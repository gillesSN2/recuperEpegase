package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormEtatFinancierConfigClient;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.comptabilite.FormEtatFinancierExploitation;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitReportingCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormBakingBeanReporting implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitReportingCtrl menudroitReportingCtrl;
   private ObjetLigneMenu menureporting = new ObjetLigneMenu();
   private ObjetLigneMenu menureportingMemo;
   private LectureModulesOnglets lesOnglets;
   private LireLesoptionsCompta lireLesoptionsCompta;
   private OptionComptabilite optionComptabilite;
   private int nature;
   private OptionVentes optionVentes;
   private Habilitation habilitation;
   private long leIdExo;
   private ExercicesComptable exoselectionne;
   private ExercicesComptable lastExercice;
   private String libelleReporting;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private String messageAlerte;
   private FormEtatFinancierConfigClient formEtatFinancierConfigClient;
   private FormEtatFinancierExploitation formEtatFinancierExploitation;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public FormBakingBeanReporting() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, NamingException, ParseException {
      ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExecpt_id();
      this.lastExercice = var2.recupererLastExo(var1);
      if (this.leIdExo == 0L) {
         UtilDate var3 = new UtilDate();
         this.exoselectionne.setExecptDateDebut(var3.datePremierJourAnnee(new Date()));
         this.exoselectionne.setExecptDateFin(var3.dateDernierJourAnnee(new Date()));
         this.lastExercice.setExecptDateDebut(var3.datePremierJourAnnee(new Date()));
         this.lastExercice.setExecptDateFin(var3.dateDernierJourAnnee(new Date()));
      }

   }

   public void recupererLeIdExo() throws HibernateException, NamingException, ParseException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesComptable recupererLeIdExo(Session var1) throws NamingException {
      ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExecpt_id();
      return this.exoselectionne;
   }

   public void menuGaucheReporting() throws JDOMException, IOException {
      if (this.menudroitReportingCtrl == null) {
         this.menudroitReportingCtrl = new MenudroitReportingCtrl();
         this.menudroitReportingCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitReportingCtrl.chargerMenuGaucheReportingXml(this.usersLog.getUsrCollaboration(), this.structureLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("91000", this.usersLog.getUsrCollaboration());
   }

   public void gestionReporting() throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.menureporting = new ObjetLigneMenu();
      if (this.menudroitReportingCtrl.getDataModelMenudroitReportingXmlList().isRowAvailable()) {
         this.menureporting = (ObjetLigneMenu)this.menudroitReportingCtrl.getDataModelMenudroitReportingXmlList().getRowData();
         if (this.menureporting.getLibelle_FR() != null && !this.menureporting.getLibelle_FR().isEmpty()) {
            this.menureportingMemo = this.menureporting;
            this.aiguillageReporting();
         }
      }

   }

   public void razMemoire() {
   }

   public void gestionReportingFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menureporting = var1;
      this.menureportingMemo = this.menureporting;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheReporting();
      }

      this.aiguillageReporting();
   }

   public void aiguillageReporting() throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.menureporting.setAdd(this.menureportingMemo.isAdd());
      this.menureporting.setMaj(this.menureportingMemo.isMaj());
      this.menureporting.setSup(this.menureportingMemo.isSup());
      this.menureporting.setDup(this.menureportingMemo.isDup());
      this.menureporting.setClo(this.menureportingMemo.isClo());
      this.menureporting.setTrf(this.menureportingMemo.isTrf());
      this.menureporting.setImp(this.menureportingMemo.isImp());
      this.razMemoire();
      if (this.menureporting.getCommande().equalsIgnoreCase("91000:01")) {
         this.affichePage = "/reporting/ConfigurationReporting.jsp";
         this.menuParametrage();
      } else if (this.menureporting.getCommande().equalsIgnoreCase("91000:02")) {
         this.affichePage = "/reporting/ImpressionReporting.jsp";
         this.libelleReporting = "Comptabilité";
         this.menuTableaux("4");
      } else if (this.menureporting.getCommande().equalsIgnoreCase("91000:03")) {
         this.affichePage = "/reporting/ImpressionReporting.jsp";
         this.libelleReporting = "Paye";
         this.menuTableaux("5");
      } else if (this.menureporting.getCommande().equalsIgnoreCase("91000:04")) {
         this.affichePage = "/reporting/ImpressionReporting.jsp";
         this.libelleReporting = "Achats";
         this.menuTableaux("6");
      } else if (this.menureporting.getCommande().equalsIgnoreCase("91000:05")) {
         this.affichePage = "/reporting/ImpressionReporting.jsp";
         this.libelleReporting = "Ventes";
         this.menuTableaux("8");
      } else if (this.menureporting.getCommande().equalsIgnoreCase("91000:06")) {
         this.affichePage = "/reporting/ImpressionReporting.jsp";
         this.libelleReporting = "Tresorerie";
         this.menuTableaux("90");
      } else if (this.menureporting.getCommande().equalsIgnoreCase("91000:07")) {
         this.affichePage = "/reporting/ImpressionReporting.jsp";
         this.libelleReporting = "Global";
         this.menuTableaux("0");
      }

   }

   public void menuParametrage() throws HibernateException, NamingException, IOException {
      this.formEtatFinancierConfigClient = new FormEtatFinancierConfigClient();
      this.formEtatFinancierConfigClient.setutilInitHibernate(this.utilInitHibernate);
      this.formEtatFinancierConfigClient.setBaseLog(this.baseLog);
      this.formEtatFinancierConfigClient.setStructureLog(this.structureLog);
      this.formEtatFinancierConfigClient.setUsersLog(this.usersLog);
      this.formEtatFinancierConfigClient.InstancesDaoUtilses();
      this.formEtatFinancierConfigClient.setNature(1);
      this.formEtatFinancierConfigClient.chargerMesracines();
      this.formEtatFinancierConfigClient.chargerMesTabNom((Session)null);
   }

   public void menuTableaux(String var1) throws HibernateException, NamingException, IOException, ParseException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CptTabNom");
      this.formEtatFinancierExploitation = new FormEtatFinancierExploitation();
      this.formEtatFinancierExploitation.setutilInitHibernate(this.utilInitHibernate);
      this.formEtatFinancierExploitation.setBaseLog(this.baseLog);
      this.formEtatFinancierExploitation.setStructureLog(this.structureLog);
      this.formEtatFinancierExploitation.setUsersLog(this.usersLog);
      this.formEtatFinancierExploitation.setSelectedExo(this.exoselectionne);
      this.formEtatFinancierExploitation.setLastExo(this.lastExercice);
      this.formEtatFinancierExploitation.setNature(1);
      this.formEtatFinancierExploitation.InstancesDaoUtilses();
      this.formEtatFinancierExploitation.setOptionComptabilite(this.optionComptabilite);
      this.formEtatFinancierExploitation.setLesModelesAutorises(this.lesModelesAutorises);
      this.formEtatFinancierExploitation.chargerMesracines();
      this.formEtatFinancierExploitation.chargerMesReporting(1, Integer.parseInt(var1), var2);
      this.utilInitHibernate.closeSession();
   }

   public void recupererTousLesItems() throws IOException, HibernateException, NamingException {
      this.recupererModelesAutorises();
   }

   public void recupererOptionsCompta() throws IOException {
      this.optionComptabilite = new OptionComptabilite();
      this.lireLesoptionsCompta = new LireLesoptionsCompta(this.structureLog);
      this.lireLesoptionsCompta.setStrId(this.structureLog.getStrid());
      this.lireLesoptionsCompta.lancer();
      this.optionComptabilite = this.lireLesoptionsCompta.getOptionComptabilite();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "reporting" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "reporting" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitReportingCtrl getMenudroitReportingCtrl() {
      return this.menudroitReportingCtrl;
   }

   public void setMenudroitReportingCtrl(MenudroitReportingCtrl var1) {
      this.menudroitReportingCtrl = var1;
   }

   public ObjetLigneMenu getMenureporting() {
      return this.menureporting;
   }

   public void setMenureporting(ObjetLigneMenu var1) {
      this.menureporting = var1;
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

   public UtilInitHibernate getInitHibernateSessionFactory_2() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getConfigListeEntete() {
      return this.configListeEntete;
   }

   public void setConfigListeEntete(String var1) {
      this.configListeEntete = var1;
   }

   public String getConfigListeLigne() {
      return this.configListeLigne;
   }

   public void setConfigListeLigne(String var1) {
      this.configListeLigne = var1;
   }

   public FormEtatFinancierConfigClient getFormEtatFinancierConfigClient() {
      return this.formEtatFinancierConfigClient;
   }

   public void setFormEtatFinancierConfigClient(FormEtatFinancierConfigClient var1) {
      this.formEtatFinancierConfigClient = var1;
   }

   public FormEtatFinancierExploitation getFormEtatFinancierExploitation() {
      return this.formEtatFinancierExploitation;
   }

   public void setFormEtatFinancierExploitation(FormEtatFinancierExploitation var1) {
      this.formEtatFinancierExploitation = var1;
   }

   public ExercicesComptable getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesComptable var1) {
      this.exoselectionne = var1;
   }

   public ExercicesComptable getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesComptable var1) {
      this.lastExercice = var1;
   }

   public ObjetLigneMenu getMenureportingMemo() {
      return this.menureportingMemo;
   }

   public void setMenureportingMemo(ObjetLigneMenu var1) {
      this.menureportingMemo = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public String getLibelleReporting() {
      return this.libelleReporting;
   }

   public void setLibelleReporting(String var1) {
      this.libelleReporting = var1;
   }
}
