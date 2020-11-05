package com.epegase.forms.administration;

import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
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

public class FormDepotAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean existCod = true;
   private boolean afficheButtSupp;
   private boolean afficheButtModif;
   private int desactiveModif;
   private boolean indpoInactif;
   private boolean showSaveAddCaiss;
   private boolean inpCodCaissRWX;
   private int inpTypCaiss;
   private String inpLibCaiss;
   private String inpCodCaiss;
   private String inpLModif;
   private ExercicesAchatsDao exercicesAchatsDao;
   private ExercicesAchats exercicesAchats;
   private boolean showPanAdd = false;
   private boolean showPanModif = false;
   private transient DataModel madatamodel = new ListDataModel();
   private DepotAchats depotAchats;
   private DepotAchatsDao depotAchatsDao;
   private List lesDepotAchats;
   private UIData dataTable;
   private long exoachIdSelect;
   private boolean moduleMedical = false;
   private boolean moduleParc = false;
   private Service service;
   private ServiceDao serviceDao;
   private List lesServices = new ArrayList();
   private transient DataModel dataModelServices = new ListDataModel();

   public void instanceDaoUtilises() {
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchatsDao = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerDepotAchat(Session var1) throws HibernateException, NamingException {
      this.lesDepotAchats = this.depotAchatsDao.selectAllDepot(var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesDepotAchats);
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         if (this.structureLog.getStrmod1().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod1().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         if (this.structureLog.getStrmod2().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod2().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         if (this.structureLog.getStrmod3().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod3().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         if (this.structureLog.getStrmod4().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod4().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         if (this.structureLog.getStrmod5().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod5().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         if (this.structureLog.getStrmod6().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod6().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         if (this.structureLog.getStrmod7().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod7().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         if (this.structureLog.getStrmod8().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod8().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty()) {
         if (this.structureLog.getStrmod9().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod9().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         if (this.structureLog.getStrmod10().equals("70000")) {
            this.moduleParc = true;
         } else if (this.structureLog.getStrmod10().equals("81500")) {
            this.moduleMedical = true;
         }
      }

      this.lesServices = this.serviceDao.selectService(var1);
      this.dataModelServices.setWrappedData(this.lesServices);
   }

   public void selectionDepot() {
      if (this.madatamodel.isRowAvailable()) {
         this.depotAchats = (DepotAchats)this.getRowData();
         this.indpoInactif = this.recupererInactifModif();
         int var1 = this.depotAchats.getDpoInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
            this.afficheButtSupp = true;
         } else {
            this.afficheButtModif = false;
            this.afficheButtSupp = false;
         }

         this.inpLModif = this.depotAchats.getDpoLibelle();
         this.indpoInactif = this.recupererInactifModif();
         new Service();

         Service var2;
         int var3;
         for(var3 = 0; var3 < this.lesServices.size(); ++var3) {
            var2 = (Service)this.lesServices.get(var3);
            var2.setSelect(false);
         }

         if (this.depotAchats.getDpoService() != null && !this.depotAchats.getDpoService().isEmpty()) {
            if (!this.depotAchats.getDpoService().contains(",")) {
               for(var3 = 0; var3 < this.lesServices.size(); ++var3) {
                  var2 = (Service)this.lesServices.get(var3);
                  if (var2.getSerCode().equals(this.depotAchats.getDpoService())) {
                     var2.setSelect(true);
                     break;
                  }
               }
            } else {
               String[] var8 = this.depotAchats.getDpoService().split(",");
               int var4 = var8.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  String var6 = var8[var5];

                  for(int var7 = 0; var7 < this.lesServices.size(); ++var7) {
                     var2 = (Service)this.lesServices.get(var7);
                     if (var2.getSerCode().equals(var6)) {
                        var2.setSelect(true);
                        break;
                     }
                  }
               }
            }

            this.dataModelServices.setWrappedData(this.lesServices);
         }
      }

   }

   public void chargerPanAdd() {
      this.depotAchats = new DepotAchats();
      this.existCod = true;
      this.showPanAdd = true;
   }

   public void chargerPanAModif() {
      this.showPanModif = true;
      this.existCod = false;
   }

   public void annule() {
      this.showPanAdd = false;
      this.showPanModif = false;
      this.afficheButtModif = false;
      this.afficheButtSupp = false;
   }

   public void deletedepot() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DepotAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.depotAchats.setDpoInactif(2);
         this.depotAchats = this.depotAchatsDao.modifDepot(this.depotAchats, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtModif = false;
      this.afficheButtSupp = false;
   }

   public ExercicesAchats recupererLastExo(Session var1) throws HibernateException, NamingException {
      return this.exercicesAchats = this.exercicesAchatsDao.recupererLastExo(var1);
   }

   public void saveDepot() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DepotAchats");
      this.recupererLastExo(var1);
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.depotAchats.getDpoId() == 0L) {
            this.depotAchats.setDpoDateCreation(new Date());
            this.depotAchats.setDpoUserCreation(this.usersLog.getUsrid());
            this.depotAchats = this.depotAchatsDao.insert(this.depotAchats, var1);
            this.lesDepotAchats.add(this.depotAchats);
            this.madatamodel.setWrappedData(this.lesDepotAchats);
         } else {
            if (this.lesServices.size() != 0) {
               String var3 = "";

               for(int var4 = 0; var4 < this.lesServices.size(); ++var4) {
                  if (((Service)this.lesServices.get(var4)).isSelect()) {
                     if (var3 != null && !var3.isEmpty()) {
                        var3 = var3 + "," + ((Service)this.lesServices.get(var4)).getSerCode();
                     } else {
                        var3 = ((Service)this.lesServices.get(var4)).getSerCode();
                     }
                  }
               }

               this.depotAchats.setDpoService(var3);
            } else {
               this.depotAchats.setDpoService("");
            }

            this.depotAchats.setDpoDateModif(new Date());
            this.depotAchats.setDpoUserModif(this.usersLog.getUsrid());
            this.depotAchats = this.depotAchatsDao.modifDepot(this.depotAchats, var1);
         }

         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showPanAdd = false;
      this.showPanModif = false;
   }

   public boolean recupererInactifModif() {
      return this.depotAchats.getDpoInactif() != 0;
   }

   public int getDesactiveModif() {
      if (!this.indpoInactif) {
         this.desactiveModif = 0;
      } else {
         this.desactiveModif = 1;
      }

      return this.desactiveModif;
   }

   public void setDesactiveModif(int var1) {
      this.desactiveModif = var1;
   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DepotAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.depotAchats = this.getDepotAchats();
         this.depotAchats.setDpoInactif(0);
         this.depotAchats = this.depotAchatsDao.modifDepot(this.depotAchats, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtModif = true;
      this.afficheButtSupp = true;
   }

   public void verifCode() throws HibernateException, NamingException {
      String var1 = this.depotAchats.getDpoCode();
      if (var1.equalsIgnoreCase("")) {
         this.existCod = true;
      } else {
         this.existCod = this.existeCode(var1);
      }

   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public UIData getDataTable() {
      return this.dataTable;
   }

   public void setDataTable(UIData var1) {
      this.dataTable = var1;
   }

   public DepotAchats getDepotAchats() {
      return this.depotAchats;
   }

   public void setDepotAchats(DepotAchats var1) {
      this.depotAchats = var1;
   }

   public List getLesDepotAchats() {
      return this.lesDepotAchats;
   }

   public void setLesDepotAchats(List var1) {
      this.lesDepotAchats = var1;
   }

   public Object getRowData() {
      return this.madatamodel.getRowData();
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public boolean isShowPanAdd() {
      return this.showPanAdd;
   }

   public void setShowPanAdd(boolean var1) {
      this.showPanAdd = var1;
   }

   public String getInpLModif() {
      return this.inpLModif;
   }

   public void setInpLModif(String var1) {
      this.inpLModif = var1;
   }

   public boolean isShowPanModif() {
      return this.showPanModif;
   }

   public void setShowPanModif(boolean var1) {
      this.showPanModif = var1;
   }

   public String getInpCodCaiss() {
      return this.inpCodCaiss;
   }

   public void setInpCodCaiss(String var1) {
      this.inpCodCaiss = var1;
   }

   public String getInpLibCaiss() {
      return this.inpLibCaiss;
   }

   public void setInpLibCaiss(String var1) {
      this.inpLibCaiss = var1;
   }

   public int getInpTypCaiss() {
      return this.inpTypCaiss;
   }

   public void setInpTypCaiss(int var1) {
      this.inpTypCaiss = var1;
   }

   public boolean isInpCodCaissRWX() {
      return this.inpCodCaissRWX;
   }

   public void setInpCodCaissRWX(boolean var1) {
      this.inpCodCaissRWX = var1;
   }

   public boolean isShowSaveAddCaiss() {
      return this.showSaveAddCaiss;
   }

   public void setShowSaveAddCaiss(boolean var1) {
      this.showSaveAddCaiss = var1;
   }

   public boolean isIndpoInactif() {
      return this.indpoInactif;
   }

   public void setIndpoInactif(boolean var1) {
      this.indpoInactif = var1;
   }

   public boolean isAfficheButtSupp() {
      return this.afficheButtSupp;
   }

   public void setAfficheButtSupp(boolean var1) {
      this.afficheButtSupp = var1;
   }

   public boolean isAfficheButtModif() {
      return this.afficheButtModif;
   }

   public void setAfficheButtModif(boolean var1) {
      this.afficheButtModif = var1;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public boolean existeCode(String var1) throws HibernateException, NamingException {
      return this.depotAchatsDao.existCode(var1, (Session)null);
   }

   public long getExoachIdSelect() {
      return this.exoachIdSelect;
   }

   public void setExoachIdSelect(long var1) {
      this.exoachIdSelect = var1;
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

   public boolean isModuleMedical() {
      return this.moduleMedical;
   }

   public void setModuleMedical(boolean var1) {
      this.moduleMedical = var1;
   }

   public boolean isModuleParc() {
      return this.moduleParc;
   }

   public void setModuleParc(boolean var1) {
      this.moduleParc = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelServices() {
      return this.dataModelServices;
   }

   public void setDataModelServices(DataModel var1) {
      this.dataModelServices = var1;
   }
}
