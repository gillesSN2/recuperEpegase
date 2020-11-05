package com.epegase.forms.administration;

import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureDevisesDetail;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetDevisesDetail;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormDevises implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureDevises lectureDevises = new LectureDevises();
   private List listeDevises;
   private transient DataModel dataModelDevises = new ListDataModel();
   private ObjetDevises devises;
   private LectureDevisesDetail lectureDevisesDetail;
   private List listeDevisesDetail;
   private ObjetDevisesDetail devisesDetail;
   private transient DataModel dataModelDevisesDetail = new ListDataModel();
   private List listeDevisesChoisies;
   private transient DataModel dataModelDevisesChoisies = new ListDataModel();
   private DeviseDao deviseDao;
   private Devise devise;
   private boolean var_aff_ajouter = false;
   private boolean var_aff_supprimer = false;
   private boolean var_aff_modifier = false;
   private boolean showModalPanelModif = false;
   private StructureDao structureDao;

   public FormDevises() throws IOException {
      this.listeDevises = this.lectureDevises.getMesDevises();
      this.dataModelDevises.setWrappedData(this.listeDevises);
   }

   public void InstancesUtilisees() {
      this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
   }

   public void selectionDevise() throws IOException, ParseException {
      if (this.dataModelDevises.isRowAvailable()) {
         this.devises = (ObjetDevises)this.dataModelDevises.getRowData();
         this.var_aff_ajouter = false;
         if (this.devises.getCode().contentEquals(this.structureLog.getStrdevise())) {
            this.var_aff_ajouter = false;
         } else if (this.listeDevisesChoisies.size() == 0) {
            this.var_aff_ajouter = true;
         } else {
            boolean var1 = false;

            for(int var2 = 0; var2 < this.listeDevisesChoisies.size(); ++var2) {
               if (this.devises.getCode().contentEquals(((Devise)this.listeDevisesChoisies.get(var2)).getDevCode())) {
                  var1 = true;
                  break;
               }
            }

            if (var1) {
               this.var_aff_ajouter = false;
            } else {
               this.var_aff_ajouter = true;
            }
         }

         this.lectureDevisesDetail = new LectureDevisesDetail();
         this.dataModelDevisesDetail = new ListDataModel();
         this.lectureDevisesDetail = new LectureDevisesDetail();
         this.dataModelDevisesDetail.setWrappedData(this.lectureDevisesDetail.recupereDevises(this.devises.getCode()));
      }

   }

   public void listeDevisesChoisies() throws HibernateException, NamingException {
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.listeDevisesChoisies = new ArrayList();
      if (this.structureLog != null && this.structureLog.getStrdevise() != null && !this.structureLog.getStrdevise().isEmpty()) {
         Devise var1 = new Devise();
         var1.setDevCode(this.structureLog.getStrdevise());
         this.listeDevisesChoisies.add(var1);
      }

      new ArrayList();
      List var4 = this.deviseDao.chargerLesDevises((Session)null);
      if (var4.size() != 0) {
         for(int var2 = 0; var2 < var4.size(); ++var2) {
            new Devise();
            Devise var3 = (Devise)var4.get(var2);
            this.listeDevisesChoisies.add(var3);
         }
      }

      this.dataModelDevisesChoisies.setWrappedData(this.listeDevisesChoisies);
   }

   public void ajouterDevises() throws HibernateException, NamingException {
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.devise = new Devise();
      this.devise.setDevCode(this.devises.getCode());
      this.devise.setDevFormat(this.devises.getFormat());
      this.devise.setDevLibelle(this.devises.getLibelle());
      this.devise.setStructure(this.structureLog);
      this.devise = this.deviseDao.insert(this.devise);
      this.listeDevisesChoisies.add(this.devise);
      this.dataModelDevisesChoisies.setWrappedData(this.listeDevisesChoisies);
      this.var_aff_ajouter = false;
   }

   public void selectionDeviseChoisie() throws IOException, ParseException {
      if (this.dataModelDevisesChoisies.isRowAvailable()) {
         this.devise = (Devise)this.dataModelDevisesChoisies.getRowData();
         int var1 = 0;
         if (this.listeDevisesChoisies.size() != 0) {
            for(int var2 = 0; var2 < this.listeDevisesChoisies.size(); ++var2) {
               if (this.devise.getDevId() == ((Devise)this.listeDevisesChoisies.get(var2)).getDevId()) {
                  var1 = var2;
                  break;
               }
            }
         }

         if (var1 != 0) {
            this.var_aff_supprimer = true;
            this.var_aff_modifier = true;
         } else {
            this.var_aff_supprimer = false;
            this.var_aff_modifier = false;
         }
      }

   }

   public void supprimerDevises() throws HibernateException, NamingException {
      if (this.devise != null) {
         this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
         this.deviseDao.delete(this.devise);
         this.listeDevisesChoisies();
         this.var_aff_supprimer = false;
      }

   }

   public void modifierDevises() {
      if (this.devise != null) {
         this.showModalPanelModif = true;
      }

   }

   public void annulerDevises() {
      this.showModalPanelModif = false;
   }

   public void validerDevises() throws HibernateException, NamingException {
      if (this.devise != null) {
         this.devise = this.deviseDao.modif(this.devise);
      }

      this.showModalPanelModif = false;
   }

   public void majStructureSite0() throws HibernateException, NamingException {
      if (this.structureLog != null) {
         this.structureLog.setStrsitedevise(0);
         this.structureLog = this.structureDao.modStructure(this.structureLog);
      }

   }

   public void majStructureSite1() throws HibernateException, NamingException {
      if (this.structureLog != null) {
         this.structureLog.setStrsitedevise(1);
         this.structureLog = this.structureDao.modStructure(this.structureLog);
      }

   }

   public DataModel getDataModelDevises() {
      return this.dataModelDevises;
   }

   public void setDataModelDevises(DataModel var1) {
      this.dataModelDevises = var1;
   }

   public LectureDevises getLectureDevises() {
      return this.lectureDevises;
   }

   public void setLectureDevises(LectureDevises var1) {
      this.lectureDevises = var1;
   }

   public List getListeDevises() {
      return this.listeDevises;
   }

   public void setListeDevises(List var1) {
      this.listeDevises = var1;
   }

   public DataModel getDataModelDevisesDetail() {
      return this.dataModelDevisesDetail;
   }

   public void setDataModelDevisesDetail(DataModel var1) {
      this.dataModelDevisesDetail = var1;
   }

   public boolean isVar_aff_ajouter() {
      return this.var_aff_ajouter;
   }

   public void setVar_aff_ajouter(boolean var1) {
      this.var_aff_ajouter = var1;
   }

   public boolean isVar_aff_supprimer() {
      return this.var_aff_supprimer;
   }

   public void setVar_aff_supprimer(boolean var1) {
      this.var_aff_supprimer = var1;
   }

   public DataModel getDataModelDevisesChoisies() {
      return this.dataModelDevisesChoisies;
   }

   public void setDataModelDevisesChoisies(DataModel var1) {
      this.dataModelDevisesChoisies = var1;
   }

   public ObjetDevises getDevises() {
      return this.devises;
   }

   public void setDevises(ObjetDevises var1) {
      this.devises = var1;
   }

   public ObjetDevisesDetail getDevisesDetail() {
      return this.devisesDetail;
   }

   public void setDevisesDetail(ObjetDevisesDetail var1) {
      this.devisesDetail = var1;
   }

   public LectureDevisesDetail getLectureDevisesDetail() {
      return this.lectureDevisesDetail;
   }

   public void setLectureDevisesDetail(LectureDevisesDetail var1) {
      this.lectureDevisesDetail = var1;
   }

   public List getListeDevisesChoisies() {
      return this.listeDevisesChoisies;
   }

   public void setListeDevisesChoisies(List var1) {
      this.listeDevisesChoisies = var1;
   }

   public List getListeDevisesDetail() {
      return this.listeDevisesDetail;
   }

   public void setListeDevisesDetail(List var1) {
      this.listeDevisesDetail = var1;
   }

   public Devise getDevise() {
      return this.devise;
   }

   public void setDevise(Devise var1) {
      this.devise = var1;
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

   public boolean isShowModalPanelModif() {
      return this.showModalPanelModif;
   }

   public void setShowModalPanelModif(boolean var1) {
      this.showModalPanelModif = var1;
   }

   public boolean isVar_aff_modifier() {
      return this.var_aff_modifier;
   }

   public void setVar_aff_modifier(boolean var1) {
      this.var_aff_modifier = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
