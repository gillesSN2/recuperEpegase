package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormBackupDatas;
import com.epegase.forms.administration.FormInfoSysteme;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.systeme.FormEtatFinancier;
import com.epegase.forms.systeme.FormEvolution;
import com.epegase.forms.systeme.FormServerLog;
import com.epegase.forms.systeme.FormSystemCabinet;
import com.epegase.forms.systeme.FormSystemSociete;
import com.epegase.forms.systeme.FormSystemUsers;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.menu.MenudroitSystemCtrl;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureFormesJuridiques;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureTypesSocietes;
import com.epegase.systeme.xml.LectureZonesCommerciales;
import com.epegase.systeme.xml.LectureZonesFiscales;
import com.epegase.systeme.xml.ObjetLigneMenu;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormBakingBeanSysteme implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private MenudroitSystemCtrl menudroitSystemCtrl;
   private FormEtatFinancier formEtatFinancier;
   private FormSystemSociete formSystemSociete;
   private FormSystemUsers formSystemUsers;
   private FormSystemCabinet formSystemCabinet;
   private FormBackupDatas formBackupDatas;
   private FormServerLog formServerLog;
   private FormInfoSysteme formInfoSysteme;
   private FormEvolution formEvolution;
   private ObjetLigneMenu menuSysteme;
   private List mesPaysItem;
   private List mesFormeJuridiqueItem;
   private List mesTypeEntrepriseItem;
   private List mesZoneCommercialeItem;
   private List mesZoneFiscaleItem;
   private String nomStructureEnCours;
   private FormRecherche formRecherche;
   private int var_currentValue;
   private String var_info;
   private boolean var_showBarProg = false;

   public FormBakingBeanSysteme() throws IOException, SAXException, JDOMException {
   }

   public void menuGaucheSysteme() throws JDOMException, IOException {
      if (this.menudroitSystemCtrl == null) {
         this.menudroitSystemCtrl = new MenudroitSystemCtrl();
         this.menudroitSystemCtrl.chargerMenudroitSystemXml();
      }

   }

   public void razMemoire() {
      this.formBackupDatas = null;
      this.formEtatFinancier = null;
      this.formInfoSysteme = null;
      this.formServerLog = null;
      this.formSystemCabinet = null;
      this.formSystemSociete = null;
      this.formSystemUsers = null;
   }

   public void gestionSystem() throws SAXException, JDOMException, IOException, HibernateException, NamingException, SQLException, ClassNotFoundException, ParseException {
      this.razMemoire();
      this.menuSysteme = new ObjetLigneMenu();
      if (this.menudroitSystemCtrl.getDataModelMenudroitSystemeXmlList().isRowAvailable()) {
         this.menuSysteme = (ObjetLigneMenu)this.menudroitSystemCtrl.getDataModelMenudroitSystemeXmlList().getRowData();
         if (this.menuSysteme.getLibelle_FR() != null && !this.menuSysteme.getLibelle_FR().isEmpty()) {
            if (this.menuSysteme.getCommande().equals("00001")) {
               this.formEtatFinancier = new FormEtatFinancier();
               this.formEtatFinancier.setUtilInitHibernate(this.utilInitHibernate);
               this.formEtatFinancier.setBaseLog(this.baseLog);
               this.formEtatFinancier.setStructureLog(this.structureLog);
               this.formEtatFinancier.setUsersLog(this.usersLog);
               this.formEtatFinancier.instancesDaoUtilisees();
               this.formEtatFinancier.chargerMesCodes();
               this.affichePage = "/systeme/etatFinancier.jsp";
            } else if (this.menuSysteme.getCommande().equals("00002")) {
               this.affichePage = "/pageenconstruction.jsp";
            } else if (this.menuSysteme.getCommande().equals("00003")) {
               this.formSystemSociete = new FormSystemSociete();
               this.formSystemSociete.setUtilInitHibernate(this.utilInitHibernate);
               this.formSystemSociete.setBaseLog(this.baseLog);
               this.formSystemSociete.setStructureLog(this.structureLog);
               this.formSystemSociete.setUsersLog(this.usersLog);
               this.formSystemSociete.instancesDaoUtilisees();
               this.affichePage = "/systeme/listesocietes.jsp";
            } else if (this.menuSysteme.getCommande().equals("00004")) {
               this.formSystemUsers = new FormSystemUsers();
               this.formSystemUsers.setUtilInitHibernate(this.utilInitHibernate);
               this.formSystemUsers.setBaseLog(this.baseLog);
               this.formSystemUsers.setStructureLog(this.structureLog);
               this.formSystemUsers.setUsersLog(this.usersLog);
               this.formSystemUsers.instancesDaoUtilisees();
               this.affichePage = "/systeme/listeusers.jsp";
            } else if (this.menuSysteme.getCommande().equals("00005")) {
               this.formSystemCabinet = new FormSystemCabinet();
               this.formSystemCabinet.setUtilInitHibernate(this.utilInitHibernate);
               this.formSystemCabinet.setBaseLog(this.baseLog);
               this.formSystemCabinet.setStructureLog(this.structureLog);
               this.formSystemCabinet.setUsersLog(this.usersLog);
               this.formSystemCabinet.instancesDaoUtilisees();
               this.affichePage = "/systeme/listegroupes.jsp";
            } else {
               UtilDate var1;
               if (this.menuSysteme.getCommande().equals("00011")) {
                  var1 = new UtilDate();
                  this.formBackupDatas = new FormBackupDatas(this.utilInitHibernate, var1);
                  this.formBackupDatas.setBaseLog(this.baseLog);
                  this.formBackupDatas.setStructureLog(this.structureLog);
                  this.formBackupDatas.setUsersLog(this.usersLog);
                  this.formBackupDatas.chargerListeBaseLocalhost();
                  this.affichePage = "/systeme/copyBasesDonnees.jsp";
               } else if (this.menuSysteme.getCommande().equals("00012")) {
                  var1 = new UtilDate();
                  this.formBackupDatas = new FormBackupDatas(this.utilInitHibernate, var1);
                  this.formBackupDatas.setBaseLog(this.baseLog);
                  this.formBackupDatas.setStructureLog(this.structureLog);
                  this.formBackupDatas.setUsersLog(this.usersLog);
                  this.formBackupDatas.chargerListeBaseEPegase();
                  this.affichePage = "/systeme/copyBasesDonnees.jsp";
               } else if (this.menuSysteme.getCommande().equals("00013")) {
                  this.formInfoSysteme = new FormInfoSysteme();
                  this.formInfoSysteme.setutilInitHibernate(this.utilInitHibernate);
                  this.formInfoSysteme.setBaseLog(this.baseLog);
                  this.formInfoSysteme.setStructureLog(this.structureLog);
                  this.formInfoSysteme.setUsersLog(this.usersLog);
                  this.formInfoSysteme.chargerListeBaseReorganisation();
                  this.affichePage = "/systeme/reorganiseBasesDonnees.jsp";
               } else if (this.menuSysteme.getCommande().equals("00014")) {
                  this.formInfoSysteme = new FormInfoSysteme();
                  this.formInfoSysteme.setutilInitHibernate(this.utilInitHibernate);
                  this.formInfoSysteme.setBaseLog(this.baseLog);
                  this.formInfoSysteme.setStructureLog(this.structureLog);
                  this.formInfoSysteme.setUsersLog(this.usersLog);
                  this.formInfoSysteme.changeePegase();
               } else if (this.menuSysteme.getCommande().equals("00006")) {
                  this.formServerLog = new FormServerLog();
                  this.formServerLog.setUtilInitHibernate(this.utilInitHibernate);
                  this.formServerLog.setBaseLog(this.baseLog);
                  this.formServerLog.setStructureLog(this.structureLog);
                  this.formServerLog.setUsersLog(this.usersLog);
                  this.formServerLog.lectureFichierGlassfish();
                  this.affichePage = "/systeme/serverlog.jsp";
               } else if (this.menuSysteme.getCommande().equals("00007")) {
                  this.formServerLog = new FormServerLog();
                  this.formServerLog.setUtilInitHibernate(this.utilInitHibernate);
                  this.formServerLog.setBaseLog(this.baseLog);
                  this.formServerLog.setStructureLog(this.structureLog);
                  this.formServerLog.setUsersLog(this.usersLog);
                  this.formServerLog.lectureFichierJvm();
                  this.affichePage = "/systeme/jvmlog.jsp";
               } else if (this.menuSysteme.getCommande().equals("00015")) {
                  this.formEvolution = new FormEvolution();
                  this.formEvolution.setUtilInitHibernate(this.utilInitHibernate);
                  this.formEvolution.setBaseLog(this.baseLog);
                  this.formEvolution.setStructureLog(this.structureLog);
                  this.formEvolution.setUsersLog(this.usersLog);
                  this.formEvolution.InstancesDaoUtilses();
                  this.formEvolution.initPegEvolution();
                  this.formEvolution.setFormRecherche(this.formRecherche);
                  this.affichePage = "/systeme/evolution.jsp";
               } else if (this.menuSysteme.getCommande().equals("00010")) {
                  this.affichePage = "/systeme/browser.jsp";
               }
            }
         }
      }

   }

   public void annulerStructure() throws IOException {
      this.affichePage = "/systeme/listesocietes.jsp";
   }

   public void modifStructureSel() throws IOException, HibernateException, NamingException {
      this.formSystemSociete.modifStructureSel();
      this.affichePage = "/systeme/listesocietes.jsp";
   }

   public void gestModifEntete() throws IOException, JDOMException {
      this.affichePage = "/systeme/entetesociete.jsp";
   }

   public void recupererTousLesItems() throws JDOMException, IOException {
      this.recupererPaysItem();
      this.recupererFormeJuridiqueItem();
      this.recupererTypeEntrepriseItem();
      this.recupererZonecommercialeItem();
      this.recupererZoneFiscaleItem();
   }

   public void recupererPaysItem() throws JDOMException, IOException {
      LecturePays var1 = new LecturePays();
      this.mesPaysItem = var1.getMesPaysItems();
   }

   public void recupererFormeJuridiqueItem() throws JDOMException, IOException {
      LectureFormesJuridiques var1 = new LectureFormesJuridiques();
      this.mesFormeJuridiqueItem = var1.getMesFormesJuridiquesItems();
   }

   public void recupererTypeEntrepriseItem() throws JDOMException, IOException {
      LectureTypesSocietes var1 = new LectureTypesSocietes();
      this.mesTypeEntrepriseItem = var1.getMesTypesSocietesItems();
   }

   public void recupererZonecommercialeItem() throws JDOMException, IOException {
      LectureZonesCommerciales var1 = new LectureZonesCommerciales();
      this.mesZoneCommercialeItem = var1.getMesZonesCommercialesItems();
   }

   public void recupererZoneFiscaleItem() throws JDOMException, IOException {
      LectureZonesFiscales var1 = new LectureZonesFiscales();
      this.mesZoneFiscaleItem = var1.getMesZonesFiscalesItems();
   }

   public FormEtatFinancier getFormEtatFinancier() {
      return this.formEtatFinancier;
   }

   public void setFormEtatFinancier(FormEtatFinancier var1) {
      this.formEtatFinancier = var1;
   }

   public FormServerLog getFormServerLog() {
      return this.formServerLog;
   }

   public void setFormServerLog(FormServerLog var1) {
      this.formServerLog = var1;
   }

   public FormSystemSociete getFormSystemSociete() {
      return this.formSystemSociete;
   }

   public void setFormSystemSociete(FormSystemSociete var1) {
      this.formSystemSociete = var1;
   }

   public MenudroitSystemCtrl getMenudroitSystemCtrl() {
      return this.menudroitSystemCtrl;
   }

   public void setMenudroitSystemCtrl(MenudroitSystemCtrl var1) {
      this.menudroitSystemCtrl = var1;
   }

   public ObjetLigneMenu getMenuSysteme() {
      return this.menuSysteme;
   }

   public void setMenuSysteme(ObjetLigneMenu var1) {
      this.menuSysteme = var1;
   }

   public List getMesPaysItem() {
      return this.mesPaysItem;
   }

   public void setMesPaysItem(List var1) {
      this.mesPaysItem = var1;
   }

   public List getMesFormeJuridiqueItem() {
      return this.mesFormeJuridiqueItem;
   }

   public void setMesFormeJuridiqueItem(List var1) {
      this.mesFormeJuridiqueItem = var1;
   }

   public List getMesTypeEntrepriseItem() {
      return this.mesTypeEntrepriseItem;
   }

   public void setMesTypeEntrepriseItem(List var1) {
      this.mesTypeEntrepriseItem = var1;
   }

   public List getMesZoneCommercialeItem() {
      return this.mesZoneCommercialeItem;
   }

   public void setMesZoneCommercialeItem(List var1) {
      this.mesZoneCommercialeItem = var1;
   }

   public List getMesZoneFiscaleItem() {
      return this.mesZoneFiscaleItem;
   }

   public void setMesZoneFiscaleItem(List var1) {
      this.mesZoneFiscaleItem = var1;
   }

   public FormSystemUsers getFormSystemUsers() {
      return this.formSystemUsers;
   }

   public void setFormSystemUsers(FormSystemUsers var1) {
      this.formSystemUsers = var1;
   }

   public FormSystemCabinet getFormSystemCabinet() {
      return this.formSystemCabinet;
   }

   public void setFormSystemCabinet(FormSystemCabinet var1) {
      this.formSystemCabinet = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public FormBackupDatas getFormBackupDatas() {
      return this.formBackupDatas;
   }

   public void setFormBackupDatas(FormBackupDatas var1) {
      this.formBackupDatas = var1;
   }

   public FormInfoSysteme getFormInfoSysteme() {
      return this.formInfoSysteme;
   }

   public void setFormInfoSysteme(FormInfoSysteme var1) {
      this.formInfoSysteme = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getNomStructureEnCours() {
      return this.nomStructureEnCours;
   }

   public void setNomStructureEnCours(String var1) {
      this.nomStructureEnCours = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public FormEvolution getFormEvolution() {
      return this.formEvolution;
   }

   public void setFormEvolution(FormEvolution var1) {
      this.formEvolution = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }
}
