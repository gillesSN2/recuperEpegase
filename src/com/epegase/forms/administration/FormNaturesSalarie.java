package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureSalarie;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.xml.sax.SAXException;

public class FormNaturesSalarie implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureNatureSalarie lectureNatureSalarie = new LectureNatureSalarie();
   private List listeNatureSalarie;
   private transient DataModel dataModel = new ListDataModel();

   public FormNaturesSalarie() throws SAXException, IOException {
      this.listeNatureSalarie = this.lectureNatureSalarie.getMesNatureSalarie();
      this.dataModel.setWrappedData(this.listeNatureSalarie);
   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
   }

   public LectureNatureSalarie getLectureNatureSalarie() {
      return this.lectureNatureSalarie;
   }

   public void setLectureNatureSalarie(LectureNatureSalarie var1) {
      this.lectureNatureSalarie = var1;
   }

   public List getListeNatureSalarie() {
      return this.listeNatureSalarie;
   }

   public void setListeNatureSalarie(List var1) {
      this.listeNatureSalarie = var1;
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
