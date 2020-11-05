package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BesoinEnteteVentes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.ChargementFrais;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.ReceptionLotAchats;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BesoinEnteteVentesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.ChargementEnteteDao;
import com.epegase.systeme.dao.ChargementFraisDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReceptionLotAchatsDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ServiceDao;
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
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormChargementVentes implements Serializable {
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
   private String ongletActif = "tabDoc";
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private Date var_date_doc;
   private String var_heure_doc;
   private String var_minute_doc;
   private String var_seconde_doc;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private Users responsable;
   private long var_nom_commercial;
   private List mesCommercialItem = new ArrayList();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private long var_nom_responsable;
   private List mesUsersItem = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private String var_depot;
   private ChargementEntete chargementEntete = new ChargementEntete();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private ChargementEnteteDao chargementEnteteDao;
   private List lesEntetesList = new ArrayList();
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete = new ListDataModel();
   private boolean visibiliteBton = false;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private boolean var_valide_chg = false;
   private boolean var_valide_rcg = false;
   private boolean var_valide_fac = false;
   private boolean var_valide_fra = false;
   private double montantTtc = 0.0D;
   private double montantFac = 0.0D;
   private double montantEcart = 0.0D;
   private double montantReglement = 0.0D;
   private double montantSolde = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantFacElmt = 0.0D;
   private double montantEcartElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private int var_nb_ligne = 0;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private boolean showModalPanelValidationDocument = false;
   private List mesParcsItems = new ArrayList();
   private long var_nom_contact;
   private double var_total_marge;
   private List mesDepotChgItems = new ArrayList();
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private boolean affichageDepot;
   private boolean showModalPanelAnnuler = false;
   private ChargementLigne chargementLigne = new ChargementLigne();
   private ChargementLigneDao chargementLigneDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private ChargementLigne rechargementLigne;
   private transient DataModel datamodelRechargement = new ListDataModel();
   private List lesRechargementsList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private double prixPlancher;
   private boolean griserValider = false;
   private float memo_qte;
   private int var_type_serie;
   private List mesPalettesItems = new ArrayList();
   private List mesCartonsItems = new ArrayList();
   private String var_select_carton;
   private String var_select_palette;
   private boolean var_liste_vide;
   private boolean var_select_type;
   private ServiceDao serviceDao;
   private Produits produits;
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
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpResponsable = "";
   private String inpCommercial = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpContener = "";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
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
   private UtilTdt utilTdt;
   private UtilPrint utilPrint;
   private String format;
   private int choixImpression;
   private boolean affMail = false;
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelPrintFacture = false;
   private boolean showModalPanelPrintAvoir = false;
   private boolean showModalPanelPrintRetour = false;
   private String nomModeleDocument;
   private List documentImpressionItems;
   private String infoOrigineDoc;
   private Date dateRechargement = new Date();
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
   private Tiers tiers;
   private String nomTier;
   private List lesFamilleClientsListe;
   private List lesModeReglementClientsListe;
   private FactureEnteteVentes factureEnteteVentes;
   private FactureLigneVentes factureLigneVentes;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private FactureLigneVentesDao factureLigneVentesDao;
   private transient DataModel datamodelFacture = new ListDataModel();
   private List listFacture = new ArrayList();
   private String var_libcondest;
   private boolean contDest = false;
   private boolean showModalPanelFacturation = false;
   private List lesProduitsDispo = new ArrayList();
   private transient DataModel datamodelDispo = new ListDataModel();
   private transient DataModel dataModelDetailFacture = new ListDataModel();
   private boolean showModalPanelAvoir = false;
   private AvoirEnteteVentes avoirEnteteVentes;
   private AvoirLigneVentes avoirLigneVentes;
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private AvoirLigneVentesDao avoirLigneVentesDao;
   private transient DataModel datamodelAvoir = new ListDataModel();
   private List listAvoir = new ArrayList();
   private boolean showModalPanelPrintNoteDebit = false;
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
   private NoteDebitLigneVentes noteDebitLigneVentes;
   private List listNoteDebit = new ArrayList();
   private transient DataModel dataModelNoteDebit = new ListDataModel();
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
   private transient DataModel datamodelDechargement = new ListDataModel();
   private List listDechargement = new ArrayList();
   private boolean showModalPanelProduit = false;
   private List listAjoutProduit = new ArrayList();
   private boolean visibiliteBtonDechargement = false;
   private ChargementFrais chargementFrais;
   private ChargementFraisDao chargementFraisDao;
   private transient DataModel datamodelFrais = new ListDataModel();
   private List listFrais = new ArrayList();
   private boolean showModalPanelFrais = false;
   private List mesProduitsFrais = new ArrayList();
   private String var_frais;
   private boolean showModalPanelLivraison = false;
   private boolean showModalPanelEclatement = false;
   private transient DataModel dataModelEclatement = new ListDataModel();
   private List listEclatement = new ArrayList();
   private float total_eclatement;
   private float total_ecart;
   private List listLigneASupprimer = new ArrayList();
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private ReglementsDao reglementsDao;
   private boolean afficheRecu;
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
   private boolean showModalPanelHistorique = false;
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

   public FormChargementVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.chargementEnteteDao = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
      this.chargementLigneDao = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
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
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.chargementFraisDao = new ChargementFraisDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("1")) {
         this.contDest = false;
         this.var_libcondest = "Contact";
      } else if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("2")) {
         this.contDest = true;
         this.var_libcondest = "Destinataire";
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

      this.periode = this.optionsVentes.getAffichInGlobViewCh();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
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

      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.ongletActif = "tabDoc";
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

      this.ongletActif = "tabImput";
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

      this.chargementLigne = new ChargementLigne();
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.ongletActif = "tabComplement";
   }

   public void autorisationRechargement() {
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

      this.chargementLigne = new ChargementLigne();
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.ongletActif = "tabRechargement";
   }

   public void autorisationFacturation() {
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

      this.chargementLigne = new ChargementLigne();
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.ongletActif = "tabFacturation";
   }

   public void autorisationAvoir() {
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

      this.chargementLigne = new ChargementLigne();
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.ongletActif = "tabAvoir";
   }

   public void autorisationRetour() {
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

      this.chargementLigne = new ChargementLigne();
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.ongletActif = "tabRetour";
   }

   public void autorisationNoteDebit() {
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

      this.chargementLigne = new ChargementLigne();
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.ongletActif = "tabNoteDebit";
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

      this.chargementFrais = new ChargementFrais();
      this.ongletActif = "tabFrais";
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

      this.ongletActif = "tabEtat";
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

      this.ongletActif = "tabTrace";
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
      this.var_action = 0;
      this.montantTtc = 0.0D;
      this.montantFac = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.montantFacElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantEcartElmt = 0.0D;
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
      new ArrayList();
      List var2 = this.usersDao.chargerLesSignataires("Ventes", var1);
      this.mesUsersItem.clear();
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            Users var4 = (Users)var2.get(var3);
            if (var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
               this.mesUsersItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
            }
         }
      }

      new ArrayList();
      List var6 = this.usersDao.chargerLesCommerciaux(var1);
      this.mesCommercialItem.clear();
      if (var6.size() != 0) {
         this.mesCommercialItem.add(new SelectItem(0, ""));

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            Users var5 = (Users)var6.get(var7);
            if (var5.getUsrVendeur() == 1 && var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
               this.mesCommercialItem.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerLesDepots(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesDepotChgItems = new ArrayList();
      DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesDepotChgItems = var2.selectActifDepotItems(28, var1);
   }

   public void chargerLesProduitsFrais(Session var1) throws HibernateException, NamingException {
      this.mesProduitsFrais = new ArrayList();
      new ArrayList();
      List var2 = this.produitsDao.chargerLesProduitsFrais(var1);
      if (var2.size() != 0) {
         this.mesProduitsFrais.add(new SelectItem(0, "Sélectionnez le frais"));
         new Produits();

         for(int var4 = 0; var4 < var2.size(); ++var4) {
            Produits var3 = (Produits)var2.get(var4);
            this.mesProduitsFrais.add(new SelectItem(var3.getProCode() + ":" + var3.getProLibClient()));
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

   public void moreSearch() throws ParseException {
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
         this.inpResponsable = "";
         this.inpCommercial = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
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
      double var10 = 0.0D;
      this.var_nb_ligne = 0;
      String var12 = "";
      String var13 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var12 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var13 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var12 = null;
         var13 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.chargementEnteteDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpResponsable(), this.getInpCommercial(), this.getInpActivite(), this.getInpContener(), var12, var13);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new ChargementEntete();

         for(int var15 = 0; var15 < this.lesEntetesList.size(); ++var15) {
            ChargementEntete var14 = (ChargementEntete)this.lesEntetesList.get(var15);
            var2 += var14.getChamobTotTtc();
            var4 += var14.getChamobTotFacture();
            var6 += var14.getChamobTotReglement();
            var8 += var14.getChamobTotHt();
            var10 += var14.getChamobTotTva();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.totauxHt = var2;
      this.totauxHt = var8;
      this.totauxTaxe = var10;
      this.montantTtc = var2;
      this.montantFac = var4;
      this.montantEcart = var2 - var4;
      this.montantReglement = var6;
      this.montantSolde = var4 - var6;
      this.visibiliteBton = false;
   }

   public void selectionLigne() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
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
            this.chargementEntete = (ChargementEntete)var1.get(0);
            this.var_date = this.chargementEntete.getChamobDate();
            if (this.chargementEntete.getChamobDate().getHours() <= 9) {
               this.var_heure = "0" + this.chargementEntete.getChamobDate().getHours();
            } else {
               this.var_heure = "" + this.chargementEntete.getChamobDate().getHours();
            }

            if (this.chargementEntete.getChamobDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.chargementEntete.getChamobDate().getMinutes();
            } else {
               this.var_minute = "" + this.chargementEntete.getChamobDate().getMinutes();
            }

            if (this.chargementEntete.getChamobDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.chargementEntete.getChamobDate().getSeconds();
            } else {
               this.var_seconde = "" + this.chargementEntete.getChamobDate().getSeconds();
            }

            this.var_depot = "";
            if (this.chargementEntete.getChamobDepotCharg() != null && !this.chargementEntete.getChamobDepotCharg().isEmpty()) {
               for(int var6 = 0; var6 < this.mesDepotChgItems.size(); ++var6) {
                  String var4 = (String)((SelectItem)this.mesDepotChgItems.get(var6)).getValue();
                  if (var4.contains(":")) {
                     String[] var5 = var4.split(":");
                     if (var5[0].equals(this.chargementEntete.getChamobDepotCharg())) {
                        this.var_depot = var4;
                     }
                  }
               }
            }

            this.calculDevise();
            Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigneDechargement");
            this.chargerDocumentLigne(var7);
            this.chargerDocumentDocument(var7);
            this.chargerDocumentFrais(var7);
            this.chargerDocumentTrace(var7);
            this.chargerUserChrono(var7);
            this.chargerParapheur(var7);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            if (this.mesUsersItem != null && this.mesUsersItem.size() != 0) {
               this.var_nom_responsable = this.chargementEntete.getChamobIdResponsable();
               if (this.var_nom_responsable == 0L) {
                  this.var_nom_responsable = this.usersLog.getUsrid();
               }
            } else {
               this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
               this.var_nom_responsable = this.usersLog.getUsrid();
            }

            if (this.mesCommercialItem != null && this.mesCommercialItem.size() != 0) {
               this.var_nom_commercial = this.chargementEntete.getChamobIdCommercial();
            } else {
               this.mesCommercialItem.add(new SelectItem(0, ""));
               this.var_nom_commercial = 0L;
            }

            this.utilInitHibernate.closeSession();
            this.montantTtcElmt = this.chargementEntete.getChamobTotTtc();
            this.montantFacElmt = this.chargementEntete.getChamobTotFacture();
            this.montantEcartElmt = this.montantTtcElmt - this.montantFacElmt;
            this.montantReglementElmt = this.chargementEntete.getChamobTotReglement();
            this.montantSoldeElmt = this.montantFacElmt - this.montantReglementElmt;
            this.cumulPrix();
            this.factureEnteteVentes = new FactureEnteteVentes();
            this.avoirEnteteVentes = new AvoirEnteteVentes();
            this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.chargementEntete.getChamobTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.chargementEntete != null) {
         if (this.chargementEntete.getChamobEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      this.var_format_devise = this.structureLog.getStrformatdevise();
   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      this.lesRechargementsList.clear();
      this.listDechargement.clear();
      this.listAjoutProduit.clear();
      new ArrayList();
      if (this.chargementEntete.getChamobId() > 0L) {
         List var2 = this.chargementLigneDao.chargerLesLignes(this.chargementEntete, var1);
         if (var2.size() != 0) {
            new ChargementLigne();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               ChargementLigne var3 = (ChargementLigne)var2.get(var4);
               if (var3.getChaligRechargement() == 1) {
                  this.lesRechargementsList.add(var3);
               } else if (var3.getChaligRechargement() == 2) {
                  this.listAjoutProduit.add(var3);
               } else {
                  this.lesLignesList.add(var3);
               }
            }
         }
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
      this.datamodelRechargement.setWrappedData(this.lesRechargementsList);
   }

   public void toutLivrer() throws HibernateException, NamingException {
      if (this.lesLignesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.chargementLigne = new ChargementLigne();
               this.chargementLigne = (ChargementLigne)this.lesLignesList.get(var3);
               if (this.chargementLigne.getChaligCode() != null && this.chargementLigne.getChaligCode().length() >= 2 && this.chargementLigne.getChaligGenerique() != 5) {
                  this.produits = this.produitsDao.chargeProduit(this.chargementLigne.getChaligCode(), var1);
                  if (this.produits != null && this.chargementLigne.getChaligQteDem() != 0.0F) {
                     this.chargementLigne.setChaligQteCharg(this.chargementLigne.getChaligQteDem());
                     this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var1);
                     this.calculPrix(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTauxTaxe(), var1);
                  }
               }
            }

            this.datamodelLigne.setWrappedData(this.lesLignesList);
            this.cumulPrix();
            this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
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

   public void chargerDocumentDocument(Session var1) throws HibernateException, NamingException {
      this.listFacture.clear();
      this.listAvoir.clear();
      this.listNoteDebit.clear();
      String var2 = "";
      if (this.chargementEntete.getChamobId() > 0L) {
         var2 = "facContrat ='CH:" + this.chargementEntete.getChamobNum() + "'";
         this.listFacture = this.factureEnteteVentesDao.rechercheFactureRequete(var2, var1);
         var2 = "avrContrat ='CH:" + this.chargementEntete.getChamobNum() + "'";
         this.listAvoir = this.avoirEnteteVentesDao.rechercheAvoirRequete(var2, var1);
         var2 = "ndbContrat ='CH:" + this.chargementEntete.getChamobNum() + "'";
         this.listNoteDebit = this.noteDebitEnteteVentesDao.rechercheNoteDebitRequete(var2, var1);
      }

      this.datamodelFacture.setWrappedData(this.listFacture);
      this.datamodelAvoir.setWrappedData(this.listAvoir);
      this.dataModelNoteDebit.setWrappedData(this.listNoteDebit);
   }

   public void chargerDocumentFrais(Session var1) throws HibernateException, NamingException {
      this.listFrais.clear();
      if (this.chargementEntete.getChamobId() > 0L) {
         this.listFrais = this.chargementFraisDao.chargerLesLignes(this.chargementEntete, var1);
      }

      this.datamodelFrais.setWrappedData(this.listFrais);
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigneDechargement");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.chargementEntete.getChamobId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.chargementEntete.getChamobId(), this.nature, var1);
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
      if (this.chargementEntete != null && this.chargementEntete.getChamobSerie() != null && !this.chargementEntete.getChamobSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.chargementEntete.getChamobSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.chargementEntete.getChamobId(), this.nature, var1);
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
      if (this.decoupageActivite && this.chargementEntete.getChamobActivite() != null && !this.chargementEntete.getChamobActivite().isEmpty() && this.chargementEntete.getChamobActivite().contains(":")) {
         String[] var1 = null;
         if (!this.chargementEntete.getChamobActivite().contains("#")) {
            var1 = this.chargementEntete.getChamobActivite().split(":");
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
            String[] var2 = this.chargementEntete.getChamobActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.chargementEntete.getChamobTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.chargementEntete.getChamobTotHt() - this.totalImputation;
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
      this.chargementEntete = new ChargementEntete();
      this.chargementLigne = new ChargementLigne();
      this.chargementEntete.setUsers(this.usersLog);
      this.chargementEntete.setChamobUserCreat(this.usersLog.getUsrid());
      this.chargementEntete.setChamobNomUserCreat(this.usersLog.getUsrPatronyme());
      this.chargementEntete.setChamobDate(new Date());
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

      if (this.optionsVentes.getResponsable().equals("0")) {
      }

      if (this.usersLog.getUsrCommVentes() == 2) {
         this.chargementEntete.setChamobIdResponsable(this.usersLog.getUsrid());
         this.chargementEntete.setChamobNomResponsable(this.usersLog.getUsrPatronyme());
         this.var_nom_responsable = this.usersLog.getUsrid();
         this.chargementEntete.setChamobIdCommercial(0L);
         this.chargementEntete.setChamobNomCommercial("");
         this.var_nom_commercial = 0L;
      } else {
         this.chargementEntete.setChamobIdResponsable(this.usersLog.getUsrid());
         this.chargementEntete.setChamobNomResponsable(this.usersLog.getUsrPatronyme());
         this.var_nom_responsable = this.usersLog.getUsrid();
         this.chargementEntete.setChamobIdCommercial(0L);
         this.chargementEntete.setChamobNomCommercial("");
         this.var_nom_commercial = 0L;
      }

      this.lesLignesList.clear();
      this.listFacture.clear();
      this.listAvoir.clear();
      this.listNoteDebit.clear();
      this.listDechargement.clear();
      this.listAjoutProduit.clear();
      this.datamodelLigne.setWrappedData(this.lesLignesList);
      this.datamodelFacture.setWrappedData(this.listFacture);
      this.datamodelAvoir.setWrappedData(this.listAvoir);
      this.dataModelNoteDebit.setWrappedData(this.listNoteDebit);
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.affichageDepot = false;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_valide_chg = false;
      this.var_valide_rcg = false;
      this.var_valide_fac = false;
      this.var_aff_detail_tiers = false;
      this.var_depot = "0";
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      this.var_total_marge = 0.0D;
      if (this.var_tc_type == 7) {
         this.var_tc_calcul = true;
      } else {
         this.var_tc_calcul = false;
      }

      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.autorisationDocument();
      this.addLigne();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.chargementEntete != null) {
         this.var_nom_responsable = this.chargementEntete.getChamobIdResponsable();
         this.var_nom_commercial = this.chargementEntete.getChamobIdCommercial();
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         if (this.var_date.equals(new Date())) {
            this.var_valide_chg = true;
         } else {
            this.var_valide_chg = false;
         }

         if (this.chargementEntete.getChamobDepotCharg() != null && !this.chargementEntete.getChamobDepotCharg().isEmpty()) {
            this.affichageDepot = true;
         } else {
            this.affichageDepot = false;
         }

         this.var_valide_rcg = true;
         this.var_valide_fac = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.chargementEntete != null) {
         this.var_nom_responsable = this.chargementEntete.getChamobIdResponsable();
         this.var_nom_commercial = this.chargementEntete.getChamobIdCommercial();
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.affichageDepot = true;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = false;
         this.var_valide_chg = false;
         this.var_valide_rcg = false;
         this.var_valide_fac = false;
         this.var_aff_detail_tiers = true;
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.chargementEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.chargementEntete.getChamobEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.chargementEntete.setChamobEtat(1);
               this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
               int var3;
               float var4;
               if (this.lesLignesList.size() != 0) {
                  for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
                     this.chargementLigne = (ChargementLigne)this.lesLignesList.get(var3);
                     if (this.chargementLigne.getChaligQteCharg() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                        if (this.produitsDepot != null) {
                           var4 = this.produitsDepot.getProdepQteStk() - this.chargementLigne.getChaligQteCharg();
                           this.produitsDepot.setProdepQteStk(var4);
                           this.produitsDepotDao.modif(this.produitsDepot, var1);
                        }
                     }
                  }
               }

               if (this.lesRechargementsList.size() != 0) {
                  for(var3 = 0; var3 < this.lesRechargementsList.size(); ++var3) {
                     this.chargementLigne = (ChargementLigne)this.lesRechargementsList.get(var3);
                     if (this.chargementLigne.getChaligQteCharg() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                        if (this.produitsDepot != null) {
                           var4 = this.produitsDepot.getProdepQteStk() - this.chargementLigne.getChaligQteCharg();
                           this.produitsDepot.setProdepQteStk(var4);
                           this.produitsDepotDao.modif(this.produitsDepot, var1);
                        }
                     }
                  }
               }

               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Validation manuelle chargement (C.) N° " + this.chargementEntete.getChamobNum() + " du " + this.utilDate.dateToStringSQLLight(this.chargementEntete.getChamobDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.chargementEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.chargementEntete.getChamobEtat() == 1) {
               this.chargementEntete.setChamobEtat(0);
               this.chargementEntete.setChamobDateImp((Date)null);
               this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
               int var3;
               float var4;
               if (this.lesLignesList.size() != 0) {
                  for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
                     this.chargementLigne = (ChargementLigne)this.lesLignesList.get(var3);
                     if (this.chargementLigne.getChaligQteCharg() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                        if (this.produitsDepot != null) {
                           var4 = this.produitsDepot.getProdepQteStk() + this.chargementLigne.getChaligQteCharg();
                           this.produitsDepot.setProdepQteStk(var4);
                           this.produitsDepotDao.modif(this.produitsDepot, var1);
                        }
                     }
                  }
               }

               if (this.lesRechargementsList.size() != 0) {
                  for(var3 = 0; var3 < this.lesRechargementsList.size(); ++var3) {
                     this.chargementLigne = (ChargementLigne)this.lesRechargementsList.get(var3);
                     if (this.chargementLigne.getChaligQteCharg() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                        if (this.produitsDepot != null) {
                           var4 = this.produitsDepot.getProdepQteStk() + this.chargementLigne.getChaligQteCharg();
                           this.produitsDepot.setProdepQteStk(var4);
                           this.produitsDepotDao.modif(this.produitsDepot, var1);
                        }
                     }
                  }
               }

               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Dévalidation manuelle chargement (C.) N° " + this.chargementEntete.getChamobNum() + " du " + this.utilDate.dateToStringSQLLight(this.chargementEntete.getChamobDate()));
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

   public void valideDechargement() throws HibernateException, NamingException, ParseException {
      if (this.chargementEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigneDechargement");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.chargementEntete.getChamobEtat() == 1) {
               this.chargementEntete.setChamobEtat(4);
               this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
               this.calculeDechargement(var1);
               if (this.listDechargement.size() != 0) {
                  for(int var3 = 0; var3 < this.listDechargement.size(); ++var3) {
                     this.chargementLigne = (ChargementLigne)this.listDechargement.get(var3);
                     if (this.chargementLigne.getChaligQteRetour() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                        if (this.produitsDepot != null) {
                           float var4 = this.produitsDepot.getProdepQteStk() + this.chargementLigne.getChaligQteRetour();
                           this.produitsDepot.setProdepQteStk(var4);
                           this.produitsDepotDao.modif(this.produitsDepot, var1);
                        }
                     }
                  }

                  boolean var11 = false;

                  for(int var12 = 0; var12 < this.listDechargement.size(); ++var12) {
                     this.chargementLigne = (ChargementLigne)this.listDechargement.get(var12);
                     if (this.chargementLigne.getChaligQteEcart() > 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty() && this.chargementLigne.getChaligRechargement() <= 1) {
                        var11 = true;
                        break;
                     }
                  }

                  if (var11) {
                     this.majNoteDebit(var1);
                  }
               }

               if (this.listFrais.size() != 0) {
                  double var13 = 0.0D;

                  for(int var5 = 0; var5 < this.listFrais.size(); ++var5) {
                     var13 += ((ChargementFrais)this.listFrais.get(var5)).getChafraMontant();
                  }

                  if (var13 != 0.0D) {
                     String var14 = this.calculChrono.numCompose(new Date(), 29, this.chargementEntete.getChamobSerie(), var1);
                     this.bonEncaissementVente = new BonEncaissementVente();
                     this.bonEncaissementVente.setBonDateCreat(new Date());
                     this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonActivite(this.chargementEntete.getChamobActivite());
                     this.bonEncaissementVente.setBonSite(this.chargementEntete.getChamobSite());
                     this.bonEncaissementVente.setBonDepartement(this.chargementEntete.getChamobDepartement());
                     this.bonEncaissementVente.setBonService(this.chargementEntete.getChamobService());
                     this.bonEncaissementVente.setBonRegion((String)null);
                     this.bonEncaissementVente.setBonSecteur((String)null);
                     this.bonEncaissementVente.setBonPdv((String)null);
                     this.bonEncaissementVente.setBonDateEcheReg(this.chargementEntete.getChamobDate());
                     this.bonEncaissementVente.setBonEtat(0);
                     this.bonEncaissementVente.setBonNatRef(28);
                     this.bonEncaissementVente.setBonNomResponsable(this.chargementEntete.getChamobNomResponsable());
                     this.bonEncaissementVente.setBonNomTiers(this.chargementEntete.getChamobNomCommercial());
                     this.bonEncaissementVente.setBonNomCommercial(this.chargementEntete.getChamobNomCommercial());
                     this.bonEncaissementVente.setBonIdCommercial(this.chargementEntete.getChamobIdCommercial());
                     this.bonEncaissementVente.setBonIdTiers(this.chargementEntete.getChamobIdCommercial());
                     this.bonEncaissementVente.setBonNomContact((String)null);
                     this.bonEncaissementVente.setBonIdContact(0L);
                     this.bonEncaissementVente.setBonTypeTiers(6);
                     this.bonEncaissementVente.setBonLibelle("Règlement frais N° " + this.chargementEntete.getChamobNum());
                     this.bonEncaissementVente.setBonRef(this.chargementEntete.getChamobNum());
                     this.bonEncaissementVente.setBonIdRef(this.chargementEntete.getChamobId());
                     this.bonEncaissementVente.setBonChg(this.chargementEntete.getChamobNum());
                     this.bonEncaissementVente.setBonIdChg(this.chargementEntete.getChamobId());
                     this.bonEncaissementVente.setBonObject(this.chargementEntete.getChamobObjet());
                     this.bonEncaissementVente.setBonObservation(this.chargementEntete.getChamobObservation());
                     this.bonEncaissementVente.setBonSerie(this.chargementEntete.getChamobSerie());
                     this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                     this.bonEncaissementVente.setBonTotTtc(var13);
                     this.bonEncaissementVente.setBonAPayer(var13);
                     this.bonEncaissementVente.setBonTypeReg(0);
                     this.bonEncaissementVente.setBonActif(0);
                     this.bonEncaissementVente.setBonNum(var14);
                     this.bonEncaissementVente.setBonDate(new Date());
                     this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
                  }
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

         this.chargerDocumentTrace((Session)null);
      }

   }

   public void deValideDechargement() throws HibernateException, NamingException {
      if (this.chargementEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigneDechargement");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.chargementEntete.getChamobEtat() == 4) {
               this.chargementEntete.setChamobEtat(1);
               this.chargementEntete.setChamobDateImp((Date)null);
               this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
               this.calculeDechargement(var1);
               if (this.listDechargement.size() != 0) {
                  int var3;
                  for(var3 = 0; var3 < this.listDechargement.size(); ++var3) {
                     this.chargementLigne = (ChargementLigne)this.listDechargement.get(var3);
                     if (this.chargementLigne.getChaligQteRetour() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                        if (this.produitsDepot != null) {
                           float var4 = this.produitsDepot.getProdepQteStk() - this.chargementLigne.getChaligQteRetour();
                           this.produitsDepot.setProdepQteStk(var4);
                           this.produitsDepotDao.modif(this.produitsDepot, var1);
                        }
                     }
                  }

                  if (this.listNoteDebit.size() != 0) {
                     for(var3 = 0; var3 < this.listNoteDebit.size(); ++var3) {
                        this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)this.listNoteDebit.get(var3);
                        long var15 = this.noteDebitEnteteVentes.getNdbId();
                        this.noteDebitLigneVentesDao.deleteAllLigne(this.noteDebitEnteteVentes, var1);
                        this.noteDebitEnteteVentesDao.delete(this.noteDebitEnteteVentes.getNdbId(), var1);
                        new ArrayList();
                        new DocumentTraceVentes();
                        List var6 = this.documentTraceVentesDao.chercherDestinationTraceListe(var15, 27, var1);
                        if (var6.size() != 0) {
                           for(int var8 = 0; var8 < var6.size(); ++var8) {
                              DocumentTraceVentes var7 = (DocumentTraceVentes)var6.get(var8);
                              if (var7 != null && var7.getDoctraDstType() == 27) {
                                 this.documentTraceVentesDao.delete(var7, var1);
                              }
                           }
                        }
                     }
                  }
               }

               new ArrayList();
               List var14 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.chargementEntete.getChamobId(), 28, var1);
               if (var14.size() != 0) {
                  for(int var16 = 0; var16 < var14.size(); ++var16) {
                     this.bonEncaissementVente = (BonEncaissementVente)var14.get(var16);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentTrace((Session)null);
      }

   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.chargementEntete != null) {
         this.chargementEntete.setChamobEtat(0);
         this.chargementEntete.setChamobDateAnnule((Date)null);
         this.chargementEntete.setChamobMotifAnnule("");
         this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.chargementEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigneDechargement");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.chargementEntete);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.chargementEntete.getChamobId();
            String var5 = this.chargementEntete.getChamobNum();
            Date var6 = this.chargementEntete.getChamobDate();
            this.calculeDechargement(var1);
            int var7;
            if (this.listDechargement.size() != 0) {
               for(var7 = 0; var7 < this.listDechargement.size(); ++var7) {
                  this.chargementLigne = new ChargementLigne();
                  this.chargementLigne = (ChargementLigne)this.listDechargement.get(var7);
                  if (this.chargementLigne.getChaligQteCharg() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var1);
                     if (this.produitsDepot != null) {
                        float var8 = this.produitsDepot.getProdepQteStk() + this.chargementLigne.getChaligQteCharg();
                        this.produitsDepot.setProdepQteStk(var8);
                        this.produitsDepotDao.modif(this.produitsDepot, var1);
                     }
                  }
               }
            }

            this.chargementLigneDao.deleteAllLigne(this.lesLignesList, var1);
            this.chargementLigneDao.deleteAllLigne(this.lesRechargementsList, var1);
            this.chargementFraisDao.deleteAllLigne(this.listFrais, var1);
            this.utilParapheur.supprimerParapheur(this.chargementEntete.getChamobId(), this.nature, var1);
            this.chargementEnteteDao.delete(this.chargementEntete, var1);
            if (this.listFacture.size() != 0) {
               for(var7 = 0; var7 < this.listFacture.size(); ++var7) {
                  this.factureEnteteVentes = (FactureEnteteVentes)this.listFacture.get(var7);
                  this.factureLigneVentesDao.deleteAllLigne(this.factureEnteteVentes, var1);
                  new ArrayList();
                  List var19 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureEnteteVentes.getFacId(), 25, var1);
                  if (var19.size() != 0) {
                     for(int var9 = 0; var9 < var19.size(); ++var9) {
                        this.bonEncaissementVente = (BonEncaissementVente)var19.get(var9);
                        this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
                     }
                  }

                  this.factureEnteteVentesDao.delete(this.factureEnteteVentes, var1);
               }
            }

            if (this.listAvoir.size() != 0) {
               for(var7 = 0; var7 < this.listAvoir.size(); ++var7) {
                  this.avoirEnteteVentes = (AvoirEnteteVentes)this.listAvoir.get(var7);
                  this.avoirLigneVentesDao.deleteAllLigne(this.avoirEnteteVentes, var1);
                  this.avoirEnteteVentesDao.delete(this.avoirEnteteVentes.getAvrId(), var1);
               }
            }

            if (this.listNoteDebit.size() != 0) {
               this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();

               for(var7 = 0; var7 < this.listNoteDebit.size(); ++var7) {
                  this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)this.listNoteDebit.get(var7);
                  this.noteDebitLigneVentesDao.deleteAllLigne(this.noteDebitEnteteVentes, var1);
                  this.noteDebitEnteteVentesDao.delete(this.noteDebitEnteteVentes.getNdbId(), var1);
               }
            }

            new DocumentTraceVentes();
            DocumentTraceVentes var22 = this.documentTraceVentesDao.chercherDestinationTrace(var3, this.nature, var1);
            if (var22 != null) {
               long var20 = var22.getDoctraOrgId();
               int var10 = var22.getDoctraOrgType();
               this.documentTraceVentesDao.delete(var22, var1);
               boolean var11 = false;
               var22 = this.documentTraceVentesDao.chercherOrigineTrace(var20, var10, var1);
               byte var23;
               if (var22 != null) {
                  var23 = 4;
               } else {
                  var23 = 1;
               }

               if (var10 == 20) {
                  new BesoinEnteteVentes();
                  BesoinEnteteVentesDao var13 = new BesoinEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  BesoinEnteteVentes var12 = var13.pourParapheur(var20, var1);
                  if (var12 != null) {
                     var12.setBesEtat(var23);
                     if (var23 == 1) {
                        var12.setBesDateTransforme((Date)null);
                        var12.setBesTypeTransforme(0);
                     }

                     var13.modif(var12, var1);
                  }
               } else if (var10 == 22) {
                  new CommandeEnteteVentes();
                  CommandeEnteteVentesDao var25 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  CommandeEnteteVentes var24 = var25.pourParapheur(var20, var1);
                  if (var24 != null) {
                     var24.setBcmEtat(var23);
                     if (var23 == 1) {
                        var24.setBcmDateTransforme((Date)null);
                        var24.setBcmTypeTransforme(0);
                     }

                     var25.modif(var24, var1);
                  }
               }
            }

            Espion var21 = new Espion();
            var21.setUsers(this.usersLog);
            var21.setEsptype(0);
            var21.setEspdtecreat(new Date());
            var21.setEspaction("Suppression Chargement N° " + var5 + " du " + var6);
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
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void preSave() throws IOException, HibernateException, NamingException, Exception {
      if (this.chargementEntete.getChamobId() != 0L) {
         this.showModalPanelValidationDocument = true;
      } else {
         this.save();
      }

   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.chargementEntete.setChamobDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.chargementEntete.getUsers() == null) {
            this.chargementEntete.setUsers(this.usersLog);
         }

         if (this.var_depot != null && this.var_depot.contains(":")) {
            String[] var3 = this.var_depot.split(":");
            this.chargementEntete.setChamobDepotCharg(var3[0]);
         } else {
            this.chargementEntete.setChamobDepotCharg("");
         }

         this.chargementEntete.setChamobIdResponsable(0L);
         this.chargementEntete.setChamobNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.chargementEntete.setChamobIdResponsable(var15.getUsrid());
            this.chargementEntete.setChamobNomResponsable(var15.getUsrPatronyme());
         }

         this.chargementEntete.setChamobIdCommercial(0L);
         this.chargementEntete.setChamobNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.chargementEntete.setChamobIdCommercial(var4.getUsrid());
               this.chargementEntete.setChamobNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.chargementEntete.setChamobIdEquipe(0L);
         this.chargementEntete.setChamobNomEquipe("");
         if (this.chargementEntete.getChamobId() != 0L) {
            this.chargementEntete.setChamobDateModif(new Date());
            this.chargementEntete.setChamobUserModif(this.usersLog.getUsrid());
            this.chargementEntete.setChamobNomUserModif(this.usersLog.getUsrPatronyme());
            this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;
         } else {
            this.chargementEntete.setExercicesVentes(this.exercicesVentes);
            this.chargementEntete.setUsers(this.usersLog);
            this.chargementEntete.setChamobDateCreat(new Date());
            this.chargementEntete.setChamobUserCreat(this.usersLog.getUsrid());
            this.chargementEntete.setChamobNomUserCreat(this.usersLog.getUsrPatronyme());
            if (this.chargementEntete.getChamobSerie() != null && !this.chargementEntete.getChamobSerie().equalsIgnoreCase("X") && !this.chargementEntete.getChamobSerie().isEmpty()) {
               this.chargementEntete.setChamobNum(this.calculChrono.numCompose(this.chargementEntete.getChamobDate(), this.nature, this.chargementEntete.getChamobSerie(), var1));
               boolean var17 = false;

               label230:
               while(true) {
                  while(true) {
                     if (var17) {
                        break label230;
                     }

                     new ChargementEntete();
                     ChargementEntete var5 = this.chargementEnteteDao.pourChargement(this.chargementEntete.getChamobNum(), this.chargementEntete.getChamobSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.chargementEntete.setChamobNum(this.calculChrono.numCompose(this.chargementEntete.getChamobDate(), this.nature, this.chargementEntete.getChamobSerie(), var1));
                        var17 = false;
                     } else {
                        var17 = true;
                     }
                  }
               }
            } else {
               long var16 = this.chargementEnteteDao.selectLastNum(var1);
               this.chargementEntete.setChamobNum("" + var16);
            }

            this.chargementEntete.setChamobEtat(0);
            this.chargementEntete.setChamobEtatVal(0);
            this.chargementEntete = this.chargementEnteteDao.insert(this.chargementEntete, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.chargementEntete);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.listDechargement.size() != 0) {
            for(int var18 = 0; var18 < this.listDechargement.size(); ++var18) {
               this.chargementLigne = new ChargementLigne();
               this.chargementLigne = (ChargementLigne)this.listDechargement.get(var18);
               this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var1);
            }
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.chargementEntete.getChamobId(), this.chargementEntete.getChamobNum(), this.chargementEntete.getChamobNomResponsable(), this.chargementEntete.getChamobDate(), this.structureLog.getStrdevise(), this.chargementEntete.getChamobTotTtc() + this.chargementEntete.getChamobTotTc(), this.chargementEntete.getChamobModeleImp(), this.tiers, this.calculeCheminRapport(0, this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), 0, 0, var1);
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
      this.chargementEntete.setChamobSite(this.usersLog.getUsrSite());
      this.chargementEntete.setChamobDepartement(this.usersLog.getUsrDepartement());
      this.chargementEntete.setChamobService(this.usersLog.getUsrService());
      if (!this.var_anal_activite) {
         this.chargementEntete.setChamobActivite("");
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

               this.chargementEntete.setChamobActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new ChargementLigne();
            new Produits();
            if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
               ArrayList var6 = new ArrayList();
               ObjetTarif var7 = new ObjetTarif();
               int var8 = 0;

               label118:
               while(true) {
                  if (var8 >= this.lesLignesList.size()) {
                     var8 = 0;

                     while(true) {
                        if (var8 >= var6.size()) {
                           break label118;
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

                  ChargementLigne var13 = (ChargementLigne)this.lesLignesList.get(var8);
                  if (var13.getChaligCode() != null && !var13.getChaligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getChaligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getChaligPt());
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
                              var7.setPrix(var13.getChaligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getChaligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.chargementEntete.setChamobActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.chargementEntete.setChamobAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.chargementEntete.getChamobAnal4() != null && this.chargementEntete.getChamobAnal4().length() <= 2) {
         this.chargementEntete.setChamobAnal4("");
      }

      if (!this.var_anal_parc) {
         this.chargementEntete.setChamobAnal2("");
      } else if (this.chargementEntete.getChamobAnal2() != null && this.chargementEntete.getChamobAnal2().length() <= 2) {
         this.chargementEntete.setChamobAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.chargementEntete.setChamobEtatVal(1);
         this.chargementEntete.setChamobEtat(0);
         return true;
      } else {
         this.chargementEntete.setChamobEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.chargementEntete.setChamobEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3 && this.chargementEntete.getChamobEtat() == 0) {
               this.chargementEntete.setChamobEtat(0);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.chargementEntete != null) {
         this.chargementEntete.setChamobDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.chargementEntete != null) {
         if (this.chargementEntete.getChamobDateAnnule() == null) {
            this.chargementEntete.setChamobDateAnnule(new Date());
         }

         this.chargementEntete.setChamobEtat(3);
         this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation chargement vente N° " + this.chargementEntete.getChamobNum() + " le " + this.chargementEntete.getChamobDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.chargementEntete);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void afficheValide() {
      if (this.var_depot != null && !this.var_depot.isEmpty() && this.var_nom_commercial != 0L) {
         this.var_valide_chg = true;
         this.var_valide_doc = true;
      } else {
         this.var_valide_chg = false;
         this.var_valide_doc = false;
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      TaxesVentes var8;
      int var35;
      if (var1 != null && !var1.isEmpty()) {
         new TaxesVentes();
         var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
         if (var8 != null) {
            var5 = var8.getTaxvteTaux();
            var6 = var8.getTaxvteCode();
            var35 = var8.getTaxvteType();
         } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
            if (var9 != null) {
               var5 = var9.getTaxvteTaux();
               var6 = var9.getTaxvteCode();
               var35 = var9.getTaxvteType();
            } else {
               var5 = var2;
               var6 = var1;
               var35 = 0;
            }
         } else {
            var5 = var2;
            var6 = var1;
            var35 = 0;
         }
      } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
         new TaxesVentes();
         var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
         if (var8 != null) {
            var5 = var8.getTaxvteTaux();
            var6 = var8.getTaxvteCode();
            var35 = var8.getTaxvteType();
         } else {
            var5 = var2;
            var6 = var1;
            var35 = 0;
         }
      } else {
         var5 = var2;
         var6 = var1;
         var35 = 0;
      }

      this.chargementLigne.setChaligTaxe(var6);
      this.chargementLigne.setChaligTauxTaxe(var5);
      double var36 = this.chargementLigne.getChaligPu();
      float var10;
      if (var35 == 3) {
         var10 = 100.0F - var5;
         var36 = this.utilNombre.myRoundDevise(var36 / (double)var10 * 100.0D, this.structureLog.getStrdevise());
      }

      var10 = this.chargementLigne.getChaligQteCharg();
      if (this.chargementLigne.getChaligQteCharg() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.chargementLigne.setChaligQteUtil(this.chargementLigne.getChaligQteCharg());
            var10 = this.chargementLigne.getChaligQteCharg() * this.chargementLigne.getChaligLong();
         } else {
            this.chargementLigne.setChaligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.chargementLigne.getChaligCondition(), this.chargementLigne.getChaligQteCharg(), this.chargementLigne.getChaligLong(), this.chargementLigne.getChaligLarg(), this.chargementLigne.getChaligHaut(), this.chargementLigne.getChaligDiam(), this.chargementLigne.getChaligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.chargementLigne.setChaligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
         var11 = var36 * (double)var10;
      } else {
         var11 = var36 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.chargementLigne.getChaligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.chargementLigne.getChaligRabais() * (double)this.chargementLigne.getChaligQteCharg();
      }

      if (this.chargementLigne.getChaligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.chargementLigne.getChaligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.chargementLigne.getChaligTauxTaxe() / 100.0D;
      if (var35 == 2) {
         var19 *= -1.0D;
      } else if (var35 == 3) {
         var19 = var17 * (double)(this.chargementLigne.getChaligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.chargementLigne.getChaligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.chargementLigne.getChaligQteCharg(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.chargementLigne.getChaligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.chargementLigne.getChaligQteCharg(), 2);
      }

      this.chargementLigne.setChaligPuRem(var25);
      this.chargementLigne.setChaligPt(var17);
      this.chargementLigne.setChaligTva(var21);
      this.chargementLigne.setChaligTc(0.0D);
      this.chargementLigne.setChaligTtc(var23);
      double var27 = 0.0D;
      if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.chargementLigne.getChaligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.chargementLigne.getChaligQteCharg(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.chargementLigne.getChaligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.chargementLigne.getChaligQteCharg(), 2);
      }

      this.chargementLigne.setChaligPuRemTtc(var27);
      double var29 = var36 + var36 * (double)this.chargementLigne.getChaligTauxTaxe() / 100.0D;
      this.chargementLigne.setChaligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.chargementEntete.setChamobTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.chargementLigne.setChaligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
               if (this.chargementLigne.getChaligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.chargementLigne.getChaligTauxTaxe() / 100.0D;
                  this.chargementLigne.setChaligTc(var33);
                  this.chargementLigne.setChaligTtc(this.chargementLigne.getChaligPt() + this.chargementLigne.getChaligTva() + this.chargementLigne.getChaligTc());
               }
            }
         } else {
            if (this.chargementEntete.getChamobTotTva() != 0.0D) {
               var31 = var17 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.chargementLigne.setChaligTc(var33);
            this.chargementLigne.setChaligTtc(this.chargementLigne.getChaligPt() + this.chargementLigne.getChaligTva() + this.chargementLigne.getChaligTc());
         }
      } else {
         this.chargementLigne.setChaligTc(0.0D);
         this.chargementEntete.setChamobTauxTc(0.0F);
      }

      this.chargementLigne.setChaligPt(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligPt(), this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligTva(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligTva(), this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligTtc(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligTtc(), this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligTc(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligTc(), this.structureLog.getStrdevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
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

      this.chargementLigne.setChaligTaxe(var6);
      this.chargementLigne.setChaligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.chargementEntete.getChamobTauxTc() != 0.0F) {
         var10 = this.chargementLigne.getChaligPuTtc() * (double)this.chargementLigne.getChaligQteCharg();
         var12 = var10 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.chargementLigne.getChaligQteCharg(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.chargementLigne.getChaligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.chargementLigne.setChaligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.chargementLigne.getChaligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.chargementLigne.getChaligRabais() * (double)this.chargementLigne.getChaligQteCharg();
      }

      double var14 = 0.0D;
      if (this.chargementLigne.getChaligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.chargementLigne.getChaligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.chargementLigne.getChaligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.chargementLigne.getChaligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.chargementLigne.getChaligQteCharg() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.chargementLigne.setChaligQteUtil(this.chargementLigne.getChaligQteCharg());
         } else {
            this.chargementLigne.setChaligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.chargementLigne.getChaligCondition(), this.chargementLigne.getChaligQteCharg(), this.chargementLigne.getChaligLong(), this.chargementLigne.getChaligLarg(), this.chargementLigne.getChaligHaut(), this.chargementLigne.getChaligDiam(), this.chargementLigne.getChaligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.chargementLigne.setChaligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.chargementLigne.getChaligQteCharg();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var26 = var20 * (double)this.chargementLigne.getChaligQteCharg();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligPuRem(var18);
      this.chargementLigne.setChaligPuRemTtc(var20);
      this.chargementLigne.setChaligPt(var24);
      this.chargementLigne.setChaligTva(var32);
      this.chargementLigne.setChaligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.chargementEntete.setChamobTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.chargementLigne.setChaligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
               if (this.chargementLigne.getChaligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.chargementLigne.getChaligTauxTaxe() / 100.0D;
                  this.chargementLigne.setChaligTc(var36);
                  this.chargementLigne.setChaligTtc(this.chargementLigne.getChaligPt() + this.chargementLigne.getChaligTva() + this.chargementLigne.getChaligTc());
               }
            }
         } else {
            var34 = var24 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.chargementLigne.setChaligTc(var36);
            this.chargementLigne.setChaligTtc(this.chargementLigne.getChaligPt() + this.chargementLigne.getChaligTva() + this.chargementLigne.getChaligTc());
         }
      } else {
         this.chargementLigne.setChaligTc(0.0D);
         this.chargementEntete.setChamobTauxTc(0.0F);
      }

      this.chargementLigne.setChaligPt(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligPt(), this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligTva(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligTva(), this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligTtc(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligTtc(), this.structureLog.getStrdevise()));
      this.chargementLigne.setChaligTc(this.utilNombre.myRoundDevise(this.chargementLigne.getChaligTc(), this.structureLog.getStrdevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrixRechargement() throws HibernateException, NamingException {
      this.chargementLigne = new ChargementLigne();
      this.chargementLigne = this.rechargementLigne;
      this.calculPrix();
      this.rechargementLigne = this.chargementLigne;
      this.chargementLigne = new ChargementLigne();
   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.chargementLigne != null && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.chargementLigne.getChaligPuRemTtc() != 0.0D) {
               if (this.chargementLigne.getChaligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.chargementLigne.getChaligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.chargementLigne.getChaligPuRem() != 0.0D) {
            if (this.chargementLigne.getChaligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.chargementLigne.getChaligPu() < this.prixPlancher) {
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

   public void calculPrixRechargement(String var1, float var2, Session var3) throws HibernateException, NamingException {
      this.chargementLigne = new ChargementLigne();
      this.chargementLigne = this.rechargementLigne;
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         this.calculTtc(var1, var2, var3);
      } else {
         this.calculHt(var1, var2, var3);
      }

      this.rechargementLigne = this.chargementLigne;
      this.chargementLigne = new ChargementLigne();
   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         new ChargementLigne();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            ChargementLigne var13 = (ChargementLigne)this.lesLignesList.get(var14);
            if (var13.getChaligGenerique() != 5) {
               var3 += var13.getChaligPt();
               var5 += var13.getChaligTva();
               var7 += var13.getChaligTtc();
               var9 += var13.getChaligTc();
               if (var13.getChaligRabais() != 0.0D || var13.getChaligTauxRemise() != 0.0F) {
                  var11 += var13.getChaligPu() * (double)var13.getChaligQteCharg() - var13.getChaligPt();
               }

               var1 = var1 + var13.getChaligPt() - var13.getChaligPump() * (double)var13.getChaligQteCharg();
            }
         }
      }

      if (this.lesRechargementsList.size() != 0) {
         for(int var15 = 0; var15 < this.lesRechargementsList.size(); ++var15) {
            new ChargementLigne();
            ChargementLigne var16 = (ChargementLigne)this.lesRechargementsList.get(var15);
            var3 += var16.getChaligPt();
            var5 += var16.getChaligTva();
            var7 += var16.getChaligTtc();
            var9 += var16.getChaligTc();
            if (var16.getChaligRabais() != 0.0D || var16.getChaligTauxRemise() != 0.0F) {
               var11 += var16.getChaligPu() * (double)var16.getChaligQteUtil() - var16.getChaligPt();
            }

            var1 = var1 + var16.getChaligPt() - var16.getChaligPump() * (double)var16.getChaligQteCharg();
         }
      }

      this.var_total_marge = var1;
      this.chargementEntete.setChamobTotHt(var3);
      this.chargementEntete.setChamobTotTva(var5);
      this.chargementEntete.setChamobTotTtc(var7);
      this.chargementEntete.setChamobTotRemise(var11);
      this.chargementEntete.setChamobTotTc(var9);
   }

   public void historiqueProduit() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.chargementLigne = (ChargementLigne)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;
         String var5 = this.chargementLigne.getChaligCode();
         ArrayList var6 = new ArrayList();
         if (this.chargementLigne.getChaligCode() != null) {
            int var7;
            List var9;
            int var10;
            if (this.listFacture.size() != 0) {
               for(var7 = 0; var7 < this.listFacture.size(); ++var7) {
                  new FactureEnteteVentes();
                  FactureEnteteVentes var8 = (FactureEnteteVentes)this.listFacture.get(var7);
                  if (var8 != null) {
                     new ArrayList();
                     var9 = this.factureLigneVentesDao.chargerLesLignes(var8, var1);
                     if (var9.size() != 0) {
                        for(var10 = 0; var10 < var9.size(); ++var10) {
                           new FactureLigneVentes();
                           FactureLigneVentes var11 = (FactureLigneVentes)var9.get(var10);
                           if (var11.getFacligCode().equals(var5)) {
                              if (var11.getFacligTauxRemise() == 100.0F) {
                                 var3 += var11.getFacligQte();
                              } else {
                                 var2 += var11.getFacligQte();
                              }

                              var6.add(var11);
                           }
                        }
                     }
                  }
               }
            }

            if (this.listAvoir.size() != 0) {
               for(var7 = 0; var7 < this.listAvoir.size(); ++var7) {
                  new AvoirEnteteVentes();
                  AvoirEnteteVentes var12 = (AvoirEnteteVentes)this.listAvoir.get(var7);
                  if (var12 != null) {
                     this.avoirLigneVentes = new AvoirLigneVentes();
                     new ArrayList();
                     var9 = this.avoirLigneVentesDao.chargerLesLignes(var12, var1);
                     if (var9.size() != 0) {
                        for(var10 = 0; var10 < var9.size(); ++var10) {
                           new AvoirLigneVentes();
                           AvoirLigneVentes var13 = (AvoirLigneVentes)var9.get(var10);
                           if (var13.getAvrligCode().equals(var5)) {
                              var4 += var13.getAvrligQte();
                           }
                        }
                     }
                  }
               }
            }

            this.chargementLigne.setChaligQteFacture(var2);
            this.chargementLigne.setChaligQteDon(var3);
            this.chargementLigne.setChaligQteAvoir(var4);
            this.calculeEcart();
            this.showModalPanelHistorique = true;
            this.dataModelDetailFacture.setWrappedData(var6);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void fermerHistorique() {
      this.showModalPanelHistorique = false;
   }

   public void choixLivraison() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.chargementLigne = (ChargementLigne)this.datamodelLigne.getRowData();
         if (this.chargementLigne.getChaligCode() != null && this.chargementLigne.getChaligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.chargementLigne.getChaligCode(), (Session)null);
         }
      }

      if (this.chargementLigne != null & this.produits != null) {
         if (this.chargementLigne.getChaligGenerique() == 5) {
            if (this.produits != null) {
               new ArrayList();
               List var1 = this.produitsDao.chargerLesProduitsVentesByGenerique(this.chargementLigne.getChaligCode(), (Session)null);
               if (var1.size() != 0) {
                  this.listEclatement.clear();

                  int var2;
                  for(var2 = 0; var2 < var1.size(); ++var2) {
                     new Produits();
                     Produits var3 = (Produits)var1.get(var2);
                     ChargementLigne var4 = new ChargementLigne();
                     var4.setChaligCasier(this.chargementLigne.getChaligCasier());
                     var4.setChaligCode(var3.getProCode());
                     var4.setChaligCondition(var3.getProCondition1());
                     var4.setChaligDateChargement(this.chargementLigne.getChaligDateChargement());
                     var4.setChaligDepotCharg(this.chargementLigne.getChaligDepotCharg());
                     var4.setChaligDescription(this.chargementLigne.getChaligDescription());
                     var4.setChaligDiam(var3.getProDiamExt());
                     var4.setChaligEchelle(this.chargementLigne.getChaligEchelle());
                     var4.setChaligFamille(var3.getProVteCode());
                     var4.setChaligGenerique(var3.getProMode());
                     var4.setChaligHaut(this.chargementLigne.getChaligHaut());
                     var4.setChaligLarg(this.chargementLigne.getChaligLarg());
                     var4.setChaligLibelle(var3.getProLibClient());
                     var4.setChaligLong(this.chargementLigne.getChaligLong());
                     var4.setChaligNb(this.chargementLigne.getChaligNb());
                     var4.setChaligOrdre(var2 + 9000);
                     var4.setChaligPoidsBrut(this.chargementLigne.getChaligPoidsBrut());
                     var4.setChaligPoidsNet(this.chargementLigne.getChaligPoidsNet());
                     var4.setChaligPt(this.chargementLigne.getChaligPt());
                     var4.setChaligPu(this.chargementLigne.getChaligPu());
                     var4.setChaligPuRem(this.chargementLigne.getChaligPuRem());
                     var4.setChaligPuRemTtc(this.chargementLigne.getChaligPuRemTtc());
                     var4.setChaligPuTtc(this.chargementLigne.getChaligPuTtc());
                     var4.setChaligPump(this.chargementLigne.getChaligPump());
                     var4.setChaligQteAvoir(this.chargementLigne.getChaligQteAvoir());
                     var4.setChaligQteCharg(this.chargementLigne.getChaligQteCharg());
                     var4.setChaligQteDefectueux(this.chargementLigne.getChaligQteDefectueux());
                     var4.setChaligQteDem(0.0F);
                     var4.setChaligQteDon(this.chargementLigne.getChaligQteDon());
                     var4.setChaligQteEcart(this.chargementLigne.getChaligQteEcart());
                     var4.setChaligQteFacture(this.chargementLigne.getChaligQteFacture());
                     var4.setChaligQteManquant(this.chargementLigne.getChaligQteManquant());
                     var4.setChaligQteNconforme(this.chargementLigne.getChaligQteNconforme());
                     var4.setChaligQtePerime(this.chargementLigne.getChaligQtePerime());
                     var4.setChaligQteReprise(this.chargementLigne.getChaligQteReprise());
                     var4.setChaligQteRetour(this.chargementLigne.getChaligQteRetour());
                     var4.setChaligQteUtil(this.chargementLigne.getChaligQteUtil());
                     var4.setChaligRabais(this.chargementLigne.getChaligRabais());
                     var4.setChaligRechargement(this.chargementLigne.getChaligRechargement());
                     var4.setChaligReference(this.produits.getProCode());
                     var4.setChaligStock(var3.getProStock());
                     var4.setChaligTauxRemise(this.chargementLigne.getChaligTauxRemise());
                     var4.setChaligTauxTaxe(this.chargementLigne.getChaligTauxTaxe());
                     var4.setChaligTaxe(this.chargementLigne.getChaligTaxe());
                     var4.setChaligTc(this.chargementLigne.getChaligTc());
                     var4.setChaligTtc(this.chargementLigne.getChaligTtc());
                     var4.setChaligTva(this.chargementLigne.getChaligTva());
                     var4.setChaligUnite(this.chargementLigne.getChaligUnite());
                     var4.setChaligVolume(this.chargementLigne.getChaligVolume());
                     this.listEclatement.add(var4);
                  }

                  if (this.listEclatement.size() != 0) {
                     for(var2 = 0; var2 < this.listEclatement.size(); ++var2) {
                        new ChargementLigne();
                        ChargementLigne var8 = (ChargementLigne)this.listEclatement.get(var2);
                        String var9 = var8.getChaligCode();
                        float var5 = 0.0F;

                        for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                           new ChargementLigne();
                           ChargementLigne var7 = (ChargementLigne)this.lesLignesList.get(var6);
                           if (var7.getChaligCode().equals(var9)) {
                              var5 = var7.getChaligQteCharg();
                              this.listLigneASupprimer.add(var7);
                              this.lesLignesList.remove(var7);
                              break;
                           }
                        }

                        if (var5 != 0.0F) {
                           this.listEclatement.remove(var8);
                           var8.setChaligQteCharg(var5);
                           this.listEclatement.add(var2, var8);
                        }
                     }
                  }

                  if (this.listEclatement.size() != 0) {
                     this.dataModelEclatement.setWrappedData(this.listEclatement);
                     this.showModalPanelEclatement = true;
                  }

                  this.totalEclatement();
               }
            }
         } else {
            this.showModalPanelLivraison = true;
         }
      }

   }

   public void validerLivraisonDirecte() throws HibernateException, NamingException {
      if (this.chargementLigne.getChaligQteDem() != 0.0F) {
         if (this.chargementLigne.getChaligQteCharg() > this.chargementLigne.getChaligQteDem()) {
            this.chargementLigne.setChaligQteCharg(this.chargementLigne.getChaligQteDem());
         }

         this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne);
         this.calculPrix();
         this.cumulPrix();
      }

      this.showModalPanelLivraison = false;
   }

   public void validerEclatement() throws HibernateException, NamingException {
      int var1 = this.lesLignesList.indexOf(this.chargementLigne) + 1;
      if (this.listEclatement.size() != 0) {
         for(int var2 = 0; var2 < this.listEclatement.size(); ++var2) {
            this.chargementLigne = new ChargementLigne();
            this.chargementLigne = (ChargementLigne)this.listEclatement.get(var2);
            if (this.chargementLigne.getChaligQteCharg() != 0.0F) {
               this.calculPrix();
               this.lesLignesList.add(var1 + var2, this.chargementLigne);
            }
         }

         Session var14 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         this.cumulPrix();
         Transaction var3 = null;

         try {
            var3 = var14.beginTransaction();
            int var4;
            if (this.lesLignesList.size() != 0) {
               for(var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
                  this.chargementLigne = new ChargementLigne();
                  this.chargementLigne = (ChargementLigne)this.lesLignesList.get(var4);
                  this.chargementLigne.setChaligOrdre(var4);
                  boolean var5 = false;
                  if (this.chargementLigne.getChaligId() != 0L) {
                     var5 = false;
                     this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var14);
                  } else {
                     var5 = true;
                     this.chargementLigne.setChaligRechargement(0);
                     this.chargementLigne.setChaligDepotCharg(this.chargementEntete.getChamobDepotCharg());
                     this.chargementLigne.setChaligDateChargement(this.chargementEntete.getChamobDate());
                     if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
                        ConditionnementDao var6 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
                        String[] var7 = this.chargementLigne.getChaligCondition().split(":");
                        String var8 = var6.rechercheConditionnement(var7[0], var14).getCdtDescription();
                        if (var8 != null && !var8.isEmpty()) {
                           this.chargementLigne.setChaligDescription(var8);
                        } else {
                           this.chargementLigne.setChaligDescription("");
                        }
                     } else {
                        this.chargementLigne.setChaligDescription("");
                     }

                     this.chargementLigne.setChargementEntete(this.chargementEntete);
                     this.chargementLigne = this.chargementLigneDao.insert(this.chargementLigne, var14);
                  }

                  if (var5 && this.produits != null && this.produits.getProStock() >= 1) {
                     this.calculStock.majChargementVentesVAL(this.chargementLigne, this.memo_qte, this.produits, 1, this.baseLog, var14);
                  }
               }
            }

            if (this.listLigneASupprimer.size() != 0) {
               for(var4 = 0; var4 < this.listLigneASupprimer.size(); ++var4) {
                  new ChargementLigne();
                  ChargementLigne var15 = (ChargementLigne)this.listLigneASupprimer.get(var4);
                  this.chargementLigneDao.delete(var15, var14);
               }
            }

            var3.commit();
         } catch (HibernateException var12) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.cumulPrix();
         this.datamodelLigne.setWrappedData(this.lesLignesList);
      }

      this.showModalPanelEclatement = false;
   }

   public void fermerLivriaison() {
      this.showModalPanelEclatement = false;
      this.showModalPanelLivraison = false;
   }

   public void totalEclatement() {
      this.total_eclatement = 0.0F;

      for(int var1 = 0; var1 < this.listEclatement.size(); ++var1) {
         this.total_eclatement += ((ChargementLigne)this.listEclatement.get(var1)).getChaligQteCharg();
      }

      this.total_ecart = this.chargementLigne.getChaligQteDem() - this.total_eclatement;
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.chargementLigne = new ChargementLigne();
      this.rechargementLigne = new ChargementLigne();
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.produits = null;
      this.listeLot.clear();
      this.listeSerie.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.chargementLigne = (ChargementLigne)this.datamodelLigne.getRowData();
         this.memo_qte = this.chargementLigne.getChaligQteCharg();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         if (this.chargementLigne.getChaligCode() != null && this.chargementLigne.getChaligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.chargementLigne.getChaligCode(), var1);
            if (this.produits != null) {
               this.chargementLigne.setChaligCode(this.produits.getProCode());
               this.chargementLigne.setChaligFamille(this.produits.getProVteCode());
               this.chargementLigne.setChaligStock(this.produits.getProStock());
               this.chargementLigne.setChaligLong(this.produits.getProLongueur());
               this.chargementLigne.setChaligLarg(this.produits.getProLargeur());
               this.chargementLigne.setChaligHaut(this.produits.getProEpaisseur());
               this.chargementLigne.setChaligDiam(this.produits.getProDiamExt());
               this.chargementLigne.setChaligPoidsBrut(this.produits.getProPoidsBrut());
               this.chargementLigne.setChaligPoidsNet(this.produits.getProPoidsNet());
               this.chargementLigne.setChaligVolume(this.produits.getProVolume());
               this.chargementLigne.setChaligNb(this.produits.getProNbUnite());
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
               if (this.chargementLigne.getChaligTaxe() != null && !this.chargementLigne.getChaligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTaxe() + ":" + this.chargementLigne.getChaligTauxTaxe()));
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

   public void addLigne() {
      this.produits = new Produits();
      this.chargementLigne = new ChargementLigne();
      this.rechargementLigne = new ChargementLigne();
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
      this.memo_qte = 0.0F;
      this.griserValider = false;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.chargementLigne.getChaligQteCharg() != 0.0F || this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && (this.chargementLigne.getChaligCode().equals("-") || this.chargementLigne.getChaligCode().equals("+") || this.chargementLigne.getChaligCode().equals("="))) {
         if (this.chargementEntete.getChamobId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrix(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTauxTaxe(), var1);
            if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
               ConditionnementDao var3 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.chargementLigne.getChaligCondition().split(":");
               String var5 = var3.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.chargementLigne.setChaligDescription(var5);
               } else {
                  this.chargementLigne.setChaligDescription("");
               }

               if (this.chargementLigne.getChaligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.chargementLigne.setChaligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.chargementLigne.setChaligDescription("");
            }

            this.chargementLigne.setChaligRechargement(0);
            this.chargementLigne.setChaligDepotCharg(this.chargementEntete.getChamobDepotCharg());
            if (this.chargementLigne.getChaligRechargement() == 0) {
               this.chargementLigne.setChaligDateChargement(this.chargementEntete.getChamobDate());
            }

            if (this.chargementLigne.getChaligId() == 0L) {
               this.chargementLigne.setChargementEntete(this.chargementEntete);
               this.chargementLigne = this.chargementLigneDao.insert(this.chargementLigne, var1);
               this.lesLignesList.add(this.chargementLigne);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
            } else {
               this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var1);
            }

            this.cumulPrix();
            this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
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

   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.chargementLigne.getChaligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.chargementLigne.getChaligCode();
            new ArrayList();
            List var4 = this.receptionSerieAchatsDao.selectChargementSerieByBlLig(this.chargementLigne, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  new ReceptionSerieAchats();
                  ReceptionSerieAchats var6 = (ReceptionSerieAchats)var4.get(var5);
                  var6.setRecserEtat(0);
                  var6.setRecserIdLigneChargement(0L);
                  var6.setRecserIdTiers(0L);
                  var6.setRecserNomTiers("");
                  var6.setRecserNumChargement("");
                  this.receptionSerieAchatsDao.modif(var6, var1);
               }
            }

            this.chargementLigneDao.deleteOneLigne(this.chargementLigne, var1);
            new ArrayList();
            List var12 = (List)this.datamodelLigne.getWrappedData();
            var12.remove(this.chargementLigne);
            this.datamodelLigne.setWrappedData(var12);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " du Chargement N° " + this.chargementEntete.getChamobNum() + " du " + this.chargementEntete.getChamobDate());
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

   }

   public void selectionLigneDetailRechargement() throws HibernateException, NamingException {
      this.chargementLigne = new ChargementLigne();
      this.rechargementLigne = new ChargementLigne();
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.produits = null;
      this.listeLot.clear();
      this.listeSerie.clear();
      if (this.datamodelRechargement.isRowAvailable()) {
         this.rechargementLigne = (ChargementLigne)this.datamodelRechargement.getRowData();
         this.memo_qte = this.rechargementLigne.getChaligQteCharg();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         if (this.rechargementLigne.getChaligCode() != null && this.rechargementLigne.getChaligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.rechargementLigne.getChaligCode(), var1);
            if (this.produits != null) {
               this.rechargementLigne.setChaligCode(this.produits.getProCode());
               this.rechargementLigne.setChaligFamille(this.produits.getProAchCode());
               this.rechargementLigne.setChaligStock(this.produits.getProStock());
               this.rechargementLigne.setChaligPoidsBrut(this.produits.getProPoidsBrut());
               this.rechargementLigne.setChaligPoidsNet(this.produits.getProPoidsNet());
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
               if (this.rechargementLigne.getChaligTaxe() != null && !this.rechargementLigne.getChaligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.rechargementLigne.getChaligTaxe(), this.rechargementLigne.getChaligTaxe() + ":" + this.rechargementLigne.getChaligTauxTaxe()));
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

   public void addLigneRechargement() {
      this.produits = new Produits();
      this.chargementLigne = new ChargementLigne();
      this.rechargementLigne = new ChargementLigne();
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
      this.memo_qte = 0.0F;
      this.griserValider = false;
   }

   public void saveOneLigneRechargement() throws IOException, HibernateException, NamingException, Exception {
      if (this.chargementLigne.getChaligQteCharg() != 0.0F || this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && (this.chargementLigne.getChaligCode().equals("-") || this.chargementLigne.getChaligCode().equals("+") || this.chargementLigne.getChaligCode().equals("="))) {
         if (this.chargementEntete.getChamobId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.rechargementLigne.getChaligDateChargement() == null) {
               this.rechargementLigne.setChaligDateChargement(new Date());
            }

            this.calculPrixRechargement(this.rechargementLigne.getChaligTaxe(), this.rechargementLigne.getChaligTauxTaxe(), var1);
            if (this.rechargementLigne.getChaligCondition() != null && !this.rechargementLigne.getChaligCondition().isEmpty() && this.rechargementLigne.getChaligCondition().contains(":")) {
               ConditionnementDao var3 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.rechargementLigne.getChaligCondition().split(":");
               String var5 = var3.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.rechargementLigne.setChaligDescription(var5);
               } else {
                  this.rechargementLigne.setChaligDescription("");
               }
            } else {
               this.rechargementLigne.setChaligDescription("");
            }

            this.rechargementLigne.setChaligRechargement(1);
            this.rechargementLigne.setChaligDepotCharg(this.chargementEntete.getChamobDepotCharg());
            if (this.rechargementLigne.getChaligRechargement() == 0) {
               this.rechargementLigne.setChaligDateChargement(this.chargementEntete.getChamobDate());
            }

            if (this.rechargementLigne.getChaligId() == 0L) {
               this.rechargementLigne.setChargementEntete(this.chargementEntete);
               this.rechargementLigne = this.chargementLigneDao.insert(this.rechargementLigne, var1);
               this.lesRechargementsList.add(this.rechargementLigne);
               this.datamodelRechargement.setWrappedData(this.lesRechargementsList);
            } else {
               this.rechargementLigne = this.chargementLigneDao.modif(this.rechargementLigne, var1);
            }

            this.cumulPrix();
            this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
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

   }

   public void deleteLigneSelectRechargement() throws HibernateException, NamingException {
      if (this.rechargementLigne.getChaligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.rechargementLigne.getChaligCode();
            new ArrayList();
            List var4 = this.receptionSerieAchatsDao.selectChargementSerieByBlLig(this.rechargementLigne, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  new ReceptionSerieAchats();
                  ReceptionSerieAchats var6 = (ReceptionSerieAchats)var4.get(var5);
                  var6.setRecserEtat(0);
                  var6.setRecserIdLigneChargement(0L);
                  var6.setRecserIdTiers(0L);
                  var6.setRecserNomTiers("");
                  var6.setRecserNumChargement("");
                  this.receptionSerieAchatsDao.modif(var6, var1);
               }
            }

            this.chargementLigneDao.deleteOneLigne(this.rechargementLigne, var1);
            new ArrayList();
            List var12 = (List)this.datamodelRechargement.getWrappedData();
            var12.remove(this.rechargementLigne);
            this.datamodelRechargement.setWrappedData(var12);
            this.addLigneRechargement();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " du rechargement N° " + this.chargementEntete.getChamobNum() + " du " + this.chargementEntete.getChamobDate());
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

   }

   public void ouvertureSerie() throws HibernateException, NamingException {
   }

   public void typeSerie() throws HibernateException, NamingException {
   }

   public void chargerSerieByCarton() throws HibernateException, NamingException {
   }

   public void chargerSerieByPalette() throws HibernateException, NamingException {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         boolean var3 = false;
         int var4 = 0;

         while(true) {
            if (var4 >= this.listeSerie.size()) {
               this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var1);
               this.cumulPrix();
               this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
               var2.commit();
               break;
            }

            this.receptionSerieAchats = new ReceptionSerieAchats();
            this.receptionSerieAchats = (ReceptionSerieAchats)this.listeSerie.get(var4);
            this.receptionSerieAchats = this.receptionSerieAchatsDao.modif(this.receptionSerieAchats, var1);
            ++var4;
         }
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
   }

   public void selectionLot() {
      this.var_validation_lot = false;
      if (this.dataModelLot.isRowAvailable()) {
         this.receptionLotAchats = (ReceptionLotAchats)this.dataModelLot.getRowData();
      }

   }

   public void validationLot() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
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

   public void ajouterFacture() throws HibernateException, NamingException {
      this.avoirEnteteVentes = null;
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.factureLigneVentes = new FactureLigneVentes();
      this.factureEnteteVentes.setUsers(this.usersLog);
      this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
      this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.factureEnteteVentes.setFacIdResponsable(this.usersLog.getUsrid());
      this.factureEnteteVentes.setFacNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.factureEnteteVentes.setFacDate(new Date());
      this.var_date_doc = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure_doc = "0" + (new Date()).getHours();
      } else {
         this.var_heure_doc = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute_doc = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute_doc = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde_doc = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde_doc = "" + (new Date()).getSeconds();
      }

      boolean var1 = false;
      int var13;
      if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
         var13 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
      } else {
         var13 = 0;
      }

      boolean var2 = false;
      int var14;
      if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
         var14 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
      } else {
         var14 = 0;
      }

      this.factureEnteteVentes.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var13));
      this.factureEnteteVentes.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var14));
      this.factureEnteteVentes.setFacDateLivraison((Date)null);
      this.factureEnteteVentes.setFacBanque(this.structureLog.getStrBanqueDefaut());
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.var_aff_detail_tiers = false;
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.var_total_marge = 0.0D;
      this.tiers = new Tiers();
      this.lesProduitsDispo.clear();
      ArrayList var3 = new ArrayList();

      int var4;
      for(var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
         if (((ChargementLigne)this.lesLignesList.get(var4)).getChaligGenerique() != 5) {
            var3.add(this.lesLignesList.get(var4));
         }
      }

      for(var4 = 0; var4 < this.lesRechargementsList.size(); ++var4) {
         if (((ChargementLigne)this.lesRechargementsList.get(var4)).getChaligGenerique() != 5) {
            var3.add(this.lesRechargementsList.get(var4));
         }
      }

      if (var3.size() != 0) {
         Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            this.chargementLigne = new ChargementLigne();
            this.chargementLigne = (ChargementLigne)var3.get(var5);
            float var6 = this.chargementLigne.getChaligQteCharg();
            String var7 = this.chargementLigne.getChaligCode();
            if (this.chargementLigne.getChaligCode() != null && this.listFacture.size() != 0) {
               new FactureEnteteVentes();

               for(int var9 = 0; var9 < this.listFacture.size(); ++var9) {
                  FactureEnteteVentes var8 = (FactureEnteteVentes)this.listFacture.get(var9);
                  this.factureLigneVentes = new FactureLigneVentes();
                  new ArrayList();
                  List var10 = this.factureLigneVentesDao.chargerLesLignes(var8, var15);
                  if (var10.size() != 0) {
                     new FactureLigneVentes();

                     for(int var12 = 0; var12 < var10.size(); ++var12) {
                        FactureLigneVentes var11 = (FactureLigneVentes)var10.get(var12);
                        if (var11.getFacligCode().equals(var7)) {
                           var6 -= var11.getFacligQte();
                        }
                     }
                  }
               }
            }

            Stock var16 = new Stock();
            var16.setStk_code_produit(this.chargementLigne.getChaligCode());
            var16.setStkLibelle(this.chargementLigne.getChaligLibelle());
            var16.setStkFamille(this.chargementLigne.getChaligFamille());
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               var16.setStk_pv(this.chargementLigne.getChaligPuTtc());
            } else {
               var16.setStk_pv(this.chargementLigne.getChaligPu());
            }

            var16.setStk_qte_in(var6);
            var16.setStk_qte_attCmdAch(0.0F);
            var16.setStk_qte_attCmdVte(0.0F);
            var16.setStk_qte_attRecAch(0.0F);
            this.lesProduitsDispo.add(var16);
         }

         this.datamodelDispo.setWrappedData(this.lesProduitsDispo);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelFacturation = true;
   }

   public void selectionnerFacture() throws HibernateException, NamingException {
      if (this.datamodelFacture.isRowAvailable()) {
         this.factureEnteteVentes = (FactureEnteteVentes)this.datamodelFacture.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         this.chargerBonEncaissement(var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void modifierFacture() {
      if (this.factureEnteteVentes != null) {
      }

   }

   public void supprimerFacture() throws HibernateException, NamingException {
      if (this.factureEnteteVentes != null) {
         if (this.factureEnteteVentes.getFacTotReglement() == 0.0D) {
            long var1 = this.factureEnteteVentes.getFacId();
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEntete");
            Transaction var4 = null;

            try {
               var4 = var3.beginTransaction();
               new ArrayList();
               List var5 = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var3);
               if (var5.size() != 0) {
                  this.factureLigneVentesDao.deleteAllLigne(this.factureEnteteVentes, var3);
                  this.factureEnteteVentesDao.delete(this.factureEnteteVentes, var3);
                  this.listFacture.remove(this.factureEnteteVentes);
                  new ArrayList();
                  List var6 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureEnteteVentes.getFacId(), 25, var3);
                  if (var6.size() != 0) {
                     for(int var7 = 0; var7 < var6.size(); ++var7) {
                        this.bonEncaissementVente = (BonEncaissementVente)var6.get(var7);
                        this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var3);
                     }
                  }

                  new ArrayList();
                  new DocumentTraceVentes();
                  List var15 = this.documentTraceVentesDao.chercherDestinationTraceListe(var1, 25, var3);
                  if (var15.size() != 0) {
                     for(int var9 = 0; var9 < var15.size(); ++var9) {
                        DocumentTraceVentes var8 = (DocumentTraceVentes)var15.get(var9);
                        if (var8 != null && var8.getDoctraDstType() == 25) {
                           this.documentTraceVentesDao.delete(var8, var3);
                        }
                     }
                  }
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
         }

         this.chargerDocumentTrace((Session)null);
         this.factureEnteteVentes = new FactureEnteteVentes();
      }

   }

   public void validerFacture() throws HibernateException, NamingException, ParseException {
      if (this.lesProduitsDispo.size() != 0) {
         ArrayList var1 = new ArrayList();

         int var2;
         for(var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            var1.add(this.lesLignesList.get(var2));
         }

         for(var2 = 0; var2 < this.lesRechargementsList.size(); ++var2) {
            var1.add(this.lesRechargementsList.get(var2));
         }

         boolean var7 = false;

         for(int var3 = 0; var3 < this.lesProduitsDispo.size(); ++var3) {
            new Stock();
            Stock var4 = (Stock)this.lesProduitsDispo.get(var3);
            if (var4.getStk_qte_attCmdAch() != 0.0F) {
               var7 = true;
            } else if (var4.getStk_qte_attRecAch() != 0.0F) {
               var7 = true;
            }
         }

         if (var7) {
            this.majFacture(var1);
            double var8 = 0.0D;
            Date var5 = null;

            for(int var6 = 0; var6 < this.listFacture.size(); ++var6) {
               var8 += ((FactureEnteteVentes)this.listFacture.get(var6)).getFacTotTtc();
               var5 = ((FactureEnteteVentes)this.listFacture.get(var6)).getFacDate();
            }

            this.chargementEntete.setChamobDateFacture(var5);
            this.chargementEntete.setChamobTotFacture(var8);
            this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete);
         }
      }

      this.showModalPanelFacturation = false;
   }

   public void annulerFacture() {
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.showModalPanelFacturation = false;
   }

   public void majFacture(List var1) throws HibernateException, NamingException, ParseException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.factureEnteteVentes.setFacSite(this.usersLog.getUsrSite());
         this.factureEnteteVentes.setFacDepartement(this.usersLog.getUsrDepartement());
         this.factureEnteteVentes.setFacService(this.usersLog.getUsrService());
         this.factureEnteteVentes.setFacRegion(this.tiers.getTieregion());
         this.factureEnteteVentes.setFacSecteur(this.tiers.getTiesecteur());
         this.factureEnteteVentes.setFacPdv(this.tiers.getTiepdv());
         this.factureEnteteVentes.setFacActivite("");
         this.factureEnteteVentes.setFacAnal4("");
         this.factureEnteteVentes.setFacAnal2("");
         this.factureEnteteVentes.setFacDate(this.utilDate.dateToSQL(this.var_date_doc, this.var_heure_doc, this.var_minute_doc, this.var_seconde_doc));
         if (this.factureEnteteVentes.getUsers() == null) {
            this.factureEnteteVentes.setUsers(this.usersLog);
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

         if (this.contDest) {
            this.factureEnteteVentes.setFacIdContact(0L);
            this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.factureEnteteVentes.getFacNomContact(), var2);
            if (this.plansAnalytiques != null) {
               this.factureEnteteVentes.setFacTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            } else {
               this.factureEnteteVentes.setFacTiersRegroupe("");
            }
         } else {
            new Contacts();
            Contacts var4 = this.contactDao.recupererContacts(this.var_nom_contact, var2);
            if (var4 != null) {
               this.factureEnteteVentes.setFacIdContact(var4.getConid());
               if (var4.getConpatronyme() != null && !var4.getConpatronyme().isEmpty()) {
                  this.factureEnteteVentes.setFacNomContact(var4.getConpatronyme());
                  this.factureEnteteVentes.setFacCivilContact(var4.getConcivilite());
               } else if (var4.getConservice() != null && !var4.getConservice().isEmpty()) {
                  this.factureEnteteVentes.setFacNomContact(var4.getConservice());
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

            this.factureEnteteVentes.setFacTiersRegroupe(this.tiers.getTiesigle());
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var26 = this.usersDao.selectUserD(this.var_nom_responsable, var2);
         if (var26 != null) {
            this.factureEnteteVentes.setFacIdResponsable(var26.getUsrid());
            this.factureEnteteVentes.setFacNomResponsable(var26.getUsrPatronyme());
         } else {
            this.factureEnteteVentes.setFacIdResponsable(0L);
            this.factureEnteteVentes.setFacNomResponsable("");
         }

         new Users();
         if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
            this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
         }

         Users var5 = this.usersDao.selectUserD(this.var_nom_commercial, var2);
         if (var5 != null) {
            this.factureEnteteVentes.setFacIdCommercial(var5.getUsrid());
            this.factureEnteteVentes.setFacNomCommercial(var5.getUsrPatronyme());
         } else {
            this.factureEnteteVentes.setFacIdCommercial(0L);
            this.factureEnteteVentes.setFacNomCommercial("");
         }

         this.factureEnteteVentes.setFacIdEquipe(0L);
         this.factureEnteteVentes.setFacNomEquipe("");
         if (this.var_timbre != 0) {
            int var6 = this.var_date.getYear() + 1900;
            double var7 = this.utilNombre.calculTimbre(this.structureLog, this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), var6, this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacDate());
            double var9 = this.utilNombre.myRoundDevise(var7, this.factureEnteteVentes.getFacDevise());
            if (var9 != 0.0D) {
               String var11 = this.utilNombre.beginSimple(var9, this.factureEnteteVentes.getFacDevise());
               this.factureEnteteVentes.setFacFormule2(this.utilNombre.texteTimbre(this.structureLog, var11, var6, this.factureEnteteVentes.getFacDevise(), this.factureEnteteVentes.getFacDate()));
            }
         }

         this.factureEnteteVentes.setFacEtatVal(0);
         this.factureEnteteVentes.setFacEtat(1);
         this.factureEnteteVentes.setFacDateValide(new Date());
         this.factureEnteteVentes.setFacStock(0);
         this.factureEnteteVentes.setFacContrat("CH:" + this.chargementEntete.getChamobNum());
         if (this.factureEnteteVentes.getFacId() != 0L) {
            this.factureEnteteVentes.setFacDateModif(new Date());
            this.factureEnteteVentes.setFacIdModif(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacNomModif(this.usersLog.getUsrPatronyme());
            this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var2);
         } else {
            this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.factureEnteteVentes.setFacDateCreat(new Date());
            this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
            this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrPatronyme());
            if (this.factureEnteteVentes.getFacSerie() != null && !this.factureEnteteVentes.getFacSerie().equalsIgnoreCase("X") && !this.factureEnteteVentes.getFacSerie().isEmpty()) {
               this.factureEnteteVentes.setFacNum(this.calculChrono.numCompose(this.factureEnteteVentes.getFacDate(), 25, this.factureEnteteVentes.getFacSerie(), var2));
            } else {
               long var27 = this.factureEnteteVentesDao.selectLastNum(var2);
               this.factureEnteteVentes.setFacNum("" + var27);
            }

            this.factureEnteteVentes.setFacEtat(0);
            this.factureEnteteVentes.setFacEtatVal(0);
            this.factureEnteteVentes.setFacDateValide((Date)null);
            this.factureEnteteVentes = this.factureEnteteVentesDao.insert(this.factureEnteteVentes, var2);
            this.listFacture.add(this.factureEnteteVentes);
            this.datamodelFacture.setWrappedData(this.listFacture);
         }

         double var28 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         double var14 = 0.0D;
         if (this.lesProduitsDispo.size() != 0) {
            new Stock();

            for(int var17 = 0; var17 < this.lesProduitsDispo.size(); ++var17) {
               Stock var16 = (Stock)this.lesProduitsDispo.get(var17);
               String var18 = var16.getStk_code_produit();
               this.chargementLigne = new ChargementLigne();

               for(int var19 = 0; var19 < var1.size(); ++var19) {
                  if (((ChargementLigne)var1.get(var19)).getChaligCode().equals(var18)) {
                     this.chargementLigne = (ChargementLigne)var1.get(var19);
                     break;
                  }
               }

               double var30;
               if (this.chargementLigne != null && var16.getStk_qte_attCmdAch() != 0.0F) {
                  this.factureLigneVentes = new FactureLigneVentes();
                  this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                  this.factureLigneVentes.setFacligCode(this.chargementLigne.getChaligCode());
                  this.factureLigneVentes.setFacligCondition(this.chargementLigne.getChaligCondition());
                  this.factureLigneVentes.setFacligDepot(this.chargementLigne.getChaligDepotCharg());
                  this.factureLigneVentes.setFacligDescription(this.chargementLigne.getChaligDescription());
                  this.factureLigneVentes.setFacligDevise(this.structureLog.getStrdevise());
                  this.factureLigneVentes.setFacligDiam(this.chargementLigne.getChaligDiam());
                  this.factureLigneVentes.setFacligEchelle(this.chargementLigne.getChaligEchelle());
                  this.factureLigneVentes.setFacligFamille(this.chargementLigne.getChaligFamille());
                  this.factureLigneVentes.setFacligHaut(this.chargementLigne.getChaligHaut());
                  this.factureLigneVentes.setFacligLarg(this.chargementLigne.getChaligLarg());
                  this.factureLigneVentes.setFacligLibelle(this.chargementLigne.getChaligLibelle());
                  this.factureLigneVentes.setFacligLong(this.chargementLigne.getChaligLong());
                  this.factureLigneVentes.setFacligLot("");
                  this.factureLigneVentes.setFacligNb(this.chargementLigne.getChaligNb());
                  this.factureLigneVentes.setFacligNumSerie("");
                  this.factureLigneVentes.setFacligPoidsBrut(this.chargementLigne.getChaligPoidsBrut());
                  this.factureLigneVentes.setFacligPoidsNet(this.chargementLigne.getChaligPoidsNet());
                  this.factureLigneVentes.setFacligPump(this.chargementLigne.getChaligPump());
                  this.factureLigneVentes.setFacligReference(this.chargementLigne.getChaligReference());
                  this.factureLigneVentes.setFacligStock(this.chargementLigne.getChaligStock());
                  this.factureLigneVentes.setFacligTauxTaxe(this.chargementLigne.getChaligTauxTaxe());
                  this.factureLigneVentes.setFacligTaxe(this.chargementLigne.getChaligTaxe());
                  this.factureLigneVentes.setFacligUnite(this.chargementLigne.getChaligUnite());
                  this.factureLigneVentes.setFacligVolume(this.chargementLigne.getChaligVolume());
                  this.factureLigneVentes.setFacligRabais(0.0D);
                  this.factureLigneVentes.setFacligTauxRemise(0.0F);
                  this.factureLigneVentes.setFacligQte(var16.getStk_qte_attCmdAch());
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureLigneVentes.setFacligPuTtc(var16.getStk_pv());
                  } else {
                     this.factureLigneVentes.setFacligPu(var16.getStk_pv());
                  }

                  this.factureLigneVentes.setFacligQteStock(0.0F);
                  var16 = this.calculPrixFacture(var16, this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var2);
                  this.factureLigneVentes.setFacligQteUtil(var16.getStk_qte_attCmdVte());
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureLigneVentes.setFacligPu(var16.getStk_pa());
                  } else {
                     this.factureLigneVentes.setFacligPuTtc(var16.getStkPuTtc());
                  }

                  this.factureLigneVentes.setFacligPuRem(var16.getStkPuRem());
                  this.factureLigneVentes.setFacligPuRemTtc(var16.getStkPuRemTtc());
                  this.factureLigneVentes.setFacligPt(var16.getStkPt());
                  this.factureLigneVentes.setFacligTc(var16.getStkTc());
                  this.factureLigneVentes.setFacligTtc(var16.getStkTtc());
                  this.factureLigneVentes.setFacligTva(var16.getStkTva());
                  var30 = 0.0D;
                  if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.factureLigneVentes.getFacligDepot() != null && !this.factureLigneVentes.getFacligDepot().isEmpty()) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligDepot(), var2);
                     if (this.produitsDepot != null) {
                        var30 = this.produitsDepot.getProdepPump();
                     }
                  }

                  this.factureLigneVentes.setFacligPump(var30);
                  this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var2);
                  var28 += this.factureLigneVentes.getFacligPt();
                  var8 += this.factureLigneVentes.getFacligTva();
                  var10 += this.factureLigneVentes.getFacligTtc();
                  var12 += this.factureLigneVentes.getFacligTc();
                  if (this.factureLigneVentes.getFacligRabais() != 0.0D || this.factureLigneVentes.getFacligTauxRemise() != 0.0F) {
                     var14 += this.factureLigneVentes.getFacligPu() * (double)this.factureLigneVentes.getFacligQteUtil() - this.factureLigneVentes.getFacligPt();
                  }
               }

               if (this.chargementLigne != null && var16.getStk_qte_attRecAch() != 0.0F) {
                  this.factureLigneVentes = new FactureLigneVentes();
                  this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
                  this.factureLigneVentes.setFacligCode(this.chargementLigne.getChaligCode());
                  this.factureLigneVentes.setFacligCondition(this.chargementLigne.getChaligCondition());
                  this.factureLigneVentes.setFacligDepot(this.chargementLigne.getChaligDepotCharg());
                  this.factureLigneVentes.setFacligDescription(this.chargementLigne.getChaligDescription());
                  this.factureLigneVentes.setFacligDevise(this.structureLog.getStrdevise());
                  this.factureLigneVentes.setFacligDiam(this.chargementLigne.getChaligDiam());
                  this.factureLigneVentes.setFacligEchelle(this.chargementLigne.getChaligEchelle());
                  this.factureLigneVentes.setFacligFamille(this.chargementLigne.getChaligFamille());
                  this.factureLigneVentes.setFacligHaut(this.chargementLigne.getChaligHaut());
                  this.factureLigneVentes.setFacligLarg(this.chargementLigne.getChaligLarg());
                  this.factureLigneVentes.setFacligLibelle(this.chargementLigne.getChaligLibelle());
                  this.factureLigneVentes.setFacligLong(this.chargementLigne.getChaligLong());
                  this.factureLigneVentes.setFacligLot("");
                  this.factureLigneVentes.setFacligNb(this.chargementLigne.getChaligNb());
                  this.factureLigneVentes.setFacligNumSerie("");
                  this.factureLigneVentes.setFacligPoidsBrut(this.chargementLigne.getChaligPoidsBrut());
                  this.factureLigneVentes.setFacligPoidsNet(this.chargementLigne.getChaligPoidsNet());
                  this.factureLigneVentes.setFacligPump(this.chargementLigne.getChaligPump());
                  this.factureLigneVentes.setFacligReference(this.chargementLigne.getChaligReference());
                  this.factureLigneVentes.setFacligStock(this.chargementLigne.getChaligStock());
                  this.factureLigneVentes.setFacligTauxTaxe(this.chargementLigne.getChaligTauxTaxe());
                  this.factureLigneVentes.setFacligTaxe(this.chargementLigne.getChaligTaxe());
                  this.factureLigneVentes.setFacligUnite(this.chargementLigne.getChaligUnite());
                  this.factureLigneVentes.setFacligVolume(this.chargementLigne.getChaligVolume());
                  this.factureLigneVentes.setFacligRabais(0.0D);
                  this.factureLigneVentes.setFacligTauxRemise(0.0F);
                  this.factureLigneVentes.setFacligQte(var16.getStk_qte_attRecAch());
                  this.factureLigneVentes.setFacligQteStock(0.0F);
                  var16.setStk_qte_attCmdAch(var16.getStk_qte_attRecAch());
                  var16 = this.calculPrixFacture(var16, this.factureLigneVentes.getFacligTaxe(), this.factureLigneVentes.getFacligTauxTaxe(), var2);
                  this.factureLigneVentes.setFacligQteUtil(var16.getStk_qte_attCmdVte());
                  this.factureLigneVentes.setFacligPu(0.0D);
                  this.factureLigneVentes.setFacligPuRem(0.0D);
                  this.factureLigneVentes.setFacligPuRemTtc(0.0D);
                  this.factureLigneVentes.setFacligPt(0.0D);
                  this.factureLigneVentes.setFacligPuTtc(0.0D);
                  this.factureLigneVentes.setFacligTc(0.0D);
                  this.factureLigneVentes.setFacligTtc(0.0D);
                  this.factureLigneVentes.setFacligTva(0.0D);
                  var30 = 0.0D;
                  if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.factureLigneVentes.getFacligDepot() != null && !this.factureLigneVentes.getFacligDepot().isEmpty()) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.factureLigneVentes.getFacligCode(), this.factureLigneVentes.getFacligDepot(), var2);
                     if (this.produitsDepot != null) {
                        var30 = this.produitsDepot.getProdepPump();
                     }
                  }

                  this.factureLigneVentes.setFacligPump(var30);
                  this.factureLigneVentes = this.factureLigneVentesDao.insertLigne(this.factureLigneVentes, var2);
                  var28 += this.factureLigneVentes.getFacligPt();
                  var8 += this.factureLigneVentes.getFacligTva();
                  var10 += this.factureLigneVentes.getFacligTtc();
                  var12 += this.factureLigneVentes.getFacligTc();
                  if (this.factureLigneVentes.getFacligRabais() != 0.0D || this.factureLigneVentes.getFacligTauxRemise() != 0.0F) {
                     var14 += this.factureLigneVentes.getFacligPu() * (double)this.factureLigneVentes.getFacligQteUtil() - this.factureLigneVentes.getFacligPt();
                  }
               }
            }
         }

         this.factureEnteteVentes.setFacTotHt(var28);
         this.factureEnteteVentes.setFacTotTva(var8);
         this.factureEnteteVentes.setFacTotTtc(var10);
         this.factureEnteteVentes.setFacTotRemise(var14);
         this.factureEnteteVentes.setFacTotTc(var12);
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var2);
         DocumentTraceVentes var29 = new DocumentTraceVentes();
         var29.setDoctraDateCreat(new Date());
         var29.setDoctraUserId(this.usersLog.getUsrid());
         var29.setDoctraUserNom(this.usersLog.getUsrNom());
         var29.setExerciceventes(this.factureEnteteVentes.getExerciceventes());
         var29.setDoctraOrgType(this.nature);
         var29.setDoctraOrgSerie(this.chargementEntete.getChamobSerie());
         var29.setDoctraOrgId(this.chargementEntete.getChamobId());
         var29.setDoctraOrgNum(this.chargementEntete.getChamobNum());
         var29.setDoctraOrgDate(this.chargementEntete.getChamobDate());
         var29.setDoctraDstType(25);
         var29.setDoctraDstSerie(this.factureEnteteVentes.getFacSerie());
         var29.setDoctraDstId(this.factureEnteteVentes.getFacId());
         var29.setDoctraDstNum(this.factureEnteteVentes.getFacNum());
         var29.setDoctraDstDate(this.factureEnteteVentes.getFacDate());
         this.documentTraceVentesDao.insert(var29, var2);
         var3.commit();
      } catch (HibernateException var24) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.chargerDocumentTrace((Session)null);
      this.factureEnteteVentes = new FactureEnteteVentes();
   }

   public Stock calculPrixFacture(Stock var1, String var2, float var3, Session var4) throws HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         var1 = this.calculTtcFacture(var1, var2, var3, var4);
      } else {
         var1 = this.calculHtFacture(var1, var2, var3, var4);
      }

      return var1;
   }

   public Stock calculHtFacture(Stock var1, String var2, float var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         var5 = true;
      }

      float var6 = 0.0F;
      String var7 = "";
      int var8 = 0;
      if (var2 != null && !var2.isEmpty() && var3 == 0.0F) {
         new TaxesVentes();
         TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var2, var4);
         if (var9 != null) {
            var6 = var9.getTaxvteTaux();
            var7 = var9.getTaxvteCode();
            var8 = var9.getTaxvteType();
         }
      } else {
         var6 = var3;
         var7 = var2;
         var8 = 0;
      }

      var1.setStkTaxe(var7);
      var1.setStkTauxTaxe(var6);
      double var31 = var1.getStk_pv();
      if (var8 == 3) {
         float var11 = 100.0F - var6;
         var31 = this.utilNombre.myRoundDevise(var31 / (double)var11 * 100.0D, this.structureLog.getStrdevise());
      }

      double var32 = 0.0D;
      var32 = var31 * (double)var1.getStk_qte_attCmdAch();
      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = var1.getStkRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = var1.getStkRabais() * (double)var1.getStk_qte_attCmdAch();
      }

      if (this.chargementLigne.getChaligTauxRemise() != 0.0F) {
         var13 = var32 - var32 * (double)var1.getStkTauxRemise() / 100.0D - var15;
      } else {
         var13 = var32 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)var1.getStkTauxTaxe() / 100.0D;
      if (var8 == 2) {
         var19 *= -1.0D;
      } else if (var8 == 3) {
         var19 = var17 * (double)(var6 / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      var25 = this.utilNombre.myRound(var17 / (double)var1.getStk_qte_attCmdAch(), 2);
      var1.setStkPuRem(var25);
      var1.setStkPt(var17);
      var1.setStkTva(var21);
      var1.setStkTc(0.0D);
      var1.setStkTtc(var23);
      double var27 = 0.0D;
      var27 = this.utilNombre.myRound(var23 / (double)var1.getStk_qte_attCmdAch(), 2);
      var1.setStkPuRemTtc(var27);
      double var29 = var31 + var31 * (double)var1.getStkTauxTaxe() / 100.0D;
      var1.setStkPuTtc(var29);
      this.factureLigneVentes.setFacligPt(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPt(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTva(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTva(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTtc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTtc(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTc(), this.factureEnteteVentes.getFacDevise()));
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public Stock calculTtcFacture(Stock var1, String var2, float var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         var5 = true;
      }

      float var6 = 0.0F;
      String var7 = "";
      if (var2 != null && !var2.isEmpty() && var3 == 0.0F) {
         new TaxesVentes();
         TaxesVentes var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var2, var4);
         if (var8 != null) {
            var6 = var8.getTaxvteTaux();
            var7 = var8.getTaxvteCode();
         }
      } else {
         var6 = var3;
         var7 = var2;
      }

      var1.setStkTaxe(var7);
      var1.setStkTauxTaxe(var6);
      double var34 = 0.0D;
      double var10;
      double var12;
      if (this.chargementEntete.getChamobTauxTc() != 0.0F) {
         var10 = var1.getStk_pv() * (double)var1.getStk_qte_attCmdAch();
         var12 = var10 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
         var34 = this.utilNombre.myRound((var10 - var12) / (double)var1.getStk_qte_attCmdAch(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var34 = var1.getStk_pv();
      }

      var10 = var34 / (double)(1.0F + var6 / 100.0F);
      var1.setStk_pv(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = var1.getStkRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = var1.getStkRabais() * (double)var1.getStk_qte_attCmdAch();
      }

      double var14 = 0.0D;
      if (var1.getStkTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)var1.getStkTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (var1.getStkTauxRemise() != 0.0F) {
         var16 = var34 - var34 * (double)var1.getStkTauxRemise() / 100.0D - var12;
      } else {
         var16 = var34 - var12;
      }

      var1.setStk_qte_attCmdVte(var1.getStk_qte_attCmdAch());
      if (var1.getStk_qte_attCmdAch() != 0.0F && var1.getStk_code_produit() != null && !var1.getStk_code_produit().isEmpty()) {
         this.produits = this.produitsDao.chargeProduit(var1.getStk_code_produit(), var4);
         if (this.produits != null && this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty()) {
            var1.setStk_qte_attCmdVte(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.produits.getProCondition1(), var1.getStk_qte_attCmdAch(), this.produits.getProLongueur(), this.produits.getProLargeur(), this.produits.getProEpaisseur(), this.produits.getProDiamExt(), this.produits.getProNbUnite(), this.baseLog, this.utilInitHibernate, var4));
         }
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)var1.getStk_qte_attCmdAch();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var26 = var20 * (double)var1.getStk_qte_attCmdAch();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      var1.setStkPuRem(var18);
      var1.setStkPuRemTtc(var20);
      var1.setStkPt(var24);
      var1.setStkTva(var32);
      var1.setStkTtc(var28);
      this.factureLigneVentes.setFacligPt(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligPt(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTva(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTva(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTtc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTtc(), this.factureEnteteVentes.getFacDevise()));
      this.factureLigneVentes.setFacligTc(this.utilNombre.myRoundDevise(this.factureLigneVentes.getFacligTc(), this.factureEnteteVentes.getFacDevise()));
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public void initImprimerFacture() {
      if (this.factureEnteteVentes != null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilTdt = new UtilTdt();
         String var1 = this.calculeCheminRapportFacture(this.baseLog);
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.documentImpressionItems = new ArrayList();
         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var5));
               }
            }
         }

         this.choixImpression = 25;
         this.showModalPanelPrintFacture = true;
      }

   }

   public void fermerImpressionFacture() {
      this.showModalPanelPrintFacture = false;
      this.showModalPanelPrintAvoir = false;
      this.showModalPanelPrintRetour = false;
      this.showModalPanelPrintNoteDebit = false;
   }

   public void imprimerPRTFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerFacture();
   }

   public void imprimerJRVFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerFacture();
   }

   public void imprimerPDFFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerFacture();
   }

   public void imprimerODTFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerFacture();
   }

   public void imprimerXLSFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerFacture();
   }

   public void imprimerDOCFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerFacture();
   }

   public void imprimerHTMLFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerFacture();
   }

   public void imprimerXMLFacture() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerFacture();
   }

   public String conversionGardeFacture() throws HibernateException, NamingException {
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

   public String conversionAnnexe1Facture() throws HibernateException, NamingException {
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

   public String conversionAnnexe2Facture() throws HibernateException, NamingException {
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

   public String calculeCheminRapportFacture(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      return var2;
   }

   public String calculeImageFondFacture(String var1, int var2) throws HibernateException, NamingException {
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

   public JRBeanCollectionDataSource calculeImpressionCommunFacture() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var2 = false;
         String var3 = "";
         double var4 = 0.0D;
         double var6 = 0.0D;
         this.infoOrigineDoc = "";
         new ArrayList();
         List var8 = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, (Session)null);

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.factureLigneVentes = (FactureLigneVentes)var8.get(var9);
            if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.factureLigneVentes.getFacligCode().equals("-")) {
               var2 = true;
               var3 = this.factureLigneVentes.getFacligLibelle();
               if (var3.startsWith("Suivant ") && (this.infoOrigineDoc == null || this.infoOrigineDoc.isEmpty())) {
                  this.infoOrigineDoc = var3;
               }
            }

            if (var2) {
               var4 += this.factureLigneVentes.getFacligPt();
               var6 = this.factureLigneVentes.getFacligTtc();
            }

            if (this.factureLigneVentes.getFacligCode() != null && !this.factureLigneVentes.getFacligCode().isEmpty() && this.factureLigneVentes.getFacligCode().equals("=") && var2) {
               this.factureLigneVentes = new FactureLigneVentes();
               this.factureLigneVentes.setFactureEnteteVentes(this.factureEnteteVentes);
               this.factureLigneVentes.setFacligCode("=");
               this.factureLigneVentes.setFacligLibelle(var3);
               this.factureLigneVentes.setFacligPt(var4);
               this.factureLigneVentes.setFacligTtc(var6);
               var1.add(this.factureLigneVentes);
               var4 = 0.0D;
               var6 = 0.0D;
               var2 = false;
            } else {
               var1.add(this.factureLigneVentes);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc(), this.factureEnteteVentes.getFacDevise());
      JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(var1);
      return var10;
   }

   public boolean majDateImpressionFacture(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.factureEnteteVentes.getFacDateImp() != null && this.factureEnteteVentes.getFacEtat() != 0) {
            var2 = true;
         }

         this.factureEnteteVentes.setFacDateImp(new Date());
         if (this.factureEnteteVentes.getFacEtat() == 0 && this.factureEnteteVentes.getFacEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.factureEnteteVentes.setFacEtat(1);
         }

         this.factureEnteteVentes.setFacModeleImp(var1);
         this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var3);
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

   public void imprimerFacture() throws IOException, IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         boolean var1 = this.majDateImpressionFacture(this.nomModeleDocument);
         this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommunFacture());
         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setEntete("Impression facture");
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         this.utilPrint.setPageGarde(this.conversionGardeFacture());
         this.utilPrint.setAnnexe1(this.conversionAnnexe1Facture());
         this.utilPrint.setAnnexe2(this.conversionAnnexe2Facture());
         this.utilPrint.setCheminRapport(this.calculeCheminRapportFacture("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setImageFondPage(this.calculeImageFondFacture("structure" + this.structureLog.getStrid(), this.chargementEntete.getChamobEtat()));
         this.utilPrint.setDuplicata("" + var1);
         this.utilPrint.setInfoOrigineDoc(this.infoOrigineDoc);
         this.utilPrint.setNbDecQte(this.optionsVentes.getNbDecQte());
         this.utilPrint.setNbDecPu(this.optionsVentes.getNbDecPu());
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
         this.utilPrint.setIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
         this.utilPrint.setTiersSelectionne(this.factureEnteteVentes.getTiers());
         this.utilPrint.setNature(25);
         this.utilPrint.setId_doc(this.factureEnteteVentes.getFacId());
         if (this.factureEnteteVentes.getFacAnal2() != null && !this.factureEnteteVentes.getFacAnal2().isEmpty()) {
            String var2 = "";
            if (this.factureEnteteVentes.getFacAnal2().contains(":")) {
               String[] var3 = this.factureEnteteVentes.getFacAnal2().split(":");
               var2 = var3[0];
            } else {
               var2 = this.factureEnteteVentes.getFacAnal2();
            }

            new Parc();
            ParcDao var4 = new ParcDao(this.baseLog, this.utilInitHibernate);
            Parc var5 = var4.rechercheParc(var2, (Session)null);
            if (var5 != null) {
               this.utilPrint.setParc(var5);
            } else {
               this.utilPrint.setParc((Parc)null);
            }
         } else {
            this.utilPrint.setParc((Parc)null);
         }

         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.factureEnteteVentes.getFacId(), 25, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      new ArrayList();
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      List var5 = this.reglementsDao.reglementDocument(this.factureEnteteVentes.getFacId(), 25, var1);
      this.afficheRecu = false;
      if (var5.size() != 0) {
         this.afficheRecu = true;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglRecette();
         }
      }

      if (this.var_tot_bon_encaissement < this.factureEnteteVentes.getFacTotTtc()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.factureEnteteVentes.getFacTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void payeDocument() {
      this.bonEncaissementVente = new BonEncaissementVente();
      this.bonEncaissementVente.setBonCodeCaisse("");
      this.bonEncaissementVente.setBonLibCaisse("");
      this.bonEncaissementVente.setBonDate(new Date());
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

         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      }

      this.showModalPanelPaye = true;
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
      if (this.var_tot_bon_encaissement <= this.factureEnteteVentes.getFacTotTtc()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteVentes.getFacTypeReg() == 5) {
               this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var4 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var3 = var4.existenceHabilitation(29, var1);
               if (var3 != null) {
               }
            } else {
               String var10 = this.calculChrono.numCompose(new Date(), 29, this.factureEnteteVentes.getFacSerie(), var1);
               this.bonEncaissementVente = new BonEncaissementVente();
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
               this.bonEncaissementVente.setBonNatRef(25);
               this.bonEncaissementVente.setBonNomResponsable(this.usersLog.getUsrPrenom() + " " + this.usersLog.getUsrNom());
               this.bonEncaissementVente.setBonNomTiers(this.factureEnteteVentes.getFacNomTiers());
               this.bonEncaissementVente.setBonIdTiers(this.factureEnteteVentes.getTiers().getTieid());
               this.bonEncaissementVente.setBonNomContact(this.factureEnteteVentes.getFacNomContact());
               this.bonEncaissementVente.setBonIdContact(this.factureEnteteVentes.getFacIdContact());
               this.bonEncaissementVente.setBonTypeTiers(0);
               this.bonEncaissementVente.setBonLibelle("Règlement Facture N° " + this.factureEnteteVentes.getFacNum());
               this.bonEncaissementVente.setBonRef(this.factureEnteteVentes.getFacNum());
               this.bonEncaissementVente.setBonIdRef(this.factureEnteteVentes.getFacId());
               this.bonEncaissementVente.setBonChg(this.chargementEntete.getChamobNum());
               this.bonEncaissementVente.setBonIdChg(this.chargementEntete.getChamobId());
               this.bonEncaissementVente.setBonObject(this.factureEnteteVentes.getFacObject());
               this.bonEncaissementVente.setBonObservation(this.factureEnteteVentes.getFacObservation());
               this.bonEncaissementVente.setBonSerie(this.factureEnteteVentes.getFacSerie());
               this.bonEncaissementVente.setBonDevise(this.factureEnteteVentes.getFacDevise());
               this.bonEncaissementVente.setBonTotTtc(this.factureEnteteVentes.getFacTotTtc());
               this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
               this.bonEncaissementVente.setBonTypeReg(this.factureEnteteVentes.getFacTypeReg());
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var10);
               this.bonEncaissementVente.setBonDate(new Date());
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

      this.showModalPanelPaye = false;
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

   public void ajouterAvoir() throws HibernateException, NamingException {
      this.factureEnteteVentes = null;
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.avoirLigneVentes = new AvoirLigneVentes();
      this.avoirEnteteVentes.setUsers(this.usersLog);
      this.avoirEnteteVentes.setAvrIdCreateur(this.usersLog.getUsrid());
      this.avoirEnteteVentes.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.avoirEnteteVentes.setAvrIdResponsable(this.usersLog.getUsrid());
      this.avoirEnteteVentes.setAvrNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.avoirEnteteVentes.setAvrDate(new Date());
      this.var_date_doc = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure_doc = "0" + (new Date()).getHours();
      } else {
         this.var_heure_doc = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute_doc = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute_doc = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde_doc = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde_doc = "" + (new Date()).getSeconds();
      }

      boolean var1 = false;
      int var13;
      if (this.optionsVentes.getNbrJrRelanceAVOIR() != null && !this.optionsVentes.getNbrJrRelanceAVOIR().isEmpty()) {
         var13 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceAVOIR());
      } else {
         var13 = 0;
      }

      boolean var2 = false;
      int var14;
      if (this.optionsVentes.getNbrJrValidAVOIR() != null && !this.optionsVentes.getNbrJrValidAVOIR().isEmpty()) {
         var14 = Integer.parseInt(this.optionsVentes.getNbrJrValidAVOIR());
      } else {
         var14 = 0;
      }

      this.avoirEnteteVentes.setAvrDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var13));
      this.avoirEnteteVentes.setAvrDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var14));
      this.avoirEnteteVentes.setAvrDateLivraison((Date)null);
      this.avoirEnteteVentes.setAvrBanque(this.structureLog.getStrBanqueDefaut());
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.var_aff_detail_tiers = false;
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.var_total_marge = 0.0D;
      this.tiers = new Tiers();
      this.lesProduitsDispo.clear();
      ArrayList var3 = new ArrayList();

      int var4;
      for(var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
         if (((ChargementLigne)this.lesLignesList.get(var4)).getChaligGenerique() != 5) {
            var3.add(this.lesLignesList.get(var4));
         }
      }

      for(var4 = 0; var4 < this.lesRechargementsList.size(); ++var4) {
         if (((ChargementLigne)this.lesRechargementsList.get(var4)).getChaligGenerique() != 5) {
            var3.add(this.lesRechargementsList.get(var4));
         }
      }

      if (var3.size() != 0) {
         Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            this.chargementLigne = new ChargementLigne();
            this.chargementLigne = (ChargementLigne)var3.get(var5);
            float var6 = 0.0F;
            String var7 = this.chargementLigne.getChaligCode();
            if (this.chargementLigne.getChaligCode() != null && this.listFacture.size() != 0) {
               for(int var8 = 0; var8 < this.listFacture.size(); ++var8) {
                  new FactureEnteteVentes();
                  FactureEnteteVentes var9 = (FactureEnteteVentes)this.listFacture.get(var8);
                  this.factureLigneVentes = new FactureLigneVentes();
                  new ArrayList();
                  List var10 = this.factureLigneVentesDao.chargerLesLignes(var9, var15);
                  if (var10.size() != 0) {
                     for(int var11 = 0; var11 < var10.size(); ++var11) {
                        new FactureLigneVentes();
                        FactureLigneVentes var12 = (FactureLigneVentes)var10.get(var11);
                        if (var12.getFacligCode().equals(var7)) {
                           var6 += var12.getFacligQte();
                        }
                     }
                  }
               }
            }

            Stock var16 = new Stock();
            var16.setStk_code_produit(this.chargementLigne.getChaligCode());
            var16.setStkLibelle(this.chargementLigne.getChaligLibelle());
            var16.setStkFamille(this.chargementLigne.getChaligFamille());
            var16.setStk_qte_in(var6);
            var16.setStk_qte_attCmdAch(0.0F);
            var16.setStk_qte_attCmdVte(0.0F);
            var16.setStk_qte_attRecAch(0.0F);
            this.lesProduitsDispo.add(var16);
         }

         this.datamodelDispo.setWrappedData(this.lesProduitsDispo);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelAvoir = true;
   }

   public void selectionnerAvoir() {
      if (this.datamodelAvoir.isRowAvailable()) {
         this.avoirEnteteVentes = (AvoirEnteteVentes)this.datamodelAvoir.getRowData();
      }

   }

   public void modifierAvoir() {
      if (this.avoirEnteteVentes != null) {
      }

   }

   public void supprimerAvoir() throws NamingException {
      if (this.avoirEnteteVentes != null) {
         long var1 = this.avoirEnteteVentes.getAvrId();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEntete");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ArrayList();
            List var5 = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, var3);
            if (var5.size() != 0) {
               this.avoirLigneVentesDao.deleteAllLigne(this.avoirEnteteVentes, var3);
               this.avoirEnteteVentesDao.delete(this.avoirEnteteVentes.getAvrId(), var3);
               this.listAvoir.remove(this.avoirEnteteVentes);
               new ArrayList();
               new DocumentTraceVentes();
               List var6 = this.documentTraceVentesDao.chercherDestinationTraceListe(var1, 26, var3);
               if (var6.size() != 0) {
                  for(int var8 = 0; var8 < var6.size(); ++var8) {
                     DocumentTraceVentes var7 = (DocumentTraceVentes)var6.get(var8);
                     if (var7 != null && var7.getDoctraDstType() == 26) {
                        this.documentTraceVentesDao.delete(var7, var3);
                     }
                  }
               }
            }

            var4.commit();
         } catch (HibernateException var12) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentTrace((Session)null);
         this.avoirEnteteVentes = new AvoirEnteteVentes();
      }

   }

   public void validerAvoir() throws HibernateException, NamingException, ParseException {
      if (this.lesProduitsDispo.size() != 0) {
         ArrayList var1 = new ArrayList();

         int var2;
         for(var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            var1.add(this.lesLignesList.get(var2));
         }

         for(var2 = 0; var2 < this.lesRechargementsList.size(); ++var2) {
            var1.add(this.lesRechargementsList.get(var2));
         }

         boolean var5 = false;

         for(int var3 = 0; var3 < this.lesProduitsDispo.size(); ++var3) {
            new Stock();
            Stock var4 = (Stock)this.lesProduitsDispo.get(var3);
            if (var4.getStk_qte_attCmdVte() != 0.0F) {
               var5 = true;
            }
         }

         if (var5) {
            this.majAvoir(var1);
         }
      }

      this.showModalPanelAvoir = false;
   }

   public void annulerAvoir() {
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.showModalPanelAvoir = false;
   }

   public void majAvoir(List var1) throws NamingException, ParseException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.avoirEnteteVentes.setAvrSite(this.usersLog.getUsrSite());
         this.avoirEnteteVentes.setAvrDepartement(this.usersLog.getUsrDepartement());
         this.avoirEnteteVentes.setAvrService(this.usersLog.getUsrService());
         this.avoirEnteteVentes.setAvrRegion(this.tiers.getTieregion());
         this.avoirEnteteVentes.setAvrSecteur(this.tiers.getTiesecteur());
         this.avoirEnteteVentes.setAvrPdv(this.tiers.getTiepdv());
         this.avoirEnteteVentes.setAvrActivite("");
         this.avoirEnteteVentes.setAvrAnal4("");
         this.avoirEnteteVentes.setAvrAnal2("");
         this.avoirEnteteVentes.setAvrDate(this.utilDate.dateToSQL(this.var_date_doc, this.var_heure_doc, this.var_minute_doc, this.var_seconde_doc));
         if (this.avoirEnteteVentes.getUsers() == null) {
            this.avoirEnteteVentes.setUsers(this.usersLog);
         }

         this.avoirEnteteVentes.setTiers(this.tiers);
         if ((this.avoirEnteteVentes.getAvrCat() == null || this.avoirEnteteVentes.getAvrCat().isEmpty()) && this.avoirEnteteVentes.getTiers().getTienomfamille() != null && !this.avoirEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.avoirEnteteVentes.setAvrCat(this.avoirEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.avoirEnteteVentes.setAvrCivilTiers("");
         } else {
            this.avoirEnteteVentes.setAvrCivilTiers(this.avoirEnteteVentes.getTiers().getTiecivilite());
         }

         if (this.contDest) {
            this.avoirEnteteVentes.setAvrIdContact(0L);
            this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.avoirEnteteVentes.getAvrNomContact(), var2);
            if (this.plansAnalytiques != null) {
               this.avoirEnteteVentes.setAvrTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            } else {
               this.avoirEnteteVentes.setAvrTiersRegroupe("");
            }
         } else {
            new Contacts();
            Contacts var4 = this.contactDao.recupererContacts(this.var_nom_contact, var2);
            if (var4 != null) {
               this.avoirEnteteVentes.setAvrIdContact(var4.getConid());
               if (var4.getConpatronyme() != null && !var4.getConpatronyme().isEmpty()) {
                  this.avoirEnteteVentes.setAvrNomContact(var4.getConpatronyme());
                  this.avoirEnteteVentes.setAvrCivilContact(var4.getConcivilite());
               } else if (var4.getConservice() != null && !var4.getConservice().isEmpty()) {
                  this.avoirEnteteVentes.setAvrNomContact(var4.getConservice());
                  this.avoirEnteteVentes.setAvrCivilContact("SERVICE/SITE:");
               } else {
                  this.avoirEnteteVentes.setAvrIdContact(0L);
                  this.avoirEnteteVentes.setAvrNomContact("");
                  this.avoirEnteteVentes.setAvrCivilContact("");
               }
            } else {
               this.avoirEnteteVentes.setAvrIdContact(0L);
               this.avoirEnteteVentes.setAvrNomContact("");
               this.avoirEnteteVentes.setAvrCivilContact("");
            }

            this.avoirEnteteVentes.setAvrTiersRegroupe(this.tiers.getTiesigle());
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var26 = this.usersDao.selectUserD(this.var_nom_responsable, var2);
         if (var26 != null) {
            this.avoirEnteteVentes.setAvrIdResponsable(var26.getUsrid());
            this.avoirEnteteVentes.setAvrNomResponsable(var26.getUsrPatronyme());
         } else {
            this.avoirEnteteVentes.setAvrIdResponsable(0L);
            this.avoirEnteteVentes.setAvrNomResponsable("");
         }

         new Users();
         if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
            this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
         }

         Users var5 = this.usersDao.selectUserD(this.var_nom_commercial, var2);
         if (var5 != null) {
            this.avoirEnteteVentes.setAvrIdCommercial(var5.getUsrid());
            this.avoirEnteteVentes.setAvrNomCommercial(var5.getUsrPatronyme());
         } else {
            this.avoirEnteteVentes.setAvrIdCommercial(0L);
            this.avoirEnteteVentes.setAvrNomCommercial("");
         }

         this.avoirEnteteVentes.setAvrIdEquipe(0L);
         this.avoirEnteteVentes.setAvrNomEquipe("");
         if (this.var_timbre != 0) {
            int var6 = this.var_date.getYear() + 1900;
            double var7 = this.utilNombre.calculTimbre(this.structureLog, this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc(), var6, this.avoirEnteteVentes.getAvrDevise(), this.avoirEnteteVentes.getAvrDate());
            double var9 = this.utilNombre.myRoundDevise(var7, this.avoirEnteteVentes.getAvrDevise());
            if (var9 != 0.0D) {
               String var11 = this.utilNombre.beginSimple(var9, this.avoirEnteteVentes.getAvrDevise());
               this.avoirEnteteVentes.setAvrFormule2(this.utilNombre.texteTimbre(this.structureLog, var11, var6, this.avoirEnteteVentes.getAvrDevise(), this.avoirEnteteVentes.getAvrDate()));
            }
         }

         this.avoirEnteteVentes.setAvrEtatVal(0);
         this.avoirEnteteVentes.setAvrEtat(1);
         this.avoirEnteteVentes.setAvrDateValide(new Date());
         this.avoirEnteteVentes.setAvrContrat("CH:" + this.chargementEntete.getChamobNum());
         if (this.avoirEnteteVentes.getAvrId() != 0L) {
            this.avoirEnteteVentes.setAvrDateModif(new Date());
            this.avoirEnteteVentes.setAvrIdModif(this.usersLog.getUsrid());
            this.avoirEnteteVentes.setAvrNomModif(this.usersLog.getUsrPatronyme());
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var2);
         } else {
            this.avoirEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.avoirEnteteVentes.setAvrDateCreat(new Date());
            this.avoirEnteteVentes.setAvrIdCreateur(this.usersLog.getUsrid());
            this.avoirEnteteVentes.setAvrNomCreateur(this.usersLog.getUsrPatronyme());
            if (this.avoirEnteteVentes.getAvrSerie() != null && !this.avoirEnteteVentes.getAvrSerie().equalsIgnoreCase("X") && !this.avoirEnteteVentes.getAvrSerie().isEmpty()) {
               this.avoirEnteteVentes.setAvrNum(this.calculChrono.numCompose(this.avoirEnteteVentes.getAvrDate(), 26, this.avoirEnteteVentes.getAvrSerie(), var2));
            } else {
               long var27 = this.avoirEnteteVentesDao.selectLastNum(var2);
               this.avoirEnteteVentes.setAvrNum("" + var27);
            }

            this.avoirEnteteVentes.setAvrEtat(0);
            this.avoirEnteteVentes.setAvrEtatVal(0);
            this.avoirEnteteVentes.setAvrDateValide((Date)null);
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.insert(this.avoirEnteteVentes, var2);
            this.listAvoir.add(this.avoirEnteteVentes);
            this.datamodelAvoir.setWrappedData(this.listAvoir);
         }

         double var28 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         double var14 = 0.0D;
         if (this.lesProduitsDispo.size() != 0) {
            new Stock();

            for(int var17 = 0; var17 < this.lesProduitsDispo.size(); ++var17) {
               Stock var16 = (Stock)this.lesProduitsDispo.get(var17);
               String var18 = var16.getStk_code_produit();
               this.chargementLigne = new ChargementLigne();

               for(int var19 = 0; var19 < var1.size(); ++var19) {
                  if (((ChargementLigne)var1.get(var19)).getChaligCode().equals(var18)) {
                     this.chargementLigne = (ChargementLigne)var1.get(var19);
                     break;
                  }
               }

               if (this.chargementLigne != null && var16.getStk_qte_attCmdVte() != 0.0F) {
                  this.avoirLigneVentes = new AvoirLigneVentes();
                  this.avoirLigneVentes.setAvoirEnteteVentes(this.avoirEnteteVentes);
                  this.avoirLigneVentes.setAvrligCode(this.chargementLigne.getChaligCode());
                  this.avoirLigneVentes.setAvrligCondition(this.chargementLigne.getChaligCondition());
                  this.avoirLigneVentes.setAvrligDepot(this.chargementLigne.getChaligDepotCharg());
                  this.avoirLigneVentes.setAvrligDescription(this.chargementLigne.getChaligDescription());
                  this.avoirLigneVentes.setAvrligDevise(this.structureLog.getStrdevise());
                  this.avoirLigneVentes.setAvrligDiam(this.chargementLigne.getChaligDiam());
                  this.avoirLigneVentes.setAvrligEchelle(this.chargementLigne.getChaligEchelle());
                  this.avoirLigneVentes.setAvrligFamille(this.chargementLigne.getChaligFamille());
                  this.avoirLigneVentes.setAvrligHaut(this.chargementLigne.getChaligHaut());
                  this.avoirLigneVentes.setAvrligLarg(this.chargementLigne.getChaligLarg());
                  this.avoirLigneVentes.setAvrligLibelle(this.chargementLigne.getChaligLibelle());
                  this.avoirLigneVentes.setAvrligLong(this.chargementLigne.getChaligLong());
                  this.avoirLigneVentes.setAvrligLot("");
                  this.avoirLigneVentes.setAvrligNb(this.chargementLigne.getChaligNb());
                  this.avoirLigneVentes.setAvrligNumSerie("");
                  this.avoirLigneVentes.setAvrligPoidsBrut(this.chargementLigne.getChaligPoidsBrut());
                  this.avoirLigneVentes.setAvrligPoidsNet(this.chargementLigne.getChaligPoidsNet());
                  this.avoirLigneVentes.setAvrligPump(this.chargementLigne.getChaligPump());
                  this.avoirLigneVentes.setAvrligReference(this.chargementLigne.getChaligReference());
                  this.avoirLigneVentes.setAvrligStock(this.chargementLigne.getChaligStock());
                  this.avoirLigneVentes.setAvrligTauxTaxe(this.chargementLigne.getChaligTauxTaxe());
                  this.avoirLigneVentes.setAvrligTaxe(this.chargementLigne.getChaligTaxe());
                  this.avoirLigneVentes.setAvrligUnite(this.chargementLigne.getChaligUnite());
                  this.avoirLigneVentes.setAvrligVolume(this.chargementLigne.getChaligVolume());
                  this.avoirLigneVentes.setAvrligRabais(0.0D);
                  this.avoirLigneVentes.setAvrligTauxRemise(0.0F);
                  this.avoirLigneVentes.setAvrligQte(var16.getStk_qte_attCmdVte());
                  this.avoirLigneVentes.setAvrligQteStock(0.0F);
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.avoirLigneVentes.setAvrligPuTtc(var16.getStk_pv());
                  } else {
                     this.avoirLigneVentes.setAvrligPu(var16.getStk_pv());
                  }

                  var16 = this.calculPrixAvoir(var16, this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var2);
                  var16 = this.calculPrixFacture(var16, this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var2);
                  this.avoirLigneVentes.setAvrligQteUtil(var16.getStk_qte_attCmdVte());
                  this.avoirLigneVentes.setAvrligPu(0.0D);
                  this.avoirLigneVentes.setAvrligPuRem(0.0D);
                  this.avoirLigneVentes.setAvrligPuRemTtc(0.0D);
                  this.avoirLigneVentes.setAvrligPt(0.0D);
                  this.avoirLigneVentes.setAvrligPuTtc(0.0D);
                  this.avoirLigneVentes.setAvrligTc(0.0D);
                  this.avoirLigneVentes.setAvrligTtc(0.0D);
                  this.avoirLigneVentes.setAvrligTva(0.0D);
                  double var30 = 0.0D;
                  if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && this.avoirLigneVentes.getAvrligDepot() != null && !this.avoirLigneVentes.getAvrligDepot().isEmpty()) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.avoirLigneVentes.getAvrligCode(), this.avoirLigneVentes.getAvrligDepot(), var2);
                     if (this.produitsDepot != null) {
                        var30 = this.produitsDepot.getProdepPump();
                     }
                  }

                  this.avoirLigneVentes.setAvrligPump(var30);
                  this.avoirLigneVentes = this.avoirLigneVentesDao.insertLigne(this.avoirLigneVentes, var2);
                  var28 += this.avoirLigneVentes.getAvrligPt();
                  var8 += this.avoirLigneVentes.getAvrligTva();
                  var10 += this.avoirLigneVentes.getAvrligTtc();
                  var12 += this.avoirLigneVentes.getAvrligTc();
                  if (this.avoirLigneVentes.getAvrligRabais() != 0.0D || this.avoirLigneVentes.getAvrligTauxRemise() != 0.0F) {
                     var14 += this.avoirLigneVentes.getAvrligPu() * (double)this.avoirLigneVentes.getAvrligQteUtil() - this.avoirLigneVentes.getAvrligPt();
                  }
               }
            }
         }

         this.avoirEnteteVentes.setAvrTotHt(var28);
         this.avoirEnteteVentes.setAvrTotTva(var8);
         this.avoirEnteteVentes.setAvrTotTtc(var10);
         this.avoirEnteteVentes.setAvrTotRemise(var14);
         this.avoirEnteteVentes.setAvrTotTc(var12);
         this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var2);
         DocumentTraceVentes var29 = new DocumentTraceVentes();
         var29.setDoctraDateCreat(new Date());
         var29.setDoctraUserId(this.usersLog.getUsrid());
         var29.setDoctraUserNom(this.usersLog.getUsrNom());
         var29.setExerciceventes(this.factureEnteteVentes.getExerciceventes());
         var29.setDoctraOrgType(this.nature);
         var29.setDoctraOrgSerie(this.chargementEntete.getChamobSerie());
         var29.setDoctraOrgId(this.chargementEntete.getChamobId());
         var29.setDoctraOrgNum(this.chargementEntete.getChamobNum());
         var29.setDoctraOrgDate(this.chargementEntete.getChamobDate());
         var29.setDoctraDstType(26);
         var29.setDoctraDstSerie(this.avoirEnteteVentes.getAvrSerie());
         var29.setDoctraDstId(this.avoirEnteteVentes.getAvrId());
         var29.setDoctraDstNum(this.avoirEnteteVentes.getAvrNum());
         var29.setDoctraDstDate(this.avoirEnteteVentes.getAvrDate());
         this.documentTraceVentesDao.insert(var29, var2);
         var3.commit();
      } catch (HibernateException var24) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.chargerDocumentTrace((Session)null);
      this.avoirEnteteVentes = new AvoirEnteteVentes();
   }

   public Stock calculPrixAvoir(Stock var1, String var2, float var3, Session var4) throws HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         var1 = this.calculTtcAvoir(var1, var2, var3, var4);
      } else {
         var1 = this.calculHtAvoir(var1, var2, var3, var4);
      }

      return var1;
   }

   public Stock calculHtAvoir(Stock var1, String var2, float var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         var5 = true;
      }

      float var6 = 0.0F;
      String var7 = "";
      int var8 = 0;
      if (var2 != null && !var2.isEmpty() && var3 == 0.0F) {
         new TaxesVentes();
         TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var2, var4);
         if (var9 != null) {
            var6 = var9.getTaxvteTaux();
            var7 = var9.getTaxvteCode();
            var8 = var9.getTaxvteType();
         }
      } else {
         var6 = var3;
         var7 = var2;
         var8 = 0;
      }

      var1.setStkTaxe(var7);
      var1.setStkTauxTaxe(var6);
      double var31 = var1.getStk_pv();
      if (var8 == 3) {
         float var11 = 100.0F - var6;
         var31 = this.utilNombre.myRoundDevise(var31 / (double)var11 * 100.0D, this.structureLog.getStrdevise());
      }

      double var32 = 0.0D;
      var32 = var31 * (double)var1.getStk_qte_attCmdAch();
      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = var1.getStkRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = var1.getStkRabais() * (double)var1.getStk_qte_attCmdAch();
      }

      if (this.chargementLigne.getChaligTauxRemise() != 0.0F) {
         var13 = var32 - var32 * (double)var1.getStkTauxRemise() / 100.0D - var15;
      } else {
         var13 = var32 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)var1.getStkTauxTaxe() / 100.0D;
      if (var8 == 2) {
         var19 *= -1.0D;
      } else if (var8 == 3) {
         var19 = var17 * (double)(var6 / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      var25 = this.utilNombre.myRound(var17 / (double)var1.getStk_qte_attCmdAch(), 2);
      var1.setStkPuRem(var25);
      var1.setStkPt(var17);
      var1.setStkTva(var21);
      var1.setStkTc(0.0D);
      var1.setStkTtc(var23);
      double var27 = 0.0D;
      var27 = this.utilNombre.myRound(var23 / (double)var1.getStk_qte_attCmdAch(), 2);
      var1.setStkPuRemTtc(var27);
      double var29 = var31 + var31 * (double)var1.getStkTauxTaxe() / 100.0D;
      var1.setStkPuTtc(var29);
      this.avoirLigneVentes.setAvrligPt(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligPt(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTva(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTva(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTtc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTtc(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTc(), this.avoirEnteteVentes.getAvrDevise()));
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public Stock calculTtcAvoir(Stock var1, String var2, float var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         var5 = true;
      }

      float var6 = 0.0F;
      String var7 = "";
      if (var2 != null && !var2.isEmpty() && var3 == 0.0F) {
         new TaxesVentes();
         TaxesVentes var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var2, var4);
         if (var8 != null) {
            var6 = var8.getTaxvteTaux();
            var7 = var8.getTaxvteCode();
         }
      } else {
         var6 = var3;
         var7 = var2;
      }

      var1.setStkTaxe(var7);
      var1.setStkTauxTaxe(var6);
      double var34 = 0.0D;
      double var10;
      double var12;
      if (this.chargementEntete.getChamobTauxTc() != 0.0F) {
         var10 = var1.getStk_pv() * (double)var1.getStk_qte_attCmdAch();
         var12 = var10 * (double)this.chargementEntete.getChamobTauxTc() / 100.0D;
         var34 = this.utilNombre.myRound((var10 - var12) / (double)var1.getStk_qte_attCmdAch(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var34 = var1.getStk_pv();
      }

      var10 = var34 / (double)(1.0F + var6 / 100.0F);
      var1.setStk_pv(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = var1.getStkRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = var1.getStkRabais() * (double)var1.getStk_qte_attCmdAch();
      }

      double var14 = 0.0D;
      if (var1.getStkTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)var1.getStkTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (var1.getStkTauxRemise() != 0.0F) {
         var16 = var34 - var34 * (double)var1.getStkTauxRemise() / 100.0D - var12;
      } else {
         var16 = var34 - var12;
      }

      var1.setStk_qte_attCmdVte(var1.getStk_qte_attCmdAch());
      if (var1.getStk_qte_attCmdAch() != 0.0F && var1.getStk_code_produit() != null && !var1.getStk_code_produit().isEmpty()) {
         this.produits = this.produitsDao.chargeProduit(var1.getStk_code_produit(), var4);
         if (this.produits != null && this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty()) {
            var1.setStk_qte_attCmdVte(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.produits.getProCondition1(), var1.getStk_qte_attCmdAch(), this.produits.getProLongueur(), this.produits.getProLargeur(), this.produits.getProEpaisseur(), this.produits.getProDiamExt(), this.produits.getProNbUnite(), this.baseLog, this.utilInitHibernate, var4));
         }
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)var1.getStk_qte_attCmdAch();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var26 = var20 * (double)var1.getStk_qte_attCmdAch();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      var1.setStkPuRem(var18);
      var1.setStkPuRemTtc(var20);
      var1.setStkPt(var24);
      var1.setStkTva(var32);
      var1.setStkTtc(var28);
      this.avoirLigneVentes.setAvrligPt(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligPt(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTva(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTva(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTtc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTtc(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTc(), this.avoirEnteteVentes.getAvrDevise()));
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public void initImprimerAvoir() {
      if (this.avoirEnteteVentes != null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilTdt = new UtilTdt();
         String var1 = this.calculeCheminRapportAvoir(this.baseLog);
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.documentImpressionItems = new ArrayList();
         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var5));
               }
            }
         }

         this.choixImpression = 26;
         this.showModalPanelPrintAvoir = true;
      }

   }

   public void fermerImpressionAvoir() {
      this.showModalPanelPrintAvoir = false;
   }

   public void imprimerPRTAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerAvoir();
   }

   public void imprimerJRVAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerAvoir();
   }

   public void imprimerPDFAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerAvoir();
   }

   public void imprimerODTAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerAvoir();
   }

   public void imprimerXLSAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerAvoir();
   }

   public void imprimerDOCAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerAvoir();
   }

   public void imprimerHTMLAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerAvoir();
   }

   public void imprimerXMLAvoir() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerAvoir();
   }

   public String conversionGardeAvoir() throws HibernateException, NamingException {
      String var1 = null;
      if (this.avoirEnteteVentes.getAvrGarde() != null && !this.avoirEnteteVentes.getAvrGarde().isEmpty() && this.avoirEnteteVentes.getAvrGarde().contains(":")) {
         String[] var2 = this.avoirEnteteVentes.getAvrGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.avoirEnteteVentes.getUsers(), this.structureLog, this.avoirEnteteVentes.getTiers());
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

   public String conversionAnnexe1Avoir() throws HibernateException, NamingException {
      String var1 = null;
      if (this.avoirEnteteVentes.getAvrAnnexe1() != null && !this.avoirEnteteVentes.getAvrAnnexe1().isEmpty() && this.avoirEnteteVentes.getAvrAnnexe1().contains(":")) {
         String[] var2 = this.avoirEnteteVentes.getAvrAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.avoirEnteteVentes.getUsers(), this.structureLog, this.avoirEnteteVentes.getTiers());
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

   public String conversionAnnexe2Avoir() throws HibernateException, NamingException {
      String var1 = null;
      if (this.avoirEnteteVentes.getAvrAnnexe2() != null && !this.avoirEnteteVentes.getAvrAnnexe2().isEmpty() && this.avoirEnteteVentes.getAvrAnnexe2().contains(":")) {
         String[] var2 = this.avoirEnteteVentes.getAvrAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.avoirEnteteVentes.getUsers(), this.structureLog, this.avoirEnteteVentes.getTiers());
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

   public String calculeCheminRapportAvoir(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      return var2;
   }

   public String calculeImageFondAvoir(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatAvoir.jpg");
            if (var4.exists()) {
               var3 = "formatAvoir.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatAvoir.jpg");
         if (var4.exists()) {
            var3 = "formatAvoir.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunAvoir() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var2 = false;
         String var3 = "";
         double var4 = 0.0D;
         double var6 = 0.0D;
         this.infoOrigineDoc = "";
         new ArrayList();
         List var8 = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, (Session)null);

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.avoirLigneVentes = (AvoirLigneVentes)var8.get(var9);
            if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && this.avoirLigneVentes.getAvrligCode().equals("-")) {
               var2 = true;
               var3 = this.avoirLigneVentes.getAvrligLibelle();
               if (var3.startsWith("Suivant ") && (this.infoOrigineDoc == null || this.infoOrigineDoc.isEmpty())) {
                  this.infoOrigineDoc = var3;
               }
            }

            if (var2) {
               var4 += this.avoirLigneVentes.getAvrligPt();
               var6 = this.avoirLigneVentes.getAvrligTtc();
            }

            if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && this.avoirLigneVentes.getAvrligCode().equals("=") && var2) {
               this.avoirLigneVentes = new AvoirLigneVentes();
               this.avoirLigneVentes.setAvrligCode("=");
               this.avoirLigneVentes.setAvrligLibelle(var3);
               this.avoirLigneVentes.setAvrligPt(var4);
               this.avoirLigneVentes.setAvrligTtc(var6);
               var1.add(this.avoirLigneVentes);
               var4 = 0.0D;
               var6 = 0.0D;
               var2 = false;
            } else {
               var1.add(this.avoirLigneVentes);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc(), this.avoirEnteteVentes.getAvrDevise());
      JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(var1);
      return var10;
   }

   public boolean majDateImpressionAvoir(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.avoirEnteteVentes.getAvrDateImp() != null) {
            var2 = true;
         }

         this.avoirEnteteVentes.setAvrDateImp(new Date());
         if (this.avoirEnteteVentes.getAvrEtat() == 0 && this.avoirEnteteVentes.getAvrEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.avoirEnteteVentes.setAvrEtat(1);
         }

         this.avoirEnteteVentes.setAvrModeleImp(var1);
         this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var3);
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

   public void imprimerAvoir() throws IOException, IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         boolean var1 = this.majDateImpressionAvoir(this.nomModeleDocument);
         this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommunAvoir());
         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setEntete("Impression avoir");
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         this.utilPrint.setPageGarde(this.conversionGardeAvoir());
         this.utilPrint.setAnnexe1(this.conversionAnnexe1Avoir());
         this.utilPrint.setAnnexe2(this.conversionAnnexe2Avoir());
         this.utilPrint.setCheminRapport(this.calculeCheminRapportAvoir("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setImageFondPage(this.calculeImageFondAvoir("structure" + this.structureLog.getStrid(), this.chargementEntete.getChamobEtat()));
         this.utilPrint.setDuplicata("" + var1);
         this.utilPrint.setInfoOrigineDoc(this.infoOrigineDoc);
         this.utilPrint.setNbDecQte(this.optionsVentes.getNbDecQte());
         this.utilPrint.setNbDecPu(this.optionsVentes.getNbDecPu());
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
         this.utilPrint.setIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
         this.utilPrint.setTiersSelectionne(this.avoirEnteteVentes.getTiers());
         this.utilPrint.setNature(26);
         this.utilPrint.setId_doc(this.avoirEnteteVentes.getAvrId());
         if (this.avoirEnteteVentes.getAvrAnal2() != null && !this.avoirEnteteVentes.getAvrAnal2().isEmpty()) {
            String var2 = "";
            if (this.avoirEnteteVentes.getAvrAnal2().contains(":")) {
               String[] var3 = this.avoirEnteteVentes.getAvrAnal2().split(":");
               var2 = var3[0];
            } else {
               var2 = this.avoirEnteteVentes.getAvrAnal2();
            }

            new Parc();
            ParcDao var4 = new ParcDao(this.baseLog, this.utilInitHibernate);
            Parc var5 = var4.rechercheParc(var2, (Session)null);
            if (var5 != null) {
               this.utilPrint.setParc(var5);
            } else {
               this.utilPrint.setParc((Parc)null);
            }
         } else {
            this.utilPrint.setParc((Parc)null);
         }

         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void ajouterFrais() {
      this.produits = new Produits();
      this.chargementFrais = new ChargementFrais();
      this.chargementFrais.setChafraDate(new Date());
      this.var_frais = "";
      this.showModalPanelFrais = true;
   }

   public void selectionnerFrais() {
      if (this.datamodelFrais.isRowAvailable()) {
         this.chargementFrais = (ChargementFrais)this.datamodelFrais.getRowData();
         this.var_frais = this.chargementFrais.getChafraCode() + ":" + this.chargementFrais.getChafraLibelle();
      }

   }

   public void modifierFrais() {
      if (this.chargementFrais != null) {
         this.showModalPanelFrais = true;
      }

   }

   public void supprimerFrais() throws HibernateException, NamingException {
      if (this.chargementFrais != null) {
         this.chargementFraisDao.delete(this.chargementFrais);
         this.listFrais.remove(this.chargementFrais);
         this.datamodelFrais.setWrappedData(this.listFrais);
      }

   }

   public void annulerFrais() {
      this.showModalPanelFrais = false;
   }

   public void validerFrais() throws HibernateException, NamingException {
      if (this.produits != null && this.var_frais != null && !this.var_frais.isEmpty() && this.var_frais.contains(":")) {
         String[] var1 = this.var_frais.split(":");
         this.chargementFrais.setChafraCode(var1[0]);
         this.chargementFrais.setChafraLibelle(var1[1]);
         if (this.chargementFrais.getChafraId() == 0L) {
            this.chargementFrais.setChargementEntete(this.chargementEntete);
            this.chargementFrais = this.chargementFraisDao.insert(this.chargementFrais);
            this.listFrais.add(this.chargementFrais);
            this.datamodelFrais.setWrappedData(this.listFrais);
         } else {
            this.chargementFrais = this.chargementFraisDao.modif(this.chargementFrais);
         }
      }

      this.showModalPanelFrais = false;
   }

   public void calculeDechargement() throws HibernateException, NamingException {
      this.calculeDechargement((Session)null);
   }

   public void calculeDechargement(Session var1) throws HibernateException, NamingException {
      this.visibiliteBtonDechargement = false;
      this.listDechargement.clear();
      ArrayList var2 = new ArrayList();

      int var3;
      for(var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
         if (((ChargementLigne)this.lesLignesList.get(var3)).getChaligGenerique() != 5) {
            var2.add(this.lesLignesList.get(var3));
         }
      }

      for(var3 = 0; var3 < this.lesRechargementsList.size(); ++var3) {
         if (((ChargementLigne)this.lesRechargementsList.get(var3)).getChaligGenerique() != 5) {
            var2.add(this.lesRechargementsList.get(var3));
         }
      }

      for(var3 = 0; var3 < this.listAjoutProduit.size(); ++var3) {
         if (((ChargementLigne)this.listAjoutProduit.get(var3)).getChaligGenerique() != 5) {
            var2.add(this.listAjoutProduit.get(var3));
         }
      }

      if (this.chargementEntete.getChamobEtat() <= 3) {
         if (var2.size() != 0) {
            boolean var14 = false;
            if (var1 == null) {
               var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
               var14 = true;
            }

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               this.chargementLigne = (ChargementLigne)var2.get(var4);
               float var5 = 0.0F;
               float var6 = 0.0F;
               float var7 = 0.0F;
               String var8 = this.chargementLigne.getChaligCode();
               if (this.chargementLigne.getChaligCode() != null) {
                  int var10;
                  List var11;
                  int var13;
                  if (this.listFacture.size() != 0) {
                     new FactureEnteteVentes();

                     for(var10 = 0; var10 < this.listFacture.size(); ++var10) {
                        FactureEnteteVentes var9 = (FactureEnteteVentes)this.listFacture.get(var10);
                        this.factureLigneVentes = new FactureLigneVentes();
                        new ArrayList();
                        var11 = this.factureLigneVentesDao.chargerLesLignes(var9, var1);
                        if (var11.size() != 0) {
                           new FactureLigneVentes();

                           for(var13 = 0; var13 < var11.size(); ++var13) {
                              FactureLigneVentes var12 = (FactureLigneVentes)var11.get(var13);
                              if (var12.getFacligCode().equals(var8)) {
                                 if (var12.getFacligTauxRemise() == 100.0F) {
                                    var6 += var12.getFacligQte();
                                 } else {
                                    var5 += var12.getFacligQte();
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (this.listAvoir.size() != 0) {
                     new AvoirEnteteVentes();

                     for(var10 = 0; var10 < this.listAvoir.size(); ++var10) {
                        AvoirEnteteVentes var15 = (AvoirEnteteVentes)this.listAvoir.get(var10);
                        this.avoirLigneVentes = new AvoirLigneVentes();
                        new ArrayList();
                        var11 = this.avoirLigneVentesDao.chargerLesLignes(var15, var1);
                        if (var11.size() != 0) {
                           new AvoirLigneVentes();

                           for(var13 = 0; var13 < var11.size(); ++var13) {
                              AvoirLigneVentes var16 = (AvoirLigneVentes)var11.get(var13);
                              if (var16.getAvrligCode().equals(var8)) {
                                 var7 += var16.getAvrligQte();
                              }
                           }
                        }
                     }
                  }
               }

               this.chargementLigne.setChaligQteFacture(var5);
               this.chargementLigne.setChaligQteDon(var6);
               this.chargementLigne.setChaligQteAvoir(var7);
               this.calculeEcart();
               this.listDechargement.add(this.chargementLigne);
            }

            if (var14) {
               this.utilInitHibernate.closeSession();
            }
         }
      } else if (var2.size() != 0) {
         for(var3 = 0; var3 < var2.size(); ++var3) {
            this.chargementLigne = (ChargementLigne)var2.get(var3);
            this.calculeEcart();
            this.listDechargement.add(this.chargementLigne);
         }
      }

      this.datamodelDechargement.setWrappedData(this.listDechargement);
      this.ongletActif = "tabDechargement";
   }

   public void selectionnerDechargement() {
      if (this.datamodelDechargement.isRowAvailable()) {
         this.chargementLigne = (ChargementLigne)this.datamodelDechargement.getRowData();
         if (this.chargementLigne.getChaligRechargement() == 2) {
            this.visibiliteBtonDechargement = true;
         } else {
            this.visibiliteBtonDechargement = false;
         }
      }

   }

   public void calculeEcart() {
      if (this.chargementLigne != null) {
         float var1 = this.chargementLigne.getChaligQteFacture() + this.chargementLigne.getChaligQteDon();
         float var2 = this.chargementLigne.getChaligQteNconforme() + this.chargementLigne.getChaligQtePerime() + this.chargementLigne.getChaligQteDefectueux() + this.chargementLigne.getChaligQteManquant();
         float var3 = this.chargementLigne.getChaligQteCharg() - var1 - var2 + this.chargementLigne.getChaligQteReprise() - this.chargementLigne.getChaligQteRetour();
         this.chargementLigne.setChaligQteEcart(var3);
      }

   }

   public void ajouterProduit() {
      this.produits = new Produits();
      this.chargementLigne = new ChargementLigne();
      this.showModalPanelProduit = true;
   }

   public void fermerProduit() {
      this.showModalPanelProduit = false;
   }

   public void validerProduit() throws IOException, HibernateException, NamingException, Exception {
      this.saveOneLigneNouveauProduit();
      this.showModalPanelProduit = false;
   }

   public void saveOneLigneNouveauProduit() throws IOException, HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargementLigne.setChaligDateChargement((Date)null);
         this.calculPrix(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTauxTaxe(), var1);
         if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
            ConditionnementDao var3 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            String[] var4 = this.chargementLigne.getChaligCondition().split(":");
            String var5 = var3.rechercheConditionnement(var4[0], var1).getCdtDescription();
            if (var5 != null && !var5.isEmpty()) {
               this.chargementLigne.setChaligDescription(var5);
            } else {
               this.chargementLigne.setChaligDescription("");
            }
         } else {
            this.chargementLigne.setChaligDescription("");
         }

         this.chargementLigne.setChaligRechargement(2);
         this.chargementLigne.setChaligDepotCharg(this.chargementEntete.getChamobDepotCharg());
         if (this.chargementLigne.getChaligId() == 0L) {
            this.chargementLigne.setChargementEntete(this.chargementEntete);
            this.chargementLigne = this.chargementLigneDao.insert(this.chargementLigne, var1);
            this.listAjoutProduit.add(this.chargementLigne);
            this.listDechargement.add(this.chargementLigne);
            this.datamodelDechargement.setWrappedData(this.listDechargement);
         } else {
            this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var1);
         }

         this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var1);
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

   public void suppressionNouveauProduit() throws NamingException {
      if (this.chargementLigne.getChaligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.chargementLigne.getChaligCode();
            this.chargementLigneDao.deleteOneLigne(this.chargementLigne, var1);
            this.listAjoutProduit.remove(this.chargementLigne);
            this.listDechargement.remove(this.chargementLigne);
            this.datamodelDechargement.setWrappedData(this.listDechargement);
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit " + var3 + " du Chargement N° " + this.chargementEntete.getChamobNum() + " du " + this.chargementEntete.getChamobDate());
            this.espionDao.mAJEspion(var4, var1);
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

      this.visibiliteBtonDechargement = false;
      this.chargementLigne = new ChargementLigne();
   }

   public void selectionnerNoteDebit() {
      if (this.dataModelNoteDebit.isRowAvailable()) {
         this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)this.dataModelNoteDebit.getRowData();
      }

   }

   public void majNoteDebit(Session var1) throws HibernateException, NamingException, ParseException {
      new Tiers();
      TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
      String var4 = "AGENT:" + this.chargementEntete.getChamobIdCommercial();
      Tiers var2 = var3.selectTierSigle(var4, var1);
      if (var2 == null) {
         new Users();
         Users var5 = this.usersDao.selectLeUserId(this.chargementEntete.getChamobIdCommercial(), var1);
         if (var5 != null) {
            var2 = new Tiers();
            var2.setTieadresse(var5.getUsrAdresse());
            var2.setTieanniversaire(var5.getUsrAnniversaire());
            var2.setTiebp(var5.getUsrBp());
            var2.setTiecel1(var5.getUsrCel1());
            var2.setTiecel2(var5.getUsrCel2());
            var2.setTiecel3(var5.getUsrCel3());
            var2.setTiecivilite(var5.getUsrCivilite());
            if (!var5.getUsrCivilite().contains("Madame") && !var5.getUsrCivilite().contains("Mademoiselle")) {
               var2.setTiesexe(1);
            } else {
               var2.setTiesexe(0);
            }

            var2.setTiedatecreat(new Date());
            var2.setTiedatemodif((Date)null);
            var2.setTieFormatDevise(this.structureLog.getStrformatdevise());
            var2.setTiedevise(this.structureLog.getStrdevise());
            var2.setTiecodepays(this.structureLog.getStrcodepays());
            var2.setTienompays(this.structureLog.getStrnompays());
            var2.setTiefacpr(0);
            var2.setTielangue(var5.getUsrLangue());
            var2.setTiemail1(var5.getUsrMail());
            var2.setTiemsn(var5.getUsrMsn());
            var2.setTieraisonsocialenom(var5.getUsrNom());
            var2.setTieprenom(var5.getUsrPrenom());
            var2.setTieskype(var5.getUsrSkype());
            var2.setTietelemployeur(var5.getUsrTelBureau());
            var2.setTieteldom(var5.getUsrTelDomicile());
            var2.setTieusercreat(this.usersLog.getUsrid());
            var2.setTieusermodif(0L);
            var2.setTieville(var5.getUsrVille());
            var2.setTieyahoo(var5.getUsrYahoo());
            var2.setTiecategorie("Client Individuel");
            var2.setTiegenre("030");
            var2.setTietype("3");
            var2.setTiesigle(var4);
            var2 = var3.insert(var2, var1);
         }
      }

      if (var2 != null) {
         this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
         this.noteDebitEnteteVentes.setNdbSite(this.usersLog.getUsrSite());
         this.noteDebitEnteteVentes.setNdbDepartement(this.usersLog.getUsrDepartement());
         this.noteDebitEnteteVentes.setNdbService(this.usersLog.getUsrService());
         this.noteDebitEnteteVentes.setNdbRegion(var2.getTieregion());
         this.noteDebitEnteteVentes.setNdbSecteur(var2.getTiesecteur());
         this.noteDebitEnteteVentes.setNdbPdv(var2.getTiepdv());
         this.noteDebitEnteteVentes.setNdbActivite("");
         this.noteDebitEnteteVentes.setNdbAnal4("");
         this.noteDebitEnteteVentes.setNdbAnal2("");
         new Habilitation();
         HabilitationDao var6 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
         Habilitation var22 = var6.existenceHabilitation(27, var1);
         if (var22 != null) {
            this.noteDebitEnteteVentes.setNdbEtatVal(1);
            this.noteDebitEnteteVentes.setNdbEtat(0);
            this.noteDebitEnteteVentes.setNdbDateValide((Date)null);
         } else {
            this.noteDebitEnteteVentes.setNdbEtatVal(0);
            if (this.usersChrono != null) {
               if (this.usersChrono.getUsrchrValidation() == 0) {
                  this.noteDebitEnteteVentes.setNdbEtat(1);
                  this.noteDebitEnteteVentes.setNdbDateValide(new Date());
               } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
                  this.noteDebitEnteteVentes.setNdbEtat(0);
                  this.noteDebitEnteteVentes.setNdbDateValide((Date)null);
               }
            }
         }

         this.var_heure_doc = "00";
         this.var_minute_doc = "00";
         this.var_seconde_doc = "00";
         this.noteDebitEnteteVentes.setNdbDate(this.utilDate.dateToSQL(this.chargementEntete.getChamobDate(), this.var_heure_doc, this.var_minute_doc, this.var_seconde_doc));
         if (this.noteDebitEnteteVentes.getUsers() == null) {
            this.noteDebitEnteteVentes.setUsers(this.usersLog);
         }

         this.noteDebitEnteteVentes.setTiers(var2);
         if (!var2.getTiegenre().equalsIgnoreCase("010") && !var2.getTiegenre().equalsIgnoreCase("020") && !var2.getTiegenre().equalsIgnoreCase("030") && !var2.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.noteDebitEnteteVentes.setNdbCivilTiers("");
         } else {
            this.nomTier = var2.getTieraisonsocialenom() + " " + var2.getTieprenom();
            this.noteDebitEnteteVentes.setNdbCivilTiers(this.noteDebitEnteteVentes.getTiers().getTiecivilite());
         }

         this.noteDebitEnteteVentes.setNdbNomTiers(this.nomTier);
         this.noteDebitEnteteVentes.setNdbTypeReg(var2.getTietypereg());
         this.noteDebitEnteteVentes.setNdbModeReg(var2.getTiemodereg());
         this.noteDebitEnteteVentes.setNdbIdContact(0L);
         this.noteDebitEnteteVentes.setNdbNomContact("");
         this.noteDebitEnteteVentes.setNdbCivilContact("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var7 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var7 != null) {
            this.noteDebitEnteteVentes.setNdbIdResponsable(var7.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomResponsable(var7.getUsrPatronyme());
         } else {
            this.noteDebitEnteteVentes.setNdbIdResponsable(0L);
            this.noteDebitEnteteVentes.setNdbNomResponsable("");
         }

         new Users();
         if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
            this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
         }

         Users var8 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
         if (var8 != null) {
            this.noteDebitEnteteVentes.setNdbIdCommercial(var8.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomCommercial(var8.getUsrPatronyme());
         } else {
            this.noteDebitEnteteVentes.setNdbIdCommercial(0L);
            this.noteDebitEnteteVentes.setNdbNomCommercial("");
         }

         this.noteDebitEnteteVentes.setNdbIdEquipe(0L);
         this.noteDebitEnteteVentes.setNdbNomEquipe("");
         if (this.var_timbre != 0) {
            int var9 = this.var_date.getYear() + 1900;
            double var10 = this.utilNombre.calculTimbre(this.structureLog, this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc(), var9, this.noteDebitEnteteVentes.getNdbDevise(), this.noteDebitEnteteVentes.getNdbDate());
            double var12 = this.utilNombre.myRoundDevise(var10, this.noteDebitEnteteVentes.getNdbDevise());
            if (var12 != 0.0D) {
               String var14 = this.utilNombre.beginSimple(var12, this.noteDebitEnteteVentes.getNdbDevise());
               this.factureEnteteVentes.setFacFormule2(this.utilNombre.texteTimbre(this.structureLog, var14, var9, this.noteDebitEnteteVentes.getNdbDevise(), this.noteDebitEnteteVentes.getNdbDate()));
            }
         }

         this.noteDebitEnteteVentes.setNdbCat(this.chargementEntete.getChamobCat());
         this.noteDebitEnteteVentes.setNdbDevise(this.structureLog.getStrdevise());
         this.noteDebitEnteteVentes.setNdbSerie(this.chargementEntete.getChamobSerie());
         this.noteDebitEnteteVentes.setNdbContrat("CH:" + this.chargementEntete.getChamobNum());
         if (this.noteDebitEnteteVentes.getNdbId() != 0L) {
            this.noteDebitEnteteVentes.setNdbDateModif(new Date());
            this.noteDebitEnteteVentes.setNdbIdModif(this.usersLog.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomModif(this.usersLog.getUsrPatronyme());
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
         } else {
            this.noteDebitEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.noteDebitEnteteVentes.setNdbDateCreat(new Date());
            this.noteDebitEnteteVentes.setNdbIdCreateur(this.usersLog.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomCreateur(this.usersLog.getUsrPatronyme());
            if (this.noteDebitEnteteVentes.getNdbSerie() != null && !this.noteDebitEnteteVentes.getNdbSerie().equalsIgnoreCase("X") && !this.noteDebitEnteteVentes.getNdbSerie().isEmpty()) {
               this.noteDebitEnteteVentes.setNdbNum(this.calculChrono.numCompose(this.noteDebitEnteteVentes.getNdbDate(), 27, this.noteDebitEnteteVentes.getNdbSerie(), var1));
            } else {
               long var23 = this.noteDebitEnteteVentesDao.selectLastNum(var1);
               this.noteDebitEnteteVentes.setNdbNum("" + var23);
            }

            this.noteDebitEnteteVentes.setNdbEtat(0);
            this.noteDebitEnteteVentes.setNdbEtatVal(0);
            this.noteDebitEnteteVentes.setNdbDateValide((Date)null);
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.insert(this.noteDebitEnteteVentes, var1);
            this.listNoteDebit.add(this.noteDebitEnteteVentes);
            this.dataModelNoteDebit.setWrappedData(this.listNoteDebit);
         }

         double var24 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         if (this.listDechargement.size() != 0) {
            for(int var19 = 0; var19 < this.listDechargement.size(); ++var19) {
               this.chargementLigne = (ChargementLigne)this.listDechargement.get(var19);
               if (this.chargementLigne != null && this.chargementLigne.getChaligQteEcart() > 0.0F) {
                  this.noteDebitLigneVentes = new NoteDebitLigneVentes();
                  this.noteDebitLigneVentes.setNoteDebitEnteteVentes(this.noteDebitEnteteVentes);
                  this.noteDebitLigneVentes.setNdbligCode(this.chargementLigne.getChaligCode());
                  this.noteDebitLigneVentes.setNdbligCondition(this.chargementLigne.getChaligCondition());
                  this.noteDebitLigneVentes.setNdbligDepot(this.chargementLigne.getChaligDepotCharg());
                  this.noteDebitLigneVentes.setNdbligDescription(this.chargementLigne.getChaligDescription());
                  this.noteDebitLigneVentes.setNdbligDevise(this.structureLog.getStrdevise());
                  this.noteDebitLigneVentes.setNdbligDiam(this.chargementLigne.getChaligDiam());
                  this.noteDebitLigneVentes.setNdbligEchelle(this.chargementLigne.getChaligEchelle());
                  this.noteDebitLigneVentes.setNdbligFamille(this.chargementLigne.getChaligFamille());
                  this.noteDebitLigneVentes.setNdbligHaut(this.chargementLigne.getChaligHaut());
                  this.noteDebitLigneVentes.setNdbligLarg(this.chargementLigne.getChaligLarg());
                  this.noteDebitLigneVentes.setNdbligLibelle(this.chargementLigne.getChaligLibelle());
                  this.noteDebitLigneVentes.setNdbligLong(this.chargementLigne.getChaligLong());
                  this.noteDebitLigneVentes.setNdbligLot("");
                  this.noteDebitLigneVentes.setNdbligNb(this.chargementLigne.getChaligNb());
                  this.noteDebitLigneVentes.setNdbligNumSerie("");
                  this.noteDebitLigneVentes.setNdbligPoidsBrut(this.chargementLigne.getChaligPoidsBrut());
                  this.noteDebitLigneVentes.setNdbligPoidsNet(this.chargementLigne.getChaligPoidsNet());
                  this.noteDebitLigneVentes.setNdbligPump(this.chargementLigne.getChaligPump());
                  this.noteDebitLigneVentes.setNdbligReference(this.chargementLigne.getChaligReference());
                  this.noteDebitLigneVentes.setNdbligStock(this.chargementLigne.getChaligStock());
                  this.noteDebitLigneVentes.setNdbligTauxTaxe(this.chargementLigne.getChaligTauxTaxe());
                  this.noteDebitLigneVentes.setNdbligTaxe(this.chargementLigne.getChaligTaxe());
                  this.noteDebitLigneVentes.setNdbligUnite(this.chargementLigne.getChaligUnite());
                  this.noteDebitLigneVentes.setNdbligVolume(this.chargementLigne.getChaligVolume());
                  this.noteDebitLigneVentes.setNdbligRabais(0.0D);
                  this.noteDebitLigneVentes.setNdbligTauxRemise(0.0F);
                  this.noteDebitLigneVentes.setNdbligQte(this.chargementLigne.getChaligQteEcart());
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.noteDebitLigneVentes.setNdbligPuTtc(this.chargementLigne.getChaligPuTtc());
                  } else {
                     this.noteDebitLigneVentes.setNdbligPu(this.chargementLigne.getChaligPu());
                  }

                  this.noteDebitLigneVentes.setNdbligQteStock(0.0F);
                  this.calculPrixNoteDebit(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var1);
                  double var20 = 0.0D;
                  if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.noteDebitLigneVentes.getNdbligDepot() != null && !this.noteDebitLigneVentes.getNdbligDepot().isEmpty()) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.noteDebitLigneVentes.getNdbligCode(), this.noteDebitLigneVentes.getNdbligDepot(), var1);
                     if (this.produitsDepot != null) {
                        var20 = this.produitsDepot.getProdepPump();
                     }
                  }

                  this.noteDebitLigneVentes.setNdbligPump(var20);
                  this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.insertLigne(this.noteDebitLigneVentes, var1);
                  var24 += this.noteDebitLigneVentes.getNdbligPt();
                  var11 += this.noteDebitLigneVentes.getNdbligTva();
                  var13 += this.noteDebitLigneVentes.getNdbligTtc();
                  var15 += this.noteDebitLigneVentes.getNdbligTc();
                  if (this.noteDebitLigneVentes.getNdbligRabais() != 0.0D || this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
                     var17 += this.noteDebitLigneVentes.getNdbligPu() * (double)this.noteDebitLigneVentes.getNdbligQteUtil() - this.noteDebitLigneVentes.getNdbligPt();
                  }
               }
            }
         }

         this.noteDebitEnteteVentes.setNdbTotHt(var24);
         this.noteDebitEnteteVentes.setNdbTotTva(var11);
         this.noteDebitEnteteVentes.setNdbTotTtc(var13);
         this.noteDebitEnteteVentes.setNdbTotRemise(var17);
         this.noteDebitEnteteVentes.setNdbTotTc(var15);
         this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
         DocumentTraceVentes var25 = new DocumentTraceVentes();
         var25.setDoctraDateCreat(new Date());
         var25.setDoctraUserId(this.usersLog.getUsrid());
         var25.setDoctraUserNom(this.usersLog.getUsrNom());
         var25.setExerciceventes(this.noteDebitEnteteVentes.getExerciceventes());
         var25.setDoctraOrgType(this.nature);
         var25.setDoctraOrgSerie(this.chargementEntete.getChamobSerie());
         var25.setDoctraOrgId(this.chargementEntete.getChamobId());
         var25.setDoctraOrgNum(this.chargementEntete.getChamobNum());
         var25.setDoctraOrgDate(this.chargementEntete.getChamobDate());
         var25.setDoctraDstType(27);
         var25.setDoctraDstSerie(this.noteDebitEnteteVentes.getNdbSerie());
         var25.setDoctraDstId(this.noteDebitEnteteVentes.getNdbId());
         var25.setDoctraDstNum(this.noteDebitEnteteVentes.getNdbNum());
         var25.setDoctraDstDate(this.noteDebitEnteteVentes.getNdbDate());
         this.documentTraceVentesDao.insert(var25, var1);
      }

   }

   public void calculPrixNoteDebit(String var1, float var2, Session var3) throws HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         this.calculTtcNdb(var1, var2, var3);
      } else {
         this.calculHtNdb(var1, var2, var3);
      }

   }

   public void calculHtNdb(String var1, float var2, Session var3) throws HibernateException, NamingException {
      float var4 = 0.0F;
      String var5 = "";
      int var6 = 0;
      if (var1 != null && !var1.isEmpty() && var2 == 0.0F) {
         new TaxesVentes();
         TaxesVentes var7 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
         if (var7 != null) {
            var4 = var7.getTaxvteTaux();
            var5 = var7.getTaxvteCode();
            var6 = var7.getTaxvteType();
         }
      } else {
         var4 = var2;
         var5 = var1;
         var6 = 0;
      }

      this.noteDebitLigneVentes.setNdbligTaxe(var5);
      this.noteDebitLigneVentes.setNdbligTauxTaxe(var4);
      double var29 = this.noteDebitLigneVentes.getNdbligPu();
      if (var6 == 3) {
         float var9 = 100.0F - var4;
         var29 = this.utilNombre.myRoundDevise(var29 / (double)var9 * 100.0D, this.structureLog.getStrdevise());
      }

      if (this.noteDebitLigneVentes.getNdbligQte() != 0.0F) {
         this.noteDebitLigneVentes.setNdbligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.noteDebitLigneVentes.getNdbligCondition(), this.noteDebitLigneVentes.getNdbligQte(), this.noteDebitLigneVentes.getNdbligLong(), this.noteDebitLigneVentes.getNdbligLarg(), this.noteDebitLigneVentes.getNdbligHaut(), this.noteDebitLigneVentes.getNdbligDiam(), this.noteDebitLigneVentes.getNdbligNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.noteDebitLigneVentes.setNdbligQteUtil(0.0F);
      }

      double var30 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
         var30 = var29 * (double)this.noteDebitLigneVentes.getNdbligQte();
      } else {
         var30 = var29 * (double)this.noteDebitLigneVentes.getNdbligQte();
      }

      double var11 = 0.0D;
      double var13 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var13 = this.noteDebitLigneVentes.getNdbligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var13 = this.noteDebitLigneVentes.getNdbligRabais() * (double)this.noteDebitLigneVentes.getNdbligQte();
      }

      if (this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
         var11 = var30 - var30 * (double)this.noteDebitLigneVentes.getNdbligTauxRemise() / 100.0D - var13;
      } else {
         var11 = var30 - var13;
      }

      double var15 = this.utilNombre.myRoundFormat(var11, this.var_format_devise);
      double var17 = var15 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
      if (var6 == 2) {
         var17 *= -1.0D;
      } else if (var6 == 3) {
         var17 = var15 * (double)(var4 / 100.0F);
         var17 *= -1.0D;
      }

      double var19 = this.utilNombre.myRoundFormat(var17, this.var_format_devise);
      double var21 = var15 + var19;
      double var23 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
         var23 = this.utilNombre.myRound(var15 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      } else {
         var23 = this.utilNombre.myRound(var15 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      }

      this.noteDebitLigneVentes.setNdbligPuRem(var23);
      this.noteDebitLigneVentes.setNdbligPt(var15);
      this.noteDebitLigneVentes.setNdbligTva(var19);
      this.noteDebitLigneVentes.setNdbligTc(0.0D);
      this.noteDebitLigneVentes.setNdbligTtc(var21);
      double var25 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
         var25 = this.utilNombre.myRound(var21 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      } else {
         var25 = this.utilNombre.myRound(var21 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      }

      this.noteDebitLigneVentes.setNdbligPuRemTtc(var25);
      double var27 = var29 + var29 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
      this.noteDebitLigneVentes.setNdbligPuTtc(var27);
      this.noteDebitLigneVentes.setNdbligPt(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligPt(), this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligTva(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligTva(), this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligTtc(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligTtc(), this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligTc(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligTc(), this.noteDebitEnteteVentes.getNdbDevise()));
   }

   public void calculTtcNdb(String var1, float var2, Session var3) throws HibernateException, NamingException {
      float var4 = 0.0F;
      String var5 = "";
      if (var1 != null && !var1.isEmpty() && var2 == 0.0F) {
         new TaxesVentes();
         TaxesVentes var6 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
         if (var6 != null) {
            var4 = var6.getTaxvteTaux();
            var5 = var6.getTaxvteCode();
         }
      } else {
         var4 = var2;
         var5 = var1;
      }

      this.noteDebitLigneVentes.setNdbligTaxe(var5);
      this.noteDebitLigneVentes.setNdbligTauxTaxe(var4);
      double var32 = 0.0D;
      double var8;
      double var10;
      if (this.noteDebitEnteteVentes.getNdbTauxTc() != 0.0F) {
         var8 = this.noteDebitLigneVentes.getNdbligPuTtc() * (double)this.noteDebitLigneVentes.getNdbligQte();
         var10 = var8 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
         var32 = this.utilNombre.myRound((var8 - var10) / (double)this.noteDebitLigneVentes.getNdbligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var32 = this.noteDebitLigneVentes.getNdbligPuTtc();
      }

      var8 = var32 / (double)(1.0F + var4 / 100.0F);
      this.noteDebitLigneVentes.setNdbligPu(this.utilNombre.myRound(var8, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var10 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var10 = this.noteDebitLigneVentes.getNdbligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var10 = this.noteDebitLigneVentes.getNdbligRabais() * (double)this.noteDebitLigneVentes.getNdbligQte();
      }

      double var12 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
         var12 = var8 - var8 * (double)this.noteDebitLigneVentes.getNdbligTauxRemise() / 100.0D - var10;
      } else {
         var12 = var8 - var10;
      }

      double var14 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
         var14 = var32 - var32 * (double)this.noteDebitLigneVentes.getNdbligTauxRemise() / 100.0D - var10;
      } else {
         var14 = var32 - var10;
      }

      if (this.noteDebitLigneVentes.getNdbligQte() != 0.0F) {
         this.noteDebitLigneVentes.setNdbligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.noteDebitLigneVentes.getNdbligCondition(), this.noteDebitLigneVentes.getNdbligQte(), this.noteDebitLigneVentes.getNdbligLong(), this.noteDebitLigneVentes.getNdbligLarg(), this.noteDebitLigneVentes.getNdbligHaut(), this.noteDebitLigneVentes.getNdbligDiam(), this.noteDebitLigneVentes.getNdbligNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.noteDebitLigneVentes.setNdbligQteUtil(0.0F);
      }

      double var16 = this.utilNombre.myRound(var12, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = var16 * (double)this.noteDebitLigneVentes.getNdbligQte();
      double var22 = this.utilNombre.myRound(var20, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var24 = var18 * (double)this.noteDebitLigneVentes.getNdbligQte();
      double var26 = this.utilNombre.myRound(var24, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var28 = var26 - var22;
      double var30 = this.utilNombre.myRound(var28, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.noteDebitLigneVentes.setNdbligPuRem(var16);
      this.noteDebitLigneVentes.setNdbligPuRemTtc(var18);
      this.noteDebitLigneVentes.setNdbligPt(var22);
      this.noteDebitLigneVentes.setNdbligTva(var30);
      this.noteDebitLigneVentes.setNdbligTtc(var26);
      this.noteDebitLigneVentes.setNdbligPt(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligPt(), this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligTva(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligTva(), this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligTtc(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligTtc(), this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligTc(this.utilNombre.myRoundDevise(this.noteDebitLigneVentes.getNdbligTc(), this.noteDebitEnteteVentes.getNdbDevise()));
   }

   public void initImprimerNoteDebit() {
      if (this.noteDebitEnteteVentes != null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilTdt = new UtilTdt();
         String var1 = this.calculeCheminRapportNoteDebit(this.baseLog);
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.documentImpressionItems = new ArrayList();
         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var5));
               }
            }
         }

         this.choixImpression = 27;
         this.showModalPanelPrintNoteDebit = true;
      }

   }

   public void fermerImpressionNoteDebit() {
      this.showModalPanelPrintNoteDebit = false;
   }

   public void imprimerPRTNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerNoteDebit();
   }

   public void imprimerJRVNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerNoteDebit();
   }

   public void imprimerPDFNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerNoteDebit();
   }

   public void imprimerODTNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerNoteDebit();
   }

   public void imprimerXLSNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerNoteDebit();
   }

   public void imprimerDOCNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerNoteDebit();
   }

   public void imprimerHTMLNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerNoteDebit();
   }

   public void imprimerXMLNoteDebit() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerNoteDebit();
   }

   public String conversionGardeNoteDebit() throws HibernateException, NamingException {
      String var1 = null;
      if (this.noteDebitEnteteVentes.getNdbGarde() != null && !this.noteDebitEnteteVentes.getNdbGarde().isEmpty() && this.noteDebitEnteteVentes.getNdbGarde().contains(":")) {
         String[] var2 = this.noteDebitEnteteVentes.getNdbGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.noteDebitEnteteVentes.getUsers(), this.structureLog, this.noteDebitEnteteVentes.getTiers());
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

   public String conversionAnnexe1NoteDebit() throws HibernateException, NamingException {
      String var1 = null;
      if (this.noteDebitEnteteVentes.getNdbAnnexe1() != null && !this.noteDebitEnteteVentes.getNdbAnnexe1().isEmpty() && this.noteDebitEnteteVentes.getNdbAnnexe1().contains(":")) {
         String[] var2 = this.noteDebitEnteteVentes.getNdbAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.noteDebitEnteteVentes.getUsers(), this.structureLog, this.noteDebitEnteteVentes.getTiers());
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

   public String conversionAnnexe2NoteDebit() throws HibernateException, NamingException {
      String var1 = null;
      if (this.noteDebitEnteteVentes.getNdbAnnexe2() != null && !this.noteDebitEnteteVentes.getNdbAnnexe2().isEmpty() && this.noteDebitEnteteVentes.getNdbAnnexe2().contains(":")) {
         String[] var2 = this.noteDebitEnteteVentes.getNdbAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.noteDebitEnteteVentes.getUsers(), this.structureLog, this.noteDebitEnteteVentes.getTiers());
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

   public String calculeCheminRapportNoteDebit(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      return var2;
   }

   public String calculeImageFondNoteDebit(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatNoteDebit.jpg");
            if (var4.exists()) {
               var3 = "formatNoteDebit.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatNoteDebit.jpg");
         if (var4.exists()) {
            var3 = "formatNoteDebit.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunNoteDebit() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.listNoteDebit.size() != 0) {
         boolean var2 = false;
         String var3 = "";
         double var4 = 0.0D;
         double var6 = 0.0D;
         this.infoOrigineDoc = "";
         new ArrayList();
         List var8 = this.noteDebitLigneVentesDao.chargerLesLignes(this.noteDebitEnteteVentes, (Session)null);

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            this.noteDebitLigneVentes = (NoteDebitLigneVentes)var8.get(var9);
            if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.noteDebitLigneVentes.getNdbligCode().equals("-")) {
               var2 = true;
               var3 = this.noteDebitLigneVentes.getNdbligLibelle();
               if (var3.startsWith("Suivant ") && (this.infoOrigineDoc == null || this.infoOrigineDoc.isEmpty())) {
                  this.infoOrigineDoc = var3;
               }
            }

            if (var2) {
               var4 += this.noteDebitLigneVentes.getNdbligPt();
               var6 = this.noteDebitLigneVentes.getNdbligTtc();
            }

            if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.noteDebitLigneVentes.getNdbligCode().equals("=") && var2) {
               this.noteDebitLigneVentes = new NoteDebitLigneVentes();
               this.noteDebitLigneVentes.setNdbligCode("=");
               this.noteDebitLigneVentes.setNdbligLibelle(var3);
               this.noteDebitLigneVentes.setNdbligPt(var4);
               this.noteDebitLigneVentes.setNdbligTtc(var6);
               var1.add(this.noteDebitLigneVentes);
               var4 = 0.0D;
               var6 = 0.0D;
               var2 = false;
            } else {
               var1.add(this.noteDebitLigneVentes);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc(), this.noteDebitEnteteVentes.getNdbDevise());
      JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(var1);
      return var10;
   }

   public boolean majDateImpressionNoteDebit(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.noteDebitEnteteVentes.getNdbDateImp() != null) {
            var2 = true;
         }

         this.noteDebitEnteteVentes.setNdbDateImp(new Date());
         if (this.noteDebitEnteteVentes.getNdbEtat() == 0 && this.noteDebitEnteteVentes.getNdbEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.noteDebitEnteteVentes.setNdbEtat(1);
         }

         this.noteDebitEnteteVentes.setNdbModeleImp(var1);
         this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var3);
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

   public void imprimerNoteDebit() throws IOException, IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         boolean var1 = this.majDateImpressionNoteDebit(this.nomModeleDocument);
         this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommunNoteDebit());
         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setEntete("Impression note débit");
         this.utilPrint.setMontant_lettre(this.montant_lettre);
         this.utilPrint.setPageGarde(this.conversionGardeNoteDebit());
         this.utilPrint.setAnnexe1(this.conversionAnnexe1NoteDebit());
         this.utilPrint.setAnnexe2(this.conversionAnnexe2NoteDebit());
         this.utilPrint.setCheminRapport(this.calculeCheminRapportNoteDebit("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setImageFondPage(this.calculeImageFondNoteDebit("structure" + this.structureLog.getStrid(), this.chargementEntete.getChamobEtat()));
         this.utilPrint.setDuplicata("" + var1);
         this.utilPrint.setInfoOrigineDoc(this.infoOrigineDoc);
         this.utilPrint.setNbDecQte(this.optionsVentes.getNbDecQte());
         this.utilPrint.setNbDecPu(this.optionsVentes.getNbDecPu());
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
         this.utilPrint.setIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
         this.utilPrint.setTiersSelectionne(this.noteDebitEnteteVentes.getTiers());
         this.utilPrint.setNature(27);
         this.utilPrint.setId_doc(this.noteDebitEnteteVentes.getNdbId());
         if (this.noteDebitEnteteVentes.getNdbAnal2() != null && !this.noteDebitEnteteVentes.getNdbAnal2().isEmpty()) {
            String var2 = "";
            if (this.noteDebitEnteteVentes.getNdbAnal2().contains(":")) {
               String[] var3 = this.noteDebitEnteteVentes.getNdbAnal2().split(":");
               var2 = var3[0];
            } else {
               var2 = this.noteDebitEnteteVentes.getNdbAnal2();
            }

            new Parc();
            ParcDao var4 = new ParcDao(this.baseLog, this.utilInitHibernate);
            Parc var5 = var4.rechercheParc(var2, (Session)null);
            if (var5 != null) {
               this.utilPrint.setParc(var5);
            } else {
               this.utilPrint.setParc((Parc)null);
            }
         } else {
            this.utilPrint.setParc((Parc)null);
         }

         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.factureEnteteVentes != null) {
         this.tiers = this.formRecherche.rechercheTiers(3, this.factureEnteteVentes.getFacNomTiers(), this.nature);
      } else if (this.avoirEnteteVentes != null) {
         this.tiers = this.formRecherche.rechercheTiers(3, this.avoirEnteteVentes.getAvrNomTiers(), this.nature);
      }

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
         } else if (this.factureEnteteVentes != null) {
            this.factureEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
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
            String var8 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var8 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var8 = this.tiers.getTiemodereg();
            }

            if (!var8.equals("") && !var8.equals("100")) {
               this.factureEnteteVentes.setFacNbJourReg(this.tiers.getTienbecheance());
               this.factureEnteteVentes.setFacArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(int var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
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
            this.factureEnteteVentes.setFacCat(this.tiers.getTienomfamille());
            this.factureEnteteVentes.setFacExoDouane(this.tiers.getTieexodouane());
            this.factureEnteteVentes.setFacExoTva(this.tiers.getTieexotva());
            if (this.var_tc_calcul) {
               this.factureEnteteVentes.setFacTauxTc(this.var_tc_taux);
            } else {
               this.factureEnteteVentes.setFacTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2) {
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
         } else if (this.avoirEnteteVentes != null) {
            this.avoirEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.avoirEnteteVentes.setAvrCivilTiers("");
               this.var_typeTiers = true;
            } else {
               this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               this.avoirEnteteVentes.setAvrCivilTiers(this.avoirEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.avoirEnteteVentes.setAvrNomTiers(this.nomTier);
            this.avoirEnteteVentes.setAvrTypeReg(this.tiers.getTietypereg());
            this.avoirEnteteVentes.setAvrModeReg(this.tiers.getTiemodereg());
            this.avoirEnteteVentes.setAvrNbJourReg(this.tiers.getTienbecheance());
            this.avoirEnteteVentes.setAvrArrondiReg(this.tiers.getTienbarrondi());
            this.avoirEnteteVentes.setAvrJournalReg(this.tiers.getTiejournalreg());
            this.avoirEnteteVentes.setAvrCat(this.tiers.getTienomfamille());
            this.avoirEnteteVentes.setAvrExoDouane(this.tiers.getTieexodouane());
            this.avoirEnteteVentes.setAvrExoTva(this.tiers.getTieexotva());
            if (this.var_tc_calcul) {
               this.avoirEnteteVentes.setAvrTauxTc(this.var_tc_taux);
            } else {
               this.avoirEnteteVentes.setAvrTauxTc(0.0F);
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.avoirEnteteVentes.setAvrDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.avoirEnteteVentes.setAvrDiversTiers(0);
               this.avoirEnteteVentes.setAvrDiversNom("");
               this.avoirEnteteVentes.setAvrDiversAdresse("");
               this.avoirEnteteVentes.setAvrDiversVille("");
               this.avoirEnteteVentes.setAvrDiversTel("");
               this.avoirEnteteVentes.setAvrDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.avoirEnteteVentes.setAvrDevise(this.tiers.getTiedevise());
            } else {
               this.avoirEnteteVentes.setAvrDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      if (this.factureEnteteVentes != null) {
         this.factureEnteteVentes.setTiers(this.tiers);
         this.factureEnteteVentes.setFacNomTiers("");
         this.factureEnteteVentes.setFacCivilTiers("");
      } else if (this.avoirEnteteVentes != null) {
         this.avoirEnteteVentes.setTiers(this.tiers);
         this.avoirEnteteVentes.setAvrNomTiers("");
         this.avoirEnteteVentes.setAvrCivilTiers("");
      }

      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (this.factureEnteteVentes != null) {
         if (!this.factureEnteteVentes.getFacNomTiers().equals("") && this.tiers.getTieid() != 0L) {
            this.var_valide_doc = true;
            this.var_aff_detail_tiers = true;
            this.CalculDateEcheance();
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      } else if (this.avoirEnteteVentes != null) {
         if (!this.avoirEnteteVentes.getAvrNomTiers().equals("") && this.tiers.getTieid() != 0L) {
            this.var_valide_doc = true;
            this.var_aff_detail_tiers = true;
            this.CalculDateEcheance();
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException {
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var1 = 0; var1 < this.lesFamilleClientsListe.size() && !this.chargementEntete.getChamobCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var1)).getLibelle()); ++var1) {
         }
      }

      if (this.lesLignesList.size() != 0) {
         Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         Transaction var2 = null;

         try {
            var2 = var11.beginTransaction();
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesLignesList.size()) {
                  this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var11);
                  var2.commit();
                  break;
               }

               this.chargementLigne = new ChargementLigne();
               this.chargementLigne = (ChargementLigne)this.lesLignesList.get(var3);
               if (this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.chargementLigne.getChaligCode(), var11);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva()) {
                        this.chargementLigne.setChaligTaxe("");
                        this.chargementLigne.setChaligTauxTaxe(0.0F);
                     } else {
                        this.chargementLigne.setChaligTaxe(var4.getProVteTva());
                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.chargementLigne.getChaligTaxe(), var11);
                        if (var5 != null) {
                           this.chargementLigne.setChaligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.chargementLigne.setChaligTauxTaxe(0.0F);
                        }
                     }
                  } else {
                     this.chargementLigne.setChaligTaxe("");
                     this.chargementLigne.setChaligTauxTaxe(0.0F);
                  }

                  if ((this.chargementLigne.getChaligTaxe() == null || this.chargementLigne.getChaligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var11);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.chargementLigne.setChaligTaxe(var5.getTaxvteCode());
                        this.chargementLigne.setChaligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               if (this.var_tc_calcul) {
                  this.chargementEntete.setChamobTauxTc(this.var_tc_taux);
               } else {
                  this.chargementEntete.setChamobTauxTc(0.0F);
               }

               this.calculPrix(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTauxTaxe(), var11);
               this.chargementLigne = this.chargementLigneDao.modif(this.chargementLigne, var11);
               ++var3;
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

   }

   public void recupererEltCatFacture() throws HibernateException, NamingException {
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var1 = 0; var1 < this.lesFamilleClientsListe.size() && !this.factureEnteteVentes.getFacCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var1)).getLibelle()); ++var1) {
         }
      }

      if (this.lesProduitsDispo.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         new Stock();

         for(int var3 = 0; var3 < this.lesProduitsDispo.size(); ++var3) {
            Stock var2 = (Stock)this.lesProduitsDispo.get(var3);
            if (var2.getStk_code_produit() != null && !var2.getStk_code_produit().isEmpty()) {
               new Produits();
               Produits var4 = this.produitsDao.chargeProduit(var2.getStk_code_produit(), var6);
               TaxesVentes var5;
               if (var4 != null) {
                  if (!var4.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
                     var2.setStkTaxe(var4.getProVteTva());
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var2.getStkTaxe(), var6);
                     if (var5 != null) {
                        var2.setStkTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        var2.setStkTauxTaxe(0.0F);
                     }

                     var2 = this.prixUnitaireCorrespondFacture(var4, var2, var6);
                     if (this.var_pr_pv && this.chargementLigne.getChaligPump() != 0.0D) {
                        var2.setStk_pv(this.chargementLigne.getChaligPump());
                     }
                  } else {
                     var2.setStkTaxe("");
                     var2.setStkTauxTaxe(0.0F);
                  }
               } else {
                  var2.setStkTaxe("");
                  var2.setStkTauxTaxe(0.0F);
               }

               if ((var2.getStkTaxe() == null || var2.getStkTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  new TaxesVentes();
                  var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var6);
                  if (var5 != null) {
                     this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                     var2.setStkTaxe(var5.getTaxvteCode());
                     var2.setStkTauxTaxe(var5.getTaxvteTaux());
                  }
               }
            }

            if (this.var_tc_calcul) {
               this.factureEnteteVentes.setFacTauxTc(this.var_tc_taux);
            } else {
               this.factureEnteteVentes.setFacTauxTc(0.0F);
            }

            this.calculPrixFacture(var2, var2.getStkTaxe(), var2.getStkTauxTaxe(), var6);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public Stock prixUnitaireCorrespondFacture(Produits var1, Stock var2, Session var3) throws HibernateException, NamingException {
      if (var1 != null) {
         new ProduitsTarif();
         ProduitsTarif var4 = this.produitsTarifdao.prixUnitaireCorrespond(var1.getProId(), this.factureEnteteVentes.getFacCat(), this.chargementLigne.getChaligCondition(), var3);
         if (var4 != null) {
            this.prixUnitaires = var4.getProtarPv();
         } else {
            this.prixUnitaires = 0.0D;
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            var2.setStkPuTtc(this.prixUnitaires);
         } else {
            var2.setStk_pv(this.prixUnitaires);
         }

         if (this.verifBareme) {
            boolean var5 = false;
            new Baremes();
            Baremes var6 = this.baremesDao.rechercheBaremeProduit(this.tiers.getTieid(), this.produits.getProCode(), var3);
            if (var6 != null && (var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0)) {
               var5 = true;
            }

            if (!var5) {
               var6 = this.baremesDao.rechercheBaremeFamille(this.tiers.getTieid(), this.produits.getProVteCode(), var3);
               if (var6 != null && (var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0)) {
                  var5 = true;
               }
            }

            if (!var5) {
               var6 = this.baremesDao.rechercheBaremeProduit(this.tiers.getTienomfamille(), this.produits.getProCode(), var3);
               if (var6 != null && (var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0)) {
                  var5 = true;
               }
            }

            if (!var5) {
               var6 = this.baremesDao.rechercheBaremeFamille(this.tiers.getTienomfamille(), this.produits.getProVteCode(), var3);
               if (var6 != null && (var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0)) {
                  var5 = true;
               }
            }

            if (var5 && var6 != null) {
               double var7;
               if (var6.getBarRemise() != 0.0F) {
                  this.factureLigneVentes.setFacligTauxRemise(var6.getBarRemise());
                  var7 = 0.0D;
                  var7 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.factureEnteteVentes.getFacDevise());
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
                     this.factureLigneVentes.setFacligPuRemTtc(var7);
                  } else {
                     this.factureLigneVentes.setFacligPu(this.prixUnitaires);
                     this.factureLigneVentes.setFacligPuRem(var7);
                  }
               } else if (var6.getBarRabais() != 0.0D) {
                  this.factureLigneVentes.setFacligRabais(var6.getBarRabais());
                  var7 = 0.0D;
                  if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                     var7 = this.prixUnitaires - var6.getBarRabais() * (double)this.factureLigneVentes.getFacligQte();
                  } else {
                     var7 = this.prixUnitaires - var6.getBarRabais();
                  }

                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureLigneVentes.setFacligPuTtc(this.prixUnitaires);
                     this.factureLigneVentes.setFacligPuRemTtc(var7);
                  } else {
                     this.factureLigneVentes.setFacligPu(this.prixUnitaires);
                     this.factureLigneVentes.setFacligPuRem(var7);
                  }
               } else if (var6.getBarPrix() != 0.0D) {
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.factureLigneVentes.setFacligPuTtc(var6.getBarPrix());
                  } else {
                     this.factureLigneVentes.setFacligPu(var6.getBarPrix());
                  }
               }
            }
         }
      }

      return var2;
   }

   public void recupererEltCatAvoir() throws HibernateException, NamingException {
   }

   public void chargerModeEcheanceAffichage() {
      if (this.factureEnteteVentes == null && this.avoirEnteteVentes != null) {
      }

   }

   public void chargerModeEcheance() throws ParseException {
      String var1;
      String[] var2;
      ObjetReglement var3;
      int var4;
      int var5;
      int var6;
      if (this.factureEnteteVentes != null) {
         if (this.factureEnteteVentes.getFacTypeReg() != 0 && this.factureEnteteVentes.getFacTypeReg() != 3) {
            if (this.factureEnteteVentes.getFacTypeReg() != 1 && this.factureEnteteVentes.getFacTypeReg() != 2) {
               if (this.factureEnteteVentes.getFacTypeReg() == 4) {
               }
            } else {
               var1 = "0";
               if (this.factureEnteteVentes.getFacModeReg() != null && !this.factureEnteteVentes.getFacModeReg().isEmpty() && this.factureEnteteVentes.getFacModeReg().contains(":")) {
                  var2 = this.factureEnteteVentes.getFacModeReg().split(":");
                  var1 = var2[0];
               }

               for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
                  new ObjetReglement();
                  var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
                  if (var3.getCategories().equals(var1)) {
                     var4 = 0;
                     if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                        var4 = Integer.parseInt(var3.getNbjours());
                     }

                     this.factureEnteteVentes.setFacNbJourReg(var4);
                     var5 = 0;
                     if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                        var5 = Integer.parseInt(var3.getArrondis());
                     }

                     this.factureEnteteVentes.setFacArrondiReg(var5);
                     break;
                  }
               }
            }
         }

         if ("Factor".equalsIgnoreCase(this.factureEnteteVentes.getFacModeReg())) {
         }
      } else if (this.avoirEnteteVentes != null) {
         if (this.avoirEnteteVentes.getAvrTypeReg() != 0 && this.avoirEnteteVentes.getAvrTypeReg() != 3) {
            if (this.avoirEnteteVentes.getAvrTypeReg() != 1 && this.avoirEnteteVentes.getAvrTypeReg() != 2) {
               if (this.avoirEnteteVentes.getAvrTypeReg() == 4) {
               }
            } else {
               var1 = "0";
               if (this.avoirEnteteVentes.getAvrModeReg() != null && !this.avoirEnteteVentes.getAvrModeReg().isEmpty() && this.avoirEnteteVentes.getAvrModeReg().contains(":")) {
                  var2 = this.avoirEnteteVentes.getAvrModeReg().split(":");
                  var1 = var2[0];
               }

               for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
                  new ObjetReglement();
                  var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
                  if (var3.getCategories().equals(var1)) {
                     var4 = 0;
                     if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                        var4 = Integer.parseInt(var3.getNbjours());
                     }

                     this.avoirEnteteVentes.setAvrNbJourReg(var4);
                     var5 = 0;
                     if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                        var5 = Integer.parseInt(var3.getArrondis());
                     }

                     this.avoirEnteteVentes.setAvrArrondiReg(var5);
                     break;
                  }
               }
            }
         }

         if ("Factor".equalsIgnoreCase(this.avoirEnteteVentes.getAvrModeReg())) {
         }
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1;
      if (this.factureEnteteVentes != null) {
         var1 = this.utilDate.CalculDateEcheance(this.factureEnteteVentes.getFacDate(), this.factureEnteteVentes.getFacTypeReg(), this.factureEnteteVentes.getFacNbJourReg(), this.factureEnteteVentes.getFacArrondiReg());
         this.factureEnteteVentes.setFacDateEcheReg(var1);
      } else if (this.avoirEnteteVentes != null) {
         var1 = this.utilDate.CalculDateEcheance(this.avoirEnteteVentes.getAvrDate(), this.avoirEnteteVentes.getAvrTypeReg(), this.avoirEnteteVentes.getAvrNbJourReg(), this.avoirEnteteVentes.getAvrArrondiReg());
         this.avoirEnteteVentes.setAvrDateEcheReg(var1);
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
      if (this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && !this.chargementLigne.getChaligCode().equals("-") && !this.chargementLigne.getChaligCode().equals("=")) {
         this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.var_depot, this.chargementLigne.getChaligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         this.chargementLigne.setChaligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.chargementLigne.setChaligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.chargementLigne.setChaligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.chargementLigne.setChaligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.chargementLigne.setChaligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.chargementLigne.setChaligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.chargementLigne.setChaligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.chargementLigne.setChaligFamille(this.produits.getProVteCode());
         this.chargementLigne.setChaligStock(this.produits.getProStock());
         this.chargementLigne.setChaligLong(this.produits.getProLongueur());
         this.chargementLigne.setChaligLarg(this.produits.getProLargeur());
         this.chargementLigne.setChaligHaut(this.produits.getProEpaisseur());
         this.chargementLigne.setChaligDiam(this.produits.getProDiamExt());
         this.chargementLigne.setChaligPoidsBrut(this.produits.getProPoidsBrut());
         this.chargementLigne.setChaligPoidsNet(this.produits.getProPoidsNet());
         this.chargementLigne.setChaligVolume(this.produits.getProVolume());
         this.chargementLigne.setChaligNb(this.produits.getProNbUnite());
         this.chargementLigne.setChaligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
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
         if (this.produits.isProExoTva()) {
            this.chargementLigne.setChaligTaxe("");
            this.chargementLigne.setChaligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         } else {
            TaxesVentes var9;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var9.getTaxvteTaux()));
                  this.chargementLigne.setChaligTaxe(this.produits.getProVteTva());
                  this.chargementLigne.setChaligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.chargementLigne.setChaligTaxe("");
                  this.chargementLigne.setChaligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.chargementLigne.setChaligTaxe(var8.getFamvteTaxe());
                  this.chargementLigne.setChaligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.chargementLigne.setChaligTaxe("");
               this.chargementLigne.setChaligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if ((this.chargementLigne.getChaligTaxe() == null || this.chargementLigne.getChaligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.chargementLigne.setChaligTaxe(var9.getTaxvteCode());
                  this.chargementLigne.setChaligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.chargementLigne.getChaligTauxTaxe() / 100.0D;
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
               this.chargementLigne.setChaligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.chargementLigne.setChaligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.chargementLigne.setChaligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.chargementLigne.setChaligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.chargementLigne.setChaligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.chargementLigne.getChaligPump() != 0.0D) {
            this.chargementLigne.setChaligPu(this.chargementLigne.getChaligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.chargementLigne.getChaligTaxe(), this.chargementLigne.getChaligTauxTaxe(), var1);
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
      if ((this.chargementLigne.getChaligCode() == null || this.chargementLigne.getChaligCode().isEmpty() || this.chargementLigne.getChaligCode().length() < 2) && this.mesTaxesVentesProduits.isEmpty() && this.tiers.getTiefacpr() <= 1) {
         this.mesTaxesVentesProduits.clear();
         if (this.mesTaxesVentesItems.size() != 0) {
            for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
               this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
            }
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.chargementLigne.setChaligCode("");
      this.chargementLigne.setChaligLibelle("");
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
            var2 = this.chargementLigne.getChaligPuTtc();
         } else {
            var2 = this.chargementLigne.getChaligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.chargementLigne.setChaligPuTtc(this.prixUnitaires);
            this.chargementLigne.setChaligPuRemTtc(this.prixUnitaires);
         } else {
            this.chargementLigne.setChaligPu(this.prixUnitaires);
            this.chargementLigne.setChaligPuRem(this.prixUnitaires);
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
                     this.chargementLigne.setChaligTauxRemise(var6.getBarRemise());
                     this.chargementLigne.setChaligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.structureLog.getStrdevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.chargementLigne.setChaligPuTtc(this.prixUnitaires);
                        this.chargementLigne.setChaligPuRemTtc(var11);
                     } else {
                        this.chargementLigne.setChaligPu(this.prixUnitaires);
                        this.chargementLigne.setChaligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.chargementLigne.setChaligTauxRemise(var6.getBarRemise());
                     this.chargementLigne.setChaligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.chargementLigne.getChaligQteCharg();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.chargementLigne.setChaligPuTtc(this.prixUnitaires);
                        this.chargementLigne.setChaligPuRemTtc(var11);
                     } else {
                        this.chargementLigne.setChaligPu(this.prixUnitaires);
                        this.chargementLigne.setChaligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.chargementLigne.setChaligTauxRemise(var6.getBarRemise());
                     this.chargementLigne.setChaligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.chargementLigne.setChaligPuTtc(this.prixUnitaires);
                        this.chargementLigne.setChaligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.chargementLigne.setChaligPu(this.prixUnitaires);
                        this.chargementLigne.setChaligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.chargementLigne.setChaligPuTtc(this.prixUnitaires);
                     this.chargementLigne.setChaligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.chargementLigne.setChaligPu(this.prixUnitaires);
                     this.chargementLigne.setChaligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((ChargementLigne)this.lesLignesList.get(var9)).getChaligCode() == null || ((ChargementLigne)this.lesLignesList.get(var9)).getChaligCode().isEmpty() || !((ChargementLigne)this.lesLignesList.get(var9)).getChaligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((ChargementLigne)this.lesLignesList.get(var9)).getChaligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((ChargementLigne)this.lesLignesList.get(var8)).getChaligFamille() != null && !((ChargementLigne)this.lesLignesList.get(var8)).getChaligFamille().isEmpty() && ((ChargementLigne)this.lesLignesList.get(var8)).getChaligFamille().equals(var7)) {
                  var5 += ((ChargementLigne)this.lesLignesList.get(var8)).getChaligPt();
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
         double var2 = this.chargementLigne.getChaligPu();
         double var4 = this.chargementLigne.getChaligPuTtc();
         if (this.chargementLigne.getChaligPu() >= 0.0D && this.chargementLigne.getChaligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.chargementEntete.getChamobCat(), (String)null, var1);
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
                     if (this.chargementLigne.getChaligQteDem() >= var7.getQteDebut() && this.chargementLigne.getChaligQteDem() <= var7.getQteFin()) {
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
                        if (this.chargementLigne.getChaligQteDem() >= var7.getQteDebut() && this.chargementLigne.getChaligQteDem() <= var7.getQteFin()) {
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
            } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var4;
            } else {
               this.prixUnitaires = var2;
            }
         } else {
            var2 = Math.abs(this.chargementLigne.getChaligPu());
            var4 = Math.abs(this.chargementLigne.getChaligPuTtc());
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
      this.chargementLigne.setChaligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && this.chargementLigne.getChaligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.chargementLigne.getChaligEchelle());
            float var5 = 1.0F;
            if (this.chargementLigne.getChaligCondition().contains("/")) {
               String[] var6 = this.chargementLigne.getChaligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.chargementLigne.getChaligCondition() != null && !this.chargementLigne.getChaligCondition().isEmpty() && !this.chargementLigne.getChaligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.chargementLigne.getChaligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.chargementLigne.setChaligPump(var9);
      } else {
         this.chargementLigne.setChaligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.chargementLigne.getChaligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.chargementLigne.setChaligEchelle(this.unite.getUniEchelle());
               } else {
                  this.chargementLigne.setChaligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.chargementLigne.setChaligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.chargementLigne.setChaligEchelle(Integer.parseInt(var2));
         } else {
            this.chargementLigne.setChaligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.chargementLigne.getChaligLong(), this.chargementLigne.getChaligLarg(), this.chargementLigne.getChaligHaut(), this.chargementLigne.getChaligDiam(), this.chargementLigne.getChaligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.chargementLigne.getChaligLong(), this.chargementLigne.getChaligLarg(), this.chargementLigne.getChaligHaut(), this.chargementLigne.getChaligDiam(), this.chargementLigne.getChaligNb(), this.baseLog, var1);
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

   public void rechercheProduitsRechargement() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.rechargementLigne.getChaligCode() != null && !this.rechargementLigne.getChaligCode().isEmpty() && !this.rechargementLigne.getChaligCode().equals("-") && !this.rechargementLigne.getChaligCode().equals("=")) {
         this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.var_depot, this.rechargementLigne.getChaligCode(), 281, this.optionsVentes);
         if (this.produits != null) {
            if (this.produits.getProId() != 0L) {
               this.calculeProduits();
            } else {
               this.var_action = 15;
            }
         } else if (this.produits == null) {
            this.calculeProduitsRechargement();
         }
      }

   }

   public void recuperationProduitRechargement() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduitsRechargement();
   }

   public void calculeProduitsRechargement() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
         this.rechargementLigne.setChaligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.rechargementLigne.setChaligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.rechargementLigne.setChaligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.rechargementLigne.setChaligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.rechargementLigne.setChaligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.rechargementLigne.setChaligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.rechargementLigne.setChaligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.rechargementLigne.setChaligFamille(this.produits.getProVteCode());
         this.rechargementLigne.setChaligStock(this.produits.getProStock());
         this.rechargementLigne.setChaligPoidsBrut(this.produits.getProPoidsBrut());
         this.rechargementLigne.setChaligPoidsNet(this.produits.getProPoidsNet());
         this.rechargementLigne.setChaligVolume(0.0F);
         this.rechargementLigne.setChaligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
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
         if (this.produits.isProExoTva()) {
            this.rechargementLigne.setChaligTaxe("");
            this.rechargementLigne.setChaligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         } else {
            TaxesVentes var9;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var9.getTaxvteTaux()));
                  this.rechargementLigne.setChaligTaxe(this.produits.getProVteTva());
                  this.rechargementLigne.setChaligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.rechargementLigne.setChaligTaxe("");
                  this.rechargementLigne.setChaligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.rechargementLigne.setChaligTaxe(var8.getFamvteTaxe());
                  this.rechargementLigne.setChaligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.rechargementLigne.setChaligTaxe("");
               this.rechargementLigne.setChaligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if ((this.rechargementLigne.getChaligTaxe() == null || this.rechargementLigne.getChaligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.rechargementLigne.setChaligTaxe(var9.getTaxvteCode());
                  this.rechargementLigne.setChaligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         }

         this.mefConditionnementDepotRechargement(var1);
         this.selectionDepotRechargement(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.rechargementLigne.getChaligTauxTaxe() / 100.0D;
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
               this.rechargementLigne.setChaligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.rechargementLigne.setChaligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.rechargementLigne.setChaligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.rechargementLigne.setChaligCondition("");
         this.prixUnitaireCorrespondRechargement(var1);
         if (this.var_pr_pv && this.rechargementLigne.getChaligPump() != 0.0D) {
            this.rechargementLigne.setChaligPu(this.rechargementLigne.getChaligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrixRechargement(this.rechargementLigne.getChaligTaxe(), this.rechargementLigne.getChaligTauxTaxe(), var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduitsRechargement();
      }

      this.var_action = this.var_memo_action;
   }

   public void detailProduitRechargement() {
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

   public void annuleDetailProduitRechargement() {
      this.var_action = this.var_memo_action;
   }

   public void calculTvaRechargement() {
      if ((this.rechargementLigne.getChaligCode() == null || this.rechargementLigne.getChaligCode().isEmpty() || this.rechargementLigne.getChaligCode().length() < 2) && this.mesTaxesVentesProduits.isEmpty() && this.tiers.getTiefacpr() <= 1) {
         this.mesTaxesVentesProduits.clear();
         if (this.mesTaxesVentesItems.size() != 0) {
            for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
               this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
            }
         }
      }

   }

   public void annuleProduitsRechargement() {
      this.produits = null;
      this.rechargementLigne.setChaligCode("");
      this.rechargementLigne.setChaligLibelle("");
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

   public void prixUnitaireCorrespondRechargement(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         new ProduitsTarif();
         ProduitsTarif var2 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.chargementEntete.getChamobCat(), this.rechargementLigne.getChaligCondition(), var1);
         if (var2 != null) {
            this.prixUnitaires = var2.getProtarPv();
         } else {
            this.prixUnitaires = 0.0D;
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.rechargementLigne.setChaligPuTtc(this.prixUnitaires);
         } else {
            this.rechargementLigne.setChaligPu(this.prixUnitaires);
         }

         if (this.verifBareme) {
            new Baremes();
            Baremes var3 = this.baremesDao.rechercheBareme(this.tiers.getTieid(), this.produits.getProVteCode(), this.produits.getProCode(), var1);
            if (var3 != null && (var3.getBarDateDebut() == null && var3.getBarDateFin() == null || var3.getBarDateDebut() != null && this.var_date.compareTo(var3.getBarDateDebut()) >= 0 && var3.getBarDateFin() != null && this.var_date.compareTo(var3.getBarDateFin()) <= 0)) {
               double var4;
               if (var3.getBarRemise() != 0.0F) {
                  var4 = 0.0D;
                  var4 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var3.getBarRemise() / 100.0D, this.structureLog.getStrdevise());
                  this.rechargementLigne.setChaligTauxRemise(var3.getBarRemise());
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.rechargementLigne.setChaligPuTtc(this.prixUnitaires);
                     this.rechargementLigne.setChaligPuRemTtc(var4);
                  } else {
                     this.rechargementLigne.setChaligPu(this.prixUnitaires);
                     this.rechargementLigne.setChaligPuRem(var4);
                  }
               } else if (var3.getBarRabais() != 0.0D) {
                  this.rechargementLigne.setChaligRabais(var3.getBarRabais());
                  var4 = 0.0D;
                  if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                     var4 = this.prixUnitaires - var3.getBarRabais() * (double)this.rechargementLigne.getChaligQteDem();
                  } else {
                     var4 = this.prixUnitaires - var3.getBarRabais();
                  }

                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.rechargementLigne.setChaligPuTtc(this.prixUnitaires);
                     this.rechargementLigne.setChaligPuRemTtc(var4);
                  } else {
                     this.rechargementLigne.setChaligPu(this.prixUnitaires);
                     this.rechargementLigne.setChaligPuRem(var4);
                  }
               } else if (var3.getBarPrix() != 0.0D) {
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.rechargementLigne.setChaligPuTtc(var3.getBarPrix());
                  } else {
                     this.rechargementLigne.setChaligPu(var3.getBarPrix());
                  }
               }
            }
         }
      }

   }

   public void prixUnitaireDegressifRechargement(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         double var4 = 0.0D;
         if (this.rechargementLigne.getChaligPu() > 0.0D && this.rechargementLigne.getChaligPuTtc() > 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.chargementEntete.getChamobCat(), (String)null, var1);
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
                     if (this.rechargementLigne.getChaligQteDem() >= var7.getQteDebut() && this.rechargementLigne.getChaligQteDem() <= var7.getQteFin()) {
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
                        if (this.rechargementLigne.getChaligQteDem() >= var7.getQteDebut() && this.rechargementLigne.getChaligQteDem() <= var7.getQteFin()) {
                           var8 = var7.getPrix();
                           break;
                        }
                     }
                  }

                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.rechargementLigne.setChaligPuTtc(var8);
                  } else {
                     this.rechargementLigne.setChaligPu(var8);
                  }
               } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                  if (var4 != 0.0D) {
                     this.rechargementLigne.setChaligPuTtc(var4);
                  } else {
                     this.rechargementLigne.setChaligPuTtc(var6.getProtarPv());
                  }
               } else if (var2 != 0.0D) {
                  this.rechargementLigne.setChaligPu(var2);
               } else {
                  this.rechargementLigne.setChaligPu(var6.getProtarPv());
               }
            } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.rechargementLigne.setChaligPuTtc(var4);
            } else {
               this.rechargementLigne.setChaligPu(var2);
            }
         } else {
            var2 = Math.abs(this.rechargementLigne.getChaligPu());
            var4 = Math.abs(this.rechargementLigne.getChaligPuTtc());
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.rechargementLigne.setChaligPuTtc(var4);
            } else {
               this.rechargementLigne.setChaligPu(var2);
            }
         }
      }

   }

   public void selectionDepotRechargement() throws HibernateException, NamingException {
      this.selectionDepotRechargement((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.rechargementLigne.setChaligUnite(this.produitsDepot.getProdepUnite());
   }

   public void selectionDepotRechargement(Session var1) throws HibernateException, NamingException {
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
         if (this.chargementLigne.getChaligCondition() != null && !this.rechargementLigne.getChaligCondition().isEmpty() && this.rechargementLigne.getChaligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.rechargementLigne.getChaligEchelle());
            float var5 = 1.0F;
            if (this.rechargementLigne.getChaligCondition().contains("/")) {
               String[] var6 = this.rechargementLigne.getChaligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.rechargementLigne.getChaligCondition() != null && !this.rechargementLigne.getChaligCondition().isEmpty() && !this.rechargementLigne.getChaligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.rechargementLigne.getChaligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.rechargementLigne.setChaligPump(var9);
      } else {
         this.rechargementLigne.setChaligPump(0.0D);
      }

   }

   public void selectionConditionnementRechargement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      this.mefConditionnementDepotRechargement(var1);
      this.prixUnitaireCorrespondRechargement(var1);
      this.selectionDepotRechargement(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepotRechargement(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.chargementLigne.getChaligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.rechargementLigne.setChaligEchelle(this.unite.getUniEchelle());
               } else {
                  this.rechargementLigne.setChaligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.rechargementLigne.setChaligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.rechargementLigne.setChaligEchelle(Integer.parseInt(var2));
         } else {
            this.rechargementLigne.setChaligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var8 = 0; var8 < this.listeProduitDepot.size(); ++var8) {
               ProduitsDepot var9 = (ProduitsDepot)this.listeProduitDepot.get(var8);
               float var10 = 0.0F;
               if (this.optionsVentes.getChoixStock().equals("1")) {
                  var10 = var9.getProdepQteStk() - var9.getProdepQteAttVte();
               } else {
                  var10 = var9.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var10 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var10, this.rechargementLigne.getChaligLong(), this.rechargementLigne.getChaligLarg(), this.rechargementLigne.getChaligHaut(), this.rechargementLigne.getChaligDiam(), this.rechargementLigne.getChaligNb(), this.baseLog, var1);
                  var7 = (int)var10;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var10 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var10, this.rechargementLigne.getChaligLong(), this.rechargementLigne.getChaligLarg(), this.rechargementLigne.getChaligHaut(), this.rechargementLigne.getChaligDiam(), this.rechargementLigne.getChaligNb(), this.baseLog, var1);
                  var7 = (int)var10;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var10;
               }

               if (var9.getProdepCasier() != null && !var9.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + ":" + var9.getProdepCasier() + "=" + var6));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var6));
               }
            }
         }
      }

   }

   public List chargerUniteProduitRechargement(Session var1) {
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

   public List chargerConditionnementProduitRechargement(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementVentes(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void rechercheFrais() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.rechercheProduitFraisVentes(this.chargementFrais.getChafraCode(), 281);
      if (this.produits != null) {
         if (this.produits.getProId() != 0L) {
            this.calculeFrais();
         } else {
            this.var_action = 15;
         }
      } else if (this.produits == null) {
         this.calculeFrais();
      }

   }

   public void recuperationFrais() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeFrais();
   }

   public void calculeFrais() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         this.chargementFrais.setChafraCode(this.produits.getProCode());
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            this.chargementFrais.setChafraLibelle(this.produits.getProLibTech());
         } else {
            this.chargementFrais.setChafraLibelle(this.produits.getProLibClient());
         }

         this.chargementFrais.setChafraFamille(this.produits.getProVteCode());
      } else {
         this.annuleFrais();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleFrais() {
      this.produits = null;
      this.chargementFrais.setChafraCode("");
      this.chargementFrais.setChafraLibelle("");
      this.var_action = this.var_memo_action;
   }

   public String calculeCheminRapport(int var1, String var2) {
      String var3 = "";
      if (var1 == 2) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var2 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "rechargement" + File.separator;
      } else if (var1 == 3) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var2 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "dechargement" + File.separator;
      } else {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var2 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatChargement.jpg");
            if (var4.exists()) {
               var3 = "formatChargement.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatChargement.jpg");
         if (var4.exists()) {
            var3 = "formatChargement.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      double var2 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         boolean var4 = false;
         String var5 = "";
         double var6 = 0.0D;
         double var8 = 0.0D;

         for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
            this.chargementLigne = (ChargementLigne)this.lesLignesList.get(var10);
            var2 = var2 + this.chargementLigne.getChaligTtc() + this.chargementLigne.getChaligTc();
            if (this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligCode().equals("-")) {
               var4 = true;
               var5 = this.chargementLigne.getChaligLibelle();
            }

            if (var4) {
               var6 += this.chargementLigne.getChaligPt();
               var8 = this.chargementLigne.getChaligTtc();
            }

            if (this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligCode().equals("=") && var4) {
               this.chargementLigne = new ChargementLigne();
               this.chargementLigne.setChaligCode("=");
               this.chargementLigne.setChaligLibelle(var5);
               this.chargementLigne.setChaligPt(var6);
               this.chargementLigne.setChaligTtc(var8);
               var1.add(this.chargementLigne);
               var6 = 0.0D;
               var8 = 0.0D;
               var4 = false;
            } else {
               var1.add(this.chargementLigne);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(var1);
      return var11;
   }

   public JRBeanCollectionDataSource calculeImpressionRechargementCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      double var2 = 0.0D;
      if (this.lesRechargementsList.size() != 0) {
         boolean var4 = false;
         String var5 = "";
         double var6 = 0.0D;
         double var8 = 0.0D;

         for(int var10 = 0; var10 < this.lesRechargementsList.size(); ++var10) {
            this.chargementLigne = (ChargementLigne)this.lesRechargementsList.get(var10);
            if (this.dateRechargement == null || this.dateRechargement != null && this.dateRechargement.equals(this.chargementLigne.getChaligDateChargement())) {
               var2 = var2 + this.chargementLigne.getChaligTtc() + this.chargementLigne.getChaligTc();
               if (this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligCode().equals("-")) {
                  var4 = true;
                  var5 = this.chargementLigne.getChaligLibelle();
               }

               if (var4) {
                  var6 += this.chargementLigne.getChaligPt();
                  var8 = this.chargementLigne.getChaligTtc();
               }

               if (this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligCode().equals("=") && var4) {
                  this.chargementLigne = new ChargementLigne();
                  this.chargementLigne.setChaligCode("=");
                  this.chargementLigne.setChaligLibelle(var5);
                  this.chargementLigne.setChaligPt(var6);
                  this.chargementLigne.setChaligTtc(var8);
                  var1.add(this.chargementLigne);
                  var6 = 0.0D;
                  var8 = 0.0D;
                  var4 = false;
               } else {
                  var1.add(this.chargementLigne);
               }
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(var1);
      return var11;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.chargementEntete.getChamobAnal2() != null && !this.chargementEntete.getChamobAnal2().isEmpty()) {
         String var4 = "";
         if (this.chargementEntete.getChamobAnal2().contains(":")) {
            String[] var5 = this.chargementEntete.getChamobAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.chargementEntete.getChamobAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         boolean var5 = false;
         this.chargementEntete.setChamobDateImp(new Date());
         if (this.chargementEntete.getChamobEtat() == 0 && this.chargementEntete.getChamobEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.chargementEntete.setChamobEtat(1);
            var5 = true;
         }

         if (this.chargementEntete.getChamobDateImp() != null) {
            var2 = true;
         }

         this.chargementEntete.setChamobModeleImp(var1);
         this.chargementEntete = this.chargementEnteteDao.modif(this.chargementEntete, var3);
         if (var5 && this.listDechargement.size() != 0) {
            for(int var6 = 0; var6 < this.listDechargement.size(); ++var6) {
               this.chargementLigne = new ChargementLigne();
               this.chargementLigne = (ChargementLigne)this.listDechargement.get(var6);
               if (this.chargementLigne.getChaligQteRetour() != 0.0F && this.chargementLigne.getChaligCode() != null && !this.chargementLigne.getChaligCode().isEmpty() && this.chargementLigne.getChaligDepotCharg() != null && !this.chargementLigne.getChaligDepotCharg().isEmpty()) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.chargementLigne.getChaligCode(), this.chargementLigne.getChaligDepotCharg(), var3);
                  if (this.produitsDepot != null) {
                     float var7 = this.produitsDepot.getProdepQteStk() - this.chargementLigne.getChaligQteRetour();
                     this.produitsDepot.setProdepQteStk(var7);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               }
            }
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

      return var2;
   }

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 != 0 && var2 != 2 && var2 != 3) {
         if (var5 != null && !var5.isEmpty()) {
            var1.setRapport(var5);
            var1.setEntete("Impression de la liste des chargements");
            var1.setTotauxHt("" + this.totauxHt);
            var1.setTotauxTaxe("" + this.totauxTaxe);
            var1.setTotauxTtc("" + this.totauxTtc);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "chargement" + File.separator);
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
      } else if (var4 != null && !var4.isEmpty()) {
         boolean var12 = this.majDateImpression(var4);
         String var13;
         if (var2 == 2) {
            var1.setRequete("");
            var1.setjRBeanCollectionDataSource(this.calculeImpressionRechargementCommun());
            var1.setEntete("Impression re-Chargement");
         } else if (var2 == 3) {
            var13 = " chamob_id = " + this.chargementEntete.getChamobId();
            var1.setRequete(var13);
            ArrayList var14 = new ArrayList();
            JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(var14);
            var1.setjRBeanCollectionDataSource(var15);
            var1.setEntete("Impression de-Chargement");
         } else {
            var1.setRequete("");
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setEntete("Impression Chargement");
         }

         var1.setRapport(var4);
         var1.setMontant_lettre(this.montant_lettre);
         var1.setCheminRapport(this.calculeCheminRapport(var2, "structure" + this.structureLog.getStrid()));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.chargementEntete.getChamobEtat()));
         var1.setDuplicata("" + var12);
         var1.setNbDecQte(this.optionsVentes.getNbDecQte());
         var1.setNbDecPu(this.optionsVentes.getNbDecPu());
         var1.setFormat(var6);
         var1.setEmetteur(var7);
         var1.setDestinataire(var8);
         var1.setDestinataireCC(var9);
         var1.setDestinataireCCI(var10);
         var1.setCorpsMail(var11);
         var1.setIdResponsable(this.chargementEntete.getChamobIdResponsable());
         var1.setIdCommercial(this.chargementEntete.getChamobIdCommercial());
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(this.chargementEntete.getChamobId());
         if (this.chargementEntete.getChamobAnal2() != null && !this.chargementEntete.getChamobAnal2().isEmpty()) {
            var13 = "";
            if (this.chargementEntete.getChamobAnal2().contains(":")) {
               String[] var17 = this.chargementEntete.getChamobAnal2().split(":");
               var13 = var17[0];
            } else {
               var13 = this.chargementEntete.getChamobAnal2();
            }

            new Parc();
            ParcDao var19 = new ParcDao(this.baseLog, this.utilInitHibernate);
            Parc var18 = var19.rechercheParc(var13, (Session)null);
            if (var18 != null) {
               var1.setParc(var18);
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
         this.chargerDocumentLigne((Session)null);
      }

   }

   public void initGrapheur() {
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
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

   public List getMesCommercialItem() {
      return this.mesCommercialItem;
   }

   public void setMesCommercialItem(List var1) {
      this.mesCommercialItem = var1;
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

   public boolean isAccesAffaires() {
      return this.accesAffaires;
   }

   public void setAccesAffaires(boolean var1) {
      this.accesAffaires = var1;
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

   public ChargementEntete getChargementEntete() {
      return this.chargementEntete;
   }

   public void setChargementEntete(ChargementEntete var1) {
      this.chargementEntete = var1;
   }

   public ChargementLigne getChargementLigne() {
      return this.chargementLigne;
   }

   public void setChargementLigne(ChargementLigne var1) {
      this.chargementLigne = var1;
   }

   public List getMesDepotChgItems() {
      return this.mesDepotChgItems;
   }

   public void setMesDepotChgItems(List var1) {
      this.mesDepotChgItems = var1;
   }

   public String getVar_depot() {
      return this.var_depot;
   }

   public void setVar_depot(String var1) {
      this.var_depot = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public DataModel getDatamodelRechargement() {
      return this.datamodelRechargement;
   }

   public void setDatamodelRechargement(DataModel var1) {
      this.datamodelRechargement = var1;
   }

   public ChargementLigne getRechargementLigne() {
      return this.rechargementLigne;
   }

   public void setRechargementLigne(ChargementLigne var1) {
      this.rechargementLigne = var1;
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

   public DataModel getDatamodelFacture() {
      return this.datamodelFacture;
   }

   public void setDatamodelFacture(DataModel var1) {
      this.datamodelFacture = var1;
   }

   public String getVar_libcondest() {
      return this.var_libcondest;
   }

   public void setVar_libcondest(String var1) {
      this.var_libcondest = var1;
   }

   public boolean isContDest() {
      return this.contDest;
   }

   public void setContDest(boolean var1) {
      this.contDest = var1;
   }

   public boolean isShowModalPanelFacturation() {
      return this.showModalPanelFacturation;
   }

   public void setShowModalPanelFacturation(boolean var1) {
      this.showModalPanelFacturation = var1;
   }

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public DataModel getDatamodelAvoir() {
      return this.datamodelAvoir;
   }

   public void setDatamodelAvoir(DataModel var1) {
      this.datamodelAvoir = var1;
   }

   public DataModel getDatamodelDispo() {
      return this.datamodelDispo;
   }

   public void setDatamodelDispo(DataModel var1) {
      this.datamodelDispo = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public Date getVar_date_doc() {
      return this.var_date_doc;
   }

   public void setVar_date_doc(Date var1) {
      this.var_date_doc = var1;
   }

   public String getVar_heure_doc() {
      return this.var_heure_doc;
   }

   public void setVar_heure_doc(String var1) {
      this.var_heure_doc = var1;
   }

   public String getVar_minute_doc() {
      return this.var_minute_doc;
   }

   public void setVar_minute_doc(String var1) {
      this.var_minute_doc = var1;
   }

   public String getVar_seconde_doc() {
      return this.var_seconde_doc;
   }

   public void setVar_seconde_doc(String var1) {
      this.var_seconde_doc = var1;
   }

   public boolean isVar_valide_chg() {
      return this.var_valide_chg;
   }

   public void setVar_valide_chg(boolean var1) {
      this.var_valide_chg = var1;
   }

   public boolean isVar_valide_fac() {
      return this.var_valide_fac;
   }

   public void setVar_valide_fac(boolean var1) {
      this.var_valide_fac = var1;
   }

   public boolean isVar_valide_rcg() {
      return this.var_valide_rcg;
   }

   public void setVar_valide_rcg(boolean var1) {
      this.var_valide_rcg = var1;
   }

   public boolean isShowModalPanelAvoir() {
      return this.showModalPanelAvoir;
   }

   public void setShowModalPanelAvoir(boolean var1) {
      this.showModalPanelAvoir = var1;
   }

   public AvoirEnteteVentes getAvoirEnteteVentes() {
      return this.avoirEnteteVentes;
   }

   public void setAvoirEnteteVentes(AvoirEnteteVentes var1) {
      this.avoirEnteteVentes = var1;
   }

   public AvoirLigneVentes getAvoirLigneVentes() {
      return this.avoirLigneVentes;
   }

   public void setAvoirLigneVentes(AvoirLigneVentes var1) {
      this.avoirLigneVentes = var1;
   }

   public DataModel getDatamodelDechargement() {
      return this.datamodelDechargement;
   }

   public void setDatamodelDechargement(DataModel var1) {
      this.datamodelDechargement = var1;
   }

   public ChargementFrais getChargementFrais() {
      return this.chargementFrais;
   }

   public void setChargementFrais(ChargementFrais var1) {
      this.chargementFrais = var1;
   }

   public DataModel getDatamodelFrais() {
      return this.datamodelFrais;
   }

   public void setDatamodelFrais(DataModel var1) {
      this.datamodelFrais = var1;
   }

   public boolean isShowModalPanelFrais() {
      return this.showModalPanelFrais;
   }

   public void setShowModalPanelFrais(boolean var1) {
      this.showModalPanelFrais = var1;
   }

   public boolean isVar_valide_fra() {
      return this.var_valide_fra;
   }

   public void setVar_valide_fra(boolean var1) {
      this.var_valide_fra = var1;
   }

   public List getMesProduitsFrais() {
      return this.mesProduitsFrais;
   }

   public void setMesProduitsFrais(List var1) {
      this.mesProduitsFrais = var1;
   }

   public String getVar_frais() {
      return this.var_frais;
   }

   public void setVar_frais(String var1) {
      this.var_frais = var1;
   }

   public boolean isShowModalPanelEclatement() {
      return this.showModalPanelEclatement;
   }

   public void setShowModalPanelEclatement(boolean var1) {
      this.showModalPanelEclatement = var1;
   }

   public boolean isShowModalPanelLivraison() {
      return this.showModalPanelLivraison;
   }

   public void setShowModalPanelLivraison(boolean var1) {
      this.showModalPanelLivraison = var1;
   }

   public DataModel getDataModelEclatement() {
      return this.dataModelEclatement;
   }

   public void setDataModelEclatement(DataModel var1) {
      this.dataModelEclatement = var1;
   }

   public float getTotal_eclatement() {
      return this.total_eclatement;
   }

   public void setTotal_eclatement(float var1) {
      this.total_eclatement = var1;
   }

   public float getTotal_ecart() {
      return this.total_ecart;
   }

   public void setTotal_ecart(float var1) {
      this.total_ecart = var1;
   }

   public String getInpCommercial() {
      return this.inpCommercial;
   }

   public void setInpCommercial(String var1) {
      this.inpCommercial = var1;
   }

   public DataModel getDataModelDetailFacture() {
      return this.dataModelDetailFacture;
   }

   public void setDataModelDetailFacture(DataModel var1) {
      this.dataModelDetailFacture = var1;
   }

   public List getLesModeReglementClientsListe() {
      return this.lesModeReglementClientsListe;
   }

   public void setLesModeReglementClientsListe(List var1) {
      this.lesModeReglementClientsListe = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isVar_affiche_dollar() {
      return this.var_affiche_dollar;
   }

   public void setVar_affiche_dollar(boolean var1) {
      this.var_affiche_dollar = var1;
   }

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public boolean isShowModalPanelHistorique() {
      return this.showModalPanelHistorique;
   }

   public void setShowModalPanelHistorique(boolean var1) {
      this.showModalPanelHistorique = var1;
   }

   public double getMontantEcart() {
      return this.montantEcart;
   }

   public void setMontantEcart(double var1) {
      this.montantEcart = var1;
   }

   public double getMontantEcartElmt() {
      return this.montantEcartElmt;
   }

   public void setMontantEcartElmt(double var1) {
      this.montantEcartElmt = var1;
   }

   public double getMontantFac() {
      return this.montantFac;
   }

   public void setMontantFac(double var1) {
      this.montantFac = var1;
   }

   public double getMontantFacElmt() {
      return this.montantFacElmt;
   }

   public void setMontantFacElmt(double var1) {
      this.montantFacElmt = var1;
   }

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public boolean isAffichageDepot() {
      return this.affichageDepot;
   }

   public void setAffichageDepot(boolean var1) {
      this.affichageDepot = var1;
   }

   public boolean isShowModalPanelPrintAvoir() {
      return this.showModalPanelPrintAvoir;
   }

   public void setShowModalPanelPrintAvoir(boolean var1) {
      this.showModalPanelPrintAvoir = var1;
   }

   public boolean isShowModalPanelPrintFacture() {
      return this.showModalPanelPrintFacture;
   }

   public void setShowModalPanelPrintFacture(boolean var1) {
      this.showModalPanelPrintFacture = var1;
   }

   public boolean isShowModalPanelPrintRetour() {
      return this.showModalPanelPrintRetour;
   }

   public void setShowModalPanelPrintRetour(boolean var1) {
      this.showModalPanelPrintRetour = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public int getChoixImpression() {
      return this.choixImpression;
   }

   public void setChoixImpression(int var1) {
      this.choixImpression = var1;
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

   public String getOngletActif() {
      return this.ongletActif;
   }

   public void setOngletActif(String var1) {
      this.ongletActif = var1;
   }

   public Date getDateRechargement() {
      return this.dateRechargement;
   }

   public void setDateRechargement(Date var1) {
      this.dateRechargement = var1;
   }

   public DataModel getDataModelNoteDebit() {
      return this.dataModelNoteDebit;
   }

   public void setDataModelNoteDebit(DataModel var1) {
      this.dataModelNoteDebit = var1;
   }

   public boolean isShowModalPanelPrintNoteDebit() {
      return this.showModalPanelPrintNoteDebit;
   }

   public void setShowModalPanelPrintNoteDebit(boolean var1) {
      this.showModalPanelPrintNoteDebit = var1;
   }

   public NoteDebitEnteteVentes getNoteDebitEnteteVentes() {
      return this.noteDebitEnteteVentes;
   }

   public void setNoteDebitEnteteVentes(NoteDebitEnteteVentes var1) {
      this.noteDebitEnteteVentes = var1;
   }

   public boolean isShowModalPanelProduit() {
      return this.showModalPanelProduit;
   }

   public void setShowModalPanelProduit(boolean var1) {
      this.showModalPanelProduit = var1;
   }

   public boolean isVisibiliteBtonDechargement() {
      return this.visibiliteBtonDechargement;
   }

   public void setVisibiliteBtonDechargement(boolean var1) {
      this.visibiliteBtonDechargement = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
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
}
