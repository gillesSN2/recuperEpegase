package com.epegase.forms.administration;

import com.epegase.systeme.classe.ClassementMediatheque;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ClassementMediathequeDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormClassementMediatheque implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private String pageIndex;
   private List ListeComplete = new ArrayList();
   private List sujetList = new ArrayList();
   private transient DataModel datamodelSujet = new ListDataModel();
   private List typeList = new ArrayList();
   private transient DataModel datamodelType = new ListDataModel();
   private List supportList = new ArrayList();
   private transient DataModel datamodelSupport = new ListDataModel();
   private List contenantList = new ArrayList();
   private transient DataModel datamodelContenant = new ListDataModel();
   private ClassementMediatheque classementMediatheque;
   private ClassementMediathequeDao classementMediathequeDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;
   private int ongletSelectionne = 0;
   private String libelleOnglet;

   public void InstancesDaoUtilses() {
      this.classementMediathequeDao = new ClassementMediathequeDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesClassementMediatheque(Session var1) throws HibernateException, NamingException {
      this.setLien(this.lien);
      this.sujetList.clear();
      this.typeList.clear();
      this.supportList.clear();
      this.contenantList.clear();
      this.ListeComplete.clear();
      this.ListeComplete = this.classementMediathequeDao.selectClassementMediatheque(var1);
      if (this.ListeComplete.size() != 0) {
         for(int var2 = 0; var2 < this.ListeComplete.size(); ++var2) {
            this.classementMediatheque = (ClassementMediatheque)this.ListeComplete.get(var2);
            if (this.classementMediatheque.getClamedType() == 0) {
               this.sujetList.add(this.classementMediatheque);
            } else if (this.classementMediatheque.getClamedType() == 1) {
               this.typeList.add(this.classementMediatheque);
            } else if (this.classementMediatheque.getClamedType() == 2) {
               this.supportList.add(this.classementMediatheque);
            } else if (this.classementMediatheque.getClamedType() == 3) {
               this.contenantList.add(this.classementMediatheque);
            }
         }
      }

      this.datamodelSujet.setWrappedData(this.sujetList);
      this.datamodelType.setWrappedData(this.typeList);
      this.datamodelSupport.setWrappedData(this.supportList);
      this.datamodelContenant.setWrappedData(this.contenantList);
   }

   public void sujetSelectionne() {
      this.ongletSelectionne = 0;
      this.libelleOnglet = "SUJET";
   }

   public void typeSelectionne() {
      this.ongletSelectionne = 1;
      this.libelleOnglet = "TYPE";
   }

   public void supportSelectionne() {
      this.ongletSelectionne = 2;
      this.libelleOnglet = "SUPPORT";
   }

   public void contenantSelectionne() {
      this.ongletSelectionne = 3;
      this.libelleOnglet = "CONTENANT";
   }

   public void selectionSujet() {
      if (this.datamodelSujet.isRowAvailable()) {
         this.classementMediatheque = (ClassementMediatheque)this.datamodelSujet.getRowData();
         if (this.classementMediatheque.getClamedInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void selectionType() {
      if (this.datamodelType.isRowAvailable()) {
         this.classementMediatheque = (ClassementMediatheque)this.datamodelType.getRowData();
         if (this.classementMediatheque.getClamedInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void selectionSupport() {
      if (this.datamodelSupport.isRowAvailable()) {
         this.classementMediatheque = (ClassementMediatheque)this.datamodelSupport.getRowData();
         if (this.classementMediatheque.getClamedInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void selectionContenant() {
      if (this.datamodelContenant.isRowAvailable()) {
         this.classementMediatheque = (ClassementMediatheque)this.datamodelContenant.getRowData();
         if (this.classementMediatheque.getClamedInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void ajouterClassement() {
      this.classementMediatheque = new ClassementMediatheque();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
   }

   public void modifierClassement() throws NamingException {
      if (this.classementMediatheque != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.showmodelPanel = true;
      }

   }

   public void supprimerClassement() throws HibernateException, NamingException {
      if (this.classementMediatheque != null) {
         if (this.classementMediatheque.getClamedType() == 0) {
            this.sujetList.remove(this.classementMediatheque);
            this.datamodelSujet.setWrappedData(this.sujetList);
         } else if (this.classementMediatheque.getClamedType() == 1) {
            this.typeList.remove(this.classementMediatheque);
            this.datamodelType.setWrappedData(this.typeList);
         } else if (this.classementMediatheque.getClamedType() == 2) {
            this.supportList.remove(this.classementMediatheque);
            this.datamodelSupport.setWrappedData(this.supportList);
         } else if (this.classementMediatheque.getClamedType() == 3) {
            this.contenantList.remove(this.classementMediatheque);
            this.datamodelContenant.setWrappedData(this.contenantList);
         }

         this.classementMediathequeDao.delete(this.classementMediatheque);
      }

   }

   public void annulerClassement() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveClassement() throws HibernateException, NamingException {
      if (this.var_inactif) {
         this.classementMediatheque.setClamedInactif(1);
      } else {
         this.classementMediatheque.setClamedInactif(0);
      }

      this.classementMediatheque.setClamedType(this.ongletSelectionne);
      if (this.classementMediatheque.getClamedId() == 0L) {
         this.classementMediatheque.setClamedUserCreat(this.usersLog.getUsrid());
         this.classementMediatheque.setClamedDateCreat(new Date());
         this.classementMediatheque = this.classementMediathequeDao.insert(this.classementMediatheque);
         if (this.classementMediatheque.getClamedType() == 0) {
            this.sujetList.add(this.classementMediatheque);
            this.datamodelSujet.setWrappedData(this.sujetList);
         } else if (this.classementMediatheque.getClamedType() == 1) {
            this.typeList.add(this.classementMediatheque);
            this.datamodelType.setWrappedData(this.typeList);
         } else if (this.classementMediatheque.getClamedType() == 2) {
            this.supportList.add(this.classementMediatheque);
            this.datamodelSupport.setWrappedData(this.supportList);
         } else if (this.classementMediatheque.getClamedType() == 3) {
            this.contenantList.add(this.classementMediatheque);
            this.datamodelContenant.setWrappedData(this.contenantList);
         }
      } else {
         this.classementMediatheque.setClamedUserModif(this.usersLog.getUsrid());
         this.classementMediatheque.setClamedDateModif(new Date());
         this.classementMediatheque = this.classementMediathequeDao.modif(this.classementMediatheque);
      }

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void verifielesSaisieCodeAct() throws HibernateException, NamingException {
      this.existeCode = this.classementMediathequeDao.existCode(this.getClassementMediatheque().getClamedCode(), (Session)null);
      if (!this.getClassementMediatheque().getClamedCode().equals("") && !this.getClassementMediatheque().getClamedSujet().equals("")) {
         this.codelibVide = true;
      } else {
         this.codelibVide = false;
      }

   }

   public void verifielesSaisieLibelleAct() {
      if (this.getClassementMediatheque().getClamedSujet().equals("")) {
         this.codelibVide = false;
      } else {
         this.codelibVide = true;
      }

   }

   public boolean isCodelibVide() {
      return this.codelibVide;
   }

   public void setCodelibVide(boolean var1) {
      this.codelibVide = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public ClassementMediatheque getClassementMediatheque() {
      return this.classementMediatheque;
   }

   public void setClassementMediatheque(ClassementMediatheque var1) {
      this.classementMediatheque = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowmodelPanel() {
      return this.showmodelPanel;
   }

   public void setShowmodelPanel(boolean var1) {
      this.showmodelPanel = var1;
   }

   public boolean isVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(boolean var1) {
      this.var_inactif = var1;
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

   public DataModel getDatamodelContenant() {
      return this.datamodelContenant;
   }

   public void setDatamodelContenant(DataModel var1) {
      this.datamodelContenant = var1;
   }

   public DataModel getDatamodelSujet() {
      return this.datamodelSujet;
   }

   public void setDatamodelSujet(DataModel var1) {
      this.datamodelSujet = var1;
   }

   public DataModel getDatamodelSupport() {
      return this.datamodelSupport;
   }

   public void setDatamodelSupport(DataModel var1) {
      this.datamodelSupport = var1;
   }

   public DataModel getDatamodelType() {
      return this.datamodelType;
   }

   public void setDatamodelType(DataModel var1) {
      this.datamodelType = var1;
   }

   public String getLibelleOnglet() {
      return this.libelleOnglet;
   }

   public void setLibelleOnglet(String var1) {
      this.libelleOnglet = var1;
   }

   public List getListeComplete() {
      return this.ListeComplete;
   }

   public void setListeComplete(List var1) {
      this.ListeComplete = var1;
   }

   public int getOngletSelectionne() {
      return this.ongletSelectionne;
   }

   public void setOngletSelectionne(int var1) {
      this.ongletSelectionne = var1;
   }
}
