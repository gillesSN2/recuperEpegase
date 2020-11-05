package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ProcessEnteteAchats;
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
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
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
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureDevisDelaisLivraison;
import com.epegase.systeme.xml.LectureDevisModeReglement;
import com.epegase.systeme.xml.LectureModeleDevis;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetModeleFacture;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;
import org.xml.sax.SAXException;

public class FormDevisVentes implements Serializable {
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
   private Contacts contacts;
   private List mesContactItem = new ArrayList();
   private DevisEnteteVentes devisEnteteVentes = new DevisEnteteVentes();
   private DevisEnteteVentesDao devisEnteteVentesDao;
   private List lesEntetesList = new ArrayList();
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean verrouNum = false;
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
   private List mesParcsItems;
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private List mesAffairesItems = new ArrayList();
   private String numeroPfManuel;
   private boolean showModalPanelAnnuler = false;
   private boolean showModalPanelGele = false;
   private List mesModesReglementsItems = new ArrayList();
   private List mesDelaisLivraisonItems = new ArrayList();
   private DevisLigneVentes devisLigneVentes = new DevisLigneVentes();
   private DevisLigneVentesDao devisLigneVentesDao;
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
   private boolean printTexte;
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
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
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
   private String devisePrint;
   private float tauxPrint;
   private DocumentTraceVentes documentTraceVentes;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
   private List mesCaissesItems = new ArrayList();
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private ReglementsDao reglementsDao;
   private boolean afficheRecu;
   private transient DataModel datamodelRecu = new ListDataModel();
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
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
   private boolean memoSuivi;
   private boolean relance1;
   private boolean relance2;
   private boolean relance3;
   private String nomUserRelance1;
   private String nomUserRelance2;
   private String nomUserRelance3;
   private String libelleRabRis;
   private boolean ristourne;
   private boolean modeleDevis = false;
   private List lesModeleDevis = new ArrayList();
   private transient DataModel dataModelModeleDevis = new ListDataModel();
   private boolean showModalPanelModelDevis = false;
   private double totModeleDevis;
   private double totAbnDevis;

