package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.ProcessLigneAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.control.RdvSemaine;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChargementEnteteDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.ProcessLigneAchatsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersFavorisDao;
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
import com.epegase.systeme.xml.LectureNatureAffaires;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetNatureAffaires;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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

public class FormCommandeVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private int typeVente;
   private String urlphotoProd;
   private List mesOnglets;
   private OptionVentes optionsVentes;
   private OptionParcs optionParcs;
   private int var_option_parc;
   private boolean var_contener_parc;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean var_tc_calcul;
   private int var_nb_max = 100;
   private List mesSerieUserItem;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private String var_libcondest;
   private boolean contDest = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private boolean reglementAutorise = false;
   private int gestionStock;
   private Tiers tiers;
   private TiersDao tiersDao;
   private String nomTier;
   private List lesFamilleClientsListe;
   private List lesModeReglementClientsListe;
   private String informationsTiers;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private Users responsable;
   private long var_nom_commercial;
   private List mesCommercialItem = new ArrayList();
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem = new ArrayList();
   private List lesEquipes = new ArrayList();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private Contacts contacts;
   private CommandeEnteteVentes commandeEnteteVentes = new CommandeEnteteVentes();
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private List lesEntetesList = new ArrayList();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete = new ListDataModel();
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
   private boolean showModalPanelValidationDocument = false;
   private List mesParcsItems = new ArrayList();
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private List mesAffairesItems;
   private String numeroPfManuel;
   private CommandeLigneVentes commandeLigneVentes = new CommandeLigneVentes();
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private float var_memo_qte;
   private double prixPlancher;
   private boolean griserValider = false;
   private int numLigne;
   private ServiceDao serviceDao;
   private Produits produits;
   private Produits memoProduits;
   private ProduitsVtesDao produitsDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsFournisseurDao produitsFournisseurDao;
   private ProduitsTarifDao produitsTarifdao;
   private ProduitsDepotDao produitsDepotDao;
   private List mesProduitsDepotsItems = new ArrayList();
   private List listeProduitDepot = new ArrayList();
   private TaxesVentesDao taxesVentesDao;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private double prixUnitaires;
   private List mesTaxesVentesItems;
   private List mesTaxesVentesProduits = new ArrayList();
   private CalculStock calculStock = new CalculStock();
   private boolean verrou_libelle = false;
   private BaremesDao baremesDao;
   private boolean verifBareme;
   private List mesConditionnementsItems;
   private List mesConditionnementsProduits = new ArrayList();
   private List mesUnitesItems;
   private List mesUnitesProduits = new ArrayList();
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private Unite unite = new Unite();
   private UniteDao uniteDao;
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpNomDestinataire = "";
   private String inpSerie = "100";
   private String inpCat = "100";
   private int inpMode = 99;
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpNumBCC = "";
   private String inpNumAnal = "";
   private String inpClient = "";
   private String inpDestinataire = "";
   private String inpResponsable = "";
   private String inpCommercial = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpContener = "";
   private String inpDossier = "100";
   private String inpRegion = "";
   private String inpSecteur = "";
   private String inpPdv = "";
   private List mesSecteursItems;
   private List mesPdvItems;
   private String inpSite = "";
   private String inpDepartement = "";
   private String inpService = "";
   private List mesDepartementsItems;
   private List mesServicesItems;
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean selectDestinataire = false;
   private boolean var_more_search = false;
   private boolean showModalPanelModifDateLiv = false;
   private boolean showModalPanelModifBCC = false;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private float var_coef_devise;
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private boolean affichagePlancher = false;
   private String verrouDepotUser;
   private boolean accesProduits;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_dre = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_exoneration = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private Habilitation habilitation;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private String nomModeleDocument;
   private String impEmetteur;
   private String impDestinataire;
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private boolean showModalPanelPrintReliquat = false;
   private List lesDocumentsReliquatItem;
   private String devisePrint;
   private float tauxPrint;
   private DocumentTraceVentes documentTraceVentes;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
   private Date var_date_remise;
   private List mesTypeReglementsCaisse;
   private List listCaisses;
   private List mesCaissesSeriesItems;
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
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
   private List listFactureSelectionne;
   private Reglements reglements;
   private Reglements memoReglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_objet;
   private String var_banque_tireur;
   private String var_num_cheque;
   private List mesModesleRecus;
   private String nomRepMod;
   private double val_timbre;
   private double var_ecart_reglement;
   private String var_banque_destination;
   private boolean var_affiche_banque_destination = false;
   private List mesBanquesItems;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean repartitionManuelle;
   private double totManuel;
   private double ecartManuel;
   private boolean showModalPanelPrintRecu = false;
   private boolean showModalPanelHistoReglement = false;
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
   private boolean showModalPanelAnnule = false;
   private boolean showModalPanelAnnuleValider = false;
   private boolean showModalPanelGele = false;
   private String var_motif_annule;
   private boolean showModalPanelReliquat = false;
   private List documentTrace;
   private transient DataModel dataModelReliquat;
   private List lesCommandesReliquat;
   private double ht_livre;
   private transient DataModel dataModelEcriture;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites;
   private transient DataModel dataModelDecoupageActivtes;
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
   private int modeRdv;
   private Date parMois;
   private Date parSemaine;
   private Date parJour;
   private Date jourDeb;
   private Date jourFin;
   private int valNatMois = 99;
   private int valStatutMois = 10;
   private int valNatSemaine = 99;
   private int valStatutSemaine = 10;
   private int valNatJour = 99;
   private int valStatutJour = 10;
   private int valNatListe = 99;
   private int valStatutListe = 10;
   private List listRdvMois;
   private List listRdvSemaine;
   private List listRdvJour;
   private List listRdv;
   private transient DataModel datamodelRdv;
   private transient DataModel datamodelLesRdvParJour;
   private transient DataModel datamodelLesRdvParSemaine;
   private transient DataModel datamodelLesRdvParMois;
   private String dateLun;
   private String dateMar;
   private String dateMer;
   private String dateJeu;
   private String dateVen;
   private String dateSam;
   private String dateDim;
   private boolean showModalPanelPlanning;
   private boolean afficheRdv;
   private RdvSemaine rdvSemaine;
   private List planningImpressionsItems;
   private boolean showModalPanelPrintPlanning;
   private Date memoDateLivraion;
   private Rdv rdv;
   private boolean showModalPanelRdv = true;
   private boolean compteRendu = false;
   private boolean rdvdetails = false;
   private RdvDao rdvDao;
   private boolean showModalPanelTiers = false;
   private transient DataModel dataModelPieceJointes;
   private List lesPiecesJointes;
   private boolean showModalPanelAjoutFile = false;
   private String cheminPieceJointes;
   private String nomPiecesJointes;
   private boolean showModalPanelPj = false;
   private String fichierMine;
   private URL fichierUrl;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload;
   private String urlExplorateur;
   private FileCtrl fileCtrl;
   private int typeFichier;
   private double plafondEnCours;
   private double soldeEnCours;
   private boolean plafondAutorise;
   private String libelleRabRis;
   private boolean ristourne;
   private boolean autorisationAppelFonds;
   private boolean showModalPanelAppelFonds = false;
   private boolean showModalPanelAjoutAppelFonds = false;
   private float valAppelfonds;
   private double totalAppelfonds;
   private transient DataModel dataModelAppelFonds;
   private float totalPourcentage;
   private double totalAppel;
   private boolean showModalPanelPrintAppelfonds = false;
   private List lesDocumentsAppelFonds;

   public FormCommandeVentes() throws IOException, SAXException, JDOMException {
      this.datamodelDocumentTrace = new ListDataModel();
      this.dataModelReliquat = new ListDataModel();
      this.listFactureSelectionne = new ArrayList();
      this.mesModesleRecus = new ArrayList();
      this.mesBanquesItems = new ArrayList();
      this.mesCaissesSeriesItems = new ArrayList();
      this.mesTypeReglementsCaisse = new ArrayList();
      this.dataModelEcriture = new ListDataModel();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.mesAffairesItems = new ArrayList();
      this.dataModelPieceJointes = new ListDataModel();
      this.lesPiecesJointes = new ArrayList();
      this.utilDownload = new UtilDownload();
      this.mesSecteursItems = new ArrayList();
      this.mesPdvItems = new ArrayList();
      this.mesDepartementsItems = new ArrayList();
      this.mesServicesItems = new ArrayList();
      this.dataModelAppelFonds = new ListDataModel();
      this.lesDocumentsAppelFonds = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (this.optionsVentes.getDecrmtPrsChrStock() == null || this.optionsVentes.getDecrmtPrsChrStock().isEmpty()) {
         this.optionsVentes.setDecrmtPrsChrStock("0");
      }

      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
         if (this.optionsVentes.getGestionStockBc().equals("1")) {
            this.gestionStock = 1;
         } else {
            this.gestionStock = 0;
         }
      } else {
         this.var_sansstock = false;
         this.gestionStock = 0;
      }

      if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("1")) {
         this.contDest = false;
         this.var_libcondest = "Contact";
      } else if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("2")) {
         this.contDest = true;
         this.var_libcondest = "Destinataire";
      }

      if (!this.optionsVentes.getLib1ENTETE().isEmpty() && !this.optionsVentes.getLib2ENTETE().isEmpty() && !this.optionsVentes.getLib3ENTETE().isEmpty() && !this.optionsVentes.getLib4ENTETE().isEmpty() && !this.optionsVentes.getLib5ENTETE().isEmpty() && !this.optionsVentes.getLib6ENTETE().isEmpty() && !this.optionsVentes.getLib7ENTETE().isEmpty() && !this.optionsVentes.getLib8ENTETE().isEmpty() && !this.optionsVentes.getLib9ENTETE().isEmpty() && !this.optionsVentes.getLib10ENTETE().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionsVentes.getPaiementAVOIR().equalsIgnoreCase("1")) {
         this.reglementAutorise = true;
      } else {
         this.reglementAutorise = false;
      }

      if (this.optionsVentes.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionsVentes.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
         this.accesAffaires = false;
         this.var_contener_parc = false;
      } else if (this.optionsVentes.getAxeDossier().equals("2")) {
         this.accesAffaires = true;
         this.var_anal_dossier = false;
         this.var_contener_parc = false;
      } else if (this.optionsVentes.getAxeDossier().equals("3")) {
         this.var_anal_dossier = true;
         this.accesAffaires = false;
         this.var_contener_parc = true;
      } else {
         this.accesAffaires = false;
         this.var_anal_dossier = false;
         this.var_contener_parc = false;
      }

      if (this.optionsVentes.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      } else {
         this.var_anal_parc = false;
      }

      this.periode = this.optionsVentes.getAffichInGlobViewCOM();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      if (this.optionsVentes.getDecrmtRabais().equals("3")) {
         this.libelleRabRis = "Ristourne";
         this.ristourne = true;
      } else {
         this.libelleRabRis = "Rabais";
         this.ristourne = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.cheminPieceJointes = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "commandeVente" + File.separator;
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemise = false;
      } else {
         this.verrouRemise = true;
      }

      if (this.usersLog.getUsrVerRabais() == 0) {
         this.verrouRabais = false;
      } else {
         this.verrouRabais = true;
      }

      if (this.usersLog.getUsrVerPv() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
      }

      if (this.usersLog.getUsrAffPlancher() == 0) {
         this.affichagePlancher = false;
      } else {
         this.affichagePlancher = true;
      }

      if (this.usersLog.getUsrProdService() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

      this.visibiliteBton = false;
      if (this.usersLog.getUsrCommVentes() == 2) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

      this.autorisationAppelFonds = true;
   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_dre = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_exoneration = false;
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
               this.var_acc_dre = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("59")) {
               this.var_acc_exoneration = true;
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

   public void autorisationDre() {
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

   public void autorisationExoneration() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("59")) {
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
      this.modeRdv = 9;
      this.selectDestinataire = false;
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
      if (this.optionsVentes.getImpressionBcBlCOM().equals("1")) {
         this.inpEtat = 28;
      } else {
         this.inpEtat = 0;
      }

      this.lesEntetesList.clear();
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("0")) {
         Object var2 = new ArrayList();
         if (this.usersLog.getUsrCommVentes() == 0) {
            var2 = this.usersDao.chargerLesUsers(var1);
         } else if (this.usersLog.getUsrCommVentes() == 1) {
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
                     ((List)var2).add(var7);
                  }
               }
            } else {
               var2 = this.usersDao.chargerLesSignataires("Ventes", var1);
            }
         } else {
            ((List)var2).add(this.usersLog);
         }

         if (((List)var2).size() == 0) {
            ((List)var2).add(this.usersLog);
         }

         this.mesUsersItem.clear();
         if (this.usersLog.getUsrCommVentes() != 0 && this.usersLog.getUsrCommVentes() != 1) {
            this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         } else {
            for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
               Users var9 = (Users)((List)var2).get(var8);
               if (var9.getUsrVendeur() == 1 && var9.getUsrPatronyme() != null && !var9.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var9.getUsrid(), var9.getUsrPatronyme()));
               }
            }

            if (this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerCommerciauxResponsable(Session var1) throws HibernateException, NamingException {
      this.lesEquipes.clear();
      this.lesEquipes = this.equipesDao.selectEquipes(var1);
      this.mesEquipeItem.clear();
      if (this.lesEquipes.size() != 0) {
         this.mesEquipeItem.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < this.lesEquipes.size(); ++var2) {
            this.mesEquipeItem.add(new SelectItem(((Equipes)this.lesEquipes.get(var2)).getEquCode() + ":" + ((Equipes)this.lesEquipes.get(var2)).getEquNomFr()));
         }
      }

      if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
         new ArrayList();
         List var6 = this.usersDao.chargerLesSignataires("Ventes", var1);
         this.mesUsersItem.clear();
         if (var6.size() != 0) {
            this.mesUsersItem.add(new SelectItem(0, ""));

            for(int var3 = 0; var3 < var6.size(); ++var3) {
               Users var4 = (Users)var6.get(var3);
               if (var4.getUsrVendeur() == 1 && var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
               }
            }
         }

         new ArrayList();
         List var7 = this.usersDao.chargerLesCommerciaux(var1);
         this.mesCommercialItem.clear();
         if (var7.size() != 0) {
            this.mesCommercialItem.add(new SelectItem(0, ""));

            for(int var8 = 0; var8 < var7.size(); ++var8) {
               Users var5 = (Users)var7.get(var8);
               if (var5.getUsrVendeur() == 1 && var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
                  this.mesCommercialItem.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme()));
               }
            }
         }
      }

   }

   public void calculeResponsableLie() throws HibernateException, HibernateException, NamingException {
      this.calculeResponsableLie((Session)null);
   }

   public void calculeResponsableLie(Session var1) throws HibernateException, HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("1")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
         this.mesEquipeItem.clear();
         this.mesEquipeItem.add(new SelectItem(0, ""));
         this.var_nom_responsable = 0L;
         this.var_nom_equipe = 0L;
         if (this.var_nom_commercial != 0L && this.lesEquipes.size() != 0) {
            boolean var2 = false;

            for(int var3 = 0; var3 < this.lesEquipes.size(); ++var3) {
               this.equipes = (Equipes)this.lesEquipes.get(var3);
               int var5;
               if (this.equipes.getEquIdAgent() != null && !this.equipes.getEquIdAgent().isEmpty()) {
                  if (!this.equipes.getEquIdAgent().contains(":")) {
                     long var8 = Long.parseLong(this.equipes.getEquIdAgent());
                     if (this.var_nom_commercial == var8) {
                        this.var_nom_responsable = this.equipes.getEquIdResponsable();
                        this.mesUsersItem.clear();
                        this.mesUsersItem.add(new SelectItem(this.equipes.getEquIdResponsable(), this.equipes.getEquNomResponsable()));
                        this.var_nom_equipe = this.equipes.getEquId();
                        this.mesEquipeItem.clear();
                        this.mesEquipeItem.add(new SelectItem(this.equipes.getEquId(), this.equipes.getEquNomFr()));
                        var2 = true;
                     }
                  } else {
                     String[] var4 = this.equipes.getEquIdAgent().split(":");

                     for(var5 = 0; var5 < var4.length; ++var5) {
                        long var6 = Long.parseLong(var4[var5]);
                        if (this.var_nom_commercial == var6) {
                           this.var_nom_responsable = this.equipes.getEquIdResponsable();
                           this.mesUsersItem.clear();
                           this.mesUsersItem.add(new SelectItem(this.equipes.getEquIdResponsable(), this.equipes.getEquNomResponsable()));
                           this.var_nom_equipe = this.equipes.getEquId();
                           this.mesEquipeItem.clear();
                           this.mesEquipeItem.add(new SelectItem(this.equipes.getEquId(), this.equipes.getEquNomFr()));
                           var2 = true;
                           break;
                        }
                     }
                  }
               }

               if (var2) {
                  break;
               }

               if (this.mesUsersItem.size() <= 1) {
                  this.mesUsersItem.clear();
                  new ArrayList();
                  List var9 = this.usersDao.chargerLesSignataires("Ventes", var1);
                  if (var9.size() != 0) {
                     for(var5 = 0; var5 < var9.size(); ++var5) {
                        this.mesUsersItem.add(new SelectItem(((Users)var9.get(var5)).getUsrid(), ((Users)var9.get(var5)).getUsrPatronyme()));
                     }
                  }

                  if (this.mesUsersItem.size() == 0) {
                     this.mesUsersItem.clear();
                     this.mesUsersItem.add(new SelectItem(0, ""));
                  }
               }
            }
         }
      }

   }

   public void chargerLesSecteurs() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.inpRegion != null && !this.inpRegion.isEmpty()) {
         new Region();
         RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpRegion.split(":");
         Region var1 = var2.rechercheRegion(var3[0], (Session)null);
         if (var1 != null) {
            SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            this.mesSecteursItems = var4.listSecteurByRegionItem(var1, (Session)null);
         }
      }

   }

   public void chargerLesPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.inpSecteur != null && !this.inpSecteur.isEmpty()) {
         new Secteur();
         SecteurDao var2 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpSecteur.split(":");
         Secteur var1 = var2.rechercheSecteur(var3[0], (Session)null);
         if (var1 != null) {
            PointDeVenteDao var4 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            this.mesPdvItems = var4.listPdvBySecteurItem(var1, (Session)null);
         }
      }

   }

   public void chargerLesDepartements() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.inpSite != null && !this.inpSite.isEmpty()) {
         new Site();
         SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpSite.split(":");
         Site var1 = var2.rechercheSite(var3[0], (Session)null);
         if (var1 != null) {
            DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            this.mesDepartementsItems = var4.listDepartementBySite(var1, (Session)null);
         }
      }

   }

   public void chargerLesServices() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.inpDepartement != null && !this.inpDepartement.isEmpty()) {
         new Departement();
         DepartementDao var2 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpDepartement.split(":");
         Departement var1 = var2.rechercheDepartement(var3[0], (Session)null);
         if (var2 != null) {
            this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
            this.mesServicesItems = this.serviceDao.listServiceByDepartement(var1, (Session)null);
         }
      }

   }

   public void rechercheDOCUMENT(long var1) throws HibernateException, NamingException {
      this.lesLignesList = new ArrayList();
      this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.commandeEnteteVentes != null) {
         this.devisePrint = this.commandeEnteteVentes.getBcmDevise();
         this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, (Session)null);
      }

   }

   public void moreSearch() throws ParseException {
      this.selectDestinataire = false;
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpDestinataire = "";
         this.inpResponsable = "";
         this.inpCommercial = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpNomDestinataire = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequete(Session var1) throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpNomDestinataire = "";
      if (this.usersLog.getUsrProdService() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.inpSite = this.usersLog.getUsrSite();
         this.inpDepartement = this.usersLog.getUsrDepartement();
         this.inpService = this.usersLog.getUsrService();
      } else {
         this.inpSite = "";
         this.inpDepartement = "";
         this.inpService = "";
      }

      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteTiers() throws IOException, HibernateException, NamingException, ParseException {
      this.inpNomDestinataire = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteDestinataire() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpDestinataire = this.inpNomDestinataire;
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

      int var13;
      if (this.inpEtat != 50) {
         if (this.inpService != null && !this.inpService.isEmpty() && this.inpService.equals("100")) {
            this.inpService = "";
         }

         new ArrayList();
         List var12 = this.commandeEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpNumBCC, this.inpNumAnal, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService, this.inpMode);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new CommandeEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               CommandeEnteteVentes var16 = (CommandeEnteteVentes)var12.get(var17);
               if (var16.getBcmActivite() != null && !var16.getBcmActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getBcmActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getBcmActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getBcmActivite().contains(this.var_colonne3)) {
                        var15 = true;
                     } else {
                        var15 = false;
                     }
                  } else {
                     var15 = true;
                  }

                  if (var19 && var14 && var15) {
                     this.lesEntetesList.add(var16);
                  }
               }
            }
         } else {
            for(var13 = 0; var13 < var12.size(); ++var13) {
               this.lesEntetesList.add(var12.get(var13));
            }
         }
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new CommandeEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            CommandeEnteteVentes var18 = (CommandeEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var18.getBcmTotTtc();
            var4 += var18.getBcmTotReglement();
            var6 += var18.getBcmTotHt();
            var8 += var18.getBcmTotTva();
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
      this.inpNomDestinataire = "";
      this.inpDestinataire = "";
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
            this.commandeEnteteVentes = (CommandeEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.commandeEnteteVentes.getBcmNomTiers();
            this.inpIdTiersEnCours = this.commandeEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.commandeEnteteVentes.getBcmNomContact();
            this.var_date = this.commandeEnteteVentes.getBcmDate();
            if (this.commandeEnteteVentes.getBcmDate().getHours() <= 9) {
               this.var_heure = "0" + this.commandeEnteteVentes.getBcmDate().getHours();
            } else {
               this.var_heure = "" + this.commandeEnteteVentes.getBcmDate().getHours();
            }

            if (this.commandeEnteteVentes.getBcmDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.commandeEnteteVentes.getBcmDate().getMinutes();
            } else {
               this.var_minute = "" + this.commandeEnteteVentes.getBcmDate().getMinutes();
            }

            if (this.commandeEnteteVentes.getBcmDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.commandeEnteteVentes.getBcmDate().getSeconds();
            } else {
               this.var_seconde = "" + this.commandeEnteteVentes.getBcmDate().getSeconds();
            }

            this.tiers = this.commandeEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
            this.numeroPfManuel = this.commandeEnteteVentes.getBcmAnal4();
            this.var_nom_contact = this.commandeEnteteVentes.getBcmIdContact();
            this.var_nom_responsable = this.commandeEnteteVentes.getBcmIdResponsable();
            this.var_nom_commercial = this.commandeEnteteVentes.getBcmIdCommercial();
            this.calculDevise();
            this.chargerDocumentLigne(var6);
            this.calculMessageLitige(var6);
            double var4 = 0.0D;
            if (this.optionsVentes.getPaiementAVOIR().equals("1")) {
               var4 = this.chargerBonEncaissement(var6);
            }

            this.chargerDocumentTrace(var6);
            this.chargerLesContactsItem(var6);
            this.chargerUserChrono(var6);
            this.chargerLesUsers(var6);
            this.chargerParapheur(var6);
            this.chargerLesParcs(var6);
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

            this.format = "PDF";
            this.var_choix_modele = 0;
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.commandeEnteteVentes.getBcmTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }

            this.utilInitHibernate.closeSession();
            if (this.lesPiecesJointes.size() != 0 && !this.commandeEnteteVentes.isBcmPj()) {
               this.commandeEnteteVentes.setBcmPj(true);
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
            } else if (this.lesPiecesJointes.size() == 0 && this.commandeEnteteVentes.isBcmPj()) {
               this.commandeEnteteVentes.setBcmPj(false);
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
            }

            if (this.optionsVentes.getPaiementAVOIR().equals("1")) {
               if (this.commandeEnteteVentes.getBcmTotReglement() != var4) {
                  if (this.structureLog.getStrid() != 42L && this.structureLog.getStrid() != 43L && this.structureLog.getStrid() != 44L && this.structureLog.getStrid() != 45L) {
                     this.commandeEnteteVentes.setBcmTotReglement(var4);
                     if (Math.abs(var4) >= Math.abs(this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc())) {
                        this.commandeEnteteVentes.setBcmSolde(1);
                     } else {
                        this.commandeEnteteVentes.setBcmSolde(0);
                     }

                     this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
                  } else if (this.commandeEnteteVentes.getBcmSolde() == 0) {
                     this.commandeEnteteVentes.setBcmTotReglement(var4);
                     this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
                  }
               } else {
                  if (Math.abs(var4) >= Math.abs(this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc())) {
                     this.commandeEnteteVentes.setBcmSolde(1);
                  } else {
                     this.commandeEnteteVentes.setBcmSolde(0);
                  }

                  this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
               }
            }

            this.setMontantTtcElmt(this.commandeEnteteVentes.getBcmTotTtc());
            this.setMontantReglementElmt(this.commandeEnteteVentes.getBcmTotReglement());
            this.setMontantElmTotBonEnc(this.commandeEnteteVentes.getBcmTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.commandeEnteteVentes.getBcmTotTtc() - this.commandeEnteteVentes.getBcmTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.commandeEnteteVentes != null) {
         if (this.commandeEnteteVentes.getBcmEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.commandeEnteteVentes.getBcmDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.commandeEnteteVentes.getBcmDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.commandeEnteteVentes.getBcmId() > 0L) {
         this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.commandeEnteteVentes != null && this.commandeEnteteVentes.getBcmEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.commandeEnteteVentes.getBcmAffaire(), this.commandeEnteteVentes.getBcmAffaire()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var7 = this.reglementsDao.reglementDocument(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
      double var4 = 0.0D;
      if (var7.size() != 0) {
         this.afficheRecu = true;

         for(int var6 = 0; var6 < var7.size(); ++var6) {
            this.var_tot_bon_encaissement += ((Reglements)var7.get(var6)).getRglRecette();
            var4 += ((Reglements)var7.get(var6)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var7);
      if (this.var_tot_bon_encaissement < this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc()) {
         if (this.usersLog.getUsrFactureCaisse() == 1) {
            this.var_affiche_be = true;
            this.var_affiche_dollar = false;
         } else if (this.usersLog.getUsrFactureCaisse() == 2) {
            this.var_affiche_be = false;
            this.var_affiche_dollar = true;
         } else if (this.usersLog.getUsrFactureCaisse() == 3) {
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

      return var4;
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      this.documentTrace = new ArrayList();
      if (this.optionsVentes.getTracabilite().equals("1")) {
         if (this.commandeEnteteVentes.getBcmId() > 0L) {
            this.documentTrace = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
         }
      } else {
         ArrayList var2 = new ArrayList();
         new ArrayList();
         new ArrayList();
         ArrayList var5 = new ArrayList();
         new ArrayList();
         ArrayList var7 = new ArrayList();
         new ArrayList();
         ArrayList var9 = new ArrayList();
         new ArrayList();
         ArrayList var11 = new ArrayList();
         ArrayList var12 = new ArrayList();
         new ArrayList();
         if (this.commandeEnteteVentes.getBcmId() > 0L) {
            long var14 = this.commandeEnteteVentes.getTiers().getTieid();
            List var4 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
            if (var4.size() == 0) {
               var4 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
            }

            int var16;
            int var17;
            for(var16 = 0; var16 < var4.size(); ++var16) {
               List var6 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(((DocumentTraceVentes)var4.get(var16)).getDoctraDstId(), ((DocumentTraceVentes)var4.get(var16)).getDoctraDstType(), var1);
               if (var6.size() != 0) {
                  for(var17 = 0; var17 < var6.size(); ++var17) {
                     var5.add(var6.get(var17));
                  }
               }
            }

            for(var16 = 0; var16 < var5.size(); ++var16) {
               List var10 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(((DocumentTraceVentes)var5.get(var16)).getDoctraDstId(), ((DocumentTraceVentes)var5.get(var16)).getDoctraDstType(), var1);
               if (var10.size() != 0) {
                  for(var17 = 0; var17 < var10.size(); ++var17) {
                     var9.add(var10.get(var17));
                  }
               }
            }

            for(var16 = 0; var16 < var4.size(); ++var16) {
               List var3 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var4.get(var16)).getDoctraOrgId(), ((DocumentTraceVentes)var4.get(var16)).getDoctraOrgType(), var1);
               if (var3.size() != 0) {
                  for(var17 = 0; var17 < var3.size(); ++var17) {
                     var2.add(var3.get(var17));
                  }
               }
            }

            for(var16 = 0; var16 < var9.size(); ++var16) {
               List var13 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var9.get(var16)).getDoctraOrgId(), 26, var1);
               if (var13.size() != 0) {
                  for(var17 = 0; var17 < var13.size(); ++var17) {
                     var12.add(var13.get(var17));
                  }
               }
            }

            for(var16 = 0; var16 < var5.size(); ++var16) {
               List var8 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var5.get(var16)).getDoctraOrgId(), 24, var1);
               if (var8.size() != 0) {
                  for(var17 = 0; var17 < var8.size(); ++var17) {
                     var7.add(var8.get(var17));
                  }
               }
            }

            long var19 = (long)(this.commandeEnteteVentes.getBcmDate().getYear() + 1900 - 2);

            int var18;
            for(var18 = 0; var18 < var2.size(); ++var18) {
               if (((DocumentTraceVentes)var2.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var2.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var2.get(var18));
               }
            }

            for(var18 = 0; var18 < var4.size(); ++var18) {
               if (((DocumentTraceVentes)var4.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var4.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var4.get(var18));
               }
            }

            for(var18 = 0; var18 < var5.size(); ++var18) {
               if (((DocumentTraceVentes)var5.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var5.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var5.get(var18));
               }
            }

            for(var18 = 0; var18 < var7.size(); ++var18) {
               if (((DocumentTraceVentes)var7.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var7.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var7.get(var18));
               }
            }

            for(var18 = 0; var18 < var9.size(); ++var18) {
               if (((DocumentTraceVentes)var9.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var9.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var9.get(var18));
               }
            }

            for(var18 = 0; var18 < var11.size(); ++var18) {
               if (((DocumentTraceVentes)var11.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var11.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var11.get(var18));
               }
            }

            for(var18 = 0; var18 < var12.size(); ++var18) {
               if (((DocumentTraceVentes)var12.get(var18)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var12.get(var18)).getDoctraOrgDate().getYear() + 1900) >= var19) {
                  this.documentTrace.add(var12.get(var18));
               }
            }
         }
      }

      this.datamodelDocumentTrace.setWrappedData(this.documentTrace);
      this.documentTraceVentes = null;
      this.utilInitHibernate.closeSession();
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      this.documentTrace = new ArrayList();
      this.datamodelDocumentTrace.setWrappedData(this.documentTrace);
      this.documentTraceVentes = null;
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null && this.commandeEnteteVentes.getBcmSerie() != null && !this.commandeEnteteVentes.getBcmSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.commandeEnteteVentes.getBcmSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         this.requete = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.commandeEnteteVentes.getBcmId();
         List var1 = var2.ChargerLesEcrituresRecherche(this.requete, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.commandeEnteteVentes.getBcmDateTransfert() != null) {
            this.commandeEnteteVentes.setBcmDateTransfert((Date)null);
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.commandeEnteteVentes.getBcmActivite() != null && !this.commandeEnteteVentes.getBcmActivite().isEmpty() && this.commandeEnteteVentes.getBcmActivite().contains(":")) {
         String[] var1 = null;
         if (!this.commandeEnteteVentes.getBcmActivite().contains("#")) {
            var1 = this.commandeEnteteVentes.getBcmActivite().split(":");
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
            String[] var2 = this.commandeEnteteVentes.getBcmActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.commandeEnteteVentes.getBcmTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.commandeEnteteVentes.getBcmTotHt() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.documentTraceVentes = null;
      this.commandeEnteteVentes = new CommandeEnteteVentes();
      this.commandeLigneVentes = new CommandeLigneVentes();
      this.commandeEnteteVentes.setUsers(this.usersLog);
      this.commandeEnteteVentes.setBcmIdCreateur(this.usersLog.getUsrid());
      this.commandeEnteteVentes.setBcmNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.commandeEnteteVentes.setBcmDate(new Date());
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
      this.commandeEnteteVentes.setBcmDateLivraison((Date)null);
      this.commandeEnteteVentes.setBcmBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesPiecesJointes.clear();
      this.dataModelPieceJointes.setWrappedData(this.lesPiecesJointes);
      this.lesLignesList.clear();
      this.datamodelLigne.setWrappedData(this.lesLignesList);
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.commandeEnteteVentes.setBcmIdCommercial(this.usersLog.getUsrid());
         this.commandeEnteteVentes.setBcmNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.commandeEnteteVentes.setBcmIdResponsable(this.usersLog.getUsrid());
         this.commandeEnteteVentes.setBcmNomResponsable(this.usersLog.getUsrPatronyme());
      }

      this.mesAffairesItems.clear();
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
      this.selectDestinataire = true;
      this.var_total_marge = 0.0D;
      this.numLigne = 0;
      if (this.var_tc_type == 7) {
         this.var_tc_calcul = true;
      } else {
         this.var_tc_calcul = false;
      }

      this.showModalPanelModifDateLiv = false;
      this.showModalPanelModifBCC = false;
      this.numeroPfManuel = "";
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.autorisationDocument();
      this.modeRdv = 9;
      this.addLigne();
   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionsVentes.getNbrJrRelanceCOM() != null && !this.optionsVentes.getNbrJrRelanceCOM().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceCOM());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidCOM() != null && !this.optionsVentes.getNbrJrValidCOM().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidCOM());
      } else {
         var4 = 0;
      }

      this.commandeEnteteVentes.setBcmDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.commandeEnteteVentes.setBcmDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         if (this.usersLog.getUsrSignatureVentes() == 1) {
            this.chargerLesUsers((Session)null);
         } else if (this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.commandeEnteteVentes.getBcmIdResponsable(), this.commandeEnteteVentes.getBcmNomResponsable()));
         }

         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
         this.modeRdv = 9;
         this.addLigne();
         this.cumulPrix();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.commandeEnteteVentes.getBcmIdResponsable(), this.commandeEnteteVentes.getBcmNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.commandeEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigneProcess");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commandeEnteteVentes.getBcmEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.commandeEnteteVentes.setBcmEtat(1);
               this.commandeEnteteVentes.setBcmDateValide(new Date());
               if (this.commandeEnteteVentes.getBcmDateLivraison() == null) {
                  this.commandeEnteteVentes.setBcmDateLivraison(this.utilDate.datedevaleurTheo(this.commandeEnteteVentes.getBcmDate(), 7));
               }

               if (this.commandeEnteteVentes.getBcmHoraireLivraison() != 3) {
                  this.commandeEnteteVentes.setBcmHeureLivraison("00");
               }

               this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
               if (this.lesLignesList.size() != 0) {
                  int var3;
                  float var4;
                  if (this.commandeEnteteVentes.getBcmStock() == 1) {
                     for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
                        this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
                        if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                           var4 = this.calculStock.majCommandeVentesVAL(this.commandeLigneVentes, this.produits, 1, this.baseLog, var1);
                           this.commandeLigneVentes.setBcmligQteStock(var4);
                           this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
                        }
                     }
                  } else {
                     for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
                        this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
                        if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                           if (this.produits != null && this.produits.getProStock() >= 1) {
                              var4 = this.calculStock.majCommandeVentesATT(this.commandeLigneVentes, this.produits, 1, this.baseLog, var1);
                              this.commandeLigneVentes.setBcmligQteStock(var4);
                              this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
                           }
                        }
                     }
                  }
               }

               if (this.structureLog.getStrtypeentreprise().equals("2") && this.optionsVentes.getGenerationBcFab().contains("1")) {
                  this.generationFabrication(this.commandeEnteteVentes, this.lesLignesList, var1);
               }

               if (this.optionsVentes.getAxeDossier().equals("2") && this.commandeEnteteVentes.getBcmAffaire() != null && !this.commandeEnteteVentes.getBcmAffaire().isEmpty()) {
                  String var21 = "";
                  String var22 = "";
                  String var5 = "";
                  String var6 = "";
                  PlansAnalytiquesDao var7 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
                  LectureNatureAffaires var8 = new LectureNatureAffaires();
                  var8.setStrId(this.structureLog.getStrid());
                  var8.setStructureLog(this.structureLog);
                  var8.chargerMesNaturesAffaires();
                  new ArrayList();
                  List var9 = var8.getMesNatures();

                  for(int var10 = 0; var10 < var9.size(); ++var10) {
                     if (this.commandeEnteteVentes.getBcmAffaire().startsWith(((ObjetNatureAffaires)var9.get(var10)).getCode())) {
                        var21 = ((ObjetNatureAffaires)var9.get(var10)).getAnalytique();
                        var22 = ((ObjetNatureAffaires)var9.get(var10)).getCode();
                        break;
                     }
                  }

                  if (var21 == null || var21.isEmpty()) {
                     var21 = "99";
                  }

                  String var11;
                  if (this.commandeEnteteVentes.getBcmAnal4() != null && !this.commandeEnteteVentes.getBcmAnal4().isEmpty()) {
                     var6 = this.commandeEnteteVentes.getBcmAnal4();
                     this.plansAnalytiques = var7.rechercheAffaire(this.commandeEnteteVentes.getBcmAffaire(), var1);
                     if (this.plansAnalytiques != null) {
                        var5 = this.plansAnalytiques.getAnaIndice();
                     } else {
                        var5 = "A";
                     }
                  } else {
                     this.plansAnalytiques = var7.rechercheAffaire(this.commandeEnteteVentes.getBcmAffaire(), var1);
                     if (this.plansAnalytiques != null && (this.plansAnalytiques == null || this.plansAnalytiques.getAnaAnalytique() != null && !this.plansAnalytiques.getAnaAnalytique().isEmpty() && this.plansAnalytiques.getAnaIndice() != null && !this.plansAnalytiques.getAnaIndice().isEmpty())) {
                        if (this.plansAnalytiques != null) {
                           var6 = this.plansAnalytiques.getAnaAnalytique();
                           var5 = this.plansAnalytiques.getAnaIndice();
                        } else {
                           var6 = this.commandeEnteteVentes.getBcmAffaire();
                           var5 = "A";
                        }
                     } else {
                        var6 = this.calculChrono.numCompose(this.commandeEnteteVentes.getBcmDate(), 128, this.commandeEnteteVentes.getBcmSerie(), var1);
                        if (var6 != null && !var6.isEmpty()) {
                           var6 = var22 + var6;
                        } else {
                           var6 = this.commandeEnteteVentes.getBcmAffaire();
                        }

                        new ArrayList();
                        var11 = "bcmAffaire = '" + this.commandeEnteteVentes.getBcmAffaire() + "'";
                        List var24 = this.commandeEnteteVentesDao.rechercheCommandeRequete(var11, var1);
                        if (var24.size() != 0) {
                           int var12 = var24.size();
                           if (var12 <= 25) {
                              var5 = this.calculIndice(var12);
                           } else if (var12 >= 26 && var12 <= 50) {
                              var5 = "A" + this.calculIndice(var12 - 25);
                           }
                        } else {
                           var5 = "A";
                        }
                     }

                     this.commandeEnteteVentes.setBcmAnal4(var6 + var5);
                     this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
                  }

                  String var25 = "";
                  var11 = "cot_affaire='" + this.commandeEnteteVentes.getBcmAffaire() + "'";
                  new ArrayList();
                  CotationEnteteAchatsDao var13 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  List var26 = var13.rechercheCotationRequete(var11, var1);
                  if (var26.size() != 0) {
                     var25 = ((CotationEnteteAchats)var26.get(0)).getCotNomTiers();
                  }

                  PlansAnalytiques var14;
                  if (var21.equals("7")) {
                     new PlansAnalytiques();
                     var14 = var7.rechercheAnal("7", var6, var1);
                     if (var14 == null) {
                        var14 = new PlansAnalytiques();
                        var14.setAnaNature("7");
                        var14.setAnaAffaireEtat(0);
                        var14.setAnaAnnee("" + (this.plansAnalytiques.getAnaAffaireDateDemande().getYear() + 1900));
                        var14.setAnaCode(var6);
                        var14.setAnaDateCreat(new Date());
                        var14.setAnaUserCreat(this.usersLog.getUsrid());
                        var14.setAnaNomFr(this.plansAnalytiques.getAnaAffaireNomClient() + "/" + var25);
                        var7.insert(var14, var1);
                     }
                  } else if (var21.equals("8")) {
                     new PlansAnalytiques();
                     var14 = var7.rechercheAnal("8", var6, var1);
                     if (var14 == null) {
                        var14 = new PlansAnalytiques();
                        var14.setAnaNature("8");
                        var14.setAnaAffaireEtat(0);
                        var14.setAnaAnnee("" + (this.plansAnalytiques.getAnaAffaireDateDemande().getYear() + 1900));
                        var14.setAnaCode(var6);
                        var14.setAnaDateCreat(new Date());
                        var14.setAnaUserCreat(this.usersLog.getUsrid());
                        var14.setAnaNomFr(this.plansAnalytiques.getAnaAffaireNomClient() + "/" + var25);
                        var7.insert(var14, var1);
                     }
                  } else if (var21.equals("99")) {
                     ActivitesDao var27 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
                     new Activites();
                     Activites var15 = var27.rechercheActivite(var6, var1);
                     if (var15 == null) {
                        var15 = new Activites();
                        var15.setActOptions(7);
                        var15.setActCode(var6);
                        var15.setActDateCreat(new Date());
                        var15.setActUserCreat(this.usersLog.getUsrid());
                        var15.setActNomFr(this.plansAnalytiques.getAnaAffaireNomClient() + "/" + var25);
                        var27.insert(var15, var1);
                     }
                  }

                  if (var6 != null && !var6.isEmpty()) {
                     new PlansAnalytiques();
                     var14 = var7.rechercheAffaire(this.commandeEnteteVentes.getBcmAffaire(), var1);
                     if (var14 != null) {
                        var14.setAnaAnalytique(var6);
                        var14.setAnaIndice(var5);
                        var7.modif(var14, var1);
                     }
                  }
               }

               Espion var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Validation manuelle commande (C.) N° " + this.commandeEnteteVentes.getBcmNum() + " du " + this.utilDate.dateToStringSQLLight(this.commandeEnteteVentes.getBcmDate()));
               this.espionDao.mAJEspion(var23, var1);
            }

            if (this.tiers.getTieDteDocument2() == null || this.commandeEnteteVentes.getBcmDate().after(this.tiers.getTieDteDocument2())) {
               this.tiers.setTieDteDocument2(this.commandeEnteteVentes.getBcmDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
            }

            var2.commit();
         } catch (HibernateException var19) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public String calculIndice(int var1) {
      String var2 = "";
      if (var1 == 1) {
         var2 = "A";
      } else if (var1 == 2) {
         var2 = "B";
      } else if (var1 == 3) {
         var2 = "C";
      } else if (var1 == 4) {
         var2 = "D";
      } else if (var1 == 5) {
         var2 = "E";
      } else if (var1 == 6) {
         var2 = "F";
      } else if (var1 == 7) {
         var2 = "G";
      } else if (var1 == 8) {
         var2 = "H";
      } else if (var1 == 9) {
         var2 = "I";
      } else if (var1 == 10) {
         var2 = "J";
      } else if (var1 == 11) {
         var2 = "K";
      } else if (var1 == 12) {
         var2 = "L";
      } else if (var1 == 13) {
         var2 = "M";
      } else if (var1 == 14) {
         var2 = "N";
      } else if (var1 == 15) {
         var2 = "O";
      } else if (var1 == 16) {
         var2 = "P";
      } else if (var1 == 17) {
         var2 = "Q";
      } else if (var1 == 18) {
         var2 = "R";
      } else if (var1 == 19) {
         var2 = "S";
      } else if (var1 == 20) {
         var2 = "T";
      } else if (var1 == 21) {
         var2 = "U";
      } else if (var1 == 22) {
         var2 = "V";
      } else if (var1 == 23) {
         var2 = "W";
      } else if (var1 == 24) {
         var2 = "X";
      } else if (var1 == 25) {
         var2 = "Y";
      } else if (var1 == 26) {
         var2 = "Z";
      }

      return var2;
   }

   public void generationFabrication(CommandeEnteteVentes var1, List var2, Session var3) throws HibernateException, NamingException {
      new ProcessEnteteAchats();
      ProcessEnteteAchatsDao var5 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new ProcessLigneAchats();
      ProcessLigneAchatsDao var7 = new ProcessLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      new FabricationEnteteAchats();
      FabricationEnteteAchatsDao var9 = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new FabricationLigneAchats();
      FabricationLigneAchatsDao var11 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      if (var2.size() != 0) {
         new ExercicesAchats();
         ExercicesAchatsDao var13 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
         ExercicesAchats var12 = var13.recupererLastExo(var3);
         if (var12 != null) {
            for(int var14 = 0; var14 < var2.size(); ++var14) {
               this.commandeLigneVentes = (CommandeLigneVentes)var2.get(var14);
               if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && !this.commandeLigneVentes.getBcmligCode().equals("=") && !this.commandeLigneVentes.getBcmligCode().equals("-")) {
                  ProcessEnteteAchats var4 = var5.rechercheProcess(this.commandeLigneVentes.getBcmligCode(), var3);
                  if (var4 != null) {
                     String var15 = "";
                     if (var1.getBcmSerie() != null && !var1.getBcmSerie().equalsIgnoreCase("X") && !var1.getBcmSerie().isEmpty()) {
                        var15 = this.calculChrono.numCompose(var1.getBcmDate(), 34, var1.getBcmSerie(), var3);
                     } else {
                        long var16 = var9.selectLastNum(var3);
                        var15 = "" + var16;
                     }

                     FabricationEnteteAchats var8 = new FabricationEnteteAchats();
                     var8.setExercicesAchats(var12);
                     var8.setFabActivite(var4.getProcesActivite());
                     var8.setFabAnal2(var1.getBcmAnal2());
                     var8.setFabAnal4(var1.getBcmAnal4());
                     var8.setFabAtelier(var4.getProcesAtelier());
                     var8.setFabCoef(var4.getProcesCoef());
                     var8.setFabCommande(var1.getBcmNum());
                     var8.setFabDate(var1.getBcmDate());
                     var8.setFabDateAnnule((Date)null);
                     var8.setFabDateCreat(new Date());
                     var8.setFabDateImp((Date)null);
                     var8.setFabDateModif((Date)null);
                     var8.setFabDateValide((Date)null);
                     var8.setFabDepot(var4.getProcesDepot());
                     var8.setFabEtat(0);
                     var8.setFabEtatVal(0);
                     var8.setFabFamille(this.commandeLigneVentes.getBcmligFamille());
                     var8.setFabGele(0);
                     var8.setFabIdCreateur(this.usersLog.getUsrid());
                     var8.setFabIdEquipe(var1.getBcmIdEquipe());
                     var8.setFabIdModif(0L);
                     var8.setFabIdResponsable(var1.getBcmIdResponsable());
                     var8.setFabInfo1(var1.getBcmInfo1());
                     var8.setFabInfo2(var1.getBcmInfo2());
                     var8.setFabInfo3(var1.getBcmInfo3());
                     var8.setFabInfo4(var1.getBcmInfo4());
                     var8.setFabInfo5(var1.getBcmInfo5());
                     var8.setFabInfo6(var1.getBcmInfo6());
                     var8.setFabInfo7(var1.getBcmInfo7());
                     var8.setFabInfo8(var1.getBcmInfo8());
                     var8.setFabInfo9(var1.getBcmInfo9());
                     var8.setFabInfo10(var1.getBcmInfo10());
                     var8.setFabLibClient(var4.getProcesLibClient());
                     var8.setFabLibTech(var4.getProcesLibTech());
                     var8.setFabLigne(var4.getProcesLigne());
                     var8.setFabMode(var4.getProcesMode());
                     var8.setFabModeleImp("");
                     var8.setFabMotifAnnule("");
                     var8.setFabNomCreateur(this.usersLog.getUsrPatronyme());
                     var8.setFabNomEquipe(var1.getBcmNomEquipe());
                     var8.setFabNomModif("");
                     var8.setFabNomResponsable(var1.getBcmNomResponsable());
                     var8.setFabNum(var15);
                     var8.setFabObject(var1.getBcmObject());
                     var8.setFabOption1(var4.getProcesOption1());
                     var8.setFabProcess(var4.getProcesCode());
                     var8.setFabQte(this.commandeLigneVentes.getBcmligQte());
                     var8.setFabQuart(1);
                     var8.setFabSerie(var1.getBcmSerie());
                     var8.setFabSite(var4.getProcesSite());
                     var8.setFabTotPump(var4.getProcesTotPump());
                     var8.setFabUnite(var4.getProcesUnite());
                     var8 = var9.insert(var8, var3);
                     new ArrayList();
                     List var18 = var7.chargerDetailProcess(var4, var3);
                     if (var18.size() != 0) {
                        for(int var17 = 0; var17 < var18.size(); ++var17) {
                           ProcessLigneAchats var6 = (ProcessLigneAchats)var18.get(var17);
                           FabricationLigneAchats var10 = new FabricationLigneAchats();
                           var10.setFabligCasier("");
                           var10.setFabligCode(var6.getProcesligCode());
                           var10.setFabligCondition("");
                           var10.setFabligDepot(var6.getProcesligDepot());
                           var10.setFabligDescription("");
                           var10.setFabligDiam(0.0F);
                           var10.setFabligFamille("");
                           var10.setFabligHaut(0.0F);
                           var10.setFabligHh(var6.getProcesligHh());
                           if (var6.getProcesligProduitInterchangeable() != null && !var6.getProcesligProduitInterchangeable().isEmpty()) {
                              var10.setFabligInterChange(true);
                           } else {
                              var10.setFabligInterChange(false);
                           }

                           var10.setFabligJj(var6.getProcesligJj());
                           var10.setFabligLarg(0.0F);
                           var10.setFabligLibelle(var6.getProcesligLibClient());
                           var10.setFabligLong(0.0F);
                           var10.setFabligMateriel(var6.getProcesligMateriel());
                           var10.setFabligMetier(var6.getProcesligMetier());
                           var10.setFabligMm(var6.getProcesligMm());
                           var10.setFabligNb(0.0F);
                           var10.setFabligObs("");
                           var10.setFabligOrdre(var6.getProcesligOrdre());
                           var10.setFabligPoidsBrut(0.0F);
                           var10.setFabligPoidsNet(0.0F);
                           var10.setFabligProduitInterchangeable(var6.getProcesligProduitInterchangeable());
                           var10.setFabligPump(var6.getProcesligPrht());
                           var10.setFabligQte((float)var6.getProcesligQte());
                           var10.setFabligQteReference(var6.getProcesligQte());
                           var10.setFabligQteStock(0.0F);
                           var10.setFabligQteUtil(0.0F);
                           var10.setFabligReference("");
                           var10.setFabligSs(var6.getProcesligSs());
                           var10.setFabligStock(1);
                           var10.setFabligTotal(0.0D);
                           var10.setFabligType(var6.getProcesligType());
                           var10.setFabligUnite(var6.getProcesligUnite());
                           var10.setFabligVolume(0.0F);
                           var10.setFabricationEnteteAchats(var8);
                           var11.insertLigne(var10, var3);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commandeEnteteVentes.getBcmEtat() == 1) {
               this.commandeEnteteVentes.setBcmEtat(0);
               this.commandeEnteteVentes.setBcmDateValide((Date)null);
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
               new ArrayList();
               List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
               int var4;
               if (var3.size() != 0) {
                  for(var4 = 0; var4 < var3.size(); ++var4) {
                     this.bonEncaissementVente = (BonEncaissementVente)var3.get(var4);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
                  }
               }

               this.var_tot_bon_encaissement = 0.0D;
               if (this.lesLignesList.size() != 0) {
                  if (this.commandeEnteteVentes.getBcmStock() == 1) {
                     this.calculStock.majCommandeVentesVAL(this.lesLignesList, 0, this.baseLog, var1);
                  } else {
                     for(var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
                        this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var4);
                        if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                           if (this.produits != null && this.produits.getProStock() >= 1) {
                              this.calculStock.majCommandeVentesATT(this.commandeLigneVentes, this.produits, 0, this.baseLog, var1);
                           }
                        }
                     }
                  }
               }

               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Dévalidation manuelle commande (C.) N° " + this.commandeEnteteVentes.getBcmNum() + " du " + this.utilDate.dateToStringSQLLight(this.commandeEnteteVentes.getBcmDate()));
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
      if (this.commandeEnteteVentes != null) {
         this.commandeEnteteVentes.setBcmEtat(0);
         this.commandeEnteteVentes.setBcmDateAnnule((Date)null);
         this.commandeEnteteVentes.setBcmMotifAnnule("");
         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.commandeEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.commandeEnteteVentes.getBcmId();
            String var5 = this.commandeEnteteVentes.getBcmNum();
            Date var6 = this.commandeEnteteVentes.getBcmDate();
            this.commandeLigneVentesDao.deleteAllLigne(this.commandeEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
            this.commandeEnteteVentesDao.delete(this.commandeEnteteVentes.getBcmId(), var1);
            if (this.lesPiecesJointes.size() != 0) {
               for(int var7 = 0; var7 < this.lesPiecesJointes.size(); ++var7) {
                  String var8 = ((FileCtrl)this.lesPiecesJointes.get(var7)).toString();
                  File var9 = new File(this.cheminPieceJointes + var8);
                  if (var9.exists()) {
                     var9.delete();
                  }
               }
            }

            this.documentTraceVentes = new DocumentTraceVentes();
            this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(var3, this.nature, var1);
            if (this.documentTraceVentes != null) {
               long var18 = this.documentTraceVentes.getDoctraOrgId();
               int var20 = this.documentTraceVentes.getDoctraOrgType();
               this.documentTraceVentesDao.delete(this.documentTraceVentes, var1);
               boolean var10 = false;
               this.documentTraceVentes = this.documentTraceVentesDao.chercherOrigineTrace(var18, var20, var1);
               byte var21;
               if (this.documentTraceVentes != null) {
                  var21 = 4;
               } else {
                  var21 = 1;
               }

               if (var20 == 21) {
                  new DevisEnteteVentes();
                  DevisEnteteVentesDao var12 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  DevisEnteteVentes var11 = var12.pourParapheur(var18, var1);
                  if (var11 != null) {
                     var11.setDvsEtat(var21);
                     if (var21 == 1) {
                        var11.setDvsDateTransforme((Date)null);
                        var11.setDvsTypeTransforme(0);
                     }

                     var12.modif(var11, var1);
                  }
               }
            }

            Espion var19 = new Espion();
            var19.setUsers(this.usersLog);
            var19.setEsptype(0);
            var19.setEspdtecreat(new Date());
            var19.setEspaction("Suppression commande N° " + var5 + " du " + var6);
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
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.commandeEnteteVentes.getBcmId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.commandeEnteteVentes.setUsers(this.usersLog);
            this.commandeEnteteVentes.setBcmIdCreateur(this.usersLog.getUsrid());
            this.commandeEnteteVentes.setBcmNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.commandeEnteteVentes.setBcmDate(new Date());
            this.commandeEnteteVentes.setBcmDateCreat(new Date());
            this.commandeEnteteVentes.setBcmDateModif((Date)null);
            this.commandeEnteteVentes.setBcmIdModif(0L);
            this.commandeEnteteVentes.setBcmNomModif("");
            this.commandeEnteteVentes.setBcmNum("");
            this.commandeEnteteVentes.setBcmIdResponsable(this.usersLog.getUsrid());
            this.commandeEnteteVentes.setBcmNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.commandeEnteteVentes.setBcmDateLivraison((Date)null);
            if (!this.commandeEnteteVentes.getBcmSerie().equalsIgnoreCase("X") && !this.commandeEnteteVentes.getBcmSerie().isEmpty()) {
               this.commandeEnteteVentes.setBcmNum(this.calculChrono.numCompose(this.commandeEnteteVentes.getBcmDate(), this.nature, this.commandeEnteteVentes.getBcmSerie(), var1));
            } else {
               long var3 = this.commandeEnteteVentesDao.selectLastNum(var1);
               this.commandeEnteteVentes.setBcmNum("" + var3);
            }

            this.verifieExistenceHabilitation(var1);
            this.commandeEnteteVentes.setBcmDateAnnule((Date)null);
            this.commandeEnteteVentes.setBcmMotifAnnule("");
            this.commandeEnteteVentes.setBcmDateImp((Date)null);
            this.commandeEnteteVentes.setBcmDateTransforme((Date)null);
            this.commandeEnteteVentes.setBcmDateLastReg((Date)null);
            this.commandeEnteteVentes.setBcmEtat(0);
            this.commandeEnteteVentes.setBcmContener("");
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.duppliquer(this.commandeEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               this.commandeLigneVentesDao.duppliquerLigne(this.lesLignesList, this.commandeEnteteVentes, var1);
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

         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.commandeEnteteVentes.getBcmId(), this.commandeEnteteVentes.getBcmNum(), this.commandeEnteteVentes.getBcmNomTiers(), this.commandeEnteteVentes.getBcmDate(), this.commandeEnteteVentes.getBcmDevise(), this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc(), this.commandeEnteteVentes.getBcmModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(this.commandeEnteteVentes.getBcmModeleImp()), this.calculeParc(var1), this.commandeEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
      }

   }

   public void uniciteNumBcclient() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes.getBcmNumClient() != null && !this.commandeEnteteVentes.getBcmNumClient().isEmpty()) {
         new CommandeEnteteVentes();
         CommandeEnteteVentes var1 = this.commandeEnteteVentesDao.rechercheCommandeByNumClient(this.commandeEnteteVentes.getBcmNumClient(), this.tiers, this.commandeEnteteVentes.getBcmId(), (Session)null);
         if (var1 != null) {
            String var2 = "Le numéro de commande client " + this.commandeEnteteVentes.getBcmNumClient() + " existe déjà. Veuillez en utiliser un autre.";
            this.formRecherche.setMessageTexte(var2);
            this.formRecherche.setShowModalPanelMessage(true);
            this.commandeEnteteVentes.setBcmNumClient("");
         }
      }

   }

   public void razNumreoPortefeuille() {
      this.numeroPfManuel = "";
   }

   public void transformerDocument() throws HibernateException, NamingException {
      this.documentDetailTrf.clear();
      this.lesLignesList.clear();
      this.var_date_trf = new Date();
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         boolean var4 = false;
         if (this.commandeEnteteVentes.getBcmTypeTransforme() != 0) {
            var4 = this.usersChronoDao.existByUserNat(this.usersLog, this.commandeEnteteVentes.getBcmTypeTransforme(), var1);
            if (var4) {
               String var5 = "";
               if (this.commandeEnteteVentes.getBcmTypeTransforme() == 22) {
                  var5 = "Bon de commande";
               } else if (this.commandeEnteteVentes.getBcmTypeTransforme() == 23) {
                  var5 = "Bon de livraison";
               } else if (this.commandeEnteteVentes.getBcmTypeTransforme() == 24) {
                  var5 = "Bon de retour";
               } else if (this.commandeEnteteVentes.getBcmTypeTransforme() == 25) {
                  var5 = "Facture";
               } else if (this.commandeEnteteVentes.getBcmTypeTransforme() == 26) {
                  var5 = "Avoir";
               } else if (this.commandeEnteteVentes.getBcmTypeTransforme() == 27) {
                  var5 = "Note de débit";
               } else if (this.commandeEnteteVentes.getBcmTypeTransforme() == 28) {
                  var5 = "Chargement";
               }

               this.documentTrfItems.add(new SelectItem(this.commandeEnteteVentes.getBcmTypeTransforme(), var5));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 23, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(23, "Bon de livraison"));
            }

            if (this.optionsVentes.getDepotChargementDefaut() != null && this.optionsVentes.getDepotChargementDefaut().contains(":")) {
               var3 = this.usersChronoDao.existByUserNat(this.usersLog, 28, var1);
               if (var3) {
                  this.documentTrfItems.add(new SelectItem(28, "Chargement"));
               }
            }
         }

         for(int var9 = 0; var9 < this.lesEntetesList.size(); ++var9) {
            new CommandeEnteteVentes();
            CommandeEnteteVentes var6 = (CommandeEnteteVentes)this.lesEntetesList.get(var9);
            if (var6.getBcmId() > 0L && var6.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(var6, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                     new CommandeLigneVentes();
                     CommandeLigneVentes var8 = (CommandeLigneVentes)this.lesLignesList.get(var7);
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

   public void annule() throws IOException, JDOMException, HibernateException, NamingException, Exception {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      if (this.commandeEnteteVentes != null && this.plafondEnCours != 0.0D) {
         this.save();
      }

   }

   public void chargerModeEcheanceAffichage() {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      if (this.commandeEnteteVentes.getBcmTypeReg() != 0 && this.commandeEnteteVentes.getBcmTypeReg() != 3) {
         if (this.commandeEnteteVentes.getBcmTypeReg() != 1 && this.commandeEnteteVentes.getBcmTypeReg() != 2 && this.commandeEnteteVentes.getBcmTypeReg() != 10) {
            if (this.commandeEnteteVentes.getBcmTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.commandeEnteteVentes.getBcmModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.commandeEnteteVentes.getBcmModeReg() != null && !this.commandeEnteteVentes.getBcmModeReg().isEmpty() && this.commandeEnteteVentes.getBcmModeReg().contains(":")) {
         String[] var2 = this.commandeEnteteVentes.getBcmModeReg().split(":");
         var1 = var2[0];
      }

      ObjetReglement var3;
      int var6;
      for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
         new ObjetReglement();
         var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
         if (var3.getCategories().equals(var1)) {
            if (var3.getEcheances() == null || var3.getEcheances().isEmpty()) {
               var3.setEcheances("0");
            }

            this.commandeEnteteVentes.setBcmTypeReg(Integer.parseInt(var3.getEcheances()));
            this.commandeEnteteVentes.setBcmModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.commandeEnteteVentes.setBcmNbJourReg(0);
            this.commandeEnteteVentes.setBcmArrondiReg(0);
            break;
         }
      }

      if (this.commandeEnteteVentes.getBcmTypeReg() != 0 && this.commandeEnteteVentes.getBcmTypeReg() != 3) {
         if (this.commandeEnteteVentes.getBcmTypeReg() != 1 && this.commandeEnteteVentes.getBcmTypeReg() != 2 && this.commandeEnteteVentes.getBcmTypeReg() != 10) {
            if (this.commandeEnteteVentes.getBcmTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.commandeEnteteVentes.setBcmTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.commandeEnteteVentes.setBcmModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.commandeEnteteVentes.setBcmNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.commandeEnteteVentes.setBcmArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.commandeEnteteVentes.getBcmModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.commandeEnteteVentes.getBcmDate(), this.commandeEnteteVentes.getBcmTypeReg(), this.commandeEnteteVentes.getBcmNbJourReg(), this.commandeEnteteVentes.getBcmArrondiReg());
      this.commandeEnteteVentes.setBcmDateEcheReg(var1);
   }

   public void preSave() throws IOException, HibernateException, NamingException, Exception {
      boolean var1 = false;
      String var2 = "";
      if (this.optionsVentes.getResponsable().equals("0")) {
         if (this.var_nom_responsable != 0L) {
            var1 = true;
         } else {
            var2 = "Il manque le responsable...";
         }
      } else if (this.optionsVentes.getResponsable().equals("1")) {
         if (this.var_nom_responsable != 0L && this.var_nom_commercial != 0L) {
            var1 = true;
         } else {
            var2 = "Il manque le responsable ou le commercial...";
         }
      } else if (this.optionsVentes.getResponsable().equals("2")) {
         if (this.var_nom_responsable != 0L && this.var_nom_commercial != 0L) {
            var1 = true;
         } else {
            var2 = "Il manque le responsable ou le commercial...";
         }
      }

      if (var1) {
         if (this.commandeEnteteVentes.getBcmId() != 0L) {
            this.showModalPanelValidationDocument = true;
         } else {
            this.save();
         }
      } else {
         this.formRecherche.setMessageTexte(var2);
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.commandeEnteteVentes.setBcmDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.commandeEnteteVentes.getUsers() == null) {
            this.commandeEnteteVentes.setUsers(this.usersLog);
         }

         if (this.tiers.getTietype().equals("1") || this.tiers.getTietype().equals("2")) {
            this.tiers.setTietype("3");
            if (!this.tiers.getTiegenre().equals("010") && !this.tiers.getTiegenre().equals("020")) {
               if (this.tiers.getTiegenre().equals("011") || this.tiers.getTiegenre().equals("021")) {
                  this.tiers.setTiegenre("031");
               }
            } else {
               this.tiers.setTiegenre("030");
            }

            this.tiers = this.tiersDao.modif(this.tiers, var1);
         }

         this.commandeEnteteVentes.setTiers(this.tiers);
         if ((this.commandeEnteteVentes.getBcmCat() == null || this.commandeEnteteVentes.getBcmCat().isEmpty()) && this.commandeEnteteVentes.getTiers().getTienomfamille() != null && !this.commandeEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.commandeEnteteVentes.setBcmCat(this.commandeEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.commandeEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.commandeEnteteVentes.setBcmCivilTiers("");
         } else {
            this.commandeEnteteVentes.setBcmCivilTiers(this.commandeEnteteVentes.getTiers().getTiecivilite());
         }

         if (this.commandeEnteteVentes.getBcmDateLivraison() == null) {
            this.commandeEnteteVentes.setBcmDateLivraison(this.utilDate.datedevaleurTheo(this.commandeEnteteVentes.getBcmDate(), 7));
         }

         if (this.commandeEnteteVentes.getBcmHoraireLivraison() != 3) {
            this.commandeEnteteVentes.setBcmHeureLivraison("00");
         }

         if (!this.contDest) {
            new Contacts();
            Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
            if (var3 != null) {
               this.commandeEnteteVentes.setBcmIdContact(var3.getConid());
               if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                  this.commandeEnteteVentes.setBcmNomContact(var3.getConpatronyme());
                  this.commandeEnteteVentes.setBcmCivilContact(var3.getConcivilite());
               } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                  this.commandeEnteteVentes.setBcmNomContact(var3.getConservice());
                  this.commandeEnteteVentes.setBcmCivilContact("SERVICE/SITE:");
               } else {
                  this.commandeEnteteVentes.setBcmIdContact(0L);
                  this.commandeEnteteVentes.setBcmNomContact("");
                  this.commandeEnteteVentes.setBcmCivilContact("");
               }
            } else {
               this.commandeEnteteVentes.setBcmIdContact(0L);
               this.commandeEnteteVentes.setBcmNomContact("");
               this.commandeEnteteVentes.setBcmCivilContact("");
            }

            this.commandeEnteteVentes.setBcmTiersRegroupe(this.tiers.getTiesigle());
         }

         this.commandeEnteteVentes.setBcmIdResponsable(0L);
         this.commandeEnteteVentes.setBcmNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.commandeEnteteVentes.setBcmIdResponsable(var15.getUsrid());
            this.commandeEnteteVentes.setBcmNomResponsable(var15.getUsrPatronyme());
         }

         this.commandeEnteteVentes.setBcmIdCommercial(0L);
         this.commandeEnteteVentes.setBcmNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.commandeEnteteVentes.setBcmIdCommercial(var4.getUsrid());
               this.commandeEnteteVentes.setBcmNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.commandeEnteteVentes.setBcmIdEquipe(0L);
         this.commandeEnteteVentes.setBcmNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.commandeEnteteVentes.getBcmIdResponsable(), var1);
            if (this.equipes != null) {
               this.commandeEnteteVentes.setBcmIdEquipe(this.equipes.getEquId());
               this.commandeEnteteVentes.setBcmNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc(), var16, this.commandeEnteteVentes.getBcmDevise(), this.commandeEnteteVentes.getBcmDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.commandeEnteteVentes.getBcmDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.commandeEnteteVentes.getBcmDevise());
               this.commandeEnteteVentes.setBcmFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.commandeEnteteVentes.getBcmDevise(), this.commandeEnteteVentes.getBcmDate()));
            }
         }

         if (this.accesAffaires) {
         }

         this.commandeEnteteVentes.setBcmStock(this.gestionStock);
         if (this.commandeEnteteVentes.getBcmId() != 0L) {
            if (this.commandeEnteteVentes.getBcmEtat() == 6) {
               if (this.commandeEnteteVentes.getBcmEtatVal() == 1) {
                  this.commandeEnteteVentes.setBcmEtat(0);
               } else {
                  this.commandeEnteteVentes.setBcmEtat(0);
               }
            }

            this.commandeEnteteVentes.setBcmDateModif(new Date());
            this.commandeEnteteVentes.setBcmIdModif(this.usersLog.getUsrid());
            this.commandeEnteteVentes.setBcmNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var16);
               this.commandeLigneVentes.setBcmligOrdre(var16);
               this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
            }
         } else {
            this.commandeEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.commandeEnteteVentes.setBcmDateCreat(new Date());
            this.commandeEnteteVentes.setBcmIdCreateur(this.usersLog.getUsrid());
            this.commandeEnteteVentes.setBcmNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.commandeEnteteVentes.getBcmSerie() != null && !this.commandeEnteteVentes.getBcmSerie().equalsIgnoreCase("X") && !this.commandeEnteteVentes.getBcmSerie().isEmpty()) {
               this.commandeEnteteVentes.setBcmNum(this.calculChrono.numCompose(this.commandeEnteteVentes.getBcmDate(), this.nature, this.commandeEnteteVentes.getBcmSerie(), var1));
               boolean var18 = false;

               label423:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label423;
                     }

                     new CommandeEnteteVentes();
                     CommandeEnteteVentes var19 = this.commandeEnteteVentesDao.pourParapheurByNum(this.commandeEnteteVentes.getBcmNum(), this.commandeEnteteVentes.getBcmSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.commandeEnteteVentes.setBcmNum(this.calculChrono.numCompose(this.commandeEnteteVentes.getBcmDate(), this.nature, this.commandeEnteteVentes.getBcmSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.commandeEnteteVentesDao.selectLastNum(var1);
               this.commandeEnteteVentes.setBcmNum("" + var17);
            }

            this.commandeEnteteVentes.setBcmEtat(0);
            this.commandeEnteteVentes.setBcmEtatVal(0);
            this.commandeEnteteVentes.setBcmDateValide((Date)null);
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.insert(this.commandeEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.commandeEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.commandeEnteteVentes.getBcmId(), this.commandeEnteteVentes.getBcmNum(), this.commandeEnteteVentes.getBcmNomTiers(), this.commandeEnteteVentes.getBcmDate(), this.commandeEnteteVentes.getBcmDevise(), this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc(), this.commandeEnteteVentes.getBcmModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(this.commandeEnteteVentes.getBcmModeleImp()), this.calculeParc(var1), this.commandeEnteteVentes.getVar_format_devise(), 0, var1);
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

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.commandeEnteteVentes.setBcmSite(this.usersLog.getUsrSite());
      this.commandeEnteteVentes.setBcmDepartement(this.usersLog.getUsrDepartement());
      this.commandeEnteteVentes.setBcmService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.commandeEnteteVentes.setBcmIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.commandeEnteteVentes.getBcmNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.commandeEnteteVentes.setBcmTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.commandeEnteteVentes.setBcmRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.commandeEnteteVentes.setBcmSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.commandeEnteteVentes.setBcmPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.commandeEnteteVentes.setBcmTiersRegroupe(this.tiers.getTiesigle());
            this.commandeEnteteVentes.setBcmRegion(this.tiers.getTieregion());
            this.commandeEnteteVentes.setBcmSecteur(this.tiers.getTiesecteur());
            this.commandeEnteteVentes.setBcmPdv(this.tiers.getTiepdv());
         }
      } else {
         this.commandeEnteteVentes.setBcmTiersRegroupe(this.tiers.getTiesigle());
         this.commandeEnteteVentes.setBcmRegion(this.tiers.getTieregion());
         this.commandeEnteteVentes.setBcmSecteur(this.tiers.getTiesecteur());
         this.commandeEnteteVentes.setBcmPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.commandeEnteteVentes.setBcmActivite("");
      } else {
         String var2;
         boolean var3;
         if (this.optionsVentes.getActiviteEnteteLigne().equals("0")) {
            if (this.decoupageActivite) {
               var2 = "";
               var3 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(int var4 = 0; var4 < this.lesDecoupagesActivites.size(); ++var4) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var4);
                     if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                        if (var3) {
                           var2 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                           var3 = false;
                        } else {
                           var2 = var2 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        }
                     }
                  }
               }

               this.commandeEnteteVentes.setBcmActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new CommandeLigneVentes();
            new Produits();
            if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
               ArrayList var6 = new ArrayList();
               ObjetTarif var7 = new ObjetTarif();
               int var8 = 0;

               label125:
               while(true) {
                  if (var8 >= this.lesLignesList.size()) {
                     var8 = 0;

                     while(true) {
                        if (var8 >= var6.size()) {
                           break label125;
                        }

                        var7 = (ObjetTarif)var6.get(var8);
                        if (var3) {
                           var2 = var7.getNomLibelle() + ":" + var7.getPrix();
                           var3 = false;
                        } else {
                           var2 = var2 + "#" + var7.getNomLibelle() + ":" + var7.getPrix();
                        }

                        ++var8;
                     }
                  }

                  CommandeLigneVentes var13 = (CommandeLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getBcmligCode() != null && !var13.getBcmligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getBcmligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getBcmligPt());
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
                              var7.setPrix(var13.getBcmligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getBcmligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.commandeEnteteVentes.setBcmActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.commandeEnteteVentes.setBcmAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.commandeEnteteVentes.getBcmAnal4() != null && !this.commandeEnteteVentes.getBcmAnal4().isEmpty()) {
         this.commandeEnteteVentes.setBcmAnal4(this.commandeEnteteVentes.getBcmAnal4().toUpperCase());
      }

      if (!this.var_anal_parc) {
         this.commandeEnteteVentes.setBcmAnal2("");
      } else if (this.commandeEnteteVentes.getBcmAnal2() != null && this.commandeEnteteVentes.getBcmAnal2().length() <= 2) {
         this.commandeEnteteVentes.setBcmAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.commandeEnteteVentes.setBcmEtatVal(1);
         this.commandeEnteteVentes.setBcmEtat(0);
         this.commandeEnteteVentes.setBcmDateValide((Date)null);
         return true;
      } else {
         this.commandeEnteteVentes.setBcmEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.commandeEnteteVentes.setBcmEtat(1);
               this.commandeEnteteVentes.setBcmDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.commandeEnteteVentes.setBcmEtat(0);
               this.commandeEnteteVentes.setBcmDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void calculReliquat() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.calculReliquatSuite();
         this.showModalPanelReliquat = true;
      }

   }

   public void calculReliquatSuite() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         long var1 = this.commandeEnteteVentes.getBcmId();
         this.ht_livre = 0.0D;
         this.lesCommandesReliquat = new ArrayList();
         this.lesCommandesReliquat = this.miseAJourReliquat(this.lesCommandesReliquat);
         this.dataModelReliquat.setWrappedData(this.lesCommandesReliquat);
         if (this.lesLignesList.size() != 0) {
            double var3 = 0.0D;
            double var5 = 0.0D;
            new CommandeLigneVentes();

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               CommandeLigneVentes var7 = (CommandeLigneVentes)this.lesLignesList.get(var8);
               var3 += (double)var7.getBcmligQteUtil();
               var5 += (double)var7.getBcmligQteLivree();
            }

            this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(var1, (Session)null);
            if (this.commandeEnteteVentes != null) {
               if (var5 != 0.0D) {
                  if (var5 >= var3) {
                     this.commandeEnteteVentes.setBcmEtat(5);
                     this.commandeEnteteVentes.setBcmTotLivre(this.ht_livre);
                     this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
                  } else {
                     this.commandeEnteteVentes.setBcmEtat(4);
                     this.commandeEnteteVentes.setBcmTotLivre(this.ht_livre);
                     this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
                  }
               } else {
                  this.commandeEnteteVentes.setBcmEtat(1);
                  this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
               }
            }
         }
      }

   }

   public List miseAJourReliquat(List var1) throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.ht_livre = 0.0D;
         this.documentTraceVentes = new DocumentTraceVentes();
         this.chargerDocumentTrace();
         ArrayList var2 = new ArrayList();
         int var3;
         if (this.documentTrace.size() != 0) {
            for(var3 = 0; var3 < this.documentTrace.size(); ++var3) {
               this.documentTraceVentes = (DocumentTraceVentes)this.documentTrace.get(var3);
               if (this.documentTraceVentes.getDoctraDstType() == 23) {
                  var2.add(this.documentTraceVentes);
               }
            }
         }

         if (var2.size() != 0) {
            Session var20 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
            Transaction var4 = null;

            try {
               var4 = var20.beginTransaction();
               this.lesLignesList.clear();
               this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, var20);
               new LivraisonEnteteVentes();
               LivraisonLigneVentes var6 = new LivraisonLigneVentes();
               LivraisonEnteteVentesDao var7 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               LivraisonLigneVentesDao var8 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               ArrayList var9 = new ArrayList();
               new ArrayList();

               int var11;
               for(var11 = 0; var11 < var2.size(); ++var11) {
                  this.documentTraceVentes = (DocumentTraceVentes)var2.get(var11);
                  LivraisonEnteteVentes var5 = var7.pourParapheur(this.documentTraceVentes.getDoctraDstId(), var20);
                  if (var5 != null) {
                     List var10 = var8.chargerLesLignes(var5, var20);
                     if (var10.size() != 0) {
                        for(int var12 = 0; var12 < var10.size(); ++var12) {
                           var6 = (LivraisonLigneVentes)var10.get(var12);
                           if (this.optionsVentes.getTracabilite().equals("0") && var6.getBlvligCode() != null && !var6.getBlvligCode().isEmpty()) {
                              var9.add(var6);
                           } else if (var6.getBlvligIdBcm() != 0L) {
                              var9.add(var6);
                           }
                        }
                     }
                  }
               }

               if (var9.size() != 0) {
                  for(var11 = 0; var11 < this.lesLignesList.size(); ++var11) {
                     this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var11);
                     float var21 = 0.0F;

                     int var13;
                     for(var13 = 0; var13 < var9.size(); ++var13) {
                        var6 = (LivraisonLigneVentes)var9.get(var13);
                        if (var6.getBlvligIdBcm() != 0L && var6.getBlvligIdBcm() == this.commandeLigneVentes.getBcmligId()) {
                           var21 += var6.getBlvligQteUtil();
                           this.ht_livre += var6.getBlvligPt();
                           this.commandeLigneVentes.setBcmligDepot(var6.getBlvligDepot());
                           var6 = var8.modif(var6, var20);
                        }
                     }

                     this.commandeLigneVentes.setBcmligQteLivree(var21);
                     this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var20);
                     this.commandeLigneVentes.setFamilleStyle("font-weight:bold;");
                     if (var6.getBlvligIdBcm() != 0L) {
                        var1.add(this.commandeLigneVentes);
                     }

                     for(var13 = 0; var13 < var9.size(); ++var13) {
                        var6 = (LivraisonLigneVentes)var9.get(var13);
                        if (var6.getBlvligCode().equals(this.commandeLigneVentes.getBcmligCode())) {
                           CommandeLigneVentes var14 = new CommandeLigneVentes();
                           var14.setBcmligCode(var6.getBlvligCode());
                           var14.setBcmligLibelle(var6.getBlvligLibelle());
                           var14.setBcmligDescription("" + this.utilDate.dateToStringFr(var6.getLivraisonEnteteVentes().getBlvDate()));
                           var14.setBcmligDepot("BL N° " + var6.getLivraisonEnteteVentes().getBlvNum());
                           var14.setBcmligQteLivree(var6.getBlvligQteUtil());
                           var14.setVar_qteRestante(0.0F);
                           var14.setFamilleStyle("font-style:italic;");
                           if (var6.getBlvligIdBcm() != 0L) {
                              var1.add(var14);
                           }
                        }
                     }
                  }
               }

               var4.commit();
            } catch (HibernateException var18) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var18;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               this.commandeLigneVentes.setBcmligQteLivree(0.0F);
               if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                  var1.add(this.commandeLigneVentes);
               }
            }
         }
      }

      return var1;
   }

   public void fermerReliquat() {
      this.showModalPanelReliquat = false;
   }

   public void initImpressionReliquat() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 5;
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "reliquatBC" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesDocumentsReliquatItem = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.lesDocumentsReliquatItem.add(new SelectItem(var5));
            }
         }
      }

      this.showModalPanelPrintReliquat = true;
   }

   public void fermerPrintReliquat() {
      this.showModalPanelPrintReliquat = false;
   }

   public void imprimerPRT() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "PRT";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerJRV() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "JRV";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerPDF() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "PDF";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerODT() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "ODT";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerXLS() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "XLS";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerDOC() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "DOC";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerHTML() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "HTML";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void imprimerXML() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.format = "XML";
      this.impression(this.utilPrint, this.var_choix_modele, 0, this.nomModeleDocument, (String)null, this.format, (String)null, (String)null, (String)null, (String)null, (String)null);
   }

   public void modeSuivi() throws HibernateException, NamingException {
   }

   public void modifierDateLivraison() {
      if (this.commandeEnteteVentes != null) {
         this.showModalPanelModifDateLiv = true;
      }

   }

   public void fermerDateLivraison() {
      this.showModalPanelModifDateLiv = false;
   }

   public void validerDateLivraison() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
      }

      this.showModalPanelModifDateLiv = false;
   }

   public void modifierBCC() {
      if (this.commandeEnteteVentes != null) {
         this.showModalPanelModifBCC = true;
      }

   }

   public void fermerBCC() {
      this.showModalPanelModifBCC = false;
   }

   public void validerBCC() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
      }

      this.showModalPanelModifBCC = false;
   }

   public void annulerDocument() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.documentDetailTrf.clear();
         this.var_motif_annule = "";
         this.var_date_trf = null;
         this.var_type_trf = this.nature;
         this.var_serie_trf = this.commandeEnteteVentes.getBcmSerie();
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

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         boolean var2 = false;
         var2 = this.usersChronoDao.existByUserNat(this.usersLog, 22, var1);
         if (var2) {
            if (this.lesLignesList.size() != 0) {
               for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
                  new CommandeLigneVentes();
                  CommandeLigneVentes var4 = (CommandeLigneVentes)this.lesLignesList.get(var3);
                  this.documentDetailTrf.add(var4);
               }
            }

            this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
            this.qteTrfQteOrg(var1);
         }

         this.utilInitHibernate.closeSession();
         if (this.lesLignesList.size() != 0) {
            this.showModalPanelAnnule = true;
         }
      }

   }

   public void valideAnnuler() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         CommandeEnteteVentes var3 = new CommandeEnteteVentes();
         ArrayList var4 = new ArrayList();
         var3.setUsers(this.usersLog);
         var3.setBcmIdCreateur(this.usersLog.getUsrid());
         var3.setBcmNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setBcmDate(this.utilDate.dateToSQLLight(this.commandeEnteteVentes.getBcmDate()));
         } else {
            var3.setBcmDate(this.var_date_trf);
         }

         var3.setBcmDate(this.utilDate.dateToSQL(var3.getBcmDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setBcmDateCreat(new Date());
         var3.setBcmDateModif((Date)null);
         var3.setBcmIdModif(0L);
         var3.setBcmNomModif("");
         var3.setBcmNum("");
         this.calculDateValidite();
         var3.setBcmService(this.commandeEnteteVentes.getBcmService());
         if (!this.var_serie_trf.equalsIgnoreCase("X") && !this.var_serie_trf.isEmpty()) {
            var3.setBcmNum(this.calculChrono.numCompose(var3.getBcmDate(), this.var_type_trf, this.var_serie_trf, var1));
         } else {
            long var5 = this.commandeEnteteVentesDao.selectLastNum(var1);
            var3.setBcmNum("" + var5);
         }

         var3.setBcmNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
         var3.setBcmIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
         var3.setBcmNomTiers(this.commandeEnteteVentes.getBcmNomTiers());
         var3.setBcmCivilTiers(this.commandeEnteteVentes.getBcmCivilTiers());
         var3.setBcmIdContact(this.commandeEnteteVentes.getBcmIdContact());
         var3.setBcmNomContact(this.commandeEnteteVentes.getBcmNomContact());
         var3.setBcmCivilContact(this.commandeEnteteVentes.getBcmCivilContact());
         var3.setBcmDiversAdresse(this.commandeEnteteVentes.getBcmDiversAdresse());
         var3.setBcmDiversMail(this.commandeEnteteVentes.getBcmDiversMail());
         var3.setBcmDiversNom(this.commandeEnteteVentes.getBcmDiversNom());
         var3.setBcmDiversTel(this.commandeEnteteVentes.getBcmDiversTel());
         var3.setBcmDiversTiers(this.commandeEnteteVentes.getBcmDiversTiers());
         var3.setBcmDiversVille(this.commandeEnteteVentes.getBcmDiversVille());
         var3.setBcmSerie(this.commandeEnteteVentes.getBcmSerie());
         var3.setBcmExoTva(this.commandeEnteteVentes.getBcmExoTva());
         var3.setBcmExoDouane(this.commandeEnteteVentes.getBcmExoDouane());
         var3.setBcmJournalReg(this.commandeEnteteVentes.getBcmJournalReg());
         var3.setBcmCat(this.commandeEnteteVentes.getBcmCat());
         var3.setBcmDevise(this.commandeEnteteVentes.getBcmDevise());
         var3.setBcmObject(this.commandeEnteteVentes.getBcmObject());
         var3.setBcmObservation(this.commandeEnteteVentes.getBcmObservation());
         var3.setBcmTotHt(0.0D);
         var3.setBcmTotRemise(0.0D);
         var3.setBcmTotRabais(0.0D);
         var3.setBcmTotTva(0.0D);
         var3.setBcmTotTc(0.0D);
         var3.setBcmTotTtc(0.0D);
         var3.setBcmTotReglement(this.commandeEnteteVentes.getBcmTotReglement());
         var3.setBcmSolde(this.commandeEnteteVentes.getBcmSolde());
         var3.setBcmBanque(this.commandeEnteteVentes.getBcmBanque());
         var3.setBcmTypeReg(this.commandeEnteteVentes.getBcmTypeReg());
         var3.setBcmModeReg(this.commandeEnteteVentes.getBcmModeReg());
         var3.setBcmNbJourReg(this.commandeEnteteVentes.getBcmNbJourReg());
         var3.setBcmArrondiReg(this.commandeEnteteVentes.getBcmArrondiReg());
         var3.setBcmConditionReg(this.commandeEnteteVentes.getBcmConditionReg());
         var3.setBcmDateEcheReg(this.commandeEnteteVentes.getBcmDateEcheReg());
         var3.setBcmActivite(this.commandeEnteteVentes.getBcmActivite());
         var3.setBcmSite(this.commandeEnteteVentes.getBcmSite());
         var3.setBcmDepartement(this.commandeEnteteVentes.getBcmDepartement());
         var3.setBcmRegion(this.commandeEnteteVentes.getBcmRegion());
         var3.setBcmSecteur(this.commandeEnteteVentes.getBcmSecteur());
         var3.setBcmPdv(this.commandeEnteteVentes.getBcmPdv());
         var3.setBcmAnal2(this.commandeEnteteVentes.getBcmAnal2());
         var3.setBcmAnal4(this.commandeEnteteVentes.getBcmAnal4());
         var3.setBcmInfo1(this.commandeEnteteVentes.getBcmInfo1());
         var3.setBcmInfo2(this.commandeEnteteVentes.getBcmInfo2());
         var3.setBcmInfo3(this.commandeEnteteVentes.getBcmInfo3());
         var3.setBcmInfo4(this.commandeEnteteVentes.getBcmInfo4());
         var3.setBcmInfo5(this.commandeEnteteVentes.getBcmInfo5());
         var3.setBcmInfo6(this.commandeEnteteVentes.getBcmInfo6());
         var3.setBcmInfo7(this.commandeEnteteVentes.getBcmInfo7());
         var3.setBcmInfo8(this.commandeEnteteVentes.getBcmInfo8());
         var3.setBcmInfo9(this.commandeEnteteVentes.getBcmInfo9());
         var3.setBcmInfo10(this.commandeEnteteVentes.getBcmInfo10());
         var3.setBcmFormule1(this.commandeEnteteVentes.getBcmFormule1());
         var3.setBcmFormule2(this.commandeEnteteVentes.getBcmFormule2());
         var3.setBcmAnnexe1(this.commandeEnteteVentes.getBcmAnnexe1());
         var3.setBcmAnnexe2(this.commandeEnteteVentes.getBcmAnnexe2());
         var3.setBcmContrat(this.commandeEnteteVentes.getBcmContrat());
         var3.setBcmIncoterm(this.commandeEnteteVentes.getBcmIncoterm());
         var3.setBcmLieuLivraison(this.commandeEnteteVentes.getBcmLieuLivraison());
         var3.setBcmDateLivraison(this.commandeEnteteVentes.getBcmDateLivraison());
         var3.setBcmInfoLivraison(this.commandeEnteteVentes.getBcmInfoLivraison());
         var3.setBcmDateImp((Date)null);
         var3.setBcmModeleImp(this.commandeEnteteVentes.getBcmModeleImp());
         var3.setBcmGarde(this.commandeEnteteVentes.getBcmGarde());
         var3.setBcmGele(0);
         var3.setBcmEtat(3);
         var3.setBcmDateTransforme((Date)null);
         var3.setBcmTypeTransforme(0);
         var3.setBcmDateAnnule((Date)null);
         var3.setBcmMotifAnnule("");
         var3.setBcmFactorNom(this.commandeEnteteVentes.getBcmFactorNom());
         var3.setBcmFactorId(this.commandeEnteteVentes.getBcmFactorId());
         var3.setBcmFactorEtat(this.commandeEnteteVentes.getBcmFactorEtat());
         var3.setExerciceventes(this.commandeEnteteVentes.getExerciceventes());
         var3.setTiers(this.commandeEnteteVentes.getTiers());
         var3.setUsers(this.usersLog);
         this.commandeEnteteVentesDao.insert(var3, var1);
         this.lesEntetesList.add(var3);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, var3.getBcmId(), var3.getBcmNum(), var3.getBcmNomTiers(), var3.getBcmDate(), var3.getBcmDevise(), var3.getBcmTotTtc() + var3.getBcmTotTc(), var3.getBcmModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(this.commandeEnteteVentes.getBcmModeleImp()), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         }

         double var25 = 0.0D;
         double var7 = 0.0D;
         double var9 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         if (this.documentDetailTrf.size() != 0) {
            for(int var17 = 0; var17 < this.documentDetailTrf.size(); ++var17) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.documentDetailTrf.get(var17);
               if (this.commandeLigneVentes.getVar_qteReliquat() != 0.0F) {
                  float var18 = this.commandeLigneVentes.getVar_qteReliquat() * -1.0F;
                  this.commandeLigneVentes.setVar_qteReliquat(var18);
                  CommandeLigneVentes var19 = new CommandeLigneVentes();
                  var19.setBcmligCode(this.commandeLigneVentes.getBcmligCode());
                  var19.setBcmligDevise(this.commandeLigneVentes.getBcmligDevise());
                  var19.setBcmligFamille(this.commandeLigneVentes.getBcmligFamille());
                  var19.setBcmligIdDvs(this.commandeLigneVentes.getBcmligId());
                  var19.setBcmligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                  var19.setBcmligDepot(this.commandeLigneVentes.getBcmligDepot());
                  var19.setBcmligUnite(this.commandeLigneVentes.getBcmligUnite());
                  var19.setBcmligCondition(this.commandeLigneVentes.getBcmligCondition());
                  var19.setBcmligStock(this.commandeLigneVentes.getBcmligStock());
                  var19.setBcmligReference(this.commandeLigneVentes.getBcmligReference());
                  var19.setBcmligPump(this.commandeLigneVentes.getBcmligPump());
                  var19.setBcmligPu(this.commandeLigneVentes.getBcmligPu());
                  var19.setBcmligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                  var19.setBcmligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                  var19.setBcmligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                  var19.setBcmligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                  this.commandeLigneVentes.setBcmligQte(((CommandeLigneVentes)this.lesLignesList.get(var17)).getVar_qteReliquat());
                  this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var1);
                  var19.setBcmligQte(((CommandeLigneVentes)this.lesLignesList.get(var17)).getVar_qteReliquat());
                  var19.setBcmligLong(this.commandeLigneVentes.getBcmligLong());
                  var19.setBcmligLarg(this.commandeLigneVentes.getBcmligLarg());
                  var19.setBcmligHaut(this.commandeLigneVentes.getBcmligHaut());
                  var19.setBcmligDiam(this.commandeLigneVentes.getBcmligDiam());
                  var19.setBcmligNb(this.commandeLigneVentes.getBcmligNb());
                  var19.setBcmligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.commandeLigneVentes.getBcmligCondition(), this.commandeLigneVentes.getBcmligQte(), this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, this.utilInitHibernate, var1));
                  var19.setBcmligQteStock(0.0F);
                  var19.setBcmligRabais(this.commandeLigneVentes.getBcmligRabais());
                  var19.setBcmligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                  var19.setBcmligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                  var19.setBcmligPt(this.commandeLigneVentes.getBcmligPt());
                  var19.setBcmligTva(this.commandeLigneVentes.getBcmligTva());
                  var19.setBcmligTtc(this.commandeLigneVentes.getBcmligTtc());
                  var19.setBcmligTc(this.commandeLigneVentes.getBcmligTc());
                  var19.setCommandeEnteteVentes(var3);
                  var4.add(var19);
                  var25 += var19.getBcmligPt();
                  var7 += (var19.getBcmligPu() - var19.getBcmligPuRem()) * (double)var19.getBcmligQte();
                  var9 += var19.getBcmligRabais();
                  var11 += var19.getBcmligTva();
                  var13 += var19.getBcmligTtc();
                  var15 += var19.getBcmligTc();
               }
            }

            var3.setBcmTotHt(var25);
            var3.setBcmTotRemise(var7);
            var3.setBcmTotRabais(var9);
            var3.setBcmTotTva(var11);
            var3.setBcmTotTc(var15);
            var3.setBcmTotTtc(var13);
            this.commandeEnteteVentesDao.modif(var3, var1);
            if (var4.size() != 0) {
               this.commandeLigneVentesDao.saveLigne(var4, var3, var1);
               this.calculStock.majCommandeVentesANNULE(var4, this.baseLog, var1);
            }
         }

         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.commandeEnteteVentes.getExerciceventes());
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.commandeEnteteVentes.getBcmSerie());
         this.documentTraceVentes.setDoctraOrgId(this.commandeEnteteVentes.getBcmId());
         this.documentTraceVentes.setDoctraOrgNum(this.commandeEnteteVentes.getBcmNum());
         this.documentTraceVentes.setDoctraOrgDate(this.commandeEnteteVentes.getBcmDate());
         this.documentTraceVentes.setDoctraDstType(this.nature);
         this.documentTraceVentes.setDoctraDstSerie(var3.getBcmSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getBcmId());
         this.documentTraceVentes.setDoctraDstNum(var3.getBcmNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getBcmDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         this.commandeEnteteVentes.setBcmEtat(3);
         this.commandeEnteteVentes.setBcmDateAnnule(var3.getBcmDate());
         this.commandeEnteteVentes.setBcmMotifAnnule(this.var_motif_annule);
         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
         Espion var26 = new Espion();
         var26.setUsers(this.usersLog);
         var26.setEsptype(0);
         var26.setEspdtecreat(new Date());
         var26.setEspaction("Annulation partielle commande vente N° " + this.commandeEnteteVentes.getBcmNum() + " le " + this.commandeEnteteVentes.getBcmDateAnnule());
         var2.commit();
      } catch (HibernateException var23) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelAnnule = false;
   }

   public void fermerAnnuler() {
      this.showModalPanelAnnule = false;
   }

   public void annulerDocumentValider() {
      if (this.commandeEnteteVentes != null) {
         this.commandeEnteteVentes.setBcmDateAnnule(new Date());
         this.showModalPanelAnnuleValider = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuleValider = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commandeEnteteVentes.getBcmDateAnnule() == null) {
               this.commandeEnteteVentes.setBcmDateAnnule(new Date());
            }

            this.commandeEnteteVentes.setBcmEtat(3);
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               if (this.commandeEnteteVentes.getBcmStock() == 1) {
                  this.calculStock.majCommandeVentesVAL(this.lesLignesList, 0, this.baseLog, var1);
               } else {
                  for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
                     this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
                     if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                        this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                        if (this.produits != null && this.produits.getProStock() >= 1) {
                           this.calculStock.majCommandeVentesATT(this.commandeLigneVentes, this.produits, 0, this.baseLog, var1);
                        }
                     }
                  }
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Annulation commplete commande vente N° " + this.commandeEnteteVentes.getBcmNum() + " le " + this.commandeEnteteVentes.getBcmDateAnnule());
            this.espionDao.mAJEspion(var9, var1);
            this.lesEntetesList.remove(this.commandeEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
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

      this.showModalPanelAnnuleValider = false;
      this.visibiliteBton = false;
   }

   public void gelerDocument() {
      if (this.commandeEnteteVentes != null) {
         this.commandeEnteteVentes.setBcmDateAnnule(new Date());
         this.showModalPanelGele = true;
      }

   }

   public void annuleGeler() {
      this.showModalPanelGele = false;
   }

   public void miseajourGeler() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         if (this.commandeEnteteVentes.getBcmDateAnnule() == null) {
            this.commandeEnteteVentes.setBcmDateAnnule(new Date());
         }

         this.commandeEnteteVentes.setBcmEtat(2);
         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Gele commande vente N° " + this.commandeEnteteVentes.getBcmNum() + " le " + this.commandeEnteteVentes.getBcmDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.commandeEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelGele = false;
      this.visibiliteBton = false;
   }

   public void planningDocument() {
      this.var_action = 17;
      this.var_memo_action = this.var_action;
      this.listRdvMois = new ArrayList();
      this.listRdvSemaine = new ArrayList();
      this.listRdvJour = new ArrayList();
      this.listRdv = new ArrayList();
      this.datamodelRdv = new ListDataModel();
      this.datamodelLesRdvParJour = new ListDataModel();
      this.datamodelLesRdvParSemaine = new ListDataModel();
      this.datamodelLesRdvParMois = new ListDataModel();
      this.showModalPanelPlanning = false;
      this.showModalPanelRdv = false;
      this.showModalPanelTiers = false;
      this.parMois = new Date();
      this.parSemaine = new Date();
      this.parJour = new Date();
      this.modeRdv = 0;
      this.planningImpressionsItems = new ArrayList();
      this.showModalPanelPrintPlanning = false;
      this.rdv = new Rdv();
      this.rdvDao = new RdvDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesDoc(Date var1, Date var2, int var3, int var4) throws HibernateException, NamingException, ParseException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommandesVentesPlanning");
      this.listRdv = this.commandeEnteteVentesDao.selectRdv(var1, var2, var3, var4, var5);
      new ArrayList();
      List var6 = this.rdvDao.selectRdv(var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.commandeEnteteVentes = new CommandeEnteteVentes();
            this.commandeEnteteVentes.setBcmIdEquipe(((Rdv)var6.get(var7)).getRdvId());
            this.commandeEnteteVentes.setBcmDate(((Rdv)var6.get(var7)).getRdvDteDe());
            this.commandeEnteteVentes.setBcmDateLivraison(((Rdv)var6.get(var7)).getRdvDteDe());
            this.commandeEnteteVentes.setBcmObject(((Rdv)var6.get(var7)).getRdvSujet());
            this.commandeEnteteVentes.setBcmObservation(((Rdv)var6.get(var7)).getRdvDescript());
            this.commandeEnteteVentes.setBcmEtatLivraison(((Rdv)var6.get(var7)).getRdvEtat());
            this.commandeEnteteVentes.setBcmNomTiers("RDV");
            this.commandeEnteteVentes.setBcmDiversNom((String)null);
            this.commandeEnteteVentes.setBcmNum("");
            this.commandeEnteteVentes.setBcmHoraireLivraison(0);
            this.commandeEnteteVentes.setHeure("");
            this.commandeEnteteVentes.setMinute("");
            boolean var8 = false;
            int var9;
            if (this.rdv.getRdvLieu() != null && !this.rdv.getRdvLieu().isEmpty()) {
               var9 = Integer.parseInt(this.rdv.getRdvLieu());
            } else {
               var9 = 0;
            }

            this.commandeEnteteVentes.setBcmModeLivraison(var9);
            this.listRdv.add(this.commandeEnteteVentes);
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void modeMois() {
      this.modeRdv = 0;
   }

   public void modeSemaine() {
      this.modeRdv = 1;
   }

   public void modeJour() {
      this.modeRdv = 2;
   }

   public void modeListe() {
      this.modeRdv = 3;
   }

   public void chargerLesRdv() throws HibernateException, NamingException, ParseException {
      this.listRdvMois.clear();
      this.listRdvSemaine.clear();
      this.listRdvJour.clear();
      if (this.jourDeb != null && this.jourFin != null) {
         this.chargerLesDoc(this.jourDeb, this.jourFin, this.valNatListe, this.valStatutListe);
      }

      this.datamodelRdv.setWrappedData(this.listRdv);
   }

   public void chargerLesRdvByJourPrecedent() throws HibernateException, NamingException, ParseException {
      if (this.parJour == null) {
         this.parJour = new Date();
      }

      Date var1 = this.parJour;
      this.parJour = this.utilDate.dateJourPrecedent(var1);
      this.chargerLesRdvByJour();
   }

   public void chargerLesRdvByJourSuivant() throws HibernateException, NamingException, ParseException {
      if (this.parJour == null) {
         this.parJour = new Date();
      }

      Date var1 = this.parJour;
      this.parJour = this.utilDate.dateJourSuivant(var1);
      this.chargerLesRdvByJour();
   }

   public void chargerLesRdvByJour() throws HibernateException, NamingException, ParseException {
      if (this.parJour != null) {
         this.listRdv.clear();
         this.chargerLesDoc(this.parJour, this.parJour, this.valNatJour, this.valStatutJour);
         this.listRdvJour.clear();
         if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
            this.structureLog.setStrHrDeb("00");
         }

         int var1 = Integer.parseInt(this.structureLog.getStrHrDeb());
         if (var1 == 0) {
            var1 = 8;
         }

         if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
            this.structureLog.setStrHrFin("00");
         }

         int var2 = Integer.parseInt(this.structureLog.getStrHrFin());
         if (var2 == 0) {
            var2 = 19;
         }

         if (this.structureLog.getStrHrPas() == null || this.structureLog.getStrHrPas().isEmpty()) {
            this.structureLog.setStrHrPas("00");
         }

         int var3 = Integer.parseInt(this.structureLog.getStrHrPas());
         int var4 = var1 * 60;
         int var5 = var2 * 60;
         int var6 = var3 * 60;

         int var7;
         for(var7 = var4; var7 < var5; var7 += var6) {
            String var8 = "";
            if (Math.abs(var7 / 60) < 10) {
               var8 = "0" + Math.abs(var7 / 60);
            } else {
               var8 = "" + Math.abs(var7 / 60);
            }

            boolean var9 = false;

            for(int var10 = 0; var10 < this.listRdv.size(); ++var10) {
               this.commandeEnteteVentes = (CommandeEnteteVentes)this.listRdv.get(var10);
               if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 3) {
                  this.commandeEnteteVentes.setHeure(this.commandeEnteteVentes.getBcmHeureLivraison());
                  this.commandeEnteteVentes.setMinute("00");
                  if (this.commandeEnteteVentes.getBcmHeureLivraison().equalsIgnoreCase(var8)) {
                     this.listRdvJour.add(this.commandeEnteteVentes);
                     var9 = true;
                  }
               }
            }

            if (!var9) {
               this.commandeEnteteVentes = new CommandeEnteteVentes();
               this.commandeEnteteVentes.setHeure(var8);
               this.commandeEnteteVentes.setMinute("00");
               this.commandeEnteteVentes.setBcmHeureLivraison(var8);
               this.commandeEnteteVentes.setBcmHoraireLivraison(3);
               this.listRdvJour.add(this.commandeEnteteVentes);
            }
         }

         for(var7 = 0; var7 < this.listRdv.size(); ++var7) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.listRdv.get(var7);
            if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 0) {
               this.commandeEnteteVentes.setHeure("00");
               this.commandeEnteteVentes.setMinute("00");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 1) {
               this.commandeEnteteVentes.setHeure("AM");
               this.commandeEnteteVentes.setMinute("");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 2) {
               this.commandeEnteteVentes.setHeure("PM");
               this.commandeEnteteVentes.setMinute("");
            }

            if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 0 || this.commandeEnteteVentes.getBcmHoraireLivraison() == 1 || this.commandeEnteteVentes.getBcmHoraireLivraison() == 2) {
               this.listRdvJour.add(this.commandeEnteteVentes);
            }
         }

         this.datamodelLesRdvParJour.setWrappedData(this.listRdvJour);
      }

   }

   public void chargerLesRdvBySemaine() throws HibernateException, NamingException, ParseException {
      this.chargerLesRdvBySemaine((Session)null);
   }

   public void chargerLesRdvBySemainePrecedent() throws HibernateException, NamingException, ParseException {
      if (this.dateLun == null || this.dateLun.isEmpty()) {
         this.dateLun = this.utilDate.dateToStringFrLg(new Date());
      }

      this.parSemaine = this.utilDate.dateJourPrecedent(this.calculeDate(this.dateLun));
      this.chargerLesRdvBySemaine((Session)null);
   }

   public void chargerLesRdvBySemaineSuivant() throws HibernateException, NamingException, ParseException {
      if (this.dateDim == null || this.dateDim.isEmpty()) {
         this.dateDim = this.utilDate.dateToStringFrLg(new Date());
      }

      this.parSemaine = this.utilDate.dateJourSuivant(this.calculeDate(this.dateDim));
      this.chargerLesRdvBySemaine((Session)null);
   }

   public void chargerLesRdvBySemaine(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.parSemaine != null) {
         Date var2 = null;
         Date var3 = null;
         Calendar var4 = Calendar.getInstance();
         var4.setTime(this.parSemaine);
         String var5 = "" + var4.getTime();
         if (var5.contains("Mon")) {
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Tue")) {
            var4.add(7, -1);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Wed")) {
            var4.add(7, -2);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Thu")) {
            var4.add(7, -3);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Fri")) {
            var4.add(7, -4);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Sat")) {
            var4.add(7, -5);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Sun")) {
            var4.add(7, -6);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         }

         Calendar var6 = Calendar.getInstance();
         var6.setTime(var2);
         SimpleDateFormat var7 = new SimpleDateFormat("dd/MM/yy", Locale.FRANCE);
         this.dateLun = var7.format(var2);
         var6.add(7, 1);
         this.dateMar = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateMer = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateJeu = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateVen = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateSam = var7.format(var6.getTime());
         this.dateDim = var7.format(var3);
         this.jourDeb = var2;
         this.jourFin = var3;
         this.listRdv.clear();
         this.chargerLesDoc(this.jourDeb, this.jourFin, this.valNatSemaine, this.valStatutSemaine);
         this.listRdvSemaine.clear();
         if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
            this.structureLog.setStrHrDeb("00");
         }

         int var8 = Integer.parseInt(this.structureLog.getStrHrDeb());
         if (var8 == 0) {
            var8 = 8;
         }

         if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
            this.structureLog.setStrHrFin("00");
         }

         int var9 = Integer.parseInt(this.structureLog.getStrHrFin());
         if (var9 == 0) {
            var9 = 19;
         }

         if (this.structureLog.getStrHrPas() == null || this.structureLog.getStrHrPas().isEmpty()) {
            this.structureLog.setStrHrPas("00");
         }

         int var10 = Integer.parseInt(this.structureLog.getStrHrPas());
         if (this.structureLog.getStrMnPas() == null || this.structureLog.getStrMnPas().isEmpty()) {
            this.structureLog.setStrMnPas("00");
         }

         int var11 = var8 * 60;
         int var12 = var9 * 60;
         int var13 = var10 * 60;

         for(int var14 = var11; var14 < var12; var14 += var13) {
            String var15 = "";
            if (Math.abs(var14 / 60) < 10) {
               var15 = "0" + Math.abs(var14 / 60);
            } else {
               var15 = "" + Math.abs(var14 / 60);
            }

            boolean var16 = false;
            RdvSemaine var17 = new RdvSemaine();

            for(int var18 = 0; var18 < this.listRdv.size(); ++var18) {
               this.commandeEnteteVentes = (CommandeEnteteVentes)this.listRdv.get(var18);
               if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 3) {
                  this.commandeEnteteVentes.setHeure(this.commandeEnteteVentes.getBcmHeureLivraison());
                  SimpleDateFormat var19 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
                  var19.format(this.commandeEnteteVentes.getBcmDateLivraison());
                  Calendar var21 = Calendar.getInstance();
                  var21.setTime(this.commandeEnteteVentes.getBcmDateLivraison());
                  String var22 = "" + var21.getTime();
                  var17.setHeure(this.commandeEnteteVentes.getHeure());
                  if (this.commandeEnteteVentes.getBcmHeureLivraison().equalsIgnoreCase(var15)) {
                     if (var22.contains("Mon")) {
                        var17.setLundi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrLundi(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdLundi(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatLundi(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurLundi(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     } else if (var22.contains("Tue")) {
                        var17.setMardi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrMardi(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdMardi(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatMardi(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurMardi(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     } else if (var22.contains("Wed")) {
                        var17.setMercredi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrMercredi(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdMercredi(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatMercredi(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurMercredi(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     } else if (var22.contains("Thu")) {
                        var17.setJeudi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrJeudi(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdJeudi(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatJeudi(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurJeudi(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     } else if (var22.contains("Fri")) {
                        var17.setVendredi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrVendredi(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdVendredi(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatVendredi(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurVendredi(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     } else if (var22.contains("Sat")) {
                        var17.setSamedi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrSamedi(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdSamedi(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatSamedi(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurSamedi(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     } else if (var22.contains("Sun")) {
                        var17.setDimanche(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                        var17.setRdvUsrDimanche(this.commandeEnteteVentes.getTiers().getTieid());
                        var17.setRdvIdDimanche(this.commandeEnteteVentes.getBcmId());
                        var17.setRdvEtatDimanche(this.commandeEnteteVentes.getBcmPhase());
                        var17.setRdvErreurDimanche(false);
                        var17.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
                     }

                     var16 = true;
                  }
               }
            }

            if (!var16) {
               var17 = new RdvSemaine();
               var17.setHeure(var15);
            }

            this.listRdvSemaine.add(var17);
         }

         RdvSemaine var23 = new RdvSemaine();

         for(int var24 = 0; var24 < this.listRdv.size(); ++var24) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.listRdv.get(var24);
            if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 0) {
               this.commandeEnteteVentes.setHeure("??");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 1) {
               this.commandeEnteteVentes.setHeure("AM");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 2) {
               this.commandeEnteteVentes.setHeure("PM");
            }

            SimpleDateFormat var25 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            var25.format(this.commandeEnteteVentes.getBcmDateLivraison());
            Calendar var26 = Calendar.getInstance();
            var26.setTime(this.commandeEnteteVentes.getBcmDateLivraison());
            String var27 = "" + var26.getTime();
            var23.setHeure(this.commandeEnteteVentes.getHeure());
            if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 0 || this.commandeEnteteVentes.getBcmHoraireLivraison() == 1 || this.commandeEnteteVentes.getBcmHoraireLivraison() == 2) {
               var23 = new RdvSemaine();
               if (var27.contains("Mon")) {
                  var23.setLundi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrLundi(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdLundi(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatLundi(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurLundi(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               } else if (var27.contains("Tue")) {
                  var23.setMardi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrMardi(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdMardi(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatMardi(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurMardi(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               } else if (var27.contains("Wed")) {
                  var23.setMercredi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrMercredi(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdMercredi(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatMercredi(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurMercredi(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               } else if (var27.contains("Thu")) {
                  var23.setJeudi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrJeudi(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdJeudi(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatJeudi(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurJeudi(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               } else if (var27.contains("Fri")) {
                  var23.setVendredi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrVendredi(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdVendredi(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatVendredi(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurVendredi(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               } else if (var27.contains("Sat")) {
                  var23.setSamedi(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrSamedi(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdSamedi(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatSamedi(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurSamedi(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               } else if (var27.contains("Sun")) {
                  var23.setDimanche(this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable());
                  var23.setRdvUsrDimanche(this.commandeEnteteVentes.getTiers().getTieid());
                  var23.setRdvIdDimanche(this.commandeEnteteVentes.getBcmId());
                  var23.setRdvEtatDimanche(this.commandeEnteteVentes.getBcmPhase());
                  var23.setRdvErreurDimanche(false);
                  var23.setRdvNature(this.commandeEnteteVentes.getBcmModeLivraison());
               }

               this.listRdvSemaine.add(var23);
            }
         }

         this.datamodelLesRdvParSemaine.setWrappedData(this.listRdvSemaine);
      }

   }

   public Date calculeDate(String var1) throws ParseException {
      String[] var2 = var1.split("/");
      int var3 = 2000 + Integer.parseInt(var2[2]);
      Date var4 = this.utilDate.stringToDateSQLLight(var3 + "-" + var2[1] + "-" + var2[0]);
      return var4;
   }

   public void chargerLesRdvByMois() throws HibernateException, NamingException, ParseException {
      this.chargerLesRdvByMois((Session)null);
   }

   public void chargerLesRdvByMoisPrecedent() throws HibernateException, NamingException, ParseException {
      if (this.parMois == null) {
         this.parMois = new Date();
      }

      Date var1 = this.parMois;
      this.parMois = this.utilDate.dateMoisPrecedent(var1);
      this.chargerLesRdvByMois((Session)null);
   }

   public void chargerLesRdvByMoisSuivant() throws HibernateException, NamingException, ParseException {
      if (this.parMois == null) {
         this.parMois = new Date();
      }

      Date var1 = this.parMois;
      this.parMois = this.utilDate.dateMoisSuivant(var1);
      this.chargerLesRdvByMois((Session)null);
   }

   public void chargerLesRdvByMois(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.parMois != null) {
         Date var2 = this.utilDate.dateToSQLLight(this.utilDate.datedevaleurTheo(new Date(), -7));
         Date var3 = this.parMois;
         Calendar var4 = Calendar.getInstance();
         var4.setTime(var3);
         var4.add(2, 1);
         SimpleDateFormat var5 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var6 = var5.format(var4.getTime());
         String[] var7 = var6.split("-");
         String var8 = "01-" + var7[1] + "-" + var7[2];
         SimpleDateFormat var9 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         Date var10 = var9.parse(var8);
         Calendar var11 = Calendar.getInstance();
         var11.setTime(var10);
         var11.add(2, -1);
         Date var12 = var11.getTime();
         var11.add(2, 1);
         var11.add(5, -1);
         Date var13 = var11.getTime();
         SimpleDateFormat var14 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var15 = var14.format(var13);
         String[] var16 = var15.split("-");
         int var17 = Integer.parseInt(var16[0]);
         this.listRdv.clear();
         this.chargerLesDoc(var12, var13, this.valNatMois, this.valStatutMois);
         this.listRdvMois.clear();
         RdvSemaine var18 = new RdvSemaine();
         int var19 = 1;

         for(int var20 = 1; var20 <= var17; ++var20) {
            String var21 = var14.format(var12).substring(0, 2);
            String var22 = "" + var12;
            ListDataModel var23;
            if (var22.contains("Mon")) {
               if (!var21.equals("01")) {
                  ++var19;
               }

               var18.setNum_sem(var19);
               var18.setLundi(var21);
               var18.setLesCmdJourLundi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourLundi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche01(false);
               } else {
                  var18.setAffiche01(true);
               }

               var18.setDataModelLundi(var23);
            } else if (var22.contains("Tue")) {
               var18.setNum_sem(var19);
               var18.setMardi(var21);
               var18.setLesCmdJourMardi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourMardi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche02(false);
               } else {
                  var18.setAffiche02(true);
               }

               var18.setDataModelMardi(var23);
            } else if (var22.contains("Wed")) {
               var18.setNum_sem(var19);
               var18.setMercredi(var21);
               var18.setLesCmdJourMercredi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourMercredi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche03(false);
               } else {
                  var18.setAffiche03(true);
               }

               var18.setDataModelMercredi(var23);
            } else if (var22.contains("Thu")) {
               var18.setNum_sem(var19);
               var18.setJeudi(var21);
               var18.setLesCmdJourJeudi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourJeudi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche04(false);
               } else {
                  var18.setAffiche04(true);
               }

               var18.setDataModelJeudi(var23);
            } else if (var22.contains("Fri")) {
               var18.setNum_sem(var19);
               var18.setVendredi(var21);
               var18.setLesCmdJourVendredi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourVendredi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche05(false);
               } else {
                  var18.setAffiche05(true);
               }

               var18.setDataModelVendredi(var23);
            } else if (var22.contains("Sat")) {
               var18.setNum_sem(var19);
               var18.setSamedi(var21);
               var18.setLesCmdJourSamedi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourSamedi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche06(false);
               } else {
                  var18.setAffiche06(true);
               }

               var18.setDataModelSamedi(var23);
            } else if (var22.contains("Sun")) {
               var18.setNum_sem(var19);
               var18.setDimanche(var21);
               var18.setLesCmdJourDimanche(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourDimanche());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche07(false);
               } else {
                  var18.setAffiche07(true);
               }

               var18.setDataModelDimanche(var23);
               this.listRdvMois.add(var18);
               var18 = new RdvSemaine();
            }

            Calendar var24 = Calendar.getInstance();
            var24.setTime(var12);
            var24.add(5, 1);
            var12 = var24.getTime();
         }

         if (var19 == 6) {
            if (var18.getLundi() != null && !var18.getLundi().isEmpty()) {
               this.listRdvMois.add(var18);
            }
         } else if (var19 == 5 && var18.getLundi() != null && !var18.getLundi().isEmpty()) {
            this.listRdvMois.add(var18);
         }

         this.datamodelLesRdvParMois.setWrappedData(this.listRdvMois);
      }

   }

   public List rechercherRDVMois(List var1, Date var2) throws ParseException {
      ArrayList var3 = new ArrayList();
      SimpleDateFormat var4 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
      String var5 = var4.format(var2);

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         this.commandeEnteteVentes = (CommandeEnteteVentes)var1.get(var6);
         SimpleDateFormat var7 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var8 = var7.format(this.commandeEnteteVentes.getBcmDateLivraison());
         if (var8.equals(var5)) {
            if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 0) {
               this.commandeEnteteVentes.setHeure("??");
               this.commandeEnteteVentes.setMinute("");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 1) {
               this.commandeEnteteVentes.setHeure("AM");
               this.commandeEnteteVentes.setMinute("");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 2) {
               this.commandeEnteteVentes.setHeure("PM");
               this.commandeEnteteVentes.setMinute("");
            } else if (this.commandeEnteteVentes.getBcmHoraireLivraison() == 3) {
               this.commandeEnteteVentes.setHeure(this.commandeEnteteVentes.getBcmHeureLivraison());
               this.commandeEnteteVentes.setMinute("");
            }

            String var9 = this.commandeEnteteVentes.getVar_nom_tiers() + "\n" + this.commandeEnteteVentes.getBcmObject() + "\n" + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable();
            this.commandeEnteteVentes.setTexteAffiche(var9);
            var3.add(this.commandeEnteteVentes);
         }
      }

      return var3;
   }

   public void selectionLigneJour() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParJour.isRowAvailable()) {
         this.commandeEnteteVentes = (CommandeEnteteVentes)this.datamodelLesRdvParJour.getRowData();
         this.modifierDateCommande();
      }

   }

   public void selectionLigneListe() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelRdv.isRowAvailable()) {
         this.commandeEnteteVentes = (CommandeEnteteVentes)this.datamodelRdv.getRowData();
         this.modifierDateCommande();
      }

   }

   public void modifDateCol01() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelLundi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelLundi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol02() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMardi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelMardi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol03() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMercredi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelMercredi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol04() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelJeudi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelJeudi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol05() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelVendredi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelVendredi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol06() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelSamedi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelSamedi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol07() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelDimanche().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelDimanche().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifierDateCommande() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         if (this.commandeEnteteVentes.getBcmId() != 0L) {
            this.memoDateLivraion = this.commandeEnteteVentes.getBcmDateLivraison();
            this.lesLignesList.clear();
            this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, (Session)null);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
            this.showModalPanelPlanning = true;
         } else {
            this.tiers = new Tiers();
            this.rdv = new Rdv();
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            if (this.rdv != null) {
               this.showModalPanelRdv = true;
               this.compteRendu = true;
            }
         }
      }

   }

   public void fermerPlanning() {
      this.showModalPanelPlanning = false;
   }

   public void validerPlanning() throws HibernateException, NamingException, ParseException {
      if (this.commandeEnteteVentes != null) {
         if (!this.memoDateLivraion.equals(this.commandeEnteteVentes.getBcmDateLivraison())) {
            this.commandeEnteteVentes.setBcmCompteurReport(this.commandeEnteteVentes.getBcmCompteurReport() + 1);
         }

         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

      this.showModalPanelPlanning = false;
   }

   public void ajouterRdvCol01() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getLundi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol02() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getMardi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol03() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getMercredi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol04() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getJeudi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol05() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getVendredi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol06() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getSamedi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol07() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getDimanche());
         this.ajouterRdvMois(var3);
      }

   }

   public void supprimerRdvCol01() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelLundi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol02() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMardi().isRowAvailable()) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getDataModelMardi().getRowData();
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol03() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMercredi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol04() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelJeudi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol05() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelVendredi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol06() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelSamedi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol07() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelDimanche().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.commandeEnteteVentes.getBcmIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void ajouterRdvMois(Date var1) {
      this.tiers = new Tiers();
      this.rdv = new Rdv();
      this.commandeEnteteVentes = new CommandeEnteteVentes();
      this.rdv.setRdvDteDe(var1);
      this.rdv.setRdvNature(12);
      this.showModalPanelRdv = true;
      this.compteRendu = false;
   }

   public void annulerRdv() throws HibernateException, NamingException {
      this.showModalPanelRdv = false;
   }

   public void saveEventRdv() throws HibernateException, NamingException, ParseException {
      if (this.rdv.getRdvSujet() != null && !this.rdv.getRdvSujet().isEmpty()) {
         if (this.rdv.getRdvId() == 0L) {
            this.rdv.setUsers(this.usersLog);
            this.rdv.setRdvDateCreation(new Date());
            this.rdv = this.rdvDao.insert(this.rdv);
         } else {
            this.rdv = this.rdvDao.modif(this.rdv);
         }

         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

      this.showModalPanelRdv = false;
   }

   public void deleteEventRdv() throws HibernateException, NamingException, ParseException {
      if (this.rdv != null) {
         this.rdvDao.delete(this.rdv);
         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.commandeEnteteVentes.getBcmExoTva() == 0) {
         TaxesVentes var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
            } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxvteTaux();
                  var6 = var9.getTaxvteCode();
                  var7 = var9.getTaxvteType();
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
         } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
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

      this.commandeLigneVentes.setBcmligTaxe(var6);
      this.commandeLigneVentes.setBcmligTauxTaxe(var5);
      double var35 = this.commandeLigneVentes.getBcmligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.commandeEnteteVentes.getBcmDevise());
      }

      var10 = this.commandeLigneVentes.getBcmligQte();
      if (this.commandeLigneVentes.getBcmligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.commandeLigneVentes.setBcmligQteUtil(this.commandeLigneVentes.getBcmligQte());
            var10 = this.commandeLigneVentes.getBcmligQte() * this.commandeLigneVentes.getBcmligLong();
         } else {
            this.commandeLigneVentes.setBcmligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.commandeLigneVentes.getBcmligCondition(), this.commandeLigneVentes.getBcmligQte(), this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.commandeLigneVentes.setBcmligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && this.commandeLigneVentes.getBcmligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.commandeLigneVentes.getBcmligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.commandeLigneVentes.getBcmligRabais() * (double)this.commandeLigneVentes.getBcmligQte();
      }

      if (this.commandeLigneVentes.getBcmligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.commandeLigneVentes.getBcmligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && this.commandeLigneVentes.getBcmligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.commandeLigneVentes.getBcmligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.commandeLigneVentes.getBcmligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.commandeLigneVentes.getBcmligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.commandeLigneVentes.getBcmligQte(), 2);
      }

      this.commandeLigneVentes.setBcmligPuRem(var25);
      this.commandeLigneVentes.setBcmligPt(var17);
      this.commandeLigneVentes.setBcmligTva(var21);
      this.commandeLigneVentes.setBcmligTc(0.0D);
      this.commandeLigneVentes.setBcmligTtc(var23);
      double var27 = 0.0D;
      if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && this.commandeLigneVentes.getBcmligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.commandeLigneVentes.getBcmligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.commandeLigneVentes.getBcmligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.commandeLigneVentes.getBcmligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.commandeLigneVentes.getBcmligQte(), 2);
      }

      this.commandeLigneVentes.setBcmligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0D;
      this.commandeLigneVentes.setBcmligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.commandeEnteteVentes.setBcmTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.commandeLigneVentes.setBcmligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
               if (this.commandeLigneVentes.getBcmligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0D;
                  this.commandeLigneVentes.setBcmligTc(var33);
               }
            }
         } else {
            if (this.commandeLigneVentes.getBcmligTva() != 0.0D) {
               var31 = var17 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.commandeLigneVentes.setBcmligTc(var33);
         }
      } else {
         this.commandeLigneVentes.setBcmligTc(0.0D);
         this.commandeEnteteVentes.setBcmTauxTc(0.0F);
      }

      this.commandeLigneVentes.setBcmligPt(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligPt(), this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligTva(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligTva(), this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligTtc(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligTtc(), this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligTc(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligTc(), this.commandeEnteteVentes.getBcmDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.commandeEnteteVentes.getBcmExoTva() == 0) {
         TaxesVentes var8;
         int var38;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
            } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxvteTaux();
                  var6 = var9.getTaxvteCode();
                  var38 = var9.getTaxvteType();
               } else {
                  var5 = var2;
                  var6 = var1;
                  var7 = false;
               }
            } else {
               var5 = var2;
               var6 = var1;
               var7 = false;
            }
         } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
            } else {
               var5 = var2;
               var6 = var1;
               var7 = false;
            }
         } else {
            var5 = var2;
            var6 = var1;
            var7 = false;
         }

         if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var5 = 0.0F;
            var6 = "";
            var7 = false;
         }
      }

      this.commandeLigneVentes.setBcmligTaxe(var6);
      this.commandeLigneVentes.setBcmligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.commandeEnteteVentes.getBcmTauxTc() != 0.0F && this.commandeLigneVentes.getBcmligTva() != 0.0D) {
         var10 = this.commandeLigneVentes.getBcmligTtc();
         var12 = var10 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.commandeLigneVentes.getBcmligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.commandeLigneVentes.getBcmligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.commandeLigneVentes.setBcmligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.commandeLigneVentes.getBcmligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.commandeLigneVentes.getBcmligRabais() * (double)this.commandeLigneVentes.getBcmligQte();
      }

      double var14 = 0.0D;
      if (this.commandeLigneVentes.getBcmligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.commandeLigneVentes.getBcmligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.commandeLigneVentes.getBcmligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.commandeLigneVentes.getBcmligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.commandeLigneVentes.getBcmligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.commandeLigneVentes.setBcmligQteUtil(this.commandeLigneVentes.getBcmligQte());
         } else {
            this.commandeLigneVentes.setBcmligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.commandeLigneVentes.getBcmligCondition(), this.commandeLigneVentes.getBcmligQte(), this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.commandeLigneVentes.setBcmligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.commandeLigneVentes.getBcmligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.commandeEnteteVentes.getBcmDevise()));
      double var26 = var20 * (double)this.commandeLigneVentes.getBcmligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.commandeEnteteVentes.getBcmDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligPuRem(var18);
      this.commandeLigneVentes.setBcmligPuRemTtc(var20);
      this.commandeLigneVentes.setBcmligPt(var24);
      this.commandeLigneVentes.setBcmligTva(var32);
      this.commandeLigneVentes.setBcmligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.commandeEnteteVentes.setBcmTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.commandeLigneVentes.setBcmligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
               if (this.commandeLigneVentes.getBcmligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0D;
                  this.commandeLigneVentes.setBcmligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.commandeEnteteVentes.getBcmTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.commandeLigneVentes.setBcmligTc(var36);
         }
      } else {
         this.commandeLigneVentes.setBcmligTc(0.0D);
         this.commandeEnteteVentes.setBcmTauxTc(0.0F);
      }

      this.commandeLigneVentes.setBcmligPt(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligPt(), this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligTva(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligTva(), this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligTtc(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligTtc(), this.commandeEnteteVentes.getBcmDevise()));
      this.commandeLigneVentes.setBcmligTc(this.utilNombre.myRoundDevise(this.commandeLigneVentes.getBcmligTc(), this.commandeEnteteVentes.getBcmDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.commandeLigneVentes != null && this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.commandeLigneVentes.getBcmligPuRemTtc() != 0.0D) {
               if (this.commandeLigneVentes.getBcmligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.commandeLigneVentes.getBcmligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.commandeLigneVentes.getBcmligPuRem() != 0.0D) {
            if (this.commandeLigneVentes.getBcmligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.commandeLigneVentes.getBcmligPu() < this.prixPlancher) {
            this.griserValider = true;
            this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

      this.calculPlafond();
   }

   public void calculPlafond() throws HibernateException, NamingException {
      if (this.plafondEnCours != 0.0D) {
         double var1 = 0.0D;
         if (this.commandeLigneVentes != null) {
            var1 = this.commandeLigneVentes.getBcmligTtc();
         }

         for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
            if (((CommandeLigneVentes)this.lesLignesList.get(var3)).getBcmligId() != this.commandeLigneVentes.getBcmligId()) {
               var1 += ((CommandeLigneVentes)this.lesLignesList.get(var3)).getBcmligTtc();
            }
         }

         if (this.soldeEnCours + var1 <= this.plafondEnCours) {
            this.plafondAutorise = true;
         } else {
            this.plafondAutorise = false;
            this.formRecherche.setMessageTexte("Vous avez dépassé le plafond autorisé. Veuillez réduire les quantités.....");
            this.formRecherche.setShowModalPanelMessage(true);
            if (this.commandeLigneVentes != null) {
               this.commandeLigneVentes.setBcmligQte(0.0F);
               this.calculPrix();
               this.cumulPrix();
            }
         }
      } else {
         this.plafondAutorise = true;
      }

   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         this.calculTtc(var1, var2, var3);
      } else {
         this.calculHt(var1, var2, var3);
      }

   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         new CommandeLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            CommandeLigneVentes var13 = (CommandeLigneVentes)this.lesLignesList.get(var14);
            if (var13.getBcmligGroupe() == null || var13.getBcmligGroupe().isEmpty()) {
               var3 += var13.getBcmligPt();
               var5 += var13.getBcmligTva();
               var7 += var13.getBcmligTtc();
               var9 += var13.getBcmligTc();
               if (var13.getBcmligRabais() != 0.0D || var13.getBcmligTauxRemise() != 0.0F) {
                  var11 += var13.getBcmligPu() * (double)var13.getBcmligQte() - var13.getBcmligPt();
               }

               var1 = var1 + var13.getBcmligPt() - var13.getBcmligPump() * (double)var13.getBcmligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.commandeEnteteVentes.setBcmTotHt(var3);
      this.commandeEnteteVentes.setBcmTotTva(var5);
      this.commandeEnteteVentes.setBcmTotTtc(var7);
      this.commandeEnteteVentes.setBcmTotRemise(var11);
      this.commandeEnteteVentes.setBcmTotTc(var9);
      if (this.plafondEnCours != 0.0D) {
         if (this.soldeEnCours + var7 <= this.plafondEnCours) {
            this.plafondAutorise = true;
         } else {
            this.plafondAutorise = false;
            this.formRecherche.setMessageTexte("Vous avez dépassé le plafond autorisé. Veuillez réduire les quantités.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      } else {
         this.plafondAutorise = true;
      }

   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.commandeLigneVentes = (CommandeLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         this.var_memo_qte = this.commandeLigneVentes.getBcmligQteUtil();
         if (this.commandeLigneVentes.getBcmligCode() != null && this.commandeLigneVentes.getBcmligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.commandeLigneVentes.setBcmligCode(this.produits.getProCode());
               this.commandeLigneVentes.setBcmligFamille(this.produits.getProAchCode());
               this.commandeLigneVentes.setBcmligStock(this.produits.getProStock());
               this.commandeLigneVentes.setBcmligLong(this.produits.getProLongueur());
               this.commandeLigneVentes.setBcmligLarg(this.produits.getProLargeur());
               this.commandeLigneVentes.setBcmligHaut(this.produits.getProEpaisseur());
               this.commandeLigneVentes.setBcmligDiam(this.produits.getProDiamExt());
               this.commandeLigneVentes.setBcmligPoidsBrut(this.produits.getProPoidsBrut());
               this.commandeLigneVentes.setBcmligPoidsNet(this.produits.getProPoidsNet());
               this.commandeLigneVentes.setBcmligVolume(this.produits.getProVolume());
               this.commandeLigneVentes.setBcmligNb(this.produits.getProNbUnite());
               this.var_aff_detail_prod = true;
               if (this.produits.getProImpDesciption() == 1) {
                  if (this.usersLog.getUsrVteLibelle() == 1) {
                     this.verrou_libelle = true;
                  } else {
                     this.verrou_libelle = false;
                  }
               } else {
                  this.verrou_libelle = false;
               }

               this.griserchamps = true;
               if (this.commandeLigneVentes.getBcmligTaxe() != null && !this.commandeLigneVentes.getBcmligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTaxe() + ":" + this.commandeLigneVentes.getBcmligTauxTaxe()));
               } else {
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }

               this.mefConditionnementDepot(var1);
               this.selectionDepot(var1);
               new FamillesProduitsVentes();
               FamillesProduitsVentes var4 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
               if (var4 != null && var4.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
                  float var3 = (100.0F - var4.getFamvteCoefPv()) / 100.0F;
                  this.prixPlancher = this.utilNombre.myRound(this.produitsDepot.getProdepPr() / (double)var3, 2);
               } else {
                  this.prixPlancher = 0.0D;
               }

               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         } else {
            this.produits = null;
            this.var_aff_detail_prod = false;
            this.verrou_libelle = false;
            this.griserchamps = false;
            this.griserValider = false;
            this.mesTaxesVentesProduits.clear();
            if (this.mesTaxesVentesItems.size() != 0) {
               for(int var2 = 0; var2 < this.mesTaxesVentesItems.size(); ++var2) {
                  this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var2));
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
         this.griserValider = false;
      }

   }

   public void selectionLigneDetailLight() throws HibernateException, NamingException {
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.commandeLigneVentes = (CommandeLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
         this.griserValider = false;
      }

   }

   public void addLigne() {
      this.produits = new Produits();
      this.memoProduits = new Produits();
      this.commandeLigneVentes = new CommandeLigneVentes();
      this.mesTaxesVentesProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
      this.var_memo_qte = 0.0F;
      this.var_depotProd = "";
      this.prixPlancher = 0.0D;
      this.griserValider = false;
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.commandeLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.commandeLigneVentes);
            this.lesLignesList.add(this.numLigne, this.commandeLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               this.commandeLigneVentes.setBcmligOrdre(var3);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
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

      this.addLigne();
   }

   public void ordonnnerAscendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.commandeLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.commandeLigneVentes);
            this.lesLignesList.add(this.numLigne, this.commandeLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               this.commandeLigneVentes.setBcmligOrdre(var3);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
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

      this.addLigne();
   }

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            if (this.commandeLigneVentes.getBcmligId() == ((CommandeLigneVentes)this.lesLignesList.get(var2)).getBcmligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() || this.commandeLigneVentes.getBcmligLibelle() != null && !this.commandeLigneVentes.getBcmligLibelle().isEmpty() || this.commandeLigneVentes.getBcmligComplement() != null && !this.commandeLigneVentes.getBcmligComplement().isEmpty()) {
         if (this.commandeEnteteVentes.getBcmId() == 0L) {
            this.save();
         }

         this.calculPlafond();
         this.majAnalytique((Session)null);
         if (this.plafondAutorise) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               if (this.commandeLigneVentes.getBcmligQteUtil() == 0.0F) {
                  this.commandeLigneVentes.setBcmligQteUtil(this.commandeLigneVentes.getBcmligQte());
               }

               this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var1);
               String[] var4;
               if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
                  String[] var3;
                  if (this.var_depotProd.contains(":")) {
                     var3 = this.var_depotProd.split(":");
                     this.commandeLigneVentes.setBcmligDepot(var3[0]);
                     var4 = this.var_depotProd.split("=");
                     this.commandeLigneVentes.setBcmligQteStock(Float.parseFloat(var4[1]));
                  } else {
                     var3 = this.var_depotProd.split("=");
                     this.commandeLigneVentes.setBcmligDepot(var3[0]);
                     this.commandeLigneVentes.setBcmligQteStock(Float.parseFloat(var3[1]));
                  }
               } else {
                  this.commandeLigneVentes.setBcmligDepot("");
                  this.commandeLigneVentes.setBcmligQteStock(0.0F);
               }

               if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && this.commandeLigneVentes.getBcmligCondition().contains(":")) {
                  ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
                  var4 = this.commandeLigneVentes.getBcmligCondition().split(":");
                  String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
                  if (var5 != null && !var5.isEmpty()) {
                     this.commandeLigneVentes.setBcmligDescription(var5);
                  } else {
                     this.commandeLigneVentes.setBcmligDescription("");
                  }

                  if (this.commandeLigneVentes.getBcmligEchelle() == 0) {
                     this.unite = new Unite();
                     this.unite = this.uniteDao.selectUnite(var4[0], var1);
                     if (this.unite != null) {
                        this.commandeLigneVentes.setBcmligEchelle(this.unite.getUniEchelle());
                     }
                  }
               } else {
                  this.commandeLigneVentes.setBcmligDescription("");
               }

               this.commandeLigneVentes.setBcmligEntStock(this.commandeEnteteVentes.getBcmStock());
               if (this.commandeLigneVentes.getBcmligId() == 0L) {
                  this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
                  this.commandeLigneVentes.setBcmligDevise(this.commandeEnteteVentes.getBcmDevise());
                  this.commandeLigneVentes = this.commandeLigneVentesDao.insertLigne(this.commandeLigneVentes, var1);
                  if (this.numLigne == 0) {
                     if (this.lesLignesList.size() != 0) {
                        this.numLigne = this.lesLignesList.size();
                     } else {
                        this.numLigne = 0;
                     }
                  }

                  this.lesLignesList.add(this.numLigne, this.commandeLigneVentes);
                  this.datamodelLigne.setWrappedData(this.lesLignesList);
                  this.numLigne = this.clauleNumlLigne() + 1;
               } else {
                  this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
               }

               if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
                  new CommandeLigneVentes();

                  for(int var18 = 0; var18 < this.lesLignesList.size(); ++var18) {
                     CommandeLigneVentes var16 = (CommandeLigneVentes)this.lesLignesList.get(var18);
                     if (var16.getBcmligGroupe() != null && !var16.getBcmligGroupe().isEmpty() && var16.getBcmligGroupe().equals(this.memoProduits.getProCode())) {
                        this.commandeLigneVentesDao.deleteOneLigne(var16, var1);
                        this.lesLignesList.remove(var16);
                        --var18;
                     }
                  }

                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               }

               if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
                  String var17 = this.produits.getProCode();
                  float var20 = this.commandeLigneVentes.getBcmligQte();
                  new CommandeLigneVentes();

                  CommandeLigneVentes var19;
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     var19 = (CommandeLigneVentes)this.lesLignesList.get(var6);
                     if (var19.getBcmligGroupe() != null && !var19.getBcmligGroupe().isEmpty() && var19.getBcmligGroupe().equals(var17)) {
                        this.commandeLigneVentesDao.deleteOneLigne(var19, var1);
                        this.lesLignesList.remove(var19);
                        --var6;
                     }
                  }

                  this.datamodelLigne.setWrappedData(this.lesLignesList);
                  new ArrayList();
                  ProduitsGrpDao var7 = new ProduitsGrpDao(this.baseLog, this.utilInitHibernate);
                  List var21 = var7.selectProdGrpByprod(this.produits, var1);
                  if (var21.size() != 0) {
                     for(int var8 = 0; var8 < var21.size(); ++var8) {
                        var19 = new CommandeLigneVentes();
                        var19.setBcmligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                        var19.setBcmligCondition("");
                        var19.setBcmligComplement("");
                        var19.setBcmligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                        var19.setBcmligDescription("");
                        var19.setBcmligDevise(this.commandeEnteteVentes.getBcmDevise());
                        var19.setBcmligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                        var19.setBcmligEchelle(0);
                        var19.setBcmligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                        var19.setBcmligGroupe(var17);
                        var19.setBcmligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                        var19.setBcmligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                        var19.setBcmligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                        var19.setBcmligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                        var19.setBcmligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                        var19.setBcmligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                        var19.setBcmligOrdre(var8);
                        var19.setBcmligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                        var19.setBcmligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                        var19.setBcmligPt(0.0D);
                        var19.setBcmligPu(0.0D);
                        var19.setBcmligPuRem(0.0D);
                        var19.setBcmligPuRemTtc(0.0D);
                        var19.setBcmligPuTtc(0.0D);
                        var19.setBcmligPump(0.0D);
                        float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                        var19.setBcmligQte(var9);
                        var19.setBcmligQteUtil(var19.getBcmligQte());
                        var19.setBcmligRabais(0.0D);
                        var19.setBcmligReference(var17);
                        var19.setBcmligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                        var19.setBcmligTauxRemise(0.0F);
                        var19.setBcmligTauxTaxe(0.0F);
                        var19.setBcmligTaxe("");
                        var19.setBcmligTc(0.0D);
                        var19.setBcmligTtc(0.0D);
                        var19.setBcmligTva(0.0D);
                        var19.setBcmligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                        var19.setBcmligVolume(0.0F);
                        var19.setCommandeEnteteVentes(this.commandeEnteteVentes);
                        var19 = this.commandeLigneVentesDao.insertLigne(var19, var1);
                        if (this.numLigne > this.lesLignesList.size()) {
                           this.numLigne = this.lesLignesList.size();
                        }

                        this.lesLignesList.add(this.numLigne + var8, var19);
                     }
                  }

                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               }

               this.cumulPrix();
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
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
      }

      if (this.plafondAutorise) {
         this.addLigne();
      }

   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.commandeLigneVentes.getBcmligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.commandeLigneVentes.getBcmligCode();
            int var4 = this.commandeLigneVentes.getBcmligModeGroupe();
            String var5 = this.commandeLigneVentes.getBcmligGroupe();
            this.commandeLigneVentesDao.deleteOneLigne(this.commandeLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new CommandeLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  CommandeLigneVentes var6 = (CommandeLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getBcmligGroupe() != null && !var6.getBcmligGroupe().isEmpty() && var6.getBcmligGroupe().equals(var3)) {
                     this.commandeLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " de la commande N° " + this.commandeEnteteVentes.getBcmNum() + " du " + this.commandeEnteteVentes.getBcmDate());
            this.espionDao.mAJEspion(var13, var1);
            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentLigne((Session)null);
         this.addLigne();
         this.cumulPrix();
         if (this.lesLignesList.size() != 0) {
            this.numLigne = this.lesLignesList.size();
         } else {
            this.numLigne = 0;
         }
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.commandeEnteteVentes.getBcmNomTiers(), this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         boolean var2 = false;
         if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
            if (this.tiers.getTieserie().equals("X")) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.mesSerieUserItem.size(); ++var3) {
                  if (((SelectItem)this.mesSerieUserItem.get(var3)).getValue().toString().equals(this.tiers.getTieserie())) {
                     var2 = true;
                     this.commandeEnteteVentes.setBcmSerie(this.tiers.getTieserie());
                     break;
                  }
               }
            }
         } else {
            var2 = true;
         }

         if (!var2) {
            this.annuleTiers();
         } else {
            this.commandeEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.commandeEnteteVentes.setBcmCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.commandeEnteteVentes.setBcmCivilTiers(this.commandeEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.commandeEnteteVentes.setBcmNomTiers(this.nomTier);
            this.commandeEnteteVentes.setBcmTypeReg(this.tiers.getTietypereg());
            this.commandeEnteteVentes.setBcmModeReg(this.tiers.getTiemodereg());
            this.calculMessageLitige(var1);
            String var8 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var8 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var8 = this.tiers.getTiemodereg();
            }

            int var9;
            if (!var8.equals("") && !var8.equals("100")) {
               this.commandeEnteteVentes.setBcmNbJourReg(this.tiers.getTienbecheance());
               this.commandeEnteteVentes.setBcmArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.commandeEnteteVentes.setBcmTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.commandeEnteteVentes.setBcmModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.commandeEnteteVentes.setBcmNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.commandeEnteteVentes.setBcmArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.commandeEnteteVentes.setBcmJournalReg(this.tiers.getTiejournalreg());
            this.commandeEnteteVentes.setBcmCat(this.tiers.getTienomfamille());
            if (this.var_tc_calcul) {
               this.commandeEnteteVentes.setBcmTauxTc(this.var_tc_taux);
            } else {
               this.commandeEnteteVentes.setBcmTauxTc(0.0F);
            }

            this.commandeEnteteVentes.setBcmExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.commandeEnteteVentes.setBcmExoDouane(1);
            }

            var9 = this.tiers.getTieexotva();
            if (var9 >= 2) {
               var9 = 0;
            }

            this.commandeEnteteVentes.setBcmExoTva(var9);
            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.commandeEnteteVentes.setBcmExoTva(1);
            }

            if (this.structureLog.getStrcodepays().equals("0077")) {
               this.var_tc_type = 1;
               if (this.tiers.getTiecss() == 0) {
                  this.var_tc_calcul = true;
               } else {
                  this.var_tc_calcul = false;
               }
            } else {
               this.var_tc_calcul = false;
               this.var_tc_type = 0;
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.commandeEnteteVentes.setBcmDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.commandeEnteteVentes.setBcmDiversTiers(0);
               this.commandeEnteteVentes.setBcmDiversNom("");
               this.commandeEnteteVentes.setBcmDiversAdresse("");
               this.commandeEnteteVentes.setBcmDiversVille("");
               this.commandeEnteteVentes.setBcmDiversTel("");
               this.commandeEnteteVentes.setBcmDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.commandeEnteteVentes.setBcmDevise(this.tiers.getTiedevise());
            } else {
               this.commandeEnteteVentes.setBcmDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }

            this.chargerLesUsers(var1);
            this.chargerLesParcs(var1);
            if (this.accesAffaires) {
               this.chargerAffaires(var1);
            } else {
               this.mesAffairesItems.clear();
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void calculMessageLitige(Session var1) throws HibernateException, NamingException {
      this.informationsTiers = null;
      this.plafondEnCours = 0.0D;
      this.soldeEnCours = 0.0D;
      this.plafondAutorise = false;
      if (this.tiers != null && this.commandeEnteteVentes != null) {
         String var2 = "";
         if (this.tiers.getTiecomptebloque() == 1) {
            var2 = "***   COMPTE BLOQUE   ***";
         } else if (this.tiers.getTiechequeinterdit() == 1) {
            var2 = "***   CHEQUE INTERDIT   ***";
         }

         String var3 = "";
         if (this.tiers.getTieplafond() != 0.0D) {
            if (this.optionsVentes.getGestionPlafondBc().equals("1")) {
               this.plafondEnCours = this.tiers.getTieplafond();
               new ArrayList();
               String var5 = " tiers.tieid=" + this.tiers.getTieid() + " and bcm_solde=0";
               double var6 = 0.0D;
               List var4 = this.commandeEnteteVentesDao.rechercheCommandeRequete(var5, var1);
               if (var4.size() != 0) {
                  for(int var8 = 0; var8 < var4.size(); ++var8) {
                     if (!((CommandeEnteteVentes)var4.get(var8)).getBcmNum().equals("1255/20")) {
                        var6 += ((CommandeEnteteVentes)var4.get(var8)).getBcmTotTtc() - ((CommandeEnteteVentes)var4.get(var8)).getBcmTotReglement();
                     }
                  }
               }

               this.soldeEnCours = var6;
               var3 = " Plafond: " + this.utilNombre.beginText(this.tiers.getTieplafond(), this.structureLog.getStrformatdevise()) + " - Solde en cours: " + this.utilNombre.beginText(var6, this.structureLog.getStrformatdevise());
            }
         } else {
            this.plafondAutorise = true;
         }

         String var9 = this.tiers.getTieobservations();
         if (var2 != null && !var2.isEmpty()) {
            this.informationsTiers = var2;
         }

         if (var3 != null && !var3.isEmpty()) {
            if (this.informationsTiers != null && !this.informationsTiers.isEmpty()) {
               this.informationsTiers = this.informationsTiers + " " + var3;
            } else {
               this.informationsTiers = var3;
            }
         }

         if (var9 != null && !var9.isEmpty()) {
            if (this.informationsTiers != null && !this.informationsTiers.isEmpty()) {
               this.informationsTiers = this.informationsTiers + " (" + var9 + ")";
            } else {
               this.informationsTiers = "(" + var9 + ")";
            }
         }

         this.cumulPrix();
      }

   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      this.informationsTiers = null;
      this.commandeEnteteVentes.setTiers(this.tiers);
      this.commandeEnteteVentes.setBcmNomTiers("");
      this.commandeEnteteVentes.setBcmCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      }

      this.mesAffairesItems.clear();
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void chargerLesParcs(Session var1) throws HibernateException, NamingException {
      if (this.var_anal_parc) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         if (this.var_option_parc == 1 || this.var_option_parc == 2) {
            this.mesParcsItems.clear();
            this.mesParcsItems = var2.chargerLesParcs(this.tiers.getTieid(), var1);
         }
      }

   }

   public void controleSaisie() throws ParseException {
      if (!this.commandeEnteteVentes.getBcmNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var3 = 0; var3 < this.lesFamilleClientsListe.size(); ++var3) {
            if (this.commandeEnteteVentes.getBcmCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.commandeEnteteVentes.setBcmExoTva(0);
      } else {
         this.commandeEnteteVentes.setBcmExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.commandeEnteteVentes.setBcmExoDouane(0);
      } else {
         this.commandeEnteteVentes.setBcmExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.commandeEnteteVentes.setBcmTauxTc(this.var_tc_taux);
      } else {
         this.commandeEnteteVentes.setBcmTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = new CommandeLigneVentes();
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               if (this.commandeEnteteVentes.getBcmExoTva() == 1) {
                  this.commandeLigneVentes.setBcmligTaxe("");
                  this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
                  this.commandeLigneVentes.setBcmligTva(0.0D);
               } else if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.commandeLigneVentes.setBcmligTaxe("");
                        this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.commandeLigneVentes.setBcmligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.commandeLigneVentes.setBcmligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.commandeLigneVentes.getBcmligTaxe(), var1);
                        if (var5 != null) {
                           this.commandeLigneVentes.setBcmligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.commandeLigneVentes.setBcmligTaxe(this.optionsVentes.getTvaDefaut());
                        this.commandeLigneVentes.setBcmligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.commandeLigneVentes.setBcmligTaxe("");
                        this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
                     }
                  } else {
                     this.commandeLigneVentes.setBcmligTaxe("");
                     this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
                  }

                  if ((this.commandeLigneVentes.getBcmligTaxe() == null || this.commandeLigneVentes.getBcmligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.commandeLigneVentes.setBcmligTaxe(var5.getTaxvteCode());
                        this.commandeLigneVentes.setBcmligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var1);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
            }
         }

         if (this.commandeEnteteVentes.getBcmId() != 0L) {
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
            var2.commit();
         }
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

   public void calculeRemiseGlobale() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.commandeLigneVentes = new CommandeLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               this.commandeLigneVentes.setBcmligTauxRemise(this.commandeEnteteVentes.getBcmTauxRemise());
               this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var1);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var1);
            }
         }

         if (this.commandeEnteteVentes.getBcmId() != 0L) {
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
            var2.commit();
         }
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.chargerDocumentLigne((Session)null);
      this.cumulPrix();
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

   public void rechercheDestinataire() throws JDOMException, IOException, HibernateException, NamingException {
      if (!this.selectDestinataire) {
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.inpDestinataire, this.nature);
      } else {
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.commandeEnteteVentes.getBcmNomContact(), this.nature);
      }

      if (this.plansAnalytiques != null) {
         if (this.plansAnalytiques.getAnaId() != 0L) {
            this.calculeDestinataire();
         } else {
            this.var_action = 10;
         }
      } else if (this.plansAnalytiques == null) {
         this.annuleDestinataire();
      }

   }

   public void recuperationDestinataire() throws JDOMException, IOException, HibernateException, NamingException {
      this.plansAnalytiques = this.formRecherche.calculeDestinataire();
      this.calculeDestinataire();
   }

   public void calculeDestinataire() throws JDOMException, IOException {
      if (!this.selectDestinataire) {
         this.inpDestinataire = this.plansAnalytiques.getAnaNomFr();
      } else if (this.plansAnalytiques != null) {
         this.commandeEnteteVentes.setBcmNomContact(this.plansAnalytiques.getAnaNomFr());
         this.commandeEnteteVentes.setBcmCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.commandeEnteteVentes.setBcmAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.commandeEnteteVentes.setBcmNomContact("");
      this.commandeEnteteVentes.setBcmCivilContact("");
      this.commandeEnteteVentes.setBcmAnal4("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpResponsable, this.nature);
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

   public void rechercheCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpCommercial, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeCommercial();
         } else {
            this.var_action = 17;
         }
      } else if (this.responsable == null) {
         this.calculeCommercial();
      }

   }

   public void recuperationCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeCommercial();
      this.calculeCommercial();
   }

   public void calculeCommercial() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpCommercial = this.responsable.getUsrPatronyme();
      } else {
         this.inpCommercial = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleCommercial() {
      this.inpCommercial = "";
      this.var_action = this.var_memo_action;
   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && !this.commandeLigneVentes.getBcmligCode().equals("-") && !this.commandeLigneVentes.getBcmligCode().equals("=")) {
         if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.commandeLigneVentes.getBcmligCode(), this.nature, this.optionsVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.commandeLigneVentes.getBcmligCode(), this.nature, this.optionsVentes);
         }

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

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         this.commandeLigneVentes.setBcmligCode(this.produits.getProCode());
         this.commandeLigneVentes.setBcmligProcess(this.produits.getProProcess());
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            this.commandeLigneVentes.setBcmligLibelle(this.produits.getProLibTech());
         } else {
            this.commandeLigneVentes.setBcmligLibelle(this.produits.getProLibClient());
         }

         this.commandeLigneVentes.setBcmligFamille(this.produits.getProVteCode());
         this.commandeLigneVentes.setBcmligStock(this.produits.getProStock());
         this.commandeLigneVentes.setBcmligLong(this.produits.getProLongueur());
         this.commandeLigneVentes.setBcmligLarg(this.produits.getProLargeur());
         this.commandeLigneVentes.setBcmligHaut(this.produits.getProEpaisseur());
         this.commandeLigneVentes.setBcmligDiam(this.produits.getProDiamExt());
         this.commandeLigneVentes.setBcmligPoidsBrut(this.produits.getProPoidsBrut());
         this.commandeLigneVentes.setBcmligPoidsNet(this.produits.getProPoidsNet());
         this.commandeLigneVentes.setBcmligVolume(this.produits.getProVolume());
         this.commandeLigneVentes.setBcmligNb(this.produits.getProNbUnite());
         this.commandeLigneVentes.setBcmligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.commandeLigneVentes.setBcmligModeGroupe(this.produits.getProMode());
         if (this.produits.getProImpDesciption() == 1) {
            if (this.usersLog.getUsrVteLibelle() == 1) {
               this.verrou_libelle = true;
            } else {
               this.verrou_libelle = false;
            }
         } else {
            this.verrou_libelle = false;
         }

         this.mesTaxesVentesProduits.clear();
         new FamillesProduitsVentes();
         FamillesProduitsVentes var2 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
         if (!this.produits.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
            TaxesVentes var3;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
               if (var3 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var3.getTaxvteTaux()));
                  this.commandeLigneVentes.setBcmligTaxe(this.produits.getProVteTva());
                  this.commandeLigneVentes.setBcmligTauxTaxe(var3.getTaxvteTaux());
               } else {
                  this.commandeLigneVentes.setBcmligTaxe("");
                  this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var2 != null && var2.getFamvteTaxe() != null && !var2.getFamvteTaxe().isEmpty() && !var2.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var2.getFamvteTaxe(), var1);
               if (var3 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var2.getFamvteTaxe(), var2.getFamvteTaxe() + ":" + var3.getTaxvteTaux()));
                  this.commandeLigneVentes.setBcmligTaxe(var2.getFamvteTaxe());
                  this.commandeLigneVentes.setBcmligTauxTaxe(var3.getTaxvteTaux());
               }
            } else {
               this.commandeLigneVentes.setBcmligTaxe("");
               this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.commandeEnteteVentes.getBcmExoTva() == 0 && (this.commandeLigneVentes.getBcmligTaxe() == null || this.commandeLigneVentes.getBcmligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var3 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var3.getTaxvteCode(), var3.getTaxvteCode() + ":" + var3.getTaxvteTaux()));
                  this.commandeLigneVentes.setBcmligTaxe(var3.getTaxvteCode());
                  this.commandeLigneVentes.setBcmligTauxTaxe(var3.getTaxvteTaux());
               }
            }
         } else {
            this.commandeLigneVentes.setBcmligTaxe("");
            this.commandeLigneVentes.setBcmligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var2 != null && var2.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var8 = (100.0F - var2.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var8;
               double var6 = var4 + var4 * (double)this.commandeLigneVentes.getBcmligTauxTaxe() / 100.0D;
               this.prixPlancher = this.utilNombre.myRound(var6, 2);
            } else {
               this.prixPlancher = this.utilNombre.myRound(this.produitsDepot.getProdepPr() / (double)var8, 2);
            }
         } else {
            this.prixPlancher = 0.0D;
         }

         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.commandeLigneVentes.setBcmligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.commandeLigneVentes.setBcmligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.commandeLigneVentes.setBcmligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.commandeLigneVentes.setBcmligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.commandeLigneVentes.setBcmligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.commandeLigneVentes.getBcmligPump() != 0.0D) {
            this.commandeLigneVentes.setBcmligPu(this.commandeLigneVentes.getBcmligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var1);
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

   public void calculTva() {
      if (this.commandeLigneVentes.getBcmligCode() == null || this.commandeLigneVentes.getBcmligCode().isEmpty() || this.commandeLigneVentes.getBcmligCode().length() < 2) {
         if (this.commandeEnteteVentes.getBcmExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.commandeLigneVentes.setBcmligTaxe(this.optionsVentes.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.produitsDepot = null;
      this.commandeLigneVentes.setBcmligCode("");
      this.commandeLigneVentes.setBcmligLibelle("");
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            var2 = this.commandeLigneVentes.getBcmligPuTtc();
         } else {
            var2 = this.commandeLigneVentes.getBcmligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.commandeLigneVentes.setBcmligPuTtc(this.prixUnitaires);
            this.commandeLigneVentes.setBcmligPuRemTtc(this.prixUnitaires);
         } else {
            this.commandeLigneVentes.setBcmligPu(this.prixUnitaires);
            this.commandeLigneVentes.setBcmligPuRem(this.prixUnitaires);
         }

         double var4 = 0.0D;
         if (this.verifBareme) {
            Baremes var6 = new Baremes();
            Baremes var7 = new Baremes();
            new ArrayList();
            List var8 = this.baremesDao.rechercheToutBaremeProduit(this.tiers.getTieid(), this.produits.getProCode(), this.produits.getProVteCode(), this.tiers.getTienomfamille(), var1);
            if (var8.size() != 0) {
               int var9;
               for(var9 = 0; var9 < var8.size(); ++var9) {
                  var6 = (Baremes)var8.get(var9);
                  if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == this.tiers.getTieid() && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                     var4 = var6.getBarPrix();
                     var7 = var6;
                     break;
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(this.tiers.getTiecategorie()) && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == this.tiers.getTieid() && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(this.tiers.getTiecategorie()) && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 != 0.0D) {
                  this.prixUnitaires = var4;
               }

               if (var7 != null && var7.getBarId() != 0L) {
                  double var11;
                  if (var6.getBarRemise() != 0.0F) {
                     this.commandeLigneVentes.setBcmligTauxRemise(var6.getBarRemise());
                     this.commandeLigneVentes.setBcmligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.commandeEnteteVentes.getBcmDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.commandeLigneVentes.setBcmligPuTtc(this.prixUnitaires);
                        this.commandeLigneVentes.setBcmligPuRemTtc(var11);
                     } else {
                        this.commandeLigneVentes.setBcmligPu(this.prixUnitaires);
                        this.commandeLigneVentes.setBcmligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.commandeLigneVentes.setBcmligTauxRemise(var6.getBarRemise());
                     this.commandeLigneVentes.setBcmligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.commandeLigneVentes.getBcmligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.commandeLigneVentes.setBcmligPuTtc(this.prixUnitaires);
                        this.commandeLigneVentes.setBcmligPuRemTtc(var11);
                     } else {
                        this.commandeLigneVentes.setBcmligPu(this.prixUnitaires);
                        this.commandeLigneVentes.setBcmligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.commandeLigneVentes.setBcmligTauxRemise(var6.getBarRemise());
                     this.commandeLigneVentes.setBcmligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.commandeLigneVentes.setBcmligPuTtc(this.prixUnitaires);
                        this.commandeLigneVentes.setBcmligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.commandeLigneVentes.setBcmligPu(this.prixUnitaires);
                        this.commandeLigneVentes.setBcmligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.commandeLigneVentes.setBcmligPuTtc(this.prixUnitaires);
                     this.commandeLigneVentes.setBcmligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.commandeLigneVentes.setBcmligPu(this.prixUnitaires);
                     this.commandeLigneVentes.setBcmligPuRem(this.prixUnitaires);
                  }
               }
            }
         }
      }

   }

   public double prixCalculeAuto() {
      double var1 = 0.0D;
      this.prixUnitaires = 0.0D;
      if (this.produits.getProFormule() != null && !this.produits.getProFormule().isEmpty() && this.produits.getProFormule().contains("=")) {
         String[] var3 = this.produits.getProFormule().split("=");
         String var4 = var3[0];
         double var5 = 0.0D;
         if (var4 != null && !var4.isEmpty() && var4.equals("TAUX")) {
            double var10 = Double.parseDouble(var3[1]);

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((CommandeLigneVentes)this.lesLignesList.get(var9)).getBcmligCode() == null || ((CommandeLigneVentes)this.lesLignesList.get(var9)).getBcmligCode().isEmpty() || !((CommandeLigneVentes)this.lesLignesList.get(var9)).getBcmligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((CommandeLigneVentes)this.lesLignesList.get(var9)).getBcmligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((CommandeLigneVentes)this.lesLignesList.get(var8)).getBcmligFamille() != null && !((CommandeLigneVentes)this.lesLignesList.get(var8)).getBcmligFamille().isEmpty() && ((CommandeLigneVentes)this.lesLignesList.get(var8)).getBcmligFamille().equals(var7)) {
                  var5 += ((CommandeLigneVentes)this.lesLignesList.get(var8)).getBcmligPt();
               }
            }

            this.prixUnitaires = var5;
         }
      } else {
         this.prixUnitaires = 0.0D;
      }

      var1 = this.prixUnitaires;
      return var1;
   }

   public void prixUnitaireDegressif(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = this.commandeLigneVentes.getBcmligPu();
         double var4 = this.commandeLigneVentes.getBcmligPuTtc();
         if (this.commandeLigneVentes.getBcmligPu() >= 0.0D && this.commandeLigneVentes.getBcmligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.commandeEnteteVentes.getBcmCat(), (String)null, var1);
            if (var6 != null) {
               new ObjetTarif();
               if (var6.getProtarTarifQte() != null && !var6.getProtarTarifQte().isEmpty()) {
                  double var8 = 0.0D;
                  ObjetTarif var7;
                  String[] var10;
                  if (!var6.getProtarTarifQte().contains("#")) {
                     var10 = var6.getProtarTarifQte().split(":");
                     var7 = new ObjetTarif();
                     var7.setQteDebut(Float.parseFloat(var10[0]));
                     var7.setQteFin(Float.parseFloat(var10[1]));
                     var7.setPrix(Double.parseDouble(var10[2]));
                     if (this.commandeLigneVentes.getBcmligQte() >= var7.getQteDebut() && this.commandeLigneVentes.getBcmligQte() <= var7.getQteFin()) {
                        var8 = var7.getPrix();
                     }
                  } else {
                     var10 = var6.getProtarTarifQte().split("#");
                     int var11 = var10.length;

                     for(int var12 = 0; var12 < var11; ++var12) {
                        String[] var13 = var10[var12].split(":");
                        var7 = new ObjetTarif();
                        var7.setQteDebut(Float.parseFloat(var13[0]));
                        var7.setQteFin(Float.parseFloat(var13[1]));
                        var7.setPrix(Double.parseDouble(var13[2]));
                        if (this.commandeLigneVentes.getBcmligQte() >= var7.getQteDebut() && this.commandeLigneVentes.getBcmligQte() <= var7.getQteFin()) {
                           var8 = var7.getPrix();
                           break;
                        }
                     }
                  }

                  if (var8 != 0.0D) {
                     this.prixUnitaires = var8;
                  } else {
                     this.prixUnitaires = var6.getProtarPv();
                  }
               } else {
                  this.prixUnitaires = var6.getProtarPv();
               }

               if (this.prixUnitaires == 0.0D) {
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.prixUnitaires = var4;
                  } else {
                     this.prixUnitaires = var2;
                  }
               }
            } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var4;
            } else {
               this.prixUnitaires = var2;
            }
         } else {
            var2 = Math.abs(this.commandeLigneVentes.getBcmligPu());
            var4 = Math.abs(this.commandeLigneVentes.getBcmligPuTtc());
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var4;
            } else {
               this.prixUnitaires = var2;
            }
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.commandeLigneVentes.setBcmligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && this.commandeLigneVentes.getBcmligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.commandeLigneVentes.getBcmligEchelle());
            float var5 = 1.0F;
            if (this.commandeLigneVentes.getBcmligCondition().contains("/")) {
               String[] var6 = this.commandeLigneVentes.getBcmligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && !this.commandeLigneVentes.getBcmligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.commandeLigneVentes.getBcmligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.commandeLigneVentes.setBcmligPump(var9);
      } else {
         this.commandeLigneVentes.setBcmligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.commandeLigneVentes.getBcmligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.commandeLigneVentes.setBcmligEchelle(this.unite.getUniEchelle());
               } else {
                  this.commandeLigneVentes.setBcmligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.commandeLigneVentes.setBcmligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.commandeLigneVentes.setBcmligEchelle(Integer.parseInt(var2));
         } else {
            this.commandeLigneVentes.setBcmligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, 23, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var10 = 0; var10 < this.listeProduitDepot.size(); ++var10) {
               ProduitsDepot var11 = (ProduitsDepot)this.listeProduitDepot.get(var10);
               float var12 = 0.0F;
               if (this.optionsVentes.getChoixStock().equals("1")) {
                  var12 = var11.getProdepQteStk() - var11.getProdepQteAttVte();
               } else {
                  var12 = var11.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var12;
               }

               String[] var13;
               if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
                  var13 = this.tiers.getTiedepot().split(":");
                  if (var11.getDepot().getDpoCode().equals(var13[0])) {
                     if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                        this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                     } else {
                        this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                     }
                  }
               } else if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
                  if (!this.verrouDepotUser.contains(",")) {
                     if (var11.getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                        if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                        }
                     }
                  } else {
                     var13 = this.verrouDepotUser.split(",");
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
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementVentes(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void verifBonEncaissement() {
      if (Math.abs(this.montantElmTotBonEnc) <= Math.abs(this.commandeEnteteVentes.getBcmTotTtc() - this.var_tot_bon_encaissement)) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.tiers.getTiedepotavance()) {
         this.montantElmTotBonEnc = this.tiers.getTiedepotavance();
      }

   }

   public void serieSelectTrf() throws HibernateException, NamingException, ParseException {
      this.mesSeriesTrfItems.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
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

      if (this.optionsVentes.getDateTransformation().equals("0")) {
         this.var_date_trf = null;
      } else {
         this.var_date_trf = new Date();
      }

      this.var_serie_trf = this.commandeEnteteVentes.getBcmSerie();
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 20) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (this.var_type_trf == 21) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (this.var_type_trf == 22) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (this.var_type_trf == 23) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (this.var_type_trf == 24) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (this.var_type_trf == 25) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (this.var_type_trf == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (this.var_type_trf == 27) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (this.var_type_trf == 28) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
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
      this.var_imput_serie = this.commandeEnteteVentes.getBcmSerie();
      this.var_imput_cat = this.commandeEnteteVentes.getBcmCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new CommandeEnteteVentes();
         CommandeEnteteVentes var1 = this.commandeEnteteVentesDao.pourParapheur(this.var_imput_num, (Session)null);
         if (var1 != null) {
            this.var_imput_num = "";
         }
      }

   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException, Exception {
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.commandeEnteteVentes.getBcmNum();
               this.commandeEnteteVentes.setBcmNum(this.var_imput_num);
               this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
               if (this.commandeEnteteVentes.getBcmTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.commandeEnteteVentes.getBcmNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.commandeEnteteVentes.getBcmNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Commande N° " + var3 + " en Commande N° " + this.commandeEnteteVentes.getBcmNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.commandeEnteteVentes.getBcmNum();
            this.commandeEnteteVentes.setBcmSerie(this.var_imput_serie);
            this.commandeEnteteVentes.setBcmCat(this.var_imput_cat);
            this.commandeEnteteVentes.setBcmNum(this.calculChrono.numCompose(this.commandeEnteteVentes.getBcmDate(), this.nature, this.commandeEnteteVentes.getBcmSerie(), var1));
            this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
            if (this.commandeEnteteVentes.getBcmTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.commandeEnteteVentes.getBcmNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.commandeEnteteVentes.getBcmNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Commande X N° " + var3 + " en Commande " + this.commandeEnteteVentes.getBcmSerie() + " N° " + this.commandeEnteteVentes.getBcmNum());
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
         Object var2 = new ArrayList();
         if (this.usersLog.getUsrDepotSel() == 1) {
            UsersFavorisDao var3 = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
            var2 = var3.chargerUsersFavoris(this.usersLog, var1);
         }

         new CommandeLigneVentes();

         for(int var4 = 0; var4 < this.documentDetailTrf.size(); ++var4) {
            CommandeLigneVentes var11 = (CommandeLigneVentes)this.documentDetailTrf.get(var4);
            float var5 = 0.0F;
            ArrayList var6 = new ArrayList();
            LivraisonLigneVentesDao var12;
            if (this.var_type_trf == 22) {
               var12 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var5 = var12.chargerLesReliquatsCommandeVtes(var11.getBcmligId(), var1);
            } else {
               List var7;
               int var8;
               ProduitsDepot var9;
               int var10;
               if (this.var_type_trf == 23) {
                  if (var11.getBcmligCode() != null && !var11.getBcmligCode().isEmpty() && var11.getBcmligCode().length() >= 2) {
                     new ArrayList();
                     var7 = this.produitsDepotDao.selectProdDepByprod(var11.getBcmligCode(), var1);
                     if (var7.size() != 0) {
                        for(var8 = 0; var8 < var7.size(); ++var8) {
                           new ProduitsDepot();
                           var9 = (ProduitsDepot)var7.get(var8);
                           if (var9.getDepot().getDpoLivraison() == 1) {
                              if (((List)var2).size() != 0 && this.usersLog.getUsrDepotSel() == 1) {
                                 if (((List)var2).size() != 0) {
                                    for(var10 = 0; var10 < ((List)var2).size(); ++var10) {
                                       if (((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin() != null && !((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin().isEmpty() && ((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin().equals(var9.getDepot().getDpoCode())) {
                                          var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                                       }
                                    }
                                 }
                              } else {
                                 var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                              }
                           }
                        }
                     }
                  }

                  var12 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
                  var5 = var12.chargerLesReliquatsCommandeVtes(var11.getBcmligId(), var1);
               } else if (this.var_type_trf == 25) {
                  if (var11.getBcmligCode() != null && !var11.getBcmligCode().isEmpty() && var11.getBcmligCode().length() >= 2) {
                     new ArrayList();
                     var7 = this.produitsDepotDao.selectProdDepByprod(var11.getBcmligCode(), var1);
                     if (var7.size() != 0) {
                        for(var8 = 0; var8 < var7.size(); ++var8) {
                           new ProduitsDepot();
                           var9 = (ProduitsDepot)var7.get(var8);
                           if (var9.getDepot().getDpoLivraison() == 1) {
                              if (((List)var2).size() != 0 && this.usersLog.getUsrDepotSel() == 1) {
                                 if (((List)var2).size() != 0) {
                                    for(var10 = 0; var10 < ((List)var2).size(); ++var10) {
                                       if (((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin() != null && !((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin().isEmpty() && ((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin().equals(var9.getDepot().getDpoCode())) {
                                          var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                                       }
                                    }
                                 }
                              } else {
                                 var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                              }
                           }
                        }
                     }
                  }

                  FactureLigneVentesDao var13 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
                  var5 = var13.chargerLesReliquatsCommandeVtes(var11.getBcmligId(), var1);
               } else if (this.var_type_trf == 28) {
                  if (var11.getBcmligCode() != null && !var11.getBcmligCode().isEmpty() && var11.getBcmligCode().length() >= 2) {
                     new ArrayList();
                     var7 = this.produitsDepotDao.selectProdDepByprod(var11.getBcmligCode(), var1);
                     if (var7.size() != 0) {
                        for(var8 = 0; var8 < var7.size(); ++var8) {
                           new ProduitsDepot();
                           var9 = (ProduitsDepot)var7.get(var8);
                           if (var9.getDepot().getDpoLivraison() == 1) {
                              if (((List)var2).size() != 0 && this.usersLog.getUsrDepotSel() == 1) {
                                 if (((List)var2).size() != 0) {
                                    for(var10 = 0; var10 < ((List)var2).size(); ++var10) {
                                       if (((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin() != null && !((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin().isEmpty() && ((UsersFavoris)((List)var2).get(var10)).getUsrfavLogin().equals(var9.getDepot().getDpoCode())) {
                                          var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                                       }
                                    }
                                 }
                              } else {
                                 var6.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                              }
                           }
                        }
                     }
                  }

                  var12 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
                  var5 = var12.chargerLesReliquatsCommandeVtes(var11.getBcmligId(), var1);
               }
            }

            float var14 = var11.getBcmligQte() - var5;
            if (var14 < 0.0F) {
               var14 = 0.0F;
            }

            var11.setVar_qteDejaTrf(var5);
            var11.setVar_listDepotItem(var6);
            float var15 = this.verifQteDisponibleBc(var11);
            if (var14 > var15 && this.structureLog.getStrstockNegatif() == 2 && var11.getBcmligDepot() != null && !var11.getBcmligDepot().isEmpty() && var11.getBcmligStock() != 0) {
               var14 = var15;
            }

            var11.setVar_qteReliquat(var14);
            var11 = (CommandeLigneVentes)this.documentDetailTrf.set(var4, var11);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         new CommandeLigneVentes();

         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            CommandeLigneVentes var1 = (CommandeLigneVentes)this.documentDetailTrf.get(var2);
            var1.setVar_qteReliquat(0.0F);
            this.verifQteDisponibleBc(var1);
            var1 = (CommandeLigneVentes)this.documentDetailTrf.set(var2, var1);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public float verifQteDisponibleBc(CommandeLigneVentes var1) {
      float var2 = 0.0F;
      if ((var1.getVar_depotLigne() == null || var1.getVar_depotLigne().isEmpty()) && var1.getVar_listDepotItem() != null && var1.getVar_listDepotItem().size() != 0) {
         var1.setVar_depotLigne(((SelectItem)var1.getVar_listDepotItem().get(0)).getValue().toString());
      }

      if (var1.getVar_depotLigne() != null && !var1.getVar_depotLigne().isEmpty() && var1.getVar_depotLigne().contains("=")) {
         String[] var3 = var1.getVar_depotLigne().split("=");
         var2 = Float.parseFloat(var3[1]);
      }

      return var2;
   }

   public void selectionLivree() {
      if (this.datamodelTransfert.isRowAvailable()) {
         this.commandeLigneVentes = (CommandeLigneVentes)this.datamodelTransfert.getRowData();
      }

   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;

         for(int var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
            var3 += ((CommandeLigneVentes)this.documentDetailTrf.get(var5)).getBcmligQte();
            var2 += ((CommandeLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((CommandeLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         CommandeEnteteVentes var6;
         int var7;
         if (var3 == var2) {
            new CommandeEnteteVentes();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               var6 = (CommandeEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setBcmEtat(5);
                  this.commandeEnteteVentesDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            if (this.var_mode_trf.equals("0")) {
               new CommandeEnteteVentes();

               for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
                  var6 = (CommandeEnteteVentes)this.lesEntetesList.get(var7);
                  if (var6.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var6.getBcmNum().equalsIgnoreCase(((CommandeEnteteVentes)var1.get(var9)).getBcmNum())) {
                           var8 = true;
                           break;
                        }
                     }

                     if (!var8) {
                        var1.add(var6);
                     }
                  }
               }
            } else {
               new CommandeEnteteVentes();

               for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                  var6 = (CommandeEnteteVentes)this.lesEntetesList.get(var7);
                  if (var6.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var6.getTiers().getTieid() == ((CommandeEnteteVentes)var1.get(var9)).getTiers().getTieid()) {
                           if (var6.getBcmSerie().equalsIgnoreCase(((CommandeEnteteVentes)var1.get(var9)).getBcmSerie())) {
                              var8 = true;
                           }
                           break;
                        }
                     }

                     if (!var8) {
                        var1.add(var6);
                     }
                  }
               }
            }

            if (var1.size() != 0) {
               for(var11 = 0; var11 < var1.size(); ++var11) {
                  this.commandeEnteteVentes = (CommandeEnteteVentes)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((CommandeEnteteVentes)var1.get(var11)).getBcmNum().equalsIgnoreCase(((CommandeLigneVentes)this.documentDetailTrf.get(var7)).getCommandeEnteteVentes().getBcmNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((CommandeEnteteVentes)var1.get(var11)).getTiers().getTieid() == ((CommandeLigneVentes)this.documentDetailTrf.get(var7)).getCommandeEnteteVentes().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0) {
                     this.utilParapheur.supprimerParapheur(this.commandeEnteteVentes.getBcmId(), this.nature, (Session)null);
                     if (this.var_type_trf != 23) {
                        if (this.var_type_trf == 25) {
                           FactureEnteteVentes var13 = new FactureEnteteVentes();
                           this.trfFac(var13);
                        } else if (this.var_type_trf == 28) {
                           this.trfChg();
                        }
                     } else {
                        LivraisonEnteteVentes var12 = new LivraisonEnteteVentes();
                        var12 = this.trfBl(var12);
                        if (this.optionsVentes.getImpressionBcBlCOM() == null || this.optionsVentes.getImpressionBcBlCOM().isEmpty()) {
                           this.optionsVentes.setImpressionBcBlCOM("0");
                        }

                        if (this.optionsVentes.getImpressionBcBlCOM().equals("1") && var12 != null && var12.getBlvModeleImp() != null && !var12.getBlvModeleImp().isEmpty()) {
                           this.utilPrint = new UtilPrint(this.utilInitHibernate);
                           this.impressionBl(this.utilPrint, var12, var12.getBlvModeleImp(), "JRV");
                        }
                     }
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
               this.commandeEnteteVentes = (CommandeEnteteVentes)this.lesEntetesList.get(var11);
               if (this.commandeEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.commandeEnteteVentes);
                  --var11;
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

   public LivraisonEnteteVentes trfBl(LivraisonEnteteVentes var1) throws HibernateException, NamingException, Exception {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      LivraisonEnteteVentesDao var3 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      LivraisonLigneVentesDao var4 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      Transaction var5 = null;

      boolean var7;
      double var13;
      double var15;
      double var17;
      double var19;
      try {
         var5 = var2.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var1.setBlvSerie(this.var_serie_trf);
         } else {
            var1.setBlvSerie(this.commandeEnteteVentes.getBcmSerie());
         }

         var1.setUsers(this.usersLog);
         var1.setBlvIdCreateur(this.usersLog.getUsrid());
         var1.setBlvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var1.setBlvDate(this.utilDate.dateToSQLLight(this.commandeEnteteVentes.getBcmDate()));
         } else {
            var1.setBlvDate(this.var_date_trf);
         }

         var1.setBlvDate(this.utilDate.dateToSQL(var1.getBlvDate(), this.var_heure, this.var_minute, this.var_seconde));
         var1.setBlvDateCreat(new Date());
         var1.setBlvDateModif((Date)null);
         var1.setBlvIdModif(0L);
         var1.setBlvNomModif("");
         var1.setBlvNum("");
         var7 = false;
         int var56;
         if (this.optionsVentes.getNbrJrRelanceLIV() != null && !this.optionsVentes.getNbrJrRelanceLIV().isEmpty()) {
            var56 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceLIV());
         } else {
            var56 = 0;
         }

         boolean var8 = false;
         int var57;
         if (this.optionsVentes.getNbrJrValidLIV() != null && !this.optionsVentes.getNbrJrValidLIV().isEmpty()) {
            var57 = Integer.parseInt(this.optionsVentes.getNbrJrValidLIV());
         } else {
            var57 = 0;
         }

         var1.setBlvDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var56));
         var1.setBlvDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var57));
         var1.setBlvService(this.commandeEnteteVentes.getBcmService());
         if (!var1.getBlvSerie().equalsIgnoreCase("X") && !var1.getBlvSerie().isEmpty()) {
            var1.setBlvNum(this.calculChrono.numCompose(var1.getBlvDate(), this.var_type_trf, var1.getBlvSerie(), var2));
         } else {
            long var9 = var3.selectLastNum(var2);
            var1.setBlvNum("" + var9);
         }

         new Habilitation();
         Habilitation var60 = this.verifieExistenceHabilitationBl(var1, var2);
         var1.setBlvSource(this.commandeEnteteVentes.getBcmSource());
         var1.setBlvNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
         var1.setBlvIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
         var1.setBlvNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
         var1.setBlvIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
         var1.setBlvNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
         var1.setBlvIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
         var1.setBlvNomTiers(this.commandeEnteteVentes.getBcmNomTiers());
         var1.setBlvCivilTiers(this.commandeEnteteVentes.getBcmCivilTiers());
         var1.setBlvTiersRegroupe(this.commandeEnteteVentes.getBcmTiersRegroupe());
         var1.setBlvIdContact(this.commandeEnteteVentes.getBcmIdContact());
         var1.setBlvNomContact(this.commandeEnteteVentes.getBcmNomContact());
         var1.setBlvCivilContact(this.commandeEnteteVentes.getBcmCivilContact());
         var1.setBlvDiversAdresse(this.commandeEnteteVentes.getBcmDiversAdresse());
         var1.setBlvDiversMail(this.commandeEnteteVentes.getBcmDiversMail());
         var1.setBlvDiversNom(this.commandeEnteteVentes.getBcmDiversNom());
         var1.setBlvDiversTel(this.commandeEnteteVentes.getBcmDiversTel());
         var1.setBlvDiversTiers(this.commandeEnteteVentes.getBcmDiversTiers());
         var1.setBlvDiversVille(this.commandeEnteteVentes.getBcmDiversVille());
         var1.setBlvExoTva(this.commandeEnteteVentes.getBcmExoTva());
         var1.setBlvExoDouane(this.commandeEnteteVentes.getBcmExoDouane());
         var1.setBlvJournalReg(this.commandeEnteteVentes.getBcmJournalReg());
         var1.setBlvCat(this.commandeEnteteVentes.getBcmCat());
         var1.setBlvDevise(this.commandeEnteteVentes.getBcmDevise());
         var1.setBlvObject(this.commandeEnteteVentes.getBcmObject());
         var1.setBlvObservation(this.commandeEnteteVentes.getBcmObservation());
         var1.setBlvTauxRemise(this.commandeEnteteVentes.getBcmTauxRemise());
         var1.setBlvTotHt(0.0D);
         var1.setBlvTotRemise(0.0D);
         var1.setBlvTotRabais(0.0D);
         var1.setBlvTotTva(0.0D);
         var1.setBlvTotTc(0.0D);
         var1.setBlvTotTtc(0.0D);
         var1.setBlvTotReglement(0.0D);
         var1.setBlvSolde(0);
         if (this.optionsVentes.getGestionStockBc().equals("1")) {
            var1.setBlvStock(1);
         } else {
            var1.setBlvStock(0);
         }

         if (this.optionsVentes.getGestionLivreur().equals("1")) {
            var1.setBlvLivreur(1);
         } else {
            var1.setBlvLivreur(0);
         }

         var1.setBlvBanque(this.commandeEnteteVentes.getBcmBanque());
         var1.setBlvTypeReg(this.commandeEnteteVentes.getBcmTypeReg());
         var1.setBlvModeReg(this.commandeEnteteVentes.getBcmModeReg());
         var1.setBlvNbJourReg(this.commandeEnteteVentes.getBcmNbJourReg());
         var1.setBlvArrondiReg(this.commandeEnteteVentes.getBcmArrondiReg());
         var1.setBlvConditionReg(this.commandeEnteteVentes.getBcmConditionReg());
         var1.setBlvDateEcheReg(this.commandeEnteteVentes.getBcmDateEcheReg());
         var1.setBlvContener(this.commandeEnteteVentes.getBcmContener());
         var1.setBlvActivite(this.commandeEnteteVentes.getBcmActivite());
         var1.setBlvSite(this.commandeEnteteVentes.getBcmSite());
         var1.setBlvDepartement(this.commandeEnteteVentes.getBcmDepartement());
         var1.setBlvRegion(this.commandeEnteteVentes.getBcmRegion());
         var1.setBlvSecteur(this.commandeEnteteVentes.getBcmSecteur());
         var1.setBlvPdv(this.commandeEnteteVentes.getBcmPdv());
         var1.setBlvAnal2(this.commandeEnteteVentes.getBcmAnal2());
         var1.setBlvAnal4(this.commandeEnteteVentes.getBcmAnal4());
         var1.setBlvAffaire(this.commandeEnteteVentes.getBcmAffaire());
         var1.setBlvInfo1(this.commandeEnteteVentes.getBcmInfo1());
         var1.setBlvInfo2(this.commandeEnteteVentes.getBcmInfo2());
         var1.setBlvInfo3(this.commandeEnteteVentes.getBcmInfo3());
         var1.setBlvInfo4(this.commandeEnteteVentes.getBcmInfo4());
         var1.setBlvInfo5(this.commandeEnteteVentes.getBcmInfo5());
         var1.setBlvInfo6(this.commandeEnteteVentes.getBcmInfo6());
         var1.setBlvInfo7(this.commandeEnteteVentes.getBcmInfo7());
         var1.setBlvInfo8(this.commandeEnteteVentes.getBcmInfo8());
         var1.setBlvInfo9(this.commandeEnteteVentes.getBcmInfo9());
         var1.setBlvInfo10(this.commandeEnteteVentes.getBcmInfo10());
         var1.setBlvFormule1(this.commandeEnteteVentes.getBcmFormule1());
         var1.setBlvFormule2(this.commandeEnteteVentes.getBcmFormule2());
         var1.setBlvAnnexe1(this.commandeEnteteVentes.getBcmAnnexe1());
         var1.setBlvAnnexe2(this.commandeEnteteVentes.getBcmAnnexe2());
         var1.setBlvContrat(this.commandeEnteteVentes.getBcmContrat());
         var1.setBlvIncoterm(this.commandeEnteteVentes.getBcmIncoterm());
         var1.setBlvLieuLivraison(this.commandeEnteteVentes.getBcmLieuLivraison());
         var1.setBlvDateLivraison(this.commandeEnteteVentes.getBcmDateLivraison());
         var1.setBlvInfoLivraison(this.commandeEnteteVentes.getBcmInfoLivraison());
         var1.setBlvDateImp((Date)null);
         var1.setBlvModeleImp(this.var_modele_trf);
         var1.setBlvGarde(this.commandeEnteteVentes.getBcmGarde());
         var1.setBlvRistourneBloquee(this.commandeEnteteVentes.isBcmRistourneBloquee());
         var1.setBlvNumClient(this.commandeEnteteVentes.getBcmNumClient());
         var1.setBlvDateClient(this.commandeEnteteVentes.getBcmDateClient());
         var1.setBlvGele(0);
         if (var60 != null) {
            var1.setBlvEtatVal(1);
            var1.setBlvEtat(0);
            var1.setBlvDateValide((Date)null);
         } else {
            var1.setBlvEtatVal(0);
            if (var1.getBlvDateImp() != null) {
               if (var1.getBlvEtat() == 0) {
                  var1.setBlvEtat(1);
                  var1.setBlvDateValide(new Date());
               }
            } else {
               var1.setBlvEtat(0);
               var1.setBlvDateValide((Date)null);
            }
         }

         var1.setBlvDateTransforme((Date)null);
         var1.setBlvTypeTransforme(0);
         var1.setBlvDateAnnule((Date)null);
         var1.setBlvMotifAnnule("");
         var1.setBlvFactorNom(this.commandeEnteteVentes.getBcmFactorNom());
         var1.setBlvFactorId(this.commandeEnteteVentes.getBcmFactorId());
         var1.setBlvFactorEtat(this.commandeEnteteVentes.getBcmFactorEtat());
         var1.setExerciceventes(this.exercicesVentes);
         var1.setTiers(this.commandeEnteteVentes.getTiers());
         var1.setUsers(this.usersLog);
         var1 = var3.insert(var1, var2);
         float var10 = 0.0F;
         float var11 = 0.0F;
         float var12 = 0.0F;
         var13 = 0.0D;
         var15 = 0.0D;
         var17 = 0.0D;
         var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         String var25 = "";
         int var26 = 0;
         if (this.lesLignesList.size() != 0) {
            int var27 = 0;

            while(true) {
               if (var27 >= this.lesLignesList.size()) {
                  var1.setBlvTotHt(var13);
                  var1.setBlvTotRemise(var15);
                  var1.setBlvTotRabais(var17);
                  var1.setBlvTotTva(var19);
                  var1.setBlvTotTc(var23);
                  var1.setBlvTotTtc(var21);
                  var1 = var3.modif(var1, var2);
                  if (var6.size() != 0) {
                     var4.saveLigne(var6, var1, var2);
                     this.calculStock.trfCmdLivraisonVenteATT(var6, this.baseLog, var2);
                  }
                  break;
               }

               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var27);
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var25 == null || var25.isEmpty() || !var25.equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum())) {
                        var25 = this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum();
                        ++var26;
                        LivraisonLigneVentes var69 = new LivraisonLigneVentes();
                        var69.setBlvligCode("-");
                        var69.setBlvligLibelle("---> Suivant commande N° " + var25);
                        var69.setLivraisonEnteteVentes(var1);
                        var6.add(var69);
                     }
                  } else if (var27 == 0) {
                     var25 = "";
                     String var28 = "";
                     int var29 = 0;

                     while(true) {
                        if (var29 >= this.lesLignesList.size()) {
                           ++var26;
                           LivraisonLigneVentes var71 = new LivraisonLigneVentes();
                           var71.setBlvligCode("-");
                           var71.setBlvligLibelle("---> Suivant commande N° " + var28);
                           var71.setLivraisonEnteteVentes(var1);
                           var6.add(var71);
                           break;
                        }

                        if (var25 == null || var25.isEmpty() || !var25.equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum())) {
                           var25 = this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum();
                           if (var28 != null && !var28.isEmpty()) {
                              var28 = var28 + "," + var25;
                           } else {
                              var28 = var25;
                           }
                        }

                        ++var29;
                     }
                  }
               }

               if (this.commandeLigneVentes.getBcmligLibelle() != null && !this.commandeLigneVentes.getBcmligLibelle().isEmpty() || this.commandeLigneVentes.getBcmligComplement() != null && !this.commandeLigneVentes.getBcmligComplement().isEmpty()) {
                  if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var2);
                     if (this.produits != null && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.commandeLigneVentes.getBcmligCode(), this.commandeLigneVentes.getBcmligDepot(), var2);
                     }
                  }

                  float var70 = this.commandeLigneVentes.getBcmligQte();
                  float var72 = this.commandeLigneVentes.getBcmligQteUtil();
                  double var30 = this.commandeLigneVentes.getBcmligPu();
                  double var32 = this.commandeLigneVentes.getBcmligPuRem();
                  double var34 = this.commandeLigneVentes.getBcmligPuRemTtc();
                  double var36 = this.commandeLigneVentes.getBcmligPuTtc();
                  double var38 = this.commandeLigneVentes.getBcmligPt();
                  double var40 = this.commandeLigneVentes.getBcmligTc();
                  double var42 = this.commandeLigneVentes.getBcmligTtc();
                  double var44 = this.commandeLigneVentes.getBcmligTva();
                  ++var26;
                  LivraisonLigneVentes var46 = new LivraisonLigneVentes();
                  var10 += this.commandeLigneVentes.getBcmligQte();
                  var11 += this.commandeLigneVentes.getVar_qteDejaTrf();
                  if (((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat() != 0.0F) {
                     var46.setBlvligOrdre(var26);
                     var46.setBlvligCode(this.commandeLigneVentes.getBcmligCode());
                     var46.setBlvligProcess(this.commandeLigneVentes.getBcmligProcess());
                     var46.setBlvligGroupe(this.commandeLigneVentes.getBcmligGroupe());
                     var46.setBlvligModeGroupe(this.commandeLigneVentes.getBcmligModeGroupe());
                     var46.setBlvligDevise(this.commandeLigneVentes.getBcmligDevise());
                     var46.setBlvligFamille(this.commandeLigneVentes.getBcmligFamille());
                     var46.setBlvligIdBcm(this.commandeLigneVentes.getBcmligId());
                     var46.setBlvligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                     var46.setBlvligComplement(this.commandeLigneVentes.getBcmligComplement());
                     var46.setBlvligDepotCmd(this.commandeLigneVentes.getBcmligDepot());
                     if (((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne() != null && !((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().isEmpty() && ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().contains("=")) {
                        String[] var73 = ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().split("=");
                        var46.setBlvligDepot(var73[0]);
                     } else {
                        var46.setBlvligDepot("");
                     }

                     var46.setBlvligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                     var46.setBlvligUnite(this.commandeLigneVentes.getBcmligUnite());
                     var46.setBlvligCondition(this.commandeLigneVentes.getBcmligCondition());
                     var46.setBlvligStock(this.commandeLigneVentes.getBcmligStock());
                     var46.setBlvligEntStock(var1.getBlvStock());
                     var46.setBlvligReference(this.commandeLigneVentes.getBcmligReference());
                     var46.setBlvligPump(this.commandeLigneVentes.getBcmligPump());
                     var46.setBlvligPu(this.commandeLigneVentes.getBcmligPu());
                     var46.setBlvligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                     var46.setBlvligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                     var46.setBlvligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                     var46.setBlvligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                     this.commandeLigneVentes.setBcmligQte(((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat());
                     this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
                     var46.setBlvligQte(((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat());
                     var46.setBlvligLong(this.commandeLigneVentes.getBcmligLong());
                     var46.setBlvligLarg(this.commandeLigneVentes.getBcmligLarg());
                     var46.setBlvligHaut(this.commandeLigneVentes.getBcmligHaut());
                     var46.setBlvligDiam(this.commandeLigneVentes.getBcmligDiam());
                     var46.setBlvligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                     var46.setBlvligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                     var46.setBlvligVolume(this.commandeLigneVentes.getBcmligVolume());
                     var46.setBlvligNb(this.commandeLigneVentes.getBcmligNb());
                     var46.setBlvligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.commandeLigneVentes.getBcmligCondition(), this.commandeLigneVentes.getBcmligQte(), this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, this.utilInitHibernate, var2));
                     if (this.optionsVentes.getGestionLivreur().equals("1")) {
                        var46.setBlvligQteStock(0.0F);
                        var46.setBlvligQteUtilStock(0.0F);
                     } else {
                        var46.setBlvligQteStock(var46.getBlvligQte());
                        var46.setBlvligQteUtilStock(var46.getBlvligQteUtil());
                     }

                     var46.setBlvligRabais(this.commandeLigneVentes.getBcmligRabais());
                     var46.setBlvligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                     var46.setBlvligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                     var46.setBlvligPt(this.commandeLigneVentes.getBcmligPt());
                     var46.setBlvligTva(this.commandeLigneVentes.getBcmligTva());
                     var46.setBlvligTtc(this.commandeLigneVentes.getBcmligTtc());
                     var46.setBlvligTc(this.commandeLigneVentes.getBcmligTc());
                     var46.setLivraisonEnteteVentes(var1);
                     var12 += ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat();
                     var6.add(var46);
                     var13 += var46.getBlvligPt();
                     var15 += (var46.getBlvligPu() - var46.getBlvligPuRem()) * (double)var46.getBlvligQte();
                     var17 += var46.getBlvligRabais();
                     var19 += var46.getBlvligTva();
                     var21 += var46.getBlvligTtc();
                     var23 += var46.getBlvligTc();
                     this.commandeLigneVentes.setBcmligQte(var70);
                     this.commandeLigneVentes.setBcmligQteUtil(var72);
                     this.commandeLigneVentes.setBcmligPu(var30);
                     this.commandeLigneVentes.setBcmligPuRem(var32);
                     this.commandeLigneVentes.setBcmligPuRemTtc(var34);
                     this.commandeLigneVentes.setBcmligPuTtc(var36);
                     this.commandeLigneVentes.setBcmligPt(var38);
                     this.commandeLigneVentes.setBcmligTc(var40);
                     this.commandeLigneVentes.setBcmligTtc(var42);
                     this.commandeLigneVentes.setBcmligTva(var44);
                  } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                     if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                        new ProcessEnteteAchats();
                        ProcessEnteteAchatsDao var48 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                        ProcessEnteteAchats var47 = var48.rechercheProcess(this.commandeLigneVentes.getBcmligCode(), var2);
                        if (var47 != null) {
                           ++var26;
                           var46 = new LivraisonLigneVentes();
                           var46.setBlvligOrdre(var26);
                           var46.setBlvligCode(var47.getProcesCode());
                           var46.setBlvligProcess(1);
                           var46.setBlvligGroupe(this.commandeLigneVentes.getBcmligGroupe());
                           var46.setBlvligModeGroupe(this.commandeLigneVentes.getBcmligModeGroupe());
                           var46.setBlvligDevise(this.commandeLigneVentes.getBcmligDevise());
                           var46.setBlvligFamille(this.commandeLigneVentes.getBcmligFamille());
                           var46.setBlvligIdDvs(this.commandeLigneVentes.getBcmligId());
                           var46.setBlvligLibelle(var47.getProcesLibClient());
                           var46.setBlvligComplement(this.commandeLigneVentes.getBcmligComplement());
                           var46.setBlvligDepot(var47.getProcesDepot());
                           var46.setBlvligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                           var46.setBlvligUnite(this.commandeLigneVentes.getBcmligUnite());
                           var46.setBlvligCondition(this.commandeLigneVentes.getBcmligCondition());
                           var46.setBlvligStock(this.commandeLigneVentes.getBcmligStock());
                           var46.setBlvligReference(this.commandeLigneVentes.getBcmligReference());
                           var46.setBlvligPump(var47.getProcesTotPump());
                           var46.setBlvligPu(this.commandeLigneVentes.getBcmligPu());
                           var46.setBlvligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                           var46.setBlvligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                           var46.setBlvligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                           var46.setBlvligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                           var46.setBlvligQte(0.0F);
                           var46.setBlvligLong(this.commandeLigneVentes.getBcmligLong());
                           var46.setBlvligLarg(this.commandeLigneVentes.getBcmligLarg());
                           var46.setBlvligHaut(this.commandeLigneVentes.getBcmligHaut());
                           var46.setBlvligDiam(this.commandeLigneVentes.getBcmligDiam());
                           var46.setBlvligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                           var46.setBlvligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                           var46.setBlvligVolume(this.commandeLigneVentes.getBcmligVolume());
                           var46.setBlvligNb(this.commandeLigneVentes.getBcmligNb());
                           var46.setBlvligQteUtil(0.0F);
                           var46.setBlvligQteStock(0.0F);
                           var46.setBlvligRabais(this.commandeLigneVentes.getBcmligRabais());
                           var46.setBlvligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                           var46.setBlvligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                           var46.setBlvligPt(this.commandeLigneVentes.getBcmligPt());
                           var46.setBlvligTva(this.commandeLigneVentes.getBcmligTva());
                           var46.setBlvligTtc(this.commandeLigneVentes.getBcmligTtc());
                           var46.setBlvligTc(this.commandeLigneVentes.getBcmligTc());
                           var46.setLivraisonEnteteVentes(var1);
                           var6.add(var46);
                        } else {
                           ++var26;
                           var46 = new LivraisonLigneVentes();
                           var46.setBlvligOrdre(var26);
                           var46.setBlvligCode(this.commandeLigneVentes.getBcmligCode());
                           var46.setBlvligProcess(this.commandeLigneVentes.getBcmligProcess());
                           var46.setBlvligGroupe(this.commandeLigneVentes.getBcmligGroupe());
                           var46.setBlvligModeGroupe(this.commandeLigneVentes.getBcmligModeGroupe());
                           var46.setBlvligDevise(this.commandeLigneVentes.getBcmligDevise());
                           var46.setBlvligFamille(this.commandeLigneVentes.getBcmligFamille());
                           var46.setBlvligIdDvs(this.commandeLigneVentes.getBcmligId());
                           var46.setBlvligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                           var46.setBlvligComplement(this.commandeLigneVentes.getBcmligComplement());
                           if (this.commandeLigneVentes.getVar_depotLigne() != null && !((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().isEmpty() && ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().contains("=")) {
                              String[] var49 = ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().split("=");
                              var46.setBlvligDepot(var49[0]);
                           } else {
                              var46.setBlvligDepot("");
                           }

                           var46.setBlvligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                           var46.setBlvligUnite(this.commandeLigneVentes.getBcmligUnite());
                           var46.setBlvligCondition(this.commandeLigneVentes.getBcmligCondition());
                           var46.setBlvligStock(this.commandeLigneVentes.getBcmligStock());
                           var46.setBlvligReference(this.commandeLigneVentes.getBcmligReference());
                           var46.setBlvligPump(this.commandeLigneVentes.getBcmligPump());
                           var46.setBlvligPu(this.commandeLigneVentes.getBcmligPu());
                           var46.setBlvligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                           var46.setBlvligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                           var46.setBlvligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                           var46.setBlvligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                           this.commandeLigneVentes.setBcmligQte(0.0F);
                           this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
                           var46.setBlvligQte(0.0F);
                           var46.setBlvligLong(this.commandeLigneVentes.getBcmligLong());
                           var46.setBlvligLarg(this.commandeLigneVentes.getBcmligLarg());
                           var46.setBlvligHaut(this.commandeLigneVentes.getBcmligHaut());
                           var46.setBlvligDiam(this.commandeLigneVentes.getBcmligDiam());
                           var46.setBlvligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                           var46.setBlvligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                           var46.setBlvligVolume(this.commandeLigneVentes.getBcmligVolume());
                           var46.setBlvligNb(this.commandeLigneVentes.getBcmligNb());
                           var46.setBlvligQteUtil(0.0F);
                           var46.setBlvligQteStock(0.0F);
                           var46.setBlvligRabais(this.commandeLigneVentes.getBcmligRabais());
                           var46.setBlvligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                           var46.setBlvligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                           var46.setBlvligPt(this.commandeLigneVentes.getBcmligPt());
                           var46.setBlvligTva(this.commandeLigneVentes.getBcmligTva());
                           var46.setBlvligTtc(this.commandeLigneVentes.getBcmligTtc());
                           var46.setBlvligTc(this.commandeLigneVentes.getBcmligTc());
                           var46.setLivraisonEnteteVentes(var1);
                           var6.add(var46);
                        }
                     } else {
                        ++var26;
                        var46 = new LivraisonLigneVentes();
                        var46.setBlvligOrdre(var26);
                        var46.setBlvligCode("");
                        var46.setBlvligProcess(0);
                        var46.setBlvligGroupe("");
                        var46.setBlvligModeGroupe(0);
                        var46.setBlvligDevise(this.commandeLigneVentes.getBcmligDevise());
                        var46.setBlvligFamille("");
                        var46.setBlvligIdDvs(this.commandeLigneVentes.getBcmligId());
                        var46.setBlvligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                        var46.setBlvligComplement(this.commandeLigneVentes.getBcmligComplement());
                        var46.setBlvligDepot("");
                        var46.setBlvligEchelle(0);
                        var46.setBlvligUnite(this.commandeLigneVentes.getBcmligUnite());
                        var46.setBlvligCondition(this.commandeLigneVentes.getBcmligCondition());
                        var46.setBlvligStock(0);
                        var46.setBlvligReference(this.commandeLigneVentes.getBcmligReference());
                        var46.setBlvligPump(this.commandeLigneVentes.getBcmligPump());
                        var46.setBlvligPu(this.commandeLigneVentes.getBcmligPu());
                        var46.setBlvligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                        var46.setBlvligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                        var46.setBlvligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                        var46.setBlvligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                        this.commandeLigneVentes.setBcmligQte(0.0F);
                        this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
                        var46.setBlvligQte(0.0F);
                        var46.setBlvligLong(this.commandeLigneVentes.getBcmligLong());
                        var46.setBlvligLarg(this.commandeLigneVentes.getBcmligLarg());
                        var46.setBlvligHaut(this.commandeLigneVentes.getBcmligHaut());
                        var46.setBlvligDiam(this.commandeLigneVentes.getBcmligDiam());
                        var46.setBlvligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                        var46.setBlvligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                        var46.setBlvligVolume(this.commandeLigneVentes.getBcmligVolume());
                        var46.setBlvligNb(this.commandeLigneVentes.getBcmligNb());
                        var46.setBlvligQteUtil(0.0F);
                        var46.setBlvligQteStock(0.0F);
                        var46.setBlvligRabais(this.commandeLigneVentes.getBcmligRabais());
                        var46.setBlvligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                        var46.setBlvligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                        var46.setBlvligPt(this.commandeLigneVentes.getBcmligPt());
                        var46.setBlvligTva(this.commandeLigneVentes.getBcmligTva());
                        var46.setBlvligTtc(this.commandeLigneVentes.getBcmligTtc());
                        var46.setBlvligTc(this.commandeLigneVentes.getBcmligTc());
                        var46.setLivraisonEnteteVentes(var1);
                        var6.add(var46);
                     }
                  }
               }

               ++var27;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationBl(var1, var2), var1.getBlvId(), var1.getBlvNum(), var1.getBlvNomTiers(), var1.getBlvDate(), var1.getBlvDevise(), var1.getBlvTotTtc() + var1.getBlvTotTc(), var1.getBlvModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 23), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFBL(var6, var1), this.calculeParc(var2), var1.getVar_format_devise(), 0, var2);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(22);
         this.documentTraceVentes.setDoctraOrgSerie(this.commandeEnteteVentes.getBcmSerie());
         this.documentTraceVentes.setDoctraOrgId(this.commandeEnteteVentes.getBcmId());
         this.documentTraceVentes.setDoctraOrgNum(this.commandeEnteteVentes.getBcmNum());
         this.documentTraceVentes.setDoctraOrgDate(this.commandeEnteteVentes.getBcmDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var1.getBlvSerie());
         this.documentTraceVentes.setDoctraDstId(var1.getBlvId());
         this.documentTraceVentes.setDoctraDstNum(var1.getBlvNum());
         this.documentTraceVentes.setDoctraDstDate(var1.getBlvDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var2);
         this.documentTrace.add(this.documentTraceVentes);
         this.datamodelDocumentTrace.setWrappedData(this.documentTrace);
         if (var10 <= var11 + var12 && var10 != 0.0F && var11 + var12 != 0.0F) {
            this.commandeEnteteVentes.setBcmEtat(5);
         } else {
            this.commandeEnteteVentes.setBcmEtat(4);
         }

         this.commandeEnteteVentes.setBcmDateTransforme(new Date());
         this.commandeEnteteVentes.setBcmTypeTransforme(this.var_type_trf);
         this.commandeEnteteVentes.setBcmTotLivre(var13);
         this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var2);
         if (var1.getBlvEtat() == 0 && var60 == null && this.usersChrono.getUsrchrValidation() == 2) {
            if (this.optionsVentes.getValidationBcBlCOM().equals("1")) {
               var1.setBlvEtat(1);
               if (this.optionsVentes.getGestionLivreur().equals("0")) {
                  var1.setBlvLivreeEtat(2);
               }

               if (this.tiers.getTieDteDocument3() == null || var1.getBlvDate().after(this.tiers.getTieDteDocument3())) {
                  this.tiers.setTieDteDocument3(var1.getBlvDate());
                  this.tiers = this.tiersDao.modif(this.tiers, var2);
               }
            } else {
               var1.setBlvEtat(0);
            }

            var1 = var3.modif(var1, var2);
            if (this.optionsVentes.getValidationBcBlCOM().equals("1")) {
               this.calculStock.majLivraisonVentesVAL(var6, 1, this.baseLog, var2);
            }
         }

         if (this.optionsVentes.getAxeDossier().equals("2") && this.commandeEnteteVentes.getBcmAnal4() != null && !this.commandeEnteteVentes.getBcmAnal4().isEmpty()) {
            PlansAnalytiquesDao var68 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            this.plansAnalytiques = var68.rechercheAffaire(this.commandeEnteteVentes.getBcmAnal4(), var2);
            if (this.plansAnalytiques != null) {
               this.plansAnalytiques.setAnaAffaireDateLivree(this.commandeEnteteVentes.getBcmDate());
               this.plansAnalytiques = var68.modif(this.plansAnalytiques, var2);
            }
         }

         var5.commit();
      } catch (HibernateException var53) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var53;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      new ArrayList();
      List var55 = var4.chargerLesLignes(var1, (Session)null);
      if (var55.size() != 0) {
         var7 = false;
         new LivraisonLigneVentes();

         for(int var61 = 0; var61 < var55.size(); ++var61) {
            LivraisonLigneVentes var59 = (LivraisonLigneVentes)var55.get(var61);
            if (var59.getBlvligIdBcm() != 0L) {
               long var62 = var59.getBlvligId();
               long var65 = var59.getBlvligIdBcm();
               boolean var14 = false;

               for(int var66 = 0; var66 < var55.size(); ++var66) {
                  if (((LivraisonLigneVentes)var55.get(var66)).getBlvligId() != var62 && ((LivraisonLigneVentes)var55.get(var66)).getBlvligIdBcm() == var65) {
                     var4.deleteOneLigne(var59);
                     --var61;
                     var14 = true;
                     var7 = true;
                     break;
                  }
               }

               if (var14) {
                  var55.remove(var59);
               }
            }
         }

         if (var7) {
            double var63 = 0.0D;
            double var64 = 0.0D;
            var13 = 0.0D;
            var15 = 0.0D;
            var17 = 0.0D;
            var19 = 0.0D;
            new LivraisonLigneVentes();

            for(int var22 = 0; var22 < var55.size(); ++var22) {
               LivraisonLigneVentes var67 = (LivraisonLigneVentes)var55.get(var22);
               var63 += var67.getBlvligPt();
               var64 += (var67.getBlvligPu() - var67.getBlvligPuRem()) * (double)var67.getBlvligQte();
               var13 += var67.getBlvligRabais();
               var15 += var67.getBlvligTva();
               var17 += var67.getBlvligTtc();
               var19 += var67.getBlvligTc();
            }

            var1 = var3.pourParapheur(var1.getBlvId(), (Session)null);
            if (var1 != null) {
               var1.setBlvTotHt(var63);
               var1.setBlvTotRemise(var64);
               var1.setBlvTotRabais(var13);
               var1.setBlvTotTva(var15);
               var1.setBlvTotTc(var19);
               var1.setBlvTotTtc(var17);
               var1 = var3.modif(var1);
            }
         }
      }

      ArrayList var58 = new ArrayList();
      this.miseAJourReliquat(var58);
      this.calculReliquatSuite();
      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionTRFBL(List var1, LivraisonEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new LivraisonLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            LivraisonLigneVentes var4 = (LivraisonLigneVentes)var1.get(var11);
            if (var4.getBlvligModeGroupe() != 2 || var4.getBlvligGroupe() == null || var4.getBlvligGroupe().isEmpty()) {
               if (var4.getBlvligCode() != null && !var4.getBlvligCode().isEmpty() && var4.getBlvligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getBlvligLibelle();
               }

               if (var5) {
                  var7 += var4.getBlvligPt();
                  var9 = var4.getBlvligTtc();
               }

               if (var4.getBlvligCode() != null && !var4.getBlvligCode().isEmpty() && var4.getBlvligCode().equals("=") && var5) {
                  var4 = new LivraisonLigneVentes();
                  var4.setLivraisonEnteteVentes(var2);
                  var4.setBlvligCode("=");
                  var4.setBlvligLibelle(var6);
                  var4.setBlvligPt(var7);
                  var4.setBlvligTtc(var9);
                  var3.add(var4);
                  var7 = 0.0D;
                  var9 = 0.0D;
                  var5 = false;
               } else {
                  var3.add(var4);
               }
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getBlvTotTtc() + var2.getBlvTotTc(), var2.getBlvDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationBl(LivraisonEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setBlvEtatVal(1);
         var1.setBlvEtat(0);
         var1.setBlvDateValide((Date)null);
      } else {
         var1.setBlvEtatVal(0);
         if (var1.getBlvDateImp() != null) {
            if (var1.getBlvEtat() == 0) {
               var1.setBlvEtat(1);
               var1.setBlvDateValide(new Date());
            }
         } else {
            var1.setBlvEtat(0);
            var1.setBlvDateValide((Date)null);
         }
      }

      return var4;
   }

   public FactureEnteteVentes trfFac(FactureEnteteVentes var1) throws HibernateException, NamingException, Exception {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      FactureEnteteVentesDao var3 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      FactureLigneVentesDao var4 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      Transaction var5 = null;

      boolean var7;
      double var13;
      double var15;
      double var17;
      double var19;
      try {
         var5 = var2.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var1.setFacSerie(this.var_serie_trf);
         } else {
            var1.setFacSerie(this.commandeEnteteVentes.getBcmSerie());
         }

         var1.setUsers(this.usersLog);
         var1.setFacIdCreateur(this.usersLog.getUsrid());
         var1.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var1.setFacDate(this.utilDate.dateToSQLLight(this.commandeEnteteVentes.getBcmDate()));
         } else {
            var1.setFacDate(this.var_date_trf);
         }

         var1.setFacDate(this.utilDate.dateToSQL(this.commandeEnteteVentes.getBcmDate(), this.var_heure, this.var_minute, this.var_seconde));
         var1.setFacDateCreat(new Date());
         var1.setFacDateModif((Date)null);
         var1.setFacIdModif(0L);
         var1.setFacNomModif("");
         var1.setFacNum("");
         var7 = false;
         int var56;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var56 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var56 = 0;
         }

         boolean var8 = false;
         int var57;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var57 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var57 = 0;
         }

         var1.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var56));
         var1.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var57));
         var1.setFacService(this.commandeEnteteVentes.getBcmService());
         if (!var1.getFacSerie().equalsIgnoreCase("X") && !var1.getFacSerie().isEmpty()) {
            var1.setFacNum(this.calculChrono.numCompose(var1.getFacDate(), this.var_type_trf, var1.getFacSerie(), var2));
         } else {
            long var9 = var3.selectLastNum(var2);
            var1.setFacNum("" + var9);
         }

         new Habilitation();
         Habilitation var60 = this.verifieExistenceHabilitationFac(var1, var2);
         var1.setFacSource(this.commandeEnteteVentes.getBcmSource());
         var1.setFacNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
         var1.setFacIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
         var1.setFacNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
         var1.setFacIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
         var1.setFacNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
         var1.setFacIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
         var1.setFacNomTiers(this.commandeEnteteVentes.getBcmNomTiers());
         var1.setFacCivilTiers(this.commandeEnteteVentes.getBcmCivilTiers());
         var1.setFacTiersRegroupe(this.commandeEnteteVentes.getBcmTiersRegroupe());
         var1.setFacIdContact(this.commandeEnteteVentes.getBcmIdContact());
         var1.setFacNomContact(this.commandeEnteteVentes.getBcmNomContact());
         var1.setFacCivilContact(this.commandeEnteteVentes.getBcmCivilContact());
         var1.setFacDiversAdresse(this.commandeEnteteVentes.getBcmDiversAdresse());
         var1.setFacDiversMail(this.commandeEnteteVentes.getBcmDiversMail());
         var1.setFacDiversNom(this.commandeEnteteVentes.getBcmDiversNom());
         var1.setFacDiversTel(this.commandeEnteteVentes.getBcmDiversTel());
         var1.setFacDiversTiers(this.commandeEnteteVentes.getBcmDiversTiers());
         var1.setFacDiversVille(this.commandeEnteteVentes.getBcmDiversVille());
         var1.setFacExoTva(this.commandeEnteteVentes.getBcmExoTva());
         var1.setFacExoDouane(this.commandeEnteteVentes.getBcmExoDouane());
         var1.setFacJournalReg(this.commandeEnteteVentes.getBcmJournalReg());
         var1.setFacCat(this.commandeEnteteVentes.getBcmCat());
         var1.setFacDevise(this.commandeEnteteVentes.getBcmDevise());
         var1.setFacObject(this.commandeEnteteVentes.getBcmObject());
         var1.setFacObservation(this.commandeEnteteVentes.getBcmObservation());
         var1.setFacTauxRemise(this.commandeEnteteVentes.getBcmTauxRemise());
         var1.setFacTotHt(0.0D);
         var1.setFacTotRemise(0.0D);
         var1.setFacTotRabais(0.0D);
         var1.setFacTotTva(0.0D);
         var1.setFacTotTc(0.0D);
         var1.setFacTotTtc(0.0D);
         var1.setFacTotReglement(0.0D);
         var1.setFacSolde(0);
         var1.setFacStock(1);
         var1.setFacBanque(this.commandeEnteteVentes.getBcmBanque());
         var1.setFacTypeReg(this.commandeEnteteVentes.getBcmTypeReg());
         var1.setFacModeReg(this.commandeEnteteVentes.getBcmModeReg());
         var1.setFacNbJourReg(this.commandeEnteteVentes.getBcmNbJourReg());
         var1.setFacArrondiReg(this.commandeEnteteVentes.getBcmArrondiReg());
         var1.setFacConditionReg(this.commandeEnteteVentes.getBcmConditionReg());
         var1.setFacDateEcheReg(this.commandeEnteteVentes.getBcmDateEcheReg());
         var1.setFacContener(this.commandeEnteteVentes.getBcmContener());
         var1.setFacActivite(this.commandeEnteteVentes.getBcmActivite());
         var1.setFacSite(this.commandeEnteteVentes.getBcmSite());
         var1.setFacDepartement(this.commandeEnteteVentes.getBcmDepartement());
         var1.setFacRegion(this.commandeEnteteVentes.getBcmRegion());
         var1.setFacSecteur(this.commandeEnteteVentes.getBcmSecteur());
         var1.setFacPdv(this.commandeEnteteVentes.getBcmPdv());
         var1.setFacAnal2(this.commandeEnteteVentes.getBcmAnal2());
         var1.setFacAnal4(this.commandeEnteteVentes.getBcmAnal4());
         var1.setFacAffaire(this.commandeEnteteVentes.getBcmAffaire());
         var1.setFacInfo1(this.commandeEnteteVentes.getBcmInfo1());
         var1.setFacInfo2(this.commandeEnteteVentes.getBcmInfo2());
         var1.setFacInfo3(this.commandeEnteteVentes.getBcmInfo3());
         var1.setFacInfo4(this.commandeEnteteVentes.getBcmInfo4());
         var1.setFacInfo5(this.commandeEnteteVentes.getBcmInfo5());
         var1.setFacInfo6(this.commandeEnteteVentes.getBcmInfo6());
         var1.setFacInfo7(this.commandeEnteteVentes.getBcmInfo7());
         var1.setFacInfo8(this.commandeEnteteVentes.getBcmInfo8());
         var1.setFacInfo9(this.commandeEnteteVentes.getBcmInfo9());
         var1.setFacInfo10(this.commandeEnteteVentes.getBcmInfo10());
         var1.setFacFormule1(this.commandeEnteteVentes.getBcmFormule1());
         var1.setFacFormule2(this.commandeEnteteVentes.getBcmFormule2());
         var1.setFacAnnexe1(this.commandeEnteteVentes.getBcmAnnexe1());
         var1.setFacAnnexe2(this.commandeEnteteVentes.getBcmAnnexe2());
         var1.setFacContrat(this.commandeEnteteVentes.getBcmContrat());
         var1.setFacIncoterm(this.commandeEnteteVentes.getBcmIncoterm());
         var1.setFacLieuLivraison(this.commandeEnteteVentes.getBcmLieuLivraison());
         var1.setFacDateLivraison(this.commandeEnteteVentes.getBcmDateLivraison());
         var1.setFacInfoLivraison(this.commandeEnteteVentes.getBcmInfoLivraison());
         var1.setFacDateImp((Date)null);
         var1.setFacModeleImp(this.var_modele_trf);
         var1.setFacGarde(this.commandeEnteteVentes.getBcmGarde());
         var1.setFacRistourneBloquee(this.commandeEnteteVentes.isBcmRistourneBloquee());
         var1.setFacNumClient(this.commandeEnteteVentes.getBcmNumClient());
         var1.setFacDateClient(this.commandeEnteteVentes.getBcmDateClient());
         var1.setFacGele(0);
         if (var60 != null) {
            var1.setFacEtatVal(1);
            var1.setFacEtat(0);
            var1.setFacDateValide((Date)null);
         } else {
            var1.setFacEtatVal(0);
            if (var1.getFacDateImp() != null) {
               if (var1.getFacEtat() == 0) {
                  var1.setFacEtat(1);
                  var1.setFacDateValide(new Date());
               }
            } else {
               var1.setFacEtat(0);
               var1.setFacDateValide((Date)null);
            }
         }

         var1.setFacDateTransforme((Date)null);
         var1.setFacTypeTransforme(0);
         var1.setFacDateAnnule((Date)null);
         var1.setFacMotifAnnule("");
         var1.setFacFactorNom(this.commandeEnteteVentes.getBcmFactorNom());
         var1.setFacFactorId(this.commandeEnteteVentes.getBcmFactorId());
         var1.setFacFactorEtat(this.commandeEnteteVentes.getBcmFactorEtat());
         var1.setExerciceventes(this.exercicesVentes);
         var1.setTiers(this.commandeEnteteVentes.getTiers());
         var1.setUsers(this.usersLog);
         var1 = var3.insert(var1, var2);
         float var10 = 0.0F;
         float var11 = 0.0F;
         float var12 = 0.0F;
         var13 = 0.0D;
         var15 = 0.0D;
         var17 = 0.0D;
         var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         String var25 = "";
         int var26 = 0;
         if (this.lesLignesList.size() != 0) {
            for(int var27 = 0; var27 < this.lesLignesList.size(); ++var27) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var27);
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var25 == null || var25.isEmpty() || !var25.equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum())) {
                        var25 = this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum();
                        ++var26;
                        FactureLigneVentes var68 = new FactureLigneVentes();
                        var68.setFacligCode("-");
                        var68.setFacligLibelle("---> Suivant commande N° " + var25);
                        var68.setFactureEnteteVentes(var1);
                        var6.add(var68);
                     }
                  } else if (var27 == 0) {
                     var25 = "";
                     String var28 = "";
                     int var29 = 0;

                     while(true) {
                        if (var29 >= this.lesLignesList.size()) {
                           ++var26;
                           FactureLigneVentes var70 = new FactureLigneVentes();
                           var70.setFacligCode("-");
                           var70.setFacligLibelle("---> Suivant commande N° " + var28);
                           var70.setFactureEnteteVentes(var1);
                           var6.add(var70);
                           break;
                        }

                        if (var25 == null || var25.isEmpty() || !var25.equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum())) {
                           var25 = this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum();
                           if (var28 != null && !var28.isEmpty()) {
                              var28 = var28 + "," + var25;
                           } else {
                              var28 = var25;
                           }
                        }

                        ++var29;
                     }
                  }
               }

               if (this.commandeLigneVentes.getBcmligLibelle() != null && !this.commandeLigneVentes.getBcmligLibelle().isEmpty() || this.commandeLigneVentes.getBcmligComplement() != null && !this.commandeLigneVentes.getBcmligComplement().isEmpty()) {
                  if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var2);
                     if (this.produits != null && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.commandeLigneVentes.getBcmligCode(), this.commandeLigneVentes.getBcmligDepot(), var2);
                     }
                  }

                  float var69 = this.commandeLigneVentes.getBcmligQte();
                  float var71 = this.commandeLigneVentes.getBcmligQteUtil();
                  double var30 = this.commandeLigneVentes.getBcmligPu();
                  double var32 = this.commandeLigneVentes.getBcmligPuRem();
                  double var34 = this.commandeLigneVentes.getBcmligPuRemTtc();
                  double var36 = this.commandeLigneVentes.getBcmligPuTtc();
                  double var38 = this.commandeLigneVentes.getBcmligPt();
                  double var40 = this.commandeLigneVentes.getBcmligTc();
                  double var42 = this.commandeLigneVentes.getBcmligTtc();
                  double var44 = this.commandeLigneVentes.getBcmligTva();
                  ++var26;
                  FactureLigneVentes var46 = new FactureLigneVentes();
                  var10 += this.commandeLigneVentes.getBcmligQte();
                  var11 += this.commandeLigneVentes.getVar_qteDejaTrf();
                  if (((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat() != 0.0F) {
                     var46.setFacligOrdre(var26);
                     var46.setFacligCode(this.commandeLigneVentes.getBcmligCode());
                     var46.setFacligGroupe(this.commandeLigneVentes.getBcmligGroupe());
                     var46.setFacligModeGroupe(this.commandeLigneVentes.getBcmligModeGroupe());
                     var46.setFacligDevise(this.commandeLigneVentes.getBcmligDevise());
                     var46.setFacligFamille(this.commandeLigneVentes.getBcmligFamille());
                     var46.setFacligIdBcm(this.commandeLigneVentes.getBcmligId());
                     var46.setFacligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                     var46.setFacligComplement(this.commandeLigneVentes.getBcmligComplement());
                     var46.setFacligDepot(this.commandeLigneVentes.getBcmligDepot());
                     if (((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne() != null && !((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().isEmpty() && ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().contains("=")) {
                        String[] var72 = ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().split("=");
                        var46.setFacligDepot(var72[0]);
                     } else {
                        var46.setFacligDepot("");
                     }

                     var46.setFacligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                     var46.setFacligUnite(this.commandeLigneVentes.getBcmligUnite());
                     var46.setFacligCondition(this.commandeLigneVentes.getBcmligCondition());
                     var46.setFacligStock(this.commandeLigneVentes.getBcmligStock());
                     var46.setFacligEntStock(var1.getFacStock());
                     var46.setFacligReference(this.commandeLigneVentes.getBcmligReference());
                     var46.setFacligPump(this.commandeLigneVentes.getBcmligPump());
                     var46.setFacligPu(this.commandeLigneVentes.getBcmligPu());
                     var46.setFacligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                     var46.setFacligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                     var46.setFacligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                     var46.setFacligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                     this.commandeLigneVentes.setBcmligQte(((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat());
                     this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
                     var46.setFacligQte(((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat());
                     var46.setFacligLong(this.commandeLigneVentes.getBcmligLong());
                     var46.setFacligLarg(this.commandeLigneVentes.getBcmligLarg());
                     var46.setFacligHaut(this.commandeLigneVentes.getBcmligHaut());
                     var46.setFacligDiam(this.commandeLigneVentes.getBcmligDiam());
                     var46.setFacligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                     var46.setFacligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                     var46.setFacligVolume(this.commandeLigneVentes.getBcmligVolume());
                     var46.setFacligNb(this.commandeLigneVentes.getBcmligNb());
                     var46.setFacligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.commandeLigneVentes.getBcmligCondition(), this.commandeLigneVentes.getBcmligQte(), this.commandeLigneVentes.getBcmligLong(), this.commandeLigneVentes.getBcmligLarg(), this.commandeLigneVentes.getBcmligHaut(), this.commandeLigneVentes.getBcmligDiam(), this.commandeLigneVentes.getBcmligNb(), this.baseLog, this.utilInitHibernate, var2));
                     if (this.optionsVentes.getGestionLivreur().equals("1")) {
                        var46.setFacligQteStock(0.0F);
                     } else {
                        var46.setFacligQteStock(var46.getFacligQte());
                     }

                     var46.setFacligRabais(this.commandeLigneVentes.getBcmligRabais());
                     var46.setFacligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                     var46.setFacligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                     var46.setFacligPt(this.commandeLigneVentes.getBcmligPt());
                     var46.setFacligTva(this.commandeLigneVentes.getBcmligTva());
                     var46.setFacligTtc(this.commandeLigneVentes.getBcmligTtc());
                     var46.setFacligTc(this.commandeLigneVentes.getBcmligTc());
                     var46.setFactureEnteteVentes(var1);
                     var12 += ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_qteReliquat();
                     var6.add(var46);
                     var13 += var46.getFacligPt();
                     var15 += (var46.getFacligPu() - var46.getFacligPuRem()) * (double)var46.getFacligQte();
                     var17 += var46.getFacligRabais();
                     var19 += var46.getFacligTva();
                     var21 += var46.getFacligTtc();
                     var23 += var46.getFacligTc();
                     this.commandeLigneVentes.setBcmligQte(var69);
                     this.commandeLigneVentes.setBcmligQteUtil(var71);
                     this.commandeLigneVentes.setBcmligPu(var30);
                     this.commandeLigneVentes.setBcmligPuRem(var32);
                     this.commandeLigneVentes.setBcmligPuRemTtc(var34);
                     this.commandeLigneVentes.setBcmligPuTtc(var36);
                     this.commandeLigneVentes.setBcmligPt(var38);
                     this.commandeLigneVentes.setBcmligTc(var40);
                     this.commandeLigneVentes.setBcmligTtc(var42);
                     this.commandeLigneVentes.setBcmligTva(var44);
                  } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                     if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                        new ProcessEnteteAchats();
                        ProcessEnteteAchatsDao var48 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                        ProcessEnteteAchats var47 = var48.rechercheProcess(this.commandeLigneVentes.getBcmligCode(), var2);
                        if (var47 != null) {
                           ++var26;
                           var46 = new FactureLigneVentes();
                           var46.setFacligOrdre(var26);
                           var46.setFacligCode(var47.getProcesCode());
                           var46.setFacligGroupe(this.commandeLigneVentes.getBcmligGroupe());
                           var46.setFacligModeGroupe(this.commandeLigneVentes.getBcmligModeGroupe());
                           var46.setFacligDevise(this.commandeLigneVentes.getBcmligDevise());
                           var46.setFacligFamille(this.commandeLigneVentes.getBcmligFamille());
                           var46.setFacligIdDvs(this.commandeLigneVentes.getBcmligId());
                           var46.setFacligLibelle(var47.getProcesLibClient());
                           var46.setFacligComplement(this.commandeLigneVentes.getBcmligComplement());
                           var46.setFacligDepot(var47.getProcesDepot());
                           var46.setFacligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                           var46.setFacligUnite(this.commandeLigneVentes.getBcmligUnite());
                           var46.setFacligCondition(this.commandeLigneVentes.getBcmligCondition());
                           var46.setFacligStock(this.commandeLigneVentes.getBcmligStock());
                           var46.setFacligReference(this.commandeLigneVentes.getBcmligReference());
                           var46.setFacligPump(var47.getProcesTotPump());
                           var46.setFacligPu(this.commandeLigneVentes.getBcmligPu());
                           var46.setFacligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                           var46.setFacligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                           var46.setFacligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                           var46.setFacligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                           var46.setFacligQte(0.0F);
                           var46.setFacligLong(this.commandeLigneVentes.getBcmligLong());
                           var46.setFacligLarg(this.commandeLigneVentes.getBcmligLarg());
                           var46.setFacligHaut(this.commandeLigneVentes.getBcmligHaut());
                           var46.setFacligDiam(this.commandeLigneVentes.getBcmligDiam());
                           var46.setFacligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                           var46.setFacligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                           var46.setFacligVolume(this.commandeLigneVentes.getBcmligVolume());
                           var46.setFacligNb(this.commandeLigneVentes.getBcmligNb());
                           var46.setFacligQteUtil(0.0F);
                           var46.setFacligQteStock(0.0F);
                           var46.setFacligRabais(this.commandeLigneVentes.getBcmligRabais());
                           var46.setFacligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                           var46.setFacligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                           var46.setFacligPt(this.commandeLigneVentes.getBcmligPt());
                           var46.setFacligTva(this.commandeLigneVentes.getBcmligTva());
                           var46.setFacligTtc(this.commandeLigneVentes.getBcmligTtc());
                           var46.setFacligTc(this.commandeLigneVentes.getBcmligTc());
                           var46.setFactureEnteteVentes(var1);
                           var6.add(var46);
                        } else {
                           ++var26;
                           var46 = new FactureLigneVentes();
                           var46.setFacligOrdre(var26);
                           var46.setFacligCode(this.commandeLigneVentes.getBcmligCode());
                           var46.setFacligGroupe(this.commandeLigneVentes.getBcmligGroupe());
                           var46.setFacligModeGroupe(this.commandeLigneVentes.getBcmligModeGroupe());
                           var46.setFacligDevise(this.commandeLigneVentes.getBcmligDevise());
                           var46.setFacligFamille(this.commandeLigneVentes.getBcmligFamille());
                           var46.setFacligIdDvs(this.commandeLigneVentes.getBcmligId());
                           var46.setFacligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                           var46.setFacligComplement(this.commandeLigneVentes.getBcmligComplement());
                           if (this.commandeLigneVentes.getVar_depotLigne() != null && !((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().isEmpty() && ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().contains("=")) {
                              String[] var49 = ((CommandeLigneVentes)this.lesLignesList.get(var27)).getVar_depotLigne().split("=");
                              var46.setFacligDepot(var49[0]);
                           } else {
                              var46.setFacligDepot("");
                           }

                           var46.setFacligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                           var46.setFacligUnite(this.commandeLigneVentes.getBcmligUnite());
                           var46.setFacligCondition(this.commandeLigneVentes.getBcmligCondition());
                           var46.setFacligStock(this.commandeLigneVentes.getBcmligStock());
                           var46.setFacligReference(this.commandeLigneVentes.getBcmligReference());
                           var46.setFacligPump(this.commandeLigneVentes.getBcmligPump());
                           var46.setFacligPu(this.commandeLigneVentes.getBcmligPu());
                           var46.setFacligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                           var46.setFacligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                           var46.setFacligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                           var46.setFacligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                           this.commandeLigneVentes.setBcmligQte(0.0F);
                           this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
                           var46.setFacligQte(0.0F);
                           var46.setFacligLong(this.commandeLigneVentes.getBcmligLong());
                           var46.setFacligLarg(this.commandeLigneVentes.getBcmligLarg());
                           var46.setFacligHaut(this.commandeLigneVentes.getBcmligHaut());
                           var46.setFacligDiam(this.commandeLigneVentes.getBcmligDiam());
                           var46.setFacligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                           var46.setFacligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                           var46.setFacligVolume(this.commandeLigneVentes.getBcmligVolume());
                           var46.setFacligNb(this.commandeLigneVentes.getBcmligNb());
                           var46.setFacligQteUtil(0.0F);
                           var46.setFacligQteStock(0.0F);
                           var46.setFacligRabais(this.commandeLigneVentes.getBcmligRabais());
                           var46.setFacligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                           var46.setFacligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                           var46.setFacligPt(this.commandeLigneVentes.getBcmligPt());
                           var46.setFacligTva(this.commandeLigneVentes.getBcmligTva());
                           var46.setFacligTtc(this.commandeLigneVentes.getBcmligTtc());
                           var46.setFacligTc(this.commandeLigneVentes.getBcmligTc());
                           var46.setFactureEnteteVentes(var1);
                           var6.add(var46);
                        }
                     } else {
                        ++var26;
                        var46 = new FactureLigneVentes();
                        var46.setFacligOrdre(var26);
                        var46.setFacligCode("");
                        var46.setFacligGroupe("");
                        var46.setFacligModeGroupe(0);
                        var46.setFacligDevise(this.commandeLigneVentes.getBcmligDevise());
                        var46.setFacligFamille("");
                        var46.setFacligIdDvs(this.commandeLigneVentes.getBcmligId());
                        var46.setFacligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                        var46.setFacligComplement(this.commandeLigneVentes.getBcmligComplement());
                        var46.setFacligDepot("");
                        var46.setFacligEchelle(0);
                        var46.setFacligUnite(this.commandeLigneVentes.getBcmligUnite());
                        var46.setFacligCondition(this.commandeLigneVentes.getBcmligCondition());
                        var46.setFacligStock(0);
                        var46.setFacligReference(this.commandeLigneVentes.getBcmligReference());
                        var46.setFacligPump(0.0D);
                        var46.setFacligPu(this.commandeLigneVentes.getBcmligPu());
                        var46.setFacligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                        var46.setFacligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                        var46.setFacligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                        var46.setFacligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                        this.commandeLigneVentes.setBcmligQte(0.0F);
                        this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
                        var46.setFacligQte(0.0F);
                        var46.setFacligLong(this.commandeLigneVentes.getBcmligLong());
                        var46.setFacligLarg(this.commandeLigneVentes.getBcmligLarg());
                        var46.setFacligHaut(this.commandeLigneVentes.getBcmligHaut());
                        var46.setFacligDiam(this.commandeLigneVentes.getBcmligDiam());
                        var46.setFacligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                        var46.setFacligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                        var46.setFacligVolume(this.commandeLigneVentes.getBcmligVolume());
                        var46.setFacligNb(this.commandeLigneVentes.getBcmligNb());
                        var46.setFacligQteUtil(0.0F);
                        var46.setFacligQteStock(0.0F);
                        var46.setFacligRabais(this.commandeLigneVentes.getBcmligRabais());
                        var46.setFacligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                        var46.setFacligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                        var46.setFacligPt(this.commandeLigneVentes.getBcmligPt());
                        var46.setFacligTva(this.commandeLigneVentes.getBcmligTva());
                        var46.setFacligTtc(this.commandeLigneVentes.getBcmligTtc());
                        var46.setFacligTc(this.commandeLigneVentes.getBcmligTc());
                        var46.setFactureEnteteVentes(var1);
                        var6.add(var46);
                     }
                  }
               }
            }

            var1.setFacTotHt(var13);
            var1.setFacTotRemise(var15);
            var1.setFacTotRabais(var17);
            var1.setFacTotTva(var19);
            var1.setFacTotTc(var23);
            var1.setFacTotTtc(var21);
            var1 = var3.modif(var1, var2);
            if (var6.size() != 0) {
               var4.saveLigne(var6, var1, var2);
               this.calculStock.trfCmdFacturationVenteATT(var6, this.baseLog, var2);
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFac(var1, var2), var1.getFacId(), var1.getFacNum(), var1.getFacNomTiers(), var1.getFacDate(), var1.getFacDevise(), var1.getFacTotTtc() + var1.getFacTotTc(), var1.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 25), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var6, var1), this.calculeParc(var2), var1.getVar_format_devise(), 0, var2);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(22);
         this.documentTraceVentes.setDoctraOrgSerie(this.commandeEnteteVentes.getBcmSerie());
         this.documentTraceVentes.setDoctraOrgId(this.commandeEnteteVentes.getBcmId());
         this.documentTraceVentes.setDoctraOrgNum(this.commandeEnteteVentes.getBcmNum());
         this.documentTraceVentes.setDoctraOrgDate(this.commandeEnteteVentes.getBcmDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var1.getFacSerie());
         this.documentTraceVentes.setDoctraDstId(var1.getFacId());
         this.documentTraceVentes.setDoctraDstNum(var1.getFacNum());
         this.documentTraceVentes.setDoctraDstDate(var1.getFacDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var2);
         this.documentTrace.add(this.documentTraceVentes);
         this.datamodelDocumentTrace.setWrappedData(this.documentTrace);
         if (var10 <= var11 + var12 && var10 != 0.0F && var11 + var12 != 0.0F) {
            this.commandeEnteteVentes.setBcmEtat(5);
         } else {
            this.commandeEnteteVentes.setBcmEtat(4);
         }

         this.commandeEnteteVentes.setBcmDateTransforme(new Date());
         this.commandeEnteteVentes.setBcmTypeTransforme(this.var_type_trf);
         this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var2);
         var5.commit();
      } catch (HibernateException var53) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var53;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      new ArrayList();
      List var55 = var4.chargerLesLignes(var1, (Session)null);
      if (var55.size() != 0) {
         var7 = false;
         new FactureLigneVentes();

         for(int var61 = 0; var61 < var55.size(); ++var61) {
            FactureLigneVentes var59 = (FactureLigneVentes)var55.get(var61);
            if (var59.getFacligIdBcm() != 0L) {
               long var62 = var59.getFacligId();
               long var65 = var59.getFacligIdBcm();
               boolean var14 = false;

               for(int var66 = 0; var66 < var55.size(); ++var66) {
                  if (((FactureLigneVentes)var55.get(var66)).getFacligId() != var62 && ((FactureLigneVentes)var55.get(var66)).getFacligIdBcm() == var65) {
                     var4.deleteOneLigne(var59);
                     --var61;
                     var14 = true;
                     var7 = true;
                     break;
                  }
               }

               if (var14) {
                  var55.remove(var59);
               }
            }
         }

         if (var7) {
            double var63 = 0.0D;
            double var64 = 0.0D;
            var13 = 0.0D;
            var15 = 0.0D;
            var17 = 0.0D;
            var19 = 0.0D;
            new FactureLigneVentes();

            for(int var22 = 0; var22 < var55.size(); ++var22) {
               FactureLigneVentes var67 = (FactureLigneVentes)var55.get(var22);
               var63 += var67.getFacligPt();
               var64 += (var67.getFacligPu() - var67.getFacligPuRem()) * (double)var67.getFacligQte();
               var13 += var67.getFacligRabais();
               var15 += var67.getFacligTva();
               var17 += var67.getFacligTtc();
               var19 += var67.getFacligTc();
            }

            var1 = var3.pourParapheur(var1.getFacId(), (Session)null);
            if (var1 != null) {
               var1.setFacTotHt(var63);
               var1.setFacTotRemise(var64);
               var1.setFacTotRabais(var13);
               var1.setFacTotTva(var15);
               var1.setFacTotTc(var19);
               var1.setFacTotTtc(var17);
               var1 = var3.modif(var1);
            }
         }
      }

      ArrayList var58 = new ArrayList();
      this.miseAJourReliquat(var58);
      this.calculReliquatSuite();
      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionTRFFAC(List var1, FactureEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new FactureLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            FactureLigneVentes var4 = (FactureLigneVentes)var1.get(var11);
            if (var4.getFacligModeGroupe() != 2 || var4.getFacligGroupe() == null || var4.getFacligGroupe().isEmpty()) {
               if (var4.getFacligCode() != null && !var4.getFacligCode().isEmpty() && var4.getFacligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getFacligLibelle();
               }

               if (var5) {
                  var7 += var4.getFacligPt();
                  var9 = var4.getFacligTtc();
               }

               if (var4.getFacligCode() != null && !var4.getFacligCode().isEmpty() && var4.getFacligCode().equals("=") && var5) {
                  var4 = new FactureLigneVentes();
                  var4.setFactureEnteteVentes(var2);
                  var4.setFacligCode("=");
                  var4.setFacligLibelle(var6);
                  var4.setFacligPt(var7);
                  var4.setFacligTtc(var9);
                  var3.add(var4);
                  var7 = 0.0D;
                  var9 = 0.0D;
                  var5 = false;
               } else {
                  var3.add(var4);
               }
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getFacTotTtc() + var2.getFacTotTc(), var2.getFacDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationFac(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setFacEtatVal(1);
         var1.setFacEtat(0);
         var1.setFacDateValide((Date)null);
      } else {
         var1.setFacEtatVal(0);
         if (var1.getFacDateImp() != null) {
            if (var1.getFacEtat() == 0) {
               var1.setFacEtat(1);
               var1.setFacDateValide(new Date());
            }
         } else {
            var1.setFacEtat(0);
            var1.setFacDateValide((Date)null);
         }
      }

      return var4;
   }

   public void trfChg() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         ChargementEntete var3 = new ChargementEntete();
         ChargementEnteteDao var4 = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
         ChargementLigneDao var5 = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setChamobSerie(this.var_serie_trf);
         } else {
            var3.setChamobSerie(this.commandeEnteteVentes.getBcmSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setChamobUserCreat(this.usersLog.getUsrid());
         var3.setChamobNomUserCreat(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setChamobDate(this.utilDate.dateToSQLLight(this.commandeEnteteVentes.getBcmDate()));
         } else {
            var3.setChamobDate(this.var_date_trf);
         }

         var3.setChamobDate(this.utilDate.dateToSQL(var3.getChamobDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setChamobDateCreat(new Date());
         var3.setChamobDateModif((Date)null);
         var3.setChamobUserModif(0L);
         var3.setChamobNomUserModif("");
         var3.setChamobNum("");
         var3.setChamobService(this.commandeEnteteVentes.getBcmService());
         if (!var3.getChamobSerie().equalsIgnoreCase("X") && !var3.getChamobSerie().isEmpty()) {
            var3.setChamobNum(this.calculChrono.numCompose(var3.getChamobDate(), this.var_type_trf, var3.getChamobSerie(), var1));
         } else {
            long var7 = var4.selectLastNum(var1);
            var3.setChamobNum("" + var7);
         }

         this.verifieExistenceHabilitationChg(var3, var1);
         var3.setChamobNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
         var3.setChamobIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
         var3.setChamobNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
         var3.setChamobIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
         var3.setChamobNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
         var3.setChamobIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
         if (this.optionsVentes.getDepotChargementDefaut() != null && this.optionsVentes.getDepotChargementDefaut().contains(":")) {
            String[] var35 = this.optionsVentes.getDepotChargementDefaut().split(":");
            var3.setChamobDepotCharg(var35[0]);
            var3.setChamobCat(this.commandeEnteteVentes.getBcmCat());
            var3.setChamobObjet(this.commandeEnteteVentes.getBcmNomTiers());
            var3.setChamobObservation(this.commandeEnteteVentes.getBcmObservation());
            var3.setChamobTotHt(0.0D);
            var3.setChamobTotRemise(0.0D);
            var3.setChamobTotRabais(0.0D);
            var3.setChamobTotTva(0.0D);
            var3.setChamobTotTc(0.0D);
            var3.setChamobTotTtc(0.0D);
            var3.setChamobTotReglement(0.0D);
            var3.setChamobSolde(0);
            var3.setChamobContener(this.commandeEnteteVentes.getBcmContener());
            var3.setChamobActivite(this.commandeEnteteVentes.getBcmActivite());
            var3.setChamobSite(this.commandeEnteteVentes.getBcmSite());
            var3.setChamobDepartement(this.commandeEnteteVentes.getBcmDepartement());
            var3.setChamobAnal2(this.commandeEnteteVentes.getBcmAnal2());
            var3.setChamobAnal4(this.commandeEnteteVentes.getBcmAnal4());
            var3.setChamobDateImp((Date)null);
            var3.setChamobModeleImp(this.var_modele_trf);
            var3.setChamobEtat(0);
            var3.setChamobDateTransforme((Date)null);
            var3.setChamobDateAnnule((Date)null);
            var3.setChamobMotifAnnule("");
            var3.setExercicesVentes(this.exercicesVentes);
            var3.setUsers(this.usersLog);
            var3 = var4.insert(var3, var1);
            float var8 = 0.0F;
            float var9 = 0.0F;
            float var10 = 0.0F;
            double var11 = 0.0D;
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            double var19 = 0.0D;
            double var21 = 0.0D;
            String var23 = "";
            int var24 = 0;
            if (this.lesLignesList.size() != 0) {
               for(int var25 = 0; var25 < this.lesLignesList.size(); ++var25) {
                  this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var25);
                  if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                     if (this.var_mode_trf.equals("0")) {
                        if (var23 == null || var23.isEmpty() || !var23.equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum())) {
                           var23 = this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum();
                           ++var24;
                           ChargementLigne var37 = new ChargementLigne();
                           var37.setChaligCode("-");
                           var37.setChaligLibelle("---> Suivant commande N° " + var23);
                           var37.setChargementEntete(var3);
                           var6.add(var37);
                        }
                     } else if (var25 == 0) {
                        var23 = "";
                        String var26 = "";
                        int var27 = 0;

                        while(true) {
                           if (var27 >= this.lesLignesList.size()) {
                              ++var24;
                              ChargementLigne var40 = new ChargementLigne();
                              var40.setChaligCode("-");
                              var40.setChaligLibelle("---> Suivant commande N° " + var26);
                              var40.setChargementEntete(var3);
                              var6.add(var40);
                              break;
                           }

                           if (var23 == null || var23.isEmpty() || !var23.equals(this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum())) {
                              var23 = this.commandeLigneVentes.getCommandeEnteteVentes().getBcmNum();
                              if (var26 != null && !var26.isEmpty()) {
                                 var26 = var26 + "," + var23;
                              } else {
                                 var26 = var23;
                              }
                           }

                           ++var27;
                        }
                     }
                  }

                  if (this.commandeLigneVentes.getBcmligLibelle() != null && !this.commandeLigneVentes.getBcmligLibelle().isEmpty() && this.commandeLigneVentes.getVar_qteReliquat() != 0.0F) {
                     if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                        this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                        if (this.produits != null && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                           this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.commandeLigneVentes.getBcmligCode(), this.commandeLigneVentes.getBcmligDepot(), var1);
                        }
                     }

                     float var38 = this.commandeLigneVentes.getBcmligQte();
                     float var41 = this.commandeLigneVentes.getBcmligQteUtil();
                     ++var24;
                     ChargementLigne var28 = new ChargementLigne();
                     var8 += this.commandeLigneVentes.getBcmligQte();
                     var9 += this.commandeLigneVentes.getVar_qteDejaTrf();
                     if (((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat() != 0.0F) {
                        var28.setChaligOrdre(var24);
                        var28.setChaligCode(this.commandeLigneVentes.getBcmligCode());
                        var28.setChaligFamille(this.commandeLigneVentes.getBcmligFamille());
                        var28.setChaligIdBcm(this.commandeLigneVentes.getBcmligId());
                        var28.setChaligLibelle(this.commandeLigneVentes.getBcmligLibelle());
                        if (((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne() != null && !((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne().isEmpty() && ((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne().contains("=")) {
                           String[] var29 = ((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne().split("=");
                           var28.setChaligDepotCharg(var29[0]);
                        } else {
                           var28.setChaligDepotCharg("");
                        }

                        var28.setChaligEchelle(this.commandeLigneVentes.getBcmligEchelle());
                        var28.setChaligUnite(this.commandeLigneVentes.getBcmligUnite());
                        var28.setChaligCondition(this.commandeLigneVentes.getBcmligCondition());
                        var28.setChaligStock(this.commandeLigneVentes.getBcmligStock());
                        var28.setChaligReference(this.commandeLigneVentes.getBcmligReference());
                        var28.setChaligPump(this.commandeLigneVentes.getBcmligPump());
                        var28.setChaligPu(this.commandeLigneVentes.getBcmligPu());
                        var28.setChaligPuTtc(this.commandeLigneVentes.getBcmligPuTtc());
                        var28.setChaligTauxRemise(this.commandeLigneVentes.getBcmligTauxRemise());
                        var28.setChaligPuRem(this.commandeLigneVentes.getBcmligPuRem());
                        var28.setChaligPuRemTtc(this.commandeLigneVentes.getBcmligPuRemTtc());
                        this.commandeLigneVentes.setBcmligQte(((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat());
                        this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var1);
                        var28.setChaligQteDem(((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat());
                        var28.setChaligQteCharg(0.0F);
                        var28.setChaligLong(this.commandeLigneVentes.getBcmligLong());
                        var28.setChaligLarg(this.commandeLigneVentes.getBcmligLarg());
                        var28.setChaligHaut(this.commandeLigneVentes.getBcmligHaut());
                        var28.setChaligDiam(this.commandeLigneVentes.getBcmligDiam());
                        var28.setChaligPoidsBrut(this.commandeLigneVentes.getBcmligPoidsBrut());
                        var28.setChaligPoidsNet(this.commandeLigneVentes.getBcmligPoidsNet());
                        var28.setChaligVolume(this.commandeLigneVentes.getBcmligVolume());
                        var28.setChaligNb(this.commandeLigneVentes.getBcmligNb());
                        this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var1);
                        if (this.produits != null) {
                           var28.setChaligGenerique(this.produits.getProMode());
                           var28.setChaligQteUtil(0.0F);
                        } else {
                           var28.setChaligGenerique(0);
                           var28.setChaligQteUtil(0.0F);
                        }

                        var28.setChaligRabais(this.commandeLigneVentes.getBcmligRabais());
                        var28.setChaligTauxTaxe(this.commandeLigneVentes.getBcmligTauxTaxe());
                        var28.setChaligTaxe(this.commandeLigneVentes.getBcmligTaxe());
                        var28.setChaligPt(this.commandeLigneVentes.getBcmligPt());
                        var28.setChaligTva(this.commandeLigneVentes.getBcmligTva());
                        var28.setChaligTtc(this.commandeLigneVentes.getBcmligTtc());
                        var28.setChaligTc(this.commandeLigneVentes.getBcmligTc());
                        var28.setChargementEntete(var3);
                        var10 += ((CommandeLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat();
                        var6.add(var28);
                        var11 += var28.getChaligPt();
                        var13 += (var28.getChaligPu() - var28.getChaligPuRem()) * (double)var28.getChaligQteCharg();
                        var15 += var28.getChaligRabais();
                        var17 += var28.getChaligTva();
                        var19 += var28.getChaligTtc();
                        var21 += var28.getChaligTc();
                        this.commandeLigneVentes.setBcmligQte(var38);
                        this.commandeLigneVentes.setBcmligQteUtil(var41);
                     }
                  }
               }

               var3.setChamobTotHt(var11);
               var3.setChamobTotRemise(var13);
               var3.setChamobTotRabais(var15);
               var3.setChamobTotTva(var17);
               var3.setChamobTotTc(var21);
               var3.setChamobTotTtc(var19);
               var3 = var4.modif(var3, var1);
               if (var6.size() != 0) {
                  var5.saveLigne(var6, var3, var1);
                  new ChargementLigne();

                  for(int var39 = 0; var39 < var6.size(); ++var39) {
                     ChargementLigne var36 = (ChargementLigne)var6.get(var39);
                     this.produits = this.produitsDao.chargeProduit(var36.getChaligCode(), var1);
                     if (this.produits != null && this.produits.getProStock() >= 1) {
                        this.calculStock.majChargementVentesVAL(var36, 0.0F, this.produits, 1, this.baseLog, var1);
                     }
                  }
               }
            }

            this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationChg(var3, var1), var3.getChamobId(), var3.getChamobNum(), var3.getChamobNomResponsable(), var3.getChamobDate(), this.structureLog.getStrdevise(), var3.getChamobTotTtc() + var3.getChamobTotTc(), var3.getChamobModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 28), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFCHG(var6, var3), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
            this.documentTraceVentes.setDoctraDateCreat(new Date());
            this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
            this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
            this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
            this.documentTraceVentes.setDoctraOrgType(this.nature);
            this.documentTraceVentes.setDoctraOrgSerie(this.commandeEnteteVentes.getBcmSerie());
            this.documentTraceVentes.setDoctraOrgId(this.commandeEnteteVentes.getBcmId());
            this.documentTraceVentes.setDoctraOrgNum(this.commandeEnteteVentes.getBcmNum());
            this.documentTraceVentes.setDoctraOrgDate(this.commandeEnteteVentes.getBcmDate());
            this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
            this.documentTraceVentes.setDoctraDstSerie(var3.getChamobSerie());
            this.documentTraceVentes.setDoctraDstId(var3.getChamobId());
            this.documentTraceVentes.setDoctraDstNum(var3.getChamobNum());
            this.documentTraceVentes.setDoctraDstDate(var3.getChamobDate());
            this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
            if (var8 <= var9 + var10 && var8 != 0.0F && var9 + var10 != 0.0F) {
               this.commandeEnteteVentes.setBcmEtat(5);
            } else {
               this.commandeEnteteVentes.setBcmEtat(4);
            }

            this.commandeEnteteVentes.setBcmDateTransforme(new Date());
            this.commandeEnteteVentes.setBcmTypeTransforme(this.var_type_trf);
            this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
         }

         var2.commit();
      } catch (HibernateException var33) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var33;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFCHG(List var1, ChargementEntete var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new ChargementLigne();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            ChargementLigne var4 = (ChargementLigne)var1.get(var11);
            if (var4.getChaligCode() != null && !var4.getChaligCode().isEmpty() && var4.getChaligCode().equals("-")) {
               var5 = true;
               var6 = var4.getChaligLibelle();
            }

            if (var5) {
               var7 += var4.getChaligPt();
               var9 = var4.getChaligTtc();
            }

            if (var4.getChaligCode() != null && !var4.getChaligCode().isEmpty() && var4.getChaligCode().equals("=") && var5) {
               var4 = new ChargementLigne();
               var4.setChargementEntete(var2);
               var4.setChaligCode("=");
               var4.setChaligLibelle(var6);
               var4.setChaligPt(var7);
               var4.setChaligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getChamobTotTtc() + var2.getChamobTotTc(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationChg(ChargementEntete var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setChamobEtatVal(1);
         var1.setChamobEtat(0);
      } else {
         var1.setChamobEtatVal(0);
         if (var1.getChamobDateImp() != null) {
            if (var1.getChamobEtat() == 0) {
               var1.setChamobEtat(1);
            }
         } else {
            var1.setChamobEtat(0);
         }
      }

      return var4;
   }

   public void verifRelcat() {
      if (this.commandeLigneVentes != null) {
         float var1 = this.commandeLigneVentes.getBcmligQte() - this.commandeLigneVentes.getVar_qteDejaTrf();
         float var2 = this.verifQteDisponibleBc(this.commandeLigneVentes);
         if (var1 > var2 && this.structureLog.getStrstockNegatif() == 2 && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty() && this.commandeLigneVentes.getBcmligStock() != 0) {
            var1 = var2;
         }

         if (this.commandeLigneVentes.getVar_qteReliquat() > var1) {
            this.var_aff_trf = false;
         } else {
            this.var_aff_trf = true;
         }
      }

   }

   public void listeAppelFonds() throws HibernateException, NamingException {
      this.totalAppel = 0.0D;
      this.totalPourcentage = 0.0F;
      if (this.commandeEnteteVentes != null) {
         new ArrayList();
         List var1 = this.bonEncaissementVenteDao.rechercheBeByDocAppelFonds(this.commandeEnteteVentes.getBcmId(), this.nature, (Session)null);
         if (var1.size() != 0) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
               this.totalPourcentage = (float)((double)this.totalPourcentage + ((BonEncaissementVente)var1.get(var2)).getBonRendu());
               this.totalAppel += ((BonEncaissementVente)var1.get(var2)).getBonAPayer();
            }
         }

         this.dataModelAppelFonds.setWrappedData(var1);
         this.bonEncaissementVente = new BonEncaissementVente();
         this.showModalPanelAppelFonds = true;
         this.showModalPanelAjoutAppelFonds = false;
      }

   }

   public void annulerAppelfonds() {
      this.showModalPanelAppelFonds = false;
   }

   public void ajouterAppelfonds() {
      if (this.commandeEnteteVentes != null) {
         this.valAppelfonds = 0.0F;
         this.totalAppelfonds = 0.0D;
         this.var_date_trf = new Date();
         this.bonEncaissementVente = new BonEncaissementVente();
         this.showModalPanelAjoutAppelFonds = true;
      }

   }

   public void selectionnerAppelFonds() {
      if (this.dataModelAppelFonds.isRowAvailable()) {
         this.bonEncaissementVente = (BonEncaissementVente)this.dataModelAppelFonds.getRowData();
      }

   }

   public void modifierAppelfonds() {
      if (this.bonEncaissementVente != null) {
         this.valAppelfonds = (float)this.bonEncaissementVente.getBonRendu();
         this.totalAppelfonds = this.bonEncaissementVente.getBonAPayer();
         this.var_date_trf = this.bonEncaissementVente.getBonDate();
         this.showModalPanelAjoutAppelFonds = true;
      }

   }

   public void supprimerAppelfonds() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.bonEncaissementVenteDao.delete(this.bonEncaissementVente);
         this.listeAppelFonds();
      }

   }

   public void fermetureAppelfonds() {
      this.showModalPanelAjoutAppelFonds = false;
   }

   public void calculAppelfonds() {
      if (this.valAppelfonds != 0.0F && this.totalAppelfonds == 0.0D) {
         this.totalAppelfonds = this.utilNombre.myRoundDevise(this.commandeEnteteVentes.getBcmTotHt() * (double)this.valAppelfonds / 100.0D, this.commandeEnteteVentes.getBcmDevise());
      } else if (this.valAppelfonds == 0.0F && this.totalAppelfonds != 0.0D) {
         this.valAppelfonds = (float)this.utilNombre.myRound(this.totalAppelfonds / this.commandeEnteteVentes.getBcmTotHt() * 100.0D, 4);
      }

   }

   public void validerAppelfonds() throws HibernateException, NamingException {
      if (this.valAppelfonds != 0.0F && this.totalAppelfonds != 0.0D) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = "";
            if (this.bonEncaissementVente.getBonId() == 0L) {
               var3 = this.calculChrono.numCompose(new Date(), 29, this.commandeEnteteVentes.getBcmSerie(), var1);
            } else {
               var3 = this.bonEncaissementVente.getBonNum();
            }

            if (var3 != null && !var3.isEmpty()) {
               this.bonEncaissementVente.setBonCodeCaisse((String)null);
               this.bonEncaissementVente.setBonLibCaisse((String)null);
               this.bonEncaissementVente.setBonTypeReg(0);
               this.bonEncaissementVente.setBonCodeBanq((String)null);
               this.bonEncaissementVente.setBonLibBanq((String)null);
               this.bonEncaissementVente.setBonBanqueTireur((String)null);
               this.bonEncaissementVente.setBonNumChqBdx((String)null);
               this.bonEncaissementVente.setBonDateCreat(new Date());
               this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
               this.bonEncaissementVente.setBonActivite(this.commandeEnteteVentes.getBcmActivite());
               this.bonEncaissementVente.setBonSite(this.commandeEnteteVentes.getBcmSite());
               this.bonEncaissementVente.setBonDepartement(this.commandeEnteteVentes.getBcmDepartement());
               this.bonEncaissementVente.setBonService(this.commandeEnteteVentes.getBcmService());
               this.bonEncaissementVente.setBonRegion(this.commandeEnteteVentes.getBcmRegion());
               this.bonEncaissementVente.setBonSecteur(this.commandeEnteteVentes.getBcmSecteur());
               this.bonEncaissementVente.setBonPdv(this.commandeEnteteVentes.getBcmPdv());
               this.bonEncaissementVente.setBonDateEcheReg(this.commandeEnteteVentes.getBcmDateEcheReg());
               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               this.bonEncaissementVente.setBonNomTiers(this.commandeEnteteVentes.getBcmNomTiers());
               this.bonEncaissementVente.setBonIdTiers(this.commandeEnteteVentes.getTiers().getTieid());
               this.bonEncaissementVente.setBonNomContact(this.commandeEnteteVentes.getBcmNomContact());
               this.bonEncaissementVente.setBonIdContact(this.commandeEnteteVentes.getBcmIdContact());
               this.bonEncaissementVente.setBonTypeTiers(20);
               this.bonEncaissementVente.setBonLibelle("Appel de fonds Commande N° " + this.commandeEnteteVentes.getBcmNum());
               this.bonEncaissementVente.setBonRef(this.commandeEnteteVentes.getBcmNum());
               this.bonEncaissementVente.setBonIdRef(this.commandeEnteteVentes.getBcmId());
               this.bonEncaissementVente.setBonObject(this.commandeEnteteVentes.getBcmObject());
               this.bonEncaissementVente.setBonObservation(this.commandeEnteteVentes.getBcmObservation());
               this.bonEncaissementVente.setBonSerie(this.commandeEnteteVentes.getBcmSerie());
               this.bonEncaissementVente.setBonDevise(this.commandeEnteteVentes.getBcmDevise());
               this.bonEncaissementVente.setBonTotTtc(this.commandeEnteteVentes.getBcmTotTtc());
               this.bonEncaissementVente.setBonAPayer(this.totalAppelfonds);
               this.bonEncaissementVente.setBonRendu((double)this.valAppelfonds);
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var3);
               this.bonEncaissementVente.setBonDate(this.var_date_trf);
               this.bonEncaissementVente.setBonDateRemise((Date)null);
               this.bonEncaissementVente.setBonIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
               this.bonEncaissementVente.setBonNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
               this.bonEncaissementVente.setBonIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
               this.bonEncaissementVente.setBonNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
               this.bonEncaissementVente.setBonIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
               this.bonEncaissementVente.setBonNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
               this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
               this.bonEncaissementVente.setBonClient("");
               this.bonEncaissementVente.setBonFacture("");
               this.bonEncaissementVente.setBonMontant("");
               this.bonEncaissementVente.setBonType(1);
               if (this.bonEncaissementVente.getBonId() == 0L) {
                  this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
               } else {
                  this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var1);
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
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

      this.listeAppelFonds();
   }

   public void initImpressionAppelfonds() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      this.nomModeleDocument = "";
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "appelFondsBC" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesDocumentsAppelFonds = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.lesDocumentsAppelFonds.add(new SelectItem(var5));
            }
         }
      }

      this.showModalPanelPrintAppelfonds = true;
   }

   public void fermerPrintAppelfonds() {
      this.showModalPanelPrintAppelfonds = false;
   }

   public void imprimerJRVAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerAppelfonds();
   }

   public void imprimerPDFAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerAppelfonds();
   }

   public void imprimerODTAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerAppelfonds();
   }

   public void imprimerXLSAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerAppelfonds();
   }

   public void imprimerDOCAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerAppelfonds();
   }

   public void imprimerHTMLAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerAppelfonds();
   }

   public void imprimerXMLAppelfonds() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerAppelfonds();
   }

   public void imprimerAppelfonds() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty() && this.bonEncaissementVente != null) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.utilPrint.setRapport(this.nomModeleDocument);
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "appelFondsBC" + File.separator;
         this.utilPrint.setCheminRapport(var1);
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
         this.utilPrint.setEntete("Impression Appel de fonds");
         if (this.commandeEnteteVentes.getBcmFormule1() != null && !this.commandeEnteteVentes.getBcmFormule1().isEmpty()) {
            this.utilPrint.setAdresseLivraison(this.formule1());
         } else {
            this.utilPrint.setAdresseLivraison((String)null);
         }

         if (this.commandeEnteteVentes.getBcmFormule2() != null && !this.commandeEnteteVentes.getBcmFormule2().isEmpty()) {
            this.utilPrint.setAdresseFacturation(this.formule2());
         } else {
            this.utilPrint.setAdresseFacturation((String)null);
         }

         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur((String)null);
         this.utilPrint.setDestinataire((String)null);
         this.utilPrint.setDestinataireCC((String)null);
         this.utilPrint.setDestinataireCCI((String)null);
         this.utilPrint.setImageFondPage((String)null);
         this.utilPrint.setIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
         this.utilPrint.setIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
         this.utilPrint.setTiersSelectionne(this.commandeEnteteVentes.getTiers());
         if (this.contacts == null) {
            this.contacts = new Contacts();
         }

         this.utilPrint.setContact(this.contacts);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(this.commandeEnteteVentes.getBcmId());
         this.utilPrint.setPlafond(this.bonEncaissementVente.getBonAPayer());
         this.utilPrint.setTaux((float)this.bonEncaissementVente.getBonRendu());
         this.utilPrint.setCompte(this.bonEncaissementVente.getBonNum());
         this.montant_lettre = this.utilNombre.begin(this.bonEncaissementVente.getBonAPayer(), this.commandeEnteteVentes.getBcmDevise());
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(this.lesLignesList);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.commandeEnteteVentes != null) {
         this.caissesCommerciales = new CaissesCommerciales();
         if (this.caissesCommercialesDao == null) {
            this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         }

         this.bonEncaissementVente = new BonEncaissementVente();
         this.bonEncaissementVente.setBonCodeCaisse((String)null);
         this.bonEncaissementVente.setBonLibCaisse((String)null);
         this.bonEncaissementVente.setBonDate(new Date());
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
         if (this.var_tot_bon_encaissement > this.commandeEnteteVentes.getBcmTotTtc()) {
            this.commandeEnteteVentes.setBcmTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.commandeEnteteVentes.getBcmTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.commandeEnteteVentes.getBcmTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.commandeEnteteVentes.getBcmEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.commandeEnteteVentes.getBcmTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.commandeEnteteVentes.setBcmTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.commandeEnteteVentes.getBcmTotTtc() - this.var_tot_bon_encaissement;
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.commandeEnteteVentes.getBcmSerie())) {
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

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.tiers.getTiedepotavance()) {
         this.montantElmTotBonEnc = this.tiers.getTiedepotavance();
      }

   }

   public void selectionBanqueDestinationBencaissement() throws HibernateException, NamingException {
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonEncaissementVente.setBonCodeCaisse(var1[0]);
         this.bonEncaissementVente.setBonLibCaisse(var1[1]);
      } else {
         this.bonEncaissementVente.setBonCodeCaisse((String)null);
         this.bonEncaissementVente.setBonLibCaisse((String)null);
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void chargerModReg() {
      if (this.commandeEnteteVentes.getBcmTypeReg() != 4 && this.commandeEnteteVentes.getBcmTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (Math.abs(this.var_tot_bon_encaissement) <= Math.abs(this.commandeEnteteVentes.getBcmTotTtc())) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.commandeEnteteVentes.getBcmTypeReg() == 5) {
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(this.nature, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.commandeEnteteVentes.getBcmSerie(), var1);
               if (var3 != null && !var3.isEmpty()) {
                  this.bonEncaissementVente = new BonEncaissementVente();
                  String[] var4;
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     var4 = this.var_inputCaisse.split(":");
                     this.bonEncaissementVente.setBonCodeCaisse(var4[0]);
                     this.bonEncaissementVente.setBonLibCaisse(var4[1]);
                     if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
                        String[] var5 = this.var_type_reg.split(":");
                        this.bonEncaissementVente.setBonTypeReg(Integer.parseInt(var5[0]));
                     } else {
                        this.bonEncaissementVente.setBonTypeReg(0);
                     }
                  } else {
                     this.bonEncaissementVente.setBonCodeCaisse((String)null);
                     this.bonEncaissementVente.setBonLibCaisse((String)null);
                     this.bonEncaissementVente.setBonTypeReg(0);
                  }

                  if (this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
                     var4 = this.var_banque_destination.split(":");
                     this.bonEncaissementVente.setBonCodeBanq(var4[0]);
                     this.bonEncaissementVente.setBonLibBanq(var4[1]);
                  } else {
                     this.bonEncaissementVente.setBonCodeBanq((String)null);
                     this.bonEncaissementVente.setBonLibBanq((String)null);
                  }

                  this.bonEncaissementVente.setBonBanqueTireur(this.var_banque_tireur);
                  this.bonEncaissementVente.setBonNumChqBdx(this.var_num_cheque);
                  this.bonEncaissementVente.setBonDateCreat(new Date());
                  this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                  this.bonEncaissementVente.setBonActivite(this.commandeEnteteVentes.getBcmActivite());
                  this.bonEncaissementVente.setBonSite(this.commandeEnteteVentes.getBcmSite());
                  this.bonEncaissementVente.setBonDepartement(this.commandeEnteteVentes.getBcmDepartement());
                  this.bonEncaissementVente.setBonService(this.commandeEnteteVentes.getBcmService());
                  this.bonEncaissementVente.setBonRegion(this.commandeEnteteVentes.getBcmRegion());
                  this.bonEncaissementVente.setBonSecteur(this.commandeEnteteVentes.getBcmSecteur());
                  this.bonEncaissementVente.setBonPdv(this.commandeEnteteVentes.getBcmPdv());
                  this.bonEncaissementVente.setBonDateEcheReg(this.commandeEnteteVentes.getBcmDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.commandeEnteteVentes.getBcmNomTiers());
                  this.bonEncaissementVente.setBonIdTiers(this.commandeEnteteVentes.getTiers().getTieid());
                  this.bonEncaissementVente.setBonNomContact(this.commandeEnteteVentes.getBcmNomContact());
                  this.bonEncaissementVente.setBonIdContact(this.commandeEnteteVentes.getBcmIdContact());
                  this.bonEncaissementVente.setBonTypeTiers(0);
                  this.bonEncaissementVente.setBonLibelle("Règlement Commande N° " + this.commandeEnteteVentes.getBcmNum());
                  this.bonEncaissementVente.setBonRef(this.commandeEnteteVentes.getBcmNum());
                  this.bonEncaissementVente.setBonIdRef(this.commandeEnteteVentes.getBcmId());
                  this.bonEncaissementVente.setBonObject(this.commandeEnteteVentes.getBcmObject());
                  this.bonEncaissementVente.setBonObservation(this.commandeEnteteVentes.getBcmObservation());
                  this.bonEncaissementVente.setBonSerie(this.commandeEnteteVentes.getBcmSerie());
                  this.bonEncaissementVente.setBonDevise(this.commandeEnteteVentes.getBcmDevise());
                  this.bonEncaissementVente.setBonTotTtc(this.commandeEnteteVentes.getBcmTotTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonDateRemise(this.var_date_remise);
                  this.bonEncaissementVente.setBonIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.commandeEnteteVentes.getBcmNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.commandeEnteteVentes.getBcmNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(this.commandeEnteteVentes.getBcmIdEquipe());
                  this.bonEncaissementVente.setBonNomEquipe(this.commandeEnteteVentes.getBcmNomEquipe());
                  this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
                  this.bonEncaissementVente.setBonClient("");
                  this.bonEncaissementVente.setBonFacture("");
                  this.bonEncaissementVente.setBonMontant("");
                  this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.lesEntetesList.get(var11);
            if (this.commandeEnteteVentes.isVar_select_ligne()) {
               long var13 = this.commandeEnteteVentes.getBcmId();
               this.commandeEnteteVentes = new CommandeEnteteVentes();
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(var13, var1);
               if (this.commandeEnteteVentes != null) {
                  this.lesEntetesList.remove(var11);
                  this.commandeEnteteVentes.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.commandeEnteteVentes);
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
            new CommandeEnteteVentes();
            CommandeEnteteVentes var11 = (CommandeEnteteVentes)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getBcmNomTiers())) && var11.getBcmSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getBcmNomTiers();
               var1 += var11.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc();
               var3 += var11.getBcmTotReglement();
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
            this.commandeEnteteVentes.setBcmTypeReg(0);
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.commandeEnteteVentes.getBcmSerie())) {
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
         new CommandeEnteteVentes();
         CommandeEnteteVentes var6 = (CommandeEnteteVentes)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getBcmTotTtc();
            var3 += var6.getBcmTotReglement();
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

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.tiers.getTiedepotavance()) {
         this.montantElmTotBonEnc = this.tiers.getTiedepotavance();
      }

      this.calculeNomRep();
      this.calculValeurTimbre();
   }

   public void calculValeurTimbre() {
      this.var_netAPayer = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      int var1;
      CommandeEnteteVentes var9;
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new CommandeEnteteVentes();
               CommandeEnteteVentes var7 = (CommandeEnteteVentes)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getBcmTotTtc() + var7.getBcmTotTc() - var7.getBcmTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getBcmTotTtc() + var7.getBcmTotTc() - var7.getBcmTotReglement(), var1, this.structureLog.getStrdevise(), var7.getBcmDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getBcmTotTtc() + var7.getBcmTotTc() - var7.getBcmTotReglement(), var1, this.structureLog.getStrdevise(), var7.getBcmDate());
                  var4 = var4 - var7.getBcmTotTtc() + var7.getBcmTotTc() - var7.getBcmTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new CommandeEnteteVentes();
            var9 = (CommandeEnteteVentes)this.listFactureSelectionne.get(var1);
            var9.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var9.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      if (this.commandeEnteteVentes.getBcmTypeReg() == 4) {
         double var8 = 0.0D;

         for(int var3 = 0; var3 < this.listFactureSelectionne.size(); ++var3) {
            new CommandeEnteteVentes();
            CommandeEnteteVentes var10 = (CommandeEnteteVentes)this.listFactureSelectionne.get(var3);
            var8 += var10.getVar_reliquat();
         }
      } else {
         this.montantElmTotBonEnc = 0.0D;

         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new CommandeEnteteVentes();
            var9 = (CommandeEnteteVentes)this.listFactureSelectionne.get(var1);
            this.montantElmTotBonEnc += var9.getVar_reliquat();
         }
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
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.commandeEnteteVentes.getBcmSerie();
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
                  new CommandeEnteteVentes();

                  for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                     CommandeEnteteVentes var20 = (CommandeEnteteVentes)this.listFactureSelectionne.get(var21);
                     var16 = var20.getVar_fac_timbre();
                     var18 = var20.getMontantReglementManuel();
                     var12 = 0.0D;
                     if (var20.isVar_select_ligne()) {
                        long var22 = var20.getBcmId();
                        var20 = this.commandeEnteteVentesDao.pourParapheur(var22, var3);
                        if (var20 != null) {
                           if (this.repartitionManuelle) {
                              if (var18 != 0.0D) {
                                 this.generationReglement(var8, var18, var16, var20, var5, var3);
                                 var34 = Math.abs(var34) - Math.abs(var18);
                                 if (var34 < 0.0D) {
                                    var34 = 0.0D;
                                    break;
                                 }
                              }
                           } else {
                              var12 = var20.getBcmTotTtc() + var20.getBcmTotTc() + var16 - var20.getBcmTotReglement();
                              if (var34 == 0.0D) {
                                 break;
                              }

                              if (Math.abs(var12) <= Math.abs(var34)) {
                                 var14 = var12;
                              } else {
                                 var14 = var34;
                              }

                              this.generationReglement(var8, var14, var16, var20, var5, var3);
                              var34 = Math.abs(var34) - Math.abs(var14);
                              if (var34 < 0.0D) {
                                 var34 = 0.0D;
                                 break;
                              }
                           }
                        }
                     }
                  }

                  boolean var35 = false;
                  if (var34 != 0.0D) {
                     this.reglements = new Reglements();
                     this.reglements.setRglDateReg(this.memoReglements.getRglDateReg());
                     this.reglements.setRglOperation("13");
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
                     this.reglements.setRglDateRemise(this.memoReglements.getRglDateRemise());
                     this.reglements.setRglDepartement(this.memoReglements.getRglDepartement());
                     this.reglements.setRglDepense(0.0D);
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
                     this.reglements.setRglRecette(var34);
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
         Session var31 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");

         for(int var32 = 0; var32 < this.lesEntetesList.size(); ++var32) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.lesEntetesList.get(var32);
            if (this.commandeEnteteVentes.isVar_select_ligne()) {
               long var33 = this.commandeEnteteVentes.getBcmId();
               this.commandeEnteteVentes = new CommandeEnteteVentes();
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(var33, var31);
               if (this.commandeEnteteVentes != null) {
                  if (this.commandeEnteteVentes.getBcmSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var32);
                  } else {
                     this.lesEntetesList.remove(var32);
                     this.commandeEnteteVentes.setVar_select_ligne(false);
                     this.lesEntetesList.add(var32, this.commandeEnteteVentes);
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
               this.totManuel += ((CommandeEnteteVentes)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
            }

            this.ecartManuel = Math.abs(this.montantElmTotBonEnc) - Math.abs(this.totManuel);
            if (this.ecartManuel >= 0.0D) {
               this.var_affiche_valide = true;
            } else {
               this.var_affiche_valide = false;
            }
         }

         if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.tiers.getTiedepotavance()) {
            this.montantElmTotBonEnc = this.tiers.getTiedepotavance();
         }
      }

   }

   public void generationReglement(String var1, double var2, double var4, CommandeEnteteVentes var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (Math.abs(var2) >= Math.abs(var6.getBcmTotTtc() + var6.getBcmTotTc() + var4)) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite(var6.getBcmActivite());
      this.reglements.setRglBudget(var6.getBcmBudget());
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(20);
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
      this.reglements.setRglDateRemise(this.var_date_remise);
      this.reglements.setRglDepartement(var6.getBcmDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getBcmDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getBcmNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getBcmId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle(var6.getBcmObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(22);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      if (this.optionsVentes.getDecrmtPrsChrStock() != null && this.optionsVentes.getDecrmtPrsChrStock().equals("2")) {
         this.reglements.setRglIdContact(var6.getBcmIdContact());
         this.reglements.setRglNomContact(var6.getVar_nomContact());
      } else {
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
      }

      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getBcmPdv());
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getBcmDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getBcmRegion());
      this.reglements.setRglSecteur(var6.getBcmSecteur());
      this.reglements.setRglSerie(var6.getBcmSerie());
      this.reglements.setRglService(var6.getBcmService());
      this.reglements.setRglSite(var6.getBcmSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getBcmIdResponsable());
      this.reglements.setRglNomResponsable(var6.getBcmNomResponsable());
      this.reglements.setRglIdCommercial(var6.getBcmIdCommercial());
      this.reglements.setRglNomCommercial(var6.getBcmNomCommercial());
      this.reglements.setRglIdEquipe(var6.getBcmIdEquipe());
      this.reglements.setRglNomEquipe(var6.getBcmNomEquipe());
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
         var6.setBcmTotReglement(var6.getBcmTotReglement() + var2);
         var6.setBcmTotTimbre(var6.getBcmTotTimbre() + var14);
         if (Math.abs(var6.getBcmTotReglement()) >= Math.abs(var6.getBcmTotTtc() + var6.getBcmTotTc())) {
            var6.setBcmSolde(1);
         } else {
            var6.setBcmSolde(0);
         }

         var6.setBcmDateLastReg(this.reglements.getRglDateReg());
         this.commandeEnteteVentesDao.modif(var6, var8);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.commandeEnteteVentes.getBcmId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.commandeEnteteVentes.setBcmTotReglement(var4);
            if (Math.abs(this.commandeEnteteVentes.getBcmTotReglement()) >= Math.abs(this.commandeEnteteVentes.getBcmTotTtc())) {
               this.commandeEnteteVentes.setBcmSolde(1);
            } else {
               this.commandeEnteteVentes.setBcmSolde(0);
            }

            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
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
      if (this.commandeEnteteVentes != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
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

            if (this.tiers.getTiedepotavance() != 0.0D) {
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
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         double var2 = 0.0D;
         String var4 = "";
         String var5 = "";
         new ArrayList();
         List var6 = this.reglementsDao.chargeRecuByNum(this.reglements.getRglNum(), this.reglements.getRglCodeCaiss(), this.reglements.getRglNatureDoc(), this.reglements.getRglDateReg(), (Session)null);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               if (var4 == null && var4.isEmpty()) {
                  var4 = ((Reglements)var6.get(var7)).getRglDocument();
                  var5 = "" + this.utilNombre.beginText(((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre(), this.structureLog.getStrformatdevise());
               } else {
                  var4 = var4 + "\n" + ((Reglements)var6.get(var7)).getRglDocument();
                  var5 = var5 + "\n" + this.utilNombre.beginText(((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre(), this.structureLog.getStrformatdevise());
               }

               var2 = var2 + ((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre();
            }

            if (var6.size() == 1) {
               var4 = null;
               var5 = null;
            }

            this.montant_lettre = this.utilNombre.begin(var2, this.reglements.getRglDevise());
            var6.clear();
            var6.add(this.reglements);
            JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(var6);
            this.utilPrint.setjRBeanCollectionDataSource(var10);
            this.utilPrint.setRapport(this.reglements.getRglModele());
            this.utilPrint.setEntete("Impression reçu");
            String var8 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod + File.separator;
            this.utilPrint.setCheminRapport(var8);
            String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport";
            this.utilPrint.setCheminSousrapport(var9);
            this.utilPrint.setImageFondPage((String)null);
            this.utilPrint.setTaux(1.0F);
            this.utilPrint.setAnnexe1(var4);
            this.utilPrint.setAnnexe2(var5);
            this.utilPrint.setPlafond(var2);
            this.utilPrint.setMontant_lettre(this.montant_lettre);
            this.utilPrint.setFormat(var1);
            this.utilPrint.setIdResponsable(this.reglements.getRglIdResponsable());
            this.utilPrint.setIdCommercial(this.reglements.getRglIdCommercial());
            this.utilPrint.setTiersSelectionne((Tiers)null);
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            this.utilPrint.setContact(this.contacts);
            this.utilPrint.setNumDoc(this.reglements.getRglNum());
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(this.reglements.getRglId());
            this.utilPrint.setParc((Parc)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public String conversionGarde() throws HibernateException, NamingException {
      String var1 = null;
      if (this.commandeEnteteVentes.getBcmGarde() != null && !this.commandeEnteteVentes.getBcmGarde().isEmpty() && this.commandeEnteteVentes.getBcmGarde().contains(":")) {
         String[] var2 = this.commandeEnteteVentes.getBcmGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.commandeEnteteVentes.getUsers(), this.structureLog, this.commandeEnteteVentes.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.commandeEnteteVentes.getBcmFormule1() != null && !this.commandeEnteteVentes.getBcmFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.commandeEnteteVentes.getBcmFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.commandeEnteteVentes.getBcmFormule2() != null && !this.commandeEnteteVentes.getBcmFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.commandeEnteteVentes.getBcmFormule2(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.commandeEnteteVentes.getBcmAnnexe1() != null && !this.commandeEnteteVentes.getBcmAnnexe1().isEmpty() && this.commandeEnteteVentes.getBcmAnnexe1().contains(":")) {
         String[] var2 = this.commandeEnteteVentes.getBcmAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.commandeEnteteVentes.getUsers(), this.structureLog, this.commandeEnteteVentes.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.commandeEnteteVentes.getBcmAnnexe2() != null && !this.commandeEnteteVentes.getBcmAnnexe2().isEmpty() && this.commandeEnteteVentes.getBcmAnnexe2().contains(":")) {
         String[] var2 = this.commandeEnteteVentes.getBcmAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.commandeEnteteVentes.getUsers(), this.structureLog, this.commandeEnteteVentes.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 6) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
      } else if (var2 == 7) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commission" + File.separator;
      } else if (var2 == 8) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "simulation" + File.separator;
      } else if (var2 == 9) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contrat" + File.separator;
      } else if (var2 == 20) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (var2 == 21) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (var2 == 22) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var2 == 23) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (var2 == 24) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var2 == 25) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var2 == 26) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var2 == 27) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var2 == 28) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
      } else if (var2 == 29) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      } else if (var2 == 140) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contratVente" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeCheminImageProduit(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatCommande.jpg");
            if (var4.exists()) {
               var3 = "formatCommande.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCommande.jpg");
         if (var4.exists()) {
            var3 = "formatCommande.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(String var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var3 = false;
         String var4 = "";
         double var5 = 0.0D;
         double var7 = 0.0D;
         this.infoOrigineDoc = "";
         ConditionnementDao var9 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();
         if (var1 != null && !var1.isEmpty() && var1.contains("Sortie")) {
            for(int var15 = 0; var15 < this.lesLignesList.size(); ++var15) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var15);
               if ((this.commandeLigneVentes.getBcmligModeGroupe() == 1 || this.commandeLigneVentes.getBcmligModeGroupe() == 2) && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                  var2.add(this.commandeLigneVentes);
               } else if (this.commandeLigneVentes.getBcmligModeGroupe() == 0 && this.commandeLigneVentes.getBcmligDepot() != null && !this.commandeLigneVentes.getBcmligDepot().isEmpty()) {
                  var2.add(this.commandeLigneVentes);
               }
            }
         } else {
            new ArrayList();
            List var11 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.commandeEnteteVentes.getBcmId(), 22, (Session)null);
            int var12;
            if (var11.size() != 0) {
               for(var12 = 0; var12 < var11.size(); ++var12) {
                  this.infoOrigineDoc = this.infoOrigineDoc + ((DocumentTraceVentes)var11.get(var12)).getDoctraOrgNum() + ", ";
               }
            }

            if (this.structureLog.getStrid() == 85L && this.commandeEnteteVentes.getBcmLieuLivraison() != null && !this.commandeEnteteVentes.getBcmLieuLivraison().isEmpty()) {
               this.commandeLigneVentes = new CommandeLigneVentes();
               this.commandeLigneVentes.setBcmligCode("INCOTERM");
               this.commandeLigneVentes.setBcmligOrdre(-1);
               this.commandeLigneVentes.setBcmligLibelle(this.commandeEnteteVentes.getBcmLieuLivraison());
               this.commandeLigneVentes.setBcmligPt(0.0D);
               this.commandeLigneVentes.setBcmligTtc(0.0D);
               this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
               var2.add(this.commandeLigneVentes);
            }

            for(var12 = 0; var12 < this.lesLignesList.size(); ++var12) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var12);
               if (this.commandeLigneVentes.getBcmligModeGroupe() != 2 || this.commandeLigneVentes.getBcmligGroupe() == null || this.commandeLigneVentes.getBcmligGroupe().isEmpty()) {
                  this.commandeLigneVentes.setVar_lib_des_condit("");
                  if (this.commandeLigneVentes.getBcmligCondition() != null && !this.commandeLigneVentes.getBcmligCondition().isEmpty() && this.commandeLigneVentes.getBcmligCondition().contains(":")) {
                     String[] var13 = this.commandeLigneVentes.getBcmligCondition().split(":");
                     Conditionnement var10 = var9.rechercheConditionnement(var13[0], (Session)null);
                     if (var10 != null) {
                        this.commandeLigneVentes.setVar_lib_des_condit(var10.getCdtDescription());
                     }
                  }

                  if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligCode().equals("-")) {
                     var3 = true;
                     var4 = this.commandeLigneVentes.getBcmligLibelle();
                  }

                  if (var3) {
                     var5 += this.commandeLigneVentes.getBcmligPt();
                     var7 = this.commandeLigneVentes.getBcmligTtc();
                  }

                  if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty() && this.commandeLigneVentes.getBcmligCode().equals("=") && var3) {
                     this.commandeLigneVentes = new CommandeLigneVentes();
                     this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
                     this.commandeLigneVentes.setBcmligCode("=");
                     this.commandeLigneVentes.setBcmligOrdre(var12);
                     this.commandeLigneVentes.setBcmligLibelle(var4);
                     this.commandeLigneVentes.setBcmligPt(var5);
                     this.commandeLigneVentes.setBcmligTtc(var7);
                     var2.add(this.commandeLigneVentes);
                     var5 = 0.0D;
                     var7 = 0.0D;
                     var3 = false;
                  } else {
                     this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
                     this.commandeLigneVentes.setBcmligOrdre(var12);
                     var2.add(this.commandeLigneVentes);
                  }
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.commandeLigneVentes = new CommandeLigneVentes();
            this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
            this.commandeLigneVentes.setBcmligCode("FORMULE1");
            this.commandeLigneVentes.setBcmligOrdre(var2.size() + 2);
            this.commandeLigneVentes.setBcmligLibelle(this.formule1());
            this.commandeLigneVentes.setBcmligPt(0.0D);
            this.commandeLigneVentes.setBcmligTtc(0.0D);
            var2.add(this.commandeLigneVentes);
            this.commandeLigneVentes = new CommandeLigneVentes();
            this.commandeLigneVentes.setCommandeEnteteVentes(this.commandeEnteteVentes);
            this.commandeLigneVentes.setBcmligCode("FORMULE2");
            this.commandeLigneVentes.setBcmligOrdre(var2.size() + 2);
            this.commandeLigneVentes.setBcmligLibelle(this.formule2());
            this.commandeLigneVentes.setBcmligPt(0.0D);
            this.commandeLigneVentes.setBcmligTtc(0.0D);
            var2.add(this.commandeLigneVentes);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.utilNombre.myRoundDevise(this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc(), this.commandeEnteteVentes.getBcmDevise()), this.commandeEnteteVentes.getBcmDevise());
      JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(var2);
      return var14;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.commandeEnteteVentes.getBcmAnal2() != null && !this.commandeEnteteVentes.getBcmAnal2().isEmpty()) {
         String var4 = "";
         if (this.commandeEnteteVentes.getBcmAnal2().contains(":")) {
            String[] var5 = this.commandeEnteteVentes.getBcmAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.commandeEnteteVentes.getBcmAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.commandeEnteteVentes.getBcmDateImp() != null && this.commandeEnteteVentes.getBcmEtat() != 0) {
            var2 = true;
         }

         this.commandeEnteteVentes.setBcmDateImp(new Date());
         if (this.commandeEnteteVentes.getBcmEtat() == 0 && this.commandeEnteteVentes.getBcmEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.commandeEnteteVentes.setBcmEtat(1);
            if (this.tiers.getTieDteDocument2() == null || this.commandeEnteteVentes.getBcmDate().after(this.tiers.getTieDteDocument2())) {
               this.tiers.setTieDteDocument2(this.commandeEnteteVentes.getBcmDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }

            if (this.lesLignesList.size() != 0) {
               for(int var5 = 0; var5 < this.lesLignesList.size(); ++var5) {
                  this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var5);
                  if (this.commandeLigneVentes.getBcmligQteUtil() == 0.0F) {
                     this.commandeLigneVentes.setBcmligQteUtil(this.commandeLigneVentes.getBcmligQte());
                     this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var3);
                  }
               }
            }
         }

         this.commandeEnteteVentes.setBcmModeleImp(var1);
         this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var3);
         this.contacts = new Contacts();
         if (this.commandeEnteteVentes.getBcmIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.commandeEnteteVentes.getBcmIdContact(), var3);
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

   public void choixDeviseImpression(String var1, float var2) {
      this.devisePrint = var1;
      this.tauxPrint = var2;
   }

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      String[] var14;
      ParcDao var15;
      String var17;
      Parc var18;
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var4));
            var1.setRapport(var4);
            var1.setEntete("Impression commande");
            var1.setPageGarde(this.conversionGarde());
            if (this.commandeEnteteVentes.getBcmFormule1() != null && !this.commandeEnteteVentes.getBcmFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            if (this.commandeEnteteVentes.getBcmFormule2() != null && !this.commandeEnteteVentes.getBcmFormule2().isEmpty()) {
               var1.setAdresseFacturation(this.formule2());
            } else {
               var1.setAdresseFacturation((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.commandeEnteteVentes.getBcmEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.commandeEnteteVentes.setBcmDevise(this.devisePrint);
            if (!this.commandeEnteteVentes.getBcmDevise().equals("XOF") && !this.commandeEnteteVentes.getBcmDevise().equals("XAF")) {
               if (this.commandeEnteteVentes.getBcmDevise().equals("EUR")) {
                  var1.setNbCar(1);
               } else {
                  var1.setNbCar(0);
               }
            } else {
               var1.setNbCar(2);
            }

            if (this.devisePrint.equals(this.structureLog.getStrdevise())) {
               var1.setTaux(1.0F);
            } else {
               var1.setTaux(this.tauxPrint);
               double var13 = this.utilNombre.myRound((this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
            var1.setIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
            var1.setTiersSelectionne(this.commandeEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNature(this.nature);
            var1.setId_doc(this.commandeEnteteVentes.getBcmId());
            if (this.commandeEnteteVentes.getBcmAnal2() != null && !this.commandeEnteteVentes.getBcmAnal2().isEmpty()) {
               var17 = "";
               if (this.commandeEnteteVentes.getBcmAnal2().contains(":")) {
                  var14 = this.commandeEnteteVentes.getBcmAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.commandeEnteteVentes.getBcmAnal2();
               }

               new Parc();
               var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               var18 = var15.rechercheParc(var17, (Session)null);
               if (var18 != null) {
                  var1.setParc(var18);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.chargerDocumentLigne((Session)null);
         }
      } else {
         JRBeanCollectionDataSource var16;
         if (var2 == 1) {
            if (var5 != null && !var5.isEmpty()) {
               var1.setRapport(var5);
               var1.setEntete("Impression de la liste des commandes");
               var1.setTotauxHt("" + this.totauxHt);
               var1.setTotauxTaxe("" + this.totauxTaxe);
               var1.setTotauxTtc("" + this.totauxTtc);
               var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "commande" + File.separator);
               var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
               var1.setFormat(var6);
               var1.setEmetteur(var7);
               var1.setDestinataire(var8);
               var1.setDestinataireCC(var9);
               var1.setDestinataireCCI(var10);
               var1.setCorpsMail(var11);
               var1.setIdResponsable(0L);
               var1.setTiersSelectionne((Tiers)null);
               var1.setNature(this.nature);
               var1.setId_doc(0L);
               var16 = new JRBeanCollectionDataSource(this.lesEntetesList);
               var1.setjRBeanCollectionDataSource(var16);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            }
         } else if (var2 == 5 && var4 != null && !var4.isEmpty()) {
            var16 = new JRBeanCollectionDataSource(this.lesCommandesReliquat);
            var1.setjRBeanCollectionDataSource(var16);
            var1.setRapport(var4);
            var1.setEntete("Impression reliquat commande");
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "reliquatBC" + File.separator);
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.commandeEnteteVentes.getBcmEtat()));
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setIdResponsable(this.commandeEnteteVentes.getBcmIdResponsable());
            var1.setIdCommercial(this.commandeEnteteVentes.getBcmIdCommercial());
            var1.setTiersSelectionne(this.commandeEnteteVentes.getTiers());
            var1.setNature(this.nature);
            var1.setId_doc(this.commandeEnteteVentes.getBcmId());
            if (this.commandeEnteteVentes.getBcmAnal2() != null && !this.commandeEnteteVentes.getBcmAnal2().isEmpty()) {
               var17 = "";
               if (this.commandeEnteteVentes.getBcmAnal2().contains(":")) {
                  var14 = this.commandeEnteteVentes.getBcmAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.commandeEnteteVentes.getBcmAnal2();
               }

               new Parc();
               var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               var18 = var15.rechercheParc(var17, (Session)null);
               if (var18 != null) {
                  var1.setParc(var18);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public boolean majDateImpressionBl(LivraisonEnteteVentes var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (var1.getBlvDateImp() != null && var1.getBlvEtat() != 0) {
            var3 = true;
         }

         var1.setBlvDateImp(new Date());
         if (var1.getBlvEtat() == 0 && var1.getBlvEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            var1.setBlvEtat(1);
         }

         var1.setBlvModeleImp(var2);
         LivraisonEnteteVentesDao var6 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var6.modif(var1, var4);
         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunBl(LivraisonEnteteVentes var1) throws IOException, HibernateException, NamingException {
      var1.setVar_numBc(this.commandeEnteteVentes.getBcmNum());
      ArrayList var2 = new ArrayList();
      new ArrayList();
      LivraisonLigneVentesDao var4 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.chargerLesLignes(var1, (Session)null);
      if (var3.size() != 0) {
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;
         this.infoOrigineDoc = "";
         ConditionnementDao var11 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();
         new LivraisonLigneVentes();

         for(int var14 = 0; var14 < var3.size(); ++var14) {
            LivraisonLigneVentes var13 = (LivraisonLigneVentes)var3.get(var14);
            if (var13.getBlvligModeGroupe() != 2 || var13.getBlvligGroupe() == null || var13.getBlvligGroupe().isEmpty()) {
               var13.setVar_lib_des_condit("");
               if (var13.getBlvligCondition() != null && !var13.getBlvligCondition().isEmpty() && var13.getBlvligCondition().contains(":")) {
                  String[] var15 = var13.getBlvligCondition().split(":");
                  Conditionnement var12 = var11.rechercheConditionnement(var15[0], (Session)null);
                  if (var12 != null) {
                     var13.setVar_lib_des_condit(var12.getCdtDescription());
                  }
               }

               if (var13.getBlvligCode() != null && !var13.getBlvligCode().isEmpty() && var13.getBlvligCode().equals("-")) {
                  var5 = true;
                  var6 = var13.getBlvligLibelle();
                  if (var6.startsWith("---> Suivant ")) {
                     this.infoOrigineDoc = var6;
                  }
               }

               if (var5) {
                  var7 += var13.getBlvligPt();
                  var9 = var13.getBlvligTtc();
               }

               if (var13.getBlvligCode() != null && !var13.getBlvligCode().isEmpty() && var13.getBlvligCode().equals("=") && var5) {
                  var13 = new LivraisonLigneVentes();
                  var13.setLivraisonEnteteVentes(var1);
                  var13.setBlvligCode("=");
                  var13.setBlvligOrdre(var14);
                  var13.setBlvligLibelle(var6);
                  var13.setBlvligPt(var7);
                  var13.setBlvligTtc(var9);
                  var2.add(var13);
                  var7 = 0.0D;
                  var9 = 0.0D;
                  var5 = false;
               } else {
                  var13.setLivraisonEnteteVentes(var1);
                  var13.setBlvligOrdre(var14);
                  var2.add(var13);
               }
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var1.getBlvTotTtc() + var1.getBlvTotTc(), var1.getBlvDevise());
      JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(var2);
      return var16;
   }

   public String conversionGardeBl(LivraisonEnteteVentes var1) throws HibernateException, NamingException {
      String var2 = null;
      if (var1.getBlvGarde() != null && !var1.getBlvGarde().isEmpty() && var1.getBlvGarde().contains(":")) {
         String[] var3 = var1.getBlvGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var5 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var4 = var5.rechercheModeles(var3[0], (Session)null);
         if (var4 != null) {
            if (var4.getModTexte().contains("[")) {
               var2 = this.utilTdt.analyseTexteCommercial(var4.getModTexte(), var1.getUsers(), this.structureLog, var1.getTiers());
            } else {
               var2 = var4.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var2 = var2 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
            }
         }
      }

      return var2;
   }

   public String formule1Bl(LivraisonEnteteVentes var1) throws HibernateException, NamingException {
      String var2 = null;
      if (var1.getBlvFormule1() != null && !var1.getBlvFormule1().isEmpty()) {
         FormulesVentesDao var3 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var2 = var3.selectFormulesVentes(var1.getBlvFormule1(), (Session)null);
      }

      return var2;
   }

   public String conversionAnnexe1Bl(LivraisonEnteteVentes var1) throws HibernateException, NamingException {
      String var2 = null;
      if (var1.getBlvAnnexe1() != null && !var1.getBlvAnnexe1().isEmpty() && var1.getBlvAnnexe1().contains(":")) {
         String[] var3 = var1.getBlvAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var5 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var4 = var5.rechercheModeles(var3[0], (Session)null);
         if (var4 != null) {
            if (var4.getModTexte().contains("[")) {
               var2 = this.utilTdt.analyseTexteCommercial(var4.getModTexte(), var1.getUsers(), this.structureLog, var1.getTiers());
            } else {
               var2 = var4.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var2 = var2 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
            }
         }
      }

      return var2;
   }

   public String conversionAnnexe2Bl(LivraisonEnteteVentes var1) throws HibernateException, NamingException {
      String var2 = null;
      if (var1.getBlvAnnexe2() != null && !var1.getBlvAnnexe2().isEmpty() && var1.getBlvAnnexe2().contains(":")) {
         String[] var3 = var1.getBlvAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var5 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var4 = var5.rechercheModeles(var3[0], (Session)null);
         if (var4 != null) {
            if (var4.getModTexte().contains("[")) {
               var2 = this.utilTdt.analyseTexteCommercial(var4.getModTexte(), var1.getUsers(), this.structureLog, var1.getTiers());
            } else {
               var2 = var4.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var6 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var2 = var2 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var6 + " alt=" + "signature /></p>";
            }
         }
      }

      return var2;
   }

   public String calculeCheminRapportBl(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      return var2;
   }

   public String calculeImageFondBl(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatLivraison.jpg");
      if (var3.exists()) {
         var2 = "formatLivraison.jpg";
      }

      return var2;
   }

   public void impressionBl(UtilPrint var1, LivraisonEnteteVentes var2, String var3, String var4) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var3 != null && !var3.isEmpty()) {
         boolean var5 = this.majDateImpressionBl(var2, var3);
         var1.setjRBeanCollectionDataSource(this.calculeImpressionCommunBl(var2));
         var1.setRapport(var3);
         var1.setEntete("Impression bon de livraison");
         var1.setMontant_lettre(this.montant_lettre);
         var1.setPageGarde(this.conversionGardeBl(var2));
         if (var2.getBlvFormule1() != null && !var2.getBlvFormule1().isEmpty()) {
            var1.setAdresseLivraison(this.formule1());
         } else {
            var1.setAdresseLivraison((String)null);
         }

         var1.setAnnexe1(this.conversionAnnexe1Bl(var2));
         var1.setAnnexe2(this.conversionAnnexe2Bl(var2));
         var1.setCheminRapport(this.calculeCheminRapportBl("structure" + this.structureLog.getStrid()));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFondBl("structure" + this.structureLog.getStrid()));
         var1.setDuplicata("" + var5);
         var1.setInfoOrigineDoc(this.infoOrigineDoc);
         var1.setNbDecQte(this.optionsVentes.getNbDecQte());
         var1.setNbDecPu(this.optionsVentes.getNbDecPu());
         var1.setFormat(var4);
         var1.setEmetteur("");
         var1.setDestinataire("");
         var1.setDestinataireCC("");
         var1.setDestinataireCCI("");
         var1.setIdResponsable(var2.getBlvIdResponsable());
         var1.setIdCommercial(var2.getBlvIdCommercial());
         var1.setTiersSelectionne(var2.getTiers());
         var1.setNature(23);
         var1.setId_doc(var2.getBlvId());
         if (var2.getBlvAnal2() != null && !var2.getBlvAnal2().isEmpty()) {
            String var6 = "";
            if (var2.getBlvAnal2().contains(":")) {
               String[] var7 = var2.getBlvAnal2().split(":");
               var6 = var7[0];
            } else {
               var6 = var2.getBlvAnal2();
            }

            new Parc();
            ParcDao var8 = new ParcDao(this.baseLog, this.utilInitHibernate);
            Parc var9 = var8.rechercheParc(var6, (Session)null);
            if (var9 != null) {
               var1.setParc(var9);
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
            this.uniteGraph = "COMMANDES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "COMMANDES : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "COMMANDES : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionsVentes.getNbDecQte());
         }

         this.titreGraph = "Analyse des ventes : ";
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
            this.sousTitreGraph = this.sousTitreGraph + " Etats: " + var2.calculeLibelleEtat(this.nature, this.inpEtat, Integer.parseInt(this.optionsVentes.getPaiementAVOIR()));
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
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par source (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 8) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par affaire (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 9) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par region (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 10) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par secteur (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 11) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par point de vente (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 12) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par site (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 13) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par departement (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 14) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par service (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 15) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par serie (" + this.uniteGraph + ")";
         }

         new CommandeEnteteVentes();
         new CommandeLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeLigne");
         String var6 = "";

         CommandeEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (CommandeEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getBcmNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getBcmNum() + "'";
            }
         }

         int var12;
         int var19;
         if (this.valQteGraph != 2 && this.modeGraph != 5 && this.modeGraph != 6) {
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

                  var14 = (CommandeEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getBcmDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getBcmNomResponsable() != null && !var14.getBcmNomResponsable().isEmpty()) {
                        var17 = var14.getBcmNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getBcmNomCommercial() != null && !var14.getBcmNomCommercial().isEmpty()) {
                        var17 = var14.getBcmNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getBcmNomEquipe() != null && !var14.getBcmNomEquipe().isEmpty()) {
                        var17 = var14.getBcmNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getBcmNomTiers() != null && !var14.getBcmNomTiers().isEmpty()) {
                        var17 = var14.getBcmNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getBcmSource() != null && !var14.getBcmSource().isEmpty()) {
                        var17 = var14.getBcmSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getBcmAnal4() != null && !var14.getBcmAnal4().isEmpty()) {
                        var17 = var14.getBcmAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getBcmRegion() != null && !var14.getBcmRegion().isEmpty()) {
                        var17 = var14.getBcmRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getBcmSecteur() != null && !var14.getBcmSecteur().isEmpty()) {
                        var17 = var14.getBcmSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getBcmPdv() != null && !var14.getBcmPdv().isEmpty()) {
                        var17 = var14.getBcmPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getBcmSite() != null && !var14.getBcmSite().isEmpty()) {
                        var17 = var14.getBcmSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getBcmDepartement() != null && !var14.getBcmDepartement().isEmpty()) {
                        var17 = var14.getBcmDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getBcmService() != null && !var14.getBcmService().isEmpty()) {
                        var17 = var14.getBcmService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getBcmSerie() != null && !var14.getBcmSerie().isEmpty()) {
                        var17 = var14.getBcmSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getBcmTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getBcmDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getBcmDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getBcmDate().getMonth() + 1 >= 1 && var14.getBcmDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getBcmDate().getMonth() + 1 >= 4 && var14.getBcmDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getBcmDate().getMonth() + 1 >= 7 && var14.getBcmDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getBcmDate().getMonth() + 1 >= 10 && var14.getBcmDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getBcmDate().getMonth() + 1 >= 1 && var14.getBcmDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getBcmDate().getMonth() + 1 >= 7 && var14.getBcmDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getBcmDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.commandeLigneVentesDao.chargerLesLignesCommandes(var6, var5);
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

                  CommandeLigneVentes var15 = (CommandeLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getCommandeEnteteVentes().getBcmDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getCommandeEnteteVentes().getBcmNomResponsable() != null && !var15.getCommandeEnteteVentes().getBcmNomResponsable().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getCommandeEnteteVentes().getBcmNomCommercial() != null && !var15.getCommandeEnteteVentes().getBcmNomCommercial().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getCommandeEnteteVentes().getBcmNomEquipe() != null && !var15.getCommandeEnteteVentes().getBcmNomEquipe().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getCommandeEnteteVentes().getBcmNomTiers() != null && !var15.getCommandeEnteteVentes().getBcmNomTiers().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getBcmligFamille() != null && !var15.getBcmligFamille().isEmpty()) {
                        var8 = var15.getBcmligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getBcmligLibelle() != null && !var15.getBcmligLibelle().isEmpty()) {
                        var8 = var15.getBcmligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getCommandeEnteteVentes().getBcmSource() != null && !var15.getCommandeEnteteVentes().getBcmSource().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getCommandeEnteteVentes().getBcmAnal4() != null && !var15.getCommandeEnteteVentes().getBcmAnal4().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getCommandeEnteteVentes().getBcmRegion() != null && !var15.getCommandeEnteteVentes().getBcmRegion().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getCommandeEnteteVentes().getBcmSecteur() != null && !var15.getCommandeEnteteVentes().getBcmSecteur().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getCommandeEnteteVentes().getBcmPdv() != null && !var15.getCommandeEnteteVentes().getBcmPdv().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getCommandeEnteteVentes().getBcmSite() != null && !var15.getCommandeEnteteVentes().getBcmSite().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getCommandeEnteteVentes().getBcmDepartement() != null && !var15.getCommandeEnteteVentes().getBcmDepartement().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getCommandeEnteteVentes().getBcmService() != null && !var15.getCommandeEnteteVentes().getBcmService().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getCommandeEnteteVentes().getBcmSerie() != null && !var15.getCommandeEnteteVentes().getBcmSerie().isEmpty()) {
                        var8 = var15.getCommandeEnteteVentes().getBcmSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getBcmligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getBcmligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getCommandeEnteteVentes().getBcmDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 >= 1 && var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 >= 4 && var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 >= 7 && var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 >= 10 && var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 >= 1 && var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 >= 7 && var15.getCommandeEnteteVentes().getBcmDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getCommandeEnteteVentes().getBcmDate().getHours();
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

   public void initImpressionPlanning() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      this.nomModeleDocument = "";
      this.recupererModeleListe();
      this.showModalPanelPrintPlanning = true;
   }

   public void fermerPrintPlanning() {
      this.showModalPanelPrintPlanning = false;
   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.modeRdv == 0) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "mois" + File.separator;
      } else if (this.modeRdv == 1) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "semaine" + File.separator;
      } else if (this.modeRdv == 2) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "jour" + File.separator;
      } else if (this.modeRdv == 3) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "liste" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.planningImpressionsItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.planningImpressionsItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void imprimerPRTPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerPlanning();
   }

   public void imprimerJRVPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerPlanning();
   }

   public void imprimerPDFPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerPlanning();
   }

   public void imprimerODTPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerPlanning();
   }

   public void imprimerXLSPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerPlanning();
   }

   public void imprimerDOCPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerPlanning();
   }

   public void imprimerHTMLPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerPlanning();
   }

   public void imprimerXMLPlanning() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerPlanning();
   }

   public String calculeCheminRapport(String var1) {
      String var2 = "";
      if (this.modeRdv == 0) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "mois" + File.separator;
      } else if (this.modeRdv == 1) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "semaine" + File.separator;
      } else if (this.modeRdv == 2) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "jour" + File.separator;
      } else if (this.modeRdv == 3) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "planning" + File.separator + "commande" + File.separator + "liste" + File.separator;
      }

      return var2;
   }

   public void imprimerPlanning() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setCheminRapport(this.calculeCheminRapport(this.baseLog));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
         this.utilPrint.setEntete("Planning des commandes en production");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setFiltre(this.calculFiltre());
         this.utilPrint.setEmetteur((String)null);
         this.utilPrint.setDestinataire((String)null);
         this.utilPrint.setDestinataireCC((String)null);
         this.utilPrint.setDestinataireCCI((String)null);
         this.utilPrint.setImageFondPage((String)null);
         this.utilPrint.setIdResponsable(this.usersLog.getUsrid());
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var1 = null;
         String var2 = "";
         ArrayList var3;
         int var5;
         if (this.modeRdv == 0) {
            var3 = new ArrayList();
            if (this.listRdvMois.size() != 0) {
               for(int var7 = 0; var7 < this.listRdvMois.size(); ++var7) {
                  this.rdvSemaine = (RdvSemaine)this.listRdvMois.get(var7);
                  var2 = "";
                  if (this.rdvSemaine.getLundi() != null && !this.rdvSemaine.getLundi().isEmpty() && this.rdvSemaine.getLesCmdJourLundi().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourLundi().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourLundi().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol01(var2);
                  var2 = "";
                  if (this.rdvSemaine.getMardi() != null && !this.rdvSemaine.getMardi().isEmpty() && this.rdvSemaine.getLesCmdJourMardi().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourMardi().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourMardi().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol02(var2);
                  var2 = "";
                  if (this.rdvSemaine.getMercredi() != null && !this.rdvSemaine.getMercredi().isEmpty() && this.rdvSemaine.getLesCmdJourMercredi().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourMercredi().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourMercredi().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol03(var2);
                  var2 = "";
                  if (this.rdvSemaine.getJeudi() != null && !this.rdvSemaine.getJeudi().isEmpty() && this.rdvSemaine.getLesCmdJourJeudi().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourJeudi().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourJeudi().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol04(var2);
                  var2 = "";
                  if (this.rdvSemaine.getVendredi() != null && !this.rdvSemaine.getVendredi().isEmpty() && this.rdvSemaine.getLesCmdJourVendredi().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourVendredi().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourVendredi().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol05(var2);
                  var2 = "";
                  if (this.rdvSemaine.getSamedi() != null && !this.rdvSemaine.getSamedi().isEmpty() && this.rdvSemaine.getLesCmdJourSamedi().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourSamedi().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourSamedi().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol06(var2);
                  var2 = "";
                  if (this.rdvSemaine.getDimanche() != null && !this.rdvSemaine.getDimanche().isEmpty() && this.rdvSemaine.getLesCmdJourDimanche().size() != 0) {
                     for(var5 = 0; var5 < this.rdvSemaine.getLesCmdJourDimanche().size(); ++var5) {
                        this.commandeEnteteVentes = (CommandeEnteteVentes)this.rdvSemaine.getLesCmdJourDimanche().get(var5);
                        var2 = var2 + this.commandeEnteteVentes.getVar_nom_tiers() + " " + this.commandeEnteteVentes.getBcmObject() + " " + this.commandeEnteteVentes.getBcmNum() + "\n" + "Ctn.:" + this.commandeEnteteVentes.getBcmNomContact() + "\n" + "Agt.:" + this.commandeEnteteVentes.getBcmNomResponsable() + "\n";
                     }
                  }

                  this.rdvSemaine.setImpcol07(var2);
                  var3.add(this.rdvSemaine);
               }
            }

            var1 = new JRBeanCollectionDataSource(var3);
         } else if (this.modeRdv == 1) {
            var3 = new ArrayList();
            if (this.listRdvSemaine.size() != 0) {
               boolean var6 = false;

               for(var5 = 0; var5 < this.listRdvSemaine.size(); ++var5) {
                  this.rdvSemaine = (RdvSemaine)this.listRdvSemaine.get(var5);
                  this.rdvSemaine.setImpcol01(this.dateLun);
                  this.rdvSemaine.setImpcol02(this.dateMar);
                  this.rdvSemaine.setImpcol03(this.dateMer);
                  this.rdvSemaine.setImpcol04(this.dateJeu);
                  this.rdvSemaine.setImpcol05(this.dateVen);
                  this.rdvSemaine.setImpcol06(this.dateSam);
                  this.rdvSemaine.setImpcol07(this.dateDim);
                  var6 = false;
                  if (this.rdvSemaine.getLundi() != null && !this.rdvSemaine.getLundi().isEmpty()) {
                     var6 = true;
                  } else if (this.rdvSemaine.getMardi() != null && !this.rdvSemaine.getMardi().isEmpty()) {
                     var6 = true;
                  } else if (this.rdvSemaine.getMercredi() != null && !this.rdvSemaine.getMercredi().isEmpty()) {
                     var6 = true;
                  } else if (this.rdvSemaine.getJeudi() != null && !this.rdvSemaine.getJeudi().isEmpty()) {
                     var6 = true;
                  } else if (this.rdvSemaine.getVendredi() != null && !this.rdvSemaine.getVendredi().isEmpty()) {
                     var6 = true;
                  } else if (this.rdvSemaine.getSamedi() != null && !this.rdvSemaine.getSamedi().isEmpty()) {
                     var6 = true;
                  } else if (this.rdvSemaine.getDimanche() != null && !this.rdvSemaine.getDimanche().isEmpty()) {
                     var6 = true;
                  }

                  if (var6) {
                     var3.add(this.rdvSemaine);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var3);
         } else if (this.modeRdv != 2) {
            if (this.modeRdv == 3) {
               var1 = new JRBeanCollectionDataSource(this.listRdv);
            }
         } else {
            var3 = new ArrayList();
            if (this.listRdvJour.size() != 0) {
               new CommandeEnteteVentes();

               for(var5 = 0; var5 < this.listRdvJour.size(); ++var5) {
                  CommandeEnteteVentes var4 = (CommandeEnteteVentes)this.listRdvJour.get(var5);
                  if (var4.getBcmNomTiers() != null && !var4.getBcmNomTiers().isEmpty()) {
                     var3.add(var4);
                  }
               }
            }

            var1 = new JRBeanCollectionDataSource(var3);
         }

         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public String calculFiltre() {
      this.filtre = "";
      if (this.modeRdv == 0) {
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         this.filtre = "Mois de " + var1 + ":" + (this.parMois.getYear() + 1900);
      } else if (this.modeRdv == 1) {
         this.filtre = "Semaine du " + this.dateLun + " au " + this.dateDim;
      } else if (this.modeRdv == 2) {
         this.filtre = "Journée du " + this.utilDate.dateToStringFr(this.parJour);
      } else if (this.modeRdv == 3) {
         this.filtre = "Période du " + this.utilDate.dateToStringFr(this.jourDeb) + " au " + this.utilDate.dateToStringFr(this.jourFin);
      }

      return this.filtre;
   }

   public void accesPiecesJointes() throws HibernateException, NamingException {
      this.lesPiecesJointes.clear();
      if (this.commandeEnteteVentes != null) {
         String var1 = this.commandeEnteteVentes.getBcmNum().replace("/", "_") + "_";
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
      this.showModalPanelAjoutFile = true;
   }

   public void annulerPieceJointe() {
      this.showModalPanelAjoutFile = false;
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
                        var1 = this.commandeEnteteVentes.getBcmNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomPiecesJointes) + "." + var8;
                     } else {
                        var1 = this.commandeEnteteVentes.getBcmNum().replace("/", "_") + "." + var8;
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
                     this.commandeEnteteVentes.setBcmPj(true);
                  } else {
                     this.commandeEnteteVentes.setBcmPj(false);
                  }

                  this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
               }
            }
         }
      } catch (IOException var7) {
      }

      this.showModalPanelAjoutFile = false;
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
         this.commandeEnteteVentes.setBcmPj(true);
      } else {
         this.commandeEnteteVentes.setBcmPj(false);
      }

      this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes);
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

   public void selectionTracabilite() {
      if (this.datamodelDocumentTrace.isRowAvailable()) {
         this.documentTraceVentes = (DocumentTraceVentes)this.datamodelDocumentTrace.getRowData();
      }

   }

   public void voirOrigine() throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceVentes == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceVentes != null) {
         this.voirCommun(this.documentTraceVentes.getDoctraOrgType(), this.documentTraceVentes.getDoctraOrgId(), this.documentTraceVentes.getDoctraOrgNum(), this.documentTraceVentes.getDoctraOrgSerie());
      }

   }

   public void voirDestination() throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceVentes == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceVentes != null) {
         this.voirCommun(this.documentTraceVentes.getDoctraDstType(), this.documentTraceVentes.getDoctraDstId(), this.documentTraceVentes.getDoctraDstNum(), this.documentTraceVentes.getDoctraDstSerie());
      }

   }

   public void voirCommun(int var1, long var2, String var4, String var5) throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceVentes == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceVentes != null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         String var7;
         if (var1 == 21) {
            FormDevisVentes var6 = new FormDevisVentes();
            var6.setBaseLog(this.baseLog);
            var6.setStructureLog(this.structureLog);
            var6.setUsersLog(this.usersLog);
            var6.setutilInitHibernate(this.utilInitHibernate);
            var6.InstancesDaoUtilses();
            var6.rechercheDOCUMENT(var2);
            if (var6.getDevisEnteteVentes() != null) {
               var6.setExercicesVentes(var6.getDevisEnteteVentes().getExerciceventes());
               var7 = var6.getDevisEnteteVentes().getDvsModeleImp();
               var6.setOptionsVentes(this.optionsVentes);
               var6.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var6.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le Devis n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le Devis n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 22) {
            FormCommandeVentes var8 = new FormCommandeVentes();
            var8.setBaseLog(this.baseLog);
            var8.setStructureLog(this.structureLog);
            var8.setUsersLog(this.usersLog);
            var8.setutilInitHibernate(this.utilInitHibernate);
            var8.InstancesDaoUtilses();
            var8.rechercheDOCUMENT(var2);
            if (var8.getCommandeEnteteVentes() != null) {
               var8.setExercicesVentes(var8.getCommandeEnteteVentes().getExerciceventes());
               var7 = var8.getCommandeEnteteVentes().getBcmModeleImp();
               var8.setOptionsVentes(this.optionsVentes);
               var8.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var8.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le BC n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le BC n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 23) {
            FormLivraisonVentes var9 = new FormLivraisonVentes();
            var9.setBaseLog(this.baseLog);
            var9.setStructureLog(this.structureLog);
            var9.setUsersLog(this.usersLog);
            var9.setutilInitHibernate(this.utilInitHibernate);
            var9.InstancesDaoUtilses();
            var9.rechercheDOCUMENT(var2);
            if (var9.getLivraisonEnteteVentes() != null) {
               var9.setExercicesVentes(var9.getLivraisonEnteteVentes().getExerciceventes());
               var7 = var9.getLivraisonEnteteVentes().getBlvModeleImp();
               var9.setOptionsVentes(this.optionsVentes);
               var9.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var9.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le BL n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le BL n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 24) {
            FormRetourVentes var10 = new FormRetourVentes();
            var10.setBaseLog(this.baseLog);
            var10.setStructureLog(this.structureLog);
            var10.setUsersLog(this.usersLog);
            var10.setutilInitHibernate(this.utilInitHibernate);
            var10.InstancesDaoUtilses();
            var10.rechercheDOCUMENT(var2);
            if (var10.getRetourEnteteVentes() != null) {
               var10.setExercicesVentes(var10.getRetourEnteteVentes().getExerciceventes());
               var7 = var10.getRetourEnteteVentes().getBrtModeleImp();
               var10.setOptionsVentes(this.optionsVentes);
               var10.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var10.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 25) {
            FormFactureVentes var11 = new FormFactureVentes();
            var11.setBaseLog(this.baseLog);
            var11.setStructureLog(this.structureLog);
            var11.setUsersLog(this.usersLog);
            var11.setutilInitHibernate(this.utilInitHibernate);
            var11.InstancesDaoUtilses();
            var11.rechercheDOCUMENT(var2);
            if (var11.getFactureEnteteVentes() != null) {
               var11.setExercicesVentes(var11.getFactureEnteteVentes().getExerciceventes());
               var7 = var11.getFactureEnteteVentes().getFacModeleImp();
               var11.setOptionsVentes(this.optionsVentes);
               var11.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var11.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 26) {
            FormAvoirVentes var12 = new FormAvoirVentes();
            var12.setBaseLog(this.baseLog);
            var12.setStructureLog(this.structureLog);
            var12.setUsersLog(this.usersLog);
            var12.setutilInitHibernate(this.utilInitHibernate);
            var12.InstancesDaoUtilses();
            var12.rechercheDOCUMENT(var2);
            if (var12.getAvoirEnteteVentes() != null) {
               var12.setExercicesVentes(var12.getAvoirEnteteVentes().getExerciceventes());
               var7 = var12.getAvoirEnteteVentes().getAvrModeleImp();
               var12.setOptionsVentes(this.optionsVentes);
               var12.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var12.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 27) {
            FormNoteDebitVentes var13 = new FormNoteDebitVentes();
            var13.setBaseLog(this.baseLog);
            var13.setStructureLog(this.structureLog);
            var13.setUsersLog(this.usersLog);
            var13.setutilInitHibernate(this.utilInitHibernate);
            var13.InstancesDaoUtilses();
            var13.rechercheDOCUMENT(var2);
            if (var13.getNoteDebitEnteteVentes() != null) {
               var13.setExercicesVentes(var13.getNoteDebitEnteteVentes().getExerciceventes());
               var7 = var13.getNoteDebitEnteteVentes().getNdbModeleImp();
               var13.setOptionsVentes(this.optionsVentes);
               var13.setNature(var1);
               if (var7 != null && !var7.isEmpty()) {
                  var13.impression(this.utilPrint, 0, 0, var7, "", "PDF", "", "", "", "", "");
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

   public void recalculTva(CommandeEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.commandeEnteteVentes = var1;
         this.tiers = this.commandeEnteteVentes.getTiers();
         if (this.tiers.getTiecss() == 0 && this.structureLog.getStrcodepays().equals("0077")) {
            this.var_tc_calcul = true;
            this.var_tc_taux = 1.0F;
            this.var_tc_type = 7;
         } else {
            this.var_tc_calcul = false;
            this.var_tc_taux = 0.0F;
            this.var_tc_type = 0;
         }

         this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var2);
               }

               this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var2);
            }

            this.cumulPrix();
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var2);
         }
      }

   }

   public void recalculCss(CommandeEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.commandeEnteteVentes = var1;
         this.tiers = this.commandeEnteteVentes.getTiers();
         this.lesLignesList = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.commandeLigneVentes = (CommandeLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.commandeLigneVentes.getBcmligCode() != null && !this.commandeLigneVentes.getBcmligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.commandeLigneVentes.getBcmligCode(), var2);
               }

               this.calculPrix(this.commandeLigneVentes.getBcmligTaxe(), this.commandeLigneVentes.getBcmligTauxTaxe(), var2);
               this.commandeLigneVentes = this.commandeLigneVentesDao.modifLigne(this.commandeLigneVentes, var2);
            }

            this.cumulPrix();
            this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var2);
         }
      }

   }

   public boolean isAccesProduits() {
      return this.accesProduits;
   }

   public void setAccesProduits(boolean var1) {
      this.accesProduits = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public boolean isContDest() {
      return this.contDest;
   }

   public void setContDest(boolean var1) {
      this.contDest = var1;
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

   public CommandeEnteteVentes getCommandeEnteteVentes() {
      return this.commandeEnteteVentes;
   }

   public void setCommandeEnteteVentes(CommandeEnteteVentes var1) {
      this.commandeEnteteVentes = var1;
   }

   public CommandeLigneVentes getCommandeLigneVentes() {
      return this.commandeLigneVentes;
   }

   public void setCommandeLigneVentes(CommandeLigneVentes var1) {
      this.commandeLigneVentes = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
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

   public String getInpClient() {
      return this.inpClient;
   }

   public void setInpClient(String var1) {
      this.inpClient = var1;
   }

   public String getInpDestinataire() {
      return this.inpDestinataire;
   }

   public void setInpDestinataire(String var1) {
      this.inpDestinataire = var1;
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

   public List getMesTaxesVentesItems() {
      return this.mesTaxesVentesItems;
   }

   public void setMesTaxesVentesItems(List var1) {
      this.mesTaxesVentesItems = var1;
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

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_dre() {
      return this.var_acc_dre;
   }

   public void setVar_acc_dre(boolean var1) {
      this.var_acc_dre = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_exoneration() {
      return this.var_acc_exoneration;
   }

   public void setVar_acc_exoneration(boolean var1) {
      this.var_acc_exoneration = var1;
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

   public String getVar_libcondest() {
      return this.var_libcondest;
   }

   public void setVar_libcondest(String var1) {
      this.var_libcondest = var1;
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

   public boolean isVar_pr_pv() {
      return this.var_pr_pv;
   }

   public void setVar_pr_pv(boolean var1) {
      this.var_pr_pv = var1;
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

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
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

   public List getMesTaxesVentesProduits() {
      return this.mesTaxesVentesProduits;
   }

   public void setMesTaxesVentesProduits(List var1) {
      this.mesTaxesVentesProduits = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public ExercicesVentes getLastExoVentes() {
      return this.lastExoVentes;
   }

   public void setLastExoVentes(ExercicesVentes var1) {
      this.lastExoVentes = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
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

   public boolean isShowModalPanelAnnule() {
      return this.showModalPanelAnnule;
   }

   public void setShowModalPanelAnnule(boolean var1) {
      this.showModalPanelAnnule = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public boolean isShowModalPanelValidationDocument() {
      return this.showModalPanelValidationDocument;
   }

   public void setShowModalPanelValidationDocument(boolean var1) {
      this.showModalPanelValidationDocument = var1;
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

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
   }

   public boolean isVerrou_libelle() {
      return this.verrou_libelle;
   }

   public void setVerrou_libelle(boolean var1) {
      this.verrou_libelle = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
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

   public boolean isAffichagePlancher() {
      return this.affichagePlancher;
   }

   public void setAffichagePlancher(boolean var1) {
      this.affichagePlancher = var1;
   }

   public double getPrixPlancher() {
      return this.prixPlancher;
   }

   public void setPrixPlancher(double var1) {
      this.prixPlancher = var1;
   }

   public boolean isGriserValider() {
      return this.griserValider;
   }

   public void setGriserValider(boolean var1) {
      this.griserValider = var1;
   }

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public double getVar_total_marge() {
      return this.var_total_marge;
   }

   public void setVar_total_marge(double var1) {
      this.var_total_marge = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesCommercialItem() {
      return this.mesCommercialItem;
   }

   public void setMesCommercialItem(List var1) {
      this.mesCommercialItem = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public String getInpCommercial() {
      return this.inpCommercial;
   }

   public void setInpCommercial(String var1) {
      this.inpCommercial = var1;
   }

   public List getLesModeReglementClientsListe() {
      return this.lesModeReglementClientsListe;
   }

   public void setLesModeReglementClientsListe(List var1) {
      this.lesModeReglementClientsListe = var1;
   }

   public boolean isShowModalPanelReliquat() {
      return this.showModalPanelReliquat;
   }

   public void setShowModalPanelReliquat(boolean var1) {
      this.showModalPanelReliquat = var1;
   }

   public DataModel getDataModelReliquat() {
      return this.dataModelReliquat;
   }

   public void setDataModelReliquat(DataModel var1) {
      this.dataModelReliquat = var1;
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

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
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

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public List getLesDocumentsReliquatItem() {
      return this.lesDocumentsReliquatItem;
   }

   public void setLesDocumentsReliquatItem(List var1) {
      this.lesDocumentsReliquatItem = var1;
   }

   public boolean isShowModalPanelPrintReliquat() {
      return this.showModalPanelPrintReliquat;
   }

   public void setShowModalPanelPrintReliquat(boolean var1) {
      this.showModalPanelPrintReliquat = var1;
   }

   public boolean isVerifBareme() {
      return this.verifBareme;
   }

   public void setVerifBareme(boolean var1) {
      this.verifBareme = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isAccesAffaires() {
      return this.accesAffaires;
   }

   public void setAccesAffaires(boolean var1) {
      this.accesAffaires = var1;
   }

   public List getMesAffairesItems() {
      return this.mesAffairesItems;
   }

   public void setMesAffairesItems(List var1) {
      this.mesAffairesItems = var1;
   }

   public String getNumeroPfManuel() {
      return this.numeroPfManuel;
   }

   public void setNumeroPfManuel(String var1) {
      this.numeroPfManuel = var1;
   }

   public String getVar_motif_annule() {
      return this.var_motif_annule;
   }

   public void setVar_motif_annule(String var1) {
      this.var_motif_annule = var1;
   }

   public boolean isShowModalPanelAnnuleValider() {
      return this.showModalPanelAnnuleValider;
   }

   public void setShowModalPanelAnnuleValider(boolean var1) {
      this.showModalPanelAnnuleValider = var1;
   }

   public int getModeRdv() {
      return this.modeRdv;
   }

   public void setModeRdv(int var1) {
      this.modeRdv = var1;
   }

   public Date getParJour() {
      return this.parJour;
   }

   public void setParJour(Date var1) {
      this.parJour = var1;
   }

   public Date getParMois() {
      return this.parMois;
   }

   public void setParMois(Date var1) {
      this.parMois = var1;
   }

   public Date getParSemaine() {
      return this.parSemaine;
   }

   public void setParSemaine(Date var1) {
      this.parSemaine = var1;
   }

   public int getValNatJour() {
      return this.valNatJour;
   }

   public void setValNatJour(int var1) {
      this.valNatJour = var1;
   }

   public int getValNatListe() {
      return this.valNatListe;
   }

   public void setValNatListe(int var1) {
      this.valNatListe = var1;
   }

   public int getValNatMois() {
      return this.valNatMois;
   }

   public void setValNatMois(int var1) {
      this.valNatMois = var1;
   }

   public int getValNatSemaine() {
      return this.valNatSemaine;
   }

   public void setValNatSemaine(int var1) {
      this.valNatSemaine = var1;
   }

   public DataModel getDatamodelLesRdvParJour() {
      return this.datamodelLesRdvParJour;
   }

   public void setDatamodelLesRdvParJour(DataModel var1) {
      this.datamodelLesRdvParJour = var1;
   }

   public DataModel getDatamodelLesRdvParMois() {
      return this.datamodelLesRdvParMois;
   }

   public void setDatamodelLesRdvParMois(DataModel var1) {
      this.datamodelLesRdvParMois = var1;
   }

   public DataModel getDatamodelLesRdvParSemaine() {
      return this.datamodelLesRdvParSemaine;
   }

   public void setDatamodelLesRdvParSemaine(DataModel var1) {
      this.datamodelLesRdvParSemaine = var1;
   }

   public DataModel getDatamodelRdv() {
      return this.datamodelRdv;
   }

   public void setDatamodelRdv(DataModel var1) {
      this.datamodelRdv = var1;
   }

   public boolean isShowModalPanelPlanning() {
      return this.showModalPanelPlanning;
   }

   public void setShowModalPanelPlanning(boolean var1) {
      this.showModalPanelPlanning = var1;
   }

   public String getDateDim() {
      return this.dateDim;
   }

   public void setDateDim(String var1) {
      this.dateDim = var1;
   }

   public String getDateJeu() {
      return this.dateJeu;
   }

   public void setDateJeu(String var1) {
      this.dateJeu = var1;
   }

   public String getDateLun() {
      return this.dateLun;
   }

   public void setDateLun(String var1) {
      this.dateLun = var1;
   }

   public String getDateMar() {
      return this.dateMar;
   }

   public void setDateMar(String var1) {
      this.dateMar = var1;
   }

   public String getDateMer() {
      return this.dateMer;
   }

   public void setDateMer(String var1) {
      this.dateMer = var1;
   }

   public String getDateSam() {
      return this.dateSam;
   }

   public void setDateSam(String var1) {
      this.dateSam = var1;
   }

   public String getDateVen() {
      return this.dateVen;
   }

   public void setDateVen(String var1) {
      this.dateVen = var1;
   }

   public boolean isAfficheRdv() {
      return this.afficheRdv;
   }

   public void setAfficheRdv(boolean var1) {
      this.afficheRdv = var1;
   }

   public Date getJourDeb() {
      return this.jourDeb;
   }

   public void setJourDeb(Date var1) {
      this.jourDeb = var1;
   }

   public Date getJourFin() {
      return this.jourFin;
   }

   public void setJourFin(Date var1) {
      this.jourFin = var1;
   }

   public List getPlanningImpressionsItems() {
      return this.planningImpressionsItems;
   }

   public void setPlanningImpressionsItems(List var1) {
      this.planningImpressionsItems = var1;
   }

   public boolean isShowModalPanelPrintPlanning() {
      return this.showModalPanelPrintPlanning;
   }

   public void setShowModalPanelPrintPlanning(boolean var1) {
      this.showModalPanelPrintPlanning = var1;
   }

   public int getInpMode() {
      return this.inpMode;
   }

   public void setInpMode(int var1) {
      this.inpMode = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public int getValStatutJour() {
      return this.valStatutJour;
   }

   public void setValStatutJour(int var1) {
      this.valStatutJour = var1;
   }

   public int getValStatutListe() {
      return this.valStatutListe;
   }

   public void setValStatutListe(int var1) {
      this.valStatutListe = var1;
   }

   public int getValStatutMois() {
      return this.valStatutMois;
   }

   public void setValStatutMois(int var1) {
      this.valStatutMois = var1;
   }

   public int getValStatutSemaine() {
      return this.valStatutSemaine;
   }

   public void setValStatutSemaine(int var1) {
      this.valStatutSemaine = var1;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public boolean isVar_contener_parc() {
      return this.var_contener_parc;
   }

   public void setVar_contener_parc(boolean var1) {
      this.var_contener_parc = var1;
   }

   public String getInpContener() {
      return this.inpContener;
   }

   public void setInpContener(String var1) {
      this.inpContener = var1;
   }

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public boolean isCompteRendu() {
      return this.compteRendu;
   }

   public void setCompteRendu(boolean var1) {
      this.compteRendu = var1;
   }

   public Rdv getRdv() {
      return this.rdv;
   }

   public void setRdv(Rdv var1) {
      this.rdv = var1;
   }

   public boolean isRdvdetails() {
      return this.rdvdetails;
   }

   public void setRdvdetails(boolean var1) {
      this.rdvdetails = var1;
   }

   public List getMesCaissesSeriesItems() {
      return this.mesCaissesSeriesItems;
   }

   public void setMesCaissesSeriesItems(List var1) {
      this.mesCaissesSeriesItems = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public List getMesTypeReglementsCaisse() {
      return this.mesTypeReglementsCaisse;
   }

   public void setMesTypeReglementsCaisse(List var1) {
      this.mesTypeReglementsCaisse = var1;
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

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public boolean isReglementAutorise() {
      return this.reglementAutorise;
   }

   public void setReglementAutorise(boolean var1) {
      this.reglementAutorise = var1;
   }

   public boolean isShowModalPanelPrintRecu() {
      return this.showModalPanelPrintRecu;
   }

   public void setShowModalPanelPrintRecu(boolean var1) {
      this.showModalPanelPrintRecu = var1;
   }

   public long getInpIdTiersEnCours() {
      return this.inpIdTiersEnCours;
   }

   public void setInpIdTiersEnCours(long var1) {
      this.inpIdTiersEnCours = var1;
   }

   public String getInpNomDestinataire() {
      return this.inpNomDestinataire;
   }

   public void setInpNomDestinataire(String var1) {
      this.inpNomDestinataire = var1;
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

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
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

   public DataModel getDataModelPieceJointes() {
      return this.dataModelPieceJointes;
   }

   public void setDataModelPieceJointes(DataModel var1) {
      this.dataModelPieceJointes = var1;
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

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public FileCtrl getFileCtrl() {
      return this.fileCtrl;
   }

   public void setFileCtrl(FileCtrl var1) {
      this.fileCtrl = var1;
   }

   public Date getVar_date_remise() {
      return this.var_date_remise;
   }

   public void setVar_date_remise(Date var1) {
      this.var_date_remise = var1;
   }

   public boolean isShowModalPanelGele() {
      return this.showModalPanelGele;
   }

   public void setShowModalPanelGele(boolean var1) {
      this.showModalPanelGele = var1;
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

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public String getInpPdv() {
      return this.inpPdv;
   }

   public void setInpPdv(String var1) {
      this.inpPdv = var1;
   }

   public String getInpRegion() {
      return this.inpRegion;
   }

   public void setInpRegion(String var1) {
      this.inpRegion = var1;
   }

   public String getInpSecteur() {
      return this.inpSecteur;
   }

   public void setInpSecteur(String var1) {
      this.inpSecteur = var1;
   }

   public String getInpDepartement() {
      return this.inpDepartement;
   }

   public void setInpDepartement(String var1) {
      this.inpDepartement = var1;
   }

   public String getInpSite() {
      return this.inpSite;
   }

   public void setInpSite(String var1) {
      this.inpSite = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public boolean isPlafondAutorise() {
      return this.plafondAutorise;
   }

   public void setPlafondAutorise(boolean var1) {
      this.plafondAutorise = var1;
   }

   public String getLibelleRabRis() {
      return this.libelleRabRis;
   }

   public void setLibelleRabRis(String var1) {
      this.libelleRabRis = var1;
   }

   public boolean isRistourne() {
      return this.ristourne;
   }

   public void setRistourne(boolean var1) {
      this.ristourne = var1;
   }

   public DataModel getDataModelEcriture() {
      return this.dataModelEcriture;
   }

   public void setDataModelEcriture(DataModel var1) {
      this.dataModelEcriture = var1;
   }

   public String getVar_tc_libelle() {
      return this.var_tc_libelle;
   }

   public void setVar_tc_libelle(String var1) {
      this.var_tc_libelle = var1;
   }

   public float getVar_tc_taux() {
      return this.var_tc_taux;
   }

   public void setVar_tc_taux(float var1) {
      this.var_tc_taux = var1;
   }

   public int getVar_tc_type() {
      return this.var_tc_type;
   }

   public void setVar_tc_type(int var1) {
      this.var_tc_type = var1;
   }

   public boolean isVar_tc_calcul() {
      return this.var_tc_calcul;
   }

   public void setVar_tc_calcul(boolean var1) {
      this.var_tc_calcul = var1;
   }

   public String getInpNumBCC() {
      return this.inpNumBCC;
   }

   public void setInpNumBCC(String var1) {
      this.inpNumBCC = var1;
   }

   public String getInpNumAnal() {
      return this.inpNumAnal;
   }

   public void setInpNumAnal(String var1) {
      this.inpNumAnal = var1;
   }

   public boolean isShowModalPanelModifDateLiv() {
      return this.showModalPanelModifDateLiv;
   }

   public void setShowModalPanelModifDateLiv(boolean var1) {
      this.showModalPanelModifDateLiv = var1;
   }

   public boolean isShowModalPanelModifBCC() {
      return this.showModalPanelModifBCC;
   }

   public void setShowModalPanelModifBCC(boolean var1) {
      this.showModalPanelModifBCC = var1;
   }

   public boolean isAutorisationAppelFonds() {
      return this.autorisationAppelFonds;
   }

   public void setAutorisationAppelFonds(boolean var1) {
      this.autorisationAppelFonds = var1;
   }

   public boolean isShowModalPanelAppelFonds() {
      return this.showModalPanelAppelFonds;
   }

   public void setShowModalPanelAppelFonds(boolean var1) {
      this.showModalPanelAppelFonds = var1;
   }

   public float getValAppelfonds() {
      return this.valAppelfonds;
   }

   public void setValAppelfonds(float var1) {
      this.valAppelfonds = var1;
   }

   public double getTotalAppelfonds() {
      return this.totalAppelfonds;
   }

   public void setTotalAppelfonds(double var1) {
      this.totalAppelfonds = var1;
   }

   public DataModel getDataModelAppelFonds() {
      return this.dataModelAppelFonds;
   }

   public void setDataModelAppelFonds(DataModel var1) {
      this.dataModelAppelFonds = var1;
   }

   public boolean isShowModalPanelAjoutAppelFonds() {
      return this.showModalPanelAjoutAppelFonds;
   }

   public void setShowModalPanelAjoutAppelFonds(boolean var1) {
      this.showModalPanelAjoutAppelFonds = var1;
   }

   public double getTotalAppel() {
      return this.totalAppel;
   }

   public void setTotalAppel(double var1) {
      this.totalAppel = var1;
   }

   public float getTotalPourcentage() {
      return this.totalPourcentage;
   }

   public void setTotalPourcentage(float var1) {
      this.totalPourcentage = var1;
   }

   public boolean isShowModalPanelPrintAppelfonds() {
      return this.showModalPanelPrintAppelfonds;
   }

   public void setShowModalPanelPrintAppelfonds(boolean var1) {
      this.showModalPanelPrintAppelfonds = var1;
   }

   public List getLesDocumentsAppelFonds() {
      return this.lesDocumentsAppelFonds;
   }

   public void setLesDocumentsAppelFonds(List var1) {
      this.lesDocumentsAppelFonds = var1;
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
