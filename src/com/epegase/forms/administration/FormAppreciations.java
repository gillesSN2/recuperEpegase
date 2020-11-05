package com.epegase.forms.administration;

import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureAppreciations;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class FormAppreciations implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private LectureAppreciations lectureAppreciations = new LectureAppreciations();
   private List listeAppreciations;
   private transient DataModel dataModelAppreciations = new ListDataModel();
   private String pageIndex;

   public FormAppreciations() throws IOException {
      this.listeAppreciations = this.lectureAppreciations.getMesAppreciation();
      this.dataModelAppreciations.setWrappedData(this.listeAppreciations);
   }

   public DataModel getDataModelAppreciations() {
      return this.dataModelAppreciations;
   }

   public void setDataModelAppreciations(DataModel var1) {
      this.dataModelAppreciations = var1;
   }

   public LectureAppreciations getLectureAppreciations() {
      return this.lectureAppreciations;
   }

   public void setLectureAppreciations(LectureAppreciations var1) {
      this.lectureAppreciations = var1;
   }

   public List getListeAppreciations() {
      return this.listeAppreciations;
   }

   public void setListeAppreciations(List var1) {
      this.listeAppreciations = var1;
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
