package com.epegase.forms.administration;

import com.epegase.systeme.classe.CmdMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CmdMedicalDao;
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

public class FormCmdMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private CmdMedicalDao cmdMedicalDao;
   private List listCmdMedical = new ArrayList();
   private Map mapCmdMedicalDistinct = new HashMap();
   private List listCmdMedicalDistinct = new ArrayList();
   private List listCmdMedicaldetail = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private CmdMedical cmdMedical = new CmdMedical();
   private transient DataModel datamodeldetail = new ListDataModel();
   private boolean showCmdMedicalDetail = false;

   public void InstancesDaoUtilses() {
      this.cmdMedicalDao = new CmdMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerListCmdMedical(Session var1) throws HibernateException, NamingException {
      this.mapCmdMedicalDistinct.clear();
      this.listCmdMedicalDistinct.clear();
      this.listCmdMedical = this.cmdMedicalDao.selectallCmdMedical(var1);
      if (this.datamodel == null) {
         this.datamodel = new ListDataModel();
      }

      Iterator var2 = this.listCmdMedical.iterator();

      while(var2.hasNext()) {
         CmdMedical var3 = (CmdMedical)var2.next();
         if (!this.mapCmdMedicalDistinct.containsKey(var3.getCmdFamCode())) {
            this.mapCmdMedicalDistinct.put(var3.getCmdFamCode(), var3.getCmdFamLibelleFr());
            this.listCmdMedicalDistinct.add(var3);
         }
      }

      this.datamodel.setWrappedData(this.listCmdMedicalDistinct);
   }

   public void initCmdMedicalSelect() throws HibernateException, NamingException {
      if (this.datamodel.isRowAvailable()) {
         this.cmdMedical = (CmdMedical)this.datamodel.getRowData();
      }

      this.setShowCmdMedicalDetail(true);
      this.chargerListCmdMedicalDetail();
   }

   public void chargerListCmdMedicalDetail() throws HibernateException, NamingException {
      this.listCmdMedicaldetail.clear();
      this.listCmdMedicaldetail = this.cmdMedicalDao.selectallCmdMedicalDetail(this.cmdMedical.getCmdFamCode(), (Session)null);
      if (this.datamodeldetail == null) {
         this.datamodeldetail = new ListDataModel();
      }

      this.datamodeldetail.setWrappedData(this.listCmdMedicaldetail);
   }

   public List getListCmdMedical() {
      return this.listCmdMedical;
   }

   public void setListCmdMedical(List var1) {
      this.listCmdMedical = var1;
   }

   public List getListCmdMedicaldetail() {
      return this.listCmdMedicaldetail;
   }

   public void setListCmdMedicaldetail(List var1) {
      this.listCmdMedicaldetail = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public CmdMedical getCmdMedical() {
      return this.cmdMedical;
   }

   public void setCmdMedical(CmdMedical var1) {
      this.cmdMedical = var1;
   }

   public Map getMapCmdMedicalDistinct() {
      return this.mapCmdMedicalDistinct;
   }

   public void setMapCmdMedicalDistinct(Map var1) {
      this.mapCmdMedicalDistinct = var1;
   }

   public DataModel getDatamodeldetail() {
      return this.datamodeldetail;
   }

   public void setDatamodeldetail(DataModel var1) {
      this.datamodeldetail = var1;
   }

   public List getListCmdMedicalDistinct() {
      return this.listCmdMedicalDistinct;
   }

   public void setListCmdMedicalDistinct(List var1) {
      this.listCmdMedicalDistinct = var1;
   }

   public boolean isShowCmdMedicalDetail() {
      return this.showCmdMedicalDetail;
   }

   public void setShowCmdMedicalDetail(boolean var1) {
      this.showCmdMedicalDetail = var1;
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
