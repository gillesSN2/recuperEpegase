package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureCodesEmplois;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.xml.sax.SAXException;

public class FormCodesEmplois implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureCodesEmplois lectureCodesEmplois;
   private List listeCodesEmplois;
   private transient DataModel dataModel = new ListDataModel();

   public void chargerLesCodes() throws SAXException, IOException {
      this.lectureCodesEmplois = new LectureCodesEmplois();
      this.lectureCodesEmplois.setStrId(this.structureLog.getStrid());
      this.lectureCodesEmplois.setStructureLog(this.structureLog);
      this.lectureCodesEmplois.recuperePaye();
      this.listeCodesEmplois = new ArrayList();
      this.listeCodesEmplois = this.lectureCodesEmplois.getMesCodesEmplois();
      this.dataModel.setWrappedData(this.listeCodesEmplois);
   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
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

   public List getListeCodesEmplois() {
      return this.listeCodesEmplois;
   }

   public void setListeCodesEmplois(List var1) {
      this.listeCodesEmplois = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
