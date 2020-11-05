package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureCivilites;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class FormCivilites implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureCivilites lectureCivilites = new LectureCivilites(0);
   private List listeCivilites;
   private transient DataModel dataModelCivilites = new ListDataModel();

   public FormCivilites() throws IOException {
      this.listeCivilites = this.lectureCivilites.getMesCivilites();
      this.dataModelCivilites.setWrappedData(this.listeCivilites);
   }

   public DataModel getDataModelCivilites() {
      return this.dataModelCivilites;
   }

   public void setDataModelCivilites(DataModel var1) {
      this.dataModelCivilites = var1;
   }

   public LectureCivilites getLectureCivilites() {
      return this.lectureCivilites;
   }

   public void setLectureCivilites(LectureCivilites var1) {
      this.lectureCivilites = var1;
   }

   public List getListeCivilites() {
      return this.listeCivilites;
   }

   public void setListeCivilites(List var1) {
      this.listeCivilites = var1;
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
