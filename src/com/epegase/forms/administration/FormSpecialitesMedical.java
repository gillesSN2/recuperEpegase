package com.epegase.forms.administration;

import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.SpecialitesMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SpecialitesMedicalDao;
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
import org.hibernate.Transaction;

public class FormSpecialitesMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private SpecialitesMedical specialitesMedical = new SpecialitesMedical();
   private SpecialitesMedicalDao specialitesMedicalDao;
   private List specialitesMedicalList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private boolean showPanAddSpec;
   private boolean showPanModifSpec;
   private Service service;
   private boolean afficheButtSupp;
   private boolean afficheButtModif;
   private String serviceSelected;
   private ServiceDao serviceDao;
   private List listService = new ArrayList();
   private List myListServicesAff = new ArrayList();

   public void InstancesDaoUtilses() {
      this.specialitesMedicalDao = new SpecialitesMedicalDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerPanAdd() {
      this.specialitesMedical = new SpecialitesMedical();
      this.showPanAddSpec = true;
   }

   public void dechargerPanAdd() {
      this.showPanAddSpec = false;
   }

   public void chargerPanAModif() {
      if (this.specialitesMedical != null) {
         this.showPanModifSpec = true;
      }

   }

   public void dechargerPanAModif() {
      this.showPanModifSpec = false;
   }

   public void confirmer() {
      if (this.datamodel.isRowAvailable()) {
         this.specialitesMedical = (SpecialitesMedical)this.datamodel.getRowData();
         this.serviceSelected = this.specialitesMedical.getSpemedCode() + ":" + this.specialitesMedical.getSpemedNom();
         this.afficheButtModif = true;
         this.afficheButtSupp = true;
      }

   }

   public void getListSpecialitesMedical(Session var1) throws HibernateException, NamingException {
      this.specialitesMedicalList = this.specialitesMedicalDao.getListSpecialitesMedical(var1);
      this.myListServicesAff = this.serviceDao.chargerLesServices(var1);
      this.listService = this.serviceDao.chargerLesServices(var1);
      String var2 = "(";
      int var3;
      if (this.specialitesMedicalList.size() == 1) {
         for(var3 = 0; var3 < this.specialitesMedicalList.size(); ++var3) {
            if (var2.equals("(")) {
               var2 = var2 + ((SpecialitesMedical)this.specialitesMedicalList.get(var3)).getService().getSerId();
            } else {
               var2 = var2 + "," + ((SpecialitesMedical)this.specialitesMedicalList.get(var3)).getService().getSerId();
            }
         }
      } else if (this.specialitesMedicalList.size() > 1) {
         for(var3 = 0; var3 < this.specialitesMedicalList.size(); ++var3) {
            if (var2.equals("(")) {
               var2 = var2 + ((SpecialitesMedical)this.specialitesMedicalList.get(var3)).getService().getSerId();
            } else {
               var2 = var2 + "," + ((SpecialitesMedical)this.specialitesMedicalList.get(var3)).getService().getSerId();
            }
         }
      }

      var2 = var2 + ")";
      if ("()".equals(var2)) {
         this.listService = this.serviceDao.chargerLesServices(var1);
      } else {
         this.listService = this.serviceDao.selectServiceByExcludeIds(var2, var1);
      }

      if (this.datamodel == null) {
         this.datamodel = new ListDataModel();
      }

      this.datamodel.setWrappedData(this.specialitesMedicalList);
      this.setAfficheButtModif(false);
      this.setAfficheButtSupp(false);
   }

   public void saveSpecialitesMedical() throws NamingException {
      this.showPanAddSpec = false;
      if (this.serviceSelected.contains(":")) {
         String[] var1 = this.serviceSelected.split(":");
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SpecialitesMedical");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.getSpecialitesMedical().setSpemedDateCreation(new Date());
            this.getSpecialitesMedical().setSpemedDateModif((Date)null);
            this.getSpecialitesMedical().setSpemedUserCreation(this.usersLog.getUsrid());
            this.getSpecialitesMedical().setSpemedUserModif(0L);
            this.specialitesMedical.setSpemedCode(var1[0]);
            this.specialitesMedical.setSpemedNom(var1[1]);
            this.specialitesMedical.setService(this.serviceDao.chargerLeServiceCode(this.specialitesMedical.getSpemedCode(), var2));
            this.specialitesMedical = this.specialitesMedicalDao.insert(this.specialitesMedical, var2);
            this.specialitesMedicalList.add(this.specialitesMedical);
            this.datamodel.setWrappedData(this.specialitesMedicalList);
            var3.commit();
         } catch (HibernateException var8) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void modifierSpecialitesMedical() throws HibernateException, NamingException {
      this.showPanModifSpec = false;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SpecialitesMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.getSpecialitesMedical().setSpemedDateModif(new Date());
         this.getSpecialitesMedical().setSpemedUserModif(this.usersLog.getUsrid());
         this.specialitesMedical = this.specialitesMedicalDao.modif(this.getSpecialitesMedical(), var1);
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

   public void deleteSpecialitesMedical() throws HibernateException, NamingException {
      if (this.specialitesMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SpecialitesMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.specialitesMedicalDao.deleteSpecialitesMedical(this.getSpecialitesMedical(), var1);
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

   }

   public List getmyListSelectItem() {
      ArrayList var1 = new ArrayList();
      if (this.showPanModifSpec) {
         var1.add(new SelectItem(this.specialitesMedical.getSpemedCode() + ":" + this.specialitesMedical.getSpemedNom()));
      }

      for(int var2 = 0; var2 < this.listService.size(); ++var2) {
         var1.add(new SelectItem(((Service)this.listService.get(var2)).getSerCode() + ":" + ((Service)this.listService.get(var2)).getSerNomFr()));
      }

      return var1;
   }

   public List getMyListServicesAff() {
      return this.myListServicesAff;
   }

   public void setMyListServicesAff(List var1) {
      this.myListServicesAff = var1;
   }

   public List getListService() {
      return this.listService;
   }

   public void setListService(List var1) {
      this.listService = var1;
   }

   public String getServiceSelected() {
      return this.serviceSelected;
   }

   public void setServiceSelected(String var1) {
      this.serviceSelected = var1;
   }

   public boolean isAfficheButtModif() {
      return this.afficheButtModif;
   }

   public void setAfficheButtModif(boolean var1) {
      this.afficheButtModif = var1;
   }

   public boolean isAfficheButtSupp() {
      return this.afficheButtSupp;
   }

   public void setAfficheButtSupp(boolean var1) {
      this.afficheButtSupp = var1;
   }

   public Service getService() {
      return this.service;
   }

   public void setService(Service var1) {
      this.service = var1;
   }

   public boolean isShowPanAddSpec() {
      return this.showPanAddSpec;
   }

   public void setShowPanAddSpec(boolean var1) {
      this.showPanAddSpec = var1;
   }

   public boolean isShowPanModifSpec() {
      return this.showPanModifSpec;
   }

   public void setShowPanModifSpec(boolean var1) {
      this.showPanModifSpec = var1;
   }

   public SpecialitesMedical getSpecialitesMedical() {
      return this.specialitesMedical;
   }

   public void setSpecialitesMedical(SpecialitesMedical var1) {
      this.specialitesMedical = var1;
   }

   public List getSpecialitesMedicalList() {
      return this.specialitesMedicalList;
   }

   public void setSpecialitesMedicalList(List var1) {
      this.specialitesMedicalList = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
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
