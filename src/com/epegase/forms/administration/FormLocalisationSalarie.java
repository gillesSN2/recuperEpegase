package com.epegase.forms.administration;

import com.epegase.systeme.classe.LocalisationSalarie;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.LocalisationSalarieDao;
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

public class FormLocalisationSalarie implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private String pageIndex;
   private List localisationSalarieList = new ArrayList();
   private transient DataModel datamodelLocalisationSalarie = new ListDataModel();
   private LocalisationSalarie localisationSalarie;
   private LocalisationSalarieDao localisationSalarieDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;

   public FormLocalisationSalarie() {
      this.localisationSalarieList = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.localisationSalarieDao = new LocalisationSalarieDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargeLocalisationSalarie(Session var1) throws HibernateException, NamingException {
      this.localisationSalarieList.clear();
      this.localisationSalarieList = this.localisationSalarieDao.selectLocalisationSalarie(var1);
      this.datamodelLocalisationSalarie.setWrappedData(this.localisationSalarieList);
   }

   public void selectionLocalisationSalarie() {
      if (this.datamodelLocalisationSalarie.isRowAvailable()) {
         this.localisationSalarie = (LocalisationSalarie)this.datamodelLocalisationSalarie.getRowData();
         if (this.localisationSalarie.getLocsalInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void ajouterLocalisationSalarie() {
      this.localisationSalarie = new LocalisationSalarie();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
   }

   public void modifierLocalisationSalarie() {
      if (this.localisationSalarie != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.showmodelPanel = true;
      }

   }

   public void supprimerLocalisationSalarie() throws HibernateException, NamingException {
      if (this.localisationSalarie != null) {
         this.localisationSalarieList.remove(this.localisationSalarie);
         this.datamodelLocalisationSalarie.setWrappedData(this.localisationSalarieList);
         this.localisationSalarieDao.delete(this.localisationSalarie);
      }

   }

   public void annulerLocalisationSalarie() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveLocalisationSalarie() throws HibernateException, NamingException {
      if (this.var_inactif) {
         this.localisationSalarie.setLocsalInactif(1);
      } else {
         this.localisationSalarie.setLocsalInactif(0);
      }

      this.localisationSalarie.setLocsalNomFr(this.localisationSalarie.getLocsalNomFr().toUpperCase());
      if (this.localisationSalarie.getLocsalId() == 0L) {
         this.localisationSalarie.setLocsalUserCreat(this.usersLog.getUsrid());
         this.localisationSalarie.setLocsalDateCreat(new Date());
         this.localisationSalarie = this.localisationSalarieDao.insert(this.localisationSalarie);
         this.localisationSalarieList.add(this.localisationSalarie);
         this.datamodelLocalisationSalarie.setWrappedData(this.localisationSalarieList);
      } else {
         this.localisationSalarie.setLocsalUserModif(this.usersLog.getUsrid());
         this.localisationSalarie.setLocsalDateModif(new Date());
         this.localisationSalarie = this.localisationSalarieDao.modif(this.localisationSalarie);
      }

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void verifielesSaisieCodeAct() throws HibernateException, NamingException {
      this.existeCode = this.localisationSalarieDao.existCode(this.getLocalisationSalarie().getLocsalNomFr(), (Session)null);
      if (this.getLocalisationSalarie().getLocsalNomFr().equals("")) {
         this.codelibVide = false;
      } else {
         this.codelibVide = true;
      }

   }

   public void verifielesSaisieLibelleAct() {
      if (this.getLocalisationSalarie().getLocsalNomFr().equals("")) {
         this.codelibVide = false;
      } else {
         this.codelibVide = true;
      }

   }

   public boolean isCodelibVide() {
      return this.codelibVide;
   }

   public void setCodelibVide(boolean var1) {
      this.codelibVide = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public List getLocalisationSalarieList() {
      return this.localisationSalarieList;
   }

   public void setLocalisationSalarieList(List var1) {
      this.localisationSalarieList = var1;
   }

   public LocalisationSalarie getLocalisationSalarie() {
      return this.localisationSalarie;
   }

   public void setLocalisationSalarie(LocalisationSalarie var1) {
      this.localisationSalarie = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelLocalisationSalarie() {
      return this.datamodelLocalisationSalarie;
   }

   public void setDatamodelLocalisationSalarie(DataModel var1) {
      this.datamodelLocalisationSalarie = var1;
   }

   public boolean isShowmodelPanel() {
      return this.showmodelPanel;
   }

   public void setShowmodelPanel(boolean var1) {
      this.showmodelPanel = var1;
   }

   public boolean isVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(boolean var1) {
      this.var_inactif = var1;
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
