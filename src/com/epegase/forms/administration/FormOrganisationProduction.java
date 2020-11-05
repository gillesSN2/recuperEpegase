package com.epegase.forms.administration;

import com.epegase.systeme.classe.ProductionAtelier;
import com.epegase.systeme.classe.ProductionLigne;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ProductionAtelierDao;
import com.epegase.systeme.dao.ProductionLigneDao;
import com.epegase.systeme.dao.SiteDao;
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

public class FormOrganisationProduction implements Serializable {
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
   private transient DataModel dataModelProductionLigne = new ListDataModel();
   private List productionLigneList = new ArrayList();
   private ProductionLigne productionLigne = new ProductionLigne();
   private ProductionLigneDao productionLigneDao;
   private boolean showmodelPanelProductionLigne = false;
   private boolean var_productionLigne_inactif;
   private List departementList = new ArrayList();
   private transient DataModel dataModelDepartementigne = new ListDataModel();
   private DepartementDao departementDao;
   private transient DataModel dataModelProductionAtelier = new ListDataModel();
   private List productionAtelierList = new ArrayList();
   private ProductionAtelier productionAtelier = new ProductionAtelier();
   private ProductionAtelierDao productionAtelierDao;
   private boolean showmodelPanelProductionAtelier = false;
   private boolean var_productionAtelier_inactif;

