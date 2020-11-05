package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.DouanesPosition;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanningAvicultureAchats;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.PumpAchats;
import com.epegase.systeme.classe.ReceptionAvicultureAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.ReceptionLotAchats;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DocumentTraceAchatsDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesAchatsDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanningAvicultureAchatsDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.PumpAchatsDao;
import com.epegase.systeme.dao.ReceptionAvicultureAchatsDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ReceptionLotAchatsDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
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
import org.xml.sax.SAXException;

public class FormReceptionAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private String urlphotoProd;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private int var_option_parc;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private ExercicesComptable lastExoCompta;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_nb_max = 100;
   private int modeReception;
   private String libelleModeReception;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private String nomTier;
   private List lesFamilleFournisseursListe;
   private List lesModeReglementFournisseurListe;
   private String informationsTiers;
   private Users responsable;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private List lesUsers = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private Contacts contacts;
   private String libelleDossier;
   private String libelleDossierFiche;
   private PlansAnalytiques dossier = new PlansAnalytiques();
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private ReceptionEnteteAchats receptionEnteteAchats = new ReceptionEnteteAchats();
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private List lesEntetesList = new ArrayList();
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonlig = true;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private boolean visibilitefactor = false;
   private boolean visibiliteterme = false;
   private boolean visibilitenbrjr = false;
   private boolean visibiliteencaissemt = false;
   private ObjetIncoterm incoterms;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private int var_imput_choix;
   private String var_imput_num;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private long var_nom_responsable;
   private long var_nom_contact;
   private ReceptionLigneAchats receptionLigneAchats = new ReceptionLigneAchats();
   private ReceptionLigneAchatsDao receptionLigneAchatsDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private float var_memo_qte;
   private List mesDepotAchItems;
   private ServiceDao serviceDao;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsTarifDao produitsTarifdao;
   private ProduitsDepotDao produitsDepotDao;
   private List mesProduitsDepotsItems = new ArrayList();
   private List listeProduitDepot = new ArrayList();
   private TaxesAchatsDao taxesAchatsDao;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private List mesTaxesAchatsItems;
   private List mesTaxesAchatsProduits = new ArrayList();
   private List lisTaxesAchats;
   private CalculStock calculStock = new CalculStock();
   private boolean verrou_libelle = false;
   private ProduitsFournisseur produitsFournisseur = new ProduitsFournisseur();
   private ProduitsFournisseurDao produitsFournisseurDao;
   private List mesConditionnementsItems;
   private List mesConditionnementsProduits = new ArrayList();
   private List mesUnitesItems;
   private List mesUnitesProduits = new ArrayList();
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private Unite unite = new Unite();
   private UniteDao uniteDao;
   private boolean showModalPanelSerie = false;
   private transient DataModel dataModelSerie = new ListDataModel();
   private List listeSerie = new ArrayList();
   private ReceptionSerieAchats receptionSerieAchats;
   private ReceptionSerieAchatsDao receptionSerieAchatsDao;
   private boolean showModalPanelLot = false;
   private List listeLot = new ArrayList();
   private ReceptionLotAchats receptionLotAchats;
   private ReceptionLotAchatsDao receptionLotAchatsDao;
   private String var_lib_condit;
   private List mesModelesPlanning;
   private ReceptionAvicultureAchats receptionAvicultureAchats;
   private ReceptionAvicultureAchatsDao receptionAvicultureAchatsDao;
   private List lesPlaningsAviculture;
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpFournisseur = "";
   private String inpBudget = "100";
   private String inpResponsable = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpDossier = "";
   private String inpAnal = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private int affichageQtePoids;
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private boolean verrouPump = false;
   private String verrouDepotUser;
   private boolean accesProduits;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_special = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_prp = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private Habilitation habilitation;
   private DocumentTraceAchatsDao documentTraceAchatsDao;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private DocumentTraceAchats documentTraceAchats;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean var_anal_chantier = false;
   private List mesBudgetsItems;
   private boolean showModalPanelAnnuler = false;
   private boolean showModalPanelTrf = false;
   private transient DataModel datamodelTransfert = new ListDataModel();
   private List documentDetailTrf = new ArrayList();
   private Date var_date_trf = null;
   private int var_type_trf;
   private String var_mode_trf;
   private String var_serie_trf;
   private String var_modele_trf;
   private boolean var_aff_trf = false;
   private List mesSeriesTrfItems = new ArrayList();
   private List modeleTrfItems = new ArrayList();
   private List documentTrfItems = new ArrayList();
   private boolean showModalPanelPaye = false;
   private PumpAchats pumpAchats = new PumpAchats();
   private PumpAchatsDao pumpAchatsDao;
   private boolean var_depot_famille;
   private boolean showModalPanelDouane = false;
   private DouanesPosition douanesPosition = new DouanesPosition();
   private DouanesPositionDao douanesPositionDao;
   private transient DataModel datamodelDouane = new ListDataModel();
   private String var_num_palette;
   private String var_num_carton;
   private transient DataModel dataModelFrais = new ListDataModel();
   private List lesFraisDirects = new ArrayList();
   private FraisLigneAchats fraisLigneAchats;
   private double totalFrais;
   private ProduitsTarif produitsTarif;
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
   private Chrono chronoAmortissement;
   private ChronoDao chronoDaoAmortissement;
   private boolean verrouNumAmortissement;
   private Amortissements amortissements;
   private AmortissementsDao amortissementsDao;
   private transient DataModel dataModelCatalogueFichier;
   private List lesCataloguesFichiers;
   private boolean showModalPanelAjoutFile = false;
   private String cheminCatalogue;
   private String nomCatalogue;
   private boolean showModalPanelPj = false;
   private String fichierMine;
   private URL fichierUrl;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload = new UtilDownload();
   private String urlExplorateur;
   private transient DataModel dataModelPieceJointes = new ListDataModel();
   private List lesPiecesJointes = new ArrayList();
   private boolean showModalPanelAjoutScan = false;
   private String cheminPieceJointes;
   private String nomPiecesJointes;
   private boolean showModalPanelScan = false;
   private FileCtrl fileCtrl;
   private int typeFichier;
   private String lotReception;
   private boolean accesLot;

   public FormReceptionAchats() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLigneAchatsDao = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.receptionSerieAchatsDao = new ReceptionSerieAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLotAchatsDao = new ReceptionLotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceAchatsDao = new DocumentTraceAchatsDao(this.baseLog, this.utilInitHibernate);
      this.pumpAchatsDao = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
      this.douanesPositionDao = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
      }

      if (!this.optionAchats.getLib1().isEmpty() && !this.optionAchats.getLib2().isEmpty() && !this.optionAchats.getLib3().isEmpty() && !this.optionAchats.getLib4().isEmpty() && !this.optionAchats.getLib5().isEmpty() && !this.optionAchats.getLib6().isEmpty() && !this.optionAchats.getLib7().isEmpty() && !this.optionAchats.getLib8().isEmpty() && !this.optionAchats.getLib9().isEmpty() && !this.optionAchats.getLib10().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionAchats.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionAchats.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
         this.libelleDossier = "N° DOS.";
         this.libelleDossierFiche = "N° Dossier";
      } else if (this.optionAchats.getAxeDossier().equals("2")) {
         this.var_anal_dossier = false;
         this.libelleDossier = "N° AFF.";
         this.libelleDossierFiche = "N° Affaire";
      } else {
         this.var_anal_dossier = false;
         this.libelleDossier = "N° DOS.";
         this.libelleDossierFiche = "N° Dossier";
      }

      if (this.optionAchats.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      } else {
         this.var_anal_parc = false;
      }

      if (this.optionAchats.getAxeChantier().equals("true")) {
         this.var_anal_chantier = true;
      } else {
         this.var_anal_chantier = false;
      }

      this.periode = this.optionAchats.getAffichInGlobViewREC();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      if (this.optionAchats.getAffichQtePoidsREC() != null) {
         this.affichageQtePoids = Integer.parseInt(this.optionAchats.getAffichQtePoidsREC());
      } else {
         this.affichageQtePoids = 0;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      if (this.rechercheModule(60010)) {
         this.modeReception = 1;
         this.libelleModeReception = "(PAPETERIE)";
      } else if (this.rechercheModule(60020)) {
         this.modeReception = 2;
         this.libelleModeReception = "(AVICULTURE)";
         this.receptionAvicultureAchatsDao = new ReceptionAvicultureAchatsDao(this.baseLog, this.utilInitHibernate);
         this.lesPlaningsAviculture = new ArrayList();
      } else {
         this.modeReception = 0;
         this.libelleModeReception = "";
      }

      this.cheminPieceJointes = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "receptionAchat" + File.separator;
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
            break;
         }
      }

      return var2;
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemiseAch() == 0) {
         this.verrouRemise = true;
      } else {
         this.verrouRemise = false;
      }

      if (this.usersLog.getUsrVerRabaisAch() == 0) {
         this.verrouRabais = true;
      } else {
         this.verrouRabais = false;
      }

      if (this.usersLog.getUsrVerPaAch() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAchPump() == 0) {
         this.affichagePump = false;
         this.verrouPump = false;
      } else {
         this.affichagePump = true;
         if (this.usersLog.getUsrAchPump() == 2) {
            this.verrouPump = true;
         } else {
            this.verrouPump = false;
         }
      }

      if (this.usersLog.getUsrProdServiceAch() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

      this.visibiliteBton = false;
      if (this.usersLog.getUsrCommAchats() == 2) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_special = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_prp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_acc_document = true;
            } else if (var1.getCode().equals("52")) {
               this.var_acc_imputation = true;
            } else if (var1.getCode().equals("53")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("54")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("55")) {
               this.var_acc_special = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("60")) {
               this.var_acc_prp = true;
            }
         }
      }

   }

   public void autorisationDocument() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationImputation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("52")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
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
            if (var1.getCode().equals("53")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationReglement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("54")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationSpecial() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("55")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationHabilitation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("56")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationEtat() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("57")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationTracabilite() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("58")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationPrp() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("60")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void initPage() {
      this.var_action = 0;
      this.montantTtc = 0.0D;
      this.montantSolde = 0.0D;
      this.montantReglement = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.inpSerie = "100";
      this.inpCat = "100";
      this.inpService = "100";
      this.inpBudget = "100";
      this.inpEtat = 0;
      this.inpDossier = "";
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void recupererBudgetItem() throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      PlansBudgetairesDao var1 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      String var2 = "" + this.lastExoCompta.getExecpt_id();
      if (this.receptionEnteteAchats.getRecActivite() != null && !this.receptionEnteteAchats.getRecActivite().isEmpty() && this.receptionEnteteAchats.getRecActivite().contains(":")) {
         String[] var3 = this.receptionEnteteAchats.getRecActivite().split(":");
         this.mesBudgetsItems = var1.chargerLesPlansBudgetaires(0, "2", var2, var3[0], (Session)null);
      } else {
         this.mesBudgetsItems = var1.chargerLesPlansBudgetaires(0, "2", var2, "", (Session)null);
      }

   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (this.usersLog.getUsrCommAchats() == 0) {
         var2 = this.usersDao.chargerLesUsers(var1);
      } else if (this.usersLog.getUsrCommAchats() == 1) {
         ResponsableDao var3 = new ResponsableDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var4 = var3.chargerLesResponsablesDocument(this.tiers, var1);
         if (var4.size() != 0) {
            new Responsable();

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               Responsable var5 = (Responsable)var4.get(var6);
               new Users();
               Users var7 = this.usersDao.selectByIdUsers(var5.getRpbuserid(), var1);
               if (var7 != null) {
                  this.lesUsers.add(var7);
               }
            }
         } else {
            var2 = this.usersDao.chargerLesSignataires("Achats", var1);
         }
      } else {
         ((List)var2).add(this.usersLog);
      }

      if (((List)var2).size() == 0) {
         ((List)var2).add(this.usersLog);
      }

      this.mesUsersItem.clear();
      if (this.usersLog.getUsrCommAchats() != 0 && this.usersLog.getUsrCommAchats() != 1) {
         this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
      } else {
         for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
            Users var9 = (Users)((List)var2).get(var8);
            if (var9.getUsrAcheteur() == 1 && var9.getUsrPatronyme() != null && !var9.getUsrPatronyme().isEmpty()) {
               this.mesUsersItem.add(new SelectItem(var9.getUsrid(), var9.getUsrPatronyme()));
            }
         }

         if (this.mesUsersItem.size() == 0) {
            this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         }
      }

   }

   public void rechercheDOCUMENT(long var1) throws HibernateException, NamingException {
      this.lesLignesList = new ArrayList();
      this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(var1, (Session)null);
      if (this.receptionEnteteAchats != null) {
         this.lesLignesList = this.receptionLigneAchatsDao.chargerLesLignes((ReceptionEnteteAchats)this.receptionEnteteAchats, (Session)null);
      }

   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         this.inpDossier = "";
         this.inpAnal = "";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpResponsable = "";
         this.inpBudget = "100";
         this.inpActivite = "100";
         this.inpDossier = "";
         this.inpAnal = "";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteTiers() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      this.var_nb_ligne = 0;
      String var10 = "";
      String var11 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var10 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var11 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var10 = null;
         var11 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.receptionEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.inpNum, this.inpIdTiersEnCours, this.inpFournisseur, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.inpService, this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.inpResponsable, this.inpActivite, this.inpDossier, this.inpAnal, var10, var11);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new ReceptionEnteteAchats();

         for(int var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            ReceptionEnteteAchats var12 = (ReceptionEnteteAchats)this.lesEntetesList.get(var13);
            var2 += var12.getRecTotTtc();
            var4 += var12.getRecTotReglement();
            var6 += var12.getRecTotHt();
            var8 += var12.getRecTotTva();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.totauxHt = var2;
      this.totauxHt = var6;
      this.totauxTaxe = var8;
      this.montantTtc = var2;
      this.montantReglement = var4;
      this.montantSolde = var2 - var4;
      this.visibiliteBton = false;
      this.inpNomTiersEnCours = "";
      this.inpIdTiersEnCours = 0L;
   }

   public void selectionLigne() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.receptionEnteteAchats = (ReceptionEnteteAchats)var1.get(0);
            this.inpNomTiersEnCours = this.receptionEnteteAchats.getRecNomTiers();
            this.inpIdTiersEnCours = this.receptionEnteteAchats.getTiers().getTieid();
            this.var_date = this.receptionEnteteAchats.getRecDate();
            if (this.receptionEnteteAchats.getRecDate().getHours() <= 9) {
               this.var_heure = "0" + this.receptionEnteteAchats.getRecDate().getHours();
            } else {
               this.var_heure = "" + this.receptionEnteteAchats.getRecDate().getHours();
            }

            if (this.receptionEnteteAchats.getRecDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.receptionEnteteAchats.getRecDate().getMinutes();
            } else {
               this.var_minute = "" + this.receptionEnteteAchats.getRecDate().getMinutes();
            }

            if (this.receptionEnteteAchats.getRecDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.receptionEnteteAchats.getRecDate().getSeconds();
            } else {
               this.var_seconde = "" + this.receptionEnteteAchats.getRecDate().getSeconds();
            }

            this.tiers = this.receptionEnteteAchats.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.receptionEnteteAchats.getRecIdContact();
            this.var_nom_responsable = this.receptionEnteteAchats.getRecIdResponsable();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
            this.calculDevise(var4);
            this.chargerDocumentLigne(var4);
            this.chargerDossierAffaire(var4);
            this.chargerDocumentAvicole(var4);
            this.chargerDocumentTrace(var4);
            this.chargerFrais(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
            this.accesCatalogue();
            this.accesPiecesJointes();
            this.chargerModeEcheanceAffichage();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.dataModelSerie = new ListDataModel();
            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.utilInitHibernate.closeSession();
            this.setMontantTtcElmt(this.receptionEnteteAchats.getRecTotTtc());
            this.setMontantReglementElmt(this.receptionEnteteAchats.getRecTotReglement());
            this.setMontantSoldeElmt(this.receptionEnteteAchats.getRecTotTtc() - this.receptionEnteteAchats.getRecTotReglement());
            this.cumulPrix();
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.modeReception == 2) {
               this.chargerlesModeles();
            }
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.receptionEnteteAchats != null) {
         if (this.receptionEnteteAchats.getRecEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() throws HibernateException, NamingException {
      this.receptionEnteteAchats.setRecCoefDevise(0.0F);
      this.calculDevise((Session)null);
   }

   public void calculDevise(Session var1) throws HibernateException, NamingException {
      if (this.receptionEnteteAchats.getRecDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.receptionEnteteAchats.getRecDevise());
         if (this.receptionEnteteAchats.getRecDevise().equals(this.structureLog.getStrdevise())) {
            this.receptionEnteteAchats.setRecCoefDevise(1.0F);
         } else if (this.receptionEnteteAchats.getRecCoefDevise() == 0.0F) {
            new ObjetDevises();
            LectureDevises var3 = new LectureDevises();
            new Devise();
            DeviseDao var5 = new DeviseDao(this.baseLog, this.utilInitHibernate);
            Devise var4 = var5.chargerLesDevises(this.receptionEnteteAchats.getRecDevise(), var1);
            ObjetDevises var2;
            float var6;
            float var7;
            float var8;
            float var9;
            if (var4 != null) {
               var6 = var4.getDevTaux1();
               var7 = var4.getDevTaux2();
               var2 = var3.devisesRecherchee(this.receptionEnteteAchats.getRecDevise(), this.structureLog.getStrdevise());
               var8 = Float.parseFloat(var2.getTaux1());
               var9 = Float.parseFloat(var2.getTaux2());
               this.receptionEnteteAchats.setRecCoefDevise(var6 * var9);
            } else {
               this.receptionEnteteAchats.setRecCoefDevise(1.0F);
            }

            if (this.receptionEnteteAchats.getRecCoefDevise() == 0.0F) {
               var2 = var3.devisesRecherchee("EUR", this.structureLog.getStrdevise());
               var6 = Float.parseFloat(var2.getTaux1());
               var7 = Float.parseFloat(var2.getTaux2());
               var2 = var3.devisesRecherchee(this.receptionEnteteAchats.getRecDevise(), this.structureLog.getStrdevise());
               var8 = Float.parseFloat(var2.getTaux1());
               var9 = Float.parseFloat(var2.getTaux2());
               this.receptionEnteteAchats.setRecCoefDevise(var6 * var9);
            }
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.receptionEnteteAchats.getRecId() > 0L) {
         this.receptionLigneAchats.setPv_ht(0.0D);
         this.lesLignesList = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var1);
         if (this.lesLignesList.size() != 0) {
            for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var2);
               if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                  if (this.produits != null) {
                     new ArrayList();
                     List var3 = this.produitsTarifdao.selectProdTarifByprod(this.produits, var1);
                     if (var3.size() != 0) {
                        this.receptionLigneAchats.setPv_ht(((ProduitsTarif)var3.get(0)).getProtarPv());
                     }
                  }
               }
            }
         }
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerDossierAffaire(Session var1) throws HibernateException, NamingException {
      this.dossier = null;
      if (this.optionAchats.getAxeDossier().equals("1")) {
         this.libelleDossierFiche = "N° Dossier";
      } else if (this.optionAchats.getAxeDossier().equals("2")) {
         this.libelleDossierFiche = "N° Affaire";
      } else {
         this.libelleDossierFiche = "N° Dossier";
      }

      if (this.receptionEnteteAchats != null && this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
         this.dossier = this.plansAnalytiquesDao.rechercheAffaire(this.receptionEnteteAchats.getRecAnal4(), var1);
         if (this.dossier != null && this.dossier.getAnaNature() != null && !this.dossier.getAnaNature().isEmpty()) {
            if (this.dossier.getAnaNature().equals("6")) {
               this.libelleDossierFiche = "N° Dossier";
            } else if (this.dossier.getAnaNature().equals("10")) {
               this.libelleDossierFiche = "N° Affaire";
            }
         }
      }

   }

   public void chargerDocumentAvicole(Session var1) throws HibernateException, NamingException {
      if (this.modeReception == 2) {
         this.lesPlaningsAviculture.clear();
         this.lesPlaningsAviculture = this.receptionAvicultureAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var1);
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      new ArrayList();
      Object var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      new ArrayList();
      ArrayList var9 = new ArrayList();
      new ArrayList();
      ArrayList var11 = new ArrayList();
      new ArrayList();
      ArrayList var13 = new ArrayList();
      ArrayList var14 = new ArrayList();
      new ArrayList();
      ArrayList var16 = new ArrayList();
      if (this.receptionEnteteAchats.getRecId() > 0L) {
         List var8 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(this.receptionEnteteAchats.getRecId(), this.nature, var1);
         if (var8.size() == 0) {
            var8 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(this.receptionEnteteAchats.getRecId(), this.nature, var1);
         }

         int var17;
         int var18;
         for(var17 = 0; var17 < var8.size(); ++var17) {
            List var12 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(((DocumentTraceAchats)var8.get(var17)).getDoctrfDstId(), ((DocumentTraceAchats)var8.get(var17)).getDoctrfDstType(), var1);
            if (var12.size() != 0) {
               for(var18 = 0; var18 < var12.size(); ++var18) {
                  var11.add(var12.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var8.size(); ++var17) {
            List var7 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var8.get(var17)).getDoctrfOrgId(), ((DocumentTraceAchats)var8.get(var17)).getDoctrfOrgType(), var1);
            if (var7.size() != 0) {
               for(var18 = 0; var18 < var7.size(); ++var18) {
                  var6.add(var7.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var6.size(); ++var17) {
            var4 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var6.get(var17)).getDoctrfOrgId(), ((DocumentTraceAchats)var6.get(var17)).getDoctrfOrgType(), var1);
            if (var5.size() != 0) {
               for(var18 = 0; var18 < var5.size(); ++var18) {
                  ((List)var4).add(var5.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < ((List)var4).size(); ++var17) {
            List var3 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)((List)var4).get(var17)).getDoctrfOrgId(), ((DocumentTraceAchats)((List)var4).get(var17)).getDoctrfOrgType(), var1);
            if (var3.size() != 0) {
               for(var18 = 0; var18 < var3.size(); ++var18) {
                  var2.add(var3.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var11.size(); ++var17) {
            List var15 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var11.get(var17)).getDoctrfOrgId(), 26, var1);
            if (var15.size() != 0) {
               for(var18 = 0; var18 < var15.size(); ++var18) {
                  var14.add(var15.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var8.size(); ++var17) {
            List var10 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var8.get(var17)).getDoctrfOrgId(), 24, var1);
            if (var10.size() != 0) {
               for(var18 = 0; var18 < var10.size(); ++var18) {
                  var9.add(var10.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var2.size(); ++var17) {
            var16.add(var2.get(var17));
         }

         for(var17 = 0; var17 < ((List)var4).size(); ++var17) {
            var16.add(((List)var4).get(var17));
         }

         for(var17 = 0; var17 < var6.size(); ++var17) {
            var16.add(var6.get(var17));
         }

         for(var17 = 0; var17 < var8.size(); ++var17) {
            var16.add(var8.get(var17));
         }

         for(var17 = 0; var17 < var9.size(); ++var17) {
            var16.add(var9.get(var17));
         }

         for(var17 = 0; var17 < var11.size(); ++var17) {
            var16.add(var11.get(var17));
         }

         for(var17 = 0; var17 < var13.size(); ++var17) {
            var16.add(var13.get(var17));
         }

         for(var17 = 0; var17 < var14.size(); ++var17) {
            var16.add(var14.get(var17));
         }
      }

      this.datamodelDocumentTrace.setWrappedData(var16);
      this.documentTraceAchats = null;
      this.utilInitHibernate.closeSession();
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      this.datamodelDocumentTrace.setWrappedData(var2);
      this.documentTraceAchats = null;
   }

   public void chargerFrais(Session var1) throws HibernateException, NamingException {
      this.dataModelFrais = new ListDataModel();
      if (this.optionAchats.getChargerFRA().equals("1")) {
         this.lesFraisDirects.clear();
         if (this.receptionEnteteAchats.getRecId() > 0L && (this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty() || this.receptionEnteteAchats.getRecAffaire() != null && !this.receptionEnteteAchats.getRecAffaire().isEmpty())) {
            FraisLigneAchatsDao var2 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            if (this.optionAchats.getAxeDossier().equals("2")) {
               this.lesFraisDirects = var2.chargerLesLignesByAffaireReception(this.receptionEnteteAchats.getRecNum(), this.receptionEnteteAchats.getRecAffaire(), this.receptionEnteteAchats.getRecAnal4(), var1);
            } else {
               this.lesFraisDirects = var2.chargerLesLignesByDossierReception(this.receptionEnteteAchats.getRecNum(), this.receptionEnteteAchats.getRecAnal4(), var1);
            }
         }

         this.cumulPrixFrais();
         this.dataModelFrais.setWrappedData(this.lesFraisDirects);
      } else {
         Object var4 = new ArrayList();
         if (this.receptionEnteteAchats.getRecId() > 0L && this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
            FraisEnteteAchatsDao var3 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            var4 = var3.rechercheByDossier(this.receptionEnteteAchats.getRecAnal4(), var1);
         }

         this.dataModelFrais.setWrappedData(var4);
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.receptionEnteteAchats != null && this.receptionEnteteAchats.getRecSerie() != null && !this.receptionEnteteAchats.getRecSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.receptionEnteteAchats.getRecSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.receptionEnteteAchats.getRecId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.receptionEnteteAchats.getRecActivite() != null && !this.receptionEnteteAchats.getRecActivite().isEmpty() && this.receptionEnteteAchats.getRecActivite().contains(":")) {
         String[] var1 = null;
         if (!this.receptionEnteteAchats.getRecActivite().contains("#")) {
            var1 = this.receptionEnteteAchats.getRecActivite().split(":");
            if (var1.length == 8) {
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
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.receptionEnteteAchats.getRecActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 8) {
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
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
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

   public void calculPourcentage() {
      if (this.ecrituresAnalytiqueCtrl != null && this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var1);
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
      float var1 = 0.0F;
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var2 = 0; var2 < this.lesDecoupagesActivites.size(); ++var2) {
            this.totalImputation += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaMontantSaisie();
            var1 += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = this.receptionEnteteAchats.getRecTotHt() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void controleNumeroAnalytique() throws HibernateException, NamingException {
      new ReceptionEnteteAchats();
      ReceptionEnteteAchats var1 = this.receptionEnteteAchatsDao.rechercheAnal4(this.receptionEnteteAchats.getRecAnal4(), (Session)null);
      if (var1 != null) {
         this.receptionEnteteAchats.setRecAnal4("");
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.dossier = null;
      this.receptionEnteteAchats = new ReceptionEnteteAchats();
      this.receptionLigneAchats = new ReceptionLigneAchats();
      this.receptionEnteteAchats.setUsers(this.usersLog);
      this.receptionEnteteAchats.setRecIdCreateur(this.usersLog.getUsrid());
      this.receptionEnteteAchats.setRecNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.receptionEnteteAchats.setRecIdResponsable(this.usersLog.getUsrid());
      this.receptionEnteteAchats.setRecNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.receptionEnteteAchats.setRecDate(new Date());
      this.receptionEnteteAchats.setRecCat("Local");
      this.var_date = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      this.calculDateValidite();
      this.receptionEnteteAchats.setRecDateLivraison((Date)null);
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.lesUsers.clear();
      this.mesUsersItem.clear();
      this.mesUsersItem.add(new SelectItem(0, ""));
      this.var_action = 1;
      this.informationsTiers = null;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_aff_detail_tiers = false;
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = true;
      this.visibilitefactor = false;
      this.visibiliteterme = false;
      this.visibilitenbrjr = false;
      this.visibiliteencaissemt = false;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.lesFraisDirects.clear();
      this.dataModelFrais.setWrappedData(this.lesFraisDirects);
      if (this.optionAchats.getAxeDossier().equals("1")) {
         this.libelleDossierFiche = "N° Dossier";
      } else if (this.optionAchats.getAxeDossier().equals("2")) {
         this.libelleDossierFiche = "N° Affaire";
      } else {
         this.libelleDossierFiche = "N° Dossier";
      }

      this.autorisationDocument();
      this.addLigne();
      if (this.modeReception == 2) {
         this.chargerlesModeles();
      }

   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionAchats.getNbrJrRelanceREC() != null && !this.optionAchats.getNbrJrRelanceREC().isEmpty()) {
         var3 = Integer.parseInt(this.optionAchats.getNbrJrRelanceREC());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionAchats.getNbrJrValidREC() != null && !this.optionAchats.getNbrJrValidREC().isEmpty()) {
         var4 = Integer.parseInt(this.optionAchats.getNbrJrValidREC());
      } else {
         var4 = 0;
      }

      this.receptionEnteteAchats.setRecDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.receptionEnteteAchats.setRecDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.receptionEnteteAchats != null) {
         this.receptionEnteteAchats.setRecMaj(1);
         this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         if (this.usersLog.getUsrSignatureAchats() == 1) {
            this.chargerLesUsers((Session)null);
         } else if (this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.receptionEnteteAchats.getRecIdResponsable(), this.receptionEnteteAchats.getRecNomResponsable()));
         }

         this.chargerFraisAuto();
         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void chargerFraisAuto() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionAchats.getChargerFRA().equals("1") && this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         new ArrayList();
         List var2 = this.produitsDao.chargerLesProduitsByNature("0112", var1);
         if (var2 != null && var2.size() != 0) {
            int var3 = 0;

            while(true) {
               if (var3 >= var2.size()) {
                  this.cumulPrixFrais();
                  this.dataModelFrais.setWrappedData(this.lesFraisDirects);
                  break;
               }

               this.produits = (Produits)var2.get(var3);
               if (this.produits.getProInactif() == 0) {
                  boolean var4 = false;
                  if (this.lesFraisDirects.size() != 0) {
                     new FraisLigneAchats();

                     for(int var6 = 0; var6 < this.lesFraisDirects.size(); ++var6) {
                        FraisLigneAchats var5 = (FraisLigneAchats)this.lesFraisDirects.get(var6);
                        if (var5.getFsfligCode() != null && !var5.getFsfligCode().isEmpty() && var5.getFsfligCode().equals(this.produits.getProCode())) {
                           var4 = true;
                           break;
                        }
                     }
                  }

                  if (!var4) {
                     this.fraisLigneAchats = new FraisLigneAchats();
                     this.calculeProduitsFrais(var1);
                     this.lesFraisDirects.add(this.fraisLigneAchats);
                  }
               }

               ++var3;
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.receptionEnteteAchats != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.receptionEnteteAchats.getRecIdResponsable(), this.receptionEnteteAchats.getRecNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var3 = null;

      ValorisationEnteteAchats var6;
      try {
         var3 = var2.beginTransaction();
         long var4 = this.receptionEnteteAchats.getTiers().getTieid();
         if (this.receptionEnteteAchats.getRecEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.receptionEnteteAchats.setRecEtat(1);
            this.receptionEnteteAchats.setRecDateValide(new Date());
            this.tiers = this.receptionEnteteAchats.getTiers();
            ValorisationEnteteAchatsDao var7;
            if (this.optionAchats.getAxeDossier().equals("2")) {
               if (this.receptionEnteteAchats.getRecAffaire() != null && !this.receptionEnteteAchats.getRecAffaire().isEmpty()) {
                  new ValorisationEnteteAchats();
                  var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  var6 = var7.rechercheByDossier(this.receptionEnteteAchats.getRecAffaire(), var2);
                  if (var6 != null) {
                     var6.setValTotalReception(this.receptionEnteteAchats.getRecTotHtLocal());
                     var6.setValObjet(this.receptionEnteteAchats.getRecObject());
                     var6.setValDate(this.receptionEnteteAchats.getRecDate());
                     var6.setValAnalytique(this.receptionEnteteAchats.getRecAnal4());
                     var6.setValSerie(this.receptionEnteteAchats.getRecSerie());
                     var6.setValDevise(this.receptionEnteteAchats.getRecDevise());
                     var6.setValCoefDeviseDouane(this.receptionEnteteAchats.getRecCoefDevise());
                     var6.setValPoidsBrut(this.receptionEnteteAchats.getRecTotPoidsBrut());
                     var6 = var7.modif(var6, var2);
                     this.receptionEnteteAchats.setRecValo(var6.getValNum());
                  } else {
                     var6 = new ValorisationEnteteAchats();
                     var6.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
                     var6.setUsers(this.usersLog);
                     var6.setValDateCreat(new Date());
                     var6.setValIdCreateur(this.usersLog.getUsrid());
                     var6.setValNomCreateur(this.usersLog.getUsrPatronyme());
                     var6.setValNomResponsable(this.usersLog.getUsrPatronyme());
                     var6.setValIdResponsable(this.usersLog.getUsrid());
                     var6.setValNature1(13);
                     var6.setValMode(0);
                     var6.setValFictif(0);
                     var6.setValCalculPr(1);
                     var6.setValTotalReception(this.receptionEnteteAchats.getRecTotHtLocal());
                     var6.setValObjet(this.receptionEnteteAchats.getRecObject());
                     var6.setValDate(this.receptionEnteteAchats.getRecDate());
                     var6.setValSerie(this.receptionEnteteAchats.getRecSerie());
                     var6.setValNum(this.calculChrono.numCompose(var6.getValDate(), 35, var6.getValSerie(), var2));
                     var6.setValDossierTransit(this.receptionEnteteAchats.getRecAffaire());
                     var6.setValAnalytique(this.receptionEnteteAchats.getRecAnal4());
                     var6.setValDevise(this.receptionEnteteAchats.getRecDevise());
                     var6.setValCoefDeviseDouane(this.receptionEnteteAchats.getRecCoefDevise());
                     var6.setValPoidsBrut(this.receptionEnteteAchats.getRecTotPoidsBrut());
                     var7.insert(var6, var2);
                  }
               }
            } else if (this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               var6 = var7.rechercheByDossier(this.receptionEnteteAchats.getRecAnal4(), var2);
               if (var6 != null) {
                  var6.setValTotalReception(this.receptionEnteteAchats.getRecTotHtLocal());
                  var6.setValObjet(this.receptionEnteteAchats.getRecObject());
                  var6.setValDate(this.receptionEnteteAchats.getRecDate());
                  var6.setValAnalytique("");
                  var6.setValSerie(this.receptionEnteteAchats.getRecSerie());
                  var6.setValDevise(this.receptionEnteteAchats.getRecDevise());
                  var6.setValCoefDeviseDouane(this.receptionEnteteAchats.getRecCoefDevise());
                  var6.setValPoidsBrut(this.receptionEnteteAchats.getRecTotPoidsBrut());
                  var6 = var7.modif(var6, var2);
                  this.receptionEnteteAchats.setRecValo(var6.getValNum());
               } else {
                  var6 = new ValorisationEnteteAchats();
                  var6.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
                  var6.setUsers(this.usersLog);
                  var6.setValDateCreat(new Date());
                  var6.setValIdCreateur(this.usersLog.getUsrid());
                  var6.setValNomCreateur(this.usersLog.getUsrPatronyme());
                  var6.setValNomResponsable(this.usersLog.getUsrPatronyme());
                  var6.setValIdResponsable(this.usersLog.getUsrid());
                  var6.setValNature1(13);
                  var6.setValMode(0);
                  var6.setValFictif(0);
                  var6.setValCalculPr(1);
                  var6.setValTotalReception(this.receptionEnteteAchats.getRecTotHtLocal());
                  var6.setValObjet(this.receptionEnteteAchats.getRecObject());
                  var6.setValDate(this.receptionEnteteAchats.getRecDate());
                  var6.setValSerie(this.receptionEnteteAchats.getRecSerie());
                  var6.setValNum(this.calculChrono.numCompose(var6.getValDate(), 35, var6.getValSerie(), var2));
                  var6.setValDossierTransit(this.receptionEnteteAchats.getRecAnal4());
                  var6.setValAnalytique("");
                  var6.setValDevise(this.receptionEnteteAchats.getRecDevise());
                  var6.setValCoefDeviseDouane(this.receptionEnteteAchats.getRecCoefDevise());
                  var6.setValPoidsBrut(this.receptionEnteteAchats.getRecTotPoidsBrut());
                  var7.insert(var6, var2);
               }
            }

            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var2);
            int var31;
            if (this.lesLignesList.size() != 0) {
               this.lotReception = "";

               for(var31 = 0; var31 < this.lesLignesList.size(); ++var31) {
                  if (((ReceptionLigneAchats)this.lesLignesList.get(var31)).getRecligNumLot() != null && !((ReceptionLigneAchats)this.lesLignesList.get(var31)).getRecligNumLot().isEmpty()) {
                     this.lotReception = ((ReceptionLigneAchats)this.lesLignesList.get(var31)).getRecligNumLot();
                  }
               }

               if (this.lotReception != null && !this.lotReception.isEmpty()) {
                  new PlansAnalytiques();
                  PlansAnalytiques var33 = this.plansAnalytiquesDao.rechercheAnal("5", this.lotReception, var2);
                  if (var33 == null) {
                     var33 = new PlansAnalytiques();
                     var33.setAnaDateCreat(new Date());
                     var33.setAnaUserCreat(this.usersLog.getUsrid());
                     var33.setAnaCode(this.receptionLigneAchats.getRecligNumLot());
                     var33.setAnaAnnee("" + (this.receptionEnteteAchats.getRecDate().getYear() + 1900));
                     var33.setAnaMissionDebut(new Date());
                     var33.setAnaMissionFin((Date)null);
                     var33.setAnaNature("5");
                     if (this.receptionEnteteAchats.getRecObject() != null && !this.receptionEnteteAchats.getRecObject().isEmpty()) {
                        var33.setAnaNomFr(this.receptionEnteteAchats.getRecObject());
                     } else if (this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
                        var33.setAnaNomFr(this.receptionEnteteAchats.getRecAnal4());
                     } else {
                        var33.setAnaNomFr(this.receptionLigneAchats.getRecligLibelle());
                     }

                     var33.setAnaAffaireService(this.receptionEnteteAchats.getRecService());
                     var33.setAnaLotEtat(0);
                     this.plansAnalytiquesDao.insert(var33, var2);
                  }
               }
            }

            if (this.receptionEnteteAchats.getRecValorisation() == 0 && this.receptionEnteteAchats.getRecCoefValo() != 0.0F) {
               this.calculPrCoefReception(var2);
            } else if (this.receptionEnteteAchats.getRecValorisation() == 1) {
               if (this.lesLignesList.size() != 0) {
                  for(var31 = 0; var31 < this.lesLignesList.size(); ++var31) {
                     this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var31);
                     this.receptionLigneAchats.setRecligCoefPr(0.0F);
                     this.receptionLigneAchats.setRecligPr(0.0D);
                     this.receptionLigneAchats.setRecligPrU(0.0D);
                     this.receptionLigneAchats.setRecligPrKg(0.0D);
                     this.receptionLigneAchats.setRecligPump(0.0D);
                     this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var2);
                  }
               }
            } else if (this.receptionEnteteAchats.getRecValorisation() == 2) {
               this.calculPrCoefFamille(var2);
            }

            this.calculStock.majReceptionAchatsVAL(this.lesLignesList, 1, this.baseLog, var2);
            if (this.lesLignesList.size() != 0) {
               for(var31 = 0; var31 < this.lesLignesList.size(); ++var31) {
                  this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var31);
                  if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty()) {
                     this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), this.receptionLigneAchats.getRecligFamille(), var2);
                     if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachNature().equals("0111")) {
                        this.amortissements = new Amortissements();
                        this.amortissementsDao = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
                        this.amortissements = this.amortissementsDao.trouverImmobilisationReception(this.receptionLigneAchats.getRecligId(), var2);
                        if (this.amortissements == null) {
                           long var30 = 0L;
                           this.chronoDaoAmortissement = new ChronoDao(this.baseLog, this.utilInitHibernate);
                           this.verifExitChronoAmortissement(var2);
                           if (this.verrouNumAmortissement) {
                              var30 = this.numCompose(var2);
                           } else {
                              var30 = this.amortissementsDao.trouverDernier(var2);
                           }

                           this.amortissements = new Amortissements();
                           this.amortissements.setAmoDateAchat(this.receptionEnteteAchats.getRecDate());
                           this.amortissements.setAmoDateCreat(new Date());
                           this.amortissements.setAmoFactureAchat(this.receptionEnteteAchats.getRecNumFature());
                           this.amortissements.setAmoFournisseur(this.receptionEnteteAchats.getRecNomTiers());
                           this.amortissements.setAmoIdReception(this.receptionLigneAchats.getRecligId());
                           this.amortissements.setAmoNum(var30);
                           this.amortissements.setAmoLibelle(this.receptionLigneAchats.getRecligLibelle());
                           this.amortissements.setAmoPieceAchat(this.receptionEnteteAchats.getRecNum());
                           this.amortissements.setAmoTvaTaux(this.receptionLigneAchats.getRecligTauxTaxe());
                           this.amortissements.setAmoTvaTotal(this.receptionLigneAchats.getRecligTva());
                           this.amortissements.setAmoUserCreat(this.usersLog.getUsrid());
                           this.amortissements.setAmoValeurAchat(this.receptionLigneAchats.getRecligPt());
                           this.amortissementsDao.insert(this.amortissements, var2);
                        }
                     }
                  }
               }
            }

            if (this.lesLignesList.size() != 0) {
               LectureDevises var37 = new LectureDevises();

               for(int var34 = 0; var34 < this.lesLignesList.size(); ++var34) {
                  this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var34);
                  if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var2);
                     if (this.produits != null) {
                        this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var2);
                        if (this.produitsFournisseur == null) {
                           this.produitsFournisseur = new ProduitsFournisseur();
                        }

                        this.produitsFournisseur.setProduits(this.produits);
                        this.produitsFournisseur.setTiers(this.tiers);
                        if ((this.produitsFournisseur.getProfouLib() == null || this.produitsFournisseur.getProfouLib().isEmpty()) && this.receptionLigneAchats.getRecligLibelleFournisseur() != null && !this.receptionLigneAchats.getRecligLibelleFournisseur().isEmpty()) {
                           this.produitsFournisseur.setProfouLib(this.receptionLigneAchats.getRecligLibelleFournisseur());
                        }

                        if ((this.produitsFournisseur.getProfouRef() == null || this.produitsFournisseur.getProfouRef().isEmpty()) && this.receptionLigneAchats.getRecligReference() != null && !this.receptionLigneAchats.getRecligReference().isEmpty()) {
                           this.produitsFournisseur.setProfouRef(this.receptionLigneAchats.getRecligReference());
                        }

                        this.produitsFournisseur.setProfouDevise(this.receptionEnteteAchats.getRecDevise());
                        this.produitsFournisseur.setProfouFormat(this.receptionEnteteAchats.getVar_format_devise());
                        if (this.produitsFournisseur.getProfouDevise() == null || this.produitsFournisseur.getProfouDevise().isEmpty()) {
                           this.produitsFournisseur.setProfouDevise(this.structureLog.getStrdevise());
                           this.produitsFournisseur.setProfouFormat(this.structureLog.getStrformatdevise());
                        }

                        this.produitsFournisseur.setProfouPa(this.receptionLigneAchats.getRecligPu());
                        this.produitsFournisseur.setProfouDate(this.receptionEnteteAchats.getRecDate());
                        new ObjetDevises();
                        ObjetDevises var8 = var37.devisesRecherchee(this.produitsFournisseur.getProfouDevise(), this.structureLog.getStrdevise());
                        float var9 = 1.0F;
                        if (var8.getTaux1() != null && !var8.getTaux1().isEmpty()) {
                           var9 = Float.parseFloat(var8.getTaux1());
                        }

                        float var10 = 1.0F;
                        if (var8.getTaux2() != null && !var8.getTaux2().isEmpty()) {
                           var10 = Float.parseFloat(var8.getTaux2());
                        }

                        this.produitsFournisseur.setProfouTauxDevise(this.receptionEnteteAchats.getRecCoefDevise());
                        this.produitsFournisseur.setProfouCoefEuro(var9);
                        if (this.produitsFournisseur.getProfouDevise().equalsIgnoreCase(this.structureLog.getStrdevise())) {
                           this.produitsFournisseur.setProfouCoefLocal(1.0F);
                           this.produitsFournisseur.setProfouPaLocal(this.produitsFournisseur.getProfouPa());
                        } else {
                           this.produitsFournisseur.setProfouCoefLocal(var10);
                           double var11 = this.produitsFournisseur.getProfouPa() * (double)var9 * (double)var10;
                           double var13 = this.utilNombre.myRoundFormat(var11, this.produitsFournisseur.getProfouFormat());
                           this.produitsFournisseur.setProfouPaLocal(var13);
                        }

                        if (this.produitsFournisseur.getProfouId() == 0L) {
                           this.produitsFournisseur = this.produitsFournisseurDao.insert(this.produitsFournisseur, var2);
                        } else {
                           this.produitsFournisseur = this.produitsFournisseurDao.modif(this.produitsFournisseur, var2);
                        }
                     }
                  }
               }
            }

            Espion var38 = new Espion();
            var38.setUsers(this.usersLog);
            var38.setEsptype(0);
            var38.setEspdtecreat(new Date());
            var38.setEspaction("Validation manuelle réception N° " + this.receptionEnteteAchats.getRecNum() + " du " + this.utilDate.dateToStringSQLLight(this.receptionEnteteAchats.getRecDate()));
            this.espionDao.mAJEspion(var38, var2);
         }

         if (this.tiers.getTieDteDocument3() == null || this.receptionEnteteAchats.getRecDate().after(this.tiers.getTieDteDocument3())) {
            this.tiers = this.tiersDao.selectTierD(var4, var2);
            if (this.tiers != null) {
               this.tiers.setTieDteDocument3(this.receptionEnteteAchats.getRecDate());
               this.tiers = this.tiersDao.modif(this.tiers, var2);
            }
         }

         var3.commit();
      } catch (HibernateException var27) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var27;
      } finally {
         var1 = true;
         this.utilInitHibernate.closeSession();
      }

      if (var1) {
         new OptionVentes();
         LireLesoptionsVentes var5 = new LireLesoptionsVentes();
         var5.setStrId(this.structureLog.getStrid());
         var5.lancer();
         OptionVentes var29 = var5.getOptionsVentes();
         if (this.lesLignesList.size() != 0) {
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
            var6 = null;

            try {
               Transaction var39 = var2.beginTransaction();
               new InventaireLigne();

               for(int var32 = 0; var32 < this.lesLignesList.size(); ++var32) {
                  this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var32);
                  if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty() && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var2);
                     if (this.produits != null) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.receptionLigneAchats.getRecligDepot(), var2);
                        if (this.produitsDepot != null) {
                           InventaireLigne var35 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.receptionLigneAchats.getRecligDepot(), this.baseLog, var2);
                           String var36 = "";
                           if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty() && (this.produits.getProAchNat().equals("1105") || this.produits.getProAchNat().equals("0104") || this.produits.getProAchNat().equals("0105") || this.produits.getProAchNat().equals("1604") || this.produits.getProAchNat().equals("1605"))) {
                              var36 = this.produits.getProAchNat();
                           } else if (this.produits.getProVteNat() == null || this.produits.getProVteNat().isEmpty() || !this.produits.getProVteNat().equals("1105") && !this.produits.getProVteNat().equals("0104") && !this.produits.getProVteNat().equals("0105") && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1605")) {
                              if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                                 var36 = this.produits.getProAchNat();
                              } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                                 var36 = this.produits.getProVteNat();
                              }
                           } else {
                              var36 = this.produits.getProVteNat();
                           }

                           this.produitsDepot = this.calculStock.recalculStock(var36, this.produitsDepot, var35, this.produits.getProCode(), (String)null, this.receptionLigneAchats.getRecligDepot(), 0L, var29.getGestionStockBc(), this.baseLog, this.structureLog, var2);
                           this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
                        }
                     }
                  }
               }

               var39.commit();
            } catch (HibernateException var25) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var25;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.receptionEnteteAchats.getRecEtat() == 1) {
            this.receptionEnteteAchats.setRecEtat(0);
            this.receptionEnteteAchats.setRecDateValide((Date)null);
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
         }

         this.annuleCoefValo(var1);
         this.calculStock.majReceptionAchatsVAL(this.lesLignesList, 2, this.baseLog, var1);
         Espion var3 = new Espion();
         var3.setUsers(this.usersLog);
         var3.setEsptype(0);
         var3.setEspdtecreat(new Date());
         var3.setEspaction("Dévalidation manuelle réception N° " + this.receptionEnteteAchats.getRecNum() + " du " + this.utilDate.dateToStringSQLLight(this.receptionEnteteAchats.getRecDate()));
         this.espionDao.mAJEspion(var3, var1);
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

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.receptionEnteteAchats != null) {
         this.receptionEnteteAchats.setRecEtat(0);
         this.receptionEnteteAchats.setRecDateAnnule((Date)null);
         this.receptionEnteteAchats.setRecMotifAnnule("");
         this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
      }

   }

   public void calculPrCoefReception(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.receptionEnteteAchats != null && this.lesLignesList.size() != 0) {
         new OptionVentes();
         LireLesoptionsVentes var3 = new LireLesoptionsVentes();
         var3.setStrId(this.structureLog.getStrid());
         var3.lancer();
         OptionVentes var2 = var3.getOptionsVentes();
         this.calculStock = new CalculStock();
         long var4 = 0L;
         new ReceptionLigneAchats();
         new InventaireLigne();
         InventaireLigneDao var8 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         new Stock();
         new DepotAchats();
         DepotAchatsDao var12 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         ProduitsAchsDao var13 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.receptionLigneAchats = new ReceptionLigneAchats();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var14);
            var4 = this.receptionLigneAchats.getRecligId();
            if (this.receptionEnteteAchats.getRecCoefDevise() == 0.0F) {
               this.receptionEnteteAchats.setRecCoefDevise(1.0F);
            }

            int var15 = Integer.parseInt(this.optionAchats.getNbDecPu());
            double var16 = 0.0D;
            if (this.receptionLigneAchats.getRecligFob() != 0.0D) {
               var16 = this.receptionLigneAchats.getRecligFob() + this.receptionLigneAchats.getRecligFret() + this.receptionLigneAchats.getRecligAssurance() + this.receptionLigneAchats.getRecligT1() + this.receptionLigneAchats.getRecligT3() + this.receptionLigneAchats.getRecligT5() + this.receptionLigneAchats.getRecligT10() + this.receptionLigneAchats.getRecligT30() + this.receptionLigneAchats.getRecligT31() + this.receptionLigneAchats.getRecligT46() + this.receptionLigneAchats.getRecligT53() + this.receptionLigneAchats.getRecligFrais() + this.receptionLigneAchats.getRecligFinancier();
            } else {
               var16 = this.receptionLigneAchats.getRecligPt() * (double)this.receptionEnteteAchats.getRecCoefValo();
            }

            if (this.optionAchats.getModCalcPr().equals("1")) {
               var16 += this.receptionLigneAchats.getRecligTva();
            }

            this.receptionLigneAchats.setRecligPr(var16);
            double var18 = 0.0D;
            double var20 = 0.0D;
            if (this.receptionLigneAchats.getRecligQteUtil() != 0.0F) {
               var18 = this.utilNombre.myRound(var16 / (double)this.receptionLigneAchats.getRecligQteUtil(), 2);
            } else if (this.receptionLigneAchats.getRecligQte() != 0.0F) {
               var18 = this.utilNombre.myRound(var16 / (double)this.receptionLigneAchats.getRecligQte(), 2);
            }

            this.receptionLigneAchats.setRecligPrU(var18);
            if (this.receptionLigneAchats.getRecligPoidsNet() != 0.0F) {
               var20 = this.utilNombre.myRound(var16 / (double)this.receptionLigneAchats.getRecligPoidsNet(), 2);
               this.receptionLigneAchats.setRecligPrKg(var20);
            } else {
               this.receptionLigneAchats.setRecligPrKg(0.0D);
            }

            if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty() && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
               if (this.produitsDepot == null) {
                  DepotAchats var11 = var12.trouveDepot(this.receptionLigneAchats.getRecligDepot(), var1);
                  if (var11 != null) {
                     this.produits = var13.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                     if (this.produits != null) {
                        this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), this.produits, var1);
                        if (this.famillesProduitsAchats == null) {
                           this.famillesProduitsAchats = new FamillesProduitsAchats();
                        }

                        this.produitsDepot = new ProduitsDepot();
                        this.produitsDepot.setProduits(this.produits);
                        this.produitsDepot.setDepot(var11);
                        this.produitsDepot.setProdepUnite(this.famillesProduitsAchats.getFamachUnite());
                        this.produitsDepot.setProdepEchelle(this.famillesProduitsAchats.getFamachEchelle());
                        String var22 = this.receptionLigneAchats.getRecligDepot() + ":" + this.receptionLigneAchats.getRecligCode();
                        this.produitsDepot.setProdepCle(var22);
                        String var23 = this.produitsDepot.getProdepGroupe() + ":" + this.receptionLigneAchats.getRecligCode();
                        this.produitsDepot.setProdepCle2(var23);
                        this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot, var1);
                     }
                  }
               }

               double var36 = 0.0D;
               double var24 = 0.0D;
               double var26 = 0.0D;
               if (this.produitsDepot != null) {
                  float var28 = 0.0F;
                  float var29 = 0.0F;
                  double var30 = 0.0D;
                  byte var32 = 0;
                  Date var33 = null;
                  InventaireLigne var7 = var8.rechercheBefore(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
                  ReceptionLigneAchats var6 = this.receptionLigneAchatsDao.rechercheBefore(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
                  if (var6 != null) {
                     var32 = 1;
                  } else if (var7 != null) {
                     var32 = 2;
                  }

                  int var35;
                  if (this.optionAchats.getModCalcPump().equals("1")) {
                     var32 = 3;
                  } else {
                     if (var7 != null) {
                        var33 = var7.getInventaireEntete().getInvDate();
                        var28 = var7.getInvligQteUtil();
                     } else {
                        var33 = this.exercicesAchats.getExeachDateDebut();
                     }

                     String var34 = "";
                     if (this.produitsDepot.getProduits().getProVteNat() != null && !this.produitsDepot.getProduits().getProVteNat().isEmpty()) {
                        var34 = this.produitsDepot.getProduits().getProVteNat();
                     } else {
                        var34 = this.produitsDepot.getProduits().getProAchNat();
                     }

                     List var9;
                     if (this.optionAchats.getModDepPump().equals("1")) {
                        var9 = this.calculStock.chargerMouvements(1, "", var34, this.receptionLigneAchats.getRecligCode(), "", (String)null, 0L, "", "", var33, this.receptionEnteteAchats.getRecDate(), false, false, true, true, false, false, true, true, true, true, true, false, false, true, true, true, false, false, true, false, true, var2.getGestionStockBc(), this.baseLog, this.structureLog, var1);
                     } else {
                        var9 = this.calculStock.chargerMouvements(1, "", var34, this.receptionLigneAchats.getRecligCode(), "", this.receptionLigneAchats.getRecligDepot(), 0L, "", "", var33, this.receptionEnteteAchats.getRecDate(), false, false, true, true, false, false, true, true, true, true, true, false, false, true, true, true, false, false, true, false, true, var2.getGestionStockBc(), this.baseLog, this.structureLog, var1);
                     }

                     if (var9.size() != 0) {
                        for(var35 = 0; var35 < var9.size(); ++var35) {
                           Stock var10 = (Stock)var9.get(var35);
                           var28 += var10.getStk_qte_in() - var10.getStk_qte_out();
                        }
                     }

                     if (var28 <= 0.0F) {
                        var32 = 0;
                     }
                  }

                  var29 = var28 - this.receptionLigneAchats.getRecligQteUtil();
                  if (var29 <= 0.0F) {
                     var29 = 0.0F;
                     var32 = 0;
                  }

                  if (var32 == 1) {
                     if (var6.getRecligPump() != 0.0D) {
                        var36 = var6.getRecligPump() * (double)var29;
                     } else {
                        var36 = var6.getRecligPrU() * (double)var29;
                     }

                     var24 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                     var26 = (var36 + var24) / (double)var28;
                     var30 = var6.getRecligPump();
                     if (var26 == 0.0D) {
                        var26 = var18;
                     }

                     this.miseAJourDepot(var18, var20, var26, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  } else if (var32 == 2) {
                     var36 = var7.getInvligPump() * (double)var29;
                     var24 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                     var26 = (var36 + var24) / (double)var28;
                     var30 = var7.getInvligPump();
                     if (var26 == 0.0D) {
                        var26 = var18;
                     }

                     this.miseAJourDepot(var18, var20, var26, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  } else if (var32 == 3) {
                     float var37 = 0.0F;
                     if (var6 != null) {
                        if (var6.getRecligPump() != 0.0D) {
                           var36 = var6.getRecligPump() * (double)var29;
                        } else {
                           var36 = var6.getRecligPrU() * (double)var29;
                        }

                        var37 = var6.getRecligQteUtil();
                     }

                     var24 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                     var26 = (var36 + var24) / (double)(var37 + this.receptionLigneAchats.getRecligQteUtil());
                     var30 = var6.getRecligPump();
                     if (var26 == 0.0D) {
                        var26 = var18;
                     }

                     this.miseAJourDepot(var18, var20, var26, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  } else {
                     this.miseAJourDepot(var18, var20, var18, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  }

                  this.pumpAchats = new PumpAchats();
                  this.pumpAchats.setPumDateCreat(new Date());
                  this.pumpAchats.setPumIdCreateur(this.usersLog.getUsrid());
                  this.pumpAchats.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
                  this.pumpAchats.setPumDate(this.receptionEnteteAchats.getRecDate());
                  this.pumpAchats.setPumIdDocOrigine(this.receptionEnteteAchats.getRecId());
                  this.pumpAchats.setPumNumDocOrigine(this.receptionEnteteAchats.getRecNum());
                  this.pumpAchats.setPumDossier(this.receptionEnteteAchats.getRecAnal4());
                  this.pumpAchats.setPumNatureOrigine(this.nature);
                  this.pumpAchats.setPumIdLigneOrigine(this.receptionLigneAchats.getRecligId());
                  this.pumpAchats.setPumProduit(this.receptionLigneAchats.getRecligCode());
                  this.pumpAchats.setPumDepot(this.receptionLigneAchats.getRecligDepot());
                  this.pumpAchats.setPumPa(this.receptionLigneAchats.getRecligPuRem());
                  this.pumpAchats.setPumPr(var18);
                  this.pumpAchats.setPumPrKg(var20);
                  if (var26 == 0.0D) {
                     var26 = var18;
                  }

                  this.pumpAchats.setPumPump(var26);
                  this.pumpAchats.setPumQteOperation(this.receptionLigneAchats.getRecligQteUtil());
                  this.pumpAchats.setPumQteStock(var28);
                  this.pumpAchats = this.pumpAchatsDao.insert(this.pumpAchats, var1);
                  this.receptionLigneAchats = this.receptionLigneAchatsDao.rechercheReception(var4, var1);
                  if (this.receptionLigneAchats != null) {
                     this.receptionLigneAchats.setRecligQteStock(var29);
                     this.receptionLigneAchats.setRecligPumpOld(var30);
                     if (var26 == 0.0D) {
                        var26 = var18;
                     }

                     this.receptionLigneAchats.setRecligPump(var26);
                     this.receptionLigneAchats.setRecligPr(var16);
                     this.receptionLigneAchats.setRecligPrU(var18);
                     this.receptionLigneAchats.setRecligPrKg(var20);
                     this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
                  }

                  List var38;
                  if (this.receptionLigneAchats.getRecligStock() != 2 && this.receptionLigneAchats.getRecligStock() != 3 && this.receptionLigneAchats.getRecligStock() != 4) {
                     if (this.receptionLigneAchats.getRecligStock() == 5) {
                        new ArrayList();
                        var38 = this.receptionSerieAchatsDao.selectReceptionSerieByRecLig(this.receptionLigneAchats, var1);
                        if (var38.size() != 0) {
                           this.receptionSerieAchats = new ReceptionSerieAchats();

                           for(var35 = 0; var35 < var38.size(); ++var35) {
                              this.receptionSerieAchats = (ReceptionSerieAchats)var38.get(var35);
                              this.receptionSerieAchats.setRecserPr(var18);
                              this.receptionSerieAchatsDao.modif(this.receptionSerieAchats, var1);
                           }
                        }
                     } else if (this.receptionLigneAchats.getRecligStock() == 1) {
                     }
                  } else {
                     new ArrayList();
                     var38 = this.receptionLotAchatsDao.selectReceptionLotByRecLig(this.receptionLigneAchats, var1);
                     if (var38.size() != 0) {
                        this.receptionLotAchats = new ReceptionLotAchats();

                        for(var35 = 0; var35 < var38.size(); ++var35) {
                           this.receptionLotAchats = (ReceptionLotAchats)var38.get(var35);
                           this.receptionLotAchats.setReclotPr(var18);
                           this.receptionLotAchatsDao.modif(this.receptionLotAchats, var1);
                        }
                     }
                  }
               }

               var1.flush();
               this.majSortie(var26, var1);
            } else {
               this.receptionLigneAchats.setRecligPump(this.receptionLigneAchats.getRecligPrU());
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
               var1.flush();
            }
         }
      }

   }

   public void calculPrCoefFamille(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.receptionEnteteAchats != null && this.lesLignesList.size() != 0) {
         new OptionVentes();
         LireLesoptionsVentes var3 = new LireLesoptionsVentes();
         var3.setStrId(this.structureLog.getStrid());
         var3.lancer();
         OptionVentes var2 = var3.getOptionsVentes();
         long var4 = 0L;
         double var6 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         this.calculStock = new CalculStock();
         new ReceptionLigneAchats();
         new InventaireLigne();
         InventaireLigneDao var14 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         new Stock();
         this.receptionLigneAchats = new ReceptionLigneAchats();

         for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
            this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var17);
            var4 = this.receptionLigneAchats.getRecligId();
            if (this.receptionEnteteAchats.getRecCoefDevise() == 0.0F) {
               this.receptionEnteteAchats.setRecCoefDevise(1.0F);
            }

            int var18 = Integer.parseInt(this.optionAchats.getNbDecPu());
            double var19 = 0.0D;
            if (this.receptionLigneAchats.getRecligFob() != 0.0D) {
               var19 = this.receptionLigneAchats.getRecligFob() + this.receptionLigneAchats.getRecligFret() + this.receptionLigneAchats.getRecligAssurance() + this.receptionLigneAchats.getRecligT1() + this.receptionLigneAchats.getRecligT3() + this.receptionLigneAchats.getRecligT5() + this.receptionLigneAchats.getRecligT10() + this.receptionLigneAchats.getRecligT30() + this.receptionLigneAchats.getRecligT31() + this.receptionLigneAchats.getRecligT46() + this.receptionLigneAchats.getRecligT53() + this.receptionLigneAchats.getRecligFrais() + this.receptionLigneAchats.getRecligFinancier();
            } else {
               var19 = this.receptionLigneAchats.getRecligPt() * (double)this.receptionEnteteAchats.getRecCoefValo();
            }

            if (this.optionAchats.getModCalcPr().equals("1")) {
               var19 += this.receptionLigneAchats.getRecligTva();
            }

            this.receptionLigneAchats.setRecligPr(var19);
            double var21 = 0.0D;
            double var23 = 0.0D;
            if (this.receptionLigneAchats.getRecligQteUtil() != 0.0F) {
               var21 = this.utilNombre.myRound(var19 / (double)this.receptionLigneAchats.getRecligQteUtil(), 2);
            } else if (this.receptionLigneAchats.getRecligQte() != 0.0F) {
               var21 = this.utilNombre.myRound(var19 / (double)this.receptionLigneAchats.getRecligQte(), 2);
            }

            this.receptionLigneAchats.setRecligPrU(var21);
            if (this.receptionLigneAchats.getRecligPoidsNet() != 0.0F) {
               var23 = this.utilNombre.myRound(var19 / (double)this.receptionLigneAchats.getRecligPoidsNet(), 2);
               this.receptionLigneAchats.setRecligPrKg(var23);
            } else {
               this.receptionLigneAchats.setRecligPrKg(0.0D);
            }

            if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty() && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
               if (this.produitsDepot != null) {
                  String var25 = "";
                  if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty() && this.receptionLigneAchats.getRecligFamille().contains(":")) {
                     String[] var26 = this.receptionLigneAchats.getRecligFamille().split(":");
                     var25 = var26[0];
                  } else {
                     var25 = this.receptionLigneAchats.getRecligFamille();
                  }

                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var25, var1);
                  float var35 = 0.0F;
                  if (this.famillesProduitsAchats != null) {
                     var35 = this.famillesProduitsAchats.getFamachCoefValDefaut();
                  } else {
                     var35 = 1.0F;
                  }

                  this.receptionLigneAchats.setRecligCoefPr(var35);
                  float var27 = 0.0F;
                  float var28 = 0.0F;
                  double var29 = 0.0D;
                  byte var31 = 0;
                  Date var32 = null;
                  InventaireLigne var13 = var14.rechercheBefore(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
                  ReceptionLigneAchats var12 = this.receptionLigneAchatsDao.rechercheBefore(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
                  if (var12 != null) {
                     var31 = 1;
                  } else if (var13 != null) {
                     var31 = 2;
                  }

                  int var34;
                  if (this.optionAchats.getModCalcPump().equals("1")) {
                     var31 = 3;
                  } else {
                     if (var13 != null) {
                        var32 = var13.getInventaireEntete().getInvDate();
                        var27 = var13.getInvligQteUtil();
                     } else {
                        var32 = this.exercicesAchats.getExeachDateDebut();
                     }

                     String var33 = "";
                     if (this.produitsDepot.getProduits().getProVteNat() != null && !this.produitsDepot.getProduits().getProVteNat().isEmpty()) {
                        var33 = this.produitsDepot.getProduits().getProVteNat();
                     } else {
                        var33 = this.produitsDepot.getProduits().getProAchNat();
                     }

                     List var15;
                     if (this.optionAchats.getModDepPump().equals("1")) {
                        var15 = this.calculStock.chargerMouvements(1, "", var33, this.receptionLigneAchats.getRecligCode(), "", (String)null, 0L, "", "", var32, this.receptionEnteteAchats.getRecDate(), false, false, true, true, false, false, true, true, true, true, true, false, false, true, true, true, false, false, true, false, true, var2.getGestionStockBc(), this.baseLog, this.structureLog, var1);
                     } else {
                        var15 = this.calculStock.chargerMouvements(1, "", var33, this.receptionLigneAchats.getRecligCode(), "", this.receptionLigneAchats.getRecligDepot(), 0L, "", "", var32, this.receptionEnteteAchats.getRecDate(), false, false, true, true, false, false, true, true, true, true, true, false, false, true, true, true, false, false, true, false, true, var2.getGestionStockBc(), this.baseLog, this.structureLog, var1);
                     }

                     if (var15.size() != 0) {
                        for(var34 = 0; var34 < var15.size(); ++var34) {
                           Stock var16 = (Stock)var15.get(var34);
                           var27 += var16.getStk_qte_in() - var16.getStk_qte_out();
                        }
                     }

                     if (var27 <= 0.0F) {
                        var31 = 0;
                     }
                  }

                  var28 = var27 - this.receptionLigneAchats.getRecligQteUtil();
                  if (var28 <= 0.0F) {
                     var28 = 0.0F;
                     var31 = 0;
                  }

                  if (var31 == 1) {
                     if (var12.getRecligPump() != 0.0D) {
                        var6 = var12.getRecligPump() * (double)var28;
                     } else {
                        var6 = var12.getRecligPrU() * (double)var28;
                     }

                     var8 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                     var10 = (var6 + var8) / (double)var27;
                     var29 = var12.getRecligPump();
                     if (var10 == 0.0D) {
                        var10 = var21;
                     }

                     this.miseAJourDepot(var21, var23, var10, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  } else if (var31 == 2) {
                     var6 = var13.getInvligPump() * (double)var28;
                     var8 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                     var10 = (var6 + var8) / (double)var27;
                     var29 = var13.getInvligPump();
                     if (var10 == 0.0D) {
                        var10 = var21;
                     }

                     this.miseAJourDepot(var21, var23, var10, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  } else if (var31 == 3) {
                     var6 = 0.0D;
                     float var36 = 0.0F;
                     if (var12 != null) {
                        if (var12.getRecligPump() != 0.0D) {
                           var6 = var12.getRecligPump() * (double)var28;
                        } else {
                           var6 = var12.getRecligPrU() * (double)var28;
                        }

                        var36 = var12.getRecligQteUtil();
                     }

                     var8 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                     var10 = (var6 + var8) / (double)(var36 + this.receptionLigneAchats.getRecligQteUtil());
                     var29 = var12.getRecligPump();
                     if (var10 == 0.0D) {
                        var10 = var21;
                     }

                     this.miseAJourDepot(var21, var23, var10, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  } else {
                     this.miseAJourDepot(var21, var23, var21, this.receptionEnteteAchats.getRecCoefValo(), var1);
                  }

                  this.pumpAchats = new PumpAchats();
                  this.pumpAchats.setPumDateCreat(new Date());
                  this.pumpAchats.setPumIdCreateur(this.usersLog.getUsrid());
                  this.pumpAchats.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
                  this.pumpAchats.setPumDate(this.receptionEnteteAchats.getRecDate());
                  this.pumpAchats.setPumIdDocOrigine(this.receptionEnteteAchats.getRecId());
                  this.pumpAchats.setPumNumDocOrigine(this.receptionEnteteAchats.getRecNum());
                  this.pumpAchats.setPumDossier(this.receptionEnteteAchats.getRecAnal4());
                  this.pumpAchats.setPumNatureOrigine(this.nature);
                  this.pumpAchats.setPumIdLigneOrigine(this.receptionLigneAchats.getRecligId());
                  this.pumpAchats.setPumProduit(this.receptionLigneAchats.getRecligCode());
                  this.pumpAchats.setPumDepot(this.receptionLigneAchats.getRecligDepot());
                  this.pumpAchats.setPumPa(this.receptionLigneAchats.getRecligPuRem());
                  this.pumpAchats.setPumPr(var21);
                  this.pumpAchats.setPumPrKg(var23);
                  if (var10 == 0.0D) {
                     var10 = var21;
                  }

                  this.pumpAchats.setPumPump(var10);
                  this.pumpAchats.setPumQteOperation(this.receptionLigneAchats.getRecligQteUtil());
                  this.pumpAchats.setPumQteStock(var27);
                  this.pumpAchats = this.pumpAchatsDao.insert(this.pumpAchats, var1);
                  this.receptionLigneAchats = this.receptionLigneAchatsDao.rechercheReception(var4, var1);
                  if (this.receptionLigneAchats != null) {
                     this.receptionLigneAchats.setRecligQteStock(var28);
                     this.receptionLigneAchats.setRecligPumpOld(var29);
                     if (var10 == 0.0D) {
                        var10 = var21;
                     }

                     this.receptionLigneAchats.setRecligPump(var10);
                     this.receptionLigneAchats.setRecligPr(var19);
                     this.receptionLigneAchats.setRecligPrU(var21);
                     this.receptionLigneAchats.setRecligPrKg(var23);
                     this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
                  }

                  List var37;
                  if (this.receptionLigneAchats.getRecligStock() != 2 && this.receptionLigneAchats.getRecligStock() != 3 && this.receptionLigneAchats.getRecligStock() != 4) {
                     if (this.receptionLigneAchats.getRecligStock() == 5) {
                        new ArrayList();
                        var37 = this.receptionSerieAchatsDao.selectReceptionSerieByRecLig(this.receptionLigneAchats, var1);
                        if (var37.size() != 0) {
                           for(var34 = 0; var34 < var37.size(); ++var34) {
                              this.receptionSerieAchats = new ReceptionSerieAchats();
                              this.receptionSerieAchats = (ReceptionSerieAchats)var37.get(var34);
                              this.receptionSerieAchats.setRecserPr(var21);
                              this.receptionSerieAchatsDao.modif(this.receptionSerieAchats, var1);
                           }
                        }
                     } else if (this.receptionLigneAchats.getRecligStock() == 1) {
                     }
                  } else {
                     new ArrayList();
                     var37 = this.receptionLotAchatsDao.selectReceptionLotByRecLig(this.receptionLigneAchats, var1);
                     if (var37.size() != 0) {
                        for(var34 = 0; var34 < var37.size(); ++var34) {
                           this.receptionLotAchats = new ReceptionLotAchats();
                           this.receptionLotAchats = (ReceptionLotAchats)var37.get(var34);
                           this.receptionLotAchats.setReclotPr(var21);
                           this.receptionLotAchatsDao.modif(this.receptionLotAchats, var1);
                        }
                     }
                  }
               }

               var1.flush();
               this.majSortie(var10, var1);
            } else {
               this.receptionLigneAchats.setRecligPump(this.receptionLigneAchats.getRecligPrU());
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
               var1.flush();
            }
         }
      }

   }

   public void miseAJourDepot(double var1, double var3, double var5, float var7, Session var8) throws HibernateException, NamingException {
      if (this.optionAchats.getModDepPump().equals("1")) {
         new ArrayList();
         List var9 = this.produitsDepotDao.selectProdDepByprod(this.receptionLigneAchats.getRecligCode(), var8);
         if (var9.size() != 0) {
            new ProduitsDepot();

            for(int var11 = 0; var11 < var9.size(); ++var11) {
               ProduitsDepot var10 = (ProduitsDepot)var9.get(var11);
               var10.setProdepPr(var1);
               var10.setProdepPrKg(var3);
               var10.setProdepPump(var5);
               var10.setProdepCoefPr(var7);
               this.produitsDepotDao.modif(var10, var8);
            }
         }
      } else {
         this.produitsDepot.setProdepPr(var1);
         this.produitsDepot.setProdepPrKg(var3);
         this.produitsDepot.setProdepPump(var5);
         this.produitsDepot.setProdepCoefPr(var7);
         this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var8);
      }

   }

   public void majSortie(double var1, Session var3) throws HibernateException, NamingException {
      Date var4 = null;
      new ReceptionLigneAchats();
      ReceptionLigneAchats var5 = this.receptionLigneAchatsDao.rechercheNext(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var3);
      if (var5 != null) {
         var4 = var5.getReceptionEnteteAchats().getRecDate();
      }

      String var6 = this.receptionLigneAchats.getRecligDepot();
      if (this.optionAchats.getModDepPump().equals("1")) {
         var6 = null;
      }

      new ArrayList();
      LivraisonLigneVentesDao var8 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var7.size() != 0) {
         new LivraisonLigneVentes();

         for(int var10 = 0; var10 < var7.size(); ++var10) {
            LivraisonLigneVentes var9 = (LivraisonLigneVentes)var7.get(var10);
            var9.setBlvligPump(var1);
            var8.modif(var9, var3);
         }
      }

      new ArrayList();
      RetourLigneVentesDao var30 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var29 = var30.chargerLesLinesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var29.size() != 0) {
         new RetourLigneVentes();

         for(int var12 = 0; var12 < var29.size(); ++var12) {
            RetourLigneVentes var11 = (RetourLigneVentes)var29.get(var12);
            var11.setBrtligPump(var1);
            var30.modifLigne(var11, var3);
         }
      }

      new ArrayList();
      FactureLigneVentesDao var32 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var31 = var32.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var31.size() != 0) {
         new FactureLigneVentes();

         for(int var14 = 0; var14 < var31.size(); ++var14) {
            FactureLigneVentes var13 = (FactureLigneVentes)var31.get(var14);
            var13.setFacligPump(var1);
            var32.modifLigne(var13, var3);
         }
      }

      new ArrayList();
      NoteDebitLigneVentesDao var34 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var33 = var34.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var33.size() != 0) {
         new NoteDebitLigneVentes();

         for(int var16 = 0; var16 < var33.size(); ++var16) {
            NoteDebitLigneVentes var15 = (NoteDebitLigneVentes)var33.get(var16);
            var15.setNdbligPump(var1);
            var34.modifLigne(var15, var3);
         }
      }

      new ArrayList();
      AvoirLigneVentesDao var36 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var35 = var36.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var35.size() != 0) {
         new AvoirLigneVentes();

         for(int var18 = 0; var18 < var35.size(); ++var18) {
            AvoirLigneVentes var17 = (AvoirLigneVentes)var35.get(var18);
            var17.setAvrligPump(var1);
            var36.modifLigne(var17, var3);
         }
      }

      new ArrayList();
      InventaireLigneDao var38 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      List var37 = var38.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var37.size() != 0) {
         new InventaireLigne();

         for(int var20 = 0; var20 < var37.size(); ++var20) {
            InventaireLigne var19 = (InventaireLigne)var37.get(var20);
            var19.setInvligPump(var1);
            var38.modifLigne(var19, var3);
         }
      }

      new ArrayList();
      BonEntreeLigneDao var40 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      List var39 = var40.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var39.size() != 0) {
         new BonEntreeLigne();

         for(int var22 = 0; var22 < var39.size(); ++var22) {
            BonEntreeLigne var21 = (BonEntreeLigne)var39.get(var22);
            var21.setBinligPump(var1);
            var40.modifLigne(var21, var3);
         }
      }

      new ArrayList();
      BonSortieLigneDao var42 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      List var41 = var42.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var41.size() != 0) {
         new BonSortieLigne();

         for(int var24 = 0; var24 < var41.size(); ++var24) {
            BonSortieLigne var23 = (BonSortieLigne)var41.get(var24);
            var23.setBouligPump(var1);
            var42.modifLigne(var23, var3);
         }
      }

      new ArrayList();
      CessionLigneDao var44 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      List var43 = var44.chargerLesLignesDestinationValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var43.size() != 0) {
         new CessionLigne();

         for(int var26 = 0; var26 < var43.size(); ++var26) {
            CessionLigne var25 = (CessionLigne)var43.get(var26);
            var25.setCesligPump(var1);
            var44.modifLigne(var25, var3);
         }
      }

      new ArrayList();
      FabricationLigneAchatsDao var46 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var45 = var46.chargerLesLignesFabricationValorisation(this.receptionLigneAchats.getRecligCode(), var6, this.receptionEnteteAchats.getRecDate(), var4, var3);
      if (var45.size() != 0) {
         new FabricationLigneAchats();

         for(int var28 = 0; var28 < var45.size(); ++var28) {
            FabricationLigneAchats var27 = (FabricationLigneAchats)var45.get(var28);
            var27.setFabligPump(var1);
            var46.modifLigne(var27, var3);
         }
      }

   }

   public void annuleCoefValo(Session var1) throws HibernateException, NamingException {
      if (this.receptionEnteteAchats != null && this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var2);
            if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty() && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
               if (this.produitsDepot != null) {
                  this.pumpAchats = new PumpAchats();
                  this.pumpAchats = this.pumpAchatsDao.chargePumpByIdDoc(this.receptionEnteteAchats.getRecId(), this.nature, var1);
                  if (this.pumpAchats != null) {
                     this.pumpAchatsDao.delete(this.pumpAchats, var1);
                  }

                  double var3 = this.calculStock.rechercheDernierPr(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.baseLog, var1);
                  double var5 = this.calculStock.rechercheDernierPump(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.baseLog, var1);
                  this.produitsDepot.setProdepPr(var3);
                  this.produitsDepot.setProdepPump(var5);
                  this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var1);
               }

               this.razSortie(var1);
            }
         }
      }

   }

   public void razSortie(Session var1) throws HibernateException, NamingException {
      Date var2 = null;
      new ReceptionLigneAchats();
      ReceptionLigneAchats var3 = this.receptionLigneAchatsDao.rechercheNext(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
      if (var3 != null) {
         var2 = var3.getReceptionEnteteAchats().getRecDate();
      }

      String var4 = this.receptionLigneAchats.getRecligDepot();
      if (this.optionAchats.getModDepPump().equals("1")) {
         var4 = null;
      }

      new ArrayList();
      LivraisonLigneVentesDao var6 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var5 = var6.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var5.size() != 0) {
         new LivraisonLigneVentes();

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            LivraisonLigneVentes var7 = (LivraisonLigneVentes)var5.get(var8);
            var7.setBlvligPump(0.0D);
            var6.modif(var7, var1);
         }
      }

      new ArrayList();
      RetourLigneVentesDao var28 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var27 = var28.chargerLesLinesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var27.size() != 0) {
         new RetourLigneVentes();

         for(int var10 = 0; var10 < var27.size(); ++var10) {
            RetourLigneVentes var9 = (RetourLigneVentes)var27.get(var10);
            var9.setBrtligPump(0.0D);
            var28.modifLigne(var9, var1);
         }
      }

      new ArrayList();
      FactureLigneVentesDao var30 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var29 = var30.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var29.size() != 0) {
         new FactureLigneVentes();

         for(int var12 = 0; var12 < var29.size(); ++var12) {
            FactureLigneVentes var11 = (FactureLigneVentes)var29.get(var12);
            var11.setFacligPump(0.0D);
            var30.modifLigne(var11, var1);
         }
      }

      new ArrayList();
      NoteDebitLigneVentesDao var32 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var31 = var32.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var31.size() != 0) {
         new NoteDebitLigneVentes();

         for(int var14 = 0; var14 < var31.size(); ++var14) {
            NoteDebitLigneVentes var13 = (NoteDebitLigneVentes)var31.get(var14);
            var13.setNdbligPump(0.0D);
            var32.modifLigne(var13, var1);
         }
      }

      new ArrayList();
      AvoirLigneVentesDao var34 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var33 = var34.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var33.size() != 0) {
         new AvoirLigneVentes();

         for(int var16 = 0; var16 < var33.size(); ++var16) {
            AvoirLigneVentes var15 = (AvoirLigneVentes)var33.get(var16);
            var15.setAvrligPump(0.0D);
            var34.modifLigne(var15, var1);
         }
      }

      new ArrayList();
      InventaireLigneDao var36 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      List var35 = var36.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var35.size() != 0) {
         new InventaireLigne();

         for(int var18 = 0; var18 < var35.size(); ++var18) {
            InventaireLigne var17 = (InventaireLigne)var35.get(var18);
            var17.setInvligPump(0.0D);
            var36.modifLigne(var17, var1);
         }
      }

      new ArrayList();
      BonEntreeLigneDao var38 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      List var37 = var38.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var37.size() != 0) {
         new BonEntreeLigne();

         for(int var20 = 0; var20 < var37.size(); ++var20) {
            BonEntreeLigne var19 = (BonEntreeLigne)var37.get(var20);
            var19.setBinligPump(0.0D);
            var38.modifLigne(var19, var1);
         }
      }

      new ArrayList();
      BonSortieLigneDao var40 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      List var39 = var40.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var39.size() != 0) {
         new BonSortieLigne();

         for(int var22 = 0; var22 < var39.size(); ++var22) {
            BonSortieLigne var21 = (BonSortieLigne)var39.get(var22);
            var21.setBouligPump(0.0D);
            var40.modifLigne(var21, var1);
         }
      }

      new ArrayList();
      CessionLigneDao var42 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      List var41 = var42.chargerLesLignesDestinationValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var41.size() != 0) {
         new CessionLigne();

         for(int var24 = 0; var24 < var41.size(); ++var24) {
            CessionLigne var23 = (CessionLigne)var41.get(var24);
            var23.setCesligPump(0.0D);
            var42.modifLigne(var23, var1);
         }
      }

      new ArrayList();
      FabricationLigneAchatsDao var44 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var43 = var44.chargerLesLignesFabricationValorisation(this.receptionLigneAchats.getRecligCode(), var4, this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var43.size() != 0) {
         new FabricationLigneAchats();

         for(int var26 = 0; var26 < var43.size(); ++var26) {
            FabricationLigneAchats var25 = (FabricationLigneAchats)var43.get(var26);
            var25.setFabligPump(0.0D);
            var44.modifLigne(var25, var1);
         }
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.receptionEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         long var3 = this.receptionEnteteAchats.getRecId();
         String var5 = this.receptionEnteteAchats.getRecNum();
         Date var6 = this.receptionEnteteAchats.getRecDate();
         if (this.lesLignesList.size() != 0) {
            for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var7);
               if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
               } else {
                  this.produits = null;
               }

               this.calculStock.majReceptionAchatsATT(this.receptionLigneAchats, this.produits, 0.0F, 2, this.baseLog, var1);
            }
         }

         new ArrayList();
         List var19 = this.receptionSerieAchatsDao.selectReceptionSerieByRecEnt(this.receptionEnteteAchats, var1);
         if (var19.size() != 0) {
            this.receptionSerieAchatsDao.deleteAllSerie(var19, var1);
         }

         this.receptionLigneAchatsDao.deleteAllLigne(this.receptionEnteteAchats, var1);
         this.utilParapheur.supprimerParapheur(this.receptionEnteteAchats.getRecId(), this.nature, var1);
         this.receptionEnteteAchatsDao.delete(this.receptionEnteteAchats.getRecId(), var1);
         this.documentTraceAchats = new DocumentTraceAchats();
         this.documentTraceAchats = this.documentTraceAchatsDao.chercherDestinationTrace(var3, this.nature, var1);
         if (this.documentTraceAchats != null) {
            long var8 = this.documentTraceAchats.getDoctrfOrgId();
            int var10 = this.documentTraceAchats.getDoctrfOrgType();
            this.documentTraceAchatsDao.delete(this.documentTraceAchats, var1);
            boolean var11 = false;
            this.documentTraceAchats = this.documentTraceAchatsDao.chercherOrigineTrace(var8, var10, var1);
            byte var22;
            if (this.documentTraceAchats != null) {
               var22 = 4;
            } else {
               var22 = 1;
            }

            if (var10 == 12) {
               new CommandeEnteteAchats();
               CommandeEnteteAchatsDao var13 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               CommandeEnteteAchats var12 = var13.pourParapheur(var8, var1);
               if (var12 != null) {
                  var12.setCmdEtat(var22);
                  if (var22 == 1) {
                     var12.setCmdDateTransforme((Date)null);
                     var12.setCmdTypeTransforme(0);
                  }

                  var13.modif(var12, var1);
               }
            }
         }

         if (this.optionAchats.getAxeDossier().equals("2") && this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
            PlansAnalytiques var20 = this.plansAnalytiquesDao.rechercheAffaire(this.receptionEnteteAchats.getRecAnal4(), var1);
            if (var20 != null) {
               var20.setAnaAffaireDateReception((Date)null);
               this.plansAnalytiquesDao.modif(var20, var1);
            }
         }

         Espion var21 = new Espion();
         var21.setUsers(this.usersLog);
         var21.setEsptype(0);
         var21.setEspdtecreat(new Date());
         var21.setEspaction("Suppression réception N° " + var5 + " du " + var6);
         this.espionDao.mAJEspion(var21, var1);
         var2.commit();
      } catch (HibernateException var17) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var17;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.receptionEnteteAchats.getRecId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.receptionEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.receptionEnteteAchats.setUsers(this.usersLog);
            this.receptionEnteteAchats.setRecIdCreateur(this.usersLog.getUsrid());
            this.receptionEnteteAchats.setRecNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.receptionEnteteAchats.setRecDate(new Date());
            this.receptionEnteteAchats.setRecDateCreat(new Date());
            this.receptionEnteteAchats.setRecDateModif((Date)null);
            this.receptionEnteteAchats.setRecIdModif(0L);
            this.receptionEnteteAchats.setRecNomModif("");
            this.receptionEnteteAchats.setRecNum("");
            this.receptionEnteteAchats.setRecIdResponsable(this.usersLog.getUsrid());
            this.receptionEnteteAchats.setRecNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.receptionEnteteAchats.setRecDateLivraison((Date)null);
            if (!this.receptionEnteteAchats.getRecSerie().equalsIgnoreCase("X") && !this.receptionEnteteAchats.getRecSerie().isEmpty()) {
               this.receptionEnteteAchats.setRecNum(this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), this.nature, this.receptionEnteteAchats.getRecSerie(), var1));
            } else {
               long var3 = this.receptionEnteteAchatsDao.selectLastNum(var1);
               this.receptionEnteteAchats.setRecNum("" + var3);
            }

            this.verifieExistenceHabilitation(var1);
            this.receptionEnteteAchats.setRecDateAnnule((Date)null);
            this.receptionEnteteAchats.setRecMotifAnnule("");
            this.receptionEnteteAchats.setRecDateImp((Date)null);
            this.receptionEnteteAchats.setRecDateTransforme((Date)null);
            this.receptionEnteteAchats.setRecEtat(0);
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.duppliquer(this.receptionEnteteAchats, var1);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.receptionEnteteAchats.getRecId(), this.receptionEnteteAchats.getRecNum(), this.receptionEnteteAchats.getRecNomTiers(), this.receptionEnteteAchats.getRecDate(), this.receptionEnteteAchats.getRecDevise(), this.receptionEnteteAchats.getRecTotTtc() + this.receptionEnteteAchats.getRecTotTc(), this.receptionEnteteAchats.getRecModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var1), this.calculeParc(var1), this.receptionEnteteAchats.getVar_format_devise(), 0, var1);
            }

            if (this.lesLignesList.size() != 0) {
               this.receptionLigneAchatsDao.duppliquerLigne(this.lesLignesList, this.receptionEnteteAchats, var1);
            }

            this.chargeListeDetail(var1);
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

   }

   public void duppliquerNegatifDocument() throws HibernateException, NamingException, Exception {
      if (this.receptionEnteteAchats.getRecId() >= 0L) {
         long var1 = this.receptionEnteteAchats.getRecId();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
         this.chargerDocumentLigne(var3);
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            this.receptionEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.receptionEnteteAchats.setUsers(this.usersLog);
            this.receptionEnteteAchats.setRecIdCreateur(this.usersLog.getUsrid());
            this.receptionEnteteAchats.setRecNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.receptionEnteteAchats.setRecDateCreat(new Date());
            this.receptionEnteteAchats.setRecDateModif((Date)null);
            this.receptionEnteteAchats.setRecIdModif(0L);
            this.receptionEnteteAchats.setRecNomModif("");
            this.receptionEnteteAchats.setRecNum("");
            this.receptionEnteteAchats.setRecIdResponsable(this.usersLog.getUsrid());
            this.receptionEnteteAchats.setRecNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.receptionEnteteAchats.setRecDateLivraison((Date)null);
            this.receptionEnteteAchats.setRecSerie("D");
            if (!this.receptionEnteteAchats.getRecSerie().equalsIgnoreCase("X") && !this.receptionEnteteAchats.getRecSerie().isEmpty()) {
               this.receptionEnteteAchats.setRecNum(this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), this.nature, this.receptionEnteteAchats.getRecSerie(), var3));
            } else {
               long var5 = this.receptionEnteteAchatsDao.selectLastNum(var3);
               this.receptionEnteteAchats.setRecNum("" + var5);
            }

            this.verifieExistenceHabilitation(var3);
            this.receptionEnteteAchats.setRecDateAnnule((Date)null);
            this.receptionEnteteAchats.setRecMotifAnnule("");
            this.receptionEnteteAchats.setRecDateImp((Date)null);
            this.receptionEnteteAchats.setRecDateTransforme((Date)null);
            this.receptionEnteteAchats.setRecEtat(0);
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.duppliquerNegatif(this.receptionEnteteAchats, var3);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.receptionEnteteAchats.getRecId(), this.receptionEnteteAchats.getRecNum(), this.receptionEnteteAchats.getRecNomTiers(), this.receptionEnteteAchats.getRecDate(), this.receptionEnteteAchats.getRecDevise(), this.receptionEnteteAchats.getRecTotTtc() + this.receptionEnteteAchats.getRecTotTc(), this.receptionEnteteAchats.getRecModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var3), this.calculeParc(var3), this.receptionEnteteAchats.getVar_format_devise(), 0, var3);
            }

            if (this.lesLignesList.size() != 0) {
               this.receptionLigneAchatsDao.duppliquerNegatifLigne(this.lesLignesList, this.receptionEnteteAchats, var3);
            }

            new ReceptionEnteteAchats();
            ReceptionEnteteAchats var12 = this.receptionEnteteAchatsDao.pourParapheur(var1, var3);
            if (var12 != null) {
               var12.setRecExcluValo(true);
               this.receptionEnteteAchatsDao.modif(var12, var3);
            }

            this.chargeListeDetail(var3);
            var4.commit();
         } catch (HibernateException var10) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void transformerDocument() throws HibernateException, NamingException {
      this.documentDetailTrf.clear();
      this.lesLignesList.clear();
      this.var_date_trf = null;
      this.var_type_trf = 0;
      this.var_mode_trf = "";
      this.var_aff_trf = false;
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      if (this.lesEntetesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         boolean var4 = false;
         if (this.receptionEnteteAchats.getRecTypeTransforme() != 0) {
            var4 = this.usersChronoDao.existByUserNat(this.usersLog, this.receptionEnteteAchats.getRecTypeTransforme(), var1);
            if (var4) {
               String var5 = "";
               if (this.receptionEnteteAchats.getRecTypeTransforme() == 12) {
                  var5 = "Commande";
               } else if (this.receptionEnteteAchats.getRecTypeTransforme() == 13) {
                  var5 = "Réception";
               } else if (this.receptionEnteteAchats.getRecTypeTransforme() == 14) {
                  var5 = "Bon retour";
               } else if (this.receptionEnteteAchats.getRecTypeTransforme() == 15) {
                  var5 = "Facture";
               } else if (this.receptionEnteteAchats.getRecTypeTransforme() == 16) {
                  var5 = "Avoir";
               } else if (this.receptionEnteteAchats.getRecTypeTransforme() == 17) {
                  var5 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.receptionEnteteAchats.getRecTypeTransforme(), var5));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 14, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(14, "Retour"));
            }

            var3 = this.usersChronoDao.existByUserNat(this.usersLog, 15, var1);
            if (var3) {
               this.documentTrfItems.add(new SelectItem(15, "Facture"));
            }
         }

         for(int var9 = 0; var9 < this.lesEntetesList.size(); ++var9) {
            new ReceptionEnteteAchats();
            ReceptionEnteteAchats var6 = (ReceptionEnteteAchats)this.lesEntetesList.get(var9);
            if (var6.getRecId() > 0L && var6.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.receptionLigneAchatsDao.chargerLesLignes(var6, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                     new ReceptionLigneAchats();
                     ReceptionLigneAchats var8 = (ReceptionLigneAchats)this.lesLignesList.get(var7);
                     this.documentDetailTrf.add(var8);
                  }
               }
            }
         }

         this.lesLignesList.clear();
         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         this.utilInitHibernate.closeSession();
      }

   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void chargerModeEcheanceAffichage() {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      if (this.receptionEnteteAchats.getRecTypeReg() != 0 && this.receptionEnteteAchats.getRecTypeReg() != 3) {
         if (this.receptionEnteteAchats.getRecTypeReg() != 1 && this.receptionEnteteAchats.getRecTypeReg() != 2 && this.receptionEnteteAchats.getRecTypeReg() != 10) {
            if (this.receptionEnteteAchats.getRecTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.receptionEnteteAchats.getRecModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.receptionEnteteAchats.getRecModeReg() != null && !this.receptionEnteteAchats.getRecModeReg().isEmpty() && this.receptionEnteteAchats.getRecModeReg().contains(":")) {
         String[] var2 = this.receptionEnteteAchats.getRecModeReg().split(":");
         var1 = var2[0];
      }

      ObjetReglement var3;
      int var6;
      for(var6 = 0; var6 < this.lesModeReglementFournisseurListe.size(); ++var6) {
         new ObjetReglement();
         var3 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var6);
         if (var3.getCategories().equals(var1)) {
            if (var3.getEcheances() == null || var3.getEcheances().isEmpty()) {
               var3.setEcheances("0");
            }

            this.receptionEnteteAchats.setRecTypeReg(Integer.parseInt(var3.getEcheances()));
            this.receptionEnteteAchats.setRecModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.receptionEnteteAchats.setRecNbJourReg(0);
            this.receptionEnteteAchats.setRecArrondiReg(0);
            break;
         }
      }

      if (this.receptionEnteteAchats.getRecTypeReg() != 0 && this.receptionEnteteAchats.getRecTypeReg() != 3) {
         if (this.receptionEnteteAchats.getRecTypeReg() != 1 && this.receptionEnteteAchats.getRecTypeReg() != 2 && this.receptionEnteteAchats.getRecTypeReg() != 10) {
            if (this.receptionEnteteAchats.getRecTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementFournisseurListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.receptionEnteteAchats.setRecTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.receptionEnteteAchats.setRecModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.receptionEnteteAchats.setRecNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.receptionEnteteAchats.setRecArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.receptionEnteteAchats.getRecModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.receptionEnteteAchats.getRecDate(), this.receptionEnteteAchats.getRecTypeReg(), this.receptionEnteteAchats.getRecNbJourReg(), this.receptionEnteteAchats.getRecArrondiReg());
      this.receptionEnteteAchats.setRecDateEcheReg(var1);
   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.receptionEnteteAchats.getRecIncoterm() != null && !this.receptionEnteteAchats.getRecIncoterm().isEmpty()) {
            if (this.receptionEnteteAchats.getRecIncoterm().equals("CFR")) {
               this.receptionEnteteAchats.setRecTotAssurance(0.0D);
               this.receptionEnteteAchats.setRecTotAssuranceLocal(0.0D);
               this.receptionEnteteAchats.setRecTotFret2(0.0D);
               this.receptionEnteteAchats.setRecTotFret2Local(0.0D);
            } else if (this.receptionEnteteAchats.getRecIncoterm().equals("CIF")) {
               this.receptionEnteteAchats.setRecTotFret2(0.0D);
               this.receptionEnteteAchats.setRecTotFret2Local(0.0D);
            } else if (this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
               this.receptionEnteteAchats.setRecTotAssurance(0.0D);
               this.receptionEnteteAchats.setRecTotAssuranceLocal(0.0D);
            } else if (this.receptionEnteteAchats.getRecIncoterm().equals("EXW")) {
               this.receptionEnteteAchats.setRecTotAssurance(0.0D);
               this.receptionEnteteAchats.setRecTotAssuranceLocal(0.0D);
               this.receptionEnteteAchats.setRecTotFret(0.0D);
               this.receptionEnteteAchats.setRecTotFretLocal(0.0D);
            }
         } else {
            this.receptionEnteteAchats.setRecTotAssurance(0.0D);
            this.receptionEnteteAchats.setRecTotAssuranceLocal(0.0D);
            this.receptionEnteteAchats.setRecTotFret(0.0D);
            this.receptionEnteteAchats.setRecTotFretLocal(0.0D);
            this.receptionEnteteAchats.setRecTotFret2(0.0D);
            this.receptionEnteteAchats.setRecTotFret2Local(0.0D);
         }

         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var3);
               this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), var1);
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
            }
         }

         this.cumulPrix();
         if (this.receptionEnteteAchats.getRecValorisation() == 1 || this.receptionEnteteAchats.getRecValorisation() == 2) {
            this.receptionEnteteAchats.setRecCoefValo(0.0F);
         }

         if (this.receptionEnteteAchats.getRecDevise().equals(this.structureLog.getStrdevise())) {
            this.receptionEnteteAchats.setRecTotHtLocal(this.receptionEnteteAchats.getRecTotHt());
            this.receptionEnteteAchats.setRecTotTvaLocal(this.receptionEnteteAchats.getRecTotTva());
            this.receptionEnteteAchats.setRecTotTtcLocal(this.receptionEnteteAchats.getRecTotTtc());
            this.receptionEnteteAchats.setRecTotRemiseLocal(this.receptionEnteteAchats.getRecTotRemise());
            this.receptionEnteteAchats.setRecTotRabaisLocal(this.receptionEnteteAchats.getRecTotRabais());
            this.receptionEnteteAchats.setRecTotFretLocal(this.receptionEnteteAchats.getRecTotFret());
            this.receptionEnteteAchats.setRecTotFret2Local(this.receptionEnteteAchats.getRecTotFret2());
            this.receptionEnteteAchats.setRecTotAssuranceLocal(this.receptionEnteteAchats.getRecTotAssurance());
            this.receptionEnteteAchats.setRecTotCertificatLocal(this.receptionEnteteAchats.getRecTotCertificat());
            this.receptionEnteteAchats.setRecTotCertificatConformiteLocal(this.receptionEnteteAchats.getRecTotCertificatConformite());
            this.receptionEnteteAchats.setRecTotFraisAdmLocal(this.receptionEnteteAchats.getRecTotFraisAdmLocal());
         } else {
            this.calculDevise(var1);
            this.receptionEnteteAchats.setRecTotHtLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotHt() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotTvaLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotTva() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotTtcLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotTtc() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotRemiseLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotRemise() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotRabaisLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotRabais() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotFretLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotFret() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotFret2Local(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotFret2() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotAssuranceLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotAssurance() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotCertificatLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotCertificat() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotCertificatConformiteLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotCertificatConformite() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
            this.receptionEnteteAchats.setRecTotFraisAdmLocal(this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotFraisAdm() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
         }

         this.receptionEnteteAchats.setRecDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.receptionEnteteAchats.getUsers() == null) {
            this.receptionEnteteAchats.setUsers(this.usersLog);
         }

         this.receptionEnteteAchats.setTiers(this.tiers);
         if ((this.receptionEnteteAchats.getRecCat() == null || this.receptionEnteteAchats.getRecCat().isEmpty()) && this.receptionEnteteAchats.getTiers().getTienomfamille() != null && !this.receptionEnteteAchats.getTiers().getTienomfamille().isEmpty()) {
            this.receptionEnteteAchats.setRecCat(this.receptionEnteteAchats.getTiers().getTienomfamille());
         }

         if (!this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.receptionEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.receptionEnteteAchats.setRecCivilTiers("");
         } else {
            this.receptionEnteteAchats.setRecCivilTiers(this.receptionEnteteAchats.getTiers().getTiecivilite());
         }

         if (this.receptionEnteteAchats.getRecDiversTiers() == 99) {
            this.receptionEnteteAchats.setRecIdContact(0L);
            this.receptionEnteteAchats.setRecNomContact("");
            this.receptionEnteteAchats.setRecCivilContact("");
         } else {
            new Contacts();
            Contacts var17 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
            if (var17 != null) {
               this.receptionEnteteAchats.setRecIdContact(var17.getConid());
               this.receptionEnteteAchats.setRecNomContact(var17.getConpatronyme());
               this.receptionEnteteAchats.setRecCivilContact(var17.getConcivilite());
            } else {
               this.receptionEnteteAchats.setRecIdContact(0L);
               this.receptionEnteteAchats.setRecNomContact("");
               this.receptionEnteteAchats.setRecCivilContact("");
            }
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var18 = this.usersDao.selectLeUserPatronyme(this.receptionEnteteAchats.getRecNomResponsable(), var1);
         if (var18 != null) {
            this.receptionEnteteAchats.setRecIdResponsable(var18.getUsrid());
            this.receptionEnteteAchats.setRecNomResponsable(var18.getUsrPatronyme());
         } else {
            this.receptionEnteteAchats.setRecIdResponsable(0L);
            this.receptionEnteteAchats.setRecNomResponsable("");
         }

         if (this.receptionEnteteAchats.getRecValorisation() == 0 && this.receptionEnteteAchats.getRecCoefValo() == 0.0F) {
            this.receptionEnteteAchats.setRecCoefValo(1.0F);
         }

         if (this.receptionEnteteAchats.getRecId() == 0L) {
            this.receptionEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.receptionEnteteAchats.setRecDateCreat(new Date());
            this.receptionEnteteAchats.setRecIdCreateur(this.usersLog.getUsrid());
            this.receptionEnteteAchats.setRecNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.receptionEnteteAchats.getRecSerie() != null && !this.receptionEnteteAchats.getRecSerie().equalsIgnoreCase("X") && !this.receptionEnteteAchats.getRecSerie().isEmpty()) {
               this.receptionEnteteAchats.setRecNum(this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), this.nature, this.receptionEnteteAchats.getRecSerie(), var1));
               boolean var19 = false;

               label703:
               while(true) {
                  while(true) {
                     if (var19) {
                        break label703;
                     }

                     new ReceptionEnteteAchats();
                     ReceptionEnteteAchats var5 = this.receptionEnteteAchatsDao.pourParapheur(this.receptionEnteteAchats.getRecNum(), this.receptionEnteteAchats.getRecSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.receptionEnteteAchats.setRecNum(this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), this.nature, this.receptionEnteteAchats.getRecSerie(), var1));
                        var19 = false;
                     } else {
                        var19 = true;
                     }
                  }
               }
            } else {
               long var4 = this.receptionEnteteAchatsDao.selectLastNum(var1);
               this.receptionEnteteAchats.setRecNum("" + var4);
            }

            this.receptionEnteteAchats.setRecMaj(1);
            this.receptionEnteteAchats.setRecEtat(0);
            this.receptionEnteteAchats.setRecEtatVal(0);
            this.receptionEnteteAchats.setRecDateValide((Date)null);
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.insert(this.receptionEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.receptionEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            if (this.receptionEnteteAchats.getRecEtat() == 6) {
               if (this.receptionEnteteAchats.getRecEtatVal() == 1) {
                  this.receptionEnteteAchats.setRecEtat(0);
               } else {
                  this.receptionEnteteAchats.setRecEtat(0);
               }
            }

            if (this.modeReception == 2 && this.lesPlaningsAviculture.size() != 0 && (this.receptionEnteteAchats.getRecProduction() == null || this.receptionEnteteAchats.getRecProduction().isEmpty())) {
               this.receptionEnteteAchats.setRecProduction(this.receptionEnteteAchats.getRecNum());
            }

            this.receptionEnteteAchats.setRecDateModif(new Date());
            this.receptionEnteteAchats.setRecIdModif(this.usersLog.getUsrid());
            this.receptionEnteteAchats.setRecNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.receptionEnteteAchats.setRecMaj(0);
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.receptionEnteteAchats.getRecId(), this.receptionEnteteAchats.getRecNum(), this.receptionEnteteAchats.getRecNomTiers(), this.receptionEnteteAchats.getRecDate(), this.receptionEnteteAchats.getRecDevise(), this.receptionEnteteAchats.getRecTotTtc() + this.receptionEnteteAchats.getRecTotTc(), this.receptionEnteteAchats.getRecModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var1), this.calculeParc(var1), this.receptionEnteteAchats.getVar_format_devise(), 0, var1);
         }

         if (this.modeReception == 2 && this.lesPlaningsAviculture.size() != 0) {
            for(int var20 = 0; var20 < this.lesPlaningsAviculture.size(); ++var20) {
               this.receptionAvicultureAchats = (ReceptionAvicultureAchats)this.lesPlaningsAviculture.get(var20);
               if (this.receptionAvicultureAchats.getRecaviId() == 0L) {
                  this.receptionAvicultureAchats = this.receptionAvicultureAchatsDao.insertLigne(this.receptionAvicultureAchats, var1);
               } else {
                  this.receptionAvicultureAchats = this.receptionAvicultureAchatsDao.modifLigne(this.receptionAvicultureAchats, var1);
               }
            }
         }

         if (this.optionAchats.getChargerFRA().equals("1") && this.lesFraisDirects.size() != 0) {
            String var22 = "";

            for(int var21 = 0; var21 < this.lesFraisDirects.size(); ++var21) {
               if (((FraisLigneAchats)this.lesFraisDirects.get(var21)).getFraisEnteteAchats() != null && ((FraisLigneAchats)this.lesFraisDirects.get(var21)).getFraisEnteteAchats().getFsfNum() != null && !((FraisLigneAchats)this.lesFraisDirects.get(var21)).getFraisEnteteAchats().getFsfNum().isEmpty()) {
                  var22 = ((FraisLigneAchats)this.lesFraisDirects.get(var21)).getFraisEnteteAchats().getFsfNum();
                  break;
               }
            }

            new FraisEnteteAchats();
            FraisEnteteAchatsDao var24 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            FraisLigneAchatsDao var7 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            FraisEnteteAchats var23;
            if (var22 != null && !var22.isEmpty()) {
               var23 = var24.pourParapheur(var22, "", var1);
            } else {
               var22 = this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), 18, this.receptionEnteteAchats.getRecSerie(), var1);
               var23 = new FraisEnteteAchats();
            }

            var23.setFsfDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
            var23.setFsfDevise(this.receptionEnteteAchats.getRecDevise());
            var23.setFsfCoefDevise(this.receptionEnteteAchats.getRecCoefDevise());
            var23.setFsfSerie(this.receptionEnteteAchats.getRecSerie());
            var23.setFsfAffaire(this.receptionEnteteAchats.getRecAffaire());
            var23.setFsfAnal4(this.receptionEnteteAchats.getRecAnal4());
            var23.setFsfNumDoc(this.receptionEnteteAchats.getRecNum());
            if (var23.getUsers() == null) {
               var23.setUsers(this.usersLog);
            }

            var23.setTiers(this.receptionEnteteAchats.getTiers());
            var23.setFsfNomTiers(this.receptionEnteteAchats.getRecNomTiers());
            if ((var23.getFsfCat() == null || var23.getFsfCat().isEmpty()) && var23.getTiers().getTienomfamille() != null && !var23.getTiers().getTienomfamille().isEmpty()) {
               var23.setFsfCat(var23.getTiers().getTienomfamille());
            }

            if (!var23.getTiers().getTiegenre().equalsIgnoreCase("010") && !var23.getTiers().getTiegenre().equalsIgnoreCase("020") && !var23.getTiers().getTiegenre().equalsIgnoreCase("030") && !var23.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               var23.setFsfCivilTiers("");
            } else {
               var23.setFsfCivilTiers(var23.getTiers().getTiecivilite());
            }

            if (var23.getFsfDiversTiers() == 99) {
               var23.setFsfIdContact(0L);
               var23.setFsfNomContact("");
               var23.setFsfCivilContact("");
            } else {
               new Contacts();
               Contacts var25 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var25 != null) {
                  var23.setFsfIdContact(var25.getConid());
                  var23.setFsfNomContact(var25.getConpatronyme());
                  var23.setFsfCivilContact(var25.getConcivilite());
               } else {
                  var23.setFsfIdContact(0L);
                  var23.setFsfNomContact("");
                  var23.setFsfCivilContact("");
               }
            }

            new Users();
            if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
               this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
            }

            var18 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
            if (var18 != null) {
               var23.setFsfIdResponsable(var18.getUsrid());
               var23.setFsfNomResponsable(var18.getUsrPatronyme());
            } else {
               var23.setFsfIdResponsable(0L);
               var23.setFsfNomResponsable("");
            }

            double var26 = 0.0D;
            int var10;
            if (this.lesFraisDirects.size() != 0) {
               for(var10 = 0; var10 < this.lesFraisDirects.size(); ++var10) {
                  if (((FraisLigneAchats)this.lesFraisDirects.get(var10)).getFsfligMode() == 4) {
                     var26 += ((FraisLigneAchats)this.lesFraisDirects.get(var10)).getFsfligTtc();
                  }
               }
            }

            var23.setFsfTotTvaDouane(var26);
            if (var23.getFsfId() != 0L) {
               if (var23.getFsfEtat() == 6) {
                  if (var23.getFsfEtatVal() == 1) {
                     var23.setFsfEtat(0);
                  } else {
                     var23.setFsfEtat(0);
                  }
               }

               var23.setFsfDateModif(new Date());
               var23.setFsfIdModif(this.usersLog.getUsrid());
               var23.setFsfNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
               var23 = var24.modif(var23, var1);
            } else {
               var23.setExercicesAchats(this.exercicesAchats);
               var23.setFsfDateCreat(new Date());
               var23.setFsfIdCreateur(this.usersLog.getUsrid());
               var23.setFsfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
               if (var23.getFsfSerie() != null && !var23.getFsfSerie().equalsIgnoreCase("X") && !var23.getFsfSerie().isEmpty()) {
                  var23.setFsfNum(var22);
               } else {
                  long var27 = var24.selectLastNum(var1);
                  var23.setFsfNum("" + var27);
               }

               var23.setFsfEtat(0);
               var23.setFsfEtatVal(0);
               var23.setFsfDateValide((Date)null);
               var23 = var24.insert(var23, var1);
            }

            if (this.lesFraisDirects.size() != 0) {
               for(var10 = 0; var10 < this.lesFraisDirects.size(); ++var10) {
                  this.fraisLigneAchats = (FraisLigneAchats)this.lesFraisDirects.get(var10);
                  if (this.fraisLigneAchats.getFsfligPtLocal() != 0.0D) {
                     this.fraisLigneAchats.setFsfligQte(1.0F);
                     if (this.fraisLigneAchats.getFsfligTaxe() != null && !this.fraisLigneAchats.getFsfligTaxe().equals("0") && !this.fraisLigneAchats.getFsfligTaxe().isEmpty()) {
                        if (this.fraisLigneAchats.getFsfligTauxTaxe() == 0.0F) {
                           this.fraisLigneAchats.setFsfligTauxTaxe(this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.fraisLigneAchats.getFsfligTaxe(), var1).getTaxachTaux());
                        }
                     } else {
                        this.fraisLigneAchats.setFsfligTaxe("0");
                        this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
                     }

                     this.fraisLigneAchats.setFsfligIdRec(this.receptionEnteteAchats.getRecId());
                     if (this.fraisLigneAchats.getFsfligId() == 0L) {
                        this.fraisLigneAchats.setFraisEnteteAchats(var23);
                        this.fraisLigneAchats = var7.insertLigne(this.fraisLigneAchats, var1);
                     } else {
                        this.fraisLigneAchats = var7.modifLigne(this.fraisLigneAchats, var1);
                     }
                  }
               }
            }
         }

         var2.commit();
      } catch (HibernateException var15) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majAnalytique() throws HibernateException, NamingException {
      this.receptionEnteteAchats.setRecSite(this.usersLog.getUsrSite());
      this.receptionEnteteAchats.setRecDepartement(this.usersLog.getUsrDepartement());
      this.receptionEnteteAchats.setRecService(this.usersLog.getUsrService());
      this.receptionEnteteAchats.setRecRegion(this.tiers.getTieregion());
      this.receptionEnteteAchats.setRecSecteur(this.tiers.getTiesecteur());
      this.receptionEnteteAchats.setRecPdv(this.tiers.getTiepdv());
      if (!this.var_anal_activite) {
         this.receptionEnteteAchats.setRecActivite("");
      } else if (this.optionAchats.getActiviteEnteteLigne().equals("0")) {
         if (this.decoupageActivite) {
            String var1 = "";
            boolean var2 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                     if (var2) {
                        var1 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var2 = false;
                     } else {
                        var1 = var1 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }
            }

            this.receptionEnteteAchats.setRecActivite(var1);
         }
      } else {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         String var14 = "";
         boolean var15 = true;
         new ReceptionLigneAchats();
         new Produits();
         if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
            ArrayList var6 = new ArrayList();
            ObjetTarif var7 = new ObjetTarif();
            int var8 = 0;

            label122:
            while(true) {
               if (var8 >= this.lesLignesList.size()) {
                  var8 = 0;

                  while(true) {
                     if (var8 >= var6.size()) {
                        break label122;
                     }

                     var7 = (ObjetTarif)var6.get(var8);
                     if (var15) {
                        var14 = var7.getNomLibelle() + ":" + var7.getPrix();
                        var15 = false;
                     } else {
                        var14 = var14 + "#" + var7.getNomLibelle() + ":" + var7.getPrix();
                     }

                     ++var8;
                  }
               }

               ReceptionLigneAchats var4 = (ReceptionLigneAchats)this.lesLignesList.get(var8);
               if (var4.getRecligCode() != null && !var4.getRecligCode().isEmpty()) {
                  Produits var5 = this.produitsDao.chargeProduit(var4.getRecligCode(), var13);
                  if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                     if (var6.size() == 0) {
                        var7 = new ObjetTarif();
                        var7.setNomLibelle(var5.getProActivite());
                        var7.setPrix(var4.getRecligPt());
                        var6.add(var7);
                     } else {
                        boolean var9 = false;
                        double var10 = 0.0D;

                        for(int var12 = 0; var12 < var6.size(); ++var12) {
                           var7 = (ObjetTarif)var6.get(var12);
                           if (var7.getNomLibelle().equals(var5.getProActivite())) {
                              var10 = var7.getPrix();
                              var9 = true;
                              break;
                           }
                        }

                        if (!var9) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var4.getRecligPt());
                           var6.add(var7);
                        } else if (var9 && var7 != null) {
                           var7.setPrix(var10 + var4.getRecligPt());
                           var6.remove(var7);
                           var6.add(var7);
                        }
                     }
                  }
               }

               ++var8;
            }
         }

         this.receptionEnteteAchats.setRecActivite(var14);
         this.utilInitHibernate.closeSession();
      }

      if (this.receptionEnteteAchats.getRecAnal4() != null && this.receptionEnteteAchats.getRecAnal4().length() <= 2) {
         this.receptionEnteteAchats.setRecAnal4("");
      }

      if (!this.var_anal_parc) {
         this.receptionEnteteAchats.setRecAnal2("");
      } else if (this.receptionEnteteAchats.getRecAnal2() != null && this.receptionEnteteAchats.getRecAnal2().length() <= 2) {
         this.receptionEnteteAchats.setRecAnal2("");
      }

      if (this.receptionEnteteAchats.getRecAnal1() != null && this.receptionEnteteAchats.getRecAnal1().length() <= 2) {
         this.receptionEnteteAchats.setRecAnal1("");
      }

      if (this.receptionEnteteAchats.getRecBudget() != null && !this.receptionEnteteAchats.getRecBudget().isEmpty()) {
         if (this.receptionEnteteAchats.getRecBudget().equals("100")) {
            this.receptionEnteteAchats.setRecBudget("");
            this.receptionEnteteAchats.setRecBudgetDispo(0.0D);
            this.receptionEnteteAchats.setRecBudgetDispoMois(0.0D);
            this.receptionEnteteAchats.setRecBudgetTreso(0.0D);
            this.receptionEnteteAchats.setRecBudgetTresoMois(0.0D);
         }
      } else {
         this.receptionEnteteAchats.setRecBudget("");
         this.receptionEnteteAchats.setRecBudgetDispo(0.0D);
         this.receptionEnteteAchats.setRecBudgetDispoMois(0.0D);
         this.receptionEnteteAchats.setRecBudgetTreso(0.0D);
         this.receptionEnteteAchats.setRecBudgetTresoMois(0.0D);
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.receptionEnteteAchats.setRecEtatVal(1);
         this.receptionEnteteAchats.setRecEtat(0);
         this.receptionEnteteAchats.setRecDateValide((Date)null);
         return true;
      } else {
         this.receptionEnteteAchats.setRecEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.receptionEnteteAchats.setRecEtat(1);
               this.receptionEnteteAchats.setRecDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.receptionEnteteAchats.setRecEtat(0);
               this.receptionEnteteAchats.setRecDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.receptionEnteteAchats != null) {
         this.receptionEnteteAchats.setRecDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.receptionEnteteAchats != null) {
         if (this.receptionEnteteAchats.getRecDateAnnule() == null) {
            this.receptionEnteteAchats.setRecDateAnnule(new Date());
         }

         this.receptionEnteteAchats.setRecEtat(3);
         this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation réception achat N° " + this.receptionEnteteAchats.getRecNum() + " le " + this.receptionEnteteAchats.getRecDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.receptionEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void verifExitChronoAmortissement(Session var1) throws HibernateException, NamingException {
      this.chronoAmortissement = new Chrono();
      this.chronoAmortissement = this.chronoDaoAmortissement.chronoByNat(51, var1);
      if (this.chronoAmortissement != null) {
         this.verrouNumAmortissement = true;
      } else {
         this.verrouNumAmortissement = false;
      }

   }

   public long numCompose(Session var1) throws HibernateException, NamingException {
      long var2 = 0L;
      if (this.verrouNumAmortissement) {
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         this.enregitrerNumero(var1);
         var2 = (long)((int)this.chronoAmortissement.getChrNum());
      } else {
         var2 = this.amortissements.getAmoNum();
      }

      return var2;
   }

   public void enregitrerNumero(Session var1) throws HibernateException, NamingException {
      this.chronoAmortissement.setChrNum(this.chronoAmortissement.getChrNum() + 1L);
      this.chronoDaoAmortissement.modifierChrono(this.chronoAmortissement, var1);
   }

   public void calculDisponibilite() throws HibernateException, NamingException {
      this.receptionEnteteAchats.setRecBudgetDispo(0.0D);
      this.receptionEnteteAchats.setRecBudgetDispoMois(0.0D);
      this.receptionEnteteAchats.setRecBudgetTreso(0.0D);
      this.receptionEnteteAchats.setRecBudgetTresoMois(0.0D);
      if (this.receptionEnteteAchats.getRecBudget() != null && this.receptionEnteteAchats.getRecBudget().contains(":")) {
         String var1 = "" + this.lastExoCompta.getExecpt_id();
         String[] var2 = this.receptionEnteteAchats.getRecBudget().split(":");
         String var3 = null;
         if (this.receptionEnteteAchats.getRecActivite() != null && !this.receptionEnteteAchats.getRecActivite().isEmpty()) {
            String[] var4 = this.receptionEnteteAchats.getRecActivite().split(":");
            var3 = var4[0];
         }

         int var27 = this.receptionEnteteAchats.getRecDate().getMonth() + 1;
         double var5 = 0.0D;
         double var7 = 0.0D;
         BudgetDao var9 = new BudgetDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var10 = var9.chargerLesBudgets("2", var1, var3, var2[0], (Session)null);
         if (var10.size() != 0) {
            for(int var11 = 0; var11 < var10.size(); ++var11) {
               new Budget();
               Budget var12 = (Budget)var10.get(var11);
               if (var12.getBudUtil() <= 1) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R1Val();
                     var5 += var12.getBud01R1Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val() + var12.getBud10R1Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val() + var12.getBud10R1Val() + var12.getBud11R1Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val() + var12.getBud10R1Val() + var12.getBud11R1Val() + var12.getBud12R1Val();
                  }
               } else if (var12.getBudUtil() == 2) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R2Val();
                     var5 += var12.getBud01R2Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val() + var12.getBud10R2Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val() + var12.getBud10R2Val() + var12.getBud11R2Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val() + var12.getBud10R2Val() + var12.getBud11R2Val() + var12.getBud12R2Val();
                  }
               } else if (var12.getBudUtil() == 2) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R3Val();
                     var5 += var12.getBud01R3Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val() + var12.getBud10R3Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val() + var12.getBud10R3Val() + var12.getBud11R3Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val() + var12.getBud10R3Val() + var12.getBud11R3Val() + var12.getBud12R3Val();
                  }
               } else if (var12.getBudUtil() == 2) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R4Val();
                     var5 += var12.getBud01R4Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val() + var12.getBud10R4Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val() + var12.getBud10R4Val() + var12.getBud11R4Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val() + var12.getBud10R4Val() + var12.getBud11R4Val() + var12.getBud12R4Val();
                  }
               }
            }
         }

         double var28 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         EcrituresDao var23 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var24 = var23.selectLesDisponibilites(this.lastExoCompta.getExecpt_id(), this.receptionEnteteAchats.getRecDate(), (Session)null);
         if (var24.size() != 0) {
            for(int var25 = 0; var25 < var24.size(); ++var25) {
               new Ecritures();
               Ecritures var26 = (Ecritures)var24.get(var25);
               if (var26.getEcrDateSaisie().getMonth() + 1 == var27) {
                  var17 += var26.getEcrDebitPays();
                  var21 += var26.getEcrCreditPays();
               }

               var15 += var26.getEcrDebitPays();
               var19 += var26.getEcrCreditPays();
            }
         }

         this.receptionEnteteAchats.setRecBudgetDispo(var5 - var28);
         this.receptionEnteteAchats.setRecBudgetDispoMois(var7 - var13);
         this.receptionEnteteAchats.setRecBudgetTreso(var15 - var19);
         this.receptionEnteteAchats.setRecBudgetTresoMois(var17 - var21);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.receptionEnteteAchats.getRecExoTva() == 0 || this.receptionEnteteAchats.getRecExoTva() == 2 || this.receptionEnteteAchats.getRecExoTva() == 3) {
         TaxesAchats var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesAchats();
            var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxachTaux();
               var6 = var8.getTaxachCode();
               var7 = var8.getTaxachType();
            } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
               new TaxesAchats();
               TaxesAchats var9 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxachTaux();
                  var6 = var9.getTaxachCode();
                  var7 = var9.getTaxachType();
               } else {
                  var5 = var2;
                  var6 = var1;
                  var7 = 0;
               }
            } else {
               var5 = var2;
               var6 = var1;
               var7 = 0;
            }
         } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
            new TaxesAchats();
            var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxachTaux();
               var6 = var8.getTaxachCode();
               var7 = var8.getTaxachType();
            } else {
               var5 = var2;
               var6 = var1;
               var7 = 0;
            }
         } else {
            var5 = var2;
            var6 = var1;
            var7 = 0;
         }

         if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var5 = 0.0F;
            var6 = "";
            var7 = 0;
         }
      }

      this.receptionLigneAchats.setRecligTaxe(var6);
      this.receptionLigneAchats.setRecligTauxTaxe(var5);
      double var28 = this.receptionLigneAchats.getRecligPu();
      if (this.receptionLigneAchats.getRecligQte() != 0.0F) {
         this.receptionLigneAchats.setRecligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.receptionLigneAchats.getRecligCondition(), this.receptionLigneAchats.getRecligQte(), this.receptionLigneAchats.getRecligLong(), this.receptionLigneAchats.getRecligLarg(), this.receptionLigneAchats.getRecligHaut(), this.receptionLigneAchats.getRecligDiam(), this.receptionLigneAchats.getRecligNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.receptionLigneAchats.setRecligQteUtil(0.0F);
      }

      double var10 = 0.0D;
      if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && this.receptionLigneAchats.getRecligCondition().contains(":")) {
         var10 = var28 * (double)this.receptionLigneAchats.getRecligQte();
      } else {
         var10 = var28 * (double)this.receptionLigneAchats.getRecligQte();
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      if (this.optionAchats.getDecrmtRabais().equals("1")) {
         var14 = this.receptionLigneAchats.getRecligRabais();
      } else if (this.optionAchats.getDecrmtRabais().equals("2")) {
         var14 = this.receptionLigneAchats.getRecligRabais() * (double)this.receptionLigneAchats.getRecligQte();
      }

      if (this.receptionLigneAchats.getRecligTauxRemise() != 0.0F) {
         var12 = var10 - var10 * (double)this.receptionLigneAchats.getRecligTauxRemise() / 100.0D - var14;
      } else {
         var12 = var10 - var14;
      }

      double var16 = 0.0D;
      double var18 = this.utilNombre.myRoundFormat(var12, this.utilNombre.formatDevise(this.receptionEnteteAchats.getRecDevise()));
      if (this.receptionEnteteAchats.getRecDevise().equalsIgnoreCase(this.structureLog.getStrdevise())) {
         var16 = this.utilNombre.myRoundFormat(var12, this.structureLog.getStrformatdevise());
         this.receptionEnteteAchats.setRecCoefDevise(1.0F);
      } else {
         if (this.receptionEnteteAchats.getRecCoefDevise() == 0.0F) {
            float var20 = 0.0F;
            var20 = this.utilNombre.deviseTaux2(this.receptionEnteteAchats.getRecDevise(), this.receptionEnteteAchats.getRecDate());
            this.receptionEnteteAchats.setRecCoefDevise(var20);
         }

         var16 = this.utilNombre.myRoundDevise(var18 * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise());
      }

      double var29 = var12 * (double)this.receptionLigneAchats.getRecligTauxTaxe() / 100.0D;
      double var22 = this.utilNombre.myRoundFormat(var29, this.receptionEnteteAchats.getVar_format_devise());
      if (var7 == 2 || var7 == 3) {
         var29 = var18 * (double)(this.receptionLigneAchats.getRecligTauxTaxe() / 100.0F);
         var29 *= -1.0D;
      }

      double var24 = var12 + var22;
      double var26 = 0.0D;
      if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && this.receptionLigneAchats.getRecligCondition().contains(":")) {
         var26 = this.utilNombre.myRound(var16 / (double)this.receptionLigneAchats.getRecligQteUtil(), 2);
      } else {
         var26 = this.utilNombre.myRound(var16 / (double)this.receptionLigneAchats.getRecligQteUtil(), 2);
      }

      this.receptionLigneAchats.setRecligPuRem(var26);
      this.receptionLigneAchats.setRecligPt(var12);
      this.receptionLigneAchats.setRecligTva(var22);
      this.receptionLigneAchats.setRecligTc(0.0D);
      this.receptionLigneAchats.setRecligTtc(var24);
      this.receptionLigneAchats.setRecligPtDev(var16);
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), (Session)null);
   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      this.calculHt(var1, var2, var3);
   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      float var13 = 0.0F;
      float var14 = 0.0F;
      if (this.optionAchats.getModeCifCfrREC().equals("0")) {
         var5 = this.receptionEnteteAchats.getRecTotFret() + this.receptionEnteteAchats.getRecTotFret2() + this.receptionEnteteAchats.getRecTotAssurance();
         var9 = this.receptionEnteteAchats.getRecTotFretLocal() + this.receptionEnteteAchats.getRecTotFret2Local() + this.receptionEnteteAchats.getRecTotAssuranceLocal();
      } else {
         var5 = 0.0D;
         var9 = 0.0D;
      }

      var5 = var5 + this.receptionEnteteAchats.getRecTotCertificat() + this.receptionEnteteAchats.getRecTotCertificatConformite() + this.receptionEnteteAchats.getRecTotFraisAdm();
      var9 = var9 + this.receptionEnteteAchats.getRecTotCertificatLocal() + this.receptionEnteteAchats.getRecTotCertificatConformiteLocal() + this.receptionEnteteAchats.getRecTotFraisAdmLocal();
      new ReceptionLigneAchats();

      for(int var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
         ReceptionLigneAchats var15 = (ReceptionLigneAchats)this.lesLignesList.get(var16);
         var1 += var15.getRecligPt();
         var5 += var15.getRecligTtc();
         var7 += var15.getRecligTc();
         var3 += var15.getRecligTva();
         var9 += var15.getRecligPtDev();
         if (var15.getRecligRabais() != 0.0D || var15.getRecligTauxRemise() != 0.0F) {
            var11 += var15.getRecligPu() * (double)var15.getRecligQte() - var15.getRecligPt();
         }

         var14 += var15.getRecligQteUtil() * var15.getRecligPoidsNet();
         var13 += var15.getRecligQte();
      }

      this.receptionEnteteAchats.setRecTotHt(var1);
      this.receptionEnteteAchats.setRecTotTtc(var5);
      this.receptionEnteteAchats.setRecTotTc(var7);
      this.receptionEnteteAchats.setRecTotTva(var3);
      this.receptionEnteteAchats.setRecTotRemise(var11);
      this.receptionEnteteAchats.setRecTotPoidsBrut(var14);
      this.receptionEnteteAchats.setRecTotQte(var13);
      this.receptionEnteteAchats.setRecTotHtLocal(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesAchatsProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.listeSerie.clear();
      this.listeLot.clear();
      this.receptionLotAchats = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.receptionLigneAchats = (ReceptionLigneAchats)this.datamodelLigne.getRowData();
         this.var_memo_qte = this.receptionLigneAchats.getRecligQteUtil();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         if (this.receptionLigneAchats.getRecligCode() != null && this.receptionLigneAchats.getRecligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
            if (this.produits != null) {
               this.receptionLigneAchats.setRecligCode(this.produits.getProCode());
               this.receptionLigneAchats.setRecligFamille(this.produits.getProAchCode() + ":" + this.produits.getProAchLib());
               if (this.receptionLigneAchats.getRecligDouane() == null || this.receptionLigneAchats.getRecligDouane().isEmpty()) {
                  if (this.produits.getProAchDouane() != null && !this.produits.getProAchDouane().isEmpty()) {
                     this.receptionLigneAchats.setRecligDouane(this.produits.getProAchDouane());
                  } else {
                     this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), this.produits, var1);
                     if (this.famillesProduitsAchats != null) {
                        this.receptionLigneAchats.setRecligDouane(this.famillesProduitsAchats.getFamachDouane());
                     }
                  }
               }

               this.receptionLigneAchats.setRecligStock(this.produits.getProStock());
               this.receptionLigneAchats.setRecligLong(this.produits.getProLongueur());
               this.receptionLigneAchats.setRecligLarg(this.produits.getProLargeur());
               this.receptionLigneAchats.setRecligHaut(this.produits.getProEpaisseur());
               this.receptionLigneAchats.setRecligDiam(this.produits.getProDiamExt());
               this.receptionLigneAchats.setRecligPoidsBrut(this.produits.getProPoidsBrut());
               this.receptionLigneAchats.setRecligPoidsNet(this.produits.getProPoidsNet());
               this.receptionLigneAchats.setRecligVolume(this.produits.getProVolume());
               this.receptionLigneAchats.setRecligNb(this.produits.getProNbUnite());
               this.var_aff_detail_prod = true;
               if (this.produits.getProImpDesciption() == 1) {
                  if (this.usersLog.getUsrAchLibelle() == 1) {
                     this.verrou_libelle = true;
                  } else {
                     this.verrou_libelle = false;
                  }
               } else {
                  this.verrou_libelle = false;
               }

               this.griserchamps = true;
               this.selectionListeTva();
               this.mesProduitsDepotsItems.clear();
               if (this.var_sansstock && this.produits.getProStock() != 0 && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
                  new ArrayList();
                  List var4 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
                  if (var4.size() != 0) {
                     int var3;
                     for(var3 = 0; var3 < var4.size(); ++var3) {
                        if (((ProduitsDepot)var4.get(var3)).getProdepCasier() != null && !((ProduitsDepot)var4.get(var3)).getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(((ProduitsDepot)var4.get(var3)).getDepot().getDpoCode() + ":" + ((ProduitsDepot)var4.get(var3)).getProdepCasier() + "=" + ((ProduitsDepot)var4.get(var3)).getProdepQteStk()));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(((ProduitsDepot)var4.get(var3)).getDepot().getDpoCode() + "=" + ((ProduitsDepot)var4.get(var3)).getProdepQteStk()));
                        }
                     }

                     for(var3 = 0; var3 < this.mesProduitsDepotsItems.size(); ++var3) {
                        if (((SelectItem)this.mesProduitsDepotsItems.get(var3)).getValue().toString().startsWith(this.receptionLigneAchats.getRecligDepot())) {
                           this.var_depotProd = ((SelectItem)this.mesProduitsDepotsItems.get(var3)).getValue().toString();
                           break;
                        }
                     }
                  }
               }

               this.selectionDepot(var1);
               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         } else {
            this.produits = null;
            this.var_aff_detail_prod = false;
            this.verrou_libelle = false;
            this.var_code_unite = 0;
            this.griserchamps = false;
            this.mesTaxesAchatsProduits.clear();
            if (this.mesTaxesAchatsItems.size() != 0) {
               for(int var2 = 0; var2 < this.mesTaxesAchatsItems.size(); ++var2) {
                  this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var2));
               }
            }

            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
      }

   }

   public void selectionLigneFrais() {
      if (this.dataModelFrais.isRowAvailable()) {
         this.fraisLigneAchats = (FraisLigneAchats)this.dataModelFrais.getRowData();
      }

   }

   public void calculprixLocalFrais() {
      if (this.fraisLigneAchats != null) {
         if (this.fraisLigneAchats.getFsfligDevise() == null || this.fraisLigneAchats.getFsfligDevise().isEmpty()) {
            this.fraisLigneAchats.setFsfligDevise(this.structureLog.getStrdevise());
         }

         if (this.fraisLigneAchats.getFsfligDevise().equals(this.structureLog.getStrdevise())) {
            this.fraisLigneAchats.setFsfligPtLocal(this.fraisLigneAchats.getFsfligPu());
            this.fraisLigneAchats.setFsfligCoefDevise(1.0F);
         } else {
            new ObjetDevises();
            LectureDevises var2 = new LectureDevises();
            ObjetDevises var1 = var2.devisesRecherchee(this.fraisLigneAchats.getFsfligDevise(), this.structureLog.getStrdevise());
            float var3 = Float.parseFloat(var1.getTaux1());
            float var4 = Float.parseFloat(var1.getTaux2());
            var1 = var2.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
            float var5 = Float.parseFloat(var1.getTaux1());
            float var6 = Float.parseFloat(var1.getTaux2());
            this.fraisLigneAchats.setFsfligCoefDevise(var3 * var6);
            this.fraisLigneAchats.setFsfligPtLocal(this.fraisLigneAchats.getFsfligPu() * (double)this.fraisLigneAchats.getFsfligCoefDevise());
         }
      }

      this.cumulPrixFrais();
   }

   public void cumulPrixFrais() {
      this.totalFrais = 0.0D;
      if (this.lesFraisDirects.size() != 0) {
         for(int var1 = 0; var1 < this.lesFraisDirects.size(); ++var1) {
            this.totalFrais += ((FraisLigneAchats)this.lesFraisDirects.get(var1)).getFsfligPtLocal();
         }
      }

   }

   public void calculPoidsNet() {
      float var1 = 0.0F;
      float var2 = 0.0F;
      float var3 = 0.0F;
      var1 = this.receptionLotAchats.getReclotPoidsBrut() * this.receptionLotAchats.getReclotQte();
      this.receptionLotAchats.setReclotPoidsBrut(var1);
      var2 = this.produits.getProPoidsTare() * this.receptionLotAchats.getReclotQte();
      this.receptionLotAchats.setReclotPoidsTare(var2);
      var3 = var1 - var2;
      this.receptionLotAchats.setReclotPoidsNet(var3);
   }

   public void addLigne() {
      this.produits = new Produits();
      this.produitsDepot = new ProduitsDepot();
      this.receptionLigneAchats = new ReceptionLigneAchats();
      this.listeSerie.clear();
      this.receptionLotAchats = new ReceptionLotAchats();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_memo_qte = 0.0F;
      this.var_depotProd = "";
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.receptionLigneAchats.getRecligQte() != 0.0F) {
         if (this.receptionEnteteAchats.getRecId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.receptionLigneAchats.getRecligQteUtil() == 0.0F) {
               this.receptionLigneAchats.setRecligQteUtil(this.receptionLigneAchats.getRecligQte());
            }

            this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), var1);
            if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
               String[] var3;
               if (this.var_depotProd != null && !this.var_depotProd.isEmpty() && this.var_depotProd.contains("=")) {
                  if (this.var_depotProd.contains(":")) {
                     var3 = this.var_depotProd.split(":");
                     this.receptionLigneAchats.setRecligDepot(var3[0]);
                  } else {
                     var3 = this.var_depotProd.split("=");
                     this.receptionLigneAchats.setRecligDepot(var3[0]);
                  }
               } else if (this.var_depotProd != null && !this.var_depotProd.isEmpty() && this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.receptionLigneAchats.setRecligDepot(var3[0]);
               } else {
                  this.receptionLigneAchats.setRecligDepot("");
               }

               if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && this.receptionLigneAchats.getRecligCondition().contains(":")) {
                  ConditionnementDao var11 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
                  String[] var4 = this.receptionLigneAchats.getRecligCondition().split(":");
                  String var5 = var11.rechercheConditionnement(var4[0], var1).getCdtDescription();
                  if (var5 != null && !var5.isEmpty()) {
                     this.receptionLigneAchats.setRecligDescription(var5);
                  } else {
                     this.receptionLigneAchats.setRecligDescription("");
                  }
               } else {
                  this.receptionLigneAchats.setRecligDescription("");
               }
            } else {
               this.receptionLigneAchats.setRecligDepot("");
               this.receptionLigneAchats.getRecligCondition();
               this.receptionLigneAchats.setRecligDescription("");
               this.produits = null;
            }

            if (this.receptionLigneAchats.getRecligId() == 0L) {
               this.receptionLigneAchats.setReceptionEnteteAchats(this.receptionEnteteAchats);
               this.receptionLigneAchats.setRecligDevise(this.receptionEnteteAchats.getRecDevise());
               this.receptionLigneAchats = this.receptionLigneAchatsDao.insertLigne(this.receptionLigneAchats, var1);
               this.lesLignesList.add(this.receptionLigneAchats);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
            } else {
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
            }

            if (this.produits != null && this.produits.getProStock() >= 1 && this.produitsDepot != null) {
               this.calculStock.majReceptionAchatsATT(this.receptionLigneAchats, this.produits, this.var_memo_qte, 1, this.baseLog, var1);
            }

            if (this.produits != null && this.produits.getProId() != 0L && this.tiers != null) {
               this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
               if (this.produitsFournisseur == null) {
                  this.produitsFournisseur = new ProduitsFournisseur();
               }

               this.produitsFournisseur.setProfouDevise(this.receptionEnteteAchats.getRecDevise());
               this.produitsFournisseur.setProfouTauxDevise(this.receptionEnteteAchats.getRecCoefDevise());
               this.produitsFournisseur.setProfouFormat(this.receptionEnteteAchats.getVar_format_devise());
               if ((this.produitsFournisseur.getProfouLib() == null || this.produitsFournisseur.getProfouLib().isEmpty()) && this.receptionLigneAchats.getRecligLibelleFournisseur() != null && !this.receptionLigneAchats.getRecligLibelleFournisseur().isEmpty()) {
                  this.produitsFournisseur.setProfouLib(this.receptionLigneAchats.getRecligLibelleFournisseur());
               }

               if ((this.produitsFournisseur.getProfouRef() == null || this.produitsFournisseur.getProfouRef().isEmpty()) && this.receptionLigneAchats.getRecligReference() != null && !this.receptionLigneAchats.getRecligReference().isEmpty()) {
                  this.produitsFournisseur.setProfouRef(this.receptionLigneAchats.getRecligReference());
               }

               this.produitsFournisseur.setProfouDate(this.receptionEnteteAchats.getRecDate());
               this.produitsFournisseur.setProfouPa(this.receptionLigneAchats.getRecligPu());
               if (this.structureLog.getStrdevise().equalsIgnoreCase(this.receptionEnteteAchats.getRecDevise())) {
                  this.produitsFournisseur.setProfouCoefLocal(1.0F);
                  this.produitsFournisseur.setProfouPaLocal(this.produitsFournisseur.getProfouPa());
               } else {
                  this.produitsFournisseur.setProfouCoefLocal(this.utilNombre.deviseTaux2(this.structureLog.getStrdevise(), this.produitsFournisseur.getProfouDate()));
                  this.produitsFournisseur.setProfouPaLocal(this.utilNombre.myRoundDevise(this.produitsFournisseur.getProfouPa() * (double)this.produitsFournisseur.getProfouCoefLocal(), this.structureLog.getStrdevise()));
               }

               this.produitsFournisseur.setProfouCoefEuro(this.utilNombre.deviseTaux1(this.produitsFournisseur.getProfouDevise(), this.produitsFournisseur.getProfouDate()));
               this.produitsFournisseur.setProfouPaEuro(this.utilNombre.myRoundFormat(this.produitsFournisseur.getProfouPa() * (double)this.produitsFournisseur.getProfouCoefEuro(), 1));
               if (this.produitsFournisseur.getProfouId() == 0L) {
                  this.produitsFournisseur.setProduits(this.produits);
                  this.produitsFournisseur.setTiers(this.tiers);
                  this.produitsFournisseurDao.insert(this.produitsFournisseur, var1);
               } else {
                  this.produitsFournisseurDao.modif(this.produitsFournisseur, var1);
               }
            }

            this.cumulPrix();
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
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

      this.addLigne();
   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.receptionLigneAchats.getRecligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.receptionLigneAchats.getRecligCode();
            new ArrayList();
            List var4 = this.receptionSerieAchatsDao.selectReceptionSerieByRecLig(this.receptionLigneAchats, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  new ReceptionSerieAchats();
                  ReceptionSerieAchats var6 = (ReceptionSerieAchats)var4.get(var5);
                  this.receptionSerieAchatsDao.deleteSerieLigne(var6, var1);
               }
            }

            new ArrayList();
            List var13 = this.receptionLotAchatsDao.selectReceptionLotByRecLig(this.receptionLigneAchats, var1);
            if (var13.size() != 0) {
               for(int var14 = 0; var14 < var13.size(); ++var14) {
                  new ReceptionLotAchats();
                  ReceptionLotAchats var7 = (ReceptionLotAchats)var13.get(var14);
                  this.receptionLotAchatsDao.deleteLotLigne(var7, var1);
               }
            }

            this.receptionLigneAchatsDao.deleteOneLigne(this.receptionLigneAchats, var1);
            new ArrayList();
            List var15 = (List)this.datamodelLigne.getWrappedData();
            var15.remove(this.receptionLigneAchats);
            this.datamodelLigne.setWrappedData(var15);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var16 = new Espion();
            var16.setUsers(this.usersLog);
            var16.setEsptype(0);
            var16.setEspdtecreat(new Date());
            var16.setEspaction("Suppression ligne produit " + var3 + " de la réception achat N° " + this.receptionEnteteAchats.getRecNum() + " du " + this.receptionEnteteAchats.getRecDate());
            this.espionDao.mAJEspion(var16, var1);
            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void deleteLigneSelectPapier() throws HibernateException, NamingException {
      if (this.receptionLigneAchats.getRecligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.receptionLigneAchats.getRecligCode();
            new ArrayList();
            List var4 = this.receptionSerieAchatsDao.selectReceptionSerieByRecLig(this.receptionLigneAchats, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  new ReceptionSerieAchats();
                  ReceptionSerieAchats var6 = (ReceptionSerieAchats)var4.get(var5);
                  this.receptionSerieAchatsDao.deleteSerieLigne(var6, var1);
               }
            }

            new ArrayList();
            List var13 = this.receptionLotAchatsDao.selectReceptionLotByRecLig(this.receptionLigneAchats, var1);
            if (var13.size() != 0) {
               for(int var14 = 0; var14 < var13.size(); ++var14) {
                  new ReceptionLotAchats();
                  ReceptionLotAchats var7 = (ReceptionLotAchats)var13.get(var14);
                  this.receptionLotAchatsDao.deleteLotLigne(var7, var1);
               }
            }

            if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
               if (this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
                  if (this.produitsDepot != null) {
                     this.produitsDepotDao.delete(this.produitsDepot, var1);
                  }
               }

               this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
               if (this.produits != null) {
                  this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                  if (this.produitsFournisseur != null) {
                     this.produitsFournisseurDao.delete(this.produitsFournisseur, var1);
                  }

                  this.produitsDao.delete(this.produits, var1);
               }
            }

            this.receptionLigneAchatsDao.deleteOneLigne(this.receptionLigneAchats, var1);
            new ArrayList();
            List var15 = (List)this.datamodelLigne.getWrappedData();
            var15.remove(this.receptionLigneAchats);
            this.datamodelLigne.setWrappedData(var15);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var16 = new Espion();
            var16.setUsers(this.usersLog);
            var16.setEsptype(0);
            var16.setEspdtecreat(new Date());
            var16.setEspaction("Suppression ligne produit " + var3 + " de la réception achat N° " + this.receptionEnteteAchats.getRecNum() + " du " + this.receptionEnteteAchats.getRecDate());
            this.espionDao.mAJEspion(var16, var1);
            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void ouvertureLot() throws HibernateException, NamingException {
      if (this.receptionLigneAchats != null && this.produits != null && (this.produits.getProStock() == 2 || this.produits.getProStock() == 3 || this.produits.getProStock() == 4)) {
         this.receptionLigneAchats.setRecligPoidsBrut(this.produits.getProPoidsBrut());
         this.receptionLigneAchats.setRecligPoidsNet(this.produits.getProPoidsNet());
         this.var_lib_condit = "";
         if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && this.receptionLigneAchats.getRecligCondition().contains(":")) {
            this.var_lib_condit = this.receptionLigneAchats.getRecligCondition();
         } else if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && !this.receptionLigneAchats.getRecligCondition().contains(":")) {
            int var1 = Integer.parseInt(this.receptionLigneAchats.getRecligCondition());
            this.unite.setUniEchelle(var1);
            this.var_lib_condit = this.unite.getVar_lib_echelle();
         }

         this.listeLot = this.receptionLotAchatsDao.selectReceptionLotByRecLig(this.receptionLigneAchats, (Session)null);
         if (this.listeLot.size() != 0) {
            this.receptionLotAchats = new ReceptionLotAchats();
         } else {
            this.receptionLotAchats = new ReceptionLotAchats();
            this.receptionLotAchats.setReclotQte(this.receptionLigneAchats.getRecligQte());
            this.receptionLotAchats.setReclotLong(this.receptionLigneAchats.getRecligLong());
            this.receptionLotAchats.setReclotLarg(this.receptionLigneAchats.getRecligLarg());
            this.receptionLotAchats.setReclotHaut(this.receptionLigneAchats.getRecligHaut());
            this.receptionLotAchats.setReclotNb(this.receptionLigneAchats.getRecligNb());
            this.receptionLotAchats.setReclotDiam(this.receptionLigneAchats.getRecligDiam());
            this.receptionLotAchats.setReclotPoidsBrut(this.receptionLigneAchats.getRecligPoidsBrut());
            this.receptionLotAchats.setReclotPoidsTare(this.produits.getProPoidsTare());
            this.receptionLotAchats.setReclotPoidsNet(0.0F);
            this.receptionLotAchats.setReclotQteUtil(this.receptionLigneAchats.getRecligQteUtil());
            if (this.receptionLigneAchats.getRecligId() == 0L || this.receptionLigneAchats.getRecligNumLot() == null || this.receptionLigneAchats.getRecligNumLot().isEmpty()) {
               if (this.receptionLigneAchats.getRecligStock() != 2 && this.receptionLigneAchats.getRecligStock() != 3 && this.receptionLigneAchats.getRecligStock() != 4) {
                  this.receptionLigneAchats.setRecligNumLot((String)null);
               } else {
                  if (this.lotReception == null || this.lotReception.isEmpty()) {
                     this.lotReception = this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), 38, this.receptionEnteteAchats.getRecSerie(), (Session)null);
                  }

                  this.receptionLigneAchats.setRecligNumLot(this.lotReception);
               }
            }

            if (this.receptionLigneAchats.getRecligNumLot() != null && !this.receptionLigneAchats.getRecligNumLot().isEmpty()) {
               this.receptionLotAchats.setReclotNumero(this.receptionLigneAchats.getRecligNumLot());
               this.accesLot = false;
            } else {
               this.receptionLotAchats.setReclotNumero("");
               this.accesLot = true;
            }

            this.listeLot.add(this.receptionLotAchats);
         }

         this.receptionLotAchats = (ReceptionLotAchats)this.listeLot.get(0);
         this.calculPoidsNet();
         this.showModalPanelLot = true;
      }

   }

   public void valideLot() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         String var3 = this.receptionLotAchats.getReclotNumero();
         this.receptionLotAchats = (ReceptionLotAchats)this.listeLot.get(0);
         this.receptionLotAchats.setReclotNum(this.receptionEnteteAchats.getRecNum());
         this.receptionLotAchats.setReclotPr(this.receptionLigneAchats.getRecligPr());
         this.receptionLotAchats.setReclotQte(this.receptionLigneAchats.getRecligQte());
         this.receptionLotAchats.setReclotLong(this.receptionLigneAchats.getRecligLong());
         this.receptionLotAchats.setReclotLarg(this.receptionLigneAchats.getRecligLarg());
         this.receptionLotAchats.setReclotHaut(this.receptionLigneAchats.getRecligHaut());
         this.receptionLotAchats.setReclotNb(this.receptionLigneAchats.getRecligNb());
         this.receptionLotAchats.setReclotDiam(this.receptionLigneAchats.getRecligDiam());
         this.receptionLotAchats.setReclotPoidsBrut(this.receptionLigneAchats.getRecligPoidsBrut());
         this.receptionLotAchats.setReclotPoidsTare(this.produits.getProPoidsTare());
         this.receptionLotAchats.setReclotNumero(var3);
         this.receptionLotAchats.setReclotPoidsNet(0.0F);
         this.calculPoidsNet();
         this.receptionLotAchats.setReclotQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.receptionLigneAchats.getRecligCondition(), this.receptionLotAchats.getReclotQte(), this.receptionLotAchats.getReclotLong(), this.receptionLotAchats.getReclotLarg(), this.receptionLotAchats.getReclotHaut(), this.receptionLotAchats.getReclotDiam(), this.receptionLotAchats.getReclotNb(), this.baseLog, this.utilInitHibernate, var1));
         if (this.receptionLotAchats.getReclotId() == 0L) {
            this.receptionLotAchats.setReclotIdLigne(this.receptionLigneAchats.getRecligId());
            this.receptionLotAchats.setReclotDateAchat(this.receptionEnteteAchats.getRecDate());
            this.receptionLotAchats.setReclotCode(this.receptionLigneAchats.getRecligCode());
            this.receptionLotAchats.setReclotDepot(this.receptionLigneAchats.getRecligDepot());
            this.receptionLotAchats = this.receptionLotAchatsDao.insert(this.receptionLotAchats, var1);
         } else {
            this.receptionLotAchats = this.receptionLotAchatsDao.modif(this.receptionLotAchats, var1);
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

      this.listeLot.clear();
      this.showModalPanelLot = false;
   }

   public void fermetureLot() {
      this.showModalPanelLot = false;
   }

   public void ouvertureSerie() throws HibernateException, NamingException {
      if (this.produits != null && this.produits.getProStock() == 5) {
         this.listeSerie = this.receptionSerieAchatsDao.selectReceptionSerieByRecLig(this.receptionLigneAchats, (Session)null);
         if ((float)this.listeSerie.size() != this.receptionLigneAchats.getRecligQte()) {
            int var1 = (int)this.receptionLigneAchats.getRecligQte() - this.listeSerie.size();

            for(int var2 = 0; var2 < var1; ++var2) {
               this.receptionSerieAchats = new ReceptionSerieAchats();
               this.listeSerie.add(this.receptionSerieAchats);
            }
         }

         this.dataModelSerie.setWrappedData(this.listeSerie);
         if (this.listeSerie.size() != 0) {
            this.var_num_palette = ((ReceptionSerieAchats)this.listeSerie.get(0)).getRecserPalette();
            this.var_num_carton = ((ReceptionSerieAchats)this.listeSerie.get(0)).getRecserCarton();
         } else {
            this.var_num_palette = "";
            this.var_num_carton = "";
         }

         this.showModalPanelSerie = true;
      }

   }

   public void selectionSerie() {
      if (this.dataModelSerie.isRowAvailable()) {
         this.receptionSerieAchats = (ReceptionSerieAchats)this.dataModelSerie.getRowData();
      }

   }

   public void valideSerie() throws HibernateException, NamingException {
      if (this.listeSerie.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listeSerie.size(); ++var3) {
               this.receptionSerieAchats = (ReceptionSerieAchats)this.listeSerie.get(var3);
               this.receptionSerieAchats.setRecserIdLigne(this.receptionLigneAchats.getRecligId());
               this.receptionSerieAchats.setRecserPalette(this.var_num_palette);
               this.receptionSerieAchats.setRecserCarton(this.var_num_carton);
               this.receptionSerieAchats.setRecserCode(this.receptionLigneAchats.getRecligCode());
               this.receptionSerieAchats.setRecserDepot(this.receptionLigneAchats.getRecligDepot());
               this.receptionSerieAchats.setRecserDateIn(this.receptionEnteteAchats.getRecDate());
               this.receptionSerieAchats.setRecserNum(this.receptionEnteteAchats.getRecNum());
               this.receptionSerieAchats.setRecserPr(this.receptionLigneAchats.getRecligPr());
               if (this.receptionSerieAchats.getRecserId() == 0L) {
                  this.receptionSerieAchats = this.receptionSerieAchatsDao.insert(this.receptionSerieAchats, var1);
               } else {
                  this.receptionSerieAchats = this.receptionSerieAchatsDao.modif(this.receptionSerieAchats, var1);
               }
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
      }

      this.showModalPanelSerie = false;
   }

   public void fermetureSerie() {
      this.showModalPanelSerie = false;
   }

   public void accesPiecesJointes() throws HibernateException, NamingException {
      this.lesPiecesJointes.clear();
      if (this.receptionEnteteAchats != null) {
         String var1 = this.receptionEnteteAchats.getRecNum().replace("/", "_") + "_";
         this.uploadedFile = null;
         File var2 = new File(this.cheminPieceJointes);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].startsWith(var1)) {
                  this.fileCtrl = new FileCtrl();
                  this.fileCtrl.setName(var3[var4]);
                  this.fileCtrl.setChemin(this.cheminPieceJointes);
                  if (!this.fileCtrl.getName().contains("pdf") && !this.fileCtrl.getName().contains("PDF")) {
                     if (!this.fileCtrl.getName().contains("doc") && !this.fileCtrl.getName().contains("DOC")) {
                        if (!this.fileCtrl.getName().contains("xls") && !this.fileCtrl.getName().contains("XLS")) {
                           if (!this.fileCtrl.getName().contains("ppt") && !this.fileCtrl.getName().contains("PPT")) {
                              if (!this.fileCtrl.getName().contains("odt") && !this.fileCtrl.getName().contains("ODT")) {
                                 if (!this.fileCtrl.getName().contains("ods") && !this.fileCtrl.getName().contains("ODS")) {
                                    if (!this.fileCtrl.getName().contains("odp") && !this.fileCtrl.getName().contains("ODP")) {
                                       if (!this.fileCtrl.getName().contains("jpg") && !this.fileCtrl.getName().contains("JPG")) {
                                          this.fileCtrl.setTypeFichier(8);
                                       } else {
                                          this.fileCtrl.setTypeFichier(7);
                                       }
                                    } else {
                                       this.fileCtrl.setTypeFichier(6);
                                    }
                                 } else {
                                    this.fileCtrl.setTypeFichier(5);
                                 }
                              } else {
                                 this.fileCtrl.setTypeFichier(4);
                              }
                           } else {
                              this.fileCtrl.setTypeFichier(3);
                           }
                        } else {
                           this.fileCtrl.setTypeFichier(2);
                        }
                     } else {
                        this.fileCtrl.setTypeFichier(1);
                     }
                  } else {
                     this.fileCtrl.setTypeFichier(0);
                  }

                  this.lesPiecesJointes.add(this.fileCtrl);
               }
            }
         }

         this.fichierUrl = null;
         this.fileCtrl = null;
      }

      this.dataModelPieceJointes.setWrappedData(this.lesPiecesJointes);
   }

   public void selectionnerPieceJointe() throws MalformedURLException, IOException {
      if (this.dataModelPieceJointes.isRowAvailable()) {
         this.fileCtrl = (FileCtrl)this.dataModelPieceJointes.getRowData();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(this.fileCtrl.getChemin() + this.fileCtrl.getName(), this.urlExplorateur);
         this.fichierMine = this.fileCtrl.getMime();
         this.nomPiecesJointes = this.fileCtrl.getName();
         this.typeFichier = this.fileCtrl.getTypeFichier();
      }

   }

   public void ajouterPieceJointe() {
      this.uploadedFile = null;
      this.nomPiecesJointes = null;
      this.fileCtrl = new FileCtrl();
      this.showModalPanelAjoutScan = true;
   }

   public void annulerPieceJointe() {
      this.showModalPanelAjoutScan = false;
   }

   public void validerPieceJointe() throws HibernateException, NamingException {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1 != null && !var1.isEmpty() && var1.contains(".")) {
               boolean var2 = false;
               if (this.lesPiecesJointes.size() != 0) {
                  for(int var3 = 0; var3 < this.lesPiecesJointes.size(); ++var3) {
                     this.fileCtrl = (FileCtrl)this.lesPiecesJointes.get(var3);
                     if (this.fileCtrl.getName().equals(var1)) {
                        var2 = true;
                        this.suppressionPjSuite();
                     }
                  }
               }

               String var8 = var1.substring(var1.indexOf(".") + 1);
               String[] var4 = var1.split(var8);
               this.nomPiecesJointes = var4[0];
               if (var1.toString().contains(".")) {
                  if (!var2) {
                     if (this.nomPiecesJointes != null && !this.nomPiecesJointes.isEmpty()) {
                        var1 = this.receptionEnteteAchats.getRecNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomPiecesJointes) + "." + var8;
                     } else {
                        var1 = this.receptionEnteteAchats.getRecNum().replace("/", "_") + "." + var8;
                     }
                  }

                  this.nomPiecesJointes = var1;
                  File var5 = new File(this.cheminPieceJointes + var1);
                  var5.delete();
                  File var6 = this.utilDownload.uniqueFile(new File(this.cheminPieceJointes), var1);
                  this.utilDownload.write(var6, this.uploadedFile.getInputStream());
                  this.fileCtrl = new FileCtrl();
                  this.fileCtrl.setName(this.nomPiecesJointes);
                  this.fileCtrl.setChemin(this.cheminPieceJointes);
                  if (!this.fileCtrl.getName().contains("pdf") && !this.fileCtrl.getName().contains("PDF")) {
                     if (!this.fileCtrl.getName().contains("doc") && !this.fileCtrl.getName().contains("DOC")) {
                        if (!this.fileCtrl.getName().contains("xls") && !this.fileCtrl.getName().contains("XLS")) {
                           if (!this.fileCtrl.getName().contains("ppt") && !this.fileCtrl.getName().contains("PPT")) {
                              if (!this.fileCtrl.getName().contains("odt") && !this.fileCtrl.getName().contains("ODT")) {
                                 if (!this.fileCtrl.getName().contains("ods") && !this.fileCtrl.getName().contains("ODS")) {
                                    if (!this.fileCtrl.getName().contains("odp") && !this.fileCtrl.getName().contains("ODP")) {
                                       if (!this.fileCtrl.getName().contains("jpg") && !this.fileCtrl.getName().contains("JPG")) {
                                          this.fileCtrl.setTypeFichier(8);
                                       } else {
                                          this.fileCtrl.setTypeFichier(7);
                                       }
                                    } else {
                                       this.fileCtrl.setTypeFichier(6);
                                    }
                                 } else {
                                    this.fileCtrl.setTypeFichier(5);
                                 }
                              } else {
                                 this.fileCtrl.setTypeFichier(4);
                              }
                           } else {
                              this.fileCtrl.setTypeFichier(3);
                           }
                        } else {
                           this.fileCtrl.setTypeFichier(2);
                        }
                     } else {
                        this.fileCtrl.setTypeFichier(1);
                     }
                  } else {
                     this.fileCtrl.setTypeFichier(0);
                  }

                  this.lesPiecesJointes.add(this.fileCtrl);
                  this.dataModelPieceJointes.setWrappedData(this.lesPiecesJointes);
                  if (this.lesPiecesJointes.size() != 0) {
                     this.receptionEnteteAchats.setRecPj(true);
                  } else {
                     this.receptionEnteteAchats.setRecPj(false);
                  }

                  this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
               }
            }
         }
      } catch (IOException var7) {
      }

      this.showModalPanelAjoutScan = false;
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

   public void consulterPieceJointe() throws MalformedURLException, IOException {
      this.selectionnerPieceJointe();
      if (this.fileCtrl != null && (this.fileCtrl.getTypeFichier() == 0 || this.fileCtrl.getTypeFichier() == 7)) {
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuPieceJointe() {
      this.showModalPanelPj = false;
   }

   public void supprimerPieceJointe() throws MalformedURLException, IOException, HibernateException, NamingException {
      this.selectionnerPieceJointe();
      this.suppressionPjSuite();
      if (this.lesPiecesJointes.size() != 0) {
         this.receptionEnteteAchats.setRecPj(true);
      } else {
         this.receptionEnteteAchats.setRecPj(false);
      }

      this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
   }

   public void suppressionPjSuite() {
      if (this.fileCtrl != null) {
         String var1 = this.fileCtrl.getChemin() + this.fileCtrl.getName();
         File var2 = new File(var1);
         var2.delete();
         this.lesPiecesJointes.remove(this.fileCtrl);
         this.dataModelPieceJointes.setWrappedData(this.lesPiecesJointes);
         this.nomPiecesJointes = null;
         this.fileCtrl = null;
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.receptionEnteteAchats.getRecNomTiers(), this.nature);
      if (this.tiers != null) {
         if (this.tiers.getTieid() != 0L) {
            this.calculeTiers();
         } else {
            this.var_action = 9;
         }
      } else if (this.tiers == null) {
         this.calculeTiers();
      }

   }

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.tiers != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         this.receptionEnteteAchats.setTiers(this.tiers);
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.receptionEnteteAchats.setRecCivilTiers("");
            this.var_typeTiers = true;
         } else {
            this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.receptionEnteteAchats.setRecCivilTiers(this.receptionEnteteAchats.getTiers().getTiecivilite());
            this.var_typeTiers = false;
         }

         this.receptionEnteteAchats.setRecNomTiers(this.nomTier);
         this.receptionEnteteAchats.setRecTypeReg(this.tiers.getTietypereg());
         this.receptionEnteteAchats.setRecModeReg(this.tiers.getTiemodereg());
         this.calculMessageLitige();
         String var2 = "";
         if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
            String[] var3 = this.tiers.getTiemodereg().split(":");
            var2 = var3[0];
         } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
            var2 = this.tiers.getTiemodereg();
         }

         if (!var2.equals("") && !var2.equals("100")) {
            this.receptionEnteteAchats.setRecNbJourReg(this.tiers.getTienbecheance());
            this.receptionEnteteAchats.setRecArrondiReg(this.tiers.getTienbarrondi());
         } else {
            for(int var7 = 0; var7 < this.lesModeReglementFournisseurListe.size(); ++var7) {
               new ObjetReglement();
               ObjetReglement var4 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var7);
               if (var4.getDefaut().equals("true")) {
                  if (var4.getEcheances() == null || var4.getEcheances().isEmpty()) {
                     var4.setEcheances("0");
                  }

                  this.receptionEnteteAchats.setRecTypeReg(Integer.parseInt(var4.getEcheances()));
                  this.receptionEnteteAchats.setRecModeReg(var4.getCategories() + ":" + var4.getLibelles());
                  int var5 = 0;
                  if (var4.getNbjours() != null && !var4.getNbjours().isEmpty()) {
                     var5 = Integer.parseInt(var4.getNbjours());
                  }

                  this.receptionEnteteAchats.setRecNbJourReg(var5);
                  int var6 = 0;
                  if (var4.getArrondis() != null && !var4.getArrondis().isEmpty()) {
                     var6 = Integer.parseInt(var4.getArrondis());
                  }

                  this.receptionEnteteAchats.setRecArrondiReg(var6);
                  break;
               }
            }
         }

         this.chargerModeEcheanceAffichage();
         this.receptionEnteteAchats.setRecJournalReg(this.tiers.getTiejournalreg());
         if (this.tiers.getTienomfamille() != null && !this.tiers.getTienomfamille().isEmpty()) {
            this.receptionEnteteAchats.setRecCat(this.tiers.getTienomfamille());
            this.receptionEnteteAchats.setRecExoDouane(this.tiers.getTieexodouane());
            this.receptionEnteteAchats.setRecExoTva(this.tiers.getTieexotva());
            if (!this.tiers.getTiecodepays().equalsIgnoreCase(this.structureLog.getStrcodepays())) {
               this.receptionEnteteAchats.setRecExoTva(1);
            }
         } else if (this.tiers.getTiecodepays().equalsIgnoreCase(this.structureLog.getStrcodepays())) {
            this.receptionEnteteAchats.setRecCat("Local");
            this.receptionEnteteAchats.setRecValorisation(0);
            this.receptionEnteteAchats.setRecCoefValo(1.0F);
            this.receptionEnteteAchats.setRecExoTva(0);
            this.receptionEnteteAchats.setRecExoTva(0);
         } else {
            this.receptionEnteteAchats.setRecCat("Import");
            this.receptionEnteteAchats.setRecValorisation(1);
            this.receptionEnteteAchats.setRecCoefValo(0.0F);
            this.receptionEnteteAchats.setRecExoTva(0);
            this.receptionEnteteAchats.setRecExoTva(1);
         }

         if (this.tiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
            this.receptionEnteteAchats.setRecDiversTiers(99);
         } else {
            this.receptionEnteteAchats.setRecDiversTiers(0);
            this.receptionEnteteAchats.setRecDiversNom("");
            this.receptionEnteteAchats.setRecDiversAdresse("");
            this.receptionEnteteAchats.setRecDiversVille("");
            this.receptionEnteteAchats.setRecDiversTel("");
            this.receptionEnteteAchats.setRecDiversMail("");
            this.receptionEnteteAchats.setRecExoTva(0);
            this.receptionEnteteAchats.setRecExoTva(0);
         }

         if (this.tiers.getTiedevise() != null && !this.tiers.getTiedevise().isEmpty()) {
            this.receptionEnteteAchats.setRecDevise(this.tiers.getTiedevise());
         } else {
            this.receptionEnteteAchats.setRecDevise(this.structureLog.getStrdevise());
         }

         this.mesContactItem.clear();
         this.chargerLesContactsItem(var1);
         this.chargerLesUsers(var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTiers();
      }

      this.calculDeviseCategorie();
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void calculMessageLitige() {
      this.informationsTiers = null;
      if (this.tiers != null) {
         if (this.tiers.getTiecomptebloque() == 1) {
            this.informationsTiers = "***   COMPTE BLOQUE   ***";
         } else if (this.tiers.getTiechequeinterdit() == 1) {
            this.informationsTiers = "***   CHEQUE INTERDIT   ***";
         }

         if (this.tiers.getTieobservations() != null && !this.tiers.getTieobservations().isEmpty()) {
            this.informationsTiers = this.informationsTiers + "   (" + this.tiers.getTieobservations() + ")";
         }
      }

   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      this.informationsTiers = null;
      this.receptionEnteteAchats.setTiers(this.tiers);
      this.receptionEnteteAchats.setRecNomTiers("");
      this.receptionEnteteAchats.setRecCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.lesUsers.clear();
      this.mesUsersItem.clear();
      this.mesUsersItem.add(new SelectItem(0, ""));
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void calculDeviseCategorie() throws HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      if (this.lesFamilleFournisseursListe.size() != 0) {
         for(int var3 = 0; var3 < this.lesFamilleFournisseursListe.size(); ++var3) {
            if (this.receptionEnteteAchats.getRecCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && !var1.equalsIgnoreCase("1")) {
         if (var1.equalsIgnoreCase("2")) {
            if (this.tiers != null && this.tiers.getTiecodepays() != null && !this.tiers.getTiecodepays().equals(this.structureLog.getStrcodepays())) {
               this.receptionEnteteAchats.setRecExoTva(3);
            } else {
               this.receptionEnteteAchats.setRecExoTva(2);
            }
         } else {
            this.receptionEnteteAchats.setRecExoTva(0);
         }
      } else {
         this.receptionEnteteAchats.setRecExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && !var2.equalsIgnoreCase("1")) {
         this.receptionEnteteAchats.setRecExoDouane(0);
      } else {
         this.receptionEnteteAchats.setRecExoDouane(1);
      }

      this.calculDevise((Session)null);
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (!this.receptionEnteteAchats.getRecNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.CalculDateEcheance();
         if (this.receptionEnteteAchats.getRecCat() != null && !this.receptionEnteteAchats.getRecCat().isEmpty()) {
            if (this.receptionEnteteAchats.getRecCat().equalsIgnoreCase("Import")) {
               if (this.optionAchats.getAxeDossier().equals("2")) {
                  if (this.receptionEnteteAchats.getRecAffaire() != null && !this.receptionEnteteAchats.getRecAffaire().isEmpty()) {
                     this.var_valide_doc = true;
                  } else {
                     this.var_valide_doc = false;
                  }
               } else if (this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
                  this.var_valide_doc = true;
               } else {
                  this.var_valide_doc = false;
               }

               this.receptionEnteteAchats.setRecValorisation(1);
            } else {
               if (this.optionAchats.getAxeDossier().equals("2")) {
                  if (this.receptionEnteteAchats.getRecAffaire() != null && !this.receptionEnteteAchats.getRecAffaire().isEmpty()) {
                     this.var_valide_doc = true;
                  } else {
                     this.var_valide_doc = false;
                  }
               } else {
                  this.var_valide_doc = true;
               }

               this.receptionEnteteAchats.setRecValorisation(0);
            }
         } else {
            this.var_valide_doc = false;
         }
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
         this.receptionEnteteAchats.setRecValorisation(0);
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException, ParseException {
      this.calculDeviseCategorie();
      if (this.lesLignesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.receptionLigneAchats = new ReceptionLigneAchats();
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesLignesList.size()) {
                  if (this.receptionEnteteAchats.getRecId() != 0L) {
                     this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
                  }

                  var2.commit();
                  break;
               }

               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.receptionEnteteAchats.getRecExoTva() == 1) {
                  this.receptionLigneAchats.setRecligTaxe("");
                  this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                  this.receptionLigneAchats.setRecligTva(0.0D);
                  if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                  }
               } else if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                  TaxesAchats var4;
                  if (this.produits != null) {
                     if (!this.produits.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
                        if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty()) {
                           this.receptionLigneAchats.setRecligTaxe(this.produits.getProVteTva());
                        } else {
                           this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), this.produits, var1);
                           if (this.famillesProduitsAchats != null) {
                              this.receptionLigneAchats.setRecligTaxe(this.famillesProduitsAchats.getFamachTaxe());
                           }
                        }

                        new TaxesAchats();
                        var4 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.receptionLigneAchats.getRecligTaxe(), var1);
                        if (var4 != null) {
                           this.receptionLigneAchats.setRecligTauxTaxe(var4.getTaxachTaux());
                        } else {
                           this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                        }
                     } else {
                        this.receptionLigneAchats.setRecligTaxe("");
                        this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                     }
                  } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
                     new TaxesAchats();
                     var4 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var1);
                     if (var4 != null) {
                        this.receptionLigneAchats.setRecligTaxe(this.optionAchats.getTvaDefaut());
                        this.receptionLigneAchats.setRecligTauxTaxe(var4.getTaxachTaux());
                     } else {
                        this.receptionLigneAchats.setRecligTaxe("");
                        this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                     }
                  } else {
                     this.receptionLigneAchats.setRecligTaxe("");
                     this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                  }
               }

               this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), var1);
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
               ++var3;
            }
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         this.chargerDocumentLigne(var1);
         this.utilInitHibernate.closeSession();
         this.cumulPrix();
      }

      this.controleSaisie();
   }

   public void detailTiers() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 12;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void modifTiers() {
      this.var_aff_detail_tiers = false;
   }

   public void ajouterContact() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null && this.tiers.getTieid() != 0L) {
         this.formRecherche.rechercheContacts(this.tiers, this.nature);
         this.var_action = 16;
      }

   }

   public void annulerContact() {
      this.var_action = this.var_memo_action;
   }

   public void recuperationContact() throws JDOMException, IOException {
      this.mesContactItem = this.formRecherche.calculeContactItems();
      if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
         this.mesContactItem.clear();
         this.mesContactItem.add(new SelectItem(0, ""));
      }

      this.var_action = this.var_memo_action;
   }

   public void rechercheResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheResponsable(this.inpResponsable, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeResponsable();
         } else {
            this.var_action = 11;
         }
      } else if (this.responsable == null) {
         this.calculeResponsable();
      }

   }

   public void recuperationResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeResponsable();
      this.calculeResponsable();
   }

   public void calculeResponsable() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpResponsable = this.responsable.getUsrPatronyme();
      } else {
         this.inpResponsable = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleResponsable() {
      this.inpResponsable = "";
      this.var_action = this.var_memo_action;
   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.rechercheProduitAchat(this.receptionLigneAchats.getRecligCode(), this.nature);
      if (this.produits != null) {
         if (this.produits.getProId() != 0L) {
            this.calculeProduits();
         } else {
            this.var_action = 15;
         }
      } else if (this.produits == null) {
         this.calculeProduits();
      }

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         this.receptionLigneAchats.setRecligCode(this.produits.getProCode());
         if (this.optionAchats.getModLibelleProd().equals("1")) {
            this.receptionLigneAchats.setRecligLibelle(this.produits.getProLibTech());
         } else {
            this.receptionLigneAchats.setRecligLibelle(this.produits.getProLibClient());
         }

         this.receptionLigneAchats.setRecligFamille(this.produits.getProAchCode() + ":" + this.produits.getProAchLib());
         this.receptionLigneAchats.setRecligStock(this.produits.getProStock());
         this.receptionLigneAchats.setRecligLong(this.produits.getProLongueur());
         this.receptionLigneAchats.setRecligLarg(this.produits.getProLargeur());
         this.receptionLigneAchats.setRecligHaut(this.produits.getProEpaisseur());
         this.receptionLigneAchats.setRecligDiam(this.produits.getProDiamExt());
         this.receptionLigneAchats.setRecligPoidsBrut(this.produits.getProPoidsBrut());
         this.receptionLigneAchats.setRecligPoidsNet(this.produits.getProPoidsNet());
         this.receptionLigneAchats.setRecligVolume(this.produits.getProVolume());
         this.receptionLigneAchats.setRecligNb(this.produits.getProNbUnite());
         this.receptionLigneAchats.setRecligReference((String)null);
         this.receptionLigneAchats.setRecligLibelleFournisseur((String)null);
         if (this.produits.getProAchDouane() != null && !this.produits.getProAchDouane().isEmpty()) {
            if (this.produits.getProAchDouane().contains(":")) {
               String[] var2 = this.produits.getProAchDouane().split(":");
               this.receptionLigneAchats.setRecligDouane(var2[0]);
            } else {
               this.receptionLigneAchats.setRecligDouane(this.produits.getProAchDouane());
            }
         } else {
            this.receptionLigneAchats.setRecligDouane("");
         }

         new FamillesProduitsAchats();
         FamillesProduitsAchats var5 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.lastExoAchats.getExeachId(), this.produits, var1);
         if (var5 != null) {
            if ((this.receptionLigneAchats.getRecligDouane() == null || this.receptionLigneAchats.getRecligDouane().isEmpty()) && var5.getFamachDouane() != null && !var5.getFamachDouane().isEmpty()) {
               if (var5.getFamachDouane().contains(":")) {
                  String[] var3 = var5.getFamachDouane().split(":");
                  this.receptionLigneAchats.setRecligDouane(var3[0]);
               } else {
                  this.receptionLigneAchats.setRecligDouane(var5.getFamachDouane());
               }
            }
         } else {
            this.receptionLigneAchats.setRecligDouane(var5.getFamachDouane());
         }

         if (this.produits.getProImpDesciption() == 1) {
            if (this.usersLog.getUsrAchLibelle() == 1) {
               this.verrou_libelle = true;
            } else {
               this.verrou_libelle = false;
            }
         } else {
            this.verrou_libelle = false;
         }

         this.selectionListeTva();
         TaxesAchats var4;
         float var6;
         if (this.produits.getProAchTva() != null && !this.produits.getProAchTva().isEmpty() && !this.produits.getProAchTva().equals("0")) {
            var6 = 0.0F;
            new TaxesAchats();
            var4 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.produits.getProAchTva(), var1);
            if (var4 != null) {
               var6 = var4.getTaxachTaux();
            }

            this.receptionLigneAchats.setRecligTaxe(this.produits.getProAchTva());
            this.receptionLigneAchats.setRecligTauxTaxe(var6);
         } else if (var5 != null && var5.getFamachTaxe() != null && !var5.getFamachTaxe().isEmpty() && !var5.getFamachTaxe().equals("0")) {
            var6 = 0.0F;
            new TaxesAchats();
            var4 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), var5.getFamachTaxe(), var1);
            if (var4 != null) {
               var6 = var4.getTaxachTaux();
            }

            this.receptionLigneAchats.setRecligTaxe(var5.getFamachTaxe());
            this.receptionLigneAchats.setRecligTauxTaxe(var6);
         } else {
            this.receptionLigneAchats.setRecligTaxe("");
            this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
         }

         if (this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            this.receptionLigneAchats.setRecligTaxe("");
            this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.receptionLigneAchats.setRecligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.receptionLigneAchats.setRecligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.receptionLigneAchats.setRecligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.receptionLigneAchats.setRecligCondition("");
         this.prixUnitaireCorrespond(var1);
         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void calculeProduitsFrais(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
            var2 = true;
         }

         this.fraisLigneAchats.setFsfligCode(this.produits.getProCode());
         this.fraisLigneAchats.setFsfligLibelle(this.produits.getProLibClient());
         this.fraisLigneAchats.setFsfligFamille(this.produits.getProAchCode());
         this.fraisLigneAchats.setFsfligMode(this.produits.getProMode());
         this.mesTaxesAchatsProduits.clear();
         if (this.mesTaxesAchatsItems.size() != 0) {
            for(int var3 = 0; var3 < this.mesTaxesAchatsItems.size(); ++var3) {
               this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var3));
            }
         }

         if (this.produits.getProAchTva() != null && !this.produits.getProAchTva().isEmpty() && !this.produits.getProAchTva().equals("0")) {
            float var7 = 0.0F;
            new TaxesAchats();
            TaxesAchats var8 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.produits.getProAchTva(), var1);
            if (var8 != null) {
               var7 = var8.getTaxachTaux();
            }

            this.fraisLigneAchats.setFsfligTaxe(this.produits.getProAchTva());
            this.fraisLigneAchats.setFsfligTauxTaxe(var7);
         } else {
            new FamillesProduitsAchats();
            FamillesProduitsAchats var6 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.lastExoAchats.getExeachId(), this.produits, var1);
            if (var6 != null && var6.getFamachTaxe() != null && !var6.getFamachTaxe().isEmpty() && !var6.getFamachTaxe().equals("0")) {
               float var4 = 0.0F;
               new TaxesAchats();
               TaxesAchats var5 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), var6.getFamachTaxe(), var1);
               if (var5 != null) {
                  var4 = var5.getTaxachTaux();
               }

               this.fraisLigneAchats.setFsfligTaxe(var6.getFamachTaxe());
               this.fraisLigneAchats.setFsfligTauxTaxe(var4);
            } else {
               this.fraisLigneAchats.setFsfligTaxe("");
               this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
            }
         }

         if (this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            this.fraisLigneAchats.setFsfligTaxe("");
            this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
         }

         this.mesTaxesAchatsProduits.add(new SelectItem(0, ""));
         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void detailProduit() {
      if (this.produits.getProPhoto() != null) {
         this.formRecherche.setUrlphotoProd(this.urlphotoProd);
      } else {
         this.urlphotoProd = "";
         this.formRecherche.setUrlphotoProd(this.urlphotoProd);
      }

      this.formRecherche.setProduits(this.produits);
      this.formRecherche.setNature(this.nature);
      this.var_action = 13;
   }

   public void annuleDetailProduit() {
      this.var_action = this.var_memo_action;
   }

   public void selectionListeTva() {
      this.mesTaxesAchatsProduits.clear();
      int var1;
      boolean var2;
      int var3;
      if (this.receptionEnteteAchats.getRecExoTva() == 0) {
         if (this.mesTaxesAchatsItems.size() != 0) {
            for(var1 = 0; var1 < this.mesTaxesAchatsItems.size(); ++var1) {
               var2 = false;

               for(var3 = 0; var3 < this.lisTaxesAchats.size(); ++var3) {
                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachCode().equals(((SelectItem)this.mesTaxesAchatsItems.get(var1)).getValue().toString()) && (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 0 || ((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 1)) {
                     var2 = true;
                     break;
                  }
               }

               if (var2) {
                  this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var1));
               }
            }
         }

         if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
            this.receptionLigneAchats.setRecligTaxe(this.optionAchats.getTvaDefaut());
         }
      } else if ((this.receptionEnteteAchats.getRecExoTva() == 2 || this.receptionEnteteAchats.getRecExoTva() == 3) && this.mesTaxesAchatsItems.size() != 0) {
         for(var1 = 0; var1 < this.mesTaxesAchatsItems.size(); ++var1) {
            var2 = false;

            for(var3 = 0; var3 < this.lisTaxesAchats.size(); ++var3) {
               if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachCode().equals(((SelectItem)this.mesTaxesAchatsItems.get(var1)).getValue().toString())) {
                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 2 && this.receptionEnteteAchats.getRecExoTva() == 2) {
                     var2 = true;
                     break;
                  }

                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 3 && this.receptionEnteteAchats.getRecExoTva() == 3) {
                     var2 = true;
                     break;
                  }
               }
            }

            if (var2) {
               this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var1));
            }
         }
      }

      this.mesTaxesAchatsProduits.add(new SelectItem(0, ""));
   }

   public void calculTva() {
      if (this.receptionLigneAchats.getRecligCode() == null || this.receptionLigneAchats.getRecligCode().isEmpty() || this.receptionLigneAchats.getRecligCode().length() < 2) {
         this.selectionListeTva();
         this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
         this.mesConditionnementsProduits = this.chargerConditionnementProduit((Session)null);
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.produitsDepot = null;
      this.receptionLigneAchats.setRecligCode("");
      this.receptionLigneAchats.setRecligLibelle("");
      this.mesTaxesAchatsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null && this.tiers != null) {
         this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
         if (this.produitsFournisseur != null) {
            this.receptionLigneAchats.setRecligPu(this.produitsFournisseur.getProfouPa());
            this.receptionLigneAchats.setRecligReference(this.produitsFournisseur.getProfouRef());
            this.receptionLigneAchats.setRecligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      if (this.receptionLigneAchats != null) {
         this.selectionDepot((Session)null);
         this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
         if (this.mesUnitesProduits != null && this.mesUnitesProduits.size() != 0) {
            this.receptionLigneAchats.setRecligUnite(this.produitsDepot.getProdepUnite());
         } else {
            this.receptionLigneAchats.setRecligUnite("");
         }
      }

   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         if (this.mesProduitsDepotsItems.size() != 0) {
            if (this.var_depotProd == null || this.var_depotProd.isEmpty()) {
               this.var_depotProd = ((SelectItem)this.mesProduitsDepotsItems.get(0)).getLabel();
            }

            String[] var2 = null;
            if (this.var_depotProd.contains(":")) {
               var2 = this.var_depotProd.split(":");
            } else {
               var2 = this.var_depotProd.split("=");
            }

            String var3 = var2[0];
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), var3, var1);
            if (this.produitsDepot == null) {
               this.produitsDepot = null;
               this.var_depotProd = "";
               this.var_code_unite = 0;
            } else {
               this.var_code_unite = this.produitsDepot.getProdepEchelle();
            }
         } else {
            if (this.produits.getProStock() != 0 && this.mesDepotAchItems != null && this.mesDepotAchItems.size() != 0) {
               for(int var9 = 0; var9 < this.mesDepotAchItems.size(); ++var9) {
                  this.mesProduitsDepotsItems.add(new SelectItem(((SelectItem)this.mesDepotAchItems.get(var9)).getValue()));
               }
            }

            this.produitsDepot = null;
            this.var_depotProd = "";
            this.var_code_unite = 0;
         }
      } else {
         this.produitsDepot = null;
         this.var_depotProd = "";
         this.var_code_unite = 0;
      }

      if (this.produitsDepot != null) {
         double var10 = 0.0D;
         float var4;
         if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && this.receptionLigneAchats.getRecligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.receptionLigneAchats.getRecligEchelle());
            float var5 = 1.0F;
            if (this.receptionLigneAchats.getRecligCondition().contains("/")) {
               String[] var6 = this.receptionLigneAchats.getRecligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var10 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.receptionLigneAchats.getRecligCondition() != null && !this.receptionLigneAchats.getRecligCondition().isEmpty() && !this.receptionLigneAchats.getRecligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.receptionLigneAchats.getRecligEchelle());
            var10 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var10 = this.produitsDepot.getProdepPump();
         }

         this.receptionLigneAchats.setRecligPump(var10);
      } else {
         this.receptionLigneAchats.setRecligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.receptionLigneAchats.getRecligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.receptionLigneAchats.setRecligEchelle(this.unite.getUniEchelle());
               } else {
                  this.receptionLigneAchats.setRecligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.receptionLigneAchats.setRecligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.receptionLigneAchats.setRecligEchelle(Integer.parseInt(var2));
         } else {
            this.receptionLigneAchats.setRecligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (this.listeProduitDepot.size() == 0) {
            new ArrayList();
            DepotAchatsDao var12 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
            List var10 = var12.selectActifDepot(this.nature, var1);
            if (var10.size() != 0) {
               for(int var14 = 0; var14 < var10.size(); ++var14) {
                  this.produitsDepot = new ProduitsDepot();
                  this.produitsDepot.setDepot((DepotAchats)var10.get(var14));
                  this.produitsDepot.setProduits(this.produits);
                  this.listeProduitDepot.add(this.produitsDepot);
               }
            }
         }

         if (this.listeProduitDepot.size() != 0) {
            for(int var11 = 0; var11 < this.listeProduitDepot.size(); ++var11) {
               ProduitsDepot var13 = (ProduitsDepot)this.listeProduitDepot.get(var11);
               float var15 = 0.0F;
               if (this.optionAchats.getChoixStock().equals("1")) {
                  var15 = var13.getProdepQteStk() - var13.getProdepQteAttAch();
               } else {
                  var15 = var13.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var15 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var15, this.receptionLigneAchats.getRecligLong(), this.receptionLigneAchats.getRecligLarg(), this.receptionLigneAchats.getRecligHaut(), this.receptionLigneAchats.getRecligDiam(), this.receptionLigneAchats.getRecligNb(), this.baseLog, var1);
                  var7 = (int)var15;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var15 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var15, this.receptionLigneAchats.getRecligLong(), this.receptionLigneAchats.getRecligLarg(), this.receptionLigneAchats.getRecligHaut(), this.receptionLigneAchats.getRecligDiam(), this.receptionLigneAchats.getRecligNb(), this.baseLog, var1);
                  var7 = (int)var15;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var15;
               }

               if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
                  if (!this.verrouDepotUser.contains(",")) {
                     if (var13.getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                        if (var13.getProdepCasier() != null && !var13.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var13.getDepot().getDpoCode() + ":" + var13.getDepot().getDpoLibelle() + ":" + var13.getProdepCasier() + "=" + var6));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var13.getDepot().getDpoCode() + ":" + var13.getDepot().getDpoLibelle() + "=" + var6));
                        }
                     }
                  } else {
                     String[] var16 = this.verrouDepotUser.split(",");
                     int var8 = var16.length;

                     for(int var9 = 0; var9 < var8; ++var9) {
                        if (var13.getDepot().getDpoCode().equals(var16[var9])) {
                           if (var13.getProdepCasier() != null && !var13.getProdepCasier().isEmpty()) {
                              this.mesProduitsDepotsItems.add(new SelectItem(var13.getDepot().getDpoCode() + ":" + var13.getDepot().getDpoLibelle() + ":" + var13.getProdepCasier() + "=" + var6));
                              break;
                           }

                           this.mesProduitsDepotsItems.add(new SelectItem(var13.getDepot().getDpoCode() + ":" + var13.getDepot().getDpoLibelle() + "=" + var6));
                           break;
                        }
                     }
                  }
               } else if (var13.getProdepCasier() != null && !var13.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var13.getDepot().getDpoCode() + ":" + var13.getDepot().getDpoLibelle() + ":" + var13.getProdepCasier() + "=" + var6));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var13.getDepot().getDpoCode() + ":" + var13.getDepot().getDpoLibelle() + "=" + var6));
               }
            }
         }
      }

   }

   public List chargerUniteProduit(Session var1) {
      this.mesUnitesProduits.clear();
      if (this.produits != null && this.produitsDepot != null && this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
         this.mesUnitesProduits.add(new SelectItem(this.produitsDepot.getProdepUnite()));
      }

      if (this.mesUnitesProduits.size() != 0) {
         this.var_aff_unite = true;
      } else {
         this.var_aff_unite = false;
      }

      return this.mesUnitesProduits;
   }

   public List chargerConditionnementProduit(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementStock(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void rechercheDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      String var1 = "" + (this.var_date.getYear() + 1900);
      this.dossier = new PlansAnalytiques();
      if (this.optionAchats.getAxeDossier().equals("2")) {
         this.dossier = this.formRecherche.rechercheAffaire(this.receptionEnteteAchats.getRecAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.receptionEnteteAchats.getRecSerie(), this.receptionEnteteAchats.getRecDevise());
      } else {
         this.dossier = this.formRecherche.rechercheDossier(this.receptionEnteteAchats.getRecAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.receptionEnteteAchats.getRecSerie(), this.receptionEnteteAchats.getRecDevise());
      }

      if (this.dossier != null) {
         if (this.dossier.getAnaId() != 0L) {
            this.calculeDossier();
         } else {
            this.var_action = 14;
         }
      } else if (this.dossier == null) {
         this.calculeDossier();
      }

   }

   public void recuperationDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.dossier = this.formRecherche.calculeDossier();
      this.calculeDossier();
   }

   public void calculeDossier() throws JDOMException, IOException, ParseException, HibernateException, NamingException {
      if (this.dossier != null) {
         if (this.optionAchats.getAxeDossier().equals("2")) {
            if (this.dossier.getAnaNature() != null && !this.dossier.getAnaNature().isEmpty()) {
               if (this.dossier.getAnaNature().equals("6")) {
                  this.libelleDossierFiche = "N° Dossier";
               } else if (this.dossier.getAnaNature().equals("10")) {
                  this.libelleDossierFiche = "N° Affaire";
               }
            }

            if (this.dossier.getAnaTypeDossier() != null && !this.dossier.getAnaTypeDossier().isEmpty() && !this.dossier.getAnaTypeDossier().equals("0")) {
               this.receptionEnteteAchats.setRecAnal4(this.dossier.getAnaTypeDossier() + this.dossier.getAnaCode());
            } else {
               this.receptionEnteteAchats.setRecAnal4(this.dossier.getAnaCode());
            }
         } else {
            this.libelleDossierFiche = "N° Dossier";
            this.receptionEnteteAchats.setRecAnal4(this.dossier.getAnaCode());
         }

         if (this.receptionEnteteAchats.getRecDevise() == null || this.receptionEnteteAchats.getRecDevise().isEmpty()) {
            this.receptionEnteteAchats.setRecDevise(this.dossier.getAnaTypeDevise());
            this.receptionEnteteAchats.setRecCoefDevise(this.dossier.getAnaTypeTauxDevise());
         }

         this.receptionEnteteAchats.setRecObject(this.dossier.getAnaNomFr());
         this.chargerFraisAuto();
      } else {
         this.receptionEnteteAchats.setRecAnal4("");
         this.receptionEnteteAchats.setRecDevise(this.tiers.getTiedevise());
         this.receptionEnteteAchats.setRecCoefDevise(1.0F);
         this.receptionEnteteAchats.setRecObject("");
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleDossier() {
      this.receptionEnteteAchats.setRecAnal4("");
      if (this.tiers != null) {
         this.receptionEnteteAchats.setRecDevise(this.tiers.getTiedevise());
      } else {
         this.receptionEnteteAchats.setRecDevise("");
      }

      this.receptionEnteteAchats.setRecCoefDevise(1.0F);
      this.receptionEnteteAchats.setRecExoTva(0);
      this.receptionEnteteAchats.setRecExoDouane(0);
      this.receptionEnteteAchats.setRecObject("");
      this.var_action = this.var_memo_action;
   }

   public void serieSelectTrf() throws HibernateException, NamingException, ParseException {
      this.mesSeriesTrfItems.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      new ArrayList();
      if (this.var_type_trf != 100) {
         if (this.receptionEnteteAchats.getRecDateFacture() != null) {
            this.var_date_trf = this.receptionEnteteAchats.getRecDateFacture();
         } else {
            this.var_date_trf = null;
         }

         List var2 = this.usersChronoDao.selectListByUserNat(this.usersLog, this.var_type_trf, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (this.usersLog.getUsrJrxReserve() == 1) {
                  if (((UsersChrono)var2.get(var3)).getUsrchrPrive() == 0) {
                     this.mesSeriesTrfItems.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
                  }
               } else {
                  this.mesSeriesTrfItems.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
               }
            }

            this.qteTrfQteOrg(var1);
            this.var_aff_trf = true;
         } else {
            this.var_aff_trf = false;
         }
      } else {
         this.var_aff_trf = false;
      }

      if (this.optionAchats.getDateTransformation().equals("0")) {
         this.var_date_trf = null;
      } else {
         this.var_date_trf = new Date();
      }

      this.var_serie_trf = this.receptionEnteteAchats.getRecSerie();
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 10) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (this.var_type_trf == 11) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (this.var_type_trf == 12) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (this.var_type_trf == 13) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (this.var_type_trf == 14) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (this.var_type_trf == 15) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (this.var_type_trf == 16) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (this.var_type_trf == 17) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (this.var_type_trf == 18) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (this.var_type_trf == 19) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (this.var_type_trf == 35) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.modeleTrfItems.add(new SelectItem(var5));
            }
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

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.receptionEnteteAchats.getRecSerie();
      this.var_imput_cat = this.receptionEnteteAchats.getRecCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new ReceptionEnteteAchats();
         ReceptionEnteteAchats var1 = this.receptionEnteteAchatsDao.pourParapheur(this.var_imput_num, this.receptionEnteteAchats.getRecSerie(), (Session)null);
         if (var1 != null) {
            this.var_imput_num = "";
         }
      }

   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      Session var1;
      Transaction var2;
      String var3;
      ArrayList var4;
      ReglementsDao var5;
      int var6;
      Reglements var7;
      int var22;
      Espion var23;
      Parapheur var24;
      if (this.var_imput_choix == 0) {
         if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.receptionEnteteAchats.getRecNum();
               this.receptionEnteteAchats.setRecNum(this.var_imput_num);
               this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
               if (this.receptionEnteteAchats.getRecTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.receptionEnteteAchats.getRecId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.receptionEnteteAchats.getRecNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.receptionEnteteAchats.getRecId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.receptionEnteteAchats.getRecNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Réception achat N° " + var3 + " en Réception achat N° " + this.receptionEnteteAchats.getRecNum());
               this.espionDao.mAJEspion(var23, var1);
               var2.commit();
            } catch (HibernateException var20) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var20;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } else if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.receptionEnteteAchats.getRecNum();
            this.receptionEnteteAchats.setRecSerie(this.var_imput_serie);
            this.receptionEnteteAchats.setRecCat(this.var_imput_cat);
            this.receptionEnteteAchats.setRecNum(this.calculChrono.numCompose(this.receptionEnteteAchats.getRecDate(), this.nature, this.receptionEnteteAchats.getRecSerie(), var1));
            this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
            if (this.receptionEnteteAchats.getRecTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.receptionEnteteAchats.getRecId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.receptionEnteteAchats.getRecNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.receptionEnteteAchats.getRecId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.receptionEnteteAchats.getRecNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Réception achat X N° " + var3 + " en Réception achat " + this.receptionEnteteAchats.getRecSerie() + " N° " + this.receptionEnteteAchats.getRecNum());
            this.espionDao.mAJEspion(var23, var1);
            var2.commit();
         } catch (HibernateException var18) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var18;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.annuleImputSerie();
      this.annule();
      this.chargeListeDetail((Session)null);
   }

   public void annuleImputSerie() {
      this.setShowModalPanelImput(false);
   }

   public void annuleTrf() {
      this.setShowModalPanelTrf(false);
   }

   public void qteTrfQteOrg() throws HibernateException, NamingException {
      this.qteTrfQteOrg((Session)null);
   }

   public void qteTrfQteOrg(Session var1) throws HibernateException, NamingException {
      if (this.documentDetailTrf.size() != 0) {
         boolean var2 = false;
         if (this.receptionEnteteAchats.getRecTotHt() < 0.0D) {
            var2 = true;
         }

         for(int var3 = 0; var3 < this.documentDetailTrf.size(); ++var3) {
            new ReceptionLigneAchats();
            ReceptionLigneAchats var4 = (ReceptionLigneAchats)this.documentDetailTrf.get(var3);
            float var5 = 0.0F;
            ArrayList var6 = new ArrayList();
            if (this.var_type_trf == 15) {
               FactureLigneAchatsDao var10 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var5 = var10.chargerLesReliquatsReceptionAchats(var4.getRecligId(), var1);
               if (var2) {
                  var5 = Math.abs(var5);
               }
            } else if (this.var_type_trf == 14) {
               new ArrayList();
               List var7 = this.produitsDepotDao.selectProdDepByprod(var4.getRecligCode(), var1);
               if (var7.size() != 0) {
                  for(int var8 = 0; var8 < var7.size(); ++var8) {
                     new ProduitsDepot();
                     ProduitsDepot var9 = (ProduitsDepot)var7.get(var8);
                     if (var9.getDepot().getDpoRetourAch() == 1) {
                        var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                     }
                  }
               }

               RetourLigneAchatsDao var12 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var5 = var12.chargerLesReliquatsReceptionAchs(var4.getRecligId(), var1);
            }

            float var11 = 0.0F;
            if (var2) {
               var11 = Math.abs(var4.getRecligQte()) - var5;
            } else {
               var11 = var4.getRecligQte() - var5;
            }

            if (var11 < 0.0F) {
               var11 = 0.0F;
            }

            if (var2) {
               var4.setVar_qteDejaTrf(var5 * -1.0F);
               var4.setVar_qteReliquat(var11 * -1.0F);
            } else {
               var4.setVar_qteDejaTrf(var5);
               var4.setVar_qteReliquat(var11);
            }

            var4.setVar_listDepotItem(var6);
            var4 = (ReceptionLigneAchats)this.documentDetailTrf.set(var3, var4);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new ReceptionLigneAchats();
            ReceptionLigneAchats var2 = (ReceptionLigneAchats)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (ReceptionLigneAchats)this.documentDetailTrf.set(var1, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;

         for(int var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
            var3 += ((ReceptionLigneAchats)this.documentDetailTrf.get(var5)).getRecligQte();
            var2 += ((ReceptionLigneAchats)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((ReceptionLigneAchats)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         int var7;
         if (var3 == var2) {
            new ReceptionEnteteAchats();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               ReceptionEnteteAchats var6 = (ReceptionEnteteAchats)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setRecEtat(5);
                  this.receptionEnteteAchatsDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            ReceptionEnteteAchats var12;
            if (this.var_mode_trf.equals("0")) {
               for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
                  new ReceptionEnteteAchats();
                  var12 = (ReceptionEnteteAchats)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getRecNum().equalsIgnoreCase(((ReceptionEnteteAchats)var1.get(var9)).getRecNum())) {
                           var8 = true;
                           break;
                        }
                     }

                     if (!var8) {
                        var1.add(var12);
                     }
                  }
               }
            } else {
               for(var11 = 0; var11 < this.documentDetailTrf.size(); ++var11) {
                  new ReceptionEnteteAchats();
                  var12 = (ReceptionEnteteAchats)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getTiers().getTieid() == ((ReceptionEnteteAchats)var1.get(var9)).getTiers().getTieid()) {
                           if (var12.getRecSerie().equalsIgnoreCase(((ReceptionEnteteAchats)var1.get(var9)).getRecSerie())) {
                              var8 = true;
                           }
                           break;
                        }
                     }

                     if (!var8) {
                        var1.add(var12);
                     }
                  }
               }
            }

            if (var1.size() != 0) {
               for(var11 = 0; var11 < var1.size(); ++var11) {
                  this.receptionEnteteAchats = (ReceptionEnteteAchats)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((ReceptionEnteteAchats)var1.get(var11)).getRecNum().equalsIgnoreCase(((ReceptionLigneAchats)this.documentDetailTrf.get(var7)).getReceptionEnteteAchats().getRecNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((ReceptionEnteteAchats)var1.get(var11)).getTiers().getTieid() == ((ReceptionLigneAchats)this.documentDetailTrf.get(var7)).getReceptionEnteteAchats().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0) {
                     if (this.var_type_trf == 14) {
                        this.trfRet();
                     } else if (this.var_type_trf == 15) {
                        this.trfFac();
                     }
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
               this.receptionEnteteAchats = (ReceptionEnteteAchats)this.lesEntetesList.get(var11);
               if (this.receptionEnteteAchats.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.receptionEnteteAchats);
               }
            }
         }

         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

      this.showModalPanelTrf = false;
      this.visibiliteBton = false;
   }

   public void trfRet() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceAchats = new DocumentTraceAchats();
         RetourEnteteAchats var3 = new RetourEnteteAchats();
         RetourEnteteAchatsDao var4 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         RetourLigneAchatsDao var5 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         var3.setUsers(this.usersLog);
         var3.setBrfIdCreateur(this.usersLog.getUsrid());
         var3.setBrfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setBrfDate(this.utilDate.dateToSQLLight(this.receptionEnteteAchats.getRecDate()));
         } else {
            var3.setBrfDate(this.var_date_trf);
         }

         var3.setBrfDate(this.utilDate.dateToSQL(var3.getBrfDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setBrfDateCreat(new Date());
         var3.setBrfDateModif((Date)null);
         var3.setBrfIdModif(0L);
         var3.setBrfNomModif("");
         var3.setBrfNum("");
         boolean var7 = false;
         int var34;
         if (this.optionAchats.getNbrJrRelanceRETOUR() != null && !this.optionAchats.getNbrJrRelanceRETOUR().isEmpty()) {
            var34 = Integer.parseInt(this.optionAchats.getNbrJrRelanceRETOUR());
         } else {
            var34 = 0;
         }

         boolean var8 = false;
         int var35;
         if (this.optionAchats.getNbrJrValidRETOUR() != null && !this.optionAchats.getNbrJrValidRETOUR().isEmpty()) {
            var35 = Integer.parseInt(this.optionAchats.getNbrJrValidRETOUR());
         } else {
            var35 = 0;
         }

         var3.setBrfDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var3.setBrfDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var35));
         var3.setBrfService(var3.getBrfService());
         if (!this.var_serie_trf.equalsIgnoreCase("X") && !this.var_serie_trf.isEmpty()) {
            var3.setBrfNum(this.calculChrono.numCompose(var3.getBrfDate(), this.var_type_trf, this.var_serie_trf, var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setBrfNum("" + var9);
         }

         this.verifieExistenceHabilitationRetour(var3, var1);
         var3.setBrfNomResponsable(this.receptionEnteteAchats.getRecNomResponsable());
         var3.setBrfIdResponsable(this.receptionEnteteAchats.getRecIdResponsable());
         var3.setBrfNomTiers(this.receptionEnteteAchats.getRecNomTiers());
         var3.setBrfCivilTiers(this.receptionEnteteAchats.getRecCivilTiers());
         var3.setBrfIdContact(this.receptionEnteteAchats.getRecIdContact());
         var3.setBrfNomContact(this.receptionEnteteAchats.getRecNomContact());
         var3.setBrfCivilContact(this.receptionEnteteAchats.getRecCivilContact());
         var3.setBrfDiversAdresse(this.receptionEnteteAchats.getRecDiversAdresse());
         var3.setBrfDiversMail(this.receptionEnteteAchats.getRecDiversMail());
         var3.setBrfDiversNom(this.receptionEnteteAchats.getRecDiversNom());
         var3.setBrfDiversTel(this.receptionEnteteAchats.getRecDiversTel());
         var3.setBrfDiversTiers(this.receptionEnteteAchats.getRecDiversTiers());
         var3.setBrfDiversVille(this.receptionEnteteAchats.getRecDiversVille());
         var3.setBrfSerie(this.var_serie_trf);
         var3.setBrfSource(this.receptionEnteteAchats.getRecSource());
         var3.setBrfJournalReg(this.receptionEnteteAchats.getRecJournalReg());
         var3.setBrfCat(this.receptionEnteteAchats.getRecCat());
         var3.setBrfDevise(this.receptionEnteteAchats.getRecDevise());
         var3.setBrfObject(this.receptionEnteteAchats.getRecObject());
         var3.setBrfObservation(this.receptionEnteteAchats.getRecObservation());
         if (var3.getBrfDevise() != null && !var3.getBrfDevise().isEmpty() && !var3.getBrfDevise().equals(this.structureLog.getStrdevise())) {
            this.receptionEnteteAchats.setRecCat("Import");
            var3.setBrfCat("Import");
         }

         this.calculDeviseCategorie();
         var3.setBrfExoTva(this.receptionEnteteAchats.getRecExoTva());
         var3.setBrfExoDouane(this.receptionEnteteAchats.getRecExoDouane());
         var3.setBrfTotHt(0.0D);
         var3.setBrfTotRemise(0.0D);
         var3.setBrfTotRabais(0.0D);
         var3.setBrfTotTva(0.0D);
         var3.setBrfTotTc(0.0D);
         var3.setBrfTotTtc(0.0D);
         var3.setBrfTotReglement(0.0D);
         var3.setBrfSolde(0);
         var3.setBrfBanque(this.receptionEnteteAchats.getRecBanque());
         var3.setBrfTypeReg(this.receptionEnteteAchats.getRecTypeReg());
         var3.setBrfModeReg(this.receptionEnteteAchats.getRecModeReg());
         var3.setBrfNbJourReg(this.receptionEnteteAchats.getRecNbJourReg());
         var3.setBrfArrondiReg(this.receptionEnteteAchats.getRecArrondiReg());
         var3.setBrfConditionReg(this.receptionEnteteAchats.getRecConditionReg());
         var3.setBrfDateEcheReg(this.receptionEnteteAchats.getRecDateEcheReg());
         var3.setBrfActivite(this.receptionEnteteAchats.getRecActivite());
         var3.setBrfSite(this.receptionEnteteAchats.getRecSite());
         var3.setBrfDepartement(this.receptionEnteteAchats.getRecDepartement());
         var3.setBrfRegion(this.receptionEnteteAchats.getRecRegion());
         var3.setBrfSecteur(this.receptionEnteteAchats.getRecSecteur());
         var3.setBrfPdv(this.receptionEnteteAchats.getRecPdv());
         var3.setBrfAnal2(this.receptionEnteteAchats.getRecAnal2());
         var3.setBrfAnal4(this.receptionEnteteAchats.getRecAnal4());
         var3.setBrfAffaire(this.receptionEnteteAchats.getRecAffaire());
         var3.setBrfInfo1(this.receptionEnteteAchats.getRecInfo1());
         var3.setBrfInfo2(this.receptionEnteteAchats.getRecInfo2());
         var3.setBrfInfo3(this.receptionEnteteAchats.getRecInfo3());
         var3.setBrfInfo4(this.receptionEnteteAchats.getRecInfo4());
         var3.setBrfInfo5(this.receptionEnteteAchats.getRecInfo5());
         var3.setBrfInfo6(this.receptionEnteteAchats.getRecInfo6());
         var3.setBrfInfo7(this.receptionEnteteAchats.getRecInfo7());
         var3.setBrfInfo8(this.receptionEnteteAchats.getRecInfo8());
         var3.setBrfInfo9(this.receptionEnteteAchats.getRecInfo9());
         var3.setBrfInfo10(this.receptionEnteteAchats.getRecInfo10());
         var3.setBrfFormule1(this.receptionEnteteAchats.getRecFormule1());
         var3.setBrfFormule2(this.receptionEnteteAchats.getRecFormule2());
         var3.setBrfAnnexe1(this.receptionEnteteAchats.getRecAnnexe1());
         var3.setBrfAnnexe2(this.receptionEnteteAchats.getRecAnnexe2());
         var3.setBrfContrat(this.receptionEnteteAchats.getRecContrat());
         var3.setBrfIncoterm(this.receptionEnteteAchats.getRecIncoterm());
         var3.setBrfLieuLivraison(this.receptionEnteteAchats.getRecLieuLivraison());
         var3.setBrfDateLivraison(this.receptionEnteteAchats.getRecDateLivraison());
         var3.setBrfInfoLivraison(this.receptionEnteteAchats.getRecInfoLivraison());
         var3.setBrfDateImp((Date)null);
         var3.setBrfModeleImp(this.var_modele_trf);
         var3.setBrfGele(0);
         var3.setBrfEtat(0);
         var3.setBrfDateTransforme((Date)null);
         var3.setBrfTypeTransforme(0);
         var3.setBrfDateAnnule((Date)null);
         var3.setBrfMotifAnnule("");
         var3.setBrfFactorNom(this.receptionEnteteAchats.getRecFactorNom());
         var3.setBrfFactorId(this.receptionEnteteAchats.getRecFactorId());
         var3.setBrfFactorEtat(this.receptionEnteteAchats.getRecFactorEtat());
         var3.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
         var3.setTiers(this.receptionEnteteAchats.getTiers());
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var36 = 0.0F;
         float var10 = 0.0F;
         float var11 = 0.0F;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         double var20 = 0.0D;
         double var22 = 0.0D;
         String var24 = "";
         int var25 = 0;
         if (this.lesLignesList.size() != 0) {
            int var26;
            RetourLigneAchats var27;
            for(var26 = 0; var26 < this.lesLignesList.size(); ++var26) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var26);
               if (this.optionAchats.getTransformation().equals("1") && (var24 == null || var24.isEmpty() || !var24.equals(this.receptionLigneAchats.getReceptionEnteteAchats().getRecNum()))) {
                  var24 = this.receptionLigneAchats.getReceptionEnteteAchats().getRecNum();
                  ++var25;
                  var27 = new RetourLigneAchats();
                  var27.setBrfligCode("-");
                  var27.setBrfligLibelle("---> Suivant réception N° " + var24);
                  var27.setRetourEnteteAchats(var3);
                  var6.add(var27);
               }

               if (this.receptionLigneAchats.getRecligLibelle() != null && !this.receptionLigneAchats.getRecligLibelle().isEmpty() && this.receptionLigneAchats.getVar_qteReliquat() != 0.0F) {
                  ++var25;
                  var27 = new RetourLigneAchats();
                  var36 += this.receptionLigneAchats.getRecligQte();
                  var10 += ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteDejaTrf();
                  if (((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var27.setBrfligCode(this.receptionLigneAchats.getRecligCode());
                     var27.setBrfligDevise(this.receptionLigneAchats.getRecligDevise());
                     var27.setBrfligFamille(this.receptionLigneAchats.getRecligFamille());
                     var27.setBrfligIdCmd(this.receptionLigneAchats.getRecligId());
                     var27.setBrfligLibelle(this.receptionLigneAchats.getRecligLibelle());
                     var27.setBrfligComplement(this.receptionLigneAchats.getRecligComplement());
                     if (((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                        String[] var28 = ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                        var27.setBrfligDepot(var28[0]);
                     } else {
                        var27.setBrfligDepot("");
                     }

                     var27.setBrfligEchelle(this.receptionLigneAchats.getRecligEchelle());
                     var27.setBrfligUnite(this.receptionLigneAchats.getRecligUnite());
                     var27.setBrfligCondition(this.receptionLigneAchats.getRecligCondition());
                     var27.setBrfligReference(this.receptionLigneAchats.getRecligReference());
                     var27.setBrfligPump(this.receptionLigneAchats.getRecligPump());
                     var27.setBrfligPu(this.receptionLigneAchats.getRecligPu());
                     var27.setBrfligTauxRemise(this.receptionLigneAchats.getRecligTauxRemise());
                     var27.setBrfligPuRem(this.receptionLigneAchats.getRecligPuRem());
                     this.receptionLigneAchats.setRecligQte(((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), var1);
                     var27.setBrfligQte(((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var27.setBrfligLong(this.receptionLigneAchats.getRecligLong());
                     var27.setBrfligLarg(this.receptionLigneAchats.getRecligLarg());
                     var27.setBrfligHaut(this.receptionLigneAchats.getRecligHaut());
                     var27.setBrfligDiam(this.receptionLigneAchats.getRecligDiam());
                     var27.setBrfligPoidsBrut(this.receptionLigneAchats.getRecligPoidsBrut());
                     var27.setBrfligPoidsNet(this.receptionLigneAchats.getRecligPoidsNet());
                     var27.setBrfligVolume(this.receptionLigneAchats.getRecligVolume());
                     var27.setBrfligNb(this.receptionLigneAchats.getRecligNb());
                     var27.setBrfligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.receptionLigneAchats.getRecligCondition(), this.receptionLigneAchats.getRecligQte(), this.receptionLigneAchats.getRecligLong(), this.receptionLigneAchats.getRecligLarg(), this.receptionLigneAchats.getRecligHaut(), this.receptionLigneAchats.getRecligDiam(), this.receptionLigneAchats.getRecligNb(), this.baseLog, this.utilInitHibernate, var1));
                     var27.setBrfligQteStock(0.0F);
                     var27.setBrfligRabais(this.receptionLigneAchats.getRecligRabais());
                     var27.setBrfligTauxTaxe(this.receptionLigneAchats.getRecligTauxTaxe());
                     var27.setBrfligTaxe(this.receptionLigneAchats.getRecligTaxe());
                     var27.setBrfligPt(this.receptionLigneAchats.getRecligPt());
                     var27.setBrfligTva(this.receptionLigneAchats.getRecligTva());
                     var27.setBrfligTtc(this.receptionLigneAchats.getRecligTtc());
                     var27.setBrfligTc(this.receptionLigneAchats.getRecligTc());
                     var27.setRetourEnteteAchats(var3);
                     var11 += ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var27);
                     var12 += var27.getBrfligPt();
                     var14 += (var27.getBrfligPu() - var27.getBrfligPuRem()) * (double)var27.getBrfligQte();
                     var16 += var27.getBrfligRabais();
                     var18 += var27.getBrfligTva();
                     var20 += var27.getBrfligTtc();
                     var22 += var27.getBrfligTc();
                  }
               }
            }

            var3.setBrfTotHt(var12);
            var3.setBrfTotRemise(var14);
            var3.setBrfTotRabais(var16);
            var3.setBrfTotTva(var18);
            var3.setBrfTotTc(var22);
            var3.setBrfTotTtc(var20);
            var3 = var4.modif(var3, var1);
            if (var6.size() != 0) {
               var5.saveLigne(var6, var3, var1);

               for(var26 = 0; var26 < var6.size(); ++var26) {
                  new RetourLigneAchats();
                  var27 = (RetourLigneAchats)var6.get(var26);
                  this.produits = this.produitsDao.chargeProduit(var27.getBrfligCode(), var1);
                  this.calculStock.majRetourAchatsATT(var27, this.produits, 0.0F, 1, this.baseLog, var1);
               }
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationRetour(var3, var1), var3.getBrfId(), var3.getBrfNum(), var3.getBrfNomTiers(), var3.getBrfDate(), var3.getBrfDevise(), var3.getBrfTotTtc() + var3.getBrfTotTc(), var3.getBrfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 14), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFRET(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceAchats.setDoctrfDateCreat(new Date());
         this.documentTraceAchats.setDoctrfUserId(this.usersLog.getUsrid());
         this.documentTraceAchats.setDoctrfUserNom(this.usersLog.getUsrNom());
         this.documentTraceAchats.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
         this.documentTraceAchats.setDoctrfOrgType(this.nature);
         this.documentTraceAchats.setDoctrfOrgSerie(this.receptionEnteteAchats.getRecSerie());
         this.documentTraceAchats.setDoctrfOrgId(this.receptionEnteteAchats.getRecId());
         this.documentTraceAchats.setDoctrfOrgNum(this.receptionEnteteAchats.getRecNum());
         this.documentTraceAchats.setDoctrfOrgDate(this.receptionEnteteAchats.getRecDate());
         this.documentTraceAchats.setDoctrfDstType(this.var_type_trf);
         this.documentTraceAchats.setDoctrfDstSerie(this.var_serie_trf);
         this.documentTraceAchats.setDoctrfDstId(var3.getBrfId());
         this.documentTraceAchats.setDoctrfDstNum(var3.getBrfNum());
         this.documentTraceAchats.setDoctrfDstDate(var3.getBrfDate());
         this.documentTraceAchatsDao.insert(this.documentTraceAchats, var1);
         var2.commit();
      } catch (HibernateException var32) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var32;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFRET(List var1, RetourEnteteAchats var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new RetourLigneAchats();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            RetourLigneAchats var4 = (RetourLigneAchats)var1.get(var11);
            if (var4.getBrfligCode() != null && !var4.getBrfligCode().isEmpty() && var4.getBrfligCode().equals("-")) {
               var5 = true;
               var6 = var4.getBrfligLibelle();
            }

            if (var5) {
               var7 += var4.getBrfligPt();
               var9 = var4.getBrfligTtc();
            }

            if (var4.getBrfligCode() != null && !var4.getBrfligCode().isEmpty() && var4.getBrfligCode().equals("=") && var5) {
               var4 = new RetourLigneAchats();
               var4.setRetourEnteteAchats(var2);
               var4.setBrfligCode("=");
               var4.setBrfligLibelle(var6);
               var4.setBrfligPt(var7);
               var4.setBrfligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getBrfTotTtc() + var2.getBrfTotTc(), var2.getBrfDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationRetour(RetourEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setBrfEtatVal(1);
         var1.setBrfEtat(0);
         var1.setBrfDateValide((Date)null);
      } else {
         var1.setBrfEtatVal(0);
         if (var1.getBrfDateImp() != null) {
            if (var1.getBrfEtat() == 0) {
               var1.setBrfEtat(1);
               var1.setBrfDateValide(new Date());
            }
         } else {
            var1.setBrfEtat(0);
            var1.setBrfDateValide((Date)null);
         }
      }

      return var4;
   }

   public void trfFac() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceAchats = new DocumentTraceAchats();
         FactureEnteteAchats var3 = new FactureEnteteAchats();
         FactureEnteteAchatsDao var4 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FactureLigneAchatsDao var5 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         var3.setUsers(this.usersLog);
         var3.setFcfIdCreateur(this.usersLog.getUsrid());
         var3.setFcfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.receptionEnteteAchats.getRecDateFacture() != null) {
            var3.setFcfDate(this.receptionEnteteAchats.getRecDateFacture());
         } else if (this.var_date_trf == null) {
            var3.setFcfDate(this.utilDate.dateToSQLLight(this.receptionEnteteAchats.getRecDate()));
         } else {
            var3.setFcfDate(this.var_date_trf);
         }

         var3.setFcfDate(this.utilDate.dateToSQL(var3.getFcfDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setFcfDateCreat(new Date());
         var3.setFcfDateModif((Date)null);
         var3.setFcfIdModif(0L);
         var3.setFcfNomModif("");
         var3.setFcfNum("");
         boolean var7 = false;
         int var34;
         if (this.optionAchats.getNbrJrRelanceFAC() != null && !this.optionAchats.getNbrJrRelanceFAC().isEmpty()) {
            var34 = Integer.parseInt(this.optionAchats.getNbrJrRelanceFAC());
         } else {
            var34 = 0;
         }

         boolean var8 = false;
         int var35;
         if (this.optionAchats.getNbrJrValidFAC() != null && !this.optionAchats.getNbrJrValidFAC().isEmpty()) {
            var35 = Integer.parseInt(this.optionAchats.getNbrJrValidFAC());
         } else {
            var35 = 0;
         }

         var3.setFcfDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var3.setFcfDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var35));
         var3.setFcfService(var3.getFcfService());
         if (!this.var_serie_trf.equalsIgnoreCase("X") && !this.var_serie_trf.isEmpty()) {
            var3.setFcfNum(this.calculChrono.numCompose(var3.getFcfDate(), this.var_type_trf, this.var_serie_trf, var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setFcfNum("" + var9);
         }

         this.verifieExistenceHabilitationFacture(var3, var1);
         var3.setFcfNomResponsable(this.receptionEnteteAchats.getRecNomResponsable());
         var3.setFcfIdResponsable(this.receptionEnteteAchats.getRecIdResponsable());
         var3.setFcfNomTiers(this.receptionEnteteAchats.getRecNomTiers());
         var3.setFcfCivilTiers(this.receptionEnteteAchats.getRecCivilTiers());
         var3.setFcfIdContact(this.receptionEnteteAchats.getRecIdContact());
         var3.setFcfNomContact(this.receptionEnteteAchats.getRecNomContact());
         var3.setFcfCivilContact(this.receptionEnteteAchats.getRecCivilContact());
         var3.setFcfDiversAdresse(this.receptionEnteteAchats.getRecDiversAdresse());
         var3.setFcfDiversMail(this.receptionEnteteAchats.getRecDiversMail());
         var3.setFcfDiversNom(this.receptionEnteteAchats.getRecDiversNom());
         var3.setFcfDiversTel(this.receptionEnteteAchats.getRecDiversTel());
         var3.setFcfDiversTiers(this.receptionEnteteAchats.getRecDiversTiers());
         var3.setFcfDiversVille(this.receptionEnteteAchats.getRecDiversVille());
         var3.setFcfSerie(this.var_serie_trf);
         var3.setFcfSource(this.receptionEnteteAchats.getRecSource());
         var3.setFcfJournalReg(this.receptionEnteteAchats.getRecJournalReg());
         var3.setFcfCat(this.receptionEnteteAchats.getRecCat());
         var3.setFcfDevise(this.structureLog.getStrdevise());
         var3.setFcfObject(this.receptionEnteteAchats.getRecObject());
         var3.setFcfObservation(this.receptionEnteteAchats.getRecObservation());
         var3.setFcfNumFour(this.receptionEnteteAchats.getRecNumFature());
         var3.setFcfDateLivraison(this.receptionEnteteAchats.getRecDate());
         if (var3.getFcfDevise() != null && !var3.getFcfDevise().isEmpty() && !var3.getFcfDevise().equals(this.structureLog.getStrdevise())) {
            this.receptionEnteteAchats.setRecCat("Import");
            var3.setFcfCat("Import");
         }

         this.calculDeviseCategorie();
         var3.setFcfExoTva(this.receptionEnteteAchats.getRecExoTva());
         var3.setFcfExoDouane(this.receptionEnteteAchats.getRecExoDouane());
         var3.setFcfTotHt(0.0D);
         var3.setFcfTotRemise(0.0D);
         var3.setFcfTotRabais(0.0D);
         var3.setFcfTotTva(0.0D);
         var3.setFcfTotTc(0.0D);
         var3.setFcfTotTtc(0.0D);
         var3.setFcfTotHtLocal(0.0D);
         var3.setFcfTotRemiseLocal(0.0D);
         var3.setFcfTotRabaisLocal(0.0D);
         var3.setFcfTotTvaLocal(0.0D);
         var3.setFcfTotTtcLocal(0.0D);
         var3.setFcfIncoterm(this.receptionEnteteAchats.getRecIncoterm());
         var3.setFcfTotFret(this.receptionEnteteAchats.getRecTotFret());
         var3.setFcfTotFretLocal(this.receptionEnteteAchats.getRecTotFretLocal());
         var3.setFcfTotFret2(this.receptionEnteteAchats.getRecTotFret2());
         var3.setFcfTotFret2Local(this.receptionEnteteAchats.getRecTotFret2Local());
         var3.setFcfTotAssurance(this.receptionEnteteAchats.getRecTotAssurance());
         var3.setFcfTotAssuranceLocal(this.receptionEnteteAchats.getRecTotAssuranceLocal());
         var3.setFcfTotReglement(this.receptionEnteteAchats.getRecTotReglement());
         var3.setFcfSolde(this.receptionEnteteAchats.getRecSolde());
         var3.setFcfBanque(this.receptionEnteteAchats.getRecBanque());
         var3.setFcfTypeReg(this.receptionEnteteAchats.getRecTypeReg());
         var3.setFcfModeReg(this.receptionEnteteAchats.getRecModeReg());
         var3.setFcfNbJourReg(this.receptionEnteteAchats.getRecNbJourReg());
         var3.setFcfArrondiReg(this.receptionEnteteAchats.getRecArrondiReg());
         var3.setFcfConditionReg(this.receptionEnteteAchats.getRecConditionReg());
         var3.setFcfDateEcheReg(this.receptionEnteteAchats.getRecDateEcheReg());
         var3.setFcfActivite(this.receptionEnteteAchats.getRecActivite());
         var3.setFcfSite(this.receptionEnteteAchats.getRecSite());
         var3.setFcfDepartement(this.receptionEnteteAchats.getRecDepartement());
         var3.setFcfRegion(this.receptionEnteteAchats.getRecRegion());
         var3.setFcfSecteur(this.receptionEnteteAchats.getRecSecteur());
         var3.setFcfPdv(this.receptionEnteteAchats.getRecPdv());
         var3.setFcfAnal1(this.receptionEnteteAchats.getRecAnal1());
         var3.setFcfAnal2(this.receptionEnteteAchats.getRecAnal2());
         var3.setFcfAnal4(this.receptionEnteteAchats.getRecAnal4());
         var3.setFcfAffaire(this.receptionEnteteAchats.getRecAffaire());
         var3.setFcfInfo1(this.receptionEnteteAchats.getRecInfo1());
         var3.setFcfInfo2(this.receptionEnteteAchats.getRecInfo2());
         var3.setFcfInfo3(this.receptionEnteteAchats.getRecInfo3());
         var3.setFcfInfo4(this.receptionEnteteAchats.getRecInfo4());
         var3.setFcfInfo5(this.receptionEnteteAchats.getRecInfo5());
         var3.setFcfInfo6(this.receptionEnteteAchats.getRecInfo6());
         var3.setFcfInfo7(this.receptionEnteteAchats.getRecInfo7());
         var3.setFcfInfo8(this.receptionEnteteAchats.getRecInfo8());
         var3.setFcfInfo9(this.receptionEnteteAchats.getRecInfo9());
         var3.setFcfInfo10(this.receptionEnteteAchats.getRecInfo10());
         var3.setFcfFormule1(this.receptionEnteteAchats.getRecFormule1());
         var3.setFcfFormule2(this.receptionEnteteAchats.getRecFormule2());
         var3.setFcfAnnexe1(this.receptionEnteteAchats.getRecAnnexe1());
         var3.setFcfAnnexe2(this.receptionEnteteAchats.getRecAnnexe2());
         var3.setFcfContrat(this.receptionEnteteAchats.getRecContrat());
         var3.setFcfDateImp((Date)null);
         var3.setFcfModeleImp(this.var_modele_trf);
         var3.setFcfGele(0);
         var3.setFcfEtat(0);
         var3.setFcfDateTransforme((Date)null);
         var3.setFcfTypeTransforme(0);
         var3.setFcfDateAnnule((Date)null);
         var3.setFcfMotifAnnule("");
         var3.setFcfFactorNom(this.receptionEnteteAchats.getRecFactorNom());
         var3.setFcfFactorId(this.receptionEnteteAchats.getRecFactorId());
         var3.setFcfFactorEtat(this.receptionEnteteAchats.getRecFactorEtat());
         var3.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
         var3.setTiers(this.receptionEnteteAchats.getTiers());
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var36 = 0.0F;
         float var10 = 0.0F;
         float var11 = 0.0F;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         double var20 = 0.0D;
         double var22 = 0.0D;
         String var24 = "";
         int var25 = 0;
         if (this.lesLignesList.size() != 0) {
            for(int var26 = 0; var26 < this.lesLignesList.size(); ++var26) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var26);
               FactureLigneAchats var27;
               if (this.optionAchats.getTransformation().equals("1") && (var24 == null || var24.isEmpty() || !var24.equals(this.receptionLigneAchats.getReceptionEnteteAchats().getRecNum()))) {
                  var24 = this.receptionLigneAchats.getReceptionEnteteAchats().getRecNum();
                  ++var25;
                  var27 = new FactureLigneAchats();
                  var27.setFcfligCode("-");
                  var27.setFcfligLibelle("---> Suivant réception N° " + var24);
                  var27.setFactureEnteteAchats(var3);
                  var6.add(var27);
               }

               if (this.receptionLigneAchats.getRecligLibelle() != null && !this.receptionLigneAchats.getRecligLibelle().isEmpty() && this.receptionLigneAchats.getVar_qteReliquat() != 0.0F) {
                  ++var25;
                  var27 = new FactureLigneAchats();
                  var36 += this.receptionLigneAchats.getRecligQte();
                  var10 += ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteDejaTrf();
                  if (((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var27.setFcfligCode(this.receptionLigneAchats.getRecligCode());
                     var27.setFcfligDevise(this.receptionLigneAchats.getRecligDevise());
                     var27.setFcfligFamille(this.receptionLigneAchats.getRecligFamille());
                     var27.setFcfligIdCmd(this.receptionLigneAchats.getRecligId());
                     var27.setFcfligLibelle(this.receptionLigneAchats.getRecligLibelle());
                     var27.setFcfligComplement(this.receptionLigneAchats.getRecligComplement());
                     if (((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                        String[] var28 = ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                        var27.setFcfligDepot(var28[0]);
                     } else {
                        var27.setFcfligDepot("");
                     }

                     var27.setFcfligEchelle(this.receptionLigneAchats.getRecligEchelle());
                     var27.setFcfligUnite(this.receptionLigneAchats.getRecligUnite());
                     var27.setFcfligCondition(this.receptionLigneAchats.getRecligCondition());
                     var27.setFcfligReference(this.receptionLigneAchats.getRecligReference());
                     var27.setFcfligLibelleFournisseur(this.receptionLigneAchats.getRecligLibelleFournisseur());
                     var27.setFcfligPump(this.receptionLigneAchats.getRecligPump());
                     var27.setFcfligTauxRemise(this.receptionLigneAchats.getRecligTauxRemise());
                     this.receptionLigneAchats.setRecligQte(((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTauxTaxe(), var1);
                     var27.setFcfligQte(((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var27.setFcfligLong(this.receptionLigneAchats.getRecligLong());
                     var27.setFcfligLarg(this.receptionLigneAchats.getRecligLarg());
                     var27.setFcfligHaut(this.receptionLigneAchats.getRecligHaut());
                     var27.setFcfligDiam(this.receptionLigneAchats.getRecligDiam());
                     var27.setFcfligPoidsBrut(this.receptionLigneAchats.getRecligPoidsBrut());
                     var27.setFcfligPoidsNet(this.receptionLigneAchats.getRecligPoidsNet());
                     var27.setFcfligVolume(this.receptionLigneAchats.getRecligVolume());
                     var27.setFcfligNb(this.receptionLigneAchats.getRecligNb());
                     var27.setFcfligQteStock(0.0F);
                     var27.setFcfligTauxTaxe(this.receptionLigneAchats.getRecligTauxTaxe());
                     var27.setFcfligTaxe(this.receptionLigneAchats.getRecligTaxe());
                     if (this.receptionEnteteAchats.getRecDevise().equals(this.structureLog.getStrdevise())) {
                        var27.setFcfligRabais(this.receptionLigneAchats.getRecligRabais());
                        var27.setFcfligPu(this.receptionLigneAchats.getRecligPu());
                        var27.setFcfligPuRem(this.receptionLigneAchats.getRecligPuRem());
                        var27.setFcfligTaxe(this.receptionLigneAchats.getRecligTaxe());
                        var27.setFcfligPt(this.receptionLigneAchats.getRecligPt());
                        var27.setFcfligPtDev(this.receptionLigneAchats.getRecligPtDev());
                        var27.setFcfligTva(this.receptionLigneAchats.getRecligTva());
                        var27.setFcfligTtc(this.receptionLigneAchats.getRecligTtc());
                        var27.setFcfligTc(this.receptionLigneAchats.getRecligTc());
                     } else {
                        this.calculDevise(var1);
                        var27.setFcfligRabais(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligRabais() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                        var27.setFcfligPu(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligPu() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                        var27.setFcfligPuRem(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligPuRem() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                        var27.setFcfligPt(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligPt() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                        var27.setFcfligPtDev(this.receptionLigneAchats.getRecligPtDev());
                        var27.setFcfligTva(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligTva() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                        var27.setFcfligTtc(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligTtc() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                        var27.setFcfligTc(this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligTc() * (double)this.receptionEnteteAchats.getRecCoefDevise(), this.structureLog.getStrdevise()));
                     }

                     var27.setFactureEnteteAchats(var3);
                     var11 += ((ReceptionLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var27);
                     var12 += var27.getFcfligPt();
                     var14 += (var27.getFcfligPu() - var27.getFcfligPuRem()) * (double)var27.getFcfligQte();
                     var16 += var27.getFcfligRabais();
                     var18 += var27.getFcfligTva();
                     var20 += var27.getFcfligTtc();
                     var22 += var27.getFcfligTc();
                  }
               }
            }

            var3.setFcfTotHt(var12);
            var3.setFcfTotRemise(var14);
            var3.setFcfTotRabais(var16);
            var3.setFcfTotTva(var18);
            var3.setFcfTotTc(var22);
            if (this.optionAchats.getModeCifCfrREC().equals("0")) {
               var3.setFcfTotTtc(var20 + var3.getFcfTotAssuranceLocal() + var3.getFcfTotFretLocal() + var3.getFcfTotFret2Local());
            } else {
               var3.setFcfTotTtc(var20);
            }

            var3 = var4.modif(var3, var1);
            if (var6.size() != 0) {
               var5.saveLigne(var6, var3, var1);
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFacture(var3, var1), var3.getFcfId(), var3.getFcfNum(), var3.getFcfNomTiers(), var3.getFcfDate(), var3.getFcfDevise(), var3.getFcfTotTtc() + var3.getFcfTotTc(), var3.getFcfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 15), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceAchats.setDoctrfDateCreat(new Date());
         this.documentTraceAchats.setDoctrfUserId(this.usersLog.getUsrid());
         this.documentTraceAchats.setDoctrfUserNom(this.usersLog.getUsrNom());
         this.documentTraceAchats.setExercicesAchats(this.receptionEnteteAchats.getExercicesAchats());
         this.documentTraceAchats.setDoctrfOrgType(this.nature);
         this.documentTraceAchats.setDoctrfOrgSerie(this.receptionEnteteAchats.getRecSerie());
         this.documentTraceAchats.setDoctrfOrgId(this.receptionEnteteAchats.getRecId());
         this.documentTraceAchats.setDoctrfOrgNum(this.receptionEnteteAchats.getRecNum());
         this.documentTraceAchats.setDoctrfOrgDate(this.receptionEnteteAchats.getRecDate());
         this.documentTraceAchats.setDoctrfDstType(this.var_type_trf);
         this.documentTraceAchats.setDoctrfDstSerie(this.var_serie_trf);
         this.documentTraceAchats.setDoctrfDstId(var3.getFcfId());
         this.documentTraceAchats.setDoctrfDstNum(var3.getFcfNum());
         this.documentTraceAchats.setDoctrfDstDate(var3.getFcfDate());
         this.documentTraceAchatsDao.insert(this.documentTraceAchats, var1);
         if (var36 <= var10 + var11 && var36 != 0.0F && var10 + var11 != 0.0F) {
            this.receptionEnteteAchats.setRecEtat(5);
         } else {
            this.receptionEnteteAchats.setRecEtat(4);
         }

         this.receptionEnteteAchats.setRecDateTransforme(new Date());
         this.receptionEnteteAchats.setRecTypeTransforme(this.var_type_trf);
         this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
         var2.commit();
      } catch (HibernateException var32) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var32;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFFAC(List var1, FactureEnteteAchats var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new FactureLigneAchats();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            FactureLigneAchats var4 = (FactureLigneAchats)var1.get(var11);
            if (var4.getFcfligCode() != null && !var4.getFcfligCode().isEmpty() && var4.getFcfligCode().equals("-")) {
               var5 = true;
               var6 = var4.getFcfligLibelle();
            }

            if (var5) {
               var7 += var4.getFcfligPt();
               var9 = var4.getFcfligTtc();
            }

            if (var4.getFcfligCode() != null && !var4.getFcfligCode().isEmpty() && var4.getFcfligCode().equals("=") && var5) {
               var4 = new FactureLigneAchats();
               var4.setFactureEnteteAchats(var2);
               var4.setFcfligCode("=");
               var4.setFcfligLibelle(var6);
               var4.setFcfligPt(var7);
               var4.setFcfligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getFcfTotTtc() + var2.getFcfTotTc(), var2.getFcfDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationFacture(FactureEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setFcfEtatVal(1);
         var1.setFcfEtat(0);
         var1.setFcfDateValide((Date)null);
      } else {
         var1.setFcfEtatVal(0);
         if (var1.getFcfDateImp() != null) {
            if (var1.getFcfEtat() == 0) {
               var1.setFcfEtat(1);
               var1.setFcfDateValide(new Date());
            }
         } else {
            var1.setFcfEtat(0);
            var1.setFcfDateValide((Date)null);
         }
      }

      return var4;
   }

   public void rechercheDouane() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.receptionLigneAchats.getRecligDouane() != null && !this.receptionLigneAchats.getRecligDouane().isEmpty()) {
         new ArrayList();
         List var1 = this.douanesPositionDao.recherchePosition(this.structureLog.getStrzonecommerciale(), this.receptionLigneAchats.getRecligDouane(), (Session)null);
         if (var1.size() == 1) {
            this.douanesPosition = (DouanesPosition)var1.get(0);
            this.calculeDouane();
         } else if (var1.size() > 1) {
            this.datamodelDouane.setWrappedData(var1);
            this.showModalPanelDouane = true;
         } else {
            this.annuleDouane();
         }
      }

   }

   public void selectionDouane() throws JDOMException, IOException {
      if (this.datamodelDouane.isRowAvailable()) {
         this.douanesPosition = (DouanesPosition)this.datamodelDouane.getRowData();
      }

   }

   public void calculeDouane() throws JDOMException, IOException {
      if (this.douanesPosition == null) {
         this.selectionDouane();
      }

      if (this.douanesPosition != null) {
         this.receptionLigneAchats.setRecligDouane(this.douanesPosition.getDouposCode());
      } else {
         this.receptionLigneAchats.setRecligDouane("");
      }

      this.showModalPanelDouane = false;
   }

   public void annuleDouane() {
      this.receptionLigneAchats.setRecligDouane("");
      this.showModalPanelDouane = false;
   }

   public void selectionLigneDetailPapier() throws HibernateException, NamingException {
      this.mesTaxesAchatsProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.listeSerie.clear();
      this.receptionLotAchats = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.receptionLigneAchats = (ReceptionLigneAchats)this.datamodelLigne.getRowData();
         this.var_memo_qte = this.receptionLigneAchats.getRecligQteUtil();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         if (this.receptionLigneAchats.getRecligCode() != null && this.receptionLigneAchats.getRecligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.receptionLigneAchats.getRecligCode(), var1);
            if (this.produits != null) {
               this.receptionLigneAchats.setRecligCode(this.produits.getProCode());
               this.receptionLigneAchats.setRecligFamille(this.produits.getProAchCode() + ":" + this.produits.getProAchLib());
               this.receptionLigneAchats.setRecligStock(this.produits.getProStock());
               this.var_aff_detail_prod = true;
               if (this.produits.getProImpDesciption() == 1) {
                  if (this.usersLog.getUsrAchLibelle() == 1) {
                     this.verrou_libelle = true;
                  } else {
                     this.verrou_libelle = false;
                  }
               } else {
                  this.verrou_libelle = false;
               }

               if (this.produits.getProCode() != null) {
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), this.produits, var1);
               }

               this.griserchamps = true;
               if (this.receptionLigneAchats.getRecligTaxe() != null && !this.receptionLigneAchats.getRecligTaxe().isEmpty()) {
                  this.mesTaxesAchatsProduits.add(new SelectItem(this.receptionLigneAchats.getRecligTaxe(), this.receptionLigneAchats.getRecligTaxe() + ":" + this.receptionLigneAchats.getRecligTauxTaxe()));
               }

               this.mesTaxesAchatsProduits.add(new SelectItem(0, ""));
               this.mesProduitsDepotsItems.clear();
               if (this.var_sansstock && this.produits.getProStock() != 0 && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
                  new ProduitsDepot();
                  ProduitsDepot var3 = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
                  if (var3 != null) {
                     if (var3.getProdepCasier() != null && !var3.getProdepCasier().isEmpty()) {
                        this.mesProduitsDepotsItems.add(new SelectItem(var3.getDepot().getDpoCode() + ":" + var3.getProdepCasier() + "=" + var3.getProdepQteStk()));
                     } else {
                        this.mesProduitsDepotsItems.add(new SelectItem(var3.getDepot().getDpoCode() + "=" + var3.getProdepQteStk()));
                     }
                  }
               }

               this.selectionDepot(var1);
            } else if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty()) {
            }
         } else {
            this.produits = null;
            this.var_aff_detail_prod = false;
            this.verrou_libelle = false;
            this.var_code_unite = 0;
            this.griserchamps = false;
            this.mesTaxesAchatsProduits.clear();
            if (this.mesTaxesAchatsItems.size() != 0) {
               for(int var2 = 0; var2 < this.mesTaxesAchatsItems.size(); ++var2) {
                  this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var2));
               }
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
      }

   }

   public void calculFamille() throws HibernateException, NamingException {
      if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty() && this.receptionLigneAchats.getRecligFamille().contains(":")) {
         this.mesTaxesAchatsProduits.clear();
         this.mesProduitsDepotsItems.clear();
         this.var_depot_famille = false;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
         String[] var2 = this.receptionLigneAchats.getRecligFamille().split(":");
         this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var2[0], var1);
         if (this.famillesProduitsAchats != null) {
            this.receptionLigneAchats.setRecligDouane(this.famillesProduitsAchats.getFamachDouane());
            this.receptionLigneAchats.setRecligTauxDouane(0.0F);
            String[] var3;
            if (this.famillesProduitsAchats.getFamachTaxe() != null && !this.famillesProduitsAchats.getFamachTaxe().isEmpty() && this.famillesProduitsAchats.getFamachTaxe().contains(":")) {
               var3 = this.famillesProduitsAchats.getFamachTaxe().split(":");
               this.receptionLigneAchats.setRecligTaxe(var3[0]);
            } else {
               this.receptionLigneAchats.setRecligTaxe(this.famillesProduitsAchats.getFamachTaxe());
            }

            if (this.famillesProduitsAchats.getFamachStock() >= 1) {
               this.var_depot_famille = true;
               DepotAchatsDao var7 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               List var4 = var7.selectActifDepot(13, var1);
               if (var4.size() != 0) {
                  for(int var5 = 0; var5 < var4.size(); ++var5) {
                     DepotAchats var6 = (DepotAchats)var4.get(var5);
                     this.mesProduitsDepotsItems.add(new SelectItem(var6.getDpoCode() + "=0.0"));
                  }
               }
            }

            if (this.famillesProduitsAchats.getFamachTaxe() != null && !this.famillesProduitsAchats.getFamachTaxe().isEmpty() && this.famillesProduitsAchats.getFamachTaxe().contains(":")) {
               var3 = this.famillesProduitsAchats.getFamachTaxe().split(":");
               float var8 = Float.parseFloat(var3[1]);
               this.mesTaxesAchatsProduits.add(new SelectItem(var3[0], var3[0] + ":" + var8));
               this.receptionLigneAchats.setRecligTaxe(var3[0]);
               this.receptionLigneAchats.setRecligTauxTaxe(var8);
            } else {
               this.receptionLigneAchats.setRecligTaxe("");
               this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
            }
         }

         this.utilInitHibernate.closeSession();
         this.calculLibelle();
      }

   }

   public void calculMode() {
      if (this.receptionLigneAchats.getRecligMode() == 0) {
         this.receptionLigneAchats.setRecligLarg(0.0F);
      } else if (this.receptionLigneAchats.getRecligMode() == 1) {
         this.receptionLigneAchats.setRecligLong(0.0F);
         this.receptionLigneAchats.setRecligHaut(0.0F);
      } else {
         this.receptionLigneAchats.setRecligLarg(0.0F);
         this.receptionLigneAchats.setRecligLong(0.0F);
         this.receptionLigneAchats.setRecligHaut(0.0F);
      }

      this.calculLibelle();
   }

   public void calculLibelle() {
      String var1 = "";
      if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty() && this.receptionLigneAchats.getRecligFamille().contains(":")) {
         String[] var2 = this.receptionLigneAchats.getRecligFamille().split(":");
         var1 = var2[1];
      } else if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty() && !this.receptionLigneAchats.getRecligFamille().contains(":")) {
         var1 = this.famillesProduitsAchats.getFamachLibelleFr();
      }

      if (this.receptionLigneAchats.getRecligGr() != 0.0F) {
         var1 = var1 + " Grs " + this.receptionLigneAchats.getRecligGr();
      }

      if (this.receptionLigneAchats.getRecligCouleur() != null && !this.receptionLigneAchats.getRecligCouleur().isEmpty()) {
         var1 = var1 + " " + this.receptionLigneAchats.getRecligCouleur();
      }

      if (this.receptionLigneAchats.getRecligLarg() != 0.0F) {
         var1 = var1 + " Laize " + this.receptionLigneAchats.getRecligLarg();
      }

      if (this.receptionLigneAchats.getRecligHaut() != 0.0F && this.receptionLigneAchats.getRecligLong() != 0.0F) {
         var1 = var1 + " " + this.receptionLigneAchats.getRecligHaut() + "x" + this.receptionLigneAchats.getRecligLong();
      }

      this.receptionLigneAchats.setRecligLibelle(var1);
   }

   public void calculQtePapier() {
      float var1 = 0.0F;
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      if (this.receptionLigneAchats.getRecligGr() == 0.0F) {
         var1 = 1.0F;
      } else {
         var1 = this.receptionLigneAchats.getRecligGr();
      }

      if (this.receptionLigneAchats.getRecligHaut() == 0.0F) {
         var2 = 1.0F;
      } else {
         var2 = this.receptionLigneAchats.getRecligHaut();
      }

      if (this.receptionLigneAchats.getRecligLong() == 0.0F) {
         var3 = 1.0F;
      } else {
         var3 = this.receptionLigneAchats.getRecligLong();
      }

      if (this.receptionLigneAchats.getRecligLarg() == 0.0F) {
         var4 = 1.0F;
      } else {
         var4 = this.receptionLigneAchats.getRecligLarg();
      }

      if (this.receptionLigneAchats.getRecligMode() == 0) {
         float var5;
         if (this.receptionLigneAchats.getRecligQte() == 0.0F && this.receptionLigneAchats.getRecligPoidsNet() != 0.0F) {
            var5 = this.utilNombre.myRound(this.receptionLigneAchats.getRecligPoidsNet() / (var1 * var2 * var3 * var4) * 1.0E7F, 0);
            this.receptionLigneAchats.setRecligQte(var5);
         } else if (this.receptionLigneAchats.getRecligQte() != 0.0F && this.receptionLigneAchats.getRecligPoidsNet() == 0.0F) {
            var5 = this.utilNombre.myRound(this.receptionLigneAchats.getRecligQte() * var1 * var2 * var3 * var4 / 1.0E7F, 2);
            this.receptionLigneAchats.setRecligPoidsNet(var5);
         } else {
            this.receptionLigneAchats.setRecligQte(0.0F);
            var5 = this.utilNombre.myRound(this.receptionLigneAchats.getRecligPoidsNet() / (var1 * var2 * var3 * var4) * 1.0E7F, 0);
            this.receptionLigneAchats.setRecligQte(var5);
         }
      } else if (this.receptionLigneAchats.getRecligMode() == 1) {
         this.receptionLigneAchats.setRecligQte(this.receptionLigneAchats.getRecligPoidsNet());
      } else {
         this.receptionLigneAchats.setRecligQte(this.receptionLigneAchats.getRecligPoidsNet());
      }

      this.receptionLigneAchats.setRecligQteUtil(this.receptionLigneAchats.getRecligQte());
   }

   public void calculDevisePapier() throws HibernateException, NamingException {
      this.calculDevisePapier((Session)null);
   }

   public void calculDevisePapier(Session var1) throws HibernateException, NamingException {
      if (this.receptionEnteteAchats.getRecDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.receptionEnteteAchats.getRecDevise());
         this.calculDeviseCategorie();
         this.calculPrixPapier(var1);
         if (this.lesLignesList.size() != 0) {
            for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
               this.receptionLigneAchats = new ReceptionLigneAchats();
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var2);
               this.calculPrixPapier(var1);
            }
         }
      }

   }

   public void calculPrixPapier() throws HibernateException, NamingException {
      this.calculPrixPapier((Session)null);
   }

   public void calculPrixPapier(Session var1) throws HibernateException, NamingException {
      if (this.receptionLigneAchats != null) {
         double var2;
         if (this.receptionLigneAchats.getRecligPt() != 0.0D) {
            this.calculDevise(var1);
            var2 = this.receptionLigneAchats.getRecligPt() * (double)this.receptionEnteteAchats.getRecCoefDevise();
            this.receptionLigneAchats.setRecligPtDev(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
         }

         if (this.receptionEnteteAchats.getRecExoTva() == 1) {
            this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
            this.receptionLigneAchats.setRecligTaxe("");
         }

         if (this.receptionLigneAchats.getRecligPt() != 0.0D && this.receptionLigneAchats.getRecligQte() != 0.0F) {
            var2 = this.receptionLigneAchats.getRecligPt() / (double)this.receptionLigneAchats.getRecligQte();
            this.receptionLigneAchats.setRecligPu(var2);
            this.receptionLigneAchats.setRecligPuRem(var2);
            this.receptionLigneAchats.setRecligTc(0.0D);
            if (this.receptionLigneAchats.getRecligTauxTaxe() != 0.0F) {
               double var4 = this.utilNombre.myRoundDevise(this.receptionLigneAchats.getRecligPt() * (double)this.receptionLigneAchats.getRecligTauxTaxe() / 100.0D, this.receptionEnteteAchats.getRecDevise());
               this.receptionLigneAchats.setRecligTva(var4);
            } else {
               this.receptionLigneAchats.setRecligTva(0.0D);
            }

            this.receptionLigneAchats.setRecligTtc(this.receptionLigneAchats.getRecligPt() + this.receptionLigneAchats.getRecligTva());
         } else {
            this.receptionLigneAchats.setRecligPu(0.0D);
            this.receptionLigneAchats.setRecligPt(0.0D);
            this.receptionLigneAchats.setRecligPuRem(0.0D);
            this.receptionLigneAchats.setRecligTc(0.0D);
            this.receptionLigneAchats.setRecligTva(0.0D);
            this.receptionLigneAchats.setRecligTtc(0.0D);
         }
      }

   }

   public void addLignePapier() {
      this.produits = new Produits();
      this.produitsDepot = new ProduitsDepot();
      this.receptionLigneAchats = new ReceptionLigneAchats();
      this.listeSerie.clear();
      this.receptionLotAchats = new ReceptionLotAchats();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_memo_qte = 0.0F;
      this.var_depotProd = "";
   }

   public void saveOneLignePapier() throws IOException, HibernateException, NamingException, Exception {
      if (this.receptionLigneAchats.getRecligFamille() != null && !this.receptionLigneAchats.getRecligFamille().isEmpty() && this.receptionLigneAchats.getRecligFamille().contains(":")) {
         if (this.receptionEnteteAchats.getRecId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.var_memo_qte = this.receptionLigneAchats.getRecligQteUtil();
            String[] var3;
            if (this.var_depotProd != null && !this.var_depotProd.isEmpty() && this.var_depotProd.contains("=")) {
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.receptionLigneAchats.setRecligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.receptionLigneAchats.setRecligDepot(var3[0]);
               }
            } else if (this.var_depotProd != null && !this.var_depotProd.isEmpty() && this.var_depotProd.contains(":")) {
               var3 = this.var_depotProd.split(":");
               this.receptionLigneAchats.setRecligDepot(var3[0]);
            } else {
               this.receptionLigneAchats.setRecligDepot("");
            }

            if ((this.receptionLigneAchats.getRecligCode() == null || this.receptionLigneAchats.getRecligCode().isEmpty()) && this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty()) {
               this.calculQtePapier();
               var3 = this.receptionLigneAchats.getRecligFamille().split(":");
               long var4 = this.produitsDao.nbProduitByFamilleAch(var3[0], var1);
               String var6 = this.receptionEnteteAchats.getRecAnal4() + "-" + var3[0] + "-" + var4;
               boolean var7 = true;

               while(var7) {
                  var7 = this.produitsDao.existCode(var6, var1);
                  if (var7) {
                     ++var4;
                     var6 = this.receptionEnteteAchats.getRecAnal4() + "-" + var3[0] + "-" + var4;
                  } else {
                     var7 = false;
                  }
               }

               this.produits = new Produits();
               this.produits.setProDateCreat(new Date());
               this.produits.setProCode(var6);
               this.produits.setProLibClient(this.receptionLigneAchats.getRecligLibelle());
               this.produits.setProLibTech(this.receptionEnteteAchats.getRecAnal4());
               this.produits.setProCouleur(this.receptionLigneAchats.getRecligCouleur());
               this.produits.setProPoidsNet(this.receptionLigneAchats.getRecligPoidsNet());
               this.produits.setProLargeur(this.receptionLigneAchats.getRecligLarg());
               this.produits.setProLongueur(this.receptionLigneAchats.getRecligLong());
               this.produits.setProEpaisseur(this.receptionLigneAchats.getRecligHaut());
               this.produits.setProMode(0);
               if (this.famillesProduitsAchats == null) {
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var3[0], var1);
               }

               this.produits.setProAchCode(this.famillesProduitsAchats.getFamachCode());
               this.produits.setProAchLib(this.famillesProduitsAchats.getFamachLibelleFr());
               this.produits.setProAchDouane(this.receptionLigneAchats.getRecligDouane());
               this.produits.setProAchNat(this.famillesProduitsAchats.getFamachNature());
               this.produits.setProAchTva(this.famillesProduitsAchats.getFamachTaxe());
               this.produits.setProStock(this.famillesProduitsAchats.getFamachStock());
               this.produits.setProCondition1(this.famillesProduitsAchats.getFamachCondition1());
               this.produits.setProCondition2(this.famillesProduitsAchats.getFamachCondition2());
               this.produits.setProCondition3(this.famillesProduitsAchats.getFamachCondition3());
               this.produits.setProCondition4(this.famillesProduitsAchats.getFamachCondition4());
               this.produits.setProCondition5(this.famillesProduitsAchats.getFamachCondition5());
               new FamillesProduitsVentes();
               FamillesProduitsVentesDao var9 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               FamillesProduitsVentes var8 = var9.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var3[0], var1);
               if (var8 != null) {
                  this.produits.setProVteCode(var8.getFamvteCode());
                  this.produits.setProVteLib(var8.getFamvteLibelleFr());
                  this.produits.setProVteNat(var8.getFamvteNature());
                  this.produits.setProVteTva(var8.getFamvteTaxe());
               } else {
                  this.produits.setProVteCode("");
                  this.produits.setProVteLib("");
                  this.produits.setProVteNat("");
                  this.produits.setProVteTva("");
               }

               this.produits.setProImpDesciption(1);
               this.produits = this.produitsDao.insert(this.produits, var1);
               this.receptionLigneAchats.setRecligCode(this.produits.getProCode());
               new DepotAchats();
               DepotAchatsDao var11 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
               DepotAchats var10 = var11.trouveDepot(this.receptionLigneAchats.getRecligDepot(), var1);
               this.produitsDepot = new ProduitsDepot();
               this.produitsDepot.setProduits(this.produits);
               this.produitsDepot.setDepot(var10);
               this.produitsDepot.setProdepUnite(this.famillesProduitsAchats.getFamachUnite());
               this.produitsDepot.setProdepEchelle(this.famillesProduitsAchats.getFamachEchelle());
               String var12 = this.receptionLigneAchats.getRecligDepot() + ":" + this.receptionLigneAchats.getRecligCode();
               this.produitsDepot.setProdepCle(var12);
               String var13 = this.produitsDepot.getProdepGroupe() + ":" + this.receptionLigneAchats.getRecligCode();
               this.produitsDepot.setProdepCle2(var13);
               this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot, var1);
            }

            this.receptionLigneAchats.setRecligDescription(this.receptionLigneAchats.getFormat());
            if (this.receptionLigneAchats.getRecligId() == 0L) {
               this.receptionLigneAchats.setReceptionEnteteAchats(this.receptionEnteteAchats);
               this.receptionLigneAchats.setRecligDevise(this.receptionEnteteAchats.getRecDevise());
               this.receptionLigneAchats = this.receptionLigneAchatsDao.insertLigne(this.receptionLigneAchats, var1);
               this.lesLignesList.add(this.receptionLigneAchats);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
            } else {
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
            }

            if (this.produits != null && this.produits.getProStock() >= 1 && this.produitsDepot != null) {
               this.calculStock.majReceptionAchatsATT(this.receptionLigneAchats, this.produits, this.var_memo_qte, 1, this.baseLog, var1);
            }

            if (this.produits != null && this.produits.getProId() != 0L && this.tiers != null) {
               this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
               if (this.produitsFournisseur == null) {
                  this.produitsFournisseur = new ProduitsFournisseur();
               }

               this.produitsFournisseur.setProfouDevise(this.receptionEnteteAchats.getRecDevise());
               this.produitsFournisseur.setProfouTauxDevise(this.receptionEnteteAchats.getRecCoefDevise());
               this.produitsFournisseur.setProfouFormat(this.receptionEnteteAchats.getVar_format_devise());
               if ((this.produitsFournisseur.getProfouLib() == null || this.produitsFournisseur.getProfouLib().isEmpty()) && this.receptionLigneAchats.getRecligLibelleFournisseur() != null && !this.receptionLigneAchats.getRecligLibelleFournisseur().isEmpty()) {
                  this.produitsFournisseur.setProfouLib(this.receptionLigneAchats.getRecligLibelleFournisseur());
               }

               if ((this.produitsFournisseur.getProfouRef() == null || this.produitsFournisseur.getProfouRef().isEmpty()) && this.receptionLigneAchats.getRecligReference() != null && !this.receptionLigneAchats.getRecligReference().isEmpty()) {
                  this.produitsFournisseur.setProfouRef(this.receptionLigneAchats.getRecligReference());
               }

               this.produitsFournisseur.setProfouDate(this.receptionEnteteAchats.getRecDate());
               this.produitsFournisseur.setProfouPa(this.receptionLigneAchats.getRecligPu());
               if (this.structureLog.getStrdevise().equalsIgnoreCase(this.receptionEnteteAchats.getRecDevise())) {
                  this.produitsFournisseur.setProfouCoefLocal(1.0F);
                  this.produitsFournisseur.setProfouPaLocal(this.produitsFournisseur.getProfouPa());
               } else {
                  this.produitsFournisseur.setProfouCoefLocal(this.utilNombre.deviseTaux2(this.structureLog.getStrdevise(), this.produitsFournisseur.getProfouDate()));
                  this.produitsFournisseur.setProfouPaLocal(this.utilNombre.myRoundDevise(this.produitsFournisseur.getProfouPa() * (double)this.produitsFournisseur.getProfouCoefLocal(), this.structureLog.getStrdevise()));
               }

               this.produitsFournisseur.setProfouCoefEuro(this.utilNombre.deviseTaux1(this.produitsFournisseur.getProfouDevise(), this.produitsFournisseur.getProfouDate()));
               this.produitsFournisseur.setProfouPaEuro(this.utilNombre.myRoundFormat(this.produitsFournisseur.getProfouPa() * (double)this.produitsFournisseur.getProfouCoefEuro(), 1));
               if (this.produitsFournisseur.getProfouId() == 0L) {
                  this.produitsFournisseur.setProduits(this.produits);
                  this.produitsFournisseur.setTiers(this.tiers);
                  this.produitsFournisseurDao.insert(this.produitsFournisseur, var1);
               } else {
                  this.produitsFournisseurDao.modif(this.produitsFournisseur, var1);
               }
            }

            this.cumulPrix();
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
            var2.commit();
         } catch (HibernateException var17) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.addLignePapier();
      }

   }

   public void recupererEltCatPapier() throws HibernateException, NamingException {
      this.calculDeviseCategorie();
      if (this.lesLignesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.receptionLigneAchats = new ReceptionLigneAchats();
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var3);
               if (this.receptionEnteteAchats.getRecExoTva() == 1) {
                  this.receptionLigneAchats.setRecligTaxe("");
                  this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                  this.receptionLigneAchats.setRecligTva(0.0D);
               } else if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                  var4 = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                  if (var4 != null) {
                     this.receptionLigneAchats.setRecligTaxe(var4.getProAchTva());
                     new TaxesAchats();
                     TaxesAchats var5 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.receptionLigneAchats.getRecligTaxe(), var1);
                     if (var5 != null) {
                        this.receptionLigneAchats.setRecligTauxTaxe(var5.getTaxachTaux());
                     } else {
                        this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                     }
                  } else {
                     this.receptionLigneAchats.setRecligTaxe("");
                     this.receptionLigneAchats.setRecligTauxTaxe(0.0F);
                  }
               }

               this.calculPrixPapier(var1);
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
            }

            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentLigne((Session)null);
         this.cumulPrix();
      }

   }

   public void chargerlesModeles() throws HibernateException, NamingException {
      if (this.mesModelesPlanning == null) {
         this.mesModelesPlanning = new ArrayList();
         PlanningAvicultureAchatsDao var1 = new PlanningAvicultureAchatsDao(this.baseLog, this.utilInitHibernate);
         this.mesModelesPlanning = var1.chargerFraisEnteteItem((Session)null);
      }

   }

   public void calculerPlanning() throws HibernateException, NamingException, ParseException {
      if (this.receptionEnteteAchats.getRecLivreurNom() != null && !this.receptionEnteteAchats.getRecLivreurNom().isEmpty() && this.receptionEnteteAchats.getRecLivreurNom().contains(":")) {
         PlanningAvicultureAchatsDao var1 = new PlanningAvicultureAchatsDao(this.baseLog, this.utilInitHibernate);
         this.lesPlaningsAviculture.clear();
         new ArrayList();
         new PlanningAvicultureAchats();
         String[] var4 = this.receptionEnteteAchats.getRecLivreurNom().split(":");
         List var2 = var1.chargerPlanningLignesCode(var4[0], (Session)null);
         if (var2.size() != 0) {
            for(int var5 = 0; var5 < var2.size(); ++var5) {
               PlanningAvicultureAchats var3 = (PlanningAvicultureAchats)var2.get(var5);
               this.receptionAvicultureAchats = new ReceptionAvicultureAchats();
               this.receptionAvicultureAchats.setRecaviAction1(var3.getPpaAction1());
               this.receptionAvicultureAchats.setRecaviAction2(var3.getPpaAction2());
               this.receptionAvicultureAchats.setRecaviAction3(var3.getPpaAction3());
               this.receptionAvicultureAchats.setRecaviCode(var3.getPpaCode());
               this.receptionAvicultureAchats.setRecaviDate(this.utilDate.CalculDateEcheance(this.var_date, 1, var3.getPpaJour(), 0));
               this.receptionAvicultureAchats.setRecaviFeuille(var3.getPpaFeuille());
               this.receptionAvicultureAchats.setRecaviHumidite(var3.getPpaHumidite());
               this.receptionAvicultureAchats.setRecaviJour(var3.getPpaJour());
               this.receptionAvicultureAchats.setRecaviNbJour(var3.getPpaNbJour());
               this.receptionAvicultureAchats.setRecaviNbMortalite(var3.getPpaNbMortalite());
               this.receptionAvicultureAchats.setRecaviObservation(var3.getPpaObservation());
               this.receptionAvicultureAchats.setRecaviOrdre(var3.getPpaOrdre());
               this.receptionAvicultureAchats.setRecaviPoids(var3.getPpaPoids());
               this.receptionAvicultureAchats.setRecaviQteAliment(var3.getPpaQteAliment());
               this.receptionAvicultureAchats.setRecaviQteEau(var3.getPpaQteEau());
               this.receptionAvicultureAchats.setRecaviTraitement1(var3.getPpaTraitement1());
               this.receptionAvicultureAchats.setRecaviTraitement2(var3.getPpaTraitement2());
               this.receptionAvicultureAchats.setRecaviTraitement3(var3.getPpaTraitement3());
               this.receptionAvicultureAchats.setRecaviTemperature(var3.getPpaTemperature());
               this.receptionAvicultureAchats.setRecaviVaccin1(var3.getPpaVaccin1());
               this.receptionAvicultureAchats.setRecaviVaccin2(var3.getPpaVaccin3());
               this.receptionAvicultureAchats.setRecaviVaccin3(var3.getPpaVaccin3());
               this.receptionAvicultureAchats.setReceptionEnteteAchats(this.receptionEnteteAchats);
               this.lesPlaningsAviculture.add(this.receptionAvicultureAchats);
            }
         }
      }

   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.receptionEnteteAchats.getRecFormule1() != null && !this.receptionEnteteAchats.getRecFormule1().isEmpty()) {
         FormulesAchatsDao var2 = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesAchats(this.receptionEnteteAchats.getRecFormule1(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.receptionEnteteAchats.getRecAnnexe1() != null && !this.receptionEnteteAchats.getRecAnnexe1().isEmpty() && this.receptionEnteteAchats.getRecAnnexe1().contains(":")) {
         String[] var2 = this.receptionEnteteAchats.getRecAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.receptionEnteteAchats.getUsers(), this.structureLog, this.receptionEnteteAchats.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.receptionEnteteAchats.getRecAnnexe2() != null && !this.receptionEnteteAchats.getRecAnnexe2().isEmpty() && this.receptionEnteteAchats.getRecAnnexe2().contains(":")) {
         String[] var2 = this.receptionEnteteAchats.getRecAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.receptionEnteteAchats.getUsers(), this.structureLog, this.receptionEnteteAchats.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 10) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (var2 == 11) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (var2 == 12) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var2 == 13) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (var2 == 14) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var2 == 15) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var2 == 16) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var2 == 17) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var2 == 18) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (var2 == 19) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (var2 == 35) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var2 == 30) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (var2 == 31) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      } else if (var2 == 32) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_sortie" + File.separator;
      } else if (var2 == 33) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "cession" + File.separator;
      } else if (var2 == 34) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      } else if (var2 == 35) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var2 == 36) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "sommier" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatReception.jpg");
            if (var4.exists()) {
               var3 = "formatReception.jpg";
            }
         }
      } else if (var2 == 20) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatParapheur.jpg");
         if (var4.exists()) {
            var3 = "formatParapheur.jpg";
         }
      } else if (var2 == 30) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCaisse.jpg");
         if (var4.exists()) {
            var3 = "formatCaisse.jpg";
         }
      } else {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatReception.jpg");
         if (var4.exists()) {
            var3 = "formatReception.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(Session var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         new CommandeLigneAchats();
         CommandeLigneAchatsDao var4 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         String var5 = "";
         CommandeLigneAchats var3;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
            Transaction var6 = null;

            try {
               var6 = var1.beginTransaction();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var7);
                  if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                     if (this.produits != null) {
                        this.receptionLigneAchats.setRecligCoefPr(this.receptionEnteteAchats.getRecCoefValo());
                        this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                        if (this.produitsFournisseur != null) {
                           this.receptionLigneAchats.setRecligReference(this.produitsFournisseur.getProfouRef());
                           this.receptionLigneAchats.setRecligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
                           this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
                        }
                     }
                  } else {
                     this.receptionLigneAchats.setRecligCoefPr(0.0F);
                  }

                  if (this.receptionLigneAchats.getRecligIdCmd() != 0L) {
                     var3 = var4.rechercheCommande(this.receptionLigneAchats.getRecligIdCmd(), var1);
                     if (var3 != null) {
                        if (var5 != null && !var5.isEmpty()) {
                           if (!var3.getCommandeEnteteAchats().getCmdNum().contains(var5)) {
                              var5 = var5 + ":" + var3.getCommandeEnteteAchats().getCmdNum();
                           }
                        } else {
                           var5 = var3.getCommandeEnteteAchats().getCmdNum();
                        }
                     }
                  }

                  this.receptionLigneAchats.setNumBc(var5);
                  var2.add(this.receptionLigneAchats);
               }

               var6.commit();
            } catch (HibernateException var11) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.lesLignesList.get(var14);
               if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.receptionLigneAchats.getRecligCode(), var1);
                  if (this.produits != null) {
                     this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                     if (this.produitsFournisseur != null) {
                        this.receptionLigneAchats.setRecligReference(this.produitsFournisseur.getProfouRef());
                        this.receptionLigneAchats.setRecligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
                        this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
                     }
                  }

                  if (this.receptionLigneAchats.getRecligIdCmd() != 0L) {
                     var3 = var4.rechercheCommande(this.receptionLigneAchats.getRecligIdCmd(), var1);
                     if (var3 != null) {
                        if (var5 != null && !var5.isEmpty()) {
                           if (!var3.getCommandeEnteteAchats().getCmdNum().contains(var5)) {
                              var5 = var5 + ":" + var3.getCommandeEnteteAchats().getCmdNum();
                           }
                        } else {
                           var5 = var3.getCommandeEnteteAchats().getCmdNum();
                        }
                     }
                  }

                  this.receptionLigneAchats.setNumBc(var5);
               }

               var2.add(this.receptionLigneAchats);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.receptionEnteteAchats.getRecTotTtc() + this.receptionEnteteAchats.getRecTotTc(), this.receptionEnteteAchats.getRecDevise());
      JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var2);
      return var13;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.receptionEnteteAchats.getRecAnal2() != null && !this.receptionEnteteAchats.getRecAnal2().isEmpty()) {
         String var4 = "";
         if (this.receptionEnteteAchats.getRecAnal2().contains(":")) {
            String[] var5 = this.receptionEnteteAchats.getRecAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.receptionEnteteAchats.getRecAnal2();
         }

         ParcDao var6 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var3 = var6.rechercheParc(var4, var1);
         if (var3 != null) {
            var2 = var3.getPrcImmatriculation();
         }
      } else {
         var3 = null;
      }

      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         boolean var5 = false;
         long var6 = this.receptionEnteteAchats.getTiers().getTieid();
         if (this.receptionEnteteAchats.getRecDateImp() != null) {
            var2 = true;
         }

         this.receptionEnteteAchats.setRecDateImp(new Date());
         if (this.receptionEnteteAchats.getRecEtat() == 0 && this.receptionEnteteAchats.getRecEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.receptionEnteteAchats.setRecEtat(1);
            var5 = true;
         }

         this.receptionEnteteAchats.setRecModeleImp(var1);
         this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var3);
         if (var5) {
            if (this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var9 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var8 = var9.rechercheByDossier(this.receptionEnteteAchats.getRecAnal4(), var3);
               if (var8 != null) {
                  this.receptionEnteteAchats.setRecValo(var8.getValNum());
                  this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var3);
               }
            }

            if (this.receptionEnteteAchats.getRecValorisation() == 0 && this.receptionEnteteAchats.getRecCoefValo() != 0.0F) {
               this.calculPrCoefReception(var3);
            } else if (this.receptionEnteteAchats.getRecValorisation() != 1 && this.receptionEnteteAchats.getRecValorisation() == 2) {
               this.calculPrCoefFamille(var3);
            }

            this.calculStock.majReceptionAchatsVAL(this.lesLignesList, 1, this.baseLog, var3);
            if (this.tiers.getTieDteDocument3() == null || this.receptionEnteteAchats.getRecDate().after(this.tiers.getTieDteDocument3())) {
               this.tiers = this.tiersDao.selectTierD(var6, var3);
               if (this.tiers != null) {
                  this.tiers.setTieDteDocument3(this.receptionEnteteAchats.getRecDate());
                  this.tiers = this.tiersDao.modif(this.tiers, var3);
               }
            }
         }

         this.contacts = new Contacts();
         if (this.receptionEnteteAchats.getRecIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.receptionEnteteAchats.getRecIdContact(), var3);
         }

         var4.commit();
      } catch (HibernateException var13) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun((Session)null));
            var1.setRapport(var3);
            var1.setEntete("Impression réception");
            var1.setMontant_lettre(this.montant_lettre);
            if (this.receptionEnteteAchats.getRecFormule1() != null && !this.receptionEnteteAchats.getRecFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog, this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.receptionEnteteAchats.getRecEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.receptionEnteteAchats.getRecIdResponsable());
            var1.setTiersSelectionne(this.receptionEnteteAchats.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.receptionEnteteAchats.getRecNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.receptionEnteteAchats.getRecId());
            if (this.receptionEnteteAchats.getRecAnal2() != null && !this.receptionEnteteAchats.getRecAnal2().isEmpty()) {
               String var12 = "";
               if (this.receptionEnteteAchats.getRecAnal2().contains(":")) {
                  String[] var13 = this.receptionEnteteAchats.getRecAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.receptionEnteteAchats.getRecAnal2();
               }

               new Parc();
               ParcDao var14 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var16 = var14.rechercheParc(var12, (Session)null);
               if (var16 != null) {
                  var1.setParc(var16);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des réceptions");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "reception" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var15);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void initGrapheur() {
      this.modeGraph = 0;
      this.valQteGraph = 0;
      this.timeDecoupage = 1;
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
      if (this.lesEntetesList.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "RECEPTIONS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "RECEPTIONS : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionAchats.getNbDecQte());
         }

         this.titreGraph = "Analyse des achats : ";
         EtatDocument var2 = new EtatDocument();
         if (this.inpDu != null && this.inpAu != null) {
            String var3 = this.utilDate.dateToStringFr(this.inpDu);
            String var4 = this.utilDate.dateToStringFr(this.inpAu);
            this.titreGraph = this.titreGraph + " Du " + var3 + " au " + var4;
         } else if (this.periode.equals("100")) {
            this.titreGraph = this.titreGraph + " Toutes periodes";
         } else {
            this.titreGraph = this.titreGraph + " " + var2.calculeLibellePeriode(this.periode);
         }

         if (this.timeDecoupage == 5) {
            this.titreGraph = this.titreGraph + " Par tranches horaires";
         }

         this.sousTitreGraph = "";
         if (this.inpCat.equals("100")) {
            this.sousTitreGraph = "Toutes les categories -";
         } else {
            this.sousTitreGraph = "Categorie: " + this.inpCat + " -";
         }

         this.sousTitreGraph = this.sousTitreGraph + " Serie:" + this.inpSerie + " -";
         if (this.inpEtat == 100) {
            this.sousTitreGraph = this.sousTitreGraph + " Tous les Etats";
         } else {
            this.sousTitreGraph = this.sousTitreGraph + " Etats: " + var2.calculeLibelleEtat(this.nature, this.inpEtat, 0);
         }

         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par responsable (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par commercial (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par equipe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par societe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par famille de produit (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par produit (" + this.uniteGraph + ")";
         }

         new ReceptionEnteteAchats();
         new ReceptionLigneAchats();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         String var6 = "";

         ReceptionEnteteAchats var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (ReceptionEnteteAchats)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getRecNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getRecNum() + "'";
            }
         }

         int var12;
         int var19;
         if (this.valQteGraph != 1 && this.modeGraph != 5 && this.modeGraph != 6) {
            if (this.lesEntetesList.size() != 0) {
               String var17 = "";
               long var20 = 0L;
               boolean var10 = false;
               var19 = 0;

               while(true) {
                  if (var19 >= this.lesEntetesList.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  var14 = (ReceptionEnteteAchats)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getRecDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getRecNomResponsable() != null && !var14.getRecNomResponsable().isEmpty()) {
                        var17 = var14.getRecNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getRecNomTiers() != null && !var14.getRecNomTiers().isEmpty()) {
                        var17 = var14.getRecNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  }

                  var20 = (long)var14.getRecTotHtLocal();
                  if (this.timeDecoupage == 0) {
                     var18 = var14.getRecDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getRecDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getRecDate().getMonth() + 1 >= 1 && var14.getRecDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getRecDate().getMonth() + 1 >= 4 && var14.getRecDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getRecDate().getMonth() + 1 >= 7 && var14.getRecDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getRecDate().getMonth() + 1 >= 10 && var14.getRecDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getRecDate().getMonth() + 1 >= 1 && var14.getRecDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getRecDate().getMonth() + 1 >= 7 && var14.getRecDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getRecDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.receptionLigneAchatsDao.chargerLesLignesReceptions(var6, var5);
            if (var16.size() != 0) {
               String var8 = "";
               long var9 = 0L;
               boolean var11 = false;
               var12 = 0;

               while(true) {
                  if (var12 >= var16.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  ReceptionLigneAchats var15 = (ReceptionLigneAchats)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getReceptionEnteteAchats().getRecDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getReceptionEnteteAchats().getRecNomResponsable() != null && !var15.getReceptionEnteteAchats().getRecNomResponsable().isEmpty()) {
                        var8 = var15.getReceptionEnteteAchats().getRecNomResponsable();
                     } else {
                        var8 = "Sans responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getReceptionEnteteAchats().getRecNomTiers() != null && !var15.getReceptionEnteteAchats().getRecNomTiers().isEmpty()) {
                        var8 = var15.getReceptionEnteteAchats().getRecNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getRecligFamille() != null && !var15.getRecligFamille().isEmpty()) {
                        var8 = var15.getRecligFamille();
                     } else {
                        var8 = "Sans Famille produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getRecligLibelle() != null && !var15.getRecligLibelle().isEmpty()) {
                        var8 = var15.getRecligLibelle();
                     } else {
                        var8 = "Sans Libelle produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getRecligPtDev();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getRecligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getReceptionEnteteAchats().getRecDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 >= 1 && var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 >= 4 && var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 >= 7 && var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 >= 10 && var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 >= 1 && var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 >= 7 && var15.getReceptionEnteteAchats().getRecDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getReceptionEnteteAchats().getRecDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var8, var19, var9);
                  ++var12;
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModele = true;
      return (List)var1;
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

   public void accesCatalogue() throws HibernateException, NamingException {
      if (this.tiers != null) {
         this.utilDownload = new UtilDownload();
         this.uploadedFile = null;
         this.dataModelCatalogueFichier = new ListDataModel();
         this.lesCataloguesFichiers = new ArrayList();
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "Tiers" + File.separator + "tier_" + this.tiers.getTieid() + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.cheminCatalogue = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "Tiers" + File.separator + "tier_" + this.tiers.getTieid() + File.separator + "catalogue" + File.separator;
         var2 = new File(this.cheminCatalogue);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               this.lesCataloguesFichiers.add(var3[var4]);
            }
         }

         this.dataModelCatalogueFichier.setWrappedData(this.lesCataloguesFichiers);
         this.fichierUrl = null;
      }

   }

   public void selectionnerCatalogue() {
      if (this.dataModelCatalogueFichier.isRowAvailable()) {
         this.nomCatalogue = (String)this.dataModelCatalogueFichier.getRowData();
      }

   }

   public void ajouterCatalogue() {
      this.uploadedFile = null;
      this.nomCatalogue = null;
      this.showModalPanelAjoutFile = true;
   }

   public void annulerCatalogue() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerCatalogue() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               if (var1.toString().contains(" ")) {
                  String var2 = var1.toString();
                  String var3 = "";

                  for(int var4 = 0; var4 < var2.length(); ++var4) {
                     String var5 = var2.substring(var4, var4 + 1);
                     if (var5.equals(" ")) {
                        var3 = var3 + "_";
                     } else {
                        var3 = var3 + var2.substring(var4, var4 + 1);
                     }
                  }

                  var1 = var3;
               }

               this.nomCatalogue = var1;
               File var7 = new File(this.cheminCatalogue + var1);
               var7.delete();
               File var8 = this.utilDownload.uniqueFile(new File(this.cheminCatalogue), var1);
               this.utilDownload.write(var8, this.uploadedFile.getInputStream());
               this.lesCataloguesFichiers.add(var1);
               this.dataModelCatalogueFichier.setWrappedData(this.lesCataloguesFichiers);
            }
         }
      } catch (IOException var6) {
      }

      this.showModalPanelAjoutFile = false;
   }

   public void consulterCatalogue() throws MalformedURLException, IOException {
      if (this.nomCatalogue != null && !this.nomCatalogue.isEmpty()) {
         this.fichierUrl = this.utilDownload.convertirFichierUtl(this.cheminCatalogue + this.nomCatalogue, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.nomCatalogue);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuCatalogue() {
      this.showModalPanelPj = false;
   }

   public void supprimerCatalogue() {
      if (this.nomCatalogue != null && !this.nomCatalogue.isEmpty()) {
         String var1 = this.cheminCatalogue + this.nomCatalogue;
         File var2 = new File(var1);
         var2.delete();
         this.lesCataloguesFichiers.remove(this.nomCatalogue);
         this.dataModelCatalogueFichier.setWrappedData(this.lesCataloguesFichiers);
         this.nomCatalogue = "";
      }

   }

   public void selectionTracabilite() {
      if (this.datamodelDocumentTrace.isRowAvailable()) {
         this.documentTraceAchats = (DocumentTraceAchats)this.datamodelDocumentTrace.getRowData();
      }

   }

   public void voirOrigine() throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceAchats == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceAchats != null) {
         this.voirCommun(this.documentTraceAchats.getDoctrfOrgType(), this.documentTraceAchats.getDoctrfOrgId(), this.documentTraceAchats.getDoctrfOrgNum(), this.documentTraceAchats.getDoctrfOrgSerie());
      }

   }

   public void voirDestination() throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceAchats == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceAchats != null) {
         this.voirCommun(this.documentTraceAchats.getDoctrfDstType(), this.documentTraceAchats.getDoctrfDstId(), this.documentTraceAchats.getDoctrfDstNum(), this.documentTraceAchats.getDoctrfDstSerie());
      }

   }

   public void voirCommun(int var1, long var2, String var4, String var5) throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceAchats == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceAchats != null) {
         UtilPrint var6 = new UtilPrint(this.utilInitHibernate);
         String var8;
         if (var1 == 10) {
            FormDemandeAchats var7 = new FormDemandeAchats();
            var7.setBaseLog(this.baseLog);
            var7.setStructureLog(this.structureLog);
            var7.setUsersLog(this.usersLog);
            var7.setutilInitHibernate(this.utilInitHibernate);
            var7.InstancesDaoUtilses();
            var7.rechercheDOCUMENT(var2);
            if (var7.getDemandeEnteteAchats() != null) {
               var7.setExercicesAchats(var7.getDemandeEnteteAchats().getExercicesAchats());
               var8 = var7.getDemandeEnteteAchats().getDemModeleImp();
               var7.setOptionAchats(this.optionAchats);
               var7.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var7.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la DA n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la DA n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 11) {
            FormCotationAchats var9 = new FormCotationAchats();
            var9.setBaseLog(this.baseLog);
            var9.setStructureLog(this.structureLog);
            var9.setUsersLog(this.usersLog);
            var9.setutilInitHibernate(this.utilInitHibernate);
            var9.InstancesDaoUtilses();
            var9.rechercheDOCUMENT(var2);
            if (var9.getCotationEnteteAchats() != null) {
               var9.setExercicesAchats(var9.getCotationEnteteAchats().getExercicesAchats());
               var8 = var9.getCotationEnteteAchats().getCotModeleImp();
               var9.setOptionAchats(this.optionAchats);
               var9.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var9.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Cotation n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Cotation n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 12) {
            FormCommandeAchats var10 = new FormCommandeAchats();
            var10.setBaseLog(this.baseLog);
            var10.setStructureLog(this.structureLog);
            var10.setUsersLog(this.usersLog);
            var10.setutilInitHibernate(this.utilInitHibernate);
            var10.InstancesDaoUtilses();
            var10.rechercheDOCUMENT(var2);
            if (var10.getCommandeEnteteAchats() != null) {
               var10.setExercicesAchats(var10.getCommandeEnteteAchats().getExercicesAchats());
               var8 = var10.getCommandeEnteteAchats().getCmdModeleImp();
               var10.setOptionAchats(this.optionAchats);
               var10.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var10.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la CMD n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la CMD n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 13) {
            FormReceptionAchats var11 = new FormReceptionAchats();
            var11.setBaseLog(this.baseLog);
            var11.setStructureLog(this.structureLog);
            var11.setUsersLog(this.usersLog);
            var11.setutilInitHibernate(this.utilInitHibernate);
            var11.InstancesDaoUtilses();
            var11.rechercheDOCUMENT(var2);
            if (var11.getReceptionEnteteAchats() != null) {
               var11.setExercicesAchats(var11.getReceptionEnteteAchats().getExercicesAchats());
               var8 = var11.getReceptionEnteteAchats().getRecModeleImp();
               var11.setOptionAchats(this.optionAchats);
               var11.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var11.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Réception n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Réception n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 14) {
            FormRetourAchats var12 = new FormRetourAchats();
            var12.setBaseLog(this.baseLog);
            var12.setStructureLog(this.structureLog);
            var12.setUsersLog(this.usersLog);
            var12.setutilInitHibernate(this.utilInitHibernate);
            var12.InstancesDaoUtilses();
            var12.rechercheDOCUMENT(var2);
            if (var12.getRetourEnteteAchats() != null) {
               var12.setExercicesAchats(var12.getRetourEnteteAchats().getExercicesAchats());
               var8 = var12.getRetourEnteteAchats().getBrfModeleImp();
               var12.setOptionAchats(this.optionAchats);
               var12.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var12.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 15) {
            FormFactureAchats var13 = new FormFactureAchats();
            var13.setBaseLog(this.baseLog);
            var13.setStructureLog(this.structureLog);
            var13.setUsersLog(this.usersLog);
            var13.setutilInitHibernate(this.utilInitHibernate);
            var13.InstancesDaoUtilses();
            var13.rechercheDOCUMENT(var2);
            if (var13.getFactureEnteteAchats() != null) {
               var13.setExercicesAchats(var13.getFactureEnteteAchats().getExercicesAchats());
               var8 = var13.getFactureEnteteAchats().getFcfModeleImp();
               var13.setOptionAchats(this.optionAchats);
               var13.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var13.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 16) {
            FormAvoirAchats var14 = new FormAvoirAchats();
            var14.setBaseLog(this.baseLog);
            var14.setStructureLog(this.structureLog);
            var14.setUsersLog(this.usersLog);
            var14.setutilInitHibernate(this.utilInitHibernate);
            var14.InstancesDaoUtilses();
            var14.rechercheDOCUMENT(var2);
            if (var14.getAvoirEnteteAchats() != null) {
               var14.setExercicesAchats(var14.getAvoirEnteteAchats().getExercicesAchats());
               var8 = var14.getAvoirEnteteAchats().getAvfModeleImp();
               var14.setOptionAchats(this.optionAchats);
               var14.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var14.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 17) {
            FormNoteDebitAchats var15 = new FormNoteDebitAchats();
            var15.setBaseLog(this.baseLog);
            var15.setStructureLog(this.structureLog);
            var15.setUsersLog(this.usersLog);
            var15.setutilInitHibernate(this.utilInitHibernate);
            var15.InstancesDaoUtilses();
            var15.rechercheDOCUMENT(var2);
            if (var15.getNoteDebitEnteteAchats() != null) {
               var15.setExercicesAchats(var15.getNoteDebitEnteteAchats().getExercicesAchats());
               var8 = var15.getNoteDebitEnteteAchats().getNdfModeleImp();
               var15.setOptionAchats(this.optionAchats);
               var15.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var15.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Note de débit n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Note Débit n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         }
      }

   }

   public boolean isAccesProduits() {
      return this.accesProduits;
   }

   public void setAccesProduits(boolean var1) {
      this.accesProduits = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public ReceptionEnteteAchats getReceptionEnteteAchats() {
      return this.receptionEnteteAchats;
   }

   public void setReceptionEnteteAchats(ReceptionEnteteAchats var1) {
      this.receptionEnteteAchats = var1;
   }

   public ReceptionLigneAchats getReceptionLigneAchats() {
      return this.receptionLigneAchats;
   }

   public void setReceptionLigneAchats(ReceptionLigneAchats var1) {
      this.receptionLigneAchats = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
   }

   public String getInpBudget() {
      return this.inpBudget;
   }

   public void setInpBudget(String var1) {
      this.inpBudget = var1;
   }

   public String getInpFournisseur() {
      return this.inpFournisseur;
   }

   public void setInpFournisseur(String var1) {
      this.inpFournisseur = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public String getInpResponsable() {
      return this.inpResponsable;
   }

   public void setInpResponsable(String var1) {
      this.inpResponsable = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public List getMesSeriesTrfItems() {
      return this.mesSeriesTrfItems;
   }

   public void setMesSeriesTrfItems(List var1) {
      this.mesSeriesTrfItems = var1;
   }

   public List getMesTaxesAchatsItems() {
      return this.mesTaxesAchatsItems;
   }

   public void setMesTaxesAchatsItems(List var1) {
      this.mesTaxesAchatsItems = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public List getModeleTrfItems() {
      return this.modeleTrfItems;
   }

   public void setModeleTrfItems(List var1) {
      this.modeleTrfItems = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantReglementElmt() {
      return this.montantReglementElmt;
   }

   public void setMontantReglementElmt(double var1) {
      this.montantReglementElmt = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public double getMontantSoldeElmt() {
      return this.montantSoldeElmt;
   }

   public void setMontantSoldeElmt(double var1) {
      this.montantSoldeElmt = var1;
   }

   public double getMontantTtc() {
      return this.montantTtc;
   }

   public void setMontantTtc(double var1) {
      this.montantTtc = var1;
   }

   public double getMontantTtcElmt() {
      return this.montantTtcElmt;
   }

   public void setMontantTtcElmt(double var1) {
      this.montantTtcElmt = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isShowModalPanelTrf() {
      return this.showModalPanelTrf;
   }

   public void setShowModalPanelTrf(boolean var1) {
      this.showModalPanelTrf = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_prp() {
      return this.var_acc_prp;
   }

   public void setVar_acc_prp(boolean var1) {
      this.var_acc_prp = var1;
   }

   public boolean isVar_acc_special() {
      return this.var_acc_special;
   }

   public void setVar_acc_special(boolean var1) {
      this.var_acc_special = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
   }

   public boolean isVar_acc_reglement() {
      return this.var_acc_reglement;
   }

   public void setVar_acc_reglement(boolean var1) {
      this.var_acc_reglement = var1;
   }

   public boolean isVar_acc_tracabilite() {
      return this.var_acc_tracabilite;
   }

   public void setVar_acc_tracabilite(boolean var1) {
      this.var_acc_tracabilite = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public boolean isVar_aff_trf() {
      return this.var_aff_trf;
   }

   public void setVar_aff_trf(boolean var1) {
      this.var_aff_trf = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public String getVar_depotProd() {
      return this.var_depotProd;
   }

   public void setVar_depotProd(String var1) {
      this.var_depotProd = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public String getVar_imput_cat() {
      return this.var_imput_cat;
   }

   public void setVar_imput_cat(String var1) {
      this.var_imput_cat = var1;
   }

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public String getVar_mode_trf() {
      return this.var_mode_trf;
   }

   public void setVar_mode_trf(String var1) {
      this.var_mode_trf = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public boolean isVar_sansstock() {
      return this.var_sansstock;
   }

   public void setVar_sansstock(boolean var1) {
      this.var_sansstock = var1;
   }

   public String getVar_serie_trf() {
      return this.var_serie_trf;
   }

   public void setVar_serie_trf(String var1) {
      this.var_serie_trf = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
   }

   public int getVar_type_trf() {
      return this.var_type_trf;
   }

   public void setVar_type_trf(int var1) {
      this.var_type_trf = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public String getVerrouDepotUser() {
      return this.verrouDepotUser;
   }

   public void setVerrouDepotUser(String var1) {
      this.verrouDepotUser = var1;
   }

   public boolean isVerrouNum() {
      return this.verrouNum;
   }

   public void setVerrouNum(boolean var1) {
      this.verrouNum = var1;
   }

   public boolean isVerrouPrvente() {
      return this.verrouPrvente;
   }

   public void setVerrouPrvente(boolean var1) {
      this.verrouPrvente = var1;
   }

   public boolean isVerrouRabais() {
      return this.verrouRabais;
   }

   public void setVerrouRabais(boolean var1) {
      this.verrouRabais = var1;
   }

   public boolean isVerrouRemise() {
      return this.verrouRemise;
   }

   public void setVerrouRemise(boolean var1) {
      this.verrouRemise = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibiliteencaissemt() {
      return this.visibiliteencaissemt;
   }

   public void setVisibiliteencaissemt(boolean var1) {
      this.visibiliteencaissemt = var1;
   }

   public boolean isVisibilitefactor() {
      return this.visibilitefactor;
   }

   public void setVisibilitefactor(boolean var1) {
      this.visibilitefactor = var1;
   }

   public boolean isVisibilitenbrjr() {
      return this.visibilitenbrjr;
   }

   public void setVisibilitenbrjr(boolean var1) {
      this.visibilitenbrjr = var1;
   }

   public boolean isVisibiliteterme() {
      return this.visibiliteterme;
   }

   public void setVisibiliteterme(boolean var1) {
      this.visibiliteterme = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
   }

   public String getInpParc() {
      return this.inpParc;
   }

   public void setInpParc(String var1) {
      this.inpParc = var1;
   }

   public boolean isVisibiliteBtonlig() {
      return this.visibiliteBtonlig;
   }

   public void setVisibiliteBtonlig(boolean var1) {
      this.visibiliteBtonlig = var1;
   }

   public boolean isVisibleOngleEntete() {
      return this.visibleOngleEntete;
   }

   public void setVisibleOngleEntete(boolean var1) {
      this.visibleOngleEntete = var1;
   }

   public DataModel getDatamodelEntete() {
      return this.datamodelEntete;
   }

   public void setDatamodelEntete(DataModel var1) {
      this.datamodelEntete = var1;
   }

   public DataModel getDatamodelLigne() {
      return this.datamodelLigne;
   }

   public void setDatamodelLigne(DataModel var1) {
      this.datamodelLigne = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
   }

   public List getMesTaxesAchatsProduits() {
      return this.mesTaxesAchatsProduits;
   }

   public void setMesTaxesAchatsProduits(List var1) {
      this.mesTaxesAchatsProduits = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public ExercicesAchats getLastExoAchats() {
      return this.lastExoAchats;
   }

   public void setLastExoAchats(ExercicesAchats var1) {
      this.lastExoAchats = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
   }

   public List getMesUnitesItems() {
      return this.mesUnitesItems;
   }

   public void setMesUnitesItems(List var1) {
      this.mesUnitesItems = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public List getDocumentTrfItems() {
      return this.documentTrfItems;
   }

   public void setDocumentTrfItems(List var1) {
      this.documentTrfItems = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public boolean isVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(boolean var1) {
      this.var_anal_dossier = var1;
   }

   public ExercicesComptable getLastExoCompta() {
      return this.lastExoCompta;
   }

   public void setLastExoCompta(ExercicesComptable var1) {
      this.lastExoCompta = var1;
   }

   public String getVar_heure() {
      return this.var_heure;
   }

   public void setVar_heure(String var1) {
      this.var_heure = var1;
   }

   public String getVar_minute() {
      return this.var_minute;
   }

   public void setVar_minute(String var1) {
      this.var_minute = var1;
   }

   public String getVar_seconde() {
      return this.var_seconde;
   }

   public void setVar_seconde(String var1) {
      this.var_seconde = var1;
   }

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public ProduitsDepot getProduitsDepot() {
      return this.produitsDepot;
   }

   public void setProduitsDepot(ProduitsDepot var1) {
      this.produitsDepot = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public int getVar_format_devise() {
      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public List getLesFamilleFournisseursListe() {
      return this.lesFamilleFournisseursListe;
   }

   public void setLesFamilleFournisseursListe(List var1) {
      this.lesFamilleFournisseursListe = var1;
   }

   public DataModel getDataModelSerie() {
      return this.dataModelSerie;
   }

   public void setDataModelSerie(DataModel var1) {
      this.dataModelSerie = var1;
   }

   public boolean isShowModalPanelLot() {
      return this.showModalPanelLot;
   }

   public void setShowModalPanelLot(boolean var1) {
      this.showModalPanelLot = var1;
   }

   public boolean isShowModalPanelSerie() {
      return this.showModalPanelSerie;
   }

   public void setShowModalPanelSerie(boolean var1) {
      this.showModalPanelSerie = var1;
   }

   public ReceptionLotAchats getReceptionLotAchats() {
      return this.receptionLotAchats;
   }

   public void setReceptionLotAchats(ReceptionLotAchats var1) {
      this.receptionLotAchats = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public String getVar_lib_condit() {
      return this.var_lib_condit;
   }

   public void setVar_lib_condit(String var1) {
      this.var_lib_condit = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public boolean isVerrou_libelle() {
      return this.verrou_libelle;
   }

   public void setVerrou_libelle(boolean var1) {
      this.verrou_libelle = var1;
   }

   public boolean isVerrouPump() {
      return this.verrouPump;
   }

   public void setVerrouPump(boolean var1) {
      this.verrouPump = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
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

   public boolean isVar_depot_famille() {
      return this.var_depot_famille;
   }

   public void setVar_depot_famille(boolean var1) {
      this.var_depot_famille = var1;
   }

   public DataModel getDatamodelDouane() {
      return this.datamodelDouane;
   }

   public void setDatamodelDouane(DataModel var1) {
      this.datamodelDouane = var1;
   }

   public boolean isShowModalPanelDouane() {
      return this.showModalPanelDouane;
   }

   public void setShowModalPanelDouane(boolean var1) {
      this.showModalPanelDouane = var1;
   }

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public String getVar_num_carton() {
      return this.var_num_carton;
   }

   public void setVar_num_carton(String var1) {
      this.var_num_carton = var1;
   }

   public String getVar_num_palette() {
      return this.var_num_palette;
   }

   public void setVar_num_palette(String var1) {
      this.var_num_palette = var1;
   }

   public DataModel getDataModelFrais() {
      return this.dataModelFrais;
   }

   public void setDataModelFrais(DataModel var1) {
      this.dataModelFrais = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesDepotAchItems() {
      return this.mesDepotAchItems;
   }

   public void setMesDepotAchItems(List var1) {
      this.mesDepotAchItems = var1;
   }

   public int getAffichageQtePoids() {
      return this.affichageQtePoids;
   }

   public void setAffichageQtePoids(int var1) {
      this.affichageQtePoids = var1;
   }

   public List getLesModeReglementFournisseurListe() {
      return this.lesModeReglementFournisseurListe;
   }

   public void setLesModeReglementFournisseurListe(List var1) {
      this.lesModeReglementFournisseurListe = var1;
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

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public DataModel getDataModelCatalogueFichier() {
      return this.dataModelCatalogueFichier;
   }

   public void setDataModelCatalogueFichier(DataModel var1) {
      this.dataModelCatalogueFichier = var1;
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

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public int getModeReception() {
      return this.modeReception;
   }

   public void setModeReception(int var1) {
      this.modeReception = var1;
   }

   public String getLibelleModeReception() {
      return this.libelleModeReception;
   }

   public void setLibelleModeReception(String var1) {
      this.libelleModeReception = var1;
   }

   public List getMesModelesPlanning() {
      return this.mesModelesPlanning;
   }

   public void setMesModelesPlanning(List var1) {
      this.mesModelesPlanning = var1;
   }

   public List getLesPlaningsAviculture() {
      return this.lesPlaningsAviculture;
   }

   public void setLesPlaningsAviculture(List var1) {
      this.lesPlaningsAviculture = var1;
   }

   public long getInpIdTiersEnCours() {
      return this.inpIdTiersEnCours;
   }

   public void setInpIdTiersEnCours(long var1) {
      this.inpIdTiersEnCours = var1;
   }

   public String getInpNomTiersEnCours() {
      return this.inpNomTiersEnCours;
   }

   public void setInpNomTiersEnCours(String var1) {
      this.inpNomTiersEnCours = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }

   public boolean isAccesLot() {
      return this.accesLot;
   }

   public void setAccesLot(boolean var1) {
      this.accesLot = var1;
   }

   public String getLibelleDossier() {
      return this.libelleDossier;
   }

   public void setLibelleDossier(String var1) {
      this.libelleDossier = var1;
   }

   public double getTotalFrais() {
      return this.totalFrais;
   }

   public void setTotalFrais(double var1) {
      this.totalFrais = var1;
   }

   public String getLibelleDossierFiche() {
      return this.libelleDossierFiche;
   }

   public void setLibelleDossierFiche(String var1) {
      this.libelleDossierFiche = var1;
   }

   public String getInpAnal() {
      return this.inpAnal;
   }

   public void setInpAnal(String var1) {
      this.inpAnal = var1;
   }

   public String getNomPiecesJointes() {
      return this.nomPiecesJointes;
   }

   public void setNomPiecesJointes(String var1) {
      this.nomPiecesJointes = var1;
   }

   public FileCtrl getFileCtrl() {
      return this.fileCtrl;
   }

   public void setFileCtrl(FileCtrl var1) {
      this.fileCtrl = var1;
   }

   public DataModel getDataModelPieceJointes() {
      return this.dataModelPieceJointes;
   }

   public void setDataModelPieceJointes(DataModel var1) {
      this.dataModelPieceJointes = var1;
   }

   public boolean isShowModalPanelAjoutScan() {
      return this.showModalPanelAjoutScan;
   }

   public void setShowModalPanelAjoutScan(boolean var1) {
      this.showModalPanelAjoutScan = var1;
   }

   public boolean isShowModalPanelScan() {
      return this.showModalPanelScan;
   }

   public void setShowModalPanelScan(boolean var1) {
      this.showModalPanelScan = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public List getLisTaxesAchats() {
      return this.lisTaxesAchats;
   }

   public void setLisTaxesAchats(List var1) {
      this.lisTaxesAchats = var1;
   }

   public boolean isVar_anal_chantier() {
      return this.var_anal_chantier;
   }

   public void setVar_anal_chantier(boolean var1) {
      this.var_anal_chantier = var1;
   }

   public int getVar_imput_choix() {
      return this.var_imput_choix;
   }

   public void setVar_imput_choix(int var1) {
      this.var_imput_choix = var1;
   }

   public String getVar_imput_num() {
      return this.var_imput_num;
   }

   public void setVar_imput_num(String var1) {
      this.var_imput_num = var1;
   }
}
