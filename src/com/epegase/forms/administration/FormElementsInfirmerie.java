package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureInfirmerieAudiometrie;
import com.epegase.systeme.xml.LectureInfirmerieTuberTest;
import com.epegase.systeme.xml.LectureInfirmerieVaccin;
import com.epegase.systeme.xml.LectureInfirmerieVma;
import com.epegase.systeme.xml.LectureInfirmerieVme;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.xml.sax.SAXException;

public class FormElementsInfirmerie implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel datamodel = new ListDataModel();
   private List listElements;
   private int type;
   private String libelleType;

   public FormElementsInfirmerie() throws SAXException {
      this.datamodel = new ListDataModel();
      this.listElements = new ArrayList();
   }

   public void chargermedicalElments() {
      if (this.type == 1) {
         LectureInfirmerieVaccin var1 = new LectureInfirmerieVaccin();
         this.listElements = var1.getMesElements();
      } else if (this.type == 2) {
         LectureInfirmerieAudiometrie var2 = new LectureInfirmerieAudiometrie();
         this.listElements = var2.getMesElements();
      } else if (this.type == 3) {
         LectureInfirmerieVme var3 = new LectureInfirmerieVme();
         this.listElements = var3.getMesElements();
      } else if (this.type == 4) {
         LectureInfirmerieVma var4 = new LectureInfirmerieVma();
         this.listElements = var4.getMesElements();
      } else if (this.type == 5) {
         LectureInfirmerieTuberTest var5 = new LectureInfirmerieTuberTest();
         this.listElements = var5.getMesElements();
      }

      this.datamodel.setWrappedData(this.listElements);
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
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

   public List getListElements() {
      return this.listElements;
   }

   public void setListElements(List var1) {
      this.listElements = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getLibelleType() {
      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public int getType() {
      return this.type;
   }

   public void setType(int var1) {
      this.type = var1;
   }
}
