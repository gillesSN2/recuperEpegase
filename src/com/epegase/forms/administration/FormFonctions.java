package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureFonctions;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class FormFonctions implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureFonctions lectureFonctions;
   private List listeFonctions;
   private transient DataModel dataModelFonctions = new ListDataModel();

   public FormFonctions(Users var1) throws IOException {
      this.lectureFonctions = new LectureFonctions(var1.getUsrCivilite());
      this.listeFonctions = this.lectureFonctions.getMesFonctions();
      this.dataModelFonctions.setWrappedData(this.listeFonctions);
   }

   public DataModel getDataModelFonctions() {
      return this.dataModelFonctions;
   }

   public void setDataModelFonctions(DataModel var1) {
      this.dataModelFonctions = var1;
   }

   public LectureFonctions getLectureFonctions() {
      return this.lectureFonctions;
   }

   public void setLectureFonctions(LectureFonctions var1) {
      this.lectureFonctions = var1;
   }

   public List getListeFonctions() {
      return this.listeFonctions;
   }

   public void setListeFonctions(List var1) {
      this.listeFonctions = var1;
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
