package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FormulesAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.FormulesAchatsDao;
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

public class FormFormulesAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private FormulesAchats formulesAchats = new FormulesAchats();
   private FormulesAchatsDao formulesAchatsDao;
   private List formulesAchatsList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private ExercicesAchats exoachSelect;

   public FormFormulesAchats() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.formulesAchatsDao = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesFormulesAchats(Session var1) throws HibernateException, NamingException {
      this.formulesAchatsList = this.formulesAchatsDao.selectFormulesAchats(this.exoachSelect.getExeachId(), var1);
      if (this.formulesAchatsList.size() > 0) {
         this.datamodel = new ListDataModel();
         this.datamodel.setWrappedData(this.formulesAchatsList);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.formulesAchats.setForachDateModif(new Date());
         this.formulesAchats.setForachUserModif(this.usersLog.getUsrid());
         this.formulesAchats.setForachInactif(0);
         this.formulesAchats = this.formulesAchatsDao.modif(this.formulesAchats, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.formulesAchats.setForachDateModif(new Date());
         this.formulesAchats.setForachUserModif(this.usersLog.getUsrid());
         this.formulesAchats.setForachInactif(2);
         this.formulesAchats = this.formulesAchatsDao.modif(this.formulesAchats, var1);
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

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionFormule() {
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.formulesAchats = (FormulesAchats)this.datamodel.getRowData();
         int var1 = this.formulesAchats.getForachInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void saveFormules() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.formulesAchats.getForachId() == 0L) {
            this.formulesAchats.setExercicesAchats(this.exoachSelect);
            this.formulesAchats.setForachDateCreation(new Date());
            this.formulesAchats.setForachUserCreation(this.usersLog.getUsrid());
            this.formulesAchats.setForachInactif(this.getConvertionInactif());
            this.formulesAchats = this.formulesAchatsDao.insert(this.formulesAchats, var1);
            this.formulesAchatsList.add(this.formulesAchats);
            this.datamodel.setWrappedData(this.formulesAchatsList);
         } else {
            this.formulesAchats.setForachDateModif(new Date());
            this.formulesAchats.setForachUserModif(this.usersLog.getUsrid());
            this.formulesAchats.setForachInactif(this.getConvertionInactif());
            this.formulesAchats = this.formulesAchatsDao.modif(this.formulesAchats, var1);
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
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void supprimerFormulesAchats() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.formulesAchatsDao.delete(this.formulesAchats, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesFormulesAchats((Session)null);
   }

   public ExercicesAchats getExoachSelect() {
      return this.exoachSelect;
   }

   public void setExoachSelect(ExercicesAchats var1) {
      this.exoachSelect = var1;
   }

   public void visibleAjt() {
      this.formulesAchats = new FormulesAchats();
      this.inactif = false;
      this.setShowModalPanel(true);
   }

   public void visibleMod() {
      this.setShowModalPanel(true);
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

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public FormulesAchats getFormulesAchats() {
      return this.formulesAchats;
   }

   public void setFormulesAchats(FormulesAchats var1) {
      this.formulesAchats = var1;
   }

   public List getFormulesAchatsList() {
      return this.formulesAchatsList;
   }

   public void setFormulesAchatsList(List var1) {
      this.formulesAchatsList = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
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
