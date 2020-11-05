package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.UniteDao;
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

public class FormUnite implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean afficheButtModif;
   private boolean inactifModif;
   private int desactiveModif;
   private boolean showPanel;
   private List lesUnite;
   private transient DataModel madatamodel = new ListDataModel();
   private Unite unite;
   private UniteDao uniteDao;
   private boolean doublon = false;
   private ExercicesVentes exovteSelect;

   public void instanceDaoUtilises() {
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerUnite(Session var1) throws HibernateException, NamingException {
      this.lesUnite = this.uniteDao.selectAll(var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesUnite);
   }

   public void selectionUnite() {
      if (this.madatamodel.isRowAvailable()) {
         this.unite = (Unite)this.getRowData();
         this.inactifModif = this.recupererInactifModif();
         int var1 = this.unite.getUniInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }
      }

   }

   public void chargerPanAdd() {
      this.unite = new Unite();
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
      if (this.unite.getUniLibelle().equalsIgnoreCase("")) {
         this.setDoublon(false);
      } else {
         Unite var1 = this.uniteDao.selectUnite(this.unite.getUniLibelle(), (Session)null);
         if (var1 == null) {
            this.setDoublon(true);
         } else {
            this.setDoublon(false);
         }
      }

   }

   public void saveUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.unite.getUniId() == 0L) {
            this.unite.setUniUserCreation(this.usersLog.getUsrid());
            this.unite.setUniDateCreation(new Date());
            this.unite = this.uniteDao.insert(this.unite, var1);
            this.lesUnite.add(this.unite);
            this.madatamodel.setWrappedData(this.lesUnite);
         } else {
            this.unite.setUniUserModif(this.usersLog.getUsrid());
            this.unite.setUniDateModif(new Date());
            this.unite = this.uniteDao.modif(this.unite, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesUnite.remove(this.unite);
         this.madatamodel.setWrappedData(this.lesUnite);
         this.uniteDao.delete(this.unite, var1);
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
      return this.unite.getUniInactif() != 0;
   }

   public void reactiverUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.unite.setUniInactif(0);
         this.unite = this.uniteDao.modif(this.unite, var1);
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

   public List getLesUnite() {
      return this.lesUnite;
   }

   public void setLesUnite(List var1) {
      this.lesUnite = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
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

   public ExercicesVentes getExovteSelect() {
      return this.exovteSelect;
   }

   public void setExovteSelect(ExercicesVentes var1) {
      this.exovteSelect = var1;
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
