package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesCapitalisation;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.SalariesTaches;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculFormuleDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.SalariesCapitalisationDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesPretsDao;
import com.epegase.systeme.dao.SalariesPretsLignesDao;
import com.epegase.systeme.dao.SalariesTachesDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.formbakingbeans.FormBakingBeanPaye;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.LectureNaturePrets;
import com.epegase.systeme.xml.LectureNatureRH;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetGrilleSalaire;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.OptionPaye;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormFicheSalarie implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionPaye optionPaye;
   private ExercicesPaye exercicesPaye;
   private ExercicesPaye lastExoPaye;
   private EspionDao espionDao;
   private HabilitationDao habilitationDao;
   private CalculChrono calculChrono;
   private UsersChrono usersChronoPret = new UsersChrono();
   private UsersChrono usersChronoContrat = new UsersChrono();
   private UsersChrono usersChronoConge = new UsersChrono();
   private UsersChrono usersChronoAbsence = new UsersChrono();
   private UsersChrono usersChronoBulletin = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private int var_nb_max = 100;
   private String nomSalarie;
   private boolean valideSalarie;
   private boolean var_acc_identification = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_familial = false;
   private boolean var_acc_contrat = false;
   private boolean var_acc_grh = false;
   private boolean var_acc_conges = false;
   private boolean var_acc_absences = false;
   private boolean var_acc_prets = false;
   private boolean var_acc_historiques = false;
   private boolean var_acc_bulletins = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean accesPrets;
   private boolean accesContrats;
   private boolean accesConges;
   private boolean accesAbsences;
   private boolean accesMissions;
   private boolean accesBulletins;
   private boolean accesInterim;
   private boolean accesPretsProtege;
   private boolean accesContratsProtege;
   private boolean accesRhProtege;
   private boolean accesAutreProtege;
   private boolean var_more_search = false;
   private List mesNatureAgentItems;
   private List mesServiceItems;
   private List mesSitesItems;
   private List mesDepartementsItems = new ArrayList();
   private List mesDepartementsImputationItems = new ArrayList();
   private List mesCentresImpotsItems;
   private List mesCentresSecuritesItems;
   private List mesClassementsItems;
   private List mesNiveauxEmploisItems;
   private List mesCodesEmploisItems;
   private List mesConventionsItems;
   private List mesGrillesItems = new ArrayList();
   private List lesGrilles = new ArrayList();
   private List mesCiviliteItems;
   private List lesCivilites;
   private List mesPaysUtilItems = new ArrayList();
   private List mesPaysItems;
   private List lesPays;
   private List mesNationnalitesItems;
   private List mesLanguesItems;
   private List mesActiviteItems;
   private List mesLocalisationItems;
   private List mesBudgetItems;
   private List mesProjetItems;
   private List mesParcItems;
   private List mesFeuillesItems;
   private List mesFeuillesContratItems = new ArrayList();
   private List mesClesItems;
   private boolean afficheCodesEmplois;
   private Date parMois = new Date();
   private String var_immat_rec = "";
   private String var_nom_rec = "";
   private String var_feuille_rec = "100";
   private String var_nature_rec = "100";
   private String var_site_rec = "100";
   private String var_departement_rec = "100";
   private String var_service_rec = "100";
   private String var_activite_rec = "100";
   private String var_localisation_rec = "100";
   private String var_projet_rec = "100";
   private String var_convention_rec = "100";
   private String var_niveau_rec = "100";
   private String var_classement_rec = "100";
   private String var_grille_rec = "100";
   private String var_centre_rec = "100";
   private String var_securite_rec = "100";
   private String var_pays_rec = "100";
   private String var_periode = "";
   private int var_etat_rec = 0;
   private int var_valide_rec = 100;
   private int var_rh_rec = 100;
   private int var_typerh_rec = 0;
   private int var_pret_rec = 100;
   private int var_nat_rec = 100;
   private String var_budget_rec;
   private String var_tiers_rec;
   private Date inpDu;
   private Date inpAu;
   private boolean affiche_site = false;
   private boolean affiche_departement = false;
   private boolean affiche_service = false;
   private boolean affiche_activite = false;
   private boolean var_affiche_nomJf = true;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private List lesSalaries = new ArrayList();
   private transient DataModel datamodelSalaries = new ListDataModel();
   private UIDataTable extDTableSal = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEnteteSal = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private boolean showModalVisuEtat = false;
   private boolean bulletinExiste = false;
   private String libelle_securite;
   private String libelle_retraite;
   private boolean accesOrange;
   private boolean nouvelleCreation;
   private String var_nature;
   private UtilDownload utilDownload = new UtilDownload();
   private String fileName;
   private String urlphotoAgent;
   private UploadedFile uploadedFile = null;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private SalariesContrats salariesContrats = new SalariesContrats();
   private SalariesContratsDao salariesContratsDao;
   private boolean var_affiche_contrat = false;
   private transient DataModel dataModelContrat = new ListDataModel();
   private UIDataTable extDTableCrt = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEnteteCrt = new SimpleSelection();
   private List lesSalariesContrats = new ArrayList();
   private boolean showModalPanelContrat = false;
   private int var_action_contrat;
   private int var_ligne_contrat;
   private String var_feuille;
   private String var_site;
   private String var_departement;
   private String var_service;
   private long var_tiers;
   private String var_convention;
   private String var_niveau;
   private String var_classement;
   private String var_grille;
   private String var_centre;
   private String var_securite;
   private String var_activite;
   private String var_localisation;
   private String var_budget;
   private String var_projet;
   private String var_cle1;
   private String var_cle2;
   private List mesModelesItems = new ArrayList();
   private String var_code_modele;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean afficheTexteContrat = false;
   private String var_lib_contrat;
   private boolean ajoutCrt = false;
   private String nomrepertRHcontrat;
   private boolean var_affFicPdfContrat;
   private boolean contratValide;
   private SalariesContrats salariesContratsMuter;
   private String var_siteMuter;
   private String var_departementMuter;
   private String var_serviceMuter;
   private String var_conventionMuter;
   private String var_niveauMuter;
   private String var_classementMuter;
   private String var_grilleMuter;
   private String var_centreMuter;
   private String var_activiteMuter;
   private String var_localisationMuter;
   private String var_budgetMuter;
   private String var_projetMuter;
   private String var_cle1Muter;
   private String var_cle2Muter;
   private String var_code_modeleMuter;
   private List lesDecoupagesActivitesMuter;
   private transient DataModel dataModelDecoupageActivtesMuter;
   private List lesNAt = new ArrayList();
   private SalariesGrh salariesGrh = new SalariesGrh();
   private SalariesGrhDao salariesGrhDao;
   private transient DataModel dataModelGrh = new ListDataModel();
   private UIDataTable extDTableGrh = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEnteteGrh = new SimpleSelection();
   private List lesSalariesGrh = new ArrayList();
   private boolean showModalPanelRh = false;
   private boolean var_affiche_rh = false;
   private int var_action_rh;
   private List mesElementRhItems = new ArrayList();
   private List mesTypeRhItems = new ArrayList();
   private String var_objet_automatique;
   private boolean var_affiche_tdt_rh = false;
   private String var_lib_rh;
   private String var_typelib_rh;
   private boolean var_affFicPdf;
   private boolean var_affFicPdfRh;
   private UploadedFile uploadedPDFFile;
   private String pdfFileName;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private boolean showModalPanelPdf = false;
   private boolean ajoutRh = false;
   private String nomrepertRH;
   private SalariesConges salariesConges = new SalariesConges();
   private SalariesCongesDao salariesCongesDao;
   private transient DataModel dataModelConges = new ListDataModel();
   private List lesSalariesConges = new ArrayList();
   private float nbInit;
   private float nbAcquis;
   private float nbPris;
   private float nbRestant;
   private SalariesConges salariesAbsences = new SalariesConges();
   private transient DataModel dataModelAbsences = new ListDataModel();
   private List lesSalariesAbsences = new ArrayList();
   private SalariesPrets salariesPrets = new SalariesPrets((List)null);
   private SalariesPretsDao salariesPretsDao;
   private transient DataModel dataModelPretsInternes = new ListDataModel();
   private transient DataModel dataModelPretsExternes = new ListDataModel();
   private transient DataModel dataModelPretsManuels = new ListDataModel();
   private List lesSalariesPretsInternes = new ArrayList();
   private List lesSalariesPretsExternes = new ArrayList();
   private List lesSalariesPretsManuels = new ArrayList();
   private SalariesPretsLignes salariesPretsLignes;
   private SalariesPretsLignesDao salariesPretsLignesDao;
   private transient DataModel dataModelPretsLignes = new ListDataModel();
   private List lesSalariesPretsLignes = new ArrayList();
   private boolean var_affiche_prets = false;
   private boolean var_affiche_lignes = false;
   private double total_pret_interne;
   private double total_rmb_interne;
   private double solde_pret_interne;
   private double total_pret_externe;
   private double total_rmb_externe;
   private double solde_pret_externe;
   private double total_pret_manuel;
   private double total_rmb_manuel;
   private double solde_pret_manuel;
   private String var_lib_pret;
   private int typePret;
   private SalariesCapitalisation salariesCapitalisation;
   private SalariesCapitalisationDao salariesCapitalisationDao;
   private List lesLignesCapitalisation = new ArrayList();
   private transient DataModel dataModelCapitalisation = new ListDataModel();
   private double total_versement;
   private double total_retrait;
   private double solde_capitalisation;
   private boolean showModalPanelCapitalisation = false;
   private boolean capitalisationActive = false;
   private SalariesHistorique salariesHistorique = new SalariesHistorique();
   private SalariesHistoriqueDao salariesHistoriqueDao;
   private transient DataModel dataModelHistorique = new ListDataModel();
   private List lesSalariesHistorique = new ArrayList();
   private boolean showModalPanelHistorique = false;
   private boolean var_affiche_historique = false;
   private boolean var_valide_historique = false;
   private int var_action_historique;
   private List lesContratsActifsItems = new ArrayList();
   private List lesBulletins = new ArrayList();
   private BulletinSalaireDao bulletinSalaireDao;
   private transient DataModel dataModelSimulationLigne = new ListDataModel();
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private List listeAvenantItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private int var_modele;
   private FormRecherche formRecherche;
   private boolean showModalGoogleMap = false;
   private URI uri;
   private FormBakingBeanPaye formBakingBeanPaye;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites = new ArrayList();
   private transient DataModel dataModelDecoupageActivtes = new ListDataModel();
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private double totalImputation;
   private double soldeImputation;
   private int numLignePret;
   private boolean var_option_parc;
   private boolean var_sursalaire;
   private boolean var_forfaitHeureSup;
   private boolean var_forfaitPrestataire;
   private boolean var_outillage;
   private boolean var_astreinte;
   private boolean var_redement;
   private boolean var_responsbilite;
   private boolean var_fonction;
   private boolean var_prm_transport;
   private boolean var_prm_logement;
   private boolean var_sujetion;
   private boolean var_exceptionnel;
   private boolean var_caisse;
   private boolean var_deplacement;
   private boolean var_logement;
   private boolean var_transport;
   private boolean var_kilometre;
   private boolean var_salissure;
   private boolean var_representation;
   private boolean var_diverse;
   private boolean var_indemResons;
   private boolean var_nourriture;
   private boolean var_avn_logement;
   private boolean var_avn_domesticite;
   private boolean var_avn_eau;
   private boolean var_avn_electricite;
   private boolean var_avn_nourriture;
   private boolean var_avn_vehicule;
   private boolean var_avn_telephone;
   private FeuilleCalculFormuleDao feuilleCalculFormuleDao;
   private FeuilleCalculDao feuilleCalculDao;
   private boolean showModalPanelChangerMatricule = false;
   private String var_nouveau_matricule;
   private boolean var_unicite;
   private List mesTiersItems = new ArrayList();
   private boolean showModalPanelImputation = false;
   private boolean showModalPanelSms = false;
   private String numeroMobile;
   private String messageSms;
   private boolean showModalPanelGraph = false;
   private int timeDecoupage;
   private int modeGraph;
   private int valQteGraph;
   private String titreGraph;
   private String sousTitreGraph;
   private String uniteGraph;
   private int nbDecGraph;
   private String deviseGraph;
   private boolean showModele;
   private boolean showModalPanelAvenant = false;
   private int nbAvenant;
   private boolean afficheAvenant = false;
   private transient DataModel dataModelAvenants = new ListDataModel();
   private String nomAvenant;
   private boolean showModalPanelAjoutAvenant = false;
   private List lesAvenants = new ArrayList();
   private String nomRepertoireAvenant;
   private boolean showModalPanelPjAvenant = false;
   private List mesNaturesPretsItems = new ArrayList();
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private boolean showModalPanelListeTache;
   private boolean showModalPanelTache;
   private List mesTachesItems;
   private TachesDao tachesDao;
   private SalariesTachesDao salariesTachesDao;
   private SalariesTaches salariesTaches;
   private List lesTachesAgents;
   private transient DataModel dataModelTachesAgents;
   private boolean selectTache;

   public FormFicheSalarie() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      this.salariesGrhDao = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
      this.salariesCongesDao = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
      this.salariesCapitalisationDao = new SalariesCapitalisationDao(this.baseLog, this.utilInitHibernate);
      this.salariesPretsDao = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
      this.salariesPretsLignesDao = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
      this.salariesHistoriqueDao = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculFormuleDao = new FeuilleCalculFormuleDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.chargerUserChronoContrat(var1);
      this.chargerUserChronoPret(var1);
      this.chargerUserChronoConge(var1);
      this.chargerUserChronoAbsence(var1);
      this.chargerUserChronoBulletin(var1);
      this.recupererNaturesRHItem();
      if (this.structureLog.getStrcodepays().equals("0077")) {
         this.libelle_securite = "N° C.N.S.S.";
      } else if (this.structureLog.getStrcodepays().equals("0138")) {
         this.libelle_securite = "N° I.N.P.S.";
      } else {
         this.libelle_securite = "N° Sécurité sociale";
      }

      if (this.structureLog.getStrcodepays().equals("0202")) {
         this.libelle_retraite = "N° IPRES";
      } else {
         this.libelle_retraite = "N° Retraite";
      }

      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

      this.accesPaiement();
   }

   public void initialisationRoster(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.chargerUserChronoContrat(var1);
      this.chargerUserChronoConge(var1);
      this.chargerUserChronoAbsence(var1);
      this.recupererNaturesRHItem();
      this.mesPaysUtilItems.clear();
      this.mesPaysUtilItems = this.salariesDao.listePaysUtil(var1);
      this.accesPaiement();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void initialisationRh(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.recupererNaturesRHItem();
      this.salaries = new Salaries();
      this.salaries.setSalSitFamille(1);
      this.salaries.setSalMiseRelation(false);
      this.var_rh_rec = 100;
      this.usersChronoConge = this.usersChronoDao.chronoByUserNat(this.usersLog, 88, var1);
      this.accesPaiement();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void initialisationImputation(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.recupererNaturesRHItem();
      this.var_nature_rec = "100";
      this.usersChronoContrat = this.usersChronoDao.chronoByUserNat(this.usersLog, 82, var1);
      this.accesPaiement();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void initialisationContrat(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.recupererNaturesRHItem();
      this.var_pret_rec = 100;
      this.usersChronoContrat = this.usersChronoDao.chronoByUserNat(this.usersLog, 82, var1);
      this.accesPaiement();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void intialisationTache(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.showModalPanelListeTache = false;
      this.showModalPanelTache = false;
      this.mesTachesItems = new ArrayList();
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.mesTachesItems = this.tachesDao.selectTachesActifItem(var1);
      this.salariesTachesDao = new SalariesTachesDao(this.baseLog, this.utilInitHibernate);
      this.salariesTaches = new SalariesTaches();
      this.lesTachesAgents = new ArrayList();
      this.dataModelTachesAgents = new ListDataModel();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void accesPaiement() throws JDOMException, IOException {
      this.accesOrange = this.structureLog.getStrcpteorange() != null && !this.structureLog.getStrcpteorange().isEmpty();
      this.affiche_site = this.mesSitesItems != null && this.mesSitesItems.size() >= 2;
      this.affiche_departement = this.mesDepartementsItems != null && this.mesDepartementsItems.size() >= 2;
      this.affiche_service = this.mesServiceItems != null && this.mesServiceItems.size() >= 2;
      this.affiche_activite = this.mesActiviteItems != null && this.mesActiviteItems.size() >= 2;
      LectureNaturePrets var1 = new LectureNaturePrets();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      this.mesNaturesPretsItems = var1.chargerMesNaturesPretsItems();
   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() throws HibernateException, NamingException {
      this.var_acc_identification = false;
      this.var_acc_complement = false;
      this.var_acc_familial = false;
      this.var_acc_contrat = false;
      this.var_acc_grh = false;
      this.var_acc_conges = false;
      this.var_acc_absences = false;
      this.var_acc_prets = false;
      this.var_acc_historiques = false;
      this.var_acc_bulletins = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_identification = true;
            } else if (var1.getCode().equals("2")) {
               if (this.salaries != null && (this.salaries.getSalProtege() == 0 || this.salaries.getSalProtege() == 1 && this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) || this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) {
                  this.var_acc_complement = true;
               } else if (this.salaries == null) {
                  this.var_acc_complement = true;
               }
            } else if (var1.getCode().equals("3")) {
               if ((this.salaries == null || this.salaries.getSalProtege() != 0 && (this.salaries.getSalProtege() != 1 || this.usersLog.getUsrPaye() < 0 || this.usersLog.getUsrPaye() > 3)) && (this.usersLog.getUsrPaye() < 0 || this.usersLog.getUsrPaye() > 3)) {
                  if (this.salaries == null) {
                     this.var_acc_familial = true;
                  }
               } else {
                  this.var_acc_familial = true;
               }
            } else if (var1.getCode().equals("4")) {
               if (this.usersChronoContrat != null) {
                  if ((this.salaries == null || this.salaries.getSalProtege() != 0 && (this.salaries.getSalProtege() != 1 || this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 3)) && (this.usersLog.getUsrPaye() < 0 || this.usersLog.getUsrPaye() > 3)) {
                     if (this.salaries == null) {
                        this.var_acc_contrat = true;
                     }
                  } else {
                     this.var_acc_contrat = true;
                  }
               }
            } else if (var1.getCode().equals("5")) {
               if ((this.salaries == null || this.salaries.getSalProtege() != 0 && (this.salaries.getSalProtege() != 1 || this.usersLog.getUsrPaye() < 0 || this.usersLog.getUsrPaye() > 3)) && (this.usersLog.getUsrPaye() < 0 || this.usersLog.getUsrPaye() > 3)) {
                  if (this.salaries == null) {
                     this.var_acc_grh = true;
                  }
               } else {
                  this.var_acc_grh = true;
               }
            } else if (var1.getCode().equals("6")) {
               if (this.usersChronoConge != null) {
                  if (this.salaries != null && (this.salaries.getSalProtege() == 0 || this.salaries.getSalProtege() == 1 && this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) || this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) {
                     this.var_acc_conges = true;
                  } else if (this.salaries == null) {
                     this.var_acc_conges = true;
                  }
               }
            } else if (var1.getCode().equals("7")) {
               if (this.usersChronoAbsence != null) {
                  if (this.salaries != null && (this.salaries.getSalProtege() == 0 || this.salaries.getSalProtege() == 1 && this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) || this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) {
                     this.var_acc_absences = true;
                  } else if (this.salaries == null) {
                     this.var_acc_absences = true;
                  }
               }
            } else if (var1.getCode().equals("8")) {
               if (this.usersChronoPret != null) {
                  if ((this.salaries == null || this.salaries.getSalProtege() != 0 && (this.salaries.getSalProtege() != 1 || this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 2 && this.usersLog.getUsrPaye() != 3)) && (this.usersLog.getUsrPaye() < 0 || this.usersLog.getUsrPaye() > 3)) {
                     if (this.salaries == null) {
                        this.var_acc_prets = true;
                     }
                  } else {
                     this.var_acc_prets = true;
                  }
               }
            } else if (var1.getCode().equals("9")) {
               if (this.salaries != null && this.salaries.getSalProtege() == 0 && this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) {
                  this.var_acc_historiques = true;
               } else if (this.salaries == null) {
                  this.var_acc_historiques = true;
               }
            } else if (var1.getCode().equals("10") && this.usersChronoBulletin != null) {
               if (this.accesBulletins && this.salaries != null && this.salaries.getSalProtege() == 0 && this.usersLog.getUsrPaye() == 0 || this.salaries != null && this.salaries.getSalProtege() == 0 && (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() == 4) || this.usersLog.getUsrPaye() >= 0 && this.usersLog.getUsrPaye() <= 3) {
                  this.var_acc_bulletins = true;
               } else if (this.salaries == null) {
                  this.var_acc_bulletins = true;
               }
            }
         }
      }

   }

   public void autorisationIdentification() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationComplement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("2")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationFamilial() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationContrat() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("4")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationGrh() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("5")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

      this.recupererElementRh((Session)null);
   }

   public void autorisationConges() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("6")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAbsences() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("7")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationPrets() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("8")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

      this.salariesPrets = null;
      this.salariesPretsLignes = null;
      this.var_affiche_prets = false;
      this.var_affiche_lignes = false;
      this.lesSalariesPretsLignes.clear();
   }

   public void autorisationHistoriques() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("9")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationBulletins() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("10")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public String calculNationnalite(String var1) {
      String var2 = "";
      if (this.lesPays.size() != 0) {
         for(int var3 = 0; var3 < this.lesPays.size(); ++var3) {
            if (((ObjetPays)this.lesPays.get(var3)).getNom_FR().equalsIgnoreCase(var1)) {
               if (this.structureLog.getStrnompays() != null && !this.structureLog.getStrnompays().isEmpty() && this.structureLog.getStrnompays().equals("GABON")) {
                  this.salaries.setSalCodeNaissance(((ObjetPays)this.lesPays.get(var3)).getRefGabon());
               } else {
                  this.salaries.setSalCodeNaissance(((ObjetPays)this.lesPays.get(var3)).getIdentification());
               }

               var2 = ((ObjetPays)this.lesPays.get(var3)).getNationnalite_FR();
               break;
            }
         }
      }

      return var2;
   }

   public int calculCivilite(String var1) {
      int var2 = 0;
      if (this.lesCivilites.size() != 0) {
         for(int var3 = 0; var3 < this.lesCivilites.size(); ++var3) {
            if (((ObjetCompte)this.lesCivilites.get(var3)).getNom_FR().equalsIgnoreCase(var1)) {
               var2 = Integer.parseInt(((ObjetCompte)this.lesCivilites.get(var3)).getSens());
               if (var2 == 2) {
                  var2 = 0;
               }
               break;
            }
         }
      }

      return var2;
   }

   public void afficheNomJf() {
      if (this.salaries.getSalGenre() == 0) {
         this.var_affiche_nomJf = true;
      } else {
         this.var_affiche_nomJf = false;
      }

   }

   public String getUrlIp() {
      return StaticModePegase.getUrlIp();
   }

   public void recupererModelesItem() throws HibernateException, NamingException {
      this.mesModelesItems = new ArrayList();
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var1.chargerLesModeles(82, this.salaries.getSalNature(), (Session)null);
      this.calculeFeuilleContrat((Session)null);
   }

   public void recupererModelesItemMuter() throws HibernateException, NamingException {
      this.mesModelesItems = new ArrayList();
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var1.chargerLesModeles(82, this.salariesContratsMuter.getSalconType(), (Session)null);
   }

   public void recupererNaturesRHItem() throws HibernateException, NamingException {
      LectureNatureRH var1 = new LectureNatureRH();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recuperePaye();
      this.lesNAt = var1.getMesNatureRhUtils();
      this.nomrepertRH = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "rh" + File.separator;
      File var2 = new File(this.nomrepertRH);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.nomrepertRHcontrat = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "rhContrat" + File.separator;
      var2 = new File(this.nomrepertRHcontrat);
      if (!var2.exists()) {
         var2.mkdir();
      }

   }

   public void recupererElementRh(Session var1) throws HibernateException, NamingException {
      this.mesElementRhItems.clear();
      new UsersChrono();
      this.mesElementRhItems.add(new SelectItem(0, "Environnement Agent"));
      UsersChrono var2 = this.usersChronoDao.chronoByUserNat(this.usersLog, 83, var1);
      if (var2 != null) {
         this.mesElementRhItems.add(new SelectItem(83, "Attestation"));
      }

      var2 = this.usersChronoDao.chronoByUserNat(this.usersLog, 85, var1);
      if (var2 != null) {
         this.mesElementRhItems.add(new SelectItem(85, "Certificat"));
      }

      var2 = this.usersChronoDao.chronoByUserNat(this.usersLog, 86, var1);
      if (var2 != null) {
         this.mesElementRhItems.add(new SelectItem(86, "Correspondance"));
      }

      var2 = this.usersChronoDao.chronoByUserNat(this.usersLog, 84, var1);
      if (var2 != null) {
         this.mesElementRhItems.add(new SelectItem(84, "Cursus"));
      }

   }

   public void recupererEnvironnementtem() throws HibernateException, NamingException {
      this.mesModelesItems.clear();
      this.var_affiche_tdt_rh = false;
   }

   public void recupererCursusItem() throws HibernateException, NamingException {
      this.mesModelesItems.clear();
      this.var_affiche_tdt_rh = false;
   }

   public void recupererAttestationItem() throws HibernateException, NamingException {
      this.mesModelesItems.clear();
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var1.chargerLesModelesDocument(83, this.salariesGrh.getSalgrhType(), (Session)null);
      this.var_affiche_tdt_rh = true;
   }

   public void recupererCertificatItem() throws HibernateException, NamingException {
      this.mesModelesItems.clear();
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var1.chargerLesModelesDocument(85, this.salariesGrh.getSalgrhType(), (Session)null);
      this.var_affiche_tdt_rh = true;
   }

   public void recupererCorrespondanceItem() throws HibernateException, NamingException {
      this.mesModelesItems.clear();
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var1.chargerLesModelesDocument(86, this.salariesGrh.getSalgrhType(), (Session)null);
      this.var_affiche_tdt_rh = true;
   }

   public Habilitation verifHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      new Habilitation();
      Habilitation var3 = this.habilitationDao.existenceHabilitation(var1, var2);
      return var3;
   }

   public void chargerUserChronoContrat(Session var1) throws HibernateException, NamingException {
      this.usersChronoContrat = this.usersChronoDao.selectUnique("", 82, this.usersLog, var1);
   }

   public void chargerUserChronoPret(Session var1) throws HibernateException, NamingException {
      this.usersChronoPret = this.usersChronoDao.selectUnique("", 87, this.usersLog, var1);
   }

   public void chargerUserChronoConge(Session var1) throws HibernateException, NamingException {
      this.usersChronoConge = this.usersChronoDao.selectUnique("", 88, this.usersLog, var1);
   }

   public void chargerUserChronoAbsence(Session var1) throws HibernateException, NamingException {
      this.usersChronoAbsence = this.usersChronoDao.selectUnique("", 89, this.usersLog, var1);
   }

   public void chargerUserChronoBulletin(Session var1) throws HibernateException, NamingException {
      this.usersChronoBulletin = this.usersChronoDao.selectUnique("", 90, this.usersLog, var1);
   }

   public void calculServiceInterim() throws HibernateException, NamingException {
      this.calculServiceInterim((Session)null);
   }

   public void calculServiceInterim(Session var1) throws HibernateException, NamingException {
      this.mesServiceItems.clear();
      if (this.salariesContrats != null) {
         new ArrayList();
         SiteDao var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
         List var2 = var3.chargerLesSitesListByClient(this.salariesContrats.getSalconIdTiers(), var1);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               this.mesServiceItems.add(new SelectItem(((Site)var2.get(var4)).getSitCode() + ":" + ((Site)var2.get(var4)).getSitNomFr()));
            }
         }
      }

   }

   public void calculDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      if (this.var_site_rec != null && !this.var_site_rec.isEmpty()) {
         DepartementDao var1 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         String[] var3 = this.var_site_rec.split(":");
         List var2 = var1.listDepartementBySit((String)var3[0], (Session)null);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               this.mesDepartementsItems.add(new SelectItem(((Departement)var2.get(var4)).getDepCode() + ":" + ((Departement)var2.get(var4)).getDepNomFr()));
            }
         }
      }

   }

   public void calculDepartementImputation() throws HibernateException, NamingException {
      this.mesDepartementsImputationItems.clear();
      if (this.var_site != null && !this.var_site.isEmpty()) {
         DepartementDao var1 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         String[] var3 = this.var_site.split(":");
         List var2 = var1.listDepartementBySit((String)var3[0], (Session)null);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               this.mesDepartementsImputationItems.add(new SelectItem(((Departement)var2.get(var4)).getDepCode() + ":" + ((Departement)var2.get(var4)).getDepNomFr()));
            }
         }
      }

   }

   public void calculContrat(Session var1) throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.lesContratsActifsItems.clear();
         this.lesSalariesContrats.clear();
         this.lesSalariesContrats = this.salariesContratsDao.chargerlesContrats(this.salaries, var1);
         if (this.lesSalariesContrats.size() != 0) {
            for(int var2 = 0; var2 < this.lesSalariesContrats.size(); ++var2) {
               this.salariesContrats = (SalariesContrats)this.lesSalariesContrats.get(var2);
               this.lesContratsActifsItems.add(new SelectItem(this.salariesContrats.getSalconNum(), this.salariesContrats.getSalconNum() + " - (Feuille N° " + this.salariesContrats.getSalconFeuille() + ")"));
            }
         }
      }

   }

   public void moreSearch() {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
         this.var_convention_rec = "100";
      }

   }

   public void rechercherSalarie() throws HibernateException, NamingException, ParseException {
      this.rechercherSalarie((Session)null);
   }

   public void rechercherSalarie(Session var1) throws HibernateException, NamingException, ParseException {
      String var2 = "";
      if (this.mesNatureAgentItems.size() != 0 && this.var_etat_rec != 20 && this.var_etat_rec != 21) {
         for(int var3 = 0; var3 < this.mesNatureAgentItems.size(); ++var3) {
            if (((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString().isEmpty()) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               } else {
                  var2 = "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               }
            }
         }
      }

      Date var10 = null;
      Date var4 = null;
      if (this.exercicesPaye.getExepayId() != this.lastExoPaye.getExepayId()) {
         UtilDate var5 = new UtilDate();
         var10 = var5.stringToDateSQLLight("1900-01-01");
         var4 = this.exercicesPaye.getExepayDateFin();
      }

      this.lesSalaries.clear();
      this.extDTableSal = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteSal.clear();
      this.var_affiche_bouton = false;
      int var11 = Integer.parseInt(this.optionPaye.getTriAgents());
      if (this.accesInterim) {
         long var6 = 0L;
         if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("100")) {
            var6 = 0L;
         } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("101")) {
            var6 = -1L;
         } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && !this.var_tiers_rec.equals("101") && !this.var_tiers_rec.equals("100")) {
            var6 = Long.parseLong(this.var_tiers_rec);
         } else {
            var6 = -1L;
         }

         this.var_budget_rec = "";
         if (this.var_feuille_rec != null && !this.var_feuille_rec.isEmpty() && (this.var_feuille_rec == null || this.var_feuille_rec.isEmpty() || !this.var_feuille_rec.equals("100"))) {
            new ArrayList();
            List var8 = this.salariesContratsDao.chargerlesContrats(var11, var2, 100, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_projet_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.var_localisation_rec, this.var_budget_rec, var6, var4, var1);
            if (var8.size() != 0) {
               for(int var9 = 0; var9 < var8.size(); ++var9) {
                  this.lesSalaries.add(((SalariesContrats)var8.get(var9)).getSalaries());
               }
            }
         } else {
            this.lesSalaries = this.salariesDao.rechercheSalaries(this.decoupageActivite, var11, var2, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, var6, var10, var4, var1);
         }
      } else if (this.var_feuille_rec == null || this.var_feuille_rec.isEmpty() || this.var_feuille_rec != null && !this.var_feuille_rec.isEmpty() && this.var_feuille_rec.equals("100")) {
         this.lesSalaries = this.salariesDao.rechercheSalaries(this.decoupageActivite, var11, var2, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, var10, var4, var1);
      } else {
         new ArrayList();
         List var12 = this.salariesContratsDao.chargerlesContrats(var11, var2, 100, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_projet_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.var_localisation_rec, this.var_budget_rec, var4, var1);
         if (var12.size() != 0) {
            for(int var7 = 0; var7 < var12.size(); ++var7) {
               this.lesSalaries.add(((SalariesContrats)var12.get(var7)).getSalaries());
            }
         }
      }

      this.datamodelSalaries.setWrappedData(this.lesSalaries);
   }

   public void rechercherRoster() throws HibernateException, NamingException, ParseException {
      this.rechercherRoster((Session)null);
   }

   public void rechercherRoster(Session var1) throws HibernateException, NamingException, ParseException {
      String var2 = "";
      if (this.mesNatureAgentItems.size() != 0) {
         for(int var3 = 0; var3 < this.mesNatureAgentItems.size(); ++var3) {
            if (((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString().isEmpty()) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               } else {
                  var2 = "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               }
            }
         }
      }

      Date var6 = null;
      Date var4 = null;
      if (this.exercicesPaye.getExepayId() != this.lastExoPaye.getExepayId()) {
         UtilDate var5 = new UtilDate();
         var6 = var5.stringToDateSQLLight("2000-01-01");
         var4 = this.exercicesPaye.getExepayDateDebut();
      }

      this.lesSalaries.clear();
      this.extDTableSal = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteSal.clear();
      this.var_affiche_bouton = false;
      this.lesSalaries = this.salariesDao.rechercheRoster(var2, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_pays_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, var6, var4, var1);
      this.datamodelSalaries.setWrappedData(this.lesSalaries);
   }

   public void selectionSalaries() throws IOException, SQLException, HibernateException, NamingException {
      if (this.extDTableSal != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEnteteSal.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableSal.setRowKey(var3);
            if (this.extDTableSal.isRowAvailable()) {
               var1.add(this.extDTableSal.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salaries = (Salaries)var1.get(0);
            this.afficheNomJf();
            Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            this.affichePhoto();
            if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && this.salaries.getSalNature().equals("04")) {
               if (this.salaries.getSalClassement() != null && !this.salaries.getSalClassement().isEmpty()) {
                  this.var_classement = this.salaries.getSalClassement() + ":" + this.salaries.getSalLibClassement();
               } else {
                  this.var_classement = "";
               }

               if (this.salaries.getSalCentresImpots() != null && !this.salaries.getSalCentresImpots().isEmpty()) {
                  this.var_centre = this.salaries.getSalCentresImpots() + ":" + this.salaries.getSalLibCentresImpots();
               } else {
                  this.var_centre = "";
               }

               if (this.salaries.getSalConvention() != null && !this.salaries.getSalConvention().isEmpty()) {
                  this.var_convention = this.salaries.getSalConvention() + ":" + this.salaries.getSalLibConvention();
                  this.chargerGrille();
               } else {
                  this.var_convention = "";
               }

               if (this.salaries.getSalGrille() != null && !this.salaries.getSalGrille().isEmpty()) {
                  this.var_grille = this.salaries.getSalGrille() + ":" + this.salaries.getSalLibGrille();
               } else {
                  this.var_grille = "";
               }

               this.chargerPretsInternes(var7);
               this.calculeFeuilleContrat(var7);
            } else {
               this.chargerContrat(var7);
               this.chargerRh(var7);
               this.chargerConges(var7);
               this.chargerAbsences(var7);
               this.chargerPretsInternes(var7);
               this.chargerPretsExternes(var7);
               this.chargerPretsManuels(var7);
               this.chargerCapitalisation(var7);
               this.chargerHistorique(var7);
               this.chargerScanAvenant();
            }

            this.chargerBulletins(var7);
            this.nbInit = 0.0F;
            this.nbAcquis = 0.0F;
            this.nbPris = 0.0F;
            float var4 = 0.0F;
            float var5 = 0.0F;
            this.nbRestant = 0.0F;
            int var6;
            if (this.lesSalariesHistorique.size() != 0) {
               for(var6 = 0; var6 < this.lesSalariesHistorique.size(); ++var6) {
                  if (((SalariesHistorique)this.lesSalariesHistorique.get(var6)).getSalhisCode().equals("NBJS")) {
                     this.nbInit = (float)((SalariesHistorique)this.lesSalariesHistorique.get(var6)).getSalhisValeurColE();
                     break;
                  }
               }
            }

            if (this.lesBulletins.size() != 0) {
               for(var6 = 0; var6 < this.lesBulletins.size(); ++var6) {
                  this.nbAcquis += ((BulletinSalaire)this.lesBulletins.get(var6)).getBulsalNbCpAcquis();
                  this.nbPris += ((BulletinSalaire)this.lesBulletins.get(var6)).getBulsalNbCpPris();
               }
            }

            if (this.lesSalariesConges.size() != 0) {
               for(var6 = 0; var6 < this.lesSalariesConges.size(); ++var6) {
                  if (((SalariesConges)this.lesSalariesConges.get(var6)).getSalcngType() == 1 && ((SalariesConges)this.lesSalariesConges.get(var6)).getSalcngEtat() == 1 && ((SalariesConges)this.lesSalariesConges.get(var6)).getSalcngNature() == 8) {
                     var4 += ((SalariesConges)this.lesSalariesConges.get(var6)).getSalcngDuree();
                  }
               }
            }

            if (this.lesSalariesAbsences.size() != 0) {
               for(var6 = 0; var6 < this.lesSalariesAbsences.size(); ++var6) {
                  if (((SalariesConges)this.lesSalariesAbsences.get(var6)).getSalcngType() == 0 && ((SalariesConges)this.lesSalariesAbsences.get(var6)).getSalcngEtat() == 1 && ((SalariesConges)this.lesSalariesAbsences.get(var6)).getSalcngNature() == 13) {
                     var4 += ((SalariesConges)this.lesSalariesConges.get(var6)).getSalcngDuree();
                  }
               }
            }

            this.nbRestant = this.nbInit + this.nbAcquis + var4 - this.nbPris - var5;
            this.utilInitHibernate.closeSession();
            this.nouvelleCreation = false;
            this.var_affiche_bouton = true;
            this.accesResteintGroupe();
            if (this.salaries.getSalProtege() == 1) {
               if (this.usersLog.getUsrPaye() == 0) {
                  this.accesAutreProtege = true;
                  this.accesContratsProtege = true;
                  this.accesPretsProtege = true;
                  this.accesRhProtege = true;
               } else if (this.usersLog.getUsrPaye() == 1) {
                  this.accesAutreProtege = false;
                  this.accesContratsProtege = false;
                  this.accesPretsProtege = false;
                  this.accesRhProtege = true;
               } else if (this.usersLog.getUsrPaye() == 2) {
                  this.accesAutreProtege = false;
                  this.accesContratsProtege = false;
                  this.accesPretsProtege = true;
                  this.accesRhProtege = true;
               } else if (this.usersLog.getUsrPaye() == 3) {
                  this.accesAutreProtege = false;
                  this.accesContratsProtege = true;
                  this.accesPretsProtege = true;
                  this.accesRhProtege = true;
               } else if (this.usersLog.getUsrPaye() == 4) {
                  this.accesAutreProtege = false;
                  this.accesContratsProtege = false;
                  this.accesPretsProtege = false;
                  this.accesRhProtege = false;
               } else if (this.usersLog.getUsrPaye() == 5) {
                  this.accesAutreProtege = true;
                  this.accesContratsProtege = true;
                  this.accesPretsProtege = true;
                  this.accesRhProtege = true;
               }
            } else if (this.usersLog.getUsrPaye() == 5) {
               this.accesAutreProtege = false;
               this.accesContratsProtege = false;
               this.accesPretsProtege = false;
               this.accesRhProtege = false;
            } else {
               this.accesAutreProtege = true;
               this.accesContratsProtege = true;
               this.accesPretsProtege = true;
               this.accesRhProtege = true;
            }
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationSalaries() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salaries != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() == 0) {
               this.accesAutreProtege = true;
               this.accesContratsProtege = true;
               this.accesPretsProtege = true;
               this.accesRhProtege = true;
            } else if (this.usersLog.getUsrPaye() == 1) {
               this.accesAutreProtege = false;
               this.accesContratsProtege = false;
               this.accesPretsProtege = false;
               this.accesRhProtege = true;
            } else if (this.usersLog.getUsrPaye() == 2) {
               this.accesAutreProtege = false;
               this.accesContratsProtege = false;
               this.accesPretsProtege = true;
               this.accesRhProtege = true;
            } else if (this.usersLog.getUsrPaye() == 3) {
               this.accesAutreProtege = false;
               this.accesContratsProtege = true;
               this.accesPretsProtege = true;
               this.accesRhProtege = true;
            } else if (this.usersLog.getUsrPaye() == 4) {
               this.accesAutreProtege = false;
               this.accesContratsProtege = false;
               this.accesPretsProtege = false;
               this.accesRhProtege = false;
            } else if (this.usersLog.getUsrPaye() == 5) {
               this.accesAutreProtege = true;
               this.accesContratsProtege = true;
               this.accesPretsProtege = true;
               this.accesRhProtege = true;
            }
         } else if (this.usersLog.getUsrPaye() == 5) {
            this.accesAutreProtege = false;
            this.accesContratsProtege = false;
            this.accesPretsProtege = false;
            this.accesRhProtege = false;
         } else {
            this.accesAutreProtege = true;
            this.accesContratsProtege = true;
            this.accesPretsProtege = true;
            this.accesRhProtege = true;
         }

         this.consulterSalaries();
      }

   }

   public void calculeUnicite() throws HibernateException, NamingException {
      if (this.salaries.getSalMatricule() != null && !this.salaries.getSalMatricule().isEmpty()) {
         String var1 = this.calculChrono.matriculeFormattage(this.salaries.getSalMatricule(), new Date(), 81, this.salaries.getSalNature(), (Session)null);
         this.salaries.setSalMatricule(var1);
         boolean var2 = this.salariesDao.verifUnicite(var1, (Session)null);
         if (!var2) {
            this.valideSalarie = true;
         } else {
            this.valideSalarie = false;
            this.salaries.setSalMatricule("");
         }
      }

   }

   public void chargerContrat(Session var1) throws HibernateException, NamingException {
      this.lesSalariesContrats.clear();
      this.lesSalariesContrats = this.salariesContratsDao.chargerlesContrats(this.salaries, var1);
      this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
      this.salariesContrats = new SalariesContrats();
      this.simpleSelectionEnteteCrt.clear();
      this.extDTableCrt = new HtmlExtendedDataTable();
      this.var_affiche_contrat = false;
   }

   public void chargerRh(Session var1) throws HibernateException, NamingException {
      this.lesSalariesGrh.clear();
      this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, var1);
      this.dataModelGrh.setWrappedData(this.lesSalariesGrh);
      this.salariesGrh = new SalariesGrh();
      this.simpleSelectionEnteteGrh.clear();
      this.extDTableGrh = new HtmlExtendedDataTable();
      this.var_affiche_rh = false;
   }

   public void chargerConges(Session var1) throws HibernateException, NamingException {
      this.lesSalariesConges.clear();
      this.lesSalariesConges = this.salariesCongesDao.chargerlesConges(this.salaries, var1);
      this.dataModelConges.setWrappedData(this.lesSalariesConges);
      this.salariesConges = new SalariesConges();
   }

   public void chargerAbsences(Session var1) throws HibernateException, NamingException {
      this.lesSalariesAbsences.clear();
      this.lesSalariesAbsences = this.salariesCongesDao.chargerlesAbsences(this.salaries, var1);
      this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
      this.salariesAbsences = new SalariesConges();
   }

   public void chargerPretsInternes(Session var1) throws HibernateException, NamingException {
      this.total_pret_interne = 0.0D;
      this.total_rmb_interne = 0.0D;
      this.solde_pret_interne = 0.0D;
      this.lesSalariesPretsInternes.clear();
      this.lesSalariesPretsInternes = this.salariesPretsDao.chargerlesPretsInternes(this.salaries, var1);
      this.dataModelPretsInternes.setWrappedData(this.lesSalariesPretsInternes);
      this.lesSalariesPretsLignes.clear();
      this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
      this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
      this.var_affiche_prets = false;
   }

   public void chargerPretsExternes(Session var1) throws HibernateException, NamingException {
      this.total_pret_externe = 0.0D;
      this.total_rmb_externe = 0.0D;
      this.solde_pret_externe = 0.0D;
      this.lesSalariesPretsExternes.clear();
      this.lesSalariesPretsExternes = this.salariesPretsDao.chargerlesPretsExternes(this.salaries, var1);
      this.dataModelPretsExternes.setWrappedData(this.lesSalariesPretsExternes);
      this.lesSalariesPretsLignes.clear();
      this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
      this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
      this.var_affiche_prets = false;
   }

   public void chargerPretsManuels(Session var1) throws HibernateException, NamingException {
      this.total_pret_manuel = 0.0D;
      this.total_rmb_manuel = 0.0D;
      this.solde_pret_manuel = 0.0D;
      this.lesSalariesPretsManuels.clear();
      this.lesSalariesPretsManuels = this.salariesPretsDao.chargerlesPretsManuels(this.salaries, var1);
      this.dataModelPretsManuels.setWrappedData(this.lesSalariesPretsManuels);
      this.lesSalariesPretsLignes.clear();
      this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
      this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
      this.var_affiche_prets = false;
   }

   public void chargerCapitalisation(Session var1) throws HibernateException, NamingException {
      this.salariesCapitalisation = new SalariesCapitalisation();
      this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var1);
      if (this.salariesCapitalisation == null) {
         this.salariesCapitalisation = new SalariesCapitalisation();
      } else {
         this.total_versement = 0.0D;
         this.total_retrait = 0.0D;
         this.solde_capitalisation = 0.0D;
         this.lesLignesCapitalisation.clear();
         if (this.salariesCapitalisation.getSalcapRubVersement() != null && !this.salariesCapitalisation.getSalcapRubVersement().isEmpty() && this.salariesCapitalisation.getSalcapRubRetrait() != null && !this.salariesCapitalisation.getSalcapRubRetrait().isEmpty()) {
            this.lesLignesCapitalisation = this.salariesCapitalisationDao.chargerlesMvts(this.salaries, this.salariesCapitalisation, var1);
            if (this.lesLignesCapitalisation.size() != 0) {
               for(int var2 = 0; var2 < this.lesLignesCapitalisation.size(); ++var2) {
                  this.total_versement += ((BulletinLigne)this.lesLignesCapitalisation.get(var2)).getDepense();
                  this.total_retrait += ((BulletinLigne)this.lesLignesCapitalisation.get(var2)).getRecette();
               }
            }

            this.solde_capitalisation = this.salariesCapitalisation.getSalcapInitial() + this.total_versement - this.total_retrait;
         }

         this.dataModelCapitalisation.setWrappedData(this.lesLignesCapitalisation);
      }

   }

   public void chargerHistorique(Session var1) throws HibernateException, NamingException {
      this.lesSalariesHistorique.clear();
      this.lesSalariesHistorique = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var1);
      this.dataModelHistorique.setWrappedData(this.lesSalariesHistorique);
      this.salariesHistorique = new SalariesHistorique();
      this.var_affiche_historique = false;
   }

   public void chargerBulletins(Session var1) throws HibernateException, NamingException {
      this.lesBulletins = this.formBakingBeanPaye.chargerBulletins(this.bulletinSalaireDao, this.salaries, var1);
   }

   public void chargerScanAvenant() throws HibernateException, NamingException {
      this.nomRepertoireAvenant = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "rhAvenants" + File.separator;
      this.lesAvenants.clear();
      if (this.nomRepertoireAvenant != null && !this.nomRepertoireAvenant.isEmpty()) {
         File var1 = new File(this.nomRepertoireAvenant);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.salaries.getSalMatricule().replace("/", "_") + "_" + this.salariesContrats.getSalconId();
         String[] var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesAvenants.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelAvenants.setWrappedData(this.lesAvenants);
   }

   public void ajouterSalaries() throws IOException, SQLException {
      this.lesBulletins.clear();
      this.lesSalariesAbsences.clear();
      this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
      this.lesSalariesConges.clear();
      this.dataModelConges.setWrappedData(this.lesSalariesConges);
      this.lesSalariesContrats.clear();
      this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
      this.lesSalariesPretsExternes.clear();
      this.dataModelPretsExternes.setWrappedData(this.lesSalariesPretsExternes);
      this.lesSalariesPretsInternes.clear();
      this.dataModelPretsInternes.setWrappedData(this.lesSalariesPretsInternes);
      this.lesSalariesPretsLignes.clear();
      this.lesSalariesPretsManuels.clear();
      this.lesAvenants.clear();
      this.dataModelAvenants.setWrappedData(this.lesAvenants);
      this.salaries = new Salaries();
      this.salaries.setSalNompays(this.structureLog.getStrnompays());
      this.salaries.setSalPaysNaissance(this.structureLog.getStrnompays());
      this.salaries.setSalCodeNaissance(this.structureLog.getStrcodepays());
      this.salaries.setSalLangue(this.structureLog.getStrlangue());
      this.salaries.setSalNationnalite(this.calculNationnalite(this.salaries.getSalPaysNaissance()));
      if (this.optionPaye.getChronoMatricule().equals("1")) {
         this.valideSalarie = false;
      } else {
         this.valideSalarie = true;
      }

      this.nouvelleCreation = true;
      if (this.salaries.getSalProtege() == 1) {
         if (this.usersLog.getUsrPaye() == 0) {
            this.accesAutreProtege = true;
            this.accesContratsProtege = true;
            this.accesPretsProtege = true;
            this.accesRhProtege = true;
         } else if (this.usersLog.getUsrPaye() == 1) {
            this.accesAutreProtege = false;
            this.accesContratsProtege = false;
            this.accesPretsProtege = false;
            this.accesRhProtege = true;
         } else if (this.usersLog.getUsrPaye() == 2) {
            this.accesAutreProtege = false;
            this.accesContratsProtege = false;
            this.accesPretsProtege = true;
            this.accesRhProtege = true;
         } else if (this.usersLog.getUsrPaye() == 3) {
            this.accesAutreProtege = false;
            this.accesContratsProtege = true;
            this.accesPretsProtege = true;
            this.accesRhProtege = true;
         } else if (this.usersLog.getUsrPaye() == 4) {
            this.accesAutreProtege = false;
            this.accesContratsProtege = false;
            this.accesPretsProtege = false;
            this.accesRhProtege = false;
         } else if (this.usersLog.getUsrPaye() == 5) {
            this.accesAutreProtege = true;
            this.accesContratsProtege = true;
            this.accesPretsProtege = true;
            this.accesRhProtege = true;
         }
      } else if (this.usersLog.getUsrPaye() == 5) {
         this.accesAutreProtege = false;
         this.accesContratsProtege = false;
         this.accesPretsProtege = false;
         this.accesRhProtege = false;
      } else {
         this.accesAutreProtege = true;
         this.accesContratsProtege = true;
         this.accesPretsProtege = true;
         this.accesRhProtege = true;
      }

      this.var_action = 1;
   }

   public void modifierSalaries() {
      if (this.salaries != null) {
         this.valideSalarie = true;
         this.nouvelleCreation = false;
         this.var_action = 2;
      }

   }

   public void consulterSalaries() {
      if (this.salaries != null) {
         this.valideSalarie = false;
         this.nouvelleCreation = false;
         this.var_action = 3;
      }

   }

   public void consulterDernierContrat() throws HibernateException, NamingException {
      if (this.salaries != null) {
         new ArrayList();
         List var1 = this.salariesContratsDao.chargerlesContrats((Salaries)this.salaries, (Session)null);
         if (var1.size() != 0) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
               if (((SalariesContrats)var1.get(var2)).getSalconEtat() <= 1) {
                  this.salariesContrats = (SalariesContrats)var1.get(var2);
                  this.var_affiche_contrat = true;
                  if (this.salariesContrats.getSalconTexte().length() <= 10) {
                     this.afficheTexteContrat = true;
                  } else {
                     this.afficheTexteContrat = false;
                  }

                  int var3 = 0;
                  if (var1.size() != 0) {
                     for(int var4 = 0; var4 < var1.size(); ++var4) {
                        if (this.salariesContrats.getSalconId() == ((SalariesContrats)var1.get(var4)).getSalconId()) {
                           var3 = var4;
                           break;
                        }
                     }
                  }

                  this.var_ligne_contrat = var3 + 1;
                  if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
                     this.var_niveau = this.salariesContrats.getSalconNivEmploi() + ":" + this.salariesContrats.getSalconLibNivEmploi();
                  } else {
                     this.var_niveau = "";
                  }

                  if (this.salariesContrats.getSalconClassement() != null && !this.salariesContrats.getSalconClassement().isEmpty()) {
                     this.var_classement = this.salariesContrats.getSalconClassement() + ":" + this.salariesContrats.getSalconLibClassement();
                  } else {
                     this.var_classement = "";
                  }

                  if (this.salariesContrats.getSalconCentresImpots() != null && !this.salariesContrats.getSalconCentresImpots().isEmpty()) {
                     this.var_centre = this.salariesContrats.getSalconCentresImpots() + ":" + this.salariesContrats.getSalconLibCentresImpots();
                  } else {
                     this.var_centre = "";
                  }

                  if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty()) {
                     this.var_convention = this.salariesContrats.getSalconConvention() + ":" + this.salariesContrats.getSalconLibConvention();
                  } else {
                     this.var_convention = "";
                  }

                  if (this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
                     this.var_grille = this.salariesContrats.getSalconGrille() + ":" + this.salariesContrats.getSalconLibGrille();
                  } else {
                     this.var_grille = "";
                  }

                  if (this.salariesContrats.getSalconActivite() != null && !this.salariesContrats.getSalconActivite().isEmpty()) {
                     this.var_activite = this.salariesContrats.getSalconActivite() + ":" + this.salariesContrats.getSalconLibActivite().toUpperCase();
                  } else {
                     this.var_activite = "";
                  }

                  if (this.salariesContrats.getSalconProjet() != null && !this.salariesContrats.getSalconProjet().isEmpty()) {
                     this.var_projet = this.salariesContrats.getSalconProjet() + ":" + this.salariesContrats.getSalconLibProjet();
                  } else {
                     this.var_projet = "";
                  }

                  if (this.salariesContrats.getSalconBudget() != null && !this.salariesContrats.getSalconBudget().isEmpty()) {
                     this.var_budget = this.salariesContrats.getSalconBudget() + ":" + this.salariesContrats.getSalconLibBudget();
                  } else {
                     this.var_budget = "";
                  }

                  if (this.salariesContrats.getSalconCle1Anal() != null && !this.salariesContrats.getSalconCle1Anal().isEmpty()) {
                     this.var_cle1 = this.salariesContrats.getSalconCle1Anal() + ":" + this.salariesContrats.getSalconLibCle1Anal();
                  } else {
                     this.var_cle1 = "";
                  }

                  if (this.salariesContrats.getSalconCle2Anal() != null && !this.salariesContrats.getSalconCle2Anal().isEmpty()) {
                     this.var_cle2 = this.salariesContrats.getSalconCle2Anal() + ":" + this.salariesContrats.getSalconLibCle2Anal();
                  } else {
                     this.var_cle2 = "";
                  }

                  this.showModalPanelContrat = true;
                  break;
               }
            }
         }
      }

   }

   public void closeContrat() {
      this.showModalPanelContrat = false;
   }

   public void supprimerSalaries() throws HibernateException, NamingException {
      if (this.salaries != null) {
         if (this.lesBulletins.size() == 0) {
            boolean var1 = true;
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var3 = null;

            List var4;
            try {
               var3 = var2.beginTransaction();
               this.bulletinExiste = false;
               new ArrayList();
               var4 = this.bulletinSalaireDao.chargerlesBulletinsbySalarie(this.salaries, var2);
               if (var4.size() != 0) {
                  this.bulletinExiste = true;
               }

               if (this.bulletinExiste) {
                  var1 = false;
               } else {
                  int var5;
                  if (this.lesSalariesContrats.size() != 0) {
                     this.salariesContrats = new SalariesContrats();

                     for(var5 = 0; var5 < this.lesSalariesContrats.size(); ++var5) {
                        this.salariesContrats = (SalariesContrats)this.lesSalariesContrats.get(var5);
                        this.salariesContratsDao.delete(this.salariesContrats, var2);
                     }
                  }

                  if (this.lesSalariesGrh.size() != 0) {
                     this.salariesGrh = new SalariesGrh();

                     for(var5 = 0; var5 < this.lesSalariesGrh.size(); ++var5) {
                        this.salariesGrh = (SalariesGrh)this.lesSalariesGrh.get(var5);
                        this.salariesGrhDao.delete(this.salariesGrh, var2);
                     }
                  }

                  if (this.lesSalariesConges.size() != 0) {
                     this.salariesConges = new SalariesConges();

                     for(var5 = 0; var5 < this.lesSalariesConges.size(); ++var5) {
                        this.salariesConges = (SalariesConges)this.lesSalariesConges.get(var5);
                        this.salariesCongesDao.delete(this.salariesConges, var2);
                     }
                  }

                  if (this.lesSalariesAbsences.size() != 0) {
                     this.salariesAbsences = new SalariesConges();

                     for(var5 = 0; var5 < this.lesSalariesAbsences.size(); ++var5) {
                        this.salariesAbsences = (SalariesConges)this.lesSalariesAbsences.get(var5);
                        this.salariesCongesDao.delete(this.salariesAbsences, var2);
                     }
                  }

                  List var6;
                  if (this.lesSalariesPretsInternes.size() != 0) {
                     this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);

                     for(var5 = 0; var5 < this.lesSalariesPretsInternes.size(); ++var5) {
                        this.salariesPrets = (SalariesPrets)this.lesSalariesPretsInternes.get(var5);
                        new ArrayList();
                        var6 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var2);
                        if (var6.size() != 0) {
                           this.salariesPretsLignesDao.deleteAllLigne(var6, var2);
                        }

                        this.salariesPretsDao.delete(this.salariesPrets, var2);
                     }
                  }

                  if (this.lesSalariesPretsExternes.size() != 0) {
                     this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);

                     for(var5 = 0; var5 < this.lesSalariesPretsExternes.size(); ++var5) {
                        this.salariesPrets = (SalariesPrets)this.lesSalariesPretsExternes.get(var5);
                        new ArrayList();
                        var6 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var2);
                        if (var6.size() != 0) {
                           this.salariesPretsLignesDao.deleteAllLigne(var6, var2);
                        }

                        this.salariesPretsDao.delete(this.salariesPrets, var2);
                     }
                  }

                  if (this.lesSalariesPretsManuels.size() != 0) {
                     this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);

                     for(var5 = 0; var5 < this.lesSalariesPretsManuels.size(); ++var5) {
                        this.salariesPrets = (SalariesPrets)this.lesSalariesPretsManuels.get(var5);
                        new ArrayList();
                        var6 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var2);
                        if (var6.size() != 0) {
                           this.salariesPretsLignesDao.deleteAllLigne(var6, var2);
                        }

                        this.salariesPretsDao.delete(this.salariesPrets, var2);
                     }
                  }

                  new ArrayList();
                  SalariesElementsDao var26 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
                  List var29 = var26.chargerlesElementsBySalaries(this.salaries, var2);
                  if (var29.size() != 0) {
                     new SalariesElements();

                     for(int var8 = 0; var8 < var29.size(); ++var8) {
                        SalariesElements var7 = (SalariesElements)var29.get(var8);
                        var26.delete(var7, var2);
                     }
                  }

                  new ArrayList();
                  SalariesVariablesDao var28 = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
                  List var27 = var28.chargerlesVariables(this.salaries, var2);
                  if (var27.size() != 0) {
                     new SalariesVariables();

                     for(int var10 = 0; var10 < var27.size(); ++var10) {
                        SalariesVariables var9 = (SalariesVariables)var27.get(var10);
                        var28.delete(var9, var2);
                     }
                  }

                  var3.commit();
               }
            } catch (HibernateException var23) {
               var1 = false;
               if (var3 != null) {
                  var3.rollback();
               }

               throw var23;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var1) {
               var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
               var4 = null;

               try {
                  Transaction var25 = var2.beginTransaction();
                  this.salariesDao.delete(this.salaries, var2);
                  this.lesSalaries.remove(this.salaries);
                  this.datamodelSalaries.setWrappedData(this.lesSalaries);
                  var25.commit();
               } catch (HibernateException var21) {
                  if (var4 != null) {
                     var4.rollback();
                  }

                  throw var21;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }

         this.var_action = 0;
         this.var_affiche_bouton = false;
         this.extDTableSal = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteSal.clear();
      }

   }

   public void fermerSuppresion() {
      this.bulletinExiste = false;
   }

   public void annuler() {
      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEnteteSal.clear();
      this.extDTableSal = new HtmlExtendedDataTable();
   }

   public void calculNbParts() {
      if (this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         this.salaries.setSalNbEnfant(this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh));
      }

      this.salaries.setSalNbFemme(this.formBakingBeanPaye.calculNbFemme(this.salaries, this.lesSalariesGrh));
      this.salaries.setSalNbPartFiscal(this.formBakingBeanPaye.calculNbPartsFiscales(this.salaries, this.lesSalariesGrh));
      this.salaries.setSalNbPartTrimf(this.formBakingBeanPaye.calculNbtrimf(this.salaries, this.lesSalariesGrh));
      if (this.salaries.getSalSitFamille() != 0) {
         this.salaries.setSalMiseRelation(false);
      }

   }

   public void saveSalaries() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.salaries.getSalDateNaissance() != null) {
            String var3 = "";
            if (this.salaries.getSalDateNaissance().getDate() <= 9) {
               var3 = "0" + this.salaries.getSalDateNaissance().getDate();
            } else {
               var3 = "" + this.salaries.getSalDateNaissance().getDate();
            }

            String var4 = "";
            if (this.salaries.getSalDateNaissance().getMonth() + 1 <= 9) {
               var4 = "0" + (this.salaries.getSalDateNaissance().getMonth() + 1);
            } else {
               var4 = "" + (this.salaries.getSalDateNaissance().getMonth() + 1);
            }

            this.salaries.setSalAnniversaire(var3 + ":" + var4);
         } else {
            this.salaries.setSalAnniversaire("");
         }

         this.calculeMatricule(var1);
         int var10;
         if (this.salaries.getSalNationnalite() != null && !this.salaries.getSalNationnalite().isEmpty()) {
            for(var10 = 0; var10 < this.lesPays.size(); ++var10) {
               if (this.salaries.getSalNationnalite().equals(((ObjetPays)this.lesPays.get(var10)).getNationnalite_FR())) {
                  this.salaries.setSalCodeNaissance(((ObjetPays)this.lesPays.get(var10)).getIdentification());
                  break;
               }
            }
         } else if (this.salaries.getSalPaysNaissance() != null && !this.salaries.getSalPaysNaissance().isEmpty()) {
            for(var10 = 0; var10 < this.lesPays.size(); ++var10) {
               if (this.salaries.getSalPaysNaissance().equals(((ObjetPays)this.lesPays.get(var10)).getNom_FR())) {
                  this.salaries.setSalCodeNaissance(((ObjetPays)this.lesPays.get(var10)).getIdentification());
                  break;
               }
            }
         }

         if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && this.salaries.getSalNature().equals("04")) {
            this.calculeZoneJRX();
         }

         if (this.salaries.getSalId() == 0L) {
            if (this.usersLog.getUsrPaye() == 5) {
               this.salaries.setSalProtege(1);
            }

            this.salaries.setExercicesPaye(this.exercicesPaye);
            this.salaries.setSalDateCreat(new Date());
            this.salaries.setSalUserCreat(this.usersLog.getUsrid());
            this.salaries = this.salariesDao.insert(this.salaries, var1);
            this.lesSalaries.add(this.salaries);
            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            this.var_action = 2;
            this.simpleSelectionEnteteSal.clear();
            this.extDTableSal = new HtmlExtendedDataTable();
         } else {
            this.salaries.setSalDateModif(new Date());
            this.salaries.setSalUserModif(this.usersLog.getUsrid());
            this.salaries = this.salariesDao.modif(this.salaries, var1);
            this.var_action = 0;
         }

         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculeMatricule(Session var1) throws HibernateException, NamingException {
      if (this.salaries.getSalNature() == null || this.salaries.getSalNature().isEmpty()) {
         this.salaries.setSalNature(((SelectItem)this.mesNatureAgentItems.get(0)).getValue().toString());
      }

      if (this.salaries.getSalMatricule() == null || this.salaries.getSalMatricule().isEmpty()) {
         String var2 = "";
         if (this.optionPaye.getChronoMatricule().equals("0")) {
            var2 = this.calculChrono.matriculeCompose(this.salaries.getSalDateCreat(), 81, this.salaries.getSalNature(), var1);
         } else if (!this.optionPaye.getChronoMatricule().equals("1")) {
            if (this.optionPaye.getChronoMatricule().equals("2")) {
               var2 = this.calculChrono.matriculeCompose(this.salaries.getSalDateCreat(), 81, this.rechercheTypeFeuille(var1), var1);
            } else if (this.optionPaye.getChronoMatricule().equals("3")) {
               var2 = this.calculChrono.matriculeCompose(this.salaries.getSalDateCreat(), 81, this.rechercheTypeFeuille(var1), var1);
            }
         }

         new Salaries();
         Salaries var3 = this.salariesDao.chargerlesSalaries(var2, var1);
         if (var3 != null) {
            int var4 = this.salariesDao.rechercheDernierByNature(this.salaries.getSalNature(), var1);
            if (var4 <= 9) {
               var2 = "00000" + var4;
            } else if (var4 >= 10 && var4 <= 99) {
               var2 = "0000" + var4;
            } else if (var4 >= 100 && var4 <= 999) {
               var2 = "000" + var4;
            } else if (var4 >= 1000 && var4 <= 9999) {
               var2 = "00" + var4;
            } else if (var4 >= 10000 && var4 <= 99999) {
               var2 = "0" + var4;
            } else if (var4 >= 100000 && var4 <= 999999) {
               var2 = "" + var4;
            }
         }

         this.salaries.setSalMatricule(var2);
      }

   }

   public void saveEtatSalaries() throws HibernateException, NamingException {
      if (this.salaries.getSalId() != 0L) {
         this.salaries = this.salariesDao.modif(this.salaries);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Modification etat du salarié N° " + this.salaries.getSalMatricule() + ": Nouvel etat: " + this.salaries.getLib_etat());
         this.espionDao.mAJEspion(var1);
      }

      this.showModalVisuEtat = false;
   }

   public void saveProtectionSalaries() throws HibernateException, NamingException {
      if (this.salaries.getSalId() != 0L) {
         this.salaries = this.salariesDao.modif(this.salaries);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         String var2 = "";
         if (this.salaries.getSalProtege() == 1) {
            var2 = "Protégé";
         } else {
            var2 = "Non protégé";
         }

         var1.setEspaction("Modification protection du salarié N° " + this.salaries.getSalMatricule() + ": Nouveau statut: " + var2);
         this.espionDao.mAJEspion(var1);
      }

      this.showModalVisuEtat = false;
   }

   public String rechercheTypeFeuille(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new ArrayList();
      ChronoDao var4 = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.selectListPaye(0, var1);
      if (this.optionPaye.getChronoMatricule().equals("2")) {
         if (var3.size() != 0) {
            for(int var5 = 0; var5 < var3.size(); ++var5) {
               if (((Chrono)var3.get(var5)).getChrNature() == 81 && (((Chrono)var3.get(var5)).getChrNum() != 0L || ((Chrono)var3.get(var5)).getChrNumAn() != 0L)) {
                  String[] var6 = ((Chrono)var3.get(var5)).getChrSerie().split(":");
                  var2 = var6[0];
                  break;
               }
            }
         }
      } else if (this.optionPaye.getChronoMatricule().equals("3")) {
         String var8 = "";
         if (this.salaries.getSalNature().startsWith("0")) {
            var8 = "0";
         } else {
            var8 = "9";
         }

         if (var3.size() != 0) {
            for(int var9 = 0; var9 < var3.size(); ++var9) {
               if (((Chrono)var3.get(var9)).getChrNature() == 81) {
                  String[] var7;
                  if (var8.endsWith("0") && ((Chrono)var3.get(var9)).getChrSerie().startsWith("0")) {
                     if (((Chrono)var3.get(var9)).getChrNum() != 0L || ((Chrono)var3.get(var9)).getChrNumAn() != 0L) {
                        var7 = ((Chrono)var3.get(var9)).getChrSerie().split(":");
                        var2 = var7[0];
                        break;
                     }
                  } else if (var8.equals("9") && !((Chrono)var3.get(var9)).getChrSerie().startsWith("0") && (((Chrono)var3.get(var9)).getChrNum() != 0L || ((Chrono)var3.get(var9)).getChrNumAn() != 0L)) {
                     var7 = ((Chrono)var3.get(var9)).getChrSerie().split(":");
                     var2 = var7[0];
                     break;
                  }
               }
            }
         }
      }

      if (var2 == null || var2.isEmpty()) {
         var2 = "XX";
      }

      return var2;
   }

   public void calculeNationPays() {
      this.salaries.setSalNationnalite(this.calculNationnalite(this.salaries.getSalPaysNaissance()));
   }

   public void calculeGenreCivil() {
      this.salaries.setSalGenre(this.calculCivilite(this.salaries.getSalCivilite()));
      this.afficheNomJf();
   }

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      this.uri = var1.calculMap(this.salaries.getSalRue(), this.salaries.getSalAdresse(), this.salaries.getSalVille(), this.salaries.getSalNompays());
      this.showModalGoogleMap = true;
   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void visuEtat() {
      if (this.salaries != null && this.usersLog.getUsrPaye() == 0) {
         this.showModalVisuEtat = true;
      }

   }

   public void fermerVisuEtat() {
      this.showModalVisuEtat = false;
   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.salariesContrats.getSalconActivite() != null && !this.salariesContrats.getSalconActivite().isEmpty() && this.salariesContrats.getSalconActivite().contains(":")) {
         String[] var1 = null;
         if (!this.salariesContrats.getSalconActivite().contains("#")) {
            var1 = this.salariesContrats.getSalconActivite().split(":");
            if (var1.length == 7) {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
               this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
               this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.salariesContrats.getSalconActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 7) {
                  this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                  this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
                  this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
                  this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
                  this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               }
            }
         }
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void selectionAnalytique() {
      if (this.dataModelDecoupageActivtes.isRowAvailable()) {
         this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.dataModelDecoupageActivtes.getRowData();
      }

   }

   public void valideColonne1() {
      if (this.ecrituresAnalytiqueCtrl.getZoneActivite() != null && !this.ecrituresAnalytiqueCtrl.getZoneActivite().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneActivite().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneActivite().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal1() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal1().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal1().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal1().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal3() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal3().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal3().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal3().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void supprimerAnalytique() {
      if (this.ecrituresAnalytiqueCtrl == null) {
         this.selectionAnalytique();
      }

      if (this.ecrituresAnalytiqueCtrl != null) {
         this.lesDecoupagesActivites.remove(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         this.ecrituresAnalytiqueCtrl = null;
      }

      if (this.lesDecoupagesActivites.size() == 0) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void controleEcartAnalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var1 = 0; var1 < this.lesDecoupagesActivites.size(); ++var1) {
            this.totalImputation += (double)((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var1)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = 100.0D - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void informationPiece() throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salaries.getSalUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salaries.getSalUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salaries.getSalUserModif() != 0L) {
            var1 = var2.selectUserD(this.salaries.getSalUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void informationPieceContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salariesContrats.getSalconUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salariesContrats.getSalconUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesContrats.getSalconUserModif() != 0L) {
            var1 = var2.selectUserD(this.salariesContrats.getSalconUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void informationPieceRH() throws HibernateException, NamingException {
      if (this.salariesGrh != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salariesGrh.getSalgrhUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salariesGrh.getSalgrhUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesGrh.getSalgrhUserModif() != 0L) {
            var1 = var2.selectUserD(this.salariesGrh.getSalgrhUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void fermerInformationPiece() {
      this.showModalPanelInformation = false;
   }

   public void rechercherSalarieRh() throws HibernateException, NamingException {
      this.rechercherSalarieRh((Session)null);
   }

   public void rechercherSalarieRh(Session var1) throws HibernateException, NamingException {
      if (this.var_etat_rec != 100) {
         this.lesSalariesGrh.clear();
         this.extDTableGrh = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteGrh.clear();
         this.var_affiche_rh = false;
         new ArrayList();
         List var2 = this.salariesGrhDao.chargerlesElementRh(this.var_typerh_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.salariesGrh = (SalariesGrh)var2.get(var3);
               boolean var4 = false;
               if (this.salariesGrh.getSalaries().getSalNature() != null && !this.salariesGrh.getSalaries().getSalNature().isEmpty()) {
                  for(int var5 = 0; var5 < this.mesNatureAgentItems.size(); ++var5) {
                     if (((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString().equals(this.salariesGrh.getSalaries().getSalNature())) {
                        var4 = true;
                        break;
                     }
                  }
               }

               if (var4) {
                  this.lesSalariesGrh.add(this.salariesGrh);
               }
            }
         }

         this.dataModelGrh.setWrappedData(this.lesSalariesGrh);
      }

   }

   public void calculeElementRh() throws HibernateException, NamingException {
      this.var_lib_rh = "";
      this.var_typelib_rh = "";
      if (this.mesElementRhItems.size() != 0) {
         for(int var1 = 0; var1 < this.mesElementRhItems.size(); ++var1) {
            if (((SelectItem)this.mesElementRhItems.get(var1)).getValue().equals(this.var_rh_rec)) {
               this.var_lib_rh = ((SelectItem)this.mesElementRhItems.get(var1)).getLabel();
               break;
            }
         }
      }

      this.salariesGrh.setSalgrhNature(this.var_rh_rec);
      this.chargerModeleSpe();
      this.lesSalariesGrh.clear();
      this.dataModelGrh.setWrappedData(this.lesSalariesGrh);
      this.var_affiche_rh = false;
      if (this.var_rh_rec == 100) {
         this.ajoutRh = false;
      } else {
         this.ajoutRh = true;
      }

   }

   public void calculeElementSuiteRh() throws HibernateException, NamingException {
      this.var_typelib_rh = "";
      if (this.mesTypeRhItems.size() != 0) {
         for(int var1 = 0; var1 < this.mesTypeRhItems.size(); ++var1) {
            if (((SelectItem)this.mesTypeRhItems.get(var1)).getValue().equals("" + this.var_typerh_rec)) {
               this.var_typelib_rh = ((SelectItem)this.mesTypeRhItems.get(var1)).getLabel();
               break;
            }
         }
      }

      this.salariesGrh.setSalgrhType(this.var_typerh_rec);
   }

   public void ajouterElementRh() throws HibernateException, NamingException {
      if (this.var_rh_rec >= 0 && this.var_rh_rec < 100) {
         this.salaries = new Salaries();
         this.salariesGrh = new SalariesGrh();
         this.salariesGrh.setSalgrhNature(this.var_rh_rec);
         this.salariesGrh.setSalgrhType(this.var_typerh_rec);
         this.salariesGrh.setSalgrhDate(new Date());
         this.salariesGrh.setSalgrhResponsable(this.usersLog.getUsrPatronyme());
         this.salariesGrh.setSalgrhObjet(this.var_lib_rh + ":" + this.var_typelib_rh);
         this.var_code_modele = "100";
         this.chargerModeleSpe();
         this.salariesGrh.setSalgrhNature(this.var_rh_rec);
         this.salariesGrh.setSalgrhType(this.var_typerh_rec);
         this.nomSalarie = "";
         this.var_action = 1;
         this.mesModelesItems.clear();
         if (this.var_rh_rec == 83) {
            this.recupererAttestationItem();
         } else if (this.var_rh_rec == 85) {
            this.recupererCertificatItem();
         } else if (this.var_rh_rec == 86) {
            this.recupererCorrespondanceItem();
         }

         if (this.salariesGrh.getSalgrhNature() != 0 && this.salariesGrh.getSalgrhNature() != 84) {
            this.var_affiche_tdt_rh = true;
         } else {
            this.var_affiche_tdt_rh = false;
         }

         this.showModalPanelRh = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void modifierElementRh() throws HibernateException, NamingException {
      if (this.salariesGrh != null) {
         this.salaries = this.salariesGrh.getSalaries();
         this.chargerModeleSpe();
         this.salariesGrh.setSalgrhNature(this.var_rh_rec);
         this.salariesGrh.setSalgrhType(this.var_typerh_rec);
         this.var_action = 2;
         this.showModalPanelRh = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterElementRh() throws HibernateException, NamingException {
      if (this.salariesGrh != null) {
         this.salaries = this.salariesGrh.getSalaries();
         this.chargerModeleSpe();
         this.salariesGrh.setSalgrhNature(this.var_rh_rec);
         this.salariesGrh.setSalgrhType(this.var_typerh_rec);
         this.var_action = 3;
         this.showModalPanelRh = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerElementRh() throws HibernateException, NamingException {
      if (this.salariesGrh != null) {
         if (this.salariesGrh.getSalgrhEtat() == 0) {
            this.salariesGrhDao.delete(this.salariesGrh);
            this.lesSalariesGrh.remove(this.salariesGrh);
            this.dataModelGrh.setWrappedData(this.lesSalariesGrh);
         }

         this.var_action = 0;
         this.extDTableGrh = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteGrh.clear();
      }

   }

   public void annulerElementRh() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEnteteGrh.clear();
      this.extDTableGrh = new HtmlExtendedDataTable();
   }

   public void saveElementRh() throws HibernateException, NamingException {
      this.saveRh();
      this.var_action = 0;
   }

   public void recupererContrat() {
      this.lesSalariesContrats.clear();
      this.extDTableCrt = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteCrt.clear();
      this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
      this.var_affiche_contrat = false;
   }

   public void rechercherSalarieContrat() throws HibernateException, NamingException, ParseException {
      this.rechercherSalarieContrat((Session)null);
   }

   public void rechercherSalarieContrat(Session var1) throws HibernateException, NamingException, ParseException {
      String var2 = "";
      if (this.mesNatureAgentItems.size() != 0) {
         for(int var3 = 0; var3 < this.mesNatureAgentItems.size(); ++var3) {
            if (((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString().isEmpty()) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               } else {
                  var2 = "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               }
            }
         }
      }

      Date var7 = null;
      if (this.exercicesPaye.getExepayId() != this.lastExoPaye.getExepayId()) {
         new UtilDate();
         var7 = this.exercicesPaye.getExepayDateDebut();
      }

      this.extDTableCrt = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteCrt.clear();
      this.var_affiche_contrat = false;
      if (this.var_nature_rec != null && !this.var_nature_rec.isEmpty() || this.var_immat_rec != null && !this.var_immat_rec.isEmpty()) {
         this.lesSalariesContrats.clear();
         int var4 = Integer.parseInt(this.optionPaye.getTriAgents());
         if (!this.accesInterim) {
            this.lesSalariesContrats = this.salariesContratsDao.chargerlesContrats(var4, var2, this.var_valide_rec, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_projet_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.var_localisation_rec, this.var_budget_rec, var7, var1);
         } else {
            long var5 = 0L;
            if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("100")) {
               var5 = 0L;
            } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("101")) {
               var5 = -1L;
            } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && !this.var_tiers_rec.equals("101") && !this.var_tiers_rec.equals("100")) {
               var5 = Long.parseLong(this.var_tiers_rec);
            } else {
               var5 = -1L;
            }

            this.var_budget_rec = "";
            this.lesSalariesContrats = this.salariesContratsDao.chargerlesContrats(var4, var2, this.var_valide_rec, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_projet_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.var_budget_rec, this.var_localisation_rec, var5, var7, var1);
         }

         this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
         this.mesModelesItems = new ArrayList();
         if (this.var_nature_rec != null && !this.var_nature_rec.isEmpty()) {
            ModelesCourriersDao var8 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
            this.mesModelesItems = var8.chargerLesModeles(82, this.var_nature_rec, (Session)null);
         }
      }

   }

   public void calculeElementContrat() {
      this.var_lib_contrat = "";
      if (this.mesNatureAgentItems.size() != 0) {
         for(int var1 = 0; var1 < this.mesNatureAgentItems.size(); ++var1) {
            if (((SelectItem)this.mesNatureAgentItems.get(var1)).getValue().equals(this.var_nature_rec)) {
               this.var_lib_contrat = ((SelectItem)this.mesNatureAgentItems.get(var1)).getLabel();
               break;
            }
         }
      }

      this.lesSalariesContrats.clear();
      this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
      this.var_affiche_contrat = false;
      if (this.var_nature_rec != null && !this.var_nature_rec.isEmpty()) {
         this.ajoutCrt = true;
      } else {
         this.ajoutCrt = false;
      }

   }

   public void ajouterElementContrat() throws HibernateException, NamingException {
      if (this.var_nature_rec != null && !this.var_nature_rec.isEmpty()) {
         this.lesAvenants.clear();
         this.dataModelAvenants.setWrappedData(this.lesAvenants);
         this.salaries = new Salaries();
         this.salariesContrats = new SalariesContrats();
         this.salariesContrats.setSalconType(this.var_nature_rec);
         this.var_tiers = 0L;
         this.nomSalarie = "";
         this.var_action = 1;
         this.var_action_contrat = this.var_action;
         if (this.decoupageActivite) {
            this.lesDecoupagesActivites.clear();
            this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         }

         if (this.accesInterim) {
            this.mesServiceItems.clear();
         }

         this.var_memo_action = this.var_action;
      }

   }

   public void modifierElementContrat() {
      if (this.salariesContrats != null) {
         this.salaries = this.salariesContrats.getSalaries();
         this.var_action = 2;
         this.var_action_contrat = this.var_action;
         this.var_memo_action = this.var_action;
      }

   }

   public void calculeRubriqueContrat() throws HibernateException, NamingException {
      this.calculeRubriqueContrat((Session)null);
   }

   public void calculeRubriqueContrat(Session var1) throws HibernateException, NamingException {
      this.var_sursalaire = false;
      this.var_forfaitHeureSup = false;
      this.var_forfaitPrestataire = false;
      this.var_outillage = false;
      this.var_astreinte = false;
      this.var_redement = false;
      this.var_responsbilite = false;
      this.var_fonction = false;
      this.var_prm_transport = false;
      this.var_prm_logement = false;
      this.var_sujetion = false;
      this.var_exceptionnel = false;
      this.var_caisse = false;
      this.var_deplacement = false;
      this.var_logement = false;
      this.var_transport = false;
      this.var_kilometre = false;
      this.var_salissure = false;
      this.var_representation = false;
      this.var_diverse = false;
      this.var_indemResons = false;
      this.var_nourriture = false;
      this.var_avn_logement = false;
      this.var_avn_domesticite = false;
      this.var_avn_eau = false;
      this.var_avn_electricite = false;
      this.var_avn_nourriture = false;
      this.var_avn_vehicule = false;
      this.var_avn_telephone = false;
      if (this.salariesContrats != null) {
         this.contratValide = false;
         boolean var2 = true;

         for(int var3 = 0; var3 < this.lesSalariesContrats.size(); ++var3) {
            if (this.salariesContrats.getSalaries().getSalId() == ((SalariesContrats)this.lesSalariesContrats.get(var3)).getSalaries().getSalId() && this.salariesContrats.getSalconId() != ((SalariesContrats)this.lesSalariesContrats.get(var3)).getSalconId() && ((SalariesContrats)this.lesSalariesContrats.get(var3)).getSalconEtatH() <= 1 && ((SalariesContrats)this.lesSalariesContrats.get(var3)).getSalconFeuille().equals(this.salariesContrats.getSalconFeuille())) {
               var2 = false;
               break;
            }
         }

         if (var2) {
            this.contratValide = true;
            new FeuilleCalcul();
            FeuilleCalcul var7 = this.feuilleCalculDao.chercherCode(this.salariesContrats.getSalconFeuille(), this.exercicesPaye.getExepayId(), var1);
            if (var7 != null) {
               new ArrayList();
               List var4 = this.feuilleCalculFormuleDao.chargerFeuille(var7, var1);
               if (var4.size() != 0) {
                  FeuilleCalculFormule var5 = null;

                  for(int var6 = 0; var6 < var4.size(); ++var6) {
                     var5 = (FeuilleCalculFormule)var4.get(var6);
                     if (var5.getFeurubforFormule().contains("M000052")) {
                        this.var_sursalaire = true;
                     } else if (var5.getFeurubforFormule().contains("M000084")) {
                        this.var_forfaitPrestataire = true;
                     } else if (var5.getFeurubforFormule().contains("M000088")) {
                        this.var_forfaitHeureSup = true;
                     } else if (var5.getFeurubforFormule().contains("M000089")) {
                        this.var_outillage = true;
                     } else if (var5.getFeurubforFormule().contains("M000093")) {
                        this.var_astreinte = true;
                     } else if (var5.getFeurubforFormule().contains("M000053")) {
                        this.var_redement = true;
                     } else if (var5.getFeurubforFormule().contains("M000054")) {
                        this.var_responsbilite = true;
                     } else if (var5.getFeurubforFormule().contains("M000055")) {
                        this.var_fonction = true;
                     } else if (var5.getFeurubforFormule().contains("M000225")) {
                        this.var_prm_transport = true;
                     } else if (var5.getFeurubforFormule().contains("M000226")) {
                        this.var_prm_logement = true;
                     } else if (var5.getFeurubforFormule().contains("M000082")) {
                        this.var_sujetion = true;
                     } else if (var5.getFeurubforFormule().contains("M000056")) {
                        this.var_caisse = true;
                     } else if (var5.getFeurubforFormule().contains("M000059")) {
                        this.var_deplacement = true;
                     } else if (var5.getFeurubforFormule().contains("M000058")) {
                        this.var_logement = true;
                     } else if (var5.getFeurubforFormule().contains("M000057")) {
                        this.var_transport = true;
                     } else if (var5.getFeurubforFormule().contains("M000060")) {
                        this.var_kilometre = true;
                     } else if (var5.getFeurubforFormule().contains("M000061")) {
                        this.var_salissure = true;
                     } else if (var5.getFeurubforFormule().contains("M000083")) {
                        this.var_representation = true;
                     } else if (var5.getFeurubforFormule().contains("M000154")) {
                        this.var_diverse = true;
                     } else if (var5.getFeurubforFormule().contains("M000156")) {
                        this.var_indemResons = true;
                     } else if (var5.getFeurubforFormule().contains("M000157")) {
                        this.var_nourriture = true;
                     } else if (var5.getFeurubforFormule().contains("M000062")) {
                        this.var_avn_logement = true;
                     } else if (var5.getFeurubforFormule().contains("M000063")) {
                        this.var_avn_domesticite = true;
                     } else if (var5.getFeurubforFormule().contains("M000065")) {
                        this.var_avn_eau = true;
                     } else if (var5.getFeurubforFormule().contains("M000066")) {
                        this.var_avn_electricite = true;
                     } else if (var5.getFeurubforFormule().contains("M000067")) {
                        this.var_avn_nourriture = true;
                     } else if (var5.getFeurubforFormule().contains("M000068")) {
                        this.var_avn_vehicule = true;
                     } else if (var5.getFeurubforFormule().contains("M000064")) {
                        this.var_avn_telephone = true;
                     } else if (var5.getFeurubforFormule().contains("M000147")) {
                        this.var_exceptionnel = true;
                     }
                  }
               }
            }
         } else {
            this.contratValide = false;
            this.formRecherche.setMessageTexte("Cette feuille est déjà utilisée sur un contrat actif. Veuillez utiliser une autre feuille.");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void calculeFeuilleContrat(Session var1) throws HibernateException, NamingException {
      this.mesFeuillesContratItems.clear();
      List var2;
      int var3;
      if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && this.salaries.getSalNature().equals("04")) {
         new ArrayList();
         var2 = this.feuilleCalculDao.chargerFeuilleNature(this.exercicesPaye.getExepayId(), this.salaries.getSalNature(), var1);
         if (var2.size() != 0) {
            for(var3 = 0; var3 < var2.size(); ++var3) {
               this.mesFeuillesContratItems.add(new SelectItem(((FeuilleCalcul)var2.get(var3)).getFeuCode(), ((FeuilleCalcul)var2.get(var3)).getFeuCode() + ":" + ((FeuilleCalcul)var2.get(var3)).getFeuLibelleFr()));
            }
         }
      } else if (this.salariesContrats != null && this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty()) {
         new ArrayList();
         var2 = this.feuilleCalculDao.chargerFeuilleNature(this.exercicesPaye.getExepayId(), this.salariesContrats.getSalconType(), var1);
         if (var2.size() != 0) {
            for(var3 = 0; var3 < var2.size(); ++var3) {
               this.mesFeuillesContratItems.add(new SelectItem(((FeuilleCalcul)var2.get(var3)).getFeuCode(), ((FeuilleCalcul)var2.get(var3)).getFeuCode() + ":" + ((FeuilleCalcul)var2.get(var3)).getFeuLibelleFr()));
            }
         }
      }

   }

   public void consulterElementContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salaries = this.salariesContrats.getSalaries();
         this.var_action = 3;
         this.var_action_contrat = this.var_action;
         this.var_memo_action = this.var_action;
      }

   }

   public void muterElementContrat() throws ParseException, ParseException {
      if (this.salariesContrats != null) {
         UtilDate var1 = new UtilDate();
         this.salaries = this.salariesContrats.getSalaries();
         this.salariesContratsMuter = new SalariesContrats();
         this.var_siteMuter = "";
         this.var_departementMuter = "";
         this.var_serviceMuter = "";
         this.var_conventionMuter = "";
         this.var_niveauMuter = "";
         this.var_classementMuter = "";
         this.var_grilleMuter = "";
         this.var_centreMuter = "";
         this.var_activiteMuter = "";
         this.var_localisationMuter = "";
         this.var_budgetMuter = "";
         this.var_projetMuter = "";
         this.var_cle1Muter = "";
         this.var_cle2Muter = "";
         this.var_code_modeleMuter = "";
         this.lesDecoupagesActivitesMuter = new ArrayList();
         this.dataModelDecoupageActivtesMuter = new ListDataModel();
         this.var_action = 4;
         if (this.salariesContrats.getSalconDateFin() != null) {
            this.salariesContratsMuter.setSalconDateDebut(var1.dateJourSuivant(this.salariesContrats.getSalconDateFin()));
         }

         this.salariesContratsMuter.setSalconDateEntreeInitial(this.salariesContrats.getSalconDateDebut());
         this.salariesContratsMuter.setSalconFonction(this.salariesContrats.getSalconFonction());
         this.salariesContratsMuter.setSalconFonction(this.salariesContrats.getSalconFonction());
         this.salariesContratsMuter.setSalconLieuTravail(this.salariesContrats.getSalconLieuTravail());
         this.salariesContratsMuter.setSalconNbJourTr(this.salariesContrats.getSalconNbJourTr());
         this.salariesContratsMuter.setSalconNbJourCp(this.salariesContrats.getSalconNbJourCp());
         this.var_action_contrat = this.var_action;
         this.var_memo_action = this.var_action;
      }

   }

   public void duppliquerElementContrat() throws HibernateException, NamingException, ParseException {
      if (this.salariesContrats != null) {
         this.salaries = this.salariesContrats.getSalaries();
         this.var_action = 1;
         this.var_action_contrat = this.var_action;
         if (this.decoupageActivite) {
            this.lesDecoupagesActivites.clear();
            this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         }

         this.duppliquerContrat();
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerElementContrat() {
      if (this.salariesContrats != null) {
         this.var_action = 0;
         this.extDTableCrt = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteCrt.clear();
      }

   }

   public void annulerElementContrat() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEnteteCrt.clear();
      this.extDTableCrt = new HtmlExtendedDataTable();
   }

   public void saveElementContrat() throws HibernateException, NamingException {
      this.saveContrat();
      this.var_action = 0;
   }

   public void saveElementContratMuter() throws NamingException, ParseException {
      this.saveContratMuter();
      this.var_action = 0;
   }

   public void rechercherSalarieImputation() throws HibernateException, NamingException {
      this.rechercherSalarieImputation((Session)null);
   }

   public void rechercherSalarieImputation(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.mesNatureAgentItems.size() != 0) {
         for(int var3 = 0; var3 < this.mesNatureAgentItems.size(); ++var3) {
            if (((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString().isEmpty()) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               } else {
                  var2 = "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               }
            }
         }
      }

      Date var7 = null;
      if (this.exercicesPaye.getExepayId() != this.lastExoPaye.getExepayId()) {
         new UtilDate();
         var7 = this.exercicesPaye.getExepayDateDebut();
      }

      this.lesSalariesContrats.clear();
      int var4 = Integer.parseInt(this.optionPaye.getTriAgents());
      long var5 = 0L;
      if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("100")) {
         var5 = 0L;
      } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("101")) {
         var5 = -1L;
      } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && !this.var_tiers_rec.equals("101") && !this.var_tiers_rec.equals("100")) {
         var5 = Long.parseLong(this.var_tiers_rec);
      } else {
         var5 = -1L;
      }

      if (this.var_nature_rec == null || this.var_nature_rec.isEmpty()) {
         this.var_nature_rec = "100";
      }

      this.lesSalariesContrats = this.salariesContratsDao.chargerlesContrats(var4, var2, this.var_valide_rec, this.var_etat_rec, (String)null, (String)null, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_projet_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.var_budget_rec, this.var_localisation_rec, var5, var7, var1);
      this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
      this.extDTableCrt = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteCrt.clear();
      this.extDTableCrt = new HtmlExtendedDataTable();
   }

   public void visualisationModificationCrt() {
      if (this.salariesContrats != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_contrat = false;
            } else {
               this.var_affiche_contrat = true;
            }
         } else {
            this.var_affiche_contrat = true;
         }

         if (this.var_affiche_contrat) {
            if (this.salariesContrats.getSalconEtat() <= 1) {
               this.modifierImputationContrat();
            } else {
               this.consulterImputationContrat();
            }
         }
      }

   }

   public void modifierImputationContrat() {
      if (this.salariesContrats != null) {
         this.var_action_contrat = 2;
         this.showModalPanelImputation = true;
      }

   }

   public void consulterImputationContrat() {
      if (this.salariesContrats != null) {
         this.var_action_contrat = 3;
         this.showModalPanelImputation = true;
      }

   }

   public void fermerImputation() {
      this.showModalPanelImputation = false;
   }

   public void validerImputation() throws HibernateException, NamingException {
      if (this.salariesContrats != null && this.salaries != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String[] var3;
            if (this.var_service != null && !this.var_service.isEmpty()) {
               if (this.var_service.contains(":")) {
                  var3 = this.var_service.split(":");
                  this.salariesContrats.setSalconService(var3[0]);
                  if (!this.var_service.endsWith(":")) {
                     this.salariesContrats.setSalconLibService(var3[1]);
                  } else {
                     this.salariesContrats.setSalconLibService("");
                  }
               } else {
                  this.salariesContrats.setSalconService(this.var_service);
                  this.salariesContrats.setSalconLibService("");
               }
            } else {
               this.salariesContrats.setSalconService("");
               this.salariesContrats.setSalconLibService("");
            }

            if (this.var_site != null && !this.var_site.isEmpty()) {
               if (this.var_site.contains(":")) {
                  var3 = this.var_site.split(":");
                  this.salariesContrats.setSalconSite(var3[0]);
               } else {
                  this.salariesContrats.setSalconSite(this.var_site);
               }
            } else {
               this.salariesContrats.setSalconSite("");
            }

            if (this.var_departement != null && !this.var_departement.isEmpty()) {
               if (this.var_departement.contains(":")) {
                  var3 = this.var_departement.split(":");
                  this.salariesContrats.setSalconDepartement(var3[0]);
               } else {
                  this.salariesContrats.setSalconDepartement(this.var_departement);
               }
            } else {
               this.salariesContrats.setSalconDepartement("");
            }

            if (this.var_feuille != null && !this.var_feuille.isEmpty()) {
               if (this.var_feuille.contains(":")) {
                  var3 = this.var_feuille.split(":");
                  this.salariesContrats.setSalconFeuille(var3[0]);
               } else {
                  this.salariesContrats.setSalconFeuille(this.var_feuille);
               }
            } else {
               this.salariesContrats.setSalconFeuille("");
            }

            if (this.var_activite != null && !this.var_activite.isEmpty()) {
               if (this.var_activite.contains(":")) {
                  var3 = this.var_activite.split(":");
                  this.salariesContrats.setSalconActivite(var3[0]);
                  if (!this.var_activite.endsWith(":")) {
                     this.salariesContrats.setSalconLibActivite(var3[1]);
                  } else {
                     this.salariesContrats.setSalconLibActivite("");
                  }
               } else {
                  this.salariesContrats.setSalconActivite(this.var_activite);
                  this.salariesContrats.setSalconLibActivite("");
               }
            } else {
               this.salariesContrats.setSalconActivite("");
               this.salariesContrats.setSalconLibActivite("");
            }

            if (this.var_localisation != null && !this.var_localisation.isEmpty()) {
               this.salariesContrats.setSalconLocalisation(this.var_localisation);
            } else {
               this.salariesContrats.setSalconLocalisation("");
            }

            if (this.var_budget != null && !this.var_budget.isEmpty()) {
               if (this.var_budget.contains(":")) {
                  var3 = this.var_budget.split(":");
                  this.salariesContrats.setSalconBudget(var3[0]);
                  if (!this.var_budget.endsWith(":")) {
                     this.salariesContrats.setSalconLibBudget(var3[1]);
                  } else {
                     this.salariesContrats.setSalconLibBudget("");
                  }
               } else {
                  this.salariesContrats.setSalconBudget(this.var_budget);
                  this.salariesContrats.setSalconLibBudget("");
               }
            } else {
               this.salariesContrats.setSalconBudget("");
               this.salariesContrats.setSalconLibBudget("");
            }

            if (this.var_projet != null && !this.var_projet.isEmpty()) {
               if (this.var_projet.contains(":")) {
                  var3 = this.var_projet.split(":");
                  this.salariesContrats.setSalconProjet(var3[0]);
                  if (!this.var_projet.endsWith(":")) {
                     this.salariesContrats.setSalconLibProjet(var3[1]);
                  } else {
                     this.salariesContrats.setSalconLibProjet("");
                  }
               } else {
                  this.salariesContrats.setSalconProjet(this.var_projet);
                  this.salariesContrats.setSalconLibProjet("");
               }
            } else {
               this.salariesContrats.setSalconProjet("");
               this.salariesContrats.setSalconLibProjet("");
            }

            if (this.salariesContrats.getSalconIdTiers() != 0L) {
               new Tiers();
               TiersDao var4 = new TiersDao(this.baseLog, this.utilInitHibernate);
               Tiers var13 = var4.selectTierD(this.salariesContrats.getSalconIdTiers(), var1);
               if (var13 != null) {
                  this.salariesContrats.setSalconNomTiers(var13.getTieraisonsocialenom());
               }
            } else {
               this.salariesContrats.setSalconIdTiers(0L);
               this.salariesContrats.setSalconNomTiers("");
            }

            if (this.var_cle1 != null && this.var_cle1.contains(":")) {
               var3 = this.var_cle1.split(":");
               this.salariesContrats.setSalconCle1Anal(var3[0]);
               if (!this.var_cle1.endsWith(":")) {
                  this.salariesContrats.setSalconLibCle1Anal(var3[1]);
               } else {
                  this.salariesContrats.setSalconLibCle1Anal("");
               }
            } else {
               this.salariesContrats.setSalconCle1Anal("");
               this.salariesContrats.setSalconLibCle1Anal("");
            }

            if (this.var_cle2 != null && this.var_cle2.contains(":")) {
               var3 = this.var_cle2.split(":");
               this.salariesContrats.setSalconCle2Anal(var3[0]);
               if (!this.var_cle2.endsWith(":")) {
                  this.salariesContrats.setSalconLibCle2Anal(var3[1]);
               } else {
                  this.salariesContrats.setSalconLibCle2Anal("");
               }
            } else {
               this.salariesContrats.setSalconCle2Anal("");
               this.salariesContrats.setSalconLibCle2Anal("");
            }

            this.salariesContrats.setSalconType(this.var_nature);
            this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var1);
            this.salaries.setSalFeuille(this.salariesContrats.getSalconFeuille());
            this.salaries.setSalService(this.salariesContrats.getSalconService());
            this.salaries.setSalLibService(this.salariesContrats.getSalconLibService());
            this.salaries.setSalSite(this.salariesContrats.getSalconSite());
            this.salaries.setSalDepartement(this.salariesContrats.getSalconDepartement());
            this.salaries.setSalActivite(this.salariesContrats.getSalconActivite());
            this.salaries.setSalLocalisation(this.salariesContrats.getSalconLocalisation());
            this.salaries.setSalBudget(this.salariesContrats.getSalconBudget());
            this.salaries.setSalCleAnal1(this.salariesContrats.getSalconCle1Anal());
            this.salaries.setSalCleAnal2(this.salariesContrats.getSalconCle2Anal());
            this.salaries.setSalLibCleAnal1(this.salariesContrats.getSalconLibCle1Anal());
            this.salaries.setSalLibCleAnal2(this.salariesContrats.getSalconLibCle2Anal());
            this.salaries.setSalIdTiers(this.salariesContrats.getSalconIdTiers());
            this.salaries.setSalNomTiers(this.salariesContrats.getSalconNomTiers());
            this.salaries.setSalNature(this.var_nature);
            this.salaries = this.salariesDao.modif(this.salaries, var1);
            new ArrayList();
            SalariesElementsDao var12 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
            List var14 = var12.chargerlesElementsBySalaries(this.salaries, var1);
            if (var14.size() != 0) {
               new SalariesElements();

               for(int var6 = 0; var6 < var14.size(); ++var6) {
                  SalariesElements var5 = (SalariesElements)var14.get(var6);
                  if (this.optionPaye.getModeTravail().equals("0")) {
                     var5.setSaleleFeuille(this.salariesContrats.getSalconFeuille());
                  } else if (this.optionPaye.getModeTravail().equals("1")) {
                     var5.setSaleleFeuille(this.salariesContrats.getSalconActivite());
                  } else if (this.optionPaye.getModeTravail().equals("2")) {
                     var5.setSaleleFeuille(this.salariesContrats.getSalconService());
                  } else if (this.optionPaye.getModeTravail().equals("3")) {
                     var5.setSaleleFeuille(this.salariesContrats.getSalconProjet());
                  } else if (this.optionPaye.getModeTravail().equals("4")) {
                     var5.setSaleleFeuille("" + this.salariesContrats.getSalconIdTiers());
                  }

                  var5.setSaleleService(this.salariesContrats.getSalconService());
                  var5.setSaleleLibService(this.salariesContrats.getSalconLibService());
                  var5.setSaleleActivite(this.salariesContrats.getSalconActivite());
                  var5.setSaleleLocalisation(this.salariesContrats.getSalconLocalisation());
                  var5.setSaleleBudget(this.salariesContrats.getSalconBudget());
                  var5.setSaleleCle1Anal(this.salariesContrats.getSalconCle1Anal());
                  var5.setSaleleCle2Anal(this.salariesContrats.getSalconCle2Anal());
                  var5.setSaleleLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
                  var5.setSaleleLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
                  var5.setSaleleNature(this.var_nature);
                  var12.modif(var5, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelImputation = false;
   }

   public void avenantElementContrat() {
      if (this.salariesContrats.getSalconDateAvenantFin12() != null) {
         this.nbAvenant = 12;
      } else if (this.salariesContrats.getSalconDateAvenantFin11() != null) {
         this.nbAvenant = 12;
      } else if (this.salariesContrats.getSalconDateAvenantFin10() != null) {
         this.nbAvenant = 11;
      } else if (this.salariesContrats.getSalconDateAvenantFin9() != null) {
         this.nbAvenant = 10;
      } else if (this.salariesContrats.getSalconDateAvenantFin8() != null) {
         this.nbAvenant = 9;
      } else if (this.salariesContrats.getSalconDateAvenantFin7() != null) {
         this.nbAvenant = 8;
      } else if (this.salariesContrats.getSalconDateAvenantFin6() != null) {
         this.nbAvenant = 7;
      } else if (this.salariesContrats.getSalconDateAvenantFin5() != null) {
         this.nbAvenant = 6;
      } else if (this.salariesContrats.getSalconDateAvenantFin4() != null) {
         this.nbAvenant = 5;
      } else if (this.salariesContrats.getSalconDateAvenantFin3() != null) {
         this.nbAvenant = 4;
      } else if (this.salariesContrats.getSalconDateAvenantFin2() != null) {
         this.nbAvenant = 3;
      } else if (this.salariesContrats.getSalconDateAvenantFin1() != null) {
         this.nbAvenant = 2;
      } else {
         this.salariesContrats.setSalconDateAvenantDeb1(this.salariesContrats.getSalconDateFin());
         this.nbAvenant = 1;
      }

      this.showModalPanelAvenant = true;
   }

   public void fermerAvenant() {
      this.showModalPanelAvenant = false;
   }

   public void validerAvenant() throws HibernateException, NamingException {
      if (this.salariesContrats.getSalconDateAvenantFin12() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin12());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin11() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin11());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin10() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin10());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin9() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin9());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin8() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin8());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin7() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin7());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin6() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin6());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin5() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin5());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin4() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin4());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin3() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin3());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin2() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin2());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      } else if (this.salariesContrats.getSalconDateAvenantFin1() != null) {
         this.salariesContrats.setSalconDateFin(this.salariesContrats.getSalconDateAvenantFin1());
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
      }

      this.showModalPanelAvenant = false;
   }

   public void gelerImputationContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salariesContrats.setSalconEtat(9);
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
         this.salaries.setSalEtat(9);
         this.salariesDao.modif(this.salaries);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         UtilDate var2 = new UtilDate();
         var1.setEspaction("Geler le contrat (M.) N° " + this.salariesContrats.getSalconNum() + " du " + var2.dateToStringSQLLight(this.salariesContrats.getSalconDateDebut()));
         this.espionDao.mAJEspion(var1);
         this.lesSalariesContrats.remove(this.salariesContrats);
         this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
         this.var_affiche_contrat = false;
         this.extDTableCrt = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteCrt.clear();
      }

   }

   public void degelerImputationContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salariesContrats.setSalconEtat(0);
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
         this.salaries.setSalEtat(0);
         this.salariesDao.modif(this.salaries);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         UtilDate var2 = new UtilDate();
         var1.setEspaction("Dégeler le contrat (M.) N° " + this.salariesContrats.getSalconNum() + " du " + var2.dateToStringSQLLight(this.salariesContrats.getSalconDateDebut()));
         this.espionDao.mAJEspion(var1);
         this.lesSalariesContrats.remove(this.salariesContrats);
         this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
         this.var_affiche_contrat = false;
         this.extDTableCrt = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteCrt.clear();
      }

   }

   public void protegerSalaries() throws HibernateException, NamingException {
      if (this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Salaries();
            new Espion();

            for(int var5 = 0; var5 < this.lesSalaries.size(); ++var5) {
               Salaries var3 = (Salaries)this.lesSalaries.get(var5);
               var3.setSalProtege(1);
               this.salariesDao.modif(var3, var1);
               Espion var4 = new Espion();
               var4.setUsers(this.usersLog);
               var4.setEsptype(0);
               var4.setEspdtecreat(new Date());
               var4.setEspaction("Modification protection du salarié N° " + this.salaries.getSalMatricule() + ": Nouveau statut: Protégé");
               this.espionDao.mAJEspion(var4, var1);
            }

            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void deprotegerSalaries() throws HibernateException, NamingException {
      if (this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Salaries();
            new Espion();

            for(int var5 = 0; var5 < this.lesSalaries.size(); ++var5) {
               Salaries var3 = (Salaries)this.lesSalaries.get(var5);
               var3.setSalProtege(0);
               this.salariesDao.modif(var3, var1);
               Espion var4 = new Espion();
               var4.setUsers(this.usersLog);
               var4.setEsptype(0);
               var4.setEspdtecreat(new Date());
               var4.setEspaction("Modification protection du salarié N° " + this.salaries.getSalMatricule() + ": Nouveau statut: Déprotégé");
               this.espionDao.mAJEspion(var4, var1);
            }

            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void verifFeuilleCalcul() {
   }

   public void affichePhoto() throws IOException, SQLException {
      if (this.salaries.getSalPhoto() != null) {
         this.urlphotoAgent = "structure" + this.structureLog.getStrid() + "/photos/Agents/" + this.salaries.getSalPhoto();
      } else {
         this.urlphotoAgent = "";
      }

      if (this.salaries.getSalDocument() != null && !this.salaries.getSalDocument().isEmpty()) {
         this.var_affFicPdf = true;
      } else {
         this.var_affFicPdf = false;
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.salaries != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               String var2 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var3 = var2.substring(var2.indexOf(".") + 1);
               var2 = this.salaries.getSalId() + "_P." + var3;
               File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Agents" + File.separator + var2);
               boolean var5 = var4.delete();
               File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Agents" + File.separator), var2);
               this.utilDownload.write(var6, this.uploadedFile.getInputStream());
               this.fileName = var2;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.salaries.setSalPhoto(this.fileName);
               this.salaries = this.salariesDao.modif(this.salaries);
               this.urlphotoAgent = "structure" + this.structureLog.getStrid() + "/photos/Agents/" + this.salaries.getSalPhoto();
            }
         } catch (IOException var7) {
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      if (this.salaries != null) {
         String var1 = "";
         int var2 = this.salaries.getSalPhoto().lastIndexOf(".");
         if (0 < var2 && var2 <= this.salaries.getSalPhoto().length() - 2) {
            var1 = "." + this.salaries.getSalPhoto().substring(var2 + 1);
         }

         String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Agents") + File.separator + this.salaries.getSalMatricule() + var1;
         File var4 = new File(var3);
         if (var4.exists()) {
            var4.delete();
         }

         this.salaries.setSalPhoto((String)null);
         this.salaries = this.salariesDao.modif(this.salaries);
      }

   }

   public void submitCV() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.salaries != null && this.uploadedPDFFile != null) {
         String var1 = new File(this.nomrepertRH) + this.salaries.getSalMatricule() + "_8410.pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         FacesContext var3 = FacesContext.getCurrentInstance();

         try {
            File var4 = this.utilDownload.uniqueFile(new File(this.nomrepertRH), var1);
            this.utilDownload.write(var4, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var1;
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.salaries.setSalDocument(var1);
            this.salaries = this.salariesDao.modif(this.salaries);
            this.var_affFicPdf = true;
         } catch (IOException var5) {
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
            this.var_affFicPdf = false;
         }
      }

   }

   public void reInitCV() throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.salaries.setSalDocument((String)null);
         if (this.salaries.getSalId() != 0L) {
            this.salaries = this.salariesDao.modif(this.salaries);
         }

         String var1 = new File(this.nomrepertRH) + this.salaries.getSalMatricule() + "_8410.pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.var_affFicPdf = false;
      }

   }

   public void voirCV() throws MalformedURLException, IOException {
      if (this.salaries != null && this.salaries.getSalDocument() != null && !this.salaries.getSalDocument().isEmpty()) {
         String var1 = this.nomrepertRH + this.salaries.getSalMatricule() + "_8410.pdf";
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.salaries.getSalDocument());
         this.showModalPanelPdf = true;
      }

   }

   public void downloadCV() throws FileNotFoundException, IOException {
      if (this.salaries != null && this.salaries.getSalDocument() != null && !this.salaries.getSalDocument().isEmpty()) {
         BufferedInputStream var1 = null;
         BufferedOutputStream var2 = null;
         FacesContext var3 = FacesContext.getCurrentInstance();
         HttpServletResponse var4 = (HttpServletResponse)var3.getExternalContext().getResponse();
         String var5 = new File(this.nomrepertRH) + this.salaries.getSalMatricule() + "_8410.pdf";
         File var6 = new File(var5);
         if (var6.exists()) {
            try {
               var1 = new BufferedInputStream(new FileInputStream(var6), 10240);
               var4.reset();
               var4.setContentType("application/pdf");
               var4.addHeader("Content-disposition", "attachment; filename=" + var6.getName());
               var4.setContentLength((int)var6.length());
               var2 = new BufferedOutputStream(var4.getOutputStream(), 10240);
               byte[] var7 = new byte[10240];

               while(true) {
                  int var8;
                  if ((var8 = var1.read(var7)) <= 0) {
                     var2.flush();
                     break;
                  }

                  var2.write(var7, 0, var8);
               }
            } finally {
               close(var2);
               close(var1);
            }

            var3.responseComplete();
         }
      }

   }

   public void selectionContrat() throws HibernateException, NamingException {
      if (this.extDTableCrt != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEnteteCrt.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableCrt.setRowKey(var3);
            if (this.extDTableCrt.isRowAvailable()) {
               var1.add(this.extDTableCrt.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salariesContrats = (SalariesContrats)var1.get(0);
            this.salaries = this.salariesContrats.getSalaries();
            this.var_tiers = this.salariesContrats.getSalconIdTiers();
            this.var_feuille = this.salariesContrats.getSalconFeuille();
            this.var_nature = this.salaries.getSalNature();
            if (this.salariesContrats.getSalconTexte() != null && !this.salariesContrats.getSalconTexte().isEmpty()) {
               if (this.salariesContrats.getSalconTexte().length() <= 10) {
                  this.afficheTexteContrat = true;
               } else {
                  this.afficheTexteContrat = false;
               }
            } else {
               this.afficheTexteContrat = true;
            }

            if (!this.salariesContrats.getSalconType().contains("01D") && !this.salariesContrats.getSalconType().contains("02D") && !this.salariesContrats.getSalconType().contains("03D")) {
               this.afficheAvenant = false;
            } else {
               this.afficheAvenant = true;
            }

            if (this.salariesContrats.getSalconDocument() != null && !this.salariesContrats.getSalconDocument().isEmpty()) {
               this.var_affFicPdfContrat = true;
            } else {
               this.var_affFicPdfContrat = false;
            }

            int var8 = 0;
            if (this.lesSalariesContrats.size() != 0) {
               for(int var4 = 0; var4 < this.lesSalariesContrats.size(); ++var4) {
                  if (this.salariesContrats.getSalconId() == ((SalariesContrats)this.lesSalariesContrats.get(var4)).getSalconId()) {
                     var8 = var4;
                     break;
                  }
               }
            }

            this.var_ligne_contrat = var8 + 1;
            if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
               if (this.salariesContrats.getSalconLibNivEmploi() == null || this.salariesContrats.getSalconLibNivEmploi().isEmpty()) {
                  this.salariesContrats.setSalconLibNivEmploi("n.d.");
               }

               this.var_niveau = this.salariesContrats.getSalconNivEmploi() + ":" + this.salariesContrats.getSalconLibNivEmploi();
            } else {
               this.var_niveau = "";
            }

            if (this.salariesContrats.getSalconClassement() != null && !this.salariesContrats.getSalconClassement().isEmpty()) {
               if (this.salariesContrats.getSalconLibClassement() == null || this.salariesContrats.getSalconLibClassement().isEmpty()) {
                  this.salariesContrats.setSalconLibClassement("n.d.");
               }

               this.var_classement = this.salariesContrats.getSalconClassement() + ":" + this.salariesContrats.getSalconLibClassement();
            } else {
               this.var_classement = "";
            }

            if (this.salariesContrats.getSalconCentresImpots() != null && !this.salariesContrats.getSalconCentresImpots().isEmpty()) {
               if (this.salariesContrats.getSalconLibCentresImpots() == null || this.salariesContrats.getSalconLibCentresImpots().isEmpty()) {
                  this.salariesContrats.setSalconLibCentresImpots("n.d.");
               }

               this.var_centre = this.salariesContrats.getSalconCentresImpots() + ":" + this.salariesContrats.getSalconLibCentresImpots();
            } else {
               this.var_centre = "";
            }

            if (this.salariesContrats.getSalconCentresSecurite() != null && !this.salariesContrats.getSalconCentresSecurite().isEmpty()) {
               this.var_securite = this.salariesContrats.getSalconCentresSecurite();
            } else {
               this.var_securite = "";
            }

            if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty()) {
               if (this.salariesContrats.getSalconLibConvention() == null || this.salariesContrats.getSalconLibConvention().isEmpty()) {
                  this.salariesContrats.setSalconLibConvention("n.d.");
               }

               this.var_convention = this.salariesContrats.getSalconConvention() + ":" + this.salariesContrats.getSalconLibConvention();
            } else {
               this.var_convention = "";
            }

            this.chargerGrille();
            if (this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
               if (this.salariesContrats.getSalconLibGrille() == null || this.salariesContrats.getSalconLibGrille().isEmpty()) {
                  this.salariesContrats.setSalconLibGrille("n.d.");
               }

               this.var_grille = this.salariesContrats.getSalconGrille() + ":" + this.salariesContrats.getSalconLibGrille();
            } else {
               this.var_grille = "";
            }

            if (this.salariesContrats.getSalconService() != null && !this.salariesContrats.getSalconService().isEmpty()) {
               if (this.salariesContrats.getSalconLibService() == null || this.salariesContrats.getSalconLibService().isEmpty()) {
                  this.salariesContrats.setSalconLibService("n.d.");
               }

               this.var_service = this.salariesContrats.getSalconService() + ":" + this.salariesContrats.getSalconLibService();
            } else {
               this.var_service = "";
            }

            Site var9 = new Site();
            if (this.salariesContrats.getSalconSite() != null && !this.salariesContrats.getSalconSite().isEmpty()) {
               SiteDao var5 = new SiteDao(this.baseLog, this.utilInitHibernate);
               var9 = var5.rechercheSite(this.salariesContrats.getSalconSite(), (Session)null);
               if (var9 != null) {
                  this.var_site = this.salariesContrats.getSalconSite() + ":" + var9.getSitNomFr();
               } else {
                  this.var_site = this.salariesContrats.getSalconSite() + ":" + "";
               }
            } else {
               this.var_site = "";
            }

            if (this.salariesContrats.getSalconDepartement() != null && !this.salariesContrats.getSalconDepartement().isEmpty()) {
               DepartementDao var10 = new DepartementDao(this.baseLog, this.utilInitHibernate);
               this.mesDepartementsImputationItems = var10.listDepartementBySite(var9, (Session)null);
               if (this.mesDepartementsImputationItems.size() != 0) {
                  for(int var6 = 0; var6 < this.mesDepartementsImputationItems.size(); ++var6) {
                     String[] var7 = ((SelectItem)this.mesDepartementsImputationItems.get(var6)).getValue().toString().split(":");
                     if (var7[0].equals(this.salariesContrats.getSalconDepartement())) {
                        this.var_departement = ((SelectItem)this.mesDepartementsImputationItems.get(var6)).getValue().toString();
                        break;
                     }
                  }
               } else {
                  this.var_departement = this.salariesContrats.getSalconDepartement() + ":" + "";
               }
            } else {
               this.var_departement = "";
            }

            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
               this.var_activite = this.salariesContrats.getSalconActivite();
            } else if (this.salariesContrats.getSalconActivite() != null && !this.salariesContrats.getSalconActivite().isEmpty()) {
               this.var_activite = this.salariesContrats.getSalconActivite() + ":" + this.salariesContrats.getSalconLibActivite().toUpperCase();
            } else {
               this.var_activite = "";
            }

            if (this.salariesContrats.getSalconLocalisation() != null && !this.salariesContrats.getSalconLocalisation().isEmpty()) {
               this.var_localisation = this.salariesContrats.getSalconLocalisation();
            } else {
               this.var_localisation = "";
            }

            if (this.salariesContrats.getSalconProjet() != null && !this.salariesContrats.getSalconProjet().isEmpty()) {
               if (this.salariesContrats.getSalconLibProjet() == null || this.salariesContrats.getSalconLibProjet().isEmpty()) {
                  this.salariesContrats.setSalconLibProjet("n.d.");
               }

               this.var_projet = this.salariesContrats.getSalconProjet() + ":" + this.salariesContrats.getSalconLibProjet();
            } else {
               this.var_projet = "";
            }

            if (this.salariesContrats.getSalconBudget() != null && !this.salariesContrats.getSalconBudget().isEmpty()) {
               if (this.salariesContrats.getSalconLibBudget() == null || this.salariesContrats.getSalconLibBudget().isEmpty()) {
                  this.salariesContrats.setSalconLibBudget("n.d.");
               }

               this.var_budget = this.salariesContrats.getSalconBudget() + ":" + this.salariesContrats.getSalconLibBudget();
            } else {
               this.var_budget = "";
            }

            if (this.salariesContrats.getSalconCle1Anal() != null && !this.salariesContrats.getSalconCle1Anal().isEmpty()) {
               if (this.salariesContrats.getSalconLibCle1Anal() == null || this.salariesContrats.getSalconLibCle1Anal().isEmpty()) {
                  this.salariesContrats.setSalconLibCle1Anal("n.d.");
               }

               this.var_cle1 = this.salariesContrats.getSalconCle1Anal() + ":" + this.salariesContrats.getSalconLibCle1Anal();
            } else {
               this.var_cle1 = "";
            }

            if (this.salariesContrats.getSalconCle2Anal() != null && !this.salariesContrats.getSalconCle2Anal().isEmpty()) {
               if (this.salariesContrats.getSalconLibCle2Anal() == null || this.salariesContrats.getSalconLibCle2Anal().isEmpty()) {
                  this.salariesContrats.setSalconLibCle2Anal("n.d.");
               }

               this.var_cle2 = this.salariesContrats.getSalconCle2Anal() + ":" + this.salariesContrats.getSalconLibCle2Anal();
            } else {
               this.var_cle2 = "";
            }

            Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            this.calculeRubriqueContrat(var11);
            this.calculeFeuilleContrat(var11);
            this.chargerScanAvenant();
            if (this.accesInterim) {
               this.calculServiceInterim(var11);
            }

            this.dataModelSimulationLigne.setWrappedData(this.formBakingBeanPaye.chargerSimulation(this.bulletinSalaireDao, this.salaries, var11));
            this.utilInitHibernate.closeSession();
            if (this.salaries.getSalProtege() == 1) {
               if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 3) {
                  this.var_affiche_contrat = false;
               } else {
                  this.var_affiche_contrat = true;
               }
            } else {
               this.var_affiche_contrat = true;
            }
         } else {
            this.var_affiche_contrat = false;
         }
      } else {
         this.var_affiche_contrat = false;
      }

   }

   public void visualisationContrat() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesContrats != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_contrat = false;
            } else {
               this.var_affiche_contrat = true;
            }
         } else {
            this.var_affiche_contrat = true;
         }

         if (this.salariesContrats.getSalconDocument() != null && !this.salariesContrats.getSalconDocument().isEmpty()) {
            this.var_affFicPdfContrat = true;
         } else {
            this.var_affFicPdfContrat = false;
         }

         if (this.var_affiche_contrat) {
            if (this.salariesContrats.getSalconEtatH() == 0) {
               this.modifierElementContrat();
            } else {
               this.consulterElementContrat();
            }
         }
      }

   }

   public void visualisationFicheContrat() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconEtatH() == 0) {
            this.modifierContrat();
         } else {
            this.consulterContrat();
         }
      }

   }

   public void ajouterContrat() throws HibernateException, NamingException {
      this.mesGrillesItems.clear();
      this.lesGrilles.clear();
      this.var_niveau = "";
      this.var_classement = "";
      this.var_centre = "";
      this.var_convention = "";
      this.var_grille = "";
      this.var_service = "";
      this.var_activite = "";
      this.var_localisation = "";
      this.var_projet = "";
      this.var_budget = "";
      this.var_cle1 = "";
      this.var_cle2 = "";
      this.var_affFicPdfContrat = false;
      this.contratValide = false;
      this.lesAvenants.clear();
      this.dataModelAvenants.setWrappedData(this.lesAvenants);
      this.salariesContrats = new SalariesContrats();
      this.salariesContrats.setSalconType(this.salaries.getSalNature());
      this.var_tiers = 0L;
      this.chargerGrille();
      this.recupererModelesItem();
      this.var_action_contrat = 1;
      this.afficheTexteContrat = true;
      if (this.decoupageActivite) {
         this.lesDecoupagesActivites.clear();
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

      this.showModalPanelContrat = true;
   }

   public void modifierContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_contrat = false;
            } else {
               this.var_affiche_contrat = true;
            }
         } else {
            this.var_affiche_contrat = true;
         }

         this.contratValide = true;
         if (this.var_affiche_contrat) {
            this.chargerGrille();
            this.recupererModelesItem();
            this.var_action_contrat = 2;
            this.showModalPanelContrat = true;
         }
      }

   }

   public void consulterContrat() {
      if (this.salariesContrats != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_contrat = false;
            } else {
               this.var_affiche_contrat = true;
            }
         } else {
            this.var_affiche_contrat = true;
         }

         this.contratValide = false;
         if (this.var_affiche_contrat) {
            this.chargerGrille();
            this.var_action_contrat = 3;
            this.showModalPanelContrat = true;
         }
      }

   }

   public void supprimerContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.lesSalariesContrats.size() == this.var_ligne_contrat) {
               this.salaries.setSalCentresImpots("");
               this.salaries.setSalLibCentresImpots("");
               this.salaries.setSalClassement("");
               this.salaries.setSalLibClassement("");
               this.salaries.setSalConvention("");
               this.salaries.setSalLibConvention("");
               this.salaries.setSalFeuille("");
               this.salaries.setSalFonction("");
               this.salaries.setSalGrille("");
               this.salaries.setSalLibGrille("");
               this.salaries.setSalNivEmploi("");
               this.salaries.setSalLibNivEmploi("");
               this.salaries.setSalSite("");
               this.salaries.setSalDepartement("");
               this.salaries.setSalService("");
               this.salaries.setSalActivite("");
               this.salaries.setSalParc("");
               this.salaries.setSalBudget("");
               this.salaries.setSalFonction("");
               this.salaries.setSalDateEntree((Date)null);
               this.salaries.setSalDateSortie((Date)null);
               this.salaries.setSalEtat(0);
               this.salaries.setSalMotifSortie("");
               this.salaries = this.salariesDao.modif(this.salaries, var1);
            }

            Habilitation var3 = this.verifHabilitation(82, var1);
            if (var3 != null) {
               new Parapheur();
               ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               Parapheur var4 = var5.existenceParapheur(this.salariesContrats.getSalconId(), 82, var1);
               if (var4 != null) {
                  var5.delete(var4, var1);
               }
            }

            this.lesSalariesContrats.remove(this.salariesContrats);
            this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
            this.salariesContratsDao.delete(this.salariesContrats, var1);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void duppliquerContrat() throws HibernateException, NamingException, ParseException {
      if (this.salariesContrats != null && this.salariesContrats.getSalconEtat() == 6) {
         UtilDate var1 = new UtilDate();
         SalariesContrats var2 = new SalariesContrats();
         var2.setSalaries(this.salaries);
         var2.setSalconActivite(this.salariesContrats.getSalconActivite());
         var2.setSalconAvnDomesticite(this.salariesContrats.getSalconAvnDomesticite());
         var2.setSalconAvnEau(this.salariesContrats.getSalconAvnEau());
         var2.setSalconAvnElectricite(this.salariesContrats.getSalconAvnElectricite());
         var2.setSalconAvnLogement(this.salariesContrats.getSalconAvnLogement());
         var2.setSalconAvnNourriture(this.salariesContrats.getSalconAvnNourriture());
         var2.setSalconAvnTelephone(this.salariesContrats.getSalconAvnTelephone());
         var2.setSalconAvnVehicule(this.salariesContrats.getSalconAvnVehicule());
         var2.setSalconBase(this.salariesContrats.getSalconBase());
         var2.setSalconBudget(this.salariesContrats.getSalconBudget());
         var2.setSalconCentresImpots(this.salariesContrats.getSalconCentresImpots());
         var2.setSalconClassement(this.salariesContrats.getSalconClassement());
         var2.setSalconCle1Anal(this.salariesContrats.getSalconCle1Anal());
         var2.setSalconCle2Anal(this.salariesContrats.getSalconCle2Anal());
         var2.setSalconConvention(this.salariesContrats.getSalconConvention());
         var2.setSalconDateConfirmation((Date)null);
         var2.setSalconDateCreat(new Date());
         var2.setSalconDateDebut(var1.dateJourSuivant(this.salariesContrats.getSalconDateFin()));
         var2.setSalconDateFin((Date)null);
         var2.setSalconDateImp((Date)null);
         var2.setSalconDateModif((Date)null);
         var2.setSalconDateRemise((Date)null);
         var2.setSalconDateRetour((Date)null);
         var2.setSalconDateValide((Date)null);
         var2.setSalconDepartement(this.salariesContrats.getSalconDepartement());
         var2.setSalconEssai(0);
         var2.setSalconEtat(0);
         var2.setSalconEtatH(0);
         var2.setSalconEtatVal(0);
         var2.setSalconFeuille(this.salariesContrats.getSalconFeuille());
         var2.setSalconFonction(this.salariesContrats.getSalconFonction());
         var2.setSalconGrille(this.salariesContrats.getSalconGrille());
         var2.setSalconIdRepresetant(this.salariesContrats.getSalconIdRepresetant());
         var2.setSalconIndemniteCaisse(this.salariesContrats.getSalconIndemniteCaisse());
         var2.setSalconIndemniteDeplacement(this.salariesContrats.getSalconIndemniteDeplacement());
         var2.setSalconIndemniteKilometrique(this.salariesContrats.getSalconIndemniteKilometrique());
         var2.setSalconIndemniteLogement(this.salariesContrats.getSalconIndemniteLogement());
         var2.setSalconIndemniteRepresentation(this.salariesContrats.getSalconIndemniteRepresentation());
         var2.setSalconIndemniteSalissure(this.salariesContrats.getSalconIndemniteSalissure());
         var2.setSalconIndemniteTransport(this.salariesContrats.getSalconIndemniteTransport());
         var2.setSalconLibActivite(this.salariesContrats.getSalconLibActivite());
         var2.setSalconLibBudget(this.salariesContrats.getSalconLibBudget());
         var2.setSalconLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
         var2.setSalconLibClassement(this.salariesContrats.getSalconLibClassement());
         var2.setSalconLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
         var2.setSalconLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
         var2.setSalconLibConvention(this.salariesContrats.getSalconLibConvention());
         var2.setSalconLibGrille(this.salariesContrats.getSalconLibGrille());
         var2.setSalconLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
         var2.setSalconLibProjet(this.salariesContrats.getSalconLibProjet());
         var2.setSalconLieuTravail(this.salariesContrats.getSalconLieuTravail());
         var2.setSalconLocalisation(this.salariesContrats.getSalconLocalisation());
         var2.setSalconMotifSortie((String)null);
         var2.setSalconNbJourCp(this.salariesContrats.getSalconNbJourCp());
         var2.setSalconNbJourTr(this.salariesContrats.getSalconNbJourTr());
         var2.setSalconNbMoisEssai(0);
         var2.setSalconNivEmploi(this.salariesContrats.getSalconNivEmploi());
         var2.setSalconNomRepresentant(this.salariesContrats.getSalconNomRepresentant());
         var2.setSalconNum((String)null);
         var2.setSalconParc(this.salariesContrats.getSalconParc());
         var2.setSalconPrimeFonction(this.salariesContrats.getSalconPrimeFonction());
         var2.setSalconPrimeRendement(this.salariesContrats.getSalconPrimeRendement());
         var2.setSalconPrimeResponsabilite(this.salariesContrats.getSalconPrimeResponsabilite());
         var2.setSalconPrimeSujetion(this.salariesContrats.getSalconPrimeSujetion());
         var2.setSalconPrimeExceptionnelle(this.salariesContrats.getSalconPrimeExceptionnelle());
         var2.setSalconProjet(this.salariesContrats.getSalconProjet());
         var2.setSalconQualite(this.salariesContrats.getSalconQualite());
         var2.setSalconRbmKms(this.salariesContrats.getSalconRbmKms());
         var2.setSalconService(this.salariesContrats.getSalconService());
         var2.setSalconSite(this.salariesContrats.getSalconSite());
         var2.setSalconSursalaire(this.salariesContrats.getSalconSursalaire());
         var2.setSalconTexte(this.salariesContrats.getSalconTexte());
         var2.setSalconType(this.salariesContrats.getSalconType());
         var2.setSalconUserCreat(this.usersLog.getUsrid());
         var2.setSalconUserModif(0L);
         var2.setSalconVehicule(this.salariesContrats.getSalconVehicule());
         this.salariesContrats = var2;
         var2 = null;
         this.chargerGrille();
         this.recupererModelesItem();
         this.var_action_contrat = 1;
         this.afficheTexteContrat = true;
         if (this.decoupageActivite) {
            this.lesDecoupagesActivites.clear();
            this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         }

         this.showModalPanelContrat = true;
      }

   }

   public void annulerContrat() {
      this.var_affiche_contrat = false;
      this.showModalPanelContrat = false;
      this.simpleSelectionEnteteCrt.clear();
      this.extDTableCrt = new HtmlExtendedDataTable();
   }

   public void saveContrat() throws HibernateException, NamingException {
      if (this.contratValide) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculeZone(var1);
            Habilitation var3 = this.verifHabilitation(82, var1);
            if (var3 != null) {
               this.salariesContrats.setSalconEtatVal(1);
               this.salariesContrats.setSalconEtatH(0);
               this.salariesContrats.setSalconDateValide((Date)null);
            } else {
               this.salariesContrats.setSalconEtatVal(0);
               if (this.usersChronoContrat != null) {
                  if (this.usersChronoContrat.getUsrchrValidation() == 0) {
                     this.salariesContrats.setSalconEtatH(1);
                     this.salariesContrats.setSalconDateValide(new Date());
                  } else if (this.usersChronoContrat.getUsrchrValidation() != 1 && this.usersChronoContrat.getUsrchrValidation() != 2 && this.usersChronoContrat.getUsrchrValidation() == 3) {
                     this.salariesContrats.setSalconEtatH(0);
                     this.salariesContrats.setSalconDateValide((Date)null);
                  }
               }
            }

            if (this.salariesContrats.getSalconEtat() == 0 && (this.salariesContrats.getSalconType().equals("01I") || this.salariesContrats.getSalconType().equals("02I") || this.salariesContrats.getSalconType().equals("03I"))) {
               this.salariesContrats.setSalconDateFin((Date)null);
            }

            boolean var4 = false;
            if (this.salariesContrats.getSalconId() == 0L) {
               var4 = true;
               String var5 = this.calculChrono.numCompose(new Date(), 82, "", var1);
               this.salariesContrats.setSalaries(this.salaries);
               this.salariesContrats.setSalconDateCreat(new Date());
               this.salariesContrats.setSalconUserCreat(this.usersLog.getUsrid());
               this.salariesContrats.setSalconNum(var5);
               this.salariesContrats = this.salariesContratsDao.insert(this.salariesContrats, var1);
               if (var3 != null) {
                  this.majParapheur(82, var3, var1);
               }

               this.lesSalariesContrats.add(this.salariesContrats);
               this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
               this.simpleSelectionEnteteCrt.clear();
               this.extDTableCrt = new HtmlExtendedDataTable();
            } else {
               var4 = false;
               this.salariesContrats.setSalconDateModif(new Date());
               this.salariesContrats.setSalconUserModif(this.usersLog.getUsrid());
               this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var1);
            }

            this.salaries.setSalCentresImpots(this.salariesContrats.getSalconCentresImpots());
            this.salaries.setSalLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
            this.salaries.setSalCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
            this.salaries.setSalLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
            this.salaries.setSalClassement(this.salariesContrats.getSalconClassement());
            this.salaries.setSalLibClassement(this.salariesContrats.getSalconLibClassement());
            this.salaries.setSalConvention(this.salariesContrats.getSalconConvention());
            this.salaries.setSalLibConvention(this.salariesContrats.getSalconLibConvention());
            this.salaries.setSalFeuille(this.salariesContrats.getSalconFeuille());
            this.salaries.setSalFonction(this.salariesContrats.getSalconFonction());
            this.salaries.setSalGrille(this.salariesContrats.getSalconGrille());
            this.salaries.setSalLibGrille(this.salariesContrats.getSalconLibGrille());
            this.salaries.setSalCodeEmploi(this.salariesContrats.getSalconCodeEmploi());
            this.salaries.setSalNivEmploi(this.salariesContrats.getSalconNivEmploi());
            this.salaries.setSalLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
            this.salaries.setSalSite(this.salariesContrats.getSalconSite());
            this.salaries.setSalDepartement(this.salariesContrats.getSalconDepartement());
            this.salaries.setSalService(this.salariesContrats.getSalconService());
            this.salaries.setSalLibService(this.salariesContrats.getSalconLibService());
            this.salaries.setSalActivite(this.salariesContrats.getSalconActivite());
            this.salaries.setSalLocalisation(this.salariesContrats.getSalconLocalisation());
            this.salaries.setSalParc(this.salariesContrats.getSalconParc());
            this.salaries.setSalBudget(this.salariesContrats.getSalconBudget());
            this.salaries.setSalFonction(this.salariesContrats.getSalconFonction());
            this.salaries.setSalDateEntree(this.salariesContrats.getSalconDateDebut());
            if (var4) {
               this.salaries.setSalDateImpot(this.salariesContrats.getSalconDateDebut());
            }

            this.salaries.setSalDateSortie(this.salariesContrats.getSalconDateFin());
            this.salaries.setSalEtat(this.salariesContrats.getSalconEtat());
            this.salaries.setSalMotifSortie(this.salariesContrats.getSalconMotifSortie());
            this.salaries.setSalNbJourCp(this.salariesContrats.getSalconNbJourCp());
            this.salaries.setSalNbJourTr(this.salariesContrats.getSalconNbJourTr());
            this.salaries.setSalCleAnal1(this.salariesContrats.getSalconCle1Anal());
            this.salaries.setSalCleAnal2(this.salariesContrats.getSalconCle2Anal());
            this.salaries.setSalLibCleAnal1(this.salariesContrats.getSalconLibCle1Anal());
            this.salaries.setSalLibCleAnal2(this.salariesContrats.getSalconLibCle2Anal());
            this.salaries.setSalIdTiers(this.salariesContrats.getSalconIdTiers());
            this.salaries.setSalNomTiers(this.salariesContrats.getSalconNomTiers());
            this.salaries = this.salariesDao.modif(this.salaries, var1);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelContrat = false;
      this.formRecherche.setShowModalPanelMessage(false);
   }

   public void valideContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salariesContrats.setSalconEtatH(1);
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         UtilDate var2 = new UtilDate();
         var1.setEspaction("Validation manuelle contrat (P.) N° " + this.salariesContrats.getSalconNum() + " du " + var2.dateToStringSQLLight(this.salariesContrats.getSalconDateDebut()));
         this.espionDao.mAJEspion(var1);
      }

   }

   public void deValideContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salariesContrats.setSalconEtatH(0);
         this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         UtilDate var2 = new UtilDate();
         var1.setEspaction("Dévalidation manuelle contrat (P.) N° " + this.salariesContrats.getSalconNum() + " du " + var2.dateToStringSQLLight(this.salariesContrats.getSalconDateDebut()));
         this.espionDao.mAJEspion(var1);
      }

   }

   public void calculeZone(Session var1) throws HibernateException, NamingException {
      String[] var2;
      if (this.var_niveau != null && this.var_niveau.contains(":")) {
         var2 = this.var_niveau.split(":");
         this.salariesContrats.setSalconNivEmploi(var2[0]);
         this.salariesContrats.setSalconLibNivEmploi(var2[1]);
      } else {
         this.salariesContrats.setSalconNivEmploi("");
         this.salariesContrats.setSalconLibNivEmploi("");
      }

      if (this.var_classement != null && this.var_classement.contains(":")) {
         var2 = this.var_classement.split(":");
         this.salariesContrats.setSalconClassement(var2[0]);
         this.salariesContrats.setSalconLibClassement(var2[1]);
      } else {
         this.salariesContrats.setSalconClassement("");
         this.salariesContrats.setSalconLibClassement("");
      }

      if (this.var_centre != null && this.var_centre.contains(":")) {
         var2 = this.var_centre.split(":");
         this.salariesContrats.setSalconCentresImpots(var2[0]);
         this.salariesContrats.setSalconLibCentresImpots(var2[1]);
      } else {
         this.salariesContrats.setSalconCentresImpots("");
         this.salariesContrats.setSalconLibCentresImpots("");
      }

      if (this.var_securite != null && !this.var_securite.isEmpty()) {
         this.salariesContrats.setSalconCentresSecurite(this.var_securite);
         if (this.mesCentresSecuritesItems.size() != 0) {
            for(int var5 = 0; var5 < this.mesCentresSecuritesItems.size(); ++var5) {
               if (((SelectItem)this.mesCentresSecuritesItems.get(var5)).getValue().toString().equals(this.var_securite)) {
                  String[] var3 = ((SelectItem)this.mesCentresSecuritesItems.get(var5)).getLabel().toString().split(":");
                  this.salariesContrats.setSalconLibCentresSecurite(var3[0]);
                  break;
               }
            }
         }
      } else {
         this.salariesContrats.setSalconCentresSecurite("");
         this.salariesContrats.setSalconLibCentresSecurite("");
      }

      if (this.var_convention != null && this.var_convention.contains(":")) {
         var2 = this.var_convention.split(":");
         this.salariesContrats.setSalconConvention(var2[0]);
         this.salariesContrats.setSalconLibConvention(var2[1]);
      } else {
         this.salariesContrats.setSalconConvention("");
         this.salariesContrats.setSalconLibConvention("");
      }

      if (this.var_grille != null && this.var_grille.contains(":")) {
         var2 = this.var_grille.split(":");
         this.salariesContrats.setSalconGrille(var2[0]);
         this.salariesContrats.setSalconLibGrille(var2[1]);
      } else {
         this.salariesContrats.setSalconGrille("");
         this.salariesContrats.setSalconLibGrille("");
      }

      if (this.var_service != null && this.var_service.contains(":")) {
         var2 = this.var_service.split(":");
         new Service();
         ServiceDao var4 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         Service var6 = var4.chargerLeServiceCode(var2[0], var1);
         if (var6 != null) {
            this.salariesContrats.setSalconService(var6.getSerCode());
            this.salariesContrats.setSalconLibService(var6.getSerNomFr());
            this.salariesContrats.setSalconDepartement(var6.getDepartement().getDepCode());
            this.salariesContrats.setSalconSite(var6.getSite().getSitCode());
         } else {
            this.salariesContrats.setSalconService("");
            this.salariesContrats.setSalconLibService("");
            this.salariesContrats.setSalconDepartement("");
            this.salariesContrats.setSalconSite("");
         }
      } else {
         this.salariesContrats.setSalconService("");
         this.salariesContrats.setSalconLibService("");
         this.salariesContrats.setSalconDepartement("");
         this.salariesContrats.setSalconSite("");
      }

      if (this.decoupageActivite) {
         String var10 = "";
         boolean var7 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var8 = 0; var8 < this.lesDecoupagesActivites.size(); ++var8) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var8);
               if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                  if (var7) {
                     var10 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     var7 = false;
                  } else {
                     var10 = var10 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                  }
               }
            }
         }

         this.salariesContrats.setSalconActivite(var10);
         this.salariesContrats.setSalconLibActivite("DécoupageActivité");
      } else if (this.var_activite != null && this.var_activite.contains(":")) {
         var2 = this.var_activite.split(":");
         this.salariesContrats.setSalconActivite(var2[0]);
         this.salariesContrats.setSalconLibActivite(var2[1]);
      } else {
         this.salariesContrats.setSalconActivite("");
         this.salariesContrats.setSalconLibActivite("");
      }

      if (this.var_localisation != null && !this.var_localisation.isEmpty()) {
         this.salariesContrats.setSalconLocalisation(this.var_localisation);
      } else {
         this.salariesContrats.setSalconLocalisation("");
      }

      if (this.var_projet != null && this.var_projet.contains(":")) {
         var2 = this.var_projet.split(":");
         this.salariesContrats.setSalconProjet(var2[0]);
         this.salariesContrats.setSalconLibProjet(var2[1]);
         new Projets();
         ProjetsDao var11 = new ProjetsDao(this.baseLog, this.utilInitHibernate);
         Projets var9 = var11.chargerLeProjet(0, this.salariesContrats.getSalconProjet(), var1);
         if (var9 != null) {
            if (this.salariesContrats.getSalconDateDebut() == null) {
               this.salariesContrats.setSalconDateDebut(var9.getProDateDebut());
            }

            if (this.salariesContrats.getSalconDateFin() == null) {
               this.salariesContrats.setSalconDateFin(var9.getProDateFin());
            }
         }
      } else {
         this.salariesContrats.setSalconProjet("");
         this.salariesContrats.setSalconLibProjet("");
      }

      if (this.var_budget != null && this.var_budget.contains(":")) {
         var2 = this.var_budget.split(":");
         this.salariesContrats.setSalconBudget(var2[0]);
         this.salariesContrats.setSalconLibBudget(var2[1]);
      } else {
         this.salariesContrats.setSalconBudget("");
         this.salariesContrats.setSalconLibBudget("");
      }

      if (this.var_cle1 != null && this.var_cle1.contains(":")) {
         var2 = this.var_cle1.split(":");
         this.salariesContrats.setSalconCle1Anal(var2[0]);
         this.salariesContrats.setSalconLibCle1Anal(var2[1]);
      } else {
         this.salariesContrats.setSalconCle1Anal("");
         this.salariesContrats.setSalconLibCle1Anal("");
      }

      if (this.var_cle2 != null && this.var_cle2.contains(":")) {
         var2 = this.var_cle2.split(":");
         this.salariesContrats.setSalconCle2Anal(var2[0]);
         this.salariesContrats.setSalconLibCle2Anal(var2[1]);
      } else {
         this.salariesContrats.setSalconCle2Anal("");
         this.salariesContrats.setSalconLibCle2Anal("");
      }

   }

   public void calculeZoneJRX() throws HibernateException, NamingException {
      this.var_classement = "40:PERSONNELS TEMPORAIRES";
      String[] var1;
      if (this.var_classement != null && this.var_classement.contains(":")) {
         var1 = this.var_classement.split(":");
         this.salaries.setSalClassement(var1[0]);
         this.salaries.setSalLibClassement(var1[1]);
      } else {
         this.salaries.setSalClassement("");
         this.salaries.setSalLibClassement("");
      }

      if (this.var_centre != null && this.var_centre.contains(":")) {
         var1 = this.var_centre.split(":");
         this.salaries.setSalCentresImpots(var1[0]);
         this.salaries.setSalLibCentresImpots(var1[1]);
      } else {
         this.salaries.setSalCentresImpots("");
         this.salaries.setSalLibCentresImpots("");
      }

      if (this.var_convention != null && this.var_convention.contains(":")) {
         var1 = this.var_convention.split(":");
         this.salaries.setSalConvention(var1[0]);
         this.salaries.setSalLibConvention(var1[1]);
      } else {
         this.salaries.setSalConvention("");
         this.salaries.setSalLibConvention("");
      }

      if (this.var_grille != null && this.var_grille.contains(":")) {
         var1 = this.var_grille.split(":");
         this.salaries.setSalGrille(var1[0]);
         this.salaries.setSalLibGrille(var1[1]);
      } else {
         this.salaries.setSalGrille("");
         this.salaries.setSalLibGrille("");
      }

      if (this.var_tiers != 0L) {
         this.salaries.setSalIdTiers(this.var_tiers);

         for(int var2 = 0; var2 < this.mesTiersItems.size(); ++var2) {
            if (Long.parseLong(((SelectItem)this.mesTiersItems.get(var2)).getValue().toString()) == this.var_tiers) {
               this.salaries.setSalNomTiers(((SelectItem)this.mesTiersItems.get(var2)).getLabel().toString());
               break;
            }
         }
      } else {
         this.salaries.setSalIdTiers(0L);
         this.salaries.setSalNomTiers("");
      }

   }

   public void saveContratMuter() throws NamingException, ParseException {
      if (this.salariesContratsMuter.getSalconDateDebut() != null && this.salariesContratsMuter.getSalconType() != null && !this.salariesContratsMuter.getSalconType().isEmpty()) {
         UtilDate var1 = new UtilDate();
         long var2 = this.salariesContrats.getSalconId();
         long var4 = this.salariesContrats.getSalaries().getSalId();
         new Salaries();
         Salaries var6 = this.salariesDao.chercherIdSalaries(var4, (Session)null);
         if (var6 != null) {
            new Salaries();
            boolean var8 = false;
            Salaries var7 = var6;
            Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var10 = null;

            try {
               var10 = var9.beginTransaction();
               var6 = this.salariesDao.chercherIdSalaries(var4, var9);
               this.calculeZoneMuter(var9);
               Habilitation var11 = this.verifHabilitation(82, var9);
               if (var11 != null) {
                  this.salariesContratsMuter.setSalconEtatVal(1);
                  this.salariesContratsMuter.setSalconEtatH(0);
                  this.salariesContratsMuter.setSalconDateValide((Date)null);
               } else {
                  this.salariesContratsMuter.setSalconEtatVal(0);
                  if (this.salariesContratsMuter.getSalconDateImp() != null) {
                     if (this.salariesContratsMuter.getSalconEtatH() == 0) {
                        this.salariesContratsMuter.setSalconEtatH(1);
                        this.salariesContratsMuter.setSalconDateValide(new Date());
                     }
                  } else {
                     this.salariesContratsMuter.setSalconEtatH(0);
                     this.salariesContratsMuter.setSalconDateValide((Date)null);
                  }
               }

               if (this.salariesContratsMuter.getSalconEtat() == 0) {
                  this.salariesContratsMuter.setSalconDateFin((Date)null);
               }

               String var12 = this.calculChrono.numCompose(new Date(), 82, "", var9);
               if (var8) {
                  this.salariesContratsMuter.setSalaries(var7);
               } else {
                  this.salariesContratsMuter.setSalaries(var6);
               }

               this.salariesContratsMuter.setSalconDateCreat(new Date());
               this.salariesContratsMuter.setSalconUserCreat(this.usersLog.getUsrid());
               this.salariesContratsMuter.setSalconNum(var12);
               this.salariesContratsMuter = this.salariesContratsDao.insert(this.salariesContratsMuter, var9);
               if (var11 != null) {
                  this.majParapheur(82, var11, var9);
               }

               this.lesSalariesContrats.add(this.salariesContratsMuter);
               this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
               this.salariesContrats = this.salariesContratsDao.pourParapheur(var2, var9);
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconDateFin(var1.dateJourPrecedent(this.salariesContratsMuter.getSalconDateDebut()));
                  this.salariesContrats.setSalconEtat(8);
                  this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var9);
               }

               if (!var8) {
                  var6.setSalCentresImpots(this.salariesContratsMuter.getSalconCentresImpots());
                  var6.setSalLibCentresImpots(this.salariesContratsMuter.getSalconLibCentresImpots());
                  var6.setSalClassement(this.salariesContratsMuter.getSalconClassement());
                  var6.setSalLibClassement(this.salariesContratsMuter.getSalconLibClassement());
                  var6.setSalConvention(this.salariesContratsMuter.getSalconConvention());
                  var6.setSalLibConvention(this.salariesContratsMuter.getSalconLibConvention());
                  var6.setSalFeuille(this.salariesContratsMuter.getSalconFeuille());
                  var6.setSalNature(this.salariesContratsMuter.getSalconType());
                  var6.setSalFonction(this.salariesContratsMuter.getSalconFonction());
                  var6.setSalGrille(this.salariesContratsMuter.getSalconGrille());
                  var6.setSalLibGrille(this.salariesContratsMuter.getSalconLibGrille());
                  var6.setSalNivEmploi(this.salariesContratsMuter.getSalconNivEmploi());
                  var6.setSalLibNivEmploi(this.salariesContratsMuter.getSalconLibNivEmploi());
                  var6.setSalSite(this.salariesContratsMuter.getSalconSite());
                  var6.setSalDepartement(this.salariesContratsMuter.getSalconDepartement());
                  var6.setSalService(this.salariesContratsMuter.getSalconService());
                  var6.setSalActivite(this.salariesContratsMuter.getSalconActivite());
                  var6.setSalParc(this.salariesContratsMuter.getSalconParc());
                  var6.setSalBudget(this.salariesContratsMuter.getSalconBudget());
                  var6.setSalFonction(this.salariesContratsMuter.getSalconFonction());
                  var6.setSalDateEntree(this.salariesContratsMuter.getSalconDateDebut());
                  var6.setSalDateSortie(this.salariesContratsMuter.getSalconDateFin());
                  var6.setSalDateEntreeInitial(this.salariesContratsMuter.getSalconDateEntreeInitial());
                  var6.setSalEtat(this.salariesContratsMuter.getSalconEtat());
                  var6.setSalMotifSortie(this.salariesContratsMuter.getSalconMotifSortie());
                  var6.setSalNbJourCp(this.salariesContratsMuter.getSalconNbJourCp());
                  var6.setSalNbJourTr(this.salariesContratsMuter.getSalconNbJourTr());
                  var6.setSalCleAnal1(this.salariesContratsMuter.getSalconCle1Anal());
                  var6.setSalCleAnal2(this.salariesContratsMuter.getSalconCle2Anal());
                  var6.setSalLibCleAnal1(this.salariesContratsMuter.getSalconLibCle1Anal());
                  var6.setSalLibCleAnal2(this.salariesContratsMuter.getSalconLibCle2Anal());
                  this.salariesDao.modif(var6, var9);
               }

               var10.commit();
            } catch (HibernateException var16) {
               if (var10 != null) {
                  var10.rollback();
               }

               throw var16;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showModalPanelContrat = false;
      this.rechercherSalarieContrat((Session)null);
   }

   public void calculeZoneMuter(Session var1) throws HibernateException, NamingException {
      String[] var2;
      if (this.var_niveauMuter != null && this.var_niveauMuter.contains(":")) {
         var2 = this.var_niveauMuter.split(":");
         this.salariesContratsMuter.setSalconNivEmploi(var2[0]);
         this.salariesContratsMuter.setSalconLibNivEmploi(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconNivEmploi("");
         this.salariesContratsMuter.setSalconLibNivEmploi("");
      }

      if (this.var_classementMuter != null && this.var_classementMuter.contains(":")) {
         var2 = this.var_classementMuter.split(":");
         this.salariesContratsMuter.setSalconClassement(var2[0]);
         this.salariesContratsMuter.setSalconLibClassement(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconClassement("");
         this.salariesContratsMuter.setSalconLibClassement("");
      }

      if (this.var_centreMuter != null && this.var_centreMuter.contains(":")) {
         var2 = this.var_centreMuter.split(":");
         this.salariesContratsMuter.setSalconCentresImpots(var2[0]);
         this.salariesContratsMuter.setSalconLibCentresImpots(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconCentresImpots("");
         this.salariesContratsMuter.setSalconLibCentresImpots("");
      }

      if (this.var_conventionMuter != null && this.var_conventionMuter.contains(":")) {
         var2 = this.var_conventionMuter.split(":");
         this.salariesContratsMuter.setSalconConvention(var2[0]);
         this.salariesContratsMuter.setSalconLibConvention(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconConvention("");
         this.salariesContratsMuter.setSalconLibConvention("");
      }

      if (this.var_grilleMuter != null && this.var_grilleMuter.contains(":")) {
         var2 = this.var_grilleMuter.split(":");
         this.salariesContratsMuter.setSalconGrille(var2[0]);
         this.salariesContratsMuter.setSalconLibGrille(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconGrille("");
         this.salariesContratsMuter.setSalconLibGrille("");
      }

      if (this.decoupageActivite) {
         String var5 = "";
         boolean var3 = true;
         if (this.lesDecoupagesActivitesMuter.size() != 0) {
            for(int var4 = 0; var4 < this.lesDecoupagesActivitesMuter.size(); ++var4) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivitesMuter.get(var4);
               if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                  if (var3) {
                     var5 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     var3 = false;
                  } else {
                     var5 = var5 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                  }
               }
            }
         }

         this.salariesContratsMuter.setSalconActivite(var5);
         this.salariesContratsMuter.setSalconLibActivite("DécoupageActivité");
      } else if (this.var_activiteMuter != null && this.var_activiteMuter.contains(":")) {
         var2 = this.var_activiteMuter.split(":");
         this.salariesContratsMuter.setSalconActivite(var2[0]);
         this.salariesContratsMuter.setSalconLibActivite(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconActivite("");
         this.salariesContratsMuter.setSalconLibActivite("");
      }

      if (this.var_projetMuter != null && this.var_projetMuter.contains(":")) {
         var2 = this.var_projetMuter.split(":");
         this.salariesContratsMuter.setSalconProjet(var2[0]);
         this.salariesContratsMuter.setSalconLibProjet(var2[1]);
         new Projets();
         ProjetsDao var7 = new ProjetsDao(this.baseLog, this.utilInitHibernate);
         Projets var6 = var7.chargerLeProjet(0, this.salariesContratsMuter.getSalconProjet(), var1);
         if (var6 != null) {
            this.salariesContratsMuter.setSalconDateDebut(var6.getProDateDebut());
            this.salariesContratsMuter.setSalconDateFin(var6.getProDateFin());
         }
      } else {
         this.salariesContratsMuter.setSalconProjet("");
         this.salariesContratsMuter.setSalconLibProjet("");
      }

      if (this.var_localisationMuter != null) {
         this.salariesContratsMuter.setSalconService(this.var_localisationMuter);
      } else {
         this.salariesContratsMuter.setSalconLocalisation("");
      }

      if (this.var_budgetMuter != null && this.var_budgetMuter.contains(":")) {
         var2 = this.var_budgetMuter.split(":");
         this.salariesContratsMuter.setSalconBudget(var2[0]);
         this.salariesContratsMuter.setSalconLibBudget(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconBudget("");
         this.salariesContratsMuter.setSalconLibBudget("");
      }

      if (this.var_cle1Muter != null && this.var_cle1Muter.contains(":")) {
         var2 = this.var_cle1Muter.split(":");
         this.salariesContratsMuter.setSalconCle1Anal(var2[0]);
         this.salariesContratsMuter.setSalconLibCle1Anal(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconCle1Anal("");
         this.salariesContratsMuter.setSalconLibCle1Anal("");
      }

      if (this.var_cle2Muter != null && this.var_cle2Muter.contains(":")) {
         var2 = this.var_cle2Muter.split(":");
         this.salariesContratsMuter.setSalconCle2Anal(var2[0]);
         this.salariesContratsMuter.setSalconLibCle2Anal(var2[1]);
      } else {
         this.salariesContratsMuter.setSalconCle2Anal("");
         this.salariesContratsMuter.setSalconLibCle2Anal("");
      }

   }

   public void chargerGrille() {
      this.mesGrillesItems.clear();
      this.lesGrilles.clear();
      if (this.var_convention != null && !this.var_convention.isEmpty() && !this.var_convention.equals("0") && this.var_convention.contains(":")) {
         String[] var1 = this.var_convention.split(":");
         LectureGrilleSalaire var2 = new LectureGrilleSalaire();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         var2.recuperePaye(var1[0]);
         this.mesGrillesItems = var2.getMesGrillesSalairesItems();
         if (this.mesGrillesItems == null) {
            this.mesGrillesItems = new ArrayList();
         }

         this.lesGrilles = var2.getMesGrillesSalaires();
         if (this.lesGrilles == null) {
            this.lesGrilles = new ArrayList();
         }
      } else {
         this.mesGrillesItems = new ArrayList();
         this.lesGrilles = new ArrayList();
      }

   }

   public void chargerGrilleMuter() {
      this.mesGrillesItems.clear();
      this.lesGrilles.clear();
      if (this.var_conventionMuter != null && !this.var_conventionMuter.isEmpty() && !this.var_conventionMuter.equals("0") && this.var_conventionMuter.contains(":")) {
         String[] var1 = this.var_conventionMuter.split(":");
         LectureGrilleSalaire var2 = new LectureGrilleSalaire();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         var2.recuperePaye(var1[0]);
         this.mesGrillesItems = var2.getMesGrillesSalairesItems();
         this.lesGrilles = var2.getMesGrillesSalaires();
      }

   }

   public void calculGrille() {
      double var1 = 0.0D;
      if (this.lesGrilles.size() != 0 && this.var_grille != null && !this.var_grille.isEmpty() && this.var_grille.contains(":")) {
         String[] var3 = this.var_grille.split(":");
         String var4 = var3[0];
         int var5;
         if (!this.salariesContrats.getSalconType().equals("03D") && !this.salariesContrats.getSalconType().equals("03I")) {
            if (!this.salariesContrats.getSalconType().equals("13") && !this.salariesContrats.getSalconType().equals("14")) {
               if (this.salariesContrats.getSalconType().equals("04")) {
                  var1 = 0.0D;
               } else {
                  for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                        var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois();
                        break;
                     }
                  }
               }
            } else {
               var1 = 0.0D;
            }
         } else {
            for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
               if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                  var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_heure();
                  break;
               }
            }
         }
      } else {
         var1 = 0.0D;
      }

      this.salariesContrats.setSalconBase(var1);
   }

   public void calculGrilleMuter() {
      double var1 = 0.0D;
      if (this.lesGrilles.size() != 0 && this.var_grilleMuter != null && !this.var_grilleMuter.isEmpty() && this.var_grilleMuter.contains(":")) {
         String[] var3 = this.var_grilleMuter.split(":");
         String var4 = var3[0];
         int var5;
         if (!this.salariesContratsMuter.getSalconType().equals("03D") && !this.salariesContratsMuter.getSalconType().equals("03I")) {
            if (!this.salariesContratsMuter.getSalconType().equals("13") && !this.salariesContratsMuter.getSalconType().equals("14")) {
               if (this.salariesContratsMuter.getSalconType().equals("04")) {
                  for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                        var1 = (double)(((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois() / 30.0F);
                        break;
                     }
                  }
               } else {
                  for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                        var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois();
                        break;
                     }
                  }
               }
            } else {
               var1 = 0.0D;
            }
         } else {
            for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
               if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                  var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_heure();
                  break;
               }
            }
         }
      } else {
         var1 = 0.0D;
      }

      this.salariesContratsMuter.setSalconBase(var1);
   }

   public void historiqueContrats(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.lesSalariesContrats.clear();
            this.lesSalariesContrats = this.salariesContratsDao.chargerlesContrats(this.salaries, var3);
            this.dataModelContrat.setWrappedData(this.lesSalariesContrats);
         }
      }

   }

   public void submitPDFContrat() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.salariesContrats != null && this.uploadedPDFFile != null) {
         if (this.salariesContrats.getSalconId() == 0L) {
            this.salariesContrats.setSalaries(this.salaries);
            this.salariesContrats = this.salariesContratsDao.insert(this.salariesContrats);
         }

         String var1 = this.salaries.getSalMatricule().replace("/", "_") + "_82_" + this.salariesContrats.getSalconId() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         FacesContext var3 = FacesContext.getCurrentInstance();

         try {
            File var4 = this.utilDownload.uniqueFile(new File(this.nomrepertRHcontrat), var1);
            this.utilDownload.write(var4, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var1;
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.salariesContrats.setSalconDocument(var1);
            if (this.salariesContrats.getSalconId() != 0L) {
               this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
            }

            this.var_affFicPdfContrat = true;
         } catch (IOException var5) {
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
            this.var_affFicPdfContrat = false;
         }
      }

   }

   public void reInitPDFContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salariesContrats.setSalconDocument((String)null);
         if (this.salariesContrats.getSalconId() != 0L) {
            this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats);
         }

         String var1 = new File(this.nomrepertRHcontrat) + File.separator + this.salaries.getSalMatricule().replace("/", "_") + "_82_" + this.salariesContrats.getSalconId() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.var_affFicPdfContrat = false;
      }

   }

   public void voirPdfContrat() throws MalformedURLException, IOException, HibernateException, NamingException {
      if (this.salariesContrats == null) {
         this.selectionContrat();
      }

      if (this.salariesContrats.getSalconDocument() != null && !this.salariesContrats.getSalconDocument().isEmpty()) {
         String var1 = this.nomrepertRHcontrat + this.salaries.getSalMatricule().replace("/", "_") + "_82_" + this.salariesContrats.getSalconId() + ".pdf";
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.salariesContrats.getSalconDocument());
         this.showModalPanelPdf = true;
      }

   }

   public void downloadPdfContrat() throws FileNotFoundException, IOException {
      if (this.salariesContrats != null) {
         BufferedInputStream var1 = null;
         BufferedOutputStream var2 = null;
         FacesContext var3 = FacesContext.getCurrentInstance();
         HttpServletResponse var4 = (HttpServletResponse)var3.getExternalContext().getResponse();
         String var5 = new File(this.nomrepertRHcontrat) + File.separator + this.salaries.getSalMatricule().replace("/", "_") + "_82_" + this.salariesContrats.getSalconId() + ".pdf";
         File var6 = new File(var5);
         if (var6.exists()) {
            try {
               var1 = new BufferedInputStream(new FileInputStream(var6), 10240);
               var4.reset();
               var4.setContentType("application/pdf");
               var4.addHeader("Content-disposition", "attachment; filename=" + var6.getName());
               var4.setContentLength((int)var6.length());
               var2 = new BufferedOutputStream(var4.getOutputStream(), 10240);
               byte[] var7 = new byte[10240];

               while(true) {
                  int var8;
                  if ((var8 = var1.read(var7)) <= 0) {
                     var2.flush();
                     break;
                  }

                  var2.write(var7, 0, var8);
               }
            } finally {
               close(var2);
               close(var1);
            }

            var3.responseComplete();
         }
      }

   }

   public void fermerVisuPdfContrat() {
      this.showModalPanelPdf = false;
   }

   public void ajouterAvenantScan() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomAvenant = "";
      this.listeAvenantImpression();
      int var1 = this.listeAvenantItems.size();
      int var2 = this.lesAvenants.size();
      int var3 = 0;
      if (var2 == 0) {
         var3 = 1;
      } else {
         for(int var4 = 0; var4 < this.listeAvenantItems.size(); ++var4) {
            for(int var5 = 0; var5 < this.lesAvenants.size(); ++var5) {
               if (((String)this.lesAvenants.get(var5)).contains("_" + (var4 + 1) + ".")) {
                  var3 = var4 + 2;
                  break;
               }
            }
         }
      }

      this.nomAvenant = "" + var3;
      if (var2 < var1) {
         this.showModalPanelAjoutAvenant = true;
      }

   }

   public void annulerAvenantScan() {
      this.showModalPanelAjoutAvenant = false;
   }

   public void validerAvenantScan() {
      if (this.salariesContrats != null && this.uploadedPDFFile != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.utilDownload == null) {
               this.utilDownload = new UtilDownload();
            }

            String var2 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var3 = var2.substring(var2.indexOf(".") + 1);
            if (this.nomAvenant == null || this.nomAvenant.isEmpty()) {
               this.nomAvenant = "" + (this.lesAvenants.size() + 1);
            }

            var2 = this.salaries.getSalMatricule().replace("/", "_") + "_" + this.salariesContrats.getSalconId() + "_" + this.filtreCaracteres(this.nomAvenant) + "." + var3;
            File var4 = new File(this.nomRepertoireAvenant + var2);
            if (var4.exists()) {
               var4.delete();
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoireAvenant), var2);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var2;
            this.lesAvenants.add(this.pdfFileName);
            this.dataModelAvenants.setWrappedData(this.lesAvenants);
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutAvenant = false;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         } else if (var3.equals(" ")) {
            var2 = var2 + "_";
         }
      }

      return var2;
   }

   public void lectureAvenant() throws MalformedURLException, IOException {
      if (this.dataModelAvenants.isRowAvailable()) {
         String var1 = (String)this.dataModelAvenants.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomAvenant = var1;
            String var2 = this.nomRepertoireAvenant + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterAvenantScan(var2);
            }
         }
      }

   }

   public void consulterAvenantScan(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPjAvenant = true;
      }

   }

   public void fermerVisuAvenantScan() {
      this.showModalPanelPjAvenant = false;
   }

   public void supprimerAvenantScan() {
      if (this.nomAvenant != null && !this.nomAvenant.isEmpty() && this.nomRepertoireAvenant != null && !this.nomRepertoireAvenant.isEmpty()) {
         String var1 = this.nomRepertoireAvenant + this.nomAvenant;
         File var2 = new File(var1);
         var2.delete();
         this.lesAvenants.remove(this.nomAvenant);
         this.dataModelAvenants.setWrappedData(this.lesAvenants);
         this.showModalPanelPjAvenant = false;
      }

   }

   public void chargerModeleSpe() throws HibernateException, NamingException {
      this.mesModelesItems.clear();
      this.mesTypeRhItems.clear();
      int var1;
      if (this.salariesGrh.getSalgrhNature() == 0) {
         for(var1 = 0; var1 < this.lesNAt.size(); ++var1) {
            if (((ObjetCompte)this.lesNAt.get(var1)).isValide() && (((ObjetCompte)this.lesNAt.get(var1)).getLot() == null || ((ObjetCompte)this.lesNAt.get(var1)).getLot().isEmpty())) {
               this.mesTypeRhItems.add(new SelectItem(((ObjetCompte)this.lesNAt.get(var1)).getCode(), ((ObjetCompte)this.lesNAt.get(var1)).getNom_FR()));
            }
         }
      } else if (this.salariesGrh.getSalgrhNature() == 83) {
         for(var1 = 0; var1 < this.lesNAt.size(); ++var1) {
            if (((ObjetCompte)this.lesNAt.get(var1)).isValide() && ((ObjetCompte)this.lesNAt.get(var1)).getLot() != null && !((ObjetCompte)this.lesNAt.get(var1)).getLot().isEmpty() && ((ObjetCompte)this.lesNAt.get(var1)).getLot().equals("83")) {
               this.mesTypeRhItems.add(new SelectItem(((ObjetCompte)this.lesNAt.get(var1)).getCode(), ((ObjetCompte)this.lesNAt.get(var1)).getNom_FR()));
            }
         }
      } else if (this.salariesGrh.getSalgrhNature() == 84) {
         for(var1 = 0; var1 < this.lesNAt.size(); ++var1) {
            if (((ObjetCompte)this.lesNAt.get(var1)).isValide() && ((ObjetCompte)this.lesNAt.get(var1)).getLot() != null && !((ObjetCompte)this.lesNAt.get(var1)).getLot().isEmpty() && ((ObjetCompte)this.lesNAt.get(var1)).getLot().equals("84")) {
               this.mesTypeRhItems.add(new SelectItem(((ObjetCompte)this.lesNAt.get(var1)).getCode(), ((ObjetCompte)this.lesNAt.get(var1)).getNom_FR()));
            }
         }
      } else if (this.salariesGrh.getSalgrhNature() == 85) {
         for(var1 = 0; var1 < this.lesNAt.size(); ++var1) {
            if (((ObjetCompte)this.lesNAt.get(var1)).isValide() && ((ObjetCompte)this.lesNAt.get(var1)).getLot() != null && !((ObjetCompte)this.lesNAt.get(var1)).getLot().isEmpty() && ((ObjetCompte)this.lesNAt.get(var1)).getLot().equals("85")) {
               this.mesTypeRhItems.add(new SelectItem(((ObjetCompte)this.lesNAt.get(var1)).getCode(), ((ObjetCompte)this.lesNAt.get(var1)).getNom_FR()));
            }
         }
      } else if (this.salariesGrh.getSalgrhNature() == 86) {
         for(var1 = 0; var1 < this.lesNAt.size(); ++var1) {
            if (((ObjetCompte)this.lesNAt.get(var1)).isValide() && ((ObjetCompte)this.lesNAt.get(var1)).getLot() != null && !((ObjetCompte)this.lesNAt.get(var1)).getLot().isEmpty() && ((ObjetCompte)this.lesNAt.get(var1)).getLot().equals("86")) {
               this.mesTypeRhItems.add(new SelectItem(((ObjetCompte)this.lesNAt.get(var1)).getCode(), ((ObjetCompte)this.lesNAt.get(var1)).getNom_FR()));
            }
         }
      }

      this.configElementAffichage();
      this.salariesGrh.setSalgrhType(0);
      if (this.showModalPanelRh) {
         if (this.mesTypeRhItems.size() != 0) {
            this.salariesGrh.setSalgrhType(Integer.parseInt(((SelectItem)this.mesTypeRhItems.get(0)).getValue().toString()));
         }

         if (this.salariesGrh.getSalgrhNature() == 83) {
            this.recupererAttestationItem();
         } else if (this.salariesGrh.getSalgrhNature() == 85) {
            this.recupererCertificatItem();
         } else if (this.salariesGrh.getSalgrhNature() == 86) {
            this.recupererCorrespondanceItem();
         }
      }

   }

   public void configElementAffichage() {
      if (this.salariesGrh != null && this.salariesGrh.getSalgrhId() != 0L) {
         if (this.salariesGrh.getSalgrhDocument() != null && !this.salariesGrh.getSalgrhDocument().isEmpty()) {
            this.var_affFicPdfRh = true;
         } else {
            this.var_affFicPdfRh = false;
         }

         if (this.salariesGrh.getSalgrhNature() != 0 && this.salariesGrh.getSalgrhNature() != 84) {
            this.var_affiche_tdt_rh = true;
         } else {
            this.var_affiche_tdt_rh = false;
         }

         this.salaries = this.salariesGrh.getSalaries();
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 1 && this.usersLog.getUsrPaye() != 2 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_rh = false;
            } else {
               this.var_affiche_rh = true;
            }
         } else {
            this.var_affiche_rh = true;
         }
      } else {
         this.var_affFicPdfRh = false;
         this.var_affiche_rh = false;
         this.var_affiche_tdt_rh = false;
      }

   }

   public void selectionRh() {
      if (this.extDTableGrh != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEnteteGrh.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableGrh.setRowKey(var3);
            if (this.extDTableGrh.isRowAvailable()) {
               var1.add(this.extDTableGrh.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salariesGrh = (SalariesGrh)var1.get(0);
            this.configElementAffichage();
         } else {
            this.var_affiche_rh = false;
         }
      } else {
         this.var_affiche_rh = false;
      }

   }

   public void visualisationRh() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesGrh != null) {
         this.configElementAffichage();
      } else {
         this.var_affiche_rh = false;
      }

   }

   public void visualisationFicheRh() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesGrh != null) {
         this.configElementAffichage();
         if (this.var_affiche_rh) {
            if (this.salariesGrh.getSalgrhEtat() == 0) {
               this.modifierRh();
            } else {
               this.consulterRh();
            }
         }
      } else {
         this.var_affiche_rh = false;
      }

   }

   public void ajouterRh() {
      this.salariesGrh = new SalariesGrh();
      this.salariesGrh.setSalgrhNature(100);
      this.salariesGrh.setSalgrhDate(new Date());
      this.var_action_rh = 1;
      if (this.var_rh_rec != 83 && this.var_rh_rec != 85 && this.var_rh_rec != 86) {
         this.var_affiche_tdt_rh = false;
      } else {
         this.var_affiche_tdt_rh = true;
      }

      this.var_affFicPdfRh = false;
      this.showModalPanelRh = true;
   }

   public void modifierRh() {
      if (this.salariesGrh != null) {
         this.configElementAffichage();
         if (this.var_affiche_rh) {
            this.var_action_rh = 2;
            this.showModalPanelRh = true;
         }
      } else {
         this.var_affiche_rh = false;
      }

   }

   public void consulterRh() {
      if (this.salariesGrh != null) {
         this.configElementAffichage();
      } else {
         this.var_affiche_rh = false;
      }

   }

   public void supprimerRh() throws HibernateException, NamingException {
      if (this.salariesGrh != null) {
         long var1 = this.salaries.getSalId();
         int var3 = this.salariesGrh.getSalgrhNature();
         int var4 = this.salariesGrh.getSalgrhType();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var6 = null;

         Habilitation var7;
         try {
            var6 = var5.beginTransaction();
            var7 = this.verifHabilitation(this.salariesGrh.getSalgrhNature(), var5);
            if (var7 != null) {
               new Parapheur();
               ParapheurDao var9 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               Parapheur var8 = var9.existenceParapheur(this.salariesPrets.getSalpreId(), this.salariesGrh.getSalgrhNature(), var5);
               if (var8 != null) {
                  var9.delete(var8, var5);
               }
            }

            if (this.salariesGrh.getSalgrhDocument() != null && !this.salariesGrh.getSalgrhDocument().isEmpty()) {
               String var26 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "paye" + File.separator + "rh") + File.separator + this.salaries.getSalMatricule() + "_" + this.salariesGrh.getSalgrhType() + "_" + this.salariesGrh.getSalgrhId() + ".pdf";
               File var28 = new File(var26);
               if (var28.exists()) {
                  var28.delete();
               }
            }

            this.lesSalariesGrh.remove(this.salariesGrh);
            this.dataModelGrh.setWrappedData(this.lesSalariesGrh);
            this.salariesGrhDao.delete(this.salariesGrh, var5);
            var6.commit();
         } catch (HibernateException var23) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var4 == 15 || var4 == 16) {
            var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            var7 = null;

            try {
               Transaction var25 = var5.beginTransaction();
               this.salaries = this.salariesDao.chercherIdSalaries(var1, var5);
               if (this.salaries != null) {
                  this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, var5);
                  this.salaries.setSalNbEnfant(this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh));
                  this.salaries.setSalNbPartFiscal(this.formBakingBeanPaye.calculNbPartsFiscales(this.salaries, this.lesSalariesGrh));
                  this.salaries.setSalNbPartTrimf(this.formBakingBeanPaye.calculNbtrimf(this.salaries, this.lesSalariesGrh));
                  this.salaries = this.salariesDao.modif(this.salaries, var5);
                  new SalariesElements();
                  SalariesElementsDao var29 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
                  SalariesElements var27 = var29.chargerlesDerniersElements(this.salaries, var5);
                  if (var27 != null) {
                     new BulletinMois();
                     BulletinMoisDao var11 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
                     BulletinMois var10 = var11.recupererBulletinMoisFeuille(var27.getSalelePeriode(), var27.getSaleleFeuille(), var5);
                     if (var10 != null && var10.getBulmenEtat() <= 2) {
                        var27.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
                        var27.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
                        var27.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
                        var29.modif(var27, var5);
                     }
                  }

                  var25.commit();
               }
            } catch (HibernateException var21) {
               if (var7 != null) {
                  var7.rollback();
               }

               throw var21;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void annulerRh() {
      this.var_affiche_rh = false;
      this.showModalPanelRh = false;
      this.simpleSelectionEnteteGrh.clear();
      this.extDTableGrh = new HtmlExtendedDataTable();
   }

   public void saveRh() throws HibernateException, NamingException {
      if (this.salaries != null) {
         long var1 = this.salaries.getSalId();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            int var5 = this.salariesGrh.getSalgrhNature();
            int var6 = this.salariesGrh.getSalgrhType();
            Habilitation var7 = this.verifHabilitation(var5, var3);
            if (var7 != null) {
               this.salariesGrh.setSalgrhEtatVal(1);
               this.salariesGrh.setSalgrhEtat(0);
               this.salariesGrh.setSalgrhDateValide((Date)null);
            } else {
               this.salariesGrh.setSalgrhEtatVal(0);
               if (this.salariesGrh.getSalgrhDateImp() != null) {
                  if (this.salariesGrh.getSalgrhEtat() == 0) {
                     this.salariesGrh.setSalgrhEtat(1);
                     this.salariesGrh.setSalgrhDateValide(new Date());
                  }
               } else {
                  this.salariesGrh.setSalgrhEtat(0);
                  this.salariesGrh.setSalgrhDateValide((Date)null);
               }
            }

            if (this.salariesGrh.getSalgrhType() == 16 && this.salariesGrh.getSalgrhTravail() == 1) {
               this.salariesGrh.setSalgrhEmployeurAdresse("");
               this.salariesGrh.setSalgrhEmployeurBp("");
               this.salariesGrh.setSalgrhEmployeurFonction("");
               this.salariesGrh.setSalgrhEmployeurNom("");
               this.salariesGrh.setSalgrhEmployeurTel("");
               this.salariesGrh.setSalgrhEmployeurVille("");
            }

            if (this.salariesGrh.getSalgrhId() != 0L) {
               this.salariesGrh.setSalgrhDateModif(new Date());
               this.salariesGrh.setSalgrhUserModif(this.usersLog.getUsrid());
               this.salariesGrh = this.salariesGrhDao.modif(this.salariesGrh, var3);
            } else {
               String var8 = "";
               if (var5 == 83 || var5 == 84 || var5 == 85 || var5 == 86) {
                  if (this.salariesGrh.getSalgrhDate() == null) {
                     this.salariesGrh.setSalgrhDate(new Date());
                  }

                  var8 = this.calculChrono.numCompose(this.salariesGrh.getSalgrhDate(), var5, "", var3);
               }

               this.salariesGrh.setSalaries(this.salaries);
               this.salariesGrh.setSalgrhDateCreat(new Date());
               this.salariesGrh.setSalgrhUserCreat(this.usersLog.getUsrid());
               this.salariesGrh.setSalgrhNum(var8);
               this.salariesGrh = this.salariesGrhDao.insert(this.salariesGrh, var3);
               if ((var5 == 83 || var5 == 84 || var5 == 85 || var5 == 86) && var7 != null) {
                  this.majParapheur(var5, var7, var3);
               }

               this.lesSalariesGrh.add(this.salariesGrh);
               this.dataModelGrh.setWrappedData(this.lesSalariesGrh);
               this.simpleSelectionEnteteGrh.clear();
               this.extDTableGrh = new HtmlExtendedDataTable();
            }

            var4.commit();
         } catch (HibernateException var21) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.salariesGrh.getSalgrhType() == 15 || this.salariesGrh.getSalgrhType() == 16) {
            var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var23 = null;

            try {
               var23 = var3.beginTransaction();
               this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
               if (this.salaries != null) {
                  this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRhFamille(this.salaries, var3);
                  this.salaries.setSalNbFemme(this.formBakingBeanPaye.calculNbFemme(this.salaries, this.lesSalariesGrh));
                  this.salaries.setSalNbEnfant(this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh));
                  this.salaries.setSalNbPartFiscal(this.formBakingBeanPaye.calculNbPartsFiscales(this.salaries, this.lesSalariesGrh));
                  this.salaries.setSalNbPartTrimf(this.formBakingBeanPaye.calculNbtrimf(this.salaries, this.lesSalariesGrh));
                  if (this.salariesGrh.getSalgrhType() == 16) {
                     this.salaries.setSalConjointEmployeurAdresse(this.salariesGrh.getSalgrhEmployeurAdresse());
                     this.salaries.setSalConjointEmployeurBp(this.salariesGrh.getSalgrhEmployeurBp());
                     this.salaries.setSalConjointEmployeurFonction(this.salariesGrh.getSalgrhEmployeurFonction());
                     this.salaries.setSalConjointEmployeurNom(this.salariesGrh.getSalgrhEmployeurNom());
                     this.salaries.setSalConjointEmployeurTel(this.salariesGrh.getSalgrhEmployeurTel());
                     this.salaries.setSalConjointEmployeurVille(this.salariesGrh.getSalgrhEmployeurVille());
                     this.salaries.setSalConjointNomJf(this.salariesGrh.getSalgrhNomJf());
                     this.salaries.setSalConjointNomPrenom(this.salariesGrh.getSalgrhObjet());
                     this.salaries.setSalConjointNumFiscal(this.salariesGrh.getSalgrhNumFiscal());
                  }

                  this.salaries = this.salariesDao.modif(this.salaries, var3);
                  new SalariesElements();
                  SalariesElementsDao var25 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
                  SalariesElements var24 = var25.chargerlesDerniersElements(this.salaries, var3);
                  if (var24 != null) {
                     new BulletinMois();
                     BulletinMoisDao var9 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
                     BulletinMois var26 = var9.recupererBulletinMoisFeuille(var24.getSalelePeriode(), var24.getSaleleFeuille(), var3);
                     if (var26 != null && var26.getBulmenEtat() <= 2) {
                        var24.setSaleleNbFemme(this.salaries.getSalNbFemme());
                        var24.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
                        var24.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
                        var24.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
                        var25.modif(var24, var3);
                     }
                  }

                  var23.commit();
               }
            } catch (HibernateException var19) {
               if (var23 != null) {
                  var23.rollback();
               }

               throw var19;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showModalPanelRh = false;
   }

   public void ctrlEval1() {
      if (this.salariesGrh.getSalgrhEval1() != 2 && this.salariesGrh.getSalgrhEval1() != 1 && this.salariesGrh.getSalgrhEval1() != 0 && this.salariesGrh.getSalgrhEval1() != -1 && this.salariesGrh.getSalgrhEval1() != -2) {
         this.salariesGrh.setSalgrhEval1(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval2() {
      if (this.salariesGrh.getSalgrhEval2() != 2 && this.salariesGrh.getSalgrhEval2() != 1 && this.salariesGrh.getSalgrhEval2() != 0 && this.salariesGrh.getSalgrhEval2() != -1 && this.salariesGrh.getSalgrhEval2() != -2) {
         this.salariesGrh.setSalgrhEval2(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval3() {
      if (this.salariesGrh.getSalgrhEval3() != 2 && this.salariesGrh.getSalgrhEval3() != 1 && this.salariesGrh.getSalgrhEval3() != 0 && this.salariesGrh.getSalgrhEval3() != -1 && this.salariesGrh.getSalgrhEval3() != -2) {
         this.salariesGrh.setSalgrhEval3(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval4() {
      if (this.salariesGrh.getSalgrhEval4() != 2 && this.salariesGrh.getSalgrhEval4() != 1 && this.salariesGrh.getSalgrhEval4() != 0 && this.salariesGrh.getSalgrhEval4() != -1 && this.salariesGrh.getSalgrhEval4() != -2) {
         this.salariesGrh.setSalgrhEval4(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval5() {
      if (this.salariesGrh.getSalgrhEval5() != 2 && this.salariesGrh.getSalgrhEval5() != 1 && this.salariesGrh.getSalgrhEval5() != 0 && this.salariesGrh.getSalgrhEval5() != -1 && this.salariesGrh.getSalgrhEval5() != -2) {
         this.salariesGrh.setSalgrhEval5(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval6() {
      if (this.salariesGrh.getSalgrhEval6() != 2 && this.salariesGrh.getSalgrhEval6() != 1 && this.salariesGrh.getSalgrhEval6() != 0 && this.salariesGrh.getSalgrhEval6() != -1 && this.salariesGrh.getSalgrhEval6() != -2) {
         this.salariesGrh.setSalgrhEval6(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval7() {
      if (this.salariesGrh.getSalgrhEval7() != 2 && this.salariesGrh.getSalgrhEval7() != 1 && this.salariesGrh.getSalgrhEval7() != 0 && this.salariesGrh.getSalgrhEval7() != -1 && this.salariesGrh.getSalgrhEval7() != -2) {
         this.salariesGrh.setSalgrhEval7(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval8() {
      if (this.salariesGrh.getSalgrhEval8() != 2 && this.salariesGrh.getSalgrhEval8() != 1 && this.salariesGrh.getSalgrhEval8() != 0 && this.salariesGrh.getSalgrhEval8() != -1 && this.salariesGrh.getSalgrhEval8() != -2) {
         this.salariesGrh.setSalgrhEval8(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval9() {
      if (this.salariesGrh.getSalgrhEval9() != 2 && this.salariesGrh.getSalgrhEval9() != 1 && this.salariesGrh.getSalgrhEval9() != 0 && this.salariesGrh.getSalgrhEval9() != -1 && this.salariesGrh.getSalgrhEval9() != -2) {
         this.salariesGrh.setSalgrhEval9(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval10() {
      if (this.salariesGrh.getSalgrhEval10() != 2 && this.salariesGrh.getSalgrhEval10() != 1 && this.salariesGrh.getSalgrhEval10() != 0 && this.salariesGrh.getSalgrhEval10() != -1 && this.salariesGrh.getSalgrhEval10() != -2) {
         this.salariesGrh.setSalgrhEval10(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval11() {
      if (this.salariesGrh.getSalgrhEval11() != 2 && this.salariesGrh.getSalgrhEval11() != 1 && this.salariesGrh.getSalgrhEval11() != 0 && this.salariesGrh.getSalgrhEval11() != -1 && this.salariesGrh.getSalgrhEval11() != -2) {
         this.salariesGrh.setSalgrhEval11(0);
      }

      this.cumulNotation();
   }

   public void ctrlEval12() {
      if (this.salariesGrh.getSalgrhEval12() != 2 && this.salariesGrh.getSalgrhEval12() != 1 && this.salariesGrh.getSalgrhEval12() != 0 && this.salariesGrh.getSalgrhEval12() != -1 && this.salariesGrh.getSalgrhEval12() != -2) {
         this.salariesGrh.setSalgrhEval12(0);
      }

      this.cumulNotation();
   }

   public void cumulNotation() {
      boolean var1 = false;
      int var2 = this.salariesGrh.getSalgrhEval1() + this.salariesGrh.getSalgrhEval2() + this.salariesGrh.getSalgrhEval3() + this.salariesGrh.getSalgrhEval4() + this.salariesGrh.getSalgrhEval5() + this.salariesGrh.getSalgrhEval6() + this.salariesGrh.getSalgrhEval7() + this.salariesGrh.getSalgrhEval8() + this.salariesGrh.getSalgrhEval9() + this.salariesGrh.getSalgrhEval10() + this.salariesGrh.getSalgrhEval11() + this.salariesGrh.getSalgrhEval12();
      this.salariesGrh.setSalgrhTotEval(var2);
   }

   public void submitPDF() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.salariesGrh != null && this.uploadedPDFFile != null) {
         if (this.salariesGrh.getSalgrhId() == 0L) {
            this.salariesGrh.setSalaries(this.salaries);
            this.salariesGrh = this.salariesGrhDao.insert(this.salariesGrh);
         }

         String var1 = this.salaries.getSalMatricule() + "_" + this.salariesGrh.getSalgrhType() + "_" + this.salariesGrh.getSalgrhId() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         FacesContext var3 = FacesContext.getCurrentInstance();

         try {
            File var4 = this.utilDownload.uniqueFile(new File(this.nomrepertRH), var1);
            this.utilDownload.write(var4, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var1;
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.salariesGrh.setSalgrhDocument(var1);
            if (this.salariesGrh.getSalgrhId() != 0L) {
               this.salariesGrh = this.salariesGrhDao.modif(this.salariesGrh);
            }

            this.var_affFicPdfRh = true;
         } catch (IOException var5) {
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
            this.var_affFicPdfRh = false;
         }
      }

   }

   public void reInitPDF() throws HibernateException, NamingException {
      if (this.salariesGrh != null) {
         this.salariesGrh.setSalgrhDocument((String)null);
         if (this.salariesGrh.getSalgrhId() != 0L) {
            this.salariesGrh = this.salariesGrhDao.modif(this.salariesGrh);
         }

         String var1 = new File(this.nomrepertRH) + this.salaries.getSalMatricule() + "_" + this.salariesGrh.getSalgrhType() + "_" + this.salariesGrh.getSalgrhId() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.var_affFicPdfRh = false;
      }

   }

   public void voirPdf() throws MalformedURLException, IOException {
      if (this.salariesGrh == null) {
         this.selectionRh();
      }

      if (this.salariesGrh.getSalgrhDocument() != null && !this.salariesGrh.getSalgrhDocument().isEmpty()) {
         String var1 = this.nomrepertRH + this.salariesGrh.getSalaries().getSalMatricule() + "_" + this.salariesGrh.getSalgrhType() + "_" + this.salariesGrh.getSalgrhId() + ".pdf";
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.salariesGrh.getSalgrhDocument());
         this.showModalPanelPdf = true;
      }

   }

   public void downloadPdf() throws FileNotFoundException, IOException {
      if (this.salariesGrh != null) {
         BufferedInputStream var1 = null;
         BufferedOutputStream var2 = null;
         FacesContext var3 = FacesContext.getCurrentInstance();
         HttpServletResponse var4 = (HttpServletResponse)var3.getExternalContext().getResponse();
         String var5 = new File(this.nomrepertRH) + this.salaries.getSalMatricule() + "_" + this.salariesGrh.getSalgrhType() + "_" + this.salariesGrh.getSalgrhId() + ".pdf";
         File var6 = new File(var5);
         if (var6.exists()) {
            try {
               var1 = new BufferedInputStream(new FileInputStream(var6), 10240);
               var4.reset();
               var4.setContentType("application/pdf");
               var4.addHeader("Content-disposition", "attachment; filename=" + var6.getName());
               var4.setContentLength((int)var6.length());
               var2 = new BufferedOutputStream(var4.getOutputStream(), 10240);
               byte[] var7 = new byte[10240];

               while(true) {
                  int var8;
                  if ((var8 = var1.read(var7)) <= 0) {
                     var2.flush();
                     break;
                  }

                  var2.write(var7, 0, var8);
               }
            } finally {
               close(var2);
               close(var1);
            }

            var3.responseComplete();
         }
      }

   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public void fermerVisuPdf() {
      this.showModalPanelPdf = false;
   }

   public void selectionPretsInternes() throws HibernateException, NamingException {
      if (this.dataModelPretsInternes.isRowAvailable()) {
         this.salariesPrets = (SalariesPrets)this.dataModelPretsInternes.getRowData();
         this.lesSalariesPretsLignes.clear();
         this.lesSalariesPretsLignes = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, (Session)null);
         this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
         this.total_pret_interne = 0.0D;
         this.total_rmb_interne = 0.0D;
         this.solde_pret_interne = 0.0D;
         this.typePret = 0;
         if (this.lesSalariesPretsLignes.size() != 0) {
            for(int var1 = 0; var1 < this.lesSalariesPretsLignes.size(); ++var1) {
               this.total_pret_interne += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantTheo();
               this.total_rmb_interne += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantReel();
            }

            this.solde_pret_interne = this.total_pret_interne - this.total_rmb_interne;
         }

         this.var_affiche_prets = true;
      }

   }

   public void selectionPretsExternes() throws HibernateException, NamingException {
      if (this.dataModelPretsExternes.isRowAvailable()) {
         this.salariesPrets = (SalariesPrets)this.dataModelPretsExternes.getRowData();
         this.lesSalariesPretsLignes.clear();
         this.lesSalariesPretsLignes = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, (Session)null);
         this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
         this.total_pret_externe = 0.0D;
         this.total_rmb_externe = 0.0D;
         this.solde_pret_externe = 0.0D;
         this.typePret = 1;
         if (this.lesSalariesPretsLignes.size() != 0) {
            for(int var1 = 0; var1 < this.lesSalariesPretsLignes.size(); ++var1) {
               this.total_pret_externe += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantTheo();
               this.total_rmb_externe += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantReel();
            }

            this.solde_pret_externe = this.total_pret_externe - this.total_rmb_externe;
         }

         this.var_affiche_prets = true;
      }

   }

   public void selectionPretsManuels() throws HibernateException, NamingException {
      if (this.dataModelPretsManuels.isRowAvailable()) {
         this.salariesPrets = (SalariesPrets)this.dataModelPretsManuels.getRowData();
         this.lesSalariesPretsLignes.clear();
         this.lesSalariesPretsLignes = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, (Session)null);
         this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
         this.total_pret_manuel = 0.0D;
         this.total_rmb_manuel = 0.0D;
         this.solde_pret_manuel = 0.0D;
         this.typePret = 2;
         if (this.lesSalariesPretsLignes.size() != 0) {
            for(int var1 = 0; var1 < this.lesSalariesPretsLignes.size(); ++var1) {
               this.total_pret_manuel += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantTheo();
               this.total_rmb_manuel += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantReel();
            }

            this.solde_pret_manuel = this.total_pret_manuel - this.total_rmb_manuel;
         }

         this.var_affiche_prets = true;
      }

   }

   public void ajouterCapitalisation() throws HibernateException, NamingException {
      this.salariesCapitalisation = new SalariesCapitalisation();
      this.calculContrat((Session)null);
      this.showModalPanelCapitalisation = true;
   }

   public void modifierCapitalisation() throws HibernateException, NamingException {
      if (this.salariesCapitalisation != null) {
         this.calculContrat((Session)null);
         this.showModalPanelCapitalisation = true;
      }

   }

   public void supprimerCapitalisation() throws HibernateException, NamingException {
      if (this.salariesCapitalisation != null) {
         this.salariesCapitalisationDao.delete(this.salariesCapitalisation);
         this.salariesCapitalisation = new SalariesCapitalisation();
      }

   }

   public void validerCapitalisation() throws HibernateException, NamingException {
      this.salariesCapitalisation.setSalcapRubVersement(this.optionPaye.getRubVersement());
      this.salariesCapitalisation.setSalcapRubSpontanee(this.optionPaye.getRubSpontanee());
      this.salariesCapitalisation.setSalcapRubRetrait(this.optionPaye.getRubRetrait());
      if (this.salariesCapitalisation.getSalcapId() == 0L) {
         this.salariesCapitalisation.setSalaries(this.salaries);
         this.salariesCapitalisation = this.salariesCapitalisationDao.insert(this.salariesCapitalisation);
      } else {
         this.salariesCapitalisation = this.salariesCapitalisationDao.modif(this.salariesCapitalisation);
      }

      this.total_versement = 0.0D;
      this.total_retrait = 0.0D;
      this.solde_capitalisation = 0.0D;
      if (this.lesLignesCapitalisation.size() != 0) {
         for(int var1 = 0; var1 < this.lesLignesCapitalisation.size(); ++var1) {
            this.total_versement += ((BulletinLigne)this.lesLignesCapitalisation.get(var1)).getRecette();
            this.total_retrait += ((BulletinLigne)this.lesLignesCapitalisation.get(var1)).getDepense();
         }
      }

      this.solde_capitalisation = this.salariesCapitalisation.getSalcapInitial() + this.total_versement + this.total_retrait;
      this.showModalPanelCapitalisation = false;
   }

   public void fermerCapitalisation() {
      this.showModalPanelCapitalisation = false;
   }

   public void historiqueEpargne(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.salariesCapitalisation = new SalariesCapitalisation();
            this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var3);
            if (this.salariesCapitalisation == null) {
               this.salariesCapitalisation = new SalariesCapitalisation();
            } else {
               this.total_versement = 0.0D;
               this.total_retrait = 0.0D;
               this.solde_capitalisation = 0.0D;
               this.lesLignesCapitalisation.clear();
               if (this.salariesCapitalisation.getSalcapRubVersement() != null && !this.salariesCapitalisation.getSalcapRubVersement().isEmpty() && this.salariesCapitalisation.getSalcapRubRetrait() != null && !this.salariesCapitalisation.getSalcapRubRetrait().isEmpty()) {
                  this.lesLignesCapitalisation = this.salariesCapitalisationDao.chargerlesMvts(this.salaries, this.salariesCapitalisation, var3);
                  if (this.lesLignesCapitalisation.size() != 0) {
                     for(int var4 = 0; var4 < this.lesLignesCapitalisation.size(); ++var4) {
                        this.total_versement += ((BulletinLigne)this.lesLignesCapitalisation.get(var4)).getDepense();
                        this.total_retrait += ((BulletinLigne)this.lesLignesCapitalisation.get(var4)).getRecette();
                     }
                  }

                  this.solde_capitalisation = this.salariesCapitalisation.getSalcapInitial() + this.total_versement - this.total_retrait;
               }

               this.dataModelCapitalisation.setWrappedData(this.lesLignesCapitalisation);
            }
         }
      }

   }

   public void selectionHistorique() {
      if (this.dataModelHistorique.isRowAvailable()) {
         this.salariesHistorique = (SalariesHistorique)this.dataModelHistorique.getRowData();
         this.var_affiche_historique = true;
      }

   }

   public void ajouterHistorique() throws HibernateException, NamingException {
      this.salariesHistorique = new SalariesHistorique();
      this.salariesHistorique.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
      this.var_action_historique = 1;
      this.var_valide_historique = false;
      if (this.salaries.getSalFeuille() != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         new FeuilleCalcul();
         FeuilleCalcul var2 = this.feuilleCalculDao.chercherCode(this.salaries.getSalFeuille(), this.exercicesPaye.getExepayId(), var1);
         if (var2 != null) {
            this.calculContrat((Session)null);
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelHistorique = true;
   }

   public void modifierHistorique() throws HibernateException, NamingException {
      if (this.salariesHistorique != null) {
         this.var_action_historique = 2;
         this.var_valide_historique = true;
         if (this.salaries.getSalFeuille() != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            new FeuilleCalcul();
            FeuilleCalcul var2 = this.feuilleCalculDao.chercherCode(this.salaries.getSalFeuille(), this.exercicesPaye.getExepayId(), var1);
            if (var2 != null) {
               this.calculContrat((Session)null);
            }

            this.utilInitHibernate.closeSession();
         }

         this.showModalPanelHistorique = true;
      }

   }

   public void consulterHistorique() throws HibernateException, NamingException {
      if (this.salariesHistorique != null) {
         this.var_action_historique = 3;
         this.var_valide_historique = false;
         if (this.salaries.getSalFeuille() != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            new FeuilleCalcul();
            FeuilleCalcul var2 = this.feuilleCalculDao.chercherCode(this.salaries.getSalFeuille(), this.exercicesPaye.getExepayId(), var1);
            if (var2 != null) {
               this.calculContrat((Session)null);
            }

            this.utilInitHibernate.closeSession();
         }

         this.showModalPanelHistorique = true;
      }

   }

   public void supprimerHistorique() throws HibernateException, NamingException {
      if (this.salariesHistorique != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesSalariesHistorique.remove(this.salariesHistorique);
            this.dataModelHistorique.setWrappedData(this.lesSalariesHistorique);
            this.salariesHistoriqueDao.delete(this.salariesHistorique, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void annulerHistorique() {
      this.var_affiche_historique = false;
      this.showModalPanelHistorique = false;
   }

   public void saveHistorique() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.salariesHistorique.getSalhisCode().equals("BRUT")) {
            this.salariesHistorique.setSalhisLibelle("Salaire Brut");
         } else if (this.salariesHistorique.getSalhisCode().equals("CP")) {
            this.salariesHistorique.setSalhisLibelle("Congès Payés");
         } else if (this.salariesHistorique.getSalhisCode().equals("NBJS")) {
            this.salariesHistorique.setSalhisLibelle("Nombre de jours de congés acquis");
         } else if (this.salariesHistorique.getSalhisCode().equals("ADM")) {
            this.salariesHistorique.setSalhisLibelle("Appoint dernier mois");
         }

         if (this.salariesHistorique.getSalhisId() == 0L) {
            this.salariesHistorique.setSalaries(this.salaries);
            this.salariesHistorique.setExercicesPaye(this.exercicesPaye);
            this.salariesHistorique = this.salariesHistoriqueDao.insert(this.salariesHistorique, var1);
            this.lesSalariesHistorique.add(this.salariesHistorique);
            this.dataModelHistorique.setWrappedData(this.lesSalariesHistorique);
         } else {
            this.salariesHistorique = this.salariesHistoriqueDao.modif(this.salariesHistorique, var1);
         }

         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelHistorique = false;
   }

   public void verifUniciteRubrique() {
      if (this.lesSalariesHistorique.size() != 0) {
         this.var_valide_historique = true;

         for(int var1 = 0; var1 < this.lesSalariesHistorique.size(); ++var1) {
            if (((SalariesHistorique)this.lesSalariesHistorique.get(var1)).getSalhisCode().equals(this.salariesHistorique.getSalhisCode())) {
               this.var_valide_historique = false;
            }
         }
      } else {
         this.var_valide_historique = true;
      }

   }

   public void majParapheur(int var1, Habilitation var2, Session var3) {
      Parapheur var4 = new Parapheur();
      ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      var4.setPhrNature(var1);
      var4.setPhrMode(var2.getHabMode());
      var4.setPhrUser1Cat(var2.getHabUser1Cat());
      var4.setPhrUser1Id(var2.getHabUser1Id());
      var4.setPhrUser1Nom(var2.getHabUser1Nom());
      var4.setPhrUser2Cat(var2.getHabUser2Cat());
      var4.setPhrUser2Id(var2.getHabUser2Id());
      var4.setPhrUser2Nom(var2.getHabUser2Nom());
      var4.setPhrUser3Cat(var2.getHabUser3Cat());
      var4.setPhrUser3Id(var2.getHabUser3Id());
      var4.setPhrUser3Nom(var2.getHabUser3Nom());
      var4.setPhrUser4Cat(var2.getHabUser4Cat());
      var4.setPhrUser4Id(var2.getHabUser4Id());
      var4.setPhrUser4Nom(var2.getHabUser4Nom());
      var4.setPhrUser5Cat(var2.getHabUser5Cat());
      var4.setPhrUser5Id(var2.getHabUser5Id());
      var4.setPhrUser5Nom(var2.getHabUser5Nom());
      var4.setPhrUser6Cat(var2.getHabUser6Cat());
      var4.setPhrUser6Id(var2.getHabUser6Id());
      var4.setPhrUser6Nom(var2.getHabUser6Nom());
      if (var1 == 82) {
         var4.setPhrDocId(this.salariesContrats.getSalconId());
         var4.setPhrNum(this.salariesContrats.getSalconNum());
         var4.setPhrDate(this.salariesContrats.getSalconDateDebut());
      } else if (var1 != 83 && var1 != 84 && var1 != 85 && var1 != 86) {
         if (var1 == 87) {
            var4.setPhrDocId(this.salariesPrets.getSalpreId());
            var4.setPhrNum(this.salariesPrets.getSalpreNum());
            var4.setPhrDate(this.salariesPrets.getSalpreDateDebut());
         } else if (var1 == 88 || var1 == 89) {
            var4.setPhrDocId(this.salariesConges.getSalcngId());
            var4.setPhrNum("");
            var4.setPhrDate(this.salariesConges.getSalcngDateDebut());
         }
      } else {
         var4.setPhrDocId(this.salariesGrh.getSalgrhId());
         var4.setPhrNum(this.salariesGrh.getSalgrhNum());
         var4.setPhrDate(this.salariesGrh.getSalgrhDate());
      }

      if (var4.getPhrId() == 0L) {
         var5.insert(var4, var3);
      } else {
         var5.modif(var4, var3);
      }

   }

   public void majPretLignes(Session var1) throws NamingException, ParseException {
      if (this.salariesPrets.getSalpreRmb() == 0.0D) {
         if (this.salariesPrets.getSalpreDateDebut() != null && this.lesSalariesPretsLignes.size() != 0) {
            this.salariesPretsLignesDao.deleteAllLigne(this.lesSalariesPretsLignes, var1);
            this.lesSalariesPretsLignes.clear();
            var1.flush();
         }

         if (this.salariesPrets.getSalpreDateDebut() != null && this.salariesPrets.getSalpreEcheance() != 0) {
            UtilDate var2 = new UtilDate();
            UtilNombre var3 = new UtilNombre();
            Date var4 = var2.dateDernierJourMois(this.salariesPrets.getSalpreDateDebut());
            double var5 = var3.myRoundFormat(this.salariesPrets.getSalpreMontant() / (double)this.salariesPrets.getSalpreEcheance(), this.structureLog.getStrformatdevise());
            double var7 = this.salariesPrets.getSalpreMontant() - var5 * (double)this.salariesPrets.getSalpreEcheance();

            for(int var9 = 0; var9 < this.salariesPrets.getSalpreEcheance(); ++var9) {
               this.salariesPretsLignes = new SalariesPretsLignes();
               this.salariesPretsLignes.setSalaries(this.salaries);
               this.salariesPretsLignes.setSalariesPrets(this.salariesPrets);
               this.salariesPretsLignes.setSalpreligNum(this.salariesPrets.getSalpreNum());
               this.salariesPretsLignes.setSalpreligDateTheo(var4);
               if (var9 == this.salariesPrets.getSalpreEcheance() - 1) {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var5 + var7);
               } else {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var5);
               }

               var4 = var2.dateMoisSuivant(var4);
               var4 = var2.dateDernierJourMois(var4);
               this.lesSalariesPretsLignes.add(this.salariesPretsLignes);
            }

            if (this.lesSalariesPretsLignes.size() != 0) {
               this.salariesPretsLignesDao.insertAllLigne(this.lesSalariesPretsLignes, var1);
            }

            var1.flush();
         }
      }

   }

   public void calculEcheance() throws NamingException, ParseException {
      if (this.salariesPrets.getSalpreRmb() == 0.0D) {
         if (this.lesSalariesPretsLignes.size() != 0) {
            this.lesSalariesPretsLignes.clear();
         }

         if (this.salariesPrets.getSalpreDateDebut() != null && this.salariesPrets.getSalpreEcheance() != 0) {
            UtilDate var1 = new UtilDate();
            UtilNombre var2 = new UtilNombre();
            Date var3 = var1.dateDernierJourMois(this.salariesPrets.getSalpreDateDebut());
            double var4 = var2.myRoundFormat(this.salariesPrets.getSalpreMontant() / (double)this.salariesPrets.getSalpreEcheance(), this.structureLog.getStrformatdevise());
            double var6 = this.salariesPrets.getSalpreMontant() - var4 * (double)this.salariesPrets.getSalpreEcheance();

            for(int var8 = 0; var8 < this.salariesPrets.getSalpreEcheance(); ++var8) {
               this.salariesPretsLignes = new SalariesPretsLignes();
               this.salariesPretsLignes.setSalaries(this.salaries);
               this.salariesPretsLignes.setSalariesPrets(this.salariesPrets);
               this.salariesPretsLignes.setSalpreligNum(this.salariesPrets.getSalpreNum());
               this.salariesPretsLignes.setSalpreligDateTheo(var3);
               if (var8 == this.salariesPrets.getSalpreEcheance() - 1) {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var4 + var6);
               } else {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var4);
               }

               var3 = var1.dateMoisSuivant(var3);
               var3 = var1.dateDernierJourMois(var3);
               this.lesSalariesPretsLignes.add(this.salariesPretsLignes);
            }
         }
      }

   }

   public void rechercheTexteModeleContrat() throws HibernateException, NamingException {
      this.salariesContrats.setSalconTexte("");
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      if (this.var_code_modele != null && !this.var_code_modele.isEmpty()) {
         String var2 = "";
         if (this.var_code_modele.contains(":")) {
            String[] var3 = this.var_code_modele.split(":");
            var2 = var3[0];
         } else {
            var2 = this.var_code_modele;
         }

         new ModelesCourriers();
         ModelesCourriers var4 = var1.rechercheModeles(var2, (Session)null);
         if (var4 != null) {
            this.salariesContrats.setSalconTexte(var4.getModTexte());
            this.var_objet_automatique = this.salariesContrats.getLib_nature();
            this.calculeTexte();
         } else {
            this.salariesContrats.setSalconTexte("Erreur modèle");
         }
      }

   }

   public void calculeTexte() throws HibernateException, NamingException {
      this.calculeZone((Session)null);
      if (this.salariesContrats.getSalconTexte() != null && !this.salariesContrats.getSalconTexte().isEmpty()) {
         this.salariesContrats.setSalconTexte(this.utilTdt.analyseTexteRH(this.salariesContrats.getSalconTexte(), this.usersLog, this.structureLog, this.salaries, this.salariesContrats, this.baseLog, this.utilInitHibernate));
      } else {
         this.afficheTexteContrat = true;
      }

   }

   public void rechercheTexteModeleContratMuter() throws HibernateException, NamingException {
      this.salariesContratsMuter.setSalconTexte("");
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      if (this.var_code_modeleMuter != null && !this.var_code_modeleMuter.isEmpty()) {
         String var2 = "";
         if (this.var_code_modeleMuter.contains(":")) {
            String[] var3 = this.var_code_modeleMuter.split(":");
            var2 = var3[0];
         } else {
            var2 = this.var_code_modeleMuter;
         }

         new ModelesCourriers();
         ModelesCourriers var4 = var1.rechercheModeles(var2, (Session)null);
         if (var4 != null) {
            this.salariesContratsMuter.setSalconTexte(var4.getModTexte());
            this.var_objet_automatique = this.salariesContratsMuter.getLib_nature();
            this.calculeTexteMuter();
         } else {
            this.salariesContratsMuter.setSalconTexte("Erreur modèle");
         }
      }

   }

   public void calculeTexteMuter() throws HibernateException, NamingException {
      this.calculeZoneMuter((Session)null);
      if (this.salariesContratsMuter.getSalconTexte() != null && !this.salariesContratsMuter.getSalconTexte().isEmpty()) {
         this.salariesContratsMuter.setSalconTexte(this.utilTdt.analyseTexteRH(this.salariesContratsMuter.getSalconTexte(), this.usersLog, this.structureLog, this.salaries, this.salariesContratsMuter, this.baseLog, this.utilInitHibernate));
      } else {
         this.afficheTexteContrat = true;
      }

   }

   public void rechercheTexteModeleRh() throws HibernateException, NamingException {
      this.salariesContrats.setSalconTexte("");
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      if (this.var_code_modele != null && !this.var_code_modele.isEmpty()) {
         String var2 = "";
         if (this.var_code_modele.contains(":")) {
            String[] var3 = this.var_code_modele.split(":");
            var2 = var3[0];
         } else {
            var2 = this.var_code_modele;
         }

         new ModelesCourriers();
         ModelesCourriers var5 = var1.rechercheModeles(var2, (Session)null);
         if (var5 != null) {
            this.salariesGrh.setSalgrhTexte(var5.getModTexte());
            String var4 = "";
            if (this.salariesGrh.getSalgrhType() == 10) {
               var4 = "libre";
            } else if (this.salariesGrh.getSalgrhType() == 11) {
               var4 = "de congés";
            } else if (this.salariesGrh.getSalgrhType() == 12) {
               var4 = "de logement";
            } else if (this.salariesGrh.getSalgrhType() == 13) {
               var4 = "d`emploi";
            } else if (this.salariesGrh.getSalgrhType() == 90) {
               var4 = "autre type";
            } else if (this.salariesGrh.getSalgrhType() == 20) {
               var4 = "libre";
            } else if (this.salariesGrh.getSalgrhType() == 21) {
               var4 = "d`embauche";
            } else if (this.salariesGrh.getSalgrhType() == 22) {
               var4 = "de travail";
            } else if (this.salariesGrh.getSalgrhType() == 23) {
               var4 = "de cessation de travail";
            } else if (this.salariesGrh.getSalgrhType() == 24) {
               var4 = "d`aptitude";
            } else if (this.salariesGrh.getSalgrhType() == 25) {
               var4 = "de stage";
            } else if (this.salariesGrh.getSalgrhType() == 26) {
               var4 = "d`obtention de diplôme";
            } else if (this.salariesGrh.getSalgrhType() == 91) {
               var4 = "autre type";
            }

            this.var_objet_automatique = this.salariesGrh.getLib_nature() + " " + var4;
            this.salariesGrh.setSalgrhTexte(this.utilTdt.analyseTexteRH(this.salariesGrh.getSalgrhTexte(), this.usersLog, this.structureLog, this.salaries, this.salariesContrats, this.baseLog, this.utilInitHibernate));
         }
      }

   }

   public void rechercheSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.rechercheSalarie(this.nomSalarie, 813, this.exercicesPaye.getExepayId());
      if (this.salaries != null) {
         if (this.salaries.getSalId() != 0L) {
            this.calculeSalarie();
         } else {
            this.var_action = 9;
         }
      } else if (this.salaries == null) {
         this.annuleSalarie();
      }

   }

   public void rechercheSalarieRH() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.rechercheSalarie(this.nomSalarie, 813, this.var_rh_rec, this.exercicesPaye.getExepayId());
      if (this.salaries != null) {
         if (this.salaries.getSalId() != 0L) {
            this.calculeSalarie();
         } else {
            this.var_action = 9;
         }
      } else if (this.salaries == null) {
         this.annuleSalarie();
      }

   }

   public void recuperationSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.calculeSalarie();
      this.calculeSalarie();
   }

   public void calculeSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.salaries != null) {
         this.nomSalarie = "";
         if (this.salariesGrh != null && this.salariesGrh.getSalgrhId() == 0L) {
            this.salariesGrh.setSalgrhNature(this.var_rh_rec);
            this.salariesGrh.setSalgrhType(this.var_typerh_rec);
         }
      } else {
         this.annuleSalarie();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleSalarie() {
      this.salaries = new Salaries();
      this.nomSalarie = "";
      this.var_action = this.var_memo_action;
   }

   public void changerMatricule() {
      if (this.salaries != null) {
         this.var_nouveau_matricule = "";
         this.var_unicite = true;
         this.showModalPanelChangerMatricule = true;
      }

   }

   public void verificationUnicite() throws HibernateException, NamingException {
      this.var_unicite = this.salariesDao.verifUnicite(this.var_nouveau_matricule, (Session)null);
   }

   public void fermerChangerMatricule() {
      this.showModalPanelChangerMatricule = true;
   }

   public void validerChangerMatricule() throws HibernateException, NamingException, ParseException {
      if (this.salaries != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.bulletinSalaireDao.chargerlesBulletinsbySalarie(this.salaries, var1);
            if (var3.size() != 0) {
               new BulletinSalaire();

               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  BulletinSalaire var4 = (BulletinSalaire)var3.get(var5);
                  var4.setBulsalMatricule(this.var_nouveau_matricule);
                  this.bulletinSalaireDao.modif(var4, var1);
               }
            }

            new ArrayList();
            SalariesElementsDao var14 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
            List var13 = var14.chargerlesElementsBySalaries(this.salaries, var1);
            if (var13.size() != 0) {
               new SalariesElements();

               for(int var7 = 0; var7 < var13.size(); ++var7) {
                  SalariesElements var6 = (SalariesElements)var13.get(var7);
                  var6.setSaleleMatricule(this.var_nouveau_matricule);
                  var14.modif(var6, var1);
               }
            }

            this.salaries = this.salariesDao.chercherIdSalaries(this.salaries.getSalId(), var1);
            if (this.salaries != null) {
               this.salaries.setSalMatricule(this.var_nouveau_matricule);
               this.salaries = this.salariesDao.modif(this.salaries, var1);
            }

            new Chrono();
            ChronoDao var16 = new ChronoDao(this.baseLog, this.utilInitHibernate);
            Chrono var15 = var16.rechercheSalarieNature(this.salaries.getSalNature(), 81, var1);
            if (var15 != null) {
               if (var15.getChrMode() == 0) {
                  var15.setChrNumAn(var15.getChrNumAn() + 1L);
               } else if (var15.getChrMode() != 1 && var15.getChrMode() == 2) {
                  var15.setChrNum(var15.getChrNum() + 1L);
               }

               var16.modifierChrono(var15, var1);
            }

            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_affiche_bouton = false;
         this.showModalPanelChangerMatricule = false;
         this.rechercherSalarie();
      }

   }

   public void envoiSmsZ1() {
      if (this.salaries.getSalCel1() != null && !this.salaries.getSalCel1().isEmpty()) {
         this.numeroMobile = this.salaries.getSalCel1();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ2() {
      if (this.salaries.getSalCel2() != null && !this.salaries.getSalCel2().isEmpty()) {
         this.numeroMobile = this.salaries.getSalCel2();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ3() {
      if (this.salaries.getSalCel3() != null && !this.salaries.getSalCel3().isEmpty()) {
         this.numeroMobile = this.salaries.getSalCel3();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void fermerSms() {
      this.showModalPanelSms = false;
   }

   public void valideEnvoiSms() throws IOException, HibernateException, NamingException, SQLException {
      UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
      var1.sendSmsOne(this.messageSms, this.numeroMobile, this.salaries.getPatronyme(), this.salaries.getSalCivilite(), this.salaries.getSalId(), (String)null, 0L, 2);
      this.showModalPanelSms = false;
   }

   public void gestionTache() throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.lesTachesAgents = this.salariesTachesDao.selectUsersTaches(this.salaries, (Session)null);
         this.dataModelTachesAgents.setWrappedData(this.lesTachesAgents);
         this.selectTache = false;
         this.showModalPanelListeTache = true;
      }

   }

   public void fermerTache() {
      this.showModalPanelListeTache = false;
   }

   public void selectionTache() {
      if (this.dataModelTachesAgents.isRowAvailable()) {
         this.salariesTaches = (SalariesTaches)this.dataModelTachesAgents.getRowData();
         this.selectTache = true;
      }

   }

   public void calculTache() throws HibernateException, NamingException {
      if (this.salariesTaches.getSaltacCode() != null && !this.salariesTaches.getSaltacCode().isEmpty()) {
         new Taches();
         Taches var1 = this.tachesDao.rechercheTache(this.salariesTaches.getSaltacCode(), (Session)null);
         if (var1 != null) {
            this.salariesTaches.setSaltacMission(var1.getTacMission());
            this.salariesTaches.setSaltacCode(var1.getTacCode());
            this.salariesTaches.setSaltacLib(var1.getTacNomFr());
            this.salariesTaches.setSaltacValPr(var1.getTacValPr());
            this.salariesTaches.setSaltacValPv(var1.getTacValPv());
         } else {
            this.salariesTaches.setSaltacMission("");
            this.salariesTaches.setSaltacCode("");
            this.salariesTaches.setSaltacLib("");
            this.salariesTaches.setSaltacValPr(0.0F);
            this.salariesTaches.setSaltacValPv(0.0F);
         }
      } else {
         this.salariesTaches.setSaltacMission("");
         this.salariesTaches.setSaltacCode("");
         this.salariesTaches.setSaltacLib("");
         this.salariesTaches.setSaltacValPr(0.0F);
         this.salariesTaches.setSaltacValPv(0.0F);
      }

   }

   public void ajouterTache() {
      if (this.salaries != null) {
         this.salariesTaches = new SalariesTaches();
         this.showModalPanelTache = true;
      }

   }

   public void annulerTache() {
      this.selectTache = false;
      this.showModalPanelTache = false;
   }

   public void modifierTache() {
      if (this.salariesTaches != null) {
         this.showModalPanelTache = true;
      }

   }

   public void supprimerTache() throws HibernateException, NamingException {
      if (this.salariesTaches != null) {
         this.salariesTachesDao.deletetache(this.salariesTaches);
         this.lesTachesAgents.remove(this.salariesTaches);
         this.dataModelTachesAgents.setWrappedData(this.lesTachesAgents);
         this.selectTache = false;
      }

   }

   public void validerTache() throws HibernateException, NamingException {
      if (this.salariesTaches.getSaltacId() == 0L) {
         this.salariesTaches.setSalaries(this.salaries);
         this.salariesTaches = this.salariesTachesDao.insert(this.salariesTaches);
         this.lesTachesAgents.add(this.salariesTaches);
         this.dataModelTachesAgents.setWrappedData(this.lesTachesAgents);
      } else {
         this.salariesTaches = this.salariesTachesDao.modif(this.salariesTaches);
      }

      this.showModalPanelTache = false;
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

   public void chargerLesModelesImpresion() {
      boolean var1 = false;
      int var8;
      if (this.var_typerh_rec > 100 && (this.var_typerh_rec < 8400 || this.var_typerh_rec > 8499)) {
         var8 = this.var_rh_rec;
      } else {
         var8 = this.var_typerh_rec;
      }

      String var2 = "";
      if (this.nature == 81) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "fiche";
      } else if (this.nature == 82) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "contrat";
      } else if (this.nature == 93) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "rh" + File.separator + "rh_" + var8;
      }

      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var4 = var3.list();
      int var5;
      String var6;
      int var7;
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            var6 = var4[var5];
            if (var6.endsWith("jasper")) {
               var7 = var6.indexOf(".");
               var6 = var6.substring(0, var7);
               this.listeImpressionItems.add(new SelectItem(var6));
            }
         }
      }

      if (this.nature == 81) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "fiche";
      } else if (this.nature == 82) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "contrat";
      } else if (this.nature == 93) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "rh" + File.separator + "rh_" + var8;
      }

      var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);
         this.documentImpressionItems = new ArrayList();

         for(var5 = 0; var5 < var4.length; ++var5) {
            var6 = var4[var5];
            if (var6.endsWith("jasper")) {
               var7 = var6.indexOf(".");
               var6 = var6.substring(0, var7);
               if (this.salaries != null && this.salariesContrats != null) {
                  if (var6.contains("Avenant") && this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && (this.salariesContrats.getSalconType().equals("01D") || this.salariesContrats.getSalconType().equals("02D") || this.salariesContrats.getSalconType().equals("03D"))) {
                     this.documentImpressionItems.add(new SelectItem(var6));
                  } else if (!var6.contains("Avenant")) {
                     this.documentImpressionItems.add(new SelectItem(var6));
                  }
               } else {
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

      this.listeAvenantImpression();
   }

   public void listeAvenantImpression() {
      this.listeAvenantItems.clear();
      if (this.nature == 82 && this.salaries != null && this.salariesContrats != null && this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && (this.salariesContrats.getSalconType().equals("01D") || this.salariesContrats.getSalconType().equals("02D") || this.salariesContrats.getSalconType().equals("03D"))) {
         if (this.salariesContrats.getSalconDateAvenantFin1() != null) {
            this.listeAvenantItems.add(new SelectItem(1, "Avenant N° 1"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin2() != null) {
            this.listeAvenantItems.add(new SelectItem(2, "Avenant N° 2"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin3() != null) {
            this.listeAvenantItems.add(new SelectItem(3, "Avenant N° 3"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin4() != null) {
            this.listeAvenantItems.add(new SelectItem(4, "Avenant N° 4"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin5() != null) {
            this.listeAvenantItems.add(new SelectItem(5, "Avenant N° 5"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin6() != null) {
            this.listeAvenantItems.add(new SelectItem(6, "Avenant N° 6"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin7() != null) {
            this.listeAvenantItems.add(new SelectItem(7, "Avenant N° 7"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin8() != null) {
            this.listeAvenantItems.add(new SelectItem(8, "Avenant N° 8"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin9() != null) {
            this.listeAvenantItems.add(new SelectItem(9, "Avenant N° 9"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin10() != null) {
            this.listeAvenantItems.add(new SelectItem(10, "Avenant N° 10"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin11() != null) {
            this.listeAvenantItems.add(new SelectItem(11, "Avenant N° 11"));
         }

         if (this.salariesContrats.getSalconDateAvenantFin12() != null) {
            this.listeAvenantItems.add(new SelectItem(12, "Avenant N° 12"));
         }
      }

   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var3 != null && !var3.isEmpty() || var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         if (var2 == 0) {
            var1.setRapport(var3);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "fiche" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression fiche salarié");
            var1.setFiltre("Saisie par ");
            var1.setFormat(var5);
            var1.setMatricule(this.salaries.getSalMatricule());
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            ArrayList var11 = new ArrayList();
            String var12 = "";
            String var13 = "";
            new ArrayList();
            List var14 = this.salariesGrhDao.chargerlesElementRh(this.salaries, (Session)null);
            if (var14.size() != 0) {
               for(int var15 = 0; var15 < var14.size(); ++var15) {
                  if (((SalariesGrh)var14.get(var15)).getSalgrhType() == 16) {
                     if (var12 != null && !var12.isEmpty()) {
                        var12 = var12 + ", " + ((SalariesGrh)var14.get(var15)).getSalgrhObjet();
                     } else {
                        var12 = ((SalariesGrh)var14.get(var15)).getSalgrhObjet();
                     }
                  } else if (((SalariesGrh)var14.get(var15)).getSalgrhType() == 15) {
                     if (var13 != null && !var13.isEmpty()) {
                        var13 = var13 + ", " + ((SalariesGrh)var14.get(var15)).getSalgrhObjet();
                     } else {
                        var13 = ((SalariesGrh)var14.get(var15)).getSalgrhObjet();
                     }
                  }
               }
            }

            this.salaries.setNomEnfant(var13);
            this.salaries.setNomEpouse(var12);
            this.salaries.setDateDebutContrat((Date)null);
            this.salaries.setDateFinContrat((Date)null);
            var11.add(this.salaries);
            JRBeanCollectionDataSource var17 = new JRBeanCollectionDataSource(var11);
            var1.setjRBeanCollectionDataSource(var17);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         } else {
            var1.setRapport(var4);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "fiche" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression liste salarié");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(this.lesSalaries);
            var1.setjRBeanCollectionDataSource(var16);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public void impressionContrat(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var4 != null && !var4.isEmpty() || var5 != null && !var5.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         if (var2 == 0) {
            var1.setRapport(var4);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "contrat" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            String var12 = "null";
            File var13;
            if (this.salariesContrats.getSalconEtatH() == 0) {
               var13 = new File(var1.getCheminSousrapport() + "formatEncours.jpg");
               if (var13.exists()) {
                  var12 = "formatEncours.jpg";
               }
            } else {
               var13 = new File(var1.getCheminSousrapport() + "formatPaye.jpg");
               if (var13.exists()) {
                  var12 = "formatPaye.jpg";
               }
            }

            var1.setImageFondPage(var12);
            var1.setEntete("Impression Contrat n° " + this.salariesContrats.getSalconNum());
            var1.setFormat(var6);
            if (var3 == null || var3.isEmpty()) {
               var3 = "0";
            }

            int var17 = Integer.parseInt(var3);
            var1.setEtat_init(var17);
            var1.setMatricule(this.salaries.getSalMatricule());
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setTiersSelectionne((Tiers)null);
            ArrayList var14 = new ArrayList();
            var14.add(this.salariesContrats);
            JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(var14);
            var1.setjRBeanCollectionDataSource(var15);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         } else if (var2 == 1) {
            var1.setRapport(var5);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "contrat" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression Liste Contrats");
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(this.lesSalariesContrats);
            var1.setjRBeanCollectionDataSource(var16);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public void impressionRh(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var3 != null && !var3.isEmpty() || var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         if (var2 == 0) {
            boolean var11 = false;
            int var17;
            if (this.var_typerh_rec > 100 && (this.var_typerh_rec < 8400 || this.var_typerh_rec > 8499)) {
               var17 = this.var_rh_rec;
            } else {
               var17 = this.var_typerh_rec;
            }

            var1.setRapport(var3);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "rh" + File.separator + "rh_" + var17 + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            String var12 = "null";
            File var13 = new File(var1.getCheminSousrapport() + "formatPaye.jpg");
            if (var13.exists()) {
               var12 = "formatPaye.jpg";
            }

            var1.setImageFondPage(var12);
            var1.setEntete("Impression rh n° " + this.salariesGrh.getSalgrhNum());
            var1.setFormat(var5);
            var1.setMatricule(this.salaries.getSalMatricule());
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNomMapping("Salarie");
            String var14 = " pay_salaries_grh.`salgrh_id`=" + this.salariesGrh.getSalgrhId();
            var1.setRequete(var14);
            ArrayList var15 = new ArrayList();
            JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(var15);
            var1.setjRBeanCollectionDataSource(var16);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         } else if (var2 == 1) {
            var1.setRapport(var4);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "rh" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression Liste R.H.");
            var1.setFormat(var5);
            var1.setMatricule(this.salaries.getSalMatricule());
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var18 = new JRBeanCollectionDataSource(this.lesSalariesGrh);
            var1.setjRBeanCollectionDataSource(var18);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public void initGrapheur() {
      this.modeGraph = 0;
      this.valQteGraph = 0;
      this.timeDecoupage = 5;
      this.sousTitreGraph = "";
      this.uniteGraph = "";
      this.nbDecGraph = 0;
      this.deviseGraph = "";
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
      if (this.lesSalaries.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "Nombre d`agents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         }

         this.titreGraph = "Analyse des agents : ";
         this.sousTitreGraph = "";
         if (this.modeGraph == 0) {
            this.sousTitreGraph = " - Par genre";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = " - Par tranche d`age";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = " - Par tranche d`age et genre";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = " - Par service";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = " - Par fonction";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = " - Par type de contrat";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = " - Par mode de paiement";
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = " - Par activité";
         } else if (this.modeGraph == 8) {
            this.sousTitreGraph = " - Par compétence";
         } else if (this.modeGraph == 9) {
            this.sousTitreGraph = " - Par pays de résidence";
         } else if (this.modeGraph == 10) {
            this.sousTitreGraph = " - Par nationnalité";
         } else if (this.modeGraph == 11) {
            this.sousTitreGraph = " - Par feuille de calcul";
         } else if (this.modeGraph == 12) {
            this.sousTitreGraph = " - Par clients interim";
         } else if (this.modeGraph == 13) {
            this.sousTitreGraph = " - Par classement";
         } else if (this.modeGraph == 14) {
            this.sousTitreGraph = " - Par niveau emploi";
         }

         new Salaries();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         if (this.lesSalaries.size() != 0) {
            String var4 = "";
            long var5 = 0L;
            boolean var7 = false;
            Salaries var2;
            int var9;
            if (this.timeDecoupage == 5) {
               int var14 = 0;

               while(true) {
                  if (var14 >= this.lesSalaries.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  var2 = (Salaries)this.lesSalaries.get(var14);
                  var4 = "";
                  var5 = 0L;
                  var7 = false;
                  if (this.modeGraph == 0) {
                     if (var2.getSalGenre() == 0) {
                        var4 = "Femme";
                     } else {
                        var4 = "Homme";
                     }
                  } else if (this.modeGraph == 1) {
                     var9 = 0;
                     if (var2.getSalDateNaissance() != null && var2.getSalDateNaissance() != null) {
                        var9 = (int)((double)((new Date()).getTime() - var2.getSalDateNaissance().getTime()) / 3.1556736E10D);
                     }

                     var4 = this.calculAge(var9);
                  } else if (this.modeGraph == 2) {
                     if (var2.getSalGenre() == 0) {
                        var4 = "Femme";
                     } else {
                        var4 = "Homme";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var2.getSalService() != null && !var2.getSalService().isEmpty()) {
                        var4 = var2.getSalService();
                     } else {
                        var4 = "Sans Service";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var2.getSalFonction() != null && !var2.getSalFonction().isEmpty()) {
                        var4 = var2.getSalFonction();
                     } else {
                        var4 = "Sans Fonction";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var2.getSalNature() != null && !var2.getSalNature().isEmpty()) {
                        var4 = var2.getSalNature() + ":" + var2.getLib_nature();
                     } else {
                        var4 = "Sans Type de contrat";
                     }
                  } else if (this.modeGraph == 6) {
                     var4 = this.calculModePaiment(var2.getSalModeReglement());
                  } else if (this.modeGraph == 7) {
                     var4 = this.calculActviteRoster(var2);
                  } else if (this.modeGraph == 9) {
                     if (var2.getSalNompays() != null && !var2.getSalNompays().isEmpty()) {
                        var4 = var2.getSalNompays();
                     } else {
                        var4 = "Sans Pays";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var2.getSalNationnalite() != null && !var2.getSalNationnalite().isEmpty()) {
                        var4 = var2.getSalNationnalite();
                     } else {
                        var4 = "Sans Nationalité";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var2.getSalFeuille() != null && !var2.getSalFeuille().isEmpty()) {
                        var4 = var2.getSalFeuille();
                     } else {
                        var4 = "Sans Feuille";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var2.getSalNomTiers() != null && !var2.getSalNomTiers().isEmpty()) {
                        var4 = var2.getSalNomTiers();
                     } else {
                        var4 = "Sans Client";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var2.getSalClassement() != null && !var2.getSalClassement().isEmpty()) {
                        var4 = var2.getSalClassement();
                     } else {
                        var4 = "Sans Classement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var2.getSalNivEmploi() != null && !var2.getSalNivEmploi().isEmpty()) {
                        var4 = var2.getSalNivEmploi();
                     } else {
                        var4 = "Sans Niveau";
                     }
                  }

                  ++var5;
                  byte var16 = 1;
                  var1 = this.calculeListe((List)var1, var4, var16, var5);
                  ++var14;
               }
            } else {
               String var8 = "";

               for(var9 = 0; var9 < this.lesSalaries.size(); ++var9) {
                  var2 = (Salaries)this.lesSalaries.get(var9);
                  if (var8.isEmpty()) {
                     var8 = "'" + var2.getSalMatricule() + "'";
                  } else {
                     var8 = var8 + ",'" + var2.getSalMatricule() + "'";
                  }
               }

               new ArrayList();
               List var15 = this.bulletinSalaireDao.chargerLesBulletinsByMatricule(var8, this.exercicesPaye.getExepayDateDebut(), this.exercicesPaye.getExepayDateFin(), var3);
               new BulletinSalaire();
               int var11 = 0;

               while(true) {
                  if (var11 >= var15.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  BulletinSalaire var10 = (BulletinSalaire)var15.get(var11);
                  var4 = "";
                  var5 = 0L;
                  int var13 = 0;
                  if (this.modeGraph == 0) {
                     if (var10.getBulsalGenre() == 0) {
                        var4 = "Femme";
                     } else {
                        var4 = "Homme";
                     }
                  } else if (this.modeGraph == 1) {
                     int var12 = 0;
                     if (var10.getSalaries().getSalDateNaissance() != null && var10.getSalaries().getSalDateNaissance() != null) {
                        var12 = (int)((double)((new Date()).getTime() - var10.getSalaries().getSalDateNaissance().getTime()) / 3.1556736E10D);
                     }

                     var4 = this.calculAge(var12);
                  } else if (this.modeGraph == 2) {
                     if (var10.getBulsalGenre() == 0) {
                        var4 = "Femme";
                     } else {
                        var4 = "Homme";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var10.getBulsalService() != null && !var10.getBulsalService().isEmpty()) {
                        var4 = var10.getBulsalService();
                     } else {
                        var4 = "Sans Service";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var10.getBulsalFonction() != null && !var10.getBulsalFonction().isEmpty()) {
                        var4 = var10.getBulsalFonction();
                     } else {
                        var4 = "Sans Fonction";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var10.getBulsalNature() != null && !var10.getBulsalNature().isEmpty()) {
                        var4 = var10.getBulsalNature() + ":" + var10.getSalaries().getLib_nature();
                     } else {
                        var4 = "Sans Type de contrat";
                     }
                  } else if (this.modeGraph == 6) {
                     var4 = this.calculModePaiment(var10.getBulsalModeReglement());
                  } else if (this.modeGraph != 7 && this.modeGraph != 8) {
                     if (this.modeGraph == 9) {
                        if (var10.getSalaries().getSalNompays() != null && !var10.getSalaries().getSalNompays().isEmpty()) {
                           var4 = var10.getSalaries().getSalNompays();
                        } else {
                           var4 = "Sans Pays";
                        }
                     } else if (this.modeGraph == 10) {
                        if (var10.getSalaries().getSalNationnalite() != null && !var10.getSalaries().getSalNationnalite().isEmpty()) {
                           var4 = var10.getSalaries().getSalNationnalite();
                        } else {
                           var4 = "Sans Nationalité";
                        }
                     } else if (this.modeGraph == 11) {
                        if (var10.getBulsalFeuille() != null && !var10.getBulsalFeuille().isEmpty()) {
                           var4 = var10.getBulsalFeuille();
                        } else {
                           var4 = "Sans Feuille";
                        }
                     } else if (this.modeGraph == 12) {
                        if (var10.getBulsalIdTiers() != 0L) {
                           var4 = "" + var10.getBulsalIdTiers();
                        } else {
                           var4 = "Sans Tiers";
                        }
                     } else if (this.modeGraph == 13) {
                        if (var10.getBulsalClassement() != null && !var10.getBulsalClassement().isEmpty()) {
                           var4 = var10.getBulsalClassement();
                        } else {
                           var4 = "Sans Classement";
                        }
                     } else if (this.modeGraph == 14) {
                        if (var10.getBulsalNivEmploi() != null && !var10.getBulsalNivEmploi().isEmpty()) {
                           var4 = var10.getBulsalNivEmploi();
                        } else {
                           var4 = "Sans Niveau";
                        }
                     }
                  }

                  ++var5;
                  if (this.timeDecoupage != 0) {
                     if (this.timeDecoupage == 1) {
                        var13 = var10.getBulsalDateFin().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var10.getBulsalDateFin().getMonth() + 1 >= 1 && var10.getBulsalDateFin().getMonth() + 1 <= 3) {
                           var13 = 1;
                        } else if (var10.getBulsalDateFin().getMonth() + 1 >= 4 && var10.getBulsalDateFin().getMonth() + 1 <= 6) {
                           var13 = 2;
                        } else if (var10.getBulsalDateFin().getMonth() + 1 >= 7 && var10.getBulsalDateFin().getMonth() + 1 <= 9) {
                           var13 = 3;
                        } else if (var10.getBulsalDateFin().getMonth() + 1 >= 10 && var10.getBulsalDateFin().getMonth() + 1 <= 12) {
                           var13 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var10.getBulsalDateFin().getMonth() + 1 >= 1 && var10.getBulsalDateFin().getMonth() + 1 <= 6) {
                           var13 = 1;
                        } else if (var10.getBulsalDateFin().getMonth() + 1 >= 7 && var10.getBulsalDateFin().getMonth() + 1 <= 12) {
                           var13 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var13 = 1;
                     }
                  }

                  var1 = this.calculeListe((List)var1, var4, var13, var5);
                  ++var11;
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModele = true;
      return (List)var1;
   }

   public String calculAge(int var1) {
      String var2 = "";
      if (var1 >= 1 && var1 < 18) {
         var2 = "-18";
      } else if (var1 >= 18 && var1 < 20) {
         var2 = "de 18 a 20";
      } else if (var1 >= 20 && var1 < 25) {
         var2 = "de 20 a 25";
      } else if (var1 >= 25 && var1 < 30) {
         var2 = "de 25 a 30";
      } else if (var1 >= 30 && var1 < 35) {
         var2 = "de 30 a 35";
      } else if (var1 >= 35 && var1 < 40) {
         var2 = "de 35 a 40";
      } else if (var1 >= 40 && var1 < 45) {
         var2 = "de 40 a 45";
      } else if (var1 >= 45 && var1 < 50) {
         var2 = "de 45 a 50";
      } else if (var1 >= 50 && var1 < 55) {
         var2 = "de 50 a 55";
      } else if (var1 >= 55 && var1 < 60) {
         var2 = "de 55 a 60";
      } else if (var1 >= 60 && var1 < 65) {
         var2 = "de 60 a 65";
      } else if (var1 >= 65) {
         var2 = "+65";
      } else {
         var2 = "Sans age";
      }

      return var2;
   }

   public String calculModePaiment(int var1) {
      String var2 = "";
      if (var1 == 0) {
         var2 = "Especes";
      } else if (var1 == 1) {
         var2 = "Cheques";
      } else if (var1 == 2) {
         var2 = "Virement";
      } else if (var1 == 3) {
         var2 = "Bicitel";
      } else if (var1 == 4) {
         var2 = "Ferlo";
      } else if (var1 == 5) {
         var2 = "Autres";
      } else {
         var2 = "Sans Mode de paiement";
      }

      return var2;
   }

   public String calculActviteRoster(Salaries var1) {
      String var2 = "";
      if (var1.isSalDomAct1()) {
         var2 = "Communications";
      } else if (var1.isSalDomAct2()) {
         var2 = "Democratic Governance";
      } else if (var1.isSalDomAct3()) {
         var2 = "Disaster Risk Reduction";
      } else if (var1.isSalDomAct4()) {
         var2 = "EVAW/GBV";
      } else if (var1.isSalDomAct5()) {
         var2 = "Extractives";
      } else if (var1.isSalDomAct6()) {
         var2 = "Facilitation/Moderation";
      } else if (var1.isSalDomAct7()) {
         var2 = "Gender & Development";
      } else if (var1.isSalDomAct8()) {
         var2 = "Gender Responsive Budgeting";
      } else if (var1.isSalDomAct9()) {
         var2 = "Governance & Leadership";
      } else if (var1.isSalDomAct10()) {
         var2 = "Graphics";
      } else if (var1.isSalDomAct11()) {
         var2 = "HIV/AIDS";
      } else if (var1.isSalDomAct12()) {
         var2 = "Human Rights";
      } else if (var1.isSalDomAct13()) {
         var2 = "Humanitarian";
      } else if (var1.isSalDomAct14()) {
         var2 = "ICT";
      } else if (var1.isSalDomAct15()) {
         var2 = "Knowledge Management";
      } else if (var1.isSalDomAct16()) {
         var2 = "Monitoring & Evaluation";
      } else if (var1.isSalDomAct17()) {
         var2 = "Nutrition  specialist";
      } else if (var1.isSalDomAct18()) {
         var2 = "Operations";
      } else if (var1.isSalDomAct19()) {
         var2 = "Organizational Development";
      } else if (var1.isSalDomAct20()) {
         var2 = "Peace & Security";
      } else if (var1.isSalDomAct21()) {
         var2 = "Programme Management";
      } else if (var1.isSalDomAct22()) {
         var2 = "Rapporteur";
      } else if (var1.isSalDomAct23()) {
         var2 = "Resource Mobilization";
      } else if (var1.isSalDomAct24()) {
         var2 = "Rule of law and gender";
      } else if (var1.isSalDomAct25()) {
         var2 = "Strategic planning";
      } else if (var1.isSalDomAct26()) {
         var2 = "Translator/Interpreter";
      } else if (var1.isSalDomAct27()) {
         var2 = "Women Economic Empowerment";
      } else if (var1.isSalDomAct28()) {
         var2 = "";
      } else if (var1.isSalDomAct29()) {
         var2 = "";
      } else if (var1.isSalDomAct30()) {
         var2 = "";
      } else {
         var2 = "Sans activité";
      }

      return var2;
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
            var8.setV13(var8.getV13() + var4);
         } else if (var3 == 14) {
            var8.setV14(var8.getV14() + var4);
         } else if (var3 == 15) {
            var8.setV15(var8.getV15() + var4);
         } else if (var3 == 16) {
            var8.setV16(var8.getV16() + var4);
         } else if (var3 == 17) {
            var8.setV17(var8.getV17() + var4);
         } else if (var3 == 18) {
            var8.setV18(var8.getV18() + var4);
         } else if (var3 == 19) {
            var8.setV19(var8.getV19() + var4);
         } else if (var3 == 20) {
            var8.setV20(var8.getV20() + var4);
         } else if (var3 == 21) {
            var8.setV21(var8.getV21() + var4);
         } else if (var3 == 22) {
            var8.setV22(var8.getV22() + var4);
         } else if (var3 == 23) {
            var8.setV23(var8.getV23() + var4);
         } else if (var3 == 24) {
            var8.setV24(var8.getV24() + var4);
         } else if (var3 == 25) {
            var8.setV25(var8.getV25() + var4);
         } else if (var3 == 26) {
            var8.setV26(var8.getV26() + var4);
         } else if (var3 == 27) {
            var8.setV27(var8.getV27() + var4);
         } else if (var3 == 28) {
            var8.setV28(var8.getV28() + var4);
         } else if (var3 == 29) {
            var8.setV29(var8.getV29() + var4);
         } else if (var3 == 30) {
            var8.setV30(var8.getV30() + var4);
         } else if (var3 == 31) {
            var8.setV31(var8.getV31() + var4);
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

   public int getVar_modele() {
      return this.var_modele;
   }

   public void setVar_modele(int var1) {
      this.var_modele = var1;
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

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public boolean isVar_acc_contrat() {
      return this.var_acc_contrat;
   }

   public void setVar_acc_contrat(boolean var1) {
      this.var_acc_contrat = var1;
   }

   public boolean isVar_acc_grh() {
      return this.var_acc_grh;
   }

   public void setVar_acc_grh(boolean var1) {
      this.var_acc_grh = var1;
   }

   public boolean isVar_acc_absences() {
      return this.var_acc_absences;
   }

   public void setVar_acc_absences(boolean var1) {
      this.var_acc_absences = var1;
   }

   public boolean isVar_acc_bulletins() {
      return this.var_acc_bulletins;
   }

   public void setVar_acc_bulletins(boolean var1) {
      this.var_acc_bulletins = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_conges() {
      return this.var_acc_conges;
   }

   public void setVar_acc_conges(boolean var1) {
      this.var_acc_conges = var1;
   }

   public boolean isVar_acc_familial() {
      return this.var_acc_familial;
   }

   public void setVar_acc_familial(boolean var1) {
      this.var_acc_familial = var1;
   }

   public boolean isVar_acc_historiques() {
      return this.var_acc_historiques;
   }

   public void setVar_acc_historiques(boolean var1) {
      this.var_acc_historiques = var1;
   }

   public boolean isVar_acc_identification() {
      return this.var_acc_identification;
   }

   public void setVar_acc_identification(boolean var1) {
      this.var_acc_identification = var1;
   }

   public boolean isVar_acc_prets() {
      return this.var_acc_prets;
   }

   public void setVar_acc_prets(boolean var1) {
      this.var_acc_prets = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public String getVar_nature_rec() {
      return this.var_nature_rec;
   }

   public void setVar_nature_rec(String var1) {
      this.var_nature_rec = var1;
   }

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public DataModel getDatamodelSalaries() {
      return this.datamodelSalaries;
   }

   public void setDatamodelSalaries(DataModel var1) {
      this.datamodelSalaries = var1;
   }

   public List getLesSalaries() {
      return this.lesSalaries;
   }

   public void setLesSalaries(List var1) {
      this.lesSalaries = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public String getVar_convention_rec() {
      return this.var_convention_rec;
   }

   public void setVar_convention_rec(String var1) {
      this.var_convention_rec = var1;
   }

   public String getVar_departement_rec() {
      return this.var_departement_rec;
   }

   public void setVar_departement_rec(String var1) {
      this.var_departement_rec = var1;
   }

   public String getVar_feuille_rec() {
      return this.var_feuille_rec;
   }

   public void setVar_feuille_rec(String var1) {
      this.var_feuille_rec = var1;
   }

   public String getVar_immat_rec() {
      return this.var_immat_rec;
   }

   public void setVar_immat_rec(String var1) {
      this.var_immat_rec = var1;
   }

   public String getVar_site_rec() {
      return this.var_site_rec;
   }

   public void setVar_site_rec(String var1) {
      this.var_site_rec = var1;
   }

   public List getMesCentresImpotsItems() {
      return this.mesCentresImpotsItems;
   }

   public void setMesCentresImpotsItems(List var1) {
      this.mesCentresImpotsItems = var1;
   }

   public List getMesClassementsItems() {
      return this.mesClassementsItems;
   }

   public void setMesClassementsItems(List var1) {
      this.mesClassementsItems = var1;
   }

   public List getMesNiveauxEmploisItems() {
      return this.mesNiveauxEmploisItems;
   }

   public void setMesNiveauxEmploisItems(List var1) {
      this.mesNiveauxEmploisItems = var1;
   }

   public String getUrlphotoAgent() {
      return this.urlphotoAgent;
   }

   public void setUrlphotoAgent(String var1) {
      this.urlphotoAgent = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public ExercicesPaye getLastExoPaye() {
      return this.lastExoPaye;
   }

   public void setLastExoPaye(ExercicesPaye var1) {
      this.lastExoPaye = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public List getMesConventionsItems() {
      return this.mesConventionsItems;
   }

   public void setMesConventionsItems(List var1) {
      this.mesConventionsItems = var1;
   }

   public List getMesGrillesItems() {
      return this.mesGrillesItems;
   }

   public void setMesGrillesItems(List var1) {
      this.mesGrillesItems = var1;
   }

   public List getMesNatureAgentItems() {
      return this.mesNatureAgentItems;
   }

   public void setMesNatureAgentItems(List var1) {
      this.mesNatureAgentItems = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public String getVar_nom_rec() {
      return this.var_nom_rec;
   }

   public void setVar_nom_rec(String var1) {
      this.var_nom_rec = var1;
   }

   public String getVar_classement_rec() {
      return this.var_classement_rec;
   }

   public void setVar_classement_rec(String var1) {
      this.var_classement_rec = var1;
   }

   public String getVar_grille_rec() {
      return this.var_grille_rec;
   }

   public void setVar_grille_rec(String var1) {
      this.var_grille_rec = var1;
   }

   public String getVar_niveau_rec() {
      return this.var_niveau_rec;
   }

   public void setVar_niveau_rec(String var1) {
      this.var_niveau_rec = var1;
   }

   public String getVar_centre_rec() {
      return this.var_centre_rec;
   }

   public void setVar_centre_rec(String var1) {
      this.var_centre_rec = var1;
   }

   public List getMesCiviliteItems() {
      return this.mesCiviliteItems;
   }

   public void setMesCiviliteItems(List var1) {
      this.mesCiviliteItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public List getMesLanguesItems() {
      return this.mesLanguesItems;
   }

   public void setMesLanguesItems(List var1) {
      this.mesLanguesItems = var1;
   }

   public List getMesNationnalitesItems() {
      return this.mesNationnalitesItems;
   }

   public void setMesNationnalitesItems(List var1) {
      this.mesNationnalitesItems = var1;
   }

   public List getLesPays() {
      return this.lesPays;
   }

   public void setLesPays(List var1) {
      this.lesPays = var1;
   }

   public List getLesCivilites() {
      return this.lesCivilites;
   }

   public void setLesCivilites(List var1) {
      this.lesCivilites = var1;
   }

   public boolean isVar_affiche_nomJf() {
      return this.var_affiche_nomJf;
   }

   public void setVar_affiche_nomJf(boolean var1) {
      this.var_affiche_nomJf = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public DataModel getDataModelContrat() {
      return this.dataModelContrat;
   }

   public void setDataModelContrat(DataModel var1) {
      this.dataModelContrat = var1;
   }

   public List getLesSalariesContrats() {
      return this.lesSalariesContrats;
   }

   public void setLesSalariesContrats(List var1) {
      this.lesSalariesContrats = var1;
   }

   public SalariesContrats getSalariesContrats() {
      return this.salariesContrats;
   }

   public void setSalariesContrats(SalariesContrats var1) {
      this.salariesContrats = var1;
   }

   public boolean isVar_affiche_contrat() {
      return this.var_affiche_contrat;
   }

   public void setVar_affiche_contrat(boolean var1) {
      this.var_affiche_contrat = var1;
   }

   public boolean isShowModalPanelContrat() {
      return this.showModalPanelContrat;
   }

   public void setShowModalPanelContrat(boolean var1) {
      this.showModalPanelContrat = var1;
   }

   public int getVar_action_contrat() {
      return this.var_action_contrat;
   }

   public void setVar_action_contrat(int var1) {
      this.var_action_contrat = var1;
   }

   public int getVar_ligne_contrat() {
      return this.var_ligne_contrat;
   }

   public void setVar_ligne_contrat(int var1) {
      this.var_ligne_contrat = var1;
   }

   public String getVar_centre() {
      return this.var_centre;
   }

   public void setVar_centre(String var1) {
      this.var_centre = var1;
   }

   public String getVar_classement() {
      return this.var_classement;
   }

   public void setVar_classement(String var1) {
      this.var_classement = var1;
   }

   public String getVar_convention() {
      return this.var_convention;
   }

   public void setVar_convention(String var1) {
      this.var_convention = var1;
   }

   public String getVar_departement() {
      return this.var_departement;
   }

   public void setVar_departement(String var1) {
      this.var_departement = var1;
   }

   public String getVar_feuille() {
      return this.var_feuille;
   }

   public void setVar_feuille(String var1) {
      this.var_feuille = var1;
   }

   public String getVar_grille() {
      return this.var_grille;
   }

   public void setVar_grille(String var1) {
      this.var_grille = var1;
   }

   public String getVar_niveau() {
      return this.var_niveau;
   }

   public void setVar_niveau(String var1) {
      this.var_niveau = var1;
   }

   public String getVar_service() {
      return this.var_service;
   }

   public void setVar_service(String var1) {
      this.var_service = var1;
   }

   public String getVar_site() {
      return this.var_site;
   }

   public void setVar_site(String var1) {
      this.var_site = var1;
   }

   public List getMesActiviteItems() {
      return this.mesActiviteItems;
   }

   public void setMesActiviteItems(List var1) {
      this.mesActiviteItems = var1;
   }

   public List getMesBudgetItems() {
      return this.mesBudgetItems;
   }

   public void setMesBudgetItems(List var1) {
      this.mesBudgetItems = var1;
   }

   public List getMesParcItems() {
      return this.mesParcItems;
   }

   public void setMesParcItems(List var1) {
      this.mesParcItems = var1;
   }

   public String getVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(String var1) {
      this.var_activite = var1;
   }

   public String getVar_budget() {
      return this.var_budget;
   }

   public void setVar_budget(String var1) {
      this.var_budget = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }

   public String getVar_code_modele() {
      return this.var_code_modele;
   }

   public void setVar_code_modele(String var1) {
      this.var_code_modele = var1;
   }

   public DataModel getDataModelGrh() {
      return this.dataModelGrh;
   }

   public void setDataModelGrh(DataModel var1) {
      this.dataModelGrh = var1;
   }

   public List getLesSalariesGrh() {
      return this.lesSalariesGrh;
   }

   public void setLesSalariesGrh(List var1) {
      this.lesSalariesGrh = var1;
   }

   public List getMesElementRhItems() {
      return this.mesElementRhItems;
   }

   public void setMesElementRhItems(List var1) {
      this.mesElementRhItems = var1;
   }

   public SalariesGrh getSalariesGrh() {
      return this.salariesGrh;
   }

   public void setSalariesGrh(SalariesGrh var1) {
      this.salariesGrh = var1;
   }

   public boolean isShowModalPanelRh() {
      return this.showModalPanelRh;
   }

   public void setShowModalPanelRh(boolean var1) {
      this.showModalPanelRh = var1;
   }

   public UtilTdt getUtilTdt() {
      return this.utilTdt;
   }

   public void setUtilTdt(UtilTdt var1) {
      this.utilTdt = var1;
   }

   public int getVar_action_rh() {
      return this.var_action_rh;
   }

   public void setVar_action_rh(int var1) {
      this.var_action_rh = var1;
   }

   public boolean isVar_affiche_rh() {
      return this.var_affiche_rh;
   }

   public void setVar_affiche_rh(boolean var1) {
      this.var_affiche_rh = var1;
   }

   public String getVar_objet_automatique() {
      return this.var_objet_automatique;
   }

   public void setVar_objet_automatique(String var1) {
      this.var_objet_automatique = var1;
   }

   public boolean isVar_affiche_tdt_rh() {
      return this.var_affiche_tdt_rh;
   }

   public void setVar_affiche_tdt_rh(boolean var1) {
      this.var_affiche_tdt_rh = var1;
   }

   public DataModel getDataModelConges() {
      return this.dataModelConges;
   }

   public void setDataModelConges(DataModel var1) {
      this.dataModelConges = var1;
   }

   public List getLesSalariesConges() {
      return this.lesSalariesConges;
   }

   public void setLesSalariesConges(List var1) {
      this.lesSalariesConges = var1;
   }

   public SalariesConges getSalariesConges() {
      return this.salariesConges;
   }

   public void setSalariesConges(SalariesConges var1) {
      this.salariesConges = var1;
   }

   public DataModel getDataModelPretsExternes() {
      return this.dataModelPretsExternes;
   }

   public void setDataModelPretsExternes(DataModel var1) {
      this.dataModelPretsExternes = var1;
   }

   public DataModel getDataModelPretsInternes() {
      return this.dataModelPretsInternes;
   }

   public void setDataModelPretsInternes(DataModel var1) {
      this.dataModelPretsInternes = var1;
   }

   public List getLesSalariesPretsExternes() {
      return this.lesSalariesPretsExternes;
   }

   public void setLesSalariesPretsExternes(List var1) {
      this.lesSalariesPretsExternes = var1;
   }

   public List getLesSalariesPretsInternes() {
      return this.lesSalariesPretsInternes;
   }

   public void setLesSalariesPretsInternes(List var1) {
      this.lesSalariesPretsInternes = var1;
   }

   public SalariesPrets getSalariesPrets() {
      return this.salariesPrets;
   }

   public void setSalariesPrets(SalariesPrets var1) {
      this.salariesPrets = var1;
   }

   public boolean isVar_affiche_prets() {
      return this.var_affiche_prets;
   }

   public void setVar_affiche_prets(boolean var1) {
      this.var_affiche_prets = var1;
   }

   public DataModel getDataModelPretsLignes() {
      return this.dataModelPretsLignes;
   }

   public void setDataModelPretsLignes(DataModel var1) {
      this.dataModelPretsLignes = var1;
   }

   public List getLesSalariesPretsLignes() {
      return this.lesSalariesPretsLignes;
   }

   public void setLesSalariesPretsLignes(List var1) {
      this.lesSalariesPretsLignes = var1;
   }

   public SalariesPretsLignes getSalariesPretsLignes() {
      return this.salariesPretsLignes;
   }

   public void setSalariesPretsLignes(SalariesPretsLignes var1) {
      this.salariesPretsLignes = var1;
   }

   public boolean isVar_affiche_lignes() {
      return this.var_affiche_lignes;
   }

   public void setVar_affiche_lignes(boolean var1) {
      this.var_affiche_lignes = var1;
   }

   public DataModel getDataModelPretsManuels() {
      return this.dataModelPretsManuels;
   }

   public void setDataModelPretsManuels(DataModel var1) {
      this.dataModelPretsManuels = var1;
   }

   public List getLesSalariesPretsManuels() {
      return this.lesSalariesPretsManuels;
   }

   public void setLesSalariesPretsManuels(List var1) {
      this.lesSalariesPretsManuels = var1;
   }

   public DataModel getDataModelAbsences() {
      return this.dataModelAbsences;
   }

   public void setDataModelAbsences(DataModel var1) {
      this.dataModelAbsences = var1;
   }

   public List getLesSalariesAbsences() {
      return this.lesSalariesAbsences;
   }

   public void setLesSalariesAbsences(List var1) {
      this.lesSalariesAbsences = var1;
   }

   public SalariesConges getSalariesAbsences() {
      return this.salariesAbsences;
   }

   public void setSalariesAbsences(SalariesConges var1) {
      this.salariesAbsences = var1;
   }

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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

   public int getVar_etat_rec() {
      return this.var_etat_rec;
   }

   public void setVar_etat_rec(int var1) {
      this.var_etat_rec = var1;
   }

   public boolean isShowModalVisuEtat() {
      return this.showModalVisuEtat;
   }

   public void setShowModalVisuEtat(boolean var1) {
      this.showModalVisuEtat = var1;
   }

   public String getVar_activite_rec() {
      return this.var_activite_rec;
   }

   public void setVar_activite_rec(String var1) {
      this.var_activite_rec = var1;
   }

   public double getSolde_pret_externe() {
      return this.solde_pret_externe;
   }

   public void setSolde_pret_externe(double var1) {
      this.solde_pret_externe = var1;
   }

   public double getSolde_pret_interne() {
      return this.solde_pret_interne;
   }

   public void setSolde_pret_interne(double var1) {
      this.solde_pret_interne = var1;
   }

   public double getSolde_pret_manuel() {
      return this.solde_pret_manuel;
   }

   public void setSolde_pret_manuel(double var1) {
      this.solde_pret_manuel = var1;
   }

   public double getTotal_pret_externe() {
      return this.total_pret_externe;
   }

   public void setTotal_pret_externe(double var1) {
      this.total_pret_externe = var1;
   }

   public double getTotal_pret_interne() {
      return this.total_pret_interne;
   }

   public void setTotal_pret_interne(double var1) {
      this.total_pret_interne = var1;
   }

   public double getTotal_pret_manuel() {
      return this.total_pret_manuel;
   }

   public void setTotal_pret_manuel(double var1) {
      this.total_pret_manuel = var1;
   }

   public double getTotal_rmb_externe() {
      return this.total_rmb_externe;
   }

   public void setTotal_rmb_externe(double var1) {
      this.total_rmb_externe = var1;
   }

   public double getTotal_rmb_interne() {
      return this.total_rmb_interne;
   }

   public void setTotal_rmb_interne(double var1) {
      this.total_rmb_interne = var1;
   }

   public double getTotal_rmb_manuel() {
      return this.total_rmb_manuel;
   }

   public void setTotal_rmb_manuel(double var1) {
      this.total_rmb_manuel = var1;
   }

   public List getMesFeuillesItems() {
      return this.mesFeuillesItems;
   }

   public void setMesFeuillesItems(List var1) {
      this.mesFeuillesItems = var1;
   }

   public String getVar_periode() {
      return this.var_periode;
   }

   public void setVar_periode(String var1) {
      this.var_periode = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public String getVar_cle1() {
      return this.var_cle1;
   }

   public void setVar_cle1(String var1) {
      this.var_cle1 = var1;
   }

   public String getVar_cle2() {
      return this.var_cle2;
   }

   public void setVar_cle2(String var1) {
      this.var_cle2 = var1;
   }

   public FormBakingBeanPaye getFormBakingBeanPaye() {
      return this.formBakingBeanPaye;
   }

   public void setFormBakingBeanPaye(FormBakingBeanPaye var1) {
      this.formBakingBeanPaye = var1;
   }

   public UsersChrono getUsersChronoPret() {
      return this.usersChronoPret;
   }

   public void setUsersChronoPret(UsersChrono var1) {
      this.usersChronoPret = var1;
   }

   public UsersChrono getUsersChronoAbsence() {
      return this.usersChronoAbsence;
   }

   public void setUsersChronoAbsence(UsersChrono var1) {
      this.usersChronoAbsence = var1;
   }

   public UsersChrono getUsersChronoConge() {
      return this.usersChronoConge;
   }

   public void setUsersChronoConge(UsersChrono var1) {
      this.usersChronoConge = var1;
   }

   public UsersChrono getUsersChronoContrat() {
      return this.usersChronoContrat;
   }

   public void setUsersChronoContrat(UsersChrono var1) {
      this.usersChronoContrat = var1;
   }

   public boolean isAfficheTexteContrat() {
      return this.afficheTexteContrat;
   }

   public void setAfficheTexteContrat(boolean var1) {
      this.afficheTexteContrat = var1;
   }

   public int getVar_rh_rec() {
      return this.var_rh_rec;
   }

   public void setVar_rh_rec(int var1) {
      this.var_rh_rec = var1;
   }

   public String getVar_lib_rh() {
      return this.var_lib_rh;
   }

   public void setVar_lib_rh(String var1) {
      this.var_lib_rh = var1;
   }

   public String getNomSalarie() {
      return this.nomSalarie;
   }

   public void setNomSalarie(String var1) {
      this.nomSalarie = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isAccesPrets() {
      return this.accesPrets;
   }

   public void setAccesPrets(boolean var1) {
      this.accesPrets = var1;
   }

   public boolean isAccesAbsences() {
      return this.accesAbsences;
   }

   public void setAccesAbsences(boolean var1) {
      this.accesAbsences = var1;
   }

   public boolean isAccesConges() {
      return this.accesConges;
   }

   public void setAccesConges(boolean var1) {
      this.accesConges = var1;
   }

   public boolean isAccesContrats() {
      return this.accesContrats;
   }

   public void setAccesContrats(boolean var1) {
      this.accesContrats = var1;
   }

   public boolean isAccesMissions() {
      return this.accesMissions;
   }

   public void setAccesMissions(boolean var1) {
      this.accesMissions = var1;
   }

   public boolean isAccesBulletins() {
      return this.accesBulletins;
   }

   public void setAccesBulletins(boolean var1) {
      this.accesBulletins = var1;
   }

   public int getVar_pret_rec() {
      return this.var_pret_rec;
   }

   public void setVar_pret_rec(int var1) {
      this.var_pret_rec = var1;
   }

   public String getVar_lib_pret() {
      return this.var_lib_pret;
   }

   public void setVar_lib_pret(String var1) {
      this.var_lib_pret = var1;
   }

   public int getVar_nat_rec() {
      return this.var_nat_rec;
   }

   public void setVar_nat_rec(int var1) {
      this.var_nat_rec = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public boolean isVar_affFicPdf() {
      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public boolean isShowModalPanelPdf() {
      return this.showModalPanelPdf;
   }

   public void setShowModalPanelPdf(boolean var1) {
      this.showModalPanelPdf = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getVar_lib_contrat() {
      return this.var_lib_contrat;
   }

   public void setVar_lib_contrat(String var1) {
      this.var_lib_contrat = var1;
   }

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLaColonne1Items() {
      return this.laColonne1Items;
   }

   public void setLaColonne1Items(List var1) {
      this.laColonne1Items = var1;
   }

   public List getLaColonne2Items() {
      return this.laColonne2Items;
   }

   public void setLaColonne2Items(List var1) {
      this.laColonne2Items = var1;
   }

   public List getLaColonne3Items() {
      return this.laColonne3Items;
   }

   public void setLaColonne3Items(List var1) {
      this.laColonne3Items = var1;
   }

   public String getVar_colonne1() {
      return this.var_colonne1;
   }

   public void setVar_colonne1(String var1) {
      this.var_colonne1 = var1;
   }

   public String getVar_colonne2() {
      return this.var_colonne2;
   }

   public void setVar_colonne2(String var1) {
      this.var_colonne2 = var1;
   }

   public String getVar_colonne3() {
      return this.var_colonne3;
   }

   public void setVar_colonne3(String var1) {
      this.var_colonne3 = var1;
   }

   public List getMesProjetItems() {
      return this.mesProjetItems;
   }

   public void setMesProjetItems(List var1) {
      this.mesProjetItems = var1;
   }

   public String getVar_projet() {
      return this.var_projet;
   }

   public void setVar_projet(String var1) {
      this.var_projet = var1;
   }

   public String getVar_projet_rec() {
      return this.var_projet_rec;
   }

   public void setVar_projet_rec(String var1) {
      this.var_projet_rec = var1;
   }

   public String getVar_pays_rec() {
      return this.var_pays_rec;
   }

   public void setVar_pays_rec(String var1) {
      this.var_pays_rec = var1;
   }

   public List getMesPaysUtilItems() {
      return this.mesPaysUtilItems;
   }

   public void setMesPaysUtilItems(List var1) {
      this.mesPaysUtilItems = var1;
   }

   public SalariesContrats getSalariesContratsMuter() {
      return this.salariesContratsMuter;
   }

   public void setSalariesContratsMuter(SalariesContrats var1) {
      this.salariesContratsMuter = var1;
   }

   public String getVar_activiteMuter() {
      return this.var_activiteMuter;
   }

   public void setVar_activiteMuter(String var1) {
      this.var_activiteMuter = var1;
   }

   public String getVar_budgetMuter() {
      return this.var_budgetMuter;
   }

   public void setVar_budgetMuter(String var1) {
      this.var_budgetMuter = var1;
   }

   public String getVar_centreMuter() {
      return this.var_centreMuter;
   }

   public void setVar_centreMuter(String var1) {
      this.var_centreMuter = var1;
   }

   public String getVar_classementMuter() {
      return this.var_classementMuter;
   }

   public void setVar_classementMuter(String var1) {
      this.var_classementMuter = var1;
   }

   public String getVar_cle1Muter() {
      return this.var_cle1Muter;
   }

   public void setVar_cle1Muter(String var1) {
      this.var_cle1Muter = var1;
   }

   public String getVar_cle2Muter() {
      return this.var_cle2Muter;
   }

   public void setVar_cle2Muter(String var1) {
      this.var_cle2Muter = var1;
   }

   public String getVar_conventionMuter() {
      return this.var_conventionMuter;
   }

   public void setVar_conventionMuter(String var1) {
      this.var_conventionMuter = var1;
   }

   public String getVar_departementMuter() {
      return this.var_departementMuter;
   }

   public void setVar_departementMuter(String var1) {
      this.var_departementMuter = var1;
   }

   public String getVar_grilleMuter() {
      return this.var_grilleMuter;
   }

   public void setVar_grilleMuter(String var1) {
      this.var_grilleMuter = var1;
   }

   public String getVar_niveauMuter() {
      return this.var_niveauMuter;
   }

   public void setVar_niveauMuter(String var1) {
      this.var_niveauMuter = var1;
   }

   public String getVar_projetMuter() {
      return this.var_projetMuter;
   }

   public void setVar_projetMuter(String var1) {
      this.var_projetMuter = var1;
   }

   public String getVar_serviceMuter() {
      return this.var_serviceMuter;
   }

   public void setVar_serviceMuter(String var1) {
      this.var_serviceMuter = var1;
   }

   public String getVar_siteMuter() {
      return this.var_siteMuter;
   }

   public void setVar_siteMuter(String var1) {
      this.var_siteMuter = var1;
   }

   public DataModel getDataModelDecoupageActivtesMuter() {
      return this.dataModelDecoupageActivtesMuter;
   }

   public void setDataModelDecoupageActivtesMuter(DataModel var1) {
      this.dataModelDecoupageActivtesMuter = var1;
   }

   public String getVar_code_modeleMuter() {
      return this.var_code_modeleMuter;
   }

   public void setVar_code_modeleMuter(String var1) {
      this.var_code_modeleMuter = var1;
   }

   public boolean isBulletinExiste() {
      return this.bulletinExiste;
   }

   public void setBulletinExiste(boolean var1) {
      this.bulletinExiste = var1;
   }

   public boolean isVar_avn_domesticite() {
      return this.var_avn_domesticite;
   }

   public void setVar_avn_domesticite(boolean var1) {
      this.var_avn_domesticite = var1;
   }

   public boolean isVar_avn_eau() {
      return this.var_avn_eau;
   }

   public void setVar_avn_eau(boolean var1) {
      this.var_avn_eau = var1;
   }

   public boolean isVar_avn_electricite() {
      return this.var_avn_electricite;
   }

   public void setVar_avn_electricite(boolean var1) {
      this.var_avn_electricite = var1;
   }

   public boolean isVar_avn_logement() {
      return this.var_avn_logement;
   }

   public void setVar_avn_logement(boolean var1) {
      this.var_avn_logement = var1;
   }

   public boolean isVar_avn_nourriture() {
      return this.var_avn_nourriture;
   }

   public void setVar_avn_nourriture(boolean var1) {
      this.var_avn_nourriture = var1;
   }

   public boolean isVar_avn_telephone() {
      return this.var_avn_telephone;
   }

   public void setVar_avn_telephone(boolean var1) {
      this.var_avn_telephone = var1;
   }

   public boolean isVar_avn_vehicule() {
      return this.var_avn_vehicule;
   }

   public void setVar_avn_vehicule(boolean var1) {
      this.var_avn_vehicule = var1;
   }

   public boolean isVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(boolean var1) {
      this.var_caisse = var1;
   }

   public boolean isVar_deplacement() {
      return this.var_deplacement;
   }

   public void setVar_deplacement(boolean var1) {
      this.var_deplacement = var1;
   }

   public boolean isVar_fonction() {
      return this.var_fonction;
   }

   public void setVar_fonction(boolean var1) {
      this.var_fonction = var1;
   }

   public boolean isVar_forfaitHeureSup() {
      return this.var_forfaitHeureSup;
   }

   public void setVar_forfaitHeureSup(boolean var1) {
      this.var_forfaitHeureSup = var1;
   }

   public boolean isVar_forfaitPrestataire() {
      return this.var_forfaitPrestataire;
   }

   public void setVar_forfaitPrestataire(boolean var1) {
      this.var_forfaitPrestataire = var1;
   }

   public boolean isVar_kilometre() {
      return this.var_kilometre;
   }

   public void setVar_kilometre(boolean var1) {
      this.var_kilometre = var1;
   }

   public boolean isVar_logement() {
      return this.var_logement;
   }

   public void setVar_logement(boolean var1) {
      this.var_logement = var1;
   }

   public boolean isVar_outillage() {
      return this.var_outillage;
   }

   public void setVar_outillage(boolean var1) {
      this.var_outillage = var1;
   }

   public boolean isVar_redement() {
      return this.var_redement;
   }

   public void setVar_redement(boolean var1) {
      this.var_redement = var1;
   }

   public boolean isVar_representation() {
      return this.var_representation;
   }

   public void setVar_representation(boolean var1) {
      this.var_representation = var1;
   }

   public boolean isVar_responsbilite() {
      return this.var_responsbilite;
   }

   public void setVar_responsbilite(boolean var1) {
      this.var_responsbilite = var1;
   }

   public boolean isVar_salissure() {
      return this.var_salissure;
   }

   public void setVar_salissure(boolean var1) {
      this.var_salissure = var1;
   }

   public boolean isVar_sujetion() {
      return this.var_sujetion;
   }

   public void setVar_sujetion(boolean var1) {
      this.var_sujetion = var1;
   }

   public boolean isVar_sursalaire() {
      return this.var_sursalaire;
   }

   public void setVar_sursalaire(boolean var1) {
      this.var_sursalaire = var1;
   }

   public boolean isVar_transport() {
      return this.var_transport;
   }

   public void setVar_transport(boolean var1) {
      this.var_transport = var1;
   }

   public List getMesFeuillesContratItems() {
      return this.mesFeuillesContratItems;
   }

   public void setMesFeuillesContratItems(List var1) {
      this.mesFeuillesContratItems = var1;
   }

   public DataModel getDataModelHistorique() {
      return this.dataModelHistorique;
   }

   public void setDataModelHistorique(DataModel var1) {
      this.dataModelHistorique = var1;
   }

   public SalariesHistorique getSalariesHistorique() {
      return this.salariesHistorique;
   }

   public void setSalariesHistorique(SalariesHistorique var1) {
      this.salariesHistorique = var1;
   }

   public boolean isShowModalPanelHistorique() {
      return this.showModalPanelHistorique;
   }

   public void setShowModalPanelHistorique(boolean var1) {
      this.showModalPanelHistorique = var1;
   }

   public int getVar_action_historique() {
      return this.var_action_historique;
   }

   public void setVar_action_historique(int var1) {
      this.var_action_historique = var1;
   }

   public boolean isVar_affiche_historique() {
      return this.var_affiche_historique;
   }

   public void setVar_affiche_historique(boolean var1) {
      this.var_affiche_historique = var1;
   }

   public List getLesContratsActifsItems() {
      return this.lesContratsActifsItems;
   }

   public void setLesContratsActifsItems(List var1) {
      this.lesContratsActifsItems = var1;
   }

   public float getNbAcquis() {
      return this.nbAcquis;
   }

   public void setNbAcquis(float var1) {
      this.nbAcquis = var1;
   }

   public float getNbInit() {
      return this.nbInit;
   }

   public void setNbInit(float var1) {
      this.nbInit = var1;
   }

   public float getNbPris() {
      return this.nbPris;
   }

   public void setNbPris(float var1) {
      this.nbPris = var1;
   }

   public float getNbRestant() {
      return this.nbRestant;
   }

   public void setNbRestant(float var1) {
      this.nbRestant = var1;
   }

   public boolean isVar_valide_historique() {
      return this.var_valide_historique;
   }

   public void setVar_valide_historique(boolean var1) {
      this.var_valide_historique = var1;
   }

   public DataModel getDataModelCapitalisation() {
      return this.dataModelCapitalisation;
   }

   public void setDataModelCapitalisation(DataModel var1) {
      this.dataModelCapitalisation = var1;
   }

   public SalariesCapitalisation getSalariesCapitalisation() {
      return this.salariesCapitalisation;
   }

   public void setSalariesCapitalisation(SalariesCapitalisation var1) {
      this.salariesCapitalisation = var1;
   }

   public double getSolde_capitalisation() {
      return this.solde_capitalisation;
   }

   public void setSolde_capitalisation(double var1) {
      this.solde_capitalisation = var1;
   }

   public double getTotal_retrait() {
      return this.total_retrait;
   }

   public void setTotal_retrait(double var1) {
      this.total_retrait = var1;
   }

   public double getTotal_versement() {
      return this.total_versement;
   }

   public void setTotal_versement(double var1) {
      this.total_versement = var1;
   }

   public boolean isShowModalPanelCapitalisation() {
      return this.showModalPanelCapitalisation;
   }

   public void setShowModalPanelCapitalisation(boolean var1) {
      this.showModalPanelCapitalisation = var1;
   }

   public boolean isCapitalisationActive() {
      return this.capitalisationActive;
   }

   public void setCapitalisationActive(boolean var1) {
      this.capitalisationActive = var1;
   }

   public int getTypePret() {
      return this.typePret;
   }

   public void setTypePret(int var1) {
      this.typePret = var1;
   }

   public boolean isVar_astreinte() {
      return this.var_astreinte;
   }

   public void setVar_astreinte(boolean var1) {
      this.var_astreinte = var1;
   }

   public boolean isShowModalPanelChangerMatricule() {
      return this.showModalPanelChangerMatricule;
   }

   public void setShowModalPanelChangerMatricule(boolean var1) {
      this.showModalPanelChangerMatricule = var1;
   }

   public String getVar_nouveau_matricule() {
      return this.var_nouveau_matricule;
   }

   public void setVar_nouveau_matricule(String var1) {
      this.var_nouveau_matricule = var1;
   }

   public boolean isVar_unicite() {
      return this.var_unicite;
   }

   public void setVar_unicite(boolean var1) {
      this.var_unicite = var1;
   }

   public String getLibelle_retraite() {
      return this.libelle_retraite;
   }

   public void setLibelle_retraite(String var1) {
      this.libelle_retraite = var1;
   }

   public String getLibelle_securite() {
      return this.libelle_securite;
   }

   public void setLibelle_securite(String var1) {
      this.libelle_securite = var1;
   }

   public Date getParMois() {
      return this.parMois;
   }

   public void setParMois(Date var1) {
      this.parMois = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isAccesInterim() {
      return this.accesInterim;
   }

   public void setAccesInterim(boolean var1) {
      this.accesInterim = var1;
   }

   public String getVar_budget_rec() {
      return this.var_budget_rec;
   }

   public void setVar_budget_rec(String var1) {
      this.var_budget_rec = var1;
   }

   public String getVar_tiers_rec() {
      return this.var_tiers_rec;
   }

   public void setVar_tiers_rec(String var1) {
      this.var_tiers_rec = var1;
   }

   public List getMesTiersItems() {
      return this.mesTiersItems;
   }

   public void setMesTiersItems(List var1) {
      this.mesTiersItems = var1;
   }

   public boolean isShowModalPanelImputation() {
      return this.showModalPanelImputation;
   }

   public void setShowModalPanelImputation(boolean var1) {
      this.showModalPanelImputation = var1;
   }

   public String getMessageSms() {
      return this.messageSms;
   }

   public void setMessageSms(String var1) {
      this.messageSms = var1;
   }

   public String getNumeroMobile() {
      return this.numeroMobile;
   }

   public void setNumeroMobile(String var1) {
      this.numeroMobile = var1;
   }

   public boolean isShowModalPanelSms() {
      return this.showModalPanelSms;
   }

   public void setShowModalPanelSms(boolean var1) {
      this.showModalPanelSms = var1;
   }

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
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

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
   }

   public boolean isAccesOrange() {
      return this.accesOrange;
   }

   public void setAccesOrange(boolean var1) {
      this.accesOrange = var1;
   }

   public boolean isValideSalarie() {
      return this.valideSalarie;
   }

   public void setValideSalarie(boolean var1) {
      this.valideSalarie = var1;
   }

   public DataModel getDataModelSimulationLigne() {
      return this.dataModelSimulationLigne;
   }

   public void setDataModelSimulationLigne(DataModel var1) {
      this.dataModelSimulationLigne = var1;
   }

   public boolean isNouvelleCreation() {
      return this.nouvelleCreation;
   }

   public void setNouvelleCreation(boolean var1) {
      this.nouvelleCreation = var1;
   }

   public boolean isShowModalPanelAvenant() {
      return this.showModalPanelAvenant;
   }

   public void setShowModalPanelAvenant(boolean var1) {
      this.showModalPanelAvenant = var1;
   }

   public int getNbAvenant() {
      return this.nbAvenant;
   }

   public void setNbAvenant(int var1) {
      this.nbAvenant = var1;
   }

   public boolean isAfficheAvenant() {
      return this.afficheAvenant;
   }

   public void setAfficheAvenant(boolean var1) {
      this.afficheAvenant = var1;
   }

   public List getMesLocalisationItems() {
      return this.mesLocalisationItems;
   }

   public void setMesLocalisationItems(List var1) {
      this.mesLocalisationItems = var1;
   }

   public String getVar_localisation() {
      return this.var_localisation;
   }

   public void setVar_localisation(String var1) {
      this.var_localisation = var1;
   }

   public String getVar_localisationMuter() {
      return this.var_localisationMuter;
   }

   public void setVar_localisationMuter(String var1) {
      this.var_localisationMuter = var1;
   }

   public String getVar_localisation_rec() {
      return this.var_localisation_rec;
   }

   public void setVar_localisation_rec(String var1) {
      this.var_localisation_rec = var1;
   }

   public boolean isVar_exceptionnel() {
      return this.var_exceptionnel;
   }

   public void setVar_exceptionnel(boolean var1) {
      this.var_exceptionnel = var1;
   }

   public boolean isAffiche_activite() {
      return this.affiche_activite;
   }

   public void setAffiche_activite(boolean var1) {
      this.affiche_activite = var1;
   }

   public boolean isAffiche_service() {
      return this.affiche_service;
   }

   public void setAffiche_service(boolean var1) {
      this.affiche_service = var1;
   }

   public String getVar_nature() {
      return this.var_nature;
   }

   public void setVar_nature(String var1) {
      this.var_nature = var1;
   }

   public UIDataTable getExtDTableCrt() {
      return this.extDTableCrt;
   }

   public void setExtDTableCrt(UIDataTable var1) {
      this.extDTableCrt = var1;
   }

   public UIDataTable getExtDTableSal() {
      return this.extDTableSal;
   }

   public void setExtDTableSal(UIDataTable var1) {
      this.extDTableSal = var1;
   }

   public SimpleSelection getSimpleSelectionEnteteCrt() {
      return this.simpleSelectionEnteteCrt;
   }

   public void setSimpleSelectionEnteteCrt(SimpleSelection var1) {
      this.simpleSelectionEnteteCrt = var1;
   }

   public SimpleSelection getSimpleSelectionEnteteSal() {
      return this.simpleSelectionEnteteSal;
   }

   public void setSimpleSelectionEnteteSal(SimpleSelection var1) {
      this.simpleSelectionEnteteSal = var1;
   }

   public UIDataTable getExtDTableGrh() {
      return this.extDTableGrh;
   }

   public void setExtDTableGrh(UIDataTable var1) {
      this.extDTableGrh = var1;
   }

   public SimpleSelection getSimpleSelectionEnteteGrh() {
      return this.simpleSelectionEnteteGrh;
   }

   public void setSimpleSelectionEnteteGrh(SimpleSelection var1) {
      this.simpleSelectionEnteteGrh = var1;
   }

   public int getVar_valide_rec() {
      return this.var_valide_rec;
   }

   public void setVar_valide_rec(int var1) {
      this.var_valide_rec = var1;
   }

   public boolean isAjoutRh() {
      return this.ajoutRh;
   }

   public void setAjoutRh(boolean var1) {
      this.ajoutRh = var1;
   }

   public boolean isAjoutCrt() {
      return this.ajoutCrt;
   }

   public void setAjoutCrt(boolean var1) {
      this.ajoutCrt = var1;
   }

   public boolean isVar_diverse() {
      return this.var_diverse;
   }

   public void setVar_diverse(boolean var1) {
      this.var_diverse = var1;
   }

   public boolean isVar_indemResons() {
      return this.var_indemResons;
   }

   public void setVar_indemResons(boolean var1) {
      this.var_indemResons = var1;
   }

   public boolean isVar_nourriture() {
      return this.var_nourriture;
   }

   public void setVar_nourriture(boolean var1) {
      this.var_nourriture = var1;
   }

   public long getVar_tiers() {
      return this.var_tiers;
   }

   public void setVar_tiers(long var1) {
      this.var_tiers = var1;
   }

   public String getVar_securite() {
      return this.var_securite;
   }

   public void setVar_securite(String var1) {
      this.var_securite = var1;
   }

   public String getVar_securite_rec() {
      return this.var_securite_rec;
   }

   public void setVar_securite_rec(String var1) {
      this.var_securite_rec = var1;
   }

   public List getMesCentresSecuritesItems() {
      return this.mesCentresSecuritesItems;
   }

   public void setMesCentresSecuritesItems(List var1) {
      this.mesCentresSecuritesItems = var1;
   }

   public boolean isAccesAutreProtege() {
      return this.accesAutreProtege;
   }

   public void setAccesAutreProtege(boolean var1) {
      this.accesAutreProtege = var1;
   }

   public boolean isAccesContratsProtege() {
      return this.accesContratsProtege;
   }

   public void setAccesContratsProtege(boolean var1) {
      this.accesContratsProtege = var1;
   }

   public boolean isAccesPretsProtege() {
      return this.accesPretsProtege;
   }

   public void setAccesPretsProtege(boolean var1) {
      this.accesPretsProtege = var1;
   }

   public boolean isAccesRhProtege() {
      return this.accesRhProtege;
   }

   public void setAccesRhProtege(boolean var1) {
      this.accesRhProtege = var1;
   }

   public String getNomCreation() {
      return this.nomCreation;
   }

   public void setNomCreation(String var1) {
      this.nomCreation = var1;
   }

   public String getNomModification() {
      return this.nomModification;
   }

   public void setNomModification(String var1) {
      this.nomModification = var1;
   }

   public boolean isShowModalPanelInformation() {
      return this.showModalPanelInformation;
   }

   public void setShowModalPanelInformation(boolean var1) {
      this.showModalPanelInformation = var1;
   }

   public List getMesTypeRhItems() {
      return this.mesTypeRhItems;
   }

   public void setMesTypeRhItems(List var1) {
      this.mesTypeRhItems = var1;
   }

   public int getVar_typerh_rec() {
      return this.var_typerh_rec;
   }

   public void setVar_typerh_rec(int var1) {
      this.var_typerh_rec = var1;
   }

   public String getVar_typelib_rh() {
      return this.var_typelib_rh;
   }

   public void setVar_typelib_rh(String var1) {
      this.var_typelib_rh = var1;
   }

   public boolean isVar_affFicPdfContrat() {
      return this.var_affFicPdfContrat;
   }

   public void setVar_affFicPdfContrat(boolean var1) {
      this.var_affFicPdfContrat = var1;
   }

   public boolean isVar_affFicPdfRh() {
      return this.var_affFicPdfRh;
   }

   public void setVar_affFicPdfRh(boolean var1) {
      this.var_affFicPdfRh = var1;
   }

   public List getMesTachesItems() {
      return this.mesTachesItems;
   }

   public void setMesTachesItems(List var1) {
      this.mesTachesItems = var1;
   }

   public boolean isShowModalPanelListeTache() {
      return this.showModalPanelListeTache;
   }

   public void setShowModalPanelListeTache(boolean var1) {
      this.showModalPanelListeTache = var1;
   }

   public boolean isShowModalPanelTache() {
      return this.showModalPanelTache;
   }

   public void setShowModalPanelTache(boolean var1) {
      this.showModalPanelTache = var1;
   }

   public SalariesTaches getSalariesTaches() {
      return this.salariesTaches;
   }

   public void setSalariesTaches(SalariesTaches var1) {
      this.salariesTaches = var1;
   }

   public DataModel getDataModelTachesAgents() {
      return this.dataModelTachesAgents;
   }

   public void setDataModelTachesAgents(DataModel var1) {
      this.dataModelTachesAgents = var1;
   }

   public boolean isSelectTache() {
      return this.selectTache;
   }

   public void setSelectTache(boolean var1) {
      this.selectTache = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public boolean isAffiche_departement() {
      return this.affiche_departement;
   }

   public void setAffiche_departement(boolean var1) {
      this.affiche_departement = var1;
   }

   public boolean isAffiche_site() {
      return this.affiche_site;
   }

   public void setAffiche_site(boolean var1) {
      this.affiche_site = var1;
   }

   public boolean isVar_prm_logement() {
      return this.var_prm_logement;
   }

   public void setVar_prm_logement(boolean var1) {
      this.var_prm_logement = var1;
   }

   public boolean isVar_prm_transport() {
      return this.var_prm_transport;
   }

   public void setVar_prm_transport(boolean var1) {
      this.var_prm_transport = var1;
   }

   public List getMesDepartementsImputationItems() {
      return this.mesDepartementsImputationItems;
   }

   public void setMesDepartementsImputationItems(List var1) {
      this.mesDepartementsImputationItems = var1;
   }

   public List getMesCodesEmploisItems() {
      return this.mesCodesEmploisItems;
   }

   public void setMesCodesEmploisItems(List var1) {
      this.mesCodesEmploisItems = var1;
   }

   public boolean isAfficheCodesEmplois() {
      return this.afficheCodesEmplois;
   }

   public void setAfficheCodesEmplois(boolean var1) {
      this.afficheCodesEmplois = var1;
   }

   public boolean isVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(boolean var1) {
      this.var_option_parc = var1;
   }

   public List getListeAvenantItems() {
      return this.listeAvenantItems;
   }

   public void setListeAvenantItems(List var1) {
      this.listeAvenantItems = var1;
   }

   public DataModel getDataModelAvenants() {
      return this.dataModelAvenants;
   }

   public void setDataModelAvenants(DataModel var1) {
      this.dataModelAvenants = var1;
   }

   public String getNomAvenant() {
      return this.nomAvenant;
   }

   public void setNomAvenant(String var1) {
      this.nomAvenant = var1;
   }

   public boolean isShowModalPanelAjoutAvenant() {
      return this.showModalPanelAjoutAvenant;
   }

   public void setShowModalPanelAjoutAvenant(boolean var1) {
      this.showModalPanelAjoutAvenant = var1;
   }

   public boolean isShowModalPanelPjAvenant() {
      return this.showModalPanelPjAvenant;
   }

   public void setShowModalPanelPjAvenant(boolean var1) {
      this.showModalPanelPjAvenant = var1;
   }
}
