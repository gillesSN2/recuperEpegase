package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DocumentTraceAchatsDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FormulesAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
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
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
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

public class FormFactureAchats implements Serializable {
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
   private boolean reglementAutorise = false;
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
   private FactureEnteteAchats factureEnteteAchats = new FactureEnteteAchats();
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
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
   private FactureLigneAchats factureLigneAchats = new FactureLigneAchats();
   private FactureLigneAchatsDao factureLigneAchatsDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
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
   private Unite unite;
   private UniteDao uniteDao;
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
   private double inpMontant = 0.0D;
   private String inpNumFacture = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
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
   private String var_inpModeleImp;
   private DocumentTraceAchats documentTraceAchats;
   private String libelleDossier;
   private String libelleDossierFiche;
   private PlansAnalytiques dossier = new PlansAnalytiques();
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean var_anal_chantier = false;
   private List mesBudgetsItems;
   private List mesTypeReglementsCaisse = new ArrayList();
   private List listCaisses;
   private List mesCaissesSeriesItems = new ArrayList();
   private BonDecaissementAchat bonDecaissementAchat;
   private BonDecaissementAchatDao bonDecaissementAchatDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_be = false;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private double totalPayerTimbre;
   private ReglementsDao reglementsDao;
   private boolean afficheRecu;
   private transient DataModel datamodelRecu = new ListDataModel();
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private boolean showModalPanelReglement = false;
   private List listFactureSelectionne = new ArrayList();
   private Reglements reglements;
   private Reglements memoReglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_objet;
   private String var_banque_tireur;
   private String var_num_cheque;
   private List mesModesleRecus = new ArrayList();
   private String nomRepMod;
   private double val_timbre;
   private double var_ecart_reglement;
   private String var_banque_destination;
   private boolean var_affiche_banque_destination = false;
   private List mesBanquesItems = new ArrayList();
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean repartitionManuelle;
   private double totManuel;
   private double ecartManuel;
   private boolean showModalPanelPrintRecu = false;
   private boolean showModalPanelHistoReglement = false;
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
   private transient DataModel dataModelEcriture = new ListDataModel();
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
   private transient DataModel dataModelPieceJointes = new ListDataModel();
   private List lesPiecesJointes = new ArrayList();
   private boolean showModalPanelAjoutScan = false;
   private String cheminPieceJointes;
   private String nomPiecesJointes;
   private boolean showModalPanelScan = false;
   private String fichierMine;
   private URL fichierUrl;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload = new UtilDownload();
   private String urlExplorateur;
   private FileCtrl fileCtrl;
   private int typeFichier;

