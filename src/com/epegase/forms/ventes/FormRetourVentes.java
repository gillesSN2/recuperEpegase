package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
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
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
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
import com.epegase.systeme.xml.ObjetIncoterm;
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

public class FormRetourVentes implements Serializable {
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
   private List mesContactItem = new ArrayList();
   private Contacts contacts;
   private RetourEnteteVentes retourEnteteVentes = new RetourEnteteVentes();
   private RetourEnteteVentesDao retourEnteteVentesDao;
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
   private RetourLigneVentes retourLigneVentes = new RetourLigneVentes();
   private RetourLigneVentesDao retourLigneVentesDao;
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
   private String var_memo_serie;
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
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
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

   public FormRetourVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.retourEnteteVentesDao = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.retourLigneVentesDao = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionsVentes.getAffichInGlobViewRETOUR();
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

   public void rechercheDOCUMENT(long var1) throws HibernateException, NamingException {
      this.lesLignesList = new ArrayList();
      this.retourEnteteVentes = this.retourEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.retourEnteteVentes != null) {
         this.devisePrint = this.retourEnteteVentes.getBrtDevise();
         this.lesLignesList = this.retourLigneVentesDao.chargerLesLignes(this.retourEnteteVentes, (Session)null);
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
         List var12 = this.retourEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpNumBCC, this.inpNumAnal, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new RetourEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               RetourEnteteVentes var16 = (RetourEnteteVentes)var12.get(var17);
               if (var16.getBrtActivite() != null && !var16.getBrtActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getBrtActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getBrtActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getBrtActivite().contains(this.var_colonne3)) {
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
         new RetourEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            RetourEnteteVentes var18 = (RetourEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var18.getBrtTotTtc();
            var4 += var18.getBrtTotReglement();
            var6 += var18.getBrtTotHt();
            var8 += var18.getBrtTotTva();
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
            this.retourEnteteVentes = (RetourEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.retourEnteteVentes.getBrtNomTiers();
            this.inpIdTiersEnCours = this.retourEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.retourEnteteVentes.getBrtNomContact();
            this.var_date = this.retourEnteteVentes.getBrtDate();
            if (this.retourEnteteVentes.getBrtDate().getHours() <= 9) {
               this.var_heure = "0" + this.retourEnteteVentes.getBrtDate().getHours();
            } else {
               this.var_heure = "" + this.retourEnteteVentes.getBrtDate().getHours();
            }

            if (this.retourEnteteVentes.getBrtDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.retourEnteteVentes.getBrtDate().getMinutes();
            } else {
               this.var_minute = "" + this.retourEnteteVentes.getBrtDate().getMinutes();
            }

            if (this.retourEnteteVentes.getBrtDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.retourEnteteVentes.getBrtDate().getSeconds();
            } else {
               this.var_seconde = "" + this.retourEnteteVentes.getBrtDate().getSeconds();
            }

            this.tiers = this.retourEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.numeroPfManuel = this.retourEnteteVentes.getBrtAnal4();
            this.var_nom_contact = this.retourEnteteVentes.getBrtIdContact();
            this.var_nom_responsable = this.retourEnteteVentes.getBrtIdResponsable();
            this.var_nom_commercial = this.retourEnteteVentes.getBrtIdCommercial();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerDocumentTrace(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
            this.chargerLesParcs(var4);
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

            this.setMontantTtcElmt(this.retourEnteteVentes.getBrtTotTtc());
            this.setMontantReglementElmt(this.retourEnteteVentes.getBrtTotReglement());
            this.setMontantSoldeElmt(this.retourEnteteVentes.getBrtTotTtc() - this.retourEnteteVentes.getBrtTotReglement());
            this.cumulPrix();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.retourEnteteVentes.getBrtTotTc() != 0.0D) {
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
      if (this.retourEnteteVentes != null) {
         if (this.retourEnteteVentes.getBrtEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.retourEnteteVentes.getBrtDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.retourEnteteVentes.getBrtDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.retourEnteteVentes.getBrtId() > 0L) {
         this.lesLignesList = this.retourLigneVentesDao.chargerLesLignes(this.retourEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.retourEnteteVentes != null && this.retourEnteteVentes.getBrtEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.retourEnteteVentes.getBrtAnal4(), this.retourEnteteVentes.getBrtAnal4()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.retourEnteteVentes.getBrtId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.retourEnteteVentes.getBrtId(), this.nature, var1);
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
      if (this.retourEnteteVentes != null && this.retourEnteteVentes.getBrtSerie() != null && !this.retourEnteteVentes.getBrtSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.retourEnteteVentes.getBrtSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.retourEnteteVentes.getBrtId(), this.nature, var1);
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
      if (this.decoupageActivite && this.retourEnteteVentes.getBrtActivite() != null && !this.retourEnteteVentes.getBrtActivite().isEmpty() && this.retourEnteteVentes.getBrtActivite().contains(":")) {
         String[] var1 = null;
         if (!this.retourEnteteVentes.getBrtActivite().contains("#")) {
            var1 = this.retourEnteteVentes.getBrtActivite().split(":");
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
            String[] var2 = this.retourEnteteVentes.getBrtActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.retourEnteteVentes.getBrtTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.retourEnteteVentes.getBrtTotHt() - this.totalImputation;
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
      this.retourEnteteVentes = new RetourEnteteVentes();
      this.retourLigneVentes = new RetourLigneVentes();
      this.retourEnteteVentes.setUsers(this.usersLog);
      this.retourEnteteVentes.setBrtIdCreateur(this.usersLog.getUsrid());
      this.retourEnteteVentes.setBrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.retourEnteteVentes.setBrtDate(new Date());
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
      this.retourEnteteVentes.setBrtDateLivraison((Date)null);
      this.retourEnteteVentes.setBrtBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.retourEnteteVentes.setBrtIdCommercial(this.usersLog.getUsrid());
         this.retourEnteteVentes.setBrtNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.retourEnteteVentes.setBrtIdResponsable(this.usersLog.getUsrid());
         this.retourEnteteVentes.setBrtNomResponsable(this.usersLog.getUsrPatronyme());
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
      if (this.optionsVentes.getNbrJrRelanceRETOUR() != null && !this.optionsVentes.getNbrJrRelanceRETOUR().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceRETOUR());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidRETOUR() != null && !this.optionsVentes.getNbrJrValidRETOUR().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidRETOUR());
      } else {
         var4 = 0;
      }

      this.retourEnteteVentes.setBrtDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.retourEnteteVentes.setBrtDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.retourEnteteVentes != null) {
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
            this.mesUsersItem.add(new SelectItem(this.retourEnteteVentes.getBrtIdResponsable(), this.retourEnteteVentes.getBrtNomResponsable()));
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
      if (this.retourEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.retourEnteteVentes.getBrtIdResponsable(), this.retourEnteteVentes.getBrtNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.retourEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.retourEnteteVentes.getBrtEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.retourEnteteVentes.setBrtEtat(1);
               this.retourEnteteVentes.setBrtDateValide(new Date());
               this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle retour (C.) N° " + this.retourEnteteVentes.getBrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.retourEnteteVentes.getBrtDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument4() == null || this.retourEnteteVentes.getBrtDate().after(this.tiers.getTieDteDocument4())) {
               this.tiers.setTieDteDocument4(this.retourEnteteVentes.getBrtDate());
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
      if (this.retourEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.retourEnteteVentes.getBrtEtat() == 1) {
               this.retourEnteteVentes.setBrtEtat(0);
               this.retourEnteteVentes.setBrtDateValide((Date)null);
               this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle retour (C.) N° " + this.retourEnteteVentes.getBrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.retourEnteteVentes.getBrtDate()));
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
      if (this.retourEnteteVentes != null) {
         this.retourEnteteVentes.setBrtEtat(0);
         this.retourEnteteVentes.setBrtDateAnnule((Date)null);
         this.retourEnteteVentes.setBrtMotifAnnule("");
         this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.retourEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.retourEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.retourEnteteVentes.getBrtId();
            String var5 = this.retourEnteteVentes.getBrtNum();
            Date var6 = this.retourEnteteVentes.getBrtDate();
            if (this.lesLignesList.size() != 0) {
               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  this.retourLigneVentes = new RetourLigneVentes();
                  this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var7);
                  this.calculStock.majRetourVentesATT(this.retourLigneVentes, this.produits, 0.0F, 0, this.baseLog, var1);
               }
            }

            this.retourLigneVentesDao.deleteAllLigne(this.retourEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.retourEnteteVentes.getBrtId(), this.nature, var1);
            this.retourEnteteVentesDao.delete(this.retourEnteteVentes.getBrtId(), var1);
            this.documentTraceVentes = new DocumentTraceVentes();
            this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(var3, this.nature, var1);
            if (this.documentTraceVentes != null) {
               long var18 = this.documentTraceVentes.getDoctraOrgId();
               int var9 = this.documentTraceVentes.getDoctraOrgType();
               this.documentTraceVentesDao.delete(this.documentTraceVentes, var1);
               boolean var10 = false;
               this.documentTraceVentes = this.documentTraceVentesDao.chercherOrigineTrace(var18, var9, var1);
               byte var20;
               if (this.documentTraceVentes != null) {
                  var20 = 4;
               } else {
                  var20 = 1;
               }

               if (var9 == 23) {
                  new LivraisonEnteteVentes();
                  LivraisonEnteteVentesDao var12 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  LivraisonEnteteVentes var11 = var12.pourParapheur(var18, var1);
                  if (var11 != null) {
                     var11.setBlvEtat(var20);
                     if (var20 == 1) {
                        var11.setBlvDateTransforme((Date)null);
                        var11.setBlvTypeTransforme(0);
                     }

                     var12.modif(var11, var1);
                  }
               }
            }

            Espion var19 = new Espion();
            var19.setUsers(this.usersLog);
            var19.setEsptype(0);
            var19.setEspdtecreat(new Date());
            var19.setEspaction("Suppression Retour N° " + var5 + " du " + var6);
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
      if (this.retourEnteteVentes.getBrtId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.retourEnteteVentes.setUsers(this.usersLog);
            this.retourEnteteVentes.setBrtIdCreateur(this.usersLog.getUsrid());
            this.retourEnteteVentes.setBrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.retourEnteteVentes.setBrtDate(new Date());
            this.retourEnteteVentes.setBrtDateCreat(new Date());
            this.retourEnteteVentes.setBrtDateModif((Date)null);
            this.retourEnteteVentes.setBrtIdModif(0L);
            this.retourEnteteVentes.setBrtNomModif("");
            this.retourEnteteVentes.setBrtNum("");
            this.retourEnteteVentes.setBrtIdResponsable(this.usersLog.getUsrid());
            this.retourEnteteVentes.setBrtNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var3 = false;
            int var12;
            if (this.optionsVentes.getNbrJrRelanceRETOUR() != null && !this.optionsVentes.getNbrJrRelanceRETOUR().isEmpty()) {
               var12 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceRETOUR());
            } else {
               var12 = 0;
            }

            boolean var4 = false;
            int var13;
            if (this.optionsVentes.getNbrJrValidRETOUR() != null && !this.optionsVentes.getNbrJrValidRETOUR().isEmpty()) {
               var13 = Integer.parseInt(this.optionsVentes.getNbrJrValidRETOUR());
            } else {
               var13 = 0;
            }

            this.retourEnteteVentes.setBrtDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var12));
            this.retourEnteteVentes.setBrtDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var13));
            this.retourEnteteVentes.setBrtDateLivraison((Date)null);
            if (!this.retourEnteteVentes.getBrtSerie().equalsIgnoreCase("X") && !this.retourEnteteVentes.getBrtSerie().isEmpty()) {
               this.retourEnteteVentes.setBrtNum(this.calculChrono.numCompose(this.retourEnteteVentes.getBrtDate(), this.nature, this.retourEnteteVentes.getBrtSerie(), var1));
            } else {
               long var5 = this.retourEnteteVentesDao.selectLastNum(var1);
               this.retourEnteteVentes.setBrtNum("" + var5);
            }

            this.verifieExistenceHabilitation();
            this.retourEnteteVentes.setBrtDateAnnule((Date)null);
            this.retourEnteteVentes.setBrtMotifAnnule("");
            this.retourEnteteVentes.setBrtDateImp((Date)null);
            this.retourEnteteVentes.setBrtDateTransforme((Date)null);
            this.retourEnteteVentes.setBrtEtat(0);
            this.retourEnteteVentes.setBrtContener("");
            this.retourEnteteVentes = this.retourEnteteVentesDao.duppliquer(this.retourEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               this.retourLigneVentesDao.duppliquerLigne(this.lesLignesList, this.retourEnteteVentes, var1);
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
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.retourEnteteVentes.getBrtId(), this.retourEnteteVentes.getBrtNum(), this.retourEnteteVentes.getBrtNomTiers(), this.retourEnteteVentes.getBrtDate(), this.retourEnteteVentes.getBrtDevise(), this.retourEnteteVentes.getBrtTotTtc() + this.retourEnteteVentes.getBrtTotTc(), this.retourEnteteVentes.getBrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.retourEnteteVentes.getVar_format_devise(), 0, (Session)null);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.retourEnteteVentes.getBrtNumAvoir() == null || this.retourEnteteVentes.getBrtNumAvoir().isEmpty()) {
            if (this.retourEnteteVentes.getBrtTypeTransforme() != 0) {
               var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.retourEnteteVentes.getBrtTypeTransforme(), var1);
               if (var3) {
                  String var4 = "";
                  if (this.retourEnteteVentes.getBrtTypeTransforme() == 26) {
                     var4 = "Avoir";
                  }

                  this.documentTrfItems.add(new SelectItem(this.retourEnteteVentes.getBrtTypeTransforme(), var4));
               }
            } else {
               var2 = this.usersChronoDao.existByUserNat(this.usersLog, 26, var1);
               if (var2) {
                  this.documentTrfItems.add(new SelectItem(26, "Avoir"));
               }
            }
         }

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            new RetourEnteteVentes();
            RetourEnteteVentes var5 = (RetourEnteteVentes)this.lesEntetesList.get(var8);
            if (var5.getBrtId() > 0L && var5.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.retourLigneVentesDao.chargerLesLignes(var5, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new RetourLigneVentes();
                     RetourLigneVentes var7 = (RetourLigneVentes)this.lesLignesList.get(var6);
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

   public void annule() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.var_action <= 1) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         this.cumulPrix();
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
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
      if (this.retourEnteteVentes.getBrtTypeReg() != 0 && this.retourEnteteVentes.getBrtTypeReg() != 3) {
         if (this.retourEnteteVentes.getBrtTypeReg() != 1 && this.retourEnteteVentes.getBrtTypeReg() != 2 && this.retourEnteteVentes.getBrtTypeReg() != 10) {
            if (this.retourEnteteVentes.getBrtTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.retourEnteteVentes.getBrtModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.retourEnteteVentes.getBrtModeReg() != null && !this.retourEnteteVentes.getBrtModeReg().isEmpty() && this.retourEnteteVentes.getBrtModeReg().contains(":")) {
         String[] var2 = this.retourEnteteVentes.getBrtModeReg().split(":");
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

            this.retourEnteteVentes.setBrtTypeReg(Integer.parseInt(var3.getEcheances()));
            this.retourEnteteVentes.setBrtModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.retourEnteteVentes.setBrtNbJourReg(0);
            this.retourEnteteVentes.setBrtArrondiReg(0);
            break;
         }
      }

      if (this.retourEnteteVentes.getBrtTypeReg() != 0 && this.retourEnteteVentes.getBrtTypeReg() != 3) {
         if (this.retourEnteteVentes.getBrtTypeReg() != 1 && this.retourEnteteVentes.getBrtTypeReg() != 2 && this.retourEnteteVentes.getBrtTypeReg() != 10) {
            if (this.retourEnteteVentes.getBrtTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.retourEnteteVentes.setBrtTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.retourEnteteVentes.setBrtModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.retourEnteteVentes.setBrtNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.retourEnteteVentes.setBrtArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.retourEnteteVentes.getBrtModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.retourEnteteVentes.getBrtDate(), this.retourEnteteVentes.getBrtTypeReg(), this.retourEnteteVentes.getBrtNbJourReg(), this.retourEnteteVentes.getBrtArrondiReg());
      this.retourEnteteVentes.setBrtDateEcheReg(var1);
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
         if (this.retourEnteteVentes.getBrtId() != 0L) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.retourEnteteVentes.setBrtDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.retourEnteteVentes.getUsers() == null) {
            this.retourEnteteVentes.setUsers(this.usersLog);
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

         this.retourEnteteVentes.setTiers(this.tiers);
         if ((this.retourEnteteVentes.getBrtCat() == null || this.retourEnteteVentes.getBrtCat().isEmpty()) && this.retourEnteteVentes.getTiers().getTienomfamille() != null && !this.retourEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.retourEnteteVentes.setBrtCat(this.retourEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.retourEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.retourEnteteVentes.setBrtCivilTiers("");
         } else {
            this.retourEnteteVentes.setBrtCivilTiers(this.retourEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.retourEnteteVentes.getBrtDiversTiers() == 99) {
               this.retourEnteteVentes.setBrtIdContact(0L);
               this.retourEnteteVentes.setBrtNomContact("");
               this.retourEnteteVentes.setBrtCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.retourEnteteVentes.setBrtIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.retourEnteteVentes.setBrtNomContact(var3.getConpatronyme());
                     this.retourEnteteVentes.setBrtCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.retourEnteteVentes.setBrtNomContact(var3.getConservice());
                     this.retourEnteteVentes.setBrtCivilContact("SERVICE/SITE:");
                  } else {
                     this.retourEnteteVentes.setBrtIdContact(0L);
                     this.retourEnteteVentes.setBrtNomContact("");
                     this.retourEnteteVentes.setBrtCivilContact("");
                  }
               } else {
                  this.retourEnteteVentes.setBrtIdContact(0L);
                  this.retourEnteteVentes.setBrtNomContact("");
                  this.retourEnteteVentes.setBrtCivilContact("");
               }
            }

            this.retourEnteteVentes.setBrtTiersRegroupe(this.tiers.getTiesigle());
         }

         this.retourEnteteVentes.setBrtIdResponsable(0L);
         this.retourEnteteVentes.setBrtNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.retourEnteteVentes.setBrtIdResponsable(var15.getUsrid());
            this.retourEnteteVentes.setBrtNomResponsable(var15.getUsrPatronyme());
         }

         this.retourEnteteVentes.setBrtIdCommercial(0L);
         this.retourEnteteVentes.setBrtNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.retourEnteteVentes.setBrtIdCommercial(var4.getUsrid());
               this.retourEnteteVentes.setBrtNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.retourEnteteVentes.setBrtIdEquipe(0L);
         this.retourEnteteVentes.setBrtNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.retourEnteteVentes.getBrtIdResponsable(), var1);
            if (this.equipes != null) {
               this.retourEnteteVentes.setBrtIdEquipe(this.equipes.getEquId());
               this.retourEnteteVentes.setBrtNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.retourEnteteVentes.getBrtTotTtc() + this.retourEnteteVentes.getBrtTotTc(), var16, this.retourEnteteVentes.getBrtDevise(), this.retourEnteteVentes.getBrtDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.retourEnteteVentes.getBrtDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.retourEnteteVentes.getBrtDevise());
               this.retourEnteteVentes.setBrtFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.retourEnteteVentes.getBrtDevise(), this.retourEnteteVentes.getBrtDate()));
            }
         }

         if (this.accesAffaires) {
         }

         if (this.retourEnteteVentes.getBrtId() != 0L) {
            if (this.retourEnteteVentes.getBrtEtat() == 6) {
               if (this.retourEnteteVentes.getBrtEtatVal() == 1) {
                  this.retourEnteteVentes.setBrtEtat(0);
               } else {
                  this.retourEnteteVentes.setBrtEtat(0);
               }
            }

            this.retourEnteteVentes.setBrtDateModif(new Date());
            this.retourEnteteVentes.setBrtIdModif(this.usersLog.getUsrid());
            this.retourEnteteVentes.setBrtNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var16);
               this.retourLigneVentes.setBrtligOrdre(var16);
               this.retourLigneVentes.setRetourEnteteVentes(this.retourEnteteVentes);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var1);
            }
         } else {
            this.retourEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.retourEnteteVentes.setBrtDateCreat(new Date());
            this.retourEnteteVentes.setBrtIdCreateur(this.usersLog.getUsrid());
            this.retourEnteteVentes.setBrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.retourEnteteVentes.getBrtSerie() != null && !this.retourEnteteVentes.getBrtSerie().equalsIgnoreCase("X") && !this.retourEnteteVentes.getBrtSerie().isEmpty()) {
               this.retourEnteteVentes.setBrtNum(this.calculChrono.numCompose(this.retourEnteteVentes.getBrtDate(), this.nature, this.retourEnteteVentes.getBrtSerie(), var1));
               boolean var18 = false;

               label409:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label409;
                     }

                     new RetourEnteteVentes();
                     RetourEnteteVentes var19 = this.retourEnteteVentesDao.pourParapheur(this.retourEnteteVentes.getBrtNum(), this.retourEnteteVentes.getBrtSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.retourEnteteVentes.setBrtNum(this.calculChrono.numCompose(this.retourEnteteVentes.getBrtDate(), this.nature, this.retourEnteteVentes.getBrtSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.retourEnteteVentesDao.selectLastNum(var1);
               this.retourEnteteVentes.setBrtNum("" + var17);
            }

            this.retourEnteteVentes.setBrtEtat(0);
            this.retourEnteteVentes.setBrtEtatVal(0);
            this.retourEnteteVentes.setBrtDateValide((Date)null);
            this.retourEnteteVentes = this.retourEnteteVentesDao.insert(this.retourEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.retourEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.retourEnteteVentes.getBrtId(), this.retourEnteteVentes.getBrtNum(), this.retourEnteteVentes.getBrtNomTiers(), this.retourEnteteVentes.getBrtDate(), this.retourEnteteVentes.getBrtDevise(), this.retourEnteteVentes.getBrtTotTtc() + this.retourEnteteVentes.getBrtTotTc(), this.retourEnteteVentes.getBrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.retourEnteteVentes.getVar_format_devise(), 0, var1);
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
      this.retourEnteteVentes.setBrtSite(this.usersLog.getUsrSite());
      this.retourEnteteVentes.setBrtDepartement(this.usersLog.getUsrDepartement());
      this.retourEnteteVentes.setBrtService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.retourEnteteVentes.setBrtIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.retourEnteteVentes.getBrtNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.retourEnteteVentes.setBrtTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.retourEnteteVentes.setBrtRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.retourEnteteVentes.setBrtSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.retourEnteteVentes.setBrtPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.retourEnteteVentes.setBrtTiersRegroupe(this.tiers.getTiesigle());
            this.retourEnteteVentes.setBrtRegion(this.tiers.getTieregion());
            this.retourEnteteVentes.setBrtSecteur(this.tiers.getTiesecteur());
            this.retourEnteteVentes.setBrtPdv(this.tiers.getTiepdv());
         }
      } else {
         this.retourEnteteVentes.setBrtTiersRegroupe(this.tiers.getTiesigle());
         this.retourEnteteVentes.setBrtRegion(this.tiers.getTieregion());
         this.retourEnteteVentes.setBrtSecteur(this.tiers.getTiesecteur());
         this.retourEnteteVentes.setBrtPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.retourEnteteVentes.setBrtActivite("");
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

               this.retourEnteteVentes.setBrtActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new RetourLigneVentes();
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

                  RetourLigneVentes var13 = (RetourLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getBrtligCode() != null && !var13.getBrtligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getBrtligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getBrtligPt());
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
                              var7.setPrix(var13.getBrtligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getBrtligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.retourEnteteVentes.setBrtActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.retourEnteteVentes.setBrtAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.retourEnteteVentes.getBrtAnal4() != null && this.retourEnteteVentes.getBrtAnal4().length() <= 2) {
         this.retourEnteteVentes.setBrtAnal4("");
      }

      if (!this.var_anal_parc) {
         this.retourEnteteVentes.setBrtAnal2("");
      } else if (this.retourEnteteVentes.getBrtAnal2() != null && this.retourEnteteVentes.getBrtAnal2().length() <= 2) {
         this.retourEnteteVentes.setBrtAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation() {
      if (this.habilitation != null) {
         this.retourEnteteVentes.setBrtEtatVal(1);
         this.retourEnteteVentes.setBrtEtat(0);
         this.retourEnteteVentes.setBrtDateValide((Date)null);
         return true;
      } else {
         this.retourEnteteVentes.setBrtEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.retourEnteteVentes.setBrtEtat(1);
               this.retourEnteteVentes.setBrtDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.retourEnteteVentes.setBrtEtat(0);
               this.retourEnteteVentes.setBrtDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.retourEnteteVentes != null) {
         this.retourEnteteVentes.setBrtDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.retourEnteteVentes != null) {
         if (this.retourEnteteVentes.getBrtDateAnnule() == null) {
            this.retourEnteteVentes.setBrtDateAnnule(new Date());
         }

         this.retourEnteteVentes.setBrtEtat(3);
         this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation retour vente N° " + this.retourEnteteVentes.getBrtNum() + " le " + this.retourEnteteVentes.getBrtDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.retourEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.retourEnteteVentes.getBrtExoTva() == 0) {
         TaxesVentes var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
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

      this.retourLigneVentes.setBrtligTaxe(var6);
      this.retourLigneVentes.setBrtligTauxTaxe(var5);
      double var35 = this.retourLigneVentes.getBrtligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.retourEnteteVentes.getBrtDevise());
      }

      var10 = this.retourLigneVentes.getBrtligQte();
      if (this.retourLigneVentes.getBrtligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.retourLigneVentes.setBrtligQteUtil(this.retourLigneVentes.getBrtligQte());
            var10 = this.retourLigneVentes.getBrtligQte() * this.retourLigneVentes.getBrtligLong();
         } else {
            this.retourLigneVentes.setBrtligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.retourLigneVentes.getBrtligCondition(), this.retourLigneVentes.getBrtligQte(), this.retourLigneVentes.getBrtligLong(), this.retourLigneVentes.getBrtligLarg(), this.retourLigneVentes.getBrtligHaut(), this.retourLigneVentes.getBrtligDiam(), this.retourLigneVentes.getBrtligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.retourLigneVentes.setBrtligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && this.retourLigneVentes.getBrtligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.retourLigneVentes.getBrtligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.retourLigneVentes.getBrtligRabais() * (double)this.retourLigneVentes.getBrtligQte();
      }

      if (this.retourLigneVentes.getBrtligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.retourLigneVentes.getBrtligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.retourLigneVentes.getBrtligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.retourLigneVentes.getBrtligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && this.retourLigneVentes.getBrtligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.retourLigneVentes.getBrtligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.retourLigneVentes.getBrtligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.retourLigneVentes.getBrtligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.retourLigneVentes.getBrtligQte(), 2);
      }

      this.retourLigneVentes.setBrtligPuRem(var25);
      this.retourLigneVentes.setBrtligPt(var17);
      this.retourLigneVentes.setBrtligTva(var21);
      this.retourLigneVentes.setBrtligTc(0.0D);
      this.retourLigneVentes.setBrtligTtc(var23);
      double var27 = 0.0D;
      if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && this.retourLigneVentes.getBrtligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.retourLigneVentes.getBrtligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.retourLigneVentes.getBrtligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.retourLigneVentes.getBrtligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.retourLigneVentes.getBrtligQte(), 2);
      }

      this.retourLigneVentes.setBrtligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.retourLigneVentes.getBrtligTauxTaxe() / 100.0D;
      this.retourLigneVentes.setBrtligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.retourEnteteVentes.setBrtTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.retourLigneVentes.setBrtligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
               if (this.retourLigneVentes.getBrtligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.retourLigneVentes.getBrtligTauxTaxe() / 100.0D;
                  this.retourLigneVentes.setBrtligTc(var33);
               }
            }
         } else {
            if (this.retourLigneVentes.getBrtligTva() != 0.0D) {
               var31 = var17 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.retourLigneVentes.setBrtligTc(var33);
         }
      } else {
         this.retourLigneVentes.setBrtligTc(0.0D);
         this.retourEnteteVentes.setBrtTauxTc(0.0F);
      }

      this.retourLigneVentes.setBrtligPt(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligPt(), this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligTva(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligTva(), this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligTtc(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligTtc(), this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligTc(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligTc(), this.retourEnteteVentes.getBrtDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.retourEnteteVentes.getBrtExoTva() == 0) {
         TaxesVentes var8;
         int var38;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
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

      this.retourLigneVentes.setBrtligTaxe(var6);
      this.retourLigneVentes.setBrtligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.retourEnteteVentes.getBrtTauxTc() != 0.0F && this.retourLigneVentes.getBrtligTva() != 0.0D) {
         var10 = this.retourLigneVentes.getBrtligTtc();
         var12 = var10 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.retourLigneVentes.getBrtligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.retourLigneVentes.getBrtligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.retourLigneVentes.setBrtligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.retourLigneVentes.getBrtligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.retourLigneVentes.getBrtligRabais() * (double)this.retourLigneVentes.getBrtligQte();
      }

      double var14 = 0.0D;
      if (this.retourLigneVentes.getBrtligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.retourLigneVentes.getBrtligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.retourLigneVentes.getBrtligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.retourLigneVentes.getBrtligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.retourLigneVentes.getBrtligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.retourLigneVentes.setBrtligQteUtil(this.retourLigneVentes.getBrtligQte());
         } else {
            this.retourLigneVentes.setBrtligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.retourLigneVentes.getBrtligCondition(), this.retourLigneVentes.getBrtligQte(), this.retourLigneVentes.getBrtligLong(), this.retourLigneVentes.getBrtligLarg(), this.retourLigneVentes.getBrtligHaut(), this.retourLigneVentes.getBrtligDiam(), this.retourLigneVentes.getBrtligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.retourLigneVentes.setBrtligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.retourLigneVentes.getBrtligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.retourEnteteVentes.getBrtDevise()));
      double var26 = var20 * (double)this.retourLigneVentes.getBrtligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.retourEnteteVentes.getBrtDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligPuRem(var18);
      this.retourLigneVentes.setBrtligPuRemTtc(var20);
      this.retourLigneVentes.setBrtligPt(var24);
      this.retourLigneVentes.setBrtligTva(var32);
      this.retourLigneVentes.setBrtligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.retourEnteteVentes.setBrtTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.retourLigneVentes.setBrtligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
               if (this.retourLigneVentes.getBrtligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.retourLigneVentes.getBrtligTauxTaxe() / 100.0D;
                  this.retourLigneVentes.setBrtligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.retourEnteteVentes.getBrtTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.retourLigneVentes.setBrtligTc(var36);
         }
      } else {
         this.retourLigneVentes.setBrtligTc(0.0D);
         this.retourEnteteVentes.setBrtTauxTc(0.0F);
      }

      this.retourLigneVentes.setBrtligPt(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligPt(), this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligTva(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligTva(), this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligTtc(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligTtc(), this.retourEnteteVentes.getBrtDevise()));
      this.retourLigneVentes.setBrtligTc(this.utilNombre.myRoundDevise(this.retourLigneVentes.getBrtligTc(), this.retourEnteteVentes.getBrtDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      this.messageStockNegatif = "";
      if (this.produitsDepot != null) {
         this.validationLigne = 0;
      } else {
         this.validationLigne = 0;
      }

      if (this.retourLigneVentes != null && this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.retourLigneVentes.getBrtligPuRemTtc() != 0.0D) {
               if (this.retourLigneVentes.getBrtligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.retourLigneVentes.getBrtligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.retourLigneVentes.getBrtligPuRem() != 0.0D) {
            if (this.retourLigneVentes.getBrtligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.retourLigneVentes.getBrtligPu() < this.prixPlancher) {
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
         new RetourLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            RetourLigneVentes var13 = (RetourLigneVentes)this.lesLignesList.get(var14);
            if (var13.getBrtligGroupe() == null || var13.getBrtligGroupe().isEmpty()) {
               var3 += var13.getBrtligPt();
               var5 += var13.getBrtligTva();
               var7 += var13.getBrtligTtc();
               var9 += var13.getBrtligTc();
               if (var13.getBrtligRabais() != 0.0D || var13.getBrtligTauxRemise() != 0.0F) {
                  var11 += var13.getBrtligPu() * (double)var13.getBrtligQte() - var13.getBrtligPt();
               }

               var1 = var1 + var13.getBrtligPt() - var13.getBrtligPump() * (double)var13.getBrtligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.retourEnteteVentes.setBrtTotHt(var3);
      this.retourEnteteVentes.setBrtTotTva(var5);
      this.retourEnteteVentes.setBrtTotTtc(var7);
      this.retourEnteteVentes.setBrtTotRemise(var11);
      this.retourEnteteVentes.setBrtTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.retourLigneVentes = (RetourLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         if (this.retourLigneVentes.getBrtligCode() != null && this.retourLigneVentes.getBrtligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.retourLigneVentes.getBrtligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.retourLigneVentes.setBrtligCode(this.produits.getProCode());
               this.retourLigneVentes.setBrtligFamille(this.produits.getProAchCode());
               this.retourLigneVentes.setBrtligStock(this.produits.getProStock());
               this.retourLigneVentes.setBrtligLong(this.produits.getProLongueur());
               this.retourLigneVentes.setBrtligLarg(this.produits.getProLargeur());
               this.retourLigneVentes.setBrtligHaut(this.produits.getProEpaisseur());
               this.retourLigneVentes.setBrtligDiam(this.produits.getProDiamExt());
               this.retourLigneVentes.setBrtligPoidsBrut(this.produits.getProPoidsBrut());
               this.retourLigneVentes.setBrtligPoidsNet(this.produits.getProPoidsNet());
               this.retourLigneVentes.setBrtligVolume(this.produits.getProVolume());
               this.retourLigneVentes.setBrtligNb(this.produits.getProNbUnite());
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
               if (this.retourLigneVentes.getBrtligTaxe() != null && !this.retourLigneVentes.getBrtligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTaxe() + ":" + this.retourLigneVentes.getBrtligTauxTaxe()));
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
         this.retourLigneVentes = (RetourLigneVentes)this.datamodelLigne.getRowData();
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
      this.retourLigneVentes = new RetourLigneVentes();
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
      if (this.retourLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.retourLigneVentes);
            this.lesLignesList.add(this.numLigne, this.retourLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var3);
               this.retourLigneVentes.setBrtligOrdre(var3);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var1);
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
      if (this.retourLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.retourLigneVentes);
            this.lesLignesList.add(this.numLigne, this.retourLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var3);
               this.retourLigneVentes.setBrtligOrdre(var3);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var1);
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
            if (this.retourLigneVentes.getBrtligId() == ((RetourLigneVentes)this.lesLignesList.get(var2)).getBrtligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() || this.retourLigneVentes.getBrtligLibelle() != null && !this.retourLigneVentes.getBrtligLibelle().isEmpty() || this.retourLigneVentes.getBrtligComplement() != null && !this.retourLigneVentes.getBrtligComplement().isEmpty()) {
         if (this.retourEnteteVentes.getBrtId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.retourLigneVentes.getBrtligQteUtil() == 0.0F) {
               this.retourLigneVentes.setBrtligQteUtil(this.retourLigneVentes.getBrtligQte());
            }

            this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.retourLigneVentes.setBrtligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.retourLigneVentes.setBrtligDepot(var3[0]);
               }
            } else {
               this.retourLigneVentes.setBrtligDepot("");
            }

            if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && this.retourLigneVentes.getBrtligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.retourLigneVentes.getBrtligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.retourLigneVentes.setBrtligDescription(var5);
               } else {
                  this.retourLigneVentes.setBrtligDescription("");
               }

               if (this.retourLigneVentes.getBrtligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.retourLigneVentes.setBrtligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.retourLigneVentes.setBrtligDescription("");
            }

            if (this.retourLigneVentes.getBrtligId() == 0L) {
               this.retourLigneVentes.setRetourEnteteVentes(this.retourEnteteVentes);
               this.retourLigneVentes.setBrtligDevise(this.retourEnteteVentes.getBrtDevise());
               this.retourLigneVentes = this.retourLigneVentesDao.insertLigne(this.retourLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.retourLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new RetourLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  RetourLigneVentes var16 = (RetourLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getBrtligGroupe() != null && !var16.getBrtligGroupe().isEmpty() && var16.getBrtligGroupe().equals(this.memoProduits.getProCode())) {
                     this.retourLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.retourLigneVentes.getBrtligQte();
               new RetourLigneVentes();

               RetourLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (RetourLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getBrtligGroupe() != null && !var19.getBrtligGroupe().isEmpty() && var19.getBrtligGroupe().equals(var18)) {
                     this.retourLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new RetourLigneVentes();
                     var19.setBrtligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setBrtligCondition("");
                     var19.setBrtligComplement("");
                     var19.setBrtligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setBrtligDescription("");
                     var19.setBrtligDevise(this.retourEnteteVentes.getBrtDevise());
                     var19.setBrtligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setBrtligEchelle(0);
                     var19.setBrtligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setBrtligGroupe(var18);
                     var19.setBrtligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setBrtligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setBrtligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setBrtligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setBrtligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setBrtligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setBrtligOrdre(var8);
                     var19.setBrtligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setBrtligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setBrtligPt(0.0D);
                     var19.setBrtligPu(0.0D);
                     var19.setBrtligPuRem(0.0D);
                     var19.setBrtligPuRemTtc(0.0D);
                     var19.setBrtligPuTtc(0.0D);
                     var19.setBrtligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setBrtligQte(var9);
                     var19.setBrtligQteUtil(var19.getBrtligQte());
                     var19.setBrtligRabais(0.0D);
                     var19.setBrtligReference(var18);
                     var19.setBrtligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setBrtligTauxRemise(0.0F);
                     var19.setBrtligTauxTaxe(0.0F);
                     var19.setBrtligTaxe("");
                     var19.setBrtligTc(0.0D);
                     var19.setBrtligTtc(0.0D);
                     var19.setBrtligTva(0.0D);
                     var19.setBrtligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setBrtligVolume(0.0F);
                     var19.setRetourEnteteVentes(this.retourEnteteVentes);
                     var19 = this.retourLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
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
      if (this.retourLigneVentes.getBrtligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.retourLigneVentes.getBrtligCode();
            int var4 = this.retourLigneVentes.getBrtligModeGroupe();
            String var5 = this.retourLigneVentes.getBrtligGroupe();
            this.retourLigneVentesDao.deleteOneLigne(this.retourLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new RetourLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  RetourLigneVentes var6 = (RetourLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getBrtligGroupe() != null && !var6.getBrtligGroupe().isEmpty() && var6.getBrtligGroupe().equals(var3)) {
                     this.retourLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " du Retour N° " + this.retourEnteteVentes.getBrtNum() + " du " + this.retourEnteteVentes.getBrtDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.retourEnteteVentes.getBrtNomTiers(), this.nature);
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
                     this.retourEnteteVentes.setBrtSerie(this.tiers.getTieserie());
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
            this.retourEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.retourEnteteVentes.setBrtCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.retourEnteteVentes.setBrtCivilTiers(this.retourEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.retourEnteteVentes.setBrtNomTiers(this.nomTier);
            this.retourEnteteVentes.setBrtTypeReg(this.tiers.getTietypereg());
            this.retourEnteteVentes.setBrtModeReg(this.tiers.getTiemodereg());
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
               this.retourEnteteVentes.setBrtNbJourReg(this.tiers.getTienbecheance());
               this.retourEnteteVentes.setBrtArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.retourEnteteVentes.setBrtTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.retourEnteteVentes.setBrtModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.retourEnteteVentes.setBrtNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.retourEnteteVentes.setBrtArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.retourEnteteVentes.setBrtCat(this.tiers.getTienomfamille());
            this.retourEnteteVentes.setBrtExoDouane(this.tiers.getTieexodouane());
            var9 = this.tiers.getTieexotva();
            if (var9 >= 2) {
               var9 = 0;
            }

            this.retourEnteteVentes.setBrtExoTva(var9);
            if (this.var_tc_calcul) {
               this.retourEnteteVentes.setBrtTauxTc(this.var_tc_taux);
            } else {
               this.retourEnteteVentes.setBrtTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2) {
               this.retourEnteteVentes.setBrtExoTva(1);
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
               this.retourEnteteVentes.setBrtDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.retourEnteteVentes.setBrtDiversTiers(0);
               this.retourEnteteVentes.setBrtDiversNom("");
               this.retourEnteteVentes.setBrtDiversAdresse("");
               this.retourEnteteVentes.setBrtDiversVille("");
               this.retourEnteteVentes.setBrtDiversTel("");
               this.retourEnteteVentes.setBrtDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.retourEnteteVentes.setBrtDevise(this.tiers.getTiedevise());
            } else {
               this.retourEnteteVentes.setBrtDevise(this.structureLog.getStrdevise());
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
      this.retourEnteteVentes.setTiers(this.tiers);
      this.retourEnteteVentes.setBrtNomTiers("");
      this.retourEnteteVentes.setBrtCivilTiers("");
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
      if (!this.retourEnteteVentes.getBrtNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.retourEnteteVentes.getBrtCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2) {
         this.retourEnteteVentes.setBrtExoTva(0);
      } else {
         this.retourEnteteVentes.setBrtExoTva(1);
      }

      if (var2.equalsIgnoreCase("true")) {
         this.retourEnteteVentes.setBrtExoDouane(1);
      } else {
         this.retourEnteteVentes.setBrtExoDouane(0);
      }

      if (this.var_tc_calcul) {
         this.retourEnteteVentes.setBrtTauxTc(this.var_tc_taux);
      } else {
         this.retourEnteteVentes.setBrtTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.retourLigneVentes = new RetourLigneVentes();
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var3);
               if (this.retourEnteteVentes.getBrtExoTva() == 1) {
                  this.retourLigneVentes.setBrtligTaxe("");
                  this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
                  this.retourLigneVentes.setBrtligTva(0.0D);
               } else if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.retourLigneVentes.getBrtligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.retourLigneVentes.setBrtligTaxe("");
                        this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.retourLigneVentes.setBrtligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.retourLigneVentes.setBrtligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.retourLigneVentes.getBrtligTaxe(), var1);
                        if (var5 != null) {
                           this.retourLigneVentes.setBrtligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.retourLigneVentes.setBrtligTaxe(this.optionsVentes.getTvaDefaut());
                        this.retourLigneVentes.setBrtligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.retourLigneVentes.setBrtligTaxe("");
                        this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
                     }
                  } else {
                     this.retourLigneVentes.setBrtligTaxe("");
                     this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
                  }

                  if ((this.retourLigneVentes.getBrtligTaxe() == null || this.retourLigneVentes.getBrtligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.retourLigneVentes.setBrtligTaxe(var5.getTaxvteCode());
                        this.retourLigneVentes.setBrtligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var1);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var1);
            }
         }

         if (this.retourEnteteVentes.getBrtId() != 0L) {
            this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.retourLigneVentes = new RetourLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var3);
               this.retourLigneVentes.setBrtligTauxRemise(this.retourEnteteVentes.getBrtTauxRemise());
               this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var1);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var1);
            }
         }

         if (this.retourEnteteVentes.getBrtId() != 0L) {
            this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.retourEnteteVentes.getBrtNomContact(), this.nature);
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
         this.retourEnteteVentes.setBrtNomContact(this.plansAnalytiques.getAnaNomFr());
         this.retourEnteteVentes.setBrtCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.retourEnteteVentes.setBrtAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.retourEnteteVentes.setBrtNomContact("");
      this.retourEnteteVentes.setBrtCivilContact("");
      this.retourEnteteVentes.setBrtAnal4("");
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
      if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && !this.retourLigneVentes.getBrtligCode().equals("-") && !this.retourLigneVentes.getBrtligCode().equals("=")) {
         if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.retourLigneVentes.getBrtligCode(), this.nature, this.optionsVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.retourLigneVentes.getBrtligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         this.retourLigneVentes.setBrtligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.retourLigneVentes.setBrtligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.retourLigneVentes.setBrtligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.retourLigneVentes.setBrtligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.retourLigneVentes.setBrtligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.retourLigneVentes.setBrtligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.retourLigneVentes.setBrtligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.retourLigneVentes.setBrtligFamille(this.produits.getProVteCode());
         this.retourLigneVentes.setBrtligStock(this.produits.getProStock());
         this.retourLigneVentes.setBrtligLong(this.produits.getProLongueur());
         this.retourLigneVentes.setBrtligLarg(this.produits.getProLargeur());
         this.retourLigneVentes.setBrtligHaut(this.produits.getProEpaisseur());
         this.retourLigneVentes.setBrtligDiam(this.produits.getProDiamExt());
         this.retourLigneVentes.setBrtligPoidsBrut(this.produits.getProPoidsBrut());
         this.retourLigneVentes.setBrtligPoidsNet(this.produits.getProPoidsNet());
         this.retourLigneVentes.setBrtligVolume(this.produits.getProVolume());
         this.retourLigneVentes.setBrtligNb(this.produits.getProNbUnite());
         this.retourLigneVentes.setBrtligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.retourLigneVentes.setBrtligModeGroupe(this.produits.getProMode());
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
                  this.retourLigneVentes.setBrtligTaxe(this.produits.getProVteTva());
                  this.retourLigneVentes.setBrtligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.retourLigneVentes.setBrtligTaxe("");
                  this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.retourLigneVentes.setBrtligTaxe(var8.getFamvteTaxe());
                  this.retourLigneVentes.setBrtligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.retourLigneVentes.setBrtligTaxe("");
               this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.retourEnteteVentes.getBrtExoTva() == 0 && (this.retourLigneVentes.getBrtligTaxe() == null || this.retourLigneVentes.getBrtligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.retourLigneVentes.setBrtligTaxe(var9.getTaxvteCode());
                  this.retourLigneVentes.setBrtligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.retourLigneVentes.setBrtligTaxe("");
            this.retourLigneVentes.setBrtligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.retourLigneVentes.getBrtligTauxTaxe() / 100.0D;
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
               this.retourLigneVentes.setBrtligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.retourLigneVentes.setBrtligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.retourLigneVentes.setBrtligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.retourLigneVentes.setBrtligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.retourLigneVentes.setBrtligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.retourLigneVentes.getBrtligPump() != 0.0D) {
            this.retourLigneVentes.setBrtligPu(this.retourLigneVentes.getBrtligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var1);
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
      if (this.retourLigneVentes.getBrtligCode() == null || this.retourLigneVentes.getBrtligCode().isEmpty() || this.retourLigneVentes.getBrtligCode().length() < 2) {
         if (this.retourEnteteVentes.getBrtExoTva() == 0 && this.tiers.getTiefacpr() <= 1) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.retourLigneVentes.setBrtligTaxe(this.optionsVentes.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.retourLigneVentes.setBrtligCode("");
      this.retourLigneVentes.setBrtligLibelle("");
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
            var2 = this.retourLigneVentes.getBrtligPuTtc();
         } else {
            var2 = this.retourLigneVentes.getBrtligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.retourLigneVentes.setBrtligPuTtc(this.prixUnitaires);
            this.retourLigneVentes.setBrtligPuRemTtc(this.prixUnitaires);
         } else {
            this.retourLigneVentes.setBrtligPu(this.prixUnitaires);
            this.retourLigneVentes.setBrtligPuRem(this.prixUnitaires);
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
                     this.retourLigneVentes.setBrtligTauxRemise(var6.getBarRemise());
                     this.retourLigneVentes.setBrtligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.retourEnteteVentes.getBrtDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.retourLigneVentes.setBrtligPuTtc(this.prixUnitaires);
                        this.retourLigneVentes.setBrtligPuRemTtc(var11);
                     } else {
                        this.retourLigneVentes.setBrtligPu(this.prixUnitaires);
                        this.retourLigneVentes.setBrtligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.retourLigneVentes.setBrtligTauxRemise(var6.getBarRemise());
                     this.retourLigneVentes.setBrtligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.retourLigneVentes.getBrtligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.retourLigneVentes.setBrtligPuTtc(this.prixUnitaires);
                        this.retourLigneVentes.setBrtligPuRemTtc(var11);
                     } else {
                        this.retourLigneVentes.setBrtligPu(this.prixUnitaires);
                        this.retourLigneVentes.setBrtligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.retourLigneVentes.setBrtligTauxRemise(var6.getBarRemise());
                     this.retourLigneVentes.setBrtligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.retourLigneVentes.setBrtligPuTtc(this.prixUnitaires);
                        this.retourLigneVentes.setBrtligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.retourLigneVentes.setBrtligPu(this.prixUnitaires);
                        this.retourLigneVentes.setBrtligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.retourLigneVentes.setBrtligPuTtc(this.prixUnitaires);
                     this.retourLigneVentes.setBrtligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.retourLigneVentes.setBrtligPu(this.prixUnitaires);
                     this.retourLigneVentes.setBrtligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((RetourLigneVentes)this.lesLignesList.get(var9)).getBrtligCode() == null || ((RetourLigneVentes)this.lesLignesList.get(var9)).getBrtligCode().isEmpty() || !((RetourLigneVentes)this.lesLignesList.get(var9)).getBrtligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((RetourLigneVentes)this.lesLignesList.get(var9)).getBrtligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((RetourLigneVentes)this.lesLignesList.get(var8)).getBrtligFamille() != null && !((RetourLigneVentes)this.lesLignesList.get(var8)).getBrtligFamille().isEmpty() && ((RetourLigneVentes)this.lesLignesList.get(var8)).getBrtligFamille().equals(var7)) {
                  var5 += ((RetourLigneVentes)this.lesLignesList.get(var8)).getBrtligPt();
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
         double var2 = this.retourLigneVentes.getBrtligPu();
         double var4 = this.retourLigneVentes.getBrtligPuTtc();
         if (this.retourLigneVentes.getBrtligPu() >= 0.0D && this.retourLigneVentes.getBrtligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.retourEnteteVentes.getBrtCat(), (String)null, var1);
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
                     if (this.retourLigneVentes.getBrtligQte() >= var7.getQteDebut() && this.retourLigneVentes.getBrtligQte() <= var7.getQteFin()) {
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
                        if (this.retourLigneVentes.getBrtligQte() >= var7.getQteDebut() && this.retourLigneVentes.getBrtligQte() <= var7.getQteFin()) {
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
            var2 = Math.abs(this.retourLigneVentes.getBrtligPu());
            var4 = Math.abs(this.retourLigneVentes.getBrtligPuTtc());
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
      this.retourLigneVentes.setBrtligUnite(this.produitsDepot.getProdepUnite());
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
               this.validationLigne = 0;
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
         if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && this.retourLigneVentes.getBrtligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.retourLigneVentes.getBrtligEchelle());
            float var5 = 1.0F;
            if (this.retourLigneVentes.getBrtligCondition().contains("/")) {
               String[] var6 = this.retourLigneVentes.getBrtligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && !this.retourLigneVentes.getBrtligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.retourLigneVentes.getBrtligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.retourLigneVentes.setBrtligPump(var9);
      } else {
         this.retourLigneVentes.setBrtligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.retourLigneVentes.getBrtligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.retourLigneVentes.setBrtligEchelle(this.unite.getUniEchelle());
               } else {
                  this.retourLigneVentes.setBrtligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.retourLigneVentes.setBrtligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.retourLigneVentes.setBrtligEchelle(Integer.parseInt(var2));
         } else {
            this.retourLigneVentes.setBrtligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.retourLigneVentes.getBrtligLong(), this.retourLigneVentes.getBrtligLarg(), this.retourLigneVentes.getBrtligHaut(), this.retourLigneVentes.getBrtligDiam(), this.retourLigneVentes.getBrtligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.retourLigneVentes.getBrtligLong(), this.retourLigneVentes.getBrtligLarg(), this.retourLigneVentes.getBrtligHaut(), this.retourLigneVentes.getBrtligDiam(), this.retourLigneVentes.getBrtligNb(), this.baseLog, var1);
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

      this.var_serie_trf = this.retourEnteteVentes.getBrtSerie();
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
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

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.retourEnteteVentes.getBrtSerie();
      this.var_imput_cat = this.retourEnteteVentes.getBrtCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new RetourEnteteVentes();
         RetourEnteteVentes var1 = this.retourEnteteVentesDao.pourParapheur(this.var_imput_num, this.retourEnteteVentes.getBrtSerie(), (Session)null);
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
      int var5;
      Parapheur var6;
      Espion var21;
      if (this.var_imput_choix == 0) {
         if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.retourEnteteVentes.getBrtNum();
               this.retourEnteteVentes.setBrtNum(this.var_imput_num);
               this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.retourEnteteVentes.getBrtId(), this.nature, var1);
               if (var4 != null) {
                  for(var5 = 0; var5 < var4.size(); ++var5) {
                     new Parapheur();
                     var6 = (Parapheur)var4.get(var5);
                     var6.setPhrNum(this.retourEnteteVentes.getBrtNum());
                     this.parapheurDao.modif(var6, var1);
                  }
               }

               var21 = new Espion();
               var21.setUsers(this.usersLog);
               var21.setEsptype(0);
               var21.setEspdtecreat(new Date());
               var21.setEspaction("Imputation Retour N° " + var3 + " en Retour N° " + this.retourEnteteVentes.getBrtNum());
               this.espionDao.mAJEspion(var21, var1);
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
      } else if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.retourEnteteVentes.getBrtNum();
            this.retourEnteteVentes.setBrtSerie(this.var_imput_serie);
            this.retourEnteteVentes.setBrtCat(this.var_imput_cat);
            this.retourEnteteVentes.setBrtNum(this.calculChrono.numCompose(this.retourEnteteVentes.getBrtDate(), this.nature, this.retourEnteteVentes.getBrtSerie(), var1));
            this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
            if (this.retourEnteteVentes.getBrtTotReglement() != 0.0D) {
               new ArrayList();
               ReglementsDao var22 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var22.reglementDocument(this.retourEnteteVentes.getBrtId(), this.nature, var1);
               if (var4 != null) {
                  for(int var23 = 0; var23 < var4.size(); ++var23) {
                     new Reglements();
                     Reglements var7 = (Reglements)var4.get(var23);
                     var7.setRglDocument(this.retourEnteteVentes.getBrtNum());
                     var22.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.retourEnteteVentes.getBrtId(), this.nature, var1);
            if (var4 != null) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  new Parapheur();
                  var6 = (Parapheur)var4.get(var5);
                  var6.setPhrNum(this.retourEnteteVentes.getBrtNum());
                  this.parapheurDao.modif(var6, var1);
               }
            }

            var21 = new Espion();
            var21.setUsers(this.usersLog);
            var21.setEsptype(0);
            var21.setEspdtecreat(new Date());
            var21.setEspaction("Imputation Retour X N° " + var3 + " en Retour " + this.retourEnteteVentes.getBrtSerie() + " N° " + this.retourEnteteVentes.getBrtNum());
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
            new RetourLigneVentes();
            RetourLigneVentes var3 = (RetourLigneVentes)this.documentDetailTrf.get(var2);
            long var4 = var3.getBrtligId();
            float var6 = var3.getBrtligQte();
            float var7 = 0.0F;
            if (this.var_type_trf == 26) {
               AvoirLigneVentesDao var8 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var7 = var8.chargerLesReliquatsFactureVtes(var4, var1);
            }

            float var9 = var6 - var7;
            if (var9 < 0.0F) {
               var9 = 0.0F;
            }

            var3.setVar_qteDejaTrf(var7);
            var3.setVar_qteReliquat(var9);
            var3 = (RetourLigneVentes)this.documentDetailTrf.set(var2, var3);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new RetourLigneVentes();
            RetourLigneVentes var2 = (RetourLigneVentes)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (RetourLigneVentes)this.documentDetailTrf.set(var1, var2);
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
            var3 += ((RetourLigneVentes)this.documentDetailTrf.get(var5)).getBrtligQte();
            var2 += ((RetourLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((RetourLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         int var7;
         if (var3 == var2) {
            new RetourEnteteVentes();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               RetourEnteteVentes var6 = (RetourEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setBrtEtat(5);
                  this.retourEnteteVentesDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            RetourEnteteVentes var12;
            if (this.var_mode_trf.equals("0")) {
               for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
                  new RetourEnteteVentes();
                  var12 = (RetourEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getBrtNum().equalsIgnoreCase(((RetourEnteteVentes)var1.get(var9)).getBrtNum())) {
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
                  new RetourEnteteVentes();
                  var12 = (RetourEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getTiers().getTieid() == ((RetourEnteteVentes)var1.get(var9)).getTiers().getTieid()) {
                           if (var12.getBrtSerie().equalsIgnoreCase(((RetourEnteteVentes)var1.get(var9)).getBrtSerie())) {
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
                  this.retourEnteteVentes = (RetourEnteteVentes)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((RetourEnteteVentes)var1.get(var11)).getBrtNum().equalsIgnoreCase(((RetourLigneVentes)this.documentDetailTrf.get(var7)).getRetourEnteteVentes().getBrtNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((RetourEnteteVentes)var1.get(var11)).getTiers().getTieid() == ((RetourLigneVentes)this.documentDetailTrf.get(var7)).getRetourEnteteVentes().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0) {
                     this.utilParapheur.supprimerParapheur(this.retourEnteteVentes.getBrtId(), this.nature, (Session)null);
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
               this.retourEnteteVentes = (RetourEnteteVentes)this.lesEntetesList.get(var11);
               if (this.retourEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.retourEnteteVentes);
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
            var3.setAvrSerie(this.retourEnteteVentes.getBrtSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setAvrIdCreateur(this.usersLog.getUsrid());
         var3.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setAvrDate(this.utilDate.dateToSQLLight(this.retourEnteteVentes.getBrtDate()));
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
         var3.setAvrService(this.retourEnteteVentes.getBrtService());
         if (!var3.getAvrSerie().equalsIgnoreCase("X") && !var3.getAvrSerie().isEmpty()) {
            var3.setAvrNum(this.calculChrono.numCompose(this.retourEnteteVentes.getBrtDate(), this.var_type_trf, var3.getAvrSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setAvrNum("" + var9);
         }

         this.verifieExistenceHabilitationAvoir(var3, var1);
         var3.setAvrSource(this.retourEnteteVentes.getBrtSource());
         var3.setAvrNomResponsable(this.retourEnteteVentes.getBrtNomResponsable());
         var3.setAvrIdResponsable(this.retourEnteteVentes.getBrtIdResponsable());
         var3.setAvrNomCommercial(this.retourEnteteVentes.getBrtNomCommercial());
         var3.setAvrIdCommercial(this.retourEnteteVentes.getBrtIdCommercial());
         var3.setAvrNomEquipe(this.retourEnteteVentes.getBrtNomEquipe());
         var3.setAvrIdEquipe(this.retourEnteteVentes.getBrtIdEquipe());
         var3.setAvrNomTiers(this.retourEnteteVentes.getBrtNomTiers());
         var3.setAvrCivilTiers(this.retourEnteteVentes.getBrtCivilTiers());
         var3.setAvrTiersRegroupe(this.retourEnteteVentes.getBrtTiersRegroupe());
         var3.setAvrIdContact(this.retourEnteteVentes.getBrtIdContact());
         var3.setAvrNomContact(this.retourEnteteVentes.getBrtNomContact());
         var3.setAvrCivilContact(this.retourEnteteVentes.getBrtCivilContact());
         var3.setAvrDiversAdresse(this.retourEnteteVentes.getBrtDiversAdresse());
         var3.setAvrDiversMail(this.retourEnteteVentes.getBrtDiversMail());
         var3.setAvrDiversNom(this.retourEnteteVentes.getBrtDiversNom());
         var3.setAvrDiversTel(this.retourEnteteVentes.getBrtDiversTel());
         var3.setAvrDiversTiers(this.retourEnteteVentes.getBrtDiversTiers());
         var3.setAvrDiversVille(this.retourEnteteVentes.getBrtDiversVille());
         var3.setAvrExoTva(this.retourEnteteVentes.getBrtExoTva());
         var3.setAvrExoDouane(this.retourEnteteVentes.getBrtExoDouane());
         var3.setAvrJournalReg(this.retourEnteteVentes.getBrtJournalReg());
         var3.setAvrCat(this.retourEnteteVentes.getBrtCat());
         var3.setAvrDevise(this.retourEnteteVentes.getBrtDevise());
         var3.setAvrObject(this.retourEnteteVentes.getBrtObject());
         var3.setAvrObservation(this.retourEnteteVentes.getBrtObservation());
         var3.setAvrTauxRemise(this.retourEnteteVentes.getBrtTauxRemise());
         var3.setAvrTotHt(0.0D);
         var3.setAvrTotRemise(0.0D);
         var3.setAvrTotRabais(0.0D);
         var3.setAvrTotTva(0.0D);
         var3.setAvrTotTc(0.0D);
         var3.setAvrTotTtc(0.0D);
         var3.setAvrTotReglement(0.0D);
         var3.setAvrSolde(0);
         var3.setAvrBanque(this.retourEnteteVentes.getBrtBanque());
         var3.setAvrTypeReg(this.retourEnteteVentes.getBrtTypeReg());
         var3.setAvrModeReg(this.retourEnteteVentes.getBrtModeReg());
         var3.setAvrNbJourReg(this.retourEnteteVentes.getBrtNbJourReg());
         var3.setAvrArrondiReg(this.retourEnteteVentes.getBrtArrondiReg());
         var3.setAvrConditionReg(this.retourEnteteVentes.getBrtConditionReg());
         var3.setAvrDateEcheReg(this.retourEnteteVentes.getBrtDateEcheReg());
         var3.setAvrContener(this.retourEnteteVentes.getBrtContener());
         var3.setAvrActivite(this.retourEnteteVentes.getBrtActivite());
         var3.setAvrSite(this.retourEnteteVentes.getBrtSite());
         var3.setAvrDepartement(this.retourEnteteVentes.getBrtDepartement());
         var3.setAvrRegion(this.retourEnteteVentes.getBrtRegion());
         var3.setAvrSecteur(this.retourEnteteVentes.getBrtSecteur());
         var3.setAvrPdv(this.retourEnteteVentes.getBrtPdv());
         var3.setAvrAnal2(this.retourEnteteVentes.getBrtAnal2());
         var3.setAvrAnal4(this.retourEnteteVentes.getBrtAnal4());
         var3.setAvrAffaire(this.retourEnteteVentes.getBrtAffaire());
         var3.setAvrInfo1(this.retourEnteteVentes.getBrtInfo1());
         var3.setAvrInfo2(this.retourEnteteVentes.getBrtInfo2());
         var3.setAvrInfo3(this.retourEnteteVentes.getBrtInfo3());
         var3.setAvrInfo4(this.retourEnteteVentes.getBrtInfo4());
         var3.setAvrInfo5(this.retourEnteteVentes.getBrtInfo5());
         var3.setAvrInfo6(this.retourEnteteVentes.getBrtInfo6());
         var3.setAvrInfo7(this.retourEnteteVentes.getBrtInfo7());
         var3.setAvrInfo8(this.retourEnteteVentes.getBrtInfo8());
         var3.setAvrInfo9(this.retourEnteteVentes.getBrtInfo9());
         var3.setAvrInfo10(this.retourEnteteVentes.getBrtInfo10());
         var3.setAvrFormule1(this.retourEnteteVentes.getBrtFormule1());
         var3.setAvrFormule2(this.retourEnteteVentes.getBrtFormule2());
         var3.setAvrAnnexe1(this.retourEnteteVentes.getBrtAnnexe1());
         var3.setAvrAnnexe2(this.retourEnteteVentes.getBrtAnnexe2());
         var3.setAvrContrat(this.retourEnteteVentes.getBrtContrat());
         var3.setAvrIncoterm(this.retourEnteteVentes.getBrtIncoterm());
         var3.setAvrLieuLivraison(this.retourEnteteVentes.getBrtLieuLivraison());
         var3.setAvrDateLivraison(this.retourEnteteVentes.getBrtDateLivraison());
         var3.setAvrInfoLivraison(this.retourEnteteVentes.getBrtInfoLivraison());
         var3.setAvrDateImp((Date)null);
         var3.setAvrModeleImp(this.var_modele_trf);
         var3.setAvrGarde(this.retourEnteteVentes.getBrtGarde());
         var3.setAvrGele(0);
         var3.setAvrEtat(0);
         var3.setAvrDateTransforme((Date)null);
         var3.setAvrTypeTransforme(0);
         var3.setAvrDateAnnule((Date)null);
         var3.setAvrMotifAnnule("");
         var3.setAvrFactorNom(this.retourEnteteVentes.getBrtFactorNom());
         var3.setAvrFactorId(this.retourEnteteVentes.getBrtFactorId());
         var3.setAvrFactorEtat(this.retourEnteteVentes.getBrtFactorEtat());
         var3.setAvrNumClient(this.retourEnteteVentes.getBrtNumClient());
         var3.setAvrDateClient(this.retourEnteteVentes.getBrtDateClient());
         var3.setExerciceventes(this.retourEnteteVentes.getExerciceventes());
         var3.setTiers(this.retourEnteteVentes.getTiers());
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
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var26);
               if (this.var_mode_trf != null && !this.var_mode_trf.isEmpty() && this.optionsVentes.getTransformation().equals("1")) {
                  if (this.var_mode_trf.equals("0")) {
                     if (var24 == null || var24.isEmpty() || !var24.equals(this.retourLigneVentes.getRetourEnteteVentes().getBrtNum())) {
                        var24 = this.retourLigneVentes.getRetourEnteteVentes().getBrtNum();
                        ++var25;
                        AvoirLigneVentes var39 = new AvoirLigneVentes();
                        var39.setAvrligCode("-");
                        var39.setAvrligLibelle("---> Suivant retour N° " + var24);
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
                           var41.setAvrligLibelle("---> Suivant retour N° " + var27);
                           var41.setAvoirEnteteVentes(var3);
                           var6.add(var41);
                           break;
                        }

                        if (var24 == null || var24.isEmpty() || !var24.equals(this.retourLigneVentes.getRetourEnteteVentes().getBrtNum())) {
                           var24 = this.retourLigneVentes.getRetourEnteteVentes().getBrtNum();
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

               if (this.retourLigneVentes.getBrtligLibelle() != null && !this.retourLigneVentes.getBrtligLibelle().isEmpty() && this.retourLigneVentes.getVar_qteReliquat() != 0.0F) {
                  if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.retourLigneVentes.getBrtligCode(), var1);
                     if (this.produits != null && this.retourLigneVentes.getBrtligDepot() != null && !this.retourLigneVentes.getBrtligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.retourLigneVentes.getBrtligCode(), this.retourLigneVentes.getBrtligDepot(), var1);
                     }
                  }

                  float var40 = this.retourLigneVentes.getBrtligQte();
                  float var42 = this.retourLigneVentes.getBrtligQteUtil();
                  ++var25;
                  AvoirLigneVentes var29 = new AvoirLigneVentes();
                  var38 += ((RetourLigneVentes)this.lesLignesList.get(var26)).getBrtligQte();
                  var10 += ((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_qteDejaTrf();
                  if (((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var29.setAvrligOrdre(var25);
                     var29.setAvrligCode(this.retourLigneVentes.getBrtligCode());
                     var29.setAvrligGroupe(this.retourLigneVentes.getBrtligGroupe());
                     var29.setAvrligModeGroupe(this.retourLigneVentes.getBrtligModeGroupe());
                     var29.setAvrligDevise(this.retourLigneVentes.getBrtligDevise());
                     var29.setAvrligFamille(this.retourLigneVentes.getBrtligFamille());
                     var29.setAvrligIdBlv(this.retourLigneVentes.getBrtligId());
                     var29.setAvrligLibelle(this.retourLigneVentes.getBrtligLibelle());
                     var29.setAvrligComplement(this.retourLigneVentes.getBrtligComplement());
                     if (((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne() != null && !((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().isEmpty() && ((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().contains("=")) {
                        String[] var30 = ((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_depotLigne().split("=");
                        var29.setAvrligDepot(var30[0]);
                     } else {
                        var29.setAvrligDepot("");
                     }

                     var29.setAvrligEchelle(this.retourLigneVentes.getBrtligEchelle());
                     var29.setAvrligUnite(this.retourLigneVentes.getBrtligUnite());
                     var29.setAvrligReference(this.retourLigneVentes.getBrtligReference());
                     var29.setAvrligPump(this.retourLigneVentes.getBrtligPump());
                     var29.setAvrligPu(this.retourLigneVentes.getBrtligPu());
                     var29.setAvrligPuTtc(this.retourLigneVentes.getBrtligPuTtc());
                     var29.setAvrligTauxRemise(this.retourLigneVentes.getBrtligTauxRemise());
                     var29.setAvrligPuRem(this.retourLigneVentes.getBrtligPuRem());
                     var29.setAvrligPuRemTtc(this.retourLigneVentes.getBrtligPuRemTtc());
                     this.retourLigneVentes.setBrtligQte(((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var1);
                     var29.setAvrligQte(((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var29.setAvrligLong(this.retourLigneVentes.getBrtligLong());
                     var29.setAvrligLarg(this.retourLigneVentes.getBrtligLarg());
                     var29.setAvrligHaut(this.retourLigneVentes.getBrtligHaut());
                     var29.setAvrligDiam(this.retourLigneVentes.getBrtligDiam());
                     var29.setAvrligPoidsBrut(this.retourLigneVentes.getBrtligPoidsBrut());
                     var29.setAvrligPoidsNet(this.retourLigneVentes.getBrtligPoidsNet());
                     var29.setAvrligVolume(this.retourLigneVentes.getBrtligVolume());
                     var29.setAvrligNb(this.retourLigneVentes.getBrtligNb());
                     var29.setAvrligQteStock(0.0F);
                     var29.setAvrligRabais(this.retourLigneVentes.getBrtligRabais());
                     var29.setAvrligTauxTaxe(this.retourLigneVentes.getBrtligTauxTaxe());
                     var29.setAvrligTaxe(this.retourLigneVentes.getBrtligTaxe());
                     var29.setAvrligPt(this.retourLigneVentes.getBrtligPt());
                     var29.setAvrligTva(this.retourLigneVentes.getBrtligTva());
                     var29.setAvrligTtc(this.retourLigneVentes.getBrtligTtc());
                     var29.setAvrligTc(this.retourLigneVentes.getBrtligTc());
                     var29.setAvoirEnteteVentes(var3);
                     var11 += ((RetourLigneVentes)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var29);
                     var12 += var29.getAvrligPt();
                     var14 += (var29.getAvrligPu() - var29.getAvrligPuRem()) * (double)var29.getAvrligQte();
                     var16 += var29.getAvrligRabais();
                     var18 += var29.getAvrligTva();
                     var20 += var29.getAvrligTtc();
                     var22 += var29.getAvrligTc();
                     this.retourLigneVentes.setBrtligQte(var40);
                     this.retourLigneVentes.setBrtligQteUtil(var42);
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

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationAvoir(var3, var1), var3.getAvrId(), var3.getAvrNum(), var3.getAvrNomTiers(), var3.getAvrDate(), var3.getAvrDevise(), var3.getAvrTotTtc() + var3.getAvrTotTc(), var3.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 26), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFAVR(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.retourEnteteVentes.getExerciceventes());
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.retourEnteteVentes.getBrtSerie());
         this.documentTraceVentes.setDoctraOrgId(this.retourEnteteVentes.getBrtId());
         this.documentTraceVentes.setDoctraOrgNum(this.retourEnteteVentes.getBrtNum());
         this.documentTraceVentes.setDoctraOrgDate(this.retourEnteteVentes.getBrtDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getAvrSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getAvrId());
         this.documentTraceVentes.setDoctraDstNum(var3.getAvrNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getAvrDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         var3.setAvrDateTransforme(new Date());
         var3.setAvrTypeTransforme(this.var_type_trf);
         var4.modif(var3, var1);
         if (var38 <= var10 + var11 && var38 != 0.0F && var10 + var11 != 0.0F) {
            this.retourEnteteVentes.setBrtEtat(5);
         } else {
            this.retourEnteteVentes.setBrtEtat(4);
         }

         this.retourEnteteVentes.setBrtNumAvoir(var3.getAvrNum());
         this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var1);
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
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() == 2) {
            }
         }
      }

      return var4;
   }

   public String conversionGarde() throws HibernateException, HibernateException, NamingException {
      String var1 = null;
      if (this.retourEnteteVentes.getBrtGarde() != null && !this.retourEnteteVentes.getBrtGarde().isEmpty() && this.retourEnteteVentes.getBrtGarde().contains(":")) {
         String[] var2 = this.retourEnteteVentes.getBrtGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.retourEnteteVentes.getUsers(), this.structureLog, this.retourEnteteVentes.getTiers());
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
      if (this.retourEnteteVentes.getBrtFormule1() != null && !this.retourEnteteVentes.getBrtFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.retourEnteteVentes.getBrtFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.retourEnteteVentes.getBrtFormule2() != null && !this.retourEnteteVentes.getBrtFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.retourEnteteVentes.getBrtFormule2(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.retourEnteteVentes.getBrtAnnexe1() != null && !this.retourEnteteVentes.getBrtAnnexe1().isEmpty() && this.retourEnteteVentes.getBrtAnnexe1().contains(":")) {
         String[] var2 = this.retourEnteteVentes.getBrtAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.retourEnteteVentes.getUsers(), this.structureLog, this.retourEnteteVentes.getTiers());
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
      if (this.retourEnteteVentes.getBrtAnnexe2() != null && !this.retourEnteteVentes.getBrtAnnexe2().isEmpty() && this.retourEnteteVentes.getBrtAnnexe2().contains(":")) {
         String[] var2 = this.retourEnteteVentes.getBrtAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.retourEnteteVentes.getUsers(), this.structureLog, this.retourEnteteVentes.getTiers());
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatRetour.jpg");
            if (var4.exists()) {
               var3 = "formatRetour.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatRetour.jpg");
         if (var4.exists()) {
            var3 = "formatRetour.jpg";
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
            this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var10);
            if (this.retourLigneVentes.getBrtligModeGroupe() != 2 || this.retourLigneVentes.getBrtligGroupe() == null || this.retourLigneVentes.getBrtligGroupe().isEmpty()) {
               this.retourLigneVentes.setVar_lib_des_condit("");
               if (this.retourLigneVentes.getBrtligCondition() != null && !this.retourLigneVentes.getBrtligCondition().isEmpty() && this.retourLigneVentes.getBrtligCondition().contains(":")) {
                  String[] var11 = this.retourLigneVentes.getBrtligCondition().split(":");
                  Conditionnement var9 = var8.rechercheConditionnement(var11[0], (Session)null);
                  if (var9 != null) {
                     this.retourLigneVentes.setVar_lib_des_condit(var9.getCdtDescription());
                  }
               }

               if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && this.retourLigneVentes.getBrtligCode().equals("-")) {
                  var2 = true;
                  var3 = this.retourLigneVentes.getBrtligLibelle();
                  if (var3.startsWith("Suivant ")) {
                     this.infoOrigineDoc = var3;
                  }
               }

               if (var2) {
                  var4 += this.retourLigneVentes.getBrtligPt();
                  var6 = this.retourLigneVentes.getBrtligTtc();
               }

               if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty() && this.retourLigneVentes.getBrtligCode().equals("=") && var2) {
                  this.retourLigneVentes = new RetourLigneVentes();
                  this.retourLigneVentes.setRetourEnteteVentes(this.retourEnteteVentes);
                  this.retourLigneVentes.setBrtligCode("=");
                  this.retourLigneVentes.setBrtligOrdre(var10);
                  this.retourLigneVentes.setBrtligLibelle(var3);
                  this.retourLigneVentes.setBrtligPt(var4);
                  this.retourLigneVentes.setBrtligTtc(var6);
                  var1.add(this.retourLigneVentes);
                  var4 = 0.0D;
                  var6 = 0.0D;
                  var2 = false;
               } else {
                  this.retourLigneVentes.setRetourEnteteVentes(this.retourEnteteVentes);
                  this.retourLigneVentes.setBrtligOrdre(var10);
                  var1.add(this.retourLigneVentes);
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.retourLigneVentes = new RetourLigneVentes();
            this.retourLigneVentes.setRetourEnteteVentes(this.retourEnteteVentes);
            this.retourLigneVentes.setBrtligCode("FORMULE1");
            this.retourLigneVentes.setBrtligOrdre(var1.size() + 2);
            this.retourLigneVentes.setBrtligLibelle(this.formule1());
            this.retourLigneVentes.setBrtligPt(0.0D);
            this.retourLigneVentes.setBrtligTtc(0.0D);
            var1.add(this.retourLigneVentes);
            this.retourLigneVentes = new RetourLigneVentes();
            this.retourLigneVentes.setRetourEnteteVentes(this.retourEnteteVentes);
            this.retourLigneVentes.setBrtligCode("FORMULE2");
            this.retourLigneVentes.setBrtligOrdre(var1.size() + 2);
            this.retourLigneVentes.setBrtligLibelle(this.formule2());
            this.retourLigneVentes.setBrtligPt(0.0D);
            this.retourLigneVentes.setBrtligTtc(0.0D);
            var1.add(this.retourLigneVentes);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.retourEnteteVentes.getBrtTotTtc() + this.retourEnteteVentes.getBrtTotTc(), this.retourEnteteVentes.getBrtDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var1);
      return var12;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.retourEnteteVentes.getBrtAnal2() != null && !this.retourEnteteVentes.getBrtAnal2().isEmpty()) {
         String var4 = "";
         if (this.retourEnteteVentes.getBrtAnal2().contains(":")) {
            String[] var5 = this.retourEnteteVentes.getBrtAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.retourEnteteVentes.getBrtAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.retourEnteteVentes.getBrtDateImp() != null && this.retourEnteteVentes.getBrtEtat() != 0) {
            var2 = true;
         }

         boolean var5 = false;
         this.retourEnteteVentes.setBrtDateImp(new Date());
         if (this.retourEnteteVentes.getBrtEtat() == 0 && this.retourEnteteVentes.getBrtEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.retourEnteteVentes.setBrtEtat(1);
            var5 = true;
         }

         this.retourEnteteVentes.setBrtModeleImp(var1);
         this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var3);
         if (var5) {
            this.calculStock.majRetourVentesVAL(this.lesLignesList, this.baseLog, var3);
            if (this.tiers.getTieDteDocument4() == null || this.retourEnteteVentes.getBrtDate().after(this.tiers.getTieDteDocument4())) {
               this.tiers.setTieDteDocument4(this.retourEnteteVentes.getBrtDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.contacts = new Contacts();
         if (this.retourEnteteVentes.getBrtIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.retourEnteteVentes.getBrtIdContact(), var3);
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
            var1.setEntete("Impression Retour");
            var1.setPageGarde(this.conversionGarde());
            if (this.retourEnteteVentes.getBrtFormule1() != null && !this.retourEnteteVentes.getBrtFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.retourEnteteVentes.getBrtEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.retourEnteteVentes.setBrtDevise(this.devisePrint);
            if (!this.retourEnteteVentes.getBrtDevise().equals("XOF") && !this.retourEnteteVentes.getBrtDevise().equals("XAF")) {
               if (this.retourEnteteVentes.getBrtDevise().equals("EUR")) {
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
               double var13 = this.utilNombre.myRound((this.retourEnteteVentes.getBrtTotTtc() + this.retourEnteteVentes.getBrtTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.retourEnteteVentes.getBrtIdResponsable());
            var1.setIdCommercial(this.retourEnteteVentes.getBrtIdCommercial());
            var1.setTiersSelectionne(this.retourEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.retourEnteteVentes.getBrtNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.retourEnteteVentes.getBrtId());
            if (this.retourEnteteVentes.getBrtAnal2() != null && !this.retourEnteteVentes.getBrtAnal2().isEmpty()) {
               String var17 = "";
               if (this.retourEnteteVentes.getBrtAnal2().contains(":")) {
                  String[] var14 = this.retourEnteteVentes.getBrtAnal2().split(":");
                  var17 = var14[0];
               } else {
                  var17 = this.retourEnteteVentes.getBrtAnal2();
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
         var1.setEntete("Impression de la liste des Retours");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "retour" + File.separator);
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
            this.uniteGraph = "BONS DE RETOUR : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "BON DE RETOUR : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "BONS DE RETOUR : Quantites";
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

         new RetourEnteteVentes();
         new RetourLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourLigne");
         String var6 = "";

         RetourEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (RetourEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getBrtNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getBrtNum() + "'";
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

                  var14 = (RetourEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getBrtDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getBrtNomResponsable() != null && !var14.getBrtNomResponsable().isEmpty()) {
                        var17 = var14.getBrtNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getBrtNomCommercial() != null && !var14.getBrtNomCommercial().isEmpty()) {
                        var17 = var14.getBrtNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getBrtNomEquipe() != null && !var14.getBrtNomEquipe().isEmpty()) {
                        var17 = var14.getBrtNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getBrtNomTiers() != null && !var14.getBrtNomTiers().isEmpty()) {
                        var17 = var14.getBrtNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getBrtSource() != null && !var14.getBrtSource().isEmpty()) {
                        var17 = var14.getBrtSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getBrtAnal4() != null && !var14.getBrtAnal4().isEmpty()) {
                        var17 = var14.getBrtAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getBrtRegion() != null && !var14.getBrtRegion().isEmpty()) {
                        var17 = var14.getBrtRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getBrtSecteur() != null && !var14.getBrtSecteur().isEmpty()) {
                        var17 = var14.getBrtSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getBrtPdv() != null && !var14.getBrtPdv().isEmpty()) {
                        var17 = var14.getBrtPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getBrtSite() != null && !var14.getBrtSite().isEmpty()) {
                        var17 = var14.getBrtSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getBrtDepartement() != null && !var14.getBrtDepartement().isEmpty()) {
                        var17 = var14.getBrtDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getBrtService() != null && !var14.getBrtService().isEmpty()) {
                        var17 = var14.getBrtService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getBrtSerie() != null && !var14.getBrtSerie().isEmpty()) {
                        var17 = var14.getBrtSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getBrtTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getBrtDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getBrtDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getBrtDate().getMonth() + 1 >= 1 && var14.getBrtDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getBrtDate().getMonth() + 1 >= 4 && var14.getBrtDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getBrtDate().getMonth() + 1 >= 7 && var14.getBrtDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getBrtDate().getMonth() + 1 >= 10 && var14.getBrtDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getBrtDate().getMonth() + 1 >= 1 && var14.getBrtDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getBrtDate().getMonth() + 1 >= 7 && var14.getBrtDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getBrtDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.retourLigneVentesDao.chargerLesLignesRetours(var6, var5);
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

                  RetourLigneVentes var15 = (RetourLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getRetourEnteteVentes().getBrtDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getRetourEnteteVentes().getBrtNomResponsable() != null && !var15.getRetourEnteteVentes().getBrtNomResponsable().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getRetourEnteteVentes().getBrtNomCommercial() != null && !var15.getRetourEnteteVentes().getBrtNomCommercial().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getRetourEnteteVentes().getBrtNomEquipe() != null && !var15.getRetourEnteteVentes().getBrtNomEquipe().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getRetourEnteteVentes().getBrtNomTiers() != null && !var15.getRetourEnteteVentes().getBrtNomTiers().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getBrtligFamille() != null && !var15.getBrtligFamille().isEmpty()) {
                        var8 = var15.getBrtligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getBrtligLibelle() != null && !var15.getBrtligLibelle().isEmpty()) {
                        var8 = var15.getBrtligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getRetourEnteteVentes().getBrtSource() != null && !var15.getRetourEnteteVentes().getBrtSource().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getRetourEnteteVentes().getBrtAnal4() != null && !var15.getRetourEnteteVentes().getBrtAnal4().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getRetourEnteteVentes().getBrtRegion() != null && !var15.getRetourEnteteVentes().getBrtRegion().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getRetourEnteteVentes().getBrtSecteur() != null && !var15.getRetourEnteteVentes().getBrtSecteur().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getRetourEnteteVentes().getBrtPdv() != null && !var15.getRetourEnteteVentes().getBrtPdv().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getRetourEnteteVentes().getBrtSite() != null && !var15.getRetourEnteteVentes().getBrtSite().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getRetourEnteteVentes().getBrtDepartement() != null && !var15.getRetourEnteteVentes().getBrtDepartement().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getRetourEnteteVentes().getBrtService() != null && !var15.getRetourEnteteVentes().getBrtService().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getRetourEnteteVentes().getBrtSerie() != null && !var15.getRetourEnteteVentes().getBrtSerie().isEmpty()) {
                        var8 = var15.getRetourEnteteVentes().getBrtSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getBrtligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getBrtligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getRetourEnteteVentes().getBrtDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 >= 1 && var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 >= 4 && var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 >= 7 && var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 >= 10 && var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 >= 1 && var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 >= 7 && var15.getRetourEnteteVentes().getBrtDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getRetourEnteteVentes().getBrtDate().getHours();
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

   public void recalculTva(RetourEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.retourEnteteVentes = var1;
         this.tiers = this.retourEnteteVentes.getTiers();
         if (this.tiers.getTiecss() == 0 && this.structureLog.getStrcodepays().equals("0077")) {
            this.var_tc_calcul = true;
            this.var_tc_taux = 1.0F;
            this.var_tc_type = 7;
         } else {
            this.var_tc_calcul = false;
            this.var_tc_taux = 0.0F;
            this.var_tc_type = 0;
         }

         this.lesLignesList = this.retourLigneVentesDao.chargerLesLignes(this.retourEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.retourLigneVentes.getBrtligCode(), var2);
               }

               this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var2);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var2);
            }

            this.cumulPrix();
            this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var2);
         }
      }

   }

   public void recalculCss(RetourEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.retourEnteteVentes = var1;
         this.tiers = this.retourEnteteVentes.getTiers();
         this.lesLignesList = this.retourLigneVentesDao.chargerLesLignes(this.retourEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.retourLigneVentes = (RetourLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.retourLigneVentes.getBrtligCode() != null && !this.retourLigneVentes.getBrtligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.retourLigneVentes.getBrtligCode(), var2);
               }

               this.calculPrix(this.retourLigneVentes.getBrtligTaxe(), this.retourLigneVentes.getBrtligTauxTaxe(), var2);
               this.retourLigneVentes = this.retourLigneVentesDao.modifLigne(this.retourLigneVentes, var2);
            }

            this.cumulPrix();
            this.retourEnteteVentes = this.retourEnteteVentesDao.modif(this.retourEnteteVentes, var2);
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

   public RetourEnteteVentes getRetourEnteteVentes() {
      return this.retourEnteteVentes;
   }

   public void setRetourEnteteVentes(RetourEnteteVentes var1) {
      this.retourEnteteVentes = var1;
   }

   public RetourLigneVentes getRetourLigneVentes() {
      return this.retourLigneVentes;
   }

   public void setRetourLigneVentes(RetourLigneVentes var1) {
      this.retourLigneVentes = var1;
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

   public boolean isVar_validation_lot() {
      return this.var_validation_lot;
   }

   public void setVar_validation_lot(boolean var1) {
      this.var_validation_lot = var1;
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

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public List getDocumentDetailTrf() {
      return this.documentDetailTrf;
   }

   public void setDocumentDetailTrf(List var1) {
      this.documentDetailTrf = var1;
   }

   public List getDocumentTrfItems() {
      return this.documentTrfItems;
   }

   public void setDocumentTrfItems(List var1) {
      this.documentTrfItems = var1;
   }

   public boolean isShowModalPanelTrf() {
      return this.showModalPanelTrf;
   }

   public void setShowModalPanelTrf(boolean var1) {
      this.showModalPanelTrf = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
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

   public String getVar_serie_trf() {
      return this.var_serie_trf;
   }

   public void setVar_serie_trf(String var1) {
      this.var_serie_trf = var1;
   }

   public int getVar_type_trf() {
      return this.var_type_trf;
   }

   public void setVar_type_trf(int var1) {
      this.var_type_trf = var1;
   }

   public boolean isVar_aff_trf() {
      return this.var_aff_trf;
   }

   public void setVar_aff_trf(boolean var1) {
      this.var_aff_trf = var1;
   }

   public List getMesSeriesTrfItems() {
      return this.mesSeriesTrfItems;
   }

   public void setMesSeriesTrfItems(List var1) {
      this.mesSeriesTrfItems = var1;
   }

   public List getModeleTrfItems() {
      return this.modeleTrfItems;
   }

   public void setModeleTrfItems(List var1) {
      this.modeleTrfItems = var1;
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