   public void InstancesDaoUtilses() {
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.productionAtelierDao = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
      this.productionLigneDao = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesSites() throws HibernateException, NamingException {
      this.siteList.clear();
      this.siteList = this.siteDao.selectSite((Session)null);
      this.dataModelSite.setWrappedData(this.siteList);
      this.productionLigneList.clear();
      this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
      this.productionAtelierList.clear();
      this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
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
         this.productionLigneList = this.productionLigneDao.logProductionLigne(this.site.getSitId());
         this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
         this.productionLigne = new ProductionLigne();
         this.productionAtelierList.clear();
         this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
         this.productionAtelier = new ProductionAtelier();
         this.departementList = this.departementDao.logDepartement(this.site.getSitId());
         this.dataModelDepartementigne.setWrappedData(this.departementList);
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

      if (this.site.getSitId() == 0L) {
         this.site.setSitUserCreat(this.usersLog.getUsrid());
         this.site.setSitDateCreat(new Date());
         this.site = this.siteDao.insert(this.site);
         this.siteList.add(this.site);
         this.dataModelSite.setWrappedData(this.siteList);
         this.productionLigneList.clear();
         this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
         this.productionLigne = new ProductionLigne();
         this.productionAtelierList.clear();
         this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
         this.productionAtelier = new ProductionAtelier();
         this.departementList.clear();
         this.dataModelDepartementigne.setWrappedData(this.departementList);
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

   public void ajouterProductionLigne() {
      if (this.site != null) {
         this.productionLigne = new ProductionLigne();
         this.var_productionLigne_inactif = false;
         this.existeCode = true;
         this.showmodelPanelProductionLigne = true;
      }

   }

   public void modifierProductionLigne() {
      if (this.productionLigne != null) {
         if (this.productionLigne.getLigInactif() == 1) {
            this.var_productionLigne_inactif = true;
         } else {
            this.var_productionLigne_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelProductionLigne = true;
      }

   }

   public void selectionProductionLigne() throws HibernateException, NamingException {
      if (this.dataModelProductionLigne.isRowAvailable()) {
         this.productionLigne = (ProductionLigne)this.dataModelProductionLigne.getRowData();
         this.productionAtelierList = this.productionAtelierDao.logProductionAtelier(this.productionLigne.getLigId());
         this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
         this.productionAtelier = new ProductionAtelier();
      }

   }

   public void supprimerProductionLigne() throws HibernateException, NamingException {
      if (this.productionLigne != null) {
         this.productionLigneList.remove(this.productionLigne);
         this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
         this.productionLigneDao.delete(this.productionLigne);
         this.productionLigne = new ProductionLigne();
      }

   }

   public void annulerProductionLigne() {
      this.showmodelPanelProductionLigne = false;
   }

   public void validerProductionLigne() throws HibernateException, NamingException {
      if (this.site != null) {
         if (this.var_productionLigne_inactif) {
            this.productionLigne.setLigInactif(1);
         } else {
            this.productionLigne.setLigInactif(0);
         }

         if (this.productionLigne.getLigId() == 0L) {
            this.productionLigne.setLigUserCreat(this.usersLog.getUsrid());
            this.productionLigne.setLigDateCreat(new Date());
            this.productionLigne.setSite(this.site);
            this.productionLigne = this.productionLigneDao.insert(this.productionLigne);
            this.productionLigneList.add(this.productionLigne);
            this.dataModelProductionLigne.setWrappedData(this.productionLigneList);
            this.productionAtelierList.clear();
            this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
            this.productionAtelier = new ProductionAtelier();
         } else {
            this.productionLigne.setLigUserModif(this.usersLog.getUsrid());
            this.productionLigne.setLigDateModif(new Date());
            this.productionLigne = this.productionLigneDao.modif(this.productionLigne);
         }
      }

      this.showmodelPanelProductionLigne = false;
   }

   public void verifierCodeProductionLigne() throws HibernateException, NamingException {
      this.existeCode = this.productionLigneDao.existCode(this.productionLigne.getLigCode(), (Session)null);
   }

   public void ajouterProductionAtelier() {
      if (this.site != null && this.productionLigne != null) {
         this.productionAtelier = new ProductionAtelier();
         this.var_productionAtelier_inactif = false;
         this.existeCode = true;
         this.showmodelPanelProductionAtelier = true;
      }

   }

   public void modifierProductionAtelier() {
      if (this.productionAtelier != null) {
         if (this.productionAtelier.getAteInactif() == 1) {
            this.var_productionAtelier_inactif = true;
         } else {
            this.var_productionAtelier_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelProductionAtelier = true;
      }

   }

   public void selectionProductionAtelier() {
      if (this.dataModelProductionAtelier.isRowAvailable()) {
         this.productionAtelier = (ProductionAtelier)this.dataModelProductionAtelier.getRowData();
      }

   }

   public void supprimerProductionAtelier() throws HibernateException, NamingException {
      if (this.productionAtelier != null) {
         this.productionAtelierList.remove(this.productionAtelier);
         this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
         this.productionAtelierDao.delete(this.productionAtelier);
         this.productionAtelier = new ProductionAtelier();
      }

   }

   public void annulerProductionAtelier() {
      this.showmodelPanelProductionAtelier = false;
   }

   public void validerProductionAtelier() throws HibernateException, NamingException {
      if (this.site != null && this.productionLigne != null) {
         if (this.var_productionAtelier_inactif) {
            this.productionAtelier.setAteInactif(1);
         } else {
            this.productionAtelier.setAteInactif(0);
         }

         if (this.productionAtelier.getAteId() == 0L) {
            this.productionAtelier.setAteUserCreat(this.usersLog.getUsrid());
            this.productionAtelier.setAteDateCreat(new Date());
            this.productionAtelier.setSite(this.site);
            this.productionAtelier.setProductionLigne(this.productionLigne);
            this.productionAtelier = this.productionAtelierDao.insert(this.productionAtelier);
            this.productionAtelierList.add(this.productionAtelier);
            this.dataModelProductionAtelier.setWrappedData(this.productionAtelierList);
         } else {
            this.productionAtelier.setAteUserModif(this.usersLog.getUsrid());
            this.productionAtelier.setAteDateModif(new Date());
            this.productionAtelier = this.productionAtelierDao.modif(this.productionAtelier);
         }
      }

      this.showmodelPanelProductionAtelier = false;
   }

   public void verifierCodeProductionAtelier() throws HibernateException, NamingException {
      this.existeCode = this.productionAtelierDao.existCode(this.productionAtelier.getAteCode(), (Session)null);
   }

   public DataModel getDataModelProductionLigne() {
      return this.dataModelProductionLigne;
   }

   public void setDataModelProductionLigne(DataModel var1) {
      this.dataModelProductionLigne = var1;
   }

   public DataModel getDataModelProductionAtelier() {
      return this.dataModelProductionAtelier;
   }

   public void setDataModelProductionAtelier(DataModel var1) {
      this.dataModelProductionAtelier = var1;
   }

   public DataModel getDataModelSite() {
      return this.dataModelSite;
   }

   public void setDataModelSite(DataModel var1) {
      this.dataModelSite = var1;
   }

   public ProductionLigne getProductionLigne() {
      return this.productionLigne;
   }

   public void setProductionLigne(ProductionLigne var1) {
      this.productionLigne = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public ProductionAtelier getProductionAtelier() {
      return this.productionAtelier;
   }

   public void setProductionAtelier(ProductionAtelier var1) {
      this.productionAtelier = var1;
   }

   public boolean isShowmodelPanelProductionLigne() {
      return this.showmodelPanelProductionLigne;
   }

   public void setShowmodelPanelProductionLigne(boolean var1) {
      this.showmodelPanelProductionLigne = var1;
   }

   public boolean isVar_productionLigne_inactif() {
      return this.var_productionLigne_inactif;
   }

   public void setVar_productionLigne_inactif(boolean var1) {
      this.var_productionLigne_inactif = var1;
   }

   public boolean isVar_productionAtelier_inactif() {
      return this.var_productionAtelier_inactif;
   }

   public void setVar_productionAtelier_inactif(boolean var1) {
      this.var_productionAtelier_inactif = var1;
   }

   public boolean isShowmodelPanelProductionAtelier() {
      return this.showmodelPanelProductionAtelier;
   }

   public void setShowmodelPanelProductionAtelier(boolean var1) {
      this.showmodelPanelProductionAtelier = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelDepartementigne() {
      return this.dataModelDepartementigne;
   }

   public void setDataModelDepartementigne(DataModel var1) {
      this.dataModelDepartementigne = var1;
   }
}
