package com.epegase.forms.administration;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormActivitesCommerciales implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private String pageIndex;
   private List activitesList = new ArrayList();
   private transient DataModel datamodelActivites = new ListDataModel();
   private Activites activites;
   private ActivitesDao activitesDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;
   private List mesResponsable = new ArrayList();
   private UserDao userDao;
   private List lesDecoupagesItems = new ArrayList();
   private boolean decoupageVisible;
   private String codeDecoupage = null;
   private boolean showModalPanelDecoupage = false;
   private StructureDao structureDao;
   private List mesCompteTaxeItems;
   private ExercicesComptableDao exercicesComptableDao;
   private ExercicesComptable exercicesComptable;
   private PlanComptableDao planComptableDao;
   private int choixRacine;
   private String selecFiscalite;

   public FormActivitesCommerciales() {
      this.activitesList = new ArrayList();
      this.mesCompteTaxeItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesActivites() throws HibernateException, NamingException {
      this.setLien(this.lien);
      this.mesResponsable.clear();
      new ArrayList();
      List var1 = this.userDao.chargerLesSignataires("Ventes", (Session)null);
      if (var1.size() != 0) {
         this.mesResponsable.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            new Users();
            Users var3 = (Users)var1.get(var2);
            this.mesResponsable.add(new SelectItem(var3.getUsrid(), var3.getUsrNom() + ":" + var3.getUsrPrenom()));
         }
      }

      if (this.mesResponsable.size() == 0) {
         this.mesResponsable.add(new SelectItem(0, ""));
      }

      this.decoupage();
      this.exercicesComptable = this.exercicesComptableDao.recupererLastExo((Session)null);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
   }

   public void decoupage() throws HibernateException, NamingException {
      this.lesDecoupagesItems.clear();
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.lesDecoupagesItems.add(new SelectItem(this.structureLog.getStrCode1(), this.structureLog.getStrLib1()));
      }

      if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
         this.lesDecoupagesItems.add(new SelectItem(this.structureLog.getStrCode2(), this.structureLog.getStrLib2()));
      }

      if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
         this.lesDecoupagesItems.add(new SelectItem(this.structureLog.getStrCode3(), this.structureLog.getStrLib3()));
      }

      if (this.lesDecoupagesItems.size() != 0) {
         this.decoupageVisible = true;
      } else {
         this.decoupageVisible = false;
         this.chargeActivite();
      }

   }

   public void chargeActivite() throws HibernateException, NamingException {
      this.activitesList.clear();
      if (this.lesDecoupagesItems.size() != 0) {
         this.activitesList = this.activitesDao.selectActivites(this.codeDecoupage, (Session)null);
      } else {
         this.activitesList = this.activitesDao.selectActivites((Session)null);
      }

      this.datamodelActivites.setWrappedData(this.activitesList);
   }

   public void configurerDecoupage() {
      this.showModalPanelDecoupage = true;
   }

   public void fermerDecoupage() {
      this.showModalPanelDecoupage = false;
   }

   public void validerDecoupage() throws HibernateException, NamingException {
      this.structureLog = this.structureDao.modStructure(this.structureLog);
      this.decoupage();
      this.showModalPanelDecoupage = false;
   }

   public void selectionActivite() {
      if (this.datamodelActivites.isRowAvailable()) {
         this.activites = (Activites)this.datamodelActivites.getRowData();
         if (this.activites.getActInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void ajouterActivites() {
      this.activites = new Activites();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
   }

   public void modifierActivites() throws NamingException {
      if (this.activites != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.chargeCompteTaxes();
         this.showmodelPanel = true;
      }

   }

   public void supprimerActivites() throws HibernateException, NamingException {
      if (this.activites != null) {
         this.activitesList.remove(this.activites);
         this.datamodelActivites.setWrappedData(this.activitesList);
         this.activitesDao.delete(this.activites);
      }

   }

   public void annulerActivites() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveActivites() throws HibernateException, NamingException {
      if (this.activites.getActIdResponsable() != 0L) {
         new Users();
         Users var1 = this.userDao.selectByIdUsers(this.activites.getActIdResponsable(), (Session)null);
         if (var1 != null) {
            this.activites.setActNomResponsable(var1.getUsrPatronyme());
         } else {
            this.activites.setActNomResponsable("");
         }
      } else {
         this.activites.setActNomResponsable("");
      }

      if (this.var_inactif) {
         this.activites.setActInactif(1);
      } else {
         this.activites.setActInactif(0);
      }

      this.activites.setActColonne(this.codeDecoupage);
      if (this.activites.getActId() == 0L) {
         this.activites.setActUserCreat(this.usersLog.getUsrid());
         this.activites.setActDateCreat(new Date());
         this.activites = this.activitesDao.insert(this.activites);
         this.activitesList.add(this.activites);
         this.datamodelActivites.setWrappedData(this.activitesList);
      } else {
         this.activites.setActUserModif(this.usersLog.getUsrid());
         this.activites.setActDateModif(new Date());
         this.activites = this.activitesDao.modif(this.activites);
      }

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void chargeCompteTaxes() throws NamingException {
      this.mesCompteTaxeItems.clear();
      if (this.activites.getActOptions() == 6 && this.exercicesComptable != null) {
         this.mesCompteTaxeItems = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exercicesComptable.getExecpt_id(), "(9,13,14,15)", 0, (Session)null);
      }

   }

   public void verifielesSaisieCodeAct() throws HibernateException, NamingException {
      this.existeCode = this.activitesDao.existCode(this.getActivites().getActCode(), (Session)null);
      if (!this.getActivites().getActCode().equals("") && !this.getActivites().getActNomFr().equals("")) {
         this.codelibVide = true;
      } else {
         this.codelibVide = false;
      }

   }

   public void verifielesSaisieLibelleAct() {
      if (this.getActivites().getActNomFr().equals("")) {
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

   public List getActivitesList() {
      return this.activitesList;
   }

   public void setActivitesList(List var1) {
      this.activitesList = var1;
   }

   public Activites getActivites() {
      return this.activites;
   }

   public void setActivites(Activites var1) {
      this.activites = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelActivites() {
      return this.datamodelActivites;
   }

   public void setDatamodelActivites(DataModel var1) {
      this.datamodelActivites = var1;
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

   public List getMesResponsable() {
      return this.mesResponsable;
   }

   public void setMesResponsable(List var1) {
      this.mesResponsable = var1;
   }

   public boolean isDecoupageVisible() {
      return this.decoupageVisible;
   }

   public void setDecoupageVisible(boolean var1) {
      this.decoupageVisible = var1;
   }

   public List getLesDecoupagesItems() {
      return this.lesDecoupagesItems;
   }

   public void setLesDecoupagesItems(List var1) {
      this.lesDecoupagesItems = var1;
   }

   public String getCodeDecoupage() {
      return this.codeDecoupage;
   }

   public void setCodeDecoupage(String var1) {
      this.codeDecoupage = var1;
   }

   public boolean isShowModalPanelDecoupage() {
      return this.showModalPanelDecoupage;
   }

   public void setShowModalPanelDecoupage(boolean var1) {
      this.showModalPanelDecoupage = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesCompteTaxeItems() {
      return this.mesCompteTaxeItems;
   }

   public void setMesCompteTaxeItems(List var1) {
      this.mesCompteTaxeItems = var1;
   }
}
