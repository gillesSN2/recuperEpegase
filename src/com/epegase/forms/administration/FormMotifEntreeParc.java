package com.epegase.forms.administration;

import com.epegase.systeme.classe.MotifEntreeParc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.MotifEntreeParcDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormMotifEntreeParc implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean afficheButtModif;
   private boolean inactifModif;
   private int desactiveModif;
   private boolean showPanel;
   private List lesMotifEntree;
   private transient DataModel madatamodel = new ListDataModel();
   private MotifEntreeParc motifEntreeParc;
   private MotifEntreeParcDao motifEntreeParcDao;
   private boolean doublon = false;

   public void instanceDaoUtilises() {
      this.motifEntreeParcDao = new MotifEntreeParcDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerMotifs(Session var1) throws HibernateException, NamingException {
      this.lesMotifEntree = this.motifEntreeParcDao.selectMotifEntreeParc(var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesMotifEntree);
   }

   public void selectionUnite() {
      if (this.madatamodel.isRowAvailable()) {
         this.motifEntreeParc = (MotifEntreeParc)this.getRowData();
         this.inactifModif = this.recupererInactifModif();
         int var1 = this.motifEntreeParc.getMtpInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }
      }

   }

   public void chargerPanAdd() {
      this.motifEntreeParc = new MotifEntreeParc();
      this.showPanel = true;
      this.doublon = false;
   }

   public void chargerPanAModif() {
      this.showPanel = true;
      this.doublon = true;
   }

   public void annule() {
      this.showPanel = false;
      this.afficheButtModif = false;
   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.motifEntreeParc.getMtpCode().equalsIgnoreCase("")) {
         this.setDoublon(false);
      } else {
         MotifEntreeParc var1 = this.motifEntreeParcDao.selectUnite(this.motifEntreeParc.getMtpCode(), (Session)null);
         if (var1 == null) {
            this.setDoublon(true);
         } else {
            this.setDoublon(false);
         }
      }

   }

   public void saveUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeParc");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.motifEntreeParc.getMtpCodeType() == 0) {
            this.motifEntreeParc.setMtpType("Diagnostic");
         } else if (this.motifEntreeParc.getMtpCodeType() == 1) {
            this.motifEntreeParc.setMtpType("Maintenance");
         } else if (this.motifEntreeParc.getMtpCodeType() == 2) {
            this.motifEntreeParc.setMtpType("Réparation");
         }

         if (this.motifEntreeParc.getMtpId() == 0L) {
            this.motifEntreeParc.setMtpUserCreation(this.usersLog.getUsrid());
            this.motifEntreeParc.setMtpDateCreation(new Date());
            this.motifEntreeParc = this.motifEntreeParcDao.insert(this.motifEntreeParc, var1);
            this.lesMotifEntree.add(this.motifEntreeParc);
            this.madatamodel.setWrappedData(this.lesMotifEntree);
         } else {
            this.motifEntreeParc.setMtpUserModif(this.usersLog.getUsrid());
            this.motifEntreeParc.setMtpDateModif(new Date());
            this.motifEntreeParc = this.motifEntreeParcDao.modif(this.motifEntreeParc, var1);
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

      this.setShowPanel(false);
   }

   public void deleteUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeParc");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesMotifEntree.remove(this.motifEntreeParc);
         this.madatamodel.setWrappedData(this.lesMotifEntree);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtModif = false;
   }

   public boolean recupererInactifModif() {
      return this.motifEntreeParc.getMtpInactif() != 0;
   }

   public void reactiverUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeParc");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.motifEntreeParc.setMtpInactif(0);
         this.motifEntreeParc = this.motifEntreeParcDao.modif(this.motifEntreeParc, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtModif = true;
   }

   public boolean isInactifModif() {
      return this.inactifModif;
   }

   public void setInactifModif(boolean var1) {
      this.inactifModif = var1;
   }

   public boolean isAfficheButtModif() {
      return this.afficheButtModif;
   }

   public void setAfficheButtModif(boolean var1) {
      this.afficheButtModif = var1;
   }

   public int getDesactiveModif() {
      if (!this.inactifModif) {
         this.desactiveModif = 0;
      } else {
         this.desactiveModif = 1;
      }

      return this.desactiveModif;
   }

   public void setDesactiveModif(int var1) {
      this.desactiveModif = var1;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public Object getRowData() {
      return this.madatamodel.getRowData();
   }

   public boolean isShowPanel() {
      return this.showPanel;
   }

   public void setShowPanel(boolean var1) {
      this.showPanel = var1;
   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public MotifEntreeParc getMotifEntreeParc() {
      return this.motifEntreeParc;
   }

   public void setMotifEntreeParc(MotifEntreeParc var1) {
      this.motifEntreeParc = var1;
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

   public List getLesMotifEntree() {
      return this.lesMotifEntree;
   }

   public void setLesMotifEntree(List var1) {
      this.lesMotifEntree = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
