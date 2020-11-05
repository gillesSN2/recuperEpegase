package com.epegase.forms.administration;

import com.epegase.systeme.classe.PathologieMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.PathologieMedicalDao;
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

public class FormPathologieMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean afficheButtModif;
   private boolean inactifModif;
   private int desactiveModif;
   private boolean showPanAdd;
   private boolean showPanModif;
   private List lesPathologieMedical;
   private transient DataModel madatamodel = new ListDataModel();
   private PathologieMedical pathologieMedical;
   private PathologieMedicalDao pathologieMedicalDao;
   private long exomedIdSelect;

   public void instanceDaoUtilises() {
      this.pathologieMedicalDao = new PathologieMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerPathologieMedical(Session var1) throws HibernateException, NamingException {
      this.lesPathologieMedical = this.pathologieMedicalDao.selectPathologieMedical(this.exomedIdSelect, var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesPathologieMedical);
      int var2 = this.lesPathologieMedical.size();
   }

   public void confirmer() {
      if (this.madatamodel.isRowAvailable()) {
         this.pathologieMedical = (PathologieMedical)this.getRowData();
         this.inactifModif = this.recupererInactifModif();
         int var1 = this.pathologieMedical.getPhlInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }
      }

   }

   public void chargerPanAdd() {
      this.pathologieMedical = new PathologieMedical();
      this.showPanModif = false;
      this.showPanAdd = true;
   }

   public void chargerPanAModif() {
      this.showPanAdd = false;
      this.showPanModif = true;
   }

   public void savePathologieMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PathologieMedical");
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.pathologieMedical.setExerciceventes(var2.recupererLExoSelect(this.exomedIdSelect, var1));
      Transaction var3 = null;

      try {
         var3 = var1.beginTransaction();
         this.pathologieMedical.setPhlUserCreation(this.usersLog.getUsrid());
         this.pathologieMedical.setPhlDateCreation(new Date());
         this.pathologieMedical = this.pathologieMedicalDao.insert(this.pathologieMedical, var1);
         this.lesPathologieMedical.add(this.pathologieMedical);
         this.madatamodel.setWrappedData(this.lesPathologieMedical);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setShowPanAdd(false);
      this.setShowPanModif(false);
   }

   public void upDatePathologieMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PathologieMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.pathologieMedical.setPhlUserModif(this.usersLog.getUsrid());
         this.pathologieMedical.setPhlInactif(this.getDesactiveModif());
         this.pathologieMedical = this.pathologieMedicalDao.modif(this.pathologieMedical, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setShowPanAdd(false);
      this.setShowPanModif(false);
   }

   public void deletePathologieMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PathologieMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.pathologieMedical.setPhlInactif(2);
         this.pathologieMedical = this.pathologieMedicalDao.modif(this.pathologieMedical, var1);
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
      return this.pathologieMedical.getPhlInactif() != 0;
   }

   public void reactiverPathologieMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PathologieMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.pathologieMedical.setPhlInactif(0);
         this.pathologieMedical = this.pathologieMedicalDao.modif(this.pathologieMedical, var1);
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

   public boolean isShowPanAdd() {
      return this.showPanAdd;
   }

   public void setShowPanAdd(boolean var1) {
      this.showPanAdd = var1;
   }

   public boolean isShowPanModif() {
      return this.showPanModif;
   }

   public void setShowPanModif(boolean var1) {
      this.showPanModif = var1;
   }

   public Object getRowData() {
      return this.madatamodel.getRowData();
   }

   public List getLesPathologieMedical() {
      return this.lesPathologieMedical;
   }

   public void setLesPathologieMedical(List var1) {
      this.lesPathologieMedical = var1;
   }

   public PathologieMedical getPathologieMedical() {
      return this.pathologieMedical;
   }

   public void setPathologieMedical(PathologieMedical var1) {
      this.pathologieMedical = var1;
   }

   public long getExomedIdSelect() {
      return this.exomedIdSelect;
   }

   public void setExomedIdSelect(long var1) {
      this.exomedIdSelect = var1;
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
