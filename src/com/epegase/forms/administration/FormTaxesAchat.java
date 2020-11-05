package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormTaxesAchat implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List lesPlanComptables;
   private TaxesAchats taxesAchats = new TaxesAchats();
   private TaxesAchatsDao taxesAchatsDao;
   private List taxesAchatsList = new ArrayList();
   private long taxachIdSelect;
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean visibiliteBton = false;
   private boolean inactif = false;
   private int convertionInactif;
   private boolean showModalPanel;
   private PlanComptableDao plancomptableDao;
   private List planComptablesList = new ArrayList();
   private boolean comtabiliteActive = false;
   private PlanComptable planComptable;
   private ExercicesAchats exoachSelect;
   private boolean doublon = false;
   private List mesComptesItems;
   private int choixRacine;
   private String selecFiscalite;

   public FormTaxesAchat() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.plancomptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesTaxesAchats(Session var1) throws HibernateException, NamingException {
      this.taxesAchatsList = this.taxesAchatsDao.selectTaxesAchats(this.exoachSelect.getExeachId(), var1);
      this.datamodel = new ListDataModel();
      this.datamodel.setWrappedData(this.taxesAchatsList);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
   }

   public void recupererComptesItem(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesComptesItems = new ArrayList();
      new ExercicesComptable();
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      ExercicesComptable var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         boolean var4 = false;
         if (this.taxesAchatsList.size() != 0) {
            for(int var5 = 0; var5 < this.taxesAchatsList.size(); ++var5) {
               if (((TaxesAchats)this.taxesAchatsList.get(var5)).getTaxachTimbre() != 0) {
                  var4 = true;
               }
            }
         }

         String var6 = "(9,13,15)";
         if (var4) {
            var6 = "(9,13,15,16)";
         }

         this.mesComptesItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), var6, 0, var1);
      }

   }

   public void afficheCompte() {
      this.setComtabiliteActive(true);
   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.taxesAchats.setTaxachDateModif(new Date());
         this.taxesAchats.setTaxachUserModif(this.usersLog.getUsrid());
         this.taxesAchats.setTaxachInactif(0);
         this.taxesAchats = this.taxesAchatsDao.modif(this.taxesAchats, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void removeCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.taxesAchats.setTaxachDateModif(new Date());
         this.taxesAchats.setTaxachUserModif(this.usersLog.getUsrid());
         this.taxesAchats.setTaxachInactif(2);
         this.taxesAchats = this.taxesAchatsDao.modif(this.taxesAchats, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void visibleAjt() {
      this.taxesAchats = new TaxesAchats();
      this.inactif = false;
      this.setDoublon(false);
      this.setShowModalPanel(true);
   }

   public void visibleMod() {
      this.setDoublon(true);
      this.setShowModalPanel(true);
   }

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionTaxe() {
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.taxesAchats = (TaxesAchats)this.datamodel.getRowData();
         this.setTaxachIdSelect(this.taxesAchats.getTaxachId());
         int var1 = this.taxesAchats.getTaxachInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.taxesAchats.getTaxachCode().equalsIgnoreCase("")) {
         this.setDoublon(false);
      } else {
         TaxesAchats var1 = this.taxesAchatsDao.selectTva(this.exoachSelect.getExeachId(), this.taxesAchats.getTaxachCode(), (Session)null);
         if (var1 == null) {
            this.setDoublon(true);
         } else {
            this.setDoublon(false);
         }
      }

   }

   public void saveTaxesAchats() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesAchats");
      this.taxesAchats.setExercicesachats(this.exoachSelect);
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.taxesAchats.getTaxachId() == 0L) {
            this.taxesAchats.setExercicesachats(this.exoachSelect);
            this.taxesAchats.setTaxachDateCreation(new Date());
            this.taxesAchats.setTaxachUserCreation(this.usersLog.getUsrid());
            this.taxesAchats.setTaxachInactif(this.getConvertionInactif());
            this.taxesAchats = this.taxesAchatsDao.insert(this.taxesAchats, var1);
            this.taxesAchatsList.add(this.taxesAchats);
            this.datamodel.setWrappedData(this.taxesAchatsList);
         } else {
            this.taxesAchats.setTaxachDateModif(new Date());
            this.taxesAchats.setTaxachUserModif(this.usersLog.getUsrid());
            this.taxesAchats = this.taxesAchatsDao.modif(this.taxesAchats, var1);
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

      this.setVisibiliteBton(false);
   }

   public void supprimerTaxesAchats() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.taxesAchatsDao.delete(this.taxesAchats, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public void setLesPlanComptables(List var1) {
      this.lesPlanComptables = var1;
   }

   public boolean isComtabiliteActive() {
      return this.comtabiliteActive;
   }

   public void setComtabiliteActive(boolean var1) {
      this.comtabiliteActive = var1;
   }

   public List getPlanComptablesList() {
      return this.planComptablesList;
   }

   public void setPlanComptablesList(List var1) {
      this.planComptablesList = var1;
   }

   public int getConvertionInactif() {
      if (!this.inactif) {
         this.convertionInactif = 0;
      } else {
         this.convertionInactif = 1;
      }

      return this.convertionInactif;
   }

   public void setConvertionInactif(int var1) {
      this.convertionInactif = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public ExercicesAchats getExoachSelect() {
      return this.exoachSelect;
   }

   public void setExoachSelect(ExercicesAchats var1) {
      this.exoachSelect = var1;
   }

   public long getTaxachIdSelect() {
      return this.taxachIdSelect;
   }

   public void setTaxachIdSelect(long var1) {
      this.taxachIdSelect = var1;
   }

   public TaxesAchats getTaxesAchats() {
      return this.taxesAchats;
   }

   public void setTaxesAchats(TaxesAchats var1) {
      this.taxesAchats = var1;
   }

   public List getTaxesAchatsList() {
      return this.taxesAchatsList;
   }

   public void setTaxesAchatsList(List var1) {
      this.taxesAchatsList = var1;
   }

   public List getMesComptesItems() {
      return this.mesComptesItems;
   }

   public void setMesComptesItems(List var1) {
      this.mesComptesItems = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
