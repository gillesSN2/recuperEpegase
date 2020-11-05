package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TransitLieuVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.TransitLieuVentesDao;
import com.epegase.systeme.dao.TransitPortVentesDao;
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

public class FormTransitLieuVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private TransitLieuVentes transitLieuVentes = new TransitLieuVentes();
   private TransitLieuVentesDao transitLieuVentesDao;
   private List transitLieuVentesList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private ExercicesVentes exovteSelect;
   private List mesPortsItems = new ArrayList();

   public FormTransitLieuVentes() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.transitLieuVentesDao = new TransitLieuVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesTransitLieuVentes(Session var1) throws HibernateException, NamingException {
      this.transitLieuVentesList = this.transitLieuVentesDao.selectTransitLieuVentes(0L, var1);
      if (this.transitLieuVentesList.size() > 0) {
         this.datamodel = new ListDataModel();
         this.datamodel.setWrappedData(this.transitLieuVentesList);
      }

      TransitPortVentesDao var2 = new TransitPortVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesPortsItems = var2.chargerLesPorts(0L, var1);
   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.transitLieuVentes.setTralieDateModif(new Date());
         this.transitLieuVentes.setTralieUserModif(this.usersLog.getUsrid());
         this.transitLieuVentes.setTralieInactif(0);
         this.transitLieuVentes = this.transitLieuVentesDao.modif(this.transitLieuVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.transitLieuVentes.setTralieDateModif(new Date());
         this.transitLieuVentes.setTralieUserModif(this.usersLog.getUsrid());
         this.transitLieuVentes.setTralieInactif(2);
         this.transitLieuVentes = this.transitLieuVentesDao.modif(this.transitLieuVentes, var1);
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
         this.transitLieuVentes = (TransitLieuVentes)this.datamodel.getRowData();
         int var1 = this.transitLieuVentes.getTralieInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void saveFormules() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.transitLieuVentes.getTralieId() == 0L) {
            this.transitLieuVentes.setTralieDateCreation(new Date());
            this.transitLieuVentes.setTralieUserCreation(this.usersLog.getUsrid());
            this.transitLieuVentes.setTralieInactif(this.getConvertionInactif());
            this.transitLieuVentes = this.transitLieuVentesDao.insert(this.transitLieuVentes, var1);
            this.transitLieuVentesList.add(this.transitLieuVentes);
            this.datamodel.setWrappedData(this.transitLieuVentesList);
         } else {
            this.transitLieuVentes.setTralieDateModif(new Date());
            this.transitLieuVentes.setTralieUserModif(this.usersLog.getUsrid());
            this.transitLieuVentes.setTralieInactif(this.getConvertionInactif());
            this.transitLieuVentes = this.transitLieuVentesDao.modif(this.transitLieuVentes, var1);
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

   public void supprimerTransitLieuVentes() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.transitLieuVentesDao.deletTransitLieuVentes(this.transitLieuVentes.getTralieId(), var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesTransitLieuVentes((Session)null);
   }

   public ExercicesVentes getExovteSelect() {
      return this.exovteSelect;
   }

   public void setExovteSelect(ExercicesVentes var1) {
      this.exovteSelect = var1;
   }

   public void visibleAjt() {
      this.transitLieuVentes = new TransitLieuVentes();
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

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public TransitLieuVentes getTransitLieuVentes() {
      return this.transitLieuVentes;
   }

   public void setTransitLieuVentes(TransitLieuVentes var1) {
      this.transitLieuVentes = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public List getTransitLieuVentesList() {
      return this.transitLieuVentesList;
   }

   public void setTransitLieuVentesList(List var1) {
      this.transitLieuVentesList = var1;
   }

   public List getMesPortsItems() {
      return this.mesPortsItems;
   }

   public void setMesPortsItems(List var1) {
      this.mesPortsItems = var1;
   }
}
