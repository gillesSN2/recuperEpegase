package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.ContratLigneVentes;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsTarif;
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
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.ContratLigneVentesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
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
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureFamillesClients;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;
import org.xml.sax.SAXException;

public class FormFactureVentes implements Serializable {
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
   private FactureEnteteVentes factureEnteteVentes = new FactureEnteteVentes();
   private FactureEnteteVentesDao factureEnteteVentesDao;
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
   private FactureLigneVentes factureLigneVentes = new FactureLigneVentes();
   private FactureLigneVentesDao factureLigneVentesDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
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
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpNomDestinataire = "";
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpCaisse = "";
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
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private String devisePrint;
   private float tauxPrint;
   private DocumentTraceVentes documentTraceVentes;
   private boolean var_transit = false;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
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
   private List lstReg = new ArrayList();
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
   private double totalAppelFonds;
   private String numeroAppelFonds;
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
   private boolean valideLissage;
   private double var_montant_trf;
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
   private boolean showModalPanelGeneration = false;
   private List lesPeriodesGeneration;
   private String var_periodeGeneration;
   private long var_idTiersGeneration;
   private List lesClientsItems;
   private int modeCalcul;
   private int modeCommision;
   private int modePresentation;
   private int modeFacturation;
   private float tauxCommission;
   private float tauxCss;
   private String libelle1;
   private double montant1;
   private String libelle2;
   private double montant2;
   private List mesServicesInterimItems = new ArrayList();
   private boolean validatioPeriode;
   private List mesPeriodesItems;
   private List mesImpressionsFacturesItems;
   private String modeleFacture;
   private String region;
   private List lesFacturesGene;
   private List lesContratsLigneGene;
   private transient DataModel datamodelEnteteGene;
   private boolean showModalPanelPrintReleve = false;
   private double plafondEnCours;
   private double soldeEnCours;
   private boolean plafondAutorise;
   private String libelleRabRis;
   private boolean ristourne;

