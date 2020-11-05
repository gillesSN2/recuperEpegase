package com.epegase.forms.administration;

import com.epegase.systeme.classe.FamillesParc1;
import com.epegase.systeme.classe.FamillesParc2;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.FamillesParc1Dao;
import com.epegase.systeme.dao.FamillesParc2Dao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureParc;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormFamilleParcs implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureNatureParc natureParc;
   private List lesNatureParcs;
   private transient DataModel datamodelNature;
   private ObjetCompte objetCompte;
   private FamillesParc1 famillesParc1;
   private List lesFamillesParc1;
   private transient DataModel datamodelFamille;
   private FamillesParc1Dao famillesParc1Dao;
   private boolean showModalPanelFamille = false;
   private boolean existCodeFamille = false;
   private boolean afficheBoutonFamille = false;
   private FamillesParc2 famillesParc2;
   private List lesFamillesParc2;
   private transient DataModel datamodelSousFamille;
   private FamillesParc2Dao famillesParc2Dao;
   private boolean showModalPanelSousFamille = false;
   private boolean existCodeSousFamille = false;
   private boolean afficheBoutonSousFamille = false;

   public FormFamilleParcs(String var1) {
      this.natureParc = new LectureNatureParc(var1);
      this.lesNatureParcs = new ArrayList();
      this.datamodelNature = new ListDataModel();
      this.objetCompte = new ObjetCompte();
      this.famillesParc1 = new FamillesParc1();
      this.lesFamillesParc1 = new ArrayList();
      this.datamodelFamille = new ListDataModel();
      this.famillesParc2 = new FamillesParc2();
      this.lesFamillesParc2 = new ArrayList();
      this.datamodelSousFamille = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.famillesParc1Dao = new FamillesParc1Dao(this.baseLog, this.utilInitHibernate);
      this.famillesParc2Dao = new FamillesParc2Dao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesNatures() {
      this.lesNatureParcs = this.natureParc.getMesNatureParcUtil();
      this.datamodelNature.setWrappedData(this.lesNatureParcs);
   }

   public void selectionNature() throws HibernateException, NamingException {
      this.lesFamillesParc1.clear();
      this.lesFamillesParc2.clear();
      if (this.datamodelNature.isRowAvailable()) {
         this.objetCompte = (ObjetCompte)this.datamodelNature.getRowData();
         this.lesFamillesParc1 = this.famillesParc1Dao.selectFamille(this.objetCompte.getCode(), (Session)null);
      }

      this.datamodelFamille.setWrappedData(this.lesFamillesParc1);
      this.datamodelSousFamille.setWrappedData(this.lesFamillesParc2);
      this.afficheBoutonFamille = false;
      this.afficheBoutonSousFamille = false;
   }

   public void selectionFamille() throws HibernateException, NamingException {
      this.lesFamillesParc2.clear();
      if (this.famillesParc1 != null) {
         this.famillesParc1 = (FamillesParc1)this.datamodelFamille.getRowData();
         this.lesFamillesParc2 = this.famillesParc2Dao.selectSousFamille(this.famillesParc1, (Session)null);
         this.afficheBoutonFamille = true;
      }

      this.datamodelSousFamille.setWrappedData(this.lesFamillesParc2);
      this.afficheBoutonSousFamille = false;
   }

   public boolean verifCodeFamille() throws HibernateException, NamingException {
      this.existCodeFamille = this.famillesParc1Dao.existCode(this.famillesParc1.getFamprc1Code(), (Session)null);
      return this.existCodeFamille;
   }

   public void ajouterFamille() {
      if (this.objetCompte != null) {
         this.famillesParc1 = new FamillesParc1();
         this.lesFamillesParc2.clear();
         this.datamodelSousFamille.setWrappedData(this.lesFamillesParc2);
         this.showModalPanelFamille = true;
      }

   }

   public void modifierFamille() {
      if (this.famillesParc1 != null) {
         this.showModalPanelFamille = true;
      }

   }

   public void supprimerFamille() throws HibernateException, NamingException {
      if (this.famillesParc1 != null) {
         this.lesFamillesParc1.remove(this.famillesParc1);
         this.datamodelFamille.setWrappedData(this.lesFamillesParc1);
         this.famillesParc1Dao.delete(this.famillesParc1);
         this.lesFamillesParc2.clear();
         this.datamodelSousFamille.setWrappedData(this.lesFamillesParc2);
         this.afficheBoutonFamille = false;
         this.afficheBoutonSousFamille = false;
      }

   }

   public void saveFamille() throws HibernateException, NamingException {
      this.famillesParc1.setFamprc1Nature(Integer.parseInt(this.objetCompte.getCode()));
      this.famillesParc1.setFamprc1LibNature(this.objetCompte.getNom_FR());
      if (this.famillesParc1.isEtat()) {
         this.famillesParc1.setFamprc1Inactif(1);
      } else {
         this.famillesParc1.setFamprc1Inactif(0);
      }

      if (this.famillesParc1.getFamprc1Id() == 0L) {
         this.famillesParc1.setFamprc1DateCreation(new Date());
         this.famillesParc1.setFamprc1UserCreation(this.usersLog.getUsrid());
         this.famillesParc1 = this.famillesParc1Dao.insert(this.famillesParc1);
         this.lesFamillesParc1.add(this.famillesParc1);
         this.datamodelFamille.setWrappedData(this.lesFamillesParc1);
      } else {
         this.famillesParc1.setFamprc1DateModif(new Date());
         this.famillesParc1.setFamprc1UserModif(this.usersLog.getUsrid());
         this.famillesParc1 = this.famillesParc1Dao.modif(this.famillesParc1);
      }

      this.showModalPanelFamille = false;
   }

   public void annulerFamille() {
      this.showModalPanelFamille = false;
   }

   public void selectionSousFamille() {
      if (this.datamodelSousFamille.isRowAvailable()) {
         this.famillesParc2 = (FamillesParc2)this.datamodelSousFamille.getRowData();
         this.afficheBoutonSousFamille = true;
      }

   }

   public boolean verifCodeSousFamille() throws HibernateException, NamingException {
      this.existCodeSousFamille = this.famillesParc2Dao.existCode(this.famillesParc2.getFamprc2Code(), (Session)null);
      return this.existCodeSousFamille;
   }

   public void ajouterSousFamille() {
      if (this.famillesParc1 != null) {
         this.famillesParc2 = new FamillesParc2();
         this.showModalPanelSousFamille = true;
      }

   }

   public void modifierSousFamille() {
      if (this.famillesParc2 != null) {
         this.showModalPanelSousFamille = true;
      }

   }

   public void supprimerSousFamille() throws HibernateException, NamingException {
      if (this.famillesParc2 != null) {
         this.lesFamillesParc2.remove(this.famillesParc2);
         this.datamodelSousFamille.setWrappedData(this.lesFamillesParc2);
         this.famillesParc2Dao.delete(this.famillesParc2);
         this.afficheBoutonSousFamille = false;
      }

   }

   public void saveSousFamille() throws HibernateException, NamingException {
      this.famillesParc2.setFamillesParc1(this.famillesParc1);
      if (this.famillesParc2.isEtat()) {
         this.famillesParc2.setFamprc2Inactif(1);
      } else {
         this.famillesParc2.setFamprc2Inactif(0);
      }

      if (this.famillesParc2.getFamprc2Id() == 0L) {
         this.famillesParc2.setFamprc2DateCreation(new Date());
         this.famillesParc2.setFamprc2UserCreation(this.usersLog.getUsrid());
         this.famillesParc2 = this.famillesParc2Dao.insert(this.famillesParc2);
         this.lesFamillesParc2.add(this.famillesParc2);
         this.datamodelSousFamille.setWrappedData(this.lesFamillesParc2);
      } else {
         this.famillesParc2.setFamprc2DateModif(new Date());
         this.famillesParc2.setFamprc2UserModif(this.usersLog.getUsrid());
         this.famillesParc2 = this.famillesParc2Dao.modif(this.famillesParc2);
      }

      this.showModalPanelSousFamille = false;
   }

   public void annulerSousFamille() {
      this.showModalPanelSousFamille = false;
   }

   public DataModel getDatamodelNature() {
      return this.datamodelNature;
   }

   public void setDatamodelNature(DataModel var1) {
      this.datamodelNature = var1;
   }

   public List getLesNatureParcs() {
      return this.lesNatureParcs;
   }

   public void setLesNatureParcs(List var1) {
      this.lesNatureParcs = var1;
   }

   public LectureNatureParc getNatureParc() {
      return this.natureParc;
   }

   public void setNatureParc(LectureNatureParc var1) {
      this.natureParc = var1;
   }

   public DataModel getDatamodelFamille() {
      return this.datamodelFamille;
   }

   public void setDatamodelFamille(DataModel var1) {
      this.datamodelFamille = var1;
   }

   public DataModel getDatamodelSousFamille() {
      return this.datamodelSousFamille;
   }

   public void setDatamodelSousFamille(DataModel var1) {
      this.datamodelSousFamille = var1;
   }

   public FamillesParc1 getFamillesParc1() {
      return this.famillesParc1;
   }

   public void setFamillesParc1(FamillesParc1 var1) {
      this.famillesParc1 = var1;
   }

   public FamillesParc2 getFamillesParc2() {
      return this.famillesParc2;
   }

   public void setFamillesParc2(FamillesParc2 var1) {
      this.famillesParc2 = var1;
   }

   public List getLesFamillesParc1() {
      return this.lesFamillesParc1;
   }

   public void setLesFamillesParc1(List var1) {
      this.lesFamillesParc1 = var1;
   }

   public List getLesFamillesParc2() {
      return this.lesFamillesParc2;
   }

   public void setLesFamillesParc2(List var1) {
      this.lesFamillesParc2 = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public boolean isShowModalPanelFamille() {
      return this.showModalPanelFamille;
   }

   public void setShowModalPanelFamille(boolean var1) {
      this.showModalPanelFamille = var1;
   }

   public boolean isShowModalPanelSousFamille() {
      return this.showModalPanelSousFamille;
   }

   public void setShowModalPanelSousFamille(boolean var1) {
      this.showModalPanelSousFamille = var1;
   }

   public boolean isExistCodeFamille() {
      return this.existCodeFamille;
   }

   public void setExistCodeFamille(boolean var1) {
      this.existCodeFamille = var1;
   }

   public boolean isExistCodeSousFamille() {
      return this.existCodeSousFamille;
   }

   public void setExistCodeSousFamille(boolean var1) {
      this.existCodeSousFamille = var1;
   }

   public boolean isAfficheBoutonFamille() {
      return this.afficheBoutonFamille;
   }

   public void setAfficheBoutonFamille(boolean var1) {
      this.afficheBoutonFamille = var1;
   }

   public boolean isAfficheBoutonSousFamille() {
      return this.afficheBoutonSousFamille;
   }

   public void setAfficheBoutonSousFamille(boolean var1) {
      this.afficheBoutonSousFamille = var1;
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
