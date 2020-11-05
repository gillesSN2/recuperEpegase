package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureTypeTiers;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class FormTypeTiers implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureTypeTiers lectureCategoriesTiers = new LectureTypeTiers();
   private List listeCategoriesTiers;
   private transient DataModel dataModelCategoriesTiers = new ListDataModel();

   public FormTypeTiers() throws IOException {
      this.listeCategoriesTiers = this.lectureCategoriesTiers.getMesTypeTiers();
      this.dataModelCategoriesTiers.setWrappedData(this.listeCategoriesTiers);
   }

   public DataModel getDataModelCategoriesTiers() {
      return this.dataModelCategoriesTiers;
   }

   public void setDataModelCategoriesTiers(DataModel var1) {
      this.dataModelCategoriesTiers = var1;
   }

   public LectureTypeTiers getLectureCategoriesTiers() {
      return this.lectureCategoriesTiers;
   }

   public void setLectureCategoriesTiers(LectureTypeTiers var1) {
      this.lectureCategoriesTiers = var1;
   }

   public List getListeCategoriesTiers() {
      return this.listeCategoriesTiers;
   }

   public void setListeCategoriesTiers(List var1) {
      this.listeCategoriesTiers = var1;
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
