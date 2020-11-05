package com.epegase.forms.administration;

import com.epegase.systeme.classe.CmaMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CmaMedicalDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormCmaMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private CmaMedicalDao cmaMedicalDao;
   private List listCmaMedical = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private CmaMedical cmaMedical = new CmaMedical();
   private boolean showCmdMedicalDetail = false;

   public void InstancesDaoUtilses() {
      this.cmaMedicalDao = new CmaMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerListCmaMedical(Session var1) throws HibernateException, NamingException {
      this.listCmaMedical = this.cmaMedicalDao.selectallCmaMedical(var1);
      if (this.datamodel == null) {
         this.datamodel = new ListDataModel();
      }

      this.datamodel.setWrappedData(this.listCmaMedical);
   }

   public void initCmaMedicalSelect() {
      if (this.datamodel.isRowAvailable()) {
         this.cmaMedical = (CmaMedical)this.datamodel.getRowData();
      }

      this.chargerListCmaMedicalDetail();
   }

   public String chargerListCmaMedicalDetail() {
      return "";
   }

   public CmaMedical getCmaMedical() {
      return this.cmaMedical;
   }

   public void setCmaMedical(CmaMedical var1) {
      this.cmaMedical = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public List getListCmaMedical() {
      return this.listCmaMedical;
   }

   public void setListCmaMedical(List var1) {
      this.listCmaMedical = var1;
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
