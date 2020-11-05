package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureJournaux;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.xml.sax.SAXException;

public class FormNaturesJournaux implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureNatureJournaux lectureNatureJournaux = new LectureNatureJournaux();
   private List listeNatureJournaux;
   private transient DataModel dataModel = new ListDataModel();

   public FormNaturesJournaux() throws SAXException, IOException {
      this.listeNatureJournaux = this.lectureNatureJournaux.getMesNatureJournaux();
      this.dataModel.setWrappedData(this.listeNatureJournaux);
   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
   }

   public LectureNatureJournaux getLectureNatureJournaux() {
      return this.lectureNatureJournaux;
   }

   public void setLectureNatureJournaux(LectureNatureJournaux var1) {
      this.lectureNatureJournaux = var1;
   }

   public List getListeNatureJournaux() {
      return this.listeNatureJournaux;
   }

   public void setListeNatureJournaux(List var1) {
      this.listeNatureJournaux = var1;
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
