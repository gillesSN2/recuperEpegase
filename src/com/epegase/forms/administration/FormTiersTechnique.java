package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TiersTechnique;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.TiersTechniqueDao;
import com.epegase.systeme.util.MD5Password;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormTiersTechnique implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean showModalPanelConfiguration = false;
   private List lesTiersTechnique = new ArrayList();
   private transient DataModel dataModelTiersTechnique = new ListDataModel();
   private TiersTechnique tiersTechnique = new TiersTechnique();
   private TiersTechniqueDao tiersTechniqueDao;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List lesTiers = new ArrayList();
   private transient DataModel dataModelTiers = new ListDataModel();
   private boolean showModalPanelTiers = false;
   private String nomTiers;
   private List mesTiersItems = new ArrayList();
   private String idTiers;
   private MD5Password mD5Password = new MD5Password();
   private String chaineAConvertir = "";
   private String chaineConvertie = "";

   public void instanceDaoUtilises() {
      this.tiersTechniqueDao = new TiersTechniqueDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerListeConfigurations() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      this.mesTiersItems = this.tiersTechniqueDao.listTechniqueItems(var1);
      this.lesTiersTechnique.clear();
      this.dataModelTiersTechnique.setWrappedData(this.lesTiersTechnique);
      this.utilInitHibernate.closeSession();
   }

   public void chargerTiers() throws HibernateException, NamingException {
      if (this.idTiers != null && !this.idTiers.isEmpty()) {
         if (this.idTiers.equals("0")) {
            this.tiers = new Tiers();
            this.lesTiersTechnique = this.tiersTechniqueDao.listTechnique((Session)null);
         } else {
            long var1 = Long.parseLong(this.idTiers);
            this.lesTiersTechnique = this.tiersTechniqueDao.listTechniqueByTiers(var1, (Session)null);
            this.tiers = this.tiersDao.selectTierD(var1);
            if (this.tiers == null) {
               this.tiers = new Tiers();
            }
         }
      } else {
         this.lesTiersTechnique.clear();
         this.tiers = new Tiers();
      }

      this.dataModelTiersTechnique.setWrappedData(this.lesTiersTechnique);
   }

   public void selectionConfiguration() {
      if (this.dataModelTiersTechnique.isRowAvailable()) {
         this.tiersTechnique = (TiersTechnique)this.dataModelTiersTechnique.getRowData();
         this.nomTiers = this.tiersTechnique.getTiers().getTieraisonsocialenom();
      }

   }

   public void ajouterConfiguration() {
      this.tiers = new Tiers();
      this.tiersTechnique = new TiersTechnique();
      this.nomTiers = "";
      this.showModalPanelConfiguration = true;
   }

   public void modifierConfiguration() {
      if (this.tiersTechnique != null) {
         this.showModalPanelConfiguration = true;
      }

   }

   public void fermerConfiguration() {
      this.showModalPanelConfiguration = false;
   }

   public void saveConfiguration() throws HibernateException, NamingException {
      if (this.tiers != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.tiersTechnique.getTietecId() == 0L) {
               this.tiersTechnique.setTietecUserCreat(this.usersLog.getUsrid());
               this.tiersTechnique.setTietecDateCreat(new Date());
               this.tiersTechnique.setTiers(this.tiers);
               this.tiersTechnique = this.tiersTechniqueDao.insert(this.tiersTechnique, var1);
               this.lesTiersTechnique.add(this.tiersTechnique);
               this.dataModelTiersTechnique.setWrappedData(this.lesTiersTechnique);
            } else {
               this.tiersTechnique.setTietecUserModif(this.usersLog.getUsrid());
               this.tiersTechnique.setTietecDateModif(new Date());
               this.tiersTechnique = this.tiersTechniqueDao.modif(this.tiersTechnique, var1);
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.mesTiersItems = this.tiersTechniqueDao.listTechniqueItems((Session)null);
      }

      this.showModalPanelConfiguration = false;
   }

   public void supprimerConfiguration() throws HibernateException, NamingException {
      if (this.tiersTechnique != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesTiersTechnique.remove(this.tiersTechnique);
            this.dataModelTiersTechnique.setWrappedData(this.lesTiersTechnique);
            this.tiersTechniqueDao.delete(this.tiersTechnique, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.mesTiersItems = this.tiersTechniqueDao.listTechniqueItems((Session)null);
         this.tiersTechnique = new TiersTechnique();
      }

   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers.clear();
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         String var1 = "(0,2,3)";
         this.lesTiers = this.tiersDao.verifTiers(this.usersLog, var1, this.nomTiers, (Session)null);
         this.showModalPanelTiers = true;
      }

      this.dataModelTiers.setWrappedData(this.lesTiers);
   }

   public void selectionligneTiers() throws JDOMException, IOException {
      if (this.dataModelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.dataModelTiers.getRowData();
      }

   }

   public void calculeTiers() throws JDOMException, IOException {
      if (this.tiers == null) {
         this.selectionligneTiers();
      }

      if (this.tiers != null) {
         this.nomTiers = this.tiers.getTieraisonsocialenom();
      } else {
         this.tiers = new Tiers();
         this.nomTiers = "";
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = new Tiers();
      this.nomTiers = "";
      this.showModalPanelTiers = false;
   }

   public void calculCodage() {
      this.chaineConvertie = "";
      if (this.chaineAConvertir != null && !this.chaineAConvertir.isEmpty()) {
         this.chaineConvertie = this.mD5Password.getEncodedPassword(this.chaineAConvertir);
      }

   }

   public DataModel getDataModelTiersTechnique() {
      return this.dataModelTiersTechnique;
   }

   public void setDataModelTiersTechnique(DataModel var1) {
      this.dataModelTiersTechnique = var1;
   }

   public boolean isShowModalPanelConfiguration() {
      return this.showModalPanelConfiguration;
   }

   public void setShowModalPanelConfiguration(boolean var1) {
      this.showModalPanelConfiguration = var1;
   }

   public TiersTechnique getTiersTechnique() {
      return this.tiersTechnique;
   }

   public void setTiersTechnique(TiersTechnique var1) {
      this.tiersTechnique = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public DataModel getDataModelTiers() {
      return this.dataModelTiers;
   }

   public void setDataModelTiers(DataModel var1) {
      this.dataModelTiers = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public String getNomTiers() {
      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public List getMesTiersItems() {
      return this.mesTiersItems;
   }

   public void setMesTiersItems(List var1) {
      this.mesTiersItems = var1;
   }

   public String getIdTiers() {
      return this.idTiers;
   }

   public void setIdTiers(String var1) {
      this.idTiers = var1;
   }

   public String getChaineAConvertir() {
      return this.chaineAConvertir;
   }

   public void setChaineAConvertir(String var1) {
      this.chaineAConvertir = var1;
   }

   public String getChaineConvertie() {
      return this.chaineConvertie;
   }

   public void setChaineConvertie(String var1) {
      this.chaineConvertie = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }
}
