package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormChronoCpta;
import com.epegase.forms.administration.FormExercicesComptables;
import com.epegase.forms.administration.FormPlansAnalytiques;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.comptabilite.FormAmortissements;
import com.epegase.forms.comptabilite.FormBrouillardsComptables;
import com.epegase.forms.comptabilite.FormBudget;
import com.epegase.forms.comptabilite.FormBudgetTresorerie;
import com.epegase.forms.comptabilite.FormEtatFinancierExploitation;
import com.epegase.forms.comptabilite.FormExtraitAnalList;
import com.epegase.forms.comptabilite.FormExtraitBudget;
import com.epegase.forms.comptabilite.FormExtraitClasse;
import com.epegase.forms.comptabilite.FormExtraitCompte;
import com.epegase.forms.comptabilite.FormExtraitProjet;
import com.epegase.forms.comptabilite.FormImpressionAnalytique;
import com.epegase.forms.comptabilite.FormImpressionGenerale;
import com.epegase.forms.comptabilite.FormImpressionProjet;
import com.epegase.forms.comptabilite.FormJournauxComptables;
import com.epegase.forms.comptabilite.FormLoyers;
import com.epegase.forms.comptabilite.FormNotesExternes;
import com.epegase.forms.comptabilite.FormRapprochement;
import com.epegase.forms.comptabilite.FormTransfertCompta;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitComptabiliteCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureCompte;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionConfigListe;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import jxl.write.WriteException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.xml.sax.SAXException;

