package com.epegase.forms.administration;

import com.epegase.systeme.classe.NgapMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.NgapMedicalDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormNgapMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private NgapMedicalDao ngapMedicalDao;
   private List listNgapMedical = new ArrayList();
   private Map mapNgapMedicalDistinct = new HashMap();
   private List listNgapMedicalDistinct = new ArrayList();
   private List listNgapMedicaldetail = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private NgapMedical ngapMedical = new NgapMedical();
   private transient DataModel datamodeldetail = new ListDataModel();
   private boolean showNgapMedicalDetail = false;

   public void InstancesDaoUtilses() {
      this.ngapMedicalDao = new NgapMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerListNgapMedical(Session var1) throws HibernateException, NamingException {
      this.mapNgapMedicalDistinct.clear();
      this.listNgapMedicalDistinct.clear();
      this.listNgapMedical = this.ngapMedicalDao.selectallNgapMedical(var1);
      if (this.datamodel == null) {
         this.datamodel = new ListDataModel();
      }

      Iterator var2 = this.listNgapMedical.iterator();

      while(var2.hasNext()) {
         NgapMedical var3 = (NgapMedical)var2.next();
         if (!this.mapNgapMedicalDistinct.containsKey(var3.getNgaFamCode())) {
            this.mapNgapMedicalDistinct.put(var3.getNgaFamCode(), var3.getNgaFamLibelleFr());
            this.listNgapMedicalDistinct.add(var3);
         }
      }

      this.datamodel.setWrappedData(this.listNgapMedicalDistinct);
   }

   public void initNgapMedicalSelect() throws HibernateException, NamingException {
      if (this.datamodel.isRowAvailable()) {
         this.ngapMedical = (NgapMedical)this.datamodel.getRowData();
      }

      this.setShowNgapMedicalDetail(true);
      this.chargerListNgapMedicalDetail();
   }

   public void chargerListNgapMedicalDetail() throws HibernateException, NamingException {
      this.listNgapMedicaldetail.clear();
      this.listNgapMedicaldetail = this.ngapMedicalDao.selectallNgapMedicalDetail(this.ngapMedical.getNgaFamCode(), (Session)null);
      if (this.datamodeldetail == null) {
         this.datamodeldetail = new ListDataModel();
      }

      this.datamodeldetail.setWrappedData(this.listNgapMedicaldetail);
   }

   public List getListNgapMedical() {
      return this.listNgapMedical;
   }

   public void setListNgapMedical(List var1) {
      this.listNgapMedical = var1;
   }

   public List getListNgapMedicaldetail() {
      return this.listNgapMedicaldetail;
   }

   public void setListNgapMedicaldetail(List var1) {
      this.listNgapMedicaldetail = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public NgapMedical getNgapMedical() {
      return this.ngapMedical;
   }

   public void setNgapMedical(NgapMedical var1) {
      this.ngapMedical = var1;
   }

   public Map getMapNgapMedicalDistinct() {
      return this.mapNgapMedicalDistinct;
   }

   public void setMapNgapMedicalDistinct(Map var1) {
      this.mapNgapMedicalDistinct = var1;
   }

   public DataModel getDatamodeldetail() {
      return this.datamodeldetail;
   }

   public void setDatamodeldetail(DataModel var1) {
      this.datamodeldetail = var1;
   }

   public List getListNgapMedicalDistinct() {
      return this.listNgapMedicalDistinct;
   }

   public void setListNgapMedicalDistinct(List var1) {
      this.listNgapMedicalDistinct = var1;
   }

   public boolean isShowNgapMedicalDetail() {
      return this.showNgapMedicalDetail;
   }

   public void setShowNgapMedicalDetail(boolean var1) {
      this.showNgapMedicalDetail = var1;
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
