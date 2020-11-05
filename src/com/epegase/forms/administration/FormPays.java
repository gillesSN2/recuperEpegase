package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LecturePays;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class FormPays implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LecturePays lecturePays = new LecturePays();
   private List listePays;
   private transient DataModel dataModelPays = new ListDataModel();

   public FormPays() throws IOException {
      this.listePays = this.lecturePays.getMespays();
      this.dataModelPays.setWrappedData(this.listePays);
   }

   public DataModel getDataModelPays() {
      return this.dataModelPays;
   }

   public void setDataModelPays(DataModel var1) {
      this.dataModelPays = var1;
   }

   public LecturePays getLecturePays() {
      return this.lecturePays;
   }

   public void setLecturePays(LecturePays var1) {
      this.lecturePays = var1;
   }

   public List getListePays() {
      return this.listePays;
   }

   public void setListePays(List var1) {
      this.listePays = var1;
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
