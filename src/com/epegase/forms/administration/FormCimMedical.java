package com.epegase.forms.administration;

import com.epegase.systeme.classe.CimMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CimMedicalDao;
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

public class FormCimMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private CimMedicalDao cimMedicalDao;
   private List listCimMedical = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private CimMedical cimMedical = new CimMedical();
   private boolean showCimMedicalDetail = false;
   private Map mapCimMedicalDistinct = new HashMap();
   private List listCimMedicalDistinct = new ArrayList();
   private List listCimMedicaldetail = new ArrayList();
   private transient DataModel datamodeldetail = new ListDataModel();

   public void InstancesDaoUtilses() {
      this.cimMedicalDao = new CimMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerListCimMedical(Session var1) throws HibernateException, NamingException {
      this.mapCimMedicalDistinct.clear();
      this.listCimMedicalDistinct.clear();
      this.listCimMedical = this.cimMedicalDao.selectallCimMedical(var1);
      if (this.datamodel == null) {
         this.datamodel = new ListDataModel();
      }

      Iterator var2 = this.listCimMedical.iterator();

      while(var2.hasNext()) {
         CimMedical var3 = (CimMedical)var2.next();
         if (!this.mapCimMedicalDistinct.containsKey(var3.getCimCodeCmd())) {
            this.mapCimMedicalDistinct.put(var3.getCimCodeCmd(), var3.getCimLibCmd());
            this.listCimMedicalDistinct.add(var3);
         }
      }

      this.datamodel.setWrappedData(this.listCimMedicalDistinct);
   }

   public void initCimMedicalSelect() throws HibernateException, NamingException {
      if (this.datamodel.isRowAvailable()) {
         this.cimMedical = (CimMedical)this.datamodel.getRowData();
         this.chargerListCimMedicalDetail();
      }

      this.setShowCimMedicalDetail(true);
   }

   public void chargerListCimMedicalDetail() throws HibernateException, NamingException {
      this.listCimMedicaldetail.clear();
      this.listCimMedicaldetail = this.cimMedicalDao.selectallCimMedical(this.cimMedical.getCimCodeCmd(), (Session)null);
      if (this.datamodeldetail == null) {
         this.datamodeldetail = new ListDataModel();
      }

      this.datamodeldetail.setWrappedData(this.listCimMedicaldetail);
   }

   public CimMedical getCimMedical() {
      return this.cimMedical;
   }

   public void setCimMedical(CimMedical var1) {
      this.cimMedical = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public List getListCimMedical() {
      return this.listCimMedical;
   }

   public void setListCimMedical(List var1) {
      this.listCimMedical = var1;
   }

   public boolean isShowCimMedicalDetail() {
      return this.showCimMedicalDetail;
   }

   public void setShowCimMedicalDetail(boolean var1) {
      this.showCimMedicalDetail = var1;
   }

   public DataModel getDatamodeldetail() {
      return this.datamodeldetail;
   }

   public void setDatamodeldetail(DataModel var1) {
      this.datamodeldetail = var1;
   }

   public List getListCimMedicalDistinct() {
      return this.listCimMedicalDistinct;
   }

   public void setListCimMedicalDistinct(List var1) {
      this.listCimMedicalDistinct = var1;
   }

   public List getListCimMedicaldetail() {
      return this.listCimMedicaldetail;
   }

   public void setListCimMedicaldetail(List var1) {
      this.listCimMedicaldetail = var1;
   }

   public Map getMapCimMedicalDistinct() {
      return this.mapCimMedicalDistinct;
   }

   public void setMapCimMedicalDistinct(Map var1) {
      this.mapCimMedicalDistinct = var1;
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
