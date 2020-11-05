package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.tiers.FormAgents;
import com.epegase.forms.tiers.FormCadeaux;
import com.epegase.forms.tiers.FormDestinataires;
import com.epegase.forms.tiers.FormEleves;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.forms.tiers.FormTiers;
import com.epegase.forms.tiers.FormTransfertTiers;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.MetiersDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProtocoleMedicalDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitTiersCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureAntecedentCDA;
import com.epegase.systeme.xml.LectureAppreciations;
import com.epegase.systeme.xml.LectureCategorieTiers;
import com.epegase.systeme.xml.LectureCentresImpots;
import com.epegase.systeme.xml.LectureCivilites;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureFamillesFournisseurs;
import com.epegase.systeme.xml.LectureFonctions;
import com.epegase.systeme.xml.LectureLangues;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureQualitesContact;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureReglementFournisseur;
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionTiers;
import java.io.BufferedReader;
import java.io.File;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.xml.sax.SAXException;

public class FormBakingBeanTiers implements Serializable {
   private int typeVente;
   private int module;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private LectureModulesOnglets lesOnglets;
   private MenudroitTiersCtrl menudroitTiersCtrl;
   private String affichePage;
   private String libelleSousMenu;
   private FormRecherche formRecherche;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private long var_memo_id_master;
   private FormTiers formTiers;
   private ObjetLigneMenu menutiers;
   private ActivitesDao activitesDao;
   private SiteDao siteDao;
   private DepartementDao departementDao;
   private RegionDao regionDao;
   private SecteurDao secteurDao;
   private UserDao userDao;
   private PointDeVenteDao pointDeVenteDao;
   private DeviseDao deviseDao;
   private List lesFamilleClientsListe;
   private List lesFamilleFournisseursListe;
   private List mesdevisesItem;
   private List mesCaissesItems;
   private List mesRegionsItems;
   private List mesSitesItems;
   private List mesFamilleFournisseursItems;
   private List mesFamilleClientsItems;
   private List mesPdvItems;
   private List mesCategoriesItems;
   private List mesAppreciationsItems;
   private List mesActivitesPPItems;
   private List mesActivitesPMItems;
   private List mesPaysItems;
   private List mesCivilitesItems;
   private List mesCivilitesItemsMedicale;
   private List mesFonctionsItems;
   private List mesLangueItems;
   private List mesSourceItems;
   private List documentImpressionItems = new ArrayList();
   private List documentRibImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private List listeImpressionContactItems;
   private List mesReglementClientItems;
   private List mesReglementFournisseurItems;
   private List listeImpressionCatalogueItems = new ArrayList();
   private List lesReglementClientListe;
   private List lesReglementFournisseurListe;
   private List mesUserItems;
   private List mesDepotItems;
   private List mesSeriesItems;
   private List mesZonesFiscales = new ArrayList();
   private List listCaisses;
   private LireLesoptionsTiers lireLesoptionsTiers;
   private OptionTiers optionTiers;
   private List mesFamilleVentestems;
   private FormDestinataires formDestinataires;
   private FormPatients formPatients;
   private List mesQualiteItems;
   private List mesAntecedentItems;
   private List mesPecItems;
   private List mesProtocoleItems;
   private FormAgents formAgents;
   private FormEleves formEleves;
   private transient DataModel dataModelTiers = new ListDataModel();
   private List lesTiers = new ArrayList();
   private Tiers tiers;
   private TiersDao tiersDao;
   private String lettre = "";
   private boolean showModalPanelTiers = false;
   private boolean showModalPanelContact = false;
   private String urlphoto;
   private FormCadeaux formCadeaux;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;
   private boolean afficheStatistique = false;
   private boolean showModalPanelGraph = false;
   private int modeGraph;
   private String titreGraph;
   private String sousTitreGraph;
   private boolean showModele;
   private FormTransfertTiers formTransfertTiers;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private String quelTransfert;

   public FormBakingBeanTiers() throws IOException {
   }