   public FormFactureAchats() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneAchatsDao = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
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
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceAchatsDao = new DocumentTraceAchatsDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonDecaissementAchatDao = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionAchats.getPaiementAVOIR().equalsIgnoreCase("0")) {
         this.reglementAutorise = true;
      } else {
         this.reglementAutorise = false;
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

      this.periode = this.optionAchats.getAffichInGlobViewFAC();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.cheminPieceJointes = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "factureAchat" + File.separator;
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
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void recupererBudgetItem() throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      PlansBudgetairesDao var1 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      String var2 = "" + this.lastExoCompta.getExecpt_id();
      if (this.factureEnteteAchats.getFcfActivite() != null && !this.factureEnteteAchats.getFcfActivite().isEmpty() && this.factureEnteteAchats.getFcfActivite().contains(":")) {
         String[] var3 = this.factureEnteteAchats.getFcfActivite().split(":");
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
      this.factureEnteteAchats = this.factureEnteteAchatsDao.pourParapheur(var1, (Session)null);
      if (this.factureEnteteAchats != null) {
         this.lesLignesList = this.factureLigneAchatsDao.chargerLesLignes(this.factureEnteteAchats, (Session)null);
      }

   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
         this.inpDossier = "";
         this.inpAnal = "";
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpDossier = "";
         this.inpAnal = "";
         this.inpResponsable = "";
         this.inpBudget = "100";
         this.inpActivite = "100";
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
         this.lesEntetesList = this.factureEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.getInpNum(), this.getInpNumFacture(), this.getInpMontant(), this.getInpIdTiersEnCours(), this.getInpFournisseur(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.getInpBudget(), this.getInpResponsable(), this.getInpActivite(), var10, var11, this.getInpDossier(), this.getInpAnal());
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new FactureEnteteAchats();

         for(int var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            FactureEnteteAchats var12 = (FactureEnteteAchats)this.lesEntetesList.get(var13);
            var2 += var12.getFcfTotTtc();
            var4 += var12.getFcfTotReglement();
            var6 += var12.getFcfTotHt();
            var8 += var12.getFcfTotTva();
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
            this.factureEnteteAchats = (FactureEnteteAchats)var1.get(0);
            this.inpNomTiersEnCours = this.factureEnteteAchats.getFcfNomTiers();
            this.inpIdTiersEnCours = this.factureEnteteAchats.getTiers().getTieid();
            this.var_date = this.factureEnteteAchats.getFcfDate();
            if (this.factureEnteteAchats.getFcfDate().getHours() <= 9) {
               this.var_heure = "0" + this.factureEnteteAchats.getFcfDate().getHours();
            } else {
               this.var_heure = "" + this.factureEnteteAchats.getFcfDate().getHours();
            }

            if (this.factureEnteteAchats.getFcfDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.factureEnteteAchats.getFcfDate().getMinutes();
            } else {
               this.var_minute = "" + this.factureEnteteAchats.getFcfDate().getMinutes();
            }

            if (this.factureEnteteAchats.getFcfDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.factureEnteteAchats.getFcfDate().getSeconds();
            } else {
               this.var_seconde = "" + this.factureEnteteAchats.getFcfDate().getSeconds();
            }

            this.tiers = this.factureEnteteAchats.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.factureEnteteAchats.getFcfIdContact();
            this.var_nom_responsable = this.factureEnteteAchats.getFcfIdResponsable();
            this.calculDevise();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
            this.chargerDocumentLigne(var6);
            this.chargerDossierAffaire(var6);
            double var4 = this.chargerBonEncaissement(var6);
            this.chargerDocumentTrace(var6);
            this.chargerLesContactsItem(var6);
            this.chargerUserChrono(var6);
            this.chargerLesUsers(var6);
            this.chargerParapheur(var6);
            this.accesPiecesJointes();
            this.chargerModeEcheanceAffichage();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.verrouNum = true;
            this.visibiliteBton = true;
            this.utilInitHibernate.closeSession();
            if (this.optionAchats.getPaiementAVOIR().equals("0")) {
               this.factureEnteteAchats.setFcfTotReglement(var4);
               if (var4 >= this.factureEnteteAchats.getFcfTotTtc() + this.factureEnteteAchats.getFcfTotTimbre()) {
                  this.factureEnteteAchats.setFcfSolde(1);
               } else {
                  this.factureEnteteAchats.setFcfSolde(0);
               }

               this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats);
            }

            this.setMontantTtcElmt(this.factureEnteteAchats.getFcfTotTtc());
            this.setMontantReglementElmt(this.factureEnteteAchats.getFcfTotReglement());
            this.setMontantElmTotBonEnc(this.factureEnteteAchats.getFcfTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.factureEnteteAchats.getFcfTotTtc() - this.factureEnteteAchats.getFcfTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.factureEnteteAchats != null) {
         if (this.factureEnteteAchats.getFcfEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() throws HibernateException, NamingException {
      this.factureEnteteAchats.setFcfCoefDevise(0.0F);
      this.calculDevise((Session)null);
   }

   public void calculDevise(Session var1) throws HibernateException, NamingException {
      if (this.factureEnteteAchats.getFcfDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.factureEnteteAchats.getFcfDevise());
         if (this.factureEnteteAchats.getFcfDevise().equals(this.structureLog.getStrdevise())) {
            this.factureEnteteAchats.setFcfCoefDevise(1.0F);
         } else if (this.factureEnteteAchats.getFcfCoefDevise() == 0.0F) {
            new ObjetDevises();
            LectureDevises var3 = new LectureDevises();
            new Devise();
            DeviseDao var5 = new DeviseDao(this.baseLog, this.utilInitHibernate);
            Devise var4 = var5.chargerLesDevises(this.factureEnteteAchats.getFcfDevise(), var1);
            ObjetDevises var2;
            float var6;
            float var7;
            float var8;
            float var9;
            if (var4 != null) {
               var6 = var4.getDevTaux1();
               var7 = var4.getDevTaux2();
               var2 = var3.devisesRecherchee(this.factureEnteteAchats.getFcfDevise(), this.structureLog.getStrdevise());
               var8 = Float.parseFloat(var2.getTaux1());
               var9 = Float.parseFloat(var2.getTaux2());
               this.factureEnteteAchats.setFcfCoefDevise(var6 * var9);
            } else {
               this.factureEnteteAchats.setFcfCoefDevise(1.0F);
            }

            if (this.factureEnteteAchats.getFcfCoefDevise() == 0.0F) {
               var2 = var3.devisesRecherchee("EUR", this.structureLog.getStrdevise());
               var6 = Float.parseFloat(var2.getTaux1());
               var7 = Float.parseFloat(var2.getTaux2());
               var2 = var3.devisesRecherchee(this.factureEnteteAchats.getFcfDevise(), this.structureLog.getStrdevise());
               var8 = Float.parseFloat(var2.getTaux1());
               var9 = Float.parseFloat(var2.getTaux2());
               this.factureEnteteAchats.setFcfCoefDevise(var6 * var9);
            }
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.factureEnteteAchats.getFcfId() > 0L) {
         this.lesLignesList = this.factureLigneAchatsDao.chargerLesLignes(this.factureEnteteAchats, var1);
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

      if (this.factureEnteteAchats != null && this.factureEnteteAchats.getFcfAnal4() != null && !this.factureEnteteAchats.getFcfAnal4().isEmpty()) {
         this.dossier = this.plansAnalytiquesDao.rechercheAffaire(this.factureEnteteAchats.getFcfAnal4(), var1);
         if (this.dossier != null && this.dossier.getAnaNature() != null && !this.dossier.getAnaNature().isEmpty()) {
            if (this.dossier.getAnaNature().equals("6")) {
               this.libelleDossierFiche = "N° Dossier";
            } else if (this.dossier.getAnaNature().equals("10")) {
               this.libelleDossierFiche = "N° Affaire";
            }
         }
      }

   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonDecaissementAchatDao.rechercheBeByDoc(this.factureEnteteAchats.getFcfId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonDecaissementAchat)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonDecaissementAchat)var2.get(var3)).getBonAPayer();
            }
         }
      }

      double var7 = 0.0D;
      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.factureEnteteAchats.getFcfId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = true;

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            var7 += ((Reglements)var5.get(var6)).getRglDepense();
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var6)).getRglDepense();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.factureEnteteAchats.getFcfTotTtc() + this.factureEnteteAchats.getFcfTotTc()) {
         if (this.usersLog.getUsrFactureDeCaisse() == 1) {
            this.var_affiche_be = true;
            this.var_affiche_dollar = false;
         } else if (this.usersLog.getUsrFactureDeCaisse() == 2) {
            this.var_affiche_be = false;
            this.var_affiche_dollar = true;
         } else if (this.usersLog.getUsrFactureDeCaisse() == 3) {
            this.var_affiche_be = true;
            this.var_affiche_dollar = true;
         } else {
            this.var_affiche_be = false;
            this.var_affiche_dollar = false;
         }
      } else {
         this.var_affiche_be = false;
         this.var_affiche_dollar = false;
      }

      return var7;
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      new ArrayList();
      ArrayList var4 = new ArrayList();
      new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      ArrayList var8 = new ArrayList();
      new ArrayList();
      ArrayList var10 = new ArrayList();
      new ArrayList();
      new ArrayList();
      ArrayList var13 = new ArrayList();
      ArrayList var14 = new ArrayList();
      new ArrayList();
      ArrayList var16 = new ArrayList();
      if (this.factureEnteteAchats.getFcfId() > 0L) {
         List var12 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(this.factureEnteteAchats.getFcfId(), this.nature, var1);
         if (var12.size() == 0) {
            var12 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(this.factureEnteteAchats.getFcfId(), this.nature, var1);
         }

         int var17;
         int var18;
         for(var17 = 0; var17 < var12.size(); ++var17) {
            List var9 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var12.get(var17)).getDoctrfOrgId(), ((DocumentTraceAchats)var12.get(var17)).getDoctrfOrgType(), var1);
            if (var9.size() != 0) {
               for(var18 = 0; var18 < var9.size(); ++var18) {
                  var8.add(var9.get(var18));
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
            List var5 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var6.get(var17)).getDoctrfOrgId(), ((DocumentTraceAchats)var6.get(var17)).getDoctrfOrgType(), var1);
            if (var5.size() != 0) {
               for(var18 = 0; var18 < var5.size(); ++var18) {
                  var4.add(var5.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var4.size(); ++var17) {
            List var3 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var4.get(var17)).getDoctrfOrgId(), ((DocumentTraceAchats)var4.get(var17)).getDoctrfOrgType(), var1);
            if (var3.size() != 0) {
               for(var18 = 0; var18 < var3.size(); ++var18) {
                  var2.add(var3.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var12.size(); ++var17) {
            List var15 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var12.get(var17)).getDoctrfOrgId(), 26, var1);
            if (var15.size() != 0) {
               for(var18 = 0; var18 < var15.size(); ++var18) {
                  var14.add(var15.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var8.size(); ++var17) {
            List var11 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var8.get(var17)).getDoctrfOrgId(), 24, var1);
            if (var11.size() != 0) {
               for(var18 = 0; var18 < var11.size(); ++var18) {
                  var10.add(var11.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var2.size(); ++var17) {
            var16.add(var2.get(var17));
         }

         for(var17 = 0; var17 < var4.size(); ++var17) {
            var16.add(var4.get(var17));
         }

         for(var17 = 0; var17 < var6.size(); ++var17) {
            var16.add(var6.get(var17));
         }

         for(var17 = 0; var17 < var8.size(); ++var17) {
            var16.add(var8.get(var17));
         }

         for(var17 = 0; var17 < var10.size(); ++var17) {
            var16.add(var10.get(var17));
         }

         for(var17 = 0; var17 < var12.size(); ++var17) {
            var16.add(var12.get(var17));
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

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null && this.factureEnteteAchats.getFcfSerie() != null && !this.factureEnteteAchats.getFcfSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.factureEnteteAchats.getFcfSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.factureEnteteAchats.getFcfId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.factureEnteteAchats.getFcfId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.factureEnteteAchats.getFcfActivite() != null && !this.factureEnteteAchats.getFcfActivite().isEmpty() && this.factureEnteteAchats.getFcfActivite().contains(":")) {
         String[] var1 = null;
         if (!this.factureEnteteAchats.getFcfActivite().contains("#")) {
            var1 = this.factureEnteteAchats.getFcfActivite().split(":");
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
            String[] var2 = this.factureEnteteAchats.getFcfActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.factureEnteteAchats.getFcfTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.factureEnteteAchats.getFcfTotHt() - this.totalImputation;
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
      new FactureEnteteAchats();
      FactureEnteteAchats var1 = this.factureEnteteAchatsDao.rechercheAnal4(this.factureEnteteAchats.getFcfAnal4(), (Session)null);
      if (var1 != null) {
         this.factureEnteteAchats.setFcfAnal4("");
      }

   }

   public void ajoutDocument() throws IOException, JDOMException {
      this.factureEnteteAchats = new FactureEnteteAchats();
      this.factureLigneAchats = new FactureLigneAchats();
      this.factureEnteteAchats.setUsers(this.usersLog);
      this.factureEnteteAchats.setFcfIdCreateur(this.usersLog.getUsrid());
      this.factureEnteteAchats.setFcfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.factureEnteteAchats.setFcfIdResponsable(this.usersLog.getUsrid());
      this.factureEnteteAchats.setFcfNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.factureEnteteAchats.setFcfDate(new Date());
      this.factureEnteteAchats.setFcfCat("Local");
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
      if (this.optionAchats.getAxeDossier().equals("1")) {
         this.libelleDossierFiche = "N° Dossier";
      } else if (this.optionAchats.getAxeDossier().equals("2")) {
         this.libelleDossierFiche = "N° Affaire";
      } else {
         this.libelleDossierFiche = "N° Dossier";
      }

      this.autorisationDocument();
      this.addLigne();
   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionAchats.getNbrJrRelanceFAC() != null && !this.optionAchats.getNbrJrRelanceFAC().isEmpty()) {
         var3 = Integer.parseInt(this.optionAchats.getNbrJrRelanceFAC());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionAchats.getNbrJrValidFAC() != null && !this.optionAchats.getNbrJrValidFAC().isEmpty()) {
         var4 = Integer.parseInt(this.optionAchats.getNbrJrValidFAC());
      } else {
         var4 = 0;
      }

      this.factureEnteteAchats.setFcfDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.factureEnteteAchats.setFcfDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
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
            this.mesUsersItem.add(new SelectItem(this.factureEnteteAchats.getFcfIdResponsable(), this.factureEnteteAchats.getFcfNomResponsable()));
         }

         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.factureEnteteAchats != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.factureEnteteAchats.getFcfIdResponsable(), this.factureEnteteAchats.getFcfNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteAchats.getFcfEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.factureEnteteAchats.setFcfEtat(1);
               this.factureEnteteAchats.setFcfDateValide(new Date());
               this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle facture (F.) N° " + this.factureEnteteAchats.getFcfNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteAchats.getFcfDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument5() == null || this.factureEnteteAchats.getFcfDate().after(this.tiers.getTieDteDocument5())) {
               this.tiers.setTieDteDocument5(this.factureEnteteAchats.getFcfDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
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

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteAchats.getFcfEtat() == 1) {
               this.factureEnteteAchats.setFcfEtat(0);
               this.factureEnteteAchats.setFcfDateValide((Date)null);
               this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
               new ArrayList();
               List var3 = this.bonDecaissementAchatDao.rechercheBeByDoc(this.factureEnteteAchats.getFcfId(), this.nature, var1);
               if (var3.size() != 0) {
                  for(int var4 = 0; var4 < var3.size(); ++var4) {
                     this.bonDecaissementAchat = (BonDecaissementAchat)var3.get(var4);
                     this.bonDecaissementAchatDao.delete(this.bonDecaissementAchat, var1);
                  }
               }

               this.var_tot_bon_encaissement = 0.0D;
               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Dévalidation manuelle facture (F.) N° " + this.factureEnteteAchats.getFcfNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteAchats.getFcfDate()));
               this.espionDao.mAJEspion(var10, var1);
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

   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
         this.factureEnteteAchats.setFcfEtat(0);
         this.factureEnteteAchats.setFcfDateAnnule((Date)null);
         this.factureEnteteAchats.setFcfMotifAnnule("");
         this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException, ParseException {
      if (this.factureEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.factureEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.factureEnteteAchats.getFcfId();
            String var5 = this.factureEnteteAchats.getFcfNum();
            Date var6 = this.factureEnteteAchats.getFcfDate();
            this.factureLigneAchatsDao.deleteAllLigne(this.factureEnteteAchats, var1);
            this.utilParapheur.supprimerParapheur(this.factureEnteteAchats.getFcfId(), this.nature, var1);
            this.factureEnteteAchatsDao.delete(this.factureEnteteAchats.getFcfId(), var1);
            this.documentTraceAchats = new DocumentTraceAchats();
            this.documentTraceAchats = this.documentTraceAchatsDao.chercherDestinationTrace(var3, this.nature, var1);
            if (this.documentTraceAchats != null) {
               long var7 = this.documentTraceAchats.getDoctrfOrgId();
               int var9 = this.documentTraceAchats.getDoctrfOrgType();
               this.documentTraceAchatsDao.delete(this.documentTraceAchats, var1);
               boolean var10 = false;
               this.documentTraceAchats = this.documentTraceAchatsDao.chercherOrigineTrace(var7, var9, var1);
               byte var18;
               if (this.documentTraceAchats != null) {
                  var18 = 4;
               } else {
                  var18 = 1;
               }

               if (var9 == 13) {
                  new ReceptionEnteteAchats();
                  ReceptionEnteteAchatsDao var12 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  ReceptionEnteteAchats var11 = var12.pourParapheur(var7, var1);
                  if (var11 != null) {
                     var11.setRecEtat(var18);
                     if (var18 == 1) {
                        var11.setRecDateTransforme((Date)null);
                        var11.setRecTypeTransforme(0);
                     }

                     var12.modif(var11, var1);
                  }
               }
            }

            Espion var19 = new Espion();
            var19.setUsers(this.usersLog);
            var19.setEsptype(0);
            var19.setEspdtecreat(new Date());
            var19.setEspaction("Suppression facture achat N° " + var5 + " du " + var6);
            this.espionDao.mAJEspion(var19, var1);
            var2.commit();
         } catch (HibernateException var16) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargeListeDetail((Session)null);
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.factureEnteteAchats.getFcfId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.factureEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.factureEnteteAchats.setUsers(this.usersLog);
            this.factureEnteteAchats.setFcfIdCreateur(this.usersLog.getUsrid());
            this.factureEnteteAchats.setFcfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.factureEnteteAchats.setFcfDate(new Date());
            this.factureEnteteAchats.setFcfDateCreat(new Date());
            this.factureEnteteAchats.setFcfDateModif((Date)null);
            this.factureEnteteAchats.setFcfIdModif(0L);
            this.factureEnteteAchats.setFcfNomModif("");
            this.factureEnteteAchats.setFcfNum("");
            this.factureEnteteAchats.setFcfIdResponsable(this.usersLog.getUsrid());
            this.factureEnteteAchats.setFcfNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            if (!this.factureEnteteAchats.getFcfSerie().equalsIgnoreCase("X") && !this.factureEnteteAchats.getFcfSerie().isEmpty()) {
               this.factureEnteteAchats.setFcfNum(this.calculChrono.numCompose(this.factureEnteteAchats.getFcfDate(), this.nature, this.factureEnteteAchats.getFcfSerie(), var1));
            } else {
               long var3 = this.factureEnteteAchatsDao.selectLastNum(var1);
               this.factureEnteteAchats.setFcfNum("" + var3);
            }

            this.verifieExistenceHabilitation(var1);
            this.factureEnteteAchats.setFcfDateAnnule((Date)null);
            this.factureEnteteAchats.setFcfMotifAnnule("");
            this.factureEnteteAchats.setFcfDateImp((Date)null);
            this.factureEnteteAchats.setFcfDateTransforme((Date)null);
            this.factureEnteteAchats.setFcfDateTransfert((Date)null);
            this.factureEnteteAchats.setFcfTotReglement(0.0D);
            this.factureEnteteAchats.setFcfSolde(0);
            this.factureEnteteAchats.setFcfEtat(0);
            this.factureEnteteAchats = this.factureEnteteAchatsDao.duppliquer(this.factureEnteteAchats, var1);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureEnteteAchats.getFcfId(), this.factureEnteteAchats.getFcfNum(), this.factureEnteteAchats.getFcfNomTiers(), this.factureEnteteAchats.getFcfDate(), this.factureEnteteAchats.getFcfDevise(), this.factureEnteteAchats.getFcfTotTtc() + this.factureEnteteAchats.getFcfTotTc(), this.factureEnteteAchats.getFcfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var1), this.calculeParc(var1), this.factureEnteteAchats.getVar_format_devise(), 0, var1);
            }

            if (this.lesLignesList.size() != 0) {
               this.factureLigneAchatsDao.duppliquerLigne(this.lesLignesList, this.factureEnteteAchats, var1);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.factureEnteteAchats.getFcfTypeTransforme() != 0) {
            var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.factureEnteteAchats.getFcfTypeTransforme(), var1);
            if (var3) {
               String var4 = "";
               if (this.factureEnteteAchats.getFcfTypeTransforme() == 12) {
                  var4 = "Commande";
               } else if (this.factureEnteteAchats.getFcfTypeTransforme() == 13) {
                  var4 = "Réception";
               } else if (this.factureEnteteAchats.getFcfTypeTransforme() == 14) {
                  var4 = "Bon retour";
               } else if (this.factureEnteteAchats.getFcfTypeTransforme() == 15) {
                  var4 = "Facture";
               } else if (this.factureEnteteAchats.getFcfTypeTransforme() == 16) {
                  var4 = "Avoir";
               } else if (this.factureEnteteAchats.getFcfTypeTransforme() == 17) {
                  var4 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.factureEnteteAchats.getFcfTypeTransforme(), var4));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 16, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(16, "Avoir"));
            }
         }

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            new FactureEnteteAchats();
            FactureEnteteAchats var5 = (FactureEnteteAchats)this.lesEntetesList.get(var8);
            if (var5.getFcfId() > 0L && var5.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.factureLigneAchatsDao.chargerLesLignes(var5, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new FactureLigneAchats();
                     FactureLigneAchats var7 = (FactureLigneAchats)this.lesLignesList.get(var6);
                     this.documentDetailTrf.add(var7);
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
      if (this.factureEnteteAchats.getFcfTypeReg() != 0 && this.factureEnteteAchats.getFcfTypeReg() != 3) {
         if (this.factureEnteteAchats.getFcfTypeReg() != 1 && this.factureEnteteAchats.getFcfTypeReg() != 2 && this.factureEnteteAchats.getFcfTypeReg() != 10) {
            if (this.factureEnteteAchats.getFcfTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.factureEnteteAchats.getFcfModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.factureEnteteAchats.getFcfModeReg() != null && !this.factureEnteteAchats.getFcfModeReg().isEmpty() && this.factureEnteteAchats.getFcfModeReg().contains(":")) {
         String[] var2 = this.factureEnteteAchats.getFcfModeReg().split(":");
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

            this.factureEnteteAchats.setFcfTypeReg(Integer.parseInt(var3.getEcheances()));
            this.factureEnteteAchats.setFcfModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.factureEnteteAchats.setFcfNbJourReg(0);
            this.factureEnteteAchats.setFcfArrondiReg(0);
            break;
         }
      }

      if (this.factureEnteteAchats.getFcfTypeReg() != 0 && this.factureEnteteAchats.getFcfTypeReg() != 3) {
         if (this.factureEnteteAchats.getFcfTypeReg() != 1 && this.factureEnteteAchats.getFcfTypeReg() != 2 && this.factureEnteteAchats.getFcfTypeReg() != 10) {
            if (this.factureEnteteAchats.getFcfTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementFournisseurListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.factureEnteteAchats.setFcfTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.factureEnteteAchats.setFcfModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.factureEnteteAchats.setFcfNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.factureEnteteAchats.setFcfArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.factureEnteteAchats.getFcfModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.factureEnteteAchats.getFcfDate(), this.factureEnteteAchats.getFcfTypeReg(), this.factureEnteteAchats.getFcfNbJourReg(), this.factureEnteteAchats.getFcfArrondiReg());
      this.factureEnteteAchats.setFcfDateEcheReg(var1);
   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.factureEnteteAchats.getFcfDevise().equals(this.structureLog.getStrdevise())) {
            this.factureEnteteAchats.setFcfTotHtLocal(this.factureEnteteAchats.getFcfTotHt());
            this.factureEnteteAchats.setFcfTotTvaLocal(this.factureEnteteAchats.getFcfTotTva());
            this.factureEnteteAchats.setFcfTotTtcLocal(this.factureEnteteAchats.getFcfTotTtc());
            this.factureEnteteAchats.setFcfTotRemiseLocal(this.factureEnteteAchats.getFcfTotRemise());
            this.factureEnteteAchats.setFcfTotRabaisLocal(this.factureEnteteAchats.getFcfTotRabais());
         } else {
            if (this.factureEnteteAchats.getFcfCoefDevise() == 0.0F) {
               new ObjetDevises();
               LectureDevises var4 = new LectureDevises();
               ObjetDevises var3 = var4.devisesRecherchee(this.factureEnteteAchats.getFcfDevise(), this.structureLog.getStrdevise());
               float var5 = Float.parseFloat(var3.getTaux1());
               float var6 = Float.parseFloat(var3.getTaux2());
               var3 = var4.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
               float var7 = Float.parseFloat(var3.getTaux1());
               float var8 = Float.parseFloat(var3.getTaux2());
               float var9 = var6 * var7;
               this.factureEnteteAchats.setFcfCoefDevise(var9);
            }

            this.factureEnteteAchats.setFcfTotHtLocal(this.utilNombre.myRoundDevise(this.factureEnteteAchats.getFcfTotHt() * (double)this.factureEnteteAchats.getFcfCoefDevise(), this.structureLog.getStrdevise()));
            this.factureEnteteAchats.setFcfTotTvaLocal(this.utilNombre.myRoundDevise(this.factureEnteteAchats.getFcfTotTva() * (double)this.factureEnteteAchats.getFcfCoefDevise(), this.structureLog.getStrdevise()));
            this.factureEnteteAchats.setFcfTotTtcLocal(this.utilNombre.myRoundDevise(this.factureEnteteAchats.getFcfTotTtc() * (double)this.factureEnteteAchats.getFcfCoefDevise(), this.structureLog.getStrdevise()));
            this.factureEnteteAchats.setFcfTotRemiseLocal(this.utilNombre.myRoundDevise(this.factureEnteteAchats.getFcfTotRemise() * (double)this.factureEnteteAchats.getFcfCoefDevise(), this.structureLog.getStrdevise()));
            this.factureEnteteAchats.setFcfTotRabaisLocal(this.utilNombre.myRoundDevise(this.factureEnteteAchats.getFcfTotRabais() * (double)this.factureEnteteAchats.getFcfCoefDevise(), this.structureLog.getStrdevise()));
         }

         this.factureEnteteAchats.setFcfDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.factureEnteteAchats.getUsers() == null) {
            this.factureEnteteAchats.setUsers(this.usersLog);
         }

         this.factureEnteteAchats.setTiers(this.tiers);
         if ((this.factureEnteteAchats.getFcfCat() == null || this.factureEnteteAchats.getFcfCat().isEmpty()) && this.factureEnteteAchats.getTiers().getTienomfamille() != null && !this.factureEnteteAchats.getTiers().getTienomfamille().isEmpty()) {
            this.factureEnteteAchats.setFcfCat(this.factureEnteteAchats.getTiers().getTienomfamille());
         }

         if (!this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.factureEnteteAchats.setFcfCivilTiers("");
         } else {
            this.factureEnteteAchats.setFcfCivilTiers(this.factureEnteteAchats.getTiers().getTiecivilite());
         }

         if (this.factureEnteteAchats.getFcfDiversTiers() == 99) {
            this.factureEnteteAchats.setFcfIdContact(0L);
            this.factureEnteteAchats.setFcfNomContact("");
            this.factureEnteteAchats.setFcfCivilContact("");
         } else {
            new Contacts();
            Contacts var15 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
            if (var15 != null) {
               this.factureEnteteAchats.setFcfIdContact(var15.getConid());
               this.factureEnteteAchats.setFcfNomContact(var15.getConpatronyme());
               this.factureEnteteAchats.setFcfCivilContact(var15.getConcivilite());
            } else {
               this.factureEnteteAchats.setFcfIdContact(0L);
               this.factureEnteteAchats.setFcfNomContact("");
               this.factureEnteteAchats.setFcfCivilContact("");
            }
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var16 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var16 != null) {
            this.factureEnteteAchats.setFcfIdResponsable(var16.getUsrid());
            this.factureEnteteAchats.setFcfNomResponsable(var16.getUsrPatronyme());
         } else {
            this.factureEnteteAchats.setFcfIdResponsable(0L);
            this.factureEnteteAchats.setFcfNomResponsable("");
         }

         if (this.factureEnteteAchats.getFcfId() != 0L) {
            if (this.factureEnteteAchats.getFcfEtat() == 6) {
               if (this.factureEnteteAchats.getFcfEtatVal() == 1) {
                  this.factureEnteteAchats.setFcfEtat(0);
               } else {
                  this.factureEnteteAchats.setFcfEtat(0);
               }
            }

            this.factureEnteteAchats.setFcfDateModif(new Date());
            this.factureEnteteAchats.setFcfIdModif(this.usersLog.getUsrid());
            this.factureEnteteAchats.setFcfNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.factureEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.factureEnteteAchats.setFcfDateCreat(new Date());
            this.factureEnteteAchats.setFcfIdCreateur(this.usersLog.getUsrid());
            this.factureEnteteAchats.setFcfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.factureEnteteAchats.getFcfSerie() != null && !this.factureEnteteAchats.getFcfSerie().equalsIgnoreCase("X") && !this.factureEnteteAchats.getFcfSerie().isEmpty()) {
               this.factureEnteteAchats.setFcfNum(this.calculChrono.numCompose(this.factureEnteteAchats.getFcfDate(), this.nature, this.factureEnteteAchats.getFcfSerie(), var1));
               boolean var18 = false;

               label257:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label257;
                     }

                     new FactureEnteteAchats();
                     FactureEnteteAchats var19 = this.factureEnteteAchatsDao.pourParapheur(this.factureEnteteAchats.getFcfNum(), this.factureEnteteAchats.getFcfSerie(), var1);
                     if (var19 != null) {
                        long var20 = 100000000L * this.usersLog.getUsrid();

                        for(long var21 = 0L; var21 < var20; ++var21) {
                        }

                        this.factureEnteteAchats.setFcfNum(this.calculChrono.numCompose(this.factureEnteteAchats.getFcfDate(), this.nature, this.factureEnteteAchats.getFcfSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.factureEnteteAchatsDao.selectLastNum(var1);
               this.factureEnteteAchats.setFcfNum("" + var17);
            }

            this.factureEnteteAchats.setFcfEtat(0);
            this.factureEnteteAchats.setFcfEtatVal(0);
            this.factureEnteteAchats.setFcfDateValide((Date)null);
            this.factureEnteteAchats = this.factureEnteteAchatsDao.insert(this.factureEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.factureEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureEnteteAchats.getFcfId(), this.factureEnteteAchats.getFcfNum(), this.factureEnteteAchats.getFcfNomTiers(), this.factureEnteteAchats.getFcfDate(), this.factureEnteteAchats.getFcfDevise(), this.factureEnteteAchats.getFcfTotTtc() + this.factureEnteteAchats.getFcfTotTc(), this.factureEnteteAchats.getFcfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var1), this.calculeParc(var1), this.factureEnteteAchats.getVar_format_devise(), 0, var1);
         }

         var2.commit();
      } catch (HibernateException var13) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majAnalytique() throws HibernateException, NamingException {
      this.factureEnteteAchats.setFcfSite(this.usersLog.getUsrSite());
      this.factureEnteteAchats.setFcfDepartement(this.usersLog.getUsrDepartement());
      this.factureEnteteAchats.setFcfService(this.usersLog.getUsrService());
      this.factureEnteteAchats.setFcfRegion(this.tiers.getTieregion());
      this.factureEnteteAchats.setFcfSecteur(this.tiers.getTiesecteur());
      this.factureEnteteAchats.setFcfPdv(this.tiers.getTiepdv());
      if (!this.var_anal_activite) {
         this.factureEnteteAchats.setFcfActivite("");
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

            this.factureEnteteAchats.setFcfActivite(var1);
         }
      } else {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
         String var14 = "";
         boolean var15 = true;
         new FactureLigneAchats();
         new Produits();
         if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
            ArrayList var6 = new ArrayList();
            ObjetTarif var7 = new ObjetTarif();
            int var8 = 0;

            label111:
            while(true) {
               if (var8 >= this.lesLignesList.size()) {
                  var8 = 0;

                  while(true) {
                     if (var8 >= var6.size()) {
                        break label111;
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

               FactureLigneAchats var4 = (FactureLigneAchats)this.lesLignesList.get(var8);
               if (var4.getFcfligCode() != null && !var4.getFcfligCode().isEmpty()) {
                  Produits var5 = this.produitsDao.chargeProduit(var4.getFcfligCode(), var13);
                  if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                     if (var6.size() == 0) {
                        var7 = new ObjetTarif();
                        var7.setNomLibelle(var5.getProActivite());
                        var7.setPrix(var4.getFcfligPt());
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
                           var7.setPrix(var4.getFcfligPt());
                           var6.add(var7);
                        } else if (var9 && var7 != null) {
                           var7.setPrix(var10 + var4.getFcfligPt());
                           var6.remove(var7);
                           var6.add(var7);
                        }
                     }
                  }
               }

               ++var8;
            }
         }

         this.factureEnteteAchats.setFcfActivite(var14);
         this.utilInitHibernate.closeSession();
      }

      if (this.factureEnteteAchats.getFcfAnal4() != null && this.factureEnteteAchats.getFcfAnal4().length() <= 2) {
         this.factureEnteteAchats.setFcfAnal4("");
      }

      if (!this.var_anal_parc) {
         this.factureEnteteAchats.setFcfAnal2("");
      } else if (this.factureEnteteAchats.getFcfAnal2() != null && this.factureEnteteAchats.getFcfAnal2().length() <= 2) {
         this.factureEnteteAchats.setFcfAnal2("");
      }

      if (this.factureEnteteAchats.getFcfAnal1() != null && this.factureEnteteAchats.getFcfAnal1().length() <= 2) {
         this.factureEnteteAchats.setFcfAnal1("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.factureEnteteAchats.setFcfEtatVal(1);
         this.factureEnteteAchats.setFcfEtat(0);
         this.factureEnteteAchats.setFcfDateValide((Date)null);
         return true;
      } else {
         this.factureEnteteAchats.setFcfEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.factureEnteteAchats.setFcfEtat(1);
               this.factureEnteteAchats.setFcfDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.factureEnteteAchats.setFcfEtat(0);
               this.factureEnteteAchats.setFcfDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.factureEnteteAchats != null) {
         this.factureEnteteAchats.setFcfDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
         if (this.factureEnteteAchats.getFcfDateAnnule() == null) {
            this.factureEnteteAchats.setFcfDateAnnule(new Date());
         }

         this.factureEnteteAchats.setFcfEtat(3);
         this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation facture achat N° " + this.factureEnteteAchats.getFcfNum() + " le " + this.factureEnteteAchats.getFcfDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.factureEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculDisponibilite() throws HibernateException, NamingException {
      this.factureEnteteAchats.setFcfBudgetDispo(0.0D);
      this.factureEnteteAchats.setFcfBudgetDispoMois(0.0D);
      this.factureEnteteAchats.setFcfBudgetTreso(0.0D);
      this.factureEnteteAchats.setFcfBudgetTresoMois(0.0D);
      if (this.factureEnteteAchats.getFcfBudget() != null && this.factureEnteteAchats.getFcfBudget().contains(":")) {
         String var1 = "" + this.lastExoCompta.getExecpt_id();
         String[] var2 = this.factureEnteteAchats.getFcfBudget().split(":");
         String var3 = null;
         if (this.factureEnteteAchats.getFcfActivite() != null && !this.factureEnteteAchats.getFcfActivite().isEmpty()) {
            String[] var4 = this.factureEnteteAchats.getFcfActivite().split(":");
            var3 = var4[0];
         }

         int var27 = this.factureEnteteAchats.getFcfDate().getMonth() + 1;
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
         List var24 = var23.selectLesDisponibilites(this.lastExoCompta.getExecpt_id(), this.factureEnteteAchats.getFcfDate(), (Session)null);
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

         this.factureEnteteAchats.setFcfBudgetDispo(var5 - var28);
         this.factureEnteteAchats.setFcfBudgetDispoMois(var7 - var13);
         this.factureEnteteAchats.setFcfBudgetTreso(var15 - var19);
         this.factureEnteteAchats.setFcfBudgetTresoMois(var17 - var21);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      float var4 = 0.0F;
      String var5 = "";
      int var6 = 0;
      if (this.factureEnteteAchats.getFcfExoTva() == 0 || this.factureEnteteAchats.getFcfExoTva() == 2 || this.factureEnteteAchats.getFcfExoTva() == 3) {
         TaxesAchats var7;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesAchats();
            var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), var1, var3);
            if (var7 != null) {
               var4 = var7.getTaxachTaux();
               var5 = var7.getTaxachCode();
               var6 = var7.getTaxachType();
            } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
               new TaxesAchats();
               TaxesAchats var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
               if (var8 != null) {
                  var4 = var8.getTaxachTaux();
                  var5 = var8.getTaxachCode();
                  var6 = var8.getTaxachType();
               } else {
                  var4 = var2;
                  var5 = var1;
                  var6 = 0;
               }
            } else {
               var4 = var2;
               var5 = var1;
               var6 = 0;
            }
         } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
            new TaxesAchats();
            var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
            if (var7 != null) {
               var4 = var7.getTaxachTaux();
               var5 = var7.getTaxachCode();
               var6 = var7.getTaxachType();
            } else {
               var4 = var2;
               var5 = var1;
               var6 = 0;
            }
         } else {
            var4 = var2;
            var5 = var1;
            var6 = 0;
         }

         if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var4 = 0.0F;
            var5 = "";
            var6 = 0;
         }
      }

      this.factureLigneAchats.setFcfligTaxe(var5);
      this.factureLigneAchats.setFcfligTauxTaxe(var4);
      double var25 = this.factureLigneAchats.getFcfligPu();
      this.factureLigneAchats.setFcfligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.factureLigneAchats.getFcfligCondition(), this.factureLigneAchats.getFcfligQte(), this.factureLigneAchats.getFcfligLong(), this.factureLigneAchats.getFcfligLarg(), this.factureLigneAchats.getFcfligHaut(), this.factureLigneAchats.getFcfligDiam(), this.factureLigneAchats.getFcfligNb(), this.baseLog, this.utilInitHibernate, var3));
      double var9 = 0.0D;
      if (this.factureLigneAchats.getFcfligCondition() != null && !this.factureLigneAchats.getFcfligCondition().isEmpty() && this.factureLigneAchats.getFcfligCondition().contains(":")) {
         var9 = var25 * (double)this.factureLigneAchats.getFcfligQte();
      } else {
         var9 = var25 * (double)this.factureLigneAchats.getFcfligQte();
      }

      double var11 = 0.0D;
      double var13 = 0.0D;
      if (this.optionAchats.getDecrmtRabais().equals("1")) {
         var13 = this.factureLigneAchats.getFcfligRabais();
      } else if (this.optionAchats.getDecrmtRabais().equals("2")) {
         var13 = this.factureLigneAchats.getFcfligRabais() * (double)this.factureLigneAchats.getFcfligQte();
      }

      if (this.factureLigneAchats.getFcfligTauxRemise() != 0.0F) {
         var11 = var9 - var9 * (double)this.factureLigneAchats.getFcfligTauxRemise() / 100.0D - var13;
      } else {
         var11 = var9 - var13;
      }

      double var15 = this.utilNombre.myRoundFormat(var11, this.var_format_devise);
      double var17 = var15 * (double)this.factureLigneAchats.getFcfligTauxTaxe() / 100.0D;
      if (var6 == 2 || var6 == 3) {
         var17 = var15 * (double)(this.factureLigneAchats.getFcfligTauxTaxe() / 100.0F);
         var17 *= -1.0D;
      }

      double var19 = this.utilNombre.myRoundFormat(var17, this.var_format_devise);
      double var21 = var15 + var19;
      double var23 = 0.0D;
      if (this.factureLigneAchats.getFcfligCondition() != null && !this.factureLigneAchats.getFcfligCondition().isEmpty() && this.factureLigneAchats.getFcfligCondition().contains(":")) {
         var23 = this.utilNombre.myRound(var15 / (double)this.factureLigneAchats.getFcfligQteUtil(), 2);
      } else {
         var23 = this.utilNombre.myRound(var15 / (double)this.factureLigneAchats.getFcfligQteUtil(), 2);
      }

      this.factureLigneAchats.setFcfligPuRem(var23);
      this.factureLigneAchats.setFcfligPt(var15);
      this.factureLigneAchats.setFcfligTva(var19);
      this.factureLigneAchats.setFcfligTc(0.0D);
      this.factureLigneAchats.setFcfligTtc(var21);
   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.factureLigneAchats.getFcfligCondition() != null && !this.factureLigneAchats.getFcfligCondition().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      }

      this.calculPrix(this.factureLigneAchats.getFcfligTaxe(), this.factureLigneAchats.getFcfligTauxTaxe(), (Session)null);
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
         var5 = this.factureEnteteAchats.getFcfTotFretLocal() + this.factureEnteteAchats.getFcfTotFret2Local() + this.factureEnteteAchats.getFcfTotAssuranceLocal();
         var9 = this.factureEnteteAchats.getFcfTotFretLocal() + this.factureEnteteAchats.getFcfTotFret2Local() + this.factureEnteteAchats.getFcfTotAssuranceLocal();
      } else {
         var5 = 0.0D;
         var9 = 0.0D;
      }

      new FactureLigneAchats();

      for(int var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
         FactureLigneAchats var15 = (FactureLigneAchats)this.lesLignesList.get(var16);
         var1 += var15.getFcfligPt();
         var5 += var15.getFcfligTtc();
         var7 += var15.getFcfligTc();
         var3 += var15.getFcfligTva();
         var9 += var15.getFcfligPtDev();
         if (var15.getFcfligRabais() != 0.0D || var15.getFcfligTauxRemise() != 0.0F) {
            var11 += var15.getFcfligPu() * (double)var15.getFcfligQte() - var15.getFcfligPt();
         }

         var14 += var15.getFcfligQteUtil() * var15.getFcfligPoidsNet();
         var13 += var15.getFcfligQte();
      }

      this.factureEnteteAchats.setFcfTotHt(var1);
      this.factureEnteteAchats.setFcfTotTtc(var5);
      this.factureEnteteAchats.setFcfTotTc(var7);
      this.factureEnteteAchats.setFcfTotTva(var3);
      this.factureEnteteAchats.setFcfTotRemise(var11);
      this.factureEnteteAchats.setFcfTotPoidsBrut(var14);
      this.factureEnteteAchats.setFcfTotQte(var13);
      this.factureEnteteAchats.setFcfTotHtLocal(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesAchatsProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.factureLigneAchats = (FactureLigneAchats)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
         if (this.factureLigneAchats.getFcfligCode() != null && this.factureLigneAchats.getFcfligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.factureLigneAchats.getFcfligCode(), var1);
            if (this.produits != null) {
               this.factureLigneAchats.setFcfligCode(this.produits.getProCode());
               this.factureLigneAchats.setFcfligFamille(this.produits.getProAchCode());
               this.factureLigneAchats.setFcfligLong(this.produits.getProLongueur());
               this.factureLigneAchats.setFcfligLarg(this.produits.getProLargeur());
               this.factureLigneAchats.setFcfligHaut(this.produits.getProEpaisseur());
               this.factureLigneAchats.setFcfligDiam(this.produits.getProDiamExt());
               this.factureLigneAchats.setFcfligPoidsBrut(this.produits.getProPoidsBrut());
               this.factureLigneAchats.setFcfligPoidsNet(this.produits.getProPoidsNet());
               this.factureLigneAchats.setFcfligVolume(this.produits.getProVolume());
               this.factureLigneAchats.setFcfligNb(this.produits.getProNbUnite());
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
               if (this.var_sansstock && this.produits.getProStock() != 0) {
                  if (this.produits.getProDepotAch() != null && !this.produits.getProDepotAch().isEmpty()) {
                     new ProduitsDepot();
                     ProduitsDepot var6 = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.produits.getProDepotAch(), var1);
                     if (var6 != null) {
                        if (var6.getProdepCasier() != null && !var6.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var6.getDepot().getDpoCode() + ":" + var6.getProdepCasier() + "=" + (var6.getProdepQteStk() + var6.getProdepQteAttAch())));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var6.getDepot().getDpoCode() + "=" + (var6.getProdepQteStk() + var6.getProdepQteAttAch())));
                        }
                     }
                  } else {
                     new ArrayList();
                     List var5 = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
                     if (var5.size() != 0) {
                        for(int var3 = 0; var3 < var5.size(); ++var3) {
                           ProduitsDepot var4 = (ProduitsDepot)var5.get(var3);
                           if (var4.getProdepCasier() != null && !var4.getProdepCasier().isEmpty()) {
                              this.mesProduitsDepotsItems.add(new SelectItem(var4.getDepot().getDpoCode() + ":" + var4.getProdepCasier() + "=" + (var4.getProdepQteStk() + var4.getProdepQteAttAch())));
                           } else {
                              this.mesProduitsDepotsItems.add(new SelectItem(var4.getDepot().getDpoCode() + "=" + (var4.getProdepQteStk() + var4.getProdepQteAttAch())));
                           }
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

   public void addLigne() {
      this.produits = new Produits();
      this.factureLigneAchats = new FactureLigneAchats();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.factureEnteteAchats.getFcfId() == 0L) {
         this.save();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.factureLigneAchats.getFcfligQteUtil() == 0.0F) {
            this.factureLigneAchats.setFcfligQteUtil(this.factureLigneAchats.getFcfligQte());
         }

         this.calculPrix(this.factureLigneAchats.getFcfligTaxe(), this.factureLigneAchats.getFcfligTauxTaxe(), var1);
         if (this.factureLigneAchats.getFcfligCondition() != null && !this.factureLigneAchats.getFcfligCondition().isEmpty() && this.factureLigneAchats.getFcfligCondition().contains(":")) {
            ConditionnementDao var3 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            String[] var4 = this.factureLigneAchats.getFcfligCondition().split(":");
            String var5 = var3.rechercheConditionnement(var4[0], var1).getCdtDescription();
            if (var5 != null && !var5.isEmpty()) {
               this.factureLigneAchats.setFcfligDescription(var5);
            } else {
               this.factureLigneAchats.setFcfligDescription("");
            }
         } else {
            this.factureLigneAchats.setFcfligDescription("");
         }

         if (this.factureLigneAchats.getFcfligId() == 0L) {
            this.factureLigneAchats.setFactureEnteteAchats(this.factureEnteteAchats);
            this.factureLigneAchats.setFcfligDevise(this.factureEnteteAchats.getFcfDevise());
            this.factureLigneAchats = this.factureLigneAchatsDao.insertLigne(this.factureLigneAchats, var1);
            this.lesLignesList.add(this.factureLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         } else {
            this.factureLigneAchats = this.factureLigneAchatsDao.modifLigne(this.factureLigneAchats, var1);
         }

         if (this.produits != null && this.produits.getProId() != 0L && this.tiers != null) {
            this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
            if (this.produitsFournisseur == null) {
               this.produitsFournisseur = new ProduitsFournisseur();
            }

            this.produitsFournisseur.setProfouDevise(this.factureEnteteAchats.getFcfDevise());
            this.produitsFournisseur.setProfouFormat(this.factureEnteteAchats.getVar_format_devise());
            if ((this.produitsFournisseur.getProfouLib() == null || this.produitsFournisseur.getProfouLib().isEmpty()) && this.factureLigneAchats.getFcfligLibelleFournisseur() != null && !this.factureLigneAchats.getFcfligLibelleFournisseur().isEmpty()) {
               this.produitsFournisseur.setProfouLib(this.factureLigneAchats.getFcfligLibelleFournisseur());
            }

            if ((this.produitsFournisseur.getProfouRef() == null || this.produitsFournisseur.getProfouRef().isEmpty()) && this.factureLigneAchats.getFcfligReference() != null && !this.factureLigneAchats.getFcfligReference().isEmpty()) {
               this.produitsFournisseur.setProfouRef(this.factureLigneAchats.getFcfligReference());
            }

            this.produitsFournisseur.setProfouDate(this.factureEnteteAchats.getFcfDate());
            this.produitsFournisseur.setProfouPa(this.factureLigneAchats.getFcfligPu());
            if (this.structureLog.getStrdevise().equalsIgnoreCase(this.factureEnteteAchats.getFcfDevise())) {
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
         this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
         var2.commit();
      } catch (HibernateException var9) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.addLigne();
   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.factureLigneAchats.getFcfligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.factureLigneAchats.getFcfligCode();
            this.factureLigneAchatsDao.deleteOneLigne(this.factureLigneAchats, var1);
            new ArrayList();
            List var4 = (List)this.datamodelLigne.getWrappedData();
            var4.remove(this.factureLigneAchats);
            this.datamodelLigne.setWrappedData(var4);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression ligne produit " + var3 + " de la facture achat N° " + this.factureEnteteAchats.getFcfNum() + " du " + this.factureEnteteAchats.getFcfDate());
            this.espionDao.mAJEspion(var5, var1);
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

   public void accesPiecesJointes() throws HibernateException, NamingException {
      this.lesPiecesJointes.clear();
      if (this.factureEnteteAchats != null) {
         String var1 = this.factureEnteteAchats.getFcfNum().replace("/", "_") + "_";
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
                        var1 = this.factureEnteteAchats.getFcfNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomPiecesJointes) + "." + var8;
                     } else {
                        var1 = this.factureEnteteAchats.getFcfNum().replace("/", "_") + "." + var8;
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
                     this.factureEnteteAchats.setFcfPj(true);
                  } else {
                     this.factureEnteteAchats.setFcfPj(false);
                  }

                  this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats);
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
         this.showModalPanelScan = true;
      }

   }

   public void fermerVisuPieceJointe() {
      this.showModalPanelScan = false;
   }

   public void supprimerPieceJointe() throws MalformedURLException, IOException, HibernateException, NamingException {
      this.selectionnerPieceJointe();
      this.suppressionPjSuite();
      if (this.lesPiecesJointes.size() != 0) {
         this.factureEnteteAchats.setFcfPj(true);
      } else {
         this.factureEnteteAchats.setFcfPj(false);
      }

      this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats);
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
      this.tiers = this.formRecherche.rechercheTiers(0, this.factureEnteteAchats.getFcfNomTiers(), this.nature);
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
         this.factureEnteteAchats.setTiers(this.tiers);
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.factureEnteteAchats.setFcfCivilTiers("");
            this.var_typeTiers = true;
         } else {
            this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.factureEnteteAchats.setFcfCivilTiers(this.factureEnteteAchats.getTiers().getTiecivilite());
            this.var_typeTiers = false;
         }

         this.factureEnteteAchats.setFcfNomTiers(this.nomTier);
         this.factureEnteteAchats.setFcfTypeReg(this.tiers.getTietypereg());
         this.factureEnteteAchats.setFcfModeReg(this.tiers.getTiemodereg());
         this.calculMessageLitige();
         String var2 = "";
         if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
            String[] var3 = this.tiers.getTiemodereg().split(":");
            var2 = var3[0];
         } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
            var2 = this.tiers.getTiemodereg();
         }

         if (!var2.equals("") && !var2.equals("100")) {
            this.factureEnteteAchats.setFcfNbJourReg(this.tiers.getTienbecheance());
            this.factureEnteteAchats.setFcfArrondiReg(this.tiers.getTienbarrondi());
         } else {
            for(int var7 = 0; var7 < this.lesModeReglementFournisseurListe.size(); ++var7) {
               new ObjetReglement();
               ObjetReglement var4 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var7);
               if (var4.getDefaut().equals("true")) {
                  if (var4.getEcheances() == null || var4.getEcheances().isEmpty()) {
                     var4.setEcheances("0");
                  }

                  this.factureEnteteAchats.setFcfTypeReg(Integer.parseInt(var4.getEcheances()));
                  this.factureEnteteAchats.setFcfModeReg(var4.getCategories() + ":" + var4.getLibelles());
                  int var5 = 0;
                  if (var4.getNbjours() != null && !var4.getNbjours().isEmpty()) {
                     var5 = Integer.parseInt(var4.getNbjours());
                  }

                  this.factureEnteteAchats.setFcfNbJourReg(var5);
                  int var6 = 0;
                  if (var4.getArrondis() != null && !var4.getArrondis().isEmpty()) {
                     var6 = Integer.parseInt(var4.getArrondis());
                  }

                  this.factureEnteteAchats.setFcfArrondiReg(var6);
                  break;
               }
            }
         }

         this.chargerModeEcheanceAffichage();
         this.factureEnteteAchats.setFcfJournalReg(this.tiers.getTiejournalreg());
         if (this.tiers.getTienomfamille() != null && !this.tiers.getTienomfamille().isEmpty()) {
            this.factureEnteteAchats.setFcfCat(this.tiers.getTienomfamille());
            this.factureEnteteAchats.setFcfExoDouane(this.tiers.getTieexodouane());
            this.factureEnteteAchats.setFcfExoTva(this.tiers.getTieexotva());
            if (!this.tiers.getTiecodepays().equalsIgnoreCase(this.structureLog.getStrcodepays())) {
               this.factureEnteteAchats.setFcfExoTva(1);
            }
         } else if (this.tiers.getTiecodepays().equalsIgnoreCase(this.structureLog.getStrcodepays())) {
            this.factureEnteteAchats.setFcfCat("Local");
         } else {
            this.factureEnteteAchats.setFcfCat("Import");
         }

         if (this.tiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
            this.factureEnteteAchats.setFcfDiversTiers(99);
         } else {
            this.factureEnteteAchats.setFcfDiversTiers(0);
            this.factureEnteteAchats.setFcfDiversNom("");
            this.factureEnteteAchats.setFcfDiversAdresse("");
            this.factureEnteteAchats.setFcfDiversVille("");
            this.factureEnteteAchats.setFcfDiversTel("");
            this.factureEnteteAchats.setFcfDiversMail("");
         }

         if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
            this.factureEnteteAchats.setFcfDevise(this.tiers.getTiedevise());
         } else {
            this.factureEnteteAchats.setFcfDevise(this.structureLog.getStrdevise());
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
      this.factureEnteteAchats.setTiers(this.tiers);
      this.factureEnteteAchats.setFcfNomTiers("");
      this.factureEnteteAchats.setFcfCivilTiers("");
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
            if (this.factureEnteteAchats.getFcfCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && !var1.equalsIgnoreCase("1")) {
         if (var1.equalsIgnoreCase("2")) {
            if (this.tiers != null && this.tiers.getTiecodepays() != null && !this.tiers.getTiecodepays().equals(this.structureLog.getStrcodepays())) {
               this.factureEnteteAchats.setFcfExoTva(3);
            } else {
               this.factureEnteteAchats.setFcfExoTva(2);
            }
         } else {
            this.factureEnteteAchats.setFcfExoTva(0);
         }
      } else {
         this.factureEnteteAchats.setFcfExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && !var2.equalsIgnoreCase("1")) {
         this.factureEnteteAchats.setFcfExoDouane(0);
      } else {
         this.factureEnteteAchats.setFcfExoDouane(1);
      }

      this.calculDevise((Session)null);
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (!this.factureEnteteAchats.getFcfNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.CalculDateEcheance();
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      if (this.lesFamilleFournisseursListe.size() != 0) {
         for(int var3 = 0; var3 < this.lesFamilleFournisseursListe.size(); ++var3) {
            if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty() && this.factureEnteteAchats.getFcfCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && !var1.equalsIgnoreCase("1")) {
         if (var1.equalsIgnoreCase("2")) {
            if (this.tiers != null && this.tiers.getTiecodepays() != null && !this.tiers.getTiecodepays().equals(this.structureLog.getStrcodepays())) {
               this.factureEnteteAchats.setFcfExoTva(3);
            } else {
               this.factureEnteteAchats.setFcfExoTva(2);
            }
         } else {
            this.factureEnteteAchats.setFcfExoTva(0);
         }
      } else {
         this.factureEnteteAchats.setFcfExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && !var2.equalsIgnoreCase("1")) {
         this.factureEnteteAchats.setFcfExoDouane(0);
      } else {
         this.factureEnteteAchats.setFcfExoDouane(1);
      }

      if (this.lesLignesList.size() != 0) {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
         Transaction var4 = null;

         try {
            var4 = var13.beginTransaction();

            for(int var5 = 0; var5 < this.lesLignesList.size(); ++var5) {
               this.factureLigneAchats = new FactureLigneAchats();
               this.factureLigneAchats = (FactureLigneAchats)this.lesLignesList.get(var5);
               if (this.factureEnteteAchats.getFcfExoTva() == 1) {
                  this.factureLigneAchats.setFcfligTaxe("");
                  this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
                  this.factureLigneAchats.setFcfligTva(0.0D);
               } else if (this.factureLigneAchats.getFcfligCode() != null && !this.factureLigneAchats.getFcfligCode().isEmpty()) {
                  new Produits();
                  Produits var6 = this.produitsDao.chargeProduit(this.factureLigneAchats.getFcfligCode(), var13);
                  TaxesAchats var7;
                  if (var6 == null) {
                     if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
                        new TaxesAchats();
                        var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var13);
                        if (var7 != null) {
                           this.factureLigneAchats.setFcfligTaxe(this.optionAchats.getTvaDefaut());
                           this.factureLigneAchats.setFcfligTauxTaxe(var7.getTaxachTaux());
                        } else {
                           this.factureLigneAchats.setFcfligTaxe("");
                           this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
                        }
                     } else {
                        this.factureLigneAchats.setFcfligTaxe("");
                        this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
                     }
                  } else if (var6.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                     this.factureLigneAchats.setFcfligTaxe("");
                     this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
                  } else {
                     if (var6.getProVteTva() != null && !var6.getProVteTva().isEmpty()) {
                        this.factureLigneAchats.setFcfligTaxe(var6.getProVteTva());
                     } else {
                        this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var6, var13);
                        if (this.famillesProduitsAchats != null) {
                           this.factureLigneAchats.setFcfligTaxe(this.famillesProduitsAchats.getFamachTaxe());
                        }
                     }

                     new TaxesAchats();
                     var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.factureLigneAchats.getFcfligTaxe(), var13);
                     if (var7 != null) {
                        this.factureLigneAchats.setFcfligTauxTaxe(var7.getTaxachTaux());
                     } else {
                        this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
                     }
                  }
               }

               this.calculPrix(this.factureLigneAchats.getFcfligTaxe(), this.factureLigneAchats.getFcfligTauxTaxe(), var13);
               this.factureLigneAchats = this.factureLigneAchatsDao.modifLigne(this.factureLigneAchats, var13);
            }

            if (this.factureEnteteAchats.getFcfId() != 0L) {
               this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var13);
            }

            var4.commit();
         } catch (HibernateException var11) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
         this.chargerDocumentLigne(var13);
         this.utilInitHibernate.closeSession();
         this.cumulPrix();
      }

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
      this.produits = this.formRecherche.rechercheProduitAchat(this.factureLigneAchats.getFcfligCode(), this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
         this.factureLigneAchats.setFcfligCode(this.produits.getProCode());
         if (this.optionAchats.getModLibelleProd().equals("1")) {
            this.factureLigneAchats.setFcfligLibelle(this.produits.getProLibTech());
         } else {
            this.factureLigneAchats.setFcfligLibelle(this.produits.getProLibClient());
         }

         this.factureLigneAchats.setFcfligFamille(this.produits.getProAchCode());
         this.factureLigneAchats.setFcfligLong(this.produits.getProLongueur());
         this.factureLigneAchats.setFcfligLarg(this.produits.getProLargeur());
         this.factureLigneAchats.setFcfligHaut(this.produits.getProEpaisseur());
         this.factureLigneAchats.setFcfligDiam(this.produits.getProDiamExt());
         this.factureLigneAchats.setFcfligPoidsBrut(this.produits.getProPoidsBrut());
         this.factureLigneAchats.setFcfligPoidsNet(this.produits.getProPoidsNet());
         this.factureLigneAchats.setFcfligVolume(this.produits.getProVolume());
         this.factureLigneAchats.setFcfligNb(this.produits.getProNbUnite());
         this.factureLigneAchats.setFcfligReference((String)null);
         this.factureLigneAchats.setFcfligLibelleFournisseur((String)null);
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
         if (this.produits.getProAchTva() != null && !this.produits.getProAchTva().isEmpty() && !this.produits.getProAchTva().equals("0")) {
            float var5 = 0.0F;
            new TaxesAchats();
            TaxesAchats var6 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.produits.getProAchTva(), var1);
            if (var6 != null) {
               var5 = var6.getTaxachTaux();
            }

            this.factureLigneAchats.setFcfligTaxe(this.produits.getProAchTva());
            this.factureLigneAchats.setFcfligTauxTaxe(var5);
         } else {
            new FamillesProduitsAchats();
            FamillesProduitsAchats var2 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.lastExoAchats.getExeachId(), this.produits, var1);
            if (var2 != null && var2.getFamachTaxe() != null && !var2.getFamachTaxe().isEmpty() && !var2.getFamachTaxe().equals("0")) {
               float var3 = 0.0F;
               new TaxesAchats();
               TaxesAchats var4 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), var2.getFamachTaxe(), var1);
               if (var4 != null) {
                  var3 = var4.getTaxachTaux();
               }

               this.factureLigneAchats.setFcfligTaxe(var2.getFamachTaxe());
               this.factureLigneAchats.setFcfligTauxTaxe(var3);
            } else {
               this.factureLigneAchats.setFcfligTaxe("");
               this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
            }
         }

         if (this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            this.factureLigneAchats.setFcfligTaxe("");
            this.factureLigneAchats.setFcfligTauxTaxe(0.0F);
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.factureLigneAchats.setFcfligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.factureLigneAchats.setFcfligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.factureLigneAchats.setFcfligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.factureLigneAchats.setFcfligCondition("");
         this.prixUnitaireCorrespond(var1);
         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.factureLigneAchats.getFcfligTaxe(), this.factureLigneAchats.getFcfligTauxTaxe(), var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
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
      if (this.factureEnteteAchats.getFcfExoTva() == 0) {
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
            this.factureLigneAchats.setFcfligTaxe(this.optionAchats.getTvaDefaut());
         }
      } else if ((this.factureEnteteAchats.getFcfExoTva() == 2 || this.factureEnteteAchats.getFcfExoTva() == 3) && this.mesTaxesAchatsItems.size() != 0) {
         for(var1 = 0; var1 < this.mesTaxesAchatsItems.size(); ++var1) {
            var2 = false;

            for(var3 = 0; var3 < this.lisTaxesAchats.size(); ++var3) {
               if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachCode().equals(((SelectItem)this.mesTaxesAchatsItems.get(var1)).getValue().toString())) {
                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 2 && this.factureEnteteAchats.getFcfExoTva() == 2) {
                     var2 = true;
                     break;
                  }

                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 3 && this.factureEnteteAchats.getFcfExoTva() == 3) {
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
      if (this.factureLigneAchats.getFcfligCode() == null || this.factureLigneAchats.getFcfligCode().isEmpty() || this.factureLigneAchats.getFcfligCode().length() < 2) {
         this.selectionListeTva();
         this.mesUnitesProduits = this.mesUnitesItems;
         this.mesConditionnementsProduits = this.mesConditionnementsItems;
         if (this.mesConditionnementsProduits.size() != 0) {
            this.var_aff_condit = true;
         } else {
            this.var_aff_condit = false;
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.produitsDepot = null;
      this.factureLigneAchats.setFcfligCode("");
      this.factureLigneAchats.setFcfligLibelle("");
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
            this.factureLigneAchats.setFcfligPu(this.produitsFournisseur.getProfouPa());
            this.factureLigneAchats.setFcfligReference(this.produitsFournisseur.getProfouRef());
            this.factureLigneAchats.setFcfligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.factureLigneAchats.setFcfligUnite(this.produitsDepot.getProdepUnite());
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
         double var9 = 0.0D;
         float var4;
         if (this.factureLigneAchats.getFcfligCondition() != null && !this.factureLigneAchats.getFcfligCondition().isEmpty() && this.factureLigneAchats.getFcfligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.factureLigneAchats.getFcfligEchelle());
            float var5 = 1.0F;
            if (this.factureLigneAchats.getFcfligCondition().contains("/")) {
               String[] var6 = this.factureLigneAchats.getFcfligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.factureLigneAchats.getFcfligCondition() != null && !this.factureLigneAchats.getFcfligCondition().isEmpty() && !this.factureLigneAchats.getFcfligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.factureLigneAchats.getFcfligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.factureLigneAchats.setFcfligPump(var9);
      } else {
         this.factureLigneAchats.setFcfligPump(0.0D);
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
         String var2 = this.factureLigneAchats.getFcfligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.factureLigneAchats.setFcfligEchelle(this.unite.getUniEchelle());
               } else {
                  this.factureLigneAchats.setFcfligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.factureLigneAchats.setFcfligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.factureLigneAchats.setFcfligEchelle(Integer.parseInt(var2));
         } else {
            this.factureLigneAchats.setFcfligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var10 = 0; var10 < this.listeProduitDepot.size(); ++var10) {
               ProduitsDepot var11 = (ProduitsDepot)this.listeProduitDepot.get(var10);
               float var12 = 0.0F;
               if (this.optionAchats.getChoixStock().equals("1")) {
                  var12 = var11.getProdepQteStk() - var11.getProdepQteAttAch();
               } else {
                  var12 = var11.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.factureLigneAchats.getFcfligLong(), this.factureLigneAchats.getFcfligLarg(), this.factureLigneAchats.getFcfligHaut(), this.factureLigneAchats.getFcfligDiam(), this.factureLigneAchats.getFcfligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.factureLigneAchats.getFcfligLong(), this.factureLigneAchats.getFcfligLarg(), this.factureLigneAchats.getFcfligHaut(), this.factureLigneAchats.getFcfligDiam(), this.factureLigneAchats.getFcfligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var12;
               }

               if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
                  if (!this.verrouDepotUser.contains(",")) {
                     if (var11.getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                        if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                        }
                     }
                  } else {
                     String[] var13 = this.verrouDepotUser.split(",");
                     int var8 = var13.length;

                     for(int var9 = 0; var9 < var8; ++var9) {
                        if (var11.getDepot().getDpoCode().equals(var13[var9])) {
                           if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                              this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                              break;
                           }

                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                           break;
                        }
                     }
                  }
               } else if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
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

   public void rechercheDossier() throws JDOMException, IOException, HibernateException, NamingException {
      String var1 = "" + (this.var_date.getYear() + 1900);
      if (this.optionAchats.getAxeDossier().equals("2")) {
         this.dossier = this.formRecherche.rechercheAffaire(this.factureEnteteAchats.getFcfAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.factureEnteteAchats.getFcfSerie(), this.factureEnteteAchats.getFcfDevise());
      } else {
         this.dossier = this.formRecherche.rechercheDossier(this.factureEnteteAchats.getFcfAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.factureEnteteAchats.getFcfSerie(), this.factureEnteteAchats.getFcfDevise());
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

   public void recuperationDossier() throws JDOMException, IOException, HibernateException, NamingException {
      this.dossier = this.formRecherche.calculeDossier();
      this.calculeDossier();
   }

   public void calculeDossier() throws JDOMException, IOException {
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
               this.factureEnteteAchats.setFcfAnal4(this.dossier.getAnaTypeDossier() + this.dossier.getAnaCode());
            } else {
               this.factureEnteteAchats.setFcfAnal4(this.dossier.getAnaCode());
            }
         } else {
            this.libelleDossierFiche = "N° Dossier";
            this.factureEnteteAchats.setFcfAnal4(this.dossier.getAnaCode());
         }
      } else {
         this.factureEnteteAchats.setFcfAnal4("");
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDossier() {
      this.factureEnteteAchats.setFcfAnal4("");
      this.var_action = this.var_memo_action;
   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.factureEnteteAchats.getFcfTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > Math.abs(this.tiers.getTiedepotavance())) {
         this.montantElmTotBonEnc = Math.abs(this.tiers.getTiedepotavance());
      }

   }

   public void serieSelectTrf() throws HibernateException, NamingException, ParseException {
      this.mesSeriesTrfItems.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      new ArrayList();
      if (this.var_type_trf != 100) {
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

      this.var_serie_trf = this.factureEnteteAchats.getFcfSerie();
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
      this.var_imput_serie = this.factureEnteteAchats.getFcfSerie();
      this.var_imput_cat = this.factureEnteteAchats.getFcfCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new FactureEnteteAchats();
         FactureEnteteAchats var1 = this.factureEnteteAchatsDao.pourParapheur(this.var_imput_num, this.factureEnteteAchats.getFcfSerie(), (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.factureEnteteAchats.getFcfNum();
               this.factureEnteteAchats.setFcfNum(this.var_imput_num);
               this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
               if (this.factureEnteteAchats.getFcfTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.factureEnteteAchats.getFcfId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.factureEnteteAchats.getFcfNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.factureEnteteAchats.getFcfId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.factureEnteteAchats.getFcfNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation facture achat N° " + var3 + " en facture achat N° " + this.factureEnteteAchats.getFcfNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.factureEnteteAchats.getFcfNum();
            this.factureEnteteAchats.setFcfSerie(this.var_imput_serie);
            this.factureEnteteAchats.setFcfCat(this.var_imput_cat);
            this.factureEnteteAchats.setFcfNum(this.calculChrono.numCompose(this.factureEnteteAchats.getFcfDate(), this.nature, this.factureEnteteAchats.getFcfSerie(), var1));
            this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
            if (this.factureEnteteAchats.getFcfTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.factureEnteteAchats.getFcfId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.factureEnteteAchats.getFcfNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.factureEnteteAchats.getFcfId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.factureEnteteAchats.getFcfNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Facture achat X N° " + var3 + " en Facture achat " + this.factureEnteteAchats.getFcfSerie() + " N° " + this.factureEnteteAchats.getFcfNum());
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
         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            new FactureLigneAchats();
            FactureLigneAchats var3 = (FactureLigneAchats)this.documentDetailTrf.get(var2);
            float var4 = 0.0F;
            if (this.var_type_trf == 16) {
               AvoirLigneAchatsDao var5 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var4 = var5.chargerLesReliquatsFacturesAchs(var3.getFcfligId(), var1);
            }

            float var6 = var3.getFcfligQte() - var4;
            if (var6 < 0.0F) {
               var6 = 0.0F;
            }

            var3.setVar_qteDejaTrf(var4);
            var3.setVar_qteReliquat(var6);
            var3 = (FactureLigneAchats)this.documentDetailTrf.set(var2, var3);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new FactureLigneAchats();
            FactureLigneAchats var2 = (FactureLigneAchats)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (FactureLigneAchats)this.documentDetailTrf.set(var1, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void transformerMaj() throws HibernateException, NamingException, IOException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;

         for(int var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
            var3 += ((FactureLigneAchats)this.documentDetailTrf.get(var5)).getFcfligQte();
            var2 += ((FactureLigneAchats)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((FactureLigneAchats)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         int var7;
         if (var3 == var2) {
            new FactureEnteteAchats();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               FactureEnteteAchats var6 = (FactureEnteteAchats)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setFcfEtat(5);
                  this.factureEnteteAchatsDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            FactureEnteteAchats var12;
            if (this.var_mode_trf.equals("0")) {
               for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
                  new FactureEnteteAchats();
                  var12 = (FactureEnteteAchats)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getFcfNum().equalsIgnoreCase(((FactureEnteteAchats)var1.get(var9)).getFcfNum())) {
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
                  new FactureEnteteAchats();
                  var12 = (FactureEnteteAchats)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getTiers().getTieid() == ((FactureEnteteAchats)var1.get(var9)).getTiers().getTieid()) {
                           if (var12.getFcfSerie().equalsIgnoreCase(((FactureEnteteAchats)var1.get(var9)).getFcfSerie())) {
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
                  this.factureEnteteAchats = (FactureEnteteAchats)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((FactureEnteteAchats)var1.get(var11)).getFcfNum().equalsIgnoreCase(((FactureLigneAchats)this.documentDetailTrf.get(var7)).getFactureEnteteAchats().getFcfNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((FactureEnteteAchats)var1.get(var11)).getTiers().getTieid() == ((FactureLigneAchats)this.documentDetailTrf.get(var7)).getFactureEnteteAchats().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0 && this.var_type_trf == 16) {
                     this.trfAvr();
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
               this.factureEnteteAchats = (FactureEnteteAchats)this.lesEntetesList.get(var11);
               if (this.factureEnteteAchats.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.factureEnteteAchats);
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

   public void trfAvr() throws HibernateException, NamingException, IOException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceAchats = new DocumentTraceAchats();
         AvoirEnteteAchats var3 = new AvoirEnteteAchats();
         AvoirEnteteAchatsDao var4 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         AvoirLigneAchatsDao var5 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         var3.setUsers(this.usersLog);
         var3.setAvfIdCreateur(this.usersLog.getUsrid());
         var3.setAvfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setAvfDate(this.utilDate.dateToSQLLight(this.factureEnteteAchats.getFcfDate()));
         } else {
            var3.setAvfDate(this.var_date_trf);
         }

         var3.setAvfDate(this.utilDate.dateToSQL(var3.getAvfDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setAvfDateCreat(new Date());
         var3.setAvfDateModif((Date)null);
         var3.setAvfIdModif(0L);
         var3.setAvfNomModif("");
         var3.setAvfNum("");
         boolean var7 = false;
         int var33;
         if (this.optionAchats.getNbrJrRelanceAVOIR() != null && !this.optionAchats.getNbrJrRelanceAVOIR().isEmpty()) {
            var33 = Integer.parseInt(this.optionAchats.getNbrJrRelanceAVOIR());
         } else {
            var33 = 0;
         }

         boolean var8 = false;
         int var34;
         if (this.optionAchats.getNbrJrValidAVOIR() != null && !this.optionAchats.getNbrJrValidAVOIR().isEmpty()) {
            var34 = Integer.parseInt(this.optionAchats.getNbrJrValidAVOIR());
         } else {
            var34 = 0;
         }

         var3.setAvfDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var33));
         var3.setAvfDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var3.setAvfService(this.factureEnteteAchats.getFcfService());
         if (!this.var_serie_trf.equalsIgnoreCase("X") && !this.var_serie_trf.isEmpty()) {
            var3.setAvfNum(this.calculChrono.numCompose(var3.getAvfDate(), this.var_type_trf, this.var_serie_trf, var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setAvfNum("" + var9);
         }

         this.verifieExistenceHabilitationAvoir(var3, var1);
         var3.setAvfNomResponsable(this.factureEnteteAchats.getFcfNomResponsable());
         var3.setAvfIdResponsable(this.factureEnteteAchats.getFcfIdResponsable());
         var3.setAvfNomTiers(this.factureEnteteAchats.getFcfNomTiers());
         var3.setAvfCivilTiers(this.factureEnteteAchats.getFcfCivilTiers());
         var3.setAvfIdContact(this.factureEnteteAchats.getFcfIdContact());
         var3.setAvfNomContact(this.factureEnteteAchats.getFcfNomContact());
         var3.setAvfCivilContact(this.factureEnteteAchats.getFcfCivilContact());
         var3.setAvfDiversAdresse(this.factureEnteteAchats.getFcfDiversAdresse());
         var3.setAvfDiversMail(this.factureEnteteAchats.getFcfDiversMail());
         var3.setAvfDiversNom(this.factureEnteteAchats.getFcfDiversNom());
         var3.setAvfDiversTel(this.factureEnteteAchats.getFcfDiversTel());
         var3.setAvfDiversTiers(this.factureEnteteAchats.getFcfDiversTiers());
         var3.setAvfDiversVille(this.factureEnteteAchats.getFcfDiversVille());
         var3.setAvfSerie(this.var_serie_trf);
         var3.setAvfSource(this.factureEnteteAchats.getFcfSource());
         var3.setAvfExoTva(this.factureEnteteAchats.getFcfExoTva());
         var3.setAvfExoDouane(this.factureEnteteAchats.getFcfExoDouane());
         var3.setAvfJournalReg(this.factureEnteteAchats.getFcfJournalReg());
         var3.setAvfCat(this.factureEnteteAchats.getFcfCat());
         var3.setAvfDevise(this.factureEnteteAchats.getFcfDevise());
         var3.setAvfObject(this.factureEnteteAchats.getFcfObject());
         var3.setAvfObservation(this.factureEnteteAchats.getFcfObservation());
         var3.setAvfTotHt(0.0D);
         var3.setAvfTotRemise(0.0D);
         var3.setAvfTotRabais(0.0D);
         var3.setAvfTotTva(0.0D);
         var3.setAvfTotTc(0.0D);
         var3.setAvfTotTtc(0.0D);
         var3.setAvfTotReglement(0.0D);
         var3.setAvfSolde(0);
         var3.setAvfBanque(this.factureEnteteAchats.getFcfBanque());
         var3.setAvfTypeReg(this.factureEnteteAchats.getFcfTypeReg());
         var3.setAvfModeReg(this.factureEnteteAchats.getFcfModeReg());
         var3.setAvfNbJourReg(this.factureEnteteAchats.getFcfNbJourReg());
         var3.setAvfArrondiReg(this.factureEnteteAchats.getFcfArrondiReg());
         var3.setAvfConditionReg(this.factureEnteteAchats.getFcfConditionReg());
         var3.setAvfDateEcheReg(this.factureEnteteAchats.getFcfDateEcheReg());
         var3.setAvfActivite(this.factureEnteteAchats.getFcfActivite());
         var3.setAvfSite(this.factureEnteteAchats.getFcfSite());
         var3.setAvfDepartement(this.factureEnteteAchats.getFcfDepartement());
         var3.setAvfRegion(this.factureEnteteAchats.getFcfRegion());
         var3.setAvfSecteur(this.factureEnteteAchats.getFcfSecteur());
         var3.setAvfPdv(this.factureEnteteAchats.getFcfPdv());
         var3.setAvfAnal1(this.factureEnteteAchats.getFcfAnal1());
         var3.setAvfAnal2(this.factureEnteteAchats.getFcfAnal2());
         var3.setAvfAnal4(this.factureEnteteAchats.getFcfAnal4());
         var3.setAvfAffaire(this.factureEnteteAchats.getFcfAffaire());
         var3.setAvfInfo1(this.factureEnteteAchats.getFcfInfo1());
         var3.setAvfInfo2(this.factureEnteteAchats.getFcfInfo2());
         var3.setAvfInfo3(this.factureEnteteAchats.getFcfInfo3());
         var3.setAvfInfo4(this.factureEnteteAchats.getFcfInfo4());
         var3.setAvfInfo5(this.factureEnteteAchats.getFcfInfo5());
         var3.setAvfInfo6(this.factureEnteteAchats.getFcfInfo6());
         var3.setAvfInfo7(this.factureEnteteAchats.getFcfInfo7());
         var3.setAvfInfo8(this.factureEnteteAchats.getFcfInfo8());
         var3.setAvfInfo9(this.factureEnteteAchats.getFcfInfo9());
         var3.setAvfInfo10(this.factureEnteteAchats.getFcfInfo10());
         var3.setAvfFormule1(this.factureEnteteAchats.getFcfFormule1());
         var3.setAvfFormule2(this.factureEnteteAchats.getFcfFormule2());
         var3.setAvfAnnexe1(this.factureEnteteAchats.getFcfAnnexe1());
         var3.setAvfAnnexe2(this.factureEnteteAchats.getFcfAnnexe2());
         var3.setAvfContrat(this.factureEnteteAchats.getFcfContrat());
         var3.setAvfDateImp((Date)null);
         var3.setAvfModeleImp(this.var_modele_trf);
         var3.setAvfGele(0);
         var3.setAvfEtat(0);
         var3.setAvfDateTransforme((Date)null);
         var3.setAvfTypeTransforme(0);
         var3.setAvfDateAnnule((Date)null);
         var3.setAvfMotifAnnule("");
         var3.setExercicesAchats(this.exercicesAchats);
         var3.setTiers(this.factureEnteteAchats.getTiers());
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var35 = 0.0F;
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
            int var26 = 0;

            while(true) {
               if (var26 >= this.lesLignesList.size()) {
                  var3.setAvfTotHt(var12);
                  var3.setAvfTotRemise(var14);
                  var3.setAvfTotRabais(var16);
                  var3.setAvfTotTva(var18);
                  var3.setAvfTotTc(var22);
                  var3.setAvfTotTtc(var20);
                  var3 = var4.modif(var3, var1);
                  if (var6.size() != 0) {
                     var5.saveLigne(var6, var3, var1);
                  }
                  break;
               }

               this.factureLigneAchats = (FactureLigneAchats)this.lesLignesList.get(var26);
               AvoirLigneAchats var27;
               if (this.optionAchats.getTransformation().equals("1") && (var24 == null || var24.isEmpty() || !var24.equals(this.factureLigneAchats.getFactureEnteteAchats().getFcfNum()))) {
                  var24 = this.factureLigneAchats.getFactureEnteteAchats().getFcfNum();
                  ++var25;
                  var27 = new AvoirLigneAchats();
                  var27.setAvfligCode("-");
                  var27.setAvfligLibelle("---> Suivant facture achat N° " + var24);
                  var27.setAvoirEnteteAchats(var3);
                  var6.add(var27);
               }

               if (this.factureLigneAchats.getFcfligLibelle() != null && !this.factureLigneAchats.getFcfligLibelle().isEmpty() && this.factureLigneAchats.getVar_qteReliquat() != 0.0F) {
                  ++var25;
                  var27 = new AvoirLigneAchats();
                  var35 += this.factureLigneAchats.getFcfligQte();
                  var10 += this.factureLigneAchats.getVar_qteDejaTrf();
                  if (((FactureLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var27.setAvfligCode(this.factureLigneAchats.getFcfligCode());
                     var27.setAvfligDevise(this.factureLigneAchats.getFcfligDevise());
                     var27.setAvfligFamille(this.factureLigneAchats.getFcfligFamille());
                     var27.setAvfligIdFcf(this.factureLigneAchats.getFcfligId());
                     var27.setAvfligLibelle(this.factureLigneAchats.getFcfligLibelle());
                     var27.setAvfligComplement(this.factureLigneAchats.getFcfligComplement());
                     var27.setAvfligEchelle(this.factureLigneAchats.getFcfligEchelle());
                     var27.setAvfligUnite(this.factureLigneAchats.getFcfligUnite());
                     var27.setAvfligCondition(this.factureLigneAchats.getFcfligCondition());
                     var27.setAvfligReference(this.factureLigneAchats.getFcfligReference());
                     var27.setAvfligLibelleFournisseur(this.factureLigneAchats.getFcfligLibelleFournisseur());
                     var27.setAvfligPump(this.factureLigneAchats.getFcfligPump());
                     var27.setAvfligPu(this.factureLigneAchats.getFcfligPu());
                     var27.setAvfligTauxRemise(this.factureLigneAchats.getFcfligTauxRemise());
                     var27.setAvfligPuRem(this.factureLigneAchats.getFcfligPuRem());
                     this.factureLigneAchats.setFcfligQte(((FactureLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.factureLigneAchats.getFcfligTaxe(), this.factureLigneAchats.getFcfligTauxTaxe(), var1);
                     var27.setAvfligQte(((FactureLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var27.setAvfligLong(this.factureLigneAchats.getFcfligLong());
                     var27.setAvfligLarg(this.factureLigneAchats.getFcfligLarg());
                     var27.setAvfligHaut(this.factureLigneAchats.getFcfligHaut());
                     var27.setAvfligDiam(this.factureLigneAchats.getFcfligDiam());
                     var27.setAvfligPoidsBrut(this.factureLigneAchats.getFcfligPoidsBrut());
                     var27.setAvfligPoidsNet(this.factureLigneAchats.getFcfligPoidsNet());
                     var27.setAvfligVolume(this.factureLigneAchats.getFcfligVolume());
                     var27.setAvfligNb(this.factureLigneAchats.getFcfligNb());
                     var27.setAvfligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.factureLigneAchats.getFcfligCondition(), this.factureLigneAchats.getFcfligQte(), this.factureLigneAchats.getFcfligLong(), this.factureLigneAchats.getFcfligLarg(), this.factureLigneAchats.getFcfligHaut(), this.factureLigneAchats.getFcfligDiam(), this.factureLigneAchats.getFcfligNb(), this.baseLog, this.utilInitHibernate, var1));
                     var27.setAvfligRabais(this.factureLigneAchats.getFcfligRabais());
                     var27.setAvfligTauxTaxe(this.factureLigneAchats.getFcfligTauxTaxe());
                     var27.setAvfligTaxe(this.factureLigneAchats.getFcfligTaxe());
                     var27.setAvfligPt(this.factureLigneAchats.getFcfligPt());
                     var27.setAvfligTva(this.factureLigneAchats.getFcfligTva());
                     var27.setAvfligTtc(this.factureLigneAchats.getFcfligTtc());
                     var27.setAvfligTc(this.factureLigneAchats.getFcfligTc());
                     var27.setAvoirEnteteAchats(var3);
                     var11 += ((FactureLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var27);
                     var12 += var27.getAvfligPt();
                     var14 += (var27.getAvfligPu() - var27.getAvfligPuRem()) * (double)var27.getAvfligQte();
                     var16 += var27.getAvfligRabais();
                     var18 += var27.getAvfligTva();
                     var20 += var27.getAvfligTtc();
                     var22 += var27.getAvfligTc();
                  }
               }

               ++var26;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationAvoir(var3, var1), var3.getAvfId(), var3.getAvfNum(), var3.getAvfNomTiers(), var3.getAvfDate(), var3.getAvfDevise(), var3.getAvfTotTtc() + var3.getAvfTotTc(), var3.getAvfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 16), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFAVR(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceAchats.setDoctrfDateCreat(new Date());
         this.documentTraceAchats.setDoctrfUserId(this.usersLog.getUsrid());
         this.documentTraceAchats.setDoctrfUserNom(this.usersLog.getUsrNom());
         this.documentTraceAchats.setExercicesAchats(this.exercicesAchats);
         this.documentTraceAchats.setDoctrfOrgType(this.nature);
         this.documentTraceAchats.setDoctrfOrgSerie(this.factureEnteteAchats.getFcfSerie());
         this.documentTraceAchats.setDoctrfOrgId(this.factureEnteteAchats.getFcfId());
         this.documentTraceAchats.setDoctrfOrgNum(this.factureEnteteAchats.getFcfNum());
         this.documentTraceAchats.setDoctrfOrgDate(this.factureEnteteAchats.getFcfDate());
         this.documentTraceAchats.setDoctrfDstType(this.var_type_trf);
         this.documentTraceAchats.setDoctrfDstSerie(this.var_serie_trf);
         this.documentTraceAchats.setDoctrfDstId(var3.getAvfId());
         this.documentTraceAchats.setDoctrfDstNum(var3.getAvfNum());
         this.documentTraceAchats.setDoctrfDstDate(var3.getAvfDate());
         this.documentTraceAchatsDao.insert(this.documentTraceAchats, var1);
         if (var35 <= var10 + var11 && var35 != 0.0F && var10 + var11 != 0.0F) {
            this.factureEnteteAchats.setFcfEtat(5);
         } else {
            this.factureEnteteAchats.setFcfEtat(4);
         }

         this.factureEnteteAchats.setFcfDateTransforme(new Date());
         this.factureEnteteAchats.setFcfTypeTransforme(this.var_type_trf);
         this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
         var2.commit();
      } catch (HibernateException var31) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var31;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFAVR(List var1, AvoirEnteteAchats var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new AvoirLigneAchats();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            AvoirLigneAchats var4 = (AvoirLigneAchats)var1.get(var11);
            if (var4.getAvfligCode() != null && !var4.getAvfligCode().isEmpty() && var4.getAvfligCode().equals("-")) {
               var5 = true;
               var6 = var4.getAvfligLibelle();
            }

            if (var5) {
               var7 += var4.getAvfligPt();
               var9 = var4.getAvfligTtc();
            }

            if (var4.getAvfligCode() != null && !var4.getAvfligCode().isEmpty() && var4.getAvfligCode().equals("=") && var5) {
               var4 = new AvoirLigneAchats();
               var4.setAvoirEnteteAchats(var2);
               var4.setAvfligCode("=");
               var4.setAvfligLibelle(var6);
               var4.setAvfligPt(var7);
               var4.setAvfligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getAvfTotTtc() + var2.getAvfTotTc(), var2.getAvfDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationAvoir(AvoirEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setAvfEtatVal(1);
         var1.setAvfEtat(0);
         var1.setAvfDateValide((Date)null);
      } else {
         var1.setAvfEtatVal(0);
         if (var1.getAvfDateImp() != null) {
            if (var1.getAvfEtat() == 0) {
               var1.setAvfEtat(1);
               var1.setAvfDateValide(new Date());
            }
         } else {
            var1.setAvfEtat(0);
            var1.setAvfDateValide((Date)null);
         }
      }

      return var4;
   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.factureEnteteAchats != null) {
         this.caissesCommerciales = new CaissesCommerciales();
         if (this.caissesCommercialesDao == null) {
            this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         }

         this.bonDecaissementAchat = new BonDecaissementAchat();
         this.bonDecaissementAchat.setBonCodeCaisse((String)null);
         this.bonDecaissementAchat.setBonLibCaisse((String)null);
         this.bonDecaissementAchat.setBonDate(new Date());
         this.mesTypeReglementsCaisse.clear();
         this.var_nom_client = "";
         this.var_num_facture = "";
         this.var_montant = "";
         this.var_inputCaisse = "0";
         this.var_ecart_reglement = 0.0D;
         this.var_type_reg = "0";
         this.var_objet = "";
         this.var_banque_tireur = "";
         this.var_num_cheque = "";
         this.var_banque_destination = "";
         this.var_affiche_banque = false;
         this.var_affiche_banque_destination = false;
         this.var_date_trf = new Date();
         this.calculeCaisseDisponibleBencaissement();
         if (this.var_tot_bon_encaissement > this.factureEnteteAchats.getFcfTotTtc()) {
            this.factureEnteteAchats.setFcfTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.factureEnteteAchats.getFcfTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.factureEnteteAchats.getFcfTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.factureEnteteAchats.getFcfEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.factureEnteteAchats.getFcfTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.factureEnteteAchats.setFcfTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.factureEnteteAchats.getFcfTotTtc() - this.var_tot_bon_encaissement;
               this.verifBonEncaissement();
            }

            this.var_affichMontant = true;
         }

         this.showModalPanelPaye = true;
      }

   }

   public void calculeCaisseDisponibleBencaissement() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 1) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureEnteteAchats.getFcfSerie())) {
               String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
               this.mesCaissesSeriesItems.add(new SelectItem(var2));
            }
         }
      }

   }

   public void choixCaisseXReglementBencaissement() throws HibernateException, NamingException {
      this.var_type_reg = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty()) {
         this.calculeTypeReglementCaisse();
         this.selectionBanqueDestinationBencaissement();
         this.choixTypeReglementBencaissement();
      }

   }

   public void choixTypeReglementBencaissement() throws HibernateException, NamingException {
      if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
         String[] var1 = this.var_type_reg.split(":");
         this.varTypeReg = Integer.parseInt(var1[0]);
      } else {
         this.varTypeReg = 0;
      }

      if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
         this.var_affiche_banque = false;
      } else {
         this.var_affiche_banque = true;
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > Math.abs(this.tiers.getTiedepotavance())) {
         this.montantElmTotBonEnc = Math.abs(this.tiers.getTiedepotavance());
      }

   }

   public void selectionBanqueDestinationBencaissement() throws HibernateException, NamingException {
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonDecaissementAchat.setBonCodeCaisse(var1[0]);
         this.bonDecaissementAchat.setBonLibCaisse(var1[1]);
      } else {
         this.bonDecaissementAchat.setBonCodeCaisse((String)null);
         this.bonDecaissementAchat.setBonLibCaisse((String)null);
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void chargerModReg() {
      if (this.factureEnteteAchats.getFcfTypeReg() != 4 && this.factureEnteteAchats.getFcfTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (this.var_tot_bon_encaissement <= this.factureEnteteAchats.getFcfTotTtc()) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteAchats.getFcfTypeReg() == 5) {
               this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(this.nature, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 19, this.factureEnteteAchats.getFcfSerie(), var1);
               if (var3 != null && !var3.isEmpty()) {
                  this.bonDecaissementAchat = new BonDecaissementAchat();
                  String[] var4;
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     var4 = this.var_inputCaisse.split(":");
                     this.bonDecaissementAchat.setBonCodeCaisse(var4[0]);
                     this.bonDecaissementAchat.setBonLibCaisse(var4[1]);
                     if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
                        String[] var5 = this.var_type_reg.split(":");
                        this.bonDecaissementAchat.setBonTypeReg(Integer.parseInt(var5[0]));
                     } else {
                        this.bonDecaissementAchat.setBonTypeReg(0);
                     }
                  } else {
                     this.bonDecaissementAchat.setBonCodeCaisse((String)null);
                     this.bonDecaissementAchat.setBonLibCaisse((String)null);
                     this.bonDecaissementAchat.setBonTypeReg(0);
                  }

                  if (this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
                     var4 = this.var_banque_destination.split(":");
                     this.bonDecaissementAchat.setBonCodeBanq(var4[0]);
                     this.bonDecaissementAchat.setBonLibBanq(var4[1]);
                  } else {
                     this.bonDecaissementAchat.setBonCodeBanq((String)null);
                     this.bonDecaissementAchat.setBonLibBanq((String)null);
                  }

                  this.bonDecaissementAchat.setBonBanqueTireur(this.var_banque_tireur);
                  this.bonDecaissementAchat.setBonNumChqBdx(this.var_num_cheque);
                  this.bonDecaissementAchat.setBonDateCreat(new Date());
                  this.bonDecaissementAchat.setBonUserCreat(this.usersLog.getUsrid());
                  this.bonDecaissementAchat.setBonActivite(this.factureEnteteAchats.getFcfActivite());
                  this.bonDecaissementAchat.setBonSite(this.factureEnteteAchats.getFcfSite());
                  this.bonDecaissementAchat.setBonDepartement(this.factureEnteteAchats.getFcfDepartement());
                  this.bonDecaissementAchat.setBonService(this.factureEnteteAchats.getFcfService());
                  this.bonDecaissementAchat.setBonRegion(this.factureEnteteAchats.getFcfRegion());
                  this.bonDecaissementAchat.setBonSecteur(this.factureEnteteAchats.getFcfSecteur());
                  this.bonDecaissementAchat.setBonPdv(this.factureEnteteAchats.getFcfPdv());
                  this.bonDecaissementAchat.setBonDateEcheReg(this.factureEnteteAchats.getFcfDateEcheReg());
                  this.bonDecaissementAchat.setBonEtat(0);
                  this.bonDecaissementAchat.setBonNatRef(this.nature);
                  this.bonDecaissementAchat.setBonNomTiers(this.factureEnteteAchats.getFcfNomTiers());
                  this.bonDecaissementAchat.setBonIdTiers(this.factureEnteteAchats.getTiers().getTieid());
                  this.bonDecaissementAchat.setBonNomContact(this.factureEnteteAchats.getFcfNomContact());
                  this.bonDecaissementAchat.setBonIdContact(this.factureEnteteAchats.getFcfIdContact());
                  this.bonDecaissementAchat.setBonTypeTiers(1);
                  this.bonDecaissementAchat.setBonLibelle("Règlement Facture achat N° " + this.factureEnteteAchats.getFcfNum());
                  this.bonDecaissementAchat.setBonRef(this.factureEnteteAchats.getFcfNum());
                  this.bonDecaissementAchat.setBonIdRef(this.factureEnteteAchats.getFcfId());
                  this.bonDecaissementAchat.setBonObject(this.factureEnteteAchats.getFcfObject());
                  this.bonDecaissementAchat.setBonObservation(this.factureEnteteAchats.getFcfObservation());
                  this.bonDecaissementAchat.setBonSerie(this.factureEnteteAchats.getFcfSerie());
                  this.bonDecaissementAchat.setBonDevise(this.factureEnteteAchats.getFcfDevise());
                  this.bonDecaissementAchat.setBonTotTtc(this.factureEnteteAchats.getFcfTotTtc());
                  this.bonDecaissementAchat.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonDecaissementAchat.setBonActif(0);
                  this.bonDecaissementAchat.setBonNum(var3);
                  this.bonDecaissementAchat.setBonDate(this.var_date_trf);
                  this.bonDecaissementAchat.setBonIdResponsable(this.factureEnteteAchats.getFcfIdResponsable());
                  this.bonDecaissementAchat.setBonNomResponsable(this.factureEnteteAchats.getFcfNomResponsable());
                  this.bonDecaissementAchat.setBonGrp(this.usersLog.getUsrCollaboration());
                  this.bonDecaissementAchatDao.insert(this.bonDecaissementAchat, var1);
               } else {
                  this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            }

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

      if (this.lesEntetesList.size() != 0) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.factureEnteteAchats = (FactureEnteteAchats)this.lesEntetesList.get(var11);
            if (this.factureEnteteAchats.isVar_select_ligne()) {
               long var13 = this.factureEnteteAchats.getFcfId();
               this.factureEnteteAchats = new FactureEnteteAchats();
               this.factureEnteteAchats = this.factureEnteteAchatsDao.pourParapheur(var13, var1);
               if (this.factureEnteteAchats != null) {
                  this.lesEntetesList.remove(var11);
                  this.factureEnteteAchats.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.factureEnteteAchats);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelPaye = false;
      this.visibiliteBton = false;
   }

   public void payeXDocumentRecu() throws HibernateException, NamingException {
      this.reglements = new Reglements();
      this.caissesCommerciales = new CaissesCommerciales();
      if (this.caissesCommercialesDao == null) {
         this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      }

      this.mesTypeReglementsCaisse.clear();
      this.var_inputCaisse = "0";
      this.var_ecart_reglement = 0.0D;
      this.var_type_reg = "0";
      this.var_objet = "";
      this.var_banque_tireur = "";
      this.var_num_cheque = "";
      this.var_banque_destination = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      this.repartitionManuelle = false;
      this.totManuel = 0.0D;
      this.ecartManuel = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      this.var_date_trf = new Date();
      this.calculeCaisseDisponibleBrecu();
      if (this.lesEntetesList.size() != 0) {
         this.listFactureSelectionne = new ArrayList();
         double var1 = 0.0D;
         double var3 = 0.0D;
         double var5 = 0.0D;
         long var7 = 0L;
         String var9 = "";

         for(int var10 = 0; var10 < this.lesEntetesList.size(); ++var10) {
            new FactureEnteteAchats();
            FactureEnteteAchats var11 = (FactureEnteteAchats)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getFcfNomTiers())) && var11.getFcfSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getFcfNomTiers();
               var1 += var11.getFcfTotTtc() + this.factureEnteteAchats.getFcfTotTc();
               var3 += var11.getFcfTotReglement();
               var5 += var11.getVar_reliquat();
               this.listFactureSelectionne.add(var11);
            }
         }

         if (this.listFactureSelectionne.size() != 0) {
            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
            this.reglements = new Reglements();
            this.var_date_trf = new Date();
            this.var_netAPayer = var5;
            this.montantElmTotBonEnc = 0.0D;
            this.varTypeReg = 0;
            this.choixTypeReglement();
            this.choixCaisseXReglement();
            this.factureEnteteAchats.setFcfTypeReg(0);
            this.chargerModReg();
            this.verifValide();
            this.showModalPanelReglement = true;
         }
      }

   }

   public void calculeCaisseDisponibleBrecu() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 1) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureEnteteAchats.getFcfSerie())) {
               String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
               this.mesCaissesSeriesItems.add(new SelectItem(var2));
            }
         }

         if (this.mesCaissesSeriesItems.size() != 0) {
            this.var_inputCaisse = ((SelectItem)this.mesCaissesSeriesItems.get(0)).getValue().toString();
         } else {
            this.var_inputCaisse = "";
         }

         this.choixCaisseXReglement();
      }

   }

   public void choixCaisseXReglement() throws HibernateException, NamingException {
      this.var_type_reg = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty()) {
         this.calculeTypeReglementCaisse();
         this.selectionBanqueDestination();
         this.choixTypeReglement();
         this.verifValide();
      }

   }

   public void selectionBanqueDestination() throws HibernateException, NamingException {
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var1[0]);
         this.reglements.setRglLibCaiss(var1[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

   }

   public void verifValide() {
      this.var_affiche_valide = false;
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = true;
      }

      this.calculValeurTimbre();
      this.controleEcartRepartitionManuelle();
   }

   public void calulNetPayer() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      this.var_netAPayer = 0.0D;

      for(int var5 = 0; var5 < this.listFactureSelectionne.size(); ++var5) {
         new FactureEnteteAchats();
         FactureEnteteAchats var6 = (FactureEnteteAchats)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getFcfTotTtc();
            var3 += var6.getFcfTotReglement();
         }
      }

      this.var_netAPayer = var1 - var3;
   }

   public void choixTypeReglement() throws HibernateException, NamingException {
      if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
         String[] var1 = this.var_type_reg.split(":");
         this.varTypeReg = Integer.parseInt(var1[0]);
      } else {
         this.varTypeReg = 0;
      }

      if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
         this.var_affiche_banque = false;
      } else {
         this.var_affiche_banque = true;
         if (this.varTypeReg == 1) {
         }
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > Math.abs(this.tiers.getTiedepotavance())) {
         this.montantElmTotBonEnc = Math.abs(this.tiers.getTiedepotavance());
      }

      this.calculeNomRep();
      this.calculValeurTimbre();
   }

   public void calculValeurTimbre() {
      this.var_netAPayer = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      int var1;
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, this.montantElmTotBonEnc, var1, this.structureLog.getStrdevise(), this.var_date);
         this.totalPayerTimbre = this.montantElmTotBonEnc + this.val_timbre;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new FactureEnteteAchats();
               FactureEnteteAchats var7 = (FactureEnteteAchats)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getFcfTotTtc() + var7.getFcfTotTc() - var7.getFcfTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFcfTotTtc() + var7.getFcfTotTc() - var7.getFcfTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFcfDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFcfTotTtc() + var7.getFcfTotTc() - var7.getFcfTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFcfDate());
                  var4 = var4 - var7.getFcfTotTtc() + var7.getFcfTotTc() - var7.getFcfTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FactureEnteteAchats();
            FactureEnteteAchats var8 = (FactureEnteteAchats)this.listFactureSelectionne.get(var1);
            var8.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var8.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc - this.val_timbre;
   }

   public void fermerXReglement() {
      this.showModalPanelReglement = false;
   }

   public void validerXreglement() throws HibernateException, NamingException, ParseException {
      if (this.montantElmTotBonEnc != 0.0D && this.var_netAPayer != 0.0D) {
         new OptionCaisses();
         LireLesoptionsCaisses var2 = new LireLesoptionsCaisses();
         var2.setStrId(this.structureLog.getStrid());
         OptionCaisses var1 = var2.lancer();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "bonDecaissementAchat");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.factureEnteteAchats.getFcfSerie();
               String var8 = "";
               String var9 = "" + this.varTypeReg;
               if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("1")) {
                  String var10 = "";
                  if (this.var_inputCaisse.contains(";")) {
                     String[] var11 = this.var_inputCaisse.split(";");
                     var10 = var11[0];
                  }

                  if (var10 != null && !var10.isEmpty()) {
                     var8 = this.calculChrono.numComposeCaisse(this.var_date_trf, 61, var9, var7, var10, var3);
                  } else {
                     var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var9, var7, var3);
                  }
               } else if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("2")) {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               } else {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               }

               if (var8 != null && !var8.isEmpty()) {
                  double var34 = this.montantElmTotBonEnc;
                  double var12 = 0.0D;
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  double var18 = 0.0D;
                  new FactureEnteteAchats();

                  for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                     FactureEnteteAchats var20 = (FactureEnteteAchats)this.listFactureSelectionne.get(var21);
                     var16 = var20.getVar_fac_timbre();
                     var18 = var20.getMontantReglementManuel();
                     var12 = 0.0D;
                     if (var20.isVar_select_ligne()) {
                        long var22 = var20.getFcfId();
                        var20 = this.factureEnteteAchatsDao.pourParapheur(var22, var3);
                        if (var20 != null) {
                           if (this.repartitionManuelle) {
                              if (var18 != 0.0D) {
                                 this.generationReglement(var8, var18, var16, var20, var5, var3);
                                 var34 -= var18;
                                 if (var34 < 0.0D) {
                                    var34 = 0.0D;
                                    break;
                                 }
                              }
                           } else {
                              var12 = var20.getFcfTotTtc() + var20.getFcfTotTc() + var16 - var20.getFcfTotReglement();
                              if (var34 <= 0.0D) {
                                 break;
                              }

                              if (var12 <= var34) {
                                 var14 = var12;
                              } else {
                                 var14 = var34;
                              }

                              this.generationReglement(var8, var14, var16, var20, var5, var3);
                              var34 -= var14;
                              if (var34 < 0.0D) {
                                 var34 = 0.0D;
                                 break;
                              }
                           }
                        }
                     }
                  }

                  boolean var35 = false;
                  if (var34 > 0.0D) {
                     this.reglements = new Reglements();
                     this.reglements.setRglDateReg(this.memoReglements.getRglDateReg());
                     this.reglements.setRglOperation("15");
                     this.reglements.setRglActivite(this.memoReglements.getRglActivite());
                     this.reglements.setRglBanqueTireur(this.memoReglements.getRglBanqueTireur());
                     this.reglements.setRglBudget(this.memoReglements.getRglBudget());
                     this.reglements.setRglBon(this.memoReglements.getRglBon());
                     this.reglements.setRglCategorie(this.memoReglements.getRglCategorie());
                     this.reglements.setRglCodeCaiss(this.memoReglements.getRglCodeCaiss());
                     this.reglements.setRglLibCaiss(this.memoReglements.getRglLibCaiss());
                     this.reglements.setRglCodeEmetrice(this.memoReglements.getRglCodeEmetrice());
                     this.reglements.setRglCodeReceptrice(this.memoReglements.getRglCodeReceptrice());
                     this.reglements.setRglDateCreation(this.memoReglements.getRglDateCreation());
                     this.reglements.setRglDateImp(this.memoReglements.getRglDateImp());
                     this.reglements.setRglDateTransfert(this.memoReglements.getRglDateTransfert());
                     this.reglements.setRglDateValeur(this.memoReglements.getRglDateValeur());
                     this.reglements.setRglDepartement(this.memoReglements.getRglDepartement());
                     this.reglements.setRglDevise(this.memoReglements.getRglDevise());
                     this.reglements.setRglDossier(this.memoReglements.getRglDossier());
                     this.reglements.setRglFormatDevise(this.memoReglements.getRglFormatDevise());
                     this.reglements.setRglDocument("");
                     this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                     this.reglements.setRglIdBon(this.memoReglements.getRglIdBon());
                     this.reglements.setRglIdDocument(0L);
                     this.reglements.setRglIdTiers(this.memoReglements.getRglIdTiers());
                     this.reglements.setRglDepotTiers(1);
                     this.reglements.setRglLibEmetrice(this.memoReglements.getRglLibEmetrice());
                     this.reglements.setRglLibReceptrice(this.memoReglements.getRglLibReceptrice());
                     this.reglements.setRglLibelle("(déposit) " + this.memoReglements.getRglLibelle());
                     this.reglements.setRglMode(this.memoReglements.getRglMode());
                     this.reglements.setRglModele(this.memoReglements.getRglModele());
                     this.reglements.setRglNumChqBdx(this.memoReglements.getRglNumChqBdx());
                     this.reglements.setRglNatureDoc(this.memoReglements.getRglNatureDoc());
                     this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                     this.reglements.setRglNomTiers(this.memoReglements.getRglNomTiers());
                     this.reglements.setRglNum(this.memoReglements.getRglNum());
                     this.reglements.setRglObjet("(déposit) " + this.memoReglements.getRglObjet());
                     this.reglements.setRglParc(this.memoReglements.getRglParc());
                     this.reglements.setRglPdv(this.memoReglements.getRglPdv());
                     this.reglements.setRglDepense(var34);
                     this.reglements.setRglTimbre(0.0D);
                     this.reglements.setRglRegion(this.memoReglements.getRglRegion());
                     this.reglements.setRglSecteur(this.memoReglements.getRglSecteur());
                     this.reglements.setRglSerie(this.memoReglements.getRglSerie());
                     this.reglements.setRglService(this.memoReglements.getRglService());
                     this.reglements.setRglSite(this.memoReglements.getRglSite());
                     this.reglements.setRglTrf(this.memoReglements.getRglTrf());
                     this.reglements.setRglTypeReg(this.memoReglements.getRglTypeReg());
                     this.reglements.setRglTypeTiers(this.memoReglements.getRglTypeTiers());
                     this.reglements.setRglUserCreat(this.memoReglements.getRglUserCreat());
                     this.reglements.setRglGrp(this.memoReglements.getRglGrp());
                     this.reglements.setRglUserModif(this.memoReglements.getRglUserModif());
                     this.reglements.setRglIdResponsable(this.memoReglements.getRglIdResponsable());
                     this.reglements.setRglNomResponsable(this.memoReglements.getRglNomResponsable());
                     this.reglements.setRglIdCommercial(this.memoReglements.getRglIdCommercial());
                     this.reglements.setRglNomCommercial(this.memoReglements.getRglNomCommercial());
                     this.reglements.setRglIdEquipe(this.memoReglements.getRglIdEquipe());
                     this.reglements.setRglNomEquipe(this.memoReglements.getRglNomEquipe());
                     this.reglements.setRglPeriode(this.memoReglements.getRglPeriode());
                     this.reglements.setRglCle1(this.memoReglements.getRglCle1());
                     this.reglements.setRglCle2(this.memoReglements.getRglCle2());
                     this.reglements.setExercicesCaisse(this.memoReglements.getExercicesCaisse());
                     this.reglementsDao.insert(this.reglements, var3);
                     var35 = true;
                  }

                  if (this.varTypeReg == 90) {
                     var35 = true;
                  }

                  if (var35) {
                     new ArrayList();
                     List var36 = this.reglementsDao.rechercheHistoDepot(this.tiers.getTieid(), var3);
                     double var23 = 0.0D;
                     if (var36.size() != 0) {
                        for(int var25 = 0; var25 < var36.size(); ++var25) {
                           if (((Reglements)var36.get(var25)).getRglTypeReg() == 90) {
                              if (((Reglements)var36.get(var25)).getRglCategorie() == 10) {
                                 var23 = var23 - ((Reglements)var36.get(var25)).getRglRecette() + ((Reglements)var36.get(var25)).getRglDepense();
                              } else {
                                 var23 = var23 - ((Reglements)var36.get(var25)).getRglRecette() - ((Reglements)var36.get(var25)).getRglDepense();
                              }
                           } else {
                              var23 = var23 + ((Reglements)var36.get(var25)).getRglRecette() - ((Reglements)var36.get(var25)).getRglDepense();
                           }
                        }
                     }

                     this.tiers = this.tiersDao.selectTierD(this.tiers.getTieid(), var3);
                     if (this.tiers != null) {
                        this.tiers.setTiedepotavance(var23);
                        this.tiers = this.tiersDao.modif(this.tiers, var3);
                     }
                  }
               } else {
                  this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
                  this.formRecherche.setShowModalPanelMessage(true);
               }

               var4.commit();
            }
         } catch (HibernateException var29) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var29;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.lesEntetesList.size() != 0) {
         Session var31 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");

         for(int var32 = 0; var32 < this.lesEntetesList.size(); ++var32) {
            this.factureEnteteAchats = (FactureEnteteAchats)this.lesEntetesList.get(var32);
            if (this.factureEnteteAchats.isVar_select_ligne()) {
               long var33 = this.factureEnteteAchats.getFcfId();
               this.factureEnteteAchats = new FactureEnteteAchats();
               this.factureEnteteAchats = this.factureEnteteAchatsDao.pourParapheur(var33, var31);
               if (this.factureEnteteAchats != null) {
                  if (this.factureEnteteAchats.getFcfSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var32);
                  } else {
                     this.lesEntetesList.remove(var32);
                     this.factureEnteteAchats.setVar_select_ligne(false);
                     this.lesEntetesList.add(var32, this.factureEnteteAchats);
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelReglement = false;
      this.ouvrirImpressionRecu();
   }

   public void controleEcartRepartitionManuelle() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = false;
         if (this.listFactureSelectionne.size() != 0) {
            this.totManuel = 0.0D;

            for(int var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
               this.totManuel += ((FactureEnteteAchats)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
            }

            this.ecartManuel = this.montantElmTotBonEnc - this.totManuel;
            if (this.ecartManuel >= 0.0D) {
               this.var_affiche_valide = true;
            } else {
               this.var_affiche_valide = false;
            }
         }
      }

   }

   public void generationReglement(String var1, double var2, double var4, FactureEnteteAchats var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= var6.getFcfTotTtc() + var6.getFcfTotTc() + var4) {
         this.reglements.setRglOperation("21");
      } else {
         this.reglements.setRglOperation("22");
      }

      this.reglements.setRglActivite(var6.getFcfActivite());
      this.reglements.setRglBudget(var6.getFcfBudget());
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(10);
      String[] var9;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         var9 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var9[0]);
         this.reglements.setRglLibCaiss(var9[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

      this.reglements.setRglCodeEmetrice((String)null);
      this.reglements.setRglLibEmetrice((String)null);
      if (this.varTypeReg != 0 && this.varTypeReg != 11 && this.var_affiche_banque_destination && this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
         var9 = this.var_banque_destination.split(":");
         this.reglements.setRglCodeEmetrice(var9[0]);
         this.reglements.setRglLibEmetrice(var9[1]);
      }

      this.reglements.setRglCodeReceptrice((String)null);
      this.reglements.setRglLibReceptrice((String)null);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDateReg(this.var_date_trf);
      this.reglements.setRglDepartement(var6.getFcfDepartement());
      this.reglements.setRglDevise(var6.getFcfDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getFcfNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getFcfId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle(var6.getFcfObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(15);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      this.reglements.setRglIdContact(var6.getFcfIdContact());
      this.reglements.setRglNomContact(var6.getVar_nomContact());
      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getFcfPdv());
      this.reglements.setRglDepense(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getFcfDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getFcfRegion());
      this.reglements.setRglSecteur(var6.getFcfSecteur());
      this.reglements.setRglSerie(var6.getFcfSerie());
      this.reglements.setRglService(var6.getFcfService());
      this.reglements.setRglSite(var6.getFcfSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getFcfIdResponsable());
      this.reglements.setRglNomResponsable(var6.getFcfNomResponsable());
      this.reglements.setRglIdCommercial(0L);
      this.reglements.setRglNomCommercial("");
      this.reglements.setRglIdEquipe(0L);
      this.reglements.setRglNomEquipe("");
      String var15 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var15 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var15 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var12 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var15 + ":" + var12);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var13 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var13);
      this.reglements.setExercicesCaisse(var7);
      this.reglements = this.reglementsDao.insert(this.reglements, var8);
      this.memoReglements = this.reglements;
      if (var6 != null) {
         var6.setFcfTotReglement(var6.getFcfTotReglement() + var2);
         var6.setFcfTotTimbre(var6.getFcfTotTimbre() + var14);
         if (var6.getFcfTotReglement() >= var6.getFcfTotTtc() + var6.getFcfTotTc()) {
            var6.setFcfSolde(1);
         } else {
            var6.setFcfSolde(0);
         }

         var6.setFcfDateLastReg(this.reglements.getRglDateReg());
         this.factureEnteteAchatsDao.modif(var6, var8);
      }

   }

   public int calculformatDevise(String var1) {
      byte var2 = 0;
      if (!var1.equals("XAF") && !var1.equals("XOF")) {
         if (var1.equals("EUR") || var1.equals("CHF")) {
            var2 = 1;
         }
      } else {
         var2 = 2;
      }

      return var2;
   }

   public void chargerModeleDocument() {
      this.mesModesleRecus.clear();
      if (this.nomRepMod != null && !this.nomRepMod.isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod;
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
                  this.mesModesleRecus.add(new SelectItem(var5));
               }
            }
         }
      }

   }

   public void supprimerReglement() throws HibernateException, NamingException {
      if (this.datamodelRecu.isRowAvailable()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.factureEnteteAchats.getFcfId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglDepense();
               }
            }

            this.factureEnteteAchats.setFcfTotReglement(var4);
            if (this.factureEnteteAchats.getFcfTotReglement() >= this.factureEnteteAchats.getFcfTotTtc()) {
               this.factureEnteteAchats.setFcfSolde(1);
            } else {
               this.factureEnteteAchats.setFcfSolde(0);
            }

            this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
            this.datamodelRecu.setWrappedData(var3);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_acc_reglement = true;
         this.visibleOnglet = true;
      }

   }

   public void histoReglement() {
      if (this.factureEnteteAchats != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
   }

   public void ouvrirImpressionRecu() {
      this.showModalPanelPrintRecu = true;
   }

   public void fermerImpressionRecu() {
      this.showModalPanelPrintRecu = false;
   }

   public void imprimerRecuPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("PRT");
   }

   public void imprimerRecuJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("JRV");
   }

   public void imprimerRecuPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("PDF");
   }

   public void imprimerRecuODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("ODT");
   }

   public void imprimerRecuXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("XLS");
   }

   public void imprimerRecuDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("DOC");
   }

   public void imprimerRecuHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("HTML");
   }

   public void imprimerRecuXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("XML");
   }

   public void impressionRecu(String var1) throws IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.reglements != null && this.reglements.getRglModele() != null && !this.reglements.getRglModele().isEmpty()) {
         UtilPrint var2 = new UtilPrint(this.utilInitHibernate);
         double var3 = 0.0D;
         String var5 = "";
         String var6 = "";
         new ArrayList();
         List var7 = this.reglementsDao.chargeRecuByNum(this.reglements.getRglNum(), this.reglements.getRglCodeCaiss(), this.reglements.getRglNatureDoc(), this.reglements.getRglDateReg(), (Session)null);
         if (var7.size() != 0) {
            for(int var8 = 0; var8 < var7.size(); ++var8) {
               if (var5 == null && var5.isEmpty()) {
                  var5 = ((Reglements)var7.get(var8)).getRglDocument();
                  var6 = "" + this.utilNombre.beginText(((Reglements)var7.get(var8)).getRglDepense() + ((Reglements)var7.get(var8)).getRglTimbre(), this.structureLog.getStrformatdevise());
               } else {
                  var5 = var5 + "\n" + ((Reglements)var7.get(var8)).getRglDocument();
                  var6 = var6 + "\n" + this.utilNombre.beginText(((Reglements)var7.get(var8)).getRglDepense() + ((Reglements)var7.get(var8)).getRglTimbre(), this.structureLog.getStrformatdevise());
               }

               var3 = var3 + ((Reglements)var7.get(var8)).getRglDepense() + ((Reglements)var7.get(var8)).getRglTimbre();
            }

            if (var7.size() == 1) {
               var5 = null;
               var6 = null;
            }

            this.montant_lettre = this.utilNombre.begin(var3, this.reglements.getRglDevise());
            var7.clear();
            var7.add(this.reglements);
            JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(var7);
            var2.setjRBeanCollectionDataSource(var11);
            var2.setRapport(this.reglements.getRglModele());
            var2.setEntete("Impression reçu");
            String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod + File.separator;
            var2.setCheminRapport(var9);
            String var10 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport";
            var2.setCheminSousrapport(var10);
            var2.setImageFondPage((String)null);
            var2.setTaux(1.0F);
            var2.setAnnexe1(var5);
            var2.setAnnexe2(var6);
            var2.setPlafond(var3);
            var2.setMontant_lettre(this.montant_lettre);
            var2.setFormat(var1);
            var2.setIdResponsable(this.reglements.getRglIdResponsable());
            var2.setIdCommercial(this.reglements.getRglIdCommercial());
            var2.setTiersSelectionne((Tiers)null);
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var2.setContact(this.contacts);
            var2.setNumDoc(this.reglements.getRglNum());
            var2.setNature(this.nature);
            var2.setId_doc(this.reglements.getRglId());
            var2.setParc((Parc)null);
            var2.setBaseLog(this.baseLog);
            var2.setStructureLog(this.structureLog);
            var2.setUsersLog(this.usersLog);
            var2.imprimeRapport();
         }
      }

   }

   public void calculeTypeReglementCaisse() throws HibernateException, NamingException {
      this.var_affiche_banque_destination = true;
      this.mesTypeReglementsCaisse.clear();
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(0L, var1[0], (Session)null);
         if (this.caissesCommerciales != null) {
            if (this.caissesCommerciales.getCaiJrEspece() != null && !this.caissesCommerciales.getCaiJrEspece().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("0:Espèces"));
            }

            if (this.caissesCommerciales.getCaiJrCheque() != null && !this.caissesCommerciales.getCaiJrCheque().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("1:Chèque"));
            }

            if (this.caissesCommerciales.getCaiJrVirement() != null && !this.caissesCommerciales.getCaiJrVirement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("2:Virement"));
            }

            if (this.caissesCommerciales.getCaiJrTraite() != null && !this.caissesCommerciales.getCaiJrTraite().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("3:Traites"));
            }

            if (this.caissesCommerciales.getCaiJrTpe() != null && !this.caissesCommerciales.getCaiJrTpe().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("4:Carte bancaire"));
            }

            if (this.caissesCommerciales.getCaiJrTransfert() != null && !this.caissesCommerciales.getCaiJrTransfert().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("5:Transfert d`argent"));
            }

            if (this.caissesCommerciales.getCaiJrePaiement() != null && !this.caissesCommerciales.getCaiJrePaiement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("6:e-paiement"));
            }

            if (this.caissesCommerciales.getCaiJrCredoc() != null && !this.caissesCommerciales.getCaiJrCredoc().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("7:Credoc"));
            }

            if (this.caissesCommerciales.getCaiJrFactor() != null && !this.caissesCommerciales.getCaiJrFactor().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("8:Factor"));
            }

            if (this.caissesCommerciales.getCaiJrCompense() != null && !this.caissesCommerciales.getCaiJrCompense().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("9:Compense"));
            }

            if (this.caissesCommerciales.getCaiJrTerme() != null && !this.caissesCommerciales.getCaiJrTerme().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("10:Terme"));
            }

            if (this.caissesCommerciales.getCaiJrEspeceST() != null && !this.caissesCommerciales.getCaiJrEspeceST().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("11:Espèces sans timbre"));
            }

            if (this.caissesCommerciales.getCaiJrLettreGarantie() != null && !this.caissesCommerciales.getCaiJrLettreGarantie().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("12:Lettre de garantie"));
            }

            if (this.caissesCommerciales.getCaiJrPrelevement() != null && !this.caissesCommerciales.getCaiJrPrelevement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("13:Prélèvement"));
            }

            if (this.caissesCommerciales.getCaiJrAlcoin() != null && !this.caissesCommerciales.getCaiJrAlcoin().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("14:ALCoin"));
            }

            if (this.tiers != null && this.tiers.getTiedepotavance() != 0.0D) {
               this.mesTypeReglementsCaisse.add(new SelectItem("90:Déposit-Avance/Ristournes"));
            }

            if (this.mesTypeReglementsCaisse.size() != 0) {
               this.var_type_reg = ((SelectItem)this.mesTypeReglementsCaisse.get(0)).getValue().toString();
            } else {
               this.var_type_reg = "";
            }

            if (this.caissesCommerciales.getCaiMvtCheBnq() == 1) {
               this.calculeListeBanqueDestination();
               this.var_affiche_banque = true;
               this.var_affiche_banque_destination = true;
            }
         }
      }

   }

   public void calculeListeBanqueDestination() throws NamingException {
      if (this.mesBanquesItems == null || this.mesBanquesItems.size() == 0) {
         this.mesBanquesItems.clear();
         new ExercicesComptable();
         ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         ExercicesComptable var1 = var2.recupererLastExo((Session)null);
         if (var1 != null) {
            JournauxComptablesDao var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
            this.mesBanquesItems = var3.chargerLesJournaux(var1, 1, this.usersLog.getUsrJrxReserve(), (Session)null);
         }
      }

   }

   public void calculeNomRep() {
      if (this.varTypeReg != 0 && this.varTypeReg != 11 && this.varTypeReg != 90) {
         if (this.varTypeReg != 1 && this.varTypeReg != 10) {
            if (this.varTypeReg == 2) {
               this.nomRepMod = "virements";
            } else if (this.varTypeReg == 3) {
               this.nomRepMod = "traites";
            } else if (this.varTypeReg == 4) {
               this.nomRepMod = "cartes";
            } else if (this.varTypeReg == 5) {
               this.nomRepMod = "transferts";
            } else if (this.varTypeReg == 6) {
               this.nomRepMod = "epaiements";
            } else if (this.varTypeReg == 7) {
               this.nomRepMod = "credocs";
            } else if (this.varTypeReg == 8) {
               this.nomRepMod = "factors";
            } else if (this.varTypeReg == 9) {
               this.nomRepMod = "compenses";
            } else if (this.varTypeReg == 12) {
               this.nomRepMod = "lettres_garantie";
            } else if (this.varTypeReg == 13) {
               this.nomRepMod = "prelevements";
            } else if (this.varTypeReg == 14) {
               this.nomRepMod = "alcoins";
            } else {
               this.nomRepMod = "";
            }
         } else {
            this.nomRepMod = "cheques";
         }
      } else {
         this.nomRepMod = "especes";
      }

      this.chargerModeleDocument();
   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureEnteteAchats.getFcfFormule1() != null && !this.factureEnteteAchats.getFcfFormule1().isEmpty()) {
         FormulesAchatsDao var2 = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesAchats(this.factureEnteteAchats.getFcfFormule1(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureEnteteAchats.getFcfAnnexe1() != null && !this.factureEnteteAchats.getFcfAnnexe1().isEmpty() && this.factureEnteteAchats.getFcfAnnexe1().contains(":")) {
         String[] var2 = this.factureEnteteAchats.getFcfAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureEnteteAchats.getUsers(), this.structureLog, this.factureEnteteAchats.getTiers());
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
      if (this.factureEnteteAchats.getFcfAnnexe2() != null && !this.factureEnteteAchats.getFcfAnnexe2().isEmpty() && this.factureEnteteAchats.getFcfAnnexe2().contains(":")) {
         String[] var2 = this.factureEnteteAchats.getFcfAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureEnteteAchats.getUsers(), this.structureLog, this.factureEnteteAchats.getTiers());
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
            if (var4.exists()) {
               var3 = "formatFacture.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
         if (var4.exists()) {
            var3 = "formatFacture.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(Session var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
            Transaction var3 = null;

            try {
               var3 = var1.beginTransaction();

               for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
                  this.factureLigneAchats = (FactureLigneAchats)this.lesLignesList.get(var4);
                  if (this.factureLigneAchats.getFcfligCode() != null && !this.factureLigneAchats.getFcfligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.factureLigneAchats.getFcfligCode(), var1);
                     if (this.produits != null) {
                        this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                        if (this.produitsFournisseur != null) {
                           this.factureLigneAchats.setFcfligReference(this.produitsFournisseur.getProfouRef());
                           this.factureLigneAchats.setFcfligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
                           this.factureLigneAchats = this.factureLigneAchatsDao.modifLigne(this.factureLigneAchats, var1);
                        }
                     }
                  }

                  var2.add(this.factureLigneAchats);
               }

               var3.commit();
            } catch (HibernateException var8) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var8;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
               this.factureLigneAchats = (FactureLigneAchats)this.lesLignesList.get(var10);
               if (this.factureLigneAchats.getFcfligCode() != null && !this.factureLigneAchats.getFcfligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.factureLigneAchats.getFcfligCode(), var1);
                  if (this.produits != null) {
                     this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                     if (this.produitsFournisseur != null) {
                        this.factureLigneAchats.setFcfligReference(this.produitsFournisseur.getProfouRef());
                        this.factureLigneAchats.setFcfligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
                        this.factureLigneAchats = this.factureLigneAchatsDao.modifLigne(this.factureLigneAchats, var1);
                     }
                  }
               }

               var2.add(this.factureLigneAchats);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.factureEnteteAchats.getFcfTotTtc() + this.factureEnteteAchats.getFcfTotTc(), this.factureEnteteAchats.getFcfDevise());
      JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(var2);
      return var11;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.factureEnteteAchats.getFcfAnal2() != null && !this.factureEnteteAchats.getFcfAnal2().isEmpty()) {
         String var4 = "";
         if (this.factureEnteteAchats.getFcfAnal2().contains(":")) {
            String[] var5 = this.factureEnteteAchats.getFcfAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.factureEnteteAchats.getFcfAnal2();
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

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.factureEnteteAchats.getFcfDateImp() != null) {
            var2 = true;
         }

         this.factureEnteteAchats.setFcfDateImp(new Date());
         if (this.factureEnteteAchats.getFcfEtat() == 0 && this.factureEnteteAchats.getFcfEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.factureEnteteAchats.setFcfEtat(1);
            if (this.tiers.getTieDteDocument5() == null || this.factureEnteteAchats.getFcfDate().after(this.tiers.getTieDteDocument5())) {
               this.tiers.setTieDteDocument5(this.factureEnteteAchats.getFcfDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.factureEnteteAchats.setFcfModeleImp(var1);
         this.factureEnteteAchats = this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var3);
         this.contacts = new Contacts();
         if (this.factureEnteteAchats.getFcfIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.factureEnteteAchats.getFcfIdContact(), var3);
         }

         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
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
            var1.setEntete("Impression facture");
            var1.setMontant_lettre(this.montant_lettre);
            if (this.factureEnteteAchats.getFcfFormule1() != null && !this.factureEnteteAchats.getFcfFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog, this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.factureEnteteAchats.getFcfEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.factureEnteteAchats.getFcfIdResponsable());
            var1.setTiersSelectionne(this.factureEnteteAchats.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.factureEnteteAchats.getFcfNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.factureEnteteAchats.getFcfId());
            if (this.factureEnteteAchats.getFcfAnal2() != null && !this.factureEnteteAchats.getFcfAnal2().isEmpty()) {
               String var12 = "";
               if (this.factureEnteteAchats.getFcfAnal2().contains(":")) {
                  String[] var13 = this.factureEnteteAchats.getFcfAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.factureEnteteAchats.getFcfAnal2();
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
         var1.setEntete("Impression de la liste des factures");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "facture" + File.separator);
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
            this.uniteGraph = "FACTURES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "FACTURES : Quantites";
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
            this.sousTitreGraph = this.sousTitreGraph + " Etats: " + var2.calculeLibelleEtat(this.nature, this.inpEtat, Integer.parseInt(this.optionAchats.getPaiementAVOIR()));
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

         new FactureEnteteAchats();
         FactureLigneAchats var15 = new FactureLigneAchats();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureLigne");
         String var6 = "";

         FactureEnteteAchats var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (FactureEnteteAchats)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getFcfNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getFcfNum() + "'";
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

                  var14 = (FactureEnteteAchats)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getFcfDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getFcfNomResponsable() != null && !var14.getFcfNomResponsable().isEmpty()) {
                        var17 = var14.getFcfNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getFcfNomTiers() != null && !var14.getFcfNomTiers().isEmpty()) {
                        var17 = var14.getFcfNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  }

                  if (var15.getFcfligDevise().equals(this.structureLog.getStrdevise())) {
                     var20 = (long)var14.getFcfTotHt();
                  } else {
                     float var21 = this.utilNombre.deviseTaux1(var15.getFactureEnteteAchats().getFcfDevise(), var15.getFactureEnteteAchats().getFcfDate());
                     var20 = (long)(var14.getFcfTotHt() * (double)var21);
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getFcfDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getFcfDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getFcfDate().getMonth() + 1 >= 1 && var14.getFcfDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getFcfDate().getMonth() + 1 >= 4 && var14.getFcfDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getFcfDate().getMonth() + 1 >= 7 && var14.getFcfDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getFcfDate().getMonth() + 1 >= 10 && var14.getFcfDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getFcfDate().getMonth() + 1 >= 1 && var14.getFcfDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getFcfDate().getMonth() + 1 >= 7 && var14.getFcfDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getFcfDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.factureLigneAchatsDao.chargerLesLignesFactures(var6, var5);
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

                  var15 = (FactureLigneAchats)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getFactureEnteteAchats().getFcfDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getFactureEnteteAchats().getFcfNomResponsable() != null && !var15.getFactureEnteteAchats().getFcfNomResponsable().isEmpty()) {
                        var8 = var15.getFactureEnteteAchats().getFcfNomResponsable();
                     } else {
                        var8 = "Sans responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getFactureEnteteAchats().getFcfNomTiers() != null && !var15.getFactureEnteteAchats().getFcfNomTiers().isEmpty()) {
                        var8 = var15.getFactureEnteteAchats().getFcfNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getFcfligFamille() != null && !var15.getFcfligFamille().isEmpty()) {
                        var8 = var15.getFcfligFamille();
                     } else {
                        var8 = "Sans Famille produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getFcfligLibelle() != null && !var15.getFcfligLibelle().isEmpty()) {
                        var8 = var15.getFcfligLibelle();
                     } else {
                        var8 = "Sans Libelle produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     if (var15.getFcfligDevise().equals(this.structureLog.getStrdevise())) {
                        var9 = (long)var15.getFcfligPt();
                     } else {
                        float var22 = this.utilNombre.deviseTaux1(var15.getFactureEnteteAchats().getFcfDevise(), var15.getFactureEnteteAchats().getFcfDate());
                        var9 = (long)(var15.getFcfligPt() * (double)var22);
                     }
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getFcfligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getFactureEnteteAchats().getFcfDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 >= 1 && var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 >= 4 && var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 >= 7 && var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 >= 10 && var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 >= 1 && var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 >= 7 && var15.getFactureEnteteAchats().getFcfDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getFactureEnteteAchats().getFcfDate().getHours();
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

   public BonDecaissementAchat getBonDecaissementAchat() {
      return this.bonDecaissementAchat;
   }

   public void setBonDecaissementAchat(BonDecaissementAchat var1) {
      this.bonDecaissementAchat = var1;
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

   public FactureEnteteAchats getFactureEnteteAchats() {
      return this.factureEnteteAchats;
   }

   public void setFactureEnteteAchats(FactureEnteteAchats var1) {
      this.factureEnteteAchats = var1;
   }

   public FactureLigneAchats getFactureLigneAchats() {
      return this.factureLigneAchats;
   }

   public void setFactureLigneAchats(FactureLigneAchats var1) {
      this.factureLigneAchats = var1;
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

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public DataModel getDatamodelRecu() {
      return this.datamodelRecu;
   }

   public void setDatamodelRecu(DataModel var1) {
      this.datamodelRecu = var1;
   }

   public boolean isAfficheRecu() {
      return this.afficheRecu;
   }

   public void setAfficheRecu(boolean var1) {
      this.afficheRecu = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public double getVar_tot_bon_encaissement() {
      return this.var_tot_bon_encaissement;
   }

   public void setVar_tot_bon_encaissement(double var1) {
      this.var_tot_bon_encaissement = var1;
   }

   public boolean isVar_affiche_dollar() {
      return this.var_affiche_dollar;
   }

   public void setVar_affiche_dollar(boolean var1) {
      this.var_affiche_dollar = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
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

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
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

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
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

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getVar_inpModeleImp() {
      return this.var_inpModeleImp;
   }

   public void setVar_inpModeleImp(String var1) {
      this.var_inpModeleImp = var1;
   }

   public List getLesModeReglementFournisseurListe() {
      return this.lesModeReglementFournisseurListe;
   }

   public void setLesModeReglementFournisseurListe(List var1) {
      this.lesModeReglementFournisseurListe = var1;
   }

   public DataModel getDataModelEcriture() {
      return this.dataModelEcriture;
   }

   public void setDataModelEcriture(DataModel var1) {
      this.dataModelEcriture = var1;
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

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
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

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public List getMesCaissesSeriesItems() {
      return this.mesCaissesSeriesItems;
   }

   public void setMesCaissesSeriesItems(List var1) {
      this.mesCaissesSeriesItems = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public List getMesTypeReglementsCaisse() {
      return this.mesTypeReglementsCaisse;
   }

   public void setMesTypeReglementsCaisse(List var1) {
      this.mesTypeReglementsCaisse = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
   }

   public boolean isShowModalPanelPrintRecu() {
      return this.showModalPanelPrintRecu;
   }

   public void setShowModalPanelPrintRecu(boolean var1) {
      this.showModalPanelPrintRecu = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public double getTotalImputation() {
      return this.totalImputation;
   }

   public void setTotalImputation(double var1) {
      this.totalImputation = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public boolean isVar_affiche_banque_destination() {
      return this.var_affiche_banque_destination;
   }

   public void setVar_affiche_banque_destination(boolean var1) {
      this.var_affiche_banque_destination = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public boolean isReglementAutorise() {
      return this.reglementAutorise;
   }

   public void setReglementAutorise(boolean var1) {
      this.reglementAutorise = var1;
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

   public String getInpNumFacture() {
      return this.inpNumFacture;
   }

   public void setInpNumFacture(String var1) {
      this.inpNumFacture = var1;
   }

   public double getInpMontant() {
      return this.inpMontant;
   }

   public void setInpMontant(double var1) {
      this.inpMontant = var1;
   }

   public String getLibelleDossier() {
      return this.libelleDossier;
   }

   public void setLibelleDossier(String var1) {
      this.libelleDossier = var1;
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

   public String getCheminPieceJointes() {
      return this.cheminPieceJointes;
   }

   public void setCheminPieceJointes(String var1) {
      this.cheminPieceJointes = var1;
   }

   public DataModel getDataModelPieceJointes() {
      return this.dataModelPieceJointes;
   }

   public void setDataModelPieceJointes(DataModel var1) {
      this.dataModelPieceJointes = var1;
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

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
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

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
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
