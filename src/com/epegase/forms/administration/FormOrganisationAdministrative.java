package com.epegase.forms.administration;

import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ProductionLigneDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormOrganisationAdministrative implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean existeCode = true;
   private transient DataModel dataModelSite = new ListDataModel();
   private List siteList = new ArrayList();
   private Site site = new Site();
   private SiteDao siteDao;
   private boolean showmodelPanelSite = false;
   private boolean var_site_inactif;
   private transient DataModel dataModelDepartement = new ListDataModel();
   private List departementList = new ArrayList();
   private Departement departement = new Departement();
   private DepartementDao departementDao;
   private boolean showmodelPanelDepartement = false;
   private boolean var_departement_inactif;
   private transient DataModel dataModelProductionLigne = new ListDataModel();
   private List productionLigneList = new ArrayList();
   private ProductionLigneDao productionLigneDao;
   private transient DataModel dataModelService = new ListDataModel();
   private List serviceList = new ArrayList();
   private Service service = new Service();
   private ServiceDao serviceDao;
   private boolean showmodelPanelService = false;
   private boolean var_service_inactif;
   private List mesResponsable = new ArrayList();
   private UserDao userDao;

   public void InstancesDaoUtilses() {
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.productionLigneDao = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesSites() throws HibernateException, NamingException {
      this.siteList.clear();
      this.siteList = this.siteDao.selectSite((Session)null);
      this.dataModelSite.setWrappedData(this.siteList);
      this.departementList.clear();
      this.dataModelDepartement.setWrappedData(this.departementList);
      this.serviceList.clear();
      this.dataModelService.setWrappedData(this.serviceList);
      this.mesResponsable.clear();
      this.mesResponsable.add(new SelectItem(0, ""));
      new ArrayList();
      List var1 = this.userDao.chargerLesSignataires("TOUS", (Session)null);
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            new Users();
            Users var3 = (Users)var1.get(var2);
            this.mesResponsable.add(new SelectItem(var3.getUsrid(), var3.getUsrNom() + ":" + var3.getUsrPrenom()));
         }
      }

   }

   public void ajouterSite() {
      this.site = new Site();
      this.var_site_inactif = false;
      this.existeCode = true;
      this.showmodelPanelSite = true;
   }

   public void modifierSite() {
      if (this.site != null) {
         if (this.site.getSitInactif() == 1) {
            this.var_site_inactif = true;
         } else {
            this.var_site_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelSite = true;
      }

   }

   public void selectionSite() throws HibernateException, NamingException {
      if (this.dataModelSite.isRowAvailable()) {
         this.site = (Site)this.dataModelSite.getRowData();
         this.departementList = this.departementDao.logDepartement(this.site.getSitId());
         this.dataModelDepartement.setWrappedData(this.departementList);
         this.departement = new Departement();
         this.serviceList.clear();
         this.dataModelService.setWrappedData(this.serviceList);
         this.service = new Service();
         this.productionLigneList = this.productionLigneDao.logProductionLigne(this.site.getSitId());
         this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
      }

   }

   public void supprimerSite() throws HibernateException, NamingException {
      if (this.site != null) {
         this.siteList.remove(this.site);
         this.dataModelSite.setWrappedData(this.siteList);
         this.siteDao.delete(this.site);
         this.site = new Site();
      }

   }

   public void annulerSite() {
      this.showmodelPanelSite = false;
   }

   public void validerSite() throws HibernateException, NamingException {
      if (this.var_site_inactif) {
         this.site.setSitInactif(1);
      } else {
         this.site.setSitInactif(0);
      }

      if (this.site.getSitIdResponsable() != 0L) {
         new Users();
         Users var1 = this.userDao.selectByIdUsers(this.site.getSitIdResponsable(), (Session)null);
         if (var1 != null) {
            this.site.setSitNomResponsable(var1.getUsrPatronyme());
         } else {
            this.site.setSitNomResponsable("");
         }
      } else {
         this.site.setSitNomResponsable("");
      }

      if (this.site.getSitId() == 0L) {
         this.site.setSitUserCreat(this.usersLog.getUsrid());
         this.site.setSitDateCreat(new Date());
         this.site = this.siteDao.insert(this.site);
         this.siteList.add(this.site);
         this.dataModelSite.setWrappedData(this.siteList);
         this.departementList.clear();
         this.dataModelDepartement.setWrappedData(this.departementList);
         this.departement = new Departement();
         this.serviceList.clear();
         this.dataModelService.setWrappedData(this.serviceList);
         this.service = new Service();
         this.productionLigneList.clear();
         this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
      } else {
         this.site.setSitUserModif(this.usersLog.getUsrid());
         this.site.setSitDateModif(new Date());
         this.site = this.siteDao.modif(this.site);
      }

      this.showmodelPanelSite = false;
   }

   public void verifierCodeSite() throws HibernateException, NamingException {
      this.existeCode = this.siteDao.existCode(this.site.getSitCode(), (Session)null);
   }

   public void ajouterDepartement() {
      if (this.site != null) {
         this.departement = new Departement();
         this.var_departement_inactif = false;
         this.existeCode = true;
         this.showmodelPanelDepartement = true;
      }

   }

   public void modifierDepartement() {
      if (this.departement != null) {
         if (this.departement.getDepInactif() == 1) {
            this.var_departement_inactif = true;
         } else {
            this.var_departement_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelDepartement = true;
      }

   }

   public void selectionDepartement() throws HibernateException, NamingException {
      if (this.dataModelDepartement.isRowAvailable()) {
         this.departement = (Departement)this.dataModelDepartement.getRowData();
         this.serviceList = this.serviceDao.logService(this.departement.getDepId());
         this.dataModelService.setWrappedData(this.serviceList);
         this.service = new Service();
      }

   }

   public void supprimerDepartement() throws HibernateException, NamingException {
      if (this.departement != null) {
         this.departementList.remove(this.departement);
         this.dataModelDepartement.setWrappedData(this.departementList);
         this.departementDao.delete(this.departement);
         this.departement = new Departement();
      }

   }

   public void annulerDepartement() {
      this.showmodelPanelDepartement = false;
   }

   public void validerDepartement() throws HibernateException, NamingException {
      if (this.site != null) {
         if (this.var_departement_inactif) {
            this.departement.setDepInactif(1);
         } else {
            this.departement.setDepInactif(0);
         }

         if (this.departement.getDepIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.departement.getDepIdResponsable(), (Session)null);
            if (var1 != null) {
               this.departement.setDepNomResponsable(var1.getUsrPatronyme());
            } else {
               this.departement.setDepNomResponsable("");
            }
         } else {
            this.departement.setDepNomResponsable("");
         }

         if (this.departement.getDepId() == 0L) {
            this.departement.setDepUserCreat(this.usersLog.getUsrid());
            this.departement.setDepDateCreat(new Date());
            this.departement.setSite(this.site);
            this.departement = this.departementDao.insert(this.departement);
            this.departementList.add(this.departement);
            this.dataModelDepartement.setWrappedData(this.departementList);
            this.serviceList.clear();
            this.dataModelService.setWrappedData(this.serviceList);
            this.service = new Service();
         } else {
            this.departement.setDepUserModif(this.usersLog.getUsrid());
            this.departement.setDepDateModif(new Date());
            this.departement = this.departementDao.modif(this.departement);
         }
      }

      this.showmodelPanelDepartement = false;
   }

   public void verifierCodeDepartement() throws HibernateException, NamingException {
      this.existeCode = this.departementDao.existCode(this.departement.getDepCode(), (Session)null);
      this.existeCode = false;
   }

   public void ajouterService() {
      if (this.site != null && this.departement != null) {
         this.service = new Service();
         this.var_service_inactif = false;
         this.existeCode = true;
         this.showmodelPanelService = true;
      }

   }

   public void modifierService() {
      if (this.service != null) {
         if (this.service.getSerInactif() == 1) {
            this.var_service_inactif = true;
         } else {
            this.var_service_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelService = true;
      }

   }

   public void selectionService() {
      if (this.dataModelService.isRowAvailable()) {
         this.service = (Service)this.dataModelService.getRowData();
      }

   }

   public void supprimerService() throws HibernateException, NamingException {
      if (this.service != null) {
         this.serviceList.remove(this.service);
         this.dataModelService.setWrappedData(this.serviceList);
         this.serviceDao.delete(this.service);
         this.service = new Service();
      }

   }

   public void annulerService() {
      this.showmodelPanelService = false;
   }

   public void validerService() throws HibernateException, NamingException {
      if (this.site != null && this.departement != null) {
         if (this.var_service_inactif) {
            this.service.setSerInactif(1);
         } else {
            this.service.setSerInactif(0);
         }

         if (this.service.getSerIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.service.getSerIdResponsable(), (Session)null);
            if (var1 != null) {
               this.service.setSerNomResponsable(var1.getUsrPatronyme());
            } else {
               this.service.setSerNomResponsable("");
            }
         } else {
            this.service.setSerNomResponsable("");
         }

         if (this.service.getSerId() == 0L) {
            this.service.setSerUserCreat(this.usersLog.getUsrid());
            this.service.setSerDateCreat(new Date());
            this.service.setSite(this.site);
            this.service.setDepartement(this.departement);
            this.service = this.serviceDao.insert(this.service);
            this.serviceList.add(this.service);
            this.dataModelService.setWrappedData(this.serviceList);
         } else {
            this.service.setSerUserModif(this.usersLog.getUsrid());
            this.service.setSerDateModif(new Date());
            this.service = this.serviceDao.modif(this.service);
         }
      }

      this.showmodelPanelService = false;
   }

   public void verifierCodeService() throws HibernateException, NamingException {
      this.existeCode = this.serviceDao.existCode(this.service.getSerCode(), (Session)null);
      this.existeCode = false;
   }

   public DataModel getDataModelDepartement() {
      return this.dataModelDepartement;
   }

   public void setDataModelDepartement(DataModel var1) {
      this.dataModelDepartement = var1;
   }

   public DataModel getDataModelService() {
      return this.dataModelService;
   }

   public void setDataModelService(DataModel var1) {
      this.dataModelService = var1;
   }

   public DataModel getDataModelSite() {
      return this.dataModelSite;
   }

   public void setDataModelSite(DataModel var1) {
      this.dataModelSite = var1;
   }

   public Departement getDepartement() {
      return this.departement;
   }

   public void setDepartement(Departement var1) {
      this.departement = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public Service getService() {
      return this.service;
   }

   public void setService(Service var1) {
      this.service = var1;
   }

   public boolean isShowmodelPanelDepartement() {
      return this.showmodelPanelDepartement;
   }

   public void setShowmodelPanelDepartement(boolean var1) {
      this.showmodelPanelDepartement = var1;
   }

   public boolean isVar_departement_inactif() {
      return this.var_departement_inactif;
   }

   public void setVar_departement_inactif(boolean var1) {
      this.var_departement_inactif = var1;
   }

   public boolean isVar_service_inactif() {
      return this.var_service_inactif;
   }

   public void setVar_service_inactif(boolean var1) {
      this.var_service_inactif = var1;
   }

   public boolean isShowmodelPanelService() {
      return this.showmodelPanelService;
   }

   public void setShowmodelPanelService(boolean var1) {
      this.showmodelPanelService = var1;
   }

   public boolean isShowmodelPanelSite() {
      return this.showmodelPanelSite;
   }

   public void setShowmodelPanelSite(boolean var1) {
      this.showmodelPanelSite = var1;
   }

   public Site getSite() {
      return this.site;
   }

   public void setSite(Site var1) {
      this.site = var1;
   }

   public boolean isVar_site_inactif() {
      return this.var_site_inactif;
   }

   public void setVar_site_inactif(boolean var1) {
      this.var_site_inactif = var1;
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

   public List getMesResponsable() {
      return this.mesResponsable;
   }

   public void setMesResponsable(List var1) {
      this.mesResponsable = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelProductionLigne() {
      return this.dataModelProductionLigne;
   }

   public void setDataModelProductionLigne(DataModel var1) {
      this.dataModelProductionLigne = var1;
   }
}