   public void InstancesDaoUtilses() throws IOException, SAXException, JDOMException, ParseException {
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void menuGaucheTiers(int var1) throws JDOMException, IOException {
      if (this.menudroitTiersCtrl == null) {
         this.menudroitTiersCtrl = new MenudroitTiersCtrl();
         this.menudroitTiersCtrl.setStrId(this.structureLog.getStrid());
         this.menudroitTiersCtrl.setStructureLog(this.structureLog);
         this.menudroitTiersCtrl.setUsersLog(this.usersLog);
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitTiersCtrl.chargerMenuTiersXml(this.usersLog.getUsrCollaboration(), var1);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("30000", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formAgents = null;
      this.formDestinataires = null;
      this.formEleves = null;
      this.formPatients = null;
      this.formTiers = null;
   }

   public void gestionTiers() throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.menutiers = new ObjetLigneMenu();
      if (this.menudroitTiersCtrl.getDataModelMenudroitTiersXmlList().isRowAvailable()) {
         this.menutiers = (ObjetLigneMenu)this.menudroitTiersCtrl.getDataModelMenudroitTiersXmlList().getRowData();
         if (this.menutiers.getLibelle_FR() != null && !this.menutiers.getLibelle_FR().isEmpty()) {
            this.aiguillageTiers();
         }
      }

   }

   public void gestionTiersFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.menutiers = var1;
      this.aiguillageTiers();
   }

   public void aiguillageTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.razMemoire();
      if (this.menutiers.getCommande().equalsIgnoreCase("30000:000")) {
         this.affichePage = "/tiers/tiersPhysiqueInit.jsp";
         this.menuFournisseurPhys();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:001")) {
         this.affichePage = "/tiers/tiersMoralInit.jsp";
         this.menuFournisseurMoral();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:010")) {
         this.affichePage = "/tiers/tiersPhysiqueInit.jsp";
         this.menuSuspectPhys();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:011")) {
         this.affichePage = "/tiers/tiersMoralInit.jsp";
         this.menuSuspectMoral();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:020")) {
         this.affichePage = "/tiers/tiersPhysiqueInit.jsp";
         this.menuProspectPhys();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:021")) {
         this.affichePage = "/tiers/tiersMoralInit.jsp";
         this.menuProspectMoral();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:022")) {
         this.affichePage = "/tiers/tiersPhysiqueInit.jsp";
         this.menuDemandeurPhys();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:023")) {
         this.affichePage = "/tiers/tiersMoralInit.jsp";
         this.menuDemandeurMoral();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:024")) {
         this.affichePage = "/tiers/tiersToutClientInit.jsp";
         this.menuToutDemandeur();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:030")) {
         this.affichePage = "/tiers/tiersPhysiqueInit.jsp";
         this.menuClientPhys();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:031")) {
         this.affichePage = "/tiers/tiersMoralInit.jsp";
         this.menuClientMoral();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:032")) {
         this.affichePage = "/tiers/tiersDestinataireInit.jsp";
         this.menuDestinataire();
      } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:033")) {
         this.affichePage = "/tiers/contactInit.jsp";
         this.menuContact();
      } else {
         Session var1;
         String var2;
         if (this.menutiers.getCommande().equalsIgnoreCase("30000:034")) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 70, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 70, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/tiers/tiersPatientInit.jsp";
                  this.menuPatient(var2, var1);
               } else {
                  this.affichePage = "/tiers/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/tiers/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:035")) {
            this.affichePage = "/tiers/tiersToutClientInit.jsp";
            this.menuToutClient();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:036")) {
            this.affichePage = "/tiers/cadeauxInit.jsp";
            this.menuCadeaux();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:039")) {
            this.affichePage = "/tiers/tiersLitigieuxInit.jsp";
            this.menuLitiges();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:040")) {
            this.affichePage = "/tiers/tiersAgentInit.jsp";
            this.menuAgents();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:060")) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 100, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 100, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/tiers/tiersEleveInit.jsp";
                  this.menuEleves(var1);
               } else {
                  this.affichePage = "/tiers/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/tiers/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:070")) {
            this.affichePage = "/tiers/locatairePhysiqueInit.jsp";
            this.menuLocatairePhys();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:071")) {
            this.affichePage = "/tiers/locataireMoralInit.jsp";
            this.menuLocataireMoral();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:075")) {
            this.affichePage = "/tiers/locataireMoralInit.jsp";
            this.menuCoproprieteMoral();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:080")) {
            this.affichePage = "/tiers/proprietairePhysiqueInit.jsp";
            this.menuProprietairePhys();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:081")) {
            this.affichePage = "/tiers/proprietaireMoralInit.jsp";
            this.menuProprietaireMoral();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:087")) {
            this.affichePage = "/tiers/membreIndividuelInit.jsp";
            this.menuMembreIndividuel();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:088")) {
            this.affichePage = "/tiers/membreSocieteInit.jsp";
            this.menuMembreSociete();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:089")) {
            this.affichePage = "/tiers/membreGroupeInit.jsp";
            this.menuMembreGroupe();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:099")) {
            this.affichePage = "/tiers/tiersPhysiqueInit.jsp";
            this.menuDivers();
         } else if (this.menutiers.getCommande().equalsIgnoreCase("30000:95")) {
            this.affichePage = "/tiers/ImportationTiers.jsp";
            this.menuImportationTiers();
         }
      }

   }

   public void menuSociete(boolean var1) throws IOException, HibernateException, NamingException, ParseException, JDOMException {
      this.formTiers = new FormTiers();
      this.formTiers.setutilInitHibernate(this.utilInitHibernate);
      this.formTiers.setBaseLog(this.baseLog);
      this.formTiers.setStructureLog(this.structureLog);
      this.formTiers.setUsersLog(this.usersLog);
      this.formTiers.InstancesDaoUtilses();
      this.formTiers.setVar_memo_id_master(this.var_memo_id_master);
      this.formTiers.setLesFamillesClientsListe(this.lesFamilleClientsListe);
      this.formTiers.setLesFamillesFournisseursListe(this.lesFamilleFournisseursListe);
      this.formTiers.setLesReglementsFournisseur(this.lesReglementFournisseurListe);
      this.formTiers.setLesReglementsClient(this.lesReglementClientListe);
      this.formTiers.setMesFamilleVentestems(this.mesFamilleVentestems);
      this.formTiers.setTypeVente(this.typeVente);
      this.formTiers.setGenreTiers(this.menutiers.getGenre());
      this.formTiers.setLigneMenu(this.menutiers);
      this.formTiers.setOptionTiers(this.optionTiers);
      this.formTiers.setFormRecherche(this.formRecherche);
      this.formTiers.recupererOptionsTiers();
      this.formTiers.setUrlphoto(this.urlphoto);
      this.formTiers.setUrlExplorateur(this.urlExplorateur);
      this.formTiers.chargerCentreInteret();
      this.formTiers.setChronoActif(var1);
      this.formTiers.setChrono(this.chrono);
      this.chargerlesmodelesFichesImpressionsTiers();
      this.chargerlesmodelesListesImpressionsTiers();
      this.chargerlesmodelesListesImpressionsCataloguesTiers();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.formTiers.menuGroupeListesociété();
   }

   public void menuFournisseurPhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Prestataires";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(300, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuFournisseurMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Fournisseurs";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(300, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuSuspectPhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Suspects individuels";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(301, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuSuspectMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Suspects sociétés";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(301, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuProspectPhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Prospects individuels";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(302, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuProspectMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Prospects sociétés";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(302, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuDemandeurPhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Demandeurs individuels";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuDemandeurMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Demandeurs sociétés";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuClientPhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Clients individuels";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(303, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuClientMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Clients sociétés";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(303, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuLocatairePhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Locataires individuels";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(306, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuLocataireMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Locataires sociétés";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(306, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuCoproprieteMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Copropriétés";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(305, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuProprietairePhys() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Propriétaires individuels";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(304, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuProprietaireMoral() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Propriétaires sociétés";
      boolean var1 = false;
      this.chrono = this.chronoDao.chronoByNat(304, (Session)null);
      if (this.chrono != null) {
         var1 = true;
      }

      this.menuSociete(var1);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuMembreIndividuel() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Membres Individuels";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuMembreSociete() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Membres Sociétés";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuMembreGroupe() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Membre Groupes";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuLitiges() throws IOException, HibernateException, NamingException, ParseException, JDOMException {
      this.libelleSousMenu = "Tous Tiers";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuDivers() throws JDOMException, IOException, ParseException, HibernateException, NamingException {
      this.libelleSousMenu = "Divers";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuDestinataire() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Destinataires";
      this.formDestinataires = new FormDestinataires();
      this.formDestinataires.setutilInitHibernate(this.utilInitHibernate);
      this.formDestinataires.setBaseLog(this.baseLog);
      this.formDestinataires.setStructureLog(this.structureLog);
      this.formDestinataires.setUsersLog(this.usersLog);
      this.formDestinataires.InstancesDaoUtilses();
      this.formDestinataires.setMesReglementClientItem(this.mesReglementClientItems);
      this.formDestinataires.setLesReglementsClient(this.lesReglementClientListe);
      this.formDestinataires.setLigneMenu(this.menutiers);
      this.formDestinataires.setOptionTiers(this.optionTiers);
      this.formDestinataires.recupererOptionsTiers();
      this.formDestinataires.setMesPdvItems(this.mesPdvItems);
      this.chargerlesmodelesFichesImpressionsDestinataire();
      this.chargerlesmodelesListesImpressionsDestinataire();
   }

   public void menuContact() throws IOException, ParseException, HibernateException, NamingException {
      this.formTiers = new FormTiers();
      this.formTiers.setutilInitHibernate(this.utilInitHibernate);
      this.formTiers.setBaseLog(this.baseLog);
      this.formTiers.setStructureLog(this.structureLog);
      this.formTiers.setUsersLog(this.usersLog);
      this.formTiers.InstancesDaoUtilses();
      this.formTiers.setLesFamillesClientsListe(this.lesFamilleClientsListe);
      this.formTiers.setLesFamillesFournisseursListe(this.lesFamilleFournisseursListe);
      this.formTiers.setLesReglementsFournisseur(this.lesReglementFournisseurListe);
      this.formTiers.setLesReglementsClient(this.lesReglementClientListe);
      this.formTiers.setMesFamilleVentestems(this.mesFamilleVentestems);
      this.formTiers.setLigneMenu(this.menutiers);
      this.formTiers.setOptionTiers(this.optionTiers);
      this.formTiers.setFormRecherche(this.formRecherche);
      this.formTiers.recupererOptionsTiersContact();
      this.formTiers.setUrlphoto(this.urlphoto);
      this.formTiers.setUrlExplorateur(this.urlExplorateur);
      this.chargerlesmodelesListeimpressionsContact();
   }

   public void menuToutClient() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Tous Clients";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuToutDemandeur() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Tous Demandeurs";
      this.menuSociete(false);
      this.mesCategoriesItems = this.recupererCategorieItem(this.menutiers.getGenre());
   }

   public void menuCadeaux() throws HibernateException, NamingException, ParseException {
      this.formCadeaux = new FormCadeaux();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
      this.formCadeaux.setUtilInitHibernate(this.utilInitHibernate);
      this.formCadeaux.setBaseLog(this.baseLog);
      this.formCadeaux.setStructureLog(this.structureLog);
      this.formCadeaux.setUsersLog(this.usersLog);
      this.formCadeaux.InstancesDaoUtilses();
      this.formCadeaux.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCadeaux.setOptionTiers(this.optionTiers);
      this.formCadeaux.configCadeaux(var1);
      this.formCadeaux.accesResteintUser();
      this.formCadeaux.accesResteintGroupe();
      this.formCadeaux.setFormRecherche(this.formRecherche);
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formCadeaux.executerRequete(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuPatient(String var1, Session var2) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Patients";
      this.formPatients = new FormPatients();
      this.formPatients.setutilInitHibernate(this.utilInitHibernate);
      this.formPatients.setBaseLog(this.baseLog);
      this.formPatients.setStructureLog(this.structureLog);
      this.formPatients.setUsersLog(this.usersLog);
      this.formPatients.InstancesDaoUtilses();
      this.formPatients.setLigneMenu(this.menutiers);
      this.formPatients.setOptionTiers(this.optionTiers);
      this.formPatients.recupererOptionsMedical(var2);
      this.formPatients.recupererExerciceMedical(var2);
      this.recupererTousLesItemsPatient(var2);
      this.formPatients.setMesCategoriesItems(this.recupererCategorieItem(this.menutiers.getGenre()));
      this.formPatients.setMesFamilleClientsItems(this.mesFamilleClientsItems);
      this.formPatients.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formPatients.setMesReglementClientItems(this.mesReglementClientItems);
      this.formPatients.setLesReglementsClient(this.lesReglementClientListe);
      this.formPatients.setMesCivilitesItems(this.mesCivilitesItems);
      this.formPatients.setMesSitesItem(this.mesSitesItems);
      this.formPatients.setUrlExplorateur(this.urlExplorateur);
      this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 71, var1, var2);
      if (this.chrono != null) {
         this.formPatients.setAfficheButtConsultation(true);
      } else {
         this.formPatients.setAfficheButtConsultation(false);
      }

      this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 73, var1, var2);
      if (this.chrono != null) {
         this.formPatients.setAfficheButtPharmacie(true);
      } else {
         this.formPatients.setAfficheButtPharmacie(false);
      }

      this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 74, var1, var2);
      if (this.chrono != null) {
         this.formPatients.setAfficheButtLaboratoire(true);
      } else {
         this.formPatients.setAfficheButtLaboratoire(false);
      }

      this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 76, var1, var2);
      if (this.chrono != null) {
         this.formPatients.setAfficheButtHospitalisation(true);
      } else {
         this.formPatients.setAfficheButtHospitalisation(false);
      }

   }

   public void menuAgents() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Agents";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
      this.formAgents = new FormAgents();
      this.formAgents.setutilInitHibernate(this.utilInitHibernate);
      this.formAgents.setBaseLog(this.baseLog);
      this.formAgents.setStructureLog(this.structureLog);
      this.formAgents.setUsersLog(this.usersLog);
      this.formAgents.InstancesDaoUtilses();
      this.formAgents.setLigneMenu(this.menutiers);
      this.formAgents.setOptionTiers(this.optionTiers);
      this.formAgents.recupererOptionsTiers(var1);
      this.formAgents.chargerGroupes(var1);
      this.formAgents.chargerServices(var1);
      this.chargerlesmodelesFichesImpressionsAgents();
      this.chargerlesmodelesListesImpressionsAgents();
      this.utilInitHibernate.closeSession();
   }

   public void menuEleves(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.libelleSousMenu = "Eleves";
      this.formEleves = new FormEleves();
      this.formEleves.setutilInitHibernate(this.utilInitHibernate);
      this.formEleves.setBaseLog(this.baseLog);
      this.formEleves.setStructureLog(this.structureLog);
      this.formEleves.setUsersLog(this.usersLog);
      this.formEleves.InstancesDaoUtilses();
      this.formEleves.setLigneMenu(this.menutiers);
      this.formEleves.setOptionTiers(this.optionTiers);
      this.formEleves.recupererOptionsEducation(var1);
      this.formEleves.recupererExerciceEducation(var1);
      this.recupererTousLesItemsEleve(var1);
      this.recupererCaisses(var1);
      this.formEleves.setMesFamilleClientsItems(this.mesFamilleClientsItems);
      this.formEleves.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formEleves.setMesReglementClientItems(this.mesReglementClientItems);
      this.formEleves.setLesReglementsClient(this.lesReglementClientListe);
      this.formEleves.setMesCivilitesItems(this.mesCivilitesItems);
      this.formEleves.setListCaisses(this.listCaisses);
      this.formEleves.setUsersChrono(this.usersChrono);
      this.formEleves.setFormRecherche(this.formRecherche);
   }

   public void menuImportationTiers() throws HibernateException, NamingException {
      this.formTransfertTiers = new FormTransfertTiers();
      this.formTransfertTiers.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertTiers.setBaseLog(this.baseLog);
      this.formTransfertTiers.setStructureLog(this.structureLog);
      this.formTransfertTiers.setUsersLog(this.usersLog);
      this.formTransfertTiers.InstancesDaoUtilses();
      this.formTransfertTiers.setTypeVente(this.typeVente);
      this.formTransfertTiers.setFormRecherche(this.formRecherche);
      this.formTransfertTiers.initImportation();
      this.listFiles = new ArrayList();
      this.uploadsAvailable = 1;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void accesTiers() {
      if (this.dataModelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.dataModelTiers.getRowData();
         this.formRecherche.rechercheTiers(this.tiers, 0);
         this.showModalPanelTiers = true;
      }

   }

   public void annuleDetailTiers() {
      this.showModalPanelTiers = false;
   }

   public void rechercheLettre() throws HibernateException, NamingException {
      this.rechercheLettre(this.lettre);
   }

   public void lettreA() throws HibernateException, NamingException {
      this.rechercheLettre("A");
   }

   public void lettreB() throws HibernateException, NamingException {
      this.rechercheLettre("B");
   }

   public void lettreC() throws HibernateException, NamingException {
      this.rechercheLettre("C");
   }

   public void lettreD() throws HibernateException, NamingException {
      this.rechercheLettre("D");
   }

   public void lettreE() throws HibernateException, NamingException {
      this.rechercheLettre("E");
   }

   public void lettreF() throws HibernateException, NamingException {
      this.rechercheLettre("F");
   }

   public void lettreG() throws HibernateException, NamingException {
      this.rechercheLettre("G");
   }

   public void lettreH() throws HibernateException, NamingException {
      this.rechercheLettre("H");
   }

   public void lettreI() throws HibernateException, NamingException {
      this.rechercheLettre("I");
   }

   public void lettreJ() throws HibernateException, NamingException {
      this.rechercheLettre("J");
   }

   public void lettreK() throws HibernateException, NamingException {
      this.rechercheLettre("K");
   }

   public void lettreL() throws HibernateException, NamingException {
      this.rechercheLettre("L");
   }

   public void lettreM() throws HibernateException, NamingException {
      this.rechercheLettre("M");
   }

   public void lettreN() throws HibernateException, NamingException {
      this.rechercheLettre("N");
   }

   public void lettreO() throws HibernateException, NamingException {
      this.rechercheLettre("O");
   }

   public void lettreP() throws HibernateException, NamingException {
      this.rechercheLettre("P");
   }

   public void lettreQ() throws HibernateException, NamingException {
      this.rechercheLettre("Q");
   }

   public void lettreR() throws HibernateException, NamingException {
      this.rechercheLettre("R");
   }

   public void lettreS() throws HibernateException, NamingException {
      this.rechercheLettre("S");
   }

   public void lettreT() throws HibernateException, NamingException {
      this.rechercheLettre("T");
   }

   public void lettreU() throws HibernateException, NamingException {
      this.rechercheLettre("U");
   }

   public void lettreV() throws HibernateException, NamingException {
      this.rechercheLettre("V");
   }

   public void lettreW() throws HibernateException, NamingException {
      this.rechercheLettre("W");
   }

   public void lettreX() throws HibernateException, NamingException {
      this.rechercheLettre("X");
   }

   public void lettreY() throws HibernateException, NamingException {
      this.rechercheLettre("Y");
   }

   public void lettreZ() throws HibernateException, NamingException {
      this.rechercheLettre("Z");
   }

   public void rechercheLettre(String var1) throws HibernateException, NamingException {
      this.lesTiers.clear();
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "TiersRecherche");
      this.lesTiers = this.tiersDao.chargerLesTiersByLettre(var1, var2);
      new ArrayList();
      ContactDao var4 = new ContactDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.chargerLesContactsLettre(var1, var2);
      if (var3.size() != 0) {
         new Contacts();

         for(int var6 = 0; var6 < var3.size(); ++var6) {
            Contacts var5 = (Contacts)var3.get(var6);
            Tiers var7 = new Tiers();
            var7.setTieraisonsocialenom(var5.getConpatronyme());
            var7.setTieemployeur(var5.getTiers().getTieraisonsocialenom());
            var7.setTietype("90");
            var7.setTieadresse(var5.getConadresse());
            var7.setTieburtel1(var5.getContelbur());
            var7.setTieburfax(var5.getConfax());
            var7.setTieweb(var5.getConweb());
            var7.setTiemail1(var5.getConmail1());
            var7.setTieville(var5.getConville());
            var7.setTienompays(var5.getConnompays());
            this.lesTiers.add(var7);
         }
      }

      new ArrayList();
      PlansAnalytiquesDao var18 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var17 = var18.selectAnal("7", var1, (String)null, 0, var2);
      if (var17.size() != 0) {
         new PlansAnalytiques();

         for(int var8 = 0; var8 < var17.size(); ++var8) {
            PlansAnalytiques var19 = (PlansAnalytiques)var17.get(var8);
            Tiers var9 = new Tiers();
            var9.setTieraisonsocialenom(var19.getAnaNomFr());
            var9.setTieemployeur("");
            var9.setTietype("91");
            var9.setTieadresse(var19.getAnaTiersAdresse());
            var9.setTieburtel1(var19.getAnaTiersTelephone());
            var9.setTieburfax(var19.getAnaTiersFax());
            var9.setTieweb("");
            var9.setTiemail1(var19.getAnaTiersMail());
            var9.setTieville(var19.getAnaTiersVille());
            var9.setTienompays(var19.getAnaTiersNompays());
            this.lesTiers.add(var9);
         }
      }

      new ArrayList();
      SalariesDao var21 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var20 = var21.chargerlesSalariesActif(var1, var2);
      if (var20.size() != 0) {
         new Salaries();

         for(int var10 = 0; var10 < var20.size(); ++var10) {
            Salaries var22 = (Salaries)var20.get(var10);
            Tiers var11 = new Tiers();
            var11.setTieraisonsocialenom(var22.getSalNom() + " " + var22.getSalPrenom());
            var11.setTieemployeur("");
            var11.setTietype("92");
            var11.setTieadresse(var22.getSalAdresse());
            var11.setTieburtel1(var22.getSalTelBur());
            var11.setTieburfax("");
            var11.setTieweb("");
            var11.setTiemail1(var22.getSalMail1());
            var11.setTieville(var22.getSalVille());
            var11.setTienompays(var22.getSalNompays());
            this.lesTiers.add(var11);
         }
      }

      new ArrayList();
      PatientsDao var24 = new PatientsDao(this.baseLog, this.utilInitHibernate);
      List var23 = var24.chargerlesPatients(var1, var2);
      if (var23.size() != 0) {
         new Patients();

         for(int var12 = 0; var12 < var23.size(); ++var12) {
            Patients var25 = (Patients)var23.get(var12);
            Tiers var13 = new Tiers();
            var13.setTieraisonsocialenom(var25.getPatNom() + " " + var25.getPatPrenom());
            var13.setTieemployeur(var25.getPatCouvert());
            var13.setTietype("93");
            var13.setTieadresse(var25.getPatAdresse());
            var13.setTieburtel1(var25.getPatBurTel1());
            var13.setTieburfax(var25.getPatBurFax());
            var13.setTieweb("");
            var13.setTiemail1(var25.getPatMail1());
            var13.setTieville(var25.getPatVille());
            var13.setTienompays(var25.getPatPays());
            this.lesTiers.add(var13);
         }
      }

      new ArrayList();
      List var26 = this.userDao.chargerUserActif(var1, var2);
      if (var26.size() != 0) {
         new Users();

         for(int var29 = 0; var29 < var26.size(); ++var29) {
            Users var27 = (Users)var26.get(var29);
            Tiers var14 = new Tiers();
            var14.setTieraisonsocialenom(var27.getUsrPatronyme());
            var14.setTieemployeur("");
            var14.setTietype("94");
            var14.setTieadresse(var27.getUsrAdresse());
            var14.setTieburtel1(var27.getUsrTelDomicile());
            var14.setTieburfax("");
            var14.setTieweb("");
            var14.setTiemail1(var27.getUsrMail());
            var14.setTieville(var27.getUsrVille());
            var14.setTienompays(var27.getUsrNomPays());
            this.lesTiers.add(var14);
         }
      }

      new ArrayList();
      ElevesDao var30 = new ElevesDao(this.baseLog, this.utilInitHibernate);
      List var28 = var30.chargerlesEleves(var1, var2);
      if (var28.size() != 0) {
         new Eleves();

         for(int var15 = 0; var15 < var28.size(); ++var15) {
            Eleves var31 = (Eleves)var28.get(var15);
            Tiers var16 = new Tiers();
            var16.setTieraisonsocialenom(var31.getEleNom() + " " + var31.getElePrenom());
            var16.setTieemployeur(var31.getEleCouvert());
            var16.setTietype("95");
            var16.setTieadresse(var31.getEleAdresse());
            var16.setTieburtel1(var31.getEleCel1());
            var16.setTieburfax("");
            var16.setTieweb("");
            var16.setTiemail1(var31.getEleMail1());
            var16.setTieville(var31.getEleVille());
            var16.setTienompays(var31.getElePays());
            this.lesTiers.add(var16);
         }
      }

      this.utilInitHibernate.closeSession();
      this.dataModelTiers.setWrappedData(this.lesTiers);
      this.afficheStatistique = false;
   }

   public void debutStatistiques() {
      this.afficheStatistique = true;
      this.modeGraph = 0;
      this.sousTitreGraph = "";
      this.showModele = false;
      this.showModalPanelGraph = true;
   }

   public void hideModele() {
      this.showModele = false;
   }

   public void fermerGrapheur() {
      this.showModalPanelGraph = false;
   }

   public List grapher() throws HibernateException, NamingException, ParseException {
      Object var1 = new ArrayList();
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      if (this.modeGraph == 0) {
         var1 = this.tiersDao.chargerLesTiers("100", var2);
      } else if (this.modeGraph == 1) {
         var1 = this.tiersDao.chargerLesTiers("101", var2);
      } else if (this.modeGraph == 2) {
         var1 = this.tiersDao.chargerLesTiers("102", var2);
      } else if (this.modeGraph == 3) {
         var1 = this.tiersDao.chargerLesTiers("102", var2);
      }

      this.utilInitHibernate.closeSession();
      Object var3 = new ArrayList();
      if (((List)var1).size() != 0) {
         this.titreGraph = "Analyse des Tiers : ";
         this.titreGraph = "";
         this.sousTitreGraph = "";
         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par Fournisseur/Suspect/Prospect/Client";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par Categorie de Fourniseurs";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par Categorie de clients";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par Litiges";
         }

         new Tiers();
         if (((List)var1).size() != 0) {
            String var5 = "";
            long var6 = 0L;
            boolean var8 = false;

            for(int var9 = 0; var9 < ((List)var1).size(); ++var9) {
               Tiers var4 = (Tiers)((List)var1).get(var9);
               var5 = "";
               var6 = 1L;
               byte var10 = 1;
               if (this.modeGraph == 0) {
                  if (var4.getTietype() != null && !var4.getTietype().isEmpty()) {
                     if (var4.getTietype().equals("0")) {
                        var5 = "Fournisseur";
                     } else if (var4.getTietype().equals("1")) {
                        var5 = "Suspect";
                     } else if (var4.getTietype().equals("2")) {
                        var5 = "Prospect";
                     } else if (var4.getTietype().equals("3")) {
                        var5 = "Client";
                     } else {
                        var5 = "Autre:" + var4.getTietype();
                     }
                  } else {
                     var5 = "Non codifie";
                  }
               } else if (this.modeGraph == 1) {
                  var5 = var4.getTiecategorie();
               } else if (this.modeGraph == 2) {
                  var5 = var4.getTiecategorie();
               } else if (this.modeGraph == 3) {
                  if (var4.getTiesurveille() == 1) {
                     var5 = "Compte a surveiller";
                  } else if (var4.getTiecomptebloque() == 1) {
                     var5 = "Compte bloque";
                  } else if (var4.getTiechequeinterdit() == 1) {
                     var5 = "Cheque interdit";
                  } else if (var4.isTieconventiongele()) {
                     var5 = "Convention gelee";
                  } else {
                     var5 = "Compte Normal";
                  }
               }

               var3 = this.calculeListe((List)var3, var5, var10, var6);
            }

            var3 = this.calculePourcentage((List)var3);
         }
      }

      this.showModele = true;
      return (List)var3;
   }

   public List calculeListe(List var1, String var2, int var3, long var4) {
      boolean var6 = false;
      boolean var7 = false;
      ObjetGraph var8 = new ObjetGraph();
      if (var1.size() == 0) {
         var6 = true;
      } else {
         for(int var9 = 0; var9 < var1.size(); ++var9) {
            var8 = (ObjetGraph)var1.get(var9);
            if (var2.equals(var8.getNomSerie())) {
               var7 = true;
               break;
            }
         }

         if (!var7) {
            var6 = true;
         }
      }

      if (var6) {
         ObjetGraph var10 = new ObjetGraph();
         var10.setNomSerie(var2);
         if (var3 == 1) {
            var10.setV01(var4);
         } else if (var3 == 2) {
            var10.setV02(var4);
         } else if (var3 == 3) {
            var10.setV03(var4);
         } else if (var3 == 4) {
            var10.setV04(var4);
         } else if (var3 == 5) {
            var10.setV05(var4);
         } else if (var3 == 6) {
            var10.setV06(var4);
         } else if (var3 == 7) {
            var10.setV07(var4);
         } else if (var3 == 8) {
            var10.setV08(var4);
         } else if (var3 == 9) {
            var10.setV09(var4);
         } else if (var3 == 10) {
            var10.setV10(var4);
         } else if (var3 == 11) {
            var10.setV11(var4);
         } else if (var3 == 12) {
            var10.setV12(var4);
         } else if (var3 == 13) {
            var10.setV13(var4);
         } else if (var3 == 14) {
            var10.setV14(var4);
         } else if (var3 == 15) {
            var10.setV15(var4);
         } else if (var3 == 16) {
            var10.setV16(var4);
         } else if (var3 == 17) {
            var10.setV17(var4);
         } else if (var3 == 18) {
            var10.setV18(var4);
         } else if (var3 == 19) {
            var10.setV19(var4);
         } else if (var3 == 20) {
            var10.setV20(var4);
         } else if (var3 == 21) {
            var10.setV21(var4);
         } else if (var3 == 22) {
            var10.setV22(var4);
         } else if (var3 == 23) {
            var10.setV23(var4);
         } else if (var3 == 24) {
            var10.setV24(var4);
         } else if (var3 == 25) {
            var10.setV25(var4);
         } else if (var3 == 26) {
            var10.setV26(var4);
         } else if (var3 == 27) {
            var10.setV27(var4);
         } else if (var3 == 28) {
            var10.setV28(var4);
         } else if (var3 == 29) {
            var10.setV29(var4);
         } else if (var3 == 30) {
            var10.setV30(var4);
         } else if (var3 == 31) {
            var10.setV31(var4);
         }

         var1.add(var10);
      } else if (var8 != null) {
         if (var3 == 1) {
            var8.setV01(var8.getV01() + var4);
         } else if (var3 == 2) {
            var8.setV02(var8.getV02() + var4);
         } else if (var3 == 3) {
            var8.setV03(var8.getV03() + var4);
         } else if (var3 == 4) {
            var8.setV04(var8.getV04() + var4);
         } else if (var3 == 5) {
            var8.setV05(var8.getV05() + var4);
         } else if (var3 == 6) {
            var8.setV06(var8.getV06() + var4);
         } else if (var3 == 7) {
            var8.setV07(var8.getV07() + var4);
         } else if (var3 == 8) {
            var8.setV08(var8.getV08() + var4);
         } else if (var3 == 9) {
            var8.setV09(var8.getV09() + var4);
         } else if (var3 == 10) {
            var8.setV10(var8.getV10() + var4);
         } else if (var3 == 11) {
            var8.setV11(var8.getV11() + var4);
         } else if (var3 == 12) {
            var8.setV12(var8.getV12() + var4);
         } else if (var3 == 13) {
            var8.setV12(var8.getV13() + var4);
         } else if (var3 == 14) {
            var8.setV12(var8.getV14() + var4);
         } else if (var3 == 15) {
            var8.setV12(var8.getV15() + var4);
         } else if (var3 == 16) {
            var8.setV12(var8.getV16() + var4);
         } else if (var3 == 17) {
            var8.setV12(var8.getV17() + var4);
         } else if (var3 == 18) {
            var8.setV12(var8.getV18() + var4);
         } else if (var3 == 19) {
            var8.setV12(var8.getV19() + var4);
         } else if (var3 == 20) {
            var8.setV12(var8.getV20() + var4);
         } else if (var3 == 21) {
            var8.setV12(var8.getV21() + var4);
         } else if (var3 == 22) {
            var8.setV12(var8.getV22() + var4);
         } else if (var3 == 23) {
            var8.setV12(var8.getV23() + var4);
         } else if (var3 == 24) {
            var8.setV12(var8.getV24() + var4);
         } else if (var3 == 25) {
            var8.setV12(var8.getV25() + var4);
         } else if (var3 == 26) {
            var8.setV12(var8.getV26() + var4);
         } else if (var3 == 27) {
            var8.setV12(var8.getV27() + var4);
         } else if (var3 == 28) {
            var8.setV12(var8.getV28() + var4);
         } else if (var3 == 29) {
            var8.setV12(var8.getV29() + var4);
         } else if (var3 == 30) {
            var8.setV12(var8.getV30() + var4);
         } else if (var3 == 31) {
            var8.setV12(var8.getV31() + var4);
         }
      }

      return var1;
   }

   public List calculePourcentage(List var1) {
      new ObjetGraph();
      float var3 = 0.0F;
      ObjetGraph var2;
      if (var1.size() != 0) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            var2 = (ObjetGraph)var1.get(var4);
            var3 += (float)(var2.getV01() + var2.getV02() + var2.getV03() + var2.getV04() + var2.getV05() + var2.getV06() + var2.getV07() + var2.getV08() + var2.getV09() + var2.getV10() + var2.getV11() + var2.getV12() + var2.getV13() + var2.getV14() + var2.getV15() + var2.getV16() + var2.getV16() + var2.getV17() + var2.getV18() + var2.getV19() + var2.getV20() + var2.getV21() + var2.getV22() + var2.getV23() + var2.getV24() + var2.getV25() + var2.getV26() + var2.getV27() + var2.getV28() + var2.getV29() + var2.getV30() + var2.getV31());
         }
      }

      if (var1.size() != 0) {
         float var7 = 0.0F;
         float var5 = 0.0F;

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            var2 = (ObjetGraph)var1.get(var6);
            var5 = (float)(var2.getV01() + var2.getV02() + var2.getV03() + var2.getV04() + var2.getV05() + var2.getV06() + var2.getV07() + var2.getV08() + var2.getV09() + var2.getV10() + var2.getV11() + var2.getV12() + var2.getV13() + var2.getV14() + var2.getV15() + var2.getV16() + var2.getV16() + var2.getV17() + var2.getV18() + var2.getV19() + var2.getV20() + var2.getV21() + var2.getV22() + var2.getV23() + var2.getV24() + var2.getV25() + var2.getV26() + var2.getV27() + var2.getV28() + var2.getV29() + var2.getV30() + var2.getV31());
            var7 = var5 / var3 * 100.0F;
            var2.setVpourcent(var7);
         }
      }

      return var1;
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.urlphoto = this.baseLog + "/photos/Tiers/";
      this.recupererOptionTiers();
      this.recupererModelesAutorises();
      this.recupererDevisesItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererCaissesItem(var1);
      this.recupererRegionItem(var1);
      this.recupererPdvItem(var1);
      this.recupererAppreciationItem();
      this.recupererFamillesClientsItem();
      this.recupererFamillesFournisseursItem();
      this.recupererPaysItem();
      this.recupererCivilitesItem();
      this.recupererFonctionsItem();
      this.recupererLangueItem();
      this.recupererSourceItem();
      this.recupererReglementClient();
      this.recupererReglementFournisseur();
      this.recupererUserItem(var1);
      this.recupererDepotItem(var1);
      this.recupererSerieItem(var1);
      this.recupererActivitesItem(var1);
      this.recupererFamillesVentesItem(var1);
      this.recupererCentresImpots();
   }

   public void recupererTousLesItemsPatient(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererQualitePatientItem();
      this.recupererAntecedentItem();
      this.recupererPecItem();
      this.recupererProtocolesItems(var1);
      this.chargerlesmodelesFicheimpressionsPatient();
      this.chargerlesmodelesListeimpressionsPatient();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererTousLesItemsEleve(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererQualiteEleveItem();
      this.chargerlesmodelesFicheimpressionsEleve();
      this.chargerlesmodelesListeimpressionsEleve();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererOptionTiers() {
      this.lireLesoptionsTiers = new LireLesoptionsTiers();
      this.lireLesoptionsTiers.setStrId(this.structureLog.getStrid());
      this.optionTiers = new OptionTiers();
      this.optionTiers = this.lireLesoptionsTiers.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void recupererDevisesItem(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItem = new ArrayList();
      this.mesdevisesItem = this.deviseDao.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
   }

   public void recupererLesSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      if (this.module == 81500) {
         ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         this.mesSitesItems = var2.chargerLesServicesItems(2, false, var1);
      } else {
         this.mesSitesItems = this.siteDao.chargerLesSitesItems(var1);
      }

   }

   public void recupererCaissesItem(Session var1) throws HibernateException, NamingException {
      this.mesCaissesItems = new ArrayList();
      CaissesCommercialesDao var2 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.mesCaissesItems = var2.selectActifCaisseItems(var1);
   }

   public void recupererCaisses(Session var1) throws HibernateException, NamingException {
      this.listCaisses = new ArrayList();
      new ArrayList();
      List var2 = this.usersChronoDao.selectListCaisseByUser(this.usersLog, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if ((((UsersChrono)var2.get(var3)).getUsrchrNature() == 60 || ((UsersChrono)var2.get(var3)).getUsrchrNature() == 61) && ((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse() != null && !((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse().isEmpty()) {
               String var4 = ((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)var2.get(var3)).getUsrchrLib();
               this.listCaisses.add(var2.get(var3));
            }
         }
      }

   }

   public void recupererRegionItem(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      this.mesRegionsItems = this.regionDao.chargerLesRegionItems(var1);
   }

   public void recupererPdvItem(Session var1) throws HibernateException, NamingException {
      this.mesPdvItems = new ArrayList();
      this.mesPdvItems = this.pointDeVenteDao.chargerLesPointDeVenteItems(var1);
   }

   public List recupererCategorieItem(String var1) throws IOException {
      this.mesCategoriesItems = new ArrayList();
      LectureCategorieTiers var2 = new LectureCategorieTiers(var1);
      this.mesCategoriesItems = var2.getMesCategoriesTiersItems();
      return this.mesCategoriesItems;
   }

   public void recupererPecItem() throws IOException {
      this.mesPecItems = new ArrayList();
      LectureCategorieTiers var1 = new LectureCategorieTiers("034");
      this.mesPecItems = var1.getMesCategoriesTiersItems();
   }

   public void recupererProtocolesItems(Session var1) throws HibernateException, NamingException {
      this.mesProtocoleItems = new ArrayList();
      new ExercicesVentes();
      ExercicesVentesDao var3 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         ProtocoleMedicalDao var4 = new ProtocoleMedicalDao(this.baseLog, this.utilInitHibernate);
         this.mesProtocoleItems = var4.selectActifProtocoleItems(var2.getExevteId(), var1);
      }

   }

   public void recupererAppreciationItem() throws IOException {
      this.mesAppreciationsItems = new ArrayList();
      LectureAppreciations var1 = new LectureAppreciations();
      this.mesAppreciationsItems = var1.getMesAppreciationItems();
   }

   public void recupererFamillesFournisseursItem() throws JDOMException, IOException {
      this.mesFamilleFournisseursItems = new ArrayList();
      this.lesFamilleFournisseursListe = new ArrayList();
      LectureFamillesFournisseurs var1 = new LectureFamillesFournisseurs();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesFournisseurItems();
      this.mesFamilleFournisseursItems = var1.getMesFamillesFournisseursItems();
      this.lesFamilleFournisseursListe = var1.getMesFamillesFournisseurs();
   }

   public void recupererFamillesClientsItem() throws JDOMException, IOException {
      this.mesFamilleClientsItems = new ArrayList();
      this.lesFamilleClientsListe = new ArrayList();
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.mesFamilleClientsItems = var1.getMesFamillesClientsItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
   }

   public void recupererPaysItem() throws IOException {
      this.mesPaysItems = new ArrayList();
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
   }

   public void recupererCivilitesItem() throws IOException {
      this.mesCivilitesItems = new ArrayList();
      LectureCivilites var1 = new LectureCivilites(0);
      this.mesCivilitesItems = var1.getMesCivilitesItems();
      boolean var2 = false;
      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().equals("81500")) {
         var2 = true;
      } else if (this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().equals("81500")) {
         var2 = true;
      }

      if (var2) {
         this.mesCivilitesItemsMedicale = new ArrayList();
         var1 = new LectureCivilites(1);
         this.mesCivilitesItemsMedicale = var1.getMesCivilitesItems();
      }

   }

   public void recupererFonctionsItem() throws IOException {
      this.mesFonctionsItems = new ArrayList();
      LectureFonctions var1 = new LectureFonctions(this.usersLog.getUsrCivilite());
      this.mesFonctionsItems = var1.getMesfonctionsItems();
   }

   public void recupererLangueItem() throws IOException {
      this.mesLangueItems = new ArrayList();
      LectureLangues var1 = new LectureLangues();
      this.mesLangueItems = var1.getMesLanguesItems();
   }

   public void recupererSourceItem() throws IOException {
      this.mesSourceItems = new ArrayList();
      LectureSourcesTiers var1 = new LectureSourcesTiers(this.structureLog.getStrid());
      this.mesSourceItems = var1.getMesSourcesTiersItems();
   }

   public void recupererQualiteEleveItem() throws IOException {
      this.mesQualiteItems = new ArrayList();
      LectureQualitesContact var1 = new LectureQualitesContact(809);
      this.mesQualiteItems = var1.getMesQualitesItems();
   }

   public void recupererQualitePatientItem() throws IOException {
      this.mesQualiteItems = new ArrayList();
      LectureQualitesContact var1 = new LectureQualitesContact(815);
      this.mesQualiteItems = var1.getMesQualitesItems();
   }

   public void recupererAntecedentItem() throws IOException {
      this.mesAntecedentItems = new ArrayList();
      LectureAntecedentCDA var1 = new LectureAntecedentCDA();
      this.mesAntecedentItems = var1.getMesAntecedentCDAItems();
   }

   public void recupererReglementClient() throws IOException {
      this.mesReglementClientItems = new ArrayList();
      this.lesReglementClientListe = new ArrayList();
      LectureReglementClient var1 = new LectureReglementClient();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementClient();
      this.mesReglementClientItems = var1.getMesReglementClientItems();
      this.lesReglementClientListe = var1.getMesReglementClient();
   }

   public void recupererReglementFournisseur() throws IOException {
      this.mesReglementFournisseurItems = new ArrayList();
      this.lesReglementFournisseurListe = new ArrayList();
      LectureReglementFournisseur var1 = new LectureReglementFournisseur();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementFournisseur();
      this.mesReglementFournisseurItems = var1.getMesReglementFournisseurItems();
      this.lesReglementFournisseurListe = var1.getMesReglementFournisseur();
   }

   public void recupererUserItem(Session var1) throws HibernateException, NamingException {
      this.mesUserItems = new ArrayList();
      this.mesUserItems = this.userDao.chargerLesUsersItem(var1);
   }

   public void recupererActivitesItem(Session var1) throws HibernateException, NamingException {
      this.mesActivitesPMItems = new ArrayList();
      MetiersDao var2 = new MetiersDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesPMItems = var2.chargerLesMetiersPM(var1);
      this.mesActivitesPPItems = new ArrayList();
      var2 = new MetiersDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesPPItems = var2.chargerLesMetiersPP(var1);
   }

   public void recupererFamillesVentesItem(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesFamilleVentestems = new ArrayList();
      new ExercicesVentes();
      ExercicesVentesDao var3 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         FamillesProduitsVentesDao var4 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         this.mesFamilleVentestems = var4.chargerFamilleProduitVentesItems(var2.getExevteId(), var1);
      }

   }

   public void recupererDepotItem(Session var1) throws IOException, HibernateException, NamingException {
      this.mesDepotItems = new ArrayList();
      new ExercicesAchats();
      ExercicesAchatsDao var3 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      ExercicesAchats var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         DepotAchatsDao var4 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         this.mesDepotItems = var4.selectActifDepotItems(0, var1);
      }

   }

   public void recupererSerieItem(Session var1) throws IOException, HibernateException, NamingException {
      this.mesSeriesItems = new ArrayList();
      this.mesSeriesItems = this.chronoDao.selectListSerieItem(var1);
   }

   public void recupererCentresImpots() throws IOException {
      this.mesZonesFiscales = new ArrayList();
      LectureCentresImpots var1 = new LectureCentresImpots();
      var1.setStructureLog(this.structureLog);
      var1.recuperePaye();
      this.mesZonesFiscales = var1.getMesCentresImpotsItems();
   }

   public void chargerlesmodelesFichesImpressionsTiers() throws HibernateException, NamingException {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "document";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems.clear();
      String[] var3 = var2.list();
      String var7;
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     var7 = var5.substring(0, var5.indexOf("."));
                     this.documentImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

      new ArrayList();
      ModelesCourriersDao var11 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      List var10 = var11.selectModelesVentes((Session)null);
      int var12;
      if (var10.size() != 0) {
         for(var12 = 0; var12 < var10.size(); ++var12) {
            this.documentImpressionItems.add(new SelectItem(((ModelesCourriers)var10.get(var12)).getModCode() + ":" + ((ModelesCourriers)var10.get(var12)).getModNomFr()));
         }
      }

      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "rib";
      var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            this.documentRibImpressionItems.clear();

            for(var12 = 0; var12 < var3.length; ++var12) {
               var7 = var3[var12];
               if (var7.endsWith(".jasper")) {
                  String var8 = var3[var12];
                  if (this.verificationAutorisation(var8)) {
                     String var9 = var7.substring(0, var7.indexOf("."));
                     this.documentRibImpressionItems.add(new SelectItem(var9));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListesImpressionsTiers() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "liste";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListesImpressionsCataloguesTiers() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "catalogue";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionCatalogueItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionCatalogueItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesFichesImpressionsDestinataire() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "destinataire" + File.separator + "document";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.documentImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListesImpressionsDestinataire() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "destinataire" + File.separator + "liste";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesFichesImpressionsAgents() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "agent" + File.separator + "document";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.documentImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListesImpressionsAgents() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "agent" + File.separator + "liste";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesFicheimpressionsPatient() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "patient" + File.separator + "document";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListeimpressionsPatient() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "patient" + File.separator + "liste";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesFicheimpressionsEleve() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListeimpressionsEleve() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionItems.add(new SelectItem(var7));
                  }
               }
            }
         }
      }

   }

   public void chargerlesmodelesListeimpressionsContact() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "contact";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionContactItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               String var5 = var3[var4];
               if (var5.endsWith(".jasper")) {
                  String var6 = var3[var4];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var5.substring(0, var5.indexOf("."));
                     this.listeImpressionContactItems.add(new SelectItem(var7));
                  }
               }
            }
         }
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

   public void recupererConfigListeEntete() throws IOException {
      if (this.menutiers != null) {
         LectureConfigListeEntete var1 = new LectureConfigListeEntete();
         var1.recupereFonctions(this.structureLog.getStrid(), 0, this.menutiers.getGenre());
         this.configListeEntete = var1.getConfigListeEntete();
      }

   }

   public void memoriseConfigListeEntete() throws IOException {
      if (this.menutiers != null) {
         LectureConfigListeEntete var1 = new LectureConfigListeEntete();
         String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), 0, this.menutiers.getGenre());
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

   }

   public void recupererConfigListeLigne() throws IOException {
      if (this.menutiers != null) {
         LectureConfigListeLigne var1 = new LectureConfigListeLigne();
         var1.recupereFonctions(this.structureLog.getStrid(), 0, this.menutiers.getGenre());
         this.configListeLigne = var1.getConfigListeLigne();
      }

   }

   public void memoriseConfigListeLigne() throws IOException {
      if (this.menutiers != null) {
         LectureConfigListeLigne var1 = new LectureConfigListeLigne();
         String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), 0, this.menutiers.getGenre());
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

   }

   public String[] triAlphabetique(String[] var1, int var2) {
      int var3 = var2;
      boolean var4;
      if (var2 != 0) {
         do {
            var4 = false;

            for(int var5 = 0; var5 < var3 - 1; ++var5) {
               if (var1[var5].compareToIgnoreCase(var1[var5 + 1]) > 0) {
                  this.echanger(var1, var5, var5 + 1);
                  var4 = true;
               }
            }

            --var3;
         } while(var4);
      }

      return var1;
   }

   public void echanger(String[] var1, int var2, int var3) {
      String var4 = var1[var2];
      var1[var2] = var1[var3];
      var1[var3] = var4;
   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
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

   public void importationFichier() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
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
                        if (var8.contains("#MECG")) {
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

   public void preparationTransfertImport(List var1) throws IOException, NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.formTransfertTiers = new FormTransfertTiers();
      this.formTransfertTiers.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertTiers.setBaseLog(this.baseLog);
      this.formTransfertTiers.setStructureLog(this.structureLog);
      this.formTransfertTiers.setUsersLog(this.usersLog);
      this.formTransfertTiers.InstancesDaoUtilses();
      this.formTransfertTiers.setOptionTiers(this.optionTiers);
      this.formTransfertTiers.transfertImport(var1);
      this.formTransfertTiers.setFormRecherche(this.formRecherche);
      this.affichePage = "/tiers/TransfertTiers.jsp";
      this.setQuelTransfert("importExterne");
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitTiersCtrl getMenudroitTiersCtrl() {
      return this.menudroitTiersCtrl;
   }

   public void setMenudroitTiersCtrl(MenudroitTiersCtrl var1) {
      this.menudroitTiersCtrl = var1;
   }

   public ObjetLigneMenu getMenutiers() {
      return this.menutiers;
   }

   public void setMenutiers(ObjetLigneMenu var1) {
      this.menutiers = var1;
   }

   public FormTiers getFormTiers() {
      return this.formTiers;
   }

   public void setFormTiers(FormTiers var1) {
      this.formTiers = var1;
   }

   public String getLibelleSousMenu() {
      return this.libelleSousMenu;
   }

   public void setLibelleSousMenu(String var1) {
      this.libelleSousMenu = var1;
   }

   public FormDestinataires getFormDestinataires() {
      return this.formDestinataires;
   }

   public void setFormDestinataires(FormDestinataires var1) {
      this.formDestinataires = var1;
   }

   public FormPatients getFormPatients() {
      return this.formPatients;
   }

   public void setFormPatients(FormPatients var1) {
      this.formPatients = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public List getMesAppreciationsItems() {
      return this.mesAppreciationsItems;
   }

   public void setMesAppreciationsItems(List var1) {
      this.mesAppreciationsItems = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
   }

   public List getMesFonctionsItems() {
      return this.mesFonctionsItems;
   }

   public void setMesFonctionsItems(List var1) {
      this.mesFonctionsItems = var1;
   }

   public List getMesLangueItems() {
      return this.mesLangueItems;
   }

   public void setMesLangueItems(List var1) {
      this.mesLangueItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesPecItems() {
      return this.mesPecItems;
   }

   public void setMesPecItems(List var1) {
      this.mesPecItems = var1;
   }

   public List getMesQualiteItems() {
      return this.mesQualiteItems;
   }

   public void setMesQualiteItems(List var1) {
      this.mesQualiteItems = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesSourceItems() {
      return this.mesSourceItems;
   }

   public void setMesSourceItems(List var1) {
      this.mesSourceItems = var1;
   }

   public List getMesUserItems() {
      return this.mesUserItems;
   }

   public void setMesUserItems(List var1) {
      this.mesUserItems = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public List getMesAntecedentItems() {
      return this.mesAntecedentItems;
   }

   public void setMesAntecedentItems(List var1) {
      this.mesAntecedentItems = var1;
   }

   public List getMesDepotItems() {
      return this.mesDepotItems;
   }

   public void setMesDepotItems(List var1) {
      this.mesDepotItems = var1;
   }

   public List getMesFamilleClientsItems() {
      return this.mesFamilleClientsItems;
   }

   public void setMesFamilleClientsItems(List var1) {
      this.mesFamilleClientsItems = var1;
   }

   public List getMesFamilleFournisseursItems() {
      return this.mesFamilleFournisseursItems;
   }

   public void setMesFamilleFournisseursItems(List var1) {
      this.mesFamilleFournisseursItems = var1;
   }

   public List getMesReglementClientItems() {
      return this.mesReglementClientItems;
   }

   public void setMesReglementClientItems(List var1) {
      this.mesReglementClientItems = var1;
   }

   public List getMesReglementFournisseurItems() {
      return this.mesReglementFournisseurItems;
   }

   public void setMesReglementFournisseurItems(List var1) {
      this.mesReglementFournisseurItems = var1;
   }

   public List getMesProtocoleItems() {
      return this.mesProtocoleItems;
   }

   public void setMesProtocoleItems(List var1) {
      this.mesProtocoleItems = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
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

   public List getMesActivitesPMItems() {
      return this.mesActivitesPMItems;
   }

   public void setMesActivitesPMItems(List var1) {
      this.mesActivitesPMItems = var1;
   }

   public List getMesActivitesPPItems() {
      return this.mesActivitesPPItems;
   }

   public void setMesActivitesPPItems(List var1) {
      this.mesActivitesPPItems = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public FormAgents getFormAgents() {
      return this.formAgents;
   }

   public void setFormAgents(FormAgents var1) {
      this.formAgents = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public DataModel getDataModelTiers() {
      return this.dataModelTiers;
   }

   public void setDataModelTiers(DataModel var1) {
      this.dataModelTiers = var1;
   }

   public String getLettre() {
      return this.lettre;
   }

   public void setLettre(String var1) {
      this.lettre = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public boolean isShowModalPanelContact() {
      return this.showModalPanelContact;
   }

   public void setShowModalPanelContact(boolean var1) {
      this.showModalPanelContact = var1;
   }

   public String getUrlphoto() {
      return this.urlphoto;
   }

   public void setUrlphoto(String var1) {
      this.urlphoto = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public FormEleves getFormEleves() {
      return this.formEleves;
   }

   public void setFormEleves(FormEleves var1) {
      this.formEleves = var1;
   }

   public List getDocumentRibImpressionItems() {
      return this.documentRibImpressionItems;
   }

   public void setDocumentRibImpressionItems(List var1) {
      this.documentRibImpressionItems = var1;
   }

   public List getMesCivilitesItemsMedicale() {
      return this.mesCivilitesItemsMedicale;
   }

   public void setMesCivilitesItemsMedicale(List var1) {
      this.mesCivilitesItemsMedicale = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public List getMesSeriesItems() {
      return this.mesSeriesItems;
   }

   public void setMesSeriesItems(List var1) {
      this.mesSeriesItems = var1;
   }

   public List getListeImpressionContactItems() {
      return this.listeImpressionContactItems;
   }

   public void setListeImpressionContactItems(List var1) {
      this.listeImpressionContactItems = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public List getMesZonesFiscales() {
      return this.mesZonesFiscales;
   }

   public void setMesZonesFiscales(List var1) {
      this.mesZonesFiscales = var1;
   }

   public FormCadeaux getFormCadeaux() {
      return this.formCadeaux;
   }

   public void setFormCadeaux(FormCadeaux var1) {
      this.formCadeaux = var1;
   }

   public List getListeImpressionCatalogueItems() {
      return this.listeImpressionCatalogueItems;
   }

   public void setListeImpressionCatalogueItems(List var1) {
      this.listeImpressionCatalogueItems = var1;
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

   public boolean isAfficheStatistique() {
      return this.afficheStatistique;
   }

   public void setAfficheStatistique(boolean var1) {
      this.afficheStatistique = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public String getSousTitreGraph() {
      return this.sousTitreGraph;
   }

   public void setSousTitreGraph(String var1) {
      this.sousTitreGraph = var1;
   }

   public String getTitreGraph() {
      return this.titreGraph;
   }

   public void setTitreGraph(String var1) {
      this.titreGraph = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public FormTransfertTiers getFormTransfertTiers() {
      return this.formTransfertTiers;
   }

   public void setFormTransfertTiers(FormTransfertTiers var1) {
      this.formTransfertTiers = var1;
   }

   public String getQuelTransfert() {
      return this.quelTransfert;
   }

   public void setQuelTransfert(String var1) {
      this.quelTransfert = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public int getModule() {
      return this.module;
   }

   public void setModule(int var1) {
      this.module = var1;
   }
}