   public FormFactureVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionsVentes.getPaiementAVOIR().equalsIgnoreCase("0")) {
         this.reglementAutorise = true;
      } else {
         this.reglementAutorise = false;
      }

      if (this.typeVente == 806) {
         this.var_transit = true;
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

      this.periode = this.optionsVentes.getAffichInGlobViewFAC();
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
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemise = false;
      } else {
         this.verrouRemise = true;
      }

      if (this.usersLog.getUsrVerRabais() != 0 && !this.optionsVentes.getDecrmtRabais().equals("3")) {
         this.verrouRabais = true;
      } else {
         this.verrouRabais = false;
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
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
      this.inpSite = "";
      this.inpDepartement = "";
      this.inpService = "";
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
      this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.factureEnteteVentes != null) {
         this.devisePrint = this.factureEnteteVentes.getFacDevise();
         this.lesLignesList = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, (Session)null);
      }

   }

   public void moreSearch() throws ParseException {
      this.selectDestinataire = false;
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
      this.inpSite = "";
      this.inpDepartement = "";
      this.inpService = "";
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

      this.chargeListeDetail(var1);
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
      this.setMontantTtcElmt(0.0D);
      this.setMontantReglementElmt(0.0D);
      this.setMontantSoldeElmt(0.0D);
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
         if (this.inpService != null && !this.inpService.isEmpty() && this.inpService.equals("100")) {
            this.inpService = "";
         }

         new ArrayList();
         byte var13 = 0;
         if (this.typeVente == 810) {
            var13 = 1;
         }

         List var12 = this.factureEnteteVentesDao.recherche(var1, var13, this.exercicesVentes.getExevteId(), this.inpNum, this.inpNumBCC, this.inpNumAnal, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var21 = false;
            boolean var15 = false;
            boolean var16 = false;
            new FactureEnteteVentes();

            for(int var18 = 0; var18 < var12.size(); ++var18) {
               FactureEnteteVentes var17 = (FactureEnteteVentes)var12.get(var18);
               if (var17.getFacActivite() != null && !var17.getFacActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var17.getFacActivite().contains(this.var_colonne1)) {
                        var21 = true;
                     } else {
                        var21 = false;
                     }
                  } else {
                     var21 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var17.getFacActivite().contains(this.var_colonne2)) {
                        var15 = true;
                     } else {
                        var15 = false;
                     }
                  } else {
                     var15 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var17.getFacActivite().contains(this.var_colonne3)) {
                        var16 = true;
                     } else {
                        var16 = false;
                     }
                  } else {
                     var16 = true;
                  }

                  if (var21 && var15 && var16) {
                     this.lesEntetesList.add(var17);
                  }
               }
            }
         } else {
            for(int var14 = 0; var14 < var12.size(); ++var14) {
               this.lesEntetesList.add(var12.get(var14));
            }
         }
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new FactureEnteteVentes();

         for(int var20 = 0; var20 < this.lesEntetesList.size(); ++var20) {
            FactureEnteteVentes var19 = (FactureEnteteVentes)this.lesEntetesList.get(var20);
            var2 += var19.getFacTotTtc();
            var4 += var19.getFacTotReglement();
            var6 += var19.getFacTotHt();
            var8 += var19.getFacTotTva();
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
            this.factureEnteteVentes = (FactureEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.factureEnteteVentes.getFacNomTiers();
            this.inpIdTiersEnCours = this.factureEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.factureEnteteVentes.getFacNomContact();
            this.var_date = this.factureEnteteVentes.getFacDate();
            if (this.factureEnteteVentes.getFacDate().getHours() <= 9) {
               this.var_heure = "0" + this.factureEnteteVentes.getFacDate().getHours();
            } else {
               this.var_heure = "" + this.factureEnteteVentes.getFacDate().getHours();
            }

            if (this.factureEnteteVentes.getFacDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.factureEnteteVentes.getFacDate().getMinutes();
            } else {
               this.var_minute = "" + this.factureEnteteVentes.getFacDate().getMinutes();
            }

            if (this.factureEnteteVentes.getFacDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.factureEnteteVentes.getFacDate().getSeconds();
            } else {
               this.var_seconde = "" + this.factureEnteteVentes.getFacDate().getSeconds();
            }

            this.tiers = this.factureEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
            this.numeroPfManuel = this.factureEnteteVentes.getFacAnal4();
            this.var_nom_contact = this.factureEnteteVentes.getFacIdContact();
            this.var_nom_responsable = this.factureEnteteVentes.getFacIdResponsable();
            this.var_nom_commercial = this.factureEnteteVentes.getFacIdCommercial();
            this.calculDevise();
            this.chargerDocumentLigne(var6);
            this.calculMessageLitige(var6);
            double var4 = 0.0D;
            if (this.optionsVentes.getPaiementAVOIR().equals("0")) {
               var4 = this.chargerBonEncaissement(var6);
            }

            this.chargerDocumentTrace(var6);
            this.chargerLesContactsItem(var6);
            this.chargerUserChrono(var6);
            this.chargerLesUsers(var6);
            this.chargerParapheur(var6);
            this.chargerLesParcs(var6);
            this.chargerModeEcheanceAffichage();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            if (this.typeVente == 804) {
               this.chargerServiceInterim(var6);
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
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.factureEnteteVentes.getFacTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }

            this.utilInitHibernate.closeSession();
            if (this.optionsVentes.getPaiementAVOIR().equals("0")) {
               if (this.factureEnteteVentes.getFacTotReglement() != var4) {
                  if (this.structureLog.getStrid() != 42L && this.structureLog.getStrid() != 43L && this.structureLog.getStrid() != 44L && this.structureLog.getStrid() != 45L) {
                     this.factureEnteteVentes.setFacTotReglement(var4);
                     if (Math.abs(var4) >= Math.abs(this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc())) {
                        this.factureEnteteVentes.setFacSolde(1);
                     } else {
                        this.factureEnteteVentes.setFacSolde(0);
                     }

                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
                  } else if (this.factureEnteteVentes.getFacSolde() == 0) {
                     this.factureEnteteVentes.setFacTotReglement(var4);
                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
                  }
               } else {
                  if (Math.abs(var4) >= Math.abs(this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc())) {
                     this.factureEnteteVentes.setFacSolde(1);
                  } else {
                     this.factureEnteteVentes.setFacSolde(0);
                  }

                  this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
               }
            }

            this.setMontantTtcElmt(this.factureEnteteVentes.getFacTotTtc());
            this.setMontantReglementElmt(this.factureEnteteVentes.getFacTotReglement());
            this.setMontantElmTotBonEnc(this.factureEnteteVentes.getFacTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.factureEnteteVentes.getFacTotTtc() - this.factureEnteteVentes.getFacTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.factureEnteteVentes != null) {
         if (this.factureEnteteVentes.getFacEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.factureEnteteVentes.getFacDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.factureEnteteVentes.getFacDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.factureEnteteVentes.getFacId() > 0L) {
         this.lesLignesList = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.factureEnteteVentes != null && this.factureEnteteVentes.getFacEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.factureEnteteVentes.getFacAnal4(), this.factureEnteteVentes.getFacAnal4()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureEnteteVentes.getFacId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.lstReg.clear();
      this.lstReg = this.reglementsDao.reglementDocument(this.factureEnteteVentes.getFacId(), this.nature, var1);
      double var7 = 0.0D;
      this.afficheRecu = false;
      if (this.lstReg.size() != 0) {
         this.afficheRecu = true;
         new Reglements();

         for(int var6 = 0; var6 < this.lstReg.size(); ++var6) {
            Reglements var5 = (Reglements)this.lstReg.get(var6);
            if (var5.getRglDepotTiers() != 2) {
               this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + var5.getRglRecette() - var5.getRglDepense();
               var7 += ((Reglements)this.lstReg.get(var6)).getRglRecette();
            }
         }
      }

      this.datamodelRecu.setWrappedData(this.lstReg);
      if (this.factureEnteteVentes.getFacEtat() == 8) {
         this.var_affiche_be = false;
         this.var_affiche_dollar = false;
      } else if (Math.abs(this.var_tot_bon_encaissement) < Math.abs(this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc())) {
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

      return var7;
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      new ArrayList();
      ArrayList var4 = new ArrayList();
      new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      ArrayList var8 = new ArrayList();
      new ArrayList();
      new ArrayList();
      ArrayList var11 = new ArrayList();
      ArrayList var12 = new ArrayList();
      new ArrayList();
      ArrayList var14 = new ArrayList();
      if (this.factureEnteteVentes.getFacId() > 0L) {
         List var10 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.factureEnteteVentes.getFacId(), this.nature, var1);
         if (var10.size() == 0 || this.optionsVentes.getModeAvoir().equals("1")) {
            var10 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(this.factureEnteteVentes.getFacId(), this.nature, var1);
            if (var10.size() == 0) {
               var10 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.factureEnteteVentes.getFacId(), this.nature, var1);
            }
         }

         int var15;
         int var16;
         for(var15 = 0; var15 < var10.size(); ++var15) {
            List var7 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var10.get(var15)).getDoctraOrgId(), ((DocumentTraceVentes)var10.get(var15)).getDoctraOrgType(), var1);
            if (var7.size() != 0) {
               for(var16 = 0; var16 < var7.size(); ++var16) {
                  var6.add(var7.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var6.size(); ++var15) {
            List var5 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var6.get(var15)).getDoctraOrgId(), ((DocumentTraceVentes)var6.get(var15)).getDoctraOrgType(), var1);
            if (var5.size() != 0) {
               for(var16 = 0; var16 < var5.size(); ++var16) {
                  var4.add(var5.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var4.size(); ++var15) {
            List var3 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var4.get(var15)).getDoctraOrgId(), ((DocumentTraceVentes)var4.get(var15)).getDoctraOrgType(), var1);
            if (var3.size() != 0) {
               for(var16 = 0; var16 < var3.size(); ++var16) {
                  var2.add(var3.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var10.size(); ++var15) {
            List var13 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var10.get(var15)).getDoctraOrgId(), 26, var1);
            if (var13.size() != 0) {
               for(var16 = 0; var16 < var13.size(); ++var16) {
                  var12.add(var13.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var6.size(); ++var15) {
            List var9 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var6.get(var15)).getDoctraOrgId(), 24, var1);
            if (var9.size() != 0) {
               for(var16 = 0; var16 < var9.size(); ++var16) {
                  var8.add(var9.get(var16));
               }
            }
         }

         long var18 = (long)(this.factureEnteteVentes.getFacDate().getYear() + 1900 - 2);

         int var17;
         for(var17 = 0; var17 < var2.size(); ++var17) {
            if (((DocumentTraceVentes)var2.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var2.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var2.get(var17));
            }
         }

         for(var17 = 0; var17 < var4.size(); ++var17) {
            if (((DocumentTraceVentes)var4.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var4.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var4.get(var17));
            }
         }

         for(var17 = 0; var17 < var6.size(); ++var17) {
            if (((DocumentTraceVentes)var6.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var6.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var6.get(var17));
            }
         }

         for(var17 = 0; var17 < var8.size(); ++var17) {
            if (((DocumentTraceVentes)var8.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var8.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var8.get(var17));
            }
         }

         for(var17 = 0; var17 < var10.size(); ++var17) {
            if (((DocumentTraceVentes)var10.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var10.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var10.get(var17));
            }
         }

         for(var17 = 0; var17 < var11.size(); ++var17) {
            if (((DocumentTraceVentes)var11.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var11.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var11.get(var17));
            }
         }

         for(var17 = 0; var17 < var12.size(); ++var17) {
            if (((DocumentTraceVentes)var12.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var12.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var12.get(var17));
            }
         }
      }

      this.datamodelDocumentTrace.setWrappedData(var14);
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
      if (this.factureEnteteVentes != null && this.factureEnteteVentes.getFacSerie() != null && !this.factureEnteteVentes.getFacSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.factureEnteteVentes.getFacSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.factureEnteteVentes.getFacId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.factureEnteteVentes.getFacId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.factureEnteteVentes.getFacDateTransfert() != null) {
            this.factureEnteteVentes.setFacDateTransfert((Date)null);
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
         }
      }

   }

   public void chargerServiceInterim(Session var1) throws HibernateException, NamingException {
      this.mesServicesInterimItems.clear();
      if (this.tiers != null) {
         new ArrayList();
         SiteDao var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
         List var2 = var3.chargerLesSitesListByClient(this.tiers.getTieid(), var1);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               this.mesServicesInterimItems.add(new SelectItem(((Site)var2.get(var4)).getSitCode() + ":" + ((Site)var2.get(var4)).getSitNomFr()));
            }
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.factureEnteteVentes.getFacActivite() != null && !this.factureEnteteVentes.getFacActivite().isEmpty() && this.factureEnteteVentes.getFacActivite().contains(":")) {
         String[] var1 = null;
         if (!this.factureEnteteVentes.getFacActivite().contains("#")) {
            var1 = this.factureEnteteVentes.getFacActivite().split(":");
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
            String[] var2 = this.factureEnteteVentes.getFacActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.factureEnteteVentes.getFacTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.factureEnteteVentes.getFacTotHt() - this.totalImputation;
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
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.factureLigneVentes = new FactureLigneVentes();
      this.factureEnteteVentes.setUsers(this.usersLog);
      this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
      this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.factureEnteteVentes.setFacDate(new Date());
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
      this.factureEnteteVentes.setFacDateLivraison((Date)null);
      this.factureEnteteVentes.setFacBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.factureEnteteVentes.setFacIdCommercial(this.usersLog.getUsrid());
         this.factureEnteteVentes.setFacNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.factureEnteteVentes.setFacIdResponsable(this.usersLog.getUsrid());
         this.factureEnteteVentes.setFacNomResponsable(this.usersLog.getUsrPatronyme());
      }

      if (this.var_sansstock) {
         this.factureEnteteVentes.setFacStock(1);
      } else {
         this.factureEnteteVentes.setFacStock(0);
      }

      this.mesAffairesItems.clear();
      this.mesServicesInterimItems.clear();
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
      if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
      } else {
         var4 = 0;
      }

      this.factureEnteteVentes.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.factureEnteteVentes.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
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
            this.mesUsersItem.add(new SelectItem(this.factureEnteteVentes.getFacIdResponsable(), this.factureEnteteVentes.getFacNomResponsable()));
         }

         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
         this.addLigne();
         this.cumulPrix();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.factureEnteteVentes.getFacIdResponsable(), this.factureEnteteVentes.getFacNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteVentes.getFacEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.factureEnteteVentes.setFacEtat(1);
               this.factureEnteteVentes.setFacDateValide(new Date());
               this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
               if (this.factureEnteteVentes.getFacStock() == 1) {
                  this.calculStock.majFactureVentesVAL(this.lesLignesList, 1, this.baseLog, var1);
               }

               if (this.optionsVentes.getDecrmtRabais().equals("3") && !this.factureEnteteVentes.isFacRistourneBloquee()) {
                  new ExercicesCaisse();
                  ExercicesCaisseDao var4 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
                  ExercicesCaisse var3 = var4.recupererLastExo(var1);
                  if (var3 != null) {
                     double var5 = 0.0D;

                     for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                        this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var7);
                        if (this.factureLigneVentes.getFacligRabais() != 0.0D) {
                           var5 += this.utilNombre.myRoundDevise((this.factureLigneVentes.getFacligPt() + this.factureLigneVentes.getFacligTva()) * this.factureLigneVentes.getFacligRabais() / 100.0D, this.factureEnteteVentes.getFacDevise());
                        }
                     }

                     if (var5 != 0.0D) {
                        String var19 = this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), 61, this.factureEnteteVentes.getFacSerie(), var1);
                        this.reglements = new Reglements();
                        this.reglements.setRglDateReg(this.factureEnteteVentes.getFacDate());
                        this.reglements.setRglOperation("14");
                        this.reglements.setRglActivite(this.factureEnteteVentes.getFacActivite());
                        this.reglements.setRglBanqueTireur("");
                        this.reglements.setRglBudget(this.factureEnteteVentes.getFacBudget());
                        this.reglements.setRglBon("");
                        this.reglements.setRglCategorie(20);
                        this.reglements.setRglCodeCaiss("");
                        this.reglements.setRglLibCaiss("");
                        this.reglements.setRglCodeEmetrice("");
                        this.reglements.setRglCodeReceptrice("");
                        this.reglements.setRglDateCreation(new Date());
                        this.reglements.setRglDateImp((Date)null);
                        this.reglements.setRglDateTransfert((Date)null);
                        this.reglements.setRglDateValeur((Date)null);
                        this.reglements.setRglDepartement(this.factureEnteteVentes.getFacDepartement());
                        this.reglements.setRglDepense(0.0D);
                        this.reglements.setRglDevise(this.factureEnteteVentes.getFacDevise());
                        this.reglements.setRglDossier("");
                        this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                        this.reglements.setRglDocument(this.factureEnteteVentes.getFacNum());
                        this.reglements.setRglIdCaissier(0L);
                        this.reglements.setRglIdBon(0L);
                        this.reglements.setRglIdDocument(this.factureEnteteVentes.getFacId());
                        this.reglements.setRglIdTiers(this.factureEnteteVentes.getTiers().getTieid());
                        this.reglements.setRglDepotTiers(2);
                        this.reglements.setRglLibEmetrice("");
                        this.reglements.setRglLibReceptrice("");
                        this.reglements.setRglLibelle("(ristourne) " + this.factureEnteteVentes.getFacObject());
                        this.reglements.setRglMode("");
                        this.reglements.setRglModele("");
                        this.reglements.setRglNumChqBdx("");
                        this.reglements.setRglNatureDoc(25);
                        this.reglements.setRglNomCaissier("");
                        this.reglements.setRglNomTiers(this.factureEnteteVentes.getFacNomTiers());
                        this.reglements.setRglNum(var19);
                        this.reglements.setRglObjet("(ristourne) " + this.factureEnteteVentes.getFacObject());
                        this.reglements.setRglParc("");
                        this.reglements.setRglPdv(this.factureEnteteVentes.getFacPdv());
                        this.reglements.setRglRecette(var5);
                        this.reglements.setRglTimbre(0.0D);
                        this.reglements.setRglRegion(this.factureEnteteVentes.getFacRegion());
                        this.reglements.setRglSecteur(this.factureEnteteVentes.getFacSecteur());
                        this.reglements.setRglSerie(this.factureEnteteVentes.getFacSerie());
                        this.reglements.setRglService(this.factureEnteteVentes.getFacService());
                        this.reglements.setRglSite(this.factureEnteteVentes.getFacSite());
                        this.reglements.setRglTrf(0);
                        this.reglements.setRglTypeReg(0);
                        this.reglements.setRglTypeTiers(0);
                        this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                        this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                        this.reglements.setRglUserModif(0L);
                        this.reglements.setRglIdResponsable(0L);
                        this.reglements.setRglNomResponsable("");
                        this.reglements.setRglIdCommercial(0L);
                        this.reglements.setRglNomCommercial("");
                        this.reglements.setRglIdEquipe(0L);
                        this.reglements.setRglNomEquipe("");
                        String var8 = "";
                        if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                           var8 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                        } else {
                           var8 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                        }

                        String var9 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                        this.reglements.setRglPeriode(var8 + ":" + var9);
                        this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                        String var10 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                        this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var10);
                        this.reglements.setExercicesCaisse(var3);
                        this.reglementsDao.insert(this.reglements, var1);
                        if (this.tiers != null) {
                           double var11 = this.tiers.getTiedepotavance() + var5;
                           this.tiers.setTiedepotavance(var11);
                           this.tiersDao.modif(this.tiers, var1);
                        }
                     }
                  }
               }

               Espion var18 = new Espion();
               var18.setUsers(this.usersLog);
               var18.setEsptype(0);
               var18.setEspdtecreat(new Date());
               var18.setEspaction("Validation manuelle facture (C.) N° " + this.factureEnteteVentes.getFacNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteVentes.getFacDate()));
               this.espionDao.mAJEspion(var18, var1);
            }

            if (this.tiers.getTieDteDocument5() == null || this.factureEnteteVentes.getFacDate().after(this.tiers.getTieDteDocument5())) {
               this.tiers.setTieDteDocument5(this.factureEnteteVentes.getFacDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
            }

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

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteVentes.getFacEtat() == 1) {
               this.factureEnteteVentes.setFacEtat(0);
               this.factureEnteteVentes.setFacDateValide((Date)null);
               this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
               if (this.factureEnteteVentes.getFacStock() == 1) {
                  this.calculStock.majFactureVentesVAL(this.lesLignesList, 0, this.baseLog, var1);
               }

               new ArrayList();
               List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureEnteteVentes.getFacId(), this.nature, var1);
               if (var3.size() != 0) {
                  for(int var4 = 0; var4 < var3.size(); ++var4) {
                     this.bonEncaissementVente = (BonEncaissementVente)var3.get(var4);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
                  }
               }

               this.var_tot_bon_encaissement = 0.0D;
               if (this.optionsVentes.getDecrmtRabais().equals("3")) {
                  double var13 = 0.0D;
                  this.reglements = this.reglementsDao.pourParapheurByNumNatRistourne(this.factureEnteteVentes.getFacId(), this.nature, var1);
                  if (this.reglements != null) {
                     var13 = this.reglements.getRglRecette();
                     this.reglementsDao.delete(this.reglements, var1);
                     if (this.tiers != null) {
                        double var6 = this.tiers.getTiedepotavance() - var13;
                        this.tiers.setTiedepotavance(var6);
                        this.tiersDao.modif(this.tiers, var1);
                     }
                  }
               }

               Espion var14 = new Espion();
               var14.setUsers(this.usersLog);
               var14.setEsptype(0);
               var14.setEspdtecreat(new Date());
               var14.setEspaction("Dévalidation manuelle facture (C.) N° " + this.factureEnteteVentes.getFacNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteVentes.getFacDate()));
               this.espionDao.mAJEspion(var14, var1);
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
      }

   }

   public void valideTout() throws HibernateException, NamingException {
      if (this.lesEntetesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               for(int var3 = 0; var3 < this.lesEntetesList.size(); ++var3) {
                  this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var3);
                  if (this.factureEnteteVentes.getFacEtat() == 0) {
                     this.factureEnteteVentes.setFacEtat(1);
                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
                     Espion var4 = new Espion();
                     var4.setUsers(this.usersLog);
                     var4.setEsptype(0);
                     var4.setEspdtecreat(new Date());
                     var4.setEspaction("Validation manuelle facture (C.) N° " + this.factureEnteteVentes.getFacNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteVentes.getFacDate()));
                     this.espionDao.mAJEspion(var4, var1);
                  }
               }

               this.datamodelEntete.setWrappedData(this.lesEntetesList);
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

      this.visibiliteBton = false;
   }

   public void deValideTout() throws HibernateException, NamingException {
      if (this.lesEntetesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.habilitation == null) {
               for(int var3 = 0; var3 < this.lesEntetesList.size(); ++var3) {
                  this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var3);
                  if (this.factureEnteteVentes.getFacEtat() == 1 && this.factureEnteteVentes.getFacTotReglement() == 0.0D) {
                     this.factureEnteteVentes.setFacEtat(0);
                     this.factureEnteteVentes.setFacDateImp((Date)null);
                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
                     Espion var4 = new Espion();
                     var4.setUsers(this.usersLog);
                     var4.setEsptype(0);
                     var4.setEspdtecreat(new Date());
                     var4.setEspaction("Dévalidation manuelle facture (C.) N° " + this.factureEnteteVentes.getFacNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteVentes.getFacDate()));
                     this.espionDao.mAJEspion(var4, var1);
                  }
               }

               this.datamodelEntete.setWrappedData(this.lesEntetesList);
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

      this.visibiliteBton = false;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         this.factureEnteteVentes.setFacEtat(0);
         this.factureEnteteVentes.setFacDateAnnule((Date)null);
         this.factureEnteteVentes.setFacMotifAnnule("");
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException, ParseException, IOException {
      boolean var1 = false;
      if (this.factureEnteteVentes != null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            String var4 = this.factureEnteteVentes.getFacNum();
            Date var5 = this.factureEnteteVentes.getFacDate();
            String var6 = this.factureEnteteVentes.getFacInfo2();
            this.lesEntetesList.remove(this.factureEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            if (this.typeVente == 810 && this.factureEnteteVentes.getFacContrat() != null && !this.factureEnteteVentes.getFacContrat().isEmpty()) {
               new ContratEnteteVentes();
               ContratEnteteVentesDao var8 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               ContratEnteteVentes var7 = var8.pourParapheur(this.factureEnteteVentes.getFacContrat(), var2);
               if (var7 != null) {
                  var7.setCrtInfo3(var6);
                  var8.modif(var7, var2);
               }
            }

            var1 = this.supprimerDocument(this.factureEnteteVentes, var2);
            Espion var14 = new Espion();
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            var14.setEspaction("Suppression Facture N° " + var4 + " du " + var5);
            this.espionDao.mAJEspion(var14, var2);
            var3.commit();
         } catch (HibernateException var12) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (var1) {
         this.executerRequete();
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public boolean supprimerDocument(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      long var3 = var1.getFacId();
      boolean var5 = false;
      this.factureLigneVentesDao.deleteAllLigne(var1, var2);
      this.utilParapheur.supprimerParapheur(var1.getFacId(), this.nature, var2);
      this.factureEnteteVentesDao.delete(var1, var2);
      new ArrayList();
      this.documentTraceVentes = new DocumentTraceVentes();
      List var6 = this.documentTraceVentesDao.chercherDestinationTraceListe(var3, this.nature, var2);
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.documentTraceVentes = (DocumentTraceVentes)var6.get(var7);
            if (this.documentTraceVentes != null && this.documentTraceVentes.getDoctraDstType() == 25) {
               long var8 = this.documentTraceVentes.getDoctraOrgId();
               int var10 = this.documentTraceVentes.getDoctraOrgType();
               this.documentTraceVentesDao.delete(this.documentTraceVentes, var2);
               boolean var11 = false;
               byte var15;
               if (this.documentTraceVentes.getDoctraDstType() == this.documentTraceVentes.getDoctraOrgType()) {
                  var15 = 1;
                  var5 = true;
               } else {
                  this.documentTraceVentes = this.documentTraceVentesDao.chercherOrigineTrace(var8, var10, var2);
                  if (this.documentTraceVentes != null) {
                     var15 = 4;
                  } else {
                     var15 = 1;
                  }
               }

               if (var10 == 21) {
                  new DevisEnteteVentes();
                  DevisEnteteVentesDao var19 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  DevisEnteteVentes var17 = var19.pourParapheur(var8, var2);
                  if (var17 != null) {
                     var17.setDvsEtat(var15);
                     if (var15 == 1) {
                        var17.setDvsDateTransforme((Date)null);
                        var17.setDvsTypeTransforme(0);
                     }

                     var19.modif(var17, var2);
                  }
               } else if (var10 == 22) {
                  new CommandeEnteteVentes();
                  CommandeEnteteVentesDao var18 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  CommandeEnteteVentes var16 = var18.pourParapheur(var8, var2);
                  if (var16 != null) {
                     var16.setBcmEtat(var15);
                     if (var15 == 1) {
                        var16.setBcmDateTransforme((Date)null);
                        var16.setBcmTypeTransforme(0);
                     }

                     var18.modif(var16, var2);
                  }
               } else if (var10 == 23) {
                  new LivraisonEnteteVentes();
                  LivraisonEnteteVentesDao var13 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  LivraisonEnteteVentes var12 = var13.pourParapheur(var8, var2);
                  if (var12 != null) {
                     if (var15 == 1 || var15 == 4) {
                        var12.setBlvEtat(1);
                        var12.setBlvDateTransforme((Date)null);
                        var12.setBlvTypeTransforme(0);
                        var12.setBlvNumFacture("");
                     }

                     var13.modif(var12, var2);
                  }
               } else if (var10 == 25) {
                  this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var8, var2);
                  if (this.factureEnteteVentes != null) {
                     if (var15 == 1 || var15 == 4) {
                        this.factureEnteteVentes.setFacEtat(1);
                        this.factureEnteteVentes.setFacDateTransforme((Date)null);
                        this.factureEnteteVentes.setFacTypeTransforme(0);
                     }

                     this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var2);
                  }
               }
            }
         }
      }

      if (this.optionsVentes.getAxeDossier().equals("2") && var1.getFacAnal4() != null && !var1.getFacAnal4().isEmpty()) {
         PlansAnalytiquesDao var14 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.plansAnalytiques = var14.rechercheAffaire(var1.getFacAnal4(), var2);
         if (this.plansAnalytiques != null) {
            this.plansAnalytiques.setAnaAffaireDateFacture((Date)null);
            this.plansAnalytiques = var14.modif(this.plansAnalytiques, var2);
         }
      }

      return var5;
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.factureEnteteVentes.getFacId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            float var3 = 0.0F;
            String var4 = "";
            if (this.factureEnteteVentes.getFacTauxAcompte() != 0.0F && this.factureEnteteVentes.getFacNumAcompte() != null && !this.factureEnteteVentes.getFacNumAcompte().isEmpty()) {
               var3 = 100.0F;
               new ArrayList();
               String var6 = "Fac_num_acompte = '" + this.factureEnteteVentes.getFacNumAcompte() + "'";
               List var5 = this.factureEnteteVentesDao.rechercheFactureRequete(var6, var1);
               if (var5.size() != 0) {
                  new FactureEnteteVentes();

                  for(int var8 = 0; var8 < var5.size(); ++var8) {
                     FactureEnteteVentes var7 = (FactureEnteteVentes)var5.get(var8);
                     var4 = var7.getFacNumAcompte();
                     var3 -= var7.getFacTauxAcompte();
                  }

                  if (var3 < 0.0F) {
                     var3 = 0.0F;
                  }
               }
            }

            FactureEnteteVentes var15 = new FactureEnteteVentes();
            var15.setUsers(this.usersLog);
            var15.setFacIdCreateur(this.usersLog.getUsrid());
            var15.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            var15.setFacDate(new Date());
            var15.setFacDateCreat(new Date());
            var15.setFacNum("");
            if (this.var_sansstock) {
               var15.setFacStock(1);
            } else {
               var15.setFacStock(0);
            }

            var15.setFacStock(0);
            var15.setFacIdResponsable(this.usersLog.getUsrid());
            var15.setFacNomResponsable(this.usersLog.getUsrPatronyme());
            this.var_date = new Date();
            boolean var16 = false;
            int var17;
            if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
               var17 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
            } else {
               var17 = 0;
            }

            boolean var18 = false;
            int var19;
            if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
               var19 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
            } else {
               var19 = 0;
            }

            var15.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var17));
            var15.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var19));
            var15.setFacDateLivraison((Date)null);
            var15.setFacSerie(this.factureEnteteVentes.getFacSerie());
            if (!var15.getFacSerie().equalsIgnoreCase("X") && !var15.getFacSerie().isEmpty()) {
               var15.setFacNum(this.calculChrono.numCompose(var15.getFacDate(), this.nature, var15.getFacSerie(), var1));
            } else {
               long var20 = this.factureEnteteVentesDao.selectLastNum(var1);
               var15.setFacNum("" + var20);
            }

            this.verifieExistenceHabilitation(var1);
            var15.setFacTauxAcompte(var3);
            var15.setFacNumAcompte(var4);
            this.factureEnteteVentes = this.factureEnteteVentesDao.duppliquer(var15, this.factureEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               this.factureLigneVentesDao.duppliquerLigne(this.lesLignesList, this.factureEnteteVentes, var3, this.factureEnteteVentes.getFacDevise(), var1);
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

         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureEnteteVentes.getFacId(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacDate(), this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), this.factureEnteteVentes.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.factureEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         if (this.factureEnteteVentes.getFacTauxAcompte() != 0.0F && this.factureEnteteVentes.getFacNumAcompte() != null && !this.factureEnteteVentes.getFacNumAcompte().isEmpty()) {
            this.chargerDocumentLigne((Session)null);
            this.calculeAcompteGlobal();
         }

         this.lesEntetesList.add(this.factureEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         this.annule();
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.factureEnteteVentes.getFacTypeTransforme() != 0) {
            var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.factureEnteteVentes.getFacTypeTransforme(), var1);
            if (var3) {
               String var4 = "";
               if (this.factureEnteteVentes.getFacTypeTransforme() == 22) {
                  var4 = "Bon de commande";
               } else if (this.factureEnteteVentes.getFacTypeTransforme() == 23) {
                  var4 = "Bon de livraison";
               } else if (this.factureEnteteVentes.getFacTypeTransforme() == 24) {
                  var4 = "Bon retour";
               } else if (this.factureEnteteVentes.getFacTypeTransforme() == 25 && this.optionsVentes.getModeAvoir().equals("0")) {
                  var4 = "Facture";
               } else if (this.factureEnteteVentes.getFacTypeTransforme() == 25 && this.optionsVentes.getModeAvoir().equals("1") && this.factureEnteteVentes.getFacTotTtc() < 0.0D) {
                  var4 = "Avoir";
               } else if (this.factureEnteteVentes.getFacTypeTransforme() == 26 && this.optionsVentes.getModeAvoir().equals("0")) {
                  var4 = "Avoir";
               } else if (this.factureEnteteVentes.getFacTypeTransforme() == 27) {
                  var4 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.factureEnteteVentes.getFacTypeTransforme(), var4));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 26, var1);
            if (var2) {
               if (this.optionsVentes.getModeAvoir().equals("1")) {
                  this.documentTrfItems.add(new SelectItem(25, "Avoir"));
               } else {
                  this.documentTrfItems.add(new SelectItem(26, "Avoir"));
               }
            }
         }

         new FactureEnteteVentes();

         for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
            FactureEnteteVentes var8 = (FactureEnteteVentes)this.lesEntetesList.get(var5);
            if (var8.getFacId() > 0L && var8.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.factureLigneVentesDao.chargerLesLignes(var8, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new FactureLigneVentes();
                     FactureLigneVentes var7 = (FactureLigneVentes)this.lesLignesList.get(var6);
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
      if (this.factureEnteteVentes.getFacTypeReg() != 0 && this.factureEnteteVentes.getFacTypeReg() != 3) {
         if (this.factureEnteteVentes.getFacTypeReg() != 1 && this.factureEnteteVentes.getFacTypeReg() != 2 && this.factureEnteteVentes.getFacTypeReg() != 10) {
            if (this.factureEnteteVentes.getFacTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.factureEnteteVentes.getFacModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.factureEnteteVentes.getFacModeReg() != null && !this.factureEnteteVentes.getFacModeReg().isEmpty() && this.factureEnteteVentes.getFacModeReg().contains(":")) {
         String[] var2 = this.factureEnteteVentes.getFacModeReg().split(":");
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

            this.factureEnteteVentes.setFacTypeReg(Integer.parseInt(var3.getEcheances()));
            this.factureEnteteVentes.setFacModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.factureEnteteVentes.setFacNbJourReg(0);
            this.factureEnteteVentes.setFacArrondiReg(0);
            break;
         }
      }

      if (this.factureEnteteVentes.getFacTypeReg() != 0 && this.factureEnteteVentes.getFacTypeReg() != 3) {
         if (this.factureEnteteVentes.getFacTypeReg() != 1 && this.factureEnteteVentes.getFacTypeReg() != 2 && this.factureEnteteVentes.getFacTypeReg() != 10) {
            if (this.factureEnteteVentes.getFacTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.factureEnteteVentes.setFacTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.factureEnteteVentes.setFacModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.factureEnteteVentes.setFacNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.factureEnteteVentes.setFacArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.factureEnteteVentes.getFacModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.factureEnteteVentes.getFacDate(), this.factureEnteteVentes.getFacTypeReg(), this.factureEnteteVentes.getFacNbJourReg(), this.factureEnteteVentes.getFacArrondiReg());
      this.factureEnteteVentes.setFacDateEcheReg(var1);
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
         if (this.factureEnteteVentes.getFacId() != 0L) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.factureEnteteVentes.setFacDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.factureEnteteVentes.getUsers() == null) {
            this.factureEnteteVentes.setUsers(this.usersLog);
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

         this.factureEnteteVentes.setTiers(this.tiers);
         if ((this.factureEnteteVentes.getFacCat() == null || this.factureEnteteVentes.getFacCat().isEmpty()) && this.factureEnteteVentes.getTiers().getTienomfamille() != null && !this.factureEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.factureEnteteVentes.setFacCat(this.factureEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.factureEnteteVentes.setFacCivilTiers("");
         } else {
            this.factureEnteteVentes.setFacCivilTiers(this.factureEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.factureEnteteVentes.getFacDiversTiers() == 99) {
               this.factureEnteteVentes.setFacIdContact(0L);
               this.factureEnteteVentes.setFacNomContact("");
               this.factureEnteteVentes.setFacCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.factureEnteteVentes.setFacIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.factureEnteteVentes.setFacNomContact(var3.getConpatronyme());
                     this.factureEnteteVentes.setFacCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.factureEnteteVentes.setFacNomContact(var3.getConservice());
                     this.factureEnteteVentes.setFacCivilContact("SERVICE/SITE:");
                  } else {
                     this.factureEnteteVentes.setFacIdContact(0L);
                     this.factureEnteteVentes.setFacNomContact("");
                     this.factureEnteteVentes.setFacCivilContact("");
                  }
               } else {
                  this.factureEnteteVentes.setFacIdContact(0L);
                  this.factureEnteteVentes.setFacNomContact("");
                  this.factureEnteteVentes.setFacCivilContact("");
               }
            }

            this.factureEnteteVentes.setFacTiersRegroupe(this.tiers.getTiesigle());
         }

         this.factureEnteteVentes.setFacIdResponsable(0L);
         this.factureEnteteVentes.setFacNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.factureEnteteVentes.setFacIdResponsable(var15.getUsrid());
            this.factureEnteteVentes.setFacNomResponsable(var15.getUsrPatronyme());
         }

         this.factureEnteteVentes.setFacIdCommercial(0L);
         this.factureEnteteVentes.setFacNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.factureEnteteVentes.setFacIdCommercial(var4.getUsrid());
               this.factureEnteteVentes.setFacNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.factureEnteteVentes.setFacIdEquipe(0L);
         this.factureEnteteVentes.setFacNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.factureEnteteVentes.getFacIdResponsable(), var1);
            if (this.equipes != null) {
               this.factureEnteteVentes.setFacIdEquipe(this.equipes.getEquId());
               this.factureEnteteVentes.setFacNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), var16, this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacDate());
            this.val_timbre = this.utilNombre.myRoundDevise(var5, this.factureEnteteVentes.getFacDevise());
            if (this.val_timbre != 0.0D) {
               String var7 = this.utilNombre.beginSimple(this.val_timbre, this.factureEnteteVentes.getFacDevise());
               this.factureEnteteVentes.setFacFormule2(this.utilNombre.texteTimbre(this.structureLog, var7, var16, this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacDate()));
            }
         }

         if (this.accesAffaires) {
         }

         if (this.factureEnteteVentes.getFacTauxAcompte() != 0.0F) {
            if (this.factureEnteteVentes.getFacNumAcompte() == null || this.factureEnteteVentes.getFacNumAcompte().isEmpty()) {
               this.factureEnteteVentes.setFacNumAcompte(this.factureEnteteVentes.getFacNum());
            }
         } else {
            this.factureEnteteVentes.setFacNumAcompte("");
         }

         if (this.factureEnteteVentes.getFacNum() == null || this.factureEnteteVentes.getFacNum().isEmpty()) {
            if (this.factureEnteteVentes.getFacSerie() != null && !this.factureEnteteVentes.getFacSerie().equalsIgnoreCase("X") && !this.factureEnteteVentes.getFacSerie().isEmpty()) {
               this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var1));
               boolean var18 = false;

               label483:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label483;
                     }

                     new FactureEnteteVentes();
                     FactureEnteteVentes var19 = this.factureEnteteVentesDao.pourParapheur(this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.factureEnteteVentesDao.selectLastNum(var1);
               this.factureEnteteVentes.setFacNum("" + var17);
            }
         }

         if (this.factureEnteteVentes.getFacId() == 0L) {
            this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.factureEnteteVentes.setFacDateCreat(new Date());
            this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrPatronyme());
            this.factureEnteteVentes.setFacEtat(0);
            this.factureEnteteVentes.setFacEtatVal(0);
            this.factureEnteteVentes.setFacDateValide((Date)null);
            if (this.var_sansstock) {
               this.factureEnteteVentes.setFacStock(1);
            } else {
               this.factureEnteteVentes.setFacStock(0);
            }

            this.factureEnteteVentes = this.factureEnteteVentesDao.insert(this.factureEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.factureEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            if (this.factureEnteteVentes.getFacEtat() == 6) {
               if (this.factureEnteteVentes.getFacEtatVal() == 1) {
                  this.factureEnteteVentes.setFacEtat(0);
               } else {
                  this.factureEnteteVentes.setFacEtat(0);
               }
            }

            this.factureEnteteVentes.setFacDateModif(new Date());
            this.factureEnteteVentes.setFacIdModif(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacNomModif(this.usersLog.getUsrPatronyme());
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var16);
               this.factureLigneVentes.setFacligOrdre(var16);
               this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
            }

            if (this.factureEnteteVentes.getFacEtat() == 1 && (this.tiers.getTieDteDocument5() == null || this.factureEnteteVentes.getFacDate().after(this.tiers.getTieDteDocument5()))) {
               this.tiers.setTieDteDocument5(this.factureEnteteVentes.getFacDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
            }
         }

         if (this.accesAffaires && this.factureEnteteVentes.getFacAnal4() != null && !this.factureEnteteVentes.getFacAnal4().isEmpty()) {
            PlansAnalytiquesDao var20 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            this.plansAnalytiques = var20.rechercheAnal("10", this.factureEnteteVentes.getFacAnal4(), var1);
            if (this.plansAnalytiques != null) {
               this.plansAnalytiques.setAnaDateModif(this.factureEnteteVentes.getFacDate());
               this.plansAnalytiques = var20.modif(this.plansAnalytiques, var1);
            }
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureEnteteVentes.getFacId(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacDate(), this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), this.factureEnteteVentes.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.factureEnteteVentes.getVar_format_devise(), 0, var1);
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

   public void majVisa() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null && this.factureEnteteVentes.getFacId() != 0L) {
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      if (this.typeVente == 804) {
         this.factureEnteteVentes.setFacSite("");
         this.factureEnteteVentes.setFacDepartement("");
      } else {
         this.factureEnteteVentes.setFacSite(this.usersLog.getUsrSite());
         this.factureEnteteVentes.setFacDepartement(this.usersLog.getUsrDepartement());
         this.factureEnteteVentes.setFacService(this.usersLog.getUsrService());
      }

      if (this.contDest) {
         this.factureEnteteVentes.setFacIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.factureEnteteVentes.getFacNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.factureEnteteVentes.setFacTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.factureEnteteVentes.setFacRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.factureEnteteVentes.setFacSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.factureEnteteVentes.setFacPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.factureEnteteVentes.setFacTiersRegroupe(this.tiers.getTiesigle());
            this.factureEnteteVentes.setFacRegion(this.tiers.getTieregion());
            this.factureEnteteVentes.setFacSecteur(this.tiers.getTiesecteur());
            this.factureEnteteVentes.setFacPdv(this.tiers.getTiepdv());
         }
      } else {
         this.factureEnteteVentes.setFacTiersRegroupe(this.tiers.getTiesigle());
         this.factureEnteteVentes.setFacRegion(this.tiers.getTieregion());
         this.factureEnteteVentes.setFacSecteur(this.tiers.getTiesecteur());
         this.factureEnteteVentes.setFacPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.factureEnteteVentes.setFacActivite("");
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

               this.factureEnteteVentes.setFacActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new FactureLigneVentes();
            new Produits();
            if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
               ArrayList var6 = new ArrayList();
               ObjetTarif var7 = new ObjetTarif();
               int var8 = 0;

               label130:
               while(true) {
                  if (var8 >= this.lesLignesList.size()) {
                     var8 = 0;

                     while(true) {
                        if (var8 >= var6.size()) {
                           break label130;
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

                  FactureLigneVentes var13 = (FactureLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getFacligCode() != null && !var13.getFacligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getFacligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getFacligPt());
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
                              var7.setPrix(var13.getFacligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getFacligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.factureEnteteVentes.setFacActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.factureEnteteVentes.setFacAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.factureEnteteVentes.getFacAnal4() != null && !this.factureEnteteVentes.getFacAnal4().isEmpty()) {
         this.factureEnteteVentes.setFacAnal4(this.factureEnteteVentes.getFacAnal4().toUpperCase());
      }

      if (!this.var_anal_parc) {
         this.factureEnteteVentes.setFacAnal2("");
      } else if (this.factureEnteteVentes.getFacAnal2() != null && this.factureEnteteVentes.getFacAnal2().length() <= 2) {
         this.factureEnteteVentes.setFacAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.factureEnteteVentes.setFacEtatVal(1);
         this.factureEnteteVentes.setFacEtat(0);
         this.factureEnteteVentes.setFacDateValide((Date)null);
         return true;
      } else {
         this.factureEnteteVentes.setFacEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.factureEnteteVentes.setFacEtat(1);
               this.factureEnteteVentes.setFacDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.factureEnteteVentes.setFacEtat(0);
               this.factureEnteteVentes.setFacDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.factureEnteteVentes != null) {
         this.factureEnteteVentes.setFacDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         if (this.factureEnteteVentes.getFacDateAnnule() == null) {
            this.factureEnteteVentes.setFacDateAnnule(new Date());
         }

         this.factureEnteteVentes.setFacEtat(3);
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation facture vente N° " + this.factureEnteteVentes.getFacNum() + " le " + this.factureEnteteVentes.getFacDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.factureEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void verifNumeroManuel() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         boolean var1 = false;
         var1 = this.factureEnteteVentesDao.verifExistNum(this.factureEnteteVentes.getFacId(), this.factureEnteteVentes.getFacNum());
         if (var1) {
            this.factureEnteteVentes.setFacNum("");
         }
      }

   }

   public void calculPeriode(List var1, List var2) throws ParseException {
      int var3 = 0;
      this.lesPeriodesGeneration.clear();
      Date var4 = this.exercicesVentes.getExevteDateDebut();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      Date var6 = this.exercicesVentes.getExevteDateFin();
      GregorianCalendar var7 = new GregorianCalendar();
      var7.setTime(var6);
      var5.add(2, -1);
      var7.add(2, -1);
      String var8 = null;
      String var9 = "";

      for(String var10 = ""; var5.compareTo(var7) < 0; this.lesPeriodesGeneration.add(new SelectItem(var8, var8 + ":" + var9 + " " + var10))) {
         var5.add(2, 1);
         Date var11 = var5.getTime();
         var8 = this.formatPeriode(var11);
         ++var3;
         var9 = "";
         int var12;
         if (var1.size() != 0) {
            for(var12 = 0; var12 < var1.size(); ++var12) {
               if (var11.getYear() + 1900 == ((FactureEnteteVentes)var1.get(var12)).getFacDate().getYear() + 1900 && var11.getMonth() + 1 == ((FactureEnteteVentes)var1.get(var12)).getFacDate().getMonth() + 1) {
                  var9 = "Période Facturée";
                  break;
               }
            }
         }

         var10 = "";
         if (var2.size() != 0) {
            for(var12 = 0; var12 < var2.size(); ++var12) {
               if (((BulletinMois)var2.get(var12)).getBulmenPeriode().equals(var8)) {
                  if (((BulletinMois)var2.get(var12)).getBulmenEtat() == 0) {
                     var10 = "et Bulletins en cours";
                  } else if (((BulletinMois)var2.get(var12)).getBulmenEtat() == 1) {
                     var10 = "et Saisie mensuelle";
                  } else if (((BulletinMois)var2.get(var12)).getBulmenEtat() == 2) {
                     var10 = "et Génération mensuelle";
                  } else if (((BulletinMois)var2.get(var12)).getBulmenEtat() == 3) {
                     var10 = "et Bulletins cloturés";
                  } else if (((BulletinMois)var2.get(var12)).getBulmenEtat() == 4) {
                     var10 = "et Bulletins transférés";
                  }
                  break;
               }
            }
         }
      }

   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void ajoutGeneration() throws ParseException, HibernateException, NamingException {
      this.mesAffairesItems.clear();
      this.lesPeriodesGeneration = new ArrayList();
      this.var_periodeGeneration = "";
      this.tiers = new Tiers();
      this.var_idTiersGeneration = 0L;
      this.var_mode_trf = "0";
      this.var_type_trf = 0;
      this.var_ecart_reglement = 0.0D;
      this.lesClientsItems = new ArrayList();
      this.libelle1 = "";
      this.libelle2 = "";
      this.montant1 = 0.0D;
      this.montant2 = 0.0D;
      this.lesClientsItems.clear();
      new ArrayList();
      List var1 = this.tiersDao.chargerLesTiers("3", (Session)null);
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((Tiers)var1.get(var2)).getTiemodecom() != 0) {
               this.lesClientsItems.add(new SelectItem(((Tiers)var1.get(var2)).getTieid(), ((Tiers)var1.get(var2)).getTieid() + ":" + ((Tiers)var1.get(var2)).getTieraisonsocialenom()));
            }
         }
      }

      this.showModalPanelGeneration = true;
   }

   public void calculeClient() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.var_idTiersGeneration != 0L) {
         this.validatioPeriode = false;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteInterim");
         this.tiers = this.tiersDao.selectTierD(this.var_idTiersGeneration, var1);
         if (this.tiers != null) {
            this.var_idTiersGeneration = this.tiers.getTieid();
            this.modeCalcul = this.tiers.getTiemodecom();
            this.modeCommision = this.tiers.getTieDeclarationTva();
            this.tauxCommission = this.tiers.getTietauxcom();
            this.tauxCss = this.tiers.getTiecoefpvmedical();
            this.modePresentation = this.tiers.getTieAssujettissement();
            this.modeFacturation = this.tiers.getTiefacpr();
            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }

            this.chargerLesUsers(var1);
            new ArrayList();
            List var2 = this.factureEnteteVentesDao.rechercheByTiers(this.tiers, var1);
            Object var3 = new ArrayList();
            BulletinMoisDao var4 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
            new ExercicesPaye();
            ExercicesPayeDao var6 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
            ExercicesPaye var5 = var6.recupererLastExo(var1);
            if (var5 != null) {
               var3 = var4.mesFeuillesmois("" + this.tiers.getTieid(), 9, var5, var1);
            }

            this.calculPeriode(var2, (List)var3);
         } else {
            this.var_idTiersGeneration = 0L;
            this.modeCalcul = 0;
            this.modeCommision = 0;
            this.tauxCommission = 0.0F;
            this.tauxCss = 0.0F;
            this.modePresentation = 0;
            this.modeFacturation = 0;
            this.var_nom_contact = 0L;
            this.var_nom_responsable = 0L;
            this.mesUsersItem.clear();
            this.var_nom_commercial = 0L;
            this.mesCommercialItem.clear();
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void annuleGeneration() {
      this.showModalPanelGeneration = false;
   }

   public void verifierPeriode() {
      this.validatioPeriode = false;

      for(int var1 = 0; var1 < this.lesPeriodesGeneration.size(); ++var1) {
         if (((SelectItem)this.lesPeriodesGeneration.get(var1)).getValue().toString().equals(this.var_periodeGeneration)) {
            if (((SelectItem)this.lesPeriodesGeneration.get(var1)).getLabel().toString().contains("cloturés") || ((SelectItem)this.lesPeriodesGeneration.get(var1)).getLabel().toString().contains("transférés")) {
               this.validatioPeriode = true;
            }
            break;
         }
      }

   }

   public void executionGeneration() throws HibernateException, NamingException, ParseException, IOException, Exception {
      if (this.var_idTiersGeneration != 0L && this.var_periodeGeneration != null && !this.var_periodeGeneration.isEmpty()) {
         new ArrayList();
         ArrayList var2 = new ArrayList();
         new BulletinSalaire();
         BulletinSalaireDao var4 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         BulletinLigneDao var5 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         List var1 = var4.chargerlesBulletinsbyTiersPeriode(this.var_idTiersGeneration, this.var_periodeGeneration, (Session)null);
         if (var1.size() != 0) {
            new ExercicesPaye();
            ExercicesPayeDao var7 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
            ExercicesPaye var6 = var7.recupererLastExo((Session)null);
            if (var6 != null) {
               new ArrayList();
               new PlanPaye();
               PlanPayeDao var10 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
               List var8 = var10.chargerPlanPaye(var6.getExepayId(), (Session)null);
               ArrayList var11 = new ArrayList();
               new ArrayList();
               SiteDao var13 = new SiteDao(this.baseLog, this.utilInitHibernate);
               List var12 = var13.chargerLesSitesListByClient(this.var_idTiersGeneration, (Session)null);
               String var15;
               if (var12.size() == 0) {
                  var11.add("****");
               } else {
                  for(int var14 = 0; var14 < var1.size(); ++var14) {
                     var15 = ((BulletinSalaire)var1.get(var14)).getBulsalService();
                     if (var15 == null || var15.isEmpty()) {
                        var15 = "****";
                     }

                     if (var11.size() == 0) {
                        var11.add(var15);
                     } else {
                        boolean var16 = false;

                        for(int var17 = 0; var17 < var11.size(); ++var17) {
                           if (((String)var11.get(var17)).toString().equals(var15)) {
                              var16 = true;
                              break;
                           }
                        }

                        if (!var16) {
                           var11.add(var15);
                        }
                     }
                  }
               }

               Session var40 = this.utilInitHibernate.getOpenSession(this.baseLog, "Interim");
               var15 = null;

               try {
                  Transaction var41 = var40.beginTransaction();

                  for(int var42 = 0; var42 < var11.size(); ++var42) {
                     String var43 = ((String)var11.get(var42)).toString();
                     var2.clear();

                     BulletinSalaire var3;
                     for(int var18 = 0; var18 < var1.size(); ++var18) {
                        var3 = (BulletinSalaire)var1.get(var18);
                        if (var43 != null && !var43.isEmpty() && var43.equals("****")) {
                           var2.add(var3);
                        } else if (var3.getBulsalService() != null && !var3.getBulsalService().isEmpty() && var3.getBulsalService().equals(var43)) {
                           var2.add(var3);
                        } else if ((var3.getBulsalService() == null || var3.getBulsalService().isEmpty()) && var43.equals("**")) {
                           var2.add(var3);
                        }
                     }

                     boolean var44 = false;
                     if (var2.size() != 0) {
                        var44 = this.calculeEnteteFacture(var43, var12, var40);
                        if (var44) {
                           this.lesLignesList.clear();
                           new ArrayList();
                           double var20 = 0.0D;
                           double var22 = 0.0D;
                           double var24 = 0.0D;
                           double var26 = 0.0D;
                           List var19;
                           int var28;
                           double var29;
                           int var46;
                           int var47;
                           if (this.tiers.getTiemodecom() >= 10) {
                              for(var28 = 0; var28 < var2.size(); ++var28) {
                                 var3 = (BulletinSalaire)var2.get(var28);
                                 var22 = 0.0D;
                                 var24 = 0.0D;
                                 var26 = 0.0D;
                                 if (this.modeCalcul == 11) {
                                    var22 = var3.getBulsalBrut();
                                    var20 += var3.getBulsalBrut();
                                 } else if (this.modeCalcul == 12) {
                                    var19 = var5.chargerleslignesBulletin(var3, var40);
                                    if (var19.size() != 0) {
                                       for(var46 = 0; var46 < var19.size(); ++var46) {
                                          if (((BulletinLigne)var19.get(var46)).getBulligNature() == 69) {
                                             var22 += ((BulletinLigne)var19.get(var46)).getBulligValColE();
                                          }
                                       }

                                       var20 += var22;
                                    }
                                 } else if (this.modeCalcul == 13) {
                                    var22 = var3.getBulsalNetPayer();
                                    var20 += var3.getBulsalNetPayer();
                                 } else if (this.modeCalcul == 14) {
                                    var19 = var5.chargerleslignesBulletin(var3, var40);
                                    if (var19.size() != 0) {
                                       for(var46 = 0; var46 < var19.size(); ++var46) {
                                          if (((BulletinLigne)var19.get(var46)).getBulligNature() == 59) {
                                             var22 += ((BulletinLigne)var19.get(var46)).getBulligValColE();
                                          } else if (((BulletinLigne)var19.get(var46)).getBulligNature() == 90) {
                                             var24 += ((BulletinLigne)var19.get(var46)).getBulligValColE() * -1.0D;
                                          }
                                       }

                                       var20 = var20 + var22 + var24;
                                    }
                                 } else if (this.modeCalcul == 15) {
                                    var19 = var5.chargerleslignesBulletin(var3, var40);
                                    if (var19.size() != 0) {
                                       var29 = 0.0D;

                                       for(var47 = 0; var47 < var19.size(); ++var47) {
                                          if (((BulletinLigne)var19.get(var47)).getBulligNature() == 59) {
                                             var22 += ((BulletinLigne)var19.get(var47)).getBulligValColE();
                                             if (((BulletinLigne)var19.get(var47)).getSalaries().getSalNbJourCp() != 0.0F && ((BulletinLigne)var19.get(var47)).getSalaries().getSalNbJourTr() != 0.0F) {
                                                var26 += ((BulletinLigne)var19.get(var47)).getBulligValColE() * (double)((BulletinLigne)var19.get(var47)).getSalaries().getSalNbJourCp() / (double)((BulletinLigne)var19.get(var47)).getSalaries().getSalNbJourTr();
                                             }
                                          } else if (((BulletinLigne)var19.get(var47)).getBulligNature() == 90) {
                                             var24 += ((BulletinLigne)var19.get(var47)).getBulligValColE() * -1.0D;
                                          } else if (((BulletinLigne)var19.get(var47)).getBulligNature() == 40) {
                                             var29 += ((BulletinLigne)var19.get(var47)).getBulligValColE();
                                          }
                                       }

                                       if (var29 != 0.0D && var26 > var29) {
                                          var26 -= var29;
                                       }

                                       var20 = var20 + var22 + var24 + var26;
                                    }
                                 } else if (this.modeCalcul == 16) {
                                    var19 = var5.chargerleslignesBulletin(var3, var40);
                                    var29 = 0.0D;
                                    if (var19.size() != 0) {
                                       double var31 = 0.0D;

                                       for(int var33 = 0; var33 < var19.size(); ++var33) {
                                          if (((BulletinLigne)var19.get(var33)).getBulligNature() == 11) {
                                             var29 += ((BulletinLigne)var19.get(var33)).getBulligValColE();
                                          }

                                          if (((BulletinLigne)var19.get(var33)).getBulligNature() == 59) {
                                             var22 += ((BulletinLigne)var19.get(var33)).getBulligValColE();
                                             if (((BulletinLigne)var19.get(var33)).getSalaries().getSalNbJourCp() != 0.0F && ((BulletinLigne)var19.get(var33)).getSalaries().getSalNbJourTr() != 0.0F) {
                                                var26 += ((BulletinLigne)var19.get(var33)).getBulligValColE() * (double)((BulletinLigne)var19.get(var33)).getSalaries().getSalNbJourCp() / (double)((BulletinLigne)var19.get(var33)).getSalaries().getSalNbJourTr();
                                             }
                                          } else if (((BulletinLigne)var19.get(var33)).getBulligNature() == 90) {
                                             var24 += ((BulletinLigne)var19.get(var33)).getBulligValColE() * -1.0D;
                                          } else if (((BulletinLigne)var19.get(var33)).getBulligNature() == 40) {
                                             var31 += ((BulletinLigne)var19.get(var33)).getBulligValColE();
                                          }
                                       }

                                       if (var31 != 0.0D && var26 > var31) {
                                          var26 -= var31;
                                       }

                                       var20 = var20 + var22 - var29 + var24 + var26;
                                    }

                                    var22 -= var29;
                                 }

                                 this.calculLigneFactureSalarie(var40, var28, var3, var22, var24, var26);
                              }
                           } else {
                              PlanPaye var9;
                              String var45;
                              if (this.modeCalcul == 1) {
                                 var45 = "";

                                 for(var46 = 0; var46 < var2.size(); ++var46) {
                                    if (var45 != null && !var45.isEmpty()) {
                                       var45 = var45 + "," + ((BulletinSalaire)var2.get(var46)).getBulsalId();
                                    } else {
                                       var45 = "" + ((BulletinSalaire)var2.get(var46)).getBulsalId();
                                    }
                                 }

                                 var45 = "(" + var45 + ")";
                                 var19 = var5.chargerleslignesBulletinInterim(var45, var40);
                                 if (var19.size() != 0 && var8.size() != 0) {
                                    for(var46 = 0; var46 < var8.size(); ++var46) {
                                       var9 = (PlanPaye)var8.get(var46);
                                       if (var9.isPlpFacture()) {
                                          var22 = 0.0D;

                                          for(int var30 = 0; var30 < var19.size(); ++var30) {
                                             if (((BulletinLigne)var19.get(var30)).getBulligRubrique().equals(var9.getPlpCode())) {
                                                if (((BulletinLigne)var19.get(var30)).getBulligNature() != 60 && ((BulletinLigne)var19.get(var30)).getBulligNature() != 61 && ((BulletinLigne)var19.get(var30)).getBulligNature() != 62 && ((BulletinLigne)var19.get(var30)).getBulligNature() != 90) {
                                                   var22 += ((BulletinLigne)var19.get(var30)).getBulligValColE();
                                                   var20 += ((BulletinLigne)var19.get(var30)).getBulligValColE();
                                                } else {
                                                   var22 += ((BulletinLigne)var19.get(var30)).getBulligValColE() * -1.0D;
                                                   var20 += ((BulletinLigne)var19.get(var30)).getBulligValColE() * -1.0D;
                                                }
                                             }
                                          }

                                          if (var22 != 0.0D) {
                                             this.calculLigneFactureRubrique(var40, var46, var9, var22);
                                          }
                                       }
                                    }
                                 }
                              } else if (this.modeCalcul == 2) {
                                 var45 = "";

                                 for(var46 = 0; var46 < var2.size(); ++var46) {
                                    if (var45 != null && !var45.isEmpty()) {
                                       var45 = var45 + "," + ((BulletinSalaire)var2.get(var46)).getBulsalId();
                                    } else {
                                       var45 = "" + ((BulletinSalaire)var2.get(var46)).getBulsalId();
                                    }
                                 }

                                 var45 = "(" + var45 + ")";
                                 var19 = var5.chargerleslignesBulletinInterim(var45, var40);
                                 if (var19.size() != 0 && var8.size() != 0) {
                                    var29 = 0.0D;

                                    for(var47 = 0; var47 < var8.size(); ++var47) {
                                       var9 = (PlanPaye)var8.get(var47);
                                       if (var9.getPlpNature() >= 10 && var9.getPlpNature() <= 49 || var9.getPlpNature() == 70 || var9.getPlpNature() == 90) {
                                          var22 = 0.0D;

                                          for(int var32 = 0; var32 < var19.size(); ++var32) {
                                             if (((BulletinLigne)var19.get(var32)).getBulligRubrique().equals(var9.getPlpCode())) {
                                                if (((BulletinLigne)var19.get(var32)).getBulligNature() != 60 && ((BulletinLigne)var19.get(var32)).getBulligNature() != 61 && ((BulletinLigne)var19.get(var32)).getBulligNature() != 62 && ((BulletinLigne)var19.get(var32)).getBulligNature() != 90) {
                                                   var22 += ((BulletinLigne)var19.get(var32)).getBulligValColE();
                                                   var20 += ((BulletinLigne)var19.get(var32)).getBulligValColE();
                                                } else if (this.structureLog.getStrcodepays().equals("0202") && ((BulletinLigne)var19.get(var32)).getBulligRubrique().equals("900030") && this.tauxCss != 0.0F) {
                                                   double var48 = 0.0D;
                                                   if (((BulletinLigne)var19.get(var32)).getBulletinSalaire().getBulsalBrut() > 63000.0D) {
                                                      var48 = (double)(63000.0F * this.tauxCss / 100.0F * -1.0F);
                                                   } else {
                                                      var48 = ((BulletinLigne)var19.get(var32)).getBulletinSalaire().getBulsalBrut() * (double)this.tauxCss / 100.0D * -1.0D;
                                                   }

                                                   var22 += var48 * -1.0D;
                                                   var20 += var48 * -1.0D;
                                                } else {
                                                   var22 += ((BulletinLigne)var19.get(var32)).getBulligValColE() * -1.0D;
                                                   var20 += ((BulletinLigne)var19.get(var32)).getBulligValColE() * -1.0D;
                                                }
                                             }
                                          }

                                          if (var22 != 0.0D) {
                                             this.calculLigneFactureRubrique(var40, var47, var9, var22);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           this.optimisationLignes(var40);
                           var28 = var2.size();
                           this.calculLigneFactureCommission(var40, 800, var20, var28);
                           this.calculLigneLibre(var40, 900, var28);
                           this.calculeEnteteTotal(var40);
                        }
                     }

                     var40.flush();
                  }

                  var41.commit();
               } catch (HibernateException var38) {
                  if (var15 != null) {
                     var15.rollback();
                  }

                  throw var38;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.showModalPanelGeneration = false;
   }

   public boolean calculeEnteteFacture(String var1, List var2, Session var3) throws ParseException, HibernateException, NamingException, Exception {
      boolean var4 = false;
      String var5 = this.tiers.getTieid() + ":" + this.var_periodeGeneration + ":" + var1;
      this.factureEnteteVentes = this.factureEnteteVentesDao.pourContrat(var5, var3);
      if (this.factureEnteteVentes != null) {
         if (this.factureEnteteVentes.getFacDateTransfert() == null) {
            this.factureLigneVentesDao.deleteAllLigne(this.factureEnteteVentes, var3);
            var4 = true;
         } else {
            var4 = false;
         }
      } else {
         this.factureEnteteVentes = new FactureEnteteVentes();
         var4 = true;
      }

      this.factureEnteteVentes.setFacContrat(this.tiers.getTieid() + ":" + this.var_periodeGeneration + ":" + var1);
      this.factureEnteteVentes.setFacDateCreat(new Date());
      this.factureEnteteVentes.setUsers(this.usersLog);
      String[] var6 = this.var_periodeGeneration.split(":");
      String var7 = var6[1] + "-" + var6[0] + "-01";
      Date var8 = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(var7));
      this.factureEnteteVentes.setFacDate(this.utilDate.dateToSQL(var8, "00", "00", "00"));
      this.factureEnteteVentes.setFacNomTiers(this.tiers.getTieraisonsocialenom());
      this.factureEnteteVentes.setFacRegion(this.tiers.getTieregion());
      this.factureEnteteVentes.setFacSecteur(this.tiers.getTiesecteur());
      this.factureEnteteVentes.setFacPdv(this.tiers.getTiepdv());
      if (this.tiers.getTietype().equals("1") || this.tiers.getTietype().equals("2")) {
         this.tiers.setTietype("3");
         if (!this.tiers.getTiegenre().equals("010") && !this.tiers.getTiegenre().equals("020")) {
            if (this.tiers.getTiegenre().equals("011") || this.tiers.getTiegenre().equals("021")) {
               this.tiers.setTiegenre("031");
            }
         } else {
            this.tiers.setTiegenre("030");
         }

         this.tiers = this.tiersDao.modif(this.tiers, var3);
      }

      this.factureEnteteVentes.setTiers(this.tiers);
      List var9;
      if (this.factureEnteteVentes.getTiers().getTienomfamille() != null && !this.factureEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
         this.factureEnteteVentes.setFacCat(this.factureEnteteVentes.getTiers().getTienomfamille());
         this.factureEnteteVentes.setFacExoDouane(this.tiers.getTieexodouane());
         if (this.tiers.getTieexodouane() == 1) {
            this.factureEnteteVentes.setFacExoDouane(1);
         }

         this.factureEnteteVentes.setFacExoTva(this.tiers.getTieexotva());
      } else {
         new ArrayList();
         LectureFamillesClients var10 = new LectureFamillesClients();
         var10.setStrId(this.structureLog.getStrid());
         var10.setStructureLog(this.structureLog);
         var10.chargerMesFamillesClientItems();
         var9 = var10.getMesFamillesClients();
         this.factureEnteteVentes.setFacCat(((ObjetFamilleTiers)var9.get(0)).getLibelle());
         if (((ObjetFamilleTiers)var9.get(0)).getExoDouane().equals("true")) {
            this.factureEnteteVentes.setFacExoDouane(1);
         } else {
            this.factureEnteteVentes.setFacExoDouane(0);
         }

         if (((ObjetFamilleTiers)var9.get(0)).getExoTva().equals("true")) {
            this.factureEnteteVentes.setFacExoTva(1);
         } else {
            this.factureEnteteVentes.setFacExoTva(0);
         }
      }

      if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
         this.factureEnteteVentes.setFacExoTva(1);
      }

      if (!this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
         this.factureEnteteVentes.setFacCivilTiers("");
      } else {
         this.factureEnteteVentes.setFacCivilTiers(this.factureEnteteVentes.getTiers().getTiecivilite());
      }

      this.factureEnteteVentes.setFacTypeReg(this.tiers.getTietypereg());
      this.factureEnteteVentes.setFacModeReg(this.tiers.getTiemodereg());
      this.chargerModeEcheanceAffichage();
      this.factureEnteteVentes.setFacJournalReg(this.tiers.getTiejournalreg());
      if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
         this.factureEnteteVentes.setFacDiversTiers(99);
         this.var_pr_pv = false;
      } else {
         this.factureEnteteVentes.setFacDiversTiers(0);
         this.factureEnteteVentes.setFacDiversNom("");
         this.factureEnteteVentes.setFacDiversAdresse("");
         this.factureEnteteVentes.setFacDiversVille("");
         this.factureEnteteVentes.setFacDiversTel("");
         this.factureEnteteVentes.setFacDiversMail("");
      }

      if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
         this.factureEnteteVentes.setFacDevise(this.tiers.getTiedevise());
      } else {
         this.factureEnteteVentes.setFacDevise(this.structureLog.getStrdevise());
      }

      if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
         this.factureEnteteVentes.setFacSerie(this.tiers.getTieserie());
      } else {
         new ArrayList();
         var9 = this.usersChronoDao.selectListVenteByUser(this.usersLog, var3);
         if (var9.size() != 0) {
            this.factureEnteteVentes.setFacSerie(((UsersChrono)var9.get(0)).getUsrchrSerie());
         }
      }

      String var18 = "";
      var18 = "Facturation période: " + this.var_periodeGeneration;
      if (var1 != null && !var1.isEmpty() && !var1.equals("****")) {
         var18 = var18 + " Service: " + var1;
         this.factureEnteteVentes.setFacService(var1);
         if (var2.size() != 0) {
            for(int var19 = 0; var19 < var2.size(); ++var19) {
               if (var1.equals(((Site)var2.get(var19)).getSitCode())) {
                  this.factureEnteteVentes.setFacService(var1 + ":" + ((Site)var2.get(var19)).getSitNomFr());
               }
            }
         }
      } else {
         this.factureEnteteVentes.setFacService("");
      }

      this.factureEnteteVentes.setFacObject(var18);
      if (!this.contDest) {
         if (this.factureEnteteVentes.getFacDiversTiers() == 99) {
            this.factureEnteteVentes.setFacIdContact(0L);
            this.factureEnteteVentes.setFacNomContact("");
            this.factureEnteteVentes.setFacCivilContact("");
         } else {
            new Contacts();
            Contacts var20 = this.contactDao.recupererContacts(this.var_nom_contact, var3);
            if (var20 != null) {
               this.factureEnteteVentes.setFacIdContact(var20.getConid());
               if (var20.getConpatronyme() != null && !var20.getConpatronyme().isEmpty()) {
                  this.factureEnteteVentes.setFacNomContact(var20.getConpatronyme());
                  this.factureEnteteVentes.setFacCivilContact(var20.getConcivilite());
               } else if (var20.getConservice() != null && !var20.getConservice().isEmpty()) {
                  this.factureEnteteVentes.setFacNomContact(var20.getConservice());
                  this.factureEnteteVentes.setFacCivilContact("SERVICE/SITE:");
               } else {
                  this.factureEnteteVentes.setFacIdContact(0L);
                  this.factureEnteteVentes.setFacNomContact("");
                  this.factureEnteteVentes.setFacCivilContact("");
               }
            } else {
               this.factureEnteteVentes.setFacIdContact(0L);
               this.factureEnteteVentes.setFacNomContact("");
               this.factureEnteteVentes.setFacCivilContact("");
            }
         }
      } else {
         this.factureEnteteVentes.setFacIdContact(0L);
      }

      new Users();
      if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
         this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
      }

      Users var21 = this.usersDao.selectUserD(this.var_nom_responsable, var3);
      if (var21 != null) {
         this.factureEnteteVentes.setFacIdResponsable(var21.getUsrid());
         this.factureEnteteVentes.setFacNomResponsable(var21.getUsrPatronyme());
      } else {
         this.factureEnteteVentes.setFacIdResponsable(0L);
         this.factureEnteteVentes.setFacNomResponsable("");
      }

      if (this.optionsVentes.getResponsable().equals("1")) {
         new Users();
         if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
            this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
         }

         Users var11 = this.usersDao.selectUserD(this.var_nom_commercial, var3);
         if (var11 != null) {
            this.factureEnteteVentes.setFacIdCommercial(var11.getUsrid());
            this.factureEnteteVentes.setFacNomCommercial(var11.getUsrPatronyme());
         } else {
            this.factureEnteteVentes.setFacIdCommercial(0L);
            this.factureEnteteVentes.setFacNomCommercial("");
         }
      } else {
         this.factureEnteteVentes.setFacIdCommercial(0L);
         this.factureEnteteVentes.setFacNomCommercial("");
      }

      this.factureEnteteVentes.setFacIdEquipe(0L);
      this.factureEnteteVentes.setFacNomEquipe("");
      if (this.var_timbre != 0) {
         int var22 = this.var_date.getYear() + 1900;
         double var12 = this.utilNombre.calculTimbre(this.structureLog, this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), var22, this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacDate());
         this.val_timbre = this.utilNombre.myRoundDevise(var12, this.factureEnteteVentes.getFacDevise());
         if (this.val_timbre != 0.0D) {
            String var14 = this.utilNombre.beginSimple(this.val_timbre, this.factureEnteteVentes.getFacDevise());
            this.factureEnteteVentes.setFacFormule2(this.utilNombre.texteTimbre(this.structureLog, var14, var22, this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacDate()));
         }
      }

      boolean var23 = false;
      if (this.factureEnteteVentes.getFacId() == 0L) {
         this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
         this.factureEnteteVentes.setFacDateCreat(new Date());
         this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
         this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrPatronyme());
         if (this.factureEnteteVentes.getFacSerie() != null && !this.factureEnteteVentes.getFacSerie().equalsIgnoreCase("X") && !this.factureEnteteVentes.getFacSerie().isEmpty()) {
            this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var3));
            boolean var25 = false;

            label152:
            while(true) {
               while(true) {
                  if (var25) {
                     break label152;
                  }

                  new FactureEnteteVentes();
                  FactureEnteteVentes var13 = this.factureEnteteVentesDao.pourParapheur(this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacSerie(), var3);
                  if (var13 != null) {
                     long var26 = 100000000L * this.usersLog.getUsrid();

                     for(long var16 = 0L; var16 < var26; ++var16) {
                     }

                     this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var3));
                     var25 = false;
                  } else {
                     var25 = true;
                  }
               }
            }
         } else {
            long var24 = this.factureEnteteVentesDao.selectLastNum(var3);
            this.factureEnteteVentes.setFacNum("" + var24);
         }

         this.factureEnteteVentes.setFacEtat(0);
         this.factureEnteteVentes.setFacEtatVal(0);
         this.factureEnteteVentes.setFacDateValide((Date)null);
         this.factureEnteteVentes.setFacStock(0);
         this.factureEnteteVentes = this.factureEnteteVentesDao.insert(this.factureEnteteVentes, var3);
         var23 = true;
      } else {
         this.factureEnteteVentes.setFacDateModif(new Date());
         this.factureEnteteVentes.setFacIdModif(this.usersLog.getUsrid());
         this.factureEnteteVentes.setFacNomModif(this.usersLog.getUsrPatronyme());
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var3);
         var23 = false;
      }

      if (this.habilitation != null && var23) {
         this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureEnteteVentes.getFacId(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacDate(), this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), this.factureEnteteVentes.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var3), this.factureEnteteVentes.getVar_format_devise(), 0, var3);
      }

      return var4;
   }

   public void calculeEnteteTotal(Session var1) throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         this.lesLignesList.clear();
         this.lesLignesList = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var1);
         this.cumulPrixInterim();
         if (this.factureEnteteVentes.getFacService() != null && !this.factureEnteteVentes.getFacService().isEmpty() && this.factureEnteteVentes.getFacService().equals("****")) {
            this.factureEnteteVentes.setFacService("");
         }

         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
      }

   }

   public void cumulPrixInterim() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         new FactureLigneVentes();

         for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
            FactureLigneVentes var9 = (FactureLigneVentes)this.lesLignesList.get(var10);
            if (var9.getFacligGroupe() == null || var9.getFacligGroupe().isEmpty()) {
               var1 += var9.getFacligPu();
               var3 += var9.getFacligTva();
               var5 += var9.getFacligTtc();
               var7 += var9.getFacligTc();
            }
         }
      }

      this.factureEnteteVentes.setFacTotHt(var1);
      this.factureEnteteVentes.setFacTotTva(var3);
      this.factureEnteteVentes.setFacTotTtc(var5);
      this.factureEnteteVentes.setFacTotRemise(0.0D);
      this.factureEnteteVentes.setFacTotTc(var7);
   }

   public void calculLigneFactureSalarie(Session var1, int var2, BulletinSalaire var3, double var4, double var6, double var8) throws HibernateException, NamingException {
      if (this.modePresentation == 0) {
         if (var4 != 0.0D) {
            this.factureLigneVentes = new FactureLigneVentes();
            this.factureLigneVentes.setFacligCode("GAIN");
            this.factureLigneVentes.setFacligLibelle("GAINS");
            this.factureLigneVentes.setFacligComplement(var3.getBulsalMatricule() + ":" + var3.getPatronyme());
            this.factureLigneVentes.setFacligOrdre(var2);
            this.factureLigneVentes.setFacligPu(var4);
            this.factureLigneVentes.setFacligQte(1.0F);
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
            this.factureLigneVentes.setFacligTaxe("0");
            this.calculPrix("0", 0.0F, var1);
            this.factureLigneVentes.setFacligDepot("");
            this.factureLigneVentes.setFacligDescription("");
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.lesLignesList.add(this.factureLigneVentes);
            this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligLibelle());
         }

         if (var6 != 0.0D) {
            this.factureLigneVentes = new FactureLigneVentes();
            this.factureLigneVentes.setFacligCode("CHGS");
            this.factureLigneVentes.setFacligLibelle("CHARGES");
            this.factureLigneVentes.setFacligComplement(var3.getBulsalMatricule() + ":" + var3.getPatronyme());
            this.factureLigneVentes.setFacligOrdre(var2);
            this.factureLigneVentes.setFacligPu(var6);
            this.factureLigneVentes.setFacligQte(1.0F);
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
            this.factureLigneVentes.setFacligTaxe("0");
            this.calculPrix("0", 0.0F, var1);
            this.factureLigneVentes.setFacligDepot("");
            this.factureLigneVentes.setFacligDescription("");
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.lesLignesList.add(this.factureLigneVentes);
            this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligLibelle());
         }

         if (var8 != 0.0D) {
            this.factureLigneVentes = new FactureLigneVentes();
            this.factureLigneVentes.setFacligCode("PROV");
            this.factureLigneVentes.setFacligLibelle("PROVSIONS CONGES");
            this.factureLigneVentes.setFacligComplement(var3.getBulsalMatricule() + ":" + var3.getPatronyme());
            this.factureLigneVentes.setFacligOrdre(var2);
            this.factureLigneVentes.setFacligPu(var8);
            this.factureLigneVentes.setFacligQte(1.0F);
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
            this.factureLigneVentes.setFacligTaxe("0");
            this.calculPrix("0", 0.0F, var1);
            this.factureLigneVentes.setFacligDepot("");
            this.factureLigneVentes.setFacligDescription("");
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.lesLignesList.add(this.factureLigneVentes);
            this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligLibelle());
         }
      } else if (this.modePresentation == 1) {
         if (var4 != 0.0D || var6 != 0.0D || var8 != 0.0D) {
            this.factureLigneVentes = new FactureLigneVentes();
            this.factureLigneVentes.setFacligCode("DEBOURS");
            this.factureLigneVentes.setFacligLibelle("DEBOURS");
            this.factureLigneVentes.setFacligComplement(var3.getBulsalMatricule() + ":" + var3.getPatronyme());
            this.factureLigneVentes.setFacligOrdre(var2);
            this.factureLigneVentes.setFacligPu(var4 + var6 + var8);
            this.factureLigneVentes.setFacligQte(1.0F);
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
            this.factureLigneVentes.setFacligTaxe("0");
            this.calculPrix("0", 0.0F, var1);
            this.factureLigneVentes.setFacligDepot("");
            this.factureLigneVentes.setFacligDescription("");
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.lesLignesList.add(this.factureLigneVentes);
            this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligLibelle());
         }
      } else if (this.modePresentation == 2) {
      }

   }

   public void calculLigneFactureRubrique(Session var1, int var2, PlanPaye var3, double var4) throws HibernateException, NamingException {
      if (var4 != 0.0D) {
         this.factureLigneVentes = new FactureLigneVentes();
         this.factureLigneVentes.setFacligCode(var3.getPlpCode());
         this.factureLigneVentes.setFacligLibelle(var3.getPlpLibelleFR());
         this.factureLigneVentes.setFacligOrdre(var2);
         this.factureLigneVentes.setFacligPu(var4);
         this.factureLigneVentes.setFacligQte(1.0F);
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
         this.factureLigneVentes.setFacligTaxe("0");
         this.calculPrix("0", 0.0F, var1);
         this.factureLigneVentes.setFacligDepot("");
         this.factureLigneVentes.setFacligDescription("");
         this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
         this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         this.lesLignesList.add(this.factureLigneVentes);
         this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligLibelle());
      }

   }

   public void optimisationLignes(Session var1) throws HibernateException, NamingException {
      if (this.modeFacturation == 0) {
         if (this.lesLignesList.size() != 0) {
            ArrayList var2 = new ArrayList();

            int var3;
            for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               if (var2.size() == 0) {
                  var2.add(this.factureLigneVentes);
               } else {
                  boolean var4 = false;
                  double var5 = 0.0D;
                  int var7 = 0;

                  for(int var8 = 0; var8 < var2.size(); ++var8) {
                     if (this.factureLigneVentes.getFacligCode().equals(((FactureLigneVentes)var2.get(var8)).getFacligCode())) {
                        var5 = ((FactureLigneVentes)var2.get(var8)).getFacligPu();
                        var7 = var8;
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.factureLigneVentes.setFacligQte(1.0F);
                     this.factureLigneVentes.setFacligComplement("");
                     this.factureLigneVentes.setFacligPt(this.factureLigneVentes.getFacligPu());
                     this.factureLigneVentes.setFacligTva(0.0D);
                     var2.add(this.factureLigneVentes);
                  } else {
                     this.factureLigneVentes.setFacligQte(1.0F);
                     this.factureLigneVentes.setFacligComplement("");
                     this.factureLigneVentes.setFacligPu(this.factureLigneVentes.getFacligPu() + var5);
                     this.factureLigneVentes.setFacligPt(this.factureLigneVentes.getFacligPu());
                     this.factureLigneVentes.setFacligTva(0.0D);
                     var2.remove(var7);
                     var2.add(this.factureLigneVentes);
                  }
               }
            }

            if (this.modePresentation == 2) {
               boolean var10 = false;

               for(int var11 = 0; var11 < var2.size(); ++var11) {
                  this.factureLigneVentes = (FactureLigneVentes)var2.get(var11);
                  if (var11 == 0) {
                     this.factureLigneVentes = new FactureLigneVentes();
                     this.factureLigneVentes.setFacligCode("-");
                     this.factureLigneVentes.setFacligLibelle("GAINS:");
                     this.factureLigneVentes.setFacligOrdre(0);
                     this.factureLigneVentes.setFacligPu(0.0D);
                     this.factureLigneVentes.setFacligQte(0.0F);
                     this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
                     this.factureLigneVentes.setFacligQteUtil(0.0F);
                     this.factureLigneVentes.setFacligTaxe("0");
                     this.factureLigneVentes.setFacligDepot("");
                     this.factureLigneVentes.setFacligDescription("");
                     this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                     this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
                     this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
                     var2.add(0, this.factureLigneVentes);
                  } else if (this.factureLigneVentes.getFacligCode().startsWith("9") && !var10) {
                     this.factureLigneVentes = new FactureLigneVentes();
                     this.factureLigneVentes.setFacligCode("-");
                     this.factureLigneVentes.setFacligLibelle("CHARGES PATRONALES:");
                     this.factureLigneVentes.setFacligOrdre(0);
                     this.factureLigneVentes.setFacligPu(0.0D);
                     this.factureLigneVentes.setFacligQte(0.0F);
                     this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
                     this.factureLigneVentes.setFacligQteUtil(0.0F);
                     this.factureLigneVentes.setFacligTaxe("0");
                     this.factureLigneVentes.setFacligDepot("");
                     this.factureLigneVentes.setFacligDescription("");
                     this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                     this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
                     this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
                     var2.add(var11, this.factureLigneVentes);
                     var10 = true;
                  }
               }
            }

            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  this.factureLigneVentes = (FactureLigneVentes)var2.get(var3);
                  this.calculPrix("0", 0.0F, var1);
                  this.factureLigneVentes.setFacligOrdre(var3);
                  if (this.factureLigneVentes.getFacligId() == 0L) {
                     this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
                  } else {
                     this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
                  }
               }
            }
         }
      } else if (this.lesLignesList.size() != 0) {
         for(int var9 = 0; var9 < this.lesLignesList.size(); ++var9) {
            this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var9);
            this.calculPrix("0", 0.0F, var1);
            if (this.factureLigneVentes.getFacligId() == 0L) {
               this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
            } else {
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
            }
         }
      }

   }

   public void calculLigneFactureCommission(Session var1, int var2, double var3, int var5) throws HibernateException, NamingException {
      if (var3 != 0.0D) {
         this.factureLigneVentes = new FactureLigneVentes();
         this.factureLigneVentes.setFacligCode("-");
         this.factureLigneVentes.setFacligLibelle("COMMISSIONS:");
         this.factureLigneVentes.setFacligOrdre(var2);
         this.factureLigneVentes.setFacligPu(0.0D);
         this.factureLigneVentes.setFacligQte(0.0F);
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         this.factureLigneVentes.setFacligQteUtil(0.0F);
         this.factureLigneVentes.setFacligTaxe("0");
         this.factureLigneVentes.setFacligDepot("");
         this.factureLigneVentes.setFacligDescription("");
         this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
         this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         if (this.factureLigneVentes.getFacligId() == 0L) {
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
            this.lesLignesList.add(this.factureLigneVentes);
         } else {
            this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
         }

         this.factureLigneVentes = new FactureLigneVentes();
         this.factureLigneVentes.setFacligCode("COMM");
         if (var5 >= 2) {
            this.factureLigneVentes.setFacligLibelle("Commissions à " + this.tiers.getTietauxcom() + "% pour " + var5 + " agents");
         } else {
            this.factureLigneVentes.setFacligLibelle("Commissions à " + this.tiers.getTietauxcom() + "% pour " + var5 + " agent");
         }

         this.factureLigneVentes.setFacligOrdre(var2);
         if (this.tiers.getTiedevise() == null || this.tiers.getTiedevise().isEmpty()) {
            this.tiers.setTiedevise(this.structureLog.getStrdevise());
         }

         double var6 = 0.0D;
         if (this.modeCommision == 0) {
            var6 = this.utilNombre.myRoundDevise(var3 * (double)this.tiers.getTietauxcom() / 100.0D, this.tiers.getTiedevise());
         } else {
            var6 = (double)this.utilNombre.myRoundDevise((float)var5 * this.tiers.getTietauxcom(), this.tiers.getTiedevise());
         }

         this.factureLigneVentes.setFacligPu(var6);
         this.factureLigneVentes.setFacligQte(1.0F);
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
         if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            this.factureLigneVentes.setFacligTaxe(this.optionsVentes.getTvaDefaut());
         }

         this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
         this.factureLigneVentes.setFacligDepot("");
         this.factureLigneVentes.setFacligDescription("");
         if (this.factureLigneVentes.getFacligId() == 0L) {
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
            this.lesLignesList.add(this.factureLigneVentes);
         } else {
            this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
         }

         this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), "Commissions");
      }

   }

   public void calculLigneLibre(Session var1, int var2, int var3) throws HibernateException, NamingException {
      if (this.montant1 != 0.0D && this.libelle1 != null && !this.libelle1.isEmpty()) {
         this.factureLigneVentes = new FactureLigneVentes();
         this.factureLigneVentes.setFacligCode("PFREE1");
         if (var3 >= 2) {
            this.factureLigneVentes.setFacligLibelle(this.libelle1 + " pour " + var3 + " agents");
         } else {
            this.factureLigneVentes.setFacligLibelle(this.libelle1 + " pour " + var3 + " agent");
         }

         this.factureLigneVentes.setFacligOrdre(var2);
         if (this.tiers.getTiedevise() == null || this.tiers.getTiedevise().isEmpty()) {
            this.tiers.setTiedevise(this.structureLog.getStrdevise());
         }

         this.factureLigneVentes.setFacligPu(this.montant1);
         this.factureLigneVentes.setFacligQte(1.0F);
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
         if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            this.factureLigneVentes.setFacligTaxe(this.optionsVentes.getTvaDefaut());
         }

         this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
         this.factureLigneVentes.setFacligDepot("");
         this.factureLigneVentes.setFacligDescription("");
         if (this.factureLigneVentes.getFacligId() == 0L) {
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
            this.lesLignesList.add(this.factureLigneVentes);
         } else {
            this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
         }

         this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), "");
      }

      if (this.montant2 != 0.0D && this.libelle2 != null && !this.libelle2.isEmpty()) {
         this.factureLigneVentes = new FactureLigneVentes();
         this.factureLigneVentes.setFacligCode("PFREE2");
         if (var3 >= 2) {
            this.factureLigneVentes.setFacligLibelle(this.libelle2 + " pour " + var3 + " agents");
         } else {
            this.factureLigneVentes.setFacligLibelle(this.libelle2 + " pour " + var3 + " agent");
         }

         this.factureLigneVentes.setFacligOrdre(var2);
         if (this.tiers.getTiedevise() == null || this.tiers.getTiedevise().isEmpty()) {
            this.tiers.setTiedevise(this.structureLog.getStrdevise());
         }

         this.factureLigneVentes.setFacligPu(this.montant2);
         this.factureLigneVentes.setFacligQte(1.0F);
         this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
         this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
         if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            this.factureLigneVentes.setFacligTaxe(this.optionsVentes.getTvaDefaut());
         }

         this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
         this.factureLigneVentes.setFacligDepot("");
         this.factureLigneVentes.setFacligDescription("");
         if (this.factureLigneVentes.getFacligId() == 0L) {
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
            this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
            this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
            this.lesLignesList.add(this.factureLigneVentes);
         } else {
            this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
         }

         this.verifCodeProduit(var1, this.factureLigneVentes.getFacligCode(), "");
      }

   }

   public void verifCodeProduit(Session var1, String var2, String var3) throws HibernateException, NamingException {
      if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         this.produits = this.produitsDao.chargeProduit(var2, var1);
         if (this.produits == null) {
            this.produits = new Produits();
            this.produits.setProCode(var2);
            this.produits.setProDateCreat(new Date());
            this.produits.setProLibClient(var3);
            this.produits.setProStock(0);
            this.produits.setProVteCode("PREST");
            this.produits.setProVteLib("PRESTATIONS");
            this.produits.setProVteNat("1610");
            this.produits = this.produitsDao.insert(this.produits, var1);
            this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), "PREST", var1);
            if (this.famillesProduitsVentes == null) {
               this.famillesProduitsVentes = new FamillesProduitsVentes();
               this.famillesProduitsVentes.setExerciceventes(this.exercicesVentes);
               this.famillesProduitsVentes.setFamvteCode("PREST");
               this.famillesProduitsVentes.setFamvteDateCreation(new Date());
               this.famillesProduitsVentes.setFamvteLibNature("Prestations");
               this.famillesProduitsVentes.setFamvteLibelleFr("PRESTATIONS");
               this.famillesProduitsVentes.setFamvteNature("1610");
               this.famillesProduitsVentes.setFamvteStock(0);
               this.famillesProduitsVentes.setFamvteUserCreation(this.usersLog.getUsrid());
               this.famillesProduitsVentes = this.famillesProduitsVentesDao.insert(this.famillesProduitsVentes, var1);
            }
         }
      }

   }

   public void ajoutAbonnement() throws ParseException {
      this.mesPeriodesItems = new ArrayList();
      this.mesImpressionsFacturesItems = new ArrayList();
      this.lesFacturesGene = new ArrayList();
      this.lesContratsLigneGene = new ArrayList();
      this.datamodelEnteteGene = new ListDataModel();
      this.chargerPeriodes();
      this.chargerModeleFactures();
      this.var_action = 18;
   }

   public void rechercheContratAbonnement() throws HibernateException, NamingException {
      this.lesFacturesGene.clear();
      String var1 = "";
      new ArrayList();
      String var3 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
      String var4 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 23:59:59";
      List var2 = this.factureEnteteVentesDao.rechercheFactureAbonnement(var3, var4, this.region, (Session)null);
      new ArrayList();
      ContratEnteteVentesDao var6 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var5 = var6.rechercheFactureByDate(this.inpDu, (String)this.region, (Session)null);
      if (var5.size() != 0) {
         new ContratEnteteVentes();

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            ContratEnteteVentes var7 = (ContratEnteteVentes)var5.get(var8);
            if (var1 != null && !var1.isEmpty()) {
               var1 = var1 + "," + var7.getCrtId();
            } else {
               var1 = "" + var7.getCrtId();
            }

            this.factureEnteteVentes = new FactureEnteteVentes();
            this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.factureEnteteVentes.setTiers(var7.getTiers());
            this.factureEnteteVentes.setUsers(this.usersLog);
            this.factureEnteteVentes.setFacActivite(var7.getCrtActivite());
            this.factureEnteteVentes.setFacAnal2(var7.getCrtAnal2());
            this.factureEnteteVentes.setFacAnal4(var7.getCrtAnal4());
            this.factureEnteteVentes.setFacArrondiReg(var7.getCrtArrondiReg());
            this.factureEnteteVentes.setFacBanque(var7.getCrtBanque());
            this.factureEnteteVentes.setFacBudget(var7.getCrtBudget());
            this.factureEnteteVentes.setFacCat(var7.getCrtCat());
            this.factureEnteteVentes.setFacCivilContact(var7.getCrtCivilContact());
            this.factureEnteteVentes.setFacCivilTiers(var7.getCrtCivilTiers());
            this.factureEnteteVentes.setFacConditionReg(var7.getCrtConditionReg());
            this.factureEnteteVentes.setFacContrat(var7.getCrtNum());
            this.factureEnteteVentes.setFacDate(this.inpDu);
            this.factureEnteteVentes.setFacDateCreat(new Date());
            this.factureEnteteVentes.setFacDateEcheReg((Date)null);
            this.factureEnteteVentes.setFacEtat(1);
            this.factureEnteteVentes.setFacExoDouane(var7.getCrtExoDouane());
            this.factureEnteteVentes.setFacExoTva(var7.getCrtExoTva());
            this.factureEnteteVentes.setFacFormule1(var7.getCrtFormule1());
            this.factureEnteteVentes.setFacFormule2(var7.getCrtFormule2());
            this.factureEnteteVentes.setFacIdCommercial(var7.getCrtIdCommercial());
            this.factureEnteteVentes.setFacIdContact(var7.getCrtIdContact());
            this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacIdEquipe(var7.getCrtIdEquipe());
            this.factureEnteteVentes.setFacIdResponsable(var7.getCrtIdResponsable());
            this.factureEnteteVentes.setFacInfo1(var7.getCrtNumCompteur());
            boolean var9 = false;

            for(int var10 = 0; var10 < var2.size(); ++var10) {
               if (var7.getTiers().getTieid() == ((FactureEnteteVentes)var2.get(var10)).getTiers().getTieid()) {
                  this.factureEnteteVentes.setFacInfo2(((FactureEnteteVentes)var2.get(var10)).getFacInfo2());
                  this.factureEnteteVentes.setFacInfo3(((FactureEnteteVentes)var2.get(var10)).getFacInfo3());
                  this.factureEnteteVentes.setFacInfo4(((FactureEnteteVentes)var2.get(var10)).getFacInfo4());
                  var9 = true;
                  break;
               }
            }

            if (var9) {
               this.factureEnteteVentes.setVar_select_ligne(true);
            } else {
               this.factureEnteteVentes.setVar_select_ligne(false);
               if (var7.getCrtInfo3() != null && !var7.getCrtInfo3().isEmpty()) {
                  this.factureEnteteVentes.setFacInfo2(var7.getCrtInfo3());
               } else {
                  this.factureEnteteVentes.setFacInfo2("" + var7.getCrtIndexInitial());
               }

               this.factureEnteteVentes.setFacInfo3("0");
               this.factureEnteteVentes.setFacInfo4(var7.getCrtInfo4());
            }

            this.factureEnteteVentes.setFacInfo5(var7.getCrtInfo5());
            this.factureEnteteVentes.setFacInfo6(var7.getCrtInfo6());
            this.factureEnteteVentes.setFacInfo7(var7.getCrtInfo7());
            this.factureEnteteVentes.setFacInfo8(var7.getCrtInfo8());
            this.factureEnteteVentes.setFacInfo9(var7.getCrtInfo9());
            this.factureEnteteVentes.setFacInfo10(var7.getCrtInfo10());
            this.factureEnteteVentes.setFacJournalReg(var7.getCrtJournalReg());
            this.factureEnteteVentes.setFacModeReg(var7.getCrtModeReg());
            this.factureEnteteVentes.setFacModeleImp(this.modeleFacture);
            this.factureEnteteVentes.setFacNbJourReg(var7.getCrtNbJourReg());
            this.factureEnteteVentes.setFacNomCommercial(var7.getCrtNomCommercial());
            this.factureEnteteVentes.setFacNomContact(var7.getCrtNomContact());
            this.factureEnteteVentes.setFacNomCreateur(var7.getCrtNomCreateur());
            this.factureEnteteVentes.setFacNomEquipe(var7.getCrtNomEquipe());
            this.factureEnteteVentes.setFacNomResponsable(var7.getCrtNomResponsable());
            this.factureEnteteVentes.setFacNomTiers(var7.getCrtNomTiers());
            this.factureEnteteVentes.setFacObject(var7.getCrtObject());
            this.factureEnteteVentes.setFacObservation(var7.getCrtObservation());
            this.factureEnteteVentes.setFacPdv(var7.getCrtPdv());
            this.factureEnteteVentes.setFacRegion(var7.getCrtRegion());
            this.factureEnteteVentes.setFacSecteur(var7.getCrtSecteur());
            this.factureEnteteVentes.setFacSerie(var7.getCrtSerie());
            this.factureEnteteVentes.setFacService(var7.getCrtService());
            this.factureEnteteVentes.setFacSite(var7.getCrtSite());
            this.factureEnteteVentes.setFacSource(var7.getCrtSource());
            this.factureEnteteVentes.setFacStock(var7.getCrtStock());
            this.factureEnteteVentes.setFacTauxRemise(var7.getCrtTauxRemise());
            this.factureEnteteVentes.setFacTauxTc(var7.getCrtTauxTc());
            this.factureEnteteVentes.setFacTiersRegroupe(var7.getCrtTiersRegroupe());
            this.factureEnteteVentes.setFacTypeReg(var7.getCrtTypeReg());
            this.lesFacturesGene.add(this.factureEnteteVentes);
         }

         this.datamodelEnteteGene.setWrappedData(this.lesFacturesGene);
         ContratLigneVentesDao var11 = new ContratLigneVentesDao(this.baseLog, this.utilInitHibernate);
         String var12 = "contratEnteteVentes.crtId in (" + var1 + ")";
         this.lesContratsLigneGene = var11.rechercheContratRequete(var12, (Session)null);
      }

   }

   public void chargerModeleFactures() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.mesImpressionsFacturesItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.mesImpressionsFacturesItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exercicesVentes.getExevteDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exercicesVentes.getExevteDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         this.mesPeriodesItems.add(new SelectItem(var5));
      }

      this.inpDu = var1;
      this.inpAu = var3;
   }

   public void calculeDates() throws ParseException {
      if (this.periode != null && !this.periode.isEmpty()) {
         if (this.periode.contains(":")) {
            String[] var1 = this.periode.split(":");
            String var2 = var1[0];
            String var3 = var1[1];
            this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + "01");
            this.inpAu = this.utilDate.dateDernierJourMois(this.inpDu);
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
            } else if (this.periode.equals("2eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("3eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
            } else if (this.periode.equals("4eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("Annuel")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void selectionLigneGene() {
      if (this.datamodelEnteteGene.isRowAvailable()) {
         this.factureEnteteVentes = (FactureEnteteVentes)this.datamodelEnteteGene.getRowData();
      }

   }

   public void calculIndex() {
      this.selectionLigneGene();
      if (this.factureEnteteVentes != null) {
         int var1 = 0;
         int var2 = Integer.parseInt(this.factureEnteteVentes.getFacInfo3());
         int var3 = Integer.parseInt(this.factureEnteteVentes.getFacInfo2());
         if (var2 >= var3) {
            var1 = var2 - var3;
         }

         this.factureEnteteVentes.setFacInfo4("" + var1);
      }

   }

   public void annulerGene() {
      this.var_action = 0;
   }

   public void validerGene() throws HibernateException, NamingException, ParseException {
      new ContratEnteteVentes();
      ContratEnteteVentesDao var2 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < this.lesFacturesGene.size(); ++var5) {
            this.factureEnteteVentes = (FactureEnteteVentes)this.lesFacturesGene.get(var5);
            if (!this.factureEnteteVentes.isVar_select_ligne()) {
               String var6 = "";
               boolean var7 = false;
               new FactureEnteteVentes();
               FactureEnteteVentes var8 = this.factureEnteteVentesDao.pourParapheurAutomatique(this.factureEnteteVentes.getTiers().getTieid(), this.factureEnteteVentes.getFacContrat(), this.utilDate.dateToStringSQLLight(this.inpDu), this.utilDate.dateToStringSQLLight(this.inpAu), var3);
               if (var8 != null) {
                  if (var8.getFacDateTransfert() == null) {
                     var6 = var8.getFacNum();
                     this.supprimerDocument(var8, var3);
                     var7 = true;
                  } else {
                     var7 = false;
                  }
               } else {
                  var7 = true;
               }

               if (var7) {
                  if (this.factureEnteteVentes.getFacId() == 0L) {
                     this.factureEnteteVentes.setFacDate(this.utilDate.dateToSQL(this.inpDu, "08", "00", "00"));
                     if (var6 == null || var6.isEmpty()) {
                        var6 = this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var3);
                     }

                     this.factureEnteteVentes.setFacNum(var6);
                     this.factureEnteteVentes = this.factureEnteteVentesDao.insert(this.factureEnteteVentes, var3);
                  } else {
                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var3);
                  }

                  this.tiers = this.factureEnteteVentes.getTiers();
                  double var9 = 0.0D;
                  double var11 = 0.0D;
                  double var13 = 0.0D;
                  double var15 = 0.0D;
                  double var17 = 0.0D;
                  double var19 = 0.0D;
                  float var21 = 0.0F;
                  if (this.lesContratsLigneGene.size() != 0) {
                     for(int var22 = 0; var22 < this.lesContratsLigneGene.size(); ++var22) {
                        if (((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getContratEnteteVentes().getCrtNum().equals(this.factureEnteteVentes.getFacContrat())) {
                           this.factureLigneVentes = new FactureLigneVentes();
                           this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                           this.factureLigneVentes.setFacligCode(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligCode());
                           this.factureLigneVentes.setFacligCommission(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligCommission());
                           this.factureLigneVentes.setFacligComplement(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligComplement());
                           this.factureLigneVentes.setFacligCondition(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligCondition());
                           this.factureLigneVentes.setFacligDepot(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligDepot());
                           this.factureLigneVentes.setFacligDescription(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligDescription());
                           this.factureLigneVentes.setFacligDevise(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligDevise());
                           this.factureLigneVentes.setFacligDiam(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligDiam());
                           this.factureLigneVentes.setFacligEchelle(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligEchelle());
                           this.factureLigneVentes.setFacligEntStock(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligEntStock());
                           this.factureLigneVentes.setFacligFamille(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligFamille());
                           this.factureLigneVentes.setFacligGroupe(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligGroupe());
                           this.factureLigneVentes.setFacligHaut(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligHaut());
                           this.factureLigneVentes.setFacligLarg(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligLarg());
                           this.factureLigneVentes.setFacligLibelle(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligLibelle());
                           this.factureLigneVentes.setFacligLong(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligLong());
                           this.factureLigneVentes.setFacligLot(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligLot());
                           this.factureLigneVentes.setFacligModeGroupe(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligModeGroupe());
                           this.factureLigneVentes.setFacligNb(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligNb());
                           this.factureLigneVentes.setFacligNumSerie(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligNumSerie());
                           this.factureLigneVentes.setFacligOrdre(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligOrdre());
                           this.factureLigneVentes.setFacligPoidsBrut(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPoidsBrut());
                           this.factureLigneVentes.setFacligPoidsNet(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPoidsNet());
                           this.factureLigneVentes.setFacligPu(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPu());
                           this.factureLigneVentes.setFacligPuRem(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPuRem());
                           this.factureLigneVentes.setFacligPump(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPump());
                           this.factureLigneVentes.setFacligPuTtc(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPuTtc());
                           this.factureLigneVentes.setFacligPuRemTtc(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligPuRemTtc());
                           if (this.factureEnteteVentes.getFacInfo4() == null || this.factureEnteteVentes.getFacInfo4().isEmpty()) {
                              this.factureEnteteVentes.setFacInfo4("0");
                           }

                           if (this.factureLigneVentes.getFacligCode().equals("01")) {
                              this.factureLigneVentes.setFacligQte((float)Integer.parseInt(this.factureEnteteVentes.getFacInfo4()));
                              var21 = this.factureLigneVentes.getFacligQte();
                           } else if (this.factureLigneVentes.getFacligCode().equals("02")) {
                              this.factureLigneVentes.setFacligQte(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQte());
                           } else if (this.factureLigneVentes.getFacligCode().equals("03")) {
                              this.factureLigneVentes.setFacligQte(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQte());
                           } else if (this.factureLigneVentes.getFacligCode().equals("04")) {
                              this.factureLigneVentes.setFacligQte(var21 - 100.0F);
                              if (this.factureLigneVentes.getFacligQte() <= 0.0F) {
                                 this.factureLigneVentes.setFacligQte(0.0F);
                              }
                           } else if (this.factureLigneVentes.getFacligCode().equals("05")) {
                              this.factureLigneVentes.setFacligQte(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQte());
                           } else if (this.factureLigneVentes.getFacligCode().equals("06")) {
                              this.factureLigneVentes.setFacligQte(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQte());
                           } else if (this.factureLigneVentes.getFacligCode().equals("07")) {
                              this.factureLigneVentes.setFacligQte(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQte());
                           }

                           this.factureLigneVentes.setFacligQteStock(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQteStock());
                           this.factureLigneVentes.setFacligQteUtil(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligQte());
                           this.factureLigneVentes.setFacligRabais(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligRabais());
                           this.factureLigneVentes.setFacligReference(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligReference());
                           this.factureLigneVentes.setFacligStock(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligStock());
                           this.factureLigneVentes.setFacligTauxRemise(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligTauxRemise());
                           this.factureLigneVentes.setFacligTauxTaxe(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligTauxTaxe());
                           this.factureLigneVentes.setFacligTaxe(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligTaxe());
                           this.factureLigneVentes.setFacligUnite(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligUnite());
                           this.factureLigneVentes.setFacligVolume(((ContratLigneVentes)this.lesContratsLigneGene.get(var22)).getCrtligVolume());
                           this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var3);
                           if (this.factureLigneVentes.getFacligCode().equals("04")) {
                              if (this.factureLigneVentes.getFacligQte() >= 0.0F) {
                                 double var23 = this.utilNombre.myRoundDevise((double)this.factureLigneVentes.getFacligQte() * this.factureLigneVentes.getFacligPu() * 0.18D, this.structureLog.getStrdevise());
                                 this.factureLigneVentes.setFacligPt(var23);
                                 this.factureLigneVentes.setFacligTva(var23);
                              }

                              var15 += this.factureLigneVentes.getFacligTva();
                              var17 += this.factureLigneVentes.getFacligTva();
                           } else {
                              this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var3);
                              var9 += this.factureLigneVentes.getFacligPt();
                              var11 += (this.factureLigneVentes.getFacligPu() - this.factureLigneVentes.getFacligPuRem()) * (double)this.factureLigneVentes.getFacligQte();
                              var13 += this.factureLigneVentes.getFacligRabais();
                              var17 += this.factureLigneVentes.getFacligTtc();
                           }

                           var19 += this.factureLigneVentes.getFacligTc();
                           if (this.factureLigneVentes.getFacligPt() != 0.0D) {
                              this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var3);
                           }
                        }
                     }
                  }

                  this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(this.factureEnteteVentes.getFacId(), var3);
                  if (this.factureEnteteVentes != null) {
                     this.factureEnteteVentes.setFacTotHt(var9);
                     this.factureEnteteVentes.setFacTotRemise(var11);
                     this.factureEnteteVentes.setFacTotRabais(var13);
                     this.factureEnteteVentes.setFacTotTva(var15);
                     this.factureEnteteVentes.setFacTotTc(var19);
                     this.factureEnteteVentes.setFacTotTtc(var17);
                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var3);
                  }

                  ContratEnteteVentes var1 = var2.pourParapheur(this.factureEnteteVentes.getFacContrat(), var3);
                  if (var1 != null) {
                     var1.setCrtInfo3(this.factureEnteteVentes.getFacInfo3());
                     var2.modif(var1, var3);
                  }
               }
            }
         }

         var4.commit();
      } catch (HibernateException var28) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var28;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 0;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.factureEnteteVentes.getFacExoTva() == 0) {
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

      this.factureLigneVentes.setFacligTaxe(var6);
      this.factureLigneVentes.setFacligTauxTaxe(var5);
      double var35 = this.factureLigneVentes.getFacligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.factureEnteteVentes.getFacDevise());
      }

      var10 = this.factureLigneVentes.getFacligQte();
      if (this.factureLigneVentes.getFacligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
            var10 = this.factureLigneVentes.getFacligQte() * this.factureLigneVentes.getFacligLong();
         } else {
            this.factureLigneVentes.setFacligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.factureLigneVentes.getFacligCondition(), this.factureLigneVentes.getFacligQte(), this.factureLigneVentes.getFacligLong(), this.factureLigneVentes.getFacligLarg(), this.factureLigneVentes.getFacligHaut(), this.factureLigneVentes.getFacligDiam(), this.factureLigneVentes.getFacligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.factureLigneVentes.setFacligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && this.factureLigneVentes.getFacligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.factureLigneVentes.getFacligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.factureLigneVentes.getFacligRabais() * (double)this.factureLigneVentes.getFacligQte();
      } else if (this.optionsVentes.getDecrmtRabais().equals("3")) {
         var15 = 0.0D;
      }

      if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F && this.factureEnteteVentes.getFacTauxAcompte() == 0.0F) {
         var13 = var11 - var11 * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D - var15;
      } else if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F && this.factureEnteteVentes.getFacTauxAcompte() != 0.0F) {
         var13 = var11 * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13 - this.factureLigneVentes.getFacligManquant(), this.var_format_devise);
      double var19 = var17 * (double)this.factureLigneVentes.getFacligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.factureLigneVentes.getFacligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && this.factureLigneVentes.getFacligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.factureLigneVentes.getFacligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.factureLigneVentes.getFacligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.factureLigneVentes.getFacligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.factureLigneVentes.getFacligQte(), 2);
      }

      this.factureLigneVentes.setFacligPuRem(var25);
      this.factureLigneVentes.setFacligPt(var17);
      this.factureLigneVentes.setFacligTva(var21);
      this.factureLigneVentes.setFacligTc(0.0D);
      this.factureLigneVentes.setFacligTtc(var23);
      double var27 = 0.0D;
      if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && this.factureLigneVentes.getFacligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.factureLigneVentes.getFacligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.factureLigneVentes.getFacligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.factureLigneVentes.getFacligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.factureLigneVentes.getFacligQte(), 2);
      }

      this.factureLigneVentes.setFacligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.factureLigneVentes.getFacligTauxTaxe() / 100.0D;
      this.factureLigneVentes.setFacligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.factureEnteteVentes.setFacTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.factureLigneVentes.setFacligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
               if (this.factureLigneVentes.getFacligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.factureLigneVentes.getFacligTauxTaxe() / 100.0D;
                  this.factureLigneVentes.setFacligTc(var33);
               }
            }
         } else {
            if (this.factureLigneVentes.getFacligTva() != 0.0D) {
               var31 = var17 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.factureLigneVentes.setFacligTc(var33);
         }
      } else {
         this.factureLigneVentes.setFacligTc(0.0D);
         this.factureEnteteVentes.setFacTauxTc(0.0F);
      }

      this.factureLigneVentes.setFacligPt(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPt(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTva(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTva(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTtc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTtc(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTc(), this.factureEnteteVentes.getFacDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.factureEnteteVentes.getFacExoTva() == 0) {
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

      this.factureLigneVentes.setFacligTaxe(var6);
      this.factureLigneVentes.setFacligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.factureEnteteVentes.getFacTauxTc() != 0.0F && this.factureLigneVentes.getFacligTva() != 0.0D) {
         var10 = this.factureLigneVentes.getFacligTtc();
         var12 = var10 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.factureLigneVentes.getFacligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.factureLigneVentes.getFacligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.factureLigneVentes.setFacligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.factureLigneVentes.getFacligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.factureLigneVentes.getFacligRabais() * (double)this.factureLigneVentes.getFacligQte();
      } else if (this.optionsVentes.getDecrmtRabais().equals("3")) {
         var12 = 0.0D;
      }

      double var14 = 0.0D;
      if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F && this.factureEnteteVentes.getFacTauxAcompte() == 0.0F) {
         var14 = var10 - var10 * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D - var12;
      } else if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F && this.factureEnteteVentes.getFacTauxAcompte() != 0.0F) {
         var14 = var10 * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F && this.factureEnteteVentes.getFacTauxAcompte() == 0.0F) {
         var16 = var39 - var39 * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D - var12;
      } else if (this.factureLigneVentes.getFacligTauxRemise() != 0.0F && this.factureEnteteVentes.getFacTauxAcompte() != 0.0F) {
         var16 = var39 * (double)this.factureLigneVentes.getFacligTauxRemise() / 100.0D;
      } else {
         var16 = var39 - var12;
      }

      if (this.factureLigneVentes.getFacligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
         } else {
            this.factureLigneVentes.setFacligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.factureLigneVentes.getFacligCondition(), this.factureLigneVentes.getFacligQte(), this.factureLigneVentes.getFacligLong(), this.factureLigneVentes.getFacligLarg(), this.factureLigneVentes.getFacligHaut(), this.factureLigneVentes.getFacligDiam(), this.factureLigneVentes.getFacligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.factureLigneVentes.setFacligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.factureLigneVentes.getFacligQte();
      double var24 = this.utilNombre.myRound(var22 - this.factureLigneVentes.getFacligManquant(), this.utilNombre.nbDecimal(this.factureEnteteVentes.getFacDevise()));
      double var26 = var20 * (double)this.factureLigneVentes.getFacligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.factureEnteteVentes.getFacDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligPuRem(var18);
      this.factureLigneVentes.setFacligPuRemTtc(var20);
      this.factureLigneVentes.setFacligPt(var24);
      this.factureLigneVentes.setFacligTva(var32);
      this.factureLigneVentes.setFacligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.factureEnteteVentes.setFacTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.factureLigneVentes.setFacligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
               if (this.factureLigneVentes.getFacligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.factureLigneVentes.getFacligTauxTaxe() / 100.0D;
                  this.factureLigneVentes.setFacligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.factureEnteteVentes.getFacTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.factureLigneVentes.setFacligTc(var36);
         }
      } else {
         this.factureLigneVentes.setFacligTc(0.0D);
         this.factureEnteteVentes.setFacTauxTc(0.0F);
      }

      this.factureLigneVentes.setFacligPt(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPt(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTva(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTva(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTtc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTtc(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTc(), this.factureEnteteVentes.getFacDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      this.messageStockNegatif = "";
      if (this.produitsDepot != null) {
         if (this.factureEnteteVentes.getFacStock() == 1) {
            if (this.structureLog.getStrstockNegatif() == 2) {
               if (this.produitsDepot.getProdepQteStk() < this.factureLigneVentes.getFacligQte() && this.factureLigneVentes.getFacligQte() != 0.0F) {
                  this.validationLigne = 2;
                  this.messageStockNegatif = "Quantité demandée : " + this.factureLigneVentes.getFacligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
               } else {
                  this.validationLigne = 0;
               }
            } else if (this.structureLog.getStrstockNegatif() == 1) {
               if (this.produitsDepot.getProdepQteStk() < this.factureLigneVentes.getFacligQte() && this.factureLigneVentes.getFacligQte() != 0.0F) {
                  this.validationLigne = 1;
                  this.messageStockNegatif = "Quantité demandée : " + this.factureLigneVentes.getFacligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
               } else {
                  this.validationLigne = 0;
               }
            } else {
               this.validationLigne = 0;
            }
         } else {
            this.validationLigne = 0;
         }

         if (this.produitsDepot.getProdepQteMini() != 0.0F && this.factureLigneVentes.getFacligQte() != 0.0F && this.produitsDepot.getProdepQteMini() >= this.produitsDepot.getProdepQteStk() - this.factureLigneVentes.getFacligQte()) {
            this.messageStockNegatif = "Quantité en stock : " + (this.produitsDepot.getProdepQteStk() - this.factureLigneVentes.getFacligQte()) + " Quantité minimale : " + this.produitsDepot.getProdepQteMini() + " ==> LA QUANTITE MINIMALE A ETE ATTEINTE";
            this.formRecherche.setMessageTexte(this.messageStockNegatif);
            this.formRecherche.setShowModalPanelMessage(true);
         }
      } else {
         this.validationLigne = 0;
      }

      if (this.factureLigneVentes != null && this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.factureLigneVentes.getFacligPuRemTtc() != 0.0D) {
               if (this.factureLigneVentes.getFacligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.factureLigneVentes.getFacligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.factureLigneVentes.getFacligPuRem() != 0.0D) {
            if (this.factureLigneVentes.getFacligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.factureLigneVentes.getFacligPu() < this.prixPlancher) {
            this.griserValider = true;
            this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

      if (this.plafondEnCours != 0.0D) {
         double var1 = 0.0D;

         for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
            var1 += ((FactureLigneVentes)this.lesLignesList.get(var3)).getFacligTtc();
         }

         if (this.soldeEnCours + var1 <= this.plafondEnCours) {
            this.plafondAutorise = true;
         } else {
            this.plafondAutorise = false;
            this.formRecherche.setMessageTexte("Vous avez dépassé le planfond autorisé. Veuillez réduire les quantités.....");
            this.formRecherche.setShowModalPanelMessage(true);
            if (this.factureLigneVentes != null) {
               this.factureLigneVentes.setFacligQte(0.0F);
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
         new FactureLigneVentes();
         FactureLigneVentes var13;
         int var14;
         if (this.typeVente == 810) {
            for(var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
               var13 = (FactureLigneVentes)this.lesLignesList.get(var14);
               if (var13.getFacligGroupe() == null || var13.getFacligGroupe().isEmpty()) {
                  if (var13.getFacligCode() != null && !var13.getFacligCode().isEmpty() && var13.getFacligCode().equals("04")) {
                     var5 += var13.getFacligTva();
                     var7 += var13.getFacligTva();
                  } else {
                     var3 += var13.getFacligPt();
                     var7 += var13.getFacligTtc();
                  }

                  var9 += var13.getFacligTc();
                  if (var13.getFacligRabais() != 0.0D || var13.getFacligTauxRemise() != 0.0F) {
                     var11 += var13.getFacligPu() * (double)var13.getFacligQte() - var13.getFacligPt();
                  }

                  var1 = var1 + var13.getFacligPt() - var13.getFacligPump() * (double)var13.getFacligQte();
               }
            }
         } else {
            for(var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
               var13 = (FactureLigneVentes)this.lesLignesList.get(var14);
               if (var13.getFacligGroupe() == null || var13.getFacligGroupe().isEmpty()) {
                  var3 += var13.getFacligPt();
                  var5 += var13.getFacligTva();
                  var7 += var13.getFacligTtc();
                  var9 += var13.getFacligTc();
                  if (var13.getFacligRabais() != 0.0D || var13.getFacligTauxRemise() != 0.0F) {
                     var11 += var13.getFacligPu() * (double)var13.getFacligQte() - var13.getFacligPt();
                  }

                  var1 = var1 + var13.getFacligPt() - var13.getFacligPump() * (double)var13.getFacligQte();
               }
            }
         }
      }

      this.var_total_marge = var1;
      this.factureEnteteVentes.setFacTotHt(var3);
      this.factureEnteteVentes.setFacTotTva(var5);
      this.factureEnteteVentes.setFacTotTtc(var7);
      this.factureEnteteVentes.setFacTotRemise(var11);
      this.factureEnteteVentes.setFacTotTc(var9);
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
         this.factureLigneVentes = (FactureLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         if (this.factureLigneVentes.getFacligCode() != null && this.factureLigneVentes.getFacligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.factureLigneVentes.setFacligCode(this.produits.getProCode());
               this.factureLigneVentes.setFacligFamille(this.produits.getProAchCode());
               this.factureLigneVentes.setFacligStock(this.produits.getProStock());
               this.factureLigneVentes.setFacligLong(this.produits.getProLongueur());
               this.factureLigneVentes.setFacligLarg(this.produits.getProLargeur());
               this.factureLigneVentes.setFacligHaut(this.produits.getProEpaisseur());
               this.factureLigneVentes.setFacligDiam(this.produits.getProDiamExt());
               this.factureLigneVentes.setFacligPoidsBrut(this.produits.getProPoidsBrut());
               this.factureLigneVentes.setFacligPoidsNet(this.produits.getProPoidsNet());
               this.factureLigneVentes.setFacligVolume(this.produits.getProVolume());
               this.factureLigneVentes.setFacligNb(this.produits.getProNbUnite());
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

               if (this.factureEnteteVentes.getFacStock() == 1) {
                  this.griserchamps = false;
               } else {
                  this.griserchamps = true;
               }

               if (this.factureLigneVentes.getFacligTaxe() != null && !this.factureLigneVentes.getFacligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTaxe() + ":" + this.factureLigneVentes.getFacligTauxTaxe()));
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
         this.factureLigneVentes = (FactureLigneVentes)this.datamodelLigne.getRowData();
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
      this.factureLigneVentes = new FactureLigneVentes();
      this.mesTaxesVentesProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_depotProd = "";
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.validationLigne = 0;
      this.messageStockNegatif = "";
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.factureLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.factureLigneVentes);
            this.lesLignesList.add(this.numLigne, this.factureLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               this.factureLigneVentes.setFacligOrdre(var3);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
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
      if (this.factureLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.factureLigneVentes);
            this.lesLignesList.add(this.numLigne, this.factureLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               this.factureLigneVentes.setFacligOrdre(var3);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
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
            if (this.factureLigneVentes.getFacligId() == ((FactureLigneVentes)this.lesLignesList.get(var2)).getFacligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() || this.factureLigneVentes.getFacligLibelle() != null && !this.factureLigneVentes.getFacligLibelle().isEmpty() || this.factureLigneVentes.getFacligComplement() != null && !this.factureLigneVentes.getFacligComplement().isEmpty()) {
         if (this.factureEnteteVentes.getFacId() == 0L) {
            this.save();
         }

         if (this.plafondAutorise) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
               if (this.factureLigneVentes.getFacligQteUtil() == 0.0F) {
                  this.factureLigneVentes.setFacligQteUtil(this.factureLigneVentes.getFacligQte());
               }

               this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
               if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
                  String[] var3;
                  if (this.var_depotProd.contains(":")) {
                     var3 = this.var_depotProd.split(":");
                     this.factureLigneVentes.setFacligDepot(var3[0]);
                  } else {
                     var3 = this.var_depotProd.split("=");
                     this.factureLigneVentes.setFacligDepot(var3[0]);
                  }
               } else {
                  this.factureLigneVentes.setFacligDepot("");
               }

               if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && this.factureLigneVentes.getFacligCondition().contains(":")) {
                  ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
                  String[] var4 = this.factureLigneVentes.getFacligCondition().split(":");
                  String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
                  if (var5 != null && !var5.isEmpty()) {
                     this.factureLigneVentes.setFacligDescription(var5);
                  } else {
                     this.factureLigneVentes.setFacligDescription("");
                  }

                  if (this.factureLigneVentes.getFacligEchelle() == 0) {
                     this.unite = new Unite();
                     this.unite = this.uniteDao.selectUnite(var4[0], var1);
                     if (this.unite != null) {
                        this.factureLigneVentes.setFacligEchelle(this.unite.getUniEchelle());
                     }
                  }
               } else {
                  this.factureLigneVentes.setFacligDescription("");
               }

               if (this.factureLigneVentes.getFacligId() == 0L) {
                  this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                  this.factureLigneVentes.setFacligDevise(this.factureEnteteVentes.getFacDevise());
                  this.factureLigneVentes.setFacligEntStock(this.factureEnteteVentes.getFacStock());
                  this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var1);
                  if (this.numLigne == 0) {
                     if (this.lesLignesList.size() != 0) {
                        this.numLigne = this.lesLignesList.size();
                     } else {
                        this.numLigne = 0;
                     }
                  }

                  this.lesLignesList.add(this.numLigne, this.factureLigneVentes);
                  this.datamodelLigne.setWrappedData(this.lesLignesList);
                  this.numLigne = this.clauleNumlLigne() + 1;
               } else {
                  this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
               }

               if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
                  new FactureLigneVentes();

                  for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                     FactureLigneVentes var16 = (FactureLigneVentes)this.lesLignesList.get(var17);
                     if (var16.getFacligGroupe() != null && !var16.getFacligGroupe().isEmpty() && var16.getFacligGroupe().equals(this.memoProduits.getProCode())) {
                        this.factureLigneVentesDao.deleteOneLigne(var16, var1);
                        this.lesLignesList.remove(var16);
                        --var17;
                     }
                  }

                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               }

               if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
                  String var18 = this.produits.getProCode();
                  float var20 = this.factureLigneVentes.getFacligQte();
                  new FactureLigneVentes();

                  FactureLigneVentes var19;
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     var19 = (FactureLigneVentes)this.lesLignesList.get(var6);
                     if (var19.getFacligGroupe() != null && !var19.getFacligGroupe().isEmpty() && var19.getFacligGroupe().equals(var18)) {
                        this.factureLigneVentesDao.deleteOneLigne(var19, var1);
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
                        var19 = new FactureLigneVentes();
                        var19.setFacligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                        var19.setFacligCondition("");
                        var19.setFacligComplement("");
                        var19.setFacligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                        var19.setFacligDescription("");
                        var19.setFacligDevise(this.factureEnteteVentes.getFacDevise());
                        var19.setFacligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                        var19.setFacligEchelle(0);
                        var19.setFacligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                        var19.setFacligGroupe(var18);
                        var19.setFacligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                        var19.setFacligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                        var19.setFacligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                        var19.setFacligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                        var19.setFacligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                        var19.setFacligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                        var19.setFacligOrdre(var8);
                        var19.setFacligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                        var19.setFacligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                        var19.setFacligPt(0.0D);
                        var19.setFacligPu(0.0D);
                        var19.setFacligPuRem(0.0D);
                        var19.setFacligPuRemTtc(0.0D);
                        var19.setFacligPuTtc(0.0D);
                        var19.setFacligPump(0.0D);
                        float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                        var19.setFacligQte(var9);
                        var19.setFacligQteUtil(var19.getFacligQte());
                        var19.setFacligRabais(0.0D);
                        var19.setFacligReference(var18);
                        var19.setFacligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                        var19.setFacligTauxRemise(0.0F);
                        var19.setFacligTauxTaxe(0.0F);
                        var19.setFacligTaxe("");
                        var19.setFacligTc(0.0D);
                        var19.setFacligTtc(0.0D);
                        var19.setFacligTva(0.0D);
                        var19.setFacligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                        var19.setFacligVolume(0.0F);
                        var19.setFactureEnteteVentes(this.factureEnteteVentes);
                        var19 = this.factureLigneVentesDao.insertLigne(var19, var1);
                        if (this.numLigne > this.lesLignesList.size()) {
                           this.numLigne = this.lesLignesList.size();
                        }

                        this.lesLignesList.add(this.numLigne + var8, var19);
                     }
                  }

                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               }

               this.cumulPrix();
               this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
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

      this.addLigne();
   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.factureLigneVentes.getFacligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.factureLigneVentes.getFacligCode();
            int var4 = this.factureLigneVentes.getFacligModeGroupe();
            String var5 = this.factureLigneVentes.getFacligGroupe();
            this.factureLigneVentesDao.deleteOneLigne(this.factureLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new FactureLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  FactureLigneVentes var6 = (FactureLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getFacligGroupe() != null && !var6.getFacligGroupe().isEmpty() && var6.getFacligGroupe().equals(var3)) {
                     this.factureLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " de la Facture N° " + this.factureEnteteVentes.getFacNum() + " du " + this.factureEnteteVentes.getFacDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.factureEnteteVentes.getFacNomTiers(), this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         boolean var2 = false;
         if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
            if (this.tiers.getTieserie().equals("X")) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.mesSerieUserItem.size(); ++var3) {
                  if (((SelectItem)this.mesSerieUserItem.get(var3)).getValue().toString().equals(this.tiers.getTieserie())) {
                     var2 = true;
                     this.factureEnteteVentes.setFacSerie(this.tiers.getTieserie());
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
            this.factureEnteteVentes.setTiers(this.tiers);
            if (this.tiers.getTiegenre() == null || this.tiers.getTiegenre().isEmpty() || !this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.factureEnteteVentes.setFacCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.factureEnteteVentes.setFacCivilTiers(this.factureEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.factureEnteteVentes.setFacNomTiers(this.nomTier);
            this.factureEnteteVentes.setFacTypeReg(this.tiers.getTietypereg());
            this.factureEnteteVentes.setFacModeReg(this.tiers.getTiemodereg());
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
               this.factureEnteteVentes.setFacNbJourReg(this.tiers.getTienbecheance());
               this.factureEnteteVentes.setFacArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.factureEnteteVentes.setFacTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.factureEnteteVentes.setFacModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.factureEnteteVentes.setFacNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.factureEnteteVentes.setFacArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.factureEnteteVentes.setFacJournalReg(this.tiers.getTiejournalreg());
            this.factureEnteteVentes.setFacCat(this.tiers.getTienomfamille());
            this.factureEnteteVentes.setFacExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.factureEnteteVentes.setFacExoDouane(1);
            }

            var9 = this.tiers.getTieexotva();
            if (var9 >= 2) {
               var9 = 0;
            }

            this.factureEnteteVentes.setFacExoTva(var9);
            if (this.var_tc_calcul) {
               this.factureEnteteVentes.setFacTauxTc(this.var_tc_taux);
            } else {
               this.factureEnteteVentes.setFacTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.factureEnteteVentes.setFacExoTva(1);
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

            if (this.tiers.getTiecategorie() != null && !this.tiers.getTiecategorie().isEmpty() && this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.factureEnteteVentes.setFacDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.factureEnteteVentes.setFacDiversTiers(0);
               this.factureEnteteVentes.setFacDiversNom("");
               this.factureEnteteVentes.setFacDiversAdresse("");
               this.factureEnteteVentes.setFacDiversVille("");
               this.factureEnteteVentes.setFacDiversTel("");
               this.factureEnteteVentes.setFacDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.factureEnteteVentes.setFacDevise(this.tiers.getTiedevise());
            } else {
               this.factureEnteteVentes.setFacDevise(this.structureLog.getStrdevise());
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

            if (this.typeVente == 804) {
               this.chargerServiceInterim(var1);
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
      if (this.tiers != null) {
         String var2 = "";
         if (this.tiers.getTiecomptebloque() == 1) {
            var2 = "***   COMPTE BLOQUE   ***";
         } else if (this.tiers.getTiechequeinterdit() == 1) {
            var2 = "***   CHEQUE INTERDIT   ***";
         }

         String var3 = "";
         if (this.tiers.getTieplafond() != 0.0D) {
            if (this.optionsVentes.getGestionPlafondFac().equals("1")) {
               this.plafondEnCours = this.tiers.getTieplafond();
               new ArrayList();
               String var5 = " tiers.tieid=" + this.tiers.getTieid() + " and fac_solde=0";
               double var6 = 0.0D;
               List var4 = this.factureEnteteVentesDao.rechercheFactureRequete(var5, var1);
               if (var4.size() != 0) {
                  for(int var8 = 0; var8 < var4.size(); ++var8) {
                     var6 += ((FactureEnteteVentes)var4.get(var8)).getFacTotTtc() - ((FactureEnteteVentes)var4.get(var8)).getFacTotReglement();
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
      this.factureEnteteVentes.setTiers(this.tiers);
      this.factureEnteteVentes.setFacNomTiers("");
      this.factureEnteteVentes.setFacCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      }

      this.mesAffairesItems.clear();
      this.mesServicesInterimItems.clear();
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
      if (!this.factureEnteteVentes.getFacNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.factureEnteteVentes.getFacCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.factureEnteteVentes.setFacExoTva(0);
      } else {
         this.factureEnteteVentes.setFacExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.factureEnteteVentes.setFacExoDouane(0);
      } else {
         this.factureEnteteVentes.setFacExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.factureEnteteVentes.setFacTauxTc(this.var_tc_taux);
      } else {
         this.factureEnteteVentes.setFacTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.factureLigneVentes = new FactureLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               if (this.factureEnteteVentes.getFacExoTva() == 1) {
                  this.factureLigneVentes.setFacligTaxe("");
                  this.factureLigneVentes.setFacligTauxTaxe(0.0F);
                  this.factureLigneVentes.setFacligTva(0.0D);
               } else if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.factureLigneVentes.setFacligTaxe("");
                        this.factureLigneVentes.setFacligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.factureLigneVentes.setFacligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.factureLigneVentes.setFacligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.factureLigneVentes.getFacligTaxe(), var1);
                        if (var5 != null) {
                           this.factureLigneVentes.setFacligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.factureLigneVentes.setFacligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.factureLigneVentes.setFacligTaxe(this.optionsVentes.getTvaDefaut());
                        this.factureLigneVentes.setFacligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.factureLigneVentes.setFacligTaxe("");
                        this.factureLigneVentes.setFacligTauxTaxe(0.0F);
                     }
                  } else {
                     this.factureLigneVentes.setFacligTaxe("");
                     this.factureLigneVentes.setFacligTauxTaxe(0.0F);
                  }

                  if ((this.factureLigneVentes.getFacligTaxe() == null || this.factureLigneVentes.getFacligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.factureLigneVentes.setFacligTaxe(var5.getTaxvteCode());
                        this.factureLigneVentes.setFacligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
            }
         }

         if (this.factureEnteteVentes.getFacExoTva() == 0) {
            this.factureEnteteVentes.setFacMotifExo("");
            this.factureEnteteVentes.setFacNumVisa("");
            this.factureEnteteVentes.setFacDateVisa((Date)null);
            this.factureEnteteVentes.setFacRangeVisa("");
         }

         if (this.factureEnteteVentes.getFacId() != 0L) {
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.factureLigneVentes = new FactureLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               this.factureLigneVentes.setFacligTauxRemise(this.factureEnteteVentes.getFacTauxRemise());
               this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
            }
         }

         if (this.factureEnteteVentes.getFacId() != 0L) {
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
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

   public void calculeAcompteGlobal() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.factureLigneVentes = new FactureLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               this.factureLigneVentes.setFacligTauxRemise(this.factureEnteteVentes.getFacTauxAcompte());
               this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var1);
            }
         }

         if (this.factureEnteteVentes.getFacId() != 0L) {
            this.factureEnteteVentes.setFacTauxRemise(0.0F);
            this.cumulPrix();
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.factureEnteteVentes.getFacNomContact(), this.nature);
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
         this.factureEnteteVentes.setFacNomContact(this.plansAnalytiques.getAnaNomFr());
         this.factureEnteteVentes.setFacCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.factureEnteteVentes.setFacAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.factureEnteteVentes.setFacNomContact("");
      this.factureEnteteVentes.setFacCivilContact("");
      this.factureEnteteVentes.setFacAnal4("");
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
      if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && !this.factureLigneVentes.getFacligCode().equals("-") && !this.factureLigneVentes.getFacligCode().equals("=")) {
         if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.factureLigneVentes.getFacligCode(), this.nature, this.optionsVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.factureLigneVentes.getFacligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         this.factureLigneVentes.setFacligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.factureLigneVentes.setFacligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.factureLigneVentes.setFacligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.factureLigneVentes.setFacligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.factureLigneVentes.setFacligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.factureLigneVentes.setFacligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.factureLigneVentes.setFacligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.factureLigneVentes.setFacligFamille(this.produits.getProVteCode());
         this.factureLigneVentes.setFacligStock(this.produits.getProStock());
         this.factureLigneVentes.setFacligLong(this.produits.getProLongueur());
         this.factureLigneVentes.setFacligLarg(this.produits.getProLargeur());
         this.factureLigneVentes.setFacligHaut(this.produits.getProEpaisseur());
         this.factureLigneVentes.setFacligDiam(this.produits.getProDiamExt());
         this.factureLigneVentes.setFacligPoidsBrut(this.produits.getProPoidsBrut());
         this.factureLigneVentes.setFacligPoidsNet(this.produits.getProPoidsNet());
         this.factureLigneVentes.setFacligVolume(this.produits.getProVolume());
         this.factureLigneVentes.setFacligNb(this.produits.getProNbUnite());
         this.factureLigneVentes.setFacligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.factureLigneVentes.setFacligModeGroupe(this.produits.getProMode());
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
                  this.factureLigneVentes.setFacligTaxe(this.produits.getProVteTva());
                  this.factureLigneVentes.setFacligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.factureLigneVentes.setFacligTaxe("");
                  this.factureLigneVentes.setFacligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.factureLigneVentes.setFacligTaxe(var8.getFamvteTaxe());
                  this.factureLigneVentes.setFacligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.factureLigneVentes.setFacligTaxe("");
               this.factureLigneVentes.setFacligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.factureEnteteVentes.getFacExoTva() == 0 && (this.factureLigneVentes.getFacligTaxe() == null || this.factureLigneVentes.getFacligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.factureLigneVentes.setFacligTaxe(var9.getTaxvteCode());
                  this.factureLigneVentes.setFacligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.factureLigneVentes.setFacligTaxe("");
            this.factureLigneVentes.setFacligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.factureLigneVentes.getFacligTauxTaxe() / 100.0D;
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
               this.factureLigneVentes.setFacligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.factureLigneVentes.setFacligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.factureLigneVentes.setFacligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.factureLigneVentes.setFacligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.factureLigneVentes.setFacligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.factureLigneVentes.getFacligPump() != 0.0D) {
            this.factureLigneVentes.setFacligPu(this.factureLigneVentes.getFacligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
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
      if (this.factureLigneVentes.getFacligCode() == null || this.factureLigneVentes.getFacligCode().isEmpty() || this.factureLigneVentes.getFacligCode().length() < 2) {
         if (this.factureEnteteVentes.getFacExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.factureLigneVentes.setFacligTaxe(this.optionsVentes.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.factureLigneVentes.setFacligCode("");
      this.factureLigneVentes.setFacligLibelle("");
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
            var2 = this.factureLigneVentes.getFacligPuTtc();
         } else {
            var2 = this.factureLigneVentes.getFacligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
            this.factureLigneVentes.setFacligPuRemTtc(this.prixUnitaires);
         } else {
            this.factureLigneVentes.setFacligPu(this.prixUnitaires);
            this.factureLigneVentes.setFacligPuRem(this.prixUnitaires);
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
                     this.factureLigneVentes.setFacligTauxRemise(var6.getBarRemise());
                     this.factureLigneVentes.setFacligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.factureEnteteVentes.getFacDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
                        this.factureLigneVentes.setFacligPuRemTtc(var11);
                     } else {
                        this.factureLigneVentes.setFacligPu(this.prixUnitaires);
                        this.factureLigneVentes.setFacligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.factureLigneVentes.setFacligTauxRemise(var6.getBarRemise());
                     this.factureLigneVentes.setFacligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.factureLigneVentes.getFacligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
                        this.factureLigneVentes.setFacligPuRemTtc(var11);
                     } else {
                        this.factureLigneVentes.setFacligPu(this.prixUnitaires);
                        this.factureLigneVentes.setFacligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.factureLigneVentes.setFacligTauxRemise(var6.getBarRemise());
                     this.factureLigneVentes.setFacligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
                        this.factureLigneVentes.setFacligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.factureLigneVentes.setFacligPu(this.prixUnitaires);
                        this.factureLigneVentes.setFacligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
                     this.factureLigneVentes.setFacligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.factureLigneVentes.setFacligPu(this.prixUnitaires);
                     this.factureLigneVentes.setFacligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((FactureLigneVentes)this.lesLignesList.get(var9)).getFacligCode() == null || ((FactureLigneVentes)this.lesLignesList.get(var9)).getFacligCode().isEmpty() || !((FactureLigneVentes)this.lesLignesList.get(var9)).getFacligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((FactureLigneVentes)this.lesLignesList.get(var9)).getFacligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((FactureLigneVentes)this.lesLignesList.get(var8)).getFacligFamille() != null && !((FactureLigneVentes)this.lesLignesList.get(var8)).getFacligFamille().isEmpty() && ((FactureLigneVentes)this.lesLignesList.get(var8)).getFacligFamille().equals(var7)) {
                  var5 += ((FactureLigneVentes)this.lesLignesList.get(var8)).getFacligPt();
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
         double var2 = this.factureLigneVentes.getFacligPu();
         double var4 = this.factureLigneVentes.getFacligPuTtc();
         if (this.factureLigneVentes.getFacligPu() >= 0.0D && this.factureLigneVentes.getFacligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.factureEnteteVentes.getFacCat(), (String)null, var1);
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
                     if (this.factureLigneVentes.getFacligQte() >= var7.getQteDebut() && this.factureLigneVentes.getFacligQte() <= var7.getQteFin()) {
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
                        if (this.factureLigneVentes.getFacligQte() >= var7.getQteDebut() && this.factureLigneVentes.getFacligQte() <= var7.getQteFin()) {
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
            var2 = Math.abs(this.factureLigneVentes.getFacligPu());
            var4 = Math.abs(this.factureLigneVentes.getFacligPuTtc());
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
      this.factureLigneVentes.setFacligUnite(this.produitsDepot.getProdepUnite());
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
               if (this.factureEnteteVentes.getFacStock() == 1) {
                  if (this.structureLog.getStrstockNegatif() == 2) {
                     if (this.produitsDepot.getProdepQteStk() < this.factureLigneVentes.getFacligQte() && this.factureLigneVentes.getFacligQte() != 0.0F) {
                        this.validationLigne = 2;
                        this.messageStockNegatif = "Quantité demandée : " + this.factureLigneVentes.getFacligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                     } else {
                        this.validationLigne = 0;
                     }
                  } else if (this.structureLog.getStrstockNegatif() == 1) {
                     if (this.produitsDepot.getProdepQteStk() < this.factureLigneVentes.getFacligQte() && this.factureLigneVentes.getFacligQte() != 0.0F) {
                        this.validationLigne = 1;
                        this.messageStockNegatif = "Quantité demandée : " + this.factureLigneVentes.getFacligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                     } else {
                        this.validationLigne = 0;
                     }
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
         if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && this.factureLigneVentes.getFacligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.factureLigneVentes.getFacligEchelle());
            float var5 = 1.0F;
            if (this.factureLigneVentes.getFacligCondition().contains("/")) {
               String[] var6 = this.factureLigneVentes.getFacligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && !this.factureLigneVentes.getFacligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.factureLigneVentes.getFacligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.factureLigneVentes.setFacligPump(var9);
      } else {
         this.factureLigneVentes.setFacligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.factureLigneVentes.getFacligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.factureLigneVentes.setFacligEchelle(this.unite.getUniEchelle());
               } else {
                  this.factureLigneVentes.setFacligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.factureLigneVentes.setFacligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.factureLigneVentes.setFacligEchelle(Integer.parseInt(var2));
         } else {
            this.factureLigneVentes.setFacligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.factureLigneVentes.getFacligLong(), this.factureLigneVentes.getFacligLarg(), this.factureLigneVentes.getFacligHaut(), this.factureLigneVentes.getFacligDiam(), this.factureLigneVentes.getFacligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.factureLigneVentes.getFacligLong(), this.factureLigneVentes.getFacligLarg(), this.factureLigneVentes.getFacligHaut(), this.factureLigneVentes.getFacligDiam(), this.factureLigneVentes.getFacligNb(), this.baseLog, var1);
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
      if (Math.abs(this.montantElmTotBonEnc) <= Math.abs(this.factureEnteteVentes.getFacTotTtc() - this.var_tot_bon_encaissement)) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.tiers.getTiedepotavance()) {
         this.montantElmTotBonEnc = this.tiers.getTiedepotavance();
      }

   }

   public void verifBonEncaissementMultiple() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc;
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

      this.var_serie_trf = this.factureEnteteVentes.getFacSerie();
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      File var2;
      String[] var3;
      int var4;
      String var5;
      if (this.var_type_trf == 26 && this.optionsVentes.getModeAvoir().equals("0")) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.modeleTrfItems.add(new SelectItem(var5));
               }
            }
         }
      } else if (this.var_type_trf == 25 && this.optionsVentes.getModeAvoir().equals("1")) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.modeleTrfItems.add(new SelectItem(var5));
               }
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
      this.var_imput_serie = this.factureEnteteVentes.getFacSerie();
      this.var_imput_cat = this.factureEnteteVentes.getFacCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new FactureEnteteVentes();
         FactureEnteteVentes var1 = this.factureEnteteVentesDao.pourParapheur(this.var_imput_num, this.factureEnteteVentes.getFacSerie(), (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.factureEnteteVentes.getFacNum();
               this.factureEnteteVentes.setFacNum(this.var_imput_num);
               this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
               if (this.factureEnteteVentes.getFacTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.factureEnteteVentes.getFacId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.factureEnteteVentes.getFacNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.factureEnteteVentes.getFacId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.factureEnteteVentes.getFacNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Facture N° " + var3 + " en Facture N° " + this.factureEnteteVentes.getFacNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.factureEnteteVentes.getFacNum();
            this.factureEnteteVentes.setFacSerie(this.var_imput_serie);
            this.factureEnteteVentes.setFacCat(this.var_imput_cat);
            this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var1));
            this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
            if (this.factureEnteteVentes.getFacTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.factureEnteteVentes.getFacId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.factureEnteteVentes.getFacNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.factureEnteteVentes.getFacId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.factureEnteteVentes.getFacNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Facture X N° " + var3 + " en Facture " + this.factureEnteteVentes.getFacSerie() + " N° " + this.factureEnteteVentes.getFacNum());
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
         new FactureLigneVentes();

         for(int var3 = 0; var3 < this.documentDetailTrf.size(); ++var3) {
            FactureLigneVentes var2 = (FactureLigneVentes)this.documentDetailTrf.get(var3);
            long var4 = var2.getFacligId();
            float var6 = var2.getFacligQte();
            float var7 = 0.0F;
            if (this.var_type_trf == 26 && this.optionsVentes.getModeAvoir().equals("0")) {
               AvoirLigneVentesDao var8 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var7 = var8.chargerLesReliquatsFactureVtes(var4, var1);
            } else if (this.var_type_trf == 25 && this.optionsVentes.getModeAvoir().equals("1")) {
               var7 = this.factureLigneVentesDao.chargerLesReliquatsFacturesNegativesVtes(var4, var1);
            }

            float var11 = var6 - var7;
            if (var11 < 0.0F) {
               var11 = 0.0F;
            }

            var2.setVar_qteDejaTrf(var7);
            var2.setVar_qteReliquat(var11);
            double var9 = 0.0D;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               var9 = var2.getFacligPuRemTtc() * (double)var2.getVar_qteReliquat();
            } else {
               var9 = var2.getFacligPuRem() * (double)var2.getVar_qteReliquat();
            }

            var2.setVar_totalTrf(var9);
            var2 = (FactureLigneVentes)this.documentDetailTrf.set(var3, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         this.calculMontantTrf();
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         new FactureLigneVentes();

         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            FactureLigneVentes var1 = (FactureLigneVentes)this.documentDetailTrf.get(var2);
            var1.setVar_qteReliquat(0.0F);
            var1.setVar_totalTrf(0.0D);
            var1 = (FactureLigneVentes)this.documentDetailTrf.set(var2, var1);
         }

         this.calculMontantTrf();
         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void fusionnerDocument() throws NamingException, Exception {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      long var3 = 0L;
      String var5 = "";
      int var6 = 0;

      for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
         if (((FactureEnteteVentes)this.lesEntetesList.get(var7)).isVar_select_ligne()) {
            if (((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacEtat() == 1 && ((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacDateTransfert() == null) {
               if (var3 == 0L) {
                  var3 = ((FactureEnteteVentes)this.lesEntetesList.get(var7)).getTiers().getTieid();
               }

               if (var5 == null || var5.isEmpty()) {
                  var5 = ((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacSerie();
               }

               if (((FactureEnteteVentes)this.lesEntetesList.get(var7)).getTiers().getTieid() == var3 && ((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacSerie() != null && !((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacSerie().isEmpty() && var5 != null && !var5.isEmpty() && ((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacSerie().equals(var5)) {
                  var1.add(this.lesEntetesList.get(var7));
                  var2.add(((FactureEnteteVentes)this.lesEntetesList.get(var7)).getFacNum());
                  ++var6;
               }
            } else {
               ((FactureEnteteVentes)this.lesEntetesList.get(var7)).setVar_select_ligne(false);
            }
         }
      }

      if (var1.size() != 0 && var6 >= 1) {
         Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         Transaction var8 = null;

         try {
            var8 = var21.beginTransaction();
            this.factureEnteteVentes = (FactureEnteteVentes)var1.get(0);
            this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.factureEnteteVentes.setUsers(this.usersLog);
            this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.factureEnteteVentes.setFacDate(new Date());
            this.factureEnteteVentes.setFacDateCreat(new Date());
            this.factureEnteteVentes.setFacDateModif((Date)null);
            this.factureEnteteVentes.setFacIdModif(0L);
            this.factureEnteteVentes.setFacNomModif("");
            this.factureEnteteVentes.setFacNum("");
            this.factureEnteteVentes.setFacIdResponsable(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.factureEnteteVentes.setFacDateLivraison((Date)null);
            if (!this.factureEnteteVentes.getFacSerie().equalsIgnoreCase("X") && !this.factureEnteteVentes.getFacSerie().isEmpty()) {
               this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.factureEnteteVentes.getFacSerie(), var21));
            } else {
               long var9 = this.factureEnteteVentesDao.selectLastNum(var21);
               this.factureEnteteVentes.setFacNum("" + var9);
            }

            this.verifieExistenceHabilitation(var21);
            this.factureEnteteVentes.setFacDateAnnule((Date)null);
            this.factureEnteteVentes.setFacMotifAnnule("");
            this.factureEnteteVentes.setFacDateImp((Date)null);
            this.factureEnteteVentes.setFacDateTransforme((Date)null);
            this.factureEnteteVentes.setFacEtat(0);
            this.factureEnteteVentes.setFacDateTransfert((Date)null);
            this.factureEnteteVentes = this.factureEnteteVentesDao.duppliquer(this.factureEnteteVentes, this.factureEnteteVentes, var21);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureEnteteVentes.getFacId(), this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacNomTiers(), this.factureEnteteVentes.getFacDate(), this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), this.factureEnteteVentes.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var21), this.factureEnteteVentes.getVar_format_devise(), 0, var21);
            }

            this.lesLignesList.clear();
            Object var22 = new ArrayList();
            int var10 = 0;

            int var11;
            for(var11 = 0; var11 < var2.size(); ++var11) {
               String var12 = ((String)var2.get(var11)).toString();
               new FactureEnteteVentes();
               FactureEnteteVentes var13 = this.factureEnteteVentesDao.pourParapheur(var12, var21);
               if (var13 != null) {
                  ((List)var22).clear();
                  var22 = this.factureLigneVentesDao.chargerLesLignes(var13, var21);
                  if (((List)var22).size() != 0) {
                     FactureLigneVentes var14 = new FactureLigneVentes();
                     ++var10;
                     var14.setFacligOrdre(var10);
                     var14.setFacligLibelle("---> Suivant Facture N° " + var12);
                     this.lesLignesList.add(var14);

                     for(int var15 = 0; var15 < ((List)var22).size(); ++var15) {
                        ++var10;
                        var14 = (FactureLigneVentes)((List)var22).get(var15);
                        var14.setFacligOrdre(var10);
                        this.lesLignesList.add(var14);
                     }
                  }

                  var13.setFacEtat(8);
                  var13 = this.factureEnteteVentesDao.modif(var13, var21);
                  this.documentTraceVentes = new DocumentTraceVentes();
                  this.documentTraceVentes.setDoctraDateCreat(new Date());
                  this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
                  this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
                  this.documentTraceVentes.setExerciceventes(var13.getExerciceventes());
                  this.documentTraceVentes.setDoctraOrgType(this.nature);
                  this.documentTraceVentes.setDoctraOrgSerie(var13.getFacSerie());
                  this.documentTraceVentes.setDoctraOrgId(var13.getFacId());
                  this.documentTraceVentes.setDoctraOrgNum(var13.getFacNum());
                  this.documentTraceVentes.setDoctraOrgDate(var13.getFacDate());
                  this.documentTraceVentes.setDoctraDstType(this.nature);
                  this.documentTraceVentes.setDoctraDstSerie(this.factureEnteteVentes.getFacSerie());
                  this.documentTraceVentes.setDoctraDstId(this.factureEnteteVentes.getFacId());
                  this.documentTraceVentes.setDoctraDstNum(this.factureEnteteVentes.getFacNum());
                  this.documentTraceVentes.setDoctraDstDate(this.factureEnteteVentes.getFacDate());
                  this.documentTraceVentesDao.insert(this.documentTraceVentes, var21);
               }
            }

            if (this.lesLignesList.size() != 0) {
               this.factureLigneVentesDao.duppliquerLigne(this.lesLignesList, this.factureEnteteVentes, 0.0F, this.factureEnteteVentes.getFacDevise(), var21);
            }

            this.cumulPrix();
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var21);
            var11 = 0;

            while(true) {
               if (var11 >= this.lesEntetesList.size()) {
                  var8.commit();
                  break;
               }

               if (((FactureEnteteVentes)this.lesEntetesList.get(var11)).isVar_select_ligne()) {
                  this.lesEntetesList.remove(var11);
                  --var11;
               }

               ++var11;
            }
         } catch (HibernateException var19) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete();
      } else {
         this.messageStockNegatif = "Il n'y a pas assez de factures sélectionnées (>= 1)";
         this.formRecherche.setMessageTexte(this.messageStockNegatif);
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;

         for(int var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
            var3 += ((FactureLigneVentes)this.documentDetailTrf.get(var5)).getFacligQte();
            var2 += ((FactureLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((FactureLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         int var7;
         if (var3 == var2) {
            new FactureEnteteVentes();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               FactureEnteteVentes var6 = (FactureEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setFacEtat(5);
                  this.factureEnteteVentesDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            FactureEnteteVentes var12;
            if (this.var_mode_trf.equals("0")) {
               for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
                  new FactureEnteteVentes();
                  var12 = (FactureEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getFacNum().equalsIgnoreCase(((FactureEnteteVentes)var1.get(var9)).getFacNum())) {
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
                  new FactureEnteteVentes();
                  var12 = (FactureEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getTiers().getTieid() == ((FactureEnteteVentes)var1.get(var9)).getTiers().getTieid()) {
                           if (var12.getFacSerie().equalsIgnoreCase(((FactureEnteteVentes)var1.get(var9)).getFacSerie())) {
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
                  this.factureEnteteVentes = (FactureEnteteVentes)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((FactureEnteteVentes)var1.get(var11)).getFacNum().equalsIgnoreCase(((FactureLigneVentes)this.documentDetailTrf.get(var7)).getFactureEnteteVentes().getFacNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((FactureEnteteVentes)var1.get(var11)).getTiers().getTieid() == ((FactureLigneVentes)this.documentDetailTrf.get(var7)).getFactureEnteteVentes().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0) {
                     this.utilParapheur.supprimerParapheur(this.factureEnteteVentes.getFacId(), this.nature, (Session)null);
                     if (this.var_type_trf == 26 && this.optionsVentes.getModeAvoir().equals("0")) {
                        this.trfAvoir();
                     } else if (this.var_type_trf == 25 && this.optionsVentes.getModeAvoir().equals("1")) {
                        this.trfFactureNegative();
                     }
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
               this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var11);
               if (this.factureEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.factureEnteteVentes);
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

   public void trfAvoir() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         AvoirEnteteVentes var3 = new AvoirEnteteVentes();
         AvoirEnteteVentesDao var4 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         AvoirLigneVentesDao var5 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setAvrSerie(this.var_serie_trf);
         } else {
            var3.setAvrSerie(this.factureEnteteVentes.getFacSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setAvrIdCreateur(this.usersLog.getUsrid());
         var3.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setAvrDate(this.utilDate.dateToSQLLight(this.factureEnteteVentes.getFacDate()));
         } else {
            var3.setAvrDate(this.var_date_trf);
         }

         var3.setAvrDate(this.utilDate.dateToSQL(var3.getAvrDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setAvrDateCreat(new Date());
         var3.setAvrDateModif((Date)null);
         var3.setAvrIdModif(0L);
         var3.setAvrNomModif("");
         var3.setAvrNum("");
         boolean var7 = false;
         int var36;
         if (this.optionsVentes.getNbrJrRelanceAVOIR() != null && !this.optionsVentes.getNbrJrRelanceAVOIR().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceAVOIR());
         } else {
            var36 = 0;
         }

         boolean var8 = false;
         int var37;
         if (this.optionsVentes.getNbrJrValidAVOIR() != null && !this.optionsVentes.getNbrJrValidAVOIR().isEmpty()) {
            var37 = Integer.parseInt(this.optionsVentes.getNbrJrValidAVOIR());
         } else {
            var37 = 0;
         }

         var3.setAvrDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var3.setAvrDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var37));
         var3.setAvrService(this.factureEnteteVentes.getFacService());
         if (!var3.getAvrSerie().equalsIgnoreCase("X") && !var3.getAvrSerie().isEmpty()) {
            var3.setAvrNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.var_type_trf, var3.getAvrSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setAvrNum("" + var9);
         }

         this.verifieExistenceHabilitationAvoir(var3, var1);
         var3.setAvrSource(this.factureEnteteVentes.getFacSource());
         var3.setAvrNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
         var3.setAvrIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
         var3.setAvrNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
         var3.setAvrIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
         var3.setAvrNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
         var3.setAvrIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
         var3.setAvrNomTiers(this.factureEnteteVentes.getFacNomTiers());
         var3.setAvrCivilTiers(this.factureEnteteVentes.getFacCivilTiers());
         var3.setAvrTiersRegroupe(this.factureEnteteVentes.getFacTiersRegroupe());
         var3.setAvrIdContact(this.factureEnteteVentes.getFacIdContact());
         var3.setAvrNomContact(this.factureEnteteVentes.getFacNomContact());
         var3.setAvrCivilContact(this.factureEnteteVentes.getFacCivilContact());
         var3.setAvrDiversAdresse(this.factureEnteteVentes.getFacDiversAdresse());
         var3.setAvrDiversMail(this.factureEnteteVentes.getFacDiversMail());
         var3.setAvrDiversNom(this.factureEnteteVentes.getFacDiversNom());
         var3.setAvrDiversTel(this.factureEnteteVentes.getFacDiversTel());
         var3.setAvrDiversTiers(this.factureEnteteVentes.getFacDiversTiers());
         var3.setAvrDiversVille(this.factureEnteteVentes.getFacDiversVille());
         var3.setAvrExoTva(this.factureEnteteVentes.getFacExoTva());
         var3.setAvrExoDouane(this.factureEnteteVentes.getFacExoDouane());
         var3.setAvrJournalReg(this.factureEnteteVentes.getFacJournalReg());
         var3.setAvrCat(this.factureEnteteVentes.getFacCat());
         var3.setAvrDevise(this.factureEnteteVentes.getFacDevise());
         var3.setAvrObject(this.factureEnteteVentes.getFacObject());
         var3.setAvrObservation(this.factureEnteteVentes.getFacObservation());
         var3.setAvrTauxRemise(this.factureEnteteVentes.getFacTauxRemise());
         var3.setAvrTotHt(0.0D);
         var3.setAvrTotRemise(0.0D);
         var3.setAvrTotRabais(0.0D);
         var3.setAvrTotTva(0.0D);
         var3.setAvrTotTc(0.0D);
         var3.setAvrTotTtc(0.0D);
         var3.setAvrTotReglement(0.0D);
         var3.setAvrSolde(0);
         var3.setAvrBanque(this.factureEnteteVentes.getFacBanque());
         var3.setAvrTypeReg(this.factureEnteteVentes.getFacTypeReg());
         var3.setAvrModeReg(this.factureEnteteVentes.getFacModeReg());
         var3.setAvrNbJourReg(this.factureEnteteVentes.getFacNbJourReg());
         var3.setAvrArrondiReg(this.factureEnteteVentes.getFacArrondiReg());
         var3.setAvrConditionReg(this.factureEnteteVentes.getFacConditionReg());
         var3.setAvrDateEcheReg(this.factureEnteteVentes.getFacDateEcheReg());
         var3.setAvrContener(this.factureEnteteVentes.getFacContener());
         var3.setAvrActivite(this.factureEnteteVentes.getFacActivite());
         var3.setAvrSite(this.factureEnteteVentes.getFacSite());
         var3.setAvrDepartement(this.factureEnteteVentes.getFacDepartement());
         var3.setAvrRegion(this.factureEnteteVentes.getFacRegion());
         var3.setAvrSecteur(this.factureEnteteVentes.getFacSecteur());
         var3.setAvrPdv(this.factureEnteteVentes.getFacPdv());
         var3.setAvrAnal2(this.factureEnteteVentes.getFacAnal2());
         var3.setAvrAnal4(this.factureEnteteVentes.getFacAnal4());
         var3.setAvrAffaire(this.factureEnteteVentes.getFacAffaire());
         var3.setAvrInfo1(this.factureEnteteVentes.getFacInfo1());
         var3.setAvrInfo2(this.factureEnteteVentes.getFacInfo2());
         var3.setAvrInfo3(this.factureEnteteVentes.getFacInfo3());
         var3.setAvrInfo4(this.factureEnteteVentes.getFacInfo4());
         var3.setAvrInfo5(this.factureEnteteVentes.getFacInfo5());
         var3.setAvrInfo6(this.factureEnteteVentes.getFacInfo6());
         var3.setAvrInfo7(this.factureEnteteVentes.getFacInfo7());
         var3.setAvrInfo8(this.factureEnteteVentes.getFacInfo8());
         var3.setAvrInfo9(this.factureEnteteVentes.getFacInfo9());
         var3.setAvrInfo10(this.factureEnteteVentes.getFacInfo10());
         var3.setAvrFormule1(this.factureEnteteVentes.getFacFormule1());
         var3.setAvrFormule2(this.factureEnteteVentes.getFacFormule2());
         var3.setAvrAnnexe1(this.factureEnteteVentes.getFacAnnexe1());
         var3.setAvrAnnexe2(this.factureEnteteVentes.getFacAnnexe2());
         var3.setAvrContrat(this.factureEnteteVentes.getFacContrat());
         var3.setAvrIncoterm(this.factureEnteteVentes.getFacIncoterm());
         var3.setAvrLieuLivraison(this.factureEnteteVentes.getFacLieuLivraison());
         var3.setAvrDateLivraison(this.factureEnteteVentes.getFacDateLivraison());
         var3.setAvrInfoLivraison(this.factureEnteteVentes.getFacInfoLivraison());
         var3.setAvrDateImp((Date)null);
         var3.setAvrModeleImp(this.var_modele_trf);
         var3.setAvrGarde(this.factureEnteteVentes.getFacGarde());
         var3.setAvrGele(0);
         var3.setAvrEtat(0);
         var3.setAvrDateTransforme((Date)null);
         var3.setAvrTypeTransforme(0);
         var3.setAvrDateAnnule((Date)null);
         var3.setAvrMotifAnnule("");
         var3.setAvrNumFacture(this.factureEnteteVentes.getFacNum());
         var3.setAvrFactorNom(this.factureEnteteVentes.getFacFactorNom());
         var3.setAvrFactorId(this.factureEnteteVentes.getFacFactorId());
         var3.setAvrFactorEtat(this.factureEnteteVentes.getFacFactorEtat());
         var3.setAvrNumClient(this.factureEnteteVentes.getFacNumClient());
         var3.setAvrDateClient(this.factureEnteteVentes.getFacDateClient());
         var3.setExerciceventes(this.factureEnteteVentes.getExerciceventes());
         var3.setTiers(this.factureEnteteVentes.getTiers());
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
            for(int var26 = 0; var26 < this.lesLignesList.size(); ++var26) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var26);
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var24 == null || var24.isEmpty() || !var24.equals(this.factureLigneVentes.getFactureEnteteVentes().getFacNum())) {
                        var24 = this.factureLigneVentes.getFactureEnteteVentes().getFacNum();
                        ++var25;
                        AvoirLigneVentes var39 = new AvoirLigneVentes();
                        var39.setAvrligCode("-");
                        var39.setAvrligLibelle("---> Suivant facture N° " + var24);
                        var39.setAvoirEnteteVentes(var3);
                        var6.add(var39);
                     }
                  } else if (var26 == 0) {
                     var24 = "";
                     String var27 = "";
                     int var28 = 0;

                     while(true) {
                        if (var28 >= this.lesLignesList.size()) {
                           ++var25;
                           AvoirLigneVentes var41 = new AvoirLigneVentes();
                           var41.setAvrligCode("-");
                           var41.setAvrligLibelle("---> Suivant facture N° " + var27);
                           var41.setAvoirEnteteVentes(var3);
                           var6.add(var41);
                           break;
                        }

                        if (var24 == null || var24.isEmpty() || !var24.equals(this.factureLigneVentes.getFactureEnteteVentes().getFacNum())) {
                           var24 = this.factureLigneVentes.getFactureEnteteVentes().getFacNum();
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

               if ((this.factureLigneVentes.getFacligLibelle() != null && !this.factureLigneVentes.getFacligLibelle().isEmpty() || this.factureLigneVentes.getFacligComplement() != null && !this.factureLigneVentes.getFacligComplement().isEmpty()) && this.factureLigneVentes.getVar_qteReliquat() != 0.0F) {
                  if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var1);
                     if (this.produits != null && this.factureLigneVentes.getFacligDepot() != null && !this.factureLigneVentes.getFacligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligDepot(), var1);
                     }
                  }

                  float var40 = this.factureLigneVentes.getFacligQte();
                  float var42 = this.factureLigneVentes.getFacligQteUtil();
                  ++var25;
                  AvoirLigneVentes var29 = new AvoirLigneVentes();
                  var38 += this.factureLigneVentes.getFacligQte();
                  var10 += this.factureLigneVentes.getVar_qteDejaTrf();
                  String[] var30;
                  if (((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var29.setAvrligOrdre(var25);
                     var29.setAvrligCode(this.factureLigneVentes.getFacligCode());
                     var29.setAvrligGroupe(this.factureLigneVentes.getFacligGroupe());
                     var29.setAvrligModeGroupe(this.factureLigneVentes.getFacligModeGroupe());
                     var29.setAvrligDevise(this.factureLigneVentes.getFacligDevise());
                     var29.setAvrligFamille(this.factureLigneVentes.getFacligFamille());
                     var29.setAvrligIdFac(this.factureLigneVentes.getFacligId());
                     var29.setAvrligLibelle(this.factureLigneVentes.getFacligLibelle());
                     var29.setAvrligComplement(this.factureLigneVentes.getFacligComplement());
                     if (((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                        var30 = ((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                        var29.setAvrligDepot(var30[0]);
                     } else {
                        var29.setAvrligDepot("");
                     }

                     var29.setAvrligEchelle(this.factureLigneVentes.getFacligEchelle());
                     var29.setAvrligUnite(this.factureLigneVentes.getFacligUnite());
                     var29.setAvrligReference(this.factureLigneVentes.getFacligReference());
                     var29.setAvrligPump(this.factureLigneVentes.getFacligPump());
                     var29.setAvrligPu(this.factureLigneVentes.getFacligPu());
                     var29.setAvrligPuTtc(this.factureLigneVentes.getFacligPuTtc());
                     var29.setAvrligTauxRemise(this.factureLigneVentes.getFacligTauxRemise());
                     var29.setAvrligPuRem(this.factureLigneVentes.getFacligPuRem());
                     var29.setAvrligPuRemTtc(this.factureLigneVentes.getFacligPuRemTtc());
                     this.factureLigneVentes.setFacligQte(((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
                     var29.setAvrligQte(((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var29.setAvrligLong(this.factureLigneVentes.getFacligLong());
                     var29.setAvrligLarg(this.factureLigneVentes.getFacligLarg());
                     var29.setAvrligHaut(this.factureLigneVentes.getFacligHaut());
                     var29.setAvrligDiam(this.factureLigneVentes.getFacligDiam());
                     var29.setAvrligPoidsBrut(this.factureLigneVentes.getFacligPoidsBrut());
                     var29.setAvrligPoidsNet(this.factureLigneVentes.getFacligPoidsNet());
                     var29.setAvrligVolume(this.factureLigneVentes.getFacligVolume());
                     var29.setAvrligNb(this.factureLigneVentes.getFacligNb());
                     var29.setAvrligQteStock(0.0F);
                     var29.setAvrligRabais(this.factureLigneVentes.getFacligRabais());
                     var29.setAvrligTauxTaxe(this.factureLigneVentes.getFacligTauxTaxe());
                     var29.setAvrligTaxe(this.factureLigneVentes.getFacligTaxe());
                     var29.setAvrligPt(this.factureLigneVentes.getFacligPt());
                     var29.setAvrligTva(this.factureLigneVentes.getFacligTva());
                     var29.setAvrligTtc(this.factureLigneVentes.getFacligTtc());
                     var29.setAvrligTc(this.factureLigneVentes.getFacligTc());
                     var29.setAvoirEnteteVentes(var3);
                     var11 += ((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var29);
                     var12 += var29.getAvrligPt();
                     var14 += (var29.getAvrligPu() - var29.getAvrligPuRem()) * (double)var29.getAvrligQte();
                     var16 += var29.getAvrligRabais();
                     var18 += var29.getAvrligTva();
                     var20 += var29.getAvrligTtc();
                     var22 += var29.getAvrligTc();
                     this.factureLigneVentes.setFacligQte(var40);
                     this.factureLigneVentes.setFacligQteUtil(var42);
                  } else {
                     var29 = new AvoirLigneVentes();
                     var29.setAvrligOrdre(var25);
                     var29.setAvrligCode(this.factureLigneVentes.getFacligCode());
                     var29.setAvrligGroupe(this.factureLigneVentes.getFacligGroupe());
                     var29.setAvrligModeGroupe(this.factureLigneVentes.getFacligModeGroupe());
                     var29.setAvrligDevise(this.factureLigneVentes.getFacligDevise());
                     var29.setAvrligFamille(this.factureLigneVentes.getFacligFamille());
                     var29.setAvrligIdFac(this.factureLigneVentes.getFacligId());
                     var29.setAvrligLibelle(this.factureLigneVentes.getFacligLibelle());
                     var29.setAvrligComplement(this.factureLigneVentes.getFacligComplement());
                     if (((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                        var30 = ((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                        var29.setAvrligDepot(var30[0]);
                     } else {
                        var29.setAvrligDepot("");
                     }

                     var29.setAvrligEchelle(this.factureLigneVentes.getFacligEchelle());
                     var29.setAvrligUnite(this.factureLigneVentes.getFacligUnite());
                     var29.setAvrligReference(this.factureLigneVentes.getFacligReference());
                     var29.setAvrligPump(this.factureLigneVentes.getFacligPump());
                     var29.setAvrligPu(this.factureLigneVentes.getFacligPu());
                     var29.setAvrligPuTtc(this.factureLigneVentes.getFacligPuTtc());
                     var29.setAvrligTauxRemise(this.factureLigneVentes.getFacligTauxRemise());
                     var29.setAvrligPuRem(this.factureLigneVentes.getFacligPuRem());
                     var29.setAvrligPuRemTtc(this.factureLigneVentes.getFacligPuRemTtc());
                     this.factureLigneVentes.setFacligQte(0.0F);
                     this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
                     var29.setAvrligQte(((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var29.setAvrligLong(this.factureLigneVentes.getFacligLong());
                     var29.setAvrligLarg(this.factureLigneVentes.getFacligLarg());
                     var29.setAvrligHaut(this.factureLigneVentes.getFacligHaut());
                     var29.setAvrligDiam(this.factureLigneVentes.getFacligDiam());
                     var29.setAvrligPoidsBrut(this.factureLigneVentes.getFacligPoidsBrut());
                     var29.setAvrligPoidsNet(this.factureLigneVentes.getFacligPoidsNet());
                     var29.setAvrligVolume(this.factureLigneVentes.getFacligVolume());
                     var29.setAvrligNb(this.factureLigneVentes.getFacligNb());
                     var29.setAvrligQteStock(0.0F);
                     var29.setAvrligRabais(this.factureLigneVentes.getFacligRabais());
                     var29.setAvrligTauxTaxe(this.factureLigneVentes.getFacligTauxTaxe());
                     var29.setAvrligTaxe(this.factureLigneVentes.getFacligTaxe());
                     var29.setAvrligPt(this.factureLigneVentes.getFacligPt());
                     var29.setAvrligTva(this.factureLigneVentes.getFacligTva());
                     var29.setAvrligTtc(this.factureLigneVentes.getFacligTtc());
                     var29.setAvrligTc(this.factureLigneVentes.getFacligTc());
                     var29.setAvoirEnteteVentes(var3);
                     var11 += ((FactureLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var29);
                     var12 += var29.getAvrligPt();
                     var14 += (var29.getAvrligPu() - var29.getAvrligPuRem()) * (double)var29.getAvrligQte();
                     var16 += var29.getAvrligRabais();
                     var18 += var29.getAvrligTva();
                     var20 += var29.getAvrligTtc();
                     var22 += var29.getAvrligTc();
                     this.factureLigneVentes.setFacligQte(var40);
                     this.factureLigneVentes.setFacligQteUtil(var42);
                  }
               }
            }

            var3.setAvrTotHt(var12);
            var3.setAvrTotRemise(var14);
            var3.setAvrTotRabais(var16);
            var3.setAvrTotTva(var18);
            var3.setAvrTotTc(var22);
            var3.setAvrTotTtc(var20);
            var3 = var4.modif(var3, var1);
            if (var6.size() != 0) {
               var5.saveLigne(var6, var3, var1);
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationAvoir(var3, var1), var3.getAvrId(), var3.getAvrNum(), var3.getAvrNum(), var3.getAvrDate(), var3.getAvrDevise(), var3.getAvrTotTtc() + var3.getAvrTotTc(), var3.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 26), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFAVR(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.factureEnteteVentes.getExerciceventes());
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.factureEnteteVentes.getFacSerie());
         this.documentTraceVentes.setDoctraOrgId(this.factureEnteteVentes.getFacId());
         this.documentTraceVentes.setDoctraOrgNum(this.factureEnteteVentes.getFacNum());
         this.documentTraceVentes.setDoctraOrgDate(this.factureEnteteVentes.getFacDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getAvrSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getAvrId());
         this.documentTraceVentes.setDoctraDstNum(var3.getAvrNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getAvrDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         var3.setAvrEtat(0);
         var3.setAvrDateTransforme(new Date());
         var3.setAvrTypeTransforme(this.var_type_trf);
         var3.setAvrTotReglement(var3.getAvrTotTtc());
         var3.setAvrSolde(1);
         var3 = var4.modif(var3, var1);
         var4.modif(var3, var1);
         this.miseajourPayeAvoir(var3, var1);
         this.factureEnteteVentes.setFacNumAvoir(var3.getAvrNum());
         this.factureEnteteVentes.setFacTotReglement(this.factureEnteteVentes.getFacTotReglement() + var3.getAvrTotHt());
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
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

   public void miseajourPayeAvoir(AvoirEnteteVentes var1, Session var2) throws HibernateException, NamingException, ParseException {
      double var3 = var1.getAvrTotTtc() - var1.getAvrTotReglement();
      double var5 = 0.0D;
      double var7 = 0.0D;
      if (this.var_date == null) {
         this.var_date = new Date();
      }

      if (this.factureEnteteVentes != null) {
         new ExercicesCaisse();
         ExercicesCaisseDao var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         ExercicesCaisse var9 = var10.recupererLastExo(var2);
         if (var9 != null && var9.getExecaiId() != 0L) {
            String var11 = this.calculChrono.numCompose(this.var_date, 29, this.factureEnteteVentes.getFacSerie(), var2);
            this.reglements = new Reglements();
            this.reglements.setRglActivite(this.factureEnteteVentes.getFacActivite());
            this.reglements.setRglBanqueTireur("");
            this.reglements.setRglBudget(this.factureEnteteVentes.getFacBudget());
            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            this.reglements.setRglCodeCaiss("");
            this.reglements.setRglLibCaiss("");
            this.reglements.setRglCodeEmetrice("");
            this.reglements.setRglLibEmetrice("");
            this.reglements.setRglCodeReceptrice("");
            this.reglements.setRglLibReceptrice("");
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateReg(this.var_date);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepartement(this.factureEnteteVentes.getFacDepartement());
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDevise(this.factureEnteteVentes.getFacDevise());
            this.reglements.setRglDossier("");
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglDocument(this.factureEnteteVentes.getFacNum());
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(this.factureEnteteVentes.getFacId());
            this.reglements.setRglIdTiers(this.factureEnteteVentes.getTiers().getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglLibelle("Compense Avoir N° " + var1.getAvrNum());
            this.reglements.setRglLibTypReg("Compense");
            this.reglements.setRglMode("Compense");
            this.reglements.setRglModele("");
            this.reglements.setRglNumChqBdx("");
            this.reglements.setRglNatureDoc(25);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglNomTiers(this.factureEnteteVentes.getFacNomTiers());
            this.reglements.setRglNum(var11);
            this.reglements.setRglObjet(this.factureEnteteVentes.getFacObject());
            this.reglements.setRglParc("");
            this.reglements.setRglPdv(this.factureEnteteVentes.getFacPdv());
            double var10000;
            if (this.factureEnteteVentes.getFacTotTtc() - this.factureEnteteVentes.getFacTotReglement() <= var3) {
               this.reglements.setRglRecette(this.factureEnteteVentes.getFacTotTtc() - this.factureEnteteVentes.getFacTotReglement());
               var10000 = var3 - (this.factureEnteteVentes.getFacTotTtc() - this.factureEnteteVentes.getFacTotReglement());
            } else {
               this.reglements.setRglRecette(var3);
               var3 = 0.0D;
            }

            var5 = this.reglements.getRglRecette();
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglRegion(this.factureEnteteVentes.getFacRegion());
            this.reglements.setRglSecteur(this.factureEnteteVentes.getFacSecteur());
            this.reglements.setRglSerie(this.factureEnteteVentes.getFacSerie());
            this.reglements.setRglService(this.factureEnteteVentes.getFacService());
            this.reglements.setRglSite(this.factureEnteteVentes.getFacSite());
            this.reglements.setRglTrf(1);
            this.reglements.setRglTypeReg(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglUserModif(0L);
            this.reglements.setRglIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
            this.reglements.setRglNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
            this.reglements.setRglIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
            this.reglements.setRglNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
            this.reglements.setRglIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
            this.reglements.setRglNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
            String var12 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            String var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var12 + ":" + var13);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            String var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
            this.reglements.setExercicesCaisse(var9);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
            this.factureEnteteVentes.setFacTotReglement(this.factureEnteteVentes.getFacTotReglement() + var5);
            if (Math.abs(this.factureEnteteVentes.getFacTotReglement()) >= Math.abs(this.factureEnteteVentes.getFacTotTtc())) {
               this.factureEnteteVentes.setFacSolde(1);
            } else {
               this.factureEnteteVentes.setFacSolde(0);
            }

            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var2);
            this.reglements = new Reglements();
            this.reglements.setRglActivite(this.factureEnteteVentes.getFacActivite());
            this.reglements.setRglBanqueTireur("");
            this.reglements.setRglBudget(this.factureEnteteVentes.getFacBudget());
            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            this.reglements.setRglCodeCaiss("");
            this.reglements.setRglLibCaiss("");
            this.reglements.setRglCodeEmetrice("");
            this.reglements.setRglLibEmetrice("");
            this.reglements.setRglCodeReceptrice("");
            this.reglements.setRglLibReceptrice("");
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateReg(this.var_date);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepartement(var1.getAvrDepartement());
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDevise(var1.getAvrDevise());
            this.reglements.setRglDossier("");
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglDocument(var1.getAvrNum());
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(var1.getAvrId());
            this.reglements.setRglIdTiers(var1.getTiers().getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglLibelle("Compense Facture N° " + this.factureEnteteVentes.getFacNum());
            this.reglements.setRglLibTypReg("Compense");
            this.reglements.setRglMode("Compense");
            this.reglements.setRglModele("");
            this.reglements.setRglNumChqBdx("");
            this.reglements.setRglNatureDoc(26);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglNomTiers(var1.getAvrNomTiers());
            this.reglements.setRglNum(var11);
            this.reglements.setRglObjet(var1.getAvrObject());
            this.reglements.setRglParc("");
            this.reglements.setRglPdv(var1.getAvrPdv());
            this.reglements.setRglRecette(var5);
            var10000 = var7 + var5;
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglRegion(var1.getAvrRegion());
            this.reglements.setRglSecteur(var1.getAvrSecteur());
            this.reglements.setRglSerie(var1.getAvrSerie());
            this.reglements.setRglService(var1.getAvrService());
            this.reglements.setRglSite(var1.getAvrSite());
            this.reglements.setRglTrf(1);
            this.reglements.setRglTypeReg(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglUserModif(0L);
            this.reglements.setRglIdResponsable(var1.getAvrIdResponsable());
            this.reglements.setRglNomResponsable(var1.getAvrNomResponsable());
            this.reglements.setRglIdCommercial(var1.getAvrIdCommercial());
            this.reglements.setRglNomCommercial(var1.getAvrNomCommercial());
            this.reglements.setRglIdEquipe(var1.getAvrIdEquipe());
            this.reglements.setRglNomEquipe(var1.getAvrNomEquipe());
            var12 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var12 + ":" + var13);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
            this.reglements.setExercicesCaisse(var9);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
         }
      }

   }

   public void selectionLigneDetailTrf() throws HibernateException, NamingException {
      if (this.datamodelTransfert.isRowAvailable()) {
         this.factureLigneVentes = (FactureLigneVentes)this.datamodelTransfert.getRowData();
      }

   }

   public double calculTotalTrf() {
      double var1 = 0.0D;
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         var1 = this.factureLigneVentes.getFacligPuRemTtc() * (double)this.factureLigneVentes.getVar_qteReliquat();
      } else {
         var1 = this.factureLigneVentes.getFacligPuRem() * (double)this.factureLigneVentes.getVar_qteReliquat();
      }

      this.factureLigneVentes.setVar_totalTrf(var1);
      this.calculMontantTrf();
      return var1;
   }

   public void calculMontantTrf() {
      this.var_montant_trf = 0.0D;
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            this.var_montant_trf += ((FactureLigneVentes)this.documentDetailTrf.get(var1)).getVar_totalTrf();
         }
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFAVR(List var1, AvoirEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new AvoirLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            AvoirLigneVentes var4 = (AvoirLigneVentes)var1.get(var11);
            if (var4.getAvrligModeGroupe() != 2 || var4.getAvrligGroupe() == null || var4.getAvrligGroupe().isEmpty()) {
               if (var4.getAvrligCode() != null && !var4.getAvrligCode().isEmpty() && var4.getAvrligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getAvrligLibelle();
               }

               if (var5) {
                  var7 += var4.getAvrligPt();
                  var9 = var4.getAvrligTtc();
               }

               if (var4.getAvrligCode() != null && !var4.getAvrligCode().isEmpty() && var4.getAvrligCode().equals("=") && var5) {
                  var4 = new AvoirLigneVentes();
                  var4.setAvoirEnteteVentes(var2);
                  var4.setAvrligCode("=");
                  var4.setAvrligLibelle(var6);
                  var4.setAvrligPt(var7);
                  var4.setAvrligTtc(var9);
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

      this.montant_lettre = this.utilNombre.begin(var2.getAvrTotTtc() + var2.getAvrTotTc(), var2.getAvrDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationAvoir(AvoirEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setAvrEtatVal(1);
         var1.setAvrEtat(0);
         var1.setAvrDateValide((Date)null);
      } else {
         var1.setAvrEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setAvrEtat(1);
               var1.setAvrDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setAvrEtat(0);
               var1.setAvrDateValide((Date)null);
            }
         }
      }

      return var4;
   }

   public void trfFactureNegative() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         FactureEnteteVentes var3 = new FactureEnteteVentes();
         ArrayList var4 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setFacSerie(this.var_serie_trf);
         } else {
            var3.setFacSerie(this.factureEnteteVentes.getFacSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setFacIdCreateur(this.usersLog.getUsrid());
         var3.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setFacDate(this.utilDate.dateToSQLLight(this.factureEnteteVentes.getFacDate()));
         } else {
            var3.setFacDate(this.var_date_trf);
         }

         var3.setFacDate(this.utilDate.dateToSQL(this.factureEnteteVentes.getFacDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setFacDateCreat(new Date());
         var3.setFacDateModif((Date)null);
         var3.setFacIdModif(0L);
         var3.setFacNomModif("");
         var3.setFacNum("");
         this.calculDateValidite();
         var3.setFacService(this.factureEnteteVentes.getFacService());
         if (!var3.getFacSerie().equalsIgnoreCase("X") && !var3.getFacSerie().isEmpty()) {
            var3.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.var_type_trf, var3.getFacSerie(), var1));
         } else {
            long var5 = this.factureEnteteVentesDao.selectLastNum(var1);
            var3.setFacNum("" + var5);
         }

         this.verifieExistenceHabilitationFacture(var3, var1);
         var3.setFacSource(this.factureEnteteVentes.getFacSource());
         var3.setFacNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
         var3.setFacIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
         var3.setFacNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
         var3.setFacIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
         var3.setFacNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
         var3.setFacIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
         var3.setFacNomTiers(this.factureEnteteVentes.getFacNomTiers());
         var3.setFacCivilTiers(this.factureEnteteVentes.getFacCivilTiers());
         var3.setFacTiersRegroupe(this.factureEnteteVentes.getFacTiersRegroupe());
         var3.setFacIdContact(this.factureEnteteVentes.getFacIdContact());
         var3.setFacNomContact(this.factureEnteteVentes.getFacNomContact());
         var3.setFacCivilContact(this.factureEnteteVentes.getFacCivilContact());
         var3.setFacDiversAdresse(this.factureEnteteVentes.getFacDiversAdresse());
         var3.setFacDiversMail(this.factureEnteteVentes.getFacDiversMail());
         var3.setFacDiversNom(this.factureEnteteVentes.getFacDiversNom());
         var3.setFacDiversTel(this.factureEnteteVentes.getFacDiversTel());
         var3.setFacDiversTiers(this.factureEnteteVentes.getFacDiversTiers());
         var3.setFacDiversVille(this.factureEnteteVentes.getFacDiversVille());
         var3.setFacExoTva(this.factureEnteteVentes.getFacExoTva());
         var3.setFacExoDouane(this.factureEnteteVentes.getFacExoDouane());
         var3.setFacJournalReg(this.factureEnteteVentes.getFacJournalReg());
         var3.setFacCat(this.factureEnteteVentes.getFacCat());
         var3.setFacDevise(this.factureEnteteVentes.getFacDevise());
         var3.setFacObject(this.factureEnteteVentes.getFacObject());
         var3.setFacObservation(this.factureEnteteVentes.getFacObservation());
         var3.setFacTauxRemise(this.factureEnteteVentes.getFacTauxRemise());
         var3.setFacTotHt(0.0D);
         var3.setFacTotRemise(0.0D);
         var3.setFacTotRabais(0.0D);
         var3.setFacTotTva(0.0D);
         var3.setFacTotTc(0.0D);
         var3.setFacTotTtc(0.0D);
         var3.setFacTotReglement(0.0D);
         var3.setFacSolde(0);
         var3.setFacBanque(this.factureEnteteVentes.getFacBanque());
         var3.setFacTypeReg(this.factureEnteteVentes.getFacTypeReg());
         var3.setFacModeReg(this.factureEnteteVentes.getFacModeReg());
         var3.setFacNbJourReg(this.factureEnteteVentes.getFacNbJourReg());
         var3.setFacArrondiReg(this.factureEnteteVentes.getFacArrondiReg());
         var3.setFacConditionReg(this.factureEnteteVentes.getFacConditionReg());
         var3.setFacDateEcheReg(this.factureEnteteVentes.getFacDateEcheReg());
         var3.setFacContener(this.factureEnteteVentes.getFacContener());
         var3.setFacActivite(this.factureEnteteVentes.getFacActivite());
         var3.setFacSite(this.factureEnteteVentes.getFacSite());
         var3.setFacDepartement(this.factureEnteteVentes.getFacDepartement());
         var3.setFacRegion(this.factureEnteteVentes.getFacRegion());
         var3.setFacSecteur(this.factureEnteteVentes.getFacSecteur());
         var3.setFacPdv(this.factureEnteteVentes.getFacPdv());
         var3.setFacAnal2(this.factureEnteteVentes.getFacAnal2());
         var3.setFacAnal4(this.factureEnteteVentes.getFacAnal4());
         var3.setFacAffaire(this.factureEnteteVentes.getFacAffaire());
         var3.setFacInfo1(this.factureEnteteVentes.getFacInfo1());
         var3.setFacInfo2(this.factureEnteteVentes.getFacInfo2());
         var3.setFacInfo3(this.factureEnteteVentes.getFacInfo3());
         var3.setFacInfo4(this.factureEnteteVentes.getFacInfo4());
         var3.setFacInfo5(this.factureEnteteVentes.getFacInfo5());
         var3.setFacInfo6(this.factureEnteteVentes.getFacInfo6());
         var3.setFacInfo7(this.factureEnteteVentes.getFacInfo7());
         var3.setFacInfo8(this.factureEnteteVentes.getFacInfo8());
         var3.setFacInfo9(this.factureEnteteVentes.getFacInfo9());
         var3.setFacInfo10(this.factureEnteteVentes.getFacInfo10());
         var3.setFacFormule1(this.factureEnteteVentes.getFacFormule1());
         var3.setFacFormule2(this.factureEnteteVentes.getFacFormule2());
         var3.setFacAnnexe1(this.factureEnteteVentes.getFacAnnexe1());
         var3.setFacAnnexe2(this.factureEnteteVentes.getFacAnnexe2());
         var3.setFacContrat(this.factureEnteteVentes.getFacContrat());
         var3.setFacIncoterm(this.factureEnteteVentes.getFacIncoterm());
         var3.setFacLieuLivraison(this.factureEnteteVentes.getFacLieuLivraison());
         var3.setFacDateLivraison(this.factureEnteteVentes.getFacDateLivraison());
         var3.setFacInfoLivraison(this.factureEnteteVentes.getFacInfoLivraison());
         var3.setFacDateImp((Date)null);
         var3.setFacModeleImp(this.var_modele_trf);
         var3.setFacGarde(this.factureEnteteVentes.getFacGarde());
         var3.setFacGele(0);
         var3.setFacEtat(0);
         var3.setFacDateTransforme((Date)null);
         var3.setFacTypeTransforme(0);
         var3.setFacDateAnnule((Date)null);
         var3.setFacMotifAnnule("");
         var3.setFacNumAvoir(this.factureEnteteVentes.getFacNum());
         var3.setFacFactorNom(this.factureEnteteVentes.getFacFactorNom());
         var3.setFacFactorId(this.factureEnteteVentes.getFacFactorId());
         var3.setFacFactorEtat(this.factureEnteteVentes.getFacFactorEtat());
         var3.setFacNumBl(this.factureEnteteVentes.getFacNumBl());
         var3.setFacNumClient(this.factureEnteteVentes.getFacNumClient());
         var3.setFacDateClient(this.factureEnteteVentes.getFacDateClient());
         var3.setExerciceventes(this.factureEnteteVentes.getExerciceventes());
         var3.setTiers(this.factureEnteteVentes.getTiers());
         var3.setUsers(this.usersLog);
         var3 = this.factureEnteteVentesDao.insert(var3, var1);
         float var32 = 0.0F;
         float var6 = 0.0F;
         float var7 = 0.0F;
         double var8 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         String var20 = "";
         int var21 = 0;
         if (this.lesLignesList.size() != 0) {
            int var22 = 0;

            while(true) {
               if (var22 >= this.lesLignesList.size()) {
                  var3.setFacTotHt(var8);
                  var3.setFacTotRemise(var10);
                  var3.setFacTotRabais(var12);
                  var3.setFacTotTva(var14);
                  var3.setFacTotTc(var18);
                  var3.setFacTotTtc(var16);
                  var3 = this.factureEnteteVentesDao.modif(var3, var1);
                  if (var4.size() != 0) {
                     this.factureLigneVentesDao.saveLigne(var4, var3, var1);
                  }
                  break;
               }

               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var22);
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var20 == null || var20.isEmpty() || !var20.equals(this.factureLigneVentes.getFactureEnteteVentes().getFacNum())) {
                        var20 = this.factureLigneVentes.getFactureEnteteVentes().getFacNum();
                        ++var21;
                        FactureLigneVentes var34 = new FactureLigneVentes();
                        var34.setFacligCode("-");
                        var34.setFacligLibelle("---> Suivant facture N° " + var20);
                        var34.setFactureEnteteVentes(this.factureEnteteVentes);
                        var4.add(var34);
                     }
                  } else if (var22 == 0) {
                     var20 = "";
                     String var23 = "";
                     int var24 = 0;

                     while(true) {
                        if (var24 >= this.lesLignesList.size()) {
                           ++var21;
                           FactureLigneVentes var37 = new FactureLigneVentes();
                           var37.setFacligCode("-");
                           var37.setFacligLibelle("---> Suivant facture N° " + var23);
                           var37.setFactureEnteteVentes(this.factureEnteteVentes);
                           var4.add(var37);
                           break;
                        }

                        if (var20 == null || var20.isEmpty() || !var20.equals(this.factureLigneVentes.getFactureEnteteVentes().getFacNum())) {
                           var20 = this.factureLigneVentes.getFactureEnteteVentes().getFacNum();
                           if (var23 != null && !var23.isEmpty()) {
                              var23 = var23 + "," + var20;
                           } else {
                              var23 = var20;
                           }
                        }

                        ++var24;
                     }
                  }
               }

               if ((this.factureLigneVentes.getFacligLibelle() != null && !this.factureLigneVentes.getFacligLibelle().isEmpty() || this.factureLigneVentes.getFacligComplement() != null && !this.factureLigneVentes.getFacligComplement().isEmpty()) && this.factureLigneVentes.getVar_qteReliquat() != 0.0F) {
                  if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var1);
                     if (this.produits != null && this.factureLigneVentes.getFacligDepot() != null && !this.factureLigneVentes.getFacligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligDepot(), var1);
                     }
                  }

                  float var35 = this.factureLigneVentes.getFacligQte();
                  float var38 = this.factureLigneVentes.getFacligQteUtil();
                  ++var21;
                  FactureLigneVentes var25 = new FactureLigneVentes();
                  var32 += this.factureLigneVentes.getFacligQte();
                  var6 += this.factureLigneVentes.getVar_qteDejaTrf();
                  String[] var26;
                  if (((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_qteReliquat() != 0.0F) {
                     var25.setFacligOrdre(var21);
                     var25.setFacligCode(this.factureLigneVentes.getFacligCode());
                     var25.setFacligGroupe(this.factureLigneVentes.getFacligGroupe());
                     var25.setFacligModeGroupe(this.factureLigneVentes.getFacligModeGroupe());
                     var25.setFacligDevise(this.factureLigneVentes.getFacligDevise());
                     var25.setFacligFamille(this.factureLigneVentes.getFacligFamille());
                     var25.setFacligIdFac(this.factureLigneVentes.getFacligId());
                     var25.setFacligLibelle(this.factureLigneVentes.getFacligLibelle());
                     var25.setFacligComplement(this.factureLigneVentes.getFacligComplement());
                     if (((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne() != null && !((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne().isEmpty() && ((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne().contains("=")) {
                        var26 = ((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne().split("=");
                        var25.setFacligDepot(var26[0]);
                     } else {
                        var25.setFacligDepot("");
                     }

                     var25.setFacligEchelle(this.factureLigneVentes.getFacligEchelle());
                     var25.setFacligUnite(this.factureLigneVentes.getFacligUnite());
                     var25.setFacligReference(this.factureLigneVentes.getFacligReference());
                     this.factureLigneVentes.setFacligPump(this.factureLigneVentes.getFacligPump() * -1.0D);
                     var25.setFacligPump(this.factureLigneVentes.getFacligPump());
                     this.factureLigneVentes.setFacligPu(this.factureLigneVentes.getFacligPu() * -1.0D);
                     var25.setFacligPu(this.factureLigneVentes.getFacligPu());
                     this.factureLigneVentes.setFacligPuTtc(this.factureLigneVentes.getFacligPuTtc() * -1.0D);
                     var25.setFacligPuTtc(this.factureLigneVentes.getFacligPuTtc());
                     var25.setFacligTauxRemise(this.factureLigneVentes.getFacligTauxRemise());
                     this.factureLigneVentes.setFacligPuRem(this.factureLigneVentes.getFacligPuRem() * -1.0D);
                     var25.setFacligPuRem(this.factureLigneVentes.getFacligPuRem());
                     this.factureLigneVentes.setFacligPuRemTtc(this.factureLigneVentes.getFacligPuRemTtc() * -1.0D);
                     var25.setFacligPuRemTtc(this.factureLigneVentes.getFacligPuRemTtc());
                     this.factureLigneVentes.setFacligQte(((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_qteReliquat());
                     this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
                     var25.setFacligQte(((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_qteReliquat());
                     var25.setFacligLong(this.factureLigneVentes.getFacligLong());
                     var25.setFacligLarg(this.factureLigneVentes.getFacligLarg());
                     var25.setFacligHaut(this.factureLigneVentes.getFacligHaut());
                     var25.setFacligDiam(this.factureLigneVentes.getFacligDiam());
                     var25.setFacligPoidsBrut(this.factureLigneVentes.getFacligPoidsBrut());
                     var25.setFacligPoidsNet(this.factureLigneVentes.getFacligPoidsNet());
                     var25.setFacligVolume(this.factureLigneVentes.getFacligVolume());
                     var25.setFacligNb(this.factureLigneVentes.getFacligNb());
                     var25.setFacligQteStock(0.0F);
                     var25.setFacligRabais(this.factureLigneVentes.getFacligRabais());
                     var25.setFacligTauxTaxe(this.factureLigneVentes.getFacligTauxTaxe());
                     var25.setFacligTaxe(this.factureLigneVentes.getFacligTaxe());
                     var25.setFacligPt(this.factureLigneVentes.getFacligPt());
                     var25.setFacligTva(this.factureLigneVentes.getFacligTva());
                     var25.setFacligTtc(this.factureLigneVentes.getFacligTtc());
                     var25.setFacligTc(this.factureLigneVentes.getFacligTc());
                     var25.setFactureEnteteVentes(this.factureEnteteVentes);
                     var7 += ((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_qteReliquat();
                     var4.add(var25);
                     var8 += var25.getFacligPt();
                     var10 += (var25.getFacligPu() - var25.getFacligPuRem()) * (double)var25.getFacligQte();
                     var12 += var25.getFacligRabais();
                     var14 += var25.getFacligTva();
                     var16 += var25.getFacligTtc();
                     var18 += var25.getFacligTc();
                     this.factureLigneVentes.setFacligQte(var35);
                     this.factureLigneVentes.setFacligQteUtil(var38);
                  } else {
                     var25 = new FactureLigneVentes();
                     var25.setFacligOrdre(var21);
                     var25.setFacligCode(this.factureLigneVentes.getFacligCode());
                     var25.setFacligGroupe(this.factureLigneVentes.getFacligGroupe());
                     var25.setFacligModeGroupe(this.factureLigneVentes.getFacligModeGroupe());
                     var25.setFacligDevise(this.factureLigneVentes.getFacligDevise());
                     var25.setFacligFamille(this.factureLigneVentes.getFacligFamille());
                     var25.setFacligIdFac(this.factureLigneVentes.getFacligId());
                     var25.setFacligLibelle(this.factureLigneVentes.getFacligLibelle());
                     var25.setFacligComplement(this.factureLigneVentes.getFacligComplement());
                     if (((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne() != null && !((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne().isEmpty() && ((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne().contains("=")) {
                        var26 = ((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_depotLigne().split("=");
                        var25.setFacligDepot(var26[0]);
                     } else {
                        var25.setFacligDepot("");
                     }

                     var25.setFacligEchelle(this.factureLigneVentes.getFacligEchelle());
                     var25.setFacligUnite(this.factureLigneVentes.getFacligUnite());
                     var25.setFacligReference(this.factureLigneVentes.getFacligReference());
                     this.factureLigneVentes.setFacligPump(this.factureLigneVentes.getFacligPump() * -1.0D);
                     var25.setFacligPump(this.factureLigneVentes.getFacligPump());
                     this.factureLigneVentes.setFacligPu(this.factureLigneVentes.getFacligPu() * -1.0D);
                     var25.setFacligPu(this.factureLigneVentes.getFacligPu());
                     this.factureLigneVentes.setFacligPuTtc(this.factureLigneVentes.getFacligPuTtc() * -1.0D);
                     var25.setFacligPuTtc(this.factureLigneVentes.getFacligPuTtc());
                     var25.setFacligTauxRemise(this.factureLigneVentes.getFacligTauxRemise());
                     this.factureLigneVentes.setFacligPuRem(this.factureLigneVentes.getFacligPuRem() * -1.0D);
                     var25.setFacligPuRem(this.factureLigneVentes.getFacligPuRem());
                     this.factureLigneVentes.setFacligPuRemTtc(this.factureLigneVentes.getFacligPuRemTtc() * -1.0D);
                     var25.setFacligPuRemTtc(this.factureLigneVentes.getFacligPuRemTtc());
                     var25.setFacligQte(0.0F);
                     this.factureLigneVentes.setFacligQte(((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_qteReliquat());
                     this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var1);
                     var25.setFacligLong(this.factureLigneVentes.getFacligLong());
                     var25.setFacligLarg(this.factureLigneVentes.getFacligLarg());
                     var25.setFacligHaut(this.factureLigneVentes.getFacligHaut());
                     var25.setFacligDiam(this.factureLigneVentes.getFacligDiam());
                     var25.setFacligPoidsBrut(this.factureLigneVentes.getFacligPoidsBrut());
                     var25.setFacligPoidsNet(this.factureLigneVentes.getFacligPoidsNet());
                     var25.setFacligVolume(this.factureLigneVentes.getFacligVolume());
                     var25.setFacligNb(this.factureLigneVentes.getFacligNb());
                     var25.setFacligQteStock(0.0F);
                     var25.setFacligRabais(this.factureLigneVentes.getFacligRabais());
                     var25.setFacligTauxTaxe(this.factureLigneVentes.getFacligTauxTaxe());
                     var25.setFacligTaxe(this.factureLigneVentes.getFacligTaxe());
                     var25.setFacligPt(this.factureLigneVentes.getFacligPt());
                     var25.setFacligTva(this.factureLigneVentes.getFacligTva());
                     var25.setFacligTtc(this.factureLigneVentes.getFacligTtc());
                     var25.setFacligTc(this.factureLigneVentes.getFacligTc());
                     var25.setFactureEnteteVentes(this.factureEnteteVentes);
                     var7 += ((FactureLigneVentes)this.lesLignesList.get(var22)).getVar_qteReliquat();
                     var4.add(var25);
                     var8 += var25.getFacligPt();
                     var10 += (var25.getFacligPu() - var25.getFacligPuRem()) * (double)var25.getFacligQte();
                     var12 += var25.getFacligRabais();
                     var14 += var25.getFacligTva();
                     var16 += var25.getFacligTtc();
                     var18 += var25.getFacligTc();
                     this.factureLigneVentes.setFacligQte(var35);
                     this.factureLigneVentes.setFacligQteUtil(var38);
                  }
               }

               ++var22;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFacture(var3, var1), var3.getFacId(), var3.getFacNum(), var3.getFacNum(), var3.getFacDate(), var3.getFacDevise(), var3.getFacTotTtc() + var3.getFacTotTc(), var3.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 25), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var4, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.factureEnteteVentes.getExerciceventes());
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.factureEnteteVentes.getFacSerie());
         this.documentTraceVentes.setDoctraOrgId(this.factureEnteteVentes.getFacId());
         this.documentTraceVentes.setDoctraOrgNum(this.factureEnteteVentes.getFacNum());
         this.documentTraceVentes.setDoctraOrgDate(this.factureEnteteVentes.getFacDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getFacSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getFacId());
         this.documentTraceVentes.setDoctraDstNum(var3.getFacNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getFacDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         var3.setFacEtat(0);
         var3.setFacDateTransforme(new Date());
         var3.setFacTypeTransforme(this.var_type_trf);
         var3.setFacTotReglement(var3.getFacTotTtc());
         var3.setFacSolde(1);
         var3 = this.factureEnteteVentesDao.modif(var3, var1);
         this.factureEnteteVentesDao.modif(var3, var1);
         var3.setFacNumAvoir(var3.getFacNum());
         var3 = this.factureEnteteVentesDao.modif(var3, var1);
         if (var3.getFacNumBl() != null && !var3.getFacNumBl().isEmpty()) {
            new LivraisonEnteteVentes();
            LivraisonEnteteVentesDao var36 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            LivraisonEnteteVentes var33 = var36.pourParapheur(var3.getFacNumBl(), var3.getFacSerie(), var1);
            if (var33 != null) {
               var33.setBlvEtat(1);
               var33.setBlvNumFacture("");
               var36.modif(var33, var1);
            }
         }

         var2.commit();
      } catch (HibernateException var30) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var30;
      } finally {
         this.utilInitHibernate.closeSession();
      }

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

   public Habilitation verifieExistenceHabilitationFacture(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setFacEtatVal(1);
         var1.setFacEtat(0);
         var1.setFacDateValide((Date)null);
      } else {
         var1.setFacEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setFacEtat(1);
               var1.setFacDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setFacEtat(0);
               var1.setFacDateValide((Date)null);
            }
         }
      }

      return var4;
   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
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
         if (this.var_tot_bon_encaissement > this.factureEnteteVentes.getFacTotTtc()) {
            this.factureEnteteVentes.setFacTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.factureEnteteVentes.getFacTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.factureEnteteVentes.getFacTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.factureEnteteVentes.getFacEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.factureEnteteVentes.getFacTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.factureEnteteVentes.setFacTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.factureEnteteVentes.getFacTotTtc() - this.var_tot_bon_encaissement;
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureEnteteVentes.getFacSerie())) {
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
      if (this.factureEnteteVentes.getFacTypeReg() != 4 && this.factureEnteteVentes.getFacTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (Math.abs(this.var_tot_bon_encaissement) <= Math.abs(this.factureEnteteVentes.getFacTotTtc())) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteVentes.getFacTypeReg() == 5) {
               this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(this.nature, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.factureEnteteVentes.getFacSerie(), var1);
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
                  this.bonEncaissementVente.setBonActivite(this.factureEnteteVentes.getFacActivite());
                  this.bonEncaissementVente.setBonSite(this.factureEnteteVentes.getFacSite());
                  this.bonEncaissementVente.setBonDepartement(this.factureEnteteVentes.getFacDepartement());
                  this.bonEncaissementVente.setBonService(this.factureEnteteVentes.getFacService());
                  this.bonEncaissementVente.setBonRegion(this.factureEnteteVentes.getFacRegion());
                  this.bonEncaissementVente.setBonSecteur(this.factureEnteteVentes.getFacSecteur());
                  this.bonEncaissementVente.setBonPdv(this.factureEnteteVentes.getFacPdv());
                  this.bonEncaissementVente.setBonDateEcheReg(this.factureEnteteVentes.getFacDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.factureEnteteVentes.getFacNomTiers());
                  this.bonEncaissementVente.setBonIdTiers(this.factureEnteteVentes.getTiers().getTieid());
                  this.bonEncaissementVente.setBonNomContact(this.factureEnteteVentes.getFacNomContact());
                  this.bonEncaissementVente.setBonIdContact(this.factureEnteteVentes.getFacIdContact());
                  this.bonEncaissementVente.setBonTypeTiers(0);
                  this.bonEncaissementVente.setBonLibelle("Règlement Facture N° " + this.factureEnteteVentes.getFacNum());
                  this.bonEncaissementVente.setBonRef(this.factureEnteteVentes.getFacNum());
                  this.bonEncaissementVente.setBonIdRef(this.factureEnteteVentes.getFacId());
                  this.bonEncaissementVente.setBonObject(this.factureEnteteVentes.getFacObject());
                  this.bonEncaissementVente.setBonObservation(this.factureEnteteVentes.getFacObservation());
                  this.bonEncaissementVente.setBonSerie(this.factureEnteteVentes.getFacSerie());
                  this.bonEncaissementVente.setBonDevise(this.factureEnteteVentes.getFacDevise());
                  this.bonEncaissementVente.setBonTotTtc(this.factureEnteteVentes.getFacTotTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
                  this.bonEncaissementVente.setBonNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var11);
            if (this.factureEnteteVentes.isVar_select_ligne()) {
               long var13 = this.factureEnteteVentes.getFacId();
               this.factureEnteteVentes = new FactureEnteteVentes();
               this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var13, var1);
               if (this.factureEnteteVentes != null) {
                  this.lesEntetesList.remove(var11);
                  this.factureEnteteVentes.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.factureEnteteVentes);
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
            new FactureEnteteVentes();
            FactureEnteteVentes var11 = (FactureEnteteVentes)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getFacNomTiers())) && var11.getFacSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getFacNomTiers();
               var1 += var11.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc();
               var3 += var11.getFacTotReglement();
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
            this.factureEnteteVentes.setFacTypeReg(0);
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureEnteteVentes.getFacSerie())) {
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
         new FactureEnteteVentes();
         FactureEnteteVentes var6 = (FactureEnteteVentes)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getFacTotTtc();
            var3 += var6.getFacTotReglement();
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
      FactureEnteteVentes var9;
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new FactureEnteteVentes();
               FactureEnteteVentes var7 = (FactureEnteteVentes)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFacDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFacDate());
                  var4 = var4 - var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FactureEnteteVentes();
            var9 = (FactureEnteteVentes)this.listFactureSelectionne.get(var1);
            var9.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var9.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      if (this.factureEnteteVentes.getFacTypeReg() == 4) {
         double var8 = 0.0D;

         for(int var3 = 0; var3 < this.listFactureSelectionne.size(); ++var3) {
            new FactureEnteteVentes();
            FactureEnteteVentes var10 = (FactureEnteteVentes)this.listFactureSelectionne.get(var3);
            var8 += var10.getVar_reliquat();
         }
      } else {
         this.montantElmTotBonEnc = 0.0D;

         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FactureEnteteVentes();
            var9 = (FactureEnteteVentes)this.listFactureSelectionne.get(var1);
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
               String var7 = this.factureEnteteVentes.getFacSerie();
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
                  new FactureEnteteVentes();

                  for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                     FactureEnteteVentes var20 = (FactureEnteteVentes)this.listFactureSelectionne.get(var21);
                     var16 = var20.getVar_fac_timbre();
                     var18 = var20.getMontantReglementManuel();
                     var12 = 0.0D;
                     if (var20.isVar_select_ligne()) {
                        long var22 = var20.getFacId();
                        var20 = this.factureEnteteVentesDao.pourParapheur(var22, var3);
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
                              var12 = var20.getFacTotTtc() + var20.getFacTotTc() + var16 - var20.getFacTotReglement();
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
         Session var31 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");

         for(int var32 = 0; var32 < this.lesEntetesList.size(); ++var32) {
            this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var32);
            if (this.factureEnteteVentes.isVar_select_ligne()) {
               long var33 = this.factureEnteteVentes.getFacId();
               this.factureEnteteVentes = new FactureEnteteVentes();
               this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var33, var31);
               if (this.factureEnteteVentes != null) {
                  if (this.factureEnteteVentes.getFacSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var32);
                  } else {
                     this.lesEntetesList.remove(var32);
                     this.factureEnteteVentes.setVar_select_ligne(false);
                     this.lesEntetesList.add(var32, this.factureEnteteVentes);
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
               this.totManuel += ((FactureEnteteVentes)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
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

   public void generationReglement(String var1, double var2, double var4, FactureEnteteVentes var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (Math.abs(var2) >= Math.abs(var6.getFacTotTtc() + var6.getFacTotTc() + var4)) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite(var6.getFacActivite());
      this.reglements.setRglBudget(var6.getFacBudget());
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
      this.reglements.setRglDepartement(var6.getFacDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getFacDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getFacNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getFacId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle(var6.getFacObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(25);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      if (this.optionsVentes.getDecrmtPrsChrStock() != null && this.optionsVentes.getDecrmtPrsChrStock().equals("2")) {
         this.reglements.setRglIdContact(var6.getFacIdContact());
         this.reglements.setRglNomContact(var6.getVar_nomContact());
      } else {
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
      }

      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getFacPdv());
      this.reglements.setRglRecette(var2);
      if (var4 != 0.0D) {
         this.reglements.setRglTimbre(var4);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getFacRegion());
      this.reglements.setRglSecteur(var6.getFacSecteur());
      this.reglements.setRglSerie(var6.getFacSerie());
      this.reglements.setRglService(var6.getFacService());
      this.reglements.setRglSite(var6.getFacSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getFacIdResponsable());
      this.reglements.setRglNomResponsable(var6.getFacNomResponsable());
      this.reglements.setRglIdCommercial(var6.getFacIdCommercial());
      this.reglements.setRglNomCommercial(var6.getFacNomCommercial());
      this.reglements.setRglIdEquipe(var6.getFacIdEquipe());
      this.reglements.setRglNomEquipe(var6.getFacNomEquipe());
      String var12 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var12 + ":" + var10);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
      this.reglements.setExercicesCaisse(var7);
      this.reglements = this.reglementsDao.insert(this.reglements, var8);
      this.memoReglements = this.reglements;
      if (var6 != null) {
         var6.setFacTotReglement(var6.getFacTotReglement() + var2);
         var6.setFacTotTimbre(var6.getFacTotTimbre() + var4);
         if (Math.abs(var6.getFacTotReglement()) >= Math.abs(var6.getFacTotTtc() + var6.getFacTotTc())) {
            var6.setFacSolde(1);
         } else {
            var6.setFacSolde(0);
         }

         var6.setFacDateLastReg(this.reglements.getRglDateReg());
         this.factureEnteteVentesDao.modif(var6, var8);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.factureEnteteVentes.getFacId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.factureEnteteVentes.setFacTotReglement(var4);
            if (Math.abs(this.factureEnteteVentes.getFacTotReglement()) >= Math.abs(this.factureEnteteVentes.getFacTotTtc())) {
               this.factureEnteteVentes.setFacSolde(1);
            } else {
               this.factureEnteteVentes.setFacSolde(0);
            }

            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
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
      if (this.factureEnteteVentes != null) {
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
                  var6 = "" + this.utilNombre.beginText(((Reglements)var7.get(var8)).getRglRecette() + ((Reglements)var7.get(var8)).getRglTimbre(), this.structureLog.getStrformatdevise());
               } else {
                  var5 = var5 + "\n" + ((Reglements)var7.get(var8)).getRglDocument();
                  var6 = var6 + "\n" + this.utilNombre.beginText(((Reglements)var7.get(var8)).getRglRecette() + ((Reglements)var7.get(var8)).getRglTimbre(), this.structureLog.getStrformatdevise());
               }

               var3 = var3 + ((Reglements)var7.get(var8)).getRglRecette() + ((Reglements)var7.get(var8)).getRglTimbre();
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

   public void ouvrirImpressionAbn() {
      this.showModalPanelPrintReleve = true;
   }

   public void fermerImpressionAbn() {
      this.showModalPanelPrintReleve = false;
   }

   public void imprimerAbnPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("PRT");
   }

   public void imprimerAbnJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("JRV");
   }

   public void imprimerAbnPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("PDF");
   }

   public void imprimerAbnODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("ODT");
   }

   public void imprimerAbnXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("XLS");
   }

   public void imprimerAbnDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("DOC");
   }

   public void imprimerAbnHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("HTML");
   }

   public void imprimerAbnXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionAbn("XML");
   }

   public void impressionAbn(String var1) throws IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.lesFacturesGene.size() != 0) {
         UtilPrint var2 = new UtilPrint(this.utilInitHibernate);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesFacturesGene);
         var2.setjRBeanCollectionDataSource(var3);
         var2.setRapport("releveAbn");
         var2.setEntete("Impression releve");
         if (this.region != null && !this.region.isEmpty()) {
            var2.setFiltre("Période: " + this.periode + "     Région: " + this.region);
         } else {
            var2.setFiltre("Période: " + this.periode + "     TOUTES REGIONS");
         }

         String var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "abonnement" + File.separator;
         File var5 = new File(var4);
         if (!var5.exists()) {
            var5.mkdir();
         }

         File var6 = new File(var5 + File.separator + var2.getRapport() + ".jasper");
         if (var6.exists()) {
            var2.setCheminRapport(var4);
            String var7 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport";
            var2.setCheminSousrapport(var7);
            var2.setImageFondPage((String)null);
            var2.setFormat(var1);
            var2.setIdResponsable(this.usersLog.getUsrid());
            var2.setIdCommercial(this.usersLog.getUsrid());
            var2.setTiersSelectionne((Tiers)null);
            var2.setContact((Contacts)null);
            var2.setNumDoc("");
            var2.setNature(this.nature);
            var2.setId_doc(0L);
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

   public void executerRequeteLissage() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetailLissage((Session)null);
   }

   public void chargeListeDetailLissage(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      this.var_nb_ligne = 0;
      String var10 = "";
      String var11 = "";
      this.setMontantTtcElmt(0.0D);
      this.setMontantReglementElmt(0.0D);
      this.setMontantSoldeElmt(0.0D);
      if (this.inpDu != null) {
         var10 = this.utilDate.dateToStringSQLLight(this.inpDu);
      }

      if (this.inpAu != null) {
         var11 = this.utilDate.dateToStringSQLLight(this.inpAu);
      }

      byte var12 = 0;
      if (this.typeVente == 810) {
         var12 = 1;
      }

      this.lesEntetesList = this.factureEnteteVentesDao.recherche(var1, var12, this.exercicesVentes.getExevteId(), "", "", "", 0L, "", 18, this.getInpSerie(), "100", "100", 0L, 0, "", "", "", "100", "", var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
      this.datamodelEntete.setWrappedData(this.lesEntetesList);
      if (this.lesEntetesList.size() > 0) {
         new FactureEnteteVentes();

         for(int var14 = 0; var14 < this.lesEntetesList.size(); ++var14) {
            FactureEnteteVentes var13 = (FactureEnteteVentes)this.lesEntetesList.get(var14);
            var13.setVar_select_ligne(false);
            var2 += var13.getFacTotTtc();
            var4 += var13.getFacTotReglement();
            var6 += var13.getFacTotHt();
            var8 += var13.getFacTotTva();
         }
      }

      this.var_nb_ligne = this.lesEntetesList.size();
      this.totauxHt = var2;
      this.totauxHt = var6;
      this.totauxTaxe = var8;
      this.montantTtc = var2;
      this.montantReglement = var4;
      this.montantSolde = var2 - var4;
      this.visibiliteBton = false;
   }

   public void selectionLigneLissage() throws JDOMException, IOException, HibernateException, NamingException {
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
            this.factureEnteteVentes = (FactureEnteteVentes)var1.get(0);
            double var8 = 0.0D;
            double var5 = 0.0D;

            for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var7);
               if (this.factureEnteteVentes.isVar_select_ligne()) {
                  var8 += this.factureEnteteVentes.getFacTotTtc();
                  var5 += this.factureEnteteVentes.getFacTotReglement();
               }
            }

            this.setMontantTtcElmt(var8);
            this.setMontantReglementElmt(var5);
            this.setMontantSoldeElmt(var8 - var5);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigneLissage() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         this.inpNomTiersEnCours = this.factureEnteteVentes.getFacNomTiers();
         this.inpIdTiersEnCours = this.factureEnteteVentes.getTiers().getTieid();
         this.inpNomDestinataire = this.factureEnteteVentes.getFacNomContact();
         this.var_date = this.factureEnteteVentes.getFacDate();
         if (this.factureEnteteVentes.getFacDate().getHours() <= 9) {
            this.var_heure = "0" + this.factureEnteteVentes.getFacDate().getHours();
         } else {
            this.var_heure = "" + this.factureEnteteVentes.getFacDate().getHours();
         }

         if (this.factureEnteteVentes.getFacDate().getMinutes() <= 9) {
            this.var_minute = "0" + this.factureEnteteVentes.getFacDate().getMinutes();
         } else {
            this.var_minute = "" + this.factureEnteteVentes.getFacDate().getMinutes();
         }

         if (this.factureEnteteVentes.getFacDate().getSeconds() <= 9) {
            this.var_seconde = "0" + this.factureEnteteVentes.getFacDate().getSeconds();
         } else {
            this.var_seconde = "" + this.factureEnteteVentes.getFacDate().getSeconds();
         }

         this.tiers = this.factureEnteteVentes.getTiers();
         this.formRecherche.setTiers(this.tiers);
         if (!this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.var_typeTiers = true;
         } else {
            this.var_typeTiers = false;
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         this.numeroPfManuel = this.factureEnteteVentes.getFacAnal4();
         this.var_nom_contact = this.factureEnteteVentes.getFacIdContact();
         this.var_nom_responsable = this.factureEnteteVentes.getFacIdResponsable();
         this.var_nom_commercial = this.factureEnteteVentes.getFacIdCommercial();
         this.calculDevise();
         this.chargerDocumentLigne(var1);
         this.calculMessageLitige(var1);
         this.chargerBonEncaissement(var1);
         this.chargerDocumentTrace(var1);
         this.chargerLesContactsItem(var1);
         this.chargerUserChrono(var1);
         this.chargerLesUsers(var1);
         this.chargerParapheur(var1);
         this.chargerLesParcs(var1);
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
         this.verrouNum = true;
         this.visibiliteBton = true;
         this.utilInitHibernate.closeSession();
         this.consultDocument();
      }

   }

   public void transformerDocumentLissage() throws HibernateException, NamingException {
      this.var_date_trf = null;
      this.var_type_trf = 0;
      this.var_mode_trf = "";
      this.var_aff_trf = false;
      this.valideLissage = false;
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

      this.showModalPanelTrf = true;
   }

   public void annuleLissage() throws IOException, JDOMException {
      this.showModalPanelTrf = false;
   }

   public void miseajourLissage() throws NamingException, IOException, HibernateException, ParseException {
      if (this.lesEntetesList.size() != 0) {
         if (this.caissesCommercialesDao == null) {
            this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         }

         if (this.inpCaisse != null && !this.inpCaisse.isEmpty()) {
            if (this.inpCaisse.contains(":")) {
               String[] var1 = this.inpCaisse.split(":");
               this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(0L, var1[0], (Session)null);
            }
         } else {
            this.caissesCommerciales = null;
         }

         Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var21.beginTransaction();
            LivraisonEnteteVentesDao var3 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            AvoirEnteteVentesDao var4 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            String var5 = "";

            for(int var6 = 0; var6 < this.lesEntetesList.size(); ++var6) {
               this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var6);
               if (this.factureEnteteVentes.isVar_select_ligne()) {
                  String var7 = this.factureEnteteVentes.getFacNum();
                  long var8 = this.factureEnteteVentes.getFacId();
                  String var10 = "";
                  if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
                     var10 = this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), this.nature, this.var_serie_trf, var21);
                  }

                  if (var10 != null && !var10.isEmpty()) {
                     this.factureEnteteVentes.setFacNum(var10);
                     this.factureEnteteVentes.setFacSerie(this.var_serie_trf);
                     this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var21);
                     new ArrayList();
                     List var11 = this.documentTraceVentesDao.chargerLesDocumentsTrace(var8, this.nature, var21);
                     if (var11.size() != 0) {
                        this.documentTraceVentes = new DocumentTraceVentes();

                        for(int var12 = 0; var12 < var11.size(); ++var12) {
                           this.documentTraceVentes = (DocumentTraceVentes)var11.get(var12);
                           if (this.documentTraceVentes.getDoctraDstId() == var8 && this.documentTraceVentes.getDoctraDstType() == this.nature) {
                              this.documentTraceVentes.setDoctraDstNum(var10);
                              this.documentTraceVentes.setDoctraDstSerie(this.var_serie_trf);
                           } else if (this.documentTraceVentes.getDoctraOrgId() == var8 && this.documentTraceVentes.getDoctraOrgType() == this.nature) {
                              this.documentTraceVentes.setDoctraOrgNum(var10);
                              this.documentTraceVentes.setDoctraOrgSerie(this.var_serie_trf);
                           }

                           this.documentTraceVentes = this.documentTraceVentesDao.modif(this.documentTraceVentes, var21);
                        }
                     }

                     new ArrayList();
                     var5 = " blvo_num_facture='" + var7 + "'";
                     List var22 = var3.rechercheLivraisonRequete(var5, var21);
                     if (var22.size() != 0) {
                        new LivraisonEnteteVentes();

                        for(int var14 = 0; var14 < var22.size(); ++var14) {
                           LivraisonEnteteVentes var13 = (LivraisonEnteteVentes)var22.get(var14);
                           var13.setBlvNumFacture(var10);
                           var3.modif(var13, var21);
                        }
                     }

                     new ArrayList();
                     var5 = " avr_num_facture='" + var7 + "'";
                     List var23 = var4.rechercheAvoirRequete(var5, var21);
                     int var15;
                     if (var23.size() != 0) {
                        new AvoirEnteteVentes();

                        for(var15 = 0; var15 < var23.size(); ++var15) {
                           AvoirEnteteVentes var24 = (AvoirEnteteVentes)var23.get(var15);
                           var24.setAvrNumFacture(var10);
                           var4.modif(var24, var21);
                        }
                     }

                     new ArrayList();
                     List var25 = this.reglementsDao.reglementDocument(var8, this.nature, var21);
                     if (var25.size() != 0) {
                        for(var15 = 0; var15 < var25.size(); ++var15) {
                           this.reglements = (Reglements)var25.get(var15);
                           this.reglements.setRglNum(this.calculChrono.numCompose(this.reglements.getRglDateReg(), 61, this.var_serie_trf, var21));
                           if (this.caissesCommerciales != null) {
                              this.reglements.setRglCodeCaiss(this.caissesCommerciales.getCaiCode());
                              this.reglements.setRglLibCaiss(this.caissesCommerciales.getCaiNom());
                           } else {
                              this.reglements.setRglCodeCaiss("");
                              this.reglements.setRglLibCaiss("");
                           }

                           this.reglements.setRglDocument(var10);
                           this.reglements.setRglSerie(this.var_serie_trf);
                           this.reglements = this.reglementsDao.modifierReg(this.reglements, var21);
                        }
                     }
                  }
               }
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

         this.executerRequeteLissage();
      }

      this.showModalPanelTrf = false;
   }

   public void verifLissage() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      String var1 = "";
      if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
         if (!this.var_serie_trf.contains(",")) {
            var1 = this.var_serie_trf;
         } else {
            var1 = "";
         }
      } else {
         var1 = "";
      }

      if (var1 != null && !var1.isEmpty()) {
         this.mesCaissesSeriesItems = this.usersChronoDao.selectChronoByUserNat(this.usersLog, 61, var1, (Session)null);
      }

      if (this.var_serie_trf.equals(this.inpSerie)) {
         this.valideLissage = false;
      } else if (this.mesCaissesSeriesItems.size() != 0) {
         this.valideLissage = true;
      } else {
         this.valideLissage = false;
      }

   }

   public void transformerReNumeroLissage() {
   }

   public String conversionGarde() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureEnteteVentes.getFacGarde() != null && !this.factureEnteteVentes.getFacGarde().isEmpty() && this.factureEnteteVentes.getFacGarde().contains(":")) {
         String[] var2 = this.factureEnteteVentes.getFacGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureEnteteVentes.getUsers(), this.structureLog, this.factureEnteteVentes.getTiers());
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
      if (this.factureEnteteVentes.getFacFormule1() != null && !this.factureEnteteVentes.getFacFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.factureEnteteVentes.getFacFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureEnteteVentes.getFacFormule2() != null && !this.factureEnteteVentes.getFacFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.factureEnteteVentes.getFacFormule2(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureEnteteVentes.getFacAnnexe1() != null && !this.factureEnteteVentes.getFacAnnexe1().isEmpty() && this.factureEnteteVentes.getFacAnnexe1().contains(":")) {
         String[] var2 = this.factureEnteteVentes.getFacAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureEnteteVentes.getUsers(), this.structureLog, this.factureEnteteVentes.getTiers());
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
      if (this.factureEnteteVentes.getFacAnnexe2() != null && !this.factureEnteteVentes.getFacAnnexe2().isEmpty() && this.factureEnteteVentes.getFacAnnexe2().contains(":")) {
         String[] var2 = this.factureEnteteVentes.getFacAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureEnteteVentes.getUsers(), this.structureLog, this.factureEnteteVentes.getTiers());
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

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      this.totalAppelFonds = 0.0D;
      this.numeroAppelFonds = "";

      for(int var1 = 0; var1 < this.lstReg.size(); ++var1) {
         if (((Reglements)this.lstReg.get(var1)).getRglTypeTiers() == 20) {
            this.totalAppelFonds += ((Reglements)this.lstReg.get(var1)).getRglRecette();
            this.numeroAppelFonds = this.numeroAppelFonds + ((Reglements)this.lstReg.get(var1)).getRglBon() + " ";
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.utilNombre.myRoundDevise(this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc() - this.totalAppelFonds, this.factureEnteteVentes.getFacDevise()), this.factureEnteteVentes.getFacDevise());
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(this.calculeImpressionListe());
      return var2;
   }

   public List calculeImpressionListe() throws IOException, HibernateException, NamingException {
      new ArrayList();
      List var1 = this.calculeImpressionListe((Session)null);
      return var1;
   }

   public List calculeImpressionListe(Session var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         Date var7 = null;
         Date var8 = null;
         Date var9 = null;
         Object var10 = null;
         Date var11 = null;
         Date var12 = null;
         Date var13 = null;
         Object var14 = null;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         String var24;
         if (this.structureLog.getStrid() == 85L) {
            if (this.factureEnteteVentes.getFacNumBl() != null && !this.factureEnteteVentes.getFacNumBl().isEmpty()) {
               new LivraisonEnteteVentes();
               LivraisonEnteteVentesDao var35 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               LivraisonEnteteVentes var33 = var35.pourParapheur(this.factureEnteteVentes.getFacNumBl(), "", var1);
               if (var33 != null) {
                  this.factureEnteteVentes.setNumBl(var33.getBlvNum());
                  this.factureEnteteVentes.setDateBl(var33.getBlvDate());
               }
            }
         } else if (this.structureLog.getStrid() == 101L) {
            new ArrayList();
            var24 = this.utilDate.dateToStringSQLLight(this.factureEnteteVentes.getFacDate()) + " 23:59:59";
            List var23 = this.factureEnteteVentesDao.rechercheNonPayeesByTiers(this.factureEnteteVentes.getTiers(), "'A'", var24, var1);
            int var25 = 0;
            if (var23.size() != 0) {
               for(int var26 = 0; var26 < var23.size(); ++var26) {
                  if (var26 == 0) {
                     var3 = ((FactureEnteteVentes)var23.get(var26)).getFacNum();
                     var7 = ((FactureEnteteVentes)var23.get(var26)).getFacDate();
                     var11 = ((FactureEnteteVentes)var23.get(var26)).getFacDateEcheReg();
                     var15 = ((FactureEnteteVentes)var23.get(var26)).getFacTotTtc() - ((FactureEnteteVentes)var23.get(var26)).getFacTotReglement();
                  } else if (var26 == 1) {
                     var4 = ((FactureEnteteVentes)var23.get(var26)).getFacNum();
                     var8 = ((FactureEnteteVentes)var23.get(var26)).getFacDate();
                     var12 = ((FactureEnteteVentes)var23.get(var26)).getFacDateEcheReg();
                     var17 = ((FactureEnteteVentes)var23.get(var26)).getFacTotTtc() - ((FactureEnteteVentes)var23.get(var26)).getFacTotReglement();
                  } else if (var26 == 2) {
                     var5 = ((FactureEnteteVentes)var23.get(var26)).getFacNum();
                     var9 = ((FactureEnteteVentes)var23.get(var26)).getFacDate();
                     var13 = ((FactureEnteteVentes)var23.get(var26)).getFacDateEcheReg();
                     var19 = ((FactureEnteteVentes)var23.get(var26)).getFacTotTtc() - ((FactureEnteteVentes)var23.get(var26)).getFacTotReglement();
                  } else {
                     ++var25;
                     var6 = "Antérieur";
                     var10 = null;
                     var14 = null;
                     var21 += ((FactureEnteteVentes)var23.get(var26)).getFacTotTtc() - ((FactureEnteteVentes)var23.get(var26)).getFacTotReglement();
                  }
               }
            }

            this.factureEnteteVentes.setF1(var3);
            this.factureEnteteVentes.setF2(var4);
            this.factureEnteteVentes.setF3(var5);
            this.factureEnteteVentes.setF4("Nb. Ant.: " + var25);
            this.factureEnteteVentes.setP1(var7);
            this.factureEnteteVentes.setP2(var8);
            this.factureEnteteVentes.setP3(var9);
            this.factureEnteteVentes.setP4((Date)var10);
            this.factureEnteteVentes.setE1(var11);
            this.factureEnteteVentes.setE2(var12);
            this.factureEnteteVentes.setE3(var13);
            this.factureEnteteVentes.setE4((Date)var14);
            this.factureEnteteVentes.setM1(var15);
            this.factureEnteteVentes.setM2(var17);
            this.factureEnteteVentes.setM3(var19);
            this.factureEnteteVentes.setM4(var21);
         }

         boolean var34 = false;
         var24 = "";
         double var36 = 0.0D;
         double var27 = 0.0D;
         this.infoOrigineDoc = "";
         ConditionnementDao var29 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();

         for(int var31 = 0; var31 < this.lesLignesList.size(); ++var31) {
            this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var31);
            if (this.factureLigneVentes.getFacligModeGroupe() != 2 || this.factureLigneVentes.getFacligGroupe() == null || this.factureLigneVentes.getFacligGroupe().isEmpty()) {
               this.factureLigneVentes.setVar_lib_des_condit("");
               if (this.factureLigneVentes.getFacligCondition() != null && !this.factureLigneVentes.getFacligCondition().isEmpty() && this.factureLigneVentes.getFacligCondition().contains(":")) {
                  String[] var32 = this.factureLigneVentes.getFacligCondition().split(":");
                  Conditionnement var30 = var29.rechercheConditionnement(var32[0], var1);
                  if (var30 != null) {
                     this.factureLigneVentes.setVar_lib_des_condit(var30.getCdtDescription());
                  }
               }

               if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.factureLigneVentes.getFacligCode().equals("-")) {
                  var34 = true;
                  var24 = this.factureLigneVentes.getFacligLibelle();
                  if (var24.startsWith("Suivant ") && (this.infoOrigineDoc == null || this.infoOrigineDoc.isEmpty())) {
                     this.infoOrigineDoc = var24;
                  }
               }

               if (var34) {
                  var36 += this.factureLigneVentes.getFacligPt();
                  var27 = this.factureLigneVentes.getFacligTtc();
               }

               if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.factureLigneVentes.getFacligCode().equals("=") && var34) {
                  this.factureLigneVentes = new FactureLigneVentes();
                  this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                  this.factureLigneVentes.setFacligCode("=");
                  this.factureLigneVentes.setFacligOrdre(var31);
                  this.factureLigneVentes.setFacligLibelle(var24);
                  this.factureLigneVentes.setFacligPt(var36);
                  this.factureLigneVentes.setFacligTtc(var27);
                  var2.add(this.factureLigneVentes);
                  var36 = 0.0D;
                  var27 = 0.0D;
                  var34 = false;
               } else {
                  this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                  this.factureLigneVentes.setFacligOrdre(var31);
                  var2.add(this.factureLigneVentes);
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.factureLigneVentes = new FactureLigneVentes();
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligCode("FORMULE1");
            this.factureLigneVentes.setFacligOrdre(var2.size() + 2);
            this.factureLigneVentes.setFacligLibelle(this.formule1());
            this.factureLigneVentes.setFacligPt(0.0D);
            this.factureLigneVentes.setFacligTtc(0.0D);
            var2.add(this.factureLigneVentes);
            this.factureLigneVentes = new FactureLigneVentes();
            this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
            this.factureLigneVentes.setFacligCode("FORMULE2");
            this.factureLigneVentes.setFacligOrdre(var2.size() + 2);
            this.factureLigneVentes.setFacligLibelle(this.formule2());
            this.factureLigneVentes.setFacligPt(0.0D);
            this.factureLigneVentes.setFacligTtc(0.0D);
            var2.add(this.factureLigneVentes);
         }
      }

      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.factureEnteteVentes.getFacAnal2() != null && !this.factureEnteteVentes.getFacAnal2().isEmpty()) {
         String var4 = "";
         if (this.factureEnteteVentes.getFacAnal2().contains(":")) {
            String[] var5 = this.factureEnteteVentes.getFacAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.factureEnteteVentes.getFacAnal2();
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
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.factureEnteteVentes.getFacDateImp() != null && this.factureEnteteVentes.getFacEtat() != 0) {
            var3 = true;
         }

         int var6 = 0;
         if (this.factureEnteteVentes.getFacTauxAcompte() != 0.0F && this.factureEnteteVentes.getFacNumAcompte() != null && !this.factureEnteteVentes.getFacNumAcompte().isEmpty()) {
            var2 = true;
            float var7 = 100.0F;
            new ArrayList();
            String var9 = this.utilDate.dateToStringFr(this.factureEnteteVentes.getFacDate());
            String var10 = var9.substring(6, 10) + "-" + var9.substring(3, 5) + "-" + var9.substring(0, 2);
            Date var11 = this.utilDate.stringToDateSQL(var10 + " 23:59:59");
            List var8 = this.factureEnteteVentesDao.rechercheFactureAcompte(this.tiers, this.factureEnteteVentes.getFacNum(), this.factureEnteteVentes.getFacNumAcompte(), var11, var4);
            if (var8.size() != 0) {
               for(int var12 = 0; var12 < var8.size(); ++var12) {
                  var7 -= ((FactureEnteteVentes)var8.get(var12)).getFacTauxAcompte();
               }
            }

            if (var7 <= 0.0F) {
               var6 = 9999;
            } else {
               var6 = var8.size();
            }
         }

         this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(this.factureEnteteVentes.getFacId(), var4);
         if (this.factureEnteteVentes != null) {
            this.factureEnteteVentes.setFacNbAcompte(var6);
            this.factureEnteteVentes.setFacDateImp(new Date());
            if (this.factureEnteteVentes.getFacEtat() == 0 && this.factureEnteteVentes.getFacEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
               this.factureEnteteVentes.setFacEtat(1);
               if (this.tiers.getTieDteDocument5() == null || this.factureEnteteVentes.getFacDate().after(this.tiers.getTieDteDocument5())) {
                  this.tiers.setTieDteDocument5(this.factureEnteteVentes.getFacDate());
                  this.tiers = this.tiersDao.modif(this.tiers, var4);
               }
            }

            this.factureEnteteVentes.setFacModeleImp(var1);
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var4);
            if (this.lesLignesList.size() != 0) {
               this.factureLigneVentes = new FactureLigneVentes();

               for(int var18 = 0; var18 < this.lesLignesList.size(); ++var18) {
                  this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var18);
                  this.factureLigneVentes.setVar_desciptif((String)null);
                  this.factureLigneVentes.setVar_photo((String)null);
                  this.factureLigneVentes.setVar_photo_taille(0);
                  if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                     if (this.produitsDao == null) {
                        this.produitsDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
                     }

                     this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var4);
                     if (this.produits != null) {
                        this.factureLigneVentes.setVar_desciptif(this.produits.getProDescrip());
                        if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
                           String var19 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
                           File var20 = new File(var19);
                           if (var20.exists()) {
                              this.factureLigneVentes.setVar_photo(var19);
                              if (this.produits.getProPhotoTaille() == 0) {
                                 this.factureLigneVentes.setVar_photo_taille(1);
                              } else {
                                 this.factureLigneVentes.setVar_photo_taille(2);
                              }
                           } else {
                              this.factureLigneVentes.setVar_photo((String)null);
                              this.factureLigneVentes.setVar_photo_taille(0);
                           }
                        } else {
                           this.factureLigneVentes.setVar_photo((String)null);
                           this.factureLigneVentes.setVar_photo_taille(0);
                        }
                     }
                  }
               }
            }
         }

         this.contacts = new Contacts();
         if (this.factureEnteteVentes.getFacIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.factureEnteteVentes.getFacIdContact(), var4);
         }

         var5.commit();
      } catch (HibernateException var16) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var2) {
         this.chargerDocumentLigne((Session)null);
      }

      return var3;
   }

   public void choixDeviseImpression(String var1, float var2) {
      this.devisePrint = var1;
      this.tauxPrint = var2;
   }

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var4);
            var1.setEntete("Impression facture");
            var1.setPageGarde(this.conversionGarde());
            if (this.factureEnteteVentes.getFacFormule1() != null && !this.factureEnteteVentes.getFacFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else if (this.factureEnteteVentes.getFacIdContact() != 0L) {
               this.contacts = this.contactDao.recupererContacts(this.factureEnteteVentes.getFacIdContact(), (Session)null);
               if (this.contacts != null) {
                  var1.setAdresseLivraison(this.contacts.getConadresse() + "\n" + this.contacts.getConbp() + " " + this.contacts.getConville());
               } else {
                  var1.setAdresseLivraison((String)null);
               }
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.factureEnteteVentes.getFacEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.factureEnteteVentes.setFacDevise(this.devisePrint);
            if (this.factureEnteteVentes.getFacDevise() == null || this.factureEnteteVentes.getFacDevise().isEmpty()) {
               this.factureEnteteVentes.setFacDevise(this.structureLog.getStrdevise());
            }

            if (!this.factureEnteteVentes.getFacDevise().equals("XOF") && !this.factureEnteteVentes.getFacDevise().equals("XAF")) {
               if (this.factureEnteteVentes.getFacDevise().equals("EUR")) {
                  var1.setNbCar(1);
               } else {
                  var1.setNbCar(0);
               }
            } else {
               var1.setNbCar(2);
            }

            if (this.devisePrint.equals(this.structureLog.getStrdevise())) {
               var1.setTaux(1.0F);
            } else if (this.tauxPrint != 0.0F) {
               var1.setTaux(this.tauxPrint);
               double var13 = this.utilNombre.myRound((this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
            var1.setIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
            var1.setTiersSelectionne(this.factureEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.factureEnteteVentes.getFacNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.factureEnteteVentes.getFacId());
            if (this.factureEnteteVentes.getFacAnal2() != null && !this.factureEnteteVentes.getFacAnal2().isEmpty()) {
               String var24 = "";
               if (this.factureEnteteVentes.getFacAnal2().contains(":")) {
                  String[] var14 = this.factureEnteteVentes.getFacAnal2().split(":");
                  var24 = var14[0];
               } else {
                  var24 = this.factureEnteteVentes.getFacAnal2();
               }

               new Parc();
               ParcDao var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var25 = var15.rechercheParc(var24, (Session)null);
               if (var25 != null) {
                  var1.setParc(var25);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setPoidsImp(var3);
            var1.setCompte(this.numeroAppelFonds);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.chargerDocumentLigne((Session)null);
         }
      } else if (var2 == 1) {
         if (var5 != null && !var5.isEmpty()) {
            var1.setRapport(var5);
            var1.setEntete("Impression de la liste des factures");
            var1.setTotauxHt("" + this.totauxHt);
            var1.setTotauxTaxe("" + this.totauxTaxe);
            var1.setTotauxTtc("" + this.totauxTtc);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "facture" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.getNature());
            var1.setId_doc(0L);
            JRBeanCollectionDataSource var22 = new JRBeanCollectionDataSource(this.lesEntetesList);
            var1.setjRBeanCollectionDataSource(var22);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 2 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression facture");
         var1.setMontant_lettre("");
         var1.setPageGarde("");
         var1.setAnnexe1("");
         var1.setAnnexe2("");
         var1.setDuplicata("");
         var1.setInfoOrigineDoc("");
         var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), 25));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.factureEnteteVentes.getFacEtat()));
         var1.setEmetteur("");
         var1.setDestinataire("");
         var1.setDestinataireCC("");
         var1.setDestinataireCCI("");
         var1.setId_doc(0L);
         var1.setFormat("PDF");
         if (this.lesEntetesList.size() != 0) {
            ArrayList var23 = new ArrayList();
            new FactureEnteteVentes();
            FactureEnteteVentes var26 = this.factureEnteteVentes;
            Session var27 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");

            for(int var28 = 0; var28 < this.lesEntetesList.size(); ++var28) {
               this.factureEnteteVentes = (FactureEnteteVentes)this.lesEntetesList.get(var28);
               if (this.factureEnteteVentes.getFacAnal2() != null && !this.factureEnteteVentes.getFacAnal2().isEmpty()) {
                  String var16 = "";
                  if (this.factureEnteteVentes.getFacAnal2().contains(":")) {
                     String[] var17 = this.factureEnteteVentes.getFacAnal2().split(":");
                     var16 = var17[0];
                  } else {
                     var16 = this.factureEnteteVentes.getFacAnal2();
                  }

                  new Parc();
                  ParcDao var18 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var31 = var18.rechercheParc(var16, var27);
                  if (var31 != null) {
                     var1.setParc((Parc)null);
                     this.factureEnteteVentes.setParcImmatriculation(var31.getPrcImmatriculation());
                  } else {
                     var1.setParc((Parc)null);
                     this.factureEnteteVentes.setParcImmatriculation("");
                  }
               } else {
                  var1.setParc((Parc)null);
                  this.factureEnteteVentes.setParcImmatriculation("");
               }

               boolean var30 = false;
               if (this.factureEnteteVentes.getFacDateImp() != null && this.factureEnteteVentes.getFacEtat() != 0) {
                  var30 = true;
               }

               this.chargerDocumentLigne(var27);
               new ArrayList();
               List var32 = this.calculeImpressionListe(var27);
               if (var32.size() != 0) {
                  new FactureLigneVentes();

                  for(int var19 = 0; var19 < var32.size(); ++var19) {
                     FactureLigneVentes var33 = (FactureLigneVentes)var32.get(var19);
                     var33.setFactureEnteteVentes(this.factureEnteteVentes);
                     this.montant_lettre = "";
                     var1.setTaux(1.0F);
                     double var20 = this.utilNombre.myRound((this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc()) / (double)this.tauxPrint, 2);
                     this.montant_lettre = this.utilNombre.begin(var20, this.structureLog.getStrdevise());
                     var33.getFactureEnteteVentes().setMontantLettre(this.montant_lettre);
                     var1.setStructureLog(this.structureLog);
                     var1.setNature(this.nature);
                     var1.setNumDoc(this.factureEnteteVentes.getFacNum());
                     var33.getFactureEnteteVentes().setCodeSecurity(var1.calculeSecurityCode());
                     var33.getFactureEnteteVentes().setDupplicata("" + var30);
                     var33.getFactureEnteteVentes().setInfoOrigineDoc(this.infoOrigineDoc);
                     var33.getFactureEnteteVentes().setParcImmatriculation(this.factureEnteteVentes.getParcImmatriculation());
                     var23.add(var33);
                  }
               }
            }

            this.utilInitHibernate.closeSession();
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            JRBeanCollectionDataSource var29 = new JRBeanCollectionDataSource(var23);
            var1.setjRBeanCollectionDataSource(var29);
            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.factureEnteteVentes = var26;
            this.chargerDocumentLigne((Session)null);
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
            this.uniteGraph = "FACTURES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "FACTURES : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "FACTURES : Quantites";
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

         new FactureEnteteVentes();
         new FactureLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         String var6 = "";

         FactureEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (FactureEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getFacNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getFacNum() + "'";
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

                  var14 = (FactureEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getFacDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getFacNomResponsable() != null && !var14.getFacNomResponsable().isEmpty()) {
                        var17 = var14.getFacNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getFacNomCommercial() != null && !var14.getFacNomCommercial().isEmpty()) {
                        var17 = var14.getFacNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getFacNomEquipe() != null && !var14.getFacNomEquipe().isEmpty()) {
                        var17 = var14.getFacNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getFacNomTiers() != null && !var14.getFacNomTiers().isEmpty()) {
                        var17 = var14.getFacNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getFacSource() != null && !var14.getFacSource().isEmpty()) {
                        var17 = var14.getFacSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getFacAnal4() != null && !var14.getFacAnal4().isEmpty()) {
                        var17 = var14.getFacAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getFacRegion() != null && !var14.getFacRegion().isEmpty()) {
                        var17 = var14.getFacRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getFacSecteur() != null && !var14.getFacSecteur().isEmpty()) {
                        var17 = var14.getFacSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getFacPdv() != null && !var14.getFacPdv().isEmpty()) {
                        var17 = var14.getFacPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getFacSite() != null && !var14.getFacSite().isEmpty()) {
                        var17 = var14.getFacSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getFacDepartement() != null && !var14.getFacDepartement().isEmpty()) {
                        var17 = var14.getFacDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getFacService() != null && !var14.getFacService().isEmpty()) {
                        var17 = var14.getFacService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getFacSerie() != null && !var14.getFacSerie().isEmpty()) {
                        var17 = var14.getFacSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getFacTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getFacDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getFacDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getFacDate().getMonth() + 1 >= 1 && var14.getFacDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getFacDate().getMonth() + 1 >= 4 && var14.getFacDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getFacDate().getMonth() + 1 >= 7 && var14.getFacDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getFacDate().getMonth() + 1 >= 10 && var14.getFacDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getFacDate().getMonth() + 1 >= 1 && var14.getFacDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getFacDate().getMonth() + 1 >= 7 && var14.getFacDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getFacDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.factureLigneVentesDao.chargerLesLignesFactures(var6, var5);
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

                  FactureLigneVentes var15 = (FactureLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getFactureEnteteVentes().getFacDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getFactureEnteteVentes().getFacNomResponsable() != null && !var15.getFactureEnteteVentes().getFacNomResponsable().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getFactureEnteteVentes().getFacNomCommercial() != null && !var15.getFactureEnteteVentes().getFacNomCommercial().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getFactureEnteteVentes().getFacNomEquipe() != null && !var15.getFactureEnteteVentes().getFacNomEquipe().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getFactureEnteteVentes().getFacNomTiers() != null && !var15.getFactureEnteteVentes().getFacNomTiers().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getFacligFamille() != null && !var15.getFacligFamille().isEmpty()) {
                        var8 = var15.getFacligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getFacligLibelle() != null && !var15.getFacligLibelle().isEmpty()) {
                        var8 = var15.getFacligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getFactureEnteteVentes().getFacSource() != null && !var15.getFactureEnteteVentes().getFacSource().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getFactureEnteteVentes().getFacAnal4() != null && !var15.getFactureEnteteVentes().getFacAnal4().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getFactureEnteteVentes().getFacRegion() != null && !var15.getFactureEnteteVentes().getFacRegion().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getFactureEnteteVentes().getFacSecteur() != null && !var15.getFactureEnteteVentes().getFacSecteur().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getFactureEnteteVentes().getFacPdv() != null && !var15.getFactureEnteteVentes().getFacPdv().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getFactureEnteteVentes().getFacSite() != null && !var15.getFactureEnteteVentes().getFacSite().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getFactureEnteteVentes().getFacDepartement() != null && !var15.getFactureEnteteVentes().getFacDepartement().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getFactureEnteteVentes().getFacService() != null && !var15.getFactureEnteteVentes().getFacService().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getFactureEnteteVentes().getFacSerie() != null && !var15.getFactureEnteteVentes().getFacSerie().isEmpty()) {
                        var8 = var15.getFactureEnteteVentes().getFacSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getFacligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getFacligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getFactureEnteteVentes().getFacDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getFactureEnteteVentes().getFacDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 >= 1 && var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 >= 4 && var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 >= 7 && var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 >= 10 && var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 >= 1 && var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 >= 7 && var15.getFactureEnteteVentes().getFacDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getFactureEnteteVentes().getFacDate().getHours();
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
         UtilPrint var6 = new UtilPrint(this.utilInitHibernate);
         String var8;
         if (var1 == 21) {
            FormDevisVentes var7 = new FormDevisVentes();
            var7.setBaseLog(this.baseLog);
            var7.setStructureLog(this.structureLog);
            var7.setUsersLog(this.usersLog);
            var7.setutilInitHibernate(this.utilInitHibernate);
            var7.InstancesDaoUtilses();
            var7.rechercheDOCUMENT(var2);
            if (var7.getDevisEnteteVentes() != null) {
               var7.setExercicesVentes(var7.getDevisEnteteVentes().getExerciceventes());
               var8 = var7.getDevisEnteteVentes().getDvsModeleImp();
               var7.setOptionsVentes(this.optionsVentes);
               var7.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var7.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le Devis n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le Devis n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 22) {
            FormCommandeVentes var9 = new FormCommandeVentes();
            var9.setBaseLog(this.baseLog);
            var9.setStructureLog(this.structureLog);
            var9.setUsersLog(this.usersLog);
            var9.setutilInitHibernate(this.utilInitHibernate);
            var9.InstancesDaoUtilses();
            var9.rechercheDOCUMENT(var2);
            if (var9.getCommandeEnteteVentes() != null) {
               var9.setExercicesVentes(var9.getCommandeEnteteVentes().getExerciceventes());
               var8 = var9.getCommandeEnteteVentes().getBcmModeleImp();
               var9.setOptionsVentes(this.optionsVentes);
               var9.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var9.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le BC n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le BC n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 23) {
            FormLivraisonVentes var10 = new FormLivraisonVentes();
            var10.setBaseLog(this.baseLog);
            var10.setStructureLog(this.structureLog);
            var10.setUsersLog(this.usersLog);
            var10.setutilInitHibernate(this.utilInitHibernate);
            var10.InstancesDaoUtilses();
            var10.rechercheDOCUMENT(var2);
            if (var10.getLivraisonEnteteVentes() != null) {
               var10.setExercicesVentes(var10.getLivraisonEnteteVentes().getExerciceventes());
               var8 = var10.getLivraisonEnteteVentes().getBlvModeleImp();
               var10.setOptionsVentes(this.optionsVentes);
               var10.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var10.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le BL n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le BL n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 24) {
            FormRetourVentes var11 = new FormRetourVentes();
            var11.setBaseLog(this.baseLog);
            var11.setStructureLog(this.structureLog);
            var11.setUsersLog(this.usersLog);
            var11.setutilInitHibernate(this.utilInitHibernate);
            var11.InstancesDaoUtilses();
            var11.rechercheDOCUMENT(var2);
            if (var11.getRetourEnteteVentes() != null) {
               var11.setExercicesVentes(var11.getRetourEnteteVentes().getExerciceventes());
               var8 = var11.getRetourEnteteVentes().getBrtModeleImp();
               var11.setOptionsVentes(this.optionsVentes);
               var11.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var11.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 25) {
            FormFactureVentes var12 = new FormFactureVentes();
            var12.setBaseLog(this.baseLog);
            var12.setStructureLog(this.structureLog);
            var12.setUsersLog(this.usersLog);
            var12.setutilInitHibernate(this.utilInitHibernate);
            var12.InstancesDaoUtilses();
            var12.rechercheDOCUMENT(var2);
            if (var12.getFactureEnteteVentes() != null) {
               var12.setExercicesVentes(var12.getFactureEnteteVentes().getExerciceventes());
               var8 = var12.getFactureEnteteVentes().getFacModeleImp();
               var12.setOptionsVentes(this.optionsVentes);
               var12.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var12.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 26) {
            FormAvoirVentes var13 = new FormAvoirVentes();
            var13.setBaseLog(this.baseLog);
            var13.setStructureLog(this.structureLog);
            var13.setUsersLog(this.usersLog);
            var13.setutilInitHibernate(this.utilInitHibernate);
            var13.InstancesDaoUtilses();
            var13.rechercheDOCUMENT(var2);
            if (var13.getAvoirEnteteVentes() != null) {
               var13.setExercicesVentes(var13.getAvoirEnteteVentes().getExerciceventes());
               var8 = var13.getAvoirEnteteVentes().getAvrModeleImp();
               var13.setOptionsVentes(this.optionsVentes);
               var13.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var13.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 27) {
            FormNoteDebitVentes var14 = new FormNoteDebitVentes();
            var14.setBaseLog(this.baseLog);
            var14.setStructureLog(this.structureLog);
            var14.setUsersLog(this.usersLog);
            var14.setutilInitHibernate(this.utilInitHibernate);
            var14.InstancesDaoUtilses();
            var14.rechercheDOCUMENT(var2);
            if (var14.getNoteDebitEnteteVentes() != null) {
               var14.setExercicesVentes(var14.getNoteDebitEnteteVentes().getExerciceventes());
               var8 = var14.getNoteDebitEnteteVentes().getNdbModeleImp();
               var14.setOptionsVentes(this.optionsVentes);
               var14.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var14.impression(var6, 0, 0, var8, "", "PDF", "", "", "", "", "");
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

   public void recalculTva(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.factureEnteteVentes = var1;
         this.tiers = this.factureEnteteVentes.getTiers();
         if (this.tiers.getTiecss() == 0 && this.structureLog.getStrcodepays().equals("0077")) {
            this.var_tc_calcul = true;
            this.var_tc_taux = 1.0F;
            this.var_tc_type = 7;
         } else {
            this.var_tc_calcul = false;
            this.var_tc_taux = 0.0F;
            this.var_tc_type = 0;
         }

         this.lesLignesList = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var2);
               }

               this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var2);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var2);
            }

            this.cumulPrix();
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var2);
         }
      }

   }

   public void recalculCss(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.factureEnteteVentes = var1;
         this.tiers = this.factureEnteteVentes.getTiers();
         this.lesLignesList = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneVentes = (FactureLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.factureLigneVentes.getFacligCode(), var2);
               }

               this.calculPrix(this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var2);
               this.factureLigneVentes = this.factureLigneVentesDao.modifLigne(this.factureLigneVentes, var2);
            }

            this.cumulPrix();
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var2);
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

   public FactureEnteteVentes getFactureEnteteVentes() {
      return this.factureEnteteVentes;
   }

   public void setFactureEnteteVentes(FactureEnteteVentes var1) {
      this.factureEnteteVentes = var1;
   }

   public FactureLigneVentes getFactureLigneVentes() {
      return this.factureLigneVentes;
   }

   public void setFactureLigneVentes(FactureLigneVentes var1) {
      this.factureLigneVentes = var1;
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

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
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

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
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

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
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

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public boolean isVar_affiche_banque_destination() {
      return this.var_affiche_banque_destination;
   }

   public void setVar_affiche_banque_destination(boolean var1) {
      this.var_affiche_banque_destination = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public boolean isValideLissage() {
      return this.valideLissage;
   }

   public void setValideLissage(boolean var1) {
      this.valideLissage = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
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

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
   }

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public double getTotManuel() {
      return this.totManuel;
   }

   public void setTotManuel(double var1) {
      this.totManuel = var1;
   }

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
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

   public boolean isShowModalPanelGeneration() {
      return this.showModalPanelGeneration;
   }

   public void setShowModalPanelGeneration(boolean var1) {
      this.showModalPanelGeneration = var1;
   }

   public List getLesPeriodesGeneration() {
      return this.lesPeriodesGeneration;
   }

   public void setLesPeriodesGeneration(List var1) {
      this.lesPeriodesGeneration = var1;
   }

   public String getVar_periodeGeneration() {
      return this.var_periodeGeneration;
   }

   public void setVar_periodeGeneration(String var1) {
      this.var_periodeGeneration = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
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

   public double getVar_montant_trf() {
      return this.var_montant_trf;
   }

   public void setVar_montant_trf(double var1) {
      this.var_montant_trf = var1;
   }

   public String getMessageStockNegatif() {
      return this.messageStockNegatif;
   }

   public void setMessageStockNegatif(String var1) {
      this.messageStockNegatif = var1;
   }

   public int getValidationLigne() {
      return this.validationLigne;
   }

   public void setValidationLigne(int var1) {
      this.validationLigne = var1;
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

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public List getLesClientsItems() {
      return this.lesClientsItems;
   }

   public void setLesClientsItems(List var1) {
      this.lesClientsItems = var1;
   }

   public long getVar_idTiersGeneration() {
      return this.var_idTiersGeneration;
   }

   public void setVar_idTiersGeneration(long var1) {
      this.var_idTiersGeneration = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
   }

   public List getMesCaissesSeriesItems() {
      return this.mesCaissesSeriesItems;
   }

   public void setMesCaissesSeriesItems(List var1) {
      this.mesCaissesSeriesItems = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesTypeReglementsCaisse() {
      return this.mesTypeReglementsCaisse;
   }

   public void setMesTypeReglementsCaisse(List var1) {
      this.mesTypeReglementsCaisse = var1;
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

   public String getInpNomTiersEnCours() {
      return this.inpNomTiersEnCours;
   }

   public void setInpNomTiersEnCours(String var1) {
      this.inpNomTiersEnCours = var1;
   }

   public String getInpNomDestinataire() {
      return this.inpNomDestinataire;
   }

   public void setInpNomDestinataire(String var1) {
      this.inpNomDestinataire = var1;
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

   public int getModeCalcul() {
      return this.modeCalcul;
   }

   public void setModeCalcul(int var1) {
      this.modeCalcul = var1;
   }

   public int getModeCommision() {
      return this.modeCommision;
   }

   public void setModeCommision(int var1) {
      this.modeCommision = var1;
   }

   public int getModeFacturation() {
      return this.modeFacturation;
   }

   public void setModeFacturation(int var1) {
      this.modeFacturation = var1;
   }

   public int getModePresentation() {
      return this.modePresentation;
   }

   public void setModePresentation(int var1) {
      this.modePresentation = var1;
   }

   public float getTauxCommission() {
      return this.tauxCommission;
   }

   public void setTauxCommission(float var1) {
      this.tauxCommission = var1;
   }

   public String getLibelle1() {
      return this.libelle1;
   }

   public void setLibelle1(String var1) {
      this.libelle1 = var1;
   }

   public String getLibelle2() {
      return this.libelle2;
   }

   public void setLibelle2(String var1) {
      this.libelle2 = var1;
   }

   public double getMontant1() {
      return this.montant1;
   }

   public void setMontant1(double var1) {
      this.montant1 = var1;
   }

   public double getMontant2() {
      return this.montant2;
   }

   public void setMontant2(double var1) {
      this.montant2 = var1;
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

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public float getTauxCss() {
      return this.tauxCss;
   }

   public void setTauxCss(float var1) {
      this.tauxCss = var1;
   }

   public List getMesServicesInterimItems() {
      return this.mesServicesInterimItems;
   }

   public void setMesServicesInterimItems(List var1) {
      this.mesServicesInterimItems = var1;
   }

   public boolean isValidatioPeriode() {
      return this.validatioPeriode;
   }

   public void setValidatioPeriode(boolean var1) {
      this.validatioPeriode = var1;
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

   public List getMesImpressionsFacturesItems() {
      return this.mesImpressionsFacturesItems;
   }

   public void setMesImpressionsFacturesItems(List var1) {
      this.mesImpressionsFacturesItems = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public String getModeleFacture() {
      return this.modeleFacture;
   }

   public void setModeleFacture(String var1) {
      this.modeleFacture = var1;
   }

   public DataModel getDatamodelEnteteGene() {
      return this.datamodelEnteteGene;
   }

   public void setDatamodelEnteteGene(DataModel var1) {
      this.datamodelEnteteGene = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
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

   public boolean isShowModalPanelPrintReleve() {
      return this.showModalPanelPrintReleve;
   }

   public void setShowModalPanelPrintReleve(boolean var1) {
      this.showModalPanelPrintReleve = var1;
   }

   public boolean isVar_transit() {
      return this.var_transit;
   }

   public void setVar_transit(boolean var1) {
      this.var_transit = var1;
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