   public FormDevisVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionsVentes.getAxeActivite().equals("1")) {
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

      this.periode = this.optionsVentes.getAffichInGlobViewDEVIS();
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

      LectureDevisModeReglement var1 = new LectureDevisModeReglement(this.structureLog.getStrid());
      this.mesModesReglementsItems = var1.getMesElementsItems();
      if (this.mesModesReglementsItems == null || this.mesModesReglementsItems.size() == 0) {
         this.mesModesReglementsItems = null;
      }

      LectureDevisDelaisLivraison var2 = new LectureDevisDelaisLivraison(this.structureLog.getStrid());
      this.mesDelaisLivraisonItems = var2.getMesElementsItems();
      if (this.mesDelaisLivraisonItems == null || this.mesDelaisLivraisonItems.size() == 0) {
         this.mesDelaisLivraisonItems = null;
      }

      File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "ventes" + File.separator + "configuration" + File.separator + "modeleDevis.xml");
      if (var3.exists()) {
         this.modeleDevis = true;
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

   public void autorisationSuivi() {
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

      this.memoSuivi = true;
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
      this.devisEnteteVentes = this.devisEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.devisEnteteVentes != null) {
         this.devisePrint = this.devisEnteteVentes.getDvsDevise();
         this.lesLignesList = this.devisLigneVentesDao.chargerLesLignes(this.devisEnteteVentes, (Session)null);
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
         List var12 = this.devisEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new DevisEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               DevisEnteteVentes var16 = (DevisEnteteVentes)var12.get(var17);
               if (var16.getDvsActivite() != null && !var16.getDvsActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getDvsActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getDvsActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getDvsActivite().contains(this.var_colonne3)) {
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
         new DevisEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            DevisEnteteVentes var18 = (DevisEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var18.getDvsTotTtc();
            var4 += var18.getDvsTotReglement();
            var6 += var18.getDvsTotHt();
            var8 += var18.getDvsTotTva();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.datamodelEntete.setWrappedData(this.lesEntetesList);
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
            this.devisEnteteVentes = (DevisEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.devisEnteteVentes.getDvsNomTiers();
            this.inpIdTiersEnCours = this.devisEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.devisEnteteVentes.getDvsNomContact();
            this.memoSuivi = false;
            this.nomUserRelance1 = "";
            this.nomUserRelance2 = "";
            this.nomUserRelance3 = "";
            this.relance1 = false;
            this.relance2 = false;
            this.relance3 = false;
            this.var_date = this.devisEnteteVentes.getDvsDate();
            if (this.devisEnteteVentes.getDvsDate().getHours() <= 9) {
               this.var_heure = "0" + this.devisEnteteVentes.getDvsDate().getHours();
            } else {
               this.var_heure = "" + this.devisEnteteVentes.getDvsDate().getHours();
            }

            if (this.devisEnteteVentes.getDvsDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.devisEnteteVentes.getDvsDate().getMinutes();
            } else {
               this.var_minute = "" + this.devisEnteteVentes.getDvsDate().getMinutes();
            }

            if (this.devisEnteteVentes.getDvsDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.devisEnteteVentes.getDvsDate().getSeconds();
            } else {
               this.var_seconde = "" + this.devisEnteteVentes.getDvsDate().getSeconds();
            }

            this.tiers = this.devisEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.numeroPfManuel = this.devisEnteteVentes.getDvsAnal4();
            this.var_nom_contact = this.devisEnteteVentes.getDvsIdContact();
            this.var_nom_responsable = this.devisEnteteVentes.getDvsIdResponsable();
            this.var_nom_commercial = this.devisEnteteVentes.getDvsIdCommercial();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteListe");
            this.chargerDocumentLigne(var4);
            this.chargerBonEncaissement(var4);
            this.chargerDocumentTrace(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
            this.chargerLesParcs(var4);
            this.chargerLesRelances(var4);
            this.chargerModeEcheanceAffichage();
            this.var_nom_responsable = this.devisEnteteVentes.getDvsIdResponsable();
            this.var_nom_commercial = this.devisEnteteVentes.getDvsIdCommercial();
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

            this.montantTtcElmt = this.devisEnteteVentes.getDvsTotTtc();
            this.montantReglementElmt = this.devisEnteteVentes.getDvsTotReglement();
            this.montantElmTotBonEnc = this.devisEnteteVentes.getDvsTotTtc() - this.var_tot_bon_encaissement;
            this.montantSoldeElmt = this.devisEnteteVentes.getDvsTotTtc() - this.devisEnteteVentes.getDvsTotReglement();
            this.cumulPrix();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.devisEnteteVentes.getDvsTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }

            this.utilInitHibernate.closeSession();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.devisEnteteVentes != null) {
         if (this.devisEnteteVentes.getDvsEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.devisEnteteVentes.getDvsDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.devisEnteteVentes.getDvsDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.devisEnteteVentes.getDvsId() > 0L) {
         this.lesLignesList = this.devisLigneVentesDao.chargerLesLignes(this.devisEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.devisEnteteVentes != null && this.devisEnteteVentes.getDvsEtat() != 0 && this.devisEnteteVentes.getDvsAffaire() != null && !this.devisEnteteVentes.getDvsAffaire().isEmpty()) {
         this.mesAffairesItems.add(new SelectItem(this.devisEnteteVentes.getDvsAffaire(), this.devisEnteteVentes.getDvsAffaire()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.devisEnteteVentes.getDvsId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.devisEnteteVentes.getDvsId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = false;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.devisEnteteVentes.getDvsTotTtc()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteListe");
      this.datamodelDocumentTrace = new ListDataModel();
      new ArrayList();
      Object var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      new ArrayList();
      ArrayList var7 = new ArrayList();
      new ArrayList();
      ArrayList var9 = new ArrayList();
      new ArrayList();
      ArrayList var11 = new ArrayList();
      ArrayList var12 = new ArrayList();
      new ArrayList();
      ArrayList var14 = new ArrayList();
      if (this.devisEnteteVentes.getDvsId() > 0L) {
         List var2 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(this.devisEnteteVentes.getDvsId(), this.nature, var1);
         if (var2.size() == 0) {
            var2 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(this.devisEnteteVentes.getDvsId(), this.nature, var1);
         }

         int var15;
         int var16;
         for(var15 = 0; var15 < var2.size(); ++var15) {
            var3 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(((DocumentTraceVentes)var2.get(var15)).getDoctraDstId(), ((DocumentTraceVentes)var2.get(var15)).getDoctraDstType(), var1);
            if (var4.size() != 0) {
               for(var16 = 0; var16 < var4.size(); ++var16) {
                  ((List)var3).add(var4.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < ((List)var3).size(); ++var15) {
            List var6 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(((DocumentTraceVentes)((List)var3).get(var15)).getDoctraDstId(), ((DocumentTraceVentes)((List)var3).get(var15)).getDoctraDstType(), var1);
            if (var6.size() != 0) {
               for(var16 = 0; var16 < var6.size(); ++var16) {
                  var5.add(var6.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var5.size(); ++var15) {
            List var10 = this.documentTraceVentesDao.chargerLesDocumentsTraceOrigine(((DocumentTraceVentes)var5.get(var15)).getDoctraDstId(), ((DocumentTraceVentes)var5.get(var15)).getDoctraDstType(), var1);
            if (var10.size() != 0) {
               for(var16 = 0; var16 < var10.size(); ++var16) {
                  var9.add(var10.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var9.size(); ++var15) {
            List var13 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var9.get(var15)).getDoctraOrgId(), 26, var1);
            if (var13.size() != 0) {
               for(var16 = 0; var16 < var13.size(); ++var16) {
                  var12.add(var13.get(var16));
               }
            }
         }

         for(var15 = 0; var15 < var5.size(); ++var15) {
            List var8 = this.documentTraceVentesDao.chargerLesDocumentsTraceDestination(((DocumentTraceVentes)var5.get(var15)).getDoctraOrgId(), 24, var1);
            if (var8.size() != 0) {
               for(var16 = 0; var16 < var8.size(); ++var16) {
                  var7.add(var8.get(var16));
               }
            }
         }

         long var18 = (long)(this.devisEnteteVentes.getDvsDate().getYear() + 1900 - 2);

         int var17;
         for(var17 = 0; var17 < var2.size(); ++var17) {
            if (((DocumentTraceVentes)var2.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var2.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var2.get(var17));
            }
         }

         for(var17 = 0; var17 < ((List)var3).size(); ++var17) {
            if (((DocumentTraceVentes)((List)var3).get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)((List)var3).get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(((List)var3).get(var17));
            }
         }

         for(var17 = 0; var17 < var5.size(); ++var17) {
            if (((DocumentTraceVentes)var5.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var5.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var5.get(var17));
            }
         }

         for(var17 = 0; var17 < var7.size(); ++var17) {
            if (((DocumentTraceVentes)var7.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var7.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var7.get(var17));
            }
         }

         for(var17 = 0; var17 < var9.size(); ++var17) {
            if (((DocumentTraceVentes)var9.get(var17)).getDoctraOrgDate() != null && (long)(((DocumentTraceVentes)var9.get(var17)).getDoctraOrgDate().getYear() + 1900) >= var18) {
               var14.add(var9.get(var17));
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
      if (this.devisEnteteVentes != null && this.devisEnteteVentes.getDvsSerie() != null && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.devisEnteteVentes.getDvsSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.devisEnteteVentes.getDvsId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerLesRelances(Session var1) throws HibernateException, NamingException {
      this.nomUserRelance1 = "";
      this.nomUserRelance2 = "";
      this.nomUserRelance3 = "";
      this.relance1 = false;
      this.relance2 = false;
      this.relance3 = false;
      if (this.devisEnteteVentes.getDvsSuivi() == 1) {
         new Users();
         Users var2;
         if (this.devisEnteteVentes.getDvsUserRelance1() != 0L) {
            var2 = this.usersDao.selectByIdUsers(this.devisEnteteVentes.getDvsUserRelance1(), var1);
            if (var2 != null) {
               this.nomUserRelance1 = var2.getUsrPatronyme();
            }
         }

         if (this.devisEnteteVentes.getDvsUserRelance2() != 0L) {
            var2 = this.usersDao.selectByIdUsers(this.devisEnteteVentes.getDvsUserRelance2(), var1);
            if (var2 != null) {
               this.nomUserRelance2 = var2.getUsrPatronyme();
            }
         }

         if (this.devisEnteteVentes.getDvsUserRelance3() != 0L) {
            var2 = this.usersDao.selectByIdUsers(this.devisEnteteVentes.getDvsUserRelance3(), var1);
            if (var2 != null) {
               this.nomUserRelance3 = var2.getUsrPatronyme();
            }
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.devisEnteteVentes.getDvsActivite() != null && !this.devisEnteteVentes.getDvsActivite().isEmpty() && this.devisEnteteVentes.getDvsActivite().contains(":")) {
         String[] var1 = null;
         if (!this.devisEnteteVentes.getDvsActivite().contains("#")) {
            var1 = this.devisEnteteVentes.getDvsActivite().split(":");
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
            String[] var2 = this.devisEnteteVentes.getDvsActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.devisEnteteVentes.getDvsTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.devisEnteteVentes.getDvsTotHt() - this.totalImputation;
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
      this.memoSuivi = false;
      this.documentTraceVentes = null;
      this.devisEnteteVentes = new DevisEnteteVentes();
      this.devisEnteteVentes.setUsers(this.usersLog);
      this.devisEnteteVentes.setDvsIdCreateur(this.usersLog.getUsrid());
      this.devisEnteteVentes.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.devisEnteteVentes.setDvsDate(new Date());
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
      this.devisEnteteVentes.setDvsDateLivraison((Date)null);
      this.devisEnteteVentes.setDvsBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.devisEnteteVentes.setDvsIdCommercial(this.usersLog.getUsrid());
         this.devisEnteteVentes.setDvsNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.devisEnteteVentes.setDvsIdResponsable(this.usersLog.getUsrid());
         this.devisEnteteVentes.setDvsNomResponsable(this.usersLog.getUsrPatronyme());
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
      this.relance1 = false;
      this.relance2 = false;
      this.relance3 = false;
      this.nomUserRelance1 = "";
      this.nomUserRelance2 = "";
      this.nomUserRelance3 = "";
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
      if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
      } else {
         var4 = 0;
      }

      this.devisEnteteVentes.setDvsDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.devisEnteteVentes.setDvsDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      this.memoSuivi = false;
      if (this.devisEnteteVentes != null) {
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
            this.mesUsersItem.add(new SelectItem(this.devisEnteteVentes.getDvsIdResponsable(), this.devisEnteteVentes.getDvsNomResponsable()));
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
      this.memoSuivi = false;
      if (this.devisEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.devisEnteteVentes.getDvsIdResponsable(), this.devisEnteteVentes.getDvsNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.devisEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.devisEnteteVentes.getDvsEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.devisEnteteVentes.setDvsEtat(1);
               this.devisEnteteVentes.setDvsDateValide(new Date());
               this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle devis (C.) N° " + this.devisEnteteVentes.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteVentes.getDvsDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument1() == null || this.devisEnteteVentes.getDvsDate().after(this.tiers.getTieDteDocument1())) {
               this.tiers.setTieDteDocument1(this.devisEnteteVentes.getDvsDate());
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
      if (this.devisEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.devisEnteteVentes.getDvsEtat() == 1) {
               this.devisEnteteVentes.setDvsEtat(0);
               this.devisEnteteVentes.setDvsDateValide((Date)null);
               this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle devis (C.) N° " + this.devisEnteteVentes.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteVentes.getDvsDate()));
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
      if (this.devisEnteteVentes != null) {
         this.devisEnteteVentes.setDvsEtat(0);
         this.devisEnteteVentes.setDvsDateAnnule((Date)null);
         this.devisEnteteVentes.setDvsMotifAnnule("");
         this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.devisEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.devisEnteteVentes.getDvsNum();
            Date var4 = this.devisEnteteVentes.getDvsDate();
            this.documentTraceVentes = new DocumentTraceVentes();
            this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(this.devisEnteteVentes.getDvsId(), this.nature, var1);
            if (this.documentTraceVentes != null) {
               long var5 = this.documentTraceVentes.getDoctraOrgId();
               this.documentTraceVentesDao.delete(this.documentTraceVentes, var1);
            }

            this.lesEntetesList.remove(this.devisEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.devisLigneVentesDao.deleteAllLigne(this.devisEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.devisEnteteVentes.getDvsId(), this.nature, var1);
            this.devisEnteteVentesDao.delete(this.devisEnteteVentes.getDvsId(), var1);
            if (this.optionsVentes.getAxeDossier().equals("2") && this.devisEnteteVentes.getDvsAnal4() != null && !this.devisEnteteVentes.getDvsAnal4().isEmpty()) {
               PlansAnalytiquesDao var12 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               this.plansAnalytiques = var12.rechercheAffaire(this.devisEnteteVentes.getDvsAnal4(), var1);
               if (this.plansAnalytiques != null) {
                  this.plansAnalytiques.setAnaAffaireDateDevis((Date)null);
                  this.plansAnalytiques = var12.modif(this.plansAnalytiques, var1);
               }
            }

            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression Devis N° " + var3 + " du " + var4);
            this.espionDao.mAJEspion(var13, var1);
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

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.devisEnteteVentes != null) {
         this.gestionDuppRevDocument(0);
      }

   }

   public void revisionDocument() throws HibernateException, NamingException, Exception {
      if (this.devisEnteteVentes != null) {
         this.gestionDuppRevDocument(1);
      }

   }

   public void gestionDuppRevDocument(int var1) throws HibernateException, NamingException, Exception {
      if (this.devisEnteteVentes != null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         this.chargerDocumentLigne(var2);
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.devisEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.devisEnteteVentes.setUsers(this.usersLog);
            this.devisEnteteVentes.setDvsIdCreateur(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.devisEnteteVentes.setDvsDate(new Date());
            this.devisEnteteVentes.setDvsDateCreat(new Date());
            this.devisEnteteVentes.setDvsDateModif((Date)null);
            this.devisEnteteVentes.setDvsIdModif(0L);
            this.devisEnteteVentes.setDvsNomModif("");
            this.calculDateValidite();
            this.devisEnteteVentes.setDvsDateLivraison((Date)null);
            if (var1 == 1) {
               if (this.devisEnteteVentes.getDvsNum().contains("#")) {
                  String[] var11 = this.devisEnteteVentes.getDvsNum().split("#");
                  int var5 = Integer.parseInt(var11[1]);
                  this.devisEnteteVentes.setDvsNum(var11[0] + "#" + (var5 + 1));
               } else {
                  this.devisEnteteVentes.setDvsNum(this.devisEnteteVentes.getDvsNum() + "#1");
               }
            } else {
               this.devisEnteteVentes.setDvsNum("");
               if (!this.devisEnteteVentes.getDvsSerie().equalsIgnoreCase("X") && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
                  this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var2));
               } else {
                  long var4 = this.devisEnteteVentesDao.selectLastNum(var2);
                  this.devisEnteteVentes.setDvsNum("" + var4);
               }
            }

            this.verifieExistenceHabilitation(var2);
            this.devisEnteteVentes.setDvsDateAnnule((Date)null);
            this.devisEnteteVentes.setDvsMotifAnnule("");
            this.devisEnteteVentes.setDvsDateImp((Date)null);
            this.devisEnteteVentes.setDvsDateTransforme((Date)null);
            this.devisEnteteVentes.setDvsEtat(0);
            this.devisEnteteVentes.setDvsContener("");
            this.devisEnteteVentes = this.devisEnteteVentesDao.duppliquer(this.devisEnteteVentes, var2);
            if (this.lesLignesList.size() != 0) {
               this.devisLigneVentesDao.duppliquerLigne(this.lesLignesList, this.devisEnteteVentes, var2);
            }

            var3.commit();
         } catch (HibernateException var9) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.devisEnteteVentes.getDvsId(), this.devisEnteteVentes.getDvsNum(), this.devisEnteteVentes.getDvsNomTiers(), this.devisEnteteVentes.getDvsDate(), this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), this.devisEnteteVentes.getDvsModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var2), this.devisEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
      }

   }

   public void razNumreoPortefeuille() {
      this.numeroPfManuel = "";
   }

   public void fusionnerDocument() throws NamingException, Exception {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      long var3 = 0L;

      for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
         if (((DevisEnteteVentes)this.lesEntetesList.get(var5)).isVar_select_ligne()) {
            if (var3 == 0L) {
               var3 = ((DevisEnteteVentes)this.lesEntetesList.get(var5)).getTiers().getTieid();
            }

            if (((DevisEnteteVentes)this.lesEntetesList.get(var5)).getTiers().getTieid() == var3) {
               var1.add(this.lesEntetesList.get(var5));
               var2.add(((DevisEnteteVentes)this.lesEntetesList.get(var5)).getDvsNum());
            }
         }
      }

      if (var1.size() != 0) {
         Session var19 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         this.chargerDocumentLigne(var19);
         Transaction var6 = null;

         try {
            var6 = var19.beginTransaction();
            this.devisEnteteVentes = (DevisEnteteVentes)var1.get(0);
            this.devisEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.devisEnteteVentes.setUsers(this.usersLog);
            this.devisEnteteVentes.setDvsIdCreateur(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.devisEnteteVentes.setDvsDate(new Date());
            this.devisEnteteVentes.setDvsDateCreat(new Date());
            this.devisEnteteVentes.setDvsDateModif((Date)null);
            this.devisEnteteVentes.setDvsIdModif(0L);
            this.devisEnteteVentes.setDvsNomModif("");
            this.devisEnteteVentes.setDvsNum("");
            this.devisEnteteVentes.setDvsIdResponsable(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.devisEnteteVentes.setDvsDateLivraison((Date)null);
            if (!this.devisEnteteVentes.getDvsSerie().equalsIgnoreCase("X") && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
               this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var19));
            } else {
               long var7 = this.devisEnteteVentesDao.selectLastNum(var19);
               this.devisEnteteVentes.setDvsNum("" + var7);
            }

            this.verifieExistenceHabilitation(var19);
            this.devisEnteteVentes.setDvsDateAnnule((Date)null);
            this.devisEnteteVentes.setDvsMotifAnnule("");
            this.devisEnteteVentes.setDvsDateImp((Date)null);
            this.devisEnteteVentes.setDvsDateTransforme((Date)null);
            this.devisEnteteVentes.setDvsEtat(0);
            this.devisEnteteVentes = this.devisEnteteVentesDao.duppliquer(this.devisEnteteVentes, var19);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.devisEnteteVentes.getDvsId(), this.devisEnteteVentes.getDvsNum(), this.devisEnteteVentes.getDvsNomTiers(), this.devisEnteteVentes.getDvsDate(), this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), this.devisEnteteVentes.getDvsModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var19), this.devisEnteteVentes.getVar_format_devise(), 0, var19);
            }

            this.lesLignesList.clear();
            Object var20 = new ArrayList();
            int var8 = 0;
            int var9 = 0;

            while(true) {
               if (var9 >= var2.size()) {
                  if (this.lesLignesList.size() != 0) {
                     this.devisLigneVentesDao.duppliquerLigne(this.lesLignesList, this.devisEnteteVentes, var19);
                  }

                  this.cumulPrix();
                  this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var19);
                  var6.commit();
                  break;
               }

               String var10 = ((String)var2.get(var9)).toString();
               new DevisEnteteVentes();
               DevisEnteteVentes var11 = this.devisEnteteVentesDao.selectByNum(var19, var10);
               if (var11 != null) {
                  ((List)var20).clear();
                  var20 = this.devisLigneVentesDao.chargerLesLignes(var11, var19);
                  if (((List)var20).size() != 0) {
                     DevisLigneVentes var12 = new DevisLigneVentes();
                     ++var8;
                     var12.setDvsligOrdre(var8);
                     var12.setDvsligLibelle("---> Suivant Devis N° " + var10);
                     this.lesLignesList.add(var12);

                     for(int var13 = 0; var13 < ((List)var20).size(); ++var13) {
                        ++var8;
                        var12 = (DevisLigneVentes)((List)var20).get(var13);
                        var12.setDvsligOrdre(var8);
                        this.lesLignesList.add(var12);
                     }
                  }
               }

               ++var9;
            }
         } catch (HibernateException var17) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete();
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         boolean var4 = false;
         boolean var5 = false;
         boolean var6 = false;
         if (this.devisEnteteVentes.getDvsTypeTransforme() != 0) {
            var6 = this.usersChronoDao.existByUserNat(this.usersLog, this.devisEnteteVentes.getDvsTypeTransforme(), var1);
            if (var6) {
               String var7 = "";
               if (this.devisEnteteVentes.getDvsTypeTransforme() == 22) {
                  var7 = "Bon de commande";
               } else if (this.devisEnteteVentes.getDvsTypeTransforme() == 23) {
                  var7 = "Bon de livraison";
               } else if (this.devisEnteteVentes.getDvsTypeTransforme() == 24) {
                  var7 = "Bon retour";
               } else if (this.devisEnteteVentes.getDvsTypeTransforme() == 25) {
                  var7 = "Facture";
               } else if (this.devisEnteteVentes.getDvsTypeTransforme() == 26) {
                  var7 = "Avoir";
               } else if (this.devisEnteteVentes.getDvsTypeTransforme() == 27) {
                  var7 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.devisEnteteVentes.getDvsTypeTransforme(), var7));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 22, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(22, "Bon de commande"));
            }

            var3 = this.usersChronoDao.existByUserNat(this.usersLog, 23, var1);
            if (var3) {
               this.documentTrfItems.add(new SelectItem(23, "Bon de livraison"));
            }

            var4 = this.usersChronoDao.existByUserNat(this.usersLog, 25, var1);
            if (var4) {
               this.documentTrfItems.add(new SelectItem(25, "Facture"));
            }

            var5 = this.usersChronoDao.existByUserNat(this.usersLog, 27, var1);
            if (var5) {
               this.documentTrfItems.add(new SelectItem(27, "Note de débit"));
            }
         }

         new DevisEnteteVentes();

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            DevisEnteteVentes var11 = (DevisEnteteVentes)this.lesEntetesList.get(var8);
            if (var11.getDvsId() > 0L && var11.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.devisLigneVentesDao.chargerLesLignes(var11, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var9 = 0; var9 < this.lesLignesList.size(); ++var9) {
                     new DevisLigneVentes();
                     DevisLigneVentes var10 = (DevisLigneVentes)this.lesLignesList.get(var9);
                     this.documentDetailTrf.add(var10);
                  }
               }
            }
         }

         this.lesLignesList.clear();
         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         this.utilInitHibernate.closeSession();
      }

   }

   public void annule() throws HibernateException, NamingException {
      if (this.devisEnteteVentes != null && this.memoSuivi && this.devisEnteteVentes.getDvsEtat() <= 1) {
         this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes);
      }

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
      if (this.devisEnteteVentes.getDvsTypeReg() != 0 && this.devisEnteteVentes.getDvsTypeReg() != 3) {
         if (this.devisEnteteVentes.getDvsTypeReg() != 1 && this.devisEnteteVentes.getDvsTypeReg() != 2 && this.devisEnteteVentes.getDvsTypeReg() != 10) {
            if (this.devisEnteteVentes.getDvsTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.devisEnteteVentes.getDvsModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.devisEnteteVentes.getDvsModeReg() != null && !this.devisEnteteVentes.getDvsModeReg().isEmpty() && this.devisEnteteVentes.getDvsModeReg().contains(":")) {
         String[] var2 = this.devisEnteteVentes.getDvsModeReg().split(":");
         var1 = var2[0];
      }

      new ObjetReglement();

      int var3;
      ObjetReglement var6;
      for(var3 = 0; var3 < this.lesModeReglementClientsListe.size(); ++var3) {
         var6 = (ObjetReglement)this.lesModeReglementClientsListe.get(var3);
         if (var6.getCategories().equals(var1)) {
            if (var6.getEcheances() == null || var6.getEcheances().isEmpty()) {
               var6.setEcheances("0");
            }

            this.devisEnteteVentes.setDvsTypeReg(Integer.parseInt(var6.getEcheances()));
            this.devisEnteteVentes.setDvsModeReg(var6.getCategories() + ":" + var6.getLibelles());
            this.devisEnteteVentes.setDvsNbJourReg(0);
            this.devisEnteteVentes.setDvsArrondiReg(0);
            break;
         }
      }

      if (this.devisEnteteVentes.getDvsTypeReg() != 0 && this.devisEnteteVentes.getDvsTypeReg() != 3) {
         if (this.devisEnteteVentes.getDvsTypeReg() != 1 && this.devisEnteteVentes.getDvsTypeReg() != 2 && this.devisEnteteVentes.getDvsTypeReg() != 10) {
            if (this.devisEnteteVentes.getDvsTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var3 = 0; var3 < this.lesModeReglementClientsListe.size(); ++var3) {
               var6 = (ObjetReglement)this.lesModeReglementClientsListe.get(var3);
               if (var6.getCategories().equals(var1)) {
                  this.devisEnteteVentes.setDvsTypeReg(Integer.parseInt(var6.getEcheances()));
                  this.devisEnteteVentes.setDvsModeReg(var6.getCategories() + ":" + var6.getLibelles());
                  int var4 = 0;
                  if (var6.getNbjours() != null && !var6.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var6.getNbjours());
                  }

                  this.devisEnteteVentes.setDvsNbJourReg(var4);
                  int var5 = 0;
                  if (var6.getArrondis() != null && !var6.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var6.getArrondis());
                  }

                  this.devisEnteteVentes.setDvsArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.devisEnteteVentes.getDvsModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.devisEnteteVentes.getDvsDate(), this.devisEnteteVentes.getDvsTypeReg(), this.devisEnteteVentes.getDvsNbJourReg(), this.devisEnteteVentes.getDvsArrondiReg());
      this.devisEnteteVentes.setDvsDateEcheReg(var1);
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
         if (this.devisEnteteVentes.getDvsId() != 0L) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.devisEnteteVentes.setDvsDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.devisEnteteVentes.getUsers() == null) {
            this.devisEnteteVentes.setUsers(this.usersLog);
         }

         if (this.tiers.getTietype().equals("1")) {
            this.tiers.setTietype("2");
            if (this.tiers.getTiegenre().equals("010")) {
               this.tiers.setTiegenre("020");
            } else if (this.tiers.getTiegenre().equals("011")) {
               this.tiers.setTiegenre("021");
            }

            this.tiers = this.tiersDao.modif(this.tiers, var1);
         }

         this.devisEnteteVentes.setTiers(this.tiers);
         if ((this.devisEnteteVentes.getDvsCat() == null || this.devisEnteteVentes.getDvsCat().isEmpty()) && this.devisEnteteVentes.getTiers().getTienomfamille() != null && !this.devisEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.devisEnteteVentes.setDvsCat(this.devisEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.devisEnteteVentes.setDvsCivilTiers("");
         } else {
            this.devisEnteteVentes.setDvsCivilTiers(this.devisEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.devisEnteteVentes.getDvsDiversTiers() == 99) {
               this.devisEnteteVentes.setDvsIdContact(0L);
               this.devisEnteteVentes.setDvsNomContact("");
               this.devisEnteteVentes.setDvsCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.devisEnteteVentes.setDvsIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.devisEnteteVentes.setDvsNomContact(var3.getConpatronyme());
                     this.devisEnteteVentes.setDvsCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.devisEnteteVentes.setDvsNomContact(var3.getConservice());
                     this.devisEnteteVentes.setDvsCivilContact("SERVICE/SITE:");
                  } else {
                     this.devisEnteteVentes.setDvsIdContact(0L);
                     this.devisEnteteVentes.setDvsNomContact("");
                     this.devisEnteteVentes.setDvsCivilContact("");
                  }
               } else {
                  this.devisEnteteVentes.setDvsIdContact(0L);
                  this.devisEnteteVentes.setDvsNomContact("");
                  this.devisEnteteVentes.setDvsCivilContact("");
               }
            }

            this.devisEnteteVentes.setDvsTiersRegroupe(this.tiers.getTiesigle());
         }

         this.devisEnteteVentes.setDvsIdResponsable(0L);
         this.devisEnteteVentes.setDvsNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.devisEnteteVentes.setDvsIdResponsable(var15.getUsrid());
            this.devisEnteteVentes.setDvsNomResponsable(var15.getUsrPatronyme());
         }

         this.devisEnteteVentes.setDvsIdCommercial(0L);
         this.devisEnteteVentes.setDvsNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.devisEnteteVentes.setDvsIdCommercial(var4.getUsrid());
               this.devisEnteteVentes.setDvsNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.devisEnteteVentes.setDvsIdEquipe(0L);
         this.devisEnteteVentes.setDvsNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.devisEnteteVentes.getDvsIdResponsable(), var1);
            if (this.equipes != null) {
               this.devisEnteteVentes.setDvsIdEquipe(this.equipes.getEquId());
               this.devisEnteteVentes.setDvsNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), var16, this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.devisEnteteVentes.getDvsDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.devisEnteteVentes.getDvsDevise());
               this.devisEnteteVentes.setDvsFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsDate()));
            }
         }

         if (this.mesModesReglementsItems == null || this.mesModesReglementsItems.size() == 0) {
            if (this.devisEnteteVentes.getDvsTypeReg() == 0) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement comptant");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 1) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement terme sur date de facture");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 2) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement terme sur fin de mois");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 3) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement arrivée/payé");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 4) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement bon encaissement");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 5) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement comptant, 50% à la commande, le solde à la livraison");
            }
         }

         if (this.accesAffaires) {
         }

         if (this.devisEnteteVentes.getDvsId() != 0L) {
            if (this.devisEnteteVentes.getDvsEtat() == 6) {
               if (this.devisEnteteVentes.getDvsEtatVal() == 1) {
                  this.devisEnteteVentes.setDvsEtat(0);
               } else {
                  this.devisEnteteVentes.setDvsEtat(0);
               }
            }

            this.devisEnteteVentes.setDvsDateModif(new Date());
            this.devisEnteteVentes.setDvsIdModif(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var16);
               this.devisLigneVentes.setDvsligOrdre(var16);
               this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
            }
         } else {
            this.devisEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.devisEnteteVentes.setDvsDateCreat(new Date());
            this.devisEnteteVentes.setDvsIdCreateur(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.devisEnteteVentes.getDvsSerie().equalsIgnoreCase("X") && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
               this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var1));
               boolean var18 = false;

               label436:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label436;
                     }

                     new DevisEnteteVentes();
                     DevisEnteteVentes var19 = this.devisEnteteVentesDao.pourParapheurByNum(this.devisEnteteVentes.getDvsNum(), this.devisEnteteVentes.getDvsSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.devisEnteteVentesDao.selectLastNum(var1);
               this.devisEnteteVentes.setDvsNum("" + var17);
            }

            this.devisEnteteVentes.setDvsEtat(0);
            this.devisEnteteVentes.setDvsEtatVal(0);
            this.devisEnteteVentes.setDvsDateValide((Date)null);
            this.devisEnteteVentes = this.devisEnteteVentesDao.insert(this.devisEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.devisEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.devisEnteteVentes.getDvsId(), this.devisEnteteVentes.getDvsNum(), this.devisEnteteVentes.getDvsNomTiers(), this.devisEnteteVentes.getDvsDate(), this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), this.devisEnteteVentes.getDvsModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.devisEnteteVentes.getVar_format_devise(), 0, var1);
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

   public void saveAttente() throws IOException, HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.devisEnteteVentes.setDvsDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.devisEnteteVentes.getUsers() == null) {
            this.devisEnteteVentes.setUsers(this.usersLog);
         }

         if (this.tiers.getTietype().equals("1")) {
            this.tiers.setTietype("2");
            if (this.tiers.getTiegenre().equals("010")) {
               this.tiers.setTiegenre("020");
            } else if (this.tiers.getTiegenre().equals("011")) {
               this.tiers.setTiegenre("021");
            }

            this.tiers = this.tiersDao.modif(this.tiers, var1);
         }

         this.devisEnteteVentes.setTiers(this.tiers);
         if ((this.devisEnteteVentes.getDvsCat() == null || this.devisEnteteVentes.getDvsCat().isEmpty()) && this.devisEnteteVentes.getTiers().getTienomfamille() != null && !this.devisEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.devisEnteteVentes.setDvsCat(this.devisEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.devisEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.devisEnteteVentes.setDvsCivilTiers("");
         } else {
            this.devisEnteteVentes.setDvsCivilTiers(this.devisEnteteVentes.getTiers().getTiecivilite());
         }

         if (this.contDest) {
            this.devisEnteteVentes.setDvsIdContact(0L);
            this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.devisEnteteVentes.getDvsNomContact(), var1);
            if (this.plansAnalytiques != null) {
               this.devisEnteteVentes.setDvsTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            } else {
               this.devisEnteteVentes.setDvsTiersRegroupe("");
            }
         } else {
            if (this.devisEnteteVentes.getDvsDiversTiers() == 99) {
               this.devisEnteteVentes.setDvsIdContact(0L);
               this.devisEnteteVentes.setDvsNomContact("");
               this.devisEnteteVentes.setDvsCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.devisEnteteVentes.setDvsIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.devisEnteteVentes.setDvsNomContact(var3.getConpatronyme());
                     this.devisEnteteVentes.setDvsCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.devisEnteteVentes.setDvsNomContact(var3.getConservice());
                     this.devisEnteteVentes.setDvsCivilContact("SERVICE/SITE:");
                  } else {
                     this.devisEnteteVentes.setDvsIdContact(0L);
                     this.devisEnteteVentes.setDvsNomContact("");
                     this.devisEnteteVentes.setDvsCivilContact("");
                  }
               } else {
                  this.devisEnteteVentes.setDvsIdContact(0L);
                  this.devisEnteteVentes.setDvsNomContact("");
                  this.devisEnteteVentes.setDvsCivilContact("");
               }
            }

            this.devisEnteteVentes.setDvsTiersRegroupe(this.tiers.getTiesigle());
         }

         this.devisEnteteVentes.setDvsIdResponsable(0L);
         this.devisEnteteVentes.setDvsNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.devisEnteteVentes.setDvsIdResponsable(var15.getUsrid());
            this.devisEnteteVentes.setDvsNomResponsable(var15.getUsrPatronyme());
         }

         this.devisEnteteVentes.setDvsIdCommercial(0L);
         this.devisEnteteVentes.setDvsNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.devisEnteteVentes.setDvsIdCommercial(var4.getUsrid());
               this.devisEnteteVentes.setDvsNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.devisEnteteVentes.setDvsIdEquipe(0L);
         this.devisEnteteVentes.setDvsNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.devisEnteteVentes.getDvsIdResponsable(), var1);
            if (this.equipes != null) {
               this.devisEnteteVentes.setDvsIdEquipe(this.equipes.getEquId());
               this.devisEnteteVentes.setDvsNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), var16, this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.devisEnteteVentes.getDvsDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.devisEnteteVentes.getDvsDevise());
               this.devisEnteteVentes.setDvsFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsDate()));
            }
         }

         if (this.mesModesReglementsItems == null || this.mesModesReglementsItems.size() == 0) {
            if (this.devisEnteteVentes.getDvsTypeReg() == 0) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement comptant");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 1) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement terme sur date de facture");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 2) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement terme sur fin de mois");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 3) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement arrivée/payé");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 4) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement bon encaissement");
            } else if (this.devisEnteteVentes.getDvsTypeReg() == 5) {
               this.devisEnteteVentes.setDvsConditionReg("Paiement comptant, 50% à la commande, le solde à la livraison");
            }
         }

         if (this.accesAffaires) {
         }

         if (this.devisEnteteVentes.getDvsId() != 0L) {
            this.devisEnteteVentes.setDvsEtat(6);
            this.devisEnteteVentes.setDvsEtatVal(0);
            this.devisEnteteVentes.setDvsDateValide((Date)null);
            this.devisEnteteVentes.setDvsDateModif(new Date());
            this.devisEnteteVentes.setDvsIdModif(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var16);
               this.devisLigneVentes.setDvsligOrdre(var16);
               this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
            }
         } else {
            this.devisEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.devisEnteteVentes.setDvsDateCreat(new Date());
            this.devisEnteteVentes.setDvsIdCreateur(this.usersLog.getUsrid());
            this.devisEnteteVentes.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.devisEnteteVentes.getDvsSerie().equalsIgnoreCase("X") && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
               this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var1));
               boolean var18 = false;

               label417:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label417;
                     }

                     new DevisEnteteVentes();
                     DevisEnteteVentes var19 = this.devisEnteteVentesDao.pourParapheurByNum(this.devisEnteteVentes.getDvsNum(), this.devisEnteteVentes.getDvsSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.devisEnteteVentesDao.selectLastNum(var1);
               this.devisEnteteVentes.setDvsNum("" + var17);
            }

            this.devisEnteteVentes.setDvsEtat(6);
            this.devisEnteteVentes.setDvsEtatVal(0);
            this.devisEnteteVentes.setDvsDateValide((Date)null);
            this.devisEnteteVentes = this.devisEnteteVentesDao.insert(this.devisEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.devisEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
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
      this.devisEnteteVentes.setDvsSite(this.usersLog.getUsrSite());
      this.devisEnteteVentes.setDvsDepartement(this.usersLog.getUsrDepartement());
      this.devisEnteteVentes.setDvsService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.devisEnteteVentes.setDvsIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.devisEnteteVentes.getDvsNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.devisEnteteVentes.setDvsTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.devisEnteteVentes.setDvsRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.devisEnteteVentes.setDvsSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.devisEnteteVentes.setDvsPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.devisEnteteVentes.setDvsTiersRegroupe(this.tiers.getTiesigle());
            this.devisEnteteVentes.setDvsRegion(this.tiers.getTieregion());
            this.devisEnteteVentes.setDvsSecteur(this.tiers.getTiesecteur());
            this.devisEnteteVentes.setDvsPdv(this.tiers.getTiepdv());
         }
      } else {
         this.devisEnteteVentes.setDvsTiersRegroupe(this.tiers.getTiesigle());
         this.devisEnteteVentes.setDvsRegion(this.tiers.getTieregion());
         this.devisEnteteVentes.setDvsSecteur(this.tiers.getTiesecteur());
         this.devisEnteteVentes.setDvsPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.devisEnteteVentes.setDvsActivite("");
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

               this.devisEnteteVentes.setDvsActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new DevisLigneVentes();
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

                  DevisLigneVentes var13 = (DevisLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getDvsligCode() != null && !var13.getDvsligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getDvsligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getDvsligPt());
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
                              var7.setPrix(var13.getDvsligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getDvsligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.devisEnteteVentes.setDvsActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.devisEnteteVentes.setDvsAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.devisEnteteVentes.getDvsAnal4() != null && this.devisEnteteVentes.getDvsAnal4().length() <= 2) {
         this.devisEnteteVentes.setDvsAnal4("");
      }

      if (!this.var_anal_parc) {
         this.devisEnteteVentes.setDvsAnal2("");
      } else if (this.devisEnteteVentes.getDvsAnal2() != null && this.devisEnteteVentes.getDvsAnal2().length() <= 2) {
         this.devisEnteteVentes.setDvsAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.devisEnteteVentes.setDvsEtatVal(1);
         this.devisEnteteVentes.setDvsEtat(0);
         this.devisEnteteVentes.setDvsDateValide((Date)null);
         return true;
      } else {
         this.devisEnteteVentes.setDvsEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.devisEnteteVentes.setDvsEtat(1);
               this.devisEnteteVentes.setDvsDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.devisEnteteVentes.setDvsEtat(0);
               this.devisEnteteVentes.setDvsDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void AjouterModeleDefaut() {
      if (this.modeleDevis) {
         LectureModeleDevis var1 = new LectureModeleDevis(this.structureLog.getStrid());
         this.lesModeleDevis = var1.getLesModeles();
         this.dataModelModeleDevis.setWrappedData(this.lesModeleDevis);
         this.showModalPanelModelDevis = true;
      }

   }

   public void calculeModeleDevis() {
      this.totModeleDevis = 0.0D;
      this.totAbnDevis = 0.0D;
      if (this.lesModeleDevis.size() != 0) {
         new ObjetModeleFacture();

         for(int var2 = 0; var2 < this.lesModeleDevis.size(); ++var2) {
            ObjetModeleFacture var1 = (ObjetModeleFacture)this.lesModeleDevis.get(var2);
            if (var1.isSelect()) {
               this.totModeleDevis += var1.getPu();
               this.totAbnDevis += var1.getAbn();
            }
         }
      }

   }

   public void fermerModeleDevis() {
      this.showModalPanelModelDevis = false;
      this.addLigne();
   }

   public void valideModeleDevis() throws HibernateException, NamingException, IOException, Exception {
      if (this.lesLignesList.size() != 0) {
         this.devisLigneVentesDao.deleteAllLigne(this.devisEnteteVentes, (Session)null);
      }

      this.lesLignesList.clear();
      String var3;
      int var4;
      if (this.lesModeleDevis.size() != 0) {
         double var1 = 0.0D;
         var3 = "";
         var4 = 0;
         new ObjetModeleFacture();

         for(int var6 = 0; var6 < this.lesModeleDevis.size(); ++var6) {
            ObjetModeleFacture var5 = (ObjetModeleFacture)this.lesModeleDevis.get(var6);
            if (var5.isSelect()) {
               ++var4;
               this.devisLigneVentes = new DevisLigneVentes();
               this.devisLigneVentes.setDvsligOrdre(var4);
               this.devisLigneVentes.setDvsligCode(var5.getCode());
               this.devisLigneVentes.setDvsligFamille(var5.getFamille());
               this.devisLigneVentes.setDvsligLibelle(var5.getLibelle());
               if (var5.getTva() != null && !var5.getTva().isEmpty() && var5.getTva().equals("?")) {
                  this.devisLigneVentes.setDvsligTaxe(this.optionsVentes.getTlvDefaut());
               } else {
                  this.devisLigneVentes.setDvsligTaxe(var5.getTva());
               }

               this.devisLigneVentes.setDvsligPu(var5.getPu());
               this.devisLigneVentes.setDvsligQte(var5.getQte());
               var1 += var5.getAbn();
               var3 = var5.getTva();
               this.lesLignesList.add(this.devisLigneVentes);
            }
         }

         if (var1 != 0.0D) {
            this.devisLigneVentes = new DevisLigneVentes();
            this.devisLigneVentes.setDvsligOrdre(var4 + 1);
            this.devisLigneVentes.setDvsligCode("ABN");
            this.devisLigneVentes.setDvsligFamille("0202");
            this.devisLigneVentes.setDvsligLibelle("Abonnement aux services SaaS HORUS");
            this.devisLigneVentes.setDvsligTaxe(var3);
            this.devisLigneVentes.setDvsligPu(var1);
            this.devisLigneVentes.setDvsligUnite("mensuel");
            this.devisLigneVentes.setDvsligQte(1.0F);
            this.lesLignesList.add(this.devisLigneVentes);
         }
      }

      if (this.lesLignesList.size() != 0) {
         Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         Transaction var2 = null;

         try {
            var2 = var21.beginTransaction();
            int var22 = 0;

            while(true) {
               if (var22 >= this.lesLignesList.size()) {
                  var2.commit();
                  break;
               }

               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var22);
               if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var21);
                  if (this.produits == null) {
                     this.produits = new Produits();
                     this.produits.setProCode(this.devisLigneVentes.getDvsligCode());
                     this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.devisLigneVentes.getDvsligFamille(), var21);
                     if (this.famillesProduitsVentes != null) {
                        this.produits.setProVteCode(this.famillesProduitsVentes.getFamvteCode());
                        this.produits.setProVteLib(this.famillesProduitsVentes.getFamvteLibelleFr());
                     } else {
                        this.produits.setProVteCode((String)null);
                        this.produits.setProVteLib((String)null);
                     }

                     this.produits.setProVteNat("1601");
                     this.produits.setProLibClient(this.devisLigneVentes.getDvsligLibelle());
                     this.produits = this.produitsDao.insert(this.produits, var21);
                  }

                  this.devisLigneVentes.setDvsligLibelle(this.produits.getProLibClient());
               }

               ++var22;
            }
         } catch (HibernateException var19) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.devisEnteteVentes.getDvsId() == 0L) {
            this.save();
         }

         var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         var3 = null;

         try {
            Transaction var23 = var21.beginTransaction();
            var4 = 0;

            while(true) {
               if (var4 >= this.lesLignesList.size()) {
                  var23.commit();
                  break;
               }

               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var4);
               this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
               this.devisLigneVentes.setUnite((Unite)null);
               this.devisLigneVentes = this.devisLigneVentesDao.insertLigne(this.devisLigneVentes, var21);
               this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var21);
               ++var4;
            }
         } catch (HibernateException var17) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.cumulPrix();
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
      this.showModalPanelModelDevis = false;
      this.addLigne();
   }

   public void modeSuivi() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteListe");
      this.chargerLesRelances(var1);
      this.utilInitHibernate.closeSession();
   }

   public void ajouterRelance1() {
      this.devisEnteteVentes.setDvsDateRelance1(new Date());
      this.devisEnteteVentes.setDvsUserRelance1(this.usersLog.getUsrid());
      this.nomUserRelance1 = this.usersLog.getUsrPatronyme();
      this.relance1 = true;
      this.relance2 = false;
      this.relance3 = false;
   }

   public void ajouterRelance2() {
      this.devisEnteteVentes.setDvsDateRelance2(new Date());
      this.devisEnteteVentes.setDvsUserRelance2(this.usersLog.getUsrid());
      this.nomUserRelance2 = this.usersLog.getUsrPatronyme();
      this.relance2 = true;
      this.relance3 = false;
   }

   public void ajouterRelance3() {
      this.devisEnteteVentes.setDvsDateRelance3(new Date());
      this.devisEnteteVentes.setDvsUserRelance3(this.usersLog.getUsrid());
      this.nomUserRelance3 = this.usersLog.getUsrPatronyme();
      this.relance3 = true;
   }

   public void supprimerRelance1() {
      this.devisEnteteVentes.setDvsDateRelance1((Date)null);
      this.devisEnteteVentes.setDvsUserRelance1(0L);
      this.nomUserRelance1 = "";
      this.relance1 = false;
      this.relance2 = false;
      this.relance3 = false;
   }

   public void supprimerRelance2() {
      this.devisEnteteVentes.setDvsDateRelance2((Date)null);
      this.devisEnteteVentes.setDvsUserRelance2(0L);
      this.nomUserRelance2 = "";
      this.relance2 = false;
      this.relance3 = false;
   }

   public void supprimerRelance3() {
      this.devisEnteteVentes.setDvsDateRelance3((Date)null);
      this.devisEnteteVentes.setDvsUserRelance3(0L);
      this.nomUserRelance3 = "";
      this.relance3 = false;
   }

   public void annulerDocument() {
      if (this.devisEnteteVentes != null) {
         this.devisEnteteVentes.setDvsDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.devisEnteteVentes != null) {
         if (this.devisEnteteVentes.getDvsDateAnnule() == null) {
            this.devisEnteteVentes.setDvsDateAnnule(new Date());
         }

         this.devisEnteteVentes.setDvsEtat(3);
         this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation devis vente N° " + this.devisEnteteVentes.getDvsNum() + " le " + this.devisEnteteVentes.getDvsDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.devisEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void gelerDocument() {
      if (this.devisEnteteVentes != null) {
         this.devisEnteteVentes.setDvsDateAnnule(new Date());
         this.showModalPanelGele = true;
      }

   }

   public void annuleGeler() {
      this.showModalPanelGele = false;
   }

   public void miseajourGeler() throws HibernateException, NamingException {
      if (this.devisEnteteVentes != null) {
         if (this.devisEnteteVentes.getDvsDateAnnule() == null) {
            this.devisEnteteVentes.setDvsDateAnnule(new Date());
         }

         this.devisEnteteVentes.setDvsEtat(2);
         this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Geler devis vente N° " + this.devisEnteteVentes.getDvsNum() + " le " + this.devisEnteteVentes.getDvsDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.devisEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelGele = false;
      this.visibiliteBton = false;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.devisEnteteVentes.getDvsExoTva() == 0) {
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

      this.devisLigneVentes.setDvsligTaxe(var6);
      this.devisLigneVentes.setDvsligTauxTaxe(var5);
      double var35 = this.devisLigneVentes.getDvsligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.devisEnteteVentes.getDvsDevise());
      }

      var10 = this.devisLigneVentes.getDvsligQte();
      if (this.devisLigneVentes.getDvsligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.devisLigneVentes.setDvsligQteUtil(this.devisLigneVentes.getDvsligQte());
            var10 = this.devisLigneVentes.getDvsligQte() * this.devisLigneVentes.getDvsligLong();
         } else {
            this.devisLigneVentes.setDvsligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.devisLigneVentes.getDvsligCondition(), this.devisLigneVentes.getDvsligQte(), this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.devisLigneVentes.setDvsligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && this.devisLigneVentes.getDvsligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.devisLigneVentes.getDvsligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.devisLigneVentes.getDvsligRabais() * (double)this.devisLigneVentes.getDvsligQte();
      }

      if (this.devisLigneVentes.getDvsligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.devisLigneVentes.getDvsligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      if (this.devisLigneVentes.getDvsligExcluCalcul() == 1) {
         var17 = 0.0D;
      }

      double var19 = var17 * (double)this.devisLigneVentes.getDvsligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.devisLigneVentes.getDvsligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && this.devisLigneVentes.getDvsligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.devisLigneVentes.getDvsligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.devisLigneVentes.getDvsligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.devisLigneVentes.getDvsligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.devisLigneVentes.getDvsligQte(), 2);
      }

      this.devisLigneVentes.setDvsligPuRem(var25);
      this.devisLigneVentes.setDvsligPt(var17);
      this.devisLigneVentes.setDvsligTva(var21);
      this.devisLigneVentes.setDvsligTtc(var23);
      this.devisLigneVentes.setDvsligTc(0.0D);
      double var27 = 0.0D;
      if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && this.devisLigneVentes.getDvsligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.devisLigneVentes.getDvsligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.devisLigneVentes.getDvsligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.devisLigneVentes.getDvsligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.devisLigneVentes.getDvsligQte(), 2);
      }

      this.devisLigneVentes.setDvsligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.devisLigneVentes.getDvsligTauxTaxe() / 100.0D;
      this.devisLigneVentes.setDvsligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.devisEnteteVentes.setDvsTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.devisLigneVentes.setDvsligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
               if (this.devisLigneVentes.getDvsligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.devisLigneVentes.getDvsligTauxTaxe() / 100.0D;
                  this.devisLigneVentes.setDvsligTc(var33);
               }
            }
         } else {
            if (this.devisLigneVentes.getDvsligTva() != 0.0D) {
               var31 = var17 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.devisLigneVentes.setDvsligTc(var33);
         }
      } else {
         this.devisLigneVentes.setDvsligTc(0.0D);
         this.devisEnteteVentes.setDvsTauxTc(0.0F);
      }

      this.devisLigneVentes.setDvsligPt(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligPt(), this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligTva(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligTva(), this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligTtc(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligTtc(), this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligTc(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligTc(), this.devisEnteteVentes.getDvsDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.devisEnteteVentes.getDvsExoTva() == 0) {
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

      this.devisLigneVentes.setDvsligTaxe(var6);
      this.devisLigneVentes.setDvsligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul && this.devisLigneVentes.getDvsligTva() != 0.0D) {
         var10 = this.devisLigneVentes.getDvsligTtc();
         var12 = var10 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.devisLigneVentes.getDvsligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.devisLigneVentes.getDvsligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.devisLigneVentes.setDvsligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.devisLigneVentes.getDvsligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.devisLigneVentes.getDvsligRabais() * (double)this.devisLigneVentes.getDvsligQte();
      }

      double var14 = 0.0D;
      if (this.devisLigneVentes.getDvsligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.devisLigneVentes.getDvsligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.devisLigneVentes.getDvsligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.devisLigneVentes.getDvsligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.devisLigneVentes.getDvsligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.devisLigneVentes.setDvsligQteUtil(this.devisLigneVentes.getDvsligQte());
         } else {
            this.devisLigneVentes.setDvsligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.devisLigneVentes.getDvsligCondition(), this.devisLigneVentes.getDvsligQte(), this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.devisLigneVentes.setDvsligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.devisLigneVentes.getDvsligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.devisEnteteVentes.getDvsDevise()));
      if (this.devisLigneVentes.getDvsligExcluCalcul() == 1) {
         var24 = 0.0D;
         var20 = 0.0D;
      }

      double var26 = var20 * (double)this.devisLigneVentes.getDvsligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.devisEnteteVentes.getDvsDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligPuRem(var18);
      this.devisLigneVentes.setDvsligPuRemTtc(var20);
      this.devisLigneVentes.setDvsligPt(var24);
      this.devisLigneVentes.setDvsligTva(var32);
      this.devisLigneVentes.setDvsligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.devisEnteteVentes.setDvsTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.devisLigneVentes.setDvsligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
               if (this.devisLigneVentes.getDvsligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.devisLigneVentes.getDvsligTauxTaxe() / 100.0D;
                  this.devisLigneVentes.setDvsligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.devisEnteteVentes.getDvsTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.devisLigneVentes.setDvsligTc(var36);
         }
      } else {
         this.devisLigneVentes.setDvsligTc(0.0D);
         this.devisEnteteVentes.setDvsTauxTc(0.0F);
      }

      this.devisLigneVentes.setDvsligPt(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligPt(), this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligTva(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligTva(), this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligTtc(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligTtc(), this.devisEnteteVentes.getDvsDevise()));
      this.devisLigneVentes.setDvsligTc(this.utilNombre.myRoundDevise(this.devisLigneVentes.getDvsligTc(), this.devisEnteteVentes.getDvsDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException, ParseException {
      if (this.devisLigneVentes != null && this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.devisLigneVentes.getDvsligPuRemTtc() != 0.0D) {
               if (this.devisLigneVentes.getDvsligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.devisLigneVentes.getDvsligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.devisLigneVentes.getDvsligPuRem() != 0.0D) {
            if (this.devisLigneVentes.getDvsligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.devisLigneVentes.getDvsligPu() < this.prixPlancher) {
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
      if (this.lesLignesList.size() != 0) {
         new DevisLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            DevisLigneVentes var13 = (DevisLigneVentes)this.lesLignesList.get(var14);
            if (var13.getDvsligGroupe() == null || var13.getDvsligGroupe().isEmpty()) {
               var3 += var13.getDvsligPt();
               var5 += var13.getDvsligTva();
               var7 += var13.getDvsligTtc();
               var9 += var13.getDvsligTc();
               if (var13.getDvsligRabais() != 0.0D || var13.getDvsligTauxRemise() != 0.0F) {
                  var11 += var13.getDvsligPu() * (double)var13.getDvsligQte() - var13.getDvsligPt();
               }

               var1 = var1 + var13.getDvsligPt() - var13.getDvsligPump() * (double)var13.getDvsligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.devisEnteteVentes.setDvsTotHt(var3);
      this.devisEnteteVentes.setDvsTotTva(var5);
      this.devisEnteteVentes.setDvsTotTtc(var7);
      this.devisEnteteVentes.setDvsTotRemise(var11);
      this.devisEnteteVentes.setDvsTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.devisLigneVentes = (DevisLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         if (this.devisLigneVentes.getDvsligCode() != null && this.devisLigneVentes.getDvsligCode().length() >= 2 && !this.devisLigneVentes.getDvsligCode().equalsIgnoreCase("incoterm")) {
            this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.devisLigneVentes.setDvsligCode(this.produits.getProCode());
               this.devisLigneVentes.setDvsligFamille(this.produits.getProAchCode());
               this.devisLigneVentes.setDvsligStock(this.produits.getProStock());
               this.devisLigneVentes.setDvsligLong(this.produits.getProLongueur());
               this.devisLigneVentes.setDvsligLarg(this.produits.getProLargeur());
               this.devisLigneVentes.setDvsligHaut(this.produits.getProEpaisseur());
               this.devisLigneVentes.setDvsligDiam(this.produits.getProDiamExt());
               this.devisLigneVentes.setDvsligPoidsBrut(this.produits.getProPoidsBrut());
               this.devisLigneVentes.setDvsligPoidsNet(this.produits.getProPoidsNet());
               this.devisLigneVentes.setDvsligVolume(this.produits.getProVolume());
               this.devisLigneVentes.setDvsligNb(this.produits.getProNbUnite());
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

               if (this.devisLigneVentes.getDvsligPrintTexte() == 0) {
                  this.printTexte = true;
               } else {
                  this.printTexte = false;
               }

               this.griserchamps = true;
               if (this.devisLigneVentes.getDvsligTaxe() != null && !this.devisLigneVentes.getDvsligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTaxe() + ":" + this.devisLigneVentes.getDvsligTauxTaxe()));
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

         this.formRecherche.setProduits(this.produits);
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
         this.devisLigneVentes = (DevisLigneVentes)this.datamodelLigne.getRowData();
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
      this.devisLigneVentes = new DevisLigneVentes();
      this.mesTaxesVentesProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_depotProd = "";
      this.prixPlancher = 0.0D;
      this.griserValider = false;
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.devisLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.devisLigneVentes);
            this.lesLignesList.add(this.numLigne, this.devisLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var3);
               this.devisLigneVentes.setDvsligOrdre(var3);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
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
      if (this.devisLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.devisLigneVentes);
            this.lesLignesList.add(this.numLigne, this.devisLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var3);
               this.devisLigneVentes.setDvsligOrdre(var3);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
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
            if (this.devisLigneVentes.getDvsligId() == ((DevisLigneVentes)this.lesLignesList.get(var2)).getDvsligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() || this.devisLigneVentes.getDvsligLibelle() != null && !this.devisLigneVentes.getDvsligLibelle().isEmpty() || this.devisLigneVentes.getDvsligComplement() != null && !this.devisLigneVentes.getDvsligComplement().isEmpty()) {
         if (this.devisEnteteVentes.getDvsId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.devisLigneVentes.getDvsligQteUtil() == 0.0F) {
               this.devisLigneVentes.setDvsligQteUtil(this.devisLigneVentes.getDvsligQte());
            }

            this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.devisLigneVentes.setDvsligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.devisLigneVentes.setDvsligDepot(var3[0]);
               }
            } else {
               this.devisLigneVentes.setDvsligDepot("");
            }

            if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && this.devisLigneVentes.getDvsligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.devisLigneVentes.getDvsligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.devisLigneVentes.setDvsligDescription(var5);
               } else {
                  this.devisLigneVentes.setDvsligDescription("");
               }

               if (this.devisLigneVentes.getDvsligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.devisLigneVentes.setDvsligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.devisLigneVentes.setDvsligDescription("");
            }

            if (this.printTexte) {
               this.devisLigneVentes.setDvsligPrintTexte(0);
            } else {
               this.devisLigneVentes.setDvsligPrintTexte(1);
            }

            if (this.devisLigneVentes.getDvsligId() == 0L) {
               this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
               this.devisLigneVentes.setDvsligDevise(this.devisEnteteVentes.getDvsDevise());
               this.devisLigneVentes = this.devisLigneVentesDao.insertLigne(this.devisLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.devisLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new DevisLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  DevisLigneVentes var16 = (DevisLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getDvsligGroupe() != null && !var16.getDvsligGroupe().isEmpty() && var16.getDvsligGroupe().equals(this.memoProduits.getProCode())) {
                     this.devisLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.devisLigneVentes.getDvsligQte();
               new DevisLigneVentes();

               DevisLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (DevisLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getDvsligGroupe() != null && !var19.getDvsligGroupe().isEmpty() && var19.getDvsligGroupe().equals(var18)) {
                     this.devisLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new DevisLigneVentes();
                     var19.setDvsligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setDvsligCondition("");
                     var19.setDvsligComplement("");
                     var19.setDvsligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setDvsligDescription("");
                     var19.setDvsligDevise(this.devisEnteteVentes.getDvsDevise());
                     var19.setDvsligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setDvsligEchelle(0);
                     var19.setDvsligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setDvsligGroupe(var18);
                     var19.setDvsligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setDvsligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setDvsligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setDvsligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setDvsligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setDvsligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setDvsligOrdre(var8);
                     var19.setDvsligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setDvsligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setDvsligPt(0.0D);
                     var19.setDvsligPu(0.0D);
                     var19.setDvsligPuRem(0.0D);
                     var19.setDvsligPuRemTtc(0.0D);
                     var19.setDvsligPuTtc(0.0D);
                     var19.setDvsligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setDvsligQte(var9);
                     var19.setDvsligQteUtil(var19.getDvsligQte());
                     var19.setDvsligRabais(0.0D);
                     var19.setDvsligReference(var18);
                     var19.setDvsligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setDvsligTauxRemise(0.0F);
                     var19.setDvsligTauxTaxe(0.0F);
                     var19.setDvsligTaxe("");
                     var19.setDvsligTc(0.0D);
                     var19.setDvsligTtc(0.0D);
                     var19.setDvsligTva(0.0D);
                     var19.setDvsligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setDvsligVolume(0.0F);
                     var19.setDevisEnteteVentes(this.devisEnteteVentes);
                     var19 = this.devisLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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
      if (this.devisLigneVentes.getDvsligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.devisLigneVentes.getDvsligCode();
            int var4 = this.devisLigneVentes.getDvsligModeGroupe();
            String var5 = this.devisLigneVentes.getDvsligGroupe();
            this.devisLigneVentesDao.deleteOneLigne(this.devisLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new DevisLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  DevisLigneVentes var6 = (DevisLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getDvsligGroupe() != null && !var6.getDvsligGroupe().isEmpty() && var6.getDvsligGroupe().equals(var3)) {
                     this.devisLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " du Devis N° " + this.devisEnteteVentes.getDvsNum() + " du " + this.devisEnteteVentes.getDvsDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.devisEnteteVentes.getDvsNomTiers(), this.nature);
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
                     this.devisEnteteVentes.setDvsSerie(this.tiers.getTieserie());
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
            this.devisEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.devisEnteteVentes.setDvsCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.devisEnteteVentes.setDvsCivilTiers(this.devisEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.devisEnteteVentes.setDvsNomTiers(this.nomTier);
            this.devisEnteteVentes.setDvsTypeReg(this.tiers.getTietypereg());
            this.devisEnteteVentes.setDvsModeReg(this.tiers.getTiemodereg());
            this.calculMessageLitige();
            String var8 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var8 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var8 = this.tiers.getTiemodereg();
            }

            if (!var8.equals("") && !var8.equals("100")) {
               this.devisEnteteVentes.setDvsNbJourReg(this.tiers.getTienbecheance());
               this.devisEnteteVentes.setDvsArrondiReg(this.tiers.getTienbarrondi());
            } else {
               new ObjetReglement();

               for(int var5 = 0; var5 < this.lesModeReglementClientsListe.size(); ++var5) {
                  ObjetReglement var9 = (ObjetReglement)this.lesModeReglementClientsListe.get(var5);
                  if (var9.getDefaut().equals("true")) {
                     if (var9.getEcheances() == null || var9.getEcheances().isEmpty()) {
                        var9.setEcheances("0");
                     }

                     this.devisEnteteVentes.setDvsTypeReg(Integer.parseInt(var9.getEcheances()));
                     this.devisEnteteVentes.setDvsModeReg(var9.getCategories() + ":" + var9.getLibelles());
                     int var6 = 0;
                     if (var9.getNbjours() != null && !var9.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var9.getNbjours());
                     }

                     this.devisEnteteVentes.setDvsNbJourReg(var6);
                     int var7 = 0;
                     if (var9.getArrondis() != null && !var9.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var9.getArrondis());
                     }

                     this.devisEnteteVentes.setDvsArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.devisEnteteVentes.setDvsJournalReg(this.tiers.getTiejournalreg());
            this.devisEnteteVentes.setDvsCat(this.tiers.getTienomfamille());
            this.devisEnteteVentes.setDvsExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.devisEnteteVentes.setDvsExoDouane(1);
            }

            int var10 = this.tiers.getTieexotva();
            if (var10 >= 2) {
               var10 = 0;
            }

            this.devisEnteteVentes.setDvsExoTva(var10);
            if (this.var_tc_calcul) {
               this.devisEnteteVentes.setDvsTauxTc(this.var_tc_taux);
            } else {
               this.devisEnteteVentes.setDvsTauxTc(0.0F);
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

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.devisEnteteVentes.setDvsExoTva(1);
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.devisEnteteVentes.setDvsDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.devisEnteteVentes.setDvsDiversTiers(0);
               this.devisEnteteVentes.setDvsDiversNom("");
               this.devisEnteteVentes.setDvsDiversAdresse("");
               this.devisEnteteVentes.setDvsDiversVille("");
               this.devisEnteteVentes.setDvsDiversTel("");
               this.devisEnteteVentes.setDvsDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.devisEnteteVentes.setDvsDevise(this.tiers.getTiedevise());
            } else {
               this.devisEnteteVentes.setDvsDevise(this.structureLog.getStrdevise());
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
      this.devisEnteteVentes.setTiers(this.tiers);
      this.devisEnteteVentes.setDvsNomTiers("");
      this.devisEnteteVentes.setDvsCivilTiers("");
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
      if (!this.devisEnteteVentes.getDvsNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.devisEnteteVentes.getDvsCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.devisEnteteVentes.setDvsExoTva(0);
      } else {
         this.devisEnteteVentes.setDvsExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.devisEnteteVentes.setDvsExoDouane(0);
      } else {
         this.devisEnteteVentes.setDvsExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.devisEnteteVentes.setDvsTauxTc(this.var_tc_taux);
      } else {
         this.devisEnteteVentes.setDvsTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var3);
               if (this.devisEnteteVentes.getDvsExoTva() == 1) {
                  this.devisLigneVentes.setDvsligTaxe("");
                  this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
                  this.devisLigneVentes.setDvsligTva(0.0D);
               } else if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.devisLigneVentes.setDvsligTaxe("");
                        this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.devisLigneVentes.setDvsligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.devisLigneVentes.setDvsligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.devisLigneVentes.getDvsligTaxe(), var1);
                        if (var5 != null) {
                           this.devisLigneVentes.setDvsligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.devisLigneVentes.setDvsligTaxe(this.optionsVentes.getTvaDefaut());
                        this.devisLigneVentes.setDvsligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.devisLigneVentes.setDvsligTaxe("");
                        this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
                     }
                  } else {
                     this.devisLigneVentes.setDvsligTaxe("");
                     this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
                  }

                  if ((this.devisLigneVentes.getDvsligTaxe() == null || this.devisLigneVentes.getDvsligTaxe().isEmpty()) && this.optionsVentes.getTlvDefaut() != null && !this.optionsVentes.getTlvDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.devisLigneVentes.setDvsligTaxe(var5.getTaxvteCode());
                        this.devisLigneVentes.setDvsligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
            }
         }

         if (this.devisEnteteVentes.getDvsId() != 0L) {
            this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.devisLigneVentes = new DevisLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var3);
               this.devisLigneVentes.setDvsligTauxRemise(this.devisEnteteVentes.getDvsTauxRemise());
               this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var1);
            }
         }

         if (this.devisEnteteVentes.getDvsId() != 0L) {
            this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.devisEnteteVentes.getDvsNomContact(), this.nature);
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
         this.devisEnteteVentes.setDvsNomContact(this.plansAnalytiques.getAnaNomFr());
         this.devisEnteteVentes.setDvsCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.devisEnteteVentes.setDvsAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.devisEnteteVentes.setDvsNomContact("");
      this.devisEnteteVentes.setDvsCivilContact("");
      this.devisEnteteVentes.setDvsAnal4("");
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

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
         if (!this.devisLigneVentes.getDvsligCode().equals("-") && !this.devisLigneVentes.getDvsligCode().equals("=") && !this.devisLigneVentes.getDvsligCode().equalsIgnoreCase("incoterm")) {
            if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
               this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.devisLigneVentes.getDvsligCode(), this.nature, this.optionsVentes);
            } else {
               this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.devisLigneVentes.getDvsligCode(), this.nature, this.optionsVentes);
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
         } else {
            this.devisLigneVentes.setDvsligCode(this.devisLigneVentes.getDvsligCode().toUpperCase());
         }
      }

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         this.devisLigneVentes.setDvsligCode(this.produits.getProCode());
         this.devisLigneVentes.setDvsligProcess(this.produits.getProProcess());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.devisLigneVentes.setDvsligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.devisLigneVentes.setDvsligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.devisLigneVentes.setDvsligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.devisLigneVentes.setDvsligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.devisLigneVentes.setDvsligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.devisLigneVentes.setDvsligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.devisLigneVentes.setDvsligFamille(this.produits.getProVteCode());
         this.devisLigneVentes.setDvsligStock(this.produits.getProStock());
         this.devisLigneVentes.setDvsligLong(this.produits.getProLongueur());
         this.devisLigneVentes.setDvsligLarg(this.produits.getProLargeur());
         this.devisLigneVentes.setDvsligHaut(this.produits.getProEpaisseur());
         this.devisLigneVentes.setDvsligDiam(this.produits.getProDiamExt());
         this.devisLigneVentes.setDvsligPoidsBrut(this.produits.getProPoidsBrut());
         this.devisLigneVentes.setDvsligPoidsNet(this.produits.getProPoidsNet());
         this.devisLigneVentes.setDvsligVolume(this.produits.getProVolume());
         this.devisLigneVentes.setDvsligNb(this.produits.getProNbUnite());
         this.devisLigneVentes.setDvsligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.devisLigneVentes.setDvsligModeGroupe(this.produits.getProMode());
         if (this.produits.getProImpDesciption() == 1) {
            if (this.usersLog.getUsrVteLibelle() == 1) {
               this.verrou_libelle = true;
            } else {
               this.verrou_libelle = false;
            }
         } else {
            this.verrou_libelle = false;
         }

         this.printTexte = true;
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
                  this.devisLigneVentes.setDvsligTaxe(this.produits.getProVteTva());
                  this.devisLigneVentes.setDvsligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.devisLigneVentes.setDvsligTaxe("");
                  this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.devisLigneVentes.setDvsligTaxe(var8.getFamvteTaxe());
                  this.devisLigneVentes.setDvsligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.devisLigneVentes.setDvsligTaxe("");
               this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.devisEnteteVentes.getDvsExoTva() == 0 && (this.devisLigneVentes.getDvsligTaxe() == null || this.devisLigneVentes.getDvsligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.devisLigneVentes.setDvsligTaxe(var9.getTaxvteCode());
                  this.devisLigneVentes.setDvsligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.devisLigneVentes.setDvsligTaxe("");
            this.devisLigneVentes.setDvsligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.devisLigneVentes.getDvsligTauxTaxe() / 100.0D;
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
               this.devisLigneVentes.setDvsligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.devisLigneVentes.setDvsligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.devisLigneVentes.setDvsligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.devisLigneVentes.setDvsligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.devisLigneVentes.setDvsligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.devisLigneVentes.getDvsligPump() != 0.0D) {
            this.devisLigneVentes.setDvsligPu(this.devisLigneVentes.getDvsligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
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
      if (this.devisLigneVentes.getDvsligCode() == null || this.devisLigneVentes.getDvsligCode().isEmpty() || this.devisLigneVentes.getDvsligCode().length() < 2) {
         if (this.devisEnteteVentes.getDvsExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.devisLigneVentes.setDvsligTaxe(this.optionsVentes.getTvaDefaut());
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
      this.devisLigneVentes.setDvsligCode("");
      this.devisLigneVentes.setDvsligLibelle("");
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.printTexte = false;
      this.var_code_unite = 0;
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            var2 = this.devisLigneVentes.getDvsligPuTtc();
         } else {
            var2 = this.devisLigneVentes.getDvsligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(true, var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.devisLigneVentes.setDvsligPuTtc(this.prixUnitaires);
            this.devisLigneVentes.setDvsligPuRemTtc(this.prixUnitaires);
         } else {
            this.devisLigneVentes.setDvsligPu(this.prixUnitaires);
            this.devisLigneVentes.setDvsligPuRem(this.prixUnitaires);
         }

         double var4 = 0.0D;
         this.devisLigneVentes.setDvsligPromotion("");
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
                  this.calculePromotion(var6);
                  double var11;
                  if (var6.getBarRemise() != 0.0F) {
                     this.devisLigneVentes.setDvsligTauxRemise(var6.getBarRemise());
                     this.devisLigneVentes.setDvsligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.devisEnteteVentes.getDvsDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.devisLigneVentes.setDvsligPuTtc(this.prixUnitaires);
                        this.devisLigneVentes.setDvsligPuRemTtc(var11);
                     } else {
                        this.devisLigneVentes.setDvsligPu(this.prixUnitaires);
                        this.devisLigneVentes.setDvsligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.devisLigneVentes.setDvsligTauxRemise(var6.getBarRemise());
                     this.devisLigneVentes.setDvsligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.devisLigneVentes.getDvsligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.devisLigneVentes.setDvsligPuTtc(this.prixUnitaires);
                        this.devisLigneVentes.setDvsligPuRemTtc(var11);
                     } else {
                        this.devisLigneVentes.setDvsligPu(this.prixUnitaires);
                        this.devisLigneVentes.setDvsligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.devisLigneVentes.setDvsligTauxRemise(var6.getBarRemise());
                     this.devisLigneVentes.setDvsligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.devisLigneVentes.setDvsligPuTtc(this.prixUnitaires);
                        this.devisLigneVentes.setDvsligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.devisLigneVentes.setDvsligPu(this.prixUnitaires);
                        this.devisLigneVentes.setDvsligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.devisLigneVentes.setDvsligPuTtc(this.prixUnitaires);
                     this.devisLigneVentes.setDvsligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.devisLigneVentes.setDvsligPu(this.prixUnitaires);
                     this.devisLigneVentes.setDvsligPuRem(this.prixUnitaires);
                  }
               }
            }
         }
      }

   }

   public void calculePromotion(Baremes var1) {
      String var2 = "";
      if (var1.getBarType() == 2 && var1.getBarRemise() != 0.0F) {
         var2 = "PROMOTION DE -" + var1.getBarRemise() + "%";
         if (var1.getBarDateDebut() != null && var1.getBarDateFin() != null) {
            var2 = var2 + " Valable du " + this.utilDate.dateToStringFr(var1.getBarDateDebut()) + " au " + this.utilDate.dateToStringFr(var1.getBarDateFin());
         }
      } else if (var1.getBarType() == 2 && var1.getBarPrix() != 0.0D) {
         var2 = "TPROMOTION DE " + var1.getBarPrix() + " au lieu de " + this.devisLigneVentes.getDvsligPu();
         if (var1.getBarDateDebut() != null && var1.getBarDateFin() != null) {
            var2 = var2 + " Valable du " + this.utilDate.dateToStringFr(var1.getBarDateDebut()) + " au " + this.utilDate.dateToStringFr(var1.getBarDateFin());
         }
      }

      this.devisLigneVentes.setDvsligPromotion(var2);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((DevisLigneVentes)this.lesLignesList.get(var9)).getDvsligCode() == null || ((DevisLigneVentes)this.lesLignesList.get(var9)).getDvsligCode().isEmpty() || !((DevisLigneVentes)this.lesLignesList.get(var9)).getDvsligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((DevisLigneVentes)this.lesLignesList.get(var9)).getDvsligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((DevisLigneVentes)this.lesLignesList.get(var8)).getDvsligFamille() != null && !((DevisLigneVentes)this.lesLignesList.get(var8)).getDvsligFamille().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var8)).getDvsligFamille().equals(var7)) {
                  var5 += ((DevisLigneVentes)this.lesLignesList.get(var8)).getDvsligPt();
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

   public String prixUnitaireDegressif(boolean var1, Session var2) throws HibernateException, NamingException {
      String var3 = "";
      if (this.produits != null) {
         double var4 = this.devisLigneVentes.getDvsligPu();
         double var6 = this.devisLigneVentes.getDvsligPuTtc();
         if (this.devisLigneVentes.getDvsligPu() >= 0.0D && this.devisLigneVentes.getDvsligPuTtc() >= 0.0D) {
            var4 = this.devisLigneVentes.getDvsligPu();
            if (this.optionsVentes.getModeCalculDevis().equals("1") && this.devisLigneVentes.getDvsligPrixKg() != 0.0D && this.devisLigneVentes.getDvsligPoidsBrut() != 0.0F) {
               var4 = this.devisLigneVentes.getDvsligPrixKg() * (double)this.devisLigneVentes.getDvsligPoidsBrut();
            }

            var6 = this.devisLigneVentes.getDvsligPuTtc();
            new ProduitsTarif();
            if (this.produitsTarifdao == null) {
               this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
            }

            ProduitsTarif var8 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.devisEnteteVentes.getDvsCat(), (String)null, var2);
            if (var8 != null) {
               new ObjetTarif();
               if (var8.getProtarTarifQte() != null && !var8.getProtarTarifQte().isEmpty()) {
                  double var10 = 0.0D;
                  ObjetTarif var9;
                  String[] var12;
                  if (!var8.getProtarTarifQte().contains("#")) {
                     var12 = var8.getProtarTarifQte().split(":");
                     var9 = new ObjetTarif();
                     var9.setQteDebut(Float.parseFloat(var12[0]));
                     var9.setQteFin(Float.parseFloat(var12[1]));
                     var9.setPrix(Double.parseDouble(var12[2]));
                     if (var1) {
                        if (var3 != null && !var3.isEmpty()) {
                           if (var9.getQteFin() != 0.0F) {
                              var3 = var3 + " / de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                           } else {
                              var3 = var3 + " / + de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                           }
                        } else if (var9.getQteDebut() == 0.0F) {
                           var3 = "de 1 à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                        } else {
                           var3 = "de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                        }
                     }

                     if (var9.getQteFin() != 0.0F) {
                        if (this.devisLigneVentes.getDvsligQte() >= var9.getQteDebut() && this.devisLigneVentes.getDvsligQte() <= var9.getQteFin()) {
                           var10 = var9.getPrix();
                        }
                     } else if (this.devisLigneVentes.getDvsligQte() >= var9.getQteDebut()) {
                        var10 = var9.getPrix();
                     }
                  } else {
                     var12 = var8.getProtarTarifQte().split("#");
                     int var13 = var12.length;

                     for(int var14 = 0; var14 < var13; ++var14) {
                        String[] var15 = var12[var14].split(":");
                        var9 = new ObjetTarif();
                        var9.setQteDebut(Float.parseFloat(var15[0]));
                        var9.setQteFin(Float.parseFloat(var15[1]));
                        var9.setPrix(Double.parseDouble(var15[2]));
                        if (var1) {
                           if (var3 != null && !var3.isEmpty()) {
                              if (var9.getQteFin() != 0.0F) {
                                 var3 = var3 + " / de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                              } else {
                                 var3 = var3 + " / + de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                              }
                           } else if (var9.getQteDebut() == 0.0F) {
                              var3 = "de 1 à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                           } else {
                              var3 = "de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.devisEnteteVentes.getDvsDevise());
                           }
                        }

                        if (var9.getQteFin() != 0.0F) {
                           if (this.devisLigneVentes.getDvsligQte() >= var9.getQteDebut() && this.devisLigneVentes.getDvsligQte() <= var9.getQteFin()) {
                              var10 = var9.getPrix();
                           }
                        } else if (this.devisLigneVentes.getDvsligQte() >= var9.getQteDebut()) {
                           var10 = var9.getPrix();
                        }
                     }
                  }

                  if (var10 != 0.0D) {
                     this.prixUnitaires = var10;
                  } else {
                     this.prixUnitaires = var8.getProtarPv();
                  }
               } else {
                  this.prixUnitaires = var8.getProtarPv();
               }

               if (this.prixUnitaires == 0.0D) {
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.prixUnitaires = var6;
                  } else {
                     this.prixUnitaires = var4;
                  }
               }
            } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var6;
            } else {
               this.prixUnitaires = var4;
            }
         } else {
            var4 = Math.abs(this.devisLigneVentes.getDvsligPu());
            var6 = Math.abs(this.devisLigneVentes.getDvsligPuTtc());
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var6;
            } else {
               this.prixUnitaires = var4;
            }
         }
      }

      return var3;
   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.devisLigneVentes.setDvsligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && this.devisLigneVentes.getDvsligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.devisLigneVentes.getDvsligEchelle());
            float var5 = 1.0F;
            if (this.devisLigneVentes.getDvsligCondition().contains("/")) {
               String[] var6 = this.devisLigneVentes.getDvsligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && !this.devisLigneVentes.getDvsligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.devisLigneVentes.getDvsligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.devisLigneVentes.setDvsligPump(var9);
      } else {
         this.devisLigneVentes.setDvsligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.devisLigneVentes.getDvsligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.devisLigneVentes.setDvsligEchelle(this.unite.getUniEchelle());
               } else {
                  this.devisLigneVentes.setDvsligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.devisLigneVentes.setDvsligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.devisLigneVentes.setDvsligEchelle(Integer.parseInt(var2));
         } else {
            this.devisLigneVentes.setDvsligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, var1);
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
      if (this.montantElmTotBonEnc <= this.devisEnteteVentes.getDvsTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
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

      this.var_serie_trf = this.devisEnteteVentes.getDvsSerie();
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
      this.var_imput_serie = this.devisEnteteVentes.getDvsSerie();
      this.var_imput_cat = this.devisEnteteVentes.getDvsCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new DevisEnteteVentes();
         DevisEnteteVentes var1 = this.devisEnteteVentesDao.pourParapheur(this.var_imput_num, (Session)null);
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
      Reglements var6;
      int var7;
      Parapheur var22;
      Espion var23;
      int var24;
      if (this.var_imput_choix == 0) {
         if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.devisEnteteVentes.getDvsNum();
               this.devisEnteteVentes.setDvsNum(this.var_imput_num);
               this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
               if (this.devisEnteteVentes.getDvsTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.devisEnteteVentes.getDvsId(), this.nature, var1);
                  if (var4 != null) {
                     new Reglements();

                     for(var7 = 0; var7 < var4.size(); ++var7) {
                        var6 = (Reglements)var4.get(var7);
                        var6.setRglDocument(this.devisEnteteVentes.getDvsNum());
                        var5.modifierReg(var6, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.devisEnteteVentes.getDvsId(), this.nature, var1);
               if (var4 != null) {
                  new Parapheur();

                  for(var24 = 0; var24 < var4.size(); ++var24) {
                     var22 = (Parapheur)var4.get(var24);
                     var22.setPhrNum(this.devisEnteteVentes.getDvsNum());
                     this.parapheurDao.modif(var22, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Devis N° " + var3 + " en DEvis N° " + this.devisEnteteVentes.getDvsNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.devisEnteteVentes.getDvsNum();
            this.devisEnteteVentes.setDvsSerie(this.var_imput_serie);
            this.devisEnteteVentes.setDvsCat(this.var_imput_cat);
            this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var1));
            this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
            if (this.devisEnteteVentes.getDvsTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.devisEnteteVentes.getDvsId(), this.nature, var1);
               if (var4 != null) {
                  new Reglements();

                  for(var7 = 0; var7 < var4.size(); ++var7) {
                     var6 = (Reglements)var4.get(var7);
                     var6.setRglDocument(this.devisEnteteVentes.getDvsNum());
                     var5.modifierReg(var6, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.devisEnteteVentes.getDvsId(), this.nature, var1);
            if (var4 != null) {
               new Parapheur();

               for(var24 = 0; var24 < var4.size(); ++var24) {
                  var22 = (Parapheur)var4.get(var24);
                  var22.setPhrNum(this.devisEnteteVentes.getDvsNum());
                  this.parapheurDao.modif(var22, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Devis X N° " + var3 + " en Devis " + this.devisEnteteVentes.getDvsSerie() + " N° " + this.devisEnteteVentes.getDvsNum());
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

         new DevisLigneVentes();

         for(int var4 = 0; var4 < this.documentDetailTrf.size(); ++var4) {
            DevisLigneVentes var11 = (DevisLigneVentes)this.documentDetailTrf.get(var4);
            float var5 = 0.0F;
            ArrayList var6 = new ArrayList();
            List var7;
            int var8;
            ProduitsDepot var9;
            int var10;
            if (this.var_type_trf == 22) {
               new ArrayList();
               var7 = this.produitsDepotDao.selectProdDepByprod(var11.getDvsligCode(), var1);
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

               CommandeLigneVentesDao var16 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var5 = var16.chargerLesReliquatsDevisVtes(var11.getDvsligId(), var1);
            } else if (this.var_type_trf != 23) {
               if (this.var_type_trf == 25) {
                  FactureLigneVentesDao var12 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
                  var5 = var12.chargerLesReliquatsDevisVtes(var11.getDvsligId(), var1);
               } else if (this.var_type_trf == 27) {
                  NoteDebitLigneVentesDao var13 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
                  var5 = var13.chargerLesReliquatsDevisVtes(var11.getDvsligId(), var1);
               }
            } else {
               new ArrayList();
               var7 = this.produitsDepotDao.selectProdDepByprod(var11.getDvsligCode(), var1);
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

               LivraisonLigneVentesDao var15 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var5 = var15.chargerLesReliquatsDevisVtes(var11.getDvsligId(), var1);
            }

            float var14 = var11.getDvsligQte() - var5;
            if (var14 < 0.0F) {
               var14 = 0.0F;
            }

            var11.setVar_qteDejaTrf(var5);
            var11.setVar_listDepotItem(var6);
            float var17 = this.verifQteDisponibleDevis(var11);
            if (var14 > var17 && this.structureLog.getStrstockNegatif() == 2 && var11.getDvsligDepot() != null && !var11.getDvsligDepot().isEmpty() && var11.getDvsligStock() != 0) {
               var14 = var17;
            }

            var11.setVar_qteReliquat(var14);
            var11 = (DevisLigneVentes)this.documentDetailTrf.set(var4, var11);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         new DevisLigneVentes();

         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            DevisLigneVentes var1 = (DevisLigneVentes)this.documentDetailTrf.get(var2);
            var1.setVar_qteReliquat(0.0F);
            this.verifQteDisponibleDevis(var1);
            var1 = (DevisLigneVentes)this.documentDetailTrf.set(var2, var1);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public float verifQteDisponibleDevis(DevisLigneVentes var1) {
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
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;

         for(int var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
            var3 += ((DevisLigneVentes)this.documentDetailTrf.get(var5)).getDvsligQte();
            var2 += ((DevisLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((DevisLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         DevisEnteteVentes var6;
         int var7;
         if (var3 == var2) {
            new DevisEnteteVentes();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               var6 = (DevisEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setDvsEtat(5);
                  this.devisEnteteVentesDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         if (var10 && var4 != 0.0F) {
            new DevisEnteteVentes();
            var7 = 0;

            label123:
            while(true) {
               if (var7 >= this.lesEntetesList.size()) {
                  if (var1.size() == 0) {
                     break;
                  }

                  var7 = 0;

                  while(true) {
                     if (var7 >= var1.size()) {
                        break label123;
                     }

                     this.devisEnteteVentes = (DevisEnteteVentes)var1.get(var7);
                     this.lesLignesList.clear();
                     int var12;
                     if (this.var_mode_trf.equals("0")) {
                        for(var12 = 0; var12 < this.documentDetailTrf.size(); ++var12) {
                           if (((DevisEnteteVentes)var1.get(var7)).getDvsNum().equalsIgnoreCase(((DevisLigneVentes)this.documentDetailTrf.get(var12)).getDevisEnteteVentes().getDvsNum())) {
                              this.lesLignesList.add(this.documentDetailTrf.get(var12));
                           }
                        }
                     } else {
                        for(var12 = 0; var12 < this.documentDetailTrf.size(); ++var12) {
                           if (((DevisEnteteVentes)var1.get(var7)).getTiers().getTieid() == ((DevisLigneVentes)this.documentDetailTrf.get(var12)).getDevisEnteteVentes().getTiers().getTieid()) {
                              this.lesLignesList.add(this.documentDetailTrf.get(var12));
                           }
                        }
                     }

                     if (this.lesLignesList.size() != 0) {
                        this.utilParapheur.supprimerParapheur(this.devisEnteteVentes.getDvsId(), this.nature, (Session)null);
                        if (this.var_type_trf == 22) {
                           this.trfCmd();
                        } else if (this.var_type_trf == 23) {
                           this.trfBl();
                        } else if (this.var_type_trf == 25) {
                           this.trfFac();
                        } else if (this.var_type_trf == 27) {
                           this.trfNdb();
                        }
                     }

                     ++var7;
                  }
               }

               var6 = (DevisEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  boolean var8 = false;

                  for(int var9 = 0; var9 < var1.size(); ++var9) {
                     if (var6.getDvsNum().equalsIgnoreCase(((DevisEnteteVentes)var1.get(var9)).getDvsNum())) {
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     var1.add(var6);
                  }
               }

               ++var7;
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
               this.devisEnteteVentes = (DevisEnteteVentes)this.lesEntetesList.get(var11);
               if (this.devisEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.devisEnteteVentes);
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

   public void trfCmd() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         CommandeEnteteVentes var3 = new CommandeEnteteVentes();
         CommandeEnteteVentesDao var4 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         CommandeLigneVentesDao var5 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setBcmSerie(this.var_serie_trf);
         } else {
            var3.setBcmSerie(this.devisEnteteVentes.getDvsSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setBcmIdCreateur(this.usersLog.getUsrid());
         var3.setBcmNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setBcmDate(this.utilDate.dateToSQLLight(this.devisEnteteVentes.getDvsDate()));
         } else {
            var3.setBcmDate(this.var_date_trf);
         }

         var3.setBcmDate(this.utilDate.dateToSQL(var3.getBcmDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setBcmDateCreat(new Date());
         var3.setBcmDateModif((Date)null);
         var3.setBcmIdModif(0L);
         var3.setBcmNomModif("");
         var3.setBcmNum("");
         boolean var7 = false;
         int var36;
         if (this.optionsVentes.getNbrJrRelanceCOM() != null && !this.optionsVentes.getNbrJrRelanceCOM().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceCOM());
         } else {
            var36 = 0;
         }

         boolean var8 = false;
         int var37;
         if (this.optionsVentes.getNbrJrValidCOM() != null && !this.optionsVentes.getNbrJrValidCOM().isEmpty()) {
            var37 = Integer.parseInt(this.optionsVentes.getNbrJrValidCOM());
         } else {
            var37 = 0;
         }

         var3.setBcmDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var3.setBcmDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var37));
         var3.setBcmService(this.devisEnteteVentes.getDvsService());
         if (!var3.getBcmSerie().equalsIgnoreCase("X") && !var3.getBcmSerie().isEmpty()) {
            var3.setBcmNum(this.calculChrono.numCompose(var3.getBcmDate(), this.var_type_trf, var3.getBcmSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setBcmNum("" + var9);
         }

         this.verifieExistenceHabilitationCmd(var3, var1);
         var3.setBcmSource(this.devisEnteteVentes.getDvsSource());
         var3.setBcmNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
         var3.setBcmIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
         var3.setBcmNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
         var3.setBcmIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
         var3.setBcmNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
         var3.setBcmIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
         var3.setBcmNomTiers(this.devisEnteteVentes.getDvsNomTiers());
         var3.setBcmCivilTiers(this.devisEnteteVentes.getDvsCivilTiers());
         var3.setBcmTiersRegroupe(this.devisEnteteVentes.getDvsTiersRegroupe());
         var3.setBcmIdContact(this.devisEnteteVentes.getDvsIdContact());
         var3.setBcmNomContact(this.devisEnteteVentes.getDvsNomContact());
         var3.setBcmCivilContact(this.devisEnteteVentes.getDvsCivilContact());
         var3.setBcmDiversAdresse(this.devisEnteteVentes.getDvsDiversAdresse());
         var3.setBcmDiversMail(this.devisEnteteVentes.getDvsDiversMail());
         var3.setBcmDiversNom(this.devisEnteteVentes.getDvsDiversNom());
         var3.setBcmDiversTel(this.devisEnteteVentes.getDvsDiversTel());
         var3.setBcmDiversTiers(this.devisEnteteVentes.getDvsDiversTiers());
         var3.setBcmDiversVille(this.devisEnteteVentes.getDvsDiversVille());
         var3.setBcmExoTva(this.devisEnteteVentes.getDvsExoTva());
         var3.setBcmExoDouane(this.devisEnteteVentes.getDvsExoDouane());
         var3.setBcmJournalReg(this.devisEnteteVentes.getDvsJournalReg());
         var3.setBcmCat(this.devisEnteteVentes.getDvsCat());
         var3.setBcmDevise(this.devisEnteteVentes.getDvsDevise());
         var3.setBcmObject(this.devisEnteteVentes.getDvsObject());
         var3.setBcmObservation(this.devisEnteteVentes.getDvsObservation());
         var3.setBcmTauxRemise(this.devisEnteteVentes.getDvsTauxRemise());
         var3.setBcmTotHt(0.0D);
         var3.setBcmTotRemise(0.0D);
         var3.setBcmTotRabais(0.0D);
         var3.setBcmTotTva(0.0D);
         var3.setBcmTotTc(0.0D);
         var3.setBcmTotTtc(0.0D);
         var3.setBcmTotReglement(0.0D);
         var3.setBcmSolde(0);
         var3.setBcmBanque(this.devisEnteteVentes.getDvsBanque());
         var3.setBcmTypeReg(this.devisEnteteVentes.getDvsTypeReg());
         var3.setBcmModeReg(this.devisEnteteVentes.getDvsModeReg());
         var3.setBcmNbJourReg(this.devisEnteteVentes.getDvsNbJourReg());
         var3.setBcmArrondiReg(this.devisEnteteVentes.getDvsArrondiReg());
         var3.setBcmConditionReg(this.devisEnteteVentes.getDvsConditionReg());
         var3.setBcmDateEcheReg(this.devisEnteteVentes.getDvsDateEcheReg());
         var3.setBcmContener(this.devisEnteteVentes.getDvsContener());
         var3.setBcmActivite(this.devisEnteteVentes.getDvsActivite());
         var3.setBcmSite(this.devisEnteteVentes.getDvsSite());
         var3.setBcmDepartement(this.devisEnteteVentes.getDvsDepartement());
         var3.setBcmRegion(this.devisEnteteVentes.getDvsRegion());
         var3.setBcmSecteur(this.devisEnteteVentes.getDvsSecteur());
         var3.setBcmPdv(this.devisEnteteVentes.getDvsPdv());
         var3.setBcmAnal2(this.devisEnteteVentes.getDvsAnal2());
         var3.setBcmAnal4(this.devisEnteteVentes.getDvsAnal4());
         var3.setBcmAffaire(this.devisEnteteVentes.getDvsAffaire());
         var3.setBcmInfo1(this.devisEnteteVentes.getDvsInfo1());
         var3.setBcmInfo2(this.devisEnteteVentes.getDvsInfo2());
         var3.setBcmInfo3(this.devisEnteteVentes.getDvsInfo3());
         var3.setBcmInfo4(this.devisEnteteVentes.getDvsInfo4());
         var3.setBcmInfo5(this.devisEnteteVentes.getDvsInfo5());
         var3.setBcmInfo6(this.devisEnteteVentes.getDvsInfo6());
         var3.setBcmInfo7(this.devisEnteteVentes.getDvsInfo7());
         var3.setBcmInfo8(this.devisEnteteVentes.getDvsInfo8());
         var3.setBcmInfo9(this.devisEnteteVentes.getDvsInfo9());
         var3.setBcmInfo10(this.devisEnteteVentes.getDvsInfo10());
         var3.setBcmFormule1(this.devisEnteteVentes.getDvsFormule1());
         var3.setBcmFormule2(this.devisEnteteVentes.getDvsFormule2());
         var3.setBcmAnnexe1(this.devisEnteteVentes.getDvsAnnexe1());
         var3.setBcmAnnexe2(this.devisEnteteVentes.getDvsAnnexe2());
         var3.setBcmContrat(this.devisEnteteVentes.getDvsContrat());
         var3.setBcmIncoterm(this.devisEnteteVentes.getDvsIncoterm());
         var3.setBcmLieuLivraison(this.devisEnteteVentes.getDvsLieuLivraison());
         var3.setBcmDateLivraison(this.devisEnteteVentes.getDvsDateLivraison());
         var3.setBcmInfoLivraison(this.devisEnteteVentes.getDvsInfoLivraison());
         var3.setBcmDateImp((Date)null);
         var3.setBcmModeleImp(this.var_modele_trf);
         var3.setBcmGarde(this.devisEnteteVentes.getDvsGarde());
         var3.setBcmGele(0);
         var3.setBcmEtat(0);
         var3.setBcmDateTransforme((Date)null);
         var3.setBcmTypeTransforme(0);
         var3.setBcmDateAnnule((Date)null);
         var3.setBcmMotifAnnule("");
         var3.setBcmNiveau(0);
         var3.setBcmPreparateur("");
         var3.setBcmConseil("");
         var3.setBcmFactorNom(this.devisEnteteVentes.getDvsFactorNom());
         var3.setBcmFactorId(this.devisEnteteVentes.getDvsFactorId());
         var3.setBcmFactorEtat(this.devisEnteteVentes.getDvsFactorEtat());
         var3.setBcmSuivi(this.devisEnteteVentes.getDvsSuivi());
         var3.setBcmPhase(0);
         if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
            if (this.optionsVentes.getGestionStockBc().equals("1")) {
               var3.setBcmStock(1);
            } else {
               var3.setBcmStock(0);
            }
         } else {
            var3.setBcmStock(0);
         }

         var3.setExerciceventes(this.exercicesVentes);
         var3.setTiers(this.devisEnteteVentes.getTiers());
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
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var26);
               if (this.devisLigneVentes.getDvsligExcluCalcul() == 0) {
                  CommandeLigneVentes var27;
                  if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                     if (this.var_mode_trf.equals("0")) {
                        if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                           var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                           ++var25;
                           var27 = new CommandeLigneVentes();
                           var27.setBcmligCode("-");
                           var27.setBcmligLibelle("---> Suivant devis N° " + var24);
                           var27.setCommandeEnteteVentes(var3);
                           var6.add(var27);
                        }
                     } else if (var26 == 0) {
                        var24 = "";
                        String var40 = "";

                        for(int var28 = 0; var28 < this.lesLignesList.size(); ++var28) {
                           if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                              var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                              if (var40 != null && !var40.isEmpty()) {
                                 var40 = var40 + "," + var24;
                              } else {
                                 var40 = var24;
                              }
                           }
                        }

                        ++var25;
                        CommandeLigneVentes var41 = new CommandeLigneVentes();
                        var41.setBcmligCode("-");
                        var41.setBcmligLibelle("---> Suivant devis N° " + var40);
                        var41.setCommandeEnteteVentes(var3);
                        var6.add(var41);
                     }
                  }

                  if (this.devisLigneVentes.getDvsligLibelle() != null && !this.devisLigneVentes.getDvsligLibelle().isEmpty() || this.devisLigneVentes.getDvsligComplement() != null && !this.devisLigneVentes.getDvsligComplement().isEmpty()) {
                     CommandeLigneVentes var29;
                     String[] var30;
                     if (this.devisLigneVentes.getVar_qteReliquat() != 0.0F) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var1);
                           if (this.produits != null && this.devisLigneVentes.getDvsligDepot() != null && !this.devisLigneVentes.getDvsligDepot().isEmpty()) {
                              this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.devisLigneVentes.getDvsligCode(), this.devisLigneVentes.getDvsligDepot(), var1);
                           }
                        }

                        float var43 = this.devisLigneVentes.getDvsligQte();
                        float var45 = this.devisLigneVentes.getDvsligQteUtil();
                        ++var25;
                        var29 = new CommandeLigneVentes();
                        var38 += this.devisLigneVentes.getDvsligQte();
                        var10 += this.devisLigneVentes.getVar_qteDejaTrf();
                        if (((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                           var29.setBcmligOrdre(var25);
                           var29.setBcmligCode(this.devisLigneVentes.getDvsligCode());
                           var29.setBcmligProcess(this.devisLigneVentes.getDvsligProcess());
                           var29.setBcmligGroupe(this.devisLigneVentes.getDvsligGroupe());
                           var29.setBcmligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                           var29.setBcmligDevise(this.devisLigneVentes.getDvsligDevise());
                           var29.setBcmligFamille(this.devisLigneVentes.getDvsligFamille());
                           var29.setBcmligIdDvs(this.devisLigneVentes.getDvsligId());
                           var29.setBcmligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var29.setBcmligComplement(this.devisLigneVentes.getDvsligComplement());
                           if (this.devisLigneVentes.getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                              var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                              var29.setBcmligDepot(var30[0]);
                           } else {
                              var29.setBcmligDepot("");
                           }

                           var29.setBcmligEchelle(this.devisLigneVentes.getDvsligEchelle());
                           var29.setBcmligUnite(this.devisLigneVentes.getDvsligUnite());
                           var29.setBcmligCondition(this.devisLigneVentes.getDvsligCondition());
                           var29.setBcmligStock(this.devisLigneVentes.getDvsligStock());
                           var29.setBcmligReference(this.devisLigneVentes.getDvsligReference());
                           var29.setBcmligPump(this.devisLigneVentes.getDvsligPump());
                           var29.setBcmligPu(this.devisLigneVentes.getDvsligPu());
                           var29.setBcmligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var29.setBcmligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var29.setBcmligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var29.setBcmligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var29.setBcmligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           var29.setBcmligLong(this.devisLigneVentes.getDvsligLong());
                           var29.setBcmligLarg(this.devisLigneVentes.getDvsligLarg());
                           var29.setBcmligHaut(this.devisLigneVentes.getDvsligHaut());
                           var29.setBcmligDiam(this.devisLigneVentes.getDvsligDiam());
                           var29.setBcmligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var29.setBcmligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var29.setBcmligVolume(this.devisLigneVentes.getDvsligVolume());
                           var29.setBcmligNb(this.devisLigneVentes.getDvsligNb());
                           var29.setBcmligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.devisLigneVentes.getDvsligCondition(), this.devisLigneVentes.getDvsligQte(), this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, this.utilInitHibernate, var1));
                           var29.setBcmligQteStock(0.0F);
                           var29.setBcmligEntStock(var3.getBcmStock());
                           var29.setBcmligRabais(this.devisLigneVentes.getDvsligRabais());
                           var29.setBcmligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var29.setBcmligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var29.setBcmligPt(this.devisLigneVentes.getDvsligPt());
                           var29.setBcmligTva(this.devisLigneVentes.getDvsligTva());
                           var29.setBcmligTtc(this.devisLigneVentes.getDvsligTtc());
                           var29.setBcmligTc(this.devisLigneVentes.getDvsligTc());
                           var29.setCommandeEnteteVentes(var3);
                           var11 += ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                           var6.add(var29);
                           var12 += var29.getBcmligPt();
                           var14 += (var29.getBcmligPu() - var29.getBcmligPuRem()) * (double)var29.getBcmligQte();
                           var16 += var29.getBcmligRabais();
                           var18 += var29.getBcmligTva();
                           var20 += var29.getBcmligTtc();
                           var22 += var29.getBcmligTc();
                           this.devisLigneVentes.setDvsligQte(var43);
                           this.devisLigneVentes.setDvsligQteUtil(var45);
                        }
                     } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           new ProcessEnteteAchats();
                           ProcessEnteteAchatsDao var44 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                           ProcessEnteteAchats var42 = var44.rechercheProcess(this.devisLigneVentes.getDvsligCode(), var1);
                           if (var42 != null) {
                              ++var25;
                              var29 = new CommandeLigneVentes();
                              var29.setBcmligOrdre(var25);
                              var29.setBcmligCode(var42.getProcesCode());
                              var29.setBcmligProcess(1);
                              var29.setBcmligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setBcmligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setBcmligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setBcmligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setBcmligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setBcmligLibelle(var42.getProcesLibClient());
                              var29.setBcmligComplement(this.devisLigneVentes.getDvsligComplement());
                              var29.setBcmligDepot(var42.getProcesDepot());
                              var29.setBcmligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setBcmligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setBcmligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setBcmligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setBcmligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setBcmligPump(var42.getProcesTotPump());
                              var29.setBcmligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setBcmligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setBcmligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setBcmligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setBcmligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              var29.setBcmligQte(0.0F);
                              var29.setBcmligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setBcmligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setBcmligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setBcmligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setBcmligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setBcmligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setBcmligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setBcmligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setBcmligQteUtil(0.0F);
                              var29.setBcmligQteStock(0.0F);
                              var29.setBcmligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setBcmligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setBcmligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setBcmligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setBcmligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setBcmligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setBcmligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setCommandeEnteteVentes(var3);
                              var6.add(var29);
                           } else {
                              ++var25;
                              var29 = new CommandeLigneVentes();
                              var29.setBcmligOrdre(var25);
                              var29.setBcmligCode(this.devisLigneVentes.getDvsligCode());
                              var29.setBcmligProcess(this.devisLigneVentes.getDvsligProcess());
                              var29.setBcmligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setBcmligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setBcmligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setBcmligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setBcmligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setBcmligLibelle(this.devisLigneVentes.getDvsligLibelle());
                              var29.setBcmligComplement(this.devisLigneVentes.getDvsligComplement());
                              if (this.devisLigneVentes.getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                                 var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                                 var29.setBcmligDepot(var30[0]);
                              } else {
                                 var29.setBcmligDepot("");
                              }

                              var29.setBcmligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setBcmligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setBcmligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setBcmligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setBcmligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setBcmligPump(this.devisLigneVentes.getDvsligPump());
                              var29.setBcmligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setBcmligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setBcmligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setBcmligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setBcmligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              this.devisLigneVentes.setDvsligQte(0.0F);
                              this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                              var29.setBcmligQte(0.0F);
                              var29.setBcmligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setBcmligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setBcmligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setBcmligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setBcmligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setBcmligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setBcmligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setBcmligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setBcmligQteUtil(0.0F);
                              var29.setBcmligQteStock(0.0F);
                              var29.setBcmligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setBcmligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setBcmligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setBcmligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setBcmligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setBcmligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setBcmligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setCommandeEnteteVentes(var3);
                              var6.add(var29);
                           }
                        } else {
                           ++var25;
                           var27 = new CommandeLigneVentes();
                           var27.setBcmligOrdre(var25);
                           var27.setBcmligCode("");
                           var27.setBcmligProcess(0);
                           var27.setBcmligGroupe("");
                           var27.setBcmligModeGroupe(0);
                           var27.setBcmligDevise(this.devisLigneVentes.getDvsligDevise());
                           var27.setBcmligFamille("");
                           var27.setBcmligIdDvs(this.devisLigneVentes.getDvsligId());
                           var27.setBcmligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var27.setBcmligComplement(this.devisLigneVentes.getDvsligComplement());
                           var27.setBcmligDepot("");
                           var27.setBcmligEchelle(0);
                           var27.setBcmligUnite(this.devisLigneVentes.getDvsligUnite());
                           var27.setBcmligCondition(this.devisLigneVentes.getDvsligCondition());
                           var27.setBcmligStock(0);
                           var27.setBcmligReference(this.devisLigneVentes.getDvsligReference());
                           var27.setBcmligPump(this.devisLigneVentes.getDvsligPump());
                           var27.setBcmligPu(this.devisLigneVentes.getDvsligPu());
                           var27.setBcmligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var27.setBcmligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var27.setBcmligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var27.setBcmligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(0.0F);
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var27.setBcmligQte(0.0F);
                           var27.setBcmligLong(this.devisLigneVentes.getDvsligLong());
                           var27.setBcmligLarg(this.devisLigneVentes.getDvsligLarg());
                           var27.setBcmligHaut(this.devisLigneVentes.getDvsligHaut());
                           var27.setBcmligDiam(this.devisLigneVentes.getDvsligDiam());
                           var27.setBcmligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var27.setBcmligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var27.setBcmligVolume(this.devisLigneVentes.getDvsligVolume());
                           var27.setBcmligNb(this.devisLigneVentes.getDvsligNb());
                           var27.setBcmligQteUtil(0.0F);
                           var27.setBcmligQteStock(0.0F);
                           var27.setBcmligRabais(this.devisLigneVentes.getDvsligRabais());
                           var27.setBcmligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var27.setBcmligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var27.setBcmligPt(this.devisLigneVentes.getDvsligPt());
                           var27.setBcmligTva(this.devisLigneVentes.getDvsligTva());
                           var27.setBcmligTtc(this.devisLigneVentes.getDvsligTtc());
                           var27.setBcmligTc(this.devisLigneVentes.getDvsligTc());
                           var27.setCommandeEnteteVentes(var3);
                           var6.add(var27);
                        }
                     }
                  }
               }
            }
         }

         var3.setBcmTotHt(var12);
         var3.setBcmTotRemise(var14);
         var3.setBcmTotRabais(var16);
         var3.setBcmTotTva(var18);
         var3.setBcmTotTc(var22);
         var3.setBcmTotTtc(var20);
         if (this.optionsVentes.getValidationDevisBcCOM().equals("1") && this.optionsVentes.getGestionStockBc().equals("0")) {
            var3.setBcmEtat(1);
         }

         var3 = var4.modif(var3, var1);
         if (var6.size() != 0) {
            var5.saveLigne(var6, var3, var1);
            this.calculStock.trfDevCommandeVenteATT(var6, this.baseLog, var1);
            if (this.optionsVentes.getValidationDevisBcCOM().equals("1") && this.structureLog.getStrtypeentreprise().equals("2") && this.optionsVentes.getGenerationBcFab().contains("1")) {
               FormCommandeVentes var39 = new FormCommandeVentes();
               var39.setutilInitHibernate(this.utilInitHibernate);
               var39.setBaseLog(this.baseLog);
               var39.setStructureLog(this.structureLog);
               var39.setUsersLog(this.usersLog);
               var39.InstancesDaoUtilses();
               var39.setNature(22);
               var39.setExercicesVentes(this.exercicesVentes);
               var39.setLastExoVentes(this.lastExoVentes);
               var39.setOptionsVentes(this.optionsVentes);
               var39.generationFabrication(var3, var6, var1);
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationCmd(var3, var1), var3.getBcmId(), var3.getBcmNum(), var3.getBcmNomTiers(), var3.getBcmDate(), var3.getBcmDevise(), var3.getBcmTotTtc() + var3.getBcmTotTc(), var3.getBcmModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 22), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFCMD(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.devisEnteteVentes.getDvsSerie());
         this.documentTraceVentes.setDoctraOrgId(this.devisEnteteVentes.getDvsId());
         this.documentTraceVentes.setDoctraOrgNum(this.devisEnteteVentes.getDvsNum());
         this.documentTraceVentes.setDoctraOrgDate(this.devisEnteteVentes.getDvsDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getBcmSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getBcmId());
         this.documentTraceVentes.setDoctraDstNum(var3.getBcmNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getBcmDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         if (var38 <= var10 + var11 && var38 != 0.0F && var10 + var11 != 0.0F) {
            this.devisEnteteVentes.setDvsEtat(5);
         } else {
            this.devisEnteteVentes.setDvsEtat(4);
         }

         this.devisEnteteVentes.setDvsDateTransforme(new Date());
         this.devisEnteteVentes.setDvsTypeTransforme(this.var_type_trf);
         this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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

   public JRBeanCollectionDataSource calculeImpressionTRFCMD(List var1, CommandeEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new CommandeLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            CommandeLigneVentes var4 = (CommandeLigneVentes)var1.get(var11);
            if (var4.getBcmligModeGroupe() != 2 || var4.getBcmligGroupe() == null || var4.getBcmligGroupe().isEmpty()) {
               if (var4.getBcmligCode() != null && !var4.getBcmligCode().isEmpty() && var4.getBcmligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getBcmligLibelle();
               }

               if (var5) {
                  var7 += var4.getBcmligPt();
                  var9 = var4.getBcmligTtc();
               }

               if (var4.getBcmligCode() != null && !var4.getBcmligCode().isEmpty() && var4.getBcmligCode().equals("=") && var5) {
                  var4 = new CommandeLigneVentes();
                  var4.setCommandeEnteteVentes(var2);
                  var4.setBcmligCode("=");
                  var4.setBcmligLibelle(var6);
                  var4.setBcmligPt(var7);
                  var4.setBcmligTtc(var9);
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

      this.montant_lettre = this.utilNombre.begin(var2.getBcmTotTtc() + var2.getBcmTotTc(), var2.getBcmDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationCmd(CommandeEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setBcmEtatVal(1);
         var1.setBcmEtat(0);
         var1.setBcmDateValide((Date)null);
      } else {
         var1.setBcmEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setBcmEtat(1);
               var1.setBcmDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setBcmEtat(0);
               var1.setBcmDateValide((Date)null);
            }
         }
      }

      return var4;
   }

   public void trfBl() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         LivraisonEnteteVentes var3 = new LivraisonEnteteVentes();
         LivraisonEnteteVentesDao var4 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         LivraisonLigneVentesDao var5 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setBlvSerie(this.var_serie_trf);
         } else {
            var3.setBlvSerie(this.devisEnteteVentes.getDvsSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setBlvIdCreateur(this.usersLog.getUsrid());
         var3.setBlvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setBlvDate(this.utilDate.dateToSQLLight(this.devisEnteteVentes.getDvsDate()));
         } else {
            var3.setBlvDate(this.var_date_trf);
         }

         var3.setBlvDate(this.utilDate.dateToSQL(var3.getBlvDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setBlvDateCreat(new Date());
         var3.setBlvDateModif((Date)null);
         var3.setBlvIdModif(0L);
         var3.setBlvNomModif("");
         var3.setBlvNum("");
         boolean var7 = false;
         int var36;
         if (this.optionsVentes.getNbrJrRelanceLIV() != null && !this.optionsVentes.getNbrJrRelanceLIV().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceLIV());
         } else {
            var36 = 0;
         }

         boolean var8 = false;
         int var37;
         if (this.optionsVentes.getNbrJrValidLIV() != null && !this.optionsVentes.getNbrJrValidLIV().isEmpty()) {
            var37 = Integer.parseInt(this.optionsVentes.getNbrJrValidLIV());
         } else {
            var37 = 0;
         }

         var3.setBlvDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var3.setBlvDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var37));
         var3.setBlvService(this.devisEnteteVentes.getDvsService());
         if (!var3.getBlvSerie().equalsIgnoreCase("X") && !var3.getBlvSerie().isEmpty()) {
            var3.setBlvNum(this.calculChrono.numCompose(var3.getBlvDate(), this.var_type_trf, var3.getBlvSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setBlvNum("" + var9);
         }

         this.verifieExistenceHabilitationBl(var3, var1);
         var3.setBlvSource(this.devisEnteteVentes.getDvsSource());
         var3.setBlvNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
         var3.setBlvIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
         var3.setBlvNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
         var3.setBlvIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
         var3.setBlvNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
         var3.setBlvIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
         var3.setBlvNomTiers(this.devisEnteteVentes.getDvsNomTiers());
         var3.setBlvCivilTiers(this.devisEnteteVentes.getDvsCivilTiers());
         var3.setBlvTiersRegroupe(this.devisEnteteVentes.getDvsTiersRegroupe());
         var3.setBlvIdContact(this.devisEnteteVentes.getDvsIdContact());
         var3.setBlvNomContact(this.devisEnteteVentes.getDvsNomContact());
         var3.setBlvCivilContact(this.devisEnteteVentes.getDvsCivilContact());
         var3.setBlvDiversAdresse(this.devisEnteteVentes.getDvsDiversAdresse());
         var3.setBlvDiversMail(this.devisEnteteVentes.getDvsDiversMail());
         var3.setBlvDiversNom(this.devisEnteteVentes.getDvsDiversNom());
         var3.setBlvDiversTel(this.devisEnteteVentes.getDvsDiversTel());
         var3.setBlvDiversTiers(this.devisEnteteVentes.getDvsDiversTiers());
         var3.setBlvDiversVille(this.devisEnteteVentes.getDvsDiversVille());
         var3.setBlvExoTva(this.devisEnteteVentes.getDvsExoTva());
         var3.setBlvExoDouane(this.devisEnteteVentes.getDvsExoDouane());
         var3.setBlvJournalReg(this.devisEnteteVentes.getDvsJournalReg());
         var3.setBlvCat(this.devisEnteteVentes.getDvsCat());
         var3.setBlvDevise(this.devisEnteteVentes.getDvsDevise());
         var3.setBlvObject(this.devisEnteteVentes.getDvsObject());
         var3.setBlvObservation(this.devisEnteteVentes.getDvsObservation());
         var3.setBlvTauxRemise(this.devisEnteteVentes.getDvsTauxRemise());
         var3.setBlvTotHt(0.0D);
         var3.setBlvTotRemise(0.0D);
         var3.setBlvTotRabais(0.0D);
         var3.setBlvTotTva(0.0D);
         var3.setBlvTotTc(0.0D);
         var3.setBlvTotTtc(0.0D);
         var3.setBlvTotReglement(0.0D);
         var3.setBlvSolde(0);
         if (this.optionsVentes.getGestionStockBc().equals("1")) {
            var3.setBlvStock(1);
         } else {
            var3.setBlvStock(0);
         }

         if (this.optionsVentes.getGestionLivreur().equals("1")) {
            var3.setBlvLivreur(1);
         } else {
            var3.setBlvLivreur(0);
         }

         var3.setBlvBanque(this.devisEnteteVentes.getDvsBanque());
         var3.setBlvTypeReg(this.devisEnteteVentes.getDvsTypeReg());
         var3.setBlvModeReg(this.devisEnteteVentes.getDvsModeReg());
         var3.setBlvNbJourReg(this.devisEnteteVentes.getDvsNbJourReg());
         var3.setBlvArrondiReg(this.devisEnteteVentes.getDvsArrondiReg());
         var3.setBlvConditionReg(this.devisEnteteVentes.getDvsConditionReg());
         var3.setBlvDateEcheReg(this.devisEnteteVentes.getDvsDateEcheReg());
         var3.setBlvContener(this.devisEnteteVentes.getDvsContener());
         var3.setBlvActivite(this.devisEnteteVentes.getDvsActivite());
         var3.setBlvSite(this.devisEnteteVentes.getDvsSite());
         var3.setBlvDepartement(this.devisEnteteVentes.getDvsDepartement());
         var3.setBlvRegion(this.devisEnteteVentes.getDvsRegion());
         var3.setBlvSecteur(this.devisEnteteVentes.getDvsSecteur());
         var3.setBlvPdv(this.devisEnteteVentes.getDvsPdv());
         var3.setBlvAnal2(this.devisEnteteVentes.getDvsAnal2());
         var3.setBlvAnal4(this.devisEnteteVentes.getDvsAnal4());
         var3.setBlvAffaire(this.devisEnteteVentes.getDvsAffaire());
         var3.setBlvInfo1(this.devisEnteteVentes.getDvsInfo1());
         var3.setBlvInfo2(this.devisEnteteVentes.getDvsInfo2());
         var3.setBlvInfo3(this.devisEnteteVentes.getDvsInfo3());
         var3.setBlvInfo4(this.devisEnteteVentes.getDvsInfo4());
         var3.setBlvInfo5(this.devisEnteteVentes.getDvsInfo5());
         var3.setBlvInfo6(this.devisEnteteVentes.getDvsInfo6());
         var3.setBlvInfo7(this.devisEnteteVentes.getDvsInfo7());
         var3.setBlvInfo8(this.devisEnteteVentes.getDvsInfo8());
         var3.setBlvInfo9(this.devisEnteteVentes.getDvsInfo9());
         var3.setBlvInfo10(this.devisEnteteVentes.getDvsInfo10());
         var3.setBlvFormule1(this.devisEnteteVentes.getDvsFormule1());
         var3.setBlvFormule2(this.devisEnteteVentes.getDvsFormule2());
         var3.setBlvAnnexe1(this.devisEnteteVentes.getDvsAnnexe1());
         var3.setBlvAnnexe2(this.devisEnteteVentes.getDvsAnnexe2());
         var3.setBlvContrat(this.devisEnteteVentes.getDvsContrat());
         var3.setBlvIncoterm(this.devisEnteteVentes.getDvsIncoterm());
         var3.setBlvLieuLivraison(this.devisEnteteVentes.getDvsLieuLivraison());
         var3.setBlvDateLivraison(this.devisEnteteVentes.getDvsDateLivraison());
         var3.setBlvInfoLivraison(this.devisEnteteVentes.getDvsInfoLivraison());
         var3.setBlvDateImp((Date)null);
         var3.setBlvModeleImp(this.var_modele_trf);
         var3.setBlvGarde(this.devisEnteteVentes.getDvsGarde());
         var3.setBlvGele(0);
         var3.setBlvEtat(0);
         var3.setBlvDateTransforme((Date)null);
         var3.setBlvTypeTransforme(0);
         var3.setBlvDateAnnule((Date)null);
         var3.setBlvMotifAnnule("");
         var3.setBlvFactorNom(this.devisEnteteVentes.getDvsFactorNom());
         var3.setBlvFactorId(this.devisEnteteVentes.getDvsFactorId());
         var3.setBlvFactorEtat(this.devisEnteteVentes.getDvsFactorEtat());
         var3.setExerciceventes(this.exercicesVentes);
         var3.setTiers(this.devisEnteteVentes.getTiers());
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
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var26);
               if (this.devisLigneVentes.getDvsligExcluCalcul() == 0) {
                  LivraisonLigneVentes var27;
                  if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                     if (this.var_mode_trf.equals("0")) {
                        if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                           var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                           ++var25;
                           var27 = new LivraisonLigneVentes();
                           var27.setBlvligCode("-");
                           var27.setBlvligLibelle("---> Suivant devis N° " + var24);
                           var27.setLivraisonEnteteVentes(var3);
                           var6.add(var27);
                        }
                     } else if (var26 == 0) {
                        var24 = "";
                        String var39 = "";

                        for(int var28 = 0; var28 < this.lesLignesList.size(); ++var28) {
                           if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                              var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                              if (var39 != null && !var39.isEmpty()) {
                                 var39 = var39 + "," + var24;
                              } else {
                                 var39 = var24;
                              }
                           }
                        }

                        ++var25;
                        LivraisonLigneVentes var40 = new LivraisonLigneVentes();
                        var40.setBlvligCode("-");
                        var40.setBlvligLibelle("---> Suivant devis N° " + var39);
                        var40.setLivraisonEnteteVentes(var3);
                        var6.add(var40);
                     }
                  }

                  if (this.devisLigneVentes.getDvsligLibelle() != null && !this.devisLigneVentes.getDvsligLibelle().isEmpty() || this.devisLigneVentes.getDvsligComplement() != null && !this.devisLigneVentes.getDvsligComplement().isEmpty()) {
                     LivraisonLigneVentes var29;
                     String[] var30;
                     if (this.devisLigneVentes.getVar_qteReliquat() != 0.0F) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var1);
                           if (this.produits != null && this.devisLigneVentes.getDvsligDepot() != null && !this.devisLigneVentes.getDvsligDepot().isEmpty()) {
                              this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.devisLigneVentes.getDvsligCode(), this.devisLigneVentes.getDvsligDepot(), var1);
                           }
                        }

                        float var42 = this.devisLigneVentes.getDvsligQte();
                        float var44 = this.devisLigneVentes.getDvsligQteUtil();
                        ++var25;
                        var29 = new LivraisonLigneVentes();
                        var38 += this.devisLigneVentes.getDvsligQte();
                        var10 += this.devisLigneVentes.getVar_qteDejaTrf();
                        if (((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                           var29.setBlvligOrdre(var25);
                           var29.setBlvligCode(this.devisLigneVentes.getDvsligCode());
                           var29.setBlvligProcess(this.devisLigneVentes.getDvsligProcess());
                           var29.setBlvligGroupe(this.devisLigneVentes.getDvsligGroupe());
                           var29.setBlvligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                           var29.setBlvligDevise(this.devisLigneVentes.getDvsligDevise());
                           var29.setBlvligFamille(this.devisLigneVentes.getDvsligFamille());
                           var29.setBlvligIdDvs(this.devisLigneVentes.getDvsligId());
                           var29.setBlvligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var29.setBlvligComplement(this.devisLigneVentes.getDvsligComplement());
                           if (((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                              var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                              var29.setBlvligDepot(var30[0]);
                           } else {
                              var29.setBlvligDepot("");
                           }

                           var29.setBlvligEchelle(this.devisLigneVentes.getDvsligEchelle());
                           var29.setBlvligUnite(this.devisLigneVentes.getDvsligUnite());
                           var29.setBlvligCondition(this.devisLigneVentes.getDvsligCondition());
                           var29.setBlvligStock(this.devisLigneVentes.getDvsligStock());
                           var29.setBlvligReference(this.devisLigneVentes.getDvsligReference());
                           var29.setBlvligPump(this.devisLigneVentes.getDvsligPump());
                           var29.setBlvligPu(this.devisLigneVentes.getDvsligPu());
                           var29.setBlvligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var29.setBlvligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var29.setBlvligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var29.setBlvligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var29.setBlvligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           var29.setBlvligLong(this.devisLigneVentes.getDvsligLong());
                           var29.setBlvligLarg(this.devisLigneVentes.getDvsligLarg());
                           var29.setBlvligHaut(this.devisLigneVentes.getDvsligHaut());
                           var29.setBlvligDiam(this.devisLigneVentes.getDvsligDiam());
                           var29.setBlvligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var29.setBlvligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var29.setBlvligVolume(this.devisLigneVentes.getDvsligVolume());
                           var29.setBlvligNb(this.devisLigneVentes.getDvsligNb());
                           var29.setBlvligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.devisLigneVentes.getDvsligCondition(), this.devisLigneVentes.getDvsligQte(), this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, this.utilInitHibernate, var1));
                           if (this.optionsVentes.getGestionLivreur().equals("1")) {
                              var29.setBlvligQteStock(0.0F);
                              var29.setBlvligQteUtilStock(0.0F);
                           } else {
                              var29.setBlvligQteStock(var29.getBlvligQte());
                              var29.setBlvligQteUtilStock(var29.getBlvligQteUtil());
                           }

                           var29.setBlvligRabais(this.devisLigneVentes.getDvsligRabais());
                           var29.setBlvligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var29.setBlvligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var29.setBlvligPt(this.devisLigneVentes.getDvsligPt());
                           var29.setBlvligTva(this.devisLigneVentes.getDvsligTva());
                           var29.setBlvligTtc(this.devisLigneVentes.getDvsligTtc());
                           var29.setBlvligTc(this.devisLigneVentes.getDvsligTc());
                           var29.setLivraisonEnteteVentes(var3);
                           var11 += ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                           var6.add(var29);
                           var12 += var29.getBlvligPt();
                           var14 += (var29.getBlvligPu() - var29.getBlvligPuRem()) * (double)var29.getBlvligQte();
                           var16 += var29.getBlvligRabais();
                           var18 += var29.getBlvligTva();
                           var20 += var29.getBlvligTtc();
                           var22 += var29.getBlvligTc();
                           this.devisLigneVentes.setDvsligQte(var42);
                           this.devisLigneVentes.setDvsligQteUtil(var44);
                        }
                     } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           new ProcessEnteteAchats();
                           ProcessEnteteAchatsDao var43 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                           ProcessEnteteAchats var41 = var43.rechercheProcess(this.devisLigneVentes.getDvsligCode(), var1);
                           if (var41 != null) {
                              ++var25;
                              var29 = new LivraisonLigneVentes();
                              var29.setBlvligOrdre(var25);
                              var29.setBlvligCode(var41.getProcesCode());
                              var29.setBlvligProcess(1);
                              var29.setBlvligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setBlvligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setBlvligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setBlvligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setBlvligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setBlvligLibelle(var41.getProcesLibClient());
                              var29.setBlvligComplement(this.devisLigneVentes.getDvsligComplement());
                              var29.setBlvligDepot(var41.getProcesDepot());
                              var29.setBlvligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setBlvligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setBlvligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setBlvligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setBlvligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setBlvligPump(var41.getProcesTotPump());
                              var29.setBlvligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setBlvligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setBlvligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setBlvligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setBlvligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              var29.setBlvligQte(0.0F);
                              var29.setBlvligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setBlvligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setBlvligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setBlvligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setBlvligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setBlvligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setBlvligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setBlvligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setBlvligQteUtil(0.0F);
                              var29.setBlvligQteStock(0.0F);
                              var29.setBlvligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setBlvligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setBlvligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setBlvligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setBlvligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setBlvligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setBlvligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setLivraisonEnteteVentes(var3);
                              var6.add(var29);
                           } else {
                              ++var25;
                              var29 = new LivraisonLigneVentes();
                              var29.setBlvligOrdre(var25);
                              var29.setBlvligCode(this.devisLigneVentes.getDvsligCode());
                              var29.setBlvligProcess(this.devisLigneVentes.getDvsligProcess());
                              var29.setBlvligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setBlvligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setBlvligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setBlvligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setBlvligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setBlvligLibelle(this.devisLigneVentes.getDvsligLibelle());
                              var29.setBlvligComplement(this.devisLigneVentes.getDvsligComplement());
                              if (this.devisLigneVentes.getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                                 var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                                 var29.setBlvligDepot(var30[0]);
                              } else {
                                 var29.setBlvligDepot("");
                              }

                              var29.setBlvligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setBlvligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setBlvligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setBlvligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setBlvligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setBlvligPump(this.devisLigneVentes.getDvsligPump());
                              var29.setBlvligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setBlvligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setBlvligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setBlvligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setBlvligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              this.devisLigneVentes.setDvsligQte(0.0F);
                              this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                              var29.setBlvligQte(0.0F);
                              var29.setBlvligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setBlvligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setBlvligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setBlvligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setBlvligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setBlvligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setBlvligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setBlvligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setBlvligQteUtil(0.0F);
                              var29.setBlvligQteStock(0.0F);
                              var29.setBlvligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setBlvligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setBlvligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setBlvligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setBlvligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setBlvligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setBlvligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setLivraisonEnteteVentes(var3);
                              var6.add(var29);
                           }
                        } else {
                           ++var25;
                           var27 = new LivraisonLigneVentes();
                           var27.setBlvligOrdre(var25);
                           var27.setBlvligCode("");
                           var27.setBlvligProcess(0);
                           var27.setBlvligGroupe("");
                           var27.setBlvligModeGroupe(0);
                           var27.setBlvligDevise(this.devisLigneVentes.getDvsligDevise());
                           var27.setBlvligFamille("");
                           var27.setBlvligIdDvs(this.devisLigneVentes.getDvsligId());
                           var27.setBlvligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var27.setBlvligComplement(this.devisLigneVentes.getDvsligComplement());
                           var27.setBlvligDepot("");
                           var27.setBlvligEchelle(0);
                           var27.setBlvligUnite(this.devisLigneVentes.getDvsligUnite());
                           var27.setBlvligCondition(this.devisLigneVentes.getDvsligCondition());
                           var27.setBlvligStock(0);
                           var27.setBlvligReference(this.devisLigneVentes.getDvsligReference());
                           var27.setBlvligPump(0.0D);
                           var27.setBlvligPu(this.devisLigneVentes.getDvsligPu());
                           var27.setBlvligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var27.setBlvligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var27.setBlvligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var27.setBlvligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(0.0F);
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var27.setBlvligQte(0.0F);
                           var27.setBlvligLong(this.devisLigneVentes.getDvsligLong());
                           var27.setBlvligLarg(this.devisLigneVentes.getDvsligLarg());
                           var27.setBlvligHaut(this.devisLigneVentes.getDvsligHaut());
                           var27.setBlvligDiam(this.devisLigneVentes.getDvsligDiam());
                           var27.setBlvligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var27.setBlvligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var27.setBlvligVolume(this.devisLigneVentes.getDvsligVolume());
                           var27.setBlvligNb(this.devisLigneVentes.getDvsligNb());
                           var27.setBlvligQteUtil(0.0F);
                           var27.setBlvligQteStock(0.0F);
                           var27.setBlvligRabais(this.devisLigneVentes.getDvsligRabais());
                           var27.setBlvligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var27.setBlvligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var27.setBlvligPt(this.devisLigneVentes.getDvsligPt());
                           var27.setBlvligTva(this.devisLigneVentes.getDvsligTva());
                           var27.setBlvligTtc(this.devisLigneVentes.getDvsligTtc());
                           var27.setBlvligTc(this.devisLigneVentes.getDvsligTc());
                           var27.setLivraisonEnteteVentes(var3);
                           var6.add(var27);
                        }
                     }
                  }
               }
            }
         }

         var3.setBlvTotHt(var12);
         var3.setBlvTotRemise(var14);
         var3.setBlvTotRabais(var16);
         var3.setBlvTotTva(var18);
         var3.setBlvTotTc(var22);
         var3.setBlvTotTtc(var20);
         var3 = var4.modif(var3, var1);
         if (var6.size() != 0) {
            var5.saveLigne(var6, var3, var1);
            this.calculStock.trfDevLivraisonVenteATT(var6, this.baseLog, var1);
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationBl(var3, var1), var3.getBlvId(), var3.getBlvNum(), var3.getBlvNomTiers(), var3.getBlvDate(), var3.getBlvDevise(), var3.getBlvTotTtc() + var3.getBlvTotTc(), var3.getBlvModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 23), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFBL(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.devisEnteteVentes.getDvsSerie());
         this.documentTraceVentes.setDoctraOrgId(this.devisEnteteVentes.getDvsId());
         this.documentTraceVentes.setDoctraOrgNum(this.devisEnteteVentes.getDvsNum());
         this.documentTraceVentes.setDoctraOrgDate(this.devisEnteteVentes.getDvsDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getBlvSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getBlvId());
         this.documentTraceVentes.setDoctraDstNum(var3.getBlvNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getBlvDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         if (var38 <= var10 + var11 && var38 != 0.0F && var10 + var11 != 0.0F) {
            this.devisEnteteVentes.setDvsEtat(5);
         } else {
            this.devisEnteteVentes.setDvsEtat(4);
         }

         this.devisEnteteVentes.setDvsDateTransforme(new Date());
         this.devisEnteteVentes.setDvsTypeTransforme(this.var_type_trf);
         this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setBlvEtat(1);
               var1.setBlvDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setBlvEtat(0);
               var1.setBlvDateValide((Date)null);
            }
         }
      }

      return var4;
   }

   public void trfFac() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         FactureEnteteVentes var3 = new FactureEnteteVentes();
         FactureEnteteVentesDao var4 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FactureLigneVentesDao var5 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setFacSerie(this.var_serie_trf);
         } else {
            var3.setFacSerie(this.devisEnteteVentes.getDvsSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setFacIdCreateur(this.usersLog.getUsrid());
         var3.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setFacDate(this.utilDate.dateToSQLLight(this.devisEnteteVentes.getDvsDate()));
         } else {
            var3.setFacDate(this.var_date_trf);
         }

         var3.setFacDate(this.utilDate.dateToSQL(var3.getFacDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setFacDateCreat(new Date());
         var3.setFacDateModif((Date)null);
         var3.setFacIdModif(0L);
         var3.setFacNomModif("");
         var3.setFacNum("");
         boolean var7 = false;
         int var36;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var36 = 0;
         }

         boolean var8 = false;
         int var37;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var37 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var37 = 0;
         }

         var3.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var3.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var37));
         var3.setFacService(this.devisEnteteVentes.getDvsService());
         if (!var3.getFacSerie().equalsIgnoreCase("X") && !var3.getFacSerie().isEmpty()) {
            var3.setFacNum(this.calculChrono.numCompose(var3.getFacDate(), this.var_type_trf, var3.getFacSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setFacNum("" + var9);
         }

         this.verifieExistenceHabilitationFac(var3, var1);
         var3.setFacSource(this.devisEnteteVentes.getDvsSource());
         var3.setFacNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
         var3.setFacIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
         var3.setFacNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
         var3.setFacIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
         var3.setFacNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
         var3.setFacIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
         var3.setFacNomTiers(this.devisEnteteVentes.getDvsNomTiers());
         var3.setFacCivilTiers(this.devisEnteteVentes.getDvsCivilTiers());
         var3.setFacTiersRegroupe(this.devisEnteteVentes.getDvsTiersRegroupe());
         var3.setFacIdContact(this.devisEnteteVentes.getDvsIdContact());
         var3.setFacNomContact(this.devisEnteteVentes.getDvsNomContact());
         var3.setFacCivilContact(this.devisEnteteVentes.getDvsCivilContact());
         var3.setFacDiversAdresse(this.devisEnteteVentes.getDvsDiversAdresse());
         var3.setFacDiversMail(this.devisEnteteVentes.getDvsDiversMail());
         var3.setFacDiversNom(this.devisEnteteVentes.getDvsDiversNom());
         var3.setFacDiversTel(this.devisEnteteVentes.getDvsDiversTel());
         var3.setFacDiversTiers(this.devisEnteteVentes.getDvsDiversTiers());
         var3.setFacDiversVille(this.devisEnteteVentes.getDvsDiversVille());
         var3.setFacExoTva(this.devisEnteteVentes.getDvsExoTva());
         var3.setFacExoDouane(this.devisEnteteVentes.getDvsExoDouane());
         var3.setFacJournalReg(this.devisEnteteVentes.getDvsJournalReg());
         var3.setFacCat(this.devisEnteteVentes.getDvsCat());
         var3.setFacDevise(this.devisEnteteVentes.getDvsDevise());
         var3.setFacObject(this.devisEnteteVentes.getDvsObject());
         var3.setFacObservation(this.devisEnteteVentes.getDvsObservation());
         var3.setFacTauxRemise(this.devisEnteteVentes.getDvsTauxRemise());
         var3.setFacTotHt(0.0D);
         var3.setFacTotRemise(0.0D);
         var3.setFacTotRabais(0.0D);
         var3.setFacTotTva(0.0D);
         var3.setFacTotTc(0.0D);
         var3.setFacTotTtc(0.0D);
         var3.setFacTotReglement(0.0D);
         var3.setFacSolde(0);
         var3.setFacBanque(this.devisEnteteVentes.getDvsBanque());
         var3.setFacTypeReg(this.devisEnteteVentes.getDvsTypeReg());
         var3.setFacModeReg(this.devisEnteteVentes.getDvsModeReg());
         var3.setFacNbJourReg(this.devisEnteteVentes.getDvsNbJourReg());
         var3.setFacArrondiReg(this.devisEnteteVentes.getDvsArrondiReg());
         var3.setFacConditionReg(this.devisEnteteVentes.getDvsConditionReg());
         var3.setFacDateEcheReg(this.devisEnteteVentes.getDvsDateEcheReg());
         var3.setFacContener(this.devisEnteteVentes.getDvsContener());
         var3.setFacActivite(this.devisEnteteVentes.getDvsActivite());
         var3.setFacSite(this.devisEnteteVentes.getDvsSite());
         var3.setFacDepartement(this.devisEnteteVentes.getDvsDepartement());
         var3.setFacRegion(this.devisEnteteVentes.getDvsRegion());
         var3.setFacSecteur(this.devisEnteteVentes.getDvsSecteur());
         var3.setFacPdv(this.devisEnteteVentes.getDvsPdv());
         var3.setFacAnal2(this.devisEnteteVentes.getDvsAnal2());
         var3.setFacAnal4(this.devisEnteteVentes.getDvsAnal4());
         var3.setFacAffaire(this.devisEnteteVentes.getDvsAffaire());
         var3.setFacInfo1(this.devisEnteteVentes.getDvsInfo1());
         var3.setFacInfo2(this.devisEnteteVentes.getDvsInfo2());
         var3.setFacInfo3(this.devisEnteteVentes.getDvsInfo3());
         var3.setFacInfo4(this.devisEnteteVentes.getDvsInfo4());
         var3.setFacInfo5(this.devisEnteteVentes.getDvsInfo5());
         var3.setFacInfo6(this.devisEnteteVentes.getDvsInfo6());
         var3.setFacInfo7(this.devisEnteteVentes.getDvsInfo7());
         var3.setFacInfo8(this.devisEnteteVentes.getDvsInfo8());
         var3.setFacInfo9(this.devisEnteteVentes.getDvsInfo9());
         var3.setFacInfo10(this.devisEnteteVentes.getDvsInfo10());
         var3.setFacFormule1(this.devisEnteteVentes.getDvsFormule1());
         var3.setFacFormule2(this.devisEnteteVentes.getDvsFormule2());
         var3.setFacAnnexe1(this.devisEnteteVentes.getDvsAnnexe1());
         var3.setFacAnnexe2(this.devisEnteteVentes.getDvsAnnexe2());
         var3.setFacContrat(this.devisEnteteVentes.getDvsContrat());
         var3.setFacIncoterm(this.devisEnteteVentes.getDvsIncoterm());
         var3.setFacLieuLivraison(this.devisEnteteVentes.getDvsLieuLivraison());
         var3.setFacDateLivraison(this.devisEnteteVentes.getDvsDateLivraison());
         var3.setFacInfoLivraison(this.devisEnteteVentes.getDvsInfoLivraison());
         var3.setFacDateImp((Date)null);
         var3.setFacModeleImp(this.var_modele_trf);
         var3.setFacGarde(this.devisEnteteVentes.getDvsGarde());
         var3.setFacGele(0);
         var3.setFacEtat(0);
         var3.setFacDateTransforme((Date)null);
         var3.setFacTypeTransforme(0);
         var3.setFacDateAnnule((Date)null);
         var3.setFacMotifAnnule("");
         var3.setFacFactorNom(this.devisEnteteVentes.getDvsFactorNom());
         var3.setFacFactorId(this.devisEnteteVentes.getDvsFactorId());
         var3.setFacFactorEtat(this.devisEnteteVentes.getDvsFactorEtat());
         var3.setExerciceventes(this.exercicesVentes);
         var3.setTiers(this.devisEnteteVentes.getTiers());
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
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var26);
               if (this.devisLigneVentes.getDvsligExcluCalcul() == 0) {
                  FactureLigneVentes var27;
                  if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                     if (this.var_mode_trf.equals("0")) {
                        if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                           var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                           ++var25;
                           var27 = new FactureLigneVentes();
                           var27.setFacligCode("-");
                           var27.setFacligLibelle("---> Suivant devis N° " + var24);
                           var27.setFactureEnteteVentes(var3);
                           var6.add(var27);
                        }
                     } else if (var26 == 0) {
                        var24 = "";
                        String var39 = "";

                        for(int var28 = 0; var28 < this.lesLignesList.size(); ++var28) {
                           if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                              var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                              if (var39 != null && !var39.isEmpty()) {
                                 var39 = var39 + "," + var24;
                              } else {
                                 var39 = var24;
                              }
                           }
                        }

                        ++var25;
                        FactureLigneVentes var40 = new FactureLigneVentes();
                        var40.setFacligCode("-");
                        var40.setFacligLibelle("---> Suivant devis N° " + var39);
                        var40.setFactureEnteteVentes(var3);
                        var6.add(var40);
                     }
                  }

                  if (this.devisLigneVentes.getDvsligLibelle() != null && !this.devisLigneVentes.getDvsligLibelle().isEmpty() || this.devisLigneVentes.getDvsligComplement() != null && !this.devisLigneVentes.getDvsligComplement().isEmpty()) {
                     FactureLigneVentes var29;
                     String[] var30;
                     if (this.devisLigneVentes.getVar_qteReliquat() != 0.0F) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var1);
                           if (this.produits != null && this.devisLigneVentes.getDvsligDepot() != null && !this.devisLigneVentes.getDvsligDepot().isEmpty()) {
                              this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.devisLigneVentes.getDvsligCode(), this.devisLigneVentes.getDvsligDepot(), var1);
                           }
                        }

                        float var42 = this.devisLigneVentes.getDvsligQte();
                        float var44 = this.devisLigneVentes.getDvsligQteUtil();
                        ++var25;
                        var29 = new FactureLigneVentes();
                        var38 += this.devisLigneVentes.getDvsligQte();
                        var10 += this.devisLigneVentes.getVar_qteDejaTrf();
                        if (((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                           var29.setFacligOrdre(var25);
                           var29.setFacligCode(this.devisLigneVentes.getDvsligCode());
                           var29.setFacligGroupe(this.devisLigneVentes.getDvsligGroupe());
                           var29.setFacligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                           var29.setFacligDevise(this.devisLigneVentes.getDvsligDevise());
                           var29.setFacligFamille(this.devisLigneVentes.getDvsligFamille());
                           var29.setFacligIdDvs(this.devisLigneVentes.getDvsligId());
                           var29.setFacligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var29.setFacligComplement(this.devisLigneVentes.getDvsligComplement());
                           if (((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                              var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                              var29.setFacligDepot(var30[0]);
                           } else {
                              var29.setFacligDepot("");
                           }

                           var29.setFacligEchelle(this.devisLigneVentes.getDvsligEchelle());
                           var29.setFacligUnite(this.devisLigneVentes.getDvsligUnite());
                           var29.setFacligStock(this.devisLigneVentes.getDvsligStock());
                           var29.setFacligReference(this.devisLigneVentes.getDvsligReference());
                           var29.setFacligPump(this.devisLigneVentes.getDvsligPump());
                           var29.setFacligPu(this.devisLigneVentes.getDvsligPu());
                           var29.setFacligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var29.setFacligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var29.setFacligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var29.setFacligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var29.setFacligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           var29.setFacligLong(this.devisLigneVentes.getDvsligLong());
                           var29.setFacligLarg(this.devisLigneVentes.getDvsligLarg());
                           var29.setFacligHaut(this.devisLigneVentes.getDvsligHaut());
                           var29.setFacligDiam(this.devisLigneVentes.getDvsligDiam());
                           var29.setFacligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var29.setFacligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var29.setFacligVolume(this.devisLigneVentes.getDvsligVolume());
                           var29.setFacligNb(this.devisLigneVentes.getDvsligNb());
                           var29.setFacligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.devisLigneVentes.getDvsligCondition(), this.devisLigneVentes.getDvsligQte(), this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, this.utilInitHibernate, var1));
                           var29.setFacligQteStock(0.0F);
                           var29.setFacligRabais(this.devisLigneVentes.getDvsligRabais());
                           var29.setFacligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var29.setFacligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var29.setFacligPt(this.devisLigneVentes.getDvsligPt());
                           var29.setFacligTva(this.devisLigneVentes.getDvsligTva());
                           var29.setFacligTtc(this.devisLigneVentes.getDvsligTtc());
                           var29.setFacligTc(this.devisLigneVentes.getDvsligTc());
                           var29.setFactureEnteteVentes(var3);
                           var11 += ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                           var6.add(var29);
                           var12 += var29.getFacligPt();
                           var14 += (var29.getFacligPu() - var29.getFacligPuRem()) * (double)var29.getFacligQte();
                           var16 += var29.getFacligRabais();
                           var18 += var29.getFacligTva();
                           var20 += var29.getFacligTtc();
                           var22 += var29.getFacligTc();
                           this.devisLigneVentes.setDvsligQte(var42);
                           this.devisLigneVentes.setDvsligQteUtil(var44);
                        }
                     } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           new ProcessEnteteAchats();
                           ProcessEnteteAchatsDao var43 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                           ProcessEnteteAchats var41 = var43.rechercheProcess(this.devisLigneVentes.getDvsligCode(), var1);
                           if (var41 != null) {
                              ++var25;
                              var29 = new FactureLigneVentes();
                              var29.setFacligOrdre(var25);
                              var29.setFacligCode(var41.getProcesCode());
                              var29.setFacligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setFacligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setFacligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setFacligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setFacligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setFacligLibelle(var41.getProcesLibClient());
                              var29.setFacligComplement(this.devisLigneVentes.getDvsligComplement());
                              var29.setFacligDepot(var41.getProcesDepot());
                              var29.setFacligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setFacligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setFacligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setFacligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setFacligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setFacligPump(var41.getProcesTotPump());
                              var29.setFacligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setFacligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setFacligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setFacligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setFacligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              var29.setFacligQte(0.0F);
                              var29.setFacligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setFacligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setFacligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setFacligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setFacligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setFacligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setFacligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setFacligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setFacligQteUtil(0.0F);
                              var29.setFacligQteStock(0.0F);
                              var29.setFacligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setFacligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setFacligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setFacligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setFacligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setFacligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setFacligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setFactureEnteteVentes(var3);
                              var6.add(var29);
                           } else {
                              ++var25;
                              var29 = new FactureLigneVentes();
                              var29.setFacligOrdre(var25);
                              var29.setFacligCode(this.devisLigneVentes.getDvsligCode());
                              var29.setFacligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setFacligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setFacligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setFacligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setFacligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setFacligLibelle(this.devisLigneVentes.getDvsligLibelle());
                              var29.setFacligComplement(this.devisLigneVentes.getDvsligComplement());
                              if (this.devisLigneVentes.getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                                 var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                                 var29.setFacligDepot(var30[0]);
                              } else {
                                 var29.setFacligDepot("");
                              }

                              var29.setFacligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setFacligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setFacligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setFacligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setFacligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setFacligPump(this.devisLigneVentes.getDvsligPump());
                              var29.setFacligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setFacligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setFacligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setFacligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setFacligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              this.devisLigneVentes.setDvsligQte(0.0F);
                              this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                              var29.setFacligQte(0.0F);
                              var29.setFacligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setFacligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setFacligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setFacligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setFacligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setFacligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setFacligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setFacligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setFacligQteUtil(0.0F);
                              var29.setFacligQteStock(0.0F);
                              var29.setFacligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setFacligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setFacligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setFacligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setFacligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setFacligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setFacligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setFactureEnteteVentes(var3);
                              var6.add(var29);
                           }
                        } else {
                           ++var25;
                           var27 = new FactureLigneVentes();
                           var27.setFacligOrdre(var25);
                           var27.setFacligCode("");
                           var27.setFacligGroupe("");
                           var27.setFacligModeGroupe(0);
                           var27.setFacligDevise(this.devisLigneVentes.getDvsligDevise());
                           var27.setFacligFamille("");
                           var27.setFacligIdDvs(this.devisLigneVentes.getDvsligId());
                           var27.setFacligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var27.setFacligComplement(this.devisLigneVentes.getDvsligComplement());
                           var27.setFacligDepot("");
                           var27.setFacligEchelle(0);
                           var27.setFacligUnite(this.devisLigneVentes.getDvsligUnite());
                           var27.setFacligCondition(this.devisLigneVentes.getDvsligCondition());
                           var27.setFacligStock(0);
                           var27.setFacligReference(this.devisLigneVentes.getDvsligReference());
                           var27.setFacligPump(0.0D);
                           var27.setFacligPu(this.devisLigneVentes.getDvsligPu());
                           var27.setFacligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var27.setFacligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var27.setFacligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var27.setFacligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(0.0F);
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var27.setFacligQte(0.0F);
                           var27.setFacligLong(this.devisLigneVentes.getDvsligLong());
                           var27.setFacligLarg(this.devisLigneVentes.getDvsligLarg());
                           var27.setFacligHaut(this.devisLigneVentes.getDvsligHaut());
                           var27.setFacligDiam(this.devisLigneVentes.getDvsligDiam());
                           var27.setFacligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var27.setFacligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var27.setFacligVolume(this.devisLigneVentes.getDvsligVolume());
                           var27.setFacligNb(this.devisLigneVentes.getDvsligNb());
                           var27.setFacligQteUtil(0.0F);
                           var27.setFacligQteStock(0.0F);
                           var27.setFacligRabais(this.devisLigneVentes.getDvsligRabais());
                           var27.setFacligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var27.setFacligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var27.setFacligPt(this.devisLigneVentes.getDvsligPt());
                           var27.setFacligTva(this.devisLigneVentes.getDvsligTva());
                           var27.setFacligTtc(this.devisLigneVentes.getDvsligTtc());
                           var27.setFacligTc(this.devisLigneVentes.getDvsligTc());
                           var27.setFactureEnteteVentes(var3);
                           var6.add(var27);
                        }
                     }
                  }
               }
            }
         }

         var3.setFacTotHt(var12);
         var3.setFacTotRemise(var14);
         var3.setFacTotRabais(var16);
         var3.setFacTotTva(var18);
         var3.setFacTotTc(var22);
         var3.setFacTotTtc(var20);
         var3 = var4.modif(var3, var1);
         if (var6.size() != 0) {
            var5.saveLigne(var6, var3, var1);
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFac(var3, var1), var3.getFacId(), var3.getFacNum(), var3.getFacNomTiers(), var3.getFacDate(), var3.getFacDevise(), var3.getFacTotTtc() + var3.getFacTotTc(), var3.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 25), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.devisEnteteVentes.getDvsSerie());
         this.documentTraceVentes.setDoctraOrgId(this.devisEnteteVentes.getDvsId());
         this.documentTraceVentes.setDoctraOrgNum(this.devisEnteteVentes.getDvsNum());
         this.documentTraceVentes.setDoctraOrgDate(this.devisEnteteVentes.getDvsDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getFacSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getFacId());
         this.documentTraceVentes.setDoctraDstNum(var3.getFacNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getFacDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         if (var38 <= var10 + var11 && var38 != 0.0F && var10 + var11 != 0.0F) {
            this.devisEnteteVentes.setDvsEtat(5);
         } else {
            this.devisEnteteVentes.setDvsEtat(4);
         }

         this.devisEnteteVentes.setDvsDateTransforme(new Date());
         this.devisEnteteVentes.setDvsTypeTransforme(this.var_type_trf);
         this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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

   public void trfNdb() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceVentes = new DocumentTraceVentes();
         NoteDebitEnteteVentes var3 = new NoteDebitEnteteVentes();
         NoteDebitEnteteVentesDao var4 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         NoteDebitLigneVentesDao var5 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var3.setNdbSerie(this.var_serie_trf);
         } else {
            var3.setNdbSerie(this.devisEnteteVentes.getDvsSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setNdbIdCreateur(this.usersLog.getUsrid());
         var3.setNdbNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setNdbDate(this.utilDate.dateToSQLLight(this.devisEnteteVentes.getDvsDate()));
         } else {
            var3.setNdbDate(this.var_date_trf);
         }

         var3.setNdbDate(this.utilDate.dateToSQL(var3.getNdbDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setNdbDateCreat(new Date());
         var3.setNdbDateModif((Date)null);
         var3.setNdbIdModif(0L);
         var3.setNdbNomModif("");
         var3.setNdbNum("");
         boolean var7 = false;
         int var36;
         if (this.optionsVentes.getNbrJrRelanceNOTDEB() != null && !this.optionsVentes.getNbrJrRelanceNOTDEB().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceNOTDEB());
         } else {
            var36 = 0;
         }

         boolean var8 = false;
         int var37;
         if (this.optionsVentes.getNbrJrValidNOTDEB() != null && !this.optionsVentes.getNbrJrValidNOTDEB().isEmpty()) {
            var37 = Integer.parseInt(this.optionsVentes.getNbrJrValidNOTDEB());
         } else {
            var37 = 0;
         }

         var3.setNdbDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var3.setNdbDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var37));
         var3.setNdbService(this.devisEnteteVentes.getDvsService());
         if (!var3.getNdbSerie().equalsIgnoreCase("X") && !var3.getNdbSerie().isEmpty()) {
            var3.setNdbNum(this.calculChrono.numCompose(var3.getNdbDate(), this.var_type_trf, var3.getNdbSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setNdbNum("" + var9);
         }

         this.verifieExistenceHabilitationNdb(var3, var1);
         var3.setNdbSource(this.devisEnteteVentes.getDvsSource());
         var3.setNdbNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
         var3.setNdbIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
         var3.setNdbNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
         var3.setNdbIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
         var3.setNdbNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
         var3.setNdbIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
         var3.setNdbNomTiers(this.devisEnteteVentes.getDvsNomTiers());
         var3.setNdbCivilTiers(this.devisEnteteVentes.getDvsCivilTiers());
         var3.setNdbTiersRegroupe(this.devisEnteteVentes.getDvsTiersRegroupe());
         var3.setNdbIdContact(this.devisEnteteVentes.getDvsIdContact());
         var3.setNdbNomContact(this.devisEnteteVentes.getDvsNomContact());
         var3.setNdbCivilContact(this.devisEnteteVentes.getDvsCivilContact());
         var3.setNdbDiversAdresse(this.devisEnteteVentes.getDvsDiversAdresse());
         var3.setNdbDiversMail(this.devisEnteteVentes.getDvsDiversMail());
         var3.setNdbDiversNom(this.devisEnteteVentes.getDvsDiversNom());
         var3.setNdbDiversTel(this.devisEnteteVentes.getDvsDiversTel());
         var3.setNdbDiversTiers(this.devisEnteteVentes.getDvsDiversTiers());
         var3.setNdbDiversVille(this.devisEnteteVentes.getDvsDiversVille());
         var3.setNdbExoTva(this.devisEnteteVentes.getDvsExoTva());
         var3.setNdbExoDouane(this.devisEnteteVentes.getDvsExoDouane());
         var3.setNdbJournalReg(this.devisEnteteVentes.getDvsJournalReg());
         var3.setNdbCat(this.devisEnteteVentes.getDvsCat());
         var3.setNdbDevise(this.devisEnteteVentes.getDvsDevise());
         var3.setNdbObject(this.devisEnteteVentes.getDvsObject());
         var3.setNdbObservation(this.devisEnteteVentes.getDvsObservation());
         var3.setNdbTauxRemise(this.devisEnteteVentes.getDvsTauxRemise());
         var3.setNdbTotHt(0.0D);
         var3.setNdbTotRemise(0.0D);
         var3.setNdbTotRabais(0.0D);
         var3.setNdbTotTva(0.0D);
         var3.setNdbTotTc(0.0D);
         var3.setNdbTotTtc(0.0D);
         var3.setNdbTotReglement(0.0D);
         var3.setNdbSolde(0);
         var3.setNdbBanque(this.devisEnteteVentes.getDvsBanque());
         var3.setNdbTypeReg(this.devisEnteteVentes.getDvsTypeReg());
         var3.setNdbModeReg(this.devisEnteteVentes.getDvsModeReg());
         var3.setNdbNbJourReg(this.devisEnteteVentes.getDvsNbJourReg());
         var3.setNdbArrondiReg(this.devisEnteteVentes.getDvsArrondiReg());
         var3.setNdbConditionReg(this.devisEnteteVentes.getDvsConditionReg());
         var3.setNdbDateEcheReg(this.devisEnteteVentes.getDvsDateEcheReg());
         var3.setNdbContener(this.devisEnteteVentes.getDvsContener());
         var3.setNdbActivite(this.devisEnteteVentes.getDvsActivite());
         var3.setNdbSite(this.devisEnteteVentes.getDvsSite());
         var3.setNdbDepartement(this.devisEnteteVentes.getDvsDepartement());
         var3.setNdbRegion(this.devisEnteteVentes.getDvsRegion());
         var3.setNdbSecteur(this.devisEnteteVentes.getDvsSecteur());
         var3.setNdbPdv(this.devisEnteteVentes.getDvsPdv());
         var3.setNdbAnal2(this.devisEnteteVentes.getDvsAnal2());
         var3.setNdbAnal4(this.devisEnteteVentes.getDvsAnal4());
         var3.setNdbAffaire(this.devisEnteteVentes.getDvsAffaire());
         var3.setNdbInfo1(this.devisEnteteVentes.getDvsInfo1());
         var3.setNdbInfo2(this.devisEnteteVentes.getDvsInfo2());
         var3.setNdbInfo3(this.devisEnteteVentes.getDvsInfo3());
         var3.setNdbInfo4(this.devisEnteteVentes.getDvsInfo4());
         var3.setNdbInfo5(this.devisEnteteVentes.getDvsInfo5());
         var3.setNdbInfo6(this.devisEnteteVentes.getDvsInfo6());
         var3.setNdbInfo7(this.devisEnteteVentes.getDvsInfo7());
         var3.setNdbInfo8(this.devisEnteteVentes.getDvsInfo8());
         var3.setNdbInfo9(this.devisEnteteVentes.getDvsInfo9());
         var3.setNdbInfo10(this.devisEnteteVentes.getDvsInfo10());
         var3.setNdbFormule1(this.devisEnteteVentes.getDvsFormule1());
         var3.setNdbFormule2(this.devisEnteteVentes.getDvsFormule2());
         var3.setNdbAnnexe1(this.devisEnteteVentes.getDvsAnnexe1());
         var3.setNdbAnnexe2(this.devisEnteteVentes.getDvsAnnexe2());
         var3.setNdbContrat(this.devisEnteteVentes.getDvsContrat());
         var3.setNdbIncoterm(this.devisEnteteVentes.getDvsIncoterm());
         var3.setNdbLieuLivraison(this.devisEnteteVentes.getDvsLieuLivraison());
         var3.setNdbDateLivraison(this.devisEnteteVentes.getDvsDateLivraison());
         var3.setNdbInfoLivraison(this.devisEnteteVentes.getDvsInfoLivraison());
         var3.setNdbDateImp((Date)null);
         var3.setNdbModeleImp(this.var_modele_trf);
         var3.setNdbGarde(this.devisEnteteVentes.getDvsGarde());
         var3.setNdbGele(0);
         var3.setNdbEtat(0);
         var3.setNdbDateTransforme((Date)null);
         var3.setNdbDateAnnule((Date)null);
         var3.setNdbMotifAnnule("");
         var3.setNdbFactorNom(this.devisEnteteVentes.getDvsFactorNom());
         var3.setNdbFactorId(this.devisEnteteVentes.getDvsFactorId());
         var3.setNdbFactorEtat(this.devisEnteteVentes.getDvsFactorEtat());
         var3.setExerciceventes(this.exercicesVentes);
         var3.setTiers(this.devisEnteteVentes.getTiers());
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
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var26);
               if (this.devisLigneVentes.getDvsligExcluCalcul() == 0) {
                  NoteDebitLigneVentes var27;
                  if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                     if (this.var_mode_trf.equals("0")) {
                        if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                           var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                           ++var25;
                           var27 = new NoteDebitLigneVentes();
                           var27.setNdbligCode("-");
                           var27.setNdbligLibelle("---> Suivant devis N° " + var24);
                           var27.setNoteDebitEnteteVentes(var3);
                           var6.add(var27);
                        }
                     } else if (var26 == 0) {
                        var24 = "";
                        String var39 = "";

                        for(int var28 = 0; var28 < this.lesLignesList.size(); ++var28) {
                           if (var24 == null || var24.isEmpty() || !var24.equals(this.devisLigneVentes.getDevisEnteteVentes().getDvsNum())) {
                              var24 = this.devisLigneVentes.getDevisEnteteVentes().getDvsNum();
                              if (var39 != null && !var39.isEmpty()) {
                                 var39 = var39 + "," + var24;
                              } else {
                                 var39 = var24;
                              }
                           }
                        }

                        ++var25;
                        NoteDebitLigneVentes var40 = new NoteDebitLigneVentes();
                        var40.setNdbligCode("-");
                        var40.setNdbligLibelle("---> Suivant devis N° " + var39);
                        var40.setNoteDebitEnteteVentes(var3);
                        var6.add(var40);
                     }
                  }

                  if (this.devisLigneVentes.getDvsligLibelle() != null && !this.devisLigneVentes.getDvsligLibelle().isEmpty() || this.devisLigneVentes.getDvsligComplement() != null && !this.devisLigneVentes.getDvsligComplement().isEmpty()) {
                     NoteDebitLigneVentes var29;
                     if (this.devisLigneVentes.getVar_qteReliquat() != 0.0F) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var1);
                           if (this.produits != null && this.devisLigneVentes.getDvsligDepot() != null && !this.devisLigneVentes.getDvsligDepot().isEmpty()) {
                              this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.devisLigneVentes.getDvsligCode(), this.devisLigneVentes.getDvsligDepot(), var1);
                           }
                        }

                        float var42 = this.devisLigneVentes.getDvsligQte();
                        float var44 = this.devisLigneVentes.getDvsligQteUtil();
                        ++var25;
                        var29 = new NoteDebitLigneVentes();
                        var38 += this.devisLigneVentes.getDvsligQte();
                        var10 += this.devisLigneVentes.getVar_qteDejaTrf();
                        if (((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                           var29.setNdbligOrdre(var25);
                           var29.setNdbligCode(this.devisLigneVentes.getDvsligCode());
                           var29.setNdbligGroupe(this.devisLigneVentes.getDvsligGroupe());
                           var29.setNdbligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                           var29.setNdbligDevise(this.devisLigneVentes.getDvsligDevise());
                           var29.setNdbligFamille(this.devisLigneVentes.getDvsligFamille());
                           var29.setNdbligIdDvs(this.devisLigneVentes.getDvsligId());
                           var29.setNdbligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var29.setNdbligComplement(this.devisLigneVentes.getDvsligComplement());
                           var29.setNdbligUnite(this.devisLigneVentes.getDvsligUnite());
                           var29.setNdbligCondition(this.devisLigneVentes.getDvsligCondition());
                           var29.setNdbligStock(this.devisLigneVentes.getDvsligStock());
                           var29.setNdbligReference(this.devisLigneVentes.getDvsligReference());
                           var29.setNdbligPump(this.devisLigneVentes.getDvsligPump());
                           var29.setNdbligPu(this.devisLigneVentes.getDvsligPu());
                           var29.setNdbligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var29.setNdbligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var29.setNdbligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var29.setNdbligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var29.setNdbligQte(((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                           var29.setNdbligLong(this.devisLigneVentes.getDvsligLong());
                           var29.setNdbligLarg(this.devisLigneVentes.getDvsligLarg());
                           var29.setNdbligHaut(this.devisLigneVentes.getDvsligHaut());
                           var29.setNdbligDiam(this.devisLigneVentes.getDvsligDiam());
                           var29.setNdbligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var29.setNdbligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var29.setNdbligVolume(this.devisLigneVentes.getDvsligVolume());
                           var29.setNdbligNb(this.devisLigneVentes.getDvsligNb());
                           var29.setNdbligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.devisLigneVentes.getDvsligCondition(), this.devisLigneVentes.getDvsligQte(), this.devisLigneVentes.getDvsligLong(), this.devisLigneVentes.getDvsligLarg(), this.devisLigneVentes.getDvsligHaut(), this.devisLigneVentes.getDvsligDiam(), this.devisLigneVentes.getDvsligNb(), this.baseLog, this.utilInitHibernate, var1));
                           var29.setNdbligQteStock(0.0F);
                           var29.setNdbligRabais(this.devisLigneVentes.getDvsligRabais());
                           var29.setNdbligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var29.setNdbligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var29.setNdbligPt(this.devisLigneVentes.getDvsligPt());
                           var29.setNdbligTva(this.devisLigneVentes.getDvsligTva());
                           var29.setNdbligTtc(this.devisLigneVentes.getDvsligTtc());
                           var29.setNdbligTc(this.devisLigneVentes.getDvsligTc());
                           var29.setNoteDebitEnteteVentes(var3);
                           var11 += ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                           var6.add(var29);
                           var12 += var29.getNdbligPt();
                           var14 += (var29.getNdbligPu() - var29.getNdbligPuRem()) * (double)var29.getNdbligQte();
                           var16 += var29.getNdbligRabais();
                           var18 += var29.getNdbligTva();
                           var20 += var29.getNdbligTtc();
                           var22 += var29.getNdbligTc();
                           this.devisLigneVentes.setDvsligQte(var42);
                           this.devisLigneVentes.setDvsligQteUtil(var44);
                        }
                     } else if (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("1") || this.structureLog.getStrtypeentreprise().equals("2")) {
                        if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                           new ProcessEnteteAchats();
                           ProcessEnteteAchatsDao var43 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                           ProcessEnteteAchats var41 = var43.rechercheProcess(this.devisLigneVentes.getDvsligCode(), var1);
                           if (var41 != null) {
                              ++var25;
                              var29 = new NoteDebitLigneVentes();
                              var29.setNdbligOrdre(var25);
                              var29.setNdbligCode(var41.getProcesCode());
                              var29.setNdbligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setNdbligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setNdbligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setNdbligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setNdbligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setNdbligLibelle(var41.getProcesLibClient());
                              var29.setNdbligComplement(this.devisLigneVentes.getDvsligComplement());
                              var29.setNdbligDepot(var41.getProcesDepot());
                              var29.setNdbligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setNdbligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setNdbligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setNdbligStock(this.devisLigneVentes.getDvsligStock());
                              var29.setNdbligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setNdbligPump(var41.getProcesTotPump());
                              var29.setNdbligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setNdbligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setNdbligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setNdbligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setNdbligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              var29.setNdbligQte(0.0F);
                              var29.setNdbligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setNdbligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setNdbligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setNdbligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setNdbligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setNdbligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setNdbligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setNdbligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setNdbligQteUtil(0.0F);
                              var29.setNdbligQteStock(0.0F);
                              var29.setNdbligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setNdbligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setNdbligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setNdbligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setNdbligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setNdbligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setNdbligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setNoteDebitEnteteVentes(var3);
                              var6.add(var29);
                           } else {
                              ++var25;
                              var29 = new NoteDebitLigneVentes();
                              var29.setNdbligOrdre(var25);
                              var29.setNdbligCode(this.devisLigneVentes.getDvsligCode());
                              var29.setNdbligGroupe(this.devisLigneVentes.getDvsligGroupe());
                              var29.setNdbligModeGroupe(this.devisLigneVentes.getDvsligModeGroupe());
                              var29.setNdbligDevise(this.devisLigneVentes.getDvsligDevise());
                              var29.setNdbligFamille(this.devisLigneVentes.getDvsligFamille());
                              var29.setNdbligIdDvs(this.devisLigneVentes.getDvsligId());
                              var29.setNdbligLibelle(this.devisLigneVentes.getDvsligLibelle());
                              var29.setNdbligComplement(this.devisLigneVentes.getDvsligComplement());
                              if (this.devisLigneVentes.getVar_depotLigne() != null && !((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                                 String[] var30 = ((DevisLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                                 var29.setNdbligDepot(var30[0]);
                              } else {
                                 var29.setNdbligDepot("");
                              }

                              var29.setNdbligEchelle(this.devisLigneVentes.getDvsligEchelle());
                              var29.setNdbligUnite(this.devisLigneVentes.getDvsligUnite());
                              var29.setNdbligCondition(this.devisLigneVentes.getDvsligCondition());
                              var29.setNdbligReference(this.devisLigneVentes.getDvsligReference());
                              var29.setNdbligPump(this.devisLigneVentes.getDvsligPump());
                              var29.setNdbligPu(this.devisLigneVentes.getDvsligPu());
                              var29.setNdbligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                              var29.setNdbligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                              var29.setNdbligPuRem(this.devisLigneVentes.getDvsligPuRem());
                              var29.setNdbligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                              this.devisLigneVentes.setDvsligQte(0.0F);
                              this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                              var29.setNdbligQte(0.0F);
                              var29.setNdbligLong(this.devisLigneVentes.getDvsligLong());
                              var29.setNdbligLarg(this.devisLigneVentes.getDvsligLarg());
                              var29.setNdbligHaut(this.devisLigneVentes.getDvsligHaut());
                              var29.setNdbligDiam(this.devisLigneVentes.getDvsligDiam());
                              var29.setNdbligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                              var29.setNdbligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                              var29.setNdbligVolume(this.devisLigneVentes.getDvsligVolume());
                              var29.setNdbligNb(this.devisLigneVentes.getDvsligNb());
                              var29.setNdbligQteUtil(0.0F);
                              var29.setNdbligQteStock(0.0F);
                              var29.setNdbligRabais(this.devisLigneVentes.getDvsligRabais());
                              var29.setNdbligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                              var29.setNdbligTaxe(this.devisLigneVentes.getDvsligTaxe());
                              var29.setNdbligPt(this.devisLigneVentes.getDvsligPt());
                              var29.setNdbligTva(this.devisLigneVentes.getDvsligTva());
                              var29.setNdbligTtc(this.devisLigneVentes.getDvsligTtc());
                              var29.setNdbligTc(this.devisLigneVentes.getDvsligTc());
                              var29.setNoteDebitEnteteVentes(var3);
                              var6.add(var29);
                           }
                        } else {
                           ++var25;
                           var27 = new NoteDebitLigneVentes();
                           var27.setNdbligOrdre(var25);
                           var27.setNdbligCode("");
                           var27.setNdbligGroupe("");
                           var27.setNdbligModeGroupe(0);
                           var27.setNdbligDevise(this.devisLigneVentes.getDvsligDevise());
                           var27.setNdbligFamille("");
                           var27.setNdbligIdDvs(this.devisLigneVentes.getDvsligId());
                           var27.setNdbligLibelle(this.devisLigneVentes.getDvsligLibelle());
                           var27.setNdbligComplement(this.devisLigneVentes.getDvsligComplement());
                           var27.setNdbligDepot("");
                           var27.setNdbligEchelle(0);
                           var27.setNdbligUnite(this.devisLigneVentes.getDvsligUnite());
                           var27.setNdbligCondition(this.devisLigneVentes.getDvsligCondition());
                           var27.setNdbligReference(this.devisLigneVentes.getDvsligReference());
                           var27.setNdbligPump(0.0D);
                           var27.setNdbligPu(this.devisLigneVentes.getDvsligPu());
                           var27.setNdbligPuTtc(this.devisLigneVentes.getDvsligPuTtc());
                           var27.setNdbligTauxRemise(this.devisLigneVentes.getDvsligTauxRemise());
                           var27.setNdbligPuRem(this.devisLigneVentes.getDvsligPuRem());
                           var27.setNdbligPuRemTtc(this.devisLigneVentes.getDvsligPuRemTtc());
                           this.devisLigneVentes.setDvsligQte(0.0F);
                           this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var1);
                           var27.setNdbligQte(0.0F);
                           var27.setNdbligLong(this.devisLigneVentes.getDvsligLong());
                           var27.setNdbligLarg(this.devisLigneVentes.getDvsligLarg());
                           var27.setNdbligHaut(this.devisLigneVentes.getDvsligHaut());
                           var27.setNdbligDiam(this.devisLigneVentes.getDvsligDiam());
                           var27.setNdbligPoidsBrut(this.devisLigneVentes.getDvsligPoidsBrut());
                           var27.setNdbligPoidsNet(this.devisLigneVentes.getDvsligPoidsNet());
                           var27.setNdbligVolume(this.devisLigneVentes.getDvsligVolume());
                           var27.setNdbligNb(this.devisLigneVentes.getDvsligNb());
                           var27.setNdbligQteUtil(0.0F);
                           var27.setNdbligQteStock(0.0F);
                           var27.setNdbligRabais(this.devisLigneVentes.getDvsligRabais());
                           var27.setNdbligTauxTaxe(this.devisLigneVentes.getDvsligTauxTaxe());
                           var27.setNdbligTaxe(this.devisLigneVentes.getDvsligTaxe());
                           var27.setNdbligPt(this.devisLigneVentes.getDvsligPt());
                           var27.setNdbligTva(this.devisLigneVentes.getDvsligTva());
                           var27.setNdbligTtc(this.devisLigneVentes.getDvsligTtc());
                           var27.setNdbligTc(this.devisLigneVentes.getDvsligTc());
                           var27.setNoteDebitEnteteVentes(var3);
                           var6.add(var27);
                        }
                     }
                  }
               }
            }
         }

         var3.setNdbTotHt(var12);
         var3.setNdbTotRemise(var14);
         var3.setNdbTotRabais(var16);
         var3.setNdbTotTva(var18);
         var3.setNdbTotTc(var22);
         var3.setNdbTotTtc(var20);
         var3 = var4.modif(var3, var1);
         if (var6.size() != 0) {
            var5.saveLigne(var6, var3, var1);
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationNdb(var3, var1), var3.getNdbId(), var3.getNdbNum(), var3.getNdbNomTiers(), var3.getNdbDate(), var3.getNdbDevise(), var3.getNdbTotTtc() + var3.getNdbTotTc(), var3.getNdbModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 27), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFNDB(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.devisEnteteVentes.getDvsSerie());
         this.documentTraceVentes.setDoctraOrgId(this.devisEnteteVentes.getDvsId());
         this.documentTraceVentes.setDoctraOrgNum(this.devisEnteteVentes.getDvsNum());
         this.documentTraceVentes.setDoctraOrgDate(this.devisEnteteVentes.getDvsDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getNdbSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getNdbId());
         this.documentTraceVentes.setDoctraDstNum(var3.getNdbNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getNdbDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         if (var38 <= var10 + var11 && var38 != 0.0F && var10 + var11 != 0.0F) {
            this.devisEnteteVentes.setDvsEtat(5);
         } else {
            this.devisEnteteVentes.setDvsEtat(4);
         }

         this.devisEnteteVentes.setDvsDateTransforme(new Date());
         this.devisEnteteVentes.setDvsTypeTransforme(this.var_type_trf);
         this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
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

   public JRBeanCollectionDataSource calculeImpressionTRFNDB(List var1, NoteDebitEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new NoteDebitLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            NoteDebitLigneVentes var4 = (NoteDebitLigneVentes)var1.get(var11);
            if (var4.getNdbligModeGroupe() != 2 || var4.getNdbligGroupe() == null || var4.getNdbligGroupe().isEmpty()) {
               if (var4.getNdbligCode() != null && !var4.getNdbligCode().isEmpty() && var4.getNdbligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getNdbligLibelle();
               }

               if (var5) {
                  var7 += var4.getNdbligPt();
                  var9 = var4.getNdbligTtc();
               }

               if (var4.getNdbligCode() != null && !var4.getNdbligCode().isEmpty() && var4.getNdbligCode().equals("=") && var5) {
                  var4 = new NoteDebitLigneVentes();
                  var4.setNoteDebitEnteteVentes(var2);
                  var4.setNdbligCode("=");
                  var4.setNdbligLibelle(var6);
                  var4.setNdbligPt(var7);
                  var4.setNdbligTtc(var9);
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

      this.montant_lettre = this.utilNombre.begin(var2.getNdbTotTtc() + var2.getNdbTotTc(), var2.getNdbDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationNdb(NoteDebitEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setNdbEtatVal(1);
         var1.setNdbEtat(0);
         var1.setNdbDateValide((Date)null);
      } else {
         var1.setNdbEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setNdbEtat(1);
               var1.setNdbDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setNdbEtat(0);
               var1.setNdbDateValide((Date)null);
            }
         }
      }

      return var4;
   }

   public void payeDocument() throws HibernateException, NamingException {
      this.bonEncaissementVente = new BonEncaissementVente();
      this.bonEncaissementVente.setBonCodeCaisse("");
      this.bonEncaissementVente.setBonLibCaisse("");
      this.bonEncaissementVente.setBonDate(new Date());
      this.chargerCaisseCommerciale();
      if (this.var_tot_bon_encaissement > this.devisEnteteVentes.getDvsTotTtc()) {
         this.devisEnteteVentes.setDvsTypeReg(4);
         this.var_verouxModReg = true;
         this.var_affichMontant = false;
         this.var_netAPayer = this.devisEnteteVentes.getDvsTotTtc() - this.var_tot_bon_encaissement;
         this.verifBonEncaissement();
      } else {
         if (this.devisEnteteVentes.getDvsTypeReg() == 5) {
            this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
            if (this.devisEnteteVentes.getDvsEtat() == 1) {
               this.var_verouxModReg = true;
            } else {
               this.var_verouxModReg = false;
            }

            this.var_netAPayer = this.devisEnteteVentes.getDvsTotTtc() - this.var_tot_bon_encaissement;
            this.var_affiche_valide = true;
         } else {
            this.devisEnteteVentes.setDvsTypeReg(0);
            this.var_verouxModReg = false;
            this.var_netAPayer = this.devisEnteteVentes.getDvsTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         }

         this.var_affichMontant = true;
      }

      this.setShowModalPanelPaye(true);
   }

   public void chargerCaisseCommerciale() throws HibernateException, NamingException {
      this.mesCaissesItems.clear();
      if (this.devisEnteteVentes != null) {
         if (this.devisEnteteVentes.getDvsSerie() != null && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
            new Chrono();
            ChronoDao var2 = new ChronoDao(this.baseLog, this.utilInitHibernate);
            CaissesCommercialesDao var3 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            String var4 = "" + (this.devisEnteteVentes.getDvsDate().getYear() + 1900);
            Chrono var1 = var2.chronoBySerieNat(this.devisEnteteVentes.getDvsSerie(), this.nature, var4, (Session)null);
            if (var1 != null) {
               this.mesCaissesItems = var3.selectActifCaisseItems(this.usersLog.getUsrJrxReserve(), (Session)null);
            } else {
               this.mesCaissesItems.add(new SelectItem(""));
            }
         } else {
            this.mesCaissesItems.add(new SelectItem(""));
         }
      } else {
         this.mesCaissesItems.add(new SelectItem(""));
      }

   }

   public void annulePaye() {
      this.setShowModalPanelPaye(false);
   }

   public void chargerModReg() {
      if (this.devisEnteteVentes.getDvsTypeReg() != 4 && this.devisEnteteVentes.getDvsTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.devisEnteteVentes.getDvsTotTtc()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.devisEnteteVentes.getDvsTypeReg() == 5) {
               this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var11 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var10 = var11.existenceHabilitation(29, var1);
               if (var10 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.devisEnteteVentes.getDvsSerie(), var1);
               this.bonEncaissementVente = new BonEncaissementVente();
               this.bonEncaissementVente.setBonDateCreat(new Date());
               if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                  String[] var4 = this.var_inputCaisse.split(":");
                  this.bonEncaissementVente.setBonCodeCaisse(var4[0]);
                  this.bonEncaissementVente.setBonLibCaisse(var4[1]);
               } else {
                  this.bonEncaissementVente.setBonCodeCaisse("");
                  this.bonEncaissementVente.setBonLibCaisse("");
               }

               this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
               this.bonEncaissementVente.setBonActivite(this.devisEnteteVentes.getDvsActivite());
               this.bonEncaissementVente.setBonSite(this.devisEnteteVentes.getDvsSite());
               this.bonEncaissementVente.setBonDepartement(this.devisEnteteVentes.getDvsDepartement());
               this.bonEncaissementVente.setBonService(this.devisEnteteVentes.getDvsService());
               this.bonEncaissementVente.setBonRegion(this.devisEnteteVentes.getDvsRegion());
               this.bonEncaissementVente.setBonSecteur(this.devisEnteteVentes.getDvsSecteur());
               this.bonEncaissementVente.setBonPdv(this.devisEnteteVentes.getDvsPdv());
               if (this.devisEnteteVentes.getDvsTypeReg() == 0) {
                  this.devisEnteteVentes.setDvsEcheanceReliquat((Date)null);
                  this.bonEncaissementVente.setBonDateEcheReg(this.devisEnteteVentes.getDvsDateEcheReg());
               } else {
                  if (this.devisEnteteVentes.getDvsEcheanceReliquat() == null) {
                     this.devisEnteteVentes.setDvsEcheanceReliquat(this.devisEnteteVentes.getDvsDateEcheReg());
                  }

                  this.bonEncaissementVente.setBonDateEcheReg(this.devisEnteteVentes.getDvsEcheanceReliquat());
               }

               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               this.bonEncaissementVente.setBonNomTiers(this.devisEnteteVentes.getDvsNomTiers());
               this.bonEncaissementVente.setBonIdTiers(this.devisEnteteVentes.getTiers().getTieid());
               this.bonEncaissementVente.setBonNomContact(this.devisEnteteVentes.getDvsNomContact());
               this.bonEncaissementVente.setBonIdContact(this.devisEnteteVentes.getDvsIdContact());
               this.bonEncaissementVente.setBonTypeTiers(0);
               this.bonEncaissementVente.setBonLibelle("Règlement Devis N° " + this.devisEnteteVentes.getDvsNum());
               this.bonEncaissementVente.setBonRef(this.devisEnteteVentes.getDvsNum());
               this.bonEncaissementVente.setBonIdRef(this.devisEnteteVentes.getDvsId());
               this.bonEncaissementVente.setBonObject(this.devisEnteteVentes.getDvsObject());
               this.bonEncaissementVente.setBonObservation(this.devisEnteteVentes.getDvsObservation());
               this.bonEncaissementVente.setBonSerie(this.devisEnteteVentes.getDvsSerie());
               this.bonEncaissementVente.setBonDevise(this.devisEnteteVentes.getDvsDevise());
               this.bonEncaissementVente.setBonTotTtc(this.devisEnteteVentes.getDvsTotTtc());
               this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
               this.bonEncaissementVente.setBonTypeReg(this.devisEnteteVentes.getDvsTypeReg());
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var3);
               this.bonEncaissementVente.setBonDate(new Date());
               this.bonEncaissementVente.setBonIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
               this.bonEncaissementVente.setBonNomResponsable(this.devisEnteteVentes.getDvsNomResponsable());
               this.bonEncaissementVente.setBonIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
               this.bonEncaissementVente.setBonNomCommercial(this.devisEnteteVentes.getDvsNomCommercial());
               this.bonEncaissementVente.setBonIdEquipe(this.devisEnteteVentes.getDvsIdEquipe());
               this.bonEncaissementVente.setBonNomEquipe(this.devisEnteteVentes.getDvsNomEquipe());
               this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
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

      this.setShowModalPanelPaye(false);
      this.visibiliteBton = false;
   }

   public void choixCaisse() {
      if (this.var_inputCaisse.equalsIgnoreCase("0")) {
         this.bonEncaissementVente.setBonCodeCaisse("");
         this.bonEncaissementVente.setBonLibCaisse("");
      } else {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonEncaissementVente.setBonCodeCaisse(var1[0]);
         this.bonEncaissementVente.setBonLibCaisse(var1[1]);
      }

   }

   public String conversionGarde() throws HibernateException, NamingException {
      String var1 = null;
      if (this.devisEnteteVentes.getDvsGarde() != null && !this.devisEnteteVentes.getDvsGarde().isEmpty()) {
         new ModelesCourriers();
         ModelesCourriersDao var3 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var2 = var3.rechercheModeles(this.devisEnteteVentes.getDvsGarde(), (Session)null);
         if (var2 != null) {
            if (var2.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteDevis(var2.getModTexte(), this.devisEnteteVentes.getUsers(), this.structureLog, this.devisEnteteVentes.getTiers(), this.devisEnteteVentes);
            } else {
               var1 = var2.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var4 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var4 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.devisEnteteVentes.getDvsFormule1() != null && !this.devisEnteteVentes.getDvsFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.devisEnteteVentes.getDvsFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.devisEnteteVentes.getDvsFormule2() != null && !this.devisEnteteVentes.getDvsFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.devisEnteteVentes.getDvsFormule2(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.devisEnteteVentes.getDvsAnnexe1() != null && !this.devisEnteteVentes.getDvsAnnexe1().isEmpty()) {
         new ModelesCourriers();
         ModelesCourriersDao var3 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var2 = var3.rechercheModeles(this.devisEnteteVentes.getDvsAnnexe1(), (Session)null);
         if (var2 != null) {
            if (var2.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var2.getModTexte(), this.devisEnteteVentes.getUsers(), this.structureLog, this.devisEnteteVentes.getTiers());
            } else {
               var1 = var2.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var4 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var4 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.devisEnteteVentes.getDvsAnnexe2() != null && !this.devisEnteteVentes.getDvsAnnexe2().isEmpty()) {
         new ModelesCourriers();
         ModelesCourriersDao var3 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var2 = var3.rechercheModeles(this.devisEnteteVentes.getDvsAnnexe2(), (Session)null);
         if (var2 != null) {
            if (var2.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var2.getModTexte(), this.devisEnteteVentes.getUsers(), this.structureLog, this.devisEnteteVentes.getTiers());
            } else {
               var1 = var2.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var4 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var4 + " alt=" + "signature /></p>";
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatDevis.jpg");
            if (var4.exists()) {
               var3 = "formatDevis.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatDevis.jpg");
         if (var4.exists()) {
            var3 = "formatDevis.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var2 = false;
         String var3 = "";
         double var4 = 0.0D;
         double var6 = 0.0D;
         ConditionnementDao var8 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();

         for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
            this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var10);
            if (this.devisLigneVentes.getDvsligModeGroupe() != 2 || this.devisLigneVentes.getDvsligGroupe() == null || this.devisLigneVentes.getDvsligGroupe().isEmpty()) {
               this.devisLigneVentes.setVar_lib_des_condit("");
               if (this.devisLigneVentes.getDvsligCondition() != null && !this.devisLigneVentes.getDvsligCondition().isEmpty() && this.devisLigneVentes.getDvsligCondition().contains(":")) {
                  String[] var11 = this.devisLigneVentes.getDvsligCondition().split(":");
                  Conditionnement var9 = var8.rechercheConditionnement(var11[0], (Session)null);
                  if (var9 != null) {
                     this.devisLigneVentes.setVar_lib_des_condit(var9.getCdtDescription());
                  }
               }

               if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() && this.devisLigneVentes.getDvsligCode().equals("-")) {
                  var2 = true;
                  var3 = this.devisLigneVentes.getDvsligLibelle();
               }

               if (var2) {
                  var4 += this.devisLigneVentes.getDvsligPt();
                  var6 = this.devisLigneVentes.getDvsligTtc();
               }

               if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty() && this.devisLigneVentes.getDvsligCode().equals("=") && var2) {
                  this.devisLigneVentes = new DevisLigneVentes();
                  this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
                  this.devisLigneVentes.setDvsligCode("=");
                  this.devisLigneVentes.setDvsligOrdre(var10);
                  this.devisLigneVentes.setDvsligLibelle(var3);
                  this.devisLigneVentes.setDvsligPt(var4);
                  this.devisLigneVentes.setDvsligTtc(var6);
                  var1.add(this.devisLigneVentes);
                  var4 = 0.0D;
                  var6 = 0.0D;
                  var2 = false;
               } else {
                  this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
                  this.devisLigneVentes.setDvsligOrdre(var10);
                  var1.add(this.devisLigneVentes);
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.devisLigneVentes = new DevisLigneVentes();
            this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
            this.devisLigneVentes.setDvsligCode("FORMULE1");
            this.devisLigneVentes.setDvsligOrdre(var1.size() + 2);
            this.devisLigneVentes.setDvsligLibelle(this.formule1());
            this.devisLigneVentes.setDvsligPt(0.0D);
            this.devisLigneVentes.setDvsligTtc(0.0D);
            var1.add(this.devisLigneVentes);
            this.devisLigneVentes = new DevisLigneVentes();
            this.devisLigneVentes.setDevisEnteteVentes(this.devisEnteteVentes);
            this.devisLigneVentes.setDvsligCode("FORMULE2");
            this.devisLigneVentes.setDvsligOrdre(var1.size() + 2);
            this.devisLigneVentes.setDvsligLibelle(this.formule2());
            this.devisLigneVentes.setDvsligPt(0.0D);
            this.devisLigneVentes.setDvsligTtc(0.0D);
            var1.add(this.devisLigneVentes);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.utilNombre.myRoundDevise(this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), this.devisEnteteVentes.getDvsDevise()), this.devisEnteteVentes.getDvsDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var1);
      return var12;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.devisEnteteVentes.getDvsAnal2() != null && !this.devisEnteteVentes.getDvsAnal2().isEmpty()) {
         String var4 = "";
         if (this.devisEnteteVentes.getDvsAnal2().contains(":")) {
            String[] var5 = this.devisEnteteVentes.getDvsAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.devisEnteteVentes.getDvsAnal2();
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

   public boolean majDateImpression(String var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.devisEnteteVentes.getDvsDateImp() != null && this.devisEnteteVentes.getDvsEtat() != 0) {
            var3 = true;
         }

         this.devisEnteteVentes.setDvsDateImp(new Date());
         if (this.devisEnteteVentes.getDvsEtat() == 0 && this.devisEnteteVentes.getDvsEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.devisEnteteVentes.setDvsEtat(1);
            if (this.tiers.getTieDteDocument1() == null || this.devisEnteteVentes.getDvsDate().after(this.tiers.getTieDteDocument1())) {
               this.tiers.setTieDteDocument1(this.devisEnteteVentes.getDvsDate());
               this.tiers = this.tiersDao.modif(this.tiers, var4);
            }
         }

         this.devisEnteteVentes.setDvsModeleImp(var1);
         if (var2 != null && !var2.isEmpty() && var2.equals("MAIL")) {
            this.devisEnteteVentes.setDvsDateEnvoie(new Date());
         }

         if (this.devisEnteteVentesDao == null) {
            this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         }

         this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var4);
         if (this.lesLignesList.size() != 0) {
            this.devisLigneVentes = new DevisLigneVentes();

            for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var6);
               double var7 = this.devisLigneVentes.getDvsligPu();
               double var9 = this.devisLigneVentes.getDvsligPuTtc();
               this.devisLigneVentes.setVar_desciptif((String)null);
               this.devisLigneVentes.setVar_tarif((String)null);
               this.devisLigneVentes.setVar_photo((String)null);
               this.devisLigneVentes.setVar_photo_taille(0);
               if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                  if (this.produitsDao == null) {
                     this.produitsDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
                  }

                  this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var4);
                  if (this.produits != null) {
                     String var11 = this.produits.getProCode();
                     String var12;
                     if (this.devisLigneVentes.getDvsligPrintTexte() == 0) {
                        this.devisLigneVentes.setVar_desciptif(this.produits.getProDescrip());
                        var12 = this.prixUnitaireDegressif(true, var4);
                        if (var12 != null && !var12.isEmpty()) {
                           this.devisLigneVentes.setVar_tarif(var12 + "\n");
                        }
                     } else {
                        this.devisLigneVentes.setVar_desciptif((String)null);
                        this.devisLigneVentes.setVar_tarif((String)null);
                     }

                     if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
                        var12 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
                        File var13 = new File(var12);
                        if (var13.exists()) {
                           this.devisLigneVentes.setVar_photo(var12);
                           if (this.produits.getProPhotoTaille() == 0) {
                              this.devisLigneVentes.setVar_photo_taille(1);
                           } else {
                              this.devisLigneVentes.setVar_photo_taille(2);
                           }
                        } else {
                           this.devisLigneVentes.setVar_photo((String)null);
                           this.devisLigneVentes.setVar_photo_taille(0);
                        }
                     } else {
                        this.devisLigneVentes.setVar_photo((String)null);
                        this.devisLigneVentes.setVar_photo_taille(0);
                     }

                     new DevisLigneVentes();

                     for(int var20 = var6 + 1; var20 < this.lesLignesList.size(); ++var20) {
                        DevisLigneVentes var19 = (DevisLigneVentes)this.lesLignesList.get(var20);
                        if (var19.getDvsligCode() != null && !var19.getDvsligCode().isEmpty() && var19.getDvsligCode().equals(var11)) {
                           var19.setDvsligCode(var19.getDvsligCode() + "*");
                        }
                     }
                  }
               }

               this.devisLigneVentes.setDvsligPu(var7);
               this.devisLigneVentes.setDvsligPuTtc(var9);
            }
         }

         this.contacts = new Contacts();
         if (this.devisEnteteVentes.getDvsIdContact() != 0L) {
            if (this.contactDao == null) {
               this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
            }

            this.contacts = this.contactDao.chargerLesContactsById(this.devisEnteteVentes.getDvsIdContact(), var4);
         }

         var5.commit();
      } catch (HibernateException var17) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var17;
      } finally {
         this.utilInitHibernate.closeSession();
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
            boolean var12 = this.majDateImpression(var4, var6);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setEntete("Impression devis");
            var1.setPageGarde(this.conversionGarde());
            if (this.devisEnteteVentes.getDvsFormule1() != null && !this.devisEnteteVentes.getDvsFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setRapport(var4);
            var1.setRapportEncapsule((String)null);
            var1.setNomMapping("");
            var1.setRequete("");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.devisEnteteVentes.getDvsEtat()));
            var1.setDuplicata("" + var12);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.devisEnteteVentes.setDvsDevise(this.devisePrint);
            if (!this.devisEnteteVentes.getDvsDevise().equals("XOF") && !this.devisEnteteVentes.getDvsDevise().equals("XAF")) {
               if (this.devisEnteteVentes.getDvsDevise().equals("EUR")) {
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
               double var13 = this.utilNombre.myRound((this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.devisEnteteVentes.getDvsIdResponsable());
            var1.setIdCommercial(this.devisEnteteVentes.getDvsIdCommercial());
            var1.setTiersSelectionne(this.devisEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.devisEnteteVentes.getDvsNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.devisEnteteVentes.getDvsId());
            if (this.devisEnteteVentes.getDvsAnal2() != null && !this.devisEnteteVentes.getDvsAnal2().isEmpty()) {
               String var17 = "";
               if (this.devisEnteteVentes.getDvsAnal2().contains(":")) {
                  String[] var14 = this.devisEnteteVentes.getDvsAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.devisEnteteVentes.getDvsAnal2();
               }

               new Parc();
               ParcDao var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var18 = var15.rechercheParc(var17, (Session)null);
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
      } else if (var2 == 1 && var5 != null && !var5.isEmpty()) {
         var1.setRapport(var5);
         var1.setEntete("Impression de la liste des devis");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "devis" + File.separator);
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
         JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var16);
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
            this.uniteGraph = "DEVIS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "DEVIS : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "DEVIS : Quantites";
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

         new DevisEnteteVentes();
         new DevisLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         String var6 = "";

         DevisEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (DevisEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getDvsNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getDvsNum() + "'";
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

                  var14 = (DevisEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getDvsDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getDvsNomResponsable() != null && !var14.getDvsNomResponsable().isEmpty()) {
                        var17 = var14.getDvsNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getDvsNomCommercial() != null && !var14.getDvsNomCommercial().isEmpty()) {
                        var17 = var14.getDvsNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getDvsNomEquipe() != null && !var14.getDvsNomEquipe().isEmpty()) {
                        var17 = var14.getDvsNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getDvsNomTiers() != null && !var14.getDvsNomTiers().isEmpty()) {
                        var17 = var14.getDvsNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getDvsSource() != null && !var14.getDvsSource().isEmpty()) {
                        var17 = var14.getDvsSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getDvsAnal4() != null && !var14.getDvsAnal4().isEmpty()) {
                        var17 = var14.getDvsAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getDvsRegion() != null && !var14.getDvsRegion().isEmpty()) {
                        var17 = var14.getDvsRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getDvsSecteur() != null && !var14.getDvsSecteur().isEmpty()) {
                        var17 = var14.getDvsSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getDvsPdv() != null && !var14.getDvsPdv().isEmpty()) {
                        var17 = var14.getDvsPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getDvsSite() != null && !var14.getDvsSite().isEmpty()) {
                        var17 = var14.getDvsSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getDvsDepartement() != null && !var14.getDvsDepartement().isEmpty()) {
                        var17 = var14.getDvsDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getDvsService() != null && !var14.getDvsService().isEmpty()) {
                        var17 = var14.getDvsService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getDvsSerie() != null && !var14.getDvsSerie().isEmpty()) {
                        var17 = var14.getDvsSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getDvsTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getDvsDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getDvsDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getDvsDate().getMonth() + 1 >= 1 && var14.getDvsDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getDvsDate().getMonth() + 1 >= 4 && var14.getDvsDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getDvsDate().getMonth() + 1 >= 7 && var14.getDvsDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getDvsDate().getMonth() + 1 >= 10 && var14.getDvsDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getDvsDate().getMonth() + 1 >= 1 && var14.getDvsDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getDvsDate().getMonth() + 1 >= 7 && var14.getDvsDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getDvsDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.devisLigneVentesDao.chargerLesLignesDevis(var6, var5);
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

                  DevisLigneVentes var15 = (DevisLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getDevisEnteteVentes().getDvsDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getDevisEnteteVentes().getDvsNomResponsable() != null && !var15.getDevisEnteteVentes().getDvsNomResponsable().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getDevisEnteteVentes().getDvsNomCommercial() != null && !var15.getDevisEnteteVentes().getDvsNomCommercial().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getDevisEnteteVentes().getDvsNomEquipe() != null && !var15.getDevisEnteteVentes().getDvsNomEquipe().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getDevisEnteteVentes().getDvsNomTiers() != null && !var15.getDevisEnteteVentes().getDvsNomTiers().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getDvsligFamille() != null && !var15.getDvsligFamille().isEmpty()) {
                        var8 = var15.getDvsligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getDvsligLibelle() != null && !var15.getDvsligLibelle().isEmpty()) {
                        var8 = var15.getDvsligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getDevisEnteteVentes().getDvsSource() != null && !var15.getDevisEnteteVentes().getDvsSource().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getDevisEnteteVentes().getDvsAnal4() != null && !var15.getDevisEnteteVentes().getDvsAnal4().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getDevisEnteteVentes().getDvsRegion() != null && !var15.getDevisEnteteVentes().getDvsRegion().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getDevisEnteteVentes().getDvsSecteur() != null && !var15.getDevisEnteteVentes().getDvsSecteur().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getDevisEnteteVentes().getDvsPdv() != null && !var15.getDevisEnteteVentes().getDvsPdv().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getDevisEnteteVentes().getDvsSite() != null && !var15.getDevisEnteteVentes().getDvsSite().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getDevisEnteteVentes().getDvsDepartement() != null && !var15.getDevisEnteteVentes().getDvsDepartement().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getDevisEnteteVentes().getDvsService() != null && !var15.getDevisEnteteVentes().getDvsService().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getDevisEnteteVentes().getDvsSerie() != null && !var15.getDevisEnteteVentes().getDvsSerie().isEmpty()) {
                        var8 = var15.getDevisEnteteVentes().getDvsSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getDvsligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getDvsligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getDevisEnteteVentes().getDvsDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 >= 1 && var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 >= 4 && var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 >= 7 && var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 >= 10 && var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 >= 1 && var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 >= 7 && var15.getDevisEnteteVentes().getDvsDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getDevisEnteteVentes().getDvsDate().getHours();
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

   public void recalculTva(DevisEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.devisEnteteVentes = var1;
         this.tiers = this.devisEnteteVentes.getTiers();
         if (this.tiers.getTiecss() == 0 && this.structureLog.getStrcodepays().equals("0077")) {
            this.var_tc_calcul = true;
            this.var_tc_taux = 1.0F;
            this.var_tc_type = 7;
         } else {
            this.var_tc_calcul = false;
            this.var_tc_taux = 0.0F;
            this.var_tc_type = 0;
         }

         this.lesLignesList = this.devisLigneVentesDao.chargerLesLignes(this.devisEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.devisLigneVentes = (DevisLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.devisLigneVentes.getDvsligCode() != null && !this.devisLigneVentes.getDvsligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.devisLigneVentes.getDvsligCode(), var2);
               }

               this.calculPrix(this.devisLigneVentes.getDvsligTaxe(), this.devisLigneVentes.getDvsligTauxTaxe(), var2);
               this.devisLigneVentes = this.devisLigneVentesDao.modifLigne(this.devisLigneVentes, var2);
            }

            this.cumulPrix();
            this.devisEnteteVentes = this.devisEnteteVentesDao.modif(this.devisEnteteVentes, var2);
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

   public DevisEnteteVentes getDevisEnteteVentes() {
      return this.devisEnteteVentes;
   }

   public void setDevisEnteteVentes(DevisEnteteVentes var1) {
      this.devisEnteteVentes = var1;
   }

   public DevisLigneVentes getDevisLigneVentes() {
      return this.devisLigneVentes;
   }

   public void setDevisLigneVentes(DevisLigneVentes var1) {
      this.devisLigneVentes = var1;
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

   public boolean isShowModalPanelValidationDocument() {
      return this.showModalPanelValidationDocument;
   }

   public void setShowModalPanelValidationDocument(boolean var1) {
      this.showModalPanelValidationDocument = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
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

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
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

   public List getLesLignesList() {
      return this.lesLignesList;
   }

   public void setLesLignesList(List var1) {
      this.lesLignesList = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
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

   public boolean isRelance1() {
      return this.relance1;
   }

   public void setRelance1(boolean var1) {
      this.relance1 = var1;
   }

   public boolean isRelance2() {
      return this.relance2;
   }

   public void setRelance2(boolean var1) {
      this.relance2 = var1;
   }

   public boolean isRelance3() {
      return this.relance3;
   }

   public void setRelance3(boolean var1) {
      this.relance3 = var1;
   }

   public String getNomUserRelance1() {
      return this.nomUserRelance1;
   }

   public void setNomUserRelance1(String var1) {
      this.nomUserRelance1 = var1;
   }

   public String getNomUserRelance2() {
      return this.nomUserRelance2;
   }

   public void setNomUserRelance2(String var1) {
      this.nomUserRelance2 = var1;
   }

   public String getNomUserRelance3() {
      return this.nomUserRelance3;
   }

   public void setNomUserRelance3(String var1) {
      this.nomUserRelance3 = var1;
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

   public boolean isPrintTexte() {
      return this.printTexte;
   }

   public void setPrintTexte(boolean var1) {
      this.printTexte = var1;
   }

   public List getMesDelaisLivraisonItems() {
      return this.mesDelaisLivraisonItems;
   }

   public void setMesDelaisLivraisonItems(List var1) {
      this.mesDelaisLivraisonItems = var1;
   }

   public List getMesModesReglementsItems() {
      return this.mesModesReglementsItems;
   }

   public void setMesModesReglementsItems(List var1) {
      this.mesModesReglementsItems = var1;
   }

   public DataModel getDataModelModeleDevis() {
      return this.dataModelModeleDevis;
   }

   public void setDataModelModeleDevis(DataModel var1) {
      this.dataModelModeleDevis = var1;
   }

   public double getTotAbnDevis() {
      return this.totAbnDevis;
   }

   public void setTotAbnDevis(double var1) {
      this.totAbnDevis = var1;
   }

   public double getTotModeleDevis() {
      return this.totModeleDevis;
   }

   public void setTotModeleDevis(double var1) {
      this.totModeleDevis = var1;
   }

   public boolean isShowModalPanelModelDevis() {
      return this.showModalPanelModelDevis;
   }

   public void setShowModalPanelModelDevis(boolean var1) {
      this.showModalPanelModelDevis = var1;
   }

   public boolean isModeleDevis() {
      return this.modeleDevis;
   }

   public void setModeleDevis(boolean var1) {
      this.modeleDevis = var1;
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
