package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.LivraisonLivreeVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.ReceptionLotAchats;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.RetourLigneVentes;
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
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.LivraisonLivreeVentesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReceptionLotAchatsDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
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
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormLivraisonVentes implements Serializable {
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
   private boolean reglementAutorise = false;
   private boolean existParapheur = false;
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
   private LivraisonEnteteVentes livraisonEnteteVentes = new LivraisonEnteteVentes();
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
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
   private boolean showModalPanelValidationDocument = false;
   private List mesParcsItems = new ArrayList();
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private List mesAffairesItems = new ArrayList();
   private String numeroPfManuel;
   private boolean showModalPanelAnnuler = false;
   private LivraisonLigneVentes livraisonLigneVentes = new LivraisonLigneVentes();
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
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
   private int var_type_serie;
   private List mesPalettesItems = new ArrayList();
   private List mesCartonsItems = new ArrayList();
   private String var_select_carton;
   private String var_select_palette;
   private boolean var_liste_vide;
   private boolean var_select_type;
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
   private int validationLigne;
   private String messageStockNegatif;
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
   private transient DataModel dataModelLot = new ListDataModel();
   private List listeLot = new ArrayList();
   private ReceptionLotAchats receptionLotAchats;
   private ReceptionLotAchatsDao receptionLotAchatsDao;
   private boolean var_validation_lot = false;
   private String var_memo_lot;
   private float var_memo_qtelot;
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpNomDestinataire = "";
   private String inpSerie = "100";
   private String inpCat = "100";
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
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private String inpSite = "";
   private String inpDepartement = "";
   private String inpService = "";
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean selectDestinataire = false;
   private boolean var_more_search = false;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private float var_coef_devise;
   private boolean var_livreur = false;
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
   private String devisePrint;
   private float tauxPrint;
   private DocumentTraceVentes documentTraceVentes;
   private transient DataModel dataModelEcriture = new ListDataModel();
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
   private Date var_date_remise;
   private List mesTypeReglementsCaisse = new ArrayList();
   private List listCaisses;
   private List mesCaissesSeriesItems = new ArrayList();
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
   private LivraisonLivreeVentes livraisonLivreeVentes = new LivraisonLivreeVentes();
   private transient DataModel dataModelLivraison = new ListDataModel();
   private List lesLivraisonLivree = new ArrayList();
   private LivraisonLivreeVentesDao livraisonLivreeVentesDao;
   private boolean showModalPanelLivraison = false;
   private boolean var_gestion_livreur = false;
   private boolean valide_livreur;
   private String var_preparateur;
   private String var_chauffeur;
   private String var_vehicule;
   private Date var_date_livree;
   private boolean showModalPanelPrintLivree = false;
   private List lesDocumentsReliquatItem;
   private List lesLivraisonHisto;
   private transient DataModel dataModelLivraisonHisto;
   private boolean livreeModif;
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
   private String libelleRabRis;
   private boolean ristourne;
   private transient DataModel dataModelPieceJointes = new ListDataModel();
   private List lesPiecesJointes = new ArrayList();
   private boolean showModalPanelAjoutFile = false;
   private String cheminPieceJointes;
   private String nomPiecesJointes;
   private boolean showModalPanelPj = false;
   private String fichierMine;
   private URL fichierUrl;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload = new UtilDownload();
   private String urlExplorateur;
   private FileCtrl fileCtrl;
   private int typeFichier;

   public FormLivraisonVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
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
      this.receptionLotAchatsDao = new ReceptionLotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionSerieAchatsDao = new ReceptionSerieAchatsDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonLivreeVentesDao = new LivraisonLivreeVentesDao(this.baseLog, this.utilInitHibernate);
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
      } else {
         this.var_sansstock = false;
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

      if (this.optionsVentes.getGestionLivreur().equals("1")) {
         this.var_gestion_livreur = true;
      } else {
         this.var_gestion_livreur = false;
      }

      if (this.optionsVentes.getPaiementAVOIR().equalsIgnoreCase("2")) {
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

      this.periode = this.optionsVentes.getAffichInGlobViewLIV();
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
      this.cheminPieceJointes = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "livraisonVente" + File.separator;
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

      if (this.usersLog.getUsrFonction().contains("Livreur")) {
         if (this.var_gestion_livreur) {
            this.var_livreur = true;
         } else {
            this.var_livreur = false;
         }
      } else {
         this.var_livreur = false;
      }

      this.visibiliteBton = false;
      if (this.usersLog.getUsrCommVentes() == 2) {
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
      this.inpEtat = 0;
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
      this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.livraisonEnteteVentes != null) {
         this.devisePrint = this.livraisonEnteteVentes.getBlvDevise();
         this.lesLignesList = this.livraisonLigneVentesDao.chargerLesLignes(this.livraisonEnteteVentes, (Session)null);
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
         List var12 = this.livraisonEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpNumBCC, this.inpNumAnal, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new LivraisonEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               LivraisonEnteteVentes var16 = (LivraisonEnteteVentes)var12.get(var17);
               if (var16.getBlvActivite() != null && !var16.getBlvActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getBlvActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getBlvActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getBlvActivite().contains(this.var_colonne3)) {
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
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new LivraisonEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            LivraisonEnteteVentes var18 = (LivraisonEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var18.getBlvTotTtc();
            var4 += var18.getBlvTotReglement();
            var6 += var18.getBlvTotHt();
            var8 += var18.getBlvTotTva();
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

   public void allSelect() {
      if (this.lesEntetesList.size() != 0) {
         for(int var1 = 0; var1 < this.lesEntetesList.size(); ++var1) {
            this.livraisonEnteteVentes = (LivraisonEnteteVentes)this.lesEntetesList.get(var1);
            if (this.livraisonEnteteVentes.isVar_select_ligne()) {
               this.livraisonEnteteVentes.setVar_select_ligne(false);
            } else {
               this.livraisonEnteteVentes.setVar_select_ligne(true);
            }
         }
      }

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
            this.livraisonEnteteVentes = (LivraisonEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.livraisonEnteteVentes.getBlvNomTiers();
            this.inpIdTiersEnCours = this.livraisonEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.livraisonEnteteVentes.getBlvNomContact();
            this.var_date = this.livraisonEnteteVentes.getBlvDate();
            if (this.livraisonEnteteVentes.getBlvDate().getHours() <= 9) {
               this.var_heure = "0" + this.livraisonEnteteVentes.getBlvDate().getHours();
            } else {
               this.var_heure = "" + this.livraisonEnteteVentes.getBlvDate().getHours();
            }

            if (this.livraisonEnteteVentes.getBlvDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.livraisonEnteteVentes.getBlvDate().getMinutes();
            } else {
               this.var_minute = "" + this.livraisonEnteteVentes.getBlvDate().getMinutes();
            }

            if (this.livraisonEnteteVentes.getBlvDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.livraisonEnteteVentes.getBlvDate().getSeconds();
            } else {
               this.var_seconde = "" + this.livraisonEnteteVentes.getBlvDate().getSeconds();
            }

            this.tiers = this.livraisonEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.numeroPfManuel = this.livraisonEnteteVentes.getBlvAnal4();
            this.var_nom_contact = this.livraisonEnteteVentes.getBlvIdContact();
            this.var_nom_responsable = this.livraisonEnteteVentes.getBlvIdResponsable();
            this.var_nom_commercial = this.livraisonEnteteVentes.getBlvIdCommercial();
            this.calculDevise();
            double var13 = 0.0D;
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
            Transaction var6 = null;

            try {
               var6 = var5.beginTransaction();
               this.chargerDocumentLigne(var5);
               this.chargerDocumentLigneLivree(var5);
               if (this.optionsVentes.getPaiementAVOIR().equals("2")) {
                  var13 = this.chargerBonEncaissement(var5);
               }

               this.chargerDocumentTrace(var5);
               this.chargerLesContactsItem(var5);
               this.chargerUserChrono(var5);
               this.chargerLesUsers(var5);
               this.chargerParapheur(var5);
               this.chargerLesParcs(var5);
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

               this.numLigne = 0;
               this.format = "PDF";
               this.var_choix_modele = 0;
               this.verrouNum = true;
               this.visibiliteBton = true;
               if (this.livraisonEnteteVentes.getBlvTotTc() != 0.0D) {
                  this.var_tc_calcul = true;
               } else {
                  this.var_tc_calcul = false;
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

            if (this.optionsVentes.getPaiementAVOIR().equals("2")) {
               if (this.livraisonEnteteVentes.getBlvTotReglement() != var13) {
                  if (this.structureLog.getStrid() != 42L && this.structureLog.getStrid() != 43L && this.structureLog.getStrid() != 44L && this.structureLog.getStrid() != 45L) {
                     this.livraisonEnteteVentes.setBlvTotReglement(var13);
                     if (Math.abs(var13) >= Math.abs(this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc())) {
                        this.livraisonEnteteVentes.setBlvSolde(1);
                     } else {
                        this.livraisonEnteteVentes.setBlvSolde(0);
                     }

                     this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
                  } else if (this.livraisonEnteteVentes.getBlvSolde() == 0) {
                     this.livraisonEnteteVentes.setBlvTotReglement(var13);
                     this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
                  }
               } else {
                  if (Math.abs(var13) >= Math.abs(this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc())) {
                     this.livraisonEnteteVentes.setBlvSolde(1);
                  } else {
                     this.livraisonEnteteVentes.setBlvSolde(0);
                  }

                  this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
               }
            }

            this.setMontantTtcElmt(this.livraisonEnteteVentes.getBlvTotTtc());
            this.setMontantReglementElmt(this.livraisonEnteteVentes.getBlvTotReglement());
            this.setMontantElmTotBonEnc(this.livraisonEnteteVentes.getBlvTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.livraisonEnteteVentes.getBlvTotTtc() - this.livraisonEnteteVentes.getBlvTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.livraisonEnteteVentes != null) {
         if (this.livraisonEnteteVentes.getBlvEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.livraisonEnteteVentes.getBlvDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.livraisonEnteteVentes.getBlvDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.livraisonEnteteVentes.getBlvId() > 0L) {
         this.lesLignesList = this.livraisonLigneVentesDao.chargerLesLignes(this.livraisonEnteteVentes, var1);
      }

      if (this.lesLignesList.size() != 0) {
         boolean var2 = false;
         new LivraisonLigneVentes();

         for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
            LivraisonLigneVentes var3 = (LivraisonLigneVentes)this.lesLignesList.get(var4);
            if (var3.getBlvligIdBcm() != 0L) {
               long var5 = var3.getBlvligId();
               long var7 = var3.getBlvligIdBcm();
               boolean var9 = false;

               for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
                  if (((LivraisonLigneVentes)this.lesLignesList.get(var10)).getBlvligId() != var5 && ((LivraisonLigneVentes)this.lesLignesList.get(var10)).getBlvligIdBcm() == var7) {
                     this.livraisonLigneVentesDao.deleteOneLigne(var3, var1);
                     --var4;
                     var9 = true;
                     var2 = true;
                     break;
                  }
               }

               if (var9) {
                  this.lesLignesList.remove(var3);
               }
            }
         }

         if (var2) {
            double var18 = 0.0D;
            double var6 = 0.0D;
            double var8 = 0.0D;
            double var19 = 0.0D;
            double var12 = 0.0D;
            double var14 = 0.0D;
            new LivraisonLigneVentes();

            for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
               LivraisonLigneVentes var16 = (LivraisonLigneVentes)this.lesLignesList.get(var17);
               var18 += var16.getBlvligPt();
               var6 += (var16.getBlvligPu() - var16.getBlvligPuRem()) * (double)var16.getBlvligQte();
               var8 += var16.getBlvligRabais();
               var19 += var16.getBlvligTva();
               var12 += var16.getBlvligTtc();
               var14 += var16.getBlvligTc();
            }

            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(this.livraisonEnteteVentes.getBlvId(), var1);
            if (this.livraisonEnteteVentes != null) {
               this.livraisonEnteteVentes.setBlvTotHt(var18);
               this.livraisonEnteteVentes.setBlvTotRemise(var6);
               this.livraisonEnteteVentes.setBlvTotRabais(var8);
               this.livraisonEnteteVentes.setBlvTotTva(var19);
               this.livraisonEnteteVentes.setBlvTotTc(var14);
               this.livraisonEnteteVentes.setBlvTotTtc(var12);
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
            }
         }
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.livraisonEnteteVentes != null && this.livraisonEnteteVentes.getBlvEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.livraisonEnteteVentes.getBlvAnal4(), this.livraisonEnteteVentes.getBlvAnal4()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var7 = this.reglementsDao.reglementDocument(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
      double var4 = 0.0D;
      if (var7.size() != 0) {
         this.afficheRecu = true;

         for(int var6 = 0; var6 < var7.size(); ++var6) {
            this.var_tot_bon_encaissement += ((Reglements)var7.get(var6)).getRglRecette();
            var4 += ((Reglements)var7.get(var6)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var7);
      if (this.var_tot_bon_encaissement < this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc()) {
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

   public void chargerDocumentLigneLivree(Session var1) {
      this.lesLivraisonLivree.clear();
      if (this.livraisonEnteteVentes.getBlvId() > 0L) {
         this.lesLivraisonLivree = this.livraisonLivreeVentesDao.chargerLesLivraisons(this.livraisonEnteteVentes.getBlvId(), var1);
      }

      this.dataModelLivraison.setWrappedData(this.lesLivraisonLivree);
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
      new ArrayList();
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.optionsVentes.getTracabilite().equals("1")) {
         if (this.livraisonEnteteVentes.getBlvId() > 0L) {
            var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
         }
      } else {
         Object var3 = new ArrayList();
         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();
         new ArrayList();
         new ArrayList();
         ArrayList var8 = new ArrayList();
         new ArrayList();
         ArrayList var10 = new ArrayList();
         new ArrayList();
         ArrayList var12 = new ArrayList();
         ArrayList var13 = new ArrayList();
         new ArrayList();
         if (this.livraisonEnteteVentes.getBlvId() > 0L) {
            List var7 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
            if (var7.size() == 0 || this.optionsVentes.getModeAvoir().equals("1")) {
               var7 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
               if (var7.size() == 0) {
                  var7 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
               }
            }

            int var15;
            int var16;
            for(var15 = 0; var15 < var7.size(); ++var15) {
               List var11 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(((DocumentTraceVentes)var7.get(var15)).getDoctraDstId(), ((DocumentTraceVentes)var7.get(var15)).getDoctraDstType(), var1);
               if (var11.size() != 0) {
                  for(var16 = 0; var16 < var11.size(); ++var16) {
                     var10.add(var11.get(var16));
                  }
               }
            }

            for(var15 = 0; var15 < var7.size(); ++var15) {
               List var6 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var7.get(var15)).getDoctraOrgId(), ((DocumentTraceVentes)var7.get(var15)).getDoctraOrgType(), var1);
               if (var6.size() != 0) {
                  for(var16 = 0; var16 < var6.size(); ++var16) {
                     var5.add(var6.get(var16));
                  }
               }
            }

            for(var15 = 0; var15 < var5.size(); ++var15) {
               var3 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var5.get(var15)).getDoctraOrgId(), ((DocumentTraceVentes)var5.get(var15)).getDoctraOrgType(), var1);
               if (var4.size() != 0) {
                  for(var16 = 0; var16 < var4.size(); ++var16) {
                     ((List)var3).add(var4.get(var16));
                  }
               }
            }

            for(var15 = 0; var15 < var10.size(); ++var15) {
               List var14 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var10.get(var15)).getDoctraOrgId(), 26, var1);
               if (var14.size() != 0) {
                  for(var16 = 0; var16 < var14.size(); ++var16) {
                     var13.add(var14.get(var16));
                  }
               }
            }

            for(var15 = 0; var15 < var7.size(); ++var15) {
               List var9 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var7.get(var15)).getDoctraOrgId(), 24, var1);
               if (var9.size() != 0) {
                  for(var16 = 0; var16 < var9.size(); ++var16) {
                     var8.add(var9.get(var16));
                  }
               }
            }

            long var18 = (long)(this.livraisonEnteteVentes.getBlvDate().getYear() + 1900 - 2);

            int var17;
            for(var17 = 0; var17 < ((List)var3).size(); ++var17) {
               if (((DocumentTraceVentes)((List)var3).get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)((List)var3).get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(((List)var3).get(var17));
               }
            }

            for(var17 = 0; var17 < var5.size(); ++var17) {
               if (((DocumentTraceVentes)var5.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var5.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(var5.get(var17));
               }
            }

            for(var17 = 0; var17 < var7.size(); ++var17) {
               if (((DocumentTraceVentes)var7.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var7.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(var7.get(var17));
               }
            }

            for(var17 = 0; var17 < var8.size(); ++var17) {
               if (((DocumentTraceVentes)var8.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var8.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(var8.get(var17));
               }
            }

            for(var17 = 0; var17 < var10.size(); ++var17) {
               if (((DocumentTraceVentes)var10.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var10.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(var10.get(var17));
               }
            }

            for(var17 = 0; var17 < var12.size(); ++var17) {
               if (((DocumentTraceVentes)var12.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var12.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(var12.get(var17));
               }
            }

            for(var17 = 0; var17 < var13.size(); ++var17) {
               if (((DocumentTraceVentes)var13.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var13.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
                  ((List)var2).add(var13.get(var17));
               }
            }
         }
      }

      this.datamodelDocumentTrace.setWrappedData(var2);
      this.documentTraceVentes = null;
      this.utilInitHibernate.closeSession();
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      this.datamodelDocumentTrace.setWrappedData(var2);
      this.documentTraceVentes = null;
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null && this.livraisonEnteteVentes.getBlvSerie() != null && !this.livraisonEnteteVentes.getBlvSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.livraisonEnteteVentes.getBlvSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         this.requete = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.livraisonEnteteVentes.getBlvId();
         List var1 = var2.ChargerLesEcrituresRecherche(this.requete, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.livraisonEnteteVentes.getBlvDateTransfert() != null) {
            this.livraisonEnteteVentes.setBlvDateTransfert((Date)null);
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.livraisonEnteteVentes.getBlvActivite() != null && !this.livraisonEnteteVentes.getBlvActivite().isEmpty() && this.livraisonEnteteVentes.getBlvActivite().contains(":")) {
         String[] var1 = null;
         if (!this.livraisonEnteteVentes.getBlvActivite().contains("#")) {
            var1 = this.livraisonEnteteVentes.getBlvActivite().split(":");
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
            String[] var2 = this.livraisonEnteteVentes.getBlvActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.livraisonEnteteVentes.getBlvTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.livraisonEnteteVentes.getBlvTotHt() - this.totalImputation;
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
      this.livraisonEnteteVentes = new LivraisonEnteteVentes();
      this.livraisonLigneVentes = new LivraisonLigneVentes();
      this.livraisonEnteteVentes.setUsers(this.usersLog);
      this.livraisonEnteteVentes.setBlvIdCreateur(this.usersLog.getUsrid());
      this.livraisonEnteteVentes.setBlvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.livraisonEnteteVentes.setBlvDate(new Date());
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
      this.livraisonEnteteVentes.setBlvDateLivraison((Date)null);
      this.livraisonEnteteVentes.setBlvBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.livraisonEnteteVentes.setBlvIdCommercial(this.usersLog.getUsrid());
         this.livraisonEnteteVentes.setBlvNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.livraisonEnteteVentes.setBlvIdResponsable(this.usersLog.getUsrid());
         this.livraisonEnteteVentes.setBlvNomResponsable(this.usersLog.getUsrPatronyme());
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

      this.numeroPfManuel = "";
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.autorisationDocument();
      this.addLigne();
   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionsVentes.getNbrJrRelanceLIV() != null && !this.optionsVentes.getNbrJrRelanceLIV().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceLIV());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidLIV() != null && !this.optionsVentes.getNbrJrValidLIV().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidLIV());
      } else {
         var4 = 0;
      }

      this.livraisonEnteteVentes.setBlvDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.livraisonEnteteVentes.setBlvDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         this.livraisonEnteteVentes.setBlvMaj(1);
         this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
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
            this.mesUsersItem.add(new SelectItem(this.livraisonEnteteVentes.getBlvIdResponsable(), this.livraisonEnteteVentes.getBlvNomResponsable()));
         }

         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.livraisonEnteteVentes.getBlvIdResponsable(), this.livraisonEnteteVentes.getBlvNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.livraisonEnteteVentes.getBlvEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.livraisonEnteteVentes.setBlvEtat(1);
               this.livraisonEnteteVentes.setBlvDateValide(new Date());
               if (!this.var_gestion_livreur) {
                  this.livraisonEnteteVentes.setBlvLivreeEtat(2);
               } else {
                  float var3 = 0.0F;
                  if (this.lesLivraisonLivree.size() != 0) {
                     for(int var4 = 0; var4 < this.lesLivraisonLivree.size(); ++var4) {
                        var3 += ((LivraisonLivreeVentes)this.lesLivraisonLivree.get(var4)).getBlvlivQteUtilLivree();
                     }
                  }

                  float var12 = 0.0F;
                  if (this.lesLignesList.size() != 0) {
                     for(int var5 = 0; var5 < this.lesLignesList.size(); ++var5) {
                        var12 += ((LivraisonLigneVentes)this.lesLignesList.get(var5)).getBlvligQteUtilStock();
                     }
                  }

                  if (var3 == 0.0F) {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(0);
                  } else if (var3 < var12) {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(1);
                  } else {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(2);
                  }
               }

               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
               if (!this.var_gestion_livreur) {
                  this.livraisonLivreeVentesDao.deleteLigne(this.lesLivraisonLivree, var1);
                  this.lesLivraisonLivree.clear();
               }

               if (this.livraisonEnteteVentes.getBlvStock() == 0) {
                  this.calculStock.majLivraisonVentesVAL(this.lesLignesList, 1, this.baseLog, var1);
               }

               Espion var11 = new Espion();
               var11.setUsers(this.usersLog);
               var11.setEsptype(0);
               var11.setEspdtecreat(new Date());
               var11.setEspaction("Validation manuelle livraison (C.) N° " + this.livraisonEnteteVentes.getBlvNum() + " du " + this.utilDate.dateToStringSQLLight(this.livraisonEnteteVentes.getBlvDate()));
               this.espionDao.mAJEspion(var11, var1);
            }

            if (this.tiers.getTieDteDocument3() == null || this.livraisonEnteteVentes.getBlvDate().after(this.tiers.getTieDteDocument3())) {
               this.tiers.setTieDteDocument3(this.livraisonEnteteVentes.getBlvDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
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

         this.showModalPanelLivraison = false;
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.livraisonEnteteVentes.getBlvEtat() == 1) {
               this.livraisonEnteteVentes.setBlvEtat(0);
               this.livraisonEnteteVentes.setBlvLivreeEtat(0);
               this.livraisonEnteteVentes.setBlvDateValide((Date)null);
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
               if (!this.var_gestion_livreur && this.lesLivraisonLivree.size() != 0) {
                  this.livraisonLivreeVentesDao.deleteLigne(this.lesLivraisonLivree, var1);
                  this.lesLivraisonLivree.clear();
               }

               if (this.livraisonEnteteVentes.getBlvStock() == 0) {
                  this.calculStock.majLivraisonVentesVAL(this.lesLignesList, 0, this.baseLog, var1);
               }

               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle livraison (C.) N° " + this.livraisonEnteteVentes.getBlvNum() + " du " + this.utilDate.dateToStringSQLLight(this.livraisonEnteteVentes.getBlvDate()));
               this.espionDao.mAJEspion(var3, var1);
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

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         this.livraisonEnteteVentes.setBlvEtat(0);
         this.livraisonEnteteVentes.setBlvDateAnnule((Date)null);
         this.livraisonEnteteVentes.setBlvMotifAnnule("");
         this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
         Transaction var2 = null;

         Object var3;
         try {
            var2 = var1.beginTransaction();
            var3 = new ArrayList();
            if (this.lesLignesList.size() != 0) {
               this.livraisonLigneVentes = new LivraisonLigneVentes();

               for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
                  this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var4);
                  ((List)var3).clear();
                  var3 = this.livraisonLivreeVentesDao.chargerLesLivraisons(this.livraisonLigneVentes, var1);
                  if (((List)var3).size() != 0) {
                     for(int var5 = 0; var5 < ((List)var3).size(); ++var5) {
                        this.livraisonLivreeVentes = (LivraisonLivreeVentes)((List)var3).get(var5);
                        this.livraisonLivreeVentesDao.deleteLigne((List)var3, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var26) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var26;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         var3 = null;

         try {
            Transaction var28 = var1.beginTransaction();
            this.lesEntetesList.remove(this.livraisonEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var29 = this.livraisonEnteteVentes.getBlvId();
            String var6 = this.livraisonEnteteVentes.getBlvNum();
            Date var7 = this.livraisonEnteteVentes.getBlvDate();
            this.livraisonLigneVentes = new LivraisonLigneVentes();
            if (this.lesLignesList.size() != 0) {
               for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
                  this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var8);
                  if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && this.livraisonLigneVentes.getBlvligDepot() != null && !this.livraisonLigneVentes.getBlvligDepot().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var1);
                     if (this.produits != null) {
                        this.calculStock.majLivraisonVentesATT(this.livraisonLigneVentes, this.produits, 0.0F, 0, this.baseLog, var1);
                     }
                  }
               }
            }

            new ArrayList();
            List var30 = this.receptionSerieAchatsDao.selectBlSerieByBlEnt(this.livraisonEnteteVentes, var1);
            if (var30.size() != 0) {
               this.receptionSerieAchatsDao.libereAllSerie(var30, var1);
            }

            this.livraisonLigneVentesDao.deleteAllLigne(this.livraisonEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
            this.livraisonEnteteVentesDao.delete(this.livraisonEnteteVentes.getBlvId(), var1);
            if (this.lesPiecesJointes.size() != 0) {
               for(int var9 = 0; var9 < this.lesPiecesJointes.size(); ++var9) {
                  String var10 = ((FileCtrl)this.lesPiecesJointes.get(var9)).toString();
                  File var11 = new File(this.cheminPieceJointes + var10);
                  if (var11.exists()) {
                     var11.delete();
                  }
               }
            }

            this.documentTraceVentes = new DocumentTraceVentes();
            this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(var29, this.nature, var1);
            if (this.documentTraceVentes != null) {
               long var31 = this.documentTraceVentes.getDoctraOrgId();
               int var34 = this.documentTraceVentes.getDoctraOrgType();
               this.documentTraceVentesDao.delete(this.documentTraceVentes, var1);
               boolean var12 = false;
               this.documentTraceVentes = this.documentTraceVentesDao.chercherOrigineTrace(var31, var34, var1);
               byte var35;
               if (this.documentTraceVentes != null) {
                  var35 = 4;
               } else {
                  var35 = 1;
               }

               if (var34 == 21) {
                  new DevisEnteteVentes();
                  DevisEnteteVentesDao var14 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  DevisEnteteVentes var13 = var14.pourParapheur(var31, var1);
                  if (var13 != null) {
                     var13.setDvsEtat(var35);
                     if (var35 == 1) {
                        var13.setDvsDateTransforme((Date)null);
                        var13.setDvsTypeTransforme(0);
                     }

                     var14.modif(var13, var1);
                  }
               } else if (var34 == 22) {
                  new CommandeEnteteVentes();
                  CommandeEnteteVentesDao var37 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  CommandeEnteteVentes var36 = var37.pourParapheur(var31, var1);
                  if (var36 != null) {
                     var36.setBcmEtat(var35);
                     if (var35 == 1) {
                        var36.setBcmDateTransforme((Date)null);
                        var36.setBcmTypeTransforme(0);
                     }

                     var37.modif(var36, var1);
                  }
               }
            }

            if (this.optionsVentes.getAxeDossier().equals("2") && this.livraisonEnteteVentes.getBlvAnal4() != null && !this.livraisonEnteteVentes.getBlvAnal4().isEmpty()) {
               PlansAnalytiquesDao var32 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               this.plansAnalytiques = var32.rechercheAffaire(this.livraisonEnteteVentes.getBlvAnal4(), var1);
               if (this.plansAnalytiques != null) {
                  this.plansAnalytiques.setAnaAffaireDateLivree((Date)null);
                  this.plansAnalytiques = var32.modif(this.plansAnalytiques, var1);
               }
            }

            Espion var33 = new Espion();
            var33.setUsers(this.usersLog);
            var33.setEsptype(0);
            var33.setEspdtecreat(new Date());
            var33.setEspaction("Suppression BL N° " + var6 + " du " + var7);
            this.espionDao.mAJEspion(var33, var1);
            var28.commit();
         } catch (HibernateException var24) {
            if (var3 != null) {
               ((Transaction)var3).rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.livraisonEnteteVentes.getBlvId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.livraisonEnteteVentes.setUsers(this.usersLog);
            this.livraisonEnteteVentes.setBlvIdCreateur(this.usersLog.getUsrid());
            this.livraisonEnteteVentes.setBlvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.livraisonEnteteVentes.setBlvDate(new Date());
            this.livraisonEnteteVentes.setBlvDateCreat(new Date());
            this.livraisonEnteteVentes.setBlvDateModif((Date)null);
            this.livraisonEnteteVentes.setBlvIdModif(0L);
            this.livraisonEnteteVentes.setBlvNomModif("");
            this.livraisonEnteteVentes.setBlvNum("");
            this.livraisonEnteteVentes.setBlvIdResponsable(this.usersLog.getUsrid());
            this.livraisonEnteteVentes.setBlvNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.livraisonEnteteVentes.setBlvDateLivraison((Date)null);
            if (!this.livraisonEnteteVentes.getBlvSerie().equalsIgnoreCase("X") && !this.livraisonEnteteVentes.getBlvSerie().isEmpty()) {
               this.livraisonEnteteVentes.setBlvNum(this.calculChrono.numCompose(this.livraisonEnteteVentes.getBlvDate(), this.nature, this.livraisonEnteteVentes.getBlvSerie(), var1));
            } else {
               long var3 = this.livraisonEnteteVentesDao.selectLastNum(var1);
               this.livraisonEnteteVentes.setBlvNum("" + var3);
            }

            this.verifieExistenceHabilitation(var1);
            this.livraisonEnteteVentes.setBlvDateAnnule((Date)null);
            this.livraisonEnteteVentes.setBlvMotifAnnule("");
            this.livraisonEnteteVentes.setBlvDateImp((Date)null);
            this.livraisonEnteteVentes.setBlvDateTransforme((Date)null);
            this.livraisonEnteteVentes.setBlvEtat(0);
            this.livraisonEnteteVentes.setBlvContener("");
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.duppliquer(this.livraisonEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               this.livraisonLigneVentesDao.duppliquerLigne(this.lesLignesList, this.livraisonEnteteVentes, var1);
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
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.livraisonEnteteVentes.getBlvId(), this.livraisonEnteteVentes.getBlvNum(), this.livraisonEnteteVentes.getBlvNomTiers(), this.livraisonEnteteVentes.getBlvDate(), this.livraisonEnteteVentes.getBlvDevise(), this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc(), this.livraisonEnteteVentes.getBlvModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun((String)null), this.calculeParc(var1), this.livraisonEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
      }

   }

   public void uniciteNumBcclient() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes.getBlvNumClient() != null && !this.livraisonEnteteVentes.getBlvNumClient().isEmpty()) {
         new LivraisonEnteteVentes();
         LivraisonEnteteVentes var1 = this.livraisonEnteteVentesDao.rechercheLivraisonByNumClient(this.livraisonEnteteVentes.getBlvNumClient(), this.tiers, this.livraisonEnteteVentes.getBlvId(), (Session)null);
         if (var1 != null) {
            String var2 = "Le numéro de commande client " + this.livraisonEnteteVentes.getBlvNumClient() + " existe déjà. Veuillez en utiliser un autre.";
            this.formRecherche.setMessageTexte(var2);
            this.formRecherche.setShowModalPanelMessage(true);
            this.livraisonEnteteVentes.setBlvNumClient("");
         }
      }

   }

   public void razNumreoPortefeuille() {
      this.numeroPfManuel = "";
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         boolean var4 = false;
         if (this.livraisonEnteteVentes.getBlvTypeTransforme() != 0) {
            var4 = this.usersChronoDao.existByUserNat(this.usersLog, this.livraisonEnteteVentes.getBlvTypeTransforme(), var1);
            if (var4) {
               String var5 = "";
               if (this.livraisonEnteteVentes.getBlvTypeTransforme() == 22) {
                  var5 = "Bon de commande";
               } else if (this.livraisonEnteteVentes.getBlvTypeTransforme() == 23) {
                  var5 = "Bon de livraison";
               } else if (this.livraisonEnteteVentes.getBlvTypeTransforme() == 25) {
                  var5 = "Facture";
               } else if (this.livraisonEnteteVentes.getBlvTypeTransforme() == 26) {
                  var5 = "Avoir";
               } else if (this.livraisonEnteteVentes.getBlvTypeTransforme() == 27) {
                  var5 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.livraisonEnteteVentes.getBlvTypeTransforme(), "Facture"));
               var3 = this.usersChronoDao.existByUserNat(this.usersLog, 24, var1);
               if (var3) {
                  this.documentTrfItems.add(new SelectItem(24, "Bon retour"));
               }
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 25, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(25, "Facture"));
            }

            var3 = this.usersChronoDao.existByUserNat(this.usersLog, 24, var1);
            if (var3) {
               this.documentTrfItems.add(new SelectItem(24, "Bon retour"));
            }
         }

         for(int var9 = 0; var9 < this.lesEntetesList.size(); ++var9) {
            new LivraisonEnteteVentes();
            LivraisonEnteteVentes var6 = (LivraisonEnteteVentes)this.lesEntetesList.get(var9);
            if (var6.getBlvId() > 0L && var6.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.livraisonLigneVentesDao.chargerLesLignes(var6, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                     new LivraisonLigneVentes();
                     LivraisonLigneVentes var8 = (LivraisonLigneVentes)this.lesLignesList.get(var7);
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
      if (this.livraisonEnteteVentes.getBlvTypeReg() != 0 && this.livraisonEnteteVentes.getBlvTypeReg() != 3) {
         if (this.livraisonEnteteVentes.getBlvTypeReg() != 1 && this.livraisonEnteteVentes.getBlvTypeReg() != 2 && this.livraisonEnteteVentes.getBlvTypeReg() != 10) {
            if (this.livraisonEnteteVentes.getBlvTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.livraisonEnteteVentes.getBlvModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.livraisonEnteteVentes.getBlvModeReg() != null && !this.livraisonEnteteVentes.getBlvModeReg().isEmpty() && this.livraisonEnteteVentes.getBlvModeReg().contains(":")) {
         String[] var2 = this.livraisonEnteteVentes.getBlvModeReg().split(":");
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

            this.livraisonEnteteVentes.setBlvTypeReg(Integer.parseInt(var3.getEcheances()));
            this.livraisonEnteteVentes.setBlvModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.livraisonEnteteVentes.setBlvNbJourReg(0);
            this.livraisonEnteteVentes.setBlvArrondiReg(0);
            break;
         }
      }

      if (this.livraisonEnteteVentes.getBlvTypeReg() != 0 && this.livraisonEnteteVentes.getBlvTypeReg() != 3) {
         if (this.livraisonEnteteVentes.getBlvTypeReg() != 1 && this.livraisonEnteteVentes.getBlvTypeReg() != 2 && this.livraisonEnteteVentes.getBlvTypeReg() != 10) {
            if (this.livraisonEnteteVentes.getBlvTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.livraisonEnteteVentes.setBlvTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.livraisonEnteteVentes.setBlvModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.livraisonEnteteVentes.setBlvNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.livraisonEnteteVentes.setBlvArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.livraisonEnteteVentes.getBlvModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.livraisonEnteteVentes.getBlvDate(), this.livraisonEnteteVentes.getBlvTypeReg(), this.livraisonEnteteVentes.getBlvNbJourReg(), this.livraisonEnteteVentes.getBlvArrondiReg());
      this.livraisonEnteteVentes.setBlvDateEcheReg(var1);
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
         if (this.livraisonEnteteVentes.getBlvId() != 0L) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.livraisonEnteteVentes.setBlvDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.livraisonEnteteVentes.getUsers() == null) {
            this.livraisonEnteteVentes.setUsers(this.usersLog);
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

         this.livraisonEnteteVentes.setTiers(this.tiers);
         if ((this.livraisonEnteteVentes.getBlvCat() == null || this.livraisonEnteteVentes.getBlvCat().isEmpty()) && this.livraisonEnteteVentes.getTiers().getTienomfamille() != null && !this.livraisonEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.livraisonEnteteVentes.setBlvCat(this.livraisonEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.livraisonEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.livraisonEnteteVentes.setBlvCivilTiers("");
         } else {
            this.livraisonEnteteVentes.setBlvCivilTiers(this.livraisonEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.livraisonEnteteVentes.getBlvDiversTiers() == 99) {
               this.livraisonEnteteVentes.setBlvIdContact(0L);
               this.livraisonEnteteVentes.setBlvNomContact("");
               this.livraisonEnteteVentes.setBlvCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.livraisonEnteteVentes.setBlvIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.livraisonEnteteVentes.setBlvNomContact(var3.getConpatronyme());
                     this.livraisonEnteteVentes.setBlvCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.livraisonEnteteVentes.setBlvNomContact(var3.getConservice());
                     this.livraisonEnteteVentes.setBlvCivilContact("SERVICE/SITE:");
                  } else {
                     this.livraisonEnteteVentes.setBlvIdContact(0L);
                     this.livraisonEnteteVentes.setBlvNomContact("");
                     this.livraisonEnteteVentes.setBlvCivilContact("");
                  }
               } else {
                  this.livraisonEnteteVentes.setBlvIdContact(0L);
                  this.livraisonEnteteVentes.setBlvNomContact("");
                  this.livraisonEnteteVentes.setBlvCivilContact("");
               }
            }

            this.livraisonEnteteVentes.setBlvTiersRegroupe(this.tiers.getTiesigle());
         }

         this.livraisonEnteteVentes.setBlvIdResponsable(0L);
         this.livraisonEnteteVentes.setBlvNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.livraisonEnteteVentes.setBlvIdResponsable(var15.getUsrid());
            this.livraisonEnteteVentes.setBlvNomResponsable(var15.getUsrPatronyme());
         }

         this.livraisonEnteteVentes.setBlvIdCommercial(0L);
         this.livraisonEnteteVentes.setBlvNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.livraisonEnteteVentes.setBlvIdCommercial(var4.getUsrid());
               this.livraisonEnteteVentes.setBlvNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.livraisonEnteteVentes.setBlvIdEquipe(0L);
         this.livraisonEnteteVentes.setBlvNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.livraisonEnteteVentes.getBlvIdResponsable(), var1);
            if (this.equipes != null) {
               this.livraisonEnteteVentes.setBlvIdEquipe(this.equipes.getEquId());
               this.livraisonEnteteVentes.setBlvNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc(), var16, this.livraisonEnteteVentes.getBlvDevise(), this.livraisonEnteteVentes.getBlvDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.livraisonEnteteVentes.getBlvDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.livraisonEnteteVentes.getBlvDevise());
               this.livraisonEnteteVentes.setBlvFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.livraisonEnteteVentes.getBlvDevise(), this.livraisonEnteteVentes.getBlvDate()));
            }
         }

         if (this.var_gestion_livreur) {
            this.livraisonEnteteVentes.setBlvLivreur(1);
         } else {
            this.livraisonEnteteVentes.setBlvLivreur(0);
         }

         if (this.accesAffaires) {
         }

         if (this.livraisonEnteteVentes.getBlvId() != 0L) {
            if (this.livraisonEnteteVentes.getBlvEtat() == 6) {
               if (this.livraisonEnteteVentes.getBlvEtatVal() == 1) {
                  this.livraisonEnteteVentes.setBlvEtat(0);
               } else {
                  this.livraisonEnteteVentes.setBlvEtat(0);
               }
            }

            this.livraisonEnteteVentes.setBlvDateModif(new Date());
            this.livraisonEnteteVentes.setBlvIdModif(this.usersLog.getUsrid());
            this.livraisonEnteteVentes.setBlvNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.livraisonEnteteVentes.setBlvMaj(0);
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var16);
               this.livraisonLigneVentes.setBlvligOrdre(var16);
               this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
            }
         } else {
            this.livraisonEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.livraisonEnteteVentes.setBlvDateCreat(new Date());
            this.livraisonEnteteVentes.setBlvIdCreateur(this.usersLog.getUsrid());
            this.livraisonEnteteVentes.setBlvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.livraisonEnteteVentes.getBlvSerie() != null && !this.livraisonEnteteVentes.getBlvSerie().equalsIgnoreCase("X") && !this.livraisonEnteteVentes.getBlvSerie().isEmpty()) {
               this.livraisonEnteteVentes.setBlvNum(this.calculChrono.numCompose(this.livraisonEnteteVentes.getBlvDate(), this.nature, this.livraisonEnteteVentes.getBlvSerie(), var1));
               boolean var18 = false;

               label432:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label432;
                     }

                     new LivraisonEnteteVentes();
                     LivraisonEnteteVentes var19 = this.livraisonEnteteVentesDao.pourParapheur(this.livraisonEnteteVentes.getBlvNum(), this.livraisonEnteteVentes.getBlvSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.livraisonEnteteVentes.setBlvNum(this.calculChrono.numCompose(this.livraisonEnteteVentes.getBlvDate(), this.nature, this.livraisonEnteteVentes.getBlvSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.livraisonEnteteVentesDao.selectLastNum(var1);
               this.livraisonEnteteVentes.setBlvNum("" + var17);
            }

            this.livraisonEnteteVentes.setBlvMaj(1);
            this.livraisonEnteteVentes.setBlvEtat(0);
            this.livraisonEnteteVentes.setBlvEtatVal(0);
            this.livraisonEnteteVentes.setBlvDateValide((Date)null);
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.insert(this.livraisonEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.livraisonEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.livraisonEnteteVentes.getBlvId(), this.livraisonEnteteVentes.getBlvNum(), this.livraisonEnteteVentes.getBlvNomTiers(), this.livraisonEnteteVentes.getBlvDate(), this.livraisonEnteteVentes.getBlvDevise(), this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc(), this.livraisonEnteteVentes.getBlvModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun((String)null), this.calculeParc(var1), this.livraisonEnteteVentes.getVar_format_devise(), 0, var1);
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

      if (this.livraisonEnteteVentes.getBlvEtatVal() == 0 && this.livraisonEnteteVentes.getBlvEtat() == 1) {
         this.valideDocument();
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.livraisonEnteteVentes.setBlvSite(this.usersLog.getUsrSite());
      this.livraisonEnteteVentes.setBlvDepartement(this.usersLog.getUsrDepartement());
      this.livraisonEnteteVentes.setBlvService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.livraisonEnteteVentes.setBlvIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.livraisonEnteteVentes.getBlvNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.livraisonEnteteVentes.setBlvTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.livraisonEnteteVentes.setBlvRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.livraisonEnteteVentes.setBlvSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.livraisonEnteteVentes.setBlvPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.livraisonEnteteVentes.setBlvTiersRegroupe(this.tiers.getTiesigle());
            this.livraisonEnteteVentes.setBlvRegion(this.tiers.getTieregion());
            this.livraisonEnteteVentes.setBlvSecteur(this.tiers.getTiesecteur());
            this.livraisonEnteteVentes.setBlvPdv(this.tiers.getTiepdv());
         }
      } else {
         this.livraisonEnteteVentes.setBlvTiersRegroupe(this.tiers.getTiesigle());
         this.livraisonEnteteVentes.setBlvRegion(this.tiers.getTieregion());
         this.livraisonEnteteVentes.setBlvSecteur(this.tiers.getTiesecteur());
         this.livraisonEnteteVentes.setBlvPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.livraisonEnteteVentes.setBlvActivite("");
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

               this.livraisonEnteteVentes.setBlvActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new LivraisonLigneVentes();
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

                  LivraisonLigneVentes var13 = (LivraisonLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getBlvligCode() != null && !var13.getBlvligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getBlvligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getBlvligPt());
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
                              var7.setPrix(var13.getBlvligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getBlvligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.livraisonEnteteVentes.setBlvActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.livraisonEnteteVentes.setBlvAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.livraisonEnteteVentes.getBlvAnal4() != null && !this.livraisonEnteteVentes.getBlvAnal4().isEmpty()) {
         this.livraisonEnteteVentes.setBlvAnal4(this.livraisonEnteteVentes.getBlvAnal4().toUpperCase());
      }

      if (!this.var_anal_parc) {
         this.livraisonEnteteVentes.setBlvAnal2("");
      } else if (this.livraisonEnteteVentes.getBlvAnal2() != null && this.livraisonEnteteVentes.getBlvAnal2().length() <= 2) {
         this.livraisonEnteteVentes.setBlvAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.livraisonEnteteVentes.setBlvEtatVal(1);
         this.livraisonEnteteVentes.setBlvEtat(0);
         this.livraisonEnteteVentes.setBlvDateValide((Date)null);
         return true;
      } else {
         this.livraisonEnteteVentes.setBlvEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.livraisonEnteteVentes.setBlvEtat(1);
               this.livraisonEnteteVentes.setBlvDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.livraisonEnteteVentes.setBlvEtat(0);
               this.livraisonEnteteVentes.setBlvDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.livraisonEnteteVentes != null) {
         this.livraisonEnteteVentes.setBlvDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         if (this.livraisonEnteteVentes.getBlvDateAnnule() == null) {
            this.livraisonEnteteVentes.setBlvDateAnnule(new Date());
         }

         this.livraisonEnteteVentes.setBlvEtat(3);
         this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation livraison vente N° " + this.livraisonEnteteVentes.getBlvNum() + " le " + this.livraisonEnteteVentes.getBlvDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.livraisonEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void preperationLivraison() throws HibernateException, NamingException {
      this.lesLivraisonHisto = new ArrayList();
      this.dataModelLivraisonHisto = new ListDataModel();
      if (this.livraisonEnteteVentes != null && this.lesLignesList.size() != 0) {
         this.lesLivraisonLivree.clear();
         ArrayList var1 = new ArrayList();
         float var2 = 0.0F;
         boolean var3 = false;
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var5 = null;

         byte var16;
         try {
            var5 = var4.beginTransaction();

            for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var6);
               long var7 = this.livraisonLigneVentes.getBlvligId();
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.rechercheLivraison(var7, var4);
               if (this.livraisonLigneVentes != null) {
                  this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var4);
                  if (this.produits != null) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), var4);
                     if (this.produitsDepot != null) {
                        float var9 = this.livraisonLivreeVentesDao.chargerLesLignesLivree(this.livraisonLigneVentes, var4);
                        this.livraisonLivreeVentes = new LivraisonLivreeVentes();
                        this.livraisonLivreeVentes.setLivraisonLigneVentes(this.livraisonLigneVentes);
                        this.livraisonLivreeVentes.setBlvlivCode(this.livraisonLigneVentes.getBlvligCode());
                        this.livraisonLivreeVentes.setBlvlivDepot(this.livraisonLigneVentes.getBlvligDepot());
                        this.livraisonLivreeVentes.setBlvlivIdBl(this.livraisonEnteteVentes.getBlvId());
                        this.livraisonLivreeVentes.setVar_qteDejaLiv(var9);
                        float var10 = this.livraisonLigneVentes.getBlvligQteUtil() - var9;
                        var2 += var9;
                        if (var10 > 0.0F) {
                           this.livraisonLivreeVentes.setBlvlivQteLivree(var10);
                           this.livraisonLivreeVentes.setBlvlivDate(new Date());
                           this.lesLivraisonLivree.add(this.livraisonLivreeVentes);
                           this.livraisonLigneVentes.setBlvligQteStock(var9);
                           this.livraisonLigneVentes.setBlvligQteUtilStock(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.livraisonLigneVentes.getBlvligCondition(), var9, this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, this.utilInitHibernate, var4));
                        } else {
                           this.livraisonLigneVentes.setBlvligQteStock(this.livraisonLigneVentes.getBlvligQte());
                           this.livraisonLigneVentes.setBlvligQteUtilStock(this.livraisonLigneVentes.getBlvligQteUtil());
                        }

                        var1.add(this.livraisonLivreeVentes);
                     } else {
                        this.livraisonLigneVentes.setBlvligQteStock(0.0F);
                        this.livraisonLigneVentes.setBlvligQteUtilStock(0.0F);
                     }
                  } else {
                     this.livraisonLigneVentes.setBlvligQteStock(0.0F);
                     this.livraisonLigneVentes.setBlvligQteUtilStock(0.0F);
                  }

                  this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var4);
               }
            }

            if (this.lesLivraisonLivree.size() != 0) {
               if (var2 == 0.0F) {
                  var16 = 0;
               } else {
                  var16 = 1;
               }
            } else {
               var16 = 2;
            }

            var5.commit();
         } catch (HibernateException var14) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.livraisonEnteteVentes.getBlvLivreeEtat() != var16) {
            this.livraisonEnteteVentes.setBlvLivreeEtat(var16);
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
         }

         if (this.lesLivraisonLivree.size() != 0) {
            this.var_preparateur = "";
            this.var_chauffeur = "";
            this.var_vehicule = "";
            this.var_date_livree = new Date();
            this.dataModelLivraison.setWrappedData(this.lesLivraisonLivree);
            this.valide_livreur = false;
            this.livreeModif = true;
         } else {
            this.dataModelLivraison.setWrappedData(var1);
            this.livreeModif = false;
         }

         this.showModalPanelLivraison = true;
      }

   }

   public void selectionLivree() throws HibernateException, NamingException {
      if (this.dataModelLivraison.isRowAvailable()) {
         this.livraisonLivreeVentes = (LivraisonLivreeVentes)this.dataModelLivraison.getRowData();
         this.livraisonLigneVentes = this.livraisonLivreeVentes.getLivraisonLigneVentes();
         this.lesLivraisonHisto = this.livraisonLivreeVentesDao.chargerLesLivraisons(this.livraisonLigneVentes, (Session)null);
         this.dataModelLivraisonHisto.setWrappedData(this.lesLivraisonHisto);
      }

   }

   public void livraisonDocument() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         long var1 = this.livraisonEnteteVentes.getBlvId();
         boolean var3 = false;
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var5 = null;

         LivraisonLigneVentes var6;
         try {
            var5 = var4.beginTransaction();
            if ((this.livraisonEnteteVentes.getBlvEtat() == 1 || this.livraisonEnteteVentes.getBlvEtat() == 4 || this.livraisonEnteteVentes.getBlvEtat() == 5) && this.livraisonEnteteVentes.getBlvLivreeEtat() <= 1 && this.habilitation == null) {
               new LivraisonLigneVentes();
               if (this.lesLivraisonLivree.size() != 0) {
                  int var7 = 0;

                  while(true) {
                     if (var7 >= this.lesLivraisonLivree.size()) {
                        var3 = true;
                        break;
                     }

                     this.livraisonLivreeVentes = (LivraisonLivreeVentes)this.lesLivraisonLivree.get(var7);
                     String var8 = this.livraisonLivreeVentes.getBlvlivCode();
                     String var9 = this.livraisonLivreeVentes.getBlvlivDepot();
                     this.produits = this.produitsDao.chargeProduit(this.livraisonLivreeVentes.getBlvlivCode(), var4);
                     if (this.produits != null) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.livraisonLivreeVentes.getBlvlivCode(), this.livraisonLivreeVentes.getBlvlivDepot(), var4);
                        if (this.produitsDepot != null) {
                           this.livraisonLivreeVentes.setBlvlivPreparateur(this.var_preparateur);
                           this.livraisonLivreeVentes.setBlvlivChauffeur(this.var_chauffeur);
                           this.livraisonLivreeVentes.setBlvlivVehicule(this.var_vehicule);
                           this.livraisonLivreeVentes.setBlvlivDate(this.var_date_livree);
                           if (this.livraisonLivreeVentes.getBlvlivDate().before(this.livraisonEnteteVentes.getBlvDate())) {
                              this.livraisonLivreeVentes.setBlvlivDate(this.livraisonEnteteVentes.getBlvDate());
                           }

                           this.livraisonLivreeVentes.setBlvlivQteUtilLivree(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.livraisonLigneVentes.getBlvligCondition(), this.livraisonLivreeVentes.getBlvlivQteLivree(), this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, this.utilInitHibernate, var4));
                           if (this.livraisonLivreeVentes.getBlvlivId() == 0L) {
                              this.livraisonLivreeVentes = this.livraisonLivreeVentesDao.insertLigne(this.livraisonLivreeVentes, var4);
                           } else {
                              this.livraisonLivreeVentes = this.livraisonLivreeVentesDao.modifLigne(this.livraisonLivreeVentes, var4);
                           }

                           if (this.livraisonLivreeVentes.getBlvlivQteLivree() != 0.0F) {
                              for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
                                 var6 = (LivraisonLigneVentes)this.lesLignesList.get(var10);
                                 if (var6.getBlvligCode().equals(var8) && var6.getBlvligDepot().equals(var9)) {
                                    long var11 = var6.getBlvligId();
                                    var6 = this.livraisonLigneVentesDao.rechercheLivraison(var11, var4);
                                    if (var6 != null) {
                                       var6.setBlvligQteStock(this.livraisonLivreeVentes.getVar_qteDejaLiv() + this.livraisonLivreeVentes.getBlvlivQteLivree());
                                       var6.setBlvligQteUtilStock(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, var6.getBlvligCondition(), var6.getBlvligQteStock(), var6.getBlvligLong(), var6.getBlvligLarg(), var6.getBlvligHaut(), var6.getBlvligDiam(), var6.getBlvligNb(), this.baseLog, this.utilInitHibernate, var4));
                                       this.livraisonLigneVentesDao.modif(var6, var4);
                                    }
                                    break;
                                 }
                              }
                           }
                        }
                     }

                     ++var7;
                  }
               }
            }

            var5.commit();
         } catch (HibernateException var25) {
            if (var5 != null) {
               var5.rollback();
            }

            var3 = false;
            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var3) {
            var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
            var6 = null;

            try {
               Transaction var27 = var4.beginTransaction();
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(var1, var4);
               if (this.habilitation == null) {
                  this.chargerDocumentLigne(var4);
                  float var28 = 0.0F;
                  float var29 = 0.0F;
                  if (this.lesLignesList.size() != 0) {
                     for(int var30 = 0; var30 < this.lesLignesList.size(); ++var30) {
                        var28 += ((LivraisonLigneVentes)this.lesLignesList.get(var30)).getBlvligQte();
                        var29 += ((LivraisonLigneVentes)this.lesLignesList.get(var30)).getBlvligQteStock();
                     }
                  }

                  if (var28 == var29 && var28 != 0.0F && var29 != 0.0F) {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(2);
                  } else if (var29 == 0.0F) {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(0);
                  } else {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(1);
                  }

                  this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var4);
               }

               var27.commit();
            } catch (HibernateException var23) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var23;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.showModalPanelLivraison = false;
      }

   }

   public void qteLivQteOrg() throws ParseException {
      if (this.lesLivraisonLivree.size() != 0) {
         new LivraisonLivreeVentes();

         for(int var2 = 0; var2 < this.lesLivraisonLivree.size(); ++var2) {
            LivraisonLivreeVentes var1 = (LivraisonLivreeVentes)this.lesLivraisonLivree.get(var2);
            float var3 = this.livraisonLigneVentes.getBlvligQte() - this.livraisonLivreeVentes.getVar_qteDejaLiv();
            var1.setBlvlivQteLivree(var3);
            var1 = (LivraisonLivreeVentes)this.lesLivraisonLivree.set(var2, var1);
         }

         this.valide_livreur = true;
         this.dataModelLivraison.setWrappedData(this.lesLivraisonLivree);
      }

   }

   public void razQteLiv() throws ParseException {
      if (this.lesLivraisonLivree.size() != 0) {
         new LivraisonLivreeVentes();

         for(int var2 = 0; var2 < this.lesLivraisonLivree.size(); ++var2) {
            LivraisonLivreeVentes var1 = (LivraisonLivreeVentes)this.lesLivraisonLivree.get(var2);
            var1.setBlvlivQteLivree(0.0F);
            var1 = (LivraisonLivreeVentes)this.lesLivraisonLivree.set(var2, var1);
         }

         this.valide_livreur = false;
         this.dataModelLivraison.setWrappedData(this.lesLivraisonLivree);
      }

   }

   public void annulationLivraison() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.livraisonEnteteVentes.getBlvEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.livraisonEnteteVentes.setBlvEtat(0);
            }

            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
            this.calculStock.majLivraisonVentesVAL(this.lesLignesList, 2, this.baseLog, var1);
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

   public void annuleValide() {
      this.setShowModalPanelLivraison(false);
   }

   public void verifRelcat() {
      if (this.lesLivraisonLivree != null) {
         float var1 = this.livraisonLigneVentes.getBlvligQte() - this.livraisonLigneVentes.getVar_qteDejaLiv();
         float var2 = this.verifQteDisponibleBl(this.livraisonLigneVentes);
         if (var1 > var2 && this.structureLog.getStrstockNegatif() == 2 && this.livraisonLigneVentes.getBlvligDepot() != null && !this.livraisonLigneVentes.getBlvligDepot().isEmpty() && this.livraisonLigneVentes.getBlvligStock() != 0) {
            var1 = var2;
         }

         if (this.livraisonLivreeVentes.getBlvlivQteLivree() > var1) {
            this.valide_livreur = false;
         } else {
            this.valide_livreur = true;
         }
      }

   }

   public void mefDateLivree() throws ParseException {
      String var1 = this.utilDate.dateToStringSQLLight(this.var_date_livree);
      this.var_date_livree = this.utilDate.stringToDateSQLLight(var1 + " " + (new Date()).getHours() + ":" + (new Date()).getMinutes() + ":" + (new Date()).getSeconds());
   }

   public void initImpressionLivree() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 5;
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "reliquatBL" + File.separator;
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

      this.showModalPanelPrintLivree = true;
   }

   public void fermerImpressionLivree() {
      this.showModalPanelPrintLivree = false;
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

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.livraisonEnteteVentes.getBlvExoTva() == 0) {
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

      this.livraisonLigneVentes.setBlvligTaxe(var6);
      this.livraisonLigneVentes.setBlvligTauxTaxe(var5);
      double var35 = this.livraisonLigneVentes.getBlvligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.livraisonEnteteVentes.getBlvDevise());
      }

      var10 = this.livraisonLigneVentes.getBlvligQte();
      if (this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.livraisonLigneVentes.setBlvligQteUtil(this.livraisonLigneVentes.getBlvligQte());
            var10 = this.livraisonLigneVentes.getBlvligQte() * this.livraisonLigneVentes.getBlvligLong();
         } else {
            this.livraisonLigneVentes.setBlvligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.livraisonLigneVentes.getBlvligCondition(), this.livraisonLigneVentes.getBlvligQte(), this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.livraisonLigneVentes.setBlvligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.livraisonLigneVentes.getBlvligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.livraisonLigneVentes.getBlvligRabais() * (double)this.livraisonLigneVentes.getBlvligQte();
      }

      if (this.livraisonLigneVentes.getBlvligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.livraisonLigneVentes.getBlvligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.livraisonLigneVentes.getBlvligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.livraisonLigneVentes.getBlvligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.livraisonLigneVentes.getBlvligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.livraisonLigneVentes.getBlvligQte(), 2);
      }

      this.livraisonLigneVentes.setBlvligPuRem(var25);
      this.livraisonLigneVentes.setBlvligPt(var17);
      this.livraisonLigneVentes.setBlvligTva(var21);
      this.livraisonLigneVentes.setBlvligTc(0.0D);
      this.livraisonLigneVentes.setBlvligTtc(var23);
      double var27 = 0.0D;
      if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.livraisonLigneVentes.getBlvligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.livraisonLigneVentes.getBlvligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.livraisonLigneVentes.getBlvligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.livraisonLigneVentes.getBlvligQte(), 2);
      }

      this.livraisonLigneVentes.setBlvligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0D;
      this.livraisonLigneVentes.setBlvligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.livraisonEnteteVentes.setBlvTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.livraisonLigneVentes.setBlvligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
               if (this.livraisonLigneVentes.getBlvligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0D;
                  this.livraisonLigneVentes.setBlvligTc(var33);
               }
            }
         } else {
            if (this.livraisonLigneVentes.getBlvligTva() != 0.0D) {
               var31 = var17 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.livraisonLigneVentes.setBlvligTc(var33);
         }
      } else {
         this.livraisonLigneVentes.setBlvligTc(0.0D);
         this.livraisonEnteteVentes.setBlvTauxTc(0.0F);
      }

      this.livraisonLigneVentes.setBlvligPt(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligPt(), this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligTva(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligTva(), this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligTtc(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligTtc(), this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligTc(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligTc(), this.livraisonEnteteVentes.getBlvDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.livraisonEnteteVentes.getBlvExoTva() == 0) {
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

      this.livraisonLigneVentes.setBlvligTaxe(var6);
      this.livraisonLigneVentes.setBlvligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.livraisonEnteteVentes.getBlvTauxTc() != 0.0F && this.livraisonLigneVentes.getBlvligTva() != 0.0D) {
         var10 = this.livraisonLigneVentes.getBlvligTtc();
         var12 = var10 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.livraisonLigneVentes.getBlvligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.livraisonLigneVentes.getBlvligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.livraisonLigneVentes.setBlvligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.livraisonLigneVentes.getBlvligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.livraisonLigneVentes.getBlvligRabais() * (double)this.livraisonLigneVentes.getBlvligQte();
      }

      double var14 = 0.0D;
      if (this.livraisonLigneVentes.getBlvligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.livraisonLigneVentes.getBlvligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.livraisonLigneVentes.getBlvligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.livraisonLigneVentes.getBlvligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.livraisonLigneVentes.setBlvligQteUtil(this.livraisonLigneVentes.getBlvligQte());
         } else {
            this.livraisonLigneVentes.setBlvligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.livraisonLigneVentes.getBlvligCondition(), this.livraisonLigneVentes.getBlvligQte(), this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.livraisonLigneVentes.setBlvligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.livraisonLigneVentes.getBlvligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.livraisonEnteteVentes.getBlvDevise()));
      double var26 = var20 * (double)this.livraisonLigneVentes.getBlvligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.livraisonEnteteVentes.getBlvDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligPuRem(var18);
      this.livraisonLigneVentes.setBlvligPuRemTtc(var20);
      this.livraisonLigneVentes.setBlvligPt(var24);
      this.livraisonLigneVentes.setBlvligTva(var32);
      this.livraisonLigneVentes.setBlvligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.livraisonEnteteVentes.setBlvTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.livraisonLigneVentes.setBlvligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
               if (this.livraisonLigneVentes.getBlvligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0D;
                  this.livraisonLigneVentes.setBlvligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.livraisonEnteteVentes.getBlvTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.livraisonLigneVentes.setBlvligTc(var36);
         }
      } else {
         this.livraisonLigneVentes.setBlvligTc(0.0D);
         this.livraisonEnteteVentes.setBlvTauxTc(0.0F);
      }

      this.livraisonLigneVentes.setBlvligPt(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligPt(), this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligTva(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligTva(), this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligTtc(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligTtc(), this.livraisonEnteteVentes.getBlvDevise()));
      this.livraisonLigneVentes.setBlvligTc(this.utilNombre.myRoundDevise(this.livraisonLigneVentes.getBlvligTc(), this.livraisonEnteteVentes.getBlvDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      this.messageStockNegatif = "";
      if (this.structureLog.getStrstockNegatif() == 2) {
         if (this.produitsDepot.getProdepQteStk() < this.livraisonLigneVentes.getBlvligQte() && this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
            this.validationLigne = 2;
            this.messageStockNegatif = "Quantité demandée : " + this.livraisonLigneVentes.getBlvligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
            this.formRecherche.setMessageTexte(this.messageStockNegatif);
            this.formRecherche.setShowModalPanelMessage(true);
         } else {
            this.validationLigne = 0;
         }
      } else if (this.structureLog.getStrstockNegatif() == 1) {
         if (this.produitsDepot.getProdepQteStk() < this.livraisonLigneVentes.getBlvligQte() && this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
            this.validationLigne = 1;
            this.messageStockNegatif = "Quantité demandée : " + this.livraisonLigneVentes.getBlvligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
         } else {
            this.validationLigne = 0;
         }
      } else {
         this.validationLigne = 0;
      }

      if (this.produitsDepot.getProdepQteMini() != 0.0F && this.livraisonLigneVentes.getBlvligQte() != 0.0F && this.produitsDepot.getProdepQteMini() >= this.produitsDepot.getProdepQteStk() - this.livraisonLigneVentes.getBlvligQte()) {
         this.messageStockNegatif = "Quantité en stock : " + (this.produitsDepot.getProdepQteStk() - this.livraisonLigneVentes.getBlvligQte()) + " Quantité minimale : " + this.produitsDepot.getProdepQteMini() + " ==> LA QUANTITE MINIMALE A ETE ATTEINTE";
         this.formRecherche.setMessageTexte(this.messageStockNegatif);
         this.formRecherche.setShowModalPanelMessage(true);
      }

      if (this.livraisonLigneVentes != null && this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.livraisonLigneVentes.getBlvligPuRemTtc() != 0.0D) {
               if (this.livraisonLigneVentes.getBlvligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.livraisonLigneVentes.getBlvligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.livraisonLigneVentes.getBlvligPuRem() != 0.0D) {
            if (this.livraisonLigneVentes.getBlvligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.livraisonLigneVentes.getBlvligPu() < this.prixPlancher) {
            this.griserValider = true;
            this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
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
      new LivraisonLigneVentes();

      for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
         LivraisonLigneVentes var13 = (LivraisonLigneVentes)this.lesLignesList.get(var14);
         if (var13.getBlvligGenerique() != 5 && (var13.getBlvligGroupe() == null || var13.getBlvligGroupe().isEmpty())) {
            var3 += var13.getBlvligPt();
            var5 += var13.getBlvligTva();
            var7 += var13.getBlvligTtc();
            var9 += var13.getBlvligTc();
            if (var13.getBlvligRabais() != 0.0D || var13.getBlvligTauxRemise() != 0.0F) {
               var11 += var13.getBlvligPu() * (double)var13.getBlvligQte() - var13.getBlvligPt();
            }

            var1 = var1 + var13.getBlvligPt() - var13.getBlvligPump() * (double)var13.getBlvligQte();
         }
      }

      this.var_total_marge = var1;
      this.livraisonEnteteVentes.setBlvTotHt(var3);
      this.livraisonEnteteVentes.setBlvTotTva(var5);
      this.livraisonEnteteVentes.setBlvTotTtc(var7);
      this.livraisonEnteteVentes.setBlvTotRemise(var11);
      this.livraisonEnteteVentes.setBlvTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      this.produits = null;
      this.listeLot.clear();
      this.listeSerie.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.livraisonLigneVentes = (LivraisonLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         this.var_memo_qte = this.livraisonLigneVentes.getBlvligQteUtil();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         if (this.livraisonLigneVentes.getBlvligCode() != null && this.livraisonLigneVentes.getBlvligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.livraisonLigneVentes.setBlvligCode(this.produits.getProCode());
               this.livraisonLigneVentes.setBlvligFamille(this.produits.getProAchCode());
               this.livraisonLigneVentes.setBlvligStock(this.produits.getProStock());
               this.livraisonLigneVentes.setBlvligLong(this.produits.getProLongueur());
               this.livraisonLigneVentes.setBlvligLarg(this.produits.getProLargeur());
               this.livraisonLigneVentes.setBlvligHaut(this.produits.getProEpaisseur());
               this.livraisonLigneVentes.setBlvligDiam(this.produits.getProDiamExt());
               this.livraisonLigneVentes.setBlvligPoidsBrut(this.produits.getProPoidsBrut());
               this.livraisonLigneVentes.setBlvligPoidsNet(this.produits.getProPoidsNet());
               this.livraisonLigneVentes.setBlvligVolume(this.produits.getProVolume());
               this.livraisonLigneVentes.setBlvligNb(this.produits.getProNbUnite());
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
               if (this.livraisonLigneVentes.getBlvligTaxe() != null && !this.livraisonLigneVentes.getBlvligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTaxe() + ":" + this.livraisonLigneVentes.getBlvligTauxTaxe()));
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
      this.produits = null;
      this.listeLot.clear();
      this.listeSerie.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.livraisonLigneVentes = (LivraisonLigneVentes)this.datamodelLigne.getRowData();
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
      this.livraisonLigneVentes = new LivraisonLigneVentes();
      this.mesTaxesVentesProduits = new ArrayList();
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
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.validationLigne = 0;
      this.messageStockNegatif = "";
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.livraisonLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.livraisonLigneVentes);
            this.lesLignesList.add(this.numLigne, this.livraisonLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var3);
               this.livraisonLigneVentes.setBlvligOrdre(var3);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
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
      if (this.livraisonLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.livraisonLigneVentes);
            this.lesLignesList.add(this.numLigne, this.livraisonLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var3);
               this.livraisonLigneVentes.setBlvligOrdre(var3);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
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
            if (this.livraisonLigneVentes.getBlvligId() == ((LivraisonLigneVentes)this.lesLignesList.get(var2)).getBlvligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() || this.livraisonLigneVentes.getBlvligLibelle() != null && !this.livraisonLigneVentes.getBlvligLibelle().isEmpty() || this.livraisonLigneVentes.getBlvligComplement() != null && !this.livraisonLigneVentes.getBlvligComplement().isEmpty()) {
         if (this.livraisonEnteteVentes.getBlvId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.livraisonLigneVentes.getBlvligQteUtil() == 0.0F) {
               this.livraisonLigneVentes.setBlvligQteUtil(this.livraisonLigneVentes.getBlvligQte());
            }

            this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.livraisonLigneVentes.setBlvligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.livraisonLigneVentes.setBlvligDepot(var3[0]);
               }
            } else {
               this.livraisonLigneVentes.setBlvligDepot("");
            }

            if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.livraisonLigneVentes.getBlvligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.livraisonLigneVentes.setBlvligDescription(var5);
               } else {
                  this.livraisonLigneVentes.setBlvligDescription("");
               }

               if (this.livraisonLigneVentes.getBlvligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.livraisonLigneVentes.setBlvligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.livraisonLigneVentes.setBlvligDescription("");
            }

            if (!this.var_gestion_livreur) {
               this.livraisonLigneVentes.setBlvligQteStock(this.livraisonLigneVentes.getBlvligQte());
               this.livraisonLigneVentes.setBlvligQteUtilStock(this.livraisonLigneVentes.getBlvligQteUtil());
            }

            this.livraisonLigneVentes.setBlvligEntStock(this.livraisonEnteteVentes.getBlvStock());
            if (this.livraisonLigneVentes.getBlvligId() == 0L) {
               this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
               this.livraisonLigneVentes.setBlvligDevise(this.livraisonEnteteVentes.getBlvDevise());
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.insert(this.livraisonLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.livraisonLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
            }

            if (this.produits != null && this.produits.getProStock() >= 1) {
               this.calculStock.majLivraisonVentesATT(this.livraisonLigneVentes, this.produits, this.var_memo_qte, 1, this.baseLog, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new LivraisonLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  LivraisonLigneVentes var16 = (LivraisonLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getBlvligGroupe() != null && !var16.getBlvligGroupe().isEmpty() && var16.getBlvligGroupe().equals(this.memoProduits.getProCode())) {
                     this.livraisonLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.livraisonLigneVentes.getBlvligQte();
               new LivraisonLigneVentes();

               LivraisonLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (LivraisonLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getBlvligGroupe() != null && !var19.getBlvligGroupe().isEmpty() && var19.getBlvligGroupe().equals(var18)) {
                     this.livraisonLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new LivraisonLigneVentes();
                     var19.setBlvligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setBlvligCondition("");
                     var19.setBlvligComplement("");
                     var19.setBlvligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setBlvligDescription("");
                     var19.setBlvligDevise(this.livraisonEnteteVentes.getBlvDevise());
                     var19.setBlvligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setBlvligEchelle(0);
                     var19.setBlvligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setBlvligGroupe(var18);
                     var19.setBlvligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setBlvligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setBlvligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setBlvligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setBlvligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setBlvligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setBlvligOrdre(var8);
                     var19.setBlvligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setBlvligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setBlvligPt(0.0D);
                     var19.setBlvligPu(0.0D);
                     var19.setBlvligPuRem(0.0D);
                     var19.setBlvligPuRemTtc(0.0D);
                     var19.setBlvligPuTtc(0.0D);
                     var19.setBlvligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setBlvligQte(var9);
                     var19.setBlvligQteStock(var9);
                     var19.setBlvligQteUtil(var19.getBlvligQte());
                     var19.setBlvligRabais(0.0D);
                     var19.setBlvligReference(var18);
                     var19.setBlvligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setBlvligTauxRemise(0.0F);
                     var19.setBlvligTauxTaxe(0.0F);
                     var19.setBlvligTaxe("");
                     var19.setBlvligTc(0.0D);
                     var19.setBlvligTtc(0.0D);
                     var19.setBlvligTva(0.0D);
                     var19.setBlvligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setBlvligVolume(0.0F);
                     var19.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
                     var19 = this.livraisonLigneVentesDao.insert(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
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

      this.addLigne();
   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.livraisonLigneVentes.getBlvligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
         Transaction var2 = null;

         List var3;
         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            var3 = this.livraisonLivreeVentesDao.chargerLesLivraisons(this.livraisonLigneVentes, var1);
            if (var3.size() != 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  this.livraisonLivreeVentes = (LivraisonLivreeVentes)var3.get(var4);
                  this.livraisonLivreeVentesDao.deleteLigne(var3, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var21) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
         var3 = null;

         try {
            Transaction var23 = var1.beginTransaction();
            String var24 = this.livraisonLigneVentes.getBlvligCode();
            int var5 = this.livraisonLigneVentes.getBlvligModeGroupe();
            String var6 = this.livraisonLigneVentes.getBlvligGroupe();
            new ArrayList();
            List var7 = this.receptionSerieAchatsDao.selectBlSerieByBlLig(this.livraisonLigneVentes, var1);
            if (var7.size() != 0) {
               for(int var8 = 0; var8 < var7.size(); ++var8) {
                  new ReceptionSerieAchats();
                  ReceptionSerieAchats var9 = (ReceptionSerieAchats)var7.get(var8);
                  var9.setRecserEtat(0);
                  var9.setRecserIdLigneBl(0L);
                  var9.setRecserIdTiers(0L);
                  var9.setRecserNomTiers("");
                  var9.setRecserNumBl("");
                  this.receptionSerieAchatsDao.modif(var9, var1);
               }
            }

            this.calculStock.majLivraisonVentesATT(this.livraisonLigneVentes, this.produits, 0.0F, 0, this.baseLog, var1);
            this.livraisonLigneVentesDao.deleteOneLigne(this.livraisonLigneVentes, var1);
            if ((var5 == 1 || var5 == 2) && (var6 == null || var6.isEmpty())) {
               new LivraisonLigneVentes();

               for(int var27 = 0; var27 < this.lesLignesList.size(); ++var27) {
                  LivraisonLigneVentes var25 = (LivraisonLigneVentes)this.lesLignesList.get(var27);
                  if (var25.getBlvligGroupe() != null && !var25.getBlvligGroupe().isEmpty() && var25.getBlvligGroupe().equals(var24)) {
                     this.livraisonLigneVentesDao.deleteOneLigne(var25, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var26 = new Espion();
            var26.setUsers(this.usersLog);
            var26.setEsptype(0);
            var26.setEspdtecreat(new Date());
            var26.setEspaction("Suppression ligne produit " + var24 + " du BL N° " + this.livraisonEnteteVentes.getBlvNum() + " du " + this.livraisonEnteteVentes.getBlvDate());
            this.espionDao.mAJEspion(var26, var1);
            var23.commit();
         } catch (HibernateException var19) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var19;
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

   public void ouvertureSerie() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.livraisonLigneVentes = (LivraisonLigneVentes)this.datamodelLigne.getRowData();
      }

      if (this.livraisonLigneVentes != null && this.livraisonLigneVentes.getBlvligStock() == 5) {
         this.listeSerie.clear();
         this.mesCartonsItems.clear();
         this.mesPalettesItems.clear();
         this.var_type_serie = 0;
         this.listeSerie = this.receptionSerieAchatsDao.selectSerieUtil(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), this.livraisonLigneVentes.getBlvligId(), (Session)null);
         if (this.listeSerie.size() == 0) {
            this.var_liste_vide = false;
            this.var_select_type = false;
         } else {
            for(int var1 = 0; var1 < this.listeSerie.size(); ++var1) {
               this.receptionSerieAchats = new ReceptionSerieAchats();
               this.receptionSerieAchats = (ReceptionSerieAchats)this.listeSerie.get(var1);
               this.receptionSerieAchats.setSelect_serie(true);
            }

            this.var_liste_vide = true;
            this.var_select_type = true;
         }

         this.dataModelSerie.setWrappedData(this.listeSerie);
         this.showModalPanelSerie = true;
      }

   }

   public void typeSerie() throws HibernateException, NamingException {
      if (this.livraisonLigneVentes != null) {
         this.var_liste_vide = false;
         if (this.livraisonLigneVentes.getBlvligStock() == 5) {
            if (this.var_type_serie == 1) {
               this.listeSerie = this.receptionSerieAchatsDao.selectSerieDispo(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), (Session)null);
               if (this.listeSerie.size() != 0) {
                  this.var_liste_vide = true;
               }

               this.dataModelSerie.setWrappedData(this.listeSerie);
            } else if (this.var_type_serie == 2) {
               this.mesCartonsItems = this.receptionSerieAchatsDao.rechercheSerieByCarton(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), (Session)null);
            } else if (this.var_type_serie == 3) {
               this.mesPalettesItems = this.receptionSerieAchatsDao.rechercheSerieByPalette(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), (Session)null);
            }
         }
      }

   }

   public void chargerSerieByCarton() throws HibernateException, NamingException {
      if (this.var_select_carton != null && !this.var_select_carton.isEmpty()) {
         this.listeSerie = this.receptionSerieAchatsDao.selectSerieDispo(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), (Session)null);
         if (this.listeSerie.size() != 0) {
            this.var_liste_vide = true;
         }

         this.dataModelSerie.setWrappedData(this.listeSerie);
      }

   }

   public void chargerSerieByPalette() throws HibernateException, NamingException {
      if (this.var_select_palette != null && !this.var_select_palette.isEmpty()) {
         this.listeSerie = this.receptionSerieAchatsDao.selectSerieDispo(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), (Session)null);
         if (this.listeSerie.size() != 0) {
            this.var_liste_vide = true;
         }

         this.dataModelSerie.setWrappedData(this.listeSerie);
      }

   }

   public void serieToutSelectionne() {
      if (this.listeSerie.size() != 0) {
         for(int var1 = 0; var1 < this.listeSerie.size(); ++var1) {
            this.receptionSerieAchats = new ReceptionSerieAchats();
            this.receptionSerieAchats = (ReceptionSerieAchats)this.listeSerie.get(var1);
            this.receptionSerieAchats.setSelect_serie(true);
         }

         this.dataModelSerie.setWrappedData(this.listeSerie);
      }

   }

   public void serieRienSelectionne() {
      if (this.listeSerie.size() != 0) {
         for(int var1 = 0; var1 < this.listeSerie.size(); ++var1) {
            this.receptionSerieAchats = new ReceptionSerieAchats();
            this.receptionSerieAchats = (ReceptionSerieAchats)this.listeSerie.get(var1);
            this.receptionSerieAchats.setSelect_serie(false);
         }

         this.dataModelSerie.setWrappedData(this.listeSerie);
      }

   }

   public void selectionSerie() {
      if (this.dataModelSerie.isRowAvailable()) {
         this.receptionSerieAchats = (ReceptionSerieAchats)this.dataModelSerie.getRowData();
      }

   }

   public void validationSerie() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         int var3 = 0;

         for(int var4 = 0; var4 < this.listeSerie.size(); ++var4) {
            this.receptionSerieAchats = new ReceptionSerieAchats();
            this.receptionSerieAchats = (ReceptionSerieAchats)this.listeSerie.get(var4);
            if (this.receptionSerieAchats.isSelect_serie()) {
               ++var3;
               this.receptionSerieAchats.setRecserDateOut(new Date());
               this.receptionSerieAchats.setRecserEtat(1);
               this.receptionSerieAchats.setRecserIdLigneBl(this.livraisonLigneVentes.getBlvligId());
               this.receptionSerieAchats.setRecserNumBl(this.livraisonEnteteVentes.getBlvNum());
               this.receptionSerieAchats.setRecserIdTiers(this.tiers.getTieid());
               this.receptionSerieAchats.setRecserNomTiers(this.tiers.getTieraisonsocialenom());
               this.receptionSerieAchats.setRecserPv(this.livraisonLigneVentes.getBlvligPuRem());
            } else {
               this.receptionSerieAchats.setRecserDateOut((Date)null);
               this.receptionSerieAchats.setRecserEtat(0);
               this.receptionSerieAchats.setRecserIdLigneBl(0L);
               this.receptionSerieAchats.setRecserNumBl("");
               this.receptionSerieAchats.setRecserIdTiers(0L);
               this.receptionSerieAchats.setRecserNomTiers("");
               this.receptionSerieAchats.setRecserPv(0.0D);
            }

            this.receptionSerieAchats = this.receptionSerieAchatsDao.modif(this.receptionSerieAchats, var1);
         }

         this.livraisonLigneVentes.setBlvligNumSerie("SERIE");
         this.livraisonLigneVentes.setBlvligQte((float)var3);
         this.livraisonLigneVentes.setBlvligQteUtil((float)var3);
         this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var1);
         this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
         this.cumulPrix();
         this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelSerie = false;
      this.addLigne();
   }

   public void fermetureSerie() {
      this.showModalPanelSerie = false;
   }

   public void ouvertureLot() throws HibernateException, NamingException {
      if (this.livraisonLigneVentes != null && (this.livraisonLigneVentes.getBlvligStock() == 2 || this.livraisonLigneVentes.getBlvligStock() == 3 || this.livraisonLigneVentes.getBlvligStock() == 4)) {
         this.var_memo_lot = this.livraisonLigneVentes.getBlvligLot();
         this.var_memo_qtelot = this.livraisonLigneVentes.getBlvligQte();
         this.receptionLotAchats = new ReceptionLotAchats();
         this.listeLot.clear();
         this.listeLot = this.receptionLotAchatsDao.selectLotDispo(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), this.var_memo_lot, (Session)null);
         this.dataModelLot.setWrappedData(this.listeLot);
         this.showModalPanelLot = true;
      }

   }

   public void selectionLot() {
      this.var_validation_lot = false;
      if (this.dataModelLot.isRowAvailable()) {
         this.receptionLotAchats = (ReceptionLotAchats)this.dataModelLot.getRowData();
      }

   }

   public void validationLot() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.var_memo_lot == null || this.var_memo_lot.isEmpty() || !this.var_memo_lot.equalsIgnoreCase(this.receptionLotAchats.getReclotNumero())) {
            this.receptionLotAchats.setReclotQteConso(this.receptionLotAchats.getReclotQteConso() + this.livraisonLigneVentes.getBlvligQte());
            this.receptionLotAchats = this.receptionLotAchatsDao.modif(this.receptionLotAchats, var1);
            if (this.var_memo_lot != null && !this.var_memo_lot.isEmpty() && !this.var_memo_lot.equalsIgnoreCase(this.receptionLotAchats.getReclotNumero())) {
               new ReceptionLotAchats();
               ReceptionLotAchats var3 = this.receptionLotAchatsDao.rechercheLot(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), this.var_memo_lot, var1);
               if (var3 != null) {
                  var3.setReclotQteConso(var3.getReclotQteConso() - this.var_memo_qtelot);
                  this.receptionLotAchatsDao.modif(var3, var1);
               }
            }

            this.livraisonLigneVentes.setBlvligLot(this.receptionLotAchats.getReclotNumero());
            this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
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

      this.showModalPanelLot = false;
   }

   public void fermetureLot() {
      this.showModalPanelLot = false;
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.livraisonEnteteVentes.getBlvNomTiers(), this.nature);
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
         boolean var2 = false;
         if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
            if (this.tiers.getTieserie().equals("X")) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.mesSerieUserItem.size(); ++var3) {
                  if (((SelectItem)this.mesSerieUserItem.get(var3)).getValue().toString().equals(this.tiers.getTieserie())) {
                     var2 = true;
                     this.livraisonEnteteVentes.setBlvSerie(this.tiers.getTieserie());
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
            this.livraisonEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.livraisonEnteteVentes.setBlvCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.livraisonEnteteVentes.setBlvCivilTiers(this.livraisonEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.livraisonEnteteVentes.setBlvNomTiers(this.nomTier);
            this.livraisonEnteteVentes.setBlvTypeReg(this.tiers.getTietypereg());
            this.livraisonEnteteVentes.setBlvModeReg(this.tiers.getTiemodereg());
            this.calculMessageLitige();
            String var8 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var8 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var8 = this.tiers.getTiemodereg();
            }

            int var9;
            if (!var8.equals("") && !var8.equals("100")) {
               this.livraisonEnteteVentes.setBlvNbJourReg(this.tiers.getTienbecheance());
               this.livraisonEnteteVentes.setBlvArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.livraisonEnteteVentes.setBlvTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.livraisonEnteteVentes.setBlvModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.livraisonEnteteVentes.setBlvNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.livraisonEnteteVentes.setBlvArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.livraisonEnteteVentes.setBlvJournalReg(this.tiers.getTiejournalreg());
            this.livraisonEnteteVentes.setBlvCat(this.tiers.getTienomfamille());
            this.livraisonEnteteVentes.setBlvExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.livraisonEnteteVentes.setBlvExoDouane(1);
            }

            var9 = this.tiers.getTieexotva();
            if (var9 >= 2) {
               var9 = 0;
            }

            this.livraisonEnteteVentes.setBlvExoTva(var9);
            if (this.var_tc_calcul) {
               this.livraisonEnteteVentes.setBlvTauxTc(this.var_tc_taux);
            } else {
               this.livraisonEnteteVentes.setBlvTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.livraisonEnteteVentes.setBlvExoTva(1);
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
               this.livraisonEnteteVentes.setBlvDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.livraisonEnteteVentes.setBlvDiversTiers(0);
               this.livraisonEnteteVentes.setBlvDiversNom("");
               this.livraisonEnteteVentes.setBlvDiversAdresse("");
               this.livraisonEnteteVentes.setBlvDiversVille("");
               this.livraisonEnteteVentes.setBlvDiversTel("");
               this.livraisonEnteteVentes.setBlvDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.livraisonEnteteVentes.setBlvDevise(this.tiers.getTiedevise());
            } else {
               this.livraisonEnteteVentes.setBlvDevise(this.structureLog.getStrdevise());
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

   public void calculMessageLitige() {
      this.informationsTiers = null;
      if (this.tiers != null) {
         String var1 = "";
         if (this.tiers.getTiecomptebloque() == 1) {
            var1 = "***   COMPTE BLOQUE   ***";
         } else if (this.tiers.getTiechequeinterdit() == 1) {
            var1 = "***   CHEQUE INTERDIT   ***";
         }

         String var2 = this.tiers.getTieobservations();
         if (var1 != null && !var1.isEmpty()) {
            this.informationsTiers = var1;
         }

         if (var2 != null && !var2.isEmpty()) {
            if (this.informationsTiers != null && !this.informationsTiers.isEmpty()) {
               this.informationsTiers = this.informationsTiers + " (" + var2 + ")";
            } else {
               this.informationsTiers = "(" + var2 + ")";
            }
         }
      }

   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      this.informationsTiers = null;
      this.livraisonEnteteVentes.setTiers(this.tiers);
      this.livraisonEnteteVentes.setBlvNomTiers("");
      this.livraisonEnteteVentes.setBlvCivilTiers("");
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
      if (!this.livraisonEnteteVentes.getBlvNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.livraisonEnteteVentes.getBlvCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.livraisonEnteteVentes.setBlvExoTva(0);
      } else {
         this.livraisonEnteteVentes.setBlvExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.livraisonEnteteVentes.setBlvExoDouane(0);
      } else {
         this.livraisonEnteteVentes.setBlvExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.livraisonEnteteVentes.setBlvTauxTc(this.var_tc_taux);
      } else {
         this.livraisonEnteteVentes.setBlvTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var4);
               if (this.livraisonEnteteVentes.getBlvExoTva() == 1) {
                  this.livraisonLigneVentes.setBlvligTaxe("");
                  this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
                  this.livraisonLigneVentes.setBlvligTva(0.0D);
               } else if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                  new Produits();
                  Produits var5 = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var2);
                  TaxesVentes var6;
                  if (var5 != null) {
                     if (var5.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.livraisonLigneVentes.setBlvligTaxe("");
                        this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
                     } else {
                        if (var5.getProVteTva() != null && !var5.getProVteTva().isEmpty()) {
                           this.livraisonLigneVentes.setBlvligTaxe(var5.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var5, var2);
                           if (this.famillesProduitsVentes != null) {
                              this.livraisonLigneVentes.setBlvligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var6 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.livraisonLigneVentes.getBlvligTaxe(), var2);
                        if (var6 != null) {
                           this.livraisonLigneVentes.setBlvligTauxTaxe(var6.getTaxvteTaux());
                        } else {
                           this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var6 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var2);
                     if (var6 != null) {
                        this.livraisonLigneVentes.setBlvligTaxe(this.optionsVentes.getTvaDefaut());
                        this.livraisonLigneVentes.setBlvligTauxTaxe(var6.getTaxvteTaux());
                     } else {
                        this.livraisonLigneVentes.setBlvligTaxe("");
                        this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
                     }
                  } else {
                     this.livraisonLigneVentes.setBlvligTaxe("");
                     this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
                  }

                  if ((this.livraisonLigneVentes.getBlvligTaxe() == null || this.livraisonLigneVentes.getBlvligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var6 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var2);
                     if (var6 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var6.getTaxvteCode(), var6.getTaxvteCode() + ":" + var6.getTaxvteTaux()));
                        this.livraisonLigneVentes.setBlvligTaxe(var6.getTaxvteCode());
                        this.livraisonLigneVentes.setBlvligTauxTaxe(var6.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var2);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var2);
            }
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var19) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var19;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.livraisonEnteteVentes.getBlvId() != 0L) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         Transaction var21 = null;

         try {
            var21 = var2.beginTransaction();
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var2);
            var21.commit();
         } catch (HibernateException var17) {
            if (var21 != null) {
               var21.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentLigne((Session)null);
         this.cumulPrix();
      }

   }

   public void calculeRemiseGlobale() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.livraisonLigneVentes = new LivraisonLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var3);
               this.livraisonLigneVentes.setBlvligTauxRemise(this.livraisonEnteteVentes.getBlvTauxRemise());
               this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var1);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var1);
            }
         }

         if (this.livraisonEnteteVentes.getBlvId() != 0L) {
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.livraisonEnteteVentes.getBlvNomContact(), this.nature);
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
         this.livraisonEnteteVentes.setBlvNomContact(this.plansAnalytiques.getAnaNomFr());
         this.livraisonEnteteVentes.setBlvCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.livraisonEnteteVentes.setBlvAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.livraisonEnteteVentes.setBlvNomContact("");
      this.livraisonEnteteVentes.setBlvCivilContact("");
      this.livraisonEnteteVentes.setBlvAnal4("");
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
      if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && !this.livraisonLigneVentes.getBlvligCode().equals("-") && !this.livraisonLigneVentes.getBlvligCode().equals("=")) {
         if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.livraisonLigneVentes.getBlvligCode(), this.nature, this.optionsVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.livraisonLigneVentes.getBlvligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         this.livraisonLigneVentes.setBlvligCode(this.produits.getProCode());
         this.livraisonLigneVentes.setBlvligProcess(this.produits.getProProcess());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.livraisonLigneVentes.setBlvligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.livraisonLigneVentes.setBlvligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.livraisonLigneVentes.setBlvligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.livraisonLigneVentes.setBlvligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.livraisonLigneVentes.setBlvligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.livraisonLigneVentes.setBlvligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.livraisonLigneVentes.setBlvligFamille(this.produits.getProVteCode());
         this.livraisonLigneVentes.setBlvligStock(this.produits.getProStock());
         this.livraisonLigneVentes.setBlvligLong(this.produits.getProLongueur());
         this.livraisonLigneVentes.setBlvligLarg(this.produits.getProLargeur());
         this.livraisonLigneVentes.setBlvligHaut(this.produits.getProEpaisseur());
         this.livraisonLigneVentes.setBlvligDiam(this.produits.getProDiamExt());
         this.livraisonLigneVentes.setBlvligPoidsBrut(this.produits.getProPoidsBrut());
         this.livraisonLigneVentes.setBlvligPoidsNet(this.produits.getProPoidsNet());
         this.livraisonLigneVentes.setBlvligVolume(this.produits.getProVolume());
         this.livraisonLigneVentes.setBlvligNb(this.produits.getProNbUnite());
         this.livraisonLigneVentes.setBlvligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.livraisonLigneVentes.setBlvligModeGroupe(this.produits.getProMode());
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
         FamillesProduitsVentes var8 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
         if (!this.produits.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
            TaxesVentes var9;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var9.getTaxvteTaux()));
                  this.livraisonLigneVentes.setBlvligTaxe(this.produits.getProVteTva());
                  this.livraisonLigneVentes.setBlvligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.livraisonLigneVentes.setBlvligTaxe("");
                  this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.livraisonLigneVentes.setBlvligTaxe(var8.getFamvteTaxe());
                  this.livraisonLigneVentes.setBlvligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.livraisonLigneVentes.setBlvligTaxe("");
               this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.livraisonEnteteVentes.getBlvExoTva() == 0 && (this.livraisonLigneVentes.getBlvligTaxe() == null || this.livraisonLigneVentes.getBlvligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.livraisonLigneVentes.setBlvligTaxe(var9.getTaxvteCode());
                  this.livraisonLigneVentes.setBlvligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.livraisonLigneVentes.setBlvligTaxe("");
            this.livraisonLigneVentes.setBlvligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.livraisonLigneVentes.getBlvligTauxTaxe() / 100.0D;
               this.prixPlancher = this.utilNombre.myRound(var6, 2);
            } else {
               this.prixPlancher = this.utilNombre.myRound(this.produitsDepot.getProdepPr() / (double)var10, 2);
            }
         } else {
            this.prixPlancher = 0.0D;
         }

         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.livraisonLigneVentes.setBlvligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.livraisonLigneVentes.setBlvligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.livraisonLigneVentes.setBlvligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.livraisonLigneVentes.setBlvligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.livraisonLigneVentes.setBlvligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.livraisonLigneVentes.getBlvligPump() != 0.0D) {
            this.livraisonLigneVentes.setBlvligPu(this.livraisonLigneVentes.getBlvligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var1);
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
      if (this.livraisonLigneVentes.getBlvligCode() == null || this.livraisonLigneVentes.getBlvligCode().isEmpty() || this.livraisonLigneVentes.getBlvligCode().length() < 2) {
         if (this.livraisonEnteteVentes.getBlvExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.livraisonLigneVentes.setBlvligTaxe(this.optionsVentes.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.livraisonLigneVentes.setBlvligCode("");
      this.livraisonLigneVentes.setBlvligLibelle("");
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            var2 = this.livraisonLigneVentes.getBlvligPuTtc();
         } else {
            var2 = this.livraisonLigneVentes.getBlvligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.livraisonLigneVentes.setBlvligPuTtc(this.prixUnitaires);
            this.livraisonLigneVentes.setBlvligPuRemTtc(this.prixUnitaires);
         } else {
            this.livraisonLigneVentes.setBlvligPu(this.prixUnitaires);
            this.livraisonLigneVentes.setBlvligPuRem(this.prixUnitaires);
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

               if (var4 != 0.0D) {
                  this.prixUnitaires = var4;
               }

               if (this.prixUnitaires == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        this.prixUnitaires = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var7 != null && var7.getBarId() != 0L) {
                  double var11;
                  if (var6.getBarRemise() != 0.0F) {
                     this.livraisonLigneVentes.setBlvligTauxRemise(var6.getBarRemise());
                     this.livraisonLigneVentes.setBlvligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.livraisonEnteteVentes.getBlvDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.livraisonLigneVentes.setBlvligPuTtc(this.prixUnitaires);
                        this.livraisonLigneVentes.setBlvligPuRemTtc(var11);
                     } else {
                        this.livraisonLigneVentes.setBlvligPu(this.prixUnitaires);
                        this.livraisonLigneVentes.setBlvligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.livraisonLigneVentes.setBlvligTauxRemise(var6.getBarRemise());
                     this.livraisonLigneVentes.setBlvligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.livraisonLigneVentes.getBlvligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.livraisonLigneVentes.setBlvligPuTtc(this.prixUnitaires);
                        this.livraisonLigneVentes.setBlvligPuRemTtc(var11);
                     } else {
                        this.livraisonLigneVentes.setBlvligPu(this.prixUnitaires);
                        this.livraisonLigneVentes.setBlvligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.livraisonLigneVentes.setBlvligTauxRemise(var6.getBarRemise());
                     this.livraisonLigneVentes.setBlvligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.livraisonLigneVentes.setBlvligPuTtc(this.prixUnitaires);
                        this.livraisonLigneVentes.setBlvligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.livraisonLigneVentes.setBlvligPu(this.prixUnitaires);
                        this.livraisonLigneVentes.setBlvligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.livraisonLigneVentes.setBlvligPuTtc(this.prixUnitaires);
                     this.livraisonLigneVentes.setBlvligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.livraisonLigneVentes.setBlvligPu(this.prixUnitaires);
                     this.livraisonLigneVentes.setBlvligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((LivraisonLigneVentes)this.lesLignesList.get(var9)).getBlvligCode() == null || ((LivraisonLigneVentes)this.lesLignesList.get(var9)).getBlvligCode().isEmpty() || !((LivraisonLigneVentes)this.lesLignesList.get(var9)).getBlvligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((LivraisonLigneVentes)this.lesLignesList.get(var9)).getBlvligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((LivraisonLigneVentes)this.lesLignesList.get(var8)).getBlvligFamille() != null && !((LivraisonLigneVentes)this.lesLignesList.get(var8)).getBlvligFamille().isEmpty() && ((LivraisonLigneVentes)this.lesLignesList.get(var8)).getBlvligFamille().equals(var7)) {
                  var5 += ((LivraisonLigneVentes)this.lesLignesList.get(var8)).getBlvligPt();
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
         double var2 = this.livraisonLigneVentes.getBlvligPu();
         double var4 = this.livraisonLigneVentes.getBlvligPuTtc();
         if (this.livraisonLigneVentes.getBlvligPu() >= 0.0D && this.livraisonLigneVentes.getBlvligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.livraisonEnteteVentes.getBlvCat(), (String)null, var1);
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
                     if (this.livraisonLigneVentes.getBlvligQte() >= var7.getQteDebut() && this.livraisonLigneVentes.getBlvligQte() <= var7.getQteFin()) {
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
                        if (this.livraisonLigneVentes.getBlvligQte() >= var7.getQteDebut() && this.livraisonLigneVentes.getBlvligQte() <= var7.getQteFin()) {
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
            var2 = Math.abs(this.livraisonLigneVentes.getBlvligPu());
            var4 = Math.abs(this.livraisonLigneVentes.getBlvligPuTtc());
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
      this.livraisonLigneVentes.setBlvligUnite(this.produitsDepot.getProdepUnite());
   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      this.messageStockNegatif = "";
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
               this.validationLigne = 0;
            } else {
               this.var_code_unite = this.produitsDepot.getProdepEchelle();
               if (this.structureLog.getStrstockNegatif() == 2) {
                  if (this.produitsDepot.getProdepQteStk() < this.livraisonLigneVentes.getBlvligQte() && this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
                     this.validationLigne = 2;
                     this.messageStockNegatif = "Quantité demandée : " + this.livraisonLigneVentes.getBlvligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                     this.formRecherche.setMessageTexte(this.messageStockNegatif);
                     this.formRecherche.setShowModalPanelMessage(true);
                  } else {
                     this.validationLigne = 0;
                  }
               } else if (this.structureLog.getStrstockNegatif() == 1) {
                  if (this.produitsDepot.getProdepQteStk() < this.livraisonLigneVentes.getBlvligQte() && this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
                     this.validationLigne = 1;
                     this.messageStockNegatif = "Quantité demandée : " + this.livraisonLigneVentes.getBlvligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                  } else {
                     this.validationLigne = 0;
                  }
               } else {
                  this.validationLigne = 0;
               }
            }
         } else {
            this.produitsDepot = null;
            this.var_depotProd = "";
            this.var_code_unite = 0;
            this.validationLigne = 0;
         }
      } else {
         this.produitsDepot = null;
         this.var_depotProd = "";
         this.var_code_unite = 0;
         this.validationLigne = 0;
      }

      if (this.produitsDepot != null) {
         double var9 = 0.0D;
         float var4;
         if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.livraisonLigneVentes.getBlvligEchelle());
            float var5 = 1.0F;
            if (this.livraisonLigneVentes.getBlvligCondition().contains("/")) {
               String[] var6 = this.livraisonLigneVentes.getBlvligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && !this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.livraisonLigneVentes.getBlvligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.livraisonLigneVentes.setBlvligPump(var9);
      } else {
         this.livraisonLigneVentes.setBlvligPump(0.0D);
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
         String var2 = this.livraisonLigneVentes.getBlvligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.livraisonLigneVentes.setBlvligEchelle(this.unite.getUniEchelle());
               } else {
                  this.livraisonLigneVentes.setBlvligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.livraisonLigneVentes.setBlvligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.livraisonLigneVentes.setBlvligEchelle(Integer.parseInt(var2));
         } else {
            this.livraisonLigneVentes.setBlvligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, var1);
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
      if (Math.abs(this.montantElmTotBonEnc) <= Math.abs(this.livraisonEnteteVentes.getBlvTotTtc() - this.var_tot_bon_encaissement)) {
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
            this.modeSelectTrf();
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

      this.var_serie_trf = this.livraisonEnteteVentes.getBlvSerie();
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
      }

      if (this.var_type_trf >= 20 && this.var_type_trf <= 27) {
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

   }

   public void modeSelectTrf() {
      if (this.var_mode_trf.equals("100")) {
         this.var_aff_trf = false;
      } else if (this.var_type_trf != 100) {
         this.var_aff_trf = true;
      } else {
         this.var_aff_trf = false;
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
      this.var_imput_serie = this.livraisonEnteteVentes.getBlvSerie();
      this.var_imput_cat = this.livraisonEnteteVentes.getBlvCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new LivraisonEnteteVentes();
         LivraisonEnteteVentes var1 = this.livraisonEnteteVentesDao.pourParapheur(this.var_imput_num, this.livraisonEnteteVentes.getBlvSerie(), (Session)null);
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
      int var23;
      Espion var24;
      Parapheur var25;
      if (this.var_imput_choix == 0) {
         if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.livraisonEnteteVentes.getBlvNum();
               this.livraisonEnteteVentes.setBlvNum(this.var_imput_num);
               this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
               if (this.livraisonEnteteVentes.getBlvTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.livraisonEnteteVentes.getBlvNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
               if (var4 != null) {
                  for(var23 = 0; var23 < var4.size(); ++var23) {
                     new Parapheur();
                     var25 = (Parapheur)var4.get(var23);
                     var25.setPhrNum(this.livraisonEnteteVentes.getBlvNum());
                     this.parapheurDao.modif(var25, var1);
                  }
               }

               var24 = new Espion();
               var24.setUsers(this.usersLog);
               var24.setEsptype(0);
               var24.setEspdtecreat(new Date());
               var24.setEspaction("Imputation Livraison N° " + var3 + " en Livraison N° " + this.livraisonEnteteVentes.getBlvNum());
               this.espionDao.mAJEspion(var24, var1);
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
      } else if (!this.var_imput_serie.equalsIgnoreCase("X") && !this.var_imput_serie.equals(this.livraisonEnteteVentes.getBlvSerie())) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.livraisonEnteteVentes.getBlvNum();
            this.livraisonEnteteVentes.setBlvSerie(this.var_imput_serie);
            this.livraisonEnteteVentes.setBlvCat(this.var_imput_cat);
            this.livraisonEnteteVentes.setBlvNum(this.calculChrono.numCompose(this.livraisonEnteteVentes.getBlvDate(), this.nature, this.livraisonEnteteVentes.getBlvSerie(), var1));
            if (!this.var_imput_serie.equals("A")) {
               this.livraisonEnteteVentes.setBlvEtat(1);
               if (!this.var_gestion_livreur) {
                  this.livraisonEnteteVentes.setBlvLivreeEtat(2);
               } else {
                  float var22 = 0.0F;
                  if (this.lesLivraisonLivree.size() != 0) {
                     for(var23 = 0; var23 < this.lesLivraisonLivree.size(); ++var23) {
                        var22 += ((LivraisonLivreeVentes)this.lesLivraisonLivree.get(var23)).getBlvlivQteUtilLivree();
                     }
                  }

                  float var26 = 0.0F;
                  if (this.lesLignesList.size() != 0) {
                     for(var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                        var26 += ((LivraisonLigneVentes)this.lesLignesList.get(var6)).getBlvligQteUtilStock();
                     }
                  }

                  if (var22 == 0.0F) {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(0);
                  } else if (var22 < var26) {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(1);
                  } else {
                     this.livraisonEnteteVentes.setBlvLivreeEtat(2);
                  }
               }
            }

            this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
            if (this.livraisonEnteteVentes.getBlvTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.livraisonEnteteVentes.getBlvNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
            if (var4 != null) {
               for(var23 = 0; var23 < var4.size(); ++var23) {
                  new Parapheur();
                  var25 = (Parapheur)var4.get(var23);
                  var25.setPhrNum(this.livraisonEnteteVentes.getBlvNum());
                  this.parapheurDao.modif(var25, var1);
               }
            }

            var24 = new Espion();
            var24.setUsers(this.usersLog);
            var24.setEsptype(0);
            var24.setEspdtecreat(new Date());
            var24.setEspaction("Imputation BL X N° " + var3 + " en BL " + this.livraisonEnteteVentes.getBlvSerie() + " N° " + this.livraisonEnteteVentes.getBlvNum());
            this.espionDao.mAJEspion(var24, var1);
            if (!this.var_imput_serie.equals("A")) {
               if (!this.var_gestion_livreur) {
                  this.livraisonLivreeVentesDao.deleteLigne(this.lesLivraisonLivree, var1);
                  this.lesLivraisonLivree.clear();
               }

               this.calculStock.majLivraisonVentesVAL(this.lesLignesList, 1, this.baseLog, var1);
            }

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

         new LivraisonLigneVentes();

         for(int var4 = 0; var4 < this.documentDetailTrf.size(); ++var4) {
            LivraisonLigneVentes var11 = (LivraisonLigneVentes)this.documentDetailTrf.get(var4);
            float var5 = 0.0F;
            ArrayList var6 = new ArrayList();
            List var7;
            int var8;
            ProduitsDepot var9;
            int var10;
            if (this.var_type_trf == 25) {
               new ArrayList();
               var7 = this.produitsDepotDao.selectProdDepByprod(var11.getBlvligCode(), var1);
               if (var7.size() != 0) {
                  for(var8 = 0; var8 < var7.size(); ++var8) {
                     new ProduitsDepot();
                     var9 = (ProduitsDepot)var7.get(var8);
                     if (var9.getDepot().getDpoRetourVent() == 1) {
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

               FactureLigneVentesDao var14 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var5 = var14.chargerLesReliquatsLivraisonVtes(var11.getBlvligId(), var1);
            } else if (this.var_type_trf == 24) {
               new ArrayList();
               var7 = this.produitsDepotDao.selectProdDepByprod(var11.getBlvligCode(), var1);
               if (var7.size() != 0) {
                  for(var8 = 0; var8 < var7.size(); ++var8) {
                     new ProduitsDepot();
                     var9 = (ProduitsDepot)var7.get(var8);
                     if (var9.getDepot().getDpoRetourVent() == 1) {
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

               RetourLigneVentesDao var13 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var5 = var13.chargerLesReliquatsLivraisonVtes(var11.getBlvligId(), var1);
            }

            float var12 = var11.getBlvligQte() - var5;
            if (var12 < 0.0F) {
               var12 = 0.0F;
            }

            var11.setVar_qteDejaTrf(var5);
            var11.setVar_listDepotItem(var6);
            var11.setVar_qteReliquat(var12);
            var11 = (LivraisonLigneVentes)this.documentDetailTrf.set(var4, var11);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new LivraisonLigneVentes();
            LivraisonLigneVentes var2 = (LivraisonLigneVentes)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            this.verifQteDisponibleBl(var2);
            var2 = (LivraisonLigneVentes)this.documentDetailTrf.set(var1, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public float verifQteDisponibleBl(LivraisonLigneVentes var1) {
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

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         ArrayList var2 = new ArrayList();
         float var3 = 0.0F;
         float var4 = 0.0F;
         float var5 = 0.0F;

         for(int var6 = 0; var6 < this.documentDetailTrf.size(); ++var6) {
            var4 += ((LivraisonLigneVentes)this.documentDetailTrf.get(var6)).getBlvligQte();
            var3 += ((LivraisonLigneVentes)this.documentDetailTrf.get(var6)).getVar_qteDejaTrf();
            var5 += ((LivraisonLigneVentes)this.documentDetailTrf.get(var6)).getVar_qteReliquat();
         }

         boolean var16 = false;
         if (var4 == var3) {
            new LivraisonEnteteVentes();

            for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
               LivraisonEnteteVentes var7 = (LivraisonEnteteVentes)this.lesEntetesList.get(var8);
               if (var7.isVar_select_ligne()) {
                  var7.setBlvEtat(5);
                  this.livraisonEnteteVentesDao.modif(var7);
               }
            }
         } else {
            var16 = true;
         }

         if (var16 && var5 != 0.0F) {
            ArrayList var17 = new ArrayList();
            new LivraisonEnteteVentes();
            int var9 = 0;

            label200:
            while(true) {
               int var12;
               LivraisonEnteteVentes var19;
               if (var9 >= this.lesEntetesList.size()) {
                  long var20;
                  if (this.var_mode_trf.equals("0")) {
                     var9 = 0;

                     while(true) {
                        if (var9 >= var1.size()) {
                           break label200;
                        }

                        this.livraisonEnteteVentes = (LivraisonEnteteVentes)var1.get(var9);
                        var20 = this.livraisonEnteteVentes.getBlvId();
                        this.lesLignesList.clear();

                        for(var12 = 0; var12 < this.documentDetailTrf.size(); ++var12) {
                           if (((LivraisonEnteteVentes)var1.get(var9)).getBlvNum().equalsIgnoreCase(((LivraisonLigneVentes)this.documentDetailTrf.get(var12)).getLivraisonEnteteVentes().getBlvNum())) {
                              this.lesLignesList.add(this.documentDetailTrf.get(var12));
                           }
                        }

                        if (this.lesLignesList.size() != 0) {
                           this.utilParapheur.supprimerParapheur(this.livraisonEnteteVentes.getBlvId(), this.nature, (Session)null);
                           this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(var20, (Session)null);
                           if (this.livraisonEnteteVentes != null) {
                              if (this.var_type_trf == 25) {
                                 var2.clear();
                                 var2.add(this.livraisonEnteteVentes);
                                 this.trfFac(var2);
                              } else if (this.var_type_trf == 24) {
                                 this.trfRetour();
                              }
                           }
                        }

                        ++var9;
                     }
                  }

                  if (!this.var_mode_trf.equals("1") && !this.var_mode_trf.equals("2")) {
                     break;
                  }

                  for(var9 = 0; var9 < var1.size(); ++var9) {
                     var19 = (LivraisonEnteteVentes)var1.get(var9);
                     this.utilParapheur.supprimerParapheur(var19.getBlvId(), this.nature, (Session)null);
                  }

                  var9 = 0;

                  while(true) {
                     if (var9 >= var17.size()) {
                        break label200;
                     }

                     this.tiers = (Tiers)var17.get(var9);
                     var20 = this.tiers.getTieid();
                     this.lesLignesList.clear();
                     String var21 = "";

                     for(int var13 = 0; var13 < this.documentDetailTrf.size(); ++var13) {
                        if (var20 == ((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes().getTiers().getTieid()) {
                           if (this.var_mode_trf.equals("1")) {
                              if (var21 == null || var21.isEmpty() || !var21.equals(((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes().getBlvNum())) {
                                 var21 = ((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes().getBlvNum();
                                 this.livraisonLigneVentes = new LivraisonLigneVentes();
                                 this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
                                 this.livraisonLigneVentes.setBlvligCode("-");
                                 this.livraisonLigneVentes.setBlvligLibelle("---> Suivant BL N° " + ((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes().getBlvNum());
                                 this.lesLignesList.add(this.livraisonLigneVentes);
                              }

                              this.lesLignesList.add(this.documentDetailTrf.get(var13));
                           } else if (this.var_mode_trf.equals("2")) {
                           }

                           if (var2.size() == 0) {
                              var2.add(((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes());
                           } else {
                              boolean var14 = false;

                              for(int var15 = 0; var15 < var2.size(); ++var15) {
                                 if (((LivraisonEnteteVentes)var2.get(var15)).getBlvNum().equals(((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes().getBlvNum())) {
                                    var14 = true;
                                    break;
                                 }
                              }

                              if (!var14) {
                                 var2.add(((LivraisonLigneVentes)this.documentDetailTrf.get(var13)).getLivraisonEnteteVentes());
                              }
                           }
                        }
                     }

                     if (this.lesLignesList.size() != 0) {
                        this.livraisonEnteteVentes = (LivraisonEnteteVentes)var2.get(0);
                        if (this.tiers != null) {
                           if (this.var_type_trf == 25) {
                              this.trfFac(var2);
                           } else if (this.var_type_trf == 24) {
                              this.trfRetour();
                           }
                        }
                     }

                     ++var9;
                  }
               }

               var19 = (LivraisonEnteteVentes)this.lesEntetesList.get(var9);
               if (var19.isVar_select_ligne()) {
                  String var10 = var19.getTiers().getTieraisonsocialenom();
                  if (this.var_mode_trf.equals("0")) {
                     var1.add(var19);
                  } else if (this.var_mode_trf.equals("1") || this.var_mode_trf.equals("2")) {
                     var1.add(var19);
                     if (var17.size() == 0) {
                        var17.add(var19.getTiers());
                     } else {
                        boolean var11 = false;

                        for(var12 = 0; var12 < var17.size(); ++var12) {
                           if (((Tiers)var17.get(var12)).getTieraisonsocialenom().equals(var10)) {
                              var11 = true;
                              break;
                           }
                        }

                        if (!var11) {
                           var17.add(var19.getTiers());
                        }
                     }
                  }
               }

               ++var9;
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(int var18 = 0; var18 < this.lesEntetesList.size(); ++var18) {
               this.livraisonEnteteVentes = (LivraisonEnteteVentes)this.lesEntetesList.get(var18);
               if (this.livraisonEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.livraisonEnteteVentes);
                  --var18;
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

   public void trfRetour() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         RetourEnteteVentes var3 = new RetourEnteteVentes();
         RetourEnteteVentesDao var4 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         RetourLigneVentesDao var5 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setBrtSerie(this.var_serie_trf);
         } else {
            var3.setBrtSerie(this.livraisonEnteteVentes.getBlvSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setBrtIdCreateur(this.usersLog.getUsrid());
         var3.setBrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setBrtDate(this.utilDate.dateToSQLLight(this.livraisonEnteteVentes.getBlvDate()));
         } else {
            var3.setBrtDate(this.var_date_trf);
         }

         var3.setBrtDate(this.utilDate.dateToSQL(var3.getBrtDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setBrtDateCreat(new Date());
         var3.setBrtDateModif((Date)null);
         var3.setBrtIdModif(0L);
         var3.setBrtNomModif("");
         var3.setBrtNum("");
         boolean var7 = false;
         int var36;
         if (this.optionsVentes.getNbrJrRelanceRETOUR() != null && !this.optionsVentes.getNbrJrRelanceRETOUR().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceRETOUR());
         } else {
            var36 = 0;
         }

         boolean var8 = false;
         int var37;
         if (this.optionsVentes.getNbrJrValidRETOUR() != null && !this.optionsVentes.getNbrJrValidRETOUR().isEmpty()) {
            var37 = Integer.parseInt(this.optionsVentes.getNbrJrValidRETOUR());
         } else {
            var37 = 0;
         }

         var3.setBrtDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var3.setBrtDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var37));
         var3.setBrtService(this.livraisonEnteteVentes.getBlvService());
         if (!var3.getBrtSerie().equalsIgnoreCase("X") && !var3.getBrtSerie().isEmpty()) {
            var3.setBrtNum(this.calculChrono.numCompose(this.livraisonEnteteVentes.getBlvDate(), this.var_type_trf, var3.getBrtSerie(), var1));
         } else {
            long var9 = this.livraisonEnteteVentesDao.selectLastNum(var1);
            var3.setBrtNum("" + var9);
         }

         this.verifieExistenceHabilitationRetour(var3, var1);
         var3.setBrtSource(this.livraisonEnteteVentes.getBlvSource());
         var3.setBrtNomResponsable(this.livraisonEnteteVentes.getBlvNomResponsable());
         var3.setBrtIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
         var3.setBrtNomCommercial(this.livraisonEnteteVentes.getBlvNomCommercial());
         var3.setBrtIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
         var3.setBrtNomEquipe(this.livraisonEnteteVentes.getBlvNomEquipe());
         var3.setBrtIdEquipe(this.livraisonEnteteVentes.getBlvIdEquipe());
         var3.setBrtNomTiers(this.livraisonEnteteVentes.getBlvNomTiers());
         var3.setBrtCivilTiers(this.livraisonEnteteVentes.getBlvCivilTiers());
         var3.setBrtTiersRegroupe(this.livraisonEnteteVentes.getBlvTiersRegroupe());
         var3.setBrtIdContact(this.livraisonEnteteVentes.getBlvIdContact());
         var3.setBrtNomContact(this.livraisonEnteteVentes.getBlvNomContact());
         var3.setBrtCivilContact(this.livraisonEnteteVentes.getBlvCivilContact());
         var3.setBrtDiversAdresse(this.livraisonEnteteVentes.getBlvDiversAdresse());
         var3.setBrtDiversMail(this.livraisonEnteteVentes.getBlvDiversMail());
         var3.setBrtDiversNom(this.livraisonEnteteVentes.getBlvDiversNom());
         var3.setBrtDiversTel(this.livraisonEnteteVentes.getBlvDiversTel());
         var3.setBrtDiversTiers(this.livraisonEnteteVentes.getBlvDiversTiers());
         var3.setBrtDiversVille(this.livraisonEnteteVentes.getBlvDiversVille());
         var3.setBrtExoTva(this.livraisonEnteteVentes.getBlvExoTva());
         var3.setBrtExoDouane(this.livraisonEnteteVentes.getBlvExoDouane());
         var3.setBrtJournalReg(this.livraisonEnteteVentes.getBlvJournalReg());
         var3.setBrtCat(this.livraisonEnteteVentes.getBlvCat());
         var3.setBrtDevise(this.livraisonEnteteVentes.getBlvDevise());
         var3.setBrtObject(this.livraisonEnteteVentes.getBlvObject());
         var3.setBrtObservation(this.livraisonEnteteVentes.getBlvObservation());
         var3.setBrtTauxRemise(this.livraisonEnteteVentes.getBlvTauxRemise());
         var3.setBrtTotHt(0.0D);
         var3.setBrtTotRemise(0.0D);
         var3.setBrtTotRabais(0.0D);
         var3.setBrtTotTva(0.0D);
         var3.setBrtTotTc(0.0D);
         var3.setBrtTotTtc(0.0D);
         var3.setBrtTotReglement(0.0D);
         var3.setBrtSolde(0);
         var3.setBrtBanque(this.livraisonEnteteVentes.getBlvBanque());
         var3.setBrtTypeReg(this.livraisonEnteteVentes.getBlvTypeReg());
         var3.setBrtModeReg(this.livraisonEnteteVentes.getBlvModeReg());
         var3.setBrtNbJourReg(this.livraisonEnteteVentes.getBlvNbJourReg());
         var3.setBrtArrondiReg(this.livraisonEnteteVentes.getBlvArrondiReg());
         var3.setBrtConditionReg(this.livraisonEnteteVentes.getBlvConditionReg());
         var3.setBrtDateEcheReg(this.livraisonEnteteVentes.getBlvDateEcheReg());
         var3.setBrtContener(this.livraisonEnteteVentes.getBlvContener());
         var3.setBrtActivite(this.livraisonEnteteVentes.getBlvActivite());
         var3.setBrtSite(this.livraisonEnteteVentes.getBlvSite());
         var3.setBrtDepartement(this.livraisonEnteteVentes.getBlvDepartement());
         var3.setBrtRegion(this.livraisonEnteteVentes.getBlvRegion());
         var3.setBrtSecteur(this.livraisonEnteteVentes.getBlvSecteur());
         var3.setBrtPdv(this.livraisonEnteteVentes.getBlvPdv());
         var3.setBrtAnal2(this.livraisonEnteteVentes.getBlvAnal2());
         var3.setBrtAnal4(this.livraisonEnteteVentes.getBlvAnal4());
         var3.setBrtAffaire(this.livraisonEnteteVentes.getBlvAffaire());
         var3.setBrtInfo1(this.livraisonEnteteVentes.getBlvInfo1());
         var3.setBrtInfo2(this.livraisonEnteteVentes.getBlvInfo2());
         var3.setBrtInfo3(this.livraisonEnteteVentes.getBlvInfo3());
         var3.setBrtInfo4(this.livraisonEnteteVentes.getBlvInfo4());
         var3.setBrtInfo5(this.livraisonEnteteVentes.getBlvInfo5());
         var3.setBrtInfo6(this.livraisonEnteteVentes.getBlvInfo6());
         var3.setBrtInfo7(this.livraisonEnteteVentes.getBlvInfo7());
         var3.setBrtInfo8(this.livraisonEnteteVentes.getBlvInfo8());
         var3.setBrtInfo9(this.livraisonEnteteVentes.getBlvInfo9());
         var3.setBrtInfo10(this.livraisonEnteteVentes.getBlvInfo10());
         var3.setBrtFormule1(this.livraisonEnteteVentes.getBlvFormule1());
         var3.setBrtFormule2(this.livraisonEnteteVentes.getBlvFormule2());
         var3.setBrtAnnexe1(this.livraisonEnteteVentes.getBlvAnnexe1());
         var3.setBrtAnnexe2(this.livraisonEnteteVentes.getBlvAnnexe2());
         var3.setBrtContrat(this.livraisonEnteteVentes.getBlvContrat());
         var3.setBrtIncoterm(this.livraisonEnteteVentes.getBlvIncoterm());
         var3.setBrtLieuLivraison(this.livraisonEnteteVentes.getBlvLieuLivraison());
         var3.setBrtDateLivraison(this.livraisonEnteteVentes.getBlvDateLivraison());
         var3.setBrtInfoLivraison(this.livraisonEnteteVentes.getBlvInfoLivraison());
         var3.setBrtDateImp((Date)null);
         var3.setBrtModeleImp(this.var_modele_trf);
         var3.setBrtGarde(this.livraisonEnteteVentes.getBlvGarde());
         var3.setBrtGele(0);
         var3.setBrtEtat(0);
         var3.setBrtDateTransforme((Date)null);
         var3.setBrtDateAnnule((Date)null);
         var3.setBrtMotifAnnule("");
         var3.setBrtFactorNom(this.livraisonEnteteVentes.getBlvFactorNom());
         var3.setBrtFactorId(this.livraisonEnteteVentes.getBlvFactorId());
         var3.setBrtFactorEtat(this.livraisonEnteteVentes.getBlvFactorEtat());
         var3.setBrtNumClient(this.livraisonEnteteVentes.getBlvNumClient());
         var3.setBrtDateClient(this.livraisonEnteteVentes.getBlvDateClient());
         var3.setExerciceventes(this.exercicesVentes);
         var3.setTiers(this.livraisonEnteteVentes.getTiers());
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var38 = 0.0F;
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

            label357:
            while(true) {
               RetourLigneVentes var39;
               if (var26 >= this.lesLignesList.size()) {
                  var3.setBrtTotHt(var12);
                  var3.setBrtTotRemise(var14);
                  var3.setBrtTotRabais(var16);
                  var3.setBrtTotTva(var18);
                  var3.setBrtTotTc(var22);
                  var3.setBrtTotTtc(var20);
                  var3 = var4.modif(var3, var1);
                  if (var6.size() == 0) {
                     break;
                  }

                  var5.saveLigne(var6, var3, var1);
                  var26 = 0;

                  while(true) {
                     if (var26 >= var6.size()) {
                        break label357;
                     }

                     new RetourLigneVentes();
                     var39 = (RetourLigneVentes)var6.get(var26);
                     this.produits = this.produitsDao.chargeProduit(var39.getBrtligCode(), var1);
                     this.calculStock.majRetourVentesATT(var39, this.produits, 0.0F, 1, this.baseLog, var1);
                     ++var26;
                  }
               }

               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var26);
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var24 == null || var24.isEmpty() || !var24.equals(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum())) {
                        var24 = this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum();
                        ++var25;
                        var39 = new RetourLigneVentes();
                        var39.setBrtligCode("-");
                        var39.setBrtligLibelle("---> Suivant livraison N° " + var24);
                        var39.setRetourEnteteVentes(var3);
                        var6.add(var39);
                     }
                  } else if (var26 == 0) {
                     var24 = "";
                     String var27 = "";
                     int var28 = 0;

                     while(true) {
                        if (var28 >= this.lesLignesList.size()) {
                           ++var25;
                           RetourLigneVentes var41 = new RetourLigneVentes();
                           var41.setBrtligCode("-");
                           var41.setBrtligLibelle("---> Suivant livraison N° " + var27);
                           var41.setRetourEnteteVentes(var3);
                           var6.add(var41);
                           break;
                        }

                        if (var24 == null || var24.isEmpty() || !var24.equals(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum())) {
                           var24 = this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum();
                           if (var27 != null && !var27.isEmpty()) {
                              var27 = var27 + "," + var24;
                           } else {
                              var27 = var24;
                           }
                        }

                        ++var28;
                     }
                  }
               }

               if ((this.livraisonLigneVentes.getBlvligLibelle() != null && !this.livraisonLigneVentes.getBlvligLibelle().isEmpty() || this.livraisonLigneVentes.getBlvligComplement() != null && !this.livraisonLigneVentes.getBlvligComplement().isEmpty()) && this.livraisonLigneVentes.getVar_qteReliquat() != 0.0F) {
                  if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var1);
                     if (this.produits != null && this.livraisonLigneVentes.getBlvligDepot() != null && !this.livraisonLigneVentes.getBlvligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), var1);
                     }
                  }

                  float var40 = this.livraisonLigneVentes.getBlvligQte();
                  float var42 = this.livraisonLigneVentes.getBlvligQteUtil();
                  ++var25;
                  RetourLigneVentes var29 = new RetourLigneVentes();
                  var38 += this.livraisonLigneVentes.getBlvligQte();
                  var10 += this.livraisonLigneVentes.getVar_qteDejaTrf();
                  if (((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var29.setBrtligOrdre(var25);
                     var29.setBrtligCode(this.livraisonLigneVentes.getBlvligCode());
                     var29.setBrtligGroupe(this.livraisonLigneVentes.getBlvligGroupe());
                     var29.setBrtligModeGroupe(this.livraisonLigneVentes.getBlvligModeGroupe());
                     var29.setBrtligDevise(this.livraisonLigneVentes.getBlvligDevise());
                     var29.setBrtligFamille(this.livraisonLigneVentes.getBlvligFamille());
                     var29.setBrtligIdBlv(this.livraisonLigneVentes.getBlvligId());
                     var29.setBrtligLibelle(this.livraisonLigneVentes.getBlvligLibelle());
                     var29.setBrtligComplement(this.livraisonLigneVentes.getBlvligComplement());
                     if (((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                        String[] var30 = ((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                        var29.setBrtligDepot(var30[0]);
                     } else {
                        var29.setBrtligDepot("");
                     }

                     var29.setBrtligEchelle(this.livraisonLigneVentes.getBlvligEchelle());
                     var29.setBrtligUnite(this.livraisonLigneVentes.getBlvligUnite());
                     var29.setBrtligCondition(this.livraisonLigneVentes.getBlvligCondition());
                     var29.setBrtligStock(this.livraisonLigneVentes.getBlvligStock());
                     var29.setBrtligReference(this.livraisonLigneVentes.getBlvligReference());
                     var29.setBrtligPump(this.livraisonLigneVentes.getBlvligPump());
                     var29.setBrtligPu(this.livraisonLigneVentes.getBlvligPu());
                     var29.setBrtligPuTtc(this.livraisonLigneVentes.getBlvligPuTtc());
                     var29.setBrtligTauxRemise(this.livraisonLigneVentes.getBlvligTauxRemise());
                     var29.setBrtligPuRem(this.livraisonLigneVentes.getBlvligPuRem());
                     var29.setBrtligPuRemTtc(this.livraisonLigneVentes.getBlvligPuRemTtc());
                     this.livraisonLigneVentes.setBlvligQte(((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var1);
                     var29.setBrtligQte(((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var29.setBrtligLong(this.livraisonLigneVentes.getBlvligLong());
                     var29.setBrtligLarg(this.livraisonLigneVentes.getBlvligLarg());
                     var29.setBrtligHaut(this.livraisonLigneVentes.getBlvligHaut());
                     var29.setBrtligDiam(this.livraisonLigneVentes.getBlvligDiam());
                     var29.setBrtligPoidsBrut(this.livraisonLigneVentes.getBlvligPoidsBrut());
                     var29.setBrtligPoidsNet(this.livraisonLigneVentes.getBlvligPoidsNet());
                     var29.setBrtligVolume(this.livraisonLigneVentes.getBlvligVolume());
                     var29.setBrtligNb(this.livraisonLigneVentes.getBlvligNb());
                     var29.setBrtligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.livraisonLigneVentes.getBlvligCondition(), this.livraisonLigneVentes.getBlvligQte(), this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, this.utilInitHibernate, var1));
                     var29.setBrtligQteStock(0.0F);
                     var29.setBrtligRabais(this.livraisonLigneVentes.getBlvligRabais());
                     var29.setBrtligTauxTaxe(this.livraisonLigneVentes.getBlvligTauxTaxe());
                     var29.setBrtligTaxe(this.livraisonLigneVentes.getBlvligTaxe());
                     var29.setBrtligPt(this.livraisonLigneVentes.getBlvligPt());
                     var29.setBrtligTva(this.livraisonLigneVentes.getBlvligTva());
                     var29.setBrtligTtc(this.livraisonLigneVentes.getBlvligTtc());
                     var29.setBrtligTc(this.livraisonLigneVentes.getBlvligTc());
                     var29.setRetourEnteteVentes(var3);
                     var11 += ((LivraisonLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var29);
                     var12 += var29.getBrtligPt();
                     var14 += (var29.getBrtligPu() - var29.getBrtligPuRem()) * (double)var29.getBrtligQte();
                     var16 += var29.getBrtligRabais();
                     var18 += var29.getBrtligTva();
                     var20 += var29.getBrtligTtc();
                     var22 += var29.getBrtligTc();
                     this.livraisonLigneVentes.setBlvligQte(var40);
                     this.livraisonLigneVentes.setBlvligQteUtil(var42);
                  }
               }

               ++var26;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationRetour(var3, var1), var3.getBrtId(), var3.getBrtNum(), var3.getBrtNomTiers(), var3.getBrtDate(), var3.getBrtDevise(), var3.getBrtTotTtc() + var3.getBrtTotTc(), var3.getBrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 24), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFRETOUR(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.livraisonEnteteVentes.getBlvSerie());
         this.documentTraceVentes.setDoctraOrgId(this.livraisonEnteteVentes.getBlvId());
         this.documentTraceVentes.setDoctraOrgNum(this.livraisonEnteteVentes.getBlvNum());
         this.documentTraceVentes.setDoctraOrgDate(this.livraisonEnteteVentes.getBlvDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getBrtSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getBrtId());
         this.documentTraceVentes.setDoctraDstNum(var3.getBrtNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getBrtDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         var2.commit();
      } catch (HibernateException var34) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var34;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFRETOUR(List var1, RetourEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new RetourLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            RetourLigneVentes var4 = (RetourLigneVentes)var1.get(var11);
            if (var4.getBrtligModeGroupe() != 2 || var4.getBrtligGroupe() == null || var4.getBrtligGroupe().isEmpty()) {
               if (var4.getBrtligCode() != null && !var4.getBrtligCode().isEmpty() && var4.getBrtligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getBrtligLibelle();
               }

               if (var5) {
                  var7 += var4.getBrtligPt();
                  var9 = var4.getBrtligTtc();
               }

               if (var4.getBrtligCode() != null && !var4.getBrtligCode().isEmpty() && var4.getBrtligCode().equals("=") && var5) {
                  var4 = new RetourLigneVentes();
                  var4.setRetourEnteteVentes(var2);
                  var4.setBrtligCode("=");
                  var4.setBrtligLibelle(var6);
                  var4.setBrtligPt(var7);
                  var4.setBrtligTtc(var9);
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

      this.montant_lettre = this.utilNombre.begin(var2.getBrtTotTtc() + var2.getBrtTotTc(), var2.getBrtDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationRetour(RetourEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setBrtEtatVal(1);
         var1.setBrtEtat(0);
         var1.setBrtDateValide((Date)null);
      } else {
         var1.setBrtEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setBrtEtat(1);
               var1.setBrtDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setBrtEtat(0);
               var1.setBrtDateValide((Date)null);
            }
         }
      }

      return var4;
   }

   public void trfFac(List var1) throws HibernateException, NamingException, Exception {
      double var2 = 0.0D;
      FactureEnteteVentesDao var4 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      FactureLigneVentesDao var5 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      ArrayList var6 = new ArrayList();
      FactureEnteteVentes var7 = new FactureEnteteVentes();
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var9 = null;

      try {
         var9 = var8.beginTransaction();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var7.setFacSerie(this.var_serie_trf);
         } else {
            var7.setFacSerie(this.livraisonEnteteVentes.getBlvSerie());
         }

         var7.setUsers(this.usersLog);
         var7.setFacIdCreateur(this.usersLog.getUsrid());
         var7.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var7.setFacDate(this.livraisonEnteteVentes.getBlvDate());
         } else {
            var7.setFacDate(this.var_date_trf);
         }

         var7.setFacDateCreat(new Date());
         var7.setFacDateModif((Date)null);
         var7.setFacIdModif(0L);
         var7.setFacNomModif("");
         var7.setFacNum("");
         var7.setFacNumBl(this.livraisonEnteteVentes.getBlvNum());
         boolean var10 = false;
         int var41;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var41 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var41 = 0;
         }

         boolean var11 = false;
         int var42;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var42 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var42 = 0;
         }

         var7.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var41));
         var7.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var42));
         var7.setFacService(this.livraisonEnteteVentes.getBlvService());
         if (this.livraisonEnteteVentes.getBlvMemoNumFacture() != null && !this.livraisonEnteteVentes.getBlvMemoNumFacture().isEmpty()) {
            var7.setFacNum(this.livraisonEnteteVentes.getBlvMemoNumFacture());
         } else if (!var7.getFacSerie().equalsIgnoreCase("X") && !var7.getFacSerie().isEmpty()) {
            var7.setFacNum(this.calculChrono.numCompose(var7.getFacDate(), this.var_type_trf, var7.getFacSerie(), var8));
         } else {
            long var12 = var4.selectLastNum(var8);
            var7.setFacNum("" + var12);
         }

         this.verifieExistenceHabilitationFac(var7, var8);
         var7.setFacSource(this.livraisonEnteteVentes.getBlvSource());
         var7.setFacNomResponsable(this.livraisonEnteteVentes.getBlvNomResponsable());
         var7.setFacIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
         var7.setFacNomCommercial(this.livraisonEnteteVentes.getBlvNomCommercial());
         var7.setFacIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
         var7.setFacNomEquipe(this.livraisonEnteteVentes.getBlvNomEquipe());
         var7.setFacIdEquipe(this.livraisonEnteteVentes.getBlvIdEquipe());
         var7.setFacNomTiers(this.livraisonEnteteVentes.getBlvNomTiers());
         var7.setFacCivilTiers(this.livraisonEnteteVentes.getBlvCivilTiers());
         var7.setFacTiersRegroupe(this.livraisonEnteteVentes.getBlvTiersRegroupe());
         var7.setFacIdContact(this.livraisonEnteteVentes.getBlvIdContact());
         var7.setFacNomContact(this.livraisonEnteteVentes.getBlvNomContact());
         var7.setFacCivilContact(this.livraisonEnteteVentes.getBlvCivilContact());
         var7.setFacDiversAdresse(this.livraisonEnteteVentes.getBlvDiversAdresse());
         var7.setFacDiversMail(this.livraisonEnteteVentes.getBlvDiversMail());
         var7.setFacDiversNom(this.livraisonEnteteVentes.getBlvDiversNom());
         var7.setFacDiversTel(this.livraisonEnteteVentes.getBlvDiversTel());
         var7.setFacDiversTiers(this.livraisonEnteteVentes.getBlvDiversTiers());
         var7.setFacDiversVille(this.livraisonEnteteVentes.getBlvDiversVille());
         var7.setFacExoTva(this.livraisonEnteteVentes.getBlvExoTva());
         var7.setFacExoDouane(this.livraisonEnteteVentes.getBlvExoDouane());
         var7.setFacJournalReg(this.livraisonEnteteVentes.getBlvJournalReg());
         var7.setFacCat(this.livraisonEnteteVentes.getBlvCat());
         var7.setFacDevise(this.livraisonEnteteVentes.getBlvDevise());
         var7.setFacObject(this.livraisonEnteteVentes.getBlvObject());
         var7.setFacObservation(this.livraisonEnteteVentes.getBlvObservation());
         var7.setFacTauxRemise(this.livraisonEnteteVentes.getBlvTauxRemise());
         var7.setFacTotHt(0.0D);
         var7.setFacTotRemise(0.0D);
         var7.setFacTotRabais(0.0D);
         var7.setFacTotTva(0.0D);
         var7.setFacTotTc(0.0D);
         var7.setFacTotTtc(0.0D);
         var7.setFacTotReglement(0.0D);
         var7.setFacSolde(0);
         var7.setFacBanque(this.livraisonEnteteVentes.getBlvBanque());
         var7.setFacTypeReg(this.livraisonEnteteVentes.getBlvTypeReg());
         var7.setFacModeReg(this.livraisonEnteteVentes.getBlvModeReg());
         var7.setFacNbJourReg(this.livraisonEnteteVentes.getBlvNbJourReg());
         var7.setFacArrondiReg(this.livraisonEnteteVentes.getBlvArrondiReg());
         var7.setFacConditionReg(this.livraisonEnteteVentes.getBlvConditionReg());
         var7.setFacDateEcheReg(this.livraisonEnteteVentes.getBlvDateEcheReg());
         var7.setFacContener(this.livraisonEnteteVentes.getBlvContener());
         var7.setFacActivite(this.livraisonEnteteVentes.getBlvActivite());
         var7.setFacSite(this.livraisonEnteteVentes.getBlvSite());
         var7.setFacDepartement(this.livraisonEnteteVentes.getBlvDepartement());
         var7.setFacRegion(this.livraisonEnteteVentes.getBlvRegion());
         var7.setFacSecteur(this.livraisonEnteteVentes.getBlvSecteur());
         var7.setFacPdv(this.livraisonEnteteVentes.getBlvPdv());
         var7.setFacAnal2(this.livraisonEnteteVentes.getBlvAnal2());
         var7.setFacAnal4(this.livraisonEnteteVentes.getBlvAnal4());
         var7.setFacAffaire(this.livraisonEnteteVentes.getBlvAffaire());
         var7.setFacInfo1(this.livraisonEnteteVentes.getBlvInfo1());
         var7.setFacInfo2(this.livraisonEnteteVentes.getBlvInfo2());
         var7.setFacInfo3(this.livraisonEnteteVentes.getBlvInfo3());
         var7.setFacInfo4(this.livraisonEnteteVentes.getBlvInfo4());
         var7.setFacInfo5(this.livraisonEnteteVentes.getBlvInfo5());
         var7.setFacInfo6(this.livraisonEnteteVentes.getBlvInfo6());
         var7.setFacInfo7(this.livraisonEnteteVentes.getBlvInfo7());
         var7.setFacInfo8(this.livraisonEnteteVentes.getBlvInfo8());
         var7.setFacInfo9(this.livraisonEnteteVentes.getBlvInfo9());
         var7.setFacInfo10(this.livraisonEnteteVentes.getBlvInfo10());
         var7.setFacFormule1(this.livraisonEnteteVentes.getBlvFormule1());
         var7.setFacFormule2(this.livraisonEnteteVentes.getBlvFormule2());
         var7.setFacAnnexe1(this.livraisonEnteteVentes.getBlvAnnexe1());
         var7.setFacAnnexe2(this.livraisonEnteteVentes.getBlvAnnexe2());
         var7.setFacContrat(this.livraisonEnteteVentes.getBlvContrat());
         var7.setFacIncoterm(this.livraisonEnteteVentes.getBlvIncoterm());
         var7.setFacLieuLivraison(this.livraisonEnteteVentes.getBlvLieuLivraison());
         var7.setFacDateLivraison(this.livraisonEnteteVentes.getBlvDateLivraison());
         var7.setFacInfoLivraison(this.livraisonEnteteVentes.getBlvInfoLivraison());
         var7.setFacDateImp((Date)null);
         var7.setFacModeleImp(this.var_modele_trf);
         var7.setFacGarde(this.livraisonEnteteVentes.getBlvGarde());
         var7.setFacRistourneBloquee(this.livraisonEnteteVentes.isBlvRistourneBloquee());
         var7.setFacGele(0);
         var7.setFacEtat(0);
         var7.setFacDateTransforme((Date)null);
         var7.setFacTypeTransforme(0);
         var7.setFacDateAnnule((Date)null);
         var7.setFacMotifAnnule("");
         var7.setFacFactorNom(this.livraisonEnteteVentes.getBlvFactorNom());
         var7.setFacFactorId(this.livraisonEnteteVentes.getBlvFactorId());
         var7.setFacFactorEtat(this.livraisonEnteteVentes.getBlvFactorEtat());
         var7.setExerciceventes(this.exercicesVentes);
         var7.setTiers(this.livraisonEnteteVentes.getTiers());
         var7.setUsers(this.usersLog);
         var7.setFacStock(0);
         var7.setFacNumClient(this.livraisonEnteteVentes.getBlvNumClient());
         var7.setFacDateClient(this.livraisonEnteteVentes.getBlvDateClient());
         var7 = var4.insert(var7, var8);
         float var43 = 0.0F;
         float var13 = 0.0F;
         float var14 = 0.0F;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         double var25 = 0.0D;
         String var27 = "";
         int var28 = 0;
         int var29;
         if (this.lesLignesList.size() != 0) {
            var29 = 0;

            while(true) {
               if (var29 >= this.lesLignesList.size()) {
                  var7.setFacTotHt(var15);
                  var7.setFacTotRemise(var17);
                  var7.setFacTotRabais(var19);
                  var7.setFacTotTva(var21);
                  var7.setFacTotTc(var25);
                  var7.setFacTotTtc(var23);
                  var7 = var4.modif(var7, var8);
                  if (var6.size() != 0) {
                     var5.saveLigne(var6, var7, var8);
                  }
                  break;
               }

               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var29);
               FactureLigneVentes var46;
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var27 == null || var27.isEmpty() || !var27.equals(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum())) {
                        var27 = this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum();
                        ++var28;
                        var46 = new FactureLigneVentes();
                        var46.setFacligCode("-");
                        var46.setFacligLibelle("---> Suivant livraison N° " + var27);
                        var46.setFactureEnteteVentes(var7);
                        var6.add(var46);
                     }
                  } else if (var29 == 0) {
                     var27 = "";
                     String var30 = "";
                     int var31 = 0;

                     while(true) {
                        if (var31 >= this.lesLignesList.size()) {
                           ++var28;
                           FactureLigneVentes var47 = new FactureLigneVentes();
                           var47.setFacligCode("-");
                           var47.setFacligLibelle("---> Suivant livraison N° " + var30);
                           var47.setFactureEnteteVentes(var7);
                           var6.add(var47);
                           break;
                        }

                        if (var27 == null || var27.isEmpty() || !var27.equals(this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum())) {
                           var27 = this.livraisonLigneVentes.getLivraisonEnteteVentes().getBlvNum();
                           if (var30 != null && !var30.isEmpty()) {
                              var30 = var30 + "," + var27;
                           } else {
                              var30 = var27;
                           }
                        }

                        ++var31;
                     }
                  }
               }

               if (this.livraisonLigneVentes.getBlvligLibelle() != null && !this.livraisonLigneVentes.getBlvligLibelle().isEmpty() || this.livraisonLigneVentes.getBlvligComplement() != null && !this.livraisonLigneVentes.getBlvligComplement().isEmpty()) {
                  FactureLigneVentes var32;
                  String[] var33;
                  if (this.livraisonLigneVentes.getVar_qteReliquat() != 0.0F) {
                     if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                        this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var8);
                        if (this.produits != null && this.livraisonLigneVentes.getBlvligDepot() != null && !this.livraisonLigneVentes.getBlvligDepot().isEmpty()) {
                           this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.livraisonLigneVentes.getBlvligCode(), this.livraisonLigneVentes.getBlvligDepot(), var8);
                        }
                     }

                     float var49 = this.livraisonLigneVentes.getBlvligQte();
                     float var52 = this.livraisonLigneVentes.getBlvligQteUtil();
                     var43 += this.livraisonLigneVentes.getBlvligQte();
                     var13 += this.livraisonLigneVentes.getVar_qteDejaTrf();
                     if (((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_qteReliquat() != 0.0F) {
                        var32 = new FactureLigneVentes();
                        ++var28;
                        var32.setFacligOrdre(var28);
                        var32.setFacligCode(this.livraisonLigneVentes.getBlvligCode());
                        var32.setFacligGroupe(this.livraisonLigneVentes.getBlvligGroupe());
                        var32.setFacligModeGroupe(this.livraisonLigneVentes.getBlvligModeGroupe());
                        var32.setFacligDevise(this.livraisonLigneVentes.getBlvligDevise());
                        var32.setFacligFamille(this.livraisonLigneVentes.getBlvligFamille());
                        var32.setFacligIdBlv(this.livraisonLigneVentes.getBlvligId());
                        var32.setFacligLibelle(this.livraisonLigneVentes.getBlvligLibelle());
                        var32.setFacligComplement(this.livraisonLigneVentes.getBlvligComplement());
                        if (((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne() != null && !((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne().isEmpty() && ((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne().contains("=")) {
                           var33 = ((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne().split("=");
                           var32.setFacligDepot(var33[0]);
                        } else {
                           var32.setFacligDepot("");
                        }

                        var32.setFacligEchelle(this.livraisonLigneVentes.getBlvligEchelle());
                        var32.setFacligUnite(this.livraisonLigneVentes.getBlvligUnite());
                        var32.setFacligCondition(this.livraisonLigneVentes.getBlvligCondition());
                        var32.setFacligStock(this.livraisonLigneVentes.getBlvligStock());
                        var32.setFacligReference(this.livraisonLigneVentes.getBlvligReference());
                        var32.setFacligPump(this.livraisonLigneVentes.getBlvligPump());
                        var32.setFacligPu(this.livraisonLigneVentes.getBlvligPu());
                        var32.setFacligPuTtc(this.livraisonLigneVentes.getBlvligPuTtc());
                        var32.setFacligTauxRemise(this.livraisonLigneVentes.getBlvligTauxRemise());
                        var32.setFacligPuRem(this.livraisonLigneVentes.getBlvligPuRem());
                        var32.setFacligPuRemTtc(this.livraisonLigneVentes.getBlvligPuRemTtc());
                        this.livraisonLigneVentes.setBlvligQte(((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_qteReliquat());
                        var32.setFacligQte(((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_qteReliquat());
                        var32.setFacligLong(this.livraisonLigneVentes.getBlvligLong());
                        var32.setFacligLarg(this.livraisonLigneVentes.getBlvligLarg());
                        var32.setFacligHaut(this.livraisonLigneVentes.getBlvligHaut());
                        var32.setFacligDiam(this.livraisonLigneVentes.getBlvligDiam());
                        var32.setFacligPoidsBrut(this.livraisonLigneVentes.getBlvligPoidsBrut());
                        var32.setFacligPoidsNet(this.livraisonLigneVentes.getBlvligPoidsNet());
                        var32.setFacligVolume(this.livraisonLigneVentes.getBlvligVolume());
                        var32.setFacligNb(this.livraisonLigneVentes.getBlvligNb());
                        var32.setFacligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.livraisonLigneVentes.getBlvligCondition(), this.livraisonLigneVentes.getBlvligQte(), this.livraisonLigneVentes.getBlvligLong(), this.livraisonLigneVentes.getBlvligLarg(), this.livraisonLigneVentes.getBlvligHaut(), this.livraisonLigneVentes.getBlvligDiam(), this.livraisonLigneVentes.getBlvligNb(), this.baseLog, this.utilInitHibernate, var8));
                        var32.setFacligQteStock(0.0F);
                        this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var8);
                        var32.setFacligRabais(this.livraisonLigneVentes.getBlvligRabais());
                        var32.setFacligTauxTaxe(this.livraisonLigneVentes.getBlvligTauxTaxe());
                        var32.setFacligTaxe(this.livraisonLigneVentes.getBlvligTaxe());
                        var32.setFacligPt(this.livraisonLigneVentes.getBlvligPt());
                        var32.setFacligTva(this.livraisonLigneVentes.getBlvligTva());
                        var32.setFacligTtc(this.livraisonLigneVentes.getBlvligTtc());
                        var32.setFacligTc(this.livraisonLigneVentes.getBlvligTc());
                        var32.setFacligEntStock(0);
                        var32.setFactureEnteteVentes(var7);
                        var14 += ((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_qteReliquat();
                        var6.add(var32);
                        var15 += var32.getFacligPt();
                        var17 += (var32.getFacligPu() - var32.getFacligPuRem()) * (double)var32.getFacligQte();
                        var19 += var32.getFacligRabais();
                        var21 += var32.getFacligTva();
                        var23 += var32.getFacligTtc();
                        var25 += var32.getFacligTc();
                        this.livraisonLigneVentes.setBlvligQte(var49);
                        this.livraisonLigneVentes.setBlvligQteUtil(var52);
                     }
                  } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                     if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                        new ProcessEnteteAchats();
                        ProcessEnteteAchatsDao var50 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                        ProcessEnteteAchats var48 = var50.rechercheProcess(this.livraisonLigneVentes.getBlvligCode(), var8);
                        if (var48 != null) {
                           ++var28;
                           var32 = new FactureLigneVentes();
                           var32.setFacligOrdre(var28);
                           var32.setFacligCode(var48.getProcesCode());
                           var32.setFacligGroupe(this.livraisonLigneVentes.getBlvligGroupe());
                           var32.setFacligModeGroupe(this.livraisonLigneVentes.getBlvligModeGroupe());
                           var32.setFacligDevise(this.livraisonLigneVentes.getBlvligDevise());
                           var32.setFacligFamille(this.livraisonLigneVentes.getBlvligFamille());
                           var32.setFacligIdDvs(this.livraisonLigneVentes.getBlvligId());
                           var32.setFacligLibelle(var48.getProcesLibClient());
                           var32.setFacligComplement(this.livraisonLigneVentes.getBlvligComplement());
                           var32.setFacligDepot(var48.getProcesDepot());
                           var32.setFacligEchelle(this.livraisonLigneVentes.getBlvligEchelle());
                           var32.setFacligUnite(this.livraisonLigneVentes.getBlvligUnite());
                           var32.setFacligCondition(this.livraisonLigneVentes.getBlvligCondition());
                           var32.setFacligStock(this.livraisonLigneVentes.getBlvligStock());
                           var32.setFacligReference(this.livraisonLigneVentes.getBlvligReference());
                           var32.setFacligPump(var48.getProcesTotPump());
                           var32.setFacligPu(this.livraisonLigneVentes.getBlvligPu());
                           var32.setFacligPuTtc(this.livraisonLigneVentes.getBlvligPuTtc());
                           var32.setFacligTauxRemise(this.livraisonLigneVentes.getBlvligTauxRemise());
                           var32.setFacligPuRem(this.livraisonLigneVentes.getBlvligPuRem());
                           var32.setFacligPuRemTtc(this.livraisonLigneVentes.getBlvligPuRemTtc());
                           var32.setFacligQte(0.0F);
                           var32.setFacligLong(this.livraisonLigneVentes.getBlvligLong());
                           var32.setFacligLarg(this.livraisonLigneVentes.getBlvligLarg());
                           var32.setFacligHaut(this.livraisonLigneVentes.getBlvligHaut());
                           var32.setFacligDiam(this.livraisonLigneVentes.getBlvligDiam());
                           var32.setFacligPoidsBrut(this.livraisonLigneVentes.getBlvligPoidsBrut());
                           var32.setFacligPoidsNet(this.livraisonLigneVentes.getBlvligPoidsNet());
                           var32.setFacligVolume(this.livraisonLigneVentes.getBlvligVolume());
                           var32.setFacligNb(this.livraisonLigneVentes.getBlvligNb());
                           var32.setFacligQteUtil(0.0F);
                           var32.setFacligQteStock(0.0F);
                           var32.setFacligRabais(this.livraisonLigneVentes.getBlvligRabais());
                           var32.setFacligTauxTaxe(this.livraisonLigneVentes.getBlvligTauxTaxe());
                           var32.setFacligTaxe(this.livraisonLigneVentes.getBlvligTaxe());
                           var32.setFacligPt(this.livraisonLigneVentes.getBlvligPt());
                           var32.setFacligTva(this.livraisonLigneVentes.getBlvligTva());
                           var32.setFacligTtc(this.livraisonLigneVentes.getBlvligTtc());
                           var32.setFacligTc(this.livraisonLigneVentes.getBlvligTc());
                           var32.setFactureEnteteVentes(var7);
                           var6.add(var32);
                        } else {
                           ++var28;
                           var32 = new FactureLigneVentes();
                           var32.setFacligOrdre(var28);
                           var32.setFacligCode(this.livraisonLigneVentes.getBlvligCode());
                           var32.setFacligGroupe(this.livraisonLigneVentes.getBlvligGroupe());
                           var32.setFacligModeGroupe(this.livraisonLigneVentes.getBlvligModeGroupe());
                           var32.setFacligDevise(this.livraisonLigneVentes.getBlvligDevise());
                           var32.setFacligFamille(this.livraisonLigneVentes.getBlvligFamille());
                           var32.setFacligIdDvs(this.livraisonLigneVentes.getBlvligId());
                           var32.setFacligLibelle(this.livraisonLigneVentes.getBlvligLibelle());
                           var32.setFacligComplement(this.livraisonLigneVentes.getBlvligComplement());
                           if (this.livraisonLigneVentes.getVar_depotLigne() != null && !((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne().isEmpty() && ((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne().contains("=")) {
                              var33 = ((LivraisonLigneVentes)this.lesLignesList.get(var29)).getVar_depotLigne().split("=");
                              var32.setFacligDepot(var33[0]);
                           } else {
                              var32.setFacligDepot("");
                           }

                           var32.setFacligEchelle(this.livraisonLigneVentes.getBlvligEchelle());
                           var32.setFacligUnite(this.livraisonLigneVentes.getBlvligUnite());
                           var32.setFacligCondition(this.livraisonLigneVentes.getBlvligCondition());
                           var32.setFacligStock(this.livraisonLigneVentes.getBlvligStock());
                           var32.setFacligReference(this.livraisonLigneVentes.getBlvligReference());
                           var32.setFacligPump(this.livraisonLigneVentes.getBlvligPump());
                           var32.setFacligPu(this.livraisonLigneVentes.getBlvligPu());
                           var32.setFacligPuTtc(this.livraisonLigneVentes.getBlvligPuTtc());
                           var32.setFacligTauxRemise(this.livraisonLigneVentes.getBlvligTauxRemise());
                           var32.setFacligPuRem(this.livraisonLigneVentes.getBlvligPuRem());
                           var32.setFacligPuRemTtc(this.livraisonLigneVentes.getBlvligPuRemTtc());
                           this.livraisonLigneVentes.setBlvligQte(0.0F);
                           this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var8);
                           var32.setFacligQte(0.0F);
                           var32.setFacligLong(this.livraisonLigneVentes.getBlvligLong());
                           var32.setFacligLarg(this.livraisonLigneVentes.getBlvligLarg());
                           var32.setFacligHaut(this.livraisonLigneVentes.getBlvligHaut());
                           var32.setFacligDiam(this.livraisonLigneVentes.getBlvligDiam());
                           var32.setFacligPoidsBrut(this.livraisonLigneVentes.getBlvligPoidsBrut());
                           var32.setFacligPoidsNet(this.livraisonLigneVentes.getBlvligPoidsNet());
                           var32.setFacligVolume(this.livraisonLigneVentes.getBlvligVolume());
                           var32.setFacligNb(this.livraisonLigneVentes.getBlvligNb());
                           var32.setFacligQteUtil(0.0F);
                           var32.setFacligQteStock(0.0F);
                           var32.setFacligRabais(this.livraisonLigneVentes.getBlvligRabais());
                           var32.setFacligTauxTaxe(this.livraisonLigneVentes.getBlvligTauxTaxe());
                           var32.setFacligTaxe(this.livraisonLigneVentes.getBlvligTaxe());
                           var32.setFacligPt(this.livraisonLigneVentes.getBlvligPt());
                           var32.setFacligTva(this.livraisonLigneVentes.getBlvligTva());
                           var32.setFacligTtc(this.livraisonLigneVentes.getBlvligTtc());
                           var32.setFacligTc(this.livraisonLigneVentes.getBlvligTc());
                           var32.setFactureEnteteVentes(var7);
                           var6.add(var32);
                        }
                     } else {
                        ++var28;
                        var46 = new FactureLigneVentes();
                        var46.setFacligOrdre(var28);
                        var46.setFacligCode("");
                        var46.setFacligGroupe("");
                        var46.setFacligModeGroupe(0);
                        var46.setFacligDevise(this.livraisonLigneVentes.getBlvligDevise());
                        var46.setFacligFamille("");
                        var46.setFacligIdDvs(this.livraisonLigneVentes.getBlvligId());
                        var46.setFacligLibelle(this.livraisonLigneVentes.getBlvligLibelle());
                        var46.setFacligComplement(this.livraisonLigneVentes.getBlvligComplement());
                        var46.setFacligDepot("");
                        var46.setFacligEchelle(0);
                        var46.setFacligUnite(this.livraisonLigneVentes.getBlvligUnite());
                        var46.setFacligCondition(this.livraisonLigneVentes.getBlvligCondition());
                        var46.setFacligStock(0);
                        var46.setFacligReference(this.livraisonLigneVentes.getBlvligReference());
                        var46.setFacligPump(0.0D);
                        var46.setFacligPu(this.livraisonLigneVentes.getBlvligPu());
                        var46.setFacligPuTtc(this.livraisonLigneVentes.getBlvligPuTtc());
                        var46.setFacligTauxRemise(this.livraisonLigneVentes.getBlvligTauxRemise());
                        var46.setFacligPuRem(this.livraisonLigneVentes.getBlvligPuRem());
                        var46.setFacligPuRemTtc(this.livraisonLigneVentes.getBlvligPuRemTtc());
                        this.livraisonLigneVentes.setBlvligQte(0.0F);
                        this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var8);
                        var46.setFacligQte(0.0F);
                        var46.setFacligLong(this.livraisonLigneVentes.getBlvligLong());
                        var46.setFacligLarg(this.livraisonLigneVentes.getBlvligLarg());
                        var46.setFacligHaut(this.livraisonLigneVentes.getBlvligHaut());
                        var46.setFacligDiam(this.livraisonLigneVentes.getBlvligDiam());
                        var46.setFacligPoidsBrut(this.livraisonLigneVentes.getBlvligPoidsBrut());
                        var46.setFacligPoidsNet(this.livraisonLigneVentes.getBlvligPoidsNet());
                        var46.setFacligVolume(this.livraisonLigneVentes.getBlvligVolume());
                        var46.setFacligNb(this.livraisonLigneVentes.getBlvligNb());
                        var46.setFacligQteUtil(0.0F);
                        var46.setFacligQteStock(0.0F);
                        var46.setFacligRabais(this.livraisonLigneVentes.getBlvligRabais());
                        var46.setFacligTauxTaxe(this.livraisonLigneVentes.getBlvligTauxTaxe());
                        var46.setFacligTaxe(this.livraisonLigneVentes.getBlvligTaxe());
                        var46.setFacligPt(this.livraisonLigneVentes.getBlvligPt());
                        var46.setFacligTva(this.livraisonLigneVentes.getBlvligTva());
                        var46.setFacligTtc(this.livraisonLigneVentes.getBlvligTtc());
                        var46.setFacligTc(this.livraisonLigneVentes.getBlvligTc());
                        var46.setFactureEnteteVentes(var7);
                        var6.add(var46);
                     }
                  }
               }

               ++var29;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFac(var7, var8), var7.getFacId(), var7.getFacNum(), var7.getFacNomTiers(), var7.getFacDate(), var7.getFacDevise(), var7.getFacTotTtc() + var7.getFacTotTc(), var7.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 25), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var6, var7), this.calculeParc(var8), var7.getVar_format_devise(), 0, var8);

         for(var29 = 0; var29 < var1.size(); ++var29) {
            this.livraisonEnteteVentes = (LivraisonEnteteVentes)var1.get(var29);
            this.documentTraceVentes = new DocumentTraceVentes();
            this.documentTraceVentes.setDoctraDateCreat(new Date());
            this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
            this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
            this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
            this.documentTraceVentes.setDoctraOrgType(this.nature);
            this.documentTraceVentes.setDoctraOrgSerie(this.livraisonEnteteVentes.getBlvSerie());
            this.documentTraceVentes.setDoctraOrgId(this.livraisonEnteteVentes.getBlvId());
            this.documentTraceVentes.setDoctraOrgNum(this.livraisonEnteteVentes.getBlvNum());
            this.documentTraceVentes.setDoctraOrgDate(this.livraisonEnteteVentes.getBlvDate());
            this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
            this.documentTraceVentes.setDoctraDstSerie(var7.getFacSerie());
            this.documentTraceVentes.setDoctraDstId(var7.getFacId());
            this.documentTraceVentes.setDoctraDstNum(var7.getFacNum());
            this.documentTraceVentes.setDoctraDstDate(var7.getFacDate());
            this.documentTraceVentesDao.insert(this.documentTraceVentes, var8);
            this.livraisonEnteteVentes.setBlvEtat(5);
            this.livraisonEnteteVentes.setBlvDateTransforme(new Date());
            this.livraisonEnteteVentes.setBlvTypeTransforme(this.var_type_trf);
            if (this.optionsVentes.getNumBlFac() == 0) {
               this.livraisonEnteteVentes.setBlvMemoNumFacture((String)null);
            } else if (this.optionsVentes.getNumBlFac() == 1) {
               this.livraisonEnteteVentes.setBlvMemoNumFacture(var7.getFacNum());
            }

            this.livraisonEnteteVentes.setBlvNumFacture(var7.getFacNum());
            if (!this.var_gestion_livreur) {
               this.livraisonEnteteVentes.setBlvLivreeEtat(2);
            } else {
               this.livraisonEnteteVentes.setBlvLivreeEtat(0);
            }

            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var8);
         }

         if (this.optionsVentes.getAxeDossier().equals("2") && this.livraisonEnteteVentes.getBlvAnal4() != null && !this.livraisonEnteteVentes.getBlvAnal4().isEmpty()) {
            PlansAnalytiquesDao var44 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            this.plansAnalytiques = var44.rechercheAffaire(this.livraisonEnteteVentes.getBlvAnal4(), var8);
            if (this.plansAnalytiques != null) {
               this.plansAnalytiques.setAnaAffaireDateFacture(this.livraisonEnteteVentes.getBlvDate());
               this.plansAnalytiques = var44.modif(this.plansAnalytiques, var8);
            }
         }

         new ArrayList();
         List var45 = this.recupAppelFonds(var8);
         if (var45.size() != 0 && var7 != null) {
            new ExercicesCaisse();
            ExercicesCaisseDao var53 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var51 = var53.recupererLastExo(var8);
            if (var51 != null) {
               String var54 = this.calculChrono.numCompose(var7.getFacDate(), 61, "0", var7.getFacSerie(), var8);

               for(int var55 = 0; var55 < var45.size(); ++var55) {
                  this.reglements = new Reglements();
                  this.reglements.setRglActivite(((BonEncaissementVente)var45.get(var55)).getBonActivite());
                  this.reglements.setRglRecette(((BonEncaissementVente)var45.get(var55)).getBonAPayer());
                  var2 += this.reglements.getRglRecette();
                  this.reglements.setRglBanqueTireur(((BonEncaissementVente)var45.get(var55)).getBonBanqueTireur());
                  this.reglements.setRglBon(((BonEncaissementVente)var45.get(var55)).getBonNum());
                  this.reglements.setRglBudget(((BonEncaissementVente)var45.get(var55)).getBonBudget());
                  String var34 = "";
                  if (((BonEncaissementVente)var45.get(var55)).getBonDate().getMonth() + 1 <= 9) {
                     var34 = "0" + (((BonEncaissementVente)var45.get(var55)).getBonDate().getMonth() + 1);
                  } else {
                     var34 = "" + (((BonEncaissementVente)var45.get(var55)).getBonDate().getMonth() + 1);
                  }

                  String var35 = "" + (((BonEncaissementVente)var45.get(var55)).getBonDate().getYear() + 1900);
                  this.reglements.setRglPeriode(var34 + ":" + var35);
                  this.reglements.setRglCategorie(20);
                  this.reglements.setRglCle1(":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle2(this.utilDate.dateToStringSQLLight(((BonEncaissementVente)var45.get(var55)).getBonDate()));
                  this.reglements.setRglCle3((String)null);
                  this.reglements.setRglCle4((String)null);
                  this.reglements.setRglCodeBudgetTreso(((BonEncaissementVente)var45.get(var55)).getBonCodeBudgetTreso());
                  this.reglements.setRglCodeCaiss(((BonEncaissementVente)var45.get(var55)).getBonCodeCaisse());
                  this.reglements.setRglCodePosteTreso(((BonEncaissementVente)var45.get(var55)).getBonCodePosteTreso());
                  this.reglements.setRglDepartement(((BonEncaissementVente)var45.get(var55)).getBonDepartement());
                  this.reglements.setRglDevise(((BonEncaissementVente)var45.get(var55)).getBonDevise());
                  this.reglements.setRglDateReg(((BonEncaissementVente)var45.get(var55)).getBonDate());
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateModif((Date)null);
                  this.reglements.setRglGrp(((BonEncaissementVente)var45.get(var55)).getBonGrp());
                  this.reglements.setRglFormatDevise(this.structureLog.getStrformatdevise());
                  this.reglements.setRglIdBon(((BonEncaissementVente)var45.get(var55)).getBonId());
                  this.reglements.setRglIdCommercial(((BonEncaissementVente)var45.get(var55)).getBonIdCommercial());
                  this.reglements.setRglIdContact(((BonEncaissementVente)var45.get(var55)).getBonIdContact());
                  this.reglements.setRglIdEquipe(((BonEncaissementVente)var45.get(var55)).getBonIdEquipe());
                  this.reglements.setRglIdResponsable(((BonEncaissementVente)var45.get(var55)).getBonIdResponsable());
                  this.reglements.setRglIdTiers(((BonEncaissementVente)var45.get(var55)).getBonIdTiers());
                  this.reglements.setRglLibCaiss(((BonEncaissementVente)var45.get(var55)).getBonLibCaisse());
                  this.reglements.setRglLibelle(((BonEncaissementVente)var45.get(var55)).getBonLibelle());
                  this.reglements.setRglModele(((BonEncaissementVente)var45.get(var55)).getBonModeleImp());
                  this.reglements.setRglMode("" + ((BonEncaissementVente)var45.get(var55)).getBonMode());
                  this.reglements.setRglNomCommercial(((BonEncaissementVente)var45.get(var55)).getBonNomCommercial());
                  this.reglements.setRglNomContact(((BonEncaissementVente)var45.get(var55)).getBonNomContact());
                  this.reglements.setRglNomEquipe(((BonEncaissementVente)var45.get(var55)).getBonNomEquipe());
                  this.reglements.setRglNomResponsable(((BonEncaissementVente)var45.get(var55)).getBonNomResponsable());
                  this.reglements.setRglNomTiers(((BonEncaissementVente)var45.get(var55)).getBonNomTiers());
                  this.reglements.setRglNumChqBdx(((BonEncaissementVente)var45.get(var55)).getBonNumChqBdx());
                  this.reglements.setRglNum(var54);
                  this.reglements.setRglNatureDoc(25);
                  this.reglements.setRglDocument(var7.getFacNum());
                  this.reglements.setRglIdDocument(var7.getFacId());
                  this.reglements.setRglObjet(((BonEncaissementVente)var45.get(var55)).getBonObject());
                  this.reglements.setRglPdv(((BonEncaissementVente)var45.get(var55)).getBonPdv());
                  this.reglements.setRglRegion(((BonEncaissementVente)var45.get(var55)).getBonRegion());
                  this.reglements.setRglRendu(((BonEncaissementVente)var45.get(var55)).getBonRendu());
                  this.reglements.setRglSecteur(((BonEncaissementVente)var45.get(var55)).getBonSecteur());
                  this.reglements.setRglSerie(((BonEncaissementVente)var45.get(var55)).getBonSerie());
                  this.reglements.setRglService(((BonEncaissementVente)var45.get(var55)).getBonService());
                  this.reglements.setRglSite(((BonEncaissementVente)var45.get(var55)).getBonSite());
                  this.reglements.setRglTypeReg(((BonEncaissementVente)var45.get(var55)).getBonTypeReg());
                  this.reglements.setRglTypeTiers(((BonEncaissementVente)var45.get(var55)).getBonTypeTiers());
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setExercicesCaisse(var51);
                  this.reglements = this.reglementsDao.insert(this.reglements, var8);
               }
            }
         }

         var9.commit();
      } catch (HibernateException var39) {
         if (var9 != null) {
            var9.rollback();
         }

         throw var39;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var2 != 0.0D) {
         var7 = var4.pourParapheur(var7.getFacId(), (Session)null);
         if (var7 != null) {
            var7.setFacTotReglement(var2);
            var7.setFacEtat(1);
            var4.modif(var7);
         }
      }

   }

   public List recupAppelFonds(Session var1) throws HibernateException, NamingException {
      Object var2 = new ArrayList();
      long var3 = 0L;
      if (this.livraisonEnteteVentes != null) {
         new ArrayList();
         List var5 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
         if (var5.size() != 0) {
            for(int var6 = 0; var6 < var5.size(); ++var6) {
               if (((DocumentTraceVentes)var5.get(var6)).getDoctraOrgType() == 22) {
                  var3 = ((DocumentTraceVentes)var5.get(var6)).getDoctraOrgId();
                  break;
               }
            }
         }

         if (var3 != 0L) {
            var2 = this.bonEncaissementVenteDao.rechercheBeByDocAppelFonds(var3, 22, var1);
         }
      }

      return (List)var2;
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

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.livraisonEnteteVentes != null) {
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
         if (this.var_tot_bon_encaissement > this.livraisonEnteteVentes.getBlvTotTtc()) {
            this.livraisonEnteteVentes.setBlvTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.livraisonEnteteVentes.getBlvTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.livraisonEnteteVentes.getBlvTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.livraisonEnteteVentes.getBlvEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.livraisonEnteteVentes.getBlvTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.livraisonEnteteVentes.setBlvTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.livraisonEnteteVentes.getBlvTotTtc() - this.var_tot_bon_encaissement;
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.livraisonEnteteVentes.getBlvSerie())) {
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
      if (this.livraisonEnteteVentes.getBlvTypeReg() != 4 && this.livraisonEnteteVentes.getBlvTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (Math.abs(this.var_tot_bon_encaissement) <= Math.abs(this.livraisonEnteteVentes.getBlvTotTtc())) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.livraisonEnteteVentes.getBlvTypeReg() == 5) {
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(this.nature, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.livraisonEnteteVentes.getBlvSerie(), var1);
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
                  this.bonEncaissementVente.setBonActivite(this.livraisonEnteteVentes.getBlvActivite());
                  this.bonEncaissementVente.setBonSite(this.livraisonEnteteVentes.getBlvSite());
                  this.bonEncaissementVente.setBonDepartement(this.livraisonEnteteVentes.getBlvDepartement());
                  this.bonEncaissementVente.setBonService(this.livraisonEnteteVentes.getBlvService());
                  this.bonEncaissementVente.setBonRegion(this.livraisonEnteteVentes.getBlvRegion());
                  this.bonEncaissementVente.setBonSecteur(this.livraisonEnteteVentes.getBlvSecteur());
                  this.bonEncaissementVente.setBonPdv(this.livraisonEnteteVentes.getBlvPdv());
                  this.bonEncaissementVente.setBonDateEcheReg(this.livraisonEnteteVentes.getBlvDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.livraisonEnteteVentes.getBlvNomTiers());
                  this.bonEncaissementVente.setBonIdTiers(this.livraisonEnteteVentes.getTiers().getTieid());
                  this.bonEncaissementVente.setBonNomContact(this.livraisonEnteteVentes.getBlvNomContact());
                  this.bonEncaissementVente.setBonIdContact(this.livraisonEnteteVentes.getBlvIdContact());
                  this.bonEncaissementVente.setBonTypeTiers(0);
                  this.bonEncaissementVente.setBonLibelle("Règlement Livraison N° " + this.livraisonEnteteVentes.getBlvNum());
                  this.bonEncaissementVente.setBonRef(this.livraisonEnteteVentes.getBlvNum());
                  this.bonEncaissementVente.setBonIdRef(this.livraisonEnteteVentes.getBlvId());
                  this.bonEncaissementVente.setBonObject(this.livraisonEnteteVentes.getBlvObject());
                  this.bonEncaissementVente.setBonObservation(this.livraisonEnteteVentes.getBlvObservation());
                  this.bonEncaissementVente.setBonSerie(this.livraisonEnteteVentes.getBlvSerie());
                  this.bonEncaissementVente.setBonDevise(this.livraisonEnteteVentes.getBlvDevise());
                  this.bonEncaissementVente.setBonTotTtc(this.livraisonEnteteVentes.getBlvTotTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonDateRemise(this.var_date_remise);
                  this.bonEncaissementVente.setBonIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.livraisonEnteteVentes.getBlvNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.livraisonEnteteVentes.getBlvNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(this.livraisonEnteteVentes.getBlvIdEquipe());
                  this.bonEncaissementVente.setBonNomEquipe(this.livraisonEnteteVentes.getBlvNomEquipe());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.livraisonEnteteVentes = (LivraisonEnteteVentes)this.lesEntetesList.get(var11);
            if (this.livraisonEnteteVentes.isVar_select_ligne()) {
               long var13 = this.livraisonEnteteVentes.getBlvId();
               this.livraisonEnteteVentes = new LivraisonEnteteVentes();
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(var13, var1);
               if (this.livraisonEnteteVentes != null) {
                  this.lesEntetesList.remove(var11);
                  this.livraisonEnteteVentes.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.livraisonEnteteVentes);
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
            new LivraisonEnteteVentes();
            LivraisonEnteteVentes var11 = (LivraisonEnteteVentes)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getBlvNomTiers())) && var11.getBlvSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getBlvNomTiers();
               var1 += var11.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc();
               var3 += var11.getBlvTotReglement();
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
            this.livraisonEnteteVentes.setBlvTypeReg(0);
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.livraisonEnteteVentes.getBlvSerie())) {
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
         new LivraisonEnteteVentes();
         LivraisonEnteteVentes var6 = (LivraisonEnteteVentes)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getBlvTotTtc();
            var3 += var6.getBlvTotReglement();
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
      LivraisonEnteteVentes var9;
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new LivraisonEnteteVentes();
               LivraisonEnteteVentes var7 = (LivraisonEnteteVentes)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getBlvTotTtc() + var7.getBlvTotTc() - var7.getBlvTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getBlvTotTtc() + var7.getBlvTotTc() - var7.getBlvTotReglement(), var1, this.structureLog.getStrdevise(), var7.getBlvDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getBlvTotTtc() + var7.getBlvTotTc() - var7.getBlvTotReglement(), var1, this.structureLog.getStrdevise(), var7.getBlvDate());
                  var4 = var4 - var7.getBlvTotTtc() + var7.getBlvTotTc() - var7.getBlvTotReglement();
               }

               var7.setVar_blv_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new LivraisonEnteteVentes();
            var9 = (LivraisonEnteteVentes)this.listFactureSelectionne.get(var1);
            var9.setVar_blv_timbre(0.0D);
            this.var_netAPayer += var9.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      if (this.livraisonEnteteVentes.getBlvTypeReg() == 4) {
         double var8 = 0.0D;

         for(int var3 = 0; var3 < this.listFactureSelectionne.size(); ++var3) {
            new LivraisonEnteteVentes();
            LivraisonEnteteVentes var10 = (LivraisonEnteteVentes)this.listFactureSelectionne.get(var3);
            var8 += var10.getVar_reliquat();
         }
      } else {
         this.montantElmTotBonEnc = 0.0D;

         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new LivraisonEnteteVentes();
            var9 = (LivraisonEnteteVentes)this.listFactureSelectionne.get(var1);
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
               String var7 = this.livraisonEnteteVentes.getBlvSerie();
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
                  new LivraisonEnteteVentes();

                  for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                     LivraisonEnteteVentes var20 = (LivraisonEnteteVentes)this.listFactureSelectionne.get(var21);
                     var16 = var20.getVar_blv_timbre();
                     var18 = var20.getMontantReglementManuel();
                     var12 = 0.0D;
                     if (var20.isVar_select_ligne()) {
                        long var22 = var20.getBlvId();
                        var20 = this.livraisonEnteteVentesDao.pourParapheur(var22, var3);
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
                              var12 = var20.getBlvTotTtc() + var20.getBlvTotTc() + var16 - var20.getBlvTotReglement();
                              if (var34 <= 0.0D) {
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
         Session var31 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");

         for(int var32 = 0; var32 < this.lesEntetesList.size(); ++var32) {
            this.livraisonEnteteVentes = (LivraisonEnteteVentes)this.lesEntetesList.get(var32);
            if (this.livraisonEnteteVentes.isVar_select_ligne()) {
               long var33 = this.livraisonEnteteVentes.getBlvId();
               this.livraisonEnteteVentes = new LivraisonEnteteVentes();
               this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(var33, var31);
               if (this.livraisonEnteteVentes != null) {
                  if (this.livraisonEnteteVentes.getBlvSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var32);
                  } else {
                     this.lesEntetesList.remove(var32);
                     this.livraisonEnteteVentes.setVar_select_ligne(false);
                     this.lesEntetesList.add(var32, this.livraisonEnteteVentes);
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
               this.totManuel += ((LivraisonEnteteVentes)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
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

   public void generationReglement(String var1, double var2, double var4, LivraisonEnteteVentes var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (Math.abs(var2) >= Math.abs(var6.getBlvTotTtc() + var6.getBlvTotTc() + var4)) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite(var6.getBlvActivite());
      this.reglements.setRglBudget(var6.getBlvBudget());
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
      this.reglements.setRglDepartement(var6.getBlvDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getBlvDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getBlvNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getBlvId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle(var6.getBlvObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(23);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      if (this.optionsVentes.getDecrmtPrsChrStock() != null && this.optionsVentes.getDecrmtPrsChrStock().equals("2")) {
         this.reglements.setRglIdContact(var6.getBlvIdContact());
         this.reglements.setRglNomContact(var6.getVar_nomContact());
      } else {
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
      }

      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getBlvPdv());
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getBlvDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getBlvRegion());
      this.reglements.setRglSecteur(var6.getBlvSecteur());
      this.reglements.setRglSerie(var6.getBlvSerie());
      this.reglements.setRglService(var6.getBlvService());
      this.reglements.setRglSite(var6.getBlvSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getBlvIdResponsable());
      this.reglements.setRglNomResponsable(var6.getBlvNomResponsable());
      this.reglements.setRglIdCommercial(var6.getBlvIdCommercial());
      this.reglements.setRglNomCommercial(var6.getBlvNomCommercial());
      this.reglements.setRglIdEquipe(var6.getBlvIdEquipe());
      this.reglements.setRglNomEquipe(var6.getBlvNomEquipe());
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
         var6.setBlvTotReglement(var6.getBlvTotReglement() + var2);
         var6.setBlvTotTimbre(var6.getBlvTotTimbre() + var14);
         if (Math.abs(var6.getBlvTotReglement()) >= Math.abs(var6.getBlvTotTtc() + var6.getBlvTotTc())) {
            var6.setBlvSolde(1);
         } else {
            var6.setBlvSolde(0);
         }

         var6.setBlvDateLastReg(this.reglements.getRglDateReg());
         this.livraisonEnteteVentesDao.modif(var6, var8);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.livraisonEnteteVentes.getBlvId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.livraisonEnteteVentes.setBlvTotReglement(var4);
            if (Math.abs(this.livraisonEnteteVentes.getBlvTotReglement()) >= Math.abs(this.livraisonEnteteVentes.getBlvTotTtc())) {
               this.livraisonEnteteVentes.setBlvSolde(1);
            } else {
               this.livraisonEnteteVentes.setBlvSolde(0);
            }

            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var1);
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
      if (this.livraisonEnteteVentes != null) {
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
      if (this.livraisonEnteteVentes.getBlvGarde() != null && !this.livraisonEnteteVentes.getBlvGarde().isEmpty() && this.livraisonEnteteVentes.getBlvGarde().contains(":")) {
         String[] var2 = this.livraisonEnteteVentes.getBlvGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.livraisonEnteteVentes.getUsers(), this.structureLog, this.livraisonEnteteVentes.getTiers());
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
      if (this.livraisonEnteteVentes.getBlvFormule1() != null && !this.livraisonEnteteVentes.getBlvFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.livraisonEnteteVentes.getBlvFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.livraisonEnteteVentes.getBlvFormule2() != null && !this.livraisonEnteteVentes.getBlvFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.livraisonEnteteVentes.getBlvFormule2(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.livraisonEnteteVentes.getBlvAnnexe1() != null && !this.livraisonEnteteVentes.getBlvAnnexe1().isEmpty() && this.livraisonEnteteVentes.getBlvAnnexe1().contains(":")) {
         String[] var2 = this.livraisonEnteteVentes.getBlvAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.livraisonEnteteVentes.getUsers(), this.structureLog, this.livraisonEnteteVentes.getTiers());
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
      if (this.livraisonEnteteVentes.getBlvAnnexe2() != null && !this.livraisonEnteteVentes.getBlvAnnexe2().isEmpty() && this.livraisonEnteteVentes.getBlvAnnexe2().contains(":")) {
         String[] var2 = this.livraisonEnteteVentes.getBlvAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.livraisonEnteteVentes.getUsers(), this.structureLog, this.livraisonEnteteVentes.getTiers());
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatLivraison.jpg");
            if (var4.exists()) {
               var3 = "formatLivraison.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatLivraison.jpg");
         if (var4.exists()) {
            var3 = "formatLivraison.jpg";
         }
      }

      return var3;
   }

   public String rechercheBc() throws HibernateException, NamingException {
      String var1 = "";
      if (this.datamodelDocumentTrace == null) {
         this.chargerDocumentTrace();
      }

      if (this.datamodelDocumentTrace != null) {
         int var2 = this.datamodelDocumentTrace.getRowCount();
         if (var2 == 0) {
            this.chargerDocumentTrace();
            var2 = this.datamodelDocumentTrace.getRowCount();
         }

         this.documentTraceVentes = new DocumentTraceVentes();

         for(int var3 = 0; var3 < var2; ++var3) {
            this.datamodelDocumentTrace.setRowIndex(var3);
            this.documentTraceVentes = (DocumentTraceVentes)this.datamodelDocumentTrace.getRowData();
            if (this.documentTraceVentes.getDoctraDstType() == 23 && this.documentTraceVentes.getDoctraOrgType() == 22) {
               var1 = this.documentTraceVentes.getDoctraOrgNum();
               break;
            }
         }
      }

      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(String var1) throws IOException, HibernateException, NamingException {
      this.livraisonEnteteVentes.setVar_numBc(this.rechercheBc());
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var3 = false;
         String var4 = "";
         double var5 = 0.0D;
         double var7 = 0.0D;
         this.infoOrigineDoc = "";
         ConditionnementDao var9 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();
         int var11;
         if (var1 != null && !var1.isEmpty() && var1.contains("Sortie")) {
            for(var11 = 0; var11 < this.lesLignesList.size(); ++var11) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var11);
               if ((this.livraisonLigneVentes.getBlvligModeGroupe() == 1 || this.livraisonLigneVentes.getBlvligModeGroupe() == 2) && this.livraisonLigneVentes.getBlvligGroupe() != null && !this.livraisonLigneVentes.getBlvligGroupe().isEmpty()) {
                  var2.add(this.livraisonLigneVentes);
               } else if (this.livraisonLigneVentes.getBlvligModeGroupe() == 0 && this.livraisonLigneVentes.getBlvligDepot() != null && !this.livraisonLigneVentes.getBlvligDepot().isEmpty()) {
                  var2.add(this.livraisonLigneVentes);
               }
            }
         } else {
            for(var11 = 0; var11 < this.lesLignesList.size(); ++var11) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var11);
               if (this.livraisonLigneVentes.getBlvligModeGroupe() != 2 || this.livraisonLigneVentes.getBlvligGroupe() == null || this.livraisonLigneVentes.getBlvligGroupe().isEmpty()) {
                  this.livraisonLigneVentes.setVar_lib_des_condit("");
                  if (this.livraisonLigneVentes.getBlvligCondition() != null && !this.livraisonLigneVentes.getBlvligCondition().isEmpty() && this.livraisonLigneVentes.getBlvligCondition().contains(":")) {
                     String[] var12 = this.livraisonLigneVentes.getBlvligCondition().split(":");
                     Conditionnement var10 = var9.rechercheConditionnement(var12[0], (Session)null);
                     if (var10 != null) {
                        this.livraisonLigneVentes.setVar_lib_des_condit(var10.getCdtDescription());
                     }
                  }

                  if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && this.livraisonLigneVentes.getBlvligCode().equals("-")) {
                     var3 = true;
                     var4 = this.livraisonLigneVentes.getBlvligLibelle();
                     if (var4.startsWith("Suivant ")) {
                        this.infoOrigineDoc = var4;
                     }
                  }

                  if (var3) {
                     var5 += this.livraisonLigneVentes.getBlvligPt();
                     var7 = this.livraisonLigneVentes.getBlvligTtc();
                  }

                  if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty() && this.livraisonLigneVentes.getBlvligCode().equals("=") && var3) {
                     this.livraisonLigneVentes = new LivraisonLigneVentes();
                     this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
                     this.livraisonLigneVentes.setBlvligCode("=");
                     this.livraisonLigneVentes.setBlvligOrdre(var11);
                     this.livraisonLigneVentes.setBlvligLibelle(var4);
                     this.livraisonLigneVentes.setBlvligPt(var5);
                     this.livraisonLigneVentes.setBlvligTtc(var7);
                     var2.add(this.livraisonLigneVentes);
                     var5 = 0.0D;
                     var7 = 0.0D;
                     var3 = false;
                  } else {
                     if (this.livraisonLigneVentes.getBlvligNumSerie() != null && !this.livraisonLigneVentes.getBlvligNumSerie().isEmpty() && this.livraisonLigneVentes.getBlvligNumSerie().equals("SERIE") && this.livraisonLigneVentes.getBlvligQte() != 0.0F) {
                        new ArrayList();
                        List var16 = this.receptionSerieAchatsDao.selectBlSerieByBlLig(this.livraisonLigneVentes, (Session)null);
                        String var13 = "";
                        if (var16.size() != 0) {
                           for(int var14 = 0; var14 < var16.size(); ++var14) {
                              var13 = var13 + " " + ((ReceptionSerieAchats)var16.get(var14)).getRecserSerie();
                           }
                        }

                        this.livraisonLigneVentes.setNumSerie(var13);
                     } else {
                        this.livraisonLigneVentes.setNumSerie("");
                     }

                     this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
                     this.livraisonLigneVentes.setBlvligOrdre(var11);
                     var2.add(this.livraisonLigneVentes);
                  }
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.livraisonLigneVentes = new LivraisonLigneVentes();
            this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
            this.livraisonLigneVentes.setBlvligCode("FORMULE1");
            this.livraisonLigneVentes.setBlvligOrdre(var2.size() + 2);
            this.livraisonLigneVentes.setBlvligLibelle(this.formule1());
            this.livraisonLigneVentes.setBlvligPt(0.0D);
            this.livraisonLigneVentes.setBlvligTtc(0.0D);
            var2.add(this.livraisonLigneVentes);
            this.livraisonLigneVentes = new LivraisonLigneVentes();
            this.livraisonLigneVentes.setLivraisonEnteteVentes(this.livraisonEnteteVentes);
            this.livraisonLigneVentes.setBlvligCode("FORMULE2");
            this.livraisonLigneVentes.setBlvligOrdre(var2.size() + 2);
            this.livraisonLigneVentes.setBlvligLibelle(this.formule2());
            this.livraisonLigneVentes.setBlvligPt(0.0D);
            this.livraisonLigneVentes.setBlvligTtc(0.0D);
            var2.add(this.livraisonLigneVentes);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.utilNombre.myRoundDevise(this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc(), this.livraisonEnteteVentes.getBlvDevise()), this.livraisonEnteteVentes.getBlvDevise());
      JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(var2);
      return var15;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.livraisonEnteteVentes.getBlvAnal2() != null && !this.livraisonEnteteVentes.getBlvAnal2().isEmpty()) {
         String var4 = "";
         if (this.livraisonEnteteVentes.getBlvAnal2().contains(":")) {
            String[] var5 = this.livraisonEnteteVentes.getBlvAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.livraisonEnteteVentes.getBlvAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.livraisonEnteteVentes.getBlvDateImp() != null && this.livraisonEnteteVentes.getBlvEtat() != 0) {
            var2 = true;
         }

         boolean var5 = false;
         this.livraisonEnteteVentes.setBlvDateImp(new Date());
         if (this.livraisonEnteteVentes.getBlvEtat() == 0 && this.livraisonEnteteVentes.getBlvEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.livraisonEnteteVentes.setBlvEtat(1);
            var5 = true;
         }

         this.livraisonEnteteVentes.setBlvModeleImp(var1);
         this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var3);
         if (var5) {
            if (!this.var_gestion_livreur) {
               this.livraisonLivreeVentesDao.deleteLigne(this.lesLivraisonLivree, var3);
               this.lesLivraisonLivree.clear();
               if (this.lesLignesList.size() != 0) {
                  this.calculStock.majLivraisonVentesVAL(this.lesLignesList, 1, this.baseLog, var3);
               }
            } else {
               this.calculStock.majLivraisonVentesVAL(this.lesLignesList, 1, this.baseLog, var3);
            }

            if (this.tiers.getTieDteDocument3() == null || this.livraisonEnteteVentes.getBlvDate().after(this.tiers.getTieDteDocument3())) {
               this.tiers.setTieDteDocument3(this.livraisonEnteteVentes.getBlvDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         if (this.lesLignesList.size() != 0) {
            this.livraisonLigneVentes = new LivraisonLigneVentes();

            for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var6);
               this.livraisonLigneVentes.setVar_desciptif((String)null);
               this.livraisonLigneVentes.setVar_photo((String)null);
               this.livraisonLigneVentes.setVar_photo_taille(0);
               if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var3);
                  if (this.produits != null) {
                     String var7 = this.produits.getProCode();
                     this.livraisonLigneVentes.setVar_desciptif(this.produits.getProDescrip());
                     if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
                        String var8 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
                        File var9 = new File(var8);
                        if (var9.exists()) {
                           this.livraisonLigneVentes.setVar_photo(this.calculeCheminImageProduit(this.baseLog) + this.produits.getProPhoto());
                           if (this.produits.getProPhotoTaille() == 0) {
                              this.livraisonLigneVentes.setVar_photo_taille(1);
                           } else {
                              this.livraisonLigneVentes.setVar_photo_taille(2);
                           }
                        } else {
                           this.livraisonLigneVentes.setVar_photo((String)null);
                           this.livraisonLigneVentes.setVar_photo_taille(0);
                        }
                     } else {
                        this.livraisonLigneVentes.setVar_photo((String)null);
                        this.livraisonLigneVentes.setVar_photo_taille(0);
                     }

                     new LivraisonLigneVentes();

                     for(int var16 = var6 + 1; var16 < this.lesLignesList.size(); ++var16) {
                        LivraisonLigneVentes var15 = (LivraisonLigneVentes)this.lesLignesList.get(var16);
                        if (var15.getBlvligCode() != null && !var15.getBlvligCode().isEmpty() && var15.getBlvligCode().equals(var7)) {
                           var15.setBlvligCode(var15.getBlvligCode() + "*");
                        }
                     }
                  }
               }
            }
         }

         this.contacts = new Contacts();
         if (this.livraisonEnteteVentes.getBlvIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.livraisonEnteteVentes.getBlvIdContact(), var3);
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
            var1.setEntete("Impression BL");
            var1.setPageGarde(this.conversionGarde());
            if (this.livraisonEnteteVentes.getBlvFormule1() != null && !this.livraisonEnteteVentes.getBlvFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.livraisonEnteteVentes.getBlvEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.livraisonEnteteVentes.setBlvDevise(this.devisePrint);
            if (!this.livraisonEnteteVentes.getBlvDevise().equals("XOF") && !this.livraisonEnteteVentes.getBlvDevise().equals("XAF")) {
               if (this.livraisonEnteteVentes.getBlvDevise().equals("EUR")) {
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
               double var13 = this.utilNombre.myRound((this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
            var1.setIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
            var1.setTiersSelectionne(this.livraisonEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.livraisonEnteteVentes.getBlvNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.livraisonEnteteVentes.getBlvId());
            if (this.livraisonEnteteVentes.getBlvAnal2() != null && !this.livraisonEnteteVentes.getBlvAnal2().isEmpty()) {
               var17 = "";
               if (this.livraisonEnteteVentes.getBlvAnal2().contains(":")) {
                  var14 = this.livraisonEnteteVentes.getBlvAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.livraisonEnteteVentes.getBlvAnal2();
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
               var1.setEntete("Impression de la liste des BL");
               var1.setTotauxHt("" + this.totauxHt);
               var1.setTotauxTaxe("" + this.totauxTaxe);
               var1.setTotauxTtc("" + this.totauxTtc);
               var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "livraison" + File.separator);
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
            var16 = new JRBeanCollectionDataSource(this.lesLivraisonLivree);
            var1.setjRBeanCollectionDataSource(var16);
            var1.setRapport(var4);
            var1.setEntete("Impression reliquat livraison");
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "reliquatBL" + File.separator);
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.livraisonEnteteVentes.getBlvEtat()));
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setIdResponsable(this.livraisonEnteteVentes.getBlvIdResponsable());
            var1.setIdCommercial(this.livraisonEnteteVentes.getBlvIdCommercial());
            var1.setTiersSelectionne(this.livraisonEnteteVentes.getTiers());
            var1.setNature(this.nature);
            var1.setId_doc(this.livraisonEnteteVentes.getBlvId());
            if (this.livraisonEnteteVentes.getBlvAnal2() != null && !this.livraisonEnteteVentes.getBlvAnal2().isEmpty()) {
               var17 = "";
               if (this.livraisonEnteteVentes.getBlvAnal2().contains(":")) {
                  var14 = this.livraisonEnteteVentes.getBlvAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.livraisonEnteteVentes.getBlvAnal2();
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
            this.uniteGraph = "LIVRAISON : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "LIVRAISON : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "LIVRAISON : Quantites";
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

         new LivraisonEnteteVentes();
         new LivraisonLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonLigne");
         String var6 = "";

         LivraisonEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (LivraisonEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getBlvNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getBlvNum() + "'";
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

                  var14 = (LivraisonEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getBlvDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getBlvNomResponsable() != null && !var14.getBlvNomResponsable().isEmpty()) {
                        var17 = var14.getBlvNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getBlvNomCommercial() != null && !var14.getBlvNomCommercial().isEmpty()) {
                        var17 = var14.getBlvNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getBlvNomEquipe() != null && !var14.getBlvNomEquipe().isEmpty()) {
                        var17 = var14.getBlvNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getBlvNomTiers() != null && !var14.getBlvNomTiers().isEmpty()) {
                        var17 = var14.getBlvNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getBlvSource() != null && !var14.getBlvSource().isEmpty()) {
                        var17 = var14.getBlvSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getBlvAnal4() != null && !var14.getBlvAnal4().isEmpty()) {
                        var17 = var14.getBlvAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getBlvRegion() != null && !var14.getBlvRegion().isEmpty()) {
                        var17 = var14.getBlvRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getBlvSecteur() != null && !var14.getBlvSecteur().isEmpty()) {
                        var17 = var14.getBlvSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getBlvPdv() != null && !var14.getBlvPdv().isEmpty()) {
                        var17 = var14.getBlvPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getBlvSite() != null && !var14.getBlvSite().isEmpty()) {
                        var17 = var14.getBlvSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getBlvDepartement() != null && !var14.getBlvDepartement().isEmpty()) {
                        var17 = var14.getBlvDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getBlvService() != null && !var14.getBlvService().isEmpty()) {
                        var17 = var14.getBlvService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getBlvSerie() != null && !var14.getBlvSerie().isEmpty()) {
                        var17 = var14.getBlvSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getBlvTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getBlvDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getBlvDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getBlvDate().getMonth() + 1 >= 1 && var14.getBlvDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getBlvDate().getMonth() + 1 >= 4 && var14.getBlvDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getBlvDate().getMonth() + 1 >= 7 && var14.getBlvDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getBlvDate().getMonth() + 1 >= 10 && var14.getBlvDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getBlvDate().getMonth() + 1 >= 1 && var14.getBlvDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getBlvDate().getMonth() + 1 >= 7 && var14.getBlvDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getBlvDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.livraisonLigneVentesDao.chargerLesLignesLivraisons(var6, var5);
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

                  LivraisonLigneVentes var15 = (LivraisonLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getLivraisonEnteteVentes().getBlvDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getLivraisonEnteteVentes().getBlvNomResponsable() != null && !var15.getLivraisonEnteteVentes().getBlvNomResponsable().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getLivraisonEnteteVentes().getBlvNomCommercial() != null && !var15.getLivraisonEnteteVentes().getBlvNomCommercial().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getLivraisonEnteteVentes().getBlvNomEquipe() != null && !var15.getLivraisonEnteteVentes().getBlvNomEquipe().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getLivraisonEnteteVentes().getBlvNomTiers() != null && !var15.getLivraisonEnteteVentes().getBlvNomTiers().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getBlvligFamille() != null && !var15.getBlvligFamille().isEmpty()) {
                        var8 = var15.getBlvligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getBlvligLibelle() != null && !var15.getBlvligLibelle().isEmpty()) {
                        var8 = var15.getBlvligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getLivraisonEnteteVentes().getBlvSource() != null && !var15.getLivraisonEnteteVentes().getBlvSource().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getLivraisonEnteteVentes().getBlvAnal4() != null && !var15.getLivraisonEnteteVentes().getBlvAnal4().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getLivraisonEnteteVentes().getBlvRegion() != null && !var15.getLivraisonEnteteVentes().getBlvRegion().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getLivraisonEnteteVentes().getBlvSecteur() != null && !var15.getLivraisonEnteteVentes().getBlvSecteur().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getLivraisonEnteteVentes().getBlvPdv() != null && !var15.getLivraisonEnteteVentes().getBlvPdv().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getLivraisonEnteteVentes().getBlvSite() != null && !var15.getLivraisonEnteteVentes().getBlvSite().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getLivraisonEnteteVentes().getBlvDepartement() != null && !var15.getLivraisonEnteteVentes().getBlvDepartement().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getLivraisonEnteteVentes().getBlvService() != null && !var15.getLivraisonEnteteVentes().getBlvService().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getLivraisonEnteteVentes().getBlvSerie() != null && !var15.getLivraisonEnteteVentes().getBlvSerie().isEmpty()) {
                        var8 = var15.getLivraisonEnteteVentes().getBlvSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getBlvligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getBlvligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getLivraisonEnteteVentes().getBlvDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 >= 1 && var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 >= 4 && var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 >= 7 && var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 >= 10 && var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 >= 1 && var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 >= 7 && var15.getLivraisonEnteteVentes().getBlvDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getLivraisonEnteteVentes().getBlvDate().getHours();
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

   public void accesPiecesJointes() throws HibernateException, NamingException {
      this.lesPiecesJointes.clear();
      if (this.livraisonEnteteVentes != null) {
         String var1 = this.livraisonEnteteVentes.getBlvNum().replace("/", "_") + "_";
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
                        var1 = this.livraisonEnteteVentes.getBlvNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomPiecesJointes) + "." + var8;
                     } else {
                        var1 = this.livraisonEnteteVentes.getBlvNum().replace("/", "_") + "." + var8;
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
                     this.livraisonEnteteVentes.setBlvPj(true);
                  } else {
                     this.livraisonEnteteVentes.setBlvPj(false);
                  }

                  this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
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
         this.livraisonEnteteVentes.setBlvPj(true);
      } else {
         this.livraisonEnteteVentes.setBlvPj(false);
      }

      this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes);
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

   public void recalculTva(LivraisonEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.livraisonEnteteVentes = var1;
         this.tiers = this.livraisonEnteteVentes.getTiers();
         if (this.tiers.getTiecss() == 0 && this.structureLog.getStrcodepays().equals("0077")) {
            this.var_tc_calcul = true;
            this.var_tc_taux = 1.0F;
            this.var_tc_type = 7;
         } else {
            this.var_tc_calcul = false;
            this.var_tc_taux = 0.0F;
            this.var_tc_type = 0;
         }

         this.lesLignesList = this.livraisonLigneVentesDao.chargerLesLignes(this.livraisonEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var2);
               }

               this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var2);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var2);
            }

            this.cumulPrix();
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var2);
         }
      }

   }

   public void recalculCss(LivraisonEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.livraisonEnteteVentes = var1;
         this.tiers = this.livraisonEnteteVentes.getTiers();
         this.lesLignesList = this.livraisonLigneVentesDao.chargerLesLignes(this.livraisonEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.livraisonLigneVentes = (LivraisonLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.livraisonLigneVentes.getBlvligCode() != null && !this.livraisonLigneVentes.getBlvligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.livraisonLigneVentes.getBlvligCode(), var2);
               }

               this.calculPrix(this.livraisonLigneVentes.getBlvligTaxe(), this.livraisonLigneVentes.getBlvligTauxTaxe(), var2);
               this.livraisonLigneVentes = this.livraisonLigneVentesDao.modif(this.livraisonLigneVentes, var2);
            }

            this.cumulPrix();
            this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.modif(this.livraisonEnteteVentes, var2);
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

   public LivraisonEnteteVentes getLivraisonEnteteVentes() {
      return this.livraisonEnteteVentes;
   }

   public void setLivraisonEnteteVentes(LivraisonEnteteVentes var1) {
      this.livraisonEnteteVentes = var1;
   }

   public LivraisonLigneVentes getLivraisonLigneVentes() {
      return this.livraisonLigneVentes;
   }

   public void setLivraisonLigneVentes(LivraisonLigneVentes var1) {
      this.livraisonLigneVentes = var1;
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

   public DataModel getDataModelLivraison() {
      return this.dataModelLivraison;
   }

   public void setDataModelLivraison(DataModel var1) {
      this.dataModelLivraison = var1;
   }

   public boolean isShowModalPanelLivraison() {
      return this.showModalPanelLivraison;
   }

   public void setShowModalPanelLivraison(boolean var1) {
      this.showModalPanelLivraison = var1;
   }

   public LivraisonLivreeVentes getLivraisonLivreeVentes() {
      return this.livraisonLivreeVentes;
   }

   public void setLivraisonLivreeVentes(LivraisonLivreeVentes var1) {
      this.livraisonLivreeVentes = var1;
   }

   public boolean isVar_livreur() {
      return this.var_livreur;
   }

   public void setVar_livreur(boolean var1) {
      this.var_livreur = var1;
   }

   public DataModel getDataModelLot() {
      return this.dataModelLot;
   }

   public void setDataModelLot(DataModel var1) {
      this.dataModelLot = var1;
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

   public boolean isVar_validation_lot() {
      return this.var_validation_lot;
   }

   public void setVar_validation_lot(boolean var1) {
      this.var_validation_lot = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
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

   public int getVar_type_serie() {
      return this.var_type_serie;
   }

   public void setVar_type_serie(int var1) {
      this.var_type_serie = var1;
   }

   public List getMesCartonsItems() {
      return this.mesCartonsItems;
   }

   public void setMesCartonsItems(List var1) {
      this.mesCartonsItems = var1;
   }

   public List getMesPalettesItems() {
      return this.mesPalettesItems;
   }

   public void setMesPalettesItems(List var1) {
      this.mesPalettesItems = var1;
   }

   public String getVar_select_carton() {
      return this.var_select_carton;
   }

   public void setVar_select_carton(String var1) {
      this.var_select_carton = var1;
   }

   public String getVar_select_palette() {
      return this.var_select_palette;
   }

   public void setVar_select_palette(String var1) {
      this.var_select_palette = var1;
   }

   public boolean isVar_liste_vide() {
      return this.var_liste_vide;
   }

   public void setVar_liste_vide(boolean var1) {
      this.var_liste_vide = var1;
   }

   public boolean isVar_select_type() {
      return this.var_select_type;
   }

   public void setVar_select_type(boolean var1) {
      this.var_select_type = var1;
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

   public boolean isValide_livreur() {
      return this.valide_livreur;
   }

   public void setValide_livreur(boolean var1) {
      this.valide_livreur = var1;
   }

   public String getVar_chauffeur() {
      return this.var_chauffeur;
   }

   public void setVar_chauffeur(String var1) {
      this.var_chauffeur = var1;
   }

   public Date getVar_date_livree() {
      return this.var_date_livree;
   }

   public void setVar_date_livree(Date var1) {
      this.var_date_livree = var1;
   }

   public String getVar_preparateur() {
      return this.var_preparateur;
   }

   public void setVar_preparateur(String var1) {
      this.var_preparateur = var1;
   }

   public String getVar_vehicule() {
      return this.var_vehicule;
   }

   public void setVar_vehicule(String var1) {
      this.var_vehicule = var1;
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

   public boolean isShowModalPanelPrintLivree() {
      return this.showModalPanelPrintLivree;
   }

   public void setShowModalPanelPrintLivree(boolean var1) {
      this.showModalPanelPrintLivree = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public int getValidationLigne() {
      return this.validationLigne;
   }

   public void setValidationLigne(int var1) {
      this.validationLigne = var1;
   }

   public String getMessageStockNegatif() {
      return this.messageStockNegatif;
   }

   public void setMessageStockNegatif(String var1) {
      this.messageStockNegatif = var1;
   }

   public boolean isVar_gestion_livreur() {
      return this.var_gestion_livreur;
   }

   public void setVar_gestion_livreur(boolean var1) {
      this.var_gestion_livreur = var1;
   }

   public DataModel getDataModelLivraisonHisto() {
      return this.dataModelLivraisonHisto;
   }

   public void setDataModelLivraisonHisto(DataModel var1) {
      this.dataModelLivraisonHisto = var1;
   }

   public boolean isLivreeModif() {
      return this.livreeModif;
   }

   public void setLivreeModif(boolean var1) {
      this.livreeModif = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
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

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
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

   public double getSoldeImputation() {
      return this.soldeImputation;
   }

   public void setSoldeImputation(double var1) {
      this.soldeImputation = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
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

   public double getVar_tot_bon_encaissement() {
      return this.var_tot_bon_encaissement;
   }

   public void setVar_tot_bon_encaissement(double var1) {
      this.var_tot_bon_encaissement = var1;
   }

   public boolean isReglementAutorise() {
      return this.reglementAutorise;
   }

   public void setReglementAutorise(boolean var1) {
      this.reglementAutorise = var1;
   }

   public DataModel getDatamodelRecu() {
      return this.datamodelRecu;
   }

   public void setDatamodelRecu(DataModel var1) {
      this.datamodelRecu = var1;
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

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public String getVar_nom_client() {
      return this.var_nom_client;
   }

   public void setVar_nom_client(String var1) {
      this.var_nom_client = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public String getVar_num_facture() {
      return this.var_num_facture;
   }

   public void setVar_num_facture(String var1) {
      this.var_num_facture = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public Date getVar_date_remise() {
      return this.var_date_remise;
   }

   public void setVar_date_remise(Date var1) {
      this.var_date_remise = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public double getTotManuel() {
      return this.totManuel;
   }

   public void setTotManuel(double var1) {
      this.totManuel = var1;
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

   public double getTotauxHt() {
      return this.totauxHt;
   }

   public void setTotauxHt(double var1) {
      this.totauxHt = var1;
   }

   public double getTotauxTaxe() {
      return this.totauxTaxe;
   }

   public void setTotauxTaxe(double var1) {
      this.totauxTaxe = var1;
   }

   public double getTotauxTtc() {
      return this.totauxTtc;
   }

   public void setTotauxTtc(double var1) {
      this.totauxTtc = var1;
   }

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
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

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
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

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getNomPiecesJointes() {
      return this.nomPiecesJointes;
   }

   public void setNomPiecesJointes(String var1) {
      this.nomPiecesJointes = var1;
   }

   public DataModel getDataModelPieceJointes() {
      return this.dataModelPieceJointes;
   }

   public void setDataModelPieceJointes(DataModel var1) {
      this.dataModelPieceJointes = var1;
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
