package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FormulesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.FormulesVentesDao;
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

public class FormFormulesVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private FormulesVentes formulesVentes = new FormulesVentes();
   private FormulesVentesDao formulesVentesDao;
   private List formulesVentesList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private ExercicesVentes exovteSelect;

   public FormFormulesVentes() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.formulesVentesDao = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesFormulesVentes(Session var1) throws HibernateException, NamingException {
      this.formulesVentesList = this.formulesVentesDao.selectFormulesVentes(this.exovteSelect.getExevteId(), var1);
      if (this.formulesVentesList.size() > 0) {
         this.datamodel = new ListDataModel();
         this.datamodel.setWrappedData(this.formulesVentesList);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.formulesVentes.setForvteDateModif(new Date());
         this.formulesVentes.setForvteUserModif(this.usersLog.getUsrid());
         this.formulesVentes.setForvteInactif(0);
         this.formulesVentes = this.formulesVentesDao.modif(this.formulesVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.formulesVentes.setForvteDateModif(new Date());
         this.formulesVentes.setForvteUserModif(this.usersLog.getUsrid());
         this.formulesVentes.setForvteInactif(2);
         this.formulesVentes = this.formulesVentesDao.modif(this.formulesVentes, var1);
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
         this.formulesVentes = (FormulesVentes)this.datamodel.getRowData();
         int var1 = this.formulesVentes.getForvteInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void saveFormules() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.formulesVentes.getForvteId() == 0L) {
            this.formulesVentes.setExerciceventes(this.exovteSelect);
            this.formulesVentes.setForvteDateCreation(new Date());
            this.formulesVentes.setForvteUserCreation(this.usersLog.getUsrid());
            this.formulesVentes.setForvteInactif(this.getConvertionInactif());
            this.formulesVentes = this.formulesVentesDao.insert(this.formulesVentes, var1);
            this.formulesVentesList.add(this.formulesVentes);
            this.datamodel.setWrappedData(this.formulesVentesList);
         } else {
            this.formulesVentes.setForvteDateModif(new Date());
            this.formulesVentes.setForvteUserModif(this.usersLog.getUsrid());
            this.formulesVentes.setForvteInactif(this.getConvertionInactif());
            this.formulesVentes = this.formulesVentesDao.modif(this.formulesVentes, var1);
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

   public void supprimerFormulesVentes() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FormulesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.formulesVentesDao.deletFormulesVentes(this.formulesVentes.getForvteId(), var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesFormulesVentes((Session)null);
   }

   public ExercicesVentes getExovteSelect() {
      return this.exovteSelect;
   }

   public void setExovteSelect(ExercicesVentes var1) {
      this.exovteSelect = var1;
   }

   public void visibleAjt() {
      this.formulesVentes = new FormulesVentes();
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

   public FormulesVentes getFormulesVentes() {
      return this.formulesVentes;
   }

   public void setFormulesVentes(FormulesVentes var1) {
      this.formulesVentes = var1;
   }

   public List getFormulesVentesList() {
      return this.formulesVentesList;
   }

   public void setFormulesVentesList(List var1) {
      this.formulesVentesList = var1;
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