public class FormBakingBeanComptabilite implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String modulesCode;
   private String affichePage;
   private String messageAlerte;
   private int nature;
   private FormRecherche formRecherche;
   private long leIdExo;
   private MenudroitComptabiliteCtrl menudroitComptabiliteCtrl;
   private OptionComptabilite optionComptabilite;
   private LectureModulesOnglets lesOnglets;
   private LireLesoptionsCompta lireLesoptionsCompta;
   private FormExercicesComptables formExercicesComptables;
   private ExercicesComptable exoselectionne = new ExercicesComptable();
   private ExercicesComptable lastExercice = new ExercicesComptable();
   private ObjetLigneMenu menucompta;
   private ObjetLigneMenu menucomptaMemo = new ObjetLigneMenu();
   private ChronoDao chronoDao;
   private boolean testAffAjout = false;
   private boolean testAffModif = false;
   private boolean testAffSupp = false;
   private boolean testAffTrf = false;
   private String quelTransfert;
   private LectureNatureCompte natureCompte;
   private List mesSitesItems = new ArrayList();
   private List mesRegionsItems = new ArrayList();
   private List mesActivitesItems = new ArrayList();
   private List mesBudgetsItems = new ArrayList();
   private List mesParcsItems = new ArrayList();
   private List mesDossiersItems = new ArrayList();
   private List mesChantiersItems = new ArrayList();
   private List mesMissionsItems = new ArrayList();
   private List mesProjetsItems = new ArrayList();
   private List mesPlansBudgetsItems = new ArrayList();
   private List mesAxesAnalytique = new ArrayList();
   private List mesStructuresItems = new ArrayList();
   private FormLoyers formLoyers;
   private FormAmortissements formAmortissements;
   private FormBudget formBudget;
   private FormBudgetTresorerie formBudgetTresorerie;
   private FormBrouillardsComptables formBrouillardMois;
   private FormJournauxComptables formJournauxComptables;
   private FormRapprochement formRapprochement;
   private FormExtraitCompte formExtraitCompte;
   private FormExtraitClasse formExtraitClasse;
   private FormExtraitAnalList formExtraitAnalList;
   private FormExtraitProjet formExtraitProjet;
   private FormExtraitBudget formExtraitBudget;
   private FormEtatFinancierExploitation formEtatFinancierExploitation;
   private FormImpressionGenerale formImpressionGenerale;
   private FormImpressionAnalytique formImpressionAnalytique;
   private FormImpressionProjet formImpressionProjet;
   private FormTransfertCompta formTransfertCompta;
   private FormNotesExternes formNotesExternes;
   private boolean disable;
   private SiteDao siteDao;
   private DepartementDao departementDao;
   private ServiceDao serviceDao;
   private RegionDao regionDao;
   private SecteurDao secteurDao;
   private PlansAnalytiquesDao analytiqueDao;
   private ActivitesDao activitesDao;
   private PointDeVenteDao pointDeVenteDao;
   private ProjetsDao projetsDao;
   private PlansBudgetairesDao plansBudgetairesDao;
   private FormChronoCpta formChronoCpta;
   private List mesClesItems;
   private List mesAgentsItems;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private Chrono chrono;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private transient DataModel dataModelSociete = new ListDataModel();
   private List lesStructuresGrp = new ArrayList();
   private FormPlansAnalytiques formPlansAnalytiques;
   private boolean showButtonModif;
   private boolean showModalPanelStructure;
   private StructurePeg structurePeg;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public void InstancesDaoUtilses() {
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.analytiqueDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.plansBudgetairesDao = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, NamingException {
      ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExecpt_id();
      this.lastExercice = var2.recupererLastExo(var1);
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

   public List getLesExerciceComptables(Session var1) throws IOException, JDOMException, NamingException {
      this.formExercicesComptables = new FormExercicesComptables();
      this.formExercicesComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesComptables.setBaseLog(this.baseLog);
      this.formExercicesComptables.setStructureLog(this.structureLog);
      this.formExercicesComptables.setUsersLog(this.usersLog);
      this.formExercicesComptables.InstancesDaoUtilses();
      return this.formExercicesComptables.recupererLesexercices(var1);
   }

   public void menuGaucheComptabilite() throws JDOMException, IOException {
      if (this.menudroitComptabiliteCtrl == null) {
         this.menudroitComptabiliteCtrl = new MenudroitComptabiliteCtrl();
         this.menudroitComptabiliteCtrl.setStrId(this.structureLog.getStrid());
         this.menudroitComptabiliteCtrl.setStrEnteteGroupe(this.structureLog.getStrmaitrecabinet());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         if (this.optionComptabilite != null) {
            this.menudroitComptabiliteCtrl.chargerMenudroitComptabiliteXml(this.usersLog.getUsrCollaboration(), this.modulesCode, this.optionComptabilite);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets(this.modulesCode, this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formAmortissements = null;
      this.formBrouillardMois = null;
      this.formBudget = null;
      this.formBudgetTresorerie = null;
      this.formEtatFinancierExploitation = null;
      this.formExtraitAnalList = null;
      this.formExtraitClasse = null;
      this.formExtraitCompte = null;
      this.formExtraitProjet = null;
      this.formImpressionAnalytique = null;
      this.formImpressionGenerale = null;
      this.formImpressionProjet = null;
      this.formJournauxComptables = null;
      this.formLoyers = null;
      this.formRapprochement = null;
      this.formTransfertCompta = null;
   }

   public void gestionComptabilite() throws IOException, SAXException, HibernateException, NamingException, org.apache.taglibs.standard.extra.spath.ParseException, ParseException, JDOMException {
      this.menucompta = new ObjetLigneMenu();
      if (this.menudroitComptabiliteCtrl.getDataModelMenudroitComptabiliteXmlList().isRowAvailable()) {
         this.menucompta = (ObjetLigneMenu)this.menudroitComptabiliteCtrl.getDataModelMenudroitComptabiliteXmlList().getRowData();
         if (this.menucompta.getLibelle_FR() != null && !this.menucompta.getLibelle_FR().isEmpty()) {
            this.menucomptaMemo = this.menucompta;
            this.aiguillageComptabilite();
         }
      }

   }

   public void gestionComptaFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.taglibs.standard.extra.spath.ParseException, ParseException {
      this.menucompta = var1;
      this.menucomptaMemo = this.menucompta;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheComptabilite();
      }

      this.aiguillageComptabilite();
   }

   public void aiguillageComptabilite() throws IOException, SAXException, HibernateException, NamingException, org.apache.taglibs.standard.extra.spath.ParseException, ParseException, JDOMException {
      if (this.lastExercice.getExecpt_id() != this.exoselectionne.getExecpt_id()) {
         this.menucompta.setAdd(false);
         this.menucompta.setMaj(false);
         this.menucompta.setSup(false);
         this.menucompta.setDup(false);
         this.menucompta.setClo(false);
         this.menucompta.setTrf(false);
         this.menucompta.setImp(true);
      } else {
         this.menucompta.setAdd(this.menucomptaMemo.isAdd());
         this.menucompta.setMaj(this.menucomptaMemo.isMaj());
         this.menucompta.setSup(this.menucomptaMemo.isSup());
         this.menucompta.setDup(this.menucomptaMemo.isDup());
         this.menucompta.setClo(this.menucomptaMemo.isClo());
         this.menucompta.setTrf(this.menucomptaMemo.isTrf());
         this.menucompta.setImp(this.menucomptaMemo.isImp());
      }

      this.razMemoire();
      if (this.exoselectionne.getExecptEtat() == 0) {
         this.testAffAjout = true;
         this.testAffModif = true;
         this.testAffSupp = true;
         this.testAffTrf = true;
      } else {
         this.testAffAjout = false;
         this.testAffModif = false;
         this.testAffSupp = false;
         this.testAffTrf = false;
      }

      Session var1;
      String var2;
      if (this.menucompta.getCommande().equalsIgnoreCase("40000:01")) {
         this.nature = 50;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Loyer");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/LoyersInit.jsp";
               this.menuLoyer(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:02")) {
         this.nature = 51;
         boolean var4 = false;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var5);
         if (this.usersChrono != null) {
            String var3 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var5);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/AmortissementsInit.jsp";
               this.menuAmortissement(var5);
               var4 = true;
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
         if (var4) {
            this.formAmortissements.recupAndroidInventnaire();
         }
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:03")) {
         this.nature = 52;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Projets");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/BudgetsInit.jsp";
               this.menuBudget(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:04")) {
         this.nature = 54;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Activites");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/BudgetsTresorerieInit.jsp";
               this.menuBudgetTresorerie(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:07")) {
         this.nature = 531;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/BrouillardsJourInit.jsp";
               this.menuBrouillardJour(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:08")) {
         this.nature = 532;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/BrouillardsMoisInit.jsp";
               this.menuBrouillardMois(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:09")) {
         this.nature = 53;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/JournauxComptablesInit.jsp";
               this.menuJournauxComptables(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:11")) {
         this.nature = 53;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/JournauxCloture.jsp";
               this.menuClotureJournaux(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:10")) {
         this.nature = 56;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/RapprochementInit.jsp";
               this.menuRapprochement(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:13")) {
         this.nature = 534;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ExtraitCompteInit.jsp";
               this.menuExtraitCompte(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:14")) {
         this.nature = 538;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ExtraitClasseInit.jsp";
               this.menuExtraitClasse(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:15")) {
         this.nature = 535;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ExtraitAnalListInit.jsp";
               this.menuExtraitAnalytique(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:16")) {
         this.nature = 539;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ExtraitProjetInit.jsp";
               this.menuExtraitProjet(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:17")) {
         this.nature = 536;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ExtraitBudgetInit.jsp";
               this.menuExtraitBudget(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:18")) {
         this.nature = 53;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ImputationAnalytiqueInit.jsp";
               this.menuImputationAnalytique(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:19")) {
         this.nature = 57;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresNotes");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/NotesExternesInit.jsp";
               this.menuNotesExternes(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:90")) {
         this.nature = 533;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ImpressionGenerale.jsp";
               this.menuImpressionGenerale(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:91")) {
         this.nature = 533;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ImpressionAnalytique.jsp";
               this.menuImpressionAnalytique(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:92")) {
         this.nature = 533;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ImpressionProjet.jsp";
               this.menuImpressionProjet(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:93")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CptTabNom");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 537, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), 537, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ImpressionEtatFinancier.jsp";
               this.nature = 0;
               this.menuTableaux(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:94")) {
         this.affichePage = "/comptabilite/ErreurAcces.jsp";
         this.messageAlerte = "Veuillez passer par le module de reporting.....";
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:95")) {
         this.nature = 53;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/ImportationEcritures.jsp";
               this.importationEcritures();
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:96")) {
         this.nature = 53;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNatCompta(this.usersChrono.getUsrchrSerie(), this.nature, var1);
            if (this.chrono != null) {
               this.affichePage = "/comptabilite/BalancesInteractives.jsp";
               this.menuImpressionBalancesInteractives(var1);
            } else {
               this.affichePage = "/comptabilite/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/comptabilite/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 50;
         this.menuDocuentsOfficiels();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40000:99")) {
         this.affichePage = "/comptabilite/SelectionExercicesCompta.jsp";
         this.menuSelectionExercicesCompta();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40010:01")) {
         this.affichePage = "/comptabilite/groupe/ListeSocietes.jsp";
         this.menuGroupeListesociété();
      } else if (this.menucompta.getCommande().equalsIgnoreCase("40010:02")) {
         this.affichePage = "/comptabilite/groupe/ListeClesRepartitions.jsp";
         this.menuGroupeCleRepartition();
      }

   }

   public void menuLoyer(Session var1) throws NamingException {
      this.formLoyers = new FormLoyers();
      this.formLoyers.setutilInitHibernate(this.utilInitHibernate);
      this.formLoyers.setBaseLog(this.baseLog);
      this.formLoyers.setStructureLog(this.structureLog);
      this.formLoyers.setUsersLog(this.usersLog);
      this.formLoyers.InstancesDaoUtilses();
      this.formLoyers.setOptionComptabilite(this.optionComptabilite);
      this.formLoyers.setLesModelesAutorises(this.lesModelesAutorises);
      this.formLoyers.setSelectedExo(this.exoselectionne);
      this.formLoyers.setLastExo(this.lastExercice);
      this.formLoyers.setNature(this.nature);
      this.formLoyers.initAnalytique();
      this.formLoyers.chargerLesComptes(var1);
      this.formLoyers.chargerLesloyers(var1);
      this.formLoyers.setDecoupageActivite(this.decoupageActivite);
      this.formLoyers.setLaColonne1Items(this.laColonne1Items);
      this.formLoyers.setLaColonne2Items(this.laColonne2Items);
      this.formLoyers.setLaColonne3Items(this.laColonne3Items);
   }

   public void menuAmortissement(Session var1) throws SAXException, HibernateException, NamingException, IOException {
      this.formAmortissements = new FormAmortissements();
      this.formAmortissements.setutilInitHibernate(this.utilInitHibernate);
      this.formAmortissements.setBaseLog(this.baseLog);
      this.formAmortissements.setStructureLog(this.structureLog);
      this.formAmortissements.setUsersLog(this.usersLog);
      this.formAmortissements.InstancesDaoUtilses();
      this.formAmortissements.setOptionComptabilite(this.optionComptabilite);
      this.formAmortissements.setLesModelesAutorises(this.lesModelesAutorises);
      this.formAmortissements.setSelectedExo(this.exoselectionne);
      this.formAmortissements.setLastExo(this.lastExercice);
      this.formAmortissements.setNature(this.nature);
      this.formAmortissements.initAnalytique(var1);
      this.formAmortissements.chargerLesComptes(var1);
      this.formAmortissements.chargerLesLocalisations(var1);
      this.recupererImpressionItems(var1);
      this.formAmortissements.verifPresenceParc(var1);
      this.formAmortissements.setDecoupageActivite(this.decoupageActivite);
      this.formAmortissements.setLaColonne1Items(this.laColonne1Items);
      this.formAmortissements.setLaColonne2Items(this.laColonne2Items);
      this.formAmortissements.setLaColonne3Items(this.laColonne3Items);
      this.formAmortissements.setUrlExplorateur(this.urlExplorateur);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuBudget(Session var1) throws IOException, HibernateException, NamingException {
      this.formBudget = new FormBudget();
      this.formBudget.setutilInitHibernate(this.utilInitHibernate);
      this.formBudget.setBaseLog(this.baseLog);
      this.formBudget.setStructureLog(this.structureLog);
      this.formBudget.setUsersLog(this.usersLog);
      this.formBudget.InstancesDaoUtilses();
      this.formBudget.setOptionComptabilite(this.optionComptabilite);
      this.formBudget.setLesModelesAutorises(this.lesModelesAutorises);
      this.formBudget.setSelectedExo(this.exoselectionne);
      this.formBudget.setLastExo(this.lastExercice);
      this.formBudget.setNature(this.nature);
      this.formBudget.initAnalytique(var1);
      this.formBudget.calculAnnee();
      this.formBudget.setDecoupageActivite(this.decoupageActivite);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuBudgetTresorerie(Session var1) throws IOException, HibernateException, NamingException {
      this.formBudgetTresorerie = new FormBudgetTresorerie();
      this.formBudgetTresorerie.setutilInitHibernate(this.utilInitHibernate);
      this.formBudgetTresorerie.setBaseLog(this.baseLog);
      this.formBudgetTresorerie.setStructureLog(this.structureLog);
      this.formBudgetTresorerie.setUsersLog(this.usersLog);
      this.formBudgetTresorerie.InstancesDaoUtilses();
      this.formBudgetTresorerie.setOptionComptabilite(this.optionComptabilite);
      this.formBudgetTresorerie.setLesModelesAutorises(this.lesModelesAutorises);
      this.formBudgetTresorerie.setSelectedExo(this.exoselectionne);
      this.formBudgetTresorerie.setLastExo(this.lastExercice);
      this.formBudgetTresorerie.setNature(this.nature);
      this.formBudgetTresorerie.initAnalytique(var1);
      this.formBudgetTresorerie.calculAnnee();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuNotesExternes(Session var1) throws IOException, org.apache.taglibs.standard.extra.spath.ParseException, HibernateException, NamingException {
      this.formNotesExternes = new FormNotesExternes();
      this.formNotesExternes.setutilInitHibernate(this.utilInitHibernate);
      this.formNotesExternes.setBaseLog(this.baseLog);
      this.formNotesExternes.setStructureLog(this.structureLog);
      this.formNotesExternes.setUsersLog(this.usersLog);
      this.formNotesExternes.InstancesDaoUtilses();
      this.formNotesExternes.setOptionComptabilite(this.optionComptabilite);
      this.formNotesExternes.setLesModelesAutorises(this.lesModelesAutorises);
      this.formNotesExternes.setSelectedExo(this.exoselectionne);
      this.formNotesExternes.setLastExo(this.lastExercice);
      this.formNotesExternes.setNature(this.nature);
      this.formNotesExternes.initAnalytique();
      this.formNotesExternes.chargerLesNotes(var1);
      this.formNotesExternes.setDecoupageActivite(this.decoupageActivite);
      this.formNotesExternes.setLaColonne1Items(this.laColonne1Items);
      this.formNotesExternes.setLaColonne2Items(this.laColonne2Items);
      this.formNotesExternes.setLaColonne3Items(this.laColonne3Items);
      this.formNotesExternes.setUrlExplorateur(this.urlExplorateur);
      this.formNotesExternes.setFormRecherche(this.formRecherche);
   }

   public void menuBrouillardJour(Session var1) throws IOException, NamingException {
      this.formBrouillardMois = new FormBrouillardsComptables();
      this.formBrouillardMois.setutilInitHibernate(this.utilInitHibernate);
      this.formBrouillardMois.setBaseLog(this.baseLog);
      this.formBrouillardMois.setStructureLog(this.structureLog);
      this.formBrouillardMois.setUsersLog(this.usersLog);
      this.formBrouillardMois.InstancesDaoUtilses();
      this.formBrouillardMois.setOptionComptabilite(this.optionComptabilite);
      this.formBrouillardMois.setLesModelesAutorises(this.lesModelesAutorises);
      this.formBrouillardMois.setSelectedExo(this.exoselectionne);
      this.formBrouillardMois.setLastExo(this.lastExercice);
      this.formBrouillardMois.setNature(this.nature);
      this.formBrouillardMois.initAnalytique();
      this.formBrouillardMois.chargerLesJournauxComptable(var1);
      this.formBrouillardMois.chargerLesUsers(var1);
      this.formBrouillardMois.calculPeriode(var1);
      this.formBrouillardMois.chargerLesModelesImpresion();
      this.formBrouillardMois.setFormRecherche(this.formRecherche);
      this.formBrouillardMois.setUrlExplorateur(this.urlExplorateur);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuBrouillardMois(Session var1) throws IOException, NamingException {
      this.formBrouillardMois = new FormBrouillardsComptables();
      this.formBrouillardMois.setutilInitHibernate(this.utilInitHibernate);
      this.formBrouillardMois.setBaseLog(this.baseLog);
      this.formBrouillardMois.setStructureLog(this.structureLog);
      this.formBrouillardMois.setUsersLog(this.usersLog);
      this.formBrouillardMois.InstancesDaoUtilses();
      this.formBrouillardMois.setOptionComptabilite(this.optionComptabilite);
      this.formBrouillardMois.setLesModelesAutorises(this.lesModelesAutorises);
      this.formBrouillardMois.setSelectedExo(this.exoselectionne);
      this.formBrouillardMois.setLastExo(this.lastExercice);
      this.formBrouillardMois.setNature(this.nature);
      this.formBrouillardMois.initAnalytique();
      this.formBrouillardMois.chargerLesJournauxComptable(var1);
      this.formBrouillardMois.chargerLesUsers(var1);
      this.formBrouillardMois.calculPeriode(var1);
      this.formBrouillardMois.chargerLesModelesImpresion();
      this.formBrouillardMois.setFormRecherche(this.formRecherche);
      this.formBrouillardMois.setUrlExplorateur(this.urlExplorateur);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuJournauxComptables(Session var1) throws IOException, NamingException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.formJournauxComptables = new FormJournauxComptables();
      this.formJournauxComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxComptables.setBaseLog(this.baseLog);
      this.formJournauxComptables.setStructureLog(this.structureLog);
      this.formJournauxComptables.setUsersLog(this.usersLog);
      this.formJournauxComptables.InstancesDaoUtilses();
      this.formJournauxComptables.setOptionComptabilite(this.optionComptabilite);
      this.formJournauxComptables.setLesModelesAutorises(this.lesModelesAutorises);
      this.formJournauxComptables.setSelectedExo(this.exoselectionne);
      this.formJournauxComptables.setLastExo(this.lastExercice);
      this.formJournauxComptables.setNature(this.nature);
      this.formJournauxComptables.setModeAcces(0);
      this.formJournauxComptables.initAnalytique();
      this.formJournauxComptables.chargerLesJournauxComptable(var1);
      this.formJournauxComptables.calculPeriode();
      this.formJournauxComptables.chargerLesModelesImpresion();
      this.formJournauxComptables.setFormRecherche(this.formRecherche);
      this.formJournauxComptables.setUrlExplorateur(this.urlExplorateur);
      if (!this.menucompta.isAdd() && !this.menucompta.isDup() && !this.menucompta.isMaj() && !this.menucompta.isSup() && !this.menucompta.isTrf() && !this.menucompta.isClo()) {
         this.formJournauxComptables.setModeConsultation(true);
      } else {
         this.formJournauxComptables.setModeConsultation(false);
      }

      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuImputationAnalytique(Session var1) throws IOException, NamingException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.formJournauxComptables = new FormJournauxComptables();
      this.formJournauxComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxComptables.setBaseLog(this.baseLog);
      this.formJournauxComptables.setStructureLog(this.structureLog);
      this.formJournauxComptables.setUsersLog(this.usersLog);
      this.formJournauxComptables.InstancesDaoUtilses();
      this.formJournauxComptables.setOptionComptabilite(this.optionComptabilite);
      this.formJournauxComptables.setLesModelesAutorises(this.lesModelesAutorises);
      this.formJournauxComptables.setSelectedExo(this.exoselectionne);
      this.formJournauxComptables.setLastExo(this.lastExercice);
      this.formJournauxComptables.setNature(this.nature);
      this.formJournauxComptables.initAnalytique();
      this.formJournauxComptables.chargerLesJournauxComptable(var1);
      this.formJournauxComptables.calculPeriode();
      this.formJournauxComptables.chargerLesModelesImpresion();
      this.formJournauxComptables.setFormRecherche(this.formRecherche);
      if (!this.menucompta.isAdd() && !this.menucompta.isDup() && !this.menucompta.isMaj() && !this.menucompta.isSup() && !this.menucompta.isTrf() && !this.menucompta.isClo()) {
         this.formJournauxComptables.setModeConsultation(true);
      } else {
         this.formJournauxComptables.setModeConsultation(false);
      }

      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuClotureJournaux(Session var1) throws IOException, NamingException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.formJournauxComptables = new FormJournauxComptables();
      this.formJournauxComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxComptables.setBaseLog(this.baseLog);
      this.formJournauxComptables.setStructureLog(this.structureLog);
      this.formJournauxComptables.setUsersLog(this.usersLog);
      this.formJournauxComptables.InstancesDaoUtilses();
      this.formJournauxComptables.setOptionComptabilite(this.optionComptabilite);
      this.formJournauxComptables.setLesModelesAutorises(this.lesModelesAutorises);
      this.formJournauxComptables.setSelectedExo(this.exoselectionne);
      this.formJournauxComptables.setLastExo(this.lastExercice);
      this.formJournauxComptables.setNature(this.nature);
      this.formJournauxComptables.initAnalytique();
      this.formJournauxComptables.chargerLesJournauxComptable(var1);
      this.formJournauxComptables.calculPeriode();
      this.formJournauxComptables.chargerLesModelesImpresion();
   }

   public void menuRapprochement(Session var1) throws HibernateException, NamingException {
      this.formRapprochement = new FormRapprochement();
      this.formRapprochement.setutilInitHibernate(this.utilInitHibernate);
      this.formRapprochement.setBaseLog(this.baseLog);
      this.formRapprochement.setStructureLog(this.structureLog);
      this.formRapprochement.setUsersLog(this.usersLog);
      this.formRapprochement.InstancesDaoUtilses();
      this.formRapprochement.setOptionComptabilite(this.optionComptabilite);
      this.formRapprochement.setLesModelesAutorises(this.lesModelesAutorises);
      this.formRapprochement.setSelectedExo(this.exoselectionne);
      this.formRapprochement.setLastExo(this.lastExercice);
      this.formRapprochement.setNature(this.nature);
      this.formRapprochement.chargerLesJournauxComptable(var1);
      this.formRapprochement.calculPeriode();
      this.formRapprochement.chargerLesModelesImpresion();
   }

   public void menuExtraitCompte(Session var1) throws IOException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.formExtraitCompte = new FormExtraitCompte();
      this.formExtraitCompte.setutilInitHibernate(this.utilInitHibernate);
      this.formExtraitCompte.setBaseLog(this.baseLog);
      this.formExtraitCompte.setStructureLog(this.structureLog);
      this.formExtraitCompte.setUsersLog(this.usersLog);
      this.formExtraitCompte.InstancesDaoUtilses();
      this.formExtraitCompte.setOptionComptabilite(this.optionComptabilite);
      this.formExtraitCompte.setLesModelesAutorises(this.lesModelesAutorises);
      this.formExtraitCompte.setSelectedExo(this.exoselectionne);
      this.formExtraitCompte.setLastExo(this.lastExercice);
      this.formExtraitCompte.setNature(this.nature);
      this.formExtraitCompte.chargerLesModelesImpresion();
      this.formExtraitCompte.init();
      this.formExtraitCompte.setFormRecherche(this.formRecherche);
      this.formExtraitCompte.setUrlExplorateur(this.urlExplorateur);
      if (!this.menucompta.isAdd() && !this.menucompta.isDup() && !this.menucompta.isMaj() && !this.menucompta.isSup() && !this.menucompta.isTrf() && !this.menucompta.isClo()) {
         this.formExtraitCompte.setModeConsultation(true);
      } else {
         this.formExtraitCompte.setModeConsultation(false);
      }

      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuExtraitClasse(Session var1) throws IOException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.formExtraitClasse = new FormExtraitClasse();
      this.formExtraitClasse.setutilInitHibernate(this.utilInitHibernate);
      this.formExtraitClasse.setBaseLog(this.baseLog);
      this.formExtraitClasse.setStructureLog(this.structureLog);
      this.formExtraitClasse.setUsersLog(this.usersLog);
      this.formExtraitClasse.InstancesDaoUtilses();
      this.formExtraitClasse.setOptionComptabilite(this.optionComptabilite);
      this.formExtraitClasse.setLesModelesAutorises(this.lesModelesAutorises);
      this.formExtraitClasse.setSelectedExo(this.exoselectionne);
      this.formExtraitClasse.setLastExo(this.lastExercice);
      this.formExtraitClasse.setNature(this.nature);
      this.formExtraitClasse.chargerLesModelesImpresion();
      this.formExtraitClasse.init();
      this.formExtraitClasse.setDecoupageActivite(this.decoupageActivite);
      this.formExtraitClasse.setLaColonne1Items(this.laColonne1Items);
      this.formExtraitClasse.setLaColonne2Items(this.laColonne2Items);
      this.formExtraitClasse.setLaColonne3Items(this.laColonne3Items);
      this.formExtraitClasse.setFormRecherche(this.formRecherche);
      this.formExtraitClasse.setUrlExplorateur(this.urlExplorateur);
      if (!this.menucompta.isAdd() && !this.menucompta.isDup() && !this.menucompta.isMaj() && !this.menucompta.isSup() && !this.menucompta.isTrf() && !this.menucompta.isClo()) {
         this.formExtraitClasse.setModeConsultation(true);
      } else {
         this.formExtraitClasse.setModeConsultation(false);
      }

      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuExtraitAnalytique(Session var1) throws IOException, org.apache.taglibs.standard.extra.spath.ParseException, HibernateException, NamingException {
      this.formExtraitAnalList = new FormExtraitAnalList();
      this.formExtraitAnalList.setutilInitHibernate(this.utilInitHibernate);
      this.formExtraitAnalList.setBaseLog(this.baseLog);
      this.formExtraitAnalList.setStructureLog(this.structureLog);
      this.formExtraitAnalList.setUsersLog(this.usersLog);
      this.formExtraitAnalList.InstancesDaoUtilses();
      this.formExtraitAnalList.setOptionComptabilite(this.optionComptabilite);
      this.formExtraitAnalList.setLesModelesAutorises(this.lesModelesAutorises);
      this.formExtraitAnalList.setSelectedExo(this.exoselectionne);
      this.formExtraitAnalList.setLastExo(this.lastExercice);
      this.formExtraitAnalList.setNature(this.nature);
      this.formExtraitAnalList.chargerLesModelesImpresion();
      this.formExtraitAnalList.init();
      this.formExtraitAnalList.setFormRecherche(this.formRecherche);
      this.formExtraitAnalList.setDecoupageActivite(this.decoupageActivite);
      this.formExtraitAnalList.setLaColonne1Items(this.laColonne1Items);
      this.formExtraitAnalList.setLaColonne2Items(this.laColonne2Items);
      this.formExtraitAnalList.setLaColonne3Items(this.laColonne3Items);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuExtraitProjet(Session var1) throws IOException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.formExtraitProjet = new FormExtraitProjet();
      this.formExtraitProjet.setutilInitHibernate(this.utilInitHibernate);
      this.formExtraitProjet.setBaseLog(this.baseLog);
      this.formExtraitProjet.setStructureLog(this.structureLog);
      this.formExtraitProjet.setUsersLog(this.usersLog);
      this.formExtraitProjet.InstancesDaoUtilses();
      this.formExtraitProjet.setOptionComptabilite(this.optionComptabilite);
      this.formExtraitProjet.setLesModelesAutorises(this.lesModelesAutorises);
      this.formExtraitProjet.setSelectedExo(this.exoselectionne);
      this.formExtraitProjet.setLastExo(this.lastExercice);
      this.formExtraitProjet.setNature(this.nature);
      this.formExtraitProjet.chargerLesModelesImpresion();
      this.formExtraitProjet.init();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuExtraitBudget(Session var1) throws IOException, org.apache.taglibs.standard.extra.spath.ParseException, HibernateException, NamingException {
      this.formExtraitBudget = new FormExtraitBudget();
      this.formExtraitBudget.setutilInitHibernate(this.utilInitHibernate);
      this.formExtraitBudget.setBaseLog(this.baseLog);
      this.formExtraitBudget.setStructureLog(this.structureLog);
      this.formExtraitBudget.setUsersLog(this.usersLog);
      this.formExtraitBudget.InstancesDaoUtilses();
      this.formExtraitBudget.setOptionComptabilite(this.optionComptabilite);
      this.formExtraitBudget.setLesModelesAutorises(this.lesModelesAutorises);
      this.formExtraitBudget.setSelectedExo(this.exoselectionne);
      this.formExtraitBudget.setLastExo(this.lastExercice);
      this.formExtraitBudget.setNature(this.nature);
      this.formExtraitBudget.initAnalytique();
      this.formExtraitBudget.calculAnnee();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void menuImpressionGenerale(Session var1) throws HibernateException, NamingException, ParseException, IOException {
      this.formImpressionGenerale = new FormImpressionGenerale();
      this.formImpressionGenerale.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionGenerale.setBaseLog(this.baseLog);
      this.formImpressionGenerale.setStructureLog(this.structureLog);
      this.formImpressionGenerale.setUsersLog(this.usersLog);
      this.formImpressionGenerale.InstancesDaoUtilses();
      this.formImpressionGenerale.setExoSelectionne(this.exoselectionne);
      this.formImpressionGenerale.setOptionComptabilite(this.optionComptabilite);
      this.formImpressionGenerale.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionGenerale.chargerLesRepImpCompta(var1);
      this.formImpressionGenerale.chargerLesPCetJC(var1);
      this.formImpressionGenerale.calculerMoisExercice(var1);
      this.formImpressionGenerale.initImpression();
      this.formImpressionGenerale.chargerPeriodes();
      this.formImpressionGenerale.setUrlExplorateur(this.urlExplorateur);
   }

   public void menuImpressionAnalytique(Session var1) throws HibernateException, NamingException, ParseException, IOException {
      this.formImpressionAnalytique = new FormImpressionAnalytique();
      this.formImpressionAnalytique.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionAnalytique.setBaseLog(this.baseLog);
      this.formImpressionAnalytique.setStructureLog(this.structureLog);
      this.formImpressionAnalytique.setUsersLog(this.usersLog);
      this.formImpressionAnalytique.InstancesDaoUtilses();
      this.formImpressionAnalytique.setExoSelectionne(this.exoselectionne);
      this.formImpressionAnalytique.setOptionComptabilite(this.optionComptabilite);
      this.formImpressionAnalytique.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionAnalytique.chargerLesRepImpCompta(var1);
      this.formImpressionAnalytique.calculeAnalytique();
      this.recupererImpressionItems(var1);
      this.formImpressionAnalytique.chargerLesPCetJC(var1);
      this.formImpressionAnalytique.calculerMoisExercice(var1);
      this.formImpressionAnalytique.initImpression(var1);
      this.formImpressionAnalytique.chargerPeriodes();
   }

   public void menuImpressionProjet(Session var1) throws HibernateException, NamingException {
      this.formImpressionProjet = new FormImpressionProjet();
      this.formImpressionProjet.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionProjet.setBaseLog(this.baseLog);
      this.formImpressionProjet.setStructureLog(this.structureLog);
      this.formImpressionProjet.setUsersLog(this.usersLog);
      this.formImpressionProjet.InstancesDaoUtilses();
      this.formImpressionProjet.setExoSelectionne(this.exoselectionne);
      this.formImpressionProjet.setOptionComptabilite(this.optionComptabilite);
      this.formImpressionProjet.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionProjet.chargerLesRepImpCompta(var1);
      this.formImpressionProjet.chargerLesPCetJC(var1);
      this.formImpressionProjet.calculerMoisExercice(var1);
      this.formImpressionProjet.initImpression();
   }

   public void menuTableaux(Session var1) throws NamingException, HibernateException, IOException {
      this.menucompta.setAdd(true);
      this.menucompta.setMaj(true);
      this.menucompta.setSup(true);
      this.menucompta.setDup(true);
      this.menucompta.setClo(true);
      this.menucompta.setTrf(true);
      this.formEtatFinancierExploitation = new FormEtatFinancierExploitation();
      this.formEtatFinancierExploitation.setutilInitHibernate(this.utilInitHibernate);
      this.formEtatFinancierExploitation.setBaseLog(this.baseLog);
      this.formEtatFinancierExploitation.setStructureLog(this.structureLog);
      this.formEtatFinancierExploitation.setUsersLog(this.usersLog);
      this.formEtatFinancierExploitation.setSelectedExo(this.exoselectionne);
      this.formEtatFinancierExploitation.setLastExo(this.lastExercice);
      this.formEtatFinancierExploitation.setNature(this.nature);
      this.formEtatFinancierExploitation.InstancesDaoUtilses();
      this.formEtatFinancierExploitation.setOptionComptabilite(this.optionComptabilite);
      this.formEtatFinancierExploitation.setLesModelesAutorises(this.lesModelesAutorises);
      this.formEtatFinancierExploitation.chargerMesracines();
      this.formEtatFinancierExploitation.chargerMesTabNom(this.nature, var1);
   }

   public void menuImpressionBalancesInteractives(Session var1) throws HibernateException, NamingException {
      this.formImpressionGenerale = new FormImpressionGenerale();
      this.formImpressionGenerale.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionGenerale.setBaseLog(this.baseLog);
      this.formImpressionGenerale.setStructureLog(this.structureLog);
      this.formImpressionGenerale.setUsersLog(this.usersLog);
      this.formImpressionGenerale.InstancesDaoUtilses();
      this.formImpressionGenerale.setExoSelectionne(this.exoselectionne);
      this.formImpressionGenerale.setOptionComptabilite(this.optionComptabilite);
      this.formImpressionGenerale.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionGenerale.chargerLesPCetJC(var1);
      this.formImpressionGenerale.calculerMoisExercice(var1);
      this.formImpressionGenerale.initBalancesInteractives(var1);
   }

   public void menuDocuentsOfficiels() throws IOException, HibernateException, NamingException {
      this.formDocumentsOfficiels.ouvrirDocument();
   }

   public void menuSelectionExercicesCompta() throws IOException, JDOMException, NamingException {
      this.formExercicesComptables = new FormExercicesComptables();
      this.formExercicesComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesComptables.setBaseLog(this.baseLog);
      this.formExercicesComptables.setStructureLog(this.structureLog);
      this.formExercicesComptables.setUsersLog(this.usersLog);
      this.formExercicesComptables.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExecpt_id();
      this.formExercicesComptables.setLesexercicesComptables(this.formExercicesComptables.recupererLesexercices((Session)null));
   }

   public void importationEcritures() throws HibernateException, NamingException {
      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setNature(this.nature);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.initImportation();
      this.listFiles = new ArrayList();
      this.uploadsAvailable = 1;
   }

   public void retourCompta() {
      this.affichePage = "/comptabilite/Vide.jsp";
   }

   public void accesJournauxExtraitCompte() throws IOException, NamingException, HibernateException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
      this.formJournauxComptables = new FormJournauxComptables();
      this.formJournauxComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxComptables.setBaseLog(this.baseLog);
      this.formJournauxComptables.setStructureLog(this.structureLog);
      this.formJournauxComptables.setUsersLog(this.usersLog);
      this.formJournauxComptables.InstancesDaoUtilses();
      this.formJournauxComptables.setOptionComptabilite(this.optionComptabilite);
      this.formJournauxComptables.setSelectedExo(this.exoselectionne);
      this.formJournauxComptables.setLastExo(this.lastExercice);
      this.formJournauxComptables.setNature(this.nature);
      this.formJournauxComptables.setModeAcces(1);
      this.formJournauxComptables.initAnalytique();
      this.formJournauxComptables.calculerLesJournauxComptable(this.formExtraitCompte.recupereJournal(), var1);
      this.formJournauxComptables.calculUnJournal(this.formExtraitCompte.recupereJournal());
      this.formJournauxComptables.calculUnePeriode(this.formExtraitCompte.recuperePeriode());
      this.formJournauxComptables.calculUnePiece(this.formExtraitCompte.recuperePiece());
      this.formJournauxComptables.chargerLesModelesImpresion();
      this.formJournauxComptables.setFormRecherche(this.formRecherche);
      boolean var2 = false;
      var2 = this.formJournauxComptables.ouvrirAPartirExtraitCompte();
      if (var2) {
         this.formExtraitCompte.ouvrirJournal();
      } else {
         this.formExtraitCompte.ouvrirJournalErreur();
      }

      this.utilInitHibernate.closeSession();
   }

   public void accesJournauxExtraitClasse() throws IOException, NamingException, HibernateException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
      this.formJournauxComptables = new FormJournauxComptables();
      this.formJournauxComptables.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxComptables.setBaseLog(this.baseLog);
      this.formJournauxComptables.setStructureLog(this.structureLog);
      this.formJournauxComptables.setUsersLog(this.usersLog);
      this.formJournauxComptables.InstancesDaoUtilses();
      this.formJournauxComptables.setOptionComptabilite(this.optionComptabilite);
      this.formJournauxComptables.setSelectedExo(this.exoselectionne);
      this.formJournauxComptables.setLastExo(this.lastExercice);
      this.formJournauxComptables.setNature(this.nature);
      this.formJournauxComptables.setModeAcces(2);
      this.formJournauxComptables.initAnalytique();
      this.formJournauxComptables.calculerLesJournauxComptable(this.formExtraitClasse.recupereJournal(), var1);
      this.formJournauxComptables.calculUnJournal(this.formExtraitClasse.recupereJournal());
      this.formJournauxComptables.calculUnePeriode(this.formExtraitClasse.recuperePeriode());
      this.formJournauxComptables.calculUnePiece(this.formExtraitClasse.recuperePiece());
      this.formJournauxComptables.chargerLesModelesImpresion();
      this.formJournauxComptables.setFormRecherche(this.formRecherche);
      boolean var2 = false;
      var2 = this.formJournauxComptables.ouvrirAPartirExtraitCompte();
      if (var2) {
         this.formExtraitClasse.ouvrirJournal();
      } else {
         this.formExtraitClasse.ouvrirJournalErreur();
      }

      this.utilInitHibernate.closeSession();
   }

   public void fermerJournauxExtraitErreur() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formExtraitCompte.fermerJournal();
   }

   public void fermerJournauxExtrait() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formJournauxComptables.fermerLeJournalEncours();
      if (this.formExtraitCompte != null) {
         this.formExtraitCompte.fermerJournal();
      } else if (this.formExtraitClasse != null) {
         this.formExtraitClasse.fermerJournal();
      }

   }

   public void menuGroupeListesociété() throws HibernateException, NamingException {
      this.showButtonModif = false;
      new ArrayList();
      this.lesStructuresGrp.clear();
      if (this.structureLog.getStrmaitrecabinet() != 0) {
         Session var2 = this.utilInitHibernate.getLoginEpegase();
         Query var3 = var2.createQuery("from StructurePeg where strId=:idStr").setLong("idStr", this.structureLog.getStrid());
         List var1 = var3.list();
         if (var1.size() != 0) {
            long var4 = ((StructurePeg)var1.get(0)).getCabinetPeg().getCabId();
            if (var4 != 0L) {
               var3 = var2.createQuery("from StructurePeg where cabinetPeg.cabId=:idCab and strmaitrecabinet=0)").setLong("idCab", var4);
               this.lesStructuresGrp = var3.list();
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.dataModelSociete.setWrappedData(this.lesStructuresGrp);
   }

   public void selectionStructure() {
      if (this.dataModelSociete.isRowAvailable()) {
         this.structurePeg = (StructurePeg)this.dataModelSociete.getRowData();
         this.showButtonModif = true;
      }

   }

   public void modifierStructure() {
      if (this.structurePeg != null) {
         this.showModalPanelStructure = true;
      }

   }

   public void annulerStructure() {
      this.showButtonModif = false;
      this.showModalPanelStructure = false;
   }

   public void validerStructure() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getLoginEpegase();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.update(this.structurePeg);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelStructure = false;
   }

   public void majStructure() throws HibernateException, NamingException {
      if (this.lesStructuresGrp.size() != 0) {
         new PlansAnalytiques();

         for(int var2 = 0; var2 < this.lesStructuresGrp.size(); ++var2) {
            this.structurePeg = (StructurePeg)this.lesStructuresGrp.get(var2);
            long var3 = this.structurePeg.getStrId();
            String var5 = "structure" + this.structurePeg.getStrId();
            Session var6 = this.utilInitHibernate.getOpenSession(var5, "PlansAnalytiques");
            Transaction var7 = null;

            try {
               var7 = var6.beginTransaction();
               new StructurePeg();

               for(int var9 = 0; var9 < this.lesStructuresGrp.size(); ++var9) {
                  StructurePeg var8 = (StructurePeg)this.lesStructuresGrp.get(var9);
                  if (var8.getStrId() != var3) {
                     StructureDao var10 = new StructureDao(var5, this.utilInitHibernate);
                     new Structure();
                     Structure var11 = var10.logStructureId(var3, var6);
                     if (var11 != null) {
                        if (this.structurePeg.getCabinetPeg() != null) {
                           var11.setStrmaitrecabinet(this.structureLog.getStrmaitrecabinet() + 10);
                        } else {
                           var11.setStrmaitrecabinet(0);
                        }

                        var10.modStructure(var11, var6);
                     }

                     PlansAnalytiquesDao var12 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
                     PlansAnalytiques var1 = var12.rechercheAnal("20", var8.getStrsigle(), var6);
                     if (var1 != null) {
                        var1.setAnaNatureRepartition(201);
                        var1.setAnaNomFr(var8.getStrraisonsociale());
                        var1.setAnaAch(true);
                        var1.setAnaFrg(true);
                        var1.setAnaInv(true);
                        var1.setAnaPrd(true);
                        var1.setAnaSal(true);
                        var1.setAnaTax(true);
                        var1.setAnaTva(true);
                        var1.setAnaVte(true);
                        var1.setAnaStr(true);
                        var1.setAnaDateModif(new Date());
                        var1.setAnaUserModif(this.usersLog.getUsrid());
                        var12.modif(var1, var6);
                     } else {
                        var1 = new PlansAnalytiques();
                        var1.setAnaCode(var8.getStrsigle());
                        var1.setAnaNature("20");
                        var1.setAnaNatureRepartition(201);
                        var1.setAnaNomFr(var8.getStrraisonsociale());
                        var1.setAnaAch(true);
                        var1.setAnaFrg(true);
                        var1.setAnaInv(true);
                        var1.setAnaPrd(true);
                        var1.setAnaSal(true);
                        var1.setAnaTax(true);
                        var1.setAnaTva(true);
                        var1.setAnaVte(true);
                        var1.setAnaStr(true);
                        var1.setAnaDateCreat(new Date());
                        var1.setAnaUserCreat(this.usersLog.getUsrid());
                        var12.insert(var1, var6);
                     }
                  }
               }

               var7.commit();
            } catch (HibernateException var16) {
               if (var7 != null) {
                  var7.rollback();
               }

               throw var16;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void menuGroupeCleRepartition() throws HibernateException, NamingException {
      if (this.lesStructuresGrp.size() == 0) {
         this.menuGroupeListesociété();
      }

      this.formPlansAnalytiques = new FormPlansAnalytiques();
      this.formPlansAnalytiques.setutilInitHibernate(this.utilInitHibernate);
      this.formPlansAnalytiques.setBaseLog(this.baseLog);
      this.formPlansAnalytiques.setStructureLog(this.structureLog);
      this.formPlansAnalytiques.setUsersLog(this.usersLog);
      this.formPlansAnalytiques.InstancesDaoUtilses();
      this.formPlansAnalytiques.setLastExercice(this.lastExercice);
      this.formPlansAnalytiques.setExoSelectionne(this.exoselectionne);
      this.formPlansAnalytiques.recupererClesStructure();
      this.formPlansAnalytiques.setLesStructures(this.lesStructuresGrp);
   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException {
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.importationFichier();
   }

   public void importationFichier() throws NamingException, HibernateException, ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               String var3 = ((FileCtrl)this.listFiles.get(var2)).getName();
               File var4 = new File(this.fileCtrl.getChemin());
               if (var4.exists()) {
                  FileReader var5 = new FileReader(var4);
                  BufferedReader var6 = new BufferedReader(var5);
                  boolean var7 = false;
                  if (!var3.toString().endsWith("xls") && !var3.toString().endsWith("xlsx") && !var3.toString().endsWith("XLS") && !var3.toString().endsWith("XLSX")) {
                     for(String var8 = var6.readLine(); var8 != null; var8 = var6.readLine()) {
                        if (var8 != null && !var8.isEmpty()) {
                           if (var8.contains("#MECG") || var8.contains("#IIMO") || var8.contains("#MPLG") || var8.contains("#MPCT") || var8.contains("#MCJR") || var8.contains("#MIVA")) {
                              var7 = true;
                           }

                           if (var8.contains("\"")) {
                              char[] var9 = var8.toCharArray();
                              String var10 = "";

                              for(int var11 = 0; var11 < var9.length; ++var11) {
                                 if (var9[var11] != '"') {
                                    var10 = var10 + var9[var11];
                                 }
                              }

                              var8 = var10;
                           }

                           if (var7 && var8.contains(",")) {
                              var8.replace(",", ".");
                           }

                           if (var8.contains("'")) {
                              var8.replace("'", "`");
                           }

                           var1.add(var8);
                        } else {
                           var1.add(var8);
                        }
                     }
                  } else {
                     var1.add(var3.toString() + ":" + var4);
                  }

                  var6.close();
                  var5.close();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertImport(var1);
         }
      } catch (IOException var12) {
         var12.printStackTrace();
      }

   }

   public void importFtp() {
   }

   public void preparationTransfertAmortissement() throws HibernateException, NamingException, IOException, SAXException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formAmortissements.transfertElement();
      this.formAmortissements.closeModalPanel();
      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertImmobilisation(this.formAmortissements.getLesTransfertCompta());
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("amortissement");
   }

   public void preparationTransfertLoyer() throws IOException, NamingException, SAXException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formLoyers.transfertElement();
      this.formLoyers.closeModalPanel();
      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertLoyer(this.formLoyers.getLesTransfertCompta());
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("loyer");
   }

   public void preparationTransfertAchats(List var1) throws IOException, NamingException, JDOMException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.recupererClesItem((Session)null);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertAchat(var1);
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("achat");
   }

   public void preparationTransfertVentes(List var1) throws IOException, NamingException, JDOMException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertVentes(var1);
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("vente");
   }

   public void preparationTransfertImmobilier(List var1) throws IOException, NamingException, JDOMException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertImmobilier(var1);
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("immobilier");
   }

   public void preparationTransfertMedical(List var1) throws IOException, NamingException, JDOMException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertMedical(var1);
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("medical");
   }

   public void preparationTransfertCaisse(List var1) throws IOException, NamingException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertCaisse(var1);
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("caisse");
   }

   public void preparationTransfertPaye(List var1) throws IOException, NamingException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertPaye(var1);
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("paye");
   }

   public void preparationTransfertImport(List var1) throws IOException, NamingException, HibernateException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formTransfertCompta = new FormTransfertCompta();
      this.formTransfertCompta.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCompta.setBaseLog(this.baseLog);
      this.formTransfertCompta.setStructureLog(this.structureLog);
      this.formTransfertCompta.setUsersLog(this.usersLog);
      this.formTransfertCompta.InstancesDaoUtilses();
      this.formTransfertCompta.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCompta.setExercicesComptable(this.exoselectionne);
      this.formTransfertCompta.setFormRecherche(this.formRecherche);
      this.formTransfertCompta.transfertImport(var1);
      this.formTransfertCompta.setPljFormatDevise(this.structureLog.getStrformatdevise());
      this.formTransfertCompta.chargerLesModelesImpresion();
      this.affichePage = "/comptabilite/TransfertComptaInit.jsp";
      this.setQuelTransfert("importExterne");
   }

   public void transfertCompta() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.chargerLesActivitesItems((Session)null);
      this.formTransfertCompta.getFormTransfertCtrl().setDecoupageActivite(this.decoupageActivite);
      if (this.getQuelTransfert().equalsIgnoreCase("amortissement")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaImmo();
         this.formAmortissements.traitementApresTransfert();
      } else if (this.getQuelTransfert().equalsIgnoreCase("loyer")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaLoyer();
         this.formLoyers.traitementApresTransfert();
      } else if (this.getQuelTransfert().equalsIgnoreCase("achat")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaAchats();
      } else if (this.getQuelTransfert().equalsIgnoreCase("vente")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaVentes();
      } else if (this.getQuelTransfert().equalsIgnoreCase("immobilier")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaImmobilier();
      } else if (this.getQuelTransfert().equalsIgnoreCase("medical")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaMedical();
      } else if (this.getQuelTransfert().equalsIgnoreCase("caisse")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaCaisse();
      } else if (this.getQuelTransfert().equalsIgnoreCase("paye")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationComptaPaye();
      } else if (this.getQuelTransfert().equalsIgnoreCase("importExterne")) {
         this.formTransfertCompta.getFormTransfertCtrl().generationImportation();
      }

      this.formTransfertCompta.getFormTransfertCtrl().genererMajJournauxMois();
      this.affichePage = "/comptabilite/Vide.jsp";
      this.setQuelTransfert(" ");
      StaticModePegase.setTexte_message("Opération de transfert en comptabilité complète...");
      StaticModePegase.setAffiche_message(true);
   }

   public void exportCompta() throws IOException, JDOMException, HibernateException, NamingException, FileNotFoundException, WriteException {
      this.numRecup = this.formTransfertCompta.exportationEcritures(this.urlExplorateur);
   }

   public void exportComptaSuite() throws IOException, JDOMException, HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      if (this.numRecup != null && !this.numRecup.isEmpty()) {
         if (this.numRecup.contains(":")) {
            String[] var3 = this.numRecup.split(":");
            var1 = var3[0];
            var2 = var3[1];
         } else {
            var1 = null;
            var2 = this.numRecup;
         }
      } else {
         var1 = null;
         var2 = "Transfert interrompu : le fichier d'exportation n'a pas été créé!";
      }

      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals("00000")) {
            var1 = "";
         }

         if (this.getQuelTransfert().equalsIgnoreCase("amortissement")) {
            this.formAmortissements.traitementApresTransfert();
         } else if (this.getQuelTransfert().equalsIgnoreCase("loyer")) {
            this.formLoyers.traitementApresTransfert();
         } else {
            Session var33;
            Transaction var4;
            if (this.getQuelTransfert().equalsIgnoreCase("achat")) {
               var33 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresAchats");
               var4 = null;

               try {
                  var4 = var33.beginTransaction();
                  this.formTransfertCompta.getFormTransfertCtrl().traitementApresTransfertAchats(var33, var1);
                  var4.commit();
               } catch (HibernateException var29) {
                  if (var4 != null) {
                     var4.rollback();
                  }

                  throw var29;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else if (this.getQuelTransfert().equalsIgnoreCase("vente")) {
               var33 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresVentes");
               var4 = null;

               try {
                  var4 = var33.beginTransaction();
                  this.formTransfertCompta.getFormTransfertCtrl().traitementApresTransfertVente(var33, var1);
                  var4.commit();
               } catch (HibernateException var27) {
                  if (var4 != null) {
                     var4.rollback();
                  }

                  throw var27;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else if (this.getQuelTransfert().equalsIgnoreCase("caisse")) {
               var33 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCaisse");
               var4 = null;

               try {
                  var4 = var33.beginTransaction();
                  this.formTransfertCompta.getFormTransfertCtrl().traitementApresTransfertCaisse(var33, var1);
                  var4.commit();
               } catch (HibernateException var31) {
                  if (var4 != null) {
                     var4.rollback();
                  }

                  throw var31;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else if (this.getQuelTransfert().equalsIgnoreCase("importExterne")) {
            }
         }
      }

      this.affichePage = "/comptabilite/Vide.jsp";
      this.setQuelTransfert(" ");
      StaticModePegase.setTexte_message(var2);
      StaticModePegase.setAffiche_message(true);
   }

   public void recupererTousLesItems(Session var1) throws IOException, HibernateException, NamingException {
      this.recupererModelesAutorises();
      if (this.modulesCode.equals("40300")) {
         this.chargerLesProjetsItems(var1);
      }

      this.recupererAxesAnalytiques();
   }

   public void recupererImpressionItems(Session var1) throws IOException, HibernateException, NamingException {
      this.chargerLesActivitesItems(var1);
      this.chargerLesSitesItems(var1);
      this.chargerLesRegionsItems(var1);
      this.recupererDossierItem(var1);
      this.recupererMissionItem(var1);
      this.recupererChantierItem(var1);
      this.recupererParcItem(var1);
      this.recupererClesItem(var1);
      this.recupererStructuresItem(var1);
      this.recupererAgentItem(var1);
      if (this.optionComptabilite.getBudget().equalsIgnoreCase("true")) {
         this.chargerLesPlansBudgetairesItems(var1);
      }

      if (this.modulesCode.equals("40300")) {
         this.chargerLesProjetsItems(var1);
      }

      this.recupererAxesAnalytiques();
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
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void chargerLesSitesItems(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      if (this.structureLog.isStrSite()) {
         this.mesSitesItems = this.siteDao.chargerLesSitesItems(var1);
      }

   }

   public void chargerLesRegionsItems(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      if (this.structureLog.isStrRegion()) {
         this.mesRegionsItems = this.regionDao.chargerLesRegionItems(var1);
      }

   }

   public void chargerLesPlansBudgetairesItems(Session var1) throws HibernateException, NamingException {
      this.mesPlansBudgetsItems = new ArrayList();
      this.mesPlansBudgetsItems = this.plansBudgetairesDao.chargerLesPlansBudgets(0, var1);
   }

   public void chargerLesActivitesItems(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      this.laColonne1Items = new ArrayList();
      this.laColonne2Items = new ArrayList();
      this.laColonne3Items = new ArrayList();
      if (this.structureLog.isStrActivite()) {
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.decoupageActivite = true;
         } else {
            this.decoupageActivite = false;
         }

         if (this.decoupageActivite) {
            if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
               this.laColonne1Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
            }

            if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
               this.laColonne2Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
            }

            if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
               this.laColonne3Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
            }
         } else {
            this.mesActivitesItems = this.activitesDao.chargerLesActivites(var1);
         }
      } else {
         this.decoupageActivite = false;
      }

   }

   public void chargerLesProjetsItems(Session var1) throws HibernateException, NamingException {
      this.mesProjetsItems = new ArrayList();
      if (this.structureLog.isStrProjet()) {
         this.mesProjetsItems = this.projetsDao.chargerLesProjets(0, var1);
      }

   }

   public void recupererDossierItem(Session var1) throws HibernateException, NamingException {
      this.mesDossiersItems = new ArrayList();
      if (this.structureLog.getStrDossier() != 0) {
         this.mesDossiersItems = this.analytiqueDao.chargerLesAnalytiques("6", var1);
      }

   }

   public void recupererMissionItem(Session var1) throws HibernateException, NamingException {
      this.mesMissionsItems = new ArrayList();
      if (this.structureLog.isStrMission()) {
         this.mesMissionsItems = this.analytiqueDao.chargerLesAnalytiques("8", var1);
      }

   }

   public void recupererChantierItem(Session var1) throws HibernateException, NamingException {
      this.mesChantiersItems = new ArrayList();
      if (this.structureLog.isStrChantier()) {
         this.mesChantiersItems = this.analytiqueDao.chargerLesAnalytiques("7", var1);
      }

   }

   public void recupererStructuresItem(Session var1) throws HibernateException, NamingException {
      this.mesStructuresItems = new ArrayList();
      if (this.structureLog.isStrStructure()) {
         this.mesStructuresItems = this.analytiqueDao.chargerLesAnalytiques("20", var1);
      }

   }

   public void recupererParcItem(Session var1) throws HibernateException, NamingException {
      this.mesParcsItems = new ArrayList();
      if (this.structureLog.isStrParc()) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         this.mesParcsItems = var2.chargerLesParcs(var1);
      }

   }

   public void recupererClesItem(Session var1) throws HibernateException, NamingException {
      this.mesClesItems = new ArrayList();
      if (this.structureLog.isStrCles()) {
         this.mesClesItems = this.analytiqueDao.chargerLesAnalytiques("9", var1);
      }

   }

   public void recupererAgentItem(Session var1) throws HibernateException, NamingException {
      this.mesAgentsItems = new ArrayList();
      if (this.structureLog.isStrAgent()) {
         SalariesDao var2 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         this.mesAgentsItems = var2.chargerlesSalariesActifItem("", var1);
      }

   }

   public void recupererAxesAnalytiques() {
      this.mesAxesAnalytique.clear();
      if (this.structureLog.isStrSite()) {
         this.mesAxesAnalytique.add(new SelectItem(100, "Sites-Départements-Services"));
      }

      if (this.structureLog.isStrRegion()) {
         this.mesAxesAnalytique.add(new SelectItem(101, "Régions-Secteurs-Points de vente"));
      }

      if (this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && this.structureLog.getStrtypeentreprise().equals("2") && this.structureLog.isStrUsine()) {
         this.mesAxesAnalytique.add(new SelectItem(102, "Sites-Ateliers-Lignes"));
      }

      if (this.structureLog.isStrActivite()) {
         this.mesAxesAnalytique.add(new SelectItem(110, "Activités"));
      }

      if (this.rechercheModule(70000) && this.structureLog.isStrParc()) {
         this.mesAxesAnalytique.add(new SelectItem(120, "Parcs"));
      }

      if (this.structureLog.getStrDossier() != 0) {
         this.mesAxesAnalytique.add(new SelectItem(6, "Dossiers"));
      }

      if (this.rechercheModule(50000) && this.structureLog.isStrAgent()) {
         this.mesAxesAnalytique.add(new SelectItem(122, "Agents"));
      }

      if (this.structureLog.isStrChantier()) {
         this.mesAxesAnalytique.add(new SelectItem(7, "Chantiers"));
      }

      if (this.structureLog.isStrMission()) {
         this.mesAxesAnalytique.add(new SelectItem(8, "Missions"));
      }

      if (this.rechercheModule(40300) && this.structureLog.isStrProjet()) {
         this.mesAxesAnalytique.add(new SelectItem(130, "Projets"));
      }

      if (this.structureLog.isStrCles()) {
         this.mesAxesAnalytique.add(new SelectItem(9, "Clés répartitions"));
      }

      if (this.structureLog.isStrStructure()) {
         this.mesAxesAnalytique.add(new SelectItem(200, "Clés répartitions structure"));
         this.mesAxesAnalytique.add(new SelectItem(201, "Axes structure"));
      }

   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
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

   public void recupererConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeEntete = var1.getConfigListeEntete();
   }

   public void memoriseConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeEntete);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
      }

   }

   public void recupererConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeLigne = var1.getConfigListeLigne();
   }

   public void memoriseConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeLigne);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
      }

   }

   public FormExtraitCompte getFormExtraitCompte() {
      return this.formExtraitCompte;
   }

   public void setFormExtraitCompte(FormExtraitCompte var1) {
      this.formExtraitCompte = var1;
   }

   public FormBrouillardsComptables getFormBrouillardMois() {
      return this.formBrouillardMois;
   }

   public void setFormBrouillardMois(FormBrouillardsComptables var1) {
      this.formBrouillardMois = var1;
   }

   public FormEtatFinancierExploitation getFormEtatFinancierExploitation() {
      return this.formEtatFinancierExploitation;
   }

   public void setFormEtatFinancierExploitation(FormEtatFinancierExploitation var1) {
      this.formEtatFinancierExploitation = var1;
   }

   public FormTransfertCompta getFormTransfertCompta() {
      return this.formTransfertCompta;
   }

   public void setFormTransfertCompta(FormTransfertCompta var1) {
      this.formTransfertCompta = var1;
   }

   public FormLoyers getFormLoyers() {
      return this.formLoyers;
   }

   public void setFormLoyers(FormLoyers var1) {
      this.formLoyers = var1;
   }

   public String getQuelTransfert() {
      return this.quelTransfert;
   }

   public void setQuelTransfert(String var1) {
      this.quelTransfert = var1;
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

   public boolean isTestAffAjout() {
      return this.testAffAjout;
   }

   public void setTestAffAjout(boolean var1) {
      this.testAffAjout = var1;
   }

   public boolean isTestAffModif() {
      return this.testAffModif;
   }

   public void setTestAffModif(boolean var1) {
      this.testAffModif = var1;
   }

   public boolean isTestAffSupp() {
      return this.testAffSupp;
   }

   public void setTestAffSupp(boolean var1) {
      this.testAffSupp = var1;
   }

   public boolean isTestAffTrf() {
      return this.testAffTrf;
   }

   public void setTestAffTrf(boolean var1) {
      this.testAffTrf = var1;
   }

   public boolean isDisable() {
      return this.disable;
   }

   public void setDisable(boolean var1) {
      this.disable = var1;
   }

   public FormChronoCpta getFormChronoCpta() {
      return this.formChronoCpta;
   }

   public void setFormChronoCpta(FormChronoCpta var1) {
      this.formChronoCpta = var1;
   }

   public String getModulesCode() {
      return this.modulesCode;
   }

   public void setModulesCode(String var1) {
      this.modulesCode = var1;
   }

   public FormImpressionAnalytique getFormImpressionAnalytique() {
      return this.formImpressionAnalytique;
   }

   public void setFormImpressionAnalytique(FormImpressionAnalytique var1) {
      this.formImpressionAnalytique = var1;
   }

   public FormImpressionGenerale getFormImpressionGenerale() {
      return this.formImpressionGenerale;
   }

   public void setFormImpressionGenerale(FormImpressionGenerale var1) {
      this.formImpressionGenerale = var1;
   }

   public FormExtraitAnalList getFormExtraitAnalList() {
      return this.formExtraitAnalList;
   }

   public void setFormExtraitAnalList(FormExtraitAnalList var1) {
      this.formExtraitAnalList = var1;
   }

   public FormExtraitClasse getFormExtraitClasse() {
      return this.formExtraitClasse;
   }

   public void setFormExtraitClasse(FormExtraitClasse var1) {
      this.formExtraitClasse = var1;
   }

   public FormBudget getFormBudget() {
      return this.formBudget;
   }

   public void setFormBudget(FormBudget var1) {
      this.formBudget = var1;
   }

   public FormAmortissements getFormAmortissements() {
      return this.formAmortissements;
   }

   public void setFormAmortissements(FormAmortissements var1) {
      this.formAmortissements = var1;
   }

   public LectureNatureCompte getNatureCompte() {
      return this.natureCompte;
   }

   public void setNatureCompte(LectureNatureCompte var1) {
      this.natureCompte = var1;
   }

   public void instanceOptionMedical() {
   }

   public LireLesoptionsCompta getLireLesoptionsCompta() {
      return this.lireLesoptionsCompta;
   }

   public void setLireLesoptionsCompta(LireLesoptionsCompta var1) {
      this.lireLesoptionsCompta = var1;
   }

   public MenudroitComptabiliteCtrl getMenudroitComptabiliteCtrl() {
      return this.menudroitComptabiliteCtrl;
   }

   public void setMenudroitComptabiliteCtrl(MenudroitComptabiliteCtrl var1) {
      this.menudroitComptabiliteCtrl = var1;
   }

   public FormExercicesComptables getFormExercicesComptables() {
      return this.formExercicesComptables;
   }

   public void setFormExercicesComptables(FormExercicesComptables var1) {
      this.formExercicesComptables = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public ObjetLigneMenu getMenucompta() {
      return this.menucompta;
   }

   public void setMenucompta(ObjetLigneMenu var1) {
      this.menucompta = var1;
   }

   public FormJournauxComptables getFormJournauxComptables() {
      return this.formJournauxComptables;
   }

   public void setFormJournauxComptables(FormJournauxComptables var1) {
      this.formJournauxComptables = var1;
   }

   public FormRapprochement getFormRapprochement() {
      return this.formRapprochement;
   }

   public void setFormRapprochement(FormRapprochement var1) {
      this.formRapprochement = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesAgentsItems() {
      return this.mesAgentsItems;
   }

   public void setMesAgentsItems(List var1) {
      this.mesAgentsItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public List getMesDossiersItems() {
      return this.mesDossiersItems;
   }

   public void setMesDossiersItems(List var1) {
      this.mesDossiersItems = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public List getMesPlansBudgetsItems() {
      return this.mesPlansBudgetsItems;
   }

   public void setMesPlansBudgetsItems(List var1) {
      this.mesPlansBudgetsItems = var1;
   }

   public List getMesProjetsItems() {
      return this.mesProjetsItems;
   }

   public void setMesProjetsItems(List var1) {
      this.mesProjetsItems = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public List getMesAxesAnalytique() {
      return this.mesAxesAnalytique;
   }

   public void setMesAxesAnalytique(List var1) {
      this.mesAxesAnalytique = var1;
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

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public FormBudgetTresorerie getFormBudgetTresorerie() {
      return this.formBudgetTresorerie;
   }

   public void setFormBudgetTresorerie(FormBudgetTresorerie var1) {
      this.formBudgetTresorerie = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public ArrayList getListFiles() {
      return this.listFiles;
   }

   public void setListFiles(ArrayList var1) {
      this.listFiles = var1;
   }

   public FormExtraitProjet getFormExtraitProjet() {
      return this.formExtraitProjet;
   }

   public void setFormExtraitProjet(FormExtraitProjet var1) {
      this.formExtraitProjet = var1;
   }

   public FormImpressionProjet getFormImpressionProjet() {
      return this.formImpressionProjet;
   }

   public void setFormImpressionProjet(FormImpressionProjet var1) {
      this.formImpressionProjet = var1;
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

   public FormDocumentsOfficiels getFormDocumentsOfficiels() {
      return this.formDocumentsOfficiels;
   }

   public void setFormDocumentsOfficiels(FormDocumentsOfficiels var1) {
      this.formDocumentsOfficiels = var1;
   }

   public DataModel getDataModelSociete() {
      return this.dataModelSociete;
   }

   public void setDataModelSociete(DataModel var1) {
      this.dataModelSociete = var1;
   }

   public FormPlansAnalytiques getFormPlansAnalytiques() {
      return this.formPlansAnalytiques;
   }

   public void setFormPlansAnalytiques(FormPlansAnalytiques var1) {
      this.formPlansAnalytiques = var1;
   }

   public boolean isShowButtonModif() {
      return this.showButtonModif;
   }

   public void setShowButtonModif(boolean var1) {
      this.showButtonModif = var1;
   }

   public boolean isShowModalPanelStructure() {
      return this.showModalPanelStructure;
   }

   public void setShowModalPanelStructure(boolean var1) {
      this.showModalPanelStructure = var1;
   }

   public StructurePeg getStructurePeg() {
      return this.structurePeg;
   }

   public void setStructurePeg(StructurePeg var1) {
      this.structurePeg = var1;
   }

   public List getMesStructuresItems() {
      return this.mesStructuresItems;
   }

   public void setMesStructuresItems(List var1) {
      this.mesStructuresItems = var1;
   }

   public FormExtraitBudget getFormExtraitBudget() {
      return this.formExtraitBudget;
   }

   public void setFormExtraitBudget(FormExtraitBudget var1) {
      this.formExtraitBudget = var1;
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

   public List getMesChantiersItems() {
      return this.mesChantiersItems;
   }

   public void setMesChantiersItems(List var1) {
      this.mesChantiersItems = var1;
   }

   public List getMesMissionsItems() {
      return this.mesMissionsItems;
   }

   public void setMesMissionsItems(List var1) {
      this.mesMissionsItems = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public FormNotesExternes getFormNotesExternes() {
      return this.formNotesExternes;
   }

   public void setFormNotesExternes(FormNotesExternes var1) {
      this.formNotesExternes = var1;
   }
}
