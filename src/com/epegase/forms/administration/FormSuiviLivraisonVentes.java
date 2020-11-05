package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.SuiviLivraisonVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.SuiviLivraisonVentesDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIData;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormSuiviLivraisonVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private SuiviLivraisonVentes suiviLivraisonVentes = new SuiviLivraisonVentes();
   private SuiviLivraisonVentesDao suiviLivraisonVentesDao;
   private List suiviLivraisonVentesList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private UIData datatable;
   private String valImp = "false";
   private int convertionInactif;
   private boolean inactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private ExercicesVentes exovteSelect;
   private boolean doublon = false;

   public FormSuiviLivraisonVentes() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.suiviLivraisonVentesDao = new SuiviLivraisonVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesSuiviLivraisonVentes(Session var1) throws HibernateException, NamingException {
      this.suiviLivraisonVentesList = this.suiviLivraisonVentesDao.selectSuiviLivraisonVentes(this.exovteSelect.getExevteId(), var1);
      if (this.suiviLivraisonVentesList.size() > 0) {
         this.datamodel = new ListDataModel();
         this.datamodel.setWrappedData(this.suiviLivraisonVentesList);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.suiviLivraisonVentes.setSuivteDateModif(new Date());
         this.suiviLivraisonVentes.setSuivteUserModif(this.usersLog.getUsrid());
         this.suiviLivraisonVentes.setSuivteInactif(0);
         this.suiviLivraisonVentes = this.suiviLivraisonVentesDao.modif(this.suiviLivraisonVentes, var1);
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

   public void remouveCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.suiviLivraisonVentes.setSuivteDateModif(new Date());
         this.suiviLivraisonVentes.setSuivteUserModif(this.usersLog.getUsrid());
         this.suiviLivraisonVentes.setSuivteInactif(2);
         this.suiviLivraisonVentes = this.suiviLivraisonVentesDao.modif(this.suiviLivraisonVentes, var1);
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

   public void visibleAjt() {
      this.suiviLivraisonVentes = new SuiviLivraisonVentes();
      this.inactif = false;
      this.doublon = false;
      this.setShowModalPanel(true);
   }

   public void visibleMod() {
      this.doublon = true;
      this.setShowModalPanel(true);
   }

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionSuivi() {
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.suiviLivraisonVentes = (SuiviLivraisonVentes)this.datamodel.getRowData();
         int var1 = this.suiviLivraisonVentes.getSuivteInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.suiviLivraisonVentes.getSuivteCode().equalsIgnoreCase("")) {
         this.setDoublon(false);
      } else {
         SuiviLivraisonVentes var1 = this.suiviLivraisonVentesDao.selectCode(this.exovteSelect.getExevteId(), this.suiviLivraisonVentes.getSuivteCode(), (Session)null);
         if (var1 == null) {
            this.setDoublon(true);
         } else {
            this.setDoublon(false);
         }
      }

   }

   public void saveSuiviLivraison() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
      this.suiviLivraisonVentes.setExerciceventes(this.suiviLivraisonVentesDao.selectActuelExo(var1));
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.suiviLivraisonVentes.getSuivteId() == 0L) {
            this.suiviLivraisonVentes.setExerciceventes(this.exovteSelect);
            this.suiviLivraisonVentes.setSuivteDateCreation(new Date());
            this.suiviLivraisonVentes.setSuivteUserCreation(this.usersLog.getUsrid());
            this.suiviLivraisonVentes.setSuivteInactif(this.getConvertionInactif());
            this.suiviLivraisonVentes = this.suiviLivraisonVentesDao.insert(this.suiviLivraisonVentes, var1);
            this.suiviLivraisonVentesList.add(this.suiviLivraisonVentes);
            this.datamodel.setWrappedData(this.suiviLivraisonVentesList);
         } else {
            this.suiviLivraisonVentes.setSuivteDateModif(new Date());
            this.suiviLivraisonVentes.setSuivteUserModif(this.usersLog.getUsrid());
            this.suiviLivraisonVentes.setSuivteInactif(this.getConvertionInactif());
            this.suiviLivraisonVentes = this.suiviLivraisonVentesDao.insert(this.suiviLivraisonVentes, var1);
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

   }

   public void supprimerSuiviLivraisonVentes() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviLivraisonVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.suiviLivraisonVentesDao.deletSuiviLivraisonVentes(this.suiviLivraisonVentes.getSuivteId(), var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesSuiviLivraisonVentes((Session)null);
   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public UIData getDatatable() {
      return this.datatable;
   }

   public void setDatatable(UIData var1) {
      this.datatable = var1;
   }

   public SuiviLivraisonVentes getSuiviLivraisonVentes() {
      return this.suiviLivraisonVentes;
   }

   public void setSuiviLivraisonVentes(SuiviLivraisonVentes var1) {
      this.suiviLivraisonVentes = var1;
   }

   public List getSuiviLivraisonVentesList() {
      return this.suiviLivraisonVentesList;
   }

   public void setSuiviLivraisonVentesList(List var1) {
      this.suiviLivraisonVentesList = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public ExercicesVentes getExovteSelect() {
      return this.exovteSelect;
   }

   public void setExovteSelect(ExercicesVentes var1) {
      this.exovteSelect = var1;
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
