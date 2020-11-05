package com.epegase.forms.administration;

import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
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
import org.jdom.JDOMException;

public class FormCaissesOperations implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesCaisse exocaiSelect;
   private CaissesOperations caissesOperations = new CaissesOperations();
   private CaissesOperationsDao caissesOperationsDao;
   private List operationsList = new ArrayList();
   private transient DataModel datamodelOperation = new ListDataModel();
   private boolean visibiliteBton = false;
   private boolean inactif = false;
   private boolean showModalPanelOperation;
   private boolean doublon = false;
   private String var_banqueDefaut;
   private boolean afficheAjDefaut = false;
   private ExercicesComptable exerciceComptable;

   public FormCaissesOperations() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.caissesOperationsDao = new CaissesOperationsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerlesCaisses(Session var1) {
      this.operationsList = this.caissesOperationsDao.selectOperation(var1);
      this.datamodelOperation.setWrappedData(this.operationsList);
      boolean var2 = false;
      Object var3 = var1.createQuery("SELECT COUNT(*) FROM CaissesOperations").uniqueResult();
      int var4 = Integer.parseInt(var3.toString());
      if (var4 > 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

   }

   public void defaultAdd() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.caissesOperationsDao.ajoutParDefaut(this.structureLog.getStrzonefiscale(), this.structureLog, this.usersLog);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
      this.chargerlesCaisses(var1);
      this.utilInitHibernate.closeSession();
      this.afficheAjDefaut = false;
   }

   public void selectionOperation() {
      this.annule();
      if (this.datamodelOperation.isRowAvailable()) {
         this.caissesOperations = (CaissesOperations)this.datamodelOperation.getRowData();
         if (this.caissesOperations.getCaiopeInactif() == 1) {
            this.inactif = true;
            this.visibiliteBton = false;
         } else {
            this.inactif = false;
            this.visibiliteBton = true;
         }
      }

   }

   public void ajouterOperation() {
      this.caissesOperations = new CaissesOperations();
      this.inactif = false;
      this.doublon = true;
      this.showModalPanelOperation = true;
   }

   public void modifierOperation() {
      if (this.caissesOperations != null) {
         this.doublon = false;
         this.showModalPanelOperation = true;
      }

   }

   public void supprimerOperation() throws HibernateException, NamingException {
      if (this.caissesOperations != null) {
         this.operationsList.remove(this.caissesOperations);
         this.datamodelOperation.setWrappedData(this.operationsList);
         this.caissesOperationsDao.delete(this.caissesOperations);
         this.visibiliteBton = false;
      }

   }

   public void reactiverOperation() throws HibernateException, NamingException {
      if (this.caissesOperations != null) {
         this.caissesOperations.setCaiopeDateModif(new Date());
         this.caissesOperations.setCaiopeUserModif(this.usersLog.getUsrid());
         this.caissesOperations.setCaiopeInactif(0);
         this.caissesOperations = this.caissesOperationsDao.modif(this.caissesOperations);
      }

   }

   public void annule() {
      this.showModalPanelOperation = false;
   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.caissesOperations.getCaiopeCode() != null && !this.caissesOperations.getCaiopeCode().isEmpty()) {
         new CaissesOperations();
         CaissesOperations var1 = this.caissesOperationsDao.selectOperation(this.caissesOperations.getCaiopeCode(), (Session)null);
         if (var1 != null) {
            this.doublon = true;
         } else {
            this.doublon = false;
         }
      } else {
         this.doublon = false;
      }

   }

   public void saveOperation() throws HibernateException, NamingException {
      if (this.inactif) {
         this.caissesOperations.setCaiopeInactif(1);
      } else {
         this.caissesOperations.setCaiopeInactif(0);
      }

      if (this.caissesOperations.getCaiopeType() == 2) {
         this.caissesOperations.setCaiopeCategorie(3);
      }

      if (this.caissesOperations.getCaiopeId() == 0L) {
         this.caissesOperations.setCaiopeDateCreat(new Date());
         this.caissesOperations.setCaiopeUserCreat(this.usersLog.getUsrid());
         this.caissesOperations = this.caissesOperationsDao.insert(this.caissesOperations);
         this.operationsList.add(this.caissesOperations);
         this.datamodelOperation.setWrappedData(this.operationsList);
      } else {
         this.caissesOperations.setCaiopeDateModif(new Date());
         this.caissesOperations.setCaiopeUserModif(this.usersLog.getUsrid());
         this.caissesOperations = this.caissesOperationsDao.modif(this.caissesOperations);
      }

      this.visibiliteBton = false;
      this.showModalPanelOperation = false;
   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
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

   public CaissesOperations getCaissesOperations() {
      return this.caissesOperations;
   }

   public void setCaissesOperations(CaissesOperations var1) {
      this.caissesOperations = var1;
   }

   public ExercicesCaisse getExocaiSelect() {
      return this.exocaiSelect;
   }

   public void setExocaiSelect(ExercicesCaisse var1) {
      this.exocaiSelect = var1;
   }

   public ExercicesComptable getExerciceComptable() {
      return this.exerciceComptable;
   }

   public void setExerciceComptable(ExercicesComptable var1) {
      this.exerciceComptable = var1;
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

   public String getVar_banqueDefaut() {
      return this.var_banqueDefaut;
   }

   public void setVar_banqueDefaut(String var1) {
      this.var_banqueDefaut = var1;
   }

   public DataModel getDatamodelOperation() {
      return this.datamodelOperation;
   }

   public void setDatamodelOperation(DataModel var1) {
      this.datamodelOperation = var1;
   }

   public boolean isShowModalPanelOperation() {
      return this.showModalPanelOperation;
   }

   public void setShowModalPanelOperation(boolean var1) {
      this.showModalPanelOperation = var1;
   }

   public List getOperationsList() {
      return this.operationsList;
   }

   public void setOperationsList(List var1) {
      this.operationsList = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }
}
