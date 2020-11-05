package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
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
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FactureInterneLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
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
import com.epegase.systeme.dao.CaissesCommercialesDao;
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
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
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

public class FormFactureInterneVentes implements Serializable {
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
   private FactureInterneEnteteVentes factureInterneEnteteVentes = new FactureInterneEnteteVentes();
   private FactureInterneEnteteVentesDao factureInterneEnteteVentesDao;
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
   private FactureInterneLigneVentes factureInterneLigneVentes = new FactureInterneLigneVentes();
   private FactureInterneLigneVentesDao factureInterneLigneVentesDao;
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
   private String infoOrigineDoc;
   private String devisePrint;
   private float tauxPrint;
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
   private String libelleRabRis;
   private boolean ristourne;

   public FormFactureInterneVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.factureInterneEnteteVentesDao = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneLigneVentesDao = new FactureInterneLigneVentesDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionsVentes.getAffichInGlobViewNOTDEB();
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
         List var12 = this.factureInterneEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new FactureInterneEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               FactureInterneEnteteVentes var16 = (FactureInterneEnteteVentes)var12.get(var17);
               if (var16.getFitActivite() != null && !var16.getFitActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getFitActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getFitActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getFitActivite().contains(this.var_colonne3)) {
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
         new FactureInterneEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            FactureInterneEnteteVentes var18 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var18.getFitTotTtc();
            var4 += var18.getFitTotReglement();
            var6 += var18.getFitTotHt();
            var8 += var18.getFitTotTva();
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
            this.factureInterneEnteteVentes = (FactureInterneEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.factureInterneEnteteVentes.getFitNomTiers();
            this.inpIdTiersEnCours = this.factureInterneEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.factureInterneEnteteVentes.getFitNomContact();
            this.var_date = this.factureInterneEnteteVentes.getFitDate();
            if (this.factureInterneEnteteVentes.getFitDate().getHours() <= 9) {
               this.var_heure = "0" + this.factureInterneEnteteVentes.getFitDate().getHours();
            } else {
               this.var_heure = "" + this.factureInterneEnteteVentes.getFitDate().getHours();
            }

            if (this.factureInterneEnteteVentes.getFitDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.factureInterneEnteteVentes.getFitDate().getMinutes();
            } else {
               this.var_minute = "" + this.factureInterneEnteteVentes.getFitDate().getMinutes();
            }

            if (this.factureInterneEnteteVentes.getFitDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.factureInterneEnteteVentes.getFitDate().getSeconds();
            } else {
               this.var_seconde = "" + this.factureInterneEnteteVentes.getFitDate().getSeconds();
            }

            this.tiers = this.factureInterneEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.numeroPfManuel = this.factureInterneEnteteVentes.getFitAnal4();
            this.var_nom_contact = this.factureInterneEnteteVentes.getFitIdContact();
            this.var_nom_responsable = this.factureInterneEnteteVentes.getFitIdResponsable();
            this.var_nom_commercial = this.factureInterneEnteteVentes.getFitIdCommercial();
            this.calculDevise();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
            this.chargerDocumentLigne(var6);
            double var4 = this.chargerBonEncaissement(var6);
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
            if (this.factureInterneEnteteVentes.getFitTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }

            this.utilInitHibernate.closeSession();
            if (this.factureInterneEnteteVentes.getFitTotReglement() != var4) {
               if (this.structureLog.getStrid() != 42L && this.structureLog.getStrid() != 43L && this.structureLog.getStrid() != 44L && this.structureLog.getStrid() != 45L) {
                  this.factureInterneEnteteVentes.setFitTotReglement(var4);
                  if (Math.abs(var4) >= this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc()) {
                     this.factureInterneEnteteVentes.setFitSolde(1);
                  } else {
                     this.factureInterneEnteteVentes.setFitSolde(0);
                  }

                  this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
               } else if (this.factureInterneEnteteVentes.getFitSolde() == 0) {
                  this.factureInterneEnteteVentes.setFitTotReglement(var4);
                  this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
               }
            } else {
               if (Math.abs(var4) >= Math.abs(this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc())) {
                  this.factureInterneEnteteVentes.setFitSolde(1);
               } else {
                  this.factureInterneEnteteVentes.setFitSolde(0);
               }

               this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
            }

            this.setMontantTtcElmt(this.factureInterneEnteteVentes.getFitTotTtc());
            this.setMontantReglementElmt(this.factureInterneEnteteVentes.getFitTotReglement());
            this.setMontantElmTotBonEnc(this.factureInterneEnteteVentes.getFitTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.factureInterneEnteteVentes.getFitTotTtc() - this.factureInterneEnteteVentes.getFitTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.factureInterneEnteteVentes != null) {
         if (this.factureInterneEnteteVentes.getFitEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.factureInterneEnteteVentes.getFitDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.factureInterneEnteteVentes.getFitDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.factureInterneEnteteVentes.getFitId() > 0L) {
         this.lesLignesList = this.factureInterneLigneVentesDao.chargerLesLignes(this.factureInterneEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.factureInterneEnteteVentes != null && this.factureInterneEnteteVentes.getFitEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.factureInterneEnteteVentes.getFitAnal4(), this.factureInterneEnteteVentes.getFitAnal4()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var7 = this.reglementsDao.reglementDocument(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
      double var4 = 0.0D;
      if (var7.size() != 0) {
         this.afficheRecu = true;

         for(int var6 = 0; var6 < var7.size(); ++var6) {
            this.var_tot_bon_encaissement += ((Reglements)var7.get(var6)).getRglRecette();
            var4 += ((Reglements)var7.get(var6)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var7);
      if (this.var_tot_bon_encaissement < this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc()) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.factureInterneEnteteVentes.getFitId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
      }

      this.datamodelDocumentTrace.setWrappedData(var2);
      this.utilInitHibernate.closeSession();
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      this.datamodelDocumentTrace.setWrappedData(var2);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null && this.factureInterneEnteteVentes.getFitSerie() != null && !this.factureInterneEnteteVentes.getFitSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.factureInterneEnteteVentes.getFitSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.factureInterneEnteteVentes.getFitId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.factureInterneEnteteVentes.getFitDateTransfert() != null) {
            this.factureInterneEnteteVentes.setFitDateTransfert((Date)null);
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.factureInterneEnteteVentes.getFitActivite() != null && !this.factureInterneEnteteVentes.getFitActivite().isEmpty() && this.factureInterneEnteteVentes.getFitActivite().contains(":")) {
         String[] var1 = null;
         if (!this.factureInterneEnteteVentes.getFitActivite().contains("#")) {
            var1 = this.factureInterneEnteteVentes.getFitActivite().split(":");
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
            String[] var2 = this.factureInterneEnteteVentes.getFitActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.factureInterneEnteteVentes.getFitTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.factureInterneEnteteVentes.getFitTotHt() - this.totalImputation;
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
      this.factureInterneEnteteVentes = new FactureInterneEnteteVentes();
      this.factureInterneLigneVentes = new FactureInterneLigneVentes();
      this.factureInterneEnteteVentes.setUsers(this.usersLog);
      this.factureInterneEnteteVentes.setFitIdCreateur(this.usersLog.getUsrid());
      this.factureInterneEnteteVentes.setFitNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.factureInterneEnteteVentes.setFitDate(new Date());
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
      this.factureInterneEnteteVentes.setFitDateLivraison((Date)null);
      this.factureInterneEnteteVentes.setFitBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.factureInterneEnteteVentes.setFitIdCommercial(this.usersLog.getUsrid());
         this.factureInterneEnteteVentes.setFitNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.factureInterneEnteteVentes.setFitIdResponsable(this.usersLog.getUsrid());
         this.factureInterneEnteteVentes.setFitNomResponsable(this.usersLog.getUsrPatronyme());
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
      if (this.optionsVentes.getNbrJrRelanceNOTDEB() != null && !this.optionsVentes.getNbrJrRelanceNOTDEB().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceNOTDEB());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidNOTDEB() != null && !this.optionsVentes.getNbrJrValidNOTDEB().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidNOTDEB());
      } else {
         var4 = 0;
      }

      this.factureInterneEnteteVentes.setFitDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.factureInterneEnteteVentes.setFitDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         if (this.usersLog.getUsrSignatureVentes() == 1) {
            this.chargerLesUsers((Session)null);
         } else if (this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.factureInterneEnteteVentes.getFitIdResponsable(), this.factureInterneEnteteVentes.getFitNomResponsable()));
         }

         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.factureInterneEnteteVentes.getFitIdResponsable(), this.factureInterneEnteteVentes.getFitNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureInterneEnteteVentes.getFitEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.factureInterneEnteteVentes.setFitEtat(1);
               this.factureInterneEnteteVentes.setFitDateValide(new Date());
               this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle facture interne (C.) N° " + this.factureInterneEnteteVentes.getFitNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureInterneEnteteVentes.getFitDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument6() == null || this.factureInterneEnteteVentes.getFitDate().after(this.tiers.getTieDteDocument6())) {
               this.tiers.setTieDteDocument6(this.factureInterneEnteteVentes.getFitDate());
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
      if (this.factureInterneEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureInterneEnteteVentes.getFitEtat() == 1) {
               this.factureInterneEnteteVentes.setFitEtat(0);
               this.factureInterneEnteteVentes.setFitDateValide((Date)null);
               this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
               new ArrayList();
               List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
               if (var3.size() != 0) {
                  for(int var4 = 0; var4 < var3.size(); ++var4) {
                     this.bonEncaissementVente = (BonEncaissementVente)var3.get(var4);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
                  }
               }

               this.var_tot_bon_encaissement = 0.0D;
               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Dévalidation manuelle facture interne (C.) N° " + this.factureInterneEnteteVentes.getFitNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureInterneEnteteVentes.getFitDate()));
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
      if (this.factureInterneEnteteVentes != null) {
         this.factureInterneEnteteVentes.setFitEtat(0);
         this.factureInterneEnteteVentes.setFitDateAnnule((Date)null);
         this.factureInterneEnteteVentes.setFitMotifAnnule("");
         this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.factureInterneEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.factureInterneEnteteVentes.getFitId();
            String var5 = this.factureInterneEnteteVentes.getFitNum();
            Date var6 = this.factureInterneEnteteVentes.getFitDate();
            this.factureInterneLigneVentesDao.deleteAllLigne(this.factureInterneEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
            this.factureInterneEnteteVentesDao.delete(this.factureInterneEnteteVentes.getFitId(), var1);
            new DocumentTraceVentes();
            DocumentTraceVentes var7 = this.documentTraceVentesDao.chercherDestinationTrace(var3, this.nature, var1);
            if (var7 != null) {
               long var8 = var7.getDoctraOrgId();
               int var10 = var7.getDoctraOrgType();
               this.documentTraceVentesDao.delete(var7, var1);
               boolean var11 = false;
               var7 = this.documentTraceVentesDao.chercherOrigineTrace(var8, var10, var1);
               byte var20;
               if (var7 != null) {
                  var20 = 4;
               } else {
                  var20 = 1;
               }

               if (var10 == 21) {
                  new DevisEnteteVentes();
                  DevisEnteteVentesDao var13 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  DevisEnteteVentes var12 = var13.pourParapheur(var8, var1);
                  if (var12 != null) {
                     var12.setDvsEtat(var20);
                     if (var20 == 1) {
                        var12.setDvsDateTransforme((Date)null);
                        var12.setDvsTypeTransforme(0);
                     }

                     var13.modif(var12, var1);
                  }
               }
            }

            Espion var19 = new Espion();
            var19.setUsers(this.usersLog);
            var19.setEsptype(0);
            var19.setEspdtecreat(new Date());
            var19.setEspaction("Suppression Facture interne N° " + var5 + " du " + var6);
            this.espionDao.mAJEspion(var19, var1);
            var2.commit();
         } catch (HibernateException var17) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.factureInterneEnteteVentes.getFitId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.factureInterneEnteteVentes.setUsers(this.usersLog);
            this.factureInterneEnteteVentes.setFitIdCreateur(this.usersLog.getUsrid());
            this.factureInterneEnteteVentes.setFitNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.factureInterneEnteteVentes.setFitDate(new Date());
            this.factureInterneEnteteVentes.setFitDateCreat(new Date());
            this.factureInterneEnteteVentes.setFitDateModif((Date)null);
            this.factureInterneEnteteVentes.setFitIdModif(0L);
            this.factureInterneEnteteVentes.setFitNomModif("");
            this.factureInterneEnteteVentes.setFitNum("");
            this.factureInterneEnteteVentes.setFitIdResponsable(this.usersLog.getUsrid());
            this.factureInterneEnteteVentes.setFitNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var3 = false;
            int var12;
            if (this.optionsVentes.getNbrJrRelanceNOTDEB() != null && !this.optionsVentes.getNbrJrRelanceNOTDEB().isEmpty()) {
               var12 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceNOTDEB());
            } else {
               var12 = 0;
            }

            boolean var4 = false;
            int var13;
            if (this.optionsVentes.getNbrJrValidNOTDEB() != null && !this.optionsVentes.getNbrJrValidNOTDEB().isEmpty()) {
               var13 = Integer.parseInt(this.optionsVentes.getNbrJrValidNOTDEB());
            } else {
               var13 = 0;
            }

            this.factureInterneEnteteVentes.setFitDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var12));
            this.factureInterneEnteteVentes.setFitDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var13));
            this.factureInterneEnteteVentes.setFitDateLivraison((Date)null);
            if (!this.factureInterneEnteteVentes.getFitSerie().equalsIgnoreCase("X") && !this.factureInterneEnteteVentes.getFitSerie().isEmpty()) {
               this.factureInterneEnteteVentes.setFitNum(this.calculChrono.numCompose(this.factureInterneEnteteVentes.getFitDate(), this.nature, this.factureInterneEnteteVentes.getFitSerie(), var1));
            } else {
               long var5 = this.factureInterneEnteteVentesDao.selectLastNum(var1);
               this.factureInterneEnteteVentes.setFitNum("" + var5);
            }

            this.verifieExistenceHabilitation();
            this.factureInterneEnteteVentes.setFitDateAnnule((Date)null);
            this.factureInterneEnteteVentes.setFitMotifAnnule("");
            this.factureInterneEnteteVentes.setFitDateImp((Date)null);
            this.factureInterneEnteteVentes.setFitDateTransforme((Date)null);
            this.factureInterneEnteteVentes.setFitDateTransfert((Date)null);
            this.factureInterneEnteteVentes.setFitDateLastReg((Date)null);
            this.factureInterneEnteteVentes.setFitTotReglement(0.0D);
            this.factureInterneEnteteVentes.setFitSolde(0);
            this.factureInterneEnteteVentes.setFitEtat(0);
            this.factureInterneEnteteVentes.setFitContener("");
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.duppliquer(this.factureInterneEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               this.factureInterneLigneVentesDao.duppliquerLigne(this.lesLignesList, this.factureInterneEnteteVentes, var1);
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

         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureInterneEnteteVentes.getFitId(), this.factureInterneEnteteVentes.getFitNum(), this.factureInterneEnteteVentes.getFitNomTiers(), this.factureInterneEnteteVentes.getFitDate(), this.factureInterneEnteteVentes.getFitDevise(), this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc(), this.factureInterneEnteteVentes.getFitModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.factureInterneEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.factureInterneEnteteVentes.getFitTypeTransforme() != 0) {
            var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.factureInterneEnteteVentes.getFitTypeTransforme(), var1);
            if (var3) {
               String var4 = "";
               if (this.factureInterneEnteteVentes.getFitTypeTransforme() == 22) {
                  var4 = "Bon de commande";
               } else if (this.factureInterneEnteteVentes.getFitTypeTransforme() == 23) {
                  var4 = "Bon de livraison";
               } else if (this.factureInterneEnteteVentes.getFitTypeTransforme() == 24) {
                  var4 = "Bon retour";
               } else if (this.factureInterneEnteteVentes.getFitTypeTransforme() == 25) {
                  var4 = "Facture";
               } else if (this.factureInterneEnteteVentes.getFitTypeTransforme() == 26) {
                  var4 = "Avoir";
               } else if (this.factureInterneEnteteVentes.getFitTypeTransforme() == 27) {
                  var4 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.factureInterneEnteteVentes.getFitTypeTransforme(), var4));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 26, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(26, "Avoir"));
            }
         }

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            new FactureInterneEnteteVentes();
            FactureInterneEnteteVentes var5 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var8);
            if (var5.getFitId() > 0L && var5.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.factureInterneLigneVentesDao.chargerLesLignes(var5, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new FactureInterneLigneVentes();
                     FactureInterneLigneVentes var7 = (FactureInterneLigneVentes)this.lesLignesList.get(var6);
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
      if (this.factureInterneEnteteVentes.getFitTypeReg() != 0 && this.factureInterneEnteteVentes.getFitTypeReg() != 3) {
         if (this.factureInterneEnteteVentes.getFitTypeReg() != 1 && this.factureInterneEnteteVentes.getFitTypeReg() != 2 && this.factureInterneEnteteVentes.getFitTypeReg() != 10) {
            if (this.factureInterneEnteteVentes.getFitTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.factureInterneEnteteVentes.getFitModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.factureInterneEnteteVentes.getFitModeReg() != null && !this.factureInterneEnteteVentes.getFitModeReg().isEmpty() && this.factureInterneEnteteVentes.getFitModeReg().contains(":")) {
         String[] var2 = this.factureInterneEnteteVentes.getFitModeReg().split(":");
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

            this.factureInterneEnteteVentes.setFitTypeReg(Integer.parseInt(var3.getEcheances()));
            this.factureInterneEnteteVentes.setFitModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.factureInterneEnteteVentes.setFitNbJourReg(0);
            this.factureInterneEnteteVentes.setFitArrondiReg(0);
            break;
         }
      }

      if (this.factureInterneEnteteVentes.getFitTypeReg() != 0 && this.factureInterneEnteteVentes.getFitTypeReg() != 3) {
         if (this.factureInterneEnteteVentes.getFitTypeReg() != 1 && this.factureInterneEnteteVentes.getFitTypeReg() != 2 && this.factureInterneEnteteVentes.getFitTypeReg() != 10) {
            if (this.factureInterneEnteteVentes.getFitTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.factureInterneEnteteVentes.setFitTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.factureInterneEnteteVentes.setFitModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.factureInterneEnteteVentes.setFitNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.factureInterneEnteteVentes.setFitArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.factureInterneEnteteVentes.getFitModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.factureInterneEnteteVentes.getFitDate(), this.factureInterneEnteteVentes.getFitTypeReg(), this.factureInterneEnteteVentes.getFitNbJourReg(), this.factureInterneEnteteVentes.getFitArrondiReg());
      this.factureInterneEnteteVentes.setFitDateEcheReg(var1);
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
         if (this.factureInterneEnteteVentes.getFitId() != 0L) {
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
      this.verifieExistenceHabilitation();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.factureInterneEnteteVentes.setFitDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.factureInterneEnteteVentes.getUsers() == null) {
            this.factureInterneEnteteVentes.setUsers(this.usersLog);
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

         this.factureInterneEnteteVentes.setTiers(this.tiers);
         if ((this.factureInterneEnteteVentes.getFitCat() == null || this.factureInterneEnteteVentes.getFitCat().isEmpty()) && this.factureInterneEnteteVentes.getTiers().getTienomfamille() != null && !this.factureInterneEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.factureInterneEnteteVentes.setFitCat(this.factureInterneEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureInterneEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.factureInterneEnteteVentes.setFitCivilTiers("");
         } else {
            this.factureInterneEnteteVentes.setFitCivilTiers(this.factureInterneEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.factureInterneEnteteVentes.getFitDiversTiers() == 99) {
               this.factureInterneEnteteVentes.setFitIdContact(0L);
               this.factureInterneEnteteVentes.setFitNomContact("");
               this.factureInterneEnteteVentes.setFitCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.factureInterneEnteteVentes.setFitIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.factureInterneEnteteVentes.setFitNomContact(var3.getConpatronyme());
                     this.factureInterneEnteteVentes.setFitCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.factureInterneEnteteVentes.setFitNomContact(var3.getConservice());
                     this.factureInterneEnteteVentes.setFitCivilContact("SERVICE/SITE:");
                  } else {
                     this.factureInterneEnteteVentes.setFitIdContact(0L);
                     this.factureInterneEnteteVentes.setFitNomContact("");
                     this.factureInterneEnteteVentes.setFitCivilContact("");
                  }
               } else {
                  this.factureInterneEnteteVentes.setFitIdContact(0L);
                  this.factureInterneEnteteVentes.setFitNomContact("");
                  this.factureInterneEnteteVentes.setFitCivilContact("");
               }
            }

            this.factureInterneEnteteVentes.setFitTiersRegroupe(this.tiers.getTiesigle());
         }

         this.factureInterneEnteteVentes.setFitIdResponsable(0L);
         this.factureInterneEnteteVentes.setFitNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.factureInterneEnteteVentes.setFitIdResponsable(var15.getUsrid());
            this.factureInterneEnteteVentes.setFitNomResponsable(var15.getUsrPatronyme());
         }

         this.factureInterneEnteteVentes.setFitIdCommercial(0L);
         this.factureInterneEnteteVentes.setFitNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.factureInterneEnteteVentes.setFitIdCommercial(var4.getUsrid());
               this.factureInterneEnteteVentes.setFitNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.factureInterneEnteteVentes.setFitIdEquipe(0L);
         this.factureInterneEnteteVentes.setFitNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.factureInterneEnteteVentes.getFitIdResponsable(), var1);
            if (this.equipes != null) {
               this.factureInterneEnteteVentes.setFitIdEquipe(this.equipes.getEquId());
               this.factureInterneEnteteVentes.setFitNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc(), var16, this.factureInterneEnteteVentes.getFitDevise(), this.factureInterneEnteteVentes.getFitDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.factureInterneEnteteVentes.getFitDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.factureInterneEnteteVentes.getFitDevise());
               this.factureInterneEnteteVentes.setFitFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.factureInterneEnteteVentes.getFitDevise(), this.factureInterneEnteteVentes.getFitDate()));
            }
         }

         if (this.accesAffaires) {
         }

         if (this.factureInterneEnteteVentes.getFitId() != 0L) {
            if (this.factureInterneEnteteVentes.getFitEtat() == 6) {
               if (this.factureInterneEnteteVentes.getFitEtatVal() == 1) {
                  this.factureInterneEnteteVentes.setFitEtat(0);
               } else {
                  this.factureInterneEnteteVentes.setFitEtat(0);
               }
            }

            this.factureInterneEnteteVentes.setFitDateModif(new Date());
            this.factureInterneEnteteVentes.setFitIdModif(this.usersLog.getUsrid());
            this.factureInterneEnteteVentes.setFitNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var16);
               this.factureInterneLigneVentes.setFitligOrdre(var16);
               this.factureInterneLigneVentes.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var1);
            }
         } else {
            this.factureInterneEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.factureInterneEnteteVentes.setFitDateCreat(new Date());
            this.factureInterneEnteteVentes.setFitIdCreateur(this.usersLog.getUsrid());
            this.factureInterneEnteteVentes.setFitNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.factureInterneEnteteVentes.getFitSerie() != null && !this.factureInterneEnteteVentes.getFitSerie().equalsIgnoreCase("X") && !this.factureInterneEnteteVentes.getFitSerie().isEmpty()) {
               this.factureInterneEnteteVentes.setFitNum(this.calculChrono.numCompose(this.factureInterneEnteteVentes.getFitDate(), this.nature, this.factureInterneEnteteVentes.getFitSerie(), var1));
               boolean var18 = false;

               label409:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label409;
                     }

                     new FactureInterneEnteteVentes();
                     FactureInterneEnteteVentes var19 = this.factureInterneEnteteVentesDao.pourParapheurByNum(this.factureInterneEnteteVentes.getFitNum(), this.factureInterneEnteteVentes.getFitSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.factureInterneEnteteVentes.setFitNum(this.calculChrono.numCompose(this.factureInterneEnteteVentes.getFitDate(), this.nature, this.factureInterneEnteteVentes.getFitSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.factureInterneEnteteVentesDao.selectLastNum(var1);
               this.factureInterneEnteteVentes.setFitNum("" + var17);
            }

            this.factureInterneEnteteVentes.setFitEtat(0);
            this.factureInterneEnteteVentes.setFitEtatVal(0);
            this.factureInterneEnteteVentes.setFitDateValide((Date)null);
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.insert(this.factureInterneEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.factureInterneEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.factureInterneEnteteVentes.getFitId(), this.factureInterneEnteteVentes.getFitNum(), this.factureInterneEnteteVentes.getFitNomTiers(), this.factureInterneEnteteVentes.getFitDate(), this.factureInterneEnteteVentes.getFitDevise(), this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc(), this.factureInterneEnteteVentes.getFitModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.factureInterneEnteteVentes.getVar_format_devise(), 0, var1);
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
      if (this.factureInterneEnteteVentes != null && this.factureInterneEnteteVentes.getFitId() != 0L) {
         this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.factureInterneEnteteVentes.setFitSite(this.usersLog.getUsrSite());
      this.factureInterneEnteteVentes.setFitDepartement(this.usersLog.getUsrDepartement());
      this.factureInterneEnteteVentes.setFitService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.factureInterneEnteteVentes.setFitIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.factureInterneEnteteVentes.getFitNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.factureInterneEnteteVentes.setFitTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.factureInterneEnteteVentes.setFitRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.factureInterneEnteteVentes.setFitSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.factureInterneEnteteVentes.setFitPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.factureInterneEnteteVentes.setFitTiersRegroupe(this.tiers.getTiesigle());
            this.factureInterneEnteteVentes.setFitRegion(this.tiers.getTieregion());
            this.factureInterneEnteteVentes.setFitSecteur(this.tiers.getTiesecteur());
            this.factureInterneEnteteVentes.setFitPdv(this.tiers.getTiepdv());
         }
      } else {
         this.factureInterneEnteteVentes.setFitTiersRegroupe(this.tiers.getTiesigle());
         this.factureInterneEnteteVentes.setFitRegion(this.tiers.getTieregion());
         this.factureInterneEnteteVentes.setFitSecteur(this.tiers.getTiesecteur());
         this.factureInterneEnteteVentes.setFitPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.factureInterneEnteteVentes.setFitActivite("");
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

               this.factureInterneEnteteVentes.setFitActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new FactureInterneLigneVentes();
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

                  FactureInterneLigneVentes var13 = (FactureInterneLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getFitligCode() != null && !var13.getFitligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getFitligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getFitligPt());
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
                              var7.setPrix(var13.getFitligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getFitligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.factureInterneEnteteVentes.setFitActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.factureInterneEnteteVentes.setFitAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.factureInterneEnteteVentes.getFitAnal4() != null && this.factureInterneEnteteVentes.getFitAnal4().length() <= 2) {
         this.factureInterneEnteteVentes.setFitAnal4("");
      }

      if (!this.var_anal_parc) {
         this.factureInterneEnteteVentes.setFitAnal2("");
      } else if (this.factureInterneEnteteVentes.getFitAnal2() != null && this.factureInterneEnteteVentes.getFitAnal2().length() <= 2) {
         this.factureInterneEnteteVentes.setFitAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation() {
      if (this.habilitation != null) {
         this.factureInterneEnteteVentes.setFitEtatVal(1);
         this.factureInterneEnteteVentes.setFitEtat(0);
         this.factureInterneEnteteVentes.setFitDateValide((Date)null);
         return true;
      } else {
         this.factureInterneEnteteVentes.setFitEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.factureInterneEnteteVentes.setFitEtat(1);
               this.factureInterneEnteteVentes.setFitDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.factureInterneEnteteVentes.setFitEtat(0);
               this.factureInterneEnteteVentes.setFitDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.factureInterneEnteteVentes != null) {
         this.factureInterneEnteteVentes.setFitDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
         if (this.factureInterneEnteteVentes.getFitDateAnnule() == null) {
            this.factureInterneEnteteVentes.setFitDateAnnule(new Date());
         }

         this.factureInterneEnteteVentes.setFitEtat(3);
         this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation note débit vente N° " + this.factureInterneEnteteVentes.getFitNum() + " le " + this.factureInterneEnteteVentes.getFitDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.factureInterneEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.factureInterneEnteteVentes.getFitExoTva() == 0) {
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

      this.factureInterneLigneVentes.setFitligTaxe(var6);
      this.factureInterneLigneVentes.setFitligTauxTaxe(var5);
      double var35 = this.factureInterneLigneVentes.getFitligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.factureInterneEnteteVentes.getFitDevise());
      }

      var10 = this.factureInterneLigneVentes.getFitligQte();
      if (this.factureInterneLigneVentes.getFitligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.factureInterneLigneVentes.setFitligQteUtil(this.factureInterneLigneVentes.getFitligQte());
            var10 = this.factureInterneLigneVentes.getFitligQte() * this.factureInterneLigneVentes.getFitligLong();
         } else {
            this.factureInterneLigneVentes.setFitligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.factureInterneLigneVentes.getFitligCondition(), this.factureInterneLigneVentes.getFitligQte(), this.factureInterneLigneVentes.getFitligLong(), this.factureInterneLigneVentes.getFitligLarg(), this.factureInterneLigneVentes.getFitligHaut(), this.factureInterneLigneVentes.getFitligDiam(), this.factureInterneLigneVentes.getFitligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.factureInterneLigneVentes.setFitligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.factureInterneLigneVentes.getFitligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.factureInterneLigneVentes.getFitligRabais() * (double)this.factureInterneLigneVentes.getFitligQte();
      }

      if (this.factureInterneLigneVentes.getFitligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.factureInterneLigneVentes.getFitligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.factureInterneLigneVentes.getFitligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.factureInterneLigneVentes.getFitligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.factureInterneLigneVentes.getFitligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.factureInterneLigneVentes.getFitligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.factureInterneLigneVentes.getFitligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.factureInterneLigneVentes.getFitligQte(), 2);
      }

      this.factureInterneLigneVentes.setFitligPuRem(var25);
      this.factureInterneLigneVentes.setFitligPt(var17);
      this.factureInterneLigneVentes.setFitligTva(var21);
      this.factureInterneLigneVentes.setFitligTc(0.0D);
      this.factureInterneLigneVentes.setFitligTtc(var23);
      double var27 = 0.0D;
      if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.factureInterneLigneVentes.getFitligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.factureInterneLigneVentes.getFitligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.factureInterneLigneVentes.getFitligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.factureInterneLigneVentes.getFitligQte(), 2);
      }

      this.factureInterneLigneVentes.setFitligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.factureInterneLigneVentes.getFitligTauxTaxe() / 100.0D;
      this.factureInterneLigneVentes.setFitligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.factureInterneEnteteVentes.setFitTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.factureInterneLigneVentes.setFitligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
               if (this.factureInterneLigneVentes.getFitligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.factureInterneLigneVentes.getFitligTauxTaxe() / 100.0D;
                  this.factureInterneLigneVentes.setFitligTc(var33);
               }
            }
         } else {
            if (this.factureInterneLigneVentes.getFitligTva() != 0.0D) {
               var31 = var17 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.factureInterneLigneVentes.setFitligTc(var33);
         }
      } else {
         this.factureInterneLigneVentes.setFitligTc(0.0D);
         this.factureInterneEnteteVentes.setFitTauxTc(0.0F);
      }

      this.factureInterneLigneVentes.setFitligPt(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligPt(), this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligTva(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligTva(), this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligTtc(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligTtc(), this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligTc(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligTc(), this.factureInterneEnteteVentes.getFitDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.factureInterneEnteteVentes.getFitExoTva() == 0) {
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

      this.factureInterneLigneVentes.setFitligTaxe(var6);
      this.factureInterneLigneVentes.setFitligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.factureInterneEnteteVentes.getFitTauxTc() != 0.0F && this.factureInterneLigneVentes.getFitligTva() != 0.0D) {
         var10 = this.factureInterneLigneVentes.getFitligTtc();
         var12 = var10 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.factureInterneLigneVentes.getFitligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.factureInterneLigneVentes.getFitligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.factureInterneLigneVentes.setFitligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.factureInterneLigneVentes.getFitligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.factureInterneLigneVentes.getFitligRabais() * (double)this.factureInterneLigneVentes.getFitligQte();
      }

      double var14 = 0.0D;
      if (this.factureInterneLigneVentes.getFitligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.factureInterneLigneVentes.getFitligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.factureInterneLigneVentes.getFitligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.factureInterneLigneVentes.getFitligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.factureInterneLigneVentes.getFitligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.factureInterneLigneVentes.setFitligQteUtil(this.factureInterneLigneVentes.getFitligQte());
         } else {
            this.factureInterneLigneVentes.setFitligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.factureInterneLigneVentes.getFitligCondition(), this.factureInterneLigneVentes.getFitligQte(), this.factureInterneLigneVentes.getFitligLong(), this.factureInterneLigneVentes.getFitligLarg(), this.factureInterneLigneVentes.getFitligHaut(), this.factureInterneLigneVentes.getFitligDiam(), this.factureInterneLigneVentes.getFitligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.factureInterneLigneVentes.setFitligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.factureInterneLigneVentes.getFitligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.factureInterneEnteteVentes.getFitDevise()));
      double var26 = var20 * (double)this.factureInterneLigneVentes.getFitligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.factureInterneEnteteVentes.getFitDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligPuRem(var18);
      this.factureInterneLigneVentes.setFitligPuRemTtc(var20);
      this.factureInterneLigneVentes.setFitligPt(var24);
      this.factureInterneLigneVentes.setFitligTva(var32);
      this.factureInterneLigneVentes.setFitligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.factureInterneEnteteVentes.setFitTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.factureInterneLigneVentes.setFitligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
               if (this.factureInterneLigneVentes.getFitligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.factureInterneLigneVentes.getFitligTauxTaxe() / 100.0D;
                  this.factureInterneLigneVentes.setFitligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.factureInterneEnteteVentes.getFitTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.factureInterneLigneVentes.setFitligTc(var36);
         }
      } else {
         this.factureInterneLigneVentes.setFitligTc(0.0D);
         this.factureInterneEnteteVentes.setFitTauxTc(0.0F);
      }

      this.factureInterneLigneVentes.setFitligPt(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligPt(), this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligTva(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligTva(), this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligTtc(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligTtc(), this.factureInterneEnteteVentes.getFitDevise()));
      this.factureInterneLigneVentes.setFitligTc(this.utilNombre.myRoundDevise(this.factureInterneLigneVentes.getFitligTc(), this.factureInterneEnteteVentes.getFitDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.factureInterneLigneVentes != null && this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.factureInterneLigneVentes.getFitligPuRemTtc() != 0.0D) {
               if (this.factureInterneLigneVentes.getFitligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.factureInterneLigneVentes.getFitligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.factureInterneLigneVentes.getFitligPuRem() != 0.0D) {
            if (this.factureInterneLigneVentes.getFitligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.factureInterneLigneVentes.getFitligPu() < this.prixPlancher) {
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
         new FactureInterneLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            FactureInterneLigneVentes var13 = (FactureInterneLigneVentes)this.lesLignesList.get(var14);
            if (var13.getFitligGroupe() == null || var13.getFitligGroupe().isEmpty()) {
               var3 += var13.getFitligPt();
               var5 += var13.getFitligTva();
               var7 += var13.getFitligTtc();
               var9 += var13.getFitligTc();
               if (var13.getFitligRabais() != 0.0D || var13.getFitligTauxRemise() != 0.0F) {
                  var11 += var13.getFitligPu() * (double)var13.getFitligQte() - var13.getFitligPt();
               }

               var1 = var1 + var13.getFitligPt() - var13.getFitligPump() * (double)var13.getFitligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.factureInterneEnteteVentes.setFitTotHt(var3);
      this.factureInterneEnteteVentes.setFitTotTva(var5);
      this.factureInterneEnteteVentes.setFitTotTtc(var7);
      this.factureInterneEnteteVentes.setFitTotRemise(var11);
      this.factureInterneEnteteVentes.setFitTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         if (this.factureInterneLigneVentes.getFitligCode() != null && this.factureInterneLigneVentes.getFitligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.factureInterneLigneVentes.getFitligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.factureInterneLigneVentes.setFitligCode(this.produits.getProCode());
               this.factureInterneLigneVentes.setFitligFamille(this.produits.getProAchCode());
               this.factureInterneLigneVentes.setFitligStock(this.produits.getProStock());
               this.factureInterneLigneVentes.setFitligLong(this.produits.getProLongueur());
               this.factureInterneLigneVentes.setFitligLarg(this.produits.getProLargeur());
               this.factureInterneLigneVentes.setFitligHaut(this.produits.getProEpaisseur());
               this.factureInterneLigneVentes.setFitligDiam(this.produits.getProDiamExt());
               this.factureInterneLigneVentes.setFitligPoidsBrut(this.produits.getProPoidsBrut());
               this.factureInterneLigneVentes.setFitligPoidsNet(this.produits.getProPoidsNet());
               this.factureInterneLigneVentes.setFitligVolume(this.produits.getProVolume());
               this.factureInterneLigneVentes.setFitligNb(this.produits.getProNbUnite());
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
               if (this.factureInterneLigneVentes.getFitligTaxe() != null && !this.factureInterneLigneVentes.getFitligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTaxe() + ":" + this.factureInterneLigneVentes.getFitligTauxTaxe()));
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
         this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.datamodelLigne.getRowData();
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
      this.factureInterneLigneVentes = new FactureInterneLigneVentes();
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
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.factureInterneLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.factureInterneLigneVentes);
            this.lesLignesList.add(this.numLigne, this.factureInterneLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var3);
               this.factureInterneLigneVentes.setFitligOrdre(var3);
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var1);
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
      if (this.factureInterneLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.factureInterneLigneVentes);
            this.lesLignesList.add(this.numLigne, this.factureInterneLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var3);
               this.factureInterneLigneVentes.setFitligOrdre(var3);
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var1);
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
            if (this.factureInterneLigneVentes.getFitligId() == ((FactureInterneLigneVentes)this.lesLignesList.get(var2)).getFitligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty() || this.factureInterneLigneVentes.getFitligLibelle() != null && !this.factureInterneLigneVentes.getFitligLibelle().isEmpty() || this.factureInterneLigneVentes.getFitligComplement() != null && !this.factureInterneLigneVentes.getFitligComplement().isEmpty()) {
         if (this.factureInterneEnteteVentes.getFitId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureInterneLigneVentes.getFitligQteUtil() == 0.0F) {
               this.factureInterneLigneVentes.setFitligQteUtil(this.factureInterneLigneVentes.getFitligQte());
            }

            this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.factureInterneLigneVentes.setFitligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.factureInterneLigneVentes.setFitligDepot(var3[0]);
               }
            } else {
               this.factureInterneLigneVentes.setFitligDepot("");
            }

            if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.factureInterneLigneVentes.getFitligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.factureInterneLigneVentes.setFitligDescription(var5);
               } else {
                  this.factureInterneLigneVentes.setFitligDescription("");
               }

               if (this.factureInterneLigneVentes.getFitligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.factureInterneLigneVentes.setFitligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.factureInterneLigneVentes.setFitligDescription("");
            }

            if (this.factureInterneLigneVentes.getFitligId() == 0L) {
               this.factureInterneLigneVentes.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
               this.factureInterneLigneVentes.setFitligDevise(this.factureInterneEnteteVentes.getFitDevise());
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.insertLigne(this.factureInterneLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.factureInterneLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new FactureInterneLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  FactureInterneLigneVentes var16 = (FactureInterneLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getFitligGroupe() != null && !var16.getFitligGroupe().isEmpty() && var16.getFitligGroupe().equals(this.memoProduits.getProCode())) {
                     this.factureInterneLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.factureInterneLigneVentes.getFitligQte();
               new FactureInterneLigneVentes();

               FactureInterneLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (FactureInterneLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getFitligGroupe() != null && !var19.getFitligGroupe().isEmpty() && var19.getFitligGroupe().equals(var18)) {
                     this.factureInterneLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new FactureInterneLigneVentes();
                     var19.setFitligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setFitligCondition("");
                     var19.setFitligComplement("");
                     var19.setFitligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setFitligDescription("");
                     var19.setFitligDevise(this.factureInterneEnteteVentes.getFitDevise());
                     var19.setFitligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setFitligEchelle(0);
                     var19.setFitligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setFitligGroupe(var18);
                     var19.setFitligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setFitligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setFitligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setFitligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setFitligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setFitligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setFitligOrdre(var8);
                     var19.setFitligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setFitligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setFitligPt(0.0D);
                     var19.setFitligPu(0.0D);
                     var19.setFitligPuRem(0.0D);
                     var19.setFitligPuRemTtc(0.0D);
                     var19.setFitligPuTtc(0.0D);
                     var19.setFitligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setFitligQte(var9);
                     var19.setFitligQteUtil(var19.getFitligQte());
                     var19.setFitligRabais(0.0D);
                     var19.setFitligReference(var18);
                     var19.setFitligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setFitligTauxRemise(0.0F);
                     var19.setFitligTauxTaxe(0.0F);
                     var19.setFitligTaxe("");
                     var19.setFitligTc(0.0D);
                     var19.setFitligTtc(0.0D);
                     var19.setFitligTva(0.0D);
                     var19.setFitligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setFitligVolume(0.0F);
                     var19.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
                     var19 = this.factureInterneLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
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
      if (this.factureInterneLigneVentes.getFitligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.factureInterneLigneVentes.getFitligCode();
            int var4 = this.factureInterneLigneVentes.getFitligModeGroupe();
            String var5 = this.factureInterneLigneVentes.getFitligGroupe();
            this.factureInterneLigneVentesDao.deleteOneLigne(this.factureInterneLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new FactureInterneLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  FactureInterneLigneVentes var6 = (FactureInterneLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getFitligGroupe() != null && !var6.getFitligGroupe().isEmpty() && var6.getFitligGroupe().equals(var3)) {
                     this.factureInterneLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " de la Facture interne N° " + this.factureInterneEnteteVentes.getFitNum() + " du " + this.factureInterneEnteteVentes.getFitDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.factureInterneEnteteVentes.getFitNomTiers(), this.nature);
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
                     this.factureInterneEnteteVentes.setFitSerie(this.tiers.getTieserie());
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
            this.factureInterneEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.factureInterneEnteteVentes.setFitCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.factureInterneEnteteVentes.setFitCivilTiers(this.factureInterneEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.factureInterneEnteteVentes.setFitNomTiers(this.nomTier);
            this.factureInterneEnteteVentes.setFitTypeReg(this.tiers.getTietypereg());
            this.factureInterneEnteteVentes.setFitModeReg(this.tiers.getTiemodereg());
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
               this.factureInterneEnteteVentes.setFitNbJourReg(this.tiers.getTienbecheance());
               this.factureInterneEnteteVentes.setFitArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.factureInterneEnteteVentes.setFitTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.factureInterneEnteteVentes.setFitModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.factureInterneEnteteVentes.setFitNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.factureInterneEnteteVentes.setFitArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.factureInterneEnteteVentes.setFitJournalReg(this.tiers.getTiejournalreg());
            this.factureInterneEnteteVentes.setFitCat(this.tiers.getTienomfamille());
            this.factureInterneEnteteVentes.setFitExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.factureInterneEnteteVentes.setFitExoDouane(1);
            }

            var9 = this.tiers.getTieexotva();
            if (var9 >= 2) {
               var9 = 0;
            }

            this.factureInterneEnteteVentes.setFitExoTva(var9);
            if (this.var_tc_calcul) {
               this.factureInterneEnteteVentes.setFitTauxTc(this.var_tc_taux);
            } else {
               this.factureInterneEnteteVentes.setFitTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.factureInterneEnteteVentes.setFitExoTva(1);
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
               this.factureInterneEnteteVentes.setFitDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.factureInterneEnteteVentes.setFitDiversTiers(0);
               this.factureInterneEnteteVentes.setFitDiversNom("");
               this.factureInterneEnteteVentes.setFitDiversAdresse("");
               this.factureInterneEnteteVentes.setFitDiversVille("");
               this.factureInterneEnteteVentes.setFitDiversTel("");
               this.factureInterneEnteteVentes.setFitDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.factureInterneEnteteVentes.setFitDevise(this.tiers.getTiedevise());
            } else {
               this.factureInterneEnteteVentes.setFitDevise(this.structureLog.getStrdevise());
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
      this.factureInterneEnteteVentes.setTiers(this.tiers);
      this.factureInterneEnteteVentes.setFitNomTiers("");
      this.factureInterneEnteteVentes.setFitCivilTiers("");
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
      if (!this.factureInterneEnteteVentes.getFitNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.factureInterneEnteteVentes.getFitCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.factureInterneEnteteVentes.setFitExoTva(0);
      } else {
         this.factureInterneEnteteVentes.setFitExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.factureInterneEnteteVentes.setFitExoDouane(0);
      } else {
         this.factureInterneEnteteVentes.setFitExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.factureInterneEnteteVentes.setFitTauxTc(this.var_tc_taux);
      } else {
         this.factureInterneEnteteVentes.setFitTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureInterneLigneVentes = new FactureInterneLigneVentes();
               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var3);
               if (this.factureInterneEnteteVentes.getFitExoTva() == 1) {
                  this.factureInterneLigneVentes.setFitligTaxe("");
                  this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
                  this.factureInterneLigneVentes.setFitligTva(0.0D);
               } else if (this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.factureInterneLigneVentes.getFitligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.factureInterneLigneVentes.setFitligTaxe("");
                        this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.factureInterneLigneVentes.setFitligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.factureInterneLigneVentes.setFitligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.factureInterneLigneVentes.getFitligTaxe(), var1);
                        if (var5 != null) {
                           this.factureInterneLigneVentes.setFitligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.factureInterneLigneVentes.setFitligTaxe(this.optionsVentes.getTvaDefaut());
                        this.factureInterneLigneVentes.setFitligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.factureInterneLigneVentes.setFitligTaxe("");
                        this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
                     }
                  } else {
                     this.factureInterneLigneVentes.setFitligTaxe("");
                     this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
                  }

                  if ((this.factureInterneLigneVentes.getFitligTaxe() == null || this.factureInterneLigneVentes.getFitligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.factureInterneLigneVentes.setFitligTaxe(var5.getTaxvteCode());
                        this.factureInterneLigneVentes.setFitligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), var1);
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var1);
            }
         }

         if (this.factureInterneEnteteVentes.getFitExoTva() == 0) {
            this.factureInterneEnteteVentes.setFitMotifExo("");
            this.factureInterneEnteteVentes.setFitNumVisa("");
            this.factureInterneEnteteVentes.setFitDateVisa((Date)null);
            this.factureInterneEnteteVentes.setFitRangeVisa("");
         }

         if (this.factureInterneEnteteVentes.getFitId() != 0L) {
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.factureInterneLigneVentes = new FactureInterneLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var3);
               this.factureInterneLigneVentes.setFitligTauxRemise(this.factureInterneEnteteVentes.getFitTauxRemise());
               this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), var1);
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var1);
            }
         }

         if (this.factureInterneEnteteVentes.getFitId() != 0L) {
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.factureInterneEnteteVentes.getFitNomContact(), this.nature);
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
         this.factureInterneEnteteVentes.setFitNomContact(this.plansAnalytiques.getAnaNomFr());
         this.factureInterneEnteteVentes.setFitCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.factureInterneEnteteVentes.setFitAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.factureInterneEnteteVentes.setFitNomContact("");
      this.factureInterneEnteteVentes.setFitCivilContact("");
      this.factureInterneEnteteVentes.setFitAnal4("");
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
      if (this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty() && !this.factureInterneLigneVentes.getFitligCode().equals("-") && !this.factureInterneLigneVentes.getFitligCode().equals("=")) {
         this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.factureInterneLigneVentes.getFitligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         this.factureInterneLigneVentes.setFitligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.factureInterneLigneVentes.setFitligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.factureInterneLigneVentes.setFitligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.factureInterneLigneVentes.setFitligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.factureInterneLigneVentes.setFitligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.factureInterneLigneVentes.setFitligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.factureInterneLigneVentes.setFitligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.factureInterneLigneVentes.setFitligFamille(this.produits.getProVteCode());
         this.factureInterneLigneVentes.setFitligStock(this.produits.getProStock());
         this.factureInterneLigneVentes.setFitligLong(this.produits.getProLongueur());
         this.factureInterneLigneVentes.setFitligLarg(this.produits.getProLargeur());
         this.factureInterneLigneVentes.setFitligHaut(this.produits.getProEpaisseur());
         this.factureInterneLigneVentes.setFitligDiam(this.produits.getProDiamExt());
         this.factureInterneLigneVentes.setFitligPoidsBrut(this.produits.getProPoidsBrut());
         this.factureInterneLigneVentes.setFitligPoidsNet(this.produits.getProPoidsNet());
         this.factureInterneLigneVentes.setFitligVolume(this.produits.getProVolume());
         this.factureInterneLigneVentes.setFitligNb(this.produits.getProNbUnite());
         this.factureInterneLigneVentes.setFitligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.factureInterneLigneVentes.setFitligModeGroupe(this.produits.getProMode());
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
                  this.factureInterneLigneVentes.setFitligTaxe(this.produits.getProVteTva());
                  this.factureInterneLigneVentes.setFitligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.factureInterneLigneVentes.setFitligTaxe("");
                  this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.factureInterneLigneVentes.setFitligTaxe(var8.getFamvteTaxe());
                  this.factureInterneLigneVentes.setFitligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.factureInterneLigneVentes.setFitligTaxe("");
               this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.factureInterneEnteteVentes.getFitExoTva() == 0 && (this.factureInterneLigneVentes.getFitligTaxe() == null || this.factureInterneLigneVentes.getFitligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.factureInterneLigneVentes.setFitligTaxe(var9.getTaxvteCode());
                  this.factureInterneLigneVentes.setFitligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.factureInterneLigneVentes.setFitligTaxe("");
            this.factureInterneLigneVentes.setFitligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.factureInterneLigneVentes.getFitligTauxTaxe() / 100.0D;
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
               this.factureInterneLigneVentes.setFitligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.factureInterneLigneVentes.setFitligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.factureInterneLigneVentes.setFitligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.factureInterneLigneVentes.setFitligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.factureInterneLigneVentes.setFitligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.factureInterneLigneVentes.getFitligPump() != 0.0D) {
            this.factureInterneLigneVentes.setFitligPu(this.factureInterneLigneVentes.getFitligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), var1);
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
      if ((this.factureInterneLigneVentes.getFitligCode() == null || this.factureInterneLigneVentes.getFitligCode().isEmpty() || this.factureInterneLigneVentes.getFitligCode().length() < 2) && this.factureInterneEnteteVentes.getFitExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
         if (this.mesTaxesVentesProduits.isEmpty()) {
            this.mesTaxesVentesProduits.clear();
            if (this.mesTaxesVentesItems.size() != 0) {
               for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                  this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
               }
            }

            if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               this.factureInterneLigneVentes.setFitligTaxe(this.optionsVentes.getTvaDefaut());
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.factureInterneLigneVentes.setFitligCode("");
      this.factureInterneLigneVentes.setFitligLibelle("");
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
            var2 = this.factureInterneLigneVentes.getFitligPuTtc();
         } else {
            var2 = this.factureInterneLigneVentes.getFitligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.factureInterneLigneVentes.setFitligPuTtc(this.prixUnitaires);
            this.factureInterneLigneVentes.setFitligPuRemTtc(this.prixUnitaires);
         } else {
            this.factureInterneLigneVentes.setFitligPu(this.prixUnitaires);
            this.factureInterneLigneVentes.setFitligPuRem(this.prixUnitaires);
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

               if (var4 != 0.0D) {
                  this.prixUnitaires = var4;
               }

               if (this.prixUnitaires == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        this.prixUnitaires = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
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
                     this.factureInterneLigneVentes.setFitligTauxRemise(var6.getBarRemise());
                     this.factureInterneLigneVentes.setFitligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.factureInterneEnteteVentes.getFitDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.factureInterneLigneVentes.setFitligPuTtc(this.prixUnitaires);
                        this.factureInterneLigneVentes.setFitligPuRemTtc(var11);
                     } else {
                        this.factureInterneLigneVentes.setFitligPu(this.prixUnitaires);
                        this.factureInterneLigneVentes.setFitligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.factureInterneLigneVentes.setFitligTauxRemise(var6.getBarRemise());
                     this.factureInterneLigneVentes.setFitligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.factureInterneLigneVentes.getFitligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.factureInterneLigneVentes.setFitligPuTtc(this.prixUnitaires);
                        this.factureInterneLigneVentes.setFitligPuRemTtc(var11);
                     } else {
                        this.factureInterneLigneVentes.setFitligPu(this.prixUnitaires);
                        this.factureInterneLigneVentes.setFitligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.factureInterneLigneVentes.setFitligTauxRemise(var6.getBarRemise());
                     this.factureInterneLigneVentes.setFitligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.factureInterneLigneVentes.setFitligPuTtc(this.prixUnitaires);
                        this.factureInterneLigneVentes.setFitligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.factureInterneLigneVentes.setFitligPu(this.prixUnitaires);
                        this.factureInterneLigneVentes.setFitligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureInterneLigneVentes.setFitligPuTtc(this.prixUnitaires);
                     this.factureInterneLigneVentes.setFitligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.factureInterneLigneVentes.setFitligPu(this.prixUnitaires);
                     this.factureInterneLigneVentes.setFitligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((FactureInterneLigneVentes)this.lesLignesList.get(var9)).getFitligCode() == null || ((FactureInterneLigneVentes)this.lesLignesList.get(var9)).getFitligCode().isEmpty() || !((FactureInterneLigneVentes)this.lesLignesList.get(var9)).getFitligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((FactureInterneLigneVentes)this.lesLignesList.get(var9)).getFitligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((FactureInterneLigneVentes)this.lesLignesList.get(var8)).getFitligFamille() != null && !((FactureInterneLigneVentes)this.lesLignesList.get(var8)).getFitligFamille().isEmpty() && ((FactureInterneLigneVentes)this.lesLignesList.get(var8)).getFitligFamille().equals(var7)) {
                  var5 += ((FactureInterneLigneVentes)this.lesLignesList.get(var8)).getFitligPt();
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
         double var2 = this.factureInterneLigneVentes.getFitligPu();
         double var4 = this.factureInterneLigneVentes.getFitligPuTtc();
         if (this.factureInterneLigneVentes.getFitligPu() >= 0.0D && this.factureInterneLigneVentes.getFitligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.factureInterneEnteteVentes.getFitCat(), (String)null, var1);
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
                     if (this.factureInterneLigneVentes.getFitligQte() >= var7.getQteDebut() && this.factureInterneLigneVentes.getFitligQte() <= var7.getQteFin()) {
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
                        if (this.factureInterneLigneVentes.getFitligQte() >= var7.getQteDebut() && this.factureInterneLigneVentes.getFitligQte() <= var7.getQteFin()) {
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
            var2 = Math.abs(this.factureInterneLigneVentes.getFitligPu());
            var4 = Math.abs(this.factureInterneLigneVentes.getFitligPuTtc());
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
      this.factureInterneLigneVentes.setFitligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.factureInterneLigneVentes.getFitligEchelle());
            float var5 = 1.0F;
            if (this.factureInterneLigneVentes.getFitligCondition().contains("/")) {
               String[] var6 = this.factureInterneLigneVentes.getFitligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && !this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.factureInterneLigneVentes.getFitligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.factureInterneLigneVentes.setFitligPump(var9);
      } else {
         this.factureInterneLigneVentes.setFitligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.factureInterneLigneVentes.getFitligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.factureInterneLigneVentes.setFitligEchelle(this.unite.getUniEchelle());
               } else {
                  this.factureInterneLigneVentes.setFitligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.factureInterneLigneVentes.setFitligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.factureInterneLigneVentes.setFitligEchelle(Integer.parseInt(var2));
         } else {
            this.factureInterneLigneVentes.setFitligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.factureInterneLigneVentes.getFitligLong(), this.factureInterneLigneVentes.getFitligLarg(), this.factureInterneLigneVentes.getFitligHaut(), this.factureInterneLigneVentes.getFitligDiam(), this.factureInterneLigneVentes.getFitligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.factureInterneLigneVentes.getFitligLong(), this.factureInterneLigneVentes.getFitligLarg(), this.factureInterneLigneVentes.getFitligHaut(), this.factureInterneLigneVentes.getFitligDiam(), this.factureInterneLigneVentes.getFitligNb(), this.baseLog, var1);
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
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementVentes(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void verifBonEncaissement() {
      if (Math.abs(this.montantElmTotBonEnc) <= Math.abs(this.factureInterneEnteteVentes.getFitTotTtc() - this.var_tot_bon_encaissement)) {
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

      this.var_serie_trf = this.factureInterneEnteteVentes.getFitSerie();
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
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
      this.var_imput_serie = this.factureInterneEnteteVentes.getFitSerie();
      this.var_imput_cat = this.factureInterneEnteteVentes.getFitCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new FactureInterneEnteteVentes();
         FactureInterneEnteteVentes var1 = this.factureInterneEnteteVentesDao.pourParapheur(this.var_imput_num, (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.factureInterneEnteteVentes.getFitNum();
               this.factureInterneEnteteVentes.setFitNum(this.var_imput_num);
               this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
               if (this.factureInterneEnteteVentes.getFitTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.factureInterneEnteteVentes.getFitNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.factureInterneEnteteVentes.getFitNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Facture interne N° " + var3 + " en Facture interne N° " + this.factureInterneEnteteVentes.getFitNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.factureInterneEnteteVentes.getFitNum();
            this.factureInterneEnteteVentes.setFitSerie(this.var_imput_serie);
            this.factureInterneEnteteVentes.setFitCat(this.var_imput_cat);
            this.factureInterneEnteteVentes.setFitNum(this.calculChrono.numCompose(this.factureInterneEnteteVentes.getFitDate(), this.nature, this.factureInterneEnteteVentes.getFitSerie(), var1));
            this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
            if (this.factureInterneEnteteVentes.getFitTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.factureInterneEnteteVentes.getFitNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.factureInterneEnteteVentes.getFitNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Note de débit X N° " + var3 + " en Note de débit " + this.factureInterneEnteteVentes.getFitSerie() + " N° " + this.factureInterneEnteteVentes.getFitNum());
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
            new FactureInterneLigneVentes();
            FactureInterneLigneVentes var3 = (FactureInterneLigneVentes)this.documentDetailTrf.get(var2);
            long var4 = var3.getFitligId();
            float var6 = var3.getFitligQte();
            float var7 = 0.0F;
            if (this.var_type_trf == 26) {
               AvoirLigneVentesDao var8 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var7 = var8.chargerLesReliquatsNoteDebitVtes(var4, var1);
            }

            float var9 = var6 - var7;
            if (var9 < 0.0F) {
               var9 = 0.0F;
            }

            var3.setVar_qteDejaTrf(var7);
            var3.setVar_qteReliquat(var9);
            var3 = (FactureInterneLigneVentes)this.documentDetailTrf.set(var2, var3);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new FactureInterneLigneVentes();
            FactureInterneLigneVentes var2 = (FactureInterneLigneVentes)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (FactureInterneLigneVentes)this.documentDetailTrf.set(var1, var2);
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
            var3 += ((FactureInterneLigneVentes)this.documentDetailTrf.get(var5)).getFitligQte();
            var2 += ((FactureInterneLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((FactureInterneLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         int var7;
         if (var3 == var2) {
            new FactureInterneEnteteVentes();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               FactureInterneEnteteVentes var6 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setFitEtat(5);
                  this.factureInterneEnteteVentesDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            FactureInterneEnteteVentes var12;
            if (this.var_mode_trf.equals("0")) {
               for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
                  new FactureInterneEnteteVentes();
                  var12 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getFitNum().equalsIgnoreCase(((FactureInterneEnteteVentes)var1.get(var9)).getFitNum())) {
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
                  new FactureInterneEnteteVentes();
                  var12 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getTiers().getTieid() == ((FactureInterneEnteteVentes)var1.get(var9)).getTiers().getTieid()) {
                           if (var12.getFitSerie().equalsIgnoreCase(((FactureInterneEnteteVentes)var1.get(var9)).getFitSerie())) {
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
                  this.factureInterneEnteteVentes = (FactureInterneEnteteVentes)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((FactureInterneEnteteVentes)var1.get(var11)).getFitNum().equalsIgnoreCase(((FactureInterneLigneVentes)this.documentDetailTrf.get(var7)).getFactureInterneEnteteVentes().getFitNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((FactureInterneEnteteVentes)var1.get(var11)).getTiers().getTieid() == ((FactureInterneLigneVentes)this.documentDetailTrf.get(var7)).getFactureInterneEnteteVentes().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0) {
                     this.utilParapheur.supprimerParapheur(this.factureInterneEnteteVentes.getFitId(), this.nature, (Session)null);
                     if (this.var_type_trf == 26) {
                        this.trfAvoir();
                     }
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
               this.factureInterneEnteteVentes = (FactureInterneEnteteVentes)this.lesEntetesList.get(var11);
               if (this.factureInterneEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.factureInterneEnteteVentes);
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
         DocumentTraceVentes var3 = new DocumentTraceVentes();
         AvoirEnteteVentes var4 = new AvoirEnteteVentes();
         AvoirEnteteVentesDao var5 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         AvoirLigneVentesDao var6 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var7 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var4.setAvrSerie(this.var_serie_trf);
         } else {
            var4.setAvrSerie(this.factureInterneEnteteVentes.getFitSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setAvrIdCreateur(this.usersLog.getUsrid());
         var4.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setAvrDate(this.utilDate.dateToSQLLight(this.factureInterneEnteteVentes.getFitDate()));
         } else {
            var4.setAvrDate(this.var_date_trf);
         }

         var4.setAvrDate(this.utilDate.dateToSQL(var4.getAvrDate(), this.var_heure, this.var_minute, this.var_seconde));
         var4.setAvrDateCreat(new Date());
         var4.setAvrDateModif((Date)null);
         var4.setAvrIdModif(0L);
         var4.setAvrNomModif("");
         var4.setAvrNum("");
         boolean var8 = false;
         int var35;
         if (this.optionsVentes.getNbrJrRelanceAVOIR() != null && !this.optionsVentes.getNbrJrRelanceAVOIR().isEmpty()) {
            var35 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceAVOIR());
         } else {
            var35 = 0;
         }

         boolean var9 = false;
         int var36;
         if (this.optionsVentes.getNbrJrValidAVOIR() != null && !this.optionsVentes.getNbrJrValidAVOIR().isEmpty()) {
            var36 = Integer.parseInt(this.optionsVentes.getNbrJrValidAVOIR());
         } else {
            var36 = 0;
         }

         var4.setAvrDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var35));
         var4.setAvrDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var36));
         var4.setAvrService(this.factureInterneEnteteVentes.getFitService());
         if (!var4.getAvrSerie().equalsIgnoreCase("X") && !var4.getAvrSerie().isEmpty()) {
            var4.setAvrNum(this.calculChrono.numCompose(this.factureInterneEnteteVentes.getFitDate(), this.var_type_trf, var4.getAvrSerie(), var1));
         } else {
            long var10 = var5.selectLastNum(var1);
            var4.setAvrNum("" + var10);
         }

         this.verifieExistenceHabilitationAvoir(var4, var1);
         var4.setAvrSource(this.factureInterneEnteteVentes.getFitSource());
         var4.setAvrNomResponsable(this.factureInterneEnteteVentes.getFitNomResponsable());
         var4.setAvrIdResponsable(this.factureInterneEnteteVentes.getFitIdResponsable());
         var4.setAvrNomCommercial(this.factureInterneEnteteVentes.getFitNomCommercial());
         var4.setAvrIdCommercial(this.factureInterneEnteteVentes.getFitIdCommercial());
         var4.setAvrNomTiers(this.factureInterneEnteteVentes.getFitNomTiers());
         var4.setAvrCivilTiers(this.factureInterneEnteteVentes.getFitCivilTiers());
         var4.setAvrTiersRegroupe(this.factureInterneEnteteVentes.getFitTiersRegroupe());
         var4.setAvrIdContact(this.factureInterneEnteteVentes.getFitIdContact());
         var4.setAvrNomContact(this.factureInterneEnteteVentes.getFitNomContact());
         var4.setAvrCivilContact(this.factureInterneEnteteVentes.getFitCivilContact());
         var4.setAvrDiversAdresse(this.factureInterneEnteteVentes.getFitDiversAdresse());
         var4.setAvrDiversMail(this.factureInterneEnteteVentes.getFitDiversMail());
         var4.setAvrDiversNom(this.factureInterneEnteteVentes.getFitDiversNom());
         var4.setAvrDiversTel(this.factureInterneEnteteVentes.getFitDiversTel());
         var4.setAvrDiversTiers(this.factureInterneEnteteVentes.getFitDiversTiers());
         var4.setAvrDiversVille(this.factureInterneEnteteVentes.getFitDiversVille());
         var4.setAvrExoTva(this.factureInterneEnteteVentes.getFitExoTva());
         var4.setAvrExoDouane(this.factureInterneEnteteVentes.getFitExoDouane());
         var4.setAvrJournalReg(this.factureInterneEnteteVentes.getFitJournalReg());
         var4.setAvrCat(this.factureInterneEnteteVentes.getFitCat());
         var4.setAvrDevise(this.factureInterneEnteteVentes.getFitDevise());
         var4.setAvrObject(this.factureInterneEnteteVentes.getFitObject());
         var4.setAvrObservation(this.factureInterneEnteteVentes.getFitObservation());
         var4.setAvrTauxRemise(this.factureInterneEnteteVentes.getFitTauxRemise());
         var4.setAvrTotHt(0.0D);
         var4.setAvrTotRemise(0.0D);
         var4.setAvrTotRabais(0.0D);
         var4.setAvrTotTva(0.0D);
         var4.setAvrTotTc(0.0D);
         var4.setAvrTotTtc(0.0D);
         var4.setAvrTotReglement(0.0D);
         var4.setAvrSolde(0);
         var4.setAvrBanque(this.factureInterneEnteteVentes.getFitBanque());
         var4.setAvrTypeReg(this.factureInterneEnteteVentes.getFitTypeReg());
         var4.setAvrModeReg(this.factureInterneEnteteVentes.getFitModeReg());
         var4.setAvrNbJourReg(this.factureInterneEnteteVentes.getFitNbJourReg());
         var4.setAvrArrondiReg(this.factureInterneEnteteVentes.getFitArrondiReg());
         var4.setAvrConditionReg(this.factureInterneEnteteVentes.getFitConditionReg());
         var4.setAvrDateEcheReg(this.factureInterneEnteteVentes.getFitDateEcheReg());
         var4.setAvrContener(this.factureInterneEnteteVentes.getFitContener());
         var4.setAvrActivite(this.factureInterneEnteteVentes.getFitActivite());
         var4.setAvrSite(this.factureInterneEnteteVentes.getFitSite());
         var4.setAvrDepartement(this.factureInterneEnteteVentes.getFitDepartement());
         var4.setAvrRegion(this.factureInterneEnteteVentes.getFitRegion());
         var4.setAvrSecteur(this.factureInterneEnteteVentes.getFitSecteur());
         var4.setAvrPdv(this.factureInterneEnteteVentes.getFitPdv());
         var4.setAvrAnal2(this.factureInterneEnteteVentes.getFitAnal2());
         var4.setAvrAnal4(this.factureInterneEnteteVentes.getFitAnal4());
         var4.setAvrInfo1(this.factureInterneEnteteVentes.getFitInfo1());
         var4.setAvrInfo2(this.factureInterneEnteteVentes.getFitInfo2());
         var4.setAvrInfo3(this.factureInterneEnteteVentes.getFitInfo3());
         var4.setAvrInfo4(this.factureInterneEnteteVentes.getFitInfo4());
         var4.setAvrInfo5(this.factureInterneEnteteVentes.getFitInfo5());
         var4.setAvrInfo6(this.factureInterneEnteteVentes.getFitInfo6());
         var4.setAvrInfo7(this.factureInterneEnteteVentes.getFitInfo7());
         var4.setAvrInfo8(this.factureInterneEnteteVentes.getFitInfo8());
         var4.setAvrInfo9(this.factureInterneEnteteVentes.getFitInfo9());
         var4.setAvrInfo10(this.factureInterneEnteteVentes.getFitInfo10());
         var4.setAvrFormule1(this.factureInterneEnteteVentes.getFitFormule1());
         var4.setAvrFormule2(this.factureInterneEnteteVentes.getFitFormule2());
         var4.setAvrAnnexe1(this.factureInterneEnteteVentes.getFitAnnexe1());
         var4.setAvrAnnexe2(this.factureInterneEnteteVentes.getFitAnnexe2());
         var4.setAvrContrat(this.factureInterneEnteteVentes.getFitContrat());
         var4.setAvrIncoterm(this.factureInterneEnteteVentes.getFitIncoterm());
         var4.setAvrLieuLivraison(this.factureInterneEnteteVentes.getFitLieuLivraison());
         var4.setAvrDateLivraison(this.factureInterneEnteteVentes.getFitDateLivraison());
         var4.setAvrInfoLivraison(this.factureInterneEnteteVentes.getFitInfoLivraison());
         var4.setAvrDateImp((Date)null);
         var4.setAvrModeleImp(this.var_modele_trf);
         var4.setAvrGarde(this.factureInterneEnteteVentes.getFitGarde());
         var4.setAvrGele(0);
         var4.setAvrEtat(0);
         var4.setAvrDateTransforme((Date)null);
         var4.setAvrTypeTransforme(0);
         var4.setAvrDateAnnule((Date)null);
         var4.setAvrMotifAnnule("");
         var4.setAvrFactorNom(this.factureInterneEnteteVentes.getFitFactorNom());
         var4.setAvrFactorId(this.factureInterneEnteteVentes.getFitFactorId());
         var4.setAvrFactorEtat(this.factureInterneEnteteVentes.getFitFactorEtat());
         var4.setExerciceventes(this.exercicesVentes);
         var4.setTiers(this.factureInterneEnteteVentes.getTiers());
         var4.setUsers(this.usersLog);
         var4 = var5.insert(var4, var1);
         float var37 = 0.0F;
         float var11 = 0.0F;
         float var12 = 0.0F;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         if (this.lesLignesList.size() != 0) {
            int var25 = 0;

            while(true) {
               if (var25 >= this.lesLignesList.size()) {
                  var4.setAvrTotHt(var13);
                  var4.setAvrTotRemise(var15);
                  var4.setAvrTotRabais(var17);
                  var4.setAvrTotTva(var19);
                  var4.setAvrTotTc(var23);
                  var4.setAvrTotTtc(var21);
                  var4 = var5.modif(var4, var1);
                  if (var7.size() != 0) {
                     var6.saveLigne(var7, var4, var1);
                  }
                  break;
               }

               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var25);
               if (this.factureInterneLigneVentes.getFitligLibelle() != null && !this.factureInterneLigneVentes.getFitligLibelle().isEmpty() && this.factureInterneLigneVentes.getVar_qteReliquat() != 0.0F) {
                  if (this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.factureInterneLigneVentes.getFitligCode(), var1);
                     if (this.produits != null && this.factureInterneLigneVentes.getFitligDepot() != null && !this.factureInterneLigneVentes.getFitligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.factureInterneLigneVentes.getFitligCode(), this.factureInterneLigneVentes.getFitligDepot(), var1);
                     }
                  }

                  float var26 = this.factureInterneLigneVentes.getFitligQte();
                  float var27 = this.factureInterneLigneVentes.getFitligQteUtil();
                  AvoirLigneVentes var28 = new AvoirLigneVentes();
                  var37 += ((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getFitligQte();
                  var11 += ((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_qteDejaTrf();
                  if (((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat() != 0.0F) {
                     var28.setAvrligOrdre(this.factureInterneLigneVentes.getFitligOrdre());
                     var28.setAvrligCode(this.factureInterneLigneVentes.getFitligCode());
                     var28.setAvrligGroupe(this.factureInterneLigneVentes.getFitligGroupe());
                     var28.setAvrligModeGroupe(this.factureInterneLigneVentes.getFitligModeGroupe());
                     var28.setAvrligDevise(this.factureInterneLigneVentes.getFitligDevise());
                     var28.setAvrligFamille(this.factureInterneLigneVentes.getFitligFamille());
                     var28.setAvrligIdNdb(this.factureInterneLigneVentes.getFitligId());
                     var28.setAvrligLibelle(this.factureInterneLigneVentes.getFitligLibelle());
                     var28.setAvrligComplement(this.factureInterneLigneVentes.getFitligComplement());
                     if (((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne() != null && !((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne().isEmpty() && ((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne().contains("=")) {
                        String[] var29 = ((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_depotLigne().split("=");
                        var28.setAvrligDepot(var29[0]);
                     } else {
                        var28.setAvrligDepot("");
                     }

                     var28.setAvrligEchelle(this.factureInterneLigneVentes.getFitligEchelle());
                     var28.setAvrligUnite(this.factureInterneLigneVentes.getFitligUnite());
                     var28.setAvrligReference(this.factureInterneLigneVentes.getFitligReference());
                     var28.setAvrligPump(this.factureInterneLigneVentes.getFitligPump());
                     var28.setAvrligPu(this.factureInterneLigneVentes.getFitligPu());
                     var28.setAvrligPuTtc(this.factureInterneLigneVentes.getFitligPuTtc());
                     var28.setAvrligTauxRemise(this.factureInterneLigneVentes.getFitligTauxRemise());
                     var28.setAvrligPuRem(this.factureInterneLigneVentes.getFitligPuRem());
                     var28.setAvrligPuRemTtc(this.factureInterneLigneVentes.getFitligPuRemTtc());
                     this.factureInterneLigneVentes.setFitligQte(((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat());
                     this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), var1);
                     var28.setAvrligQte(((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat());
                     var28.setAvrligLong(this.factureInterneLigneVentes.getFitligLong());
                     var28.setAvrligLarg(this.factureInterneLigneVentes.getFitligLarg());
                     var28.setAvrligHaut(this.factureInterneLigneVentes.getFitligHaut());
                     var28.setAvrligDiam(this.factureInterneLigneVentes.getFitligDiam());
                     var28.setAvrligPoidsBrut(this.factureInterneLigneVentes.getFitligPoidsBrut());
                     var28.setAvrligPoidsNet(this.factureInterneLigneVentes.getFitligPoidsNet());
                     var28.setAvrligVolume(this.factureInterneLigneVentes.getFitligVolume());
                     var28.setAvrligNb(this.factureInterneLigneVentes.getFitligNb());
                     var28.setAvrligQteStock(0.0F);
                     var28.setAvrligRabais(this.factureInterneLigneVentes.getFitligRabais());
                     var28.setAvrligTauxTaxe(this.factureInterneLigneVentes.getFitligTauxTaxe());
                     var28.setAvrligTaxe(this.factureInterneLigneVentes.getFitligTaxe());
                     var28.setAvrligPt(this.factureInterneLigneVentes.getFitligPt());
                     var28.setAvrligTva(this.factureInterneLigneVentes.getFitligTva());
                     var28.setAvrligTtc(this.factureInterneLigneVentes.getFitligTtc());
                     var28.setAvrligTc(this.factureInterneLigneVentes.getFitligTc());
                     var28.setAvoirEnteteVentes(var4);
                     var12 += ((FactureInterneLigneVentes)this.lesLignesList.get(var25)).getVar_qteReliquat();
                     var7.add(var28);
                     var13 += var28.getAvrligPt();
                     var15 += (var28.getAvrligPu() - var28.getAvrligPuRem()) * (double)var28.getAvrligQte();
                     var17 += var28.getAvrligRabais();
                     var19 += var28.getAvrligTva();
                     var21 += var28.getAvrligTtc();
                     var23 += var28.getAvrligTc();
                     this.factureInterneLigneVentes.setFitligQte(var26);
                     this.factureInterneLigneVentes.setFitligQteUtil(var27);
                  }
               }

               ++var25;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationAvoir(var4, var1), var4.getAvrId(), var4.getAvrNum(), var4.getAvrNum(), var4.getAvrDate(), var4.getAvrDevise(), var4.getAvrTotTtc() + var4.getAvrTotTc(), var4.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 26), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFAVR(var7, var4), this.calculeParc(var1), var4.getVar_format_devise(), 0, var1);
         var3.setDoctraDateCreat(new Date());
         var3.setDoctraUserId(this.usersLog.getUsrid());
         var3.setDoctraUserNom(this.usersLog.getUsrNom());
         var3.setExerciceventes(this.exercicesVentes);
         var3.setDoctraOrgType(this.nature);
         var3.setDoctraOrgSerie(this.factureInterneEnteteVentes.getFitSerie());
         var3.setDoctraOrgId(this.factureInterneEnteteVentes.getFitId());
         var3.setDoctraOrgNum(this.factureInterneEnteteVentes.getFitNum());
         var3.setDoctraOrgDate(this.factureInterneEnteteVentes.getFitDate());
         var3.setDoctraDstType(this.var_type_trf);
         var3.setDoctraDstSerie(var4.getAvrSerie());
         var3.setDoctraDstId(var4.getAvrId());
         var3.setDoctraDstNum(var4.getAvrNum());
         var3.setDoctraDstDate(var4.getAvrDate());
         this.documentTraceVentesDao.insert(var3, var1);
         if (var37 <= var11 + var12 && var37 != 0.0F && var11 + var12 != 0.0F) {
            var4.setAvrEtat(5);
         } else {
            var4.setAvrEtat(4);
         }

         var4.setAvrDateTransforme(new Date());
         var4.setAvrTypeTransforme(this.var_type_trf);
         var5.modif(var4, var1);
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
         if (var1.getAvrDateImp() != null) {
            if (var1.getAvrEtat() == 0) {
               var1.setAvrEtat(1);
               var1.setAvrDateValide(new Date());
            }
         } else {
            var1.setAvrEtat(0);
            var1.setAvrDateValide((Date)null);
         }
      }

      return var4;
   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.factureInterneEnteteVentes != null) {
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
         if (this.var_tot_bon_encaissement > this.factureInterneEnteteVentes.getFitTotTtc()) {
            this.factureInterneEnteteVentes.setFitTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.factureInterneEnteteVentes.getFitTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.factureInterneEnteteVentes.getFitTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.factureInterneEnteteVentes.getFitEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.factureInterneEnteteVentes.getFitTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.factureInterneEnteteVentes.setFitTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.factureInterneEnteteVentes.getFitTotTtc() - this.var_tot_bon_encaissement;
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureInterneEnteteVentes.getFitSerie())) {
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
      if (this.factureInterneEnteteVentes.getFitTypeReg() != 4 && this.factureInterneEnteteVentes.getFitTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (Math.abs(this.var_tot_bon_encaissement) <= Math.abs(this.factureInterneEnteteVentes.getFitTotTtc())) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureInterneEnteteVentes.getFitTypeReg() == 5) {
               this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(this.nature, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.factureInterneEnteteVentes.getFitSerie(), var1);
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
                  this.bonEncaissementVente.setBonActivite(this.factureInterneEnteteVentes.getFitActivite());
                  this.bonEncaissementVente.setBonSite(this.factureInterneEnteteVentes.getFitSite());
                  this.bonEncaissementVente.setBonDepartement(this.factureInterneEnteteVentes.getFitDepartement());
                  this.bonEncaissementVente.setBonService(this.factureInterneEnteteVentes.getFitService());
                  this.bonEncaissementVente.setBonRegion(this.factureInterneEnteteVentes.getFitRegion());
                  this.bonEncaissementVente.setBonSecteur(this.factureInterneEnteteVentes.getFitSecteur());
                  this.bonEncaissementVente.setBonPdv(this.factureInterneEnteteVentes.getFitPdv());
                  this.bonEncaissementVente.setBonDateEcheReg(this.factureInterneEnteteVentes.getFitDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.factureInterneEnteteVentes.getFitNomTiers());
                  this.bonEncaissementVente.setBonIdTiers(this.factureInterneEnteteVentes.getTiers().getTieid());
                  this.bonEncaissementVente.setBonNomContact(this.factureInterneEnteteVentes.getFitNomContact());
                  this.bonEncaissementVente.setBonIdContact(this.factureInterneEnteteVentes.getFitIdContact());
                  this.bonEncaissementVente.setBonTypeTiers(0);
                  this.bonEncaissementVente.setBonLibelle("Règlement Facture interne N° " + this.factureInterneEnteteVentes.getFitNum());
                  this.bonEncaissementVente.setBonRef(this.factureInterneEnteteVentes.getFitNum());
                  this.bonEncaissementVente.setBonIdRef(this.factureInterneEnteteVentes.getFitId());
                  this.bonEncaissementVente.setBonObject(this.factureInterneEnteteVentes.getFitObject());
                  this.bonEncaissementVente.setBonObservation(this.factureInterneEnteteVentes.getFitObservation());
                  this.bonEncaissementVente.setBonSerie(this.factureInterneEnteteVentes.getFitSerie());
                  this.bonEncaissementVente.setBonDevise(this.factureInterneEnteteVentes.getFitDevise());
                  this.bonEncaissementVente.setBonTotTtc(this.factureInterneEnteteVentes.getFitTotTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonIdResponsable(this.factureInterneEnteteVentes.getFitIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.factureInterneEnteteVentes.getFitNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.factureInterneEnteteVentes.getFitIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.factureInterneEnteteVentes.getFitNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(this.factureInterneEnteteVentes.getFitIdEquipe());
                  this.bonEncaissementVente.setBonNomEquipe(this.factureInterneEnteteVentes.getFitNomEquipe());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.factureInterneEnteteVentes = (FactureInterneEnteteVentes)this.lesEntetesList.get(var11);
            if (this.factureInterneEnteteVentes.isVar_select_ligne()) {
               long var13 = this.factureInterneEnteteVentes.getFitId();
               this.factureInterneEnteteVentes = new FactureInterneEnteteVentes();
               this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.pourParapheur(var13, var1);
               if (this.factureInterneEnteteVentes != null) {
                  this.lesEntetesList.remove(var11);
                  this.factureInterneEnteteVentes.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.factureInterneEnteteVentes);
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
            new FactureInterneEnteteVentes();
            FactureInterneEnteteVentes var11 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getFitNomTiers())) && var11.getFitSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getFitNomTiers();
               var1 += var11.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc();
               var3 += var11.getFitTotReglement();
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
            this.factureInterneEnteteVentes.setFitTypeReg(0);
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureInterneEnteteVentes.getFitSerie())) {
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
         new FactureInterneEnteteVentes();
         FactureInterneEnteteVentes var6 = (FactureInterneEnteteVentes)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getFitTotTtc();
            var3 += var6.getFitTotReglement();
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
      FactureInterneEnteteVentes var9;
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new FactureInterneEnteteVentes();
               FactureInterneEnteteVentes var7 = (FactureInterneEnteteVentes)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getFitTotTtc() + var7.getFitTotTc() - var7.getFitTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFitTotTtc() + var7.getFitTotTc() - var7.getFitTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFitDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFitTotTtc() + var7.getFitTotTc() - var7.getFitTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFitDate());
                  var4 = var4 - var7.getFitTotTtc() + var7.getFitTotTc() - var7.getFitTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FactureInterneEnteteVentes();
            var9 = (FactureInterneEnteteVentes)this.listFactureSelectionne.get(var1);
            var9.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var9.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      if (this.factureInterneEnteteVentes.getFitTypeReg() == 4) {
         double var8 = 0.0D;

         for(int var3 = 0; var3 < this.listFactureSelectionne.size(); ++var3) {
            new FactureInterneEnteteVentes();
            FactureInterneEnteteVentes var10 = (FactureInterneEnteteVentes)this.listFactureSelectionne.get(var3);
            var8 += var10.getVar_reliquat();
         }
      } else {
         this.montantElmTotBonEnc = 0.0D;

         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FactureInterneEnteteVentes();
            var9 = (FactureInterneEnteteVentes)this.listFactureSelectionne.get(var1);
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
               String var7 = this.factureInterneEnteteVentes.getFitSerie();
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
                  new FactureInterneEnteteVentes();

                  for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                     FactureInterneEnteteVentes var20 = (FactureInterneEnteteVentes)this.listFactureSelectionne.get(var21);
                     var16 = var20.getVar_fac_timbre();
                     var18 = var20.getMontantReglementManuel();
                     var12 = 0.0D;
                     if (var20.isVar_select_ligne()) {
                        long var22 = var20.getFitId();
                        var20 = this.factureInterneEnteteVentesDao.pourParapheur(var22, var3);
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
                              var12 = var20.getFitTotTtc() + var20.getFitTotTc() + var16 - var20.getFitTotReglement();
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
         Session var31 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");

         for(int var32 = 0; var32 < this.lesEntetesList.size(); ++var32) {
            this.factureInterneEnteteVentes = (FactureInterneEnteteVentes)this.lesEntetesList.get(var32);
            if (this.factureInterneEnteteVentes.isVar_select_ligne()) {
               long var33 = this.factureInterneEnteteVentes.getFitId();
               this.factureInterneEnteteVentes = new FactureInterneEnteteVentes();
               this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.pourParapheur(var33, var31);
               if (this.factureInterneEnteteVentes != null) {
                  if (this.factureInterneEnteteVentes.getFitSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var32);
                  } else {
                     this.lesEntetesList.remove(var32);
                     this.factureInterneEnteteVentes.setVar_select_ligne(false);
                     this.lesEntetesList.add(var32, this.factureInterneEnteteVentes);
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
               this.totManuel += ((FactureInterneEnteteVentes)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
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

   public void generationReglement(String var1, double var2, double var4, FactureInterneEnteteVentes var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (Math.abs(var2) >= Math.abs(var6.getFitTotTtc() + var6.getFitTotTc() + var4)) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite(var6.getFitActivite());
      this.reglements.setRglBudget(var6.getFitBudget());
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
      this.reglements.setRglDepartement(var6.getFitDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getFitDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getFitNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getFitId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle(var6.getFitObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(142);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      if (this.optionsVentes.getDecrmtPrsChrStock() != null && this.optionsVentes.getDecrmtPrsChrStock().equals("2")) {
         this.reglements.setRglIdContact(var6.getFitIdContact());
         this.reglements.setRglNomContact(var6.getVar_nomContact());
      } else {
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
      }

      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getFitPdv());
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getFitDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getFitRegion());
      this.reglements.setRglSecteur(var6.getFitSecteur());
      this.reglements.setRglSerie(var6.getFitSerie());
      this.reglements.setRglService(var6.getFitService());
      this.reglements.setRglSite(var6.getFitSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getFitIdResponsable());
      this.reglements.setRglNomResponsable(var6.getFitNomResponsable());
      this.reglements.setRglIdCommercial(var6.getFitIdCommercial());
      this.reglements.setRglNomCommercial(var6.getFitNomCommercial());
      this.reglements.setRglIdEquipe(var6.getFitIdEquipe());
      this.reglements.setRglNomEquipe(var6.getFitNomEquipe());
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
         var6.setFitTotReglement(var6.getFitTotReglement() + var2);
         var6.setFitTotTimbre(var6.getFitTotTimbre() + var14);
         if (Math.abs(var6.getFitTotReglement()) >= Math.abs(var6.getFitTotTtc() + var6.getFitTotTc())) {
            var6.setFitSolde(1);
         } else {
            var6.setFitSolde(0);
         }

         var6.setFitDateLastReg(this.reglements.getRglDateReg());
         this.factureInterneEnteteVentesDao.modif(var6, var8);
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
      this.mesModesleRecus = new ArrayList();
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.factureInterneEnteteVentes.getFitId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.factureInterneEnteteVentes.setFitTotReglement(var4);
            if (Math.abs(this.factureInterneEnteteVentes.getFitTotReglement()) >= Math.abs(this.factureInterneEnteteVentes.getFitTotTtc())) {
               this.factureInterneEnteteVentes.setFitSolde(1);
            } else {
               this.factureInterneEnteteVentes.setFitSolde(0);
            }

            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
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
      if (this.factureInterneEnteteVentes != null) {
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

   public String conversionGarde() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureInterneEnteteVentes.getFitGarde() != null && !this.factureInterneEnteteVentes.getFitGarde().isEmpty() && this.factureInterneEnteteVentes.getFitGarde().contains(":")) {
         String[] var2 = this.factureInterneEnteteVentes.getFitGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureInterneEnteteVentes.getUsers(), this.structureLog, this.factureInterneEnteteVentes.getTiers());
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
      if (this.factureInterneEnteteVentes.getFitFormule1() != null && !this.factureInterneEnteteVentes.getFitFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.factureInterneEnteteVentes.getFitFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureInterneEnteteVentes.getFitFormule2() != null && !this.factureInterneEnteteVentes.getFitFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.factureInterneEnteteVentes.getFitFormule2(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.factureInterneEnteteVentes.getFitAnnexe1() != null && !this.factureInterneEnteteVentes.getFitAnnexe1().isEmpty() && this.factureInterneEnteteVentes.getFitAnnexe1().contains(":")) {
         String[] var2 = this.factureInterneEnteteVentes.getFitAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureInterneEnteteVentes.getUsers(), this.structureLog, this.factureInterneEnteteVentes.getTiers());
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
      if (this.factureInterneEnteteVentes.getFitAnnexe2() != null && !this.factureInterneEnteteVentes.getFitAnnexe2().isEmpty() && this.factureInterneEnteteVentes.getFitAnnexe2().contains(":")) {
         String[] var2 = this.factureInterneEnteteVentes.getFitAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.factureInterneEnteteVentes.getUsers(), this.structureLog, this.factureInterneEnteteVentes.getTiers());
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
      } else if (var2 == 142) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture_interne" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatFactureInterne.jpg");
            if (var4.exists()) {
               var3 = "formatFactureInterne.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatFactureInterne.jpg");
         if (var4.exists()) {
            var3 = "formatFactureInterne.jpg";
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
         this.infoOrigineDoc = "";
         ConditionnementDao var8 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();

         for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
            this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var10);
            if (this.factureInterneLigneVentes.getFitligModeGroupe() != 2 || this.factureInterneLigneVentes.getFitligGroupe() == null || this.factureInterneLigneVentes.getFitligGroupe().isEmpty()) {
               this.factureInterneLigneVentes.setVar_lib_des_condit("");
               if (this.factureInterneLigneVentes.getFitligCondition() != null && !this.factureInterneLigneVentes.getFitligCondition().isEmpty() && this.factureInterneLigneVentes.getFitligCondition().contains(":")) {
                  String[] var11 = this.factureInterneLigneVentes.getFitligCondition().split(":");
                  Conditionnement var9 = var8.rechercheConditionnement(var11[0], (Session)null);
                  if (var9 != null) {
                     this.factureInterneLigneVentes.setVar_lib_des_condit(var9.getCdtDescription());
                  }
               }

               if (this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty() && this.factureInterneLigneVentes.getFitligCode().equals("-")) {
                  var2 = true;
                  var3 = this.factureInterneLigneVentes.getFitligLibelle();
                  if (var3.startsWith("Suivant ")) {
                     this.infoOrigineDoc = var3;
                  }
               }

               if (var2) {
                  var4 += this.factureInterneLigneVentes.getFitligPt();
                  var6 = this.factureInterneLigneVentes.getFitligTtc();
               }

               if (this.factureInterneLigneVentes.getFitligCode() != null && !this.factureInterneLigneVentes.getFitligCode().isEmpty() && this.factureInterneLigneVentes.getFitligCode().equals("=") && var2) {
                  this.factureInterneLigneVentes = new FactureInterneLigneVentes();
                  this.factureInterneLigneVentes.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
                  this.factureInterneLigneVentes.setFitligCode("=");
                  this.factureInterneLigneVentes.setFitligOrdre(var10);
                  this.factureInterneLigneVentes.setFitligLibelle(var3);
                  this.factureInterneLigneVentes.setFitligPt(var4);
                  this.factureInterneLigneVentes.setFitligTtc(var6);
                  var1.add(this.factureInterneLigneVentes);
                  var4 = 0.0D;
                  var6 = 0.0D;
                  var2 = false;
               } else {
                  this.factureInterneLigneVentes.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
                  this.factureInterneLigneVentes.setFitligOrdre(var10);
                  var1.add(this.factureInterneLigneVentes);
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.factureInterneLigneVentes = new FactureInterneLigneVentes();
            this.factureInterneLigneVentes.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
            this.factureInterneLigneVentes.setFitligCode("FORMULE1");
            this.factureInterneLigneVentes.setFitligOrdre(var1.size() + 2);
            this.factureInterneLigneVentes.setFitligLibelle(this.formule1());
            this.factureInterneLigneVentes.setFitligPt(0.0D);
            this.factureInterneLigneVentes.setFitligTtc(0.0D);
            var1.add(this.factureInterneLigneVentes);
            this.factureInterneLigneVentes = new FactureInterneLigneVentes();
            this.factureInterneLigneVentes.setFactureInterneEnteteVentes(this.factureInterneEnteteVentes);
            this.factureInterneLigneVentes.setFitligCode("FORMULE2");
            this.factureInterneLigneVentes.setFitligOrdre(var1.size() + 2);
            this.factureInterneLigneVentes.setFitligLibelle(this.formule2());
            this.factureInterneLigneVentes.setFitligPt(0.0D);
            this.factureInterneLigneVentes.setFitligTtc(0.0D);
            var1.add(this.factureInterneLigneVentes);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.utilNombre.myRoundDevise(this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc(), this.factureInterneEnteteVentes.getFitDevise()), this.factureInterneEnteteVentes.getFitDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var1);
      return var12;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.factureInterneEnteteVentes.getFitAnal2() != null && !this.factureInterneEnteteVentes.getFitAnal2().isEmpty()) {
         String var4 = "";
         if (this.factureInterneEnteteVentes.getFitAnal2().contains(":")) {
            String[] var5 = this.factureInterneEnteteVentes.getFitAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.factureInterneEnteteVentes.getFitAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.factureInterneEnteteVentes.getFitDateImp() != null && this.factureInterneEnteteVentes.getFitEtat() != 0) {
            var2 = true;
         }

         this.factureInterneEnteteVentes.setFitDateImp(new Date());
         if (this.factureInterneEnteteVentes.getFitEtat() == 0 && this.factureInterneEnteteVentes.getFitEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.factureInterneEnteteVentes.setFitEtat(1);
            if (this.tiers.getTieDteDocument6() == null || this.factureInterneEnteteVentes.getFitDate().after(this.tiers.getTieDteDocument6())) {
               this.tiers.setTieDteDocument6(this.factureInterneEnteteVentes.getFitDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.factureInterneEnteteVentes.setFitModeleImp(var1);
         this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var3);
         this.contacts = new Contacts();
         if (this.factureInterneEnteteVentes.getFitIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.factureInterneEnteteVentes.getFitIdContact(), var3);
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
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var4);
            var1.setEntete("Impression facture interne");
            var1.setPageGarde(this.conversionGarde());
            if (this.factureInterneEnteteVentes.getFitFormule1() != null && !this.factureInterneEnteteVentes.getFitFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.factureInterneEnteteVentes.getFitEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.factureInterneEnteteVentes.setFitDevise(this.devisePrint);
            if (!this.factureInterneEnteteVentes.getFitDevise().equals("XOF") && !this.factureInterneEnteteVentes.getFitDevise().equals("XAF")) {
               if (this.factureInterneEnteteVentes.getFitDevise().equals("EUR")) {
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
               double var13 = this.utilNombre.myRound((this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.factureInterneEnteteVentes.getFitIdResponsable());
            var1.setIdCommercial(this.factureInterneEnteteVentes.getFitIdCommercial());
            var1.setTiersSelectionne(this.factureInterneEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.factureInterneEnteteVentes.getFitNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.factureInterneEnteteVentes.getFitId());
            if (this.factureInterneEnteteVentes.getFitAnal2() != null && !this.factureInterneEnteteVentes.getFitAnal2().isEmpty()) {
               String var17 = "";
               if (this.factureInterneEnteteVentes.getFitAnal2().contains(":")) {
                  String[] var14 = this.factureInterneEnteteVentes.getFitAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.factureInterneEnteteVentes.getFitAnal2();
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
      } else if (var5 != null && !var5.isEmpty()) {
         var1.setRapport(var5);
         var1.setEntete("Impression de la liste des factures internes");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "facture_interne" + File.separator);
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
            this.uniteGraph = "NOTES DEBIT : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "NOTES DEBIT : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "NOTES DEBIT : Quantites";
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

         new FactureInterneEnteteVentes();
         new FactureInterneLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureInterneLigne");
         String var6 = "";

         FactureInterneEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getFitNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getFitNum() + "'";
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

                  var14 = (FactureInterneEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getFitDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getFitNomResponsable() != null && !var14.getFitNomResponsable().isEmpty()) {
                        var17 = var14.getFitNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getFitNomCommercial() != null && !var14.getFitNomCommercial().isEmpty()) {
                        var17 = var14.getFitNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getFitNomEquipe() != null && !var14.getFitNomEquipe().isEmpty()) {
                        var17 = var14.getFitNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getFitNomTiers() != null && !var14.getFitNomTiers().isEmpty()) {
                        var17 = var14.getFitNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getFitSource() != null && !var14.getFitSource().isEmpty()) {
                        var17 = var14.getFitSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getFitRegion() != null && !var14.getFitRegion().isEmpty()) {
                        var17 = var14.getFitRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getFitSecteur() != null && !var14.getFitSecteur().isEmpty()) {
                        var17 = var14.getFitSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getFitPdv() != null && !var14.getFitPdv().isEmpty()) {
                        var17 = var14.getFitPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getFitSite() != null && !var14.getFitSite().isEmpty()) {
                        var17 = var14.getFitSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getFitDepartement() != null && !var14.getFitDepartement().isEmpty()) {
                        var17 = var14.getFitDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getFitService() != null && !var14.getFitService().isEmpty()) {
                        var17 = var14.getFitService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getFitSerie() != null && !var14.getFitSerie().isEmpty()) {
                        var17 = var14.getFitSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getFitTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getFitDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getFitDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getFitDate().getMonth() + 1 >= 1 && var14.getFitDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getFitDate().getMonth() + 1 >= 4 && var14.getFitDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getFitDate().getMonth() + 1 >= 7 && var14.getFitDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getFitDate().getMonth() + 1 >= 10 && var14.getFitDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getFitDate().getMonth() + 1 >= 1 && var14.getFitDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getFitDate().getMonth() + 1 >= 7 && var14.getFitDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getFitDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.factureInterneLigneVentesDao.chargerLesLignesNoteDebits(var6, var5);
            if (var16.size() != 0) {
               String var8 = "";
               long var9 = 0L;
               boolean var11 = false;

               for(var12 = 0; var12 < var16.size(); ++var12) {
                  FactureInterneLigneVentes var15 = (FactureInterneLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getFactureInterneEnteteVentes().getFitDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getFactureInterneEnteteVentes().getFitNomResponsable() != null && !var15.getFactureInterneEnteteVentes().getFitNomResponsable().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getFactureInterneEnteteVentes().getFitNomCommercial() != null && !var15.getFactureInterneEnteteVentes().getFitNomCommercial().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getFactureInterneEnteteVentes().getFitNomEquipe() != null && !var15.getFactureInterneEnteteVentes().getFitNomEquipe().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getFactureInterneEnteteVentes().getFitNomTiers() != null && !var15.getFactureInterneEnteteVentes().getFitNomTiers().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getFitligFamille() != null && !var15.getFitligFamille().isEmpty()) {
                        var8 = var15.getFitligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getFitligLibelle() != null && !var15.getFitligLibelle().isEmpty()) {
                        var8 = var15.getFitligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getFactureInterneEnteteVentes().getFitSource() != null && !var15.getFactureInterneEnteteVentes().getFitSource().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getFactureInterneEnteteVentes().getFitAnal4() != null && !var15.getFactureInterneEnteteVentes().getFitAnal4().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getFactureInterneEnteteVentes().getFitRegion() != null && !var15.getFactureInterneEnteteVentes().getFitRegion().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getFactureInterneEnteteVentes().getFitSecteur() != null && !var15.getFactureInterneEnteteVentes().getFitSecteur().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getFactureInterneEnteteVentes().getFitPdv() != null && !var15.getFactureInterneEnteteVentes().getFitPdv().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getFactureInterneEnteteVentes().getFitSite() != null && !var15.getFactureInterneEnteteVentes().getFitSite().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getFactureInterneEnteteVentes().getFitDepartement() != null && !var15.getFactureInterneEnteteVentes().getFitDepartement().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getFactureInterneEnteteVentes().getFitService() != null && !var15.getFactureInterneEnteteVentes().getFitService().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getFactureInterneEnteteVentes().getFitSerie() != null && !var15.getFactureInterneEnteteVentes().getFitSerie().isEmpty()) {
                        var8 = var15.getFactureInterneEnteteVentes().getFitSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getFitligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getFitligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getFactureInterneEnteteVentes().getFitDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 >= 1 && var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 >= 4 && var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 >= 7 && var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 >= 10 && var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 >= 1 && var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 >= 7 && var15.getFactureInterneEnteteVentes().getFitDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getFactureInterneEnteteVentes().getFitDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var8, var19, var9);
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

   public void recalculTva(FactureInterneEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.factureInterneEnteteVentes = var1;
         this.lesLignesList = this.factureInterneLigneVentesDao.chargerLesLignes(this.factureInterneEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureInterneLigneVentes = (FactureInterneLigneVentes)this.lesLignesList.get(var3);
               this.calculPrix(this.factureInterneLigneVentes.getFitligTaxe(), this.factureInterneLigneVentes.getFitligTauxTaxe(), var2);
               this.factureInterneLigneVentes = this.factureInterneLigneVentesDao.modifLigne(this.factureInterneLigneVentes, var2);
            }

            this.cumulPrix();
            this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var2);
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

   public FactureInterneEnteteVentes getFactureInterneEnteteVentes() {
      return this.factureInterneEnteteVentes;
   }

   public void setFactureInterneEnteteVentes(FactureInterneEnteteVentes var1) {
      this.factureInterneEnteteVentes = var1;
   }

   public FactureInterneLigneVentes getFactureInterneLigneVentes() {
      return this.factureInterneLigneVentes;
   }

   public void setFactureInterneLigneVentes(FactureInterneLigneVentes var1) {
      this.factureInterneLigneVentes = var1;
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

   public double getPrixUnitaires() {
      return this.prixUnitaires;
   }

   public void setPrixUnitaires(double var1) {
      this.prixUnitaires = var1;
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

   public double getPrixPlancher() {
      return this.prixPlancher;
   }

   public void setPrixPlancher(double var1) {
      this.prixPlancher = var1;
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

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
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
