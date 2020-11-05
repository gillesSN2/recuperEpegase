package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureFormesJuridiques;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class FormFormesJuridiques implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureFormesJuridiques lectureFormesJuridiques = new LectureFormesJuridiques();
   private List listeFormesJuridiques;
   private transient DataModel dataModelFormesJuridiques = new ListDataModel();

   public FormFormesJuridiques() throws IOException {
      this.listeFormesJuridiques = this.lectureFormesJuridiques.getMesFormesJuridiques();
      this.dataModelFormesJuridiques.setWrappedData(this.listeFormesJuridiques);
   }

   public DataModel getDataModelFormesJuridiques() {
      return this.dataModelFormesJuridiques;
   }

   public void setDataModelFormesJuridiques(DataModel var1) {
      this.dataModelFormesJuridiques = var1;
   }

   public LectureFormesJuridiques getLectureFormesJuridiques() {
      return this.lectureFormesJuridiques;
   }

   public void setLectureFormesJuridiques(LectureFormesJuridiques var1) {
      this.lectureFormesJuridiques = var1;
   }

   public List getListeFormesJuridiques() {
      return this.listeFormesJuridiques;
   }

   public void setListeFormesJuridiques(List var1) {
      this.listeFormesJuridiques = var1;
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
