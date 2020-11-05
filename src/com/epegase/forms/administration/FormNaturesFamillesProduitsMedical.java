package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureMedical;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.xml.sax.SAXException;

public class FormNaturesFamillesProduitsMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureNatureMedical lectureNatureMedical = new LectureNatureMedical();
   private List listeNatureMedical;
   private transient DataModel dataModel = new ListDataModel();

   public FormNaturesFamillesProduitsMedical() throws SAXException {
      this.listeNatureMedical = this.lectureNatureMedical.getMesNatureMedical();
      this.dataModel.setWrappedData(this.listeNatureMedical);
   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
   }

   public LectureNatureMedical getLectureNatureMedical() {
      return this.lectureNatureMedical;
   }

   public void setLectureNatureMedical(LectureNatureMedical var1) {
      this.lectureNatureMedical = var1;
   }

   public List getListeNatureMedical() {
      return this.listeNatureMedical;
   }

   public void setListeNatureMedical(List var1) {
      this.listeNatureMedical = var1;
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
