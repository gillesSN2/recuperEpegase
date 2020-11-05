package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.ProduitsMedicamment;
import com.epegase.systeme.classe.ProtocoleMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.ProduitsMedicammentDao;
import com.epegase.systeme.dao.ProtocoleMedicalDao;
import com.epegase.systeme.util.UtilInitHibernate;
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

public class FormProtocoleMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesVentes ExercicesVentes;
   private boolean var_inactif = false;
   private boolean showMoalPanel = false;
   private boolean var_unicite = false;
   private List lesProtocoleMedical = new ArrayList();
   private transient DataModel madatamodel = new ListDataModel();
   private ProtocoleMedical protocoleMedical;
   private ProtocoleMedicalDao protocoleMedicalDao;
   private List lesProtMed = new ArrayList();
   private transient DataModel dataModelProMed = new ListDataModel();
   private List lesMedicamants = new ArrayList();
   private transient DataModel dataModelMedicament = new ListDataModel();
   private ProduitsMedicamment produitsMedicamment;
   private ProduitsMedicammentDao produitsMedicammentDao;
   private ObjetTarif objetTarif;
   private boolean showModaPanelProduit = false;
   private boolean showModaPanelMedicament = false;

   public void instanceDaoUtilises() {
      this.protocoleMedicalDao = new ProtocoleMedicalDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicammentDao = new ProduitsMedicammentDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerProtocoleMedical(Session var1) throws HibernateException, NamingException {
      this.lesProtocoleMedical = this.protocoleMedicalDao.selectProtocoleMedical(this.ExercicesVentes.getExevteId(), var1);
      this.madatamodel.setWrappedData(this.lesProtocoleMedical);
      this.protocoleMedical = new ProtocoleMedical();
      this.lesMedicamants.clear();
      this.dataModelMedicament.setWrappedData(this.lesMedicamants);
      this.objetTarif = null;
   }

   public void ajouter() {
      this.protocoleMedical = new ProtocoleMedical();
      this.var_unicite = false;
      this.objetTarif = null;
      this.showMoalPanel = true;
   }

   public void modifier() {
      if (this.protocoleMedical != null) {
         this.var_unicite = true;
         this.showMoalPanel = true;
      }

   }

   public void annuleSaisie() {
      this.showMoalPanel = false;
   }

   public void selectionLigne() {
      if (this.madatamodel.isRowAvailable()) {
         this.protocoleMedical = (ProtocoleMedical)this.madatamodel.getRowData();
         if (this.protocoleMedical.getPrtInactif() == 0) {
            this.var_inactif = false;
         } else {
            this.var_inactif = true;
         }

         this.lesMedicamants.clear();
         this.dataModelMedicament.setWrappedData(this.lesMedicamants);
         this.lesProtMed.clear();
         if (this.protocoleMedical.getPrtOrdonance() != null && !this.protocoleMedical.getPrtOrdonance().isEmpty()) {
            String[] var1;
            if (!this.protocoleMedical.getPrtOrdonance().contains("#")) {
               var1 = this.protocoleMedical.getPrtOrdonance().split(":");
               this.objetTarif = new ObjetTarif();
               this.objetTarif.setCodeProduit(var1[0]);
               this.objetTarif.setNomProduit(var1[1]);
               this.objetTarif.setIdProduit(Long.parseLong(var1[2]));
               this.objetTarif.setQteProduit(Float.parseFloat(var1[3]));
               this.lesProtMed.add(this.objetTarif);
            } else {
               var1 = this.protocoleMedical.getPrtOrdonance().split("#");
               int var2 = var1.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  String[] var4 = var1[var3].split(":");
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setCodeProduit(var4[0]);
                  this.objetTarif.setNomProduit(var4[1]);
                  this.objetTarif.setIdProduit(Long.parseLong(var4[2]));
                  this.objetTarif.setQteProduit(Float.parseFloat(var4[3]));
                  this.lesProtMed.add(this.objetTarif);
               }
            }
         }

         this.dataModelProMed.setWrappedData(this.lesProtMed);
         this.objetTarif = null;
      }

   }

   public void supprimerLogique() throws HibernateException, NamingException {
      if (this.protocoleMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProtocoleMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.protocoleMedical.setPrtInactif(2);
            this.protocoleMedical = this.protocoleMedicalDao.modif(this.protocoleMedical, var1);
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

   }

   public void supprimerPhysique() throws HibernateException, NamingException {
      if (this.protocoleMedical != null) {
         this.protocoleMedicalDao.delete(this.protocoleMedical);
         this.lesProtocoleMedical.remove(this.protocoleMedical);
         this.madatamodel.setWrappedData(this.lesProtocoleMedical);
      }

   }

   public void testUnicite() throws HibernateException, NamingException {
      this.var_unicite = this.protocoleMedicalDao.testUnicite(this.protocoleMedical.getPrtCode(), this.ExercicesVentes.getExevteId(), (Session)null);
   }

   public void save() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProtocoleMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.var_inactif) {
            this.protocoleMedical.setPrtInactif(1);
         } else {
            this.protocoleMedical.setPrtInactif(0);
         }

         this.protocoleMedical.setExerciceventes(this.ExercicesVentes);
         if (this.protocoleMedical.getPrtId() == 0L) {
            this.protocoleMedical.setPrtUserCreation(this.usersLog.getUsrid());
            this.protocoleMedical.setPrtDateCreation(new Date());
            this.protocoleMedical = this.protocoleMedicalDao.insert(this.protocoleMedical, var1);
            this.lesProtocoleMedical.add(this.protocoleMedical);
            this.madatamodel.setWrappedData(this.lesProtocoleMedical);
         } else {
            this.protocoleMedical.setPrtUserModif(this.usersLog.getUsrid());
            this.protocoleMedical.setPrtDateModif(new Date());
            this.protocoleMedical = this.protocoleMedicalDao.modif(this.protocoleMedical, var1);
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

      this.showMoalPanel = false;
   }

   public void selectionLigneMedicament() {
      if (this.dataModelProMed.isRowAvailable()) {
         this.objetTarif = (ObjetTarif)this.dataModelProMed.getRowData();
      }

   }

   public void ajouterMedicament() {
      this.objetTarif = new ObjetTarif();
      this.lesMedicamants.clear();
      this.dataModelMedicament.setWrappedData(this.lesMedicamants);
      this.showModaPanelProduit = true;
   }

   public void modifierMedicament() {
      if (this.objetTarif != null) {
         this.showModaPanelProduit = true;
      }

   }

   public void supprimerMedicament() throws HibernateException, NamingException {
      if (this.objetTarif != null) {
         this.lesProtMed.remove(this.objetTarif);
         this.saveMedicament();
      }

   }

   public void saveMedicament() throws HibernateException, NamingException {
      if (this.protocoleMedical != null) {
         String var1 = "";
         if (this.lesProtMed.size() == 0) {
            this.protocoleMedical.setPrtOrdonance("");
         } else {
            int var2 = 0;

            while(true) {
               if (var2 >= this.lesProtMed.size()) {
                  this.protocoleMedical.setPrtOrdonance(var1);
                  break;
               }

               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "#" + this.objetTarif.getCodeProduit() + ":" + this.objetTarif.getNomProduit() + ":" + this.objetTarif.getIdProduit() + ":" + this.objetTarif.getQteProduit();
               } else {
                  var1 = this.objetTarif.getCodeProduit() + ":" + this.objetTarif.getNomProduit() + ":" + this.objetTarif.getIdProduit() + ":" + this.objetTarif.getQteProduit();
               }

               ++var2;
            }
         }

         this.protocoleMedical = this.protocoleMedicalDao.modif(this.protocoleMedical);
      }

      this.showModaPanelProduit = false;
   }

   public void annulerMedicament() {
      this.showModaPanelProduit = false;
   }

   public void rechercheProduit() throws HibernateException, NamingException {
      if (this.objetTarif.getCodeProduit() != null && !this.objetTarif.getCodeProduit().isEmpty()) {
         this.lesMedicamants.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         this.lesMedicamants = this.produitsMedicammentDao.rechercheMedicamments(this.objetTarif.getCodeProduit(), var1);
         this.utilInitHibernate.closeSession();
         if (this.lesMedicamants.size() != 0) {
            this.dataModelMedicament.setWrappedData(this.lesMedicamants);
            this.produitsMedicamment = new ProduitsMedicamment();
            this.showModaPanelMedicament = true;
         } else {
            this.annulerProduit();
         }
      }

   }

   public void selectionLigneProduit() {
      if (this.dataModelMedicament.isRowAvailable()) {
         this.produitsMedicamment = (ProduitsMedicamment)this.dataModelMedicament.getRowData();
      }

   }

   public void validerProduit() {
      if (this.produitsMedicamment != null) {
         this.objetTarif.setCodeProduit(this.produitsMedicamment.getPromdcCodeCip());
         this.objetTarif.setNomProduit(this.produitsMedicamment.getPromdcSpecialite());
         this.objetTarif.setIdProduit(this.produitsMedicamment.getPromdcId());
         this.lesProtMed.add(this.objetTarif);
         this.dataModelProMed.setWrappedData(this.lesProtMed);
      }

      this.showModaPanelMedicament = false;
   }

   public void annulerProduit() {
      this.objetTarif.setCodeProduit("");
      this.objetTarif.setNomProduit("");
      this.objetTarif.setIdProduit(0L);
      this.showModaPanelMedicament = false;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public boolean isShowMoalPanel() {
      return this.showMoalPanel;
   }

   public void setShowMoalPanel(boolean var1) {
      this.showMoalPanel = var1;
   }

   public boolean isVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(boolean var1) {
      this.var_inactif = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.ExercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.ExercicesVentes = var1;
   }

   public boolean isVar_unicite() {
      return this.var_unicite;
   }

   public void setVar_unicite(boolean var1) {
      this.var_unicite = var1;
   }

   public ProtocoleMedical getProtocoleMedical() {
      return this.protocoleMedical;
   }

   public void setProtocoleMedical(ProtocoleMedical var1) {
      this.protocoleMedical = var1;
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

   public List getLesProtocoleMedical() {
      return this.lesProtocoleMedical;
   }

   public void setLesProtocoleMedical(List var1) {
      this.lesProtocoleMedical = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelMedicament() {
      return this.dataModelMedicament;
   }

   public void setDataModelMedicament(DataModel var1) {
      this.dataModelMedicament = var1;
   }

   public boolean isShowModaPanelMedicament() {
      return this.showModaPanelMedicament;
   }

   public void setShowModaPanelMedicament(boolean var1) {
      this.showModaPanelMedicament = var1;
   }

   public boolean isShowModaPanelProduit() {
      return this.showModaPanelProduit;
   }

   public void setShowModaPanelProduit(boolean var1) {
      this.showModaPanelProduit = var1;
   }

   public ObjetTarif getObjetTarif() {
      return this.objetTarif;
   }

   public void setObjetTarif(ObjetTarif var1) {
      this.objetTarif = var1;
   }

   public ProduitsMedicamment getProduitsMedicamment() {
      return this.produitsMedicamment;
   }

   public void setProduitsMedicamment(ProduitsMedicamment var1) {
      this.produitsMedicamment = var1;
   }

   public DataModel getDataModelProMed() {
      return this.dataModelProMed;
   }

   public void setDataModelProMed(DataModel var1) {
      this.dataModelProMed = var1;
   }
}
