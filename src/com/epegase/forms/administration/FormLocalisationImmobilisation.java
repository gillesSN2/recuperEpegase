package com.epegase.forms.administration;

import com.epegase.systeme.classe.LocalisationImmobilisation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.LocalisationImmobilisationDao;
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

public class FormLocalisationImmobilisation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private String pageIndex;
   private List localisationImmobilisationList = new ArrayList();
   private transient DataModel datamodelLocalisationImmobilisation = new ListDataModel();
   private LocalisationImmobilisation localisationImmobilisation;
   private LocalisationImmobilisationDao localisationImmobilisationDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;

   public FormLocalisationImmobilisation() {
      this.localisationImmobilisationList = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.localisationImmobilisationDao = new LocalisationImmobilisationDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargeLocalisationImmobilisation(Session var1) throws HibernateException, NamingException {
      this.localisationImmobilisationList.clear();
      this.localisationImmobilisationList = this.localisationImmobilisationDao.selectLocalisationImmobilisation(var1);
      this.datamodelLocalisationImmobilisation.setWrappedData(this.localisationImmobilisationList);
   }

   public void selectionLocalisationImmobilisation() {
      if (this.datamodelLocalisationImmobilisation.isRowAvailable()) {
         this.localisationImmobilisation = (LocalisationImmobilisation)this.datamodelLocalisationImmobilisation.getRowData();
         if (this.localisationImmobilisation.getLocimmInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void ajouterLocalisationImmobilisation() {
      this.localisationImmobilisation = new LocalisationImmobilisation();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
   }

   public void modifierLocalisationImmobilisation() {
      if (this.localisationImmobilisation != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.showmodelPanel = true;
      }

   }

   public void supprimerLocalisationImmobilisation() throws HibernateException, NamingException {
      if (this.localisationImmobilisation != null) {
         this.localisationImmobilisationList.remove(this.localisationImmobilisation);
         this.datamodelLocalisationImmobilisation.setWrappedData(this.localisationImmobilisationList);
         this.localisationImmobilisationDao.delete(this.localisationImmobilisation);
      }

   }

   public void annulerLocalisationImmobilisation() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveLocalisationImmobilisation() throws HibernateException, NamingException {
      if (this.var_inactif) {
         this.localisationImmobilisation.setLocimmInactif(1);
      } else {
         this.localisationImmobilisation.setLocimmInactif(0);
      }

      this.localisationImmobilisation.setLocimmNomFr(this.localisationImmobilisation.getLocimmNomFr().toUpperCase());
      if (this.localisationImmobilisation.getLocimmId() == 0L) {
         this.localisationImmobilisation.setLocimmUserCreat(this.usersLog.getUsrid());
         this.localisationImmobilisation.setLocimmDateCreat(new Date());
         this.localisationImmobilisation = this.localisationImmobilisationDao.insert(this.localisationImmobilisation);
         this.localisationImmobilisationList.add(this.localisationImmobilisation);
         this.datamodelLocalisationImmobilisation.setWrappedData(this.localisationImmobilisationList);
      } else {
         this.localisationImmobilisation.setLocimmUserModif(this.usersLog.getUsrid());
         this.localisationImmobilisation.setLocimmDateModif(new Date());
         this.localisationImmobilisation = this.localisationImmobilisationDao.modif(this.localisationImmobilisation);
      }

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void verifielesSaisieCodeAct() throws HibernateException, NamingException {
      this.existeCode = this.localisationImmobilisationDao.existCode(this.getLocalisationImmobilisation().getLocimmNomFr(), (Session)null);
      if (this.getLocalisationImmobilisation().getLocimmNomFr().equals("")) {
         this.codelibVide = false;
      } else {
         this.codelibVide = true;
      }

   }

   public void verifielesSaisieLibelleAct() {
      if (this.getLocalisationImmobilisation().getLocimmNomFr().equals("")) {
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

   public List getLocalisationImmobilisationList() {
      return this.localisationImmobilisationList;
   }

   public void setLocalisationImmobilisationList(List var1) {
      this.localisationImmobilisationList = var1;
   }

   public LocalisationImmobilisation getLocalisationImmobilisation() {
      return this.localisationImmobilisation;
   }

   public void setLocalisationImmobilisation(LocalisationImmobilisation var1) {
      this.localisationImmobilisation = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelLocalisationImmobilisation() {
      return this.datamodelLocalisationImmobilisation;
   }

   public void setDatamodelLocalisationImmobilisation(DataModel var1) {
      this.datamodelLocalisationImmobilisation = var1;
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

   public LocalisationImmobilisationDao getLocalisationImmobilisationDao() {
      return this.localisationImmobilisationDao;
   }

   public void setLocalisationImmobilisationDao(LocalisationImmobilisationDao var1) {
      this.localisationImmobilisationDao = var1;
   }
}
