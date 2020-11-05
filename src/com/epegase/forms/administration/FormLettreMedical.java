package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.OptionMedical;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormLettreMedical implements Serializable {
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
   private List lesLettreMedical;
   private transient DataModel madatamodel = new ListDataModel();
   private LettreMedical LettreMedical;
   private LettreMedicalDao LettreMedicalDao;
   private long exomedIdSelect;
   private OptionMedical optionMedical;

   public void instanceDaoUtilises() {
      this.LettreMedicalDao = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLettreMedical(Session var1) throws HibernateException, NamingException {
      this.lesLettreMedical = this.LettreMedicalDao.selectActifLettre(this.exomedIdSelect, var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesLettreMedical);
      int var2 = this.lesLettreMedical.size();
      LireLesoptionsMedical var3 = new LireLesoptionsMedical();
      var3.setStrId(this.structureLog.getStrid());
      this.optionMedical = var3.lancer();
   }

   public void confirmer() {
      if (this.madatamodel.isRowAvailable()) {
         this.LettreMedical = (LettreMedical)this.getRowData();
         this.inactifModif = this.recupererInactifModif();
         int var1 = this.LettreMedical.getLetInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }
      }

   }

   public void chargerPanAdd() {
      this.LettreMedical = new LettreMedical();
      this.showPanModif = false;
      this.showPanAdd = true;
   }

   public void chargerPanAModif() {
      this.showPanAdd = false;
      this.showPanModif = true;
   }

   public void saveLettreMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LettreMedical");
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesVentes();
      ExercicesVentes var3 = var2.recupererLExoSelect(this.exomedIdSelect, var1);
      this.LettreMedical.setExerciceventes(var3);
      Transaction var4 = null;

      try {
         var4 = var1.beginTransaction();
         this.LettreMedical.setLetUserCreat(this.usersLog.getUsrid());
         this.LettreMedical.setLetDateCreat(new Date());
         this.LettreMedical.setLetUserModif(0L);
         this.LettreMedical.setLetDateModif((Date)null);
         this.LettreMedical = this.LettreMedicalDao.insert(this.LettreMedical, var1);
         this.lesLettreMedical.add(this.LettreMedical);
         this.madatamodel.setWrappedData(this.lesLettreMedical);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setShowPanAdd(false);
      this.setShowPanModif(false);
   }

   public void upDateLettreMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LettreMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.LettreMedical.setLetUserModif(this.usersLog.getUsrid());
         this.LettreMedical.setLetInactif(this.getDesactiveModif());
         this.LettreMedical = this.LettreMedicalDao.modif(this.LettreMedical, var1);
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

   public void deleteLettreMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LettreMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.LettreMedical.setLetInactif(2);
         this.LettreMedical = this.LettreMedicalDao.modif(this.LettreMedical, var1);
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
      return this.LettreMedical.getLetInactif() != 0;
   }

   public void reactiverLettreMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LettreMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.LettreMedical.setLetInactif(0);
         this.LettreMedical = this.LettreMedicalDao.modif(this.LettreMedical, var1);
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

   public List getLesLettreMedical() {
      return this.lesLettreMedical;
   }

   public void setLesLettreMedical(List var1) {
      this.lesLettreMedical = var1;
   }

   public LettreMedical getLettreMedical() {
      return this.LettreMedical;
   }

   public void setLettreMedical(LettreMedical var1) {
      this.LettreMedical = var1;
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

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }
}
