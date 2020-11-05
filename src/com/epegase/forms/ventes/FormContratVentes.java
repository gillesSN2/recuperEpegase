package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.ContratLigneVentes;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
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
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.SalariesPointage;
import com.epegase.systeme.classe.SalariesTaches;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.ContratLigneVentesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
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
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.SalariesPointageDao;
import com.epegase.systeme.dao.SalariesTachesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TaxesVentesDao;
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
import com.epegase.systeme.xml.LectureModeleFacture;
import com.epegase.systeme.xml.LectureNatureMissions;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetModeleFacture;
import com.epegase.systeme.xml.ObjetReglement;
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

public class FormContratVentes implements Serializable {
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
   private int typeVente;
   private List mesOnglets;
   private OptionVentes optionsVentes;
   private int var_option_parc;
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
   private String nomTier;
   private List lesFamilleClientsListe;
   private List lesModeReglementClientsListe;
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
   private ContratEnteteVentes contratEnteteVentes = new ContratEnteteVentes();
   private ContratEnteteVentesDao contratEnteteVentesDao;
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
   private boolean showModalPanelValidationDocument = false;
   private List mesParcsItems = new ArrayList();
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private boolean showModalPanelHistoReglement = false;
   private double val_timbre;
   private ContratLigneVentes contratLigneVentes = new ContratLigneVentes();
   private ContratLigneVentesDao contratLigneVentesDao;
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
   private int inpEtat = 1;
   private String periode;
   private String inpNum = "";
   private String inpClient = "";
   private String inpDestinataire = "";
   private String inpResponsable = "";
   private String inpCommercial = "";
   private String inpActivite = "100";
   private String inpParc = "100";
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
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
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
   private boolean afficheTexteContrat;
   private String var_code_modele;
   private List mesModelesItems = new ArrayList();
   private transient DataModel dataModelEcheance = new ListDataModel();
   private List lesEcheances = new ArrayList();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private FactureEnteteVentes factureEnteteVentes;
   private FactureLigneVentesDao factureLigneVentesDao;
   private boolean showModalPanelAuto = false;
   private List mesPeriodesItems = new ArrayList();
   private List mesImpressionsFacturesItems = new ArrayList();
   private String modeleFacture;
   private int nombreFacture;
   private double totalHt;
   private double totalTtc;
   private double totalReglement;
   private String libelleRabRis;
   private boolean ristourne;
   private List mesNaturesMissions = new ArrayList();
   private transient DataModel dataModelTache = new ListDataModel();
   private TachesDao tachesDao;
   private SalariesPointage salariesPointage;
   private SalariesPointageDao salariesPointageDao;
   private Taches taches;
   private SalariesTaches salariesTaches;
   private SalariesTachesDao salariesTachesDao;

   public FormContratVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.contratEnteteVentesDao = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.contratLigneVentesDao = new ContratLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
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
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.salariesPointageDao = new SalariesPointageDao(this.baseLog, this.utilInitHibernate);
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.salariesTachesDao = new SalariesTachesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() throws JDOMException, IOException {
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
      } else if (this.optionsVentes.getAxeDossier().equals("2")) {
         this.accesAffaires = true;
         this.var_anal_dossier = false;
      } else {
         this.accesAffaires = false;
         this.var_anal_dossier = false;
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

      if (this.typeVente == 805) {
         LectureNatureMissions var1 = new LectureNatureMissions();
         var1.setStrId(this.structureLog.getStrid());
         var1.setStructureLog(this.structureLog);
         this.mesNaturesMissions = var1.chargerMesFamillesClientItems();
         if (this.mesNaturesMissions == null) {
            this.mesNaturesMissions = new ArrayList();
         }
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
      this.inpEtat = 1;
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

   public void recupererModelesItem(Session var1) throws HibernateException, NamingException {
      this.mesModelesItems = new ArrayList();
      ModelesCourriersDao var2 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var2.chargerLesContratsVentes(var1);
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

         this.lesEntetesList = this.contratEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, "", var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new ContratEnteteVentes();

         for(int var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            ContratEnteteVentes var12 = (ContratEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var12.getCrtTotTtc();
            var6 += var12.getCrtTotHt();
            var8 += var12.getCrtTotTva();
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
            this.contratEnteteVentes = (ContratEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.contratEnteteVentes.getCrtNomTiers();
            this.inpIdTiersEnCours = this.contratEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.contratEnteteVentes.getCrtNomContact();
            this.var_date = this.contratEnteteVentes.getCrtDate();
            if (this.contratEnteteVentes.getCrtDate().getHours() <= 9) {
               this.var_heure = "0" + this.contratEnteteVentes.getCrtDate().getHours();
            } else {
               this.var_heure = "" + this.contratEnteteVentes.getCrtDate().getHours();
            }

            if (this.contratEnteteVentes.getCrtDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.contratEnteteVentes.getCrtDate().getMinutes();
            } else {
               this.var_minute = "" + this.contratEnteteVentes.getCrtDate().getMinutes();
            }

            if (this.contratEnteteVentes.getCrtDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.contratEnteteVentes.getCrtDate().getSeconds();
            } else {
               this.var_seconde = "" + this.contratEnteteVentes.getCrtDate().getSeconds();
            }

            this.tiers = this.contratEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.var_nom_contact = this.contratEnteteVentes.getCrtIdContact();
            this.var_nom_responsable = this.contratEnteteVentes.getCrtIdResponsable();
            this.var_nom_commercial = this.contratEnteteVentes.getCrtIdCommercial();
            if (this.contratEnteteVentes.getCrtText() != null && !this.contratEnteteVentes.getCrtText().isEmpty()) {
               this.afficheTexteContrat = false;
            } else {
               this.afficheTexteContrat = true;
            }

            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerEcheance(var4);
            this.chargerTacheMission(var4);
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

            this.setMontantTtcElmt(this.contratEnteteVentes.getCrtTotTtc());
            this.setMontantReglementElmt(0.0D);
            this.setMontantSoldeElmt(0.0D);
            this.cumulPrix();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.contratEnteteVentes.getCrtTotTc() != 0.0D) {
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
      if (this.contratEnteteVentes != null) {
         if (this.contratEnteteVentes.getCrtEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.contratEnteteVentes.getCrtDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.contratEnteteVentes.getCrtDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.contratEnteteVentes.getCrtId() > 0L) {
         this.lesLignesList = this.contratLigneVentesDao.chargerLesLignes(this.contratEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerEcheance(Session var1) throws HibernateException, NamingException {
      this.nombreFacture = 0;
      this.totalHt = 0.0D;
      this.totalTtc = 0.0D;
      this.totalReglement = 0.0D;
      this.lesEcheances.clear();
      if (this.contratEnteteVentes.getCrtId() > 0L) {
         this.lesEcheances = this.factureEnteteVentesDao.rechercheFactureContrat(this.contratEnteteVentes.getCrtNum(), var1);
         if (this.lesEcheances.size() != 0) {
            for(int var2 = 0; var2 < this.lesEcheances.size(); ++var2) {
               ++this.nombreFacture;
               this.totalHt += ((FactureEnteteVentes)this.lesEcheances.get(var2)).getFacTotHt();
               this.totalTtc += ((FactureEnteteVentes)this.lesEcheances.get(var2)).getFacTotTtc();
               this.totalReglement += ((FactureEnteteVentes)this.lesEcheances.get(var2)).getFacTotReglement();
            }
         }
      }

      this.dataModelEcheance.setWrappedData(this.lesEcheances);
   }

   public void chargerTacheMission(Session var1) throws HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (this.contratEnteteVentes.getCrtId() > 0L) {
         var2 = this.tachesDao.selectMissionTaches(this.contratEnteteVentes.getCrtNature(), var1);
      }

      this.dataModelTache.setWrappedData(var2);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null && this.contratEnteteVentes.getCrtSerie() != null && !this.contratEnteteVentes.getCrtSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.contratEnteteVentes.getCrtSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.contratEnteteVentes.getCrtId(), this.nature, var1);
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
      if (this.decoupageActivite && this.contratEnteteVentes.getCrtActivite() != null && !this.contratEnteteVentes.getCrtActivite().isEmpty() && this.contratEnteteVentes.getCrtActivite().contains(":")) {
         String[] var1 = null;
         if (!this.contratEnteteVentes.getCrtActivite().contains("#")) {
            var1 = this.contratEnteteVentes.getCrtActivite().split(":");
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
            String[] var2 = this.contratEnteteVentes.getCrtActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.contratEnteteVentes.getCrtTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.contratEnteteVentes.getCrtTotHt() - this.totalImputation;
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
      this.contratEnteteVentes = new ContratEnteteVentes();
      this.contratLigneVentes = new ContratLigneVentes();
      this.contratEnteteVentes.setUsers(this.usersLog);
      this.contratEnteteVentes.setCrtIdCreateur(this.usersLog.getUsrid());
      this.contratEnteteVentes.setCrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.contratEnteteVentes.setCrtDate(new Date());
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
      this.contratEnteteVentes.setCrtBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.mesModelesItems.clear();
      this.mesModelesItems.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.contratEnteteVentes.setCrtIdCommercial(this.usersLog.getUsrid());
         this.contratEnteteVentes.setCrtNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.contratEnteteVentes.setCrtIdResponsable(this.usersLog.getUsrid());
         this.contratEnteteVentes.setCrtNomResponsable(this.usersLog.getUsrPatronyme());
      }

      if (this.typeVente == 810) {
         this.contratEnteteVentes.setCrtType(25);
      } else {
         this.contratEnteteVentes.setCrtType(0);
      }

      this.var_code_modele = "";
      this.var_action = 1;
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
      this.afficheTexteContrat = true;
      this.var_total_marge = 0.0D;
      this.numLigne = 0;
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

   public void calculDateValidite() {
      boolean var1 = false;
      if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
         int var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
      } else {
         var1 = false;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
      } else {
         var4 = 0;
      }

      this.contratEnteteVentes.setCrtDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
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
            this.mesUsersItem.add(new SelectItem(this.contratEnteteVentes.getCrtIdResponsable(), this.contratEnteteVentes.getCrtNomResponsable()));
         }

         if (this.typeVente == 810) {
            this.contratEnteteVentes.setCrtType(25);
            LectureModeleFacture var1 = new LectureModeleFacture(this.structureLog.getStrid(), this.tiers.getTieregion());
            var1.recupereModele(this.structureLog.getStrid(), this.tiers.getTieregion());
            new ArrayList();
            List var2 = var1.getLesModeles();
            if (var2.size() != 0) {
               new ObjetModeleFacture();
               int var4 = 0;

               while(true) {
                  if (var4 >= var2.size()) {
                     this.datamodelLigne.setWrappedData(this.lesLignesList);
                     break;
                  }

                  ObjetModeleFacture var3 = (ObjetModeleFacture)var2.get(var4);
                  boolean var5 = false;
                  if (this.lesLignesList.size() != 0) {
                     for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                        if (((ContratLigneVentes)this.lesLignesList.get(var6)).getCrtligCode() != null && !((ContratLigneVentes)this.lesLignesList.get(var6)).getCrtligCode().isEmpty() && var3.getCode() != null && !var3.getCode().isEmpty() && ((ContratLigneVentes)this.lesLignesList.get(var6)).getCrtligCode().equals(var3.getCode())) {
                           var5 = true;
                           break;
                        }
                     }
                  }

                  if (!var5) {
                     this.contratLigneVentes = new ContratLigneVentes();
                     this.contratLigneVentes.setCrtligCode(var3.getCode());
                     this.contratLigneVentes.setCrtligLibelle(var3.getLibelle());
                     this.contratLigneVentes.setCrtligTaxe(var3.getTva());
                     this.contratLigneVentes.setCrtligQte(var3.getQte());
                     this.contratLigneVentes.setCrtligPu(var3.getPu());
                     this.lesLignesList.add(this.contratLigneVentes);
                  }

                  ++var4;
               }
            }
         }

         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.contratEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.contratEnteteVentes.getCrtIdResponsable(), this.contratEnteteVentes.getCrtNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.contratEnteteVentes.getCrtEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.contratEnteteVentes.setCrtEtat(1);
               this.contratEnteteVentes.setCrtDateValide(new Date());
               this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle contrat (C.) N° " + this.contratEnteteVentes.getCrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.contratEnteteVentes.getCrtDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.contratEnteteVentes.getCrtEtat() == 1) {
               this.contratEnteteVentes.setCrtEtat(0);
               this.contratEnteteVentes.setCrtDateValide((Date)null);
               this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle contrat (C.) N° " + this.contratEnteteVentes.getCrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.contratEnteteVentes.getCrtDate()));
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
      if (this.contratEnteteVentes != null) {
         this.contratEnteteVentes.setCrtEtat(0);
         this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.contratEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.contratEnteteVentes.getCrtId();
            String var5 = this.contratEnteteVentes.getCrtNum();
            Date var6 = this.contratEnteteVentes.getCrtDate();
            this.contratLigneVentesDao.deleteAllLigne(this.contratEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.contratEnteteVentes.getCrtId(), this.nature, var1);
            this.contratEnteteVentesDao.delete(this.contratEnteteVentes.getCrtId(), var1);
            Espion var7 = new Espion();
            var7.setUsers(this.usersLog);
            var7.setEsptype(0);
            var7.setEspdtecreat(new Date());
            var7.setEspaction("Suppression Contrat vente N° " + var5 + " du " + var6);
            this.espionDao.mAJEspion(var7, var1);
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

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.contratEnteteVentes.getCrtId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            ArrayList var3 = new ArrayList();
            this.contratEnteteVentes.setUsers(this.usersLog);
            this.contratEnteteVentes.setCrtIdCreateur(this.usersLog.getUsrid());
            this.contratEnteteVentes.setCrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.contratEnteteVentes.setCrtDate(new Date());
            this.contratEnteteVentes.setCrtDateCreat(new Date());
            this.contratEnteteVentes.setCrtDateModif((Date)null);
            this.contratEnteteVentes.setCrtIdModif(0L);
            this.contratEnteteVentes.setCrtNomModif("");
            this.contratEnteteVentes.setCrtNum("");
            this.contratEnteteVentes.setCrtIdResponsable(this.usersLog.getUsrid());
            this.contratEnteteVentes.setCrtNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            if (!this.contratEnteteVentes.getCrtSerie().equalsIgnoreCase("X") && !this.contratEnteteVentes.getCrtSerie().isEmpty()) {
               this.contratEnteteVentes.setCrtNum(this.calculChrono.numCompose(this.contratEnteteVentes.getCrtDate(), this.nature, this.contratEnteteVentes.getCrtSerie(), var1));
            } else {
               long var4 = this.contratEnteteVentesDao.selectLastNum(var1);
               this.contratEnteteVentes.setCrtNum("" + var4);
            }

            this.verifieExistenceHabilitation(var1);
            this.contratEnteteVentes.setCrtDateImp((Date)null);
            this.contratEnteteVentes.setCrtDateTransfert((Date)null);
            this.contratEnteteVentes.setCrtEtat(0);
            var3.add(this.contratEnteteVentes);
            this.contratEnteteVentes = this.contratEnteteVentesDao.insert((ContratEnteteVentes)var3.get(0), var1);
            if (this.lesLignesList.size() != 0) {
               this.contratLigneVentesDao.duppliquerLigne(this.lesLignesList, this.contratEnteteVentes, var1);
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

         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.contratEnteteVentes.getCrtId(), this.contratEnteteVentes.getCrtNum(), this.contratEnteteVentes.getCrtNomTiers(), this.contratEnteteVentes.getCrtDate(), this.contratEnteteVentes.getCrtDevise(), this.contratEnteteVentes.getCrtTotTtc() + this.contratEnteteVentes.getCrtTotTc(), this.contratEnteteVentes.getCrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.contratEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
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
      if (this.contratEnteteVentes.getCrtTypeReg() != 0 && this.contratEnteteVentes.getCrtTypeReg() != 3) {
         if (this.contratEnteteVentes.getCrtTypeReg() != 1 && this.contratEnteteVentes.getCrtTypeReg() != 2 && this.contratEnteteVentes.getCrtTypeReg() != 10) {
            if (this.contratEnteteVentes.getCrtTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.contratEnteteVentes.getCrtModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.contratEnteteVentes.getCrtModeReg() != null && !this.contratEnteteVentes.getCrtModeReg().isEmpty() && this.contratEnteteVentes.getCrtModeReg().contains(":")) {
         String[] var2 = this.contratEnteteVentes.getCrtModeReg().split(":");
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

            this.contratEnteteVentes.setCrtTypeReg(Integer.parseInt(var3.getEcheances()));
            this.contratEnteteVentes.setCrtModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.contratEnteteVentes.setCrtNbJourReg(0);
            this.contratEnteteVentes.setCrtArrondiReg(0);
            break;
         }
      }

      if (this.contratEnteteVentes.getCrtTypeReg() != 0 && this.contratEnteteVentes.getCrtTypeReg() != 3) {
         if (this.contratEnteteVentes.getCrtTypeReg() != 1 && this.contratEnteteVentes.getCrtTypeReg() != 2 && this.contratEnteteVentes.getCrtTypeReg() != 10) {
            if (this.contratEnteteVentes.getCrtTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.contratEnteteVentes.setCrtTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.contratEnteteVentes.setCrtModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.contratEnteteVentes.setCrtNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.contratEnteteVentes.setCrtArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.contratEnteteVentes.getCrtModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.contratEnteteVentes.getCrtDate(), this.contratEnteteVentes.getCrtTypeReg(), this.contratEnteteVentes.getCrtNbJourReg(), this.contratEnteteVentes.getCrtArrondiReg());
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
         if (this.contratEnteteVentes.getCrtId() != 0L) {
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
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      this.cumulPrix();
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.majAnalytique(var2);
         this.contratEnteteVentes.setCrtDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.contratEnteteVentes.getUsers() == null) {
            this.contratEnteteVentes.setUsers(this.usersLog);
         }

         this.contratEnteteVentes.setTiers(this.tiers);
         if ((this.contratEnteteVentes.getCrtCat() == null || this.contratEnteteVentes.getCrtCat().isEmpty()) && this.contratEnteteVentes.getTiers().getTienomfamille() != null && !this.contratEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.contratEnteteVentes.setCrtCat(this.contratEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.contratEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.contratEnteteVentes.setCrtCivilTiers("");
         } else {
            this.contratEnteteVentes.setCrtCivilTiers(this.contratEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            new Contacts();
            Contacts var4 = this.contactDao.recupererContacts(this.var_nom_contact, var2);
            if (var4 != null) {
               this.contratEnteteVentes.setCrtIdContact(var4.getConid());
               if (var4.getConpatronyme() != null && !var4.getConpatronyme().isEmpty()) {
                  this.contratEnteteVentes.setCrtNomContact(var4.getConpatronyme());
                  this.contratEnteteVentes.setCrtCivilContact(var4.getConcivilite());
               } else if (var4.getConservice() != null && !var4.getConservice().isEmpty()) {
                  this.contratEnteteVentes.setCrtNomContact(var4.getConservice());
                  this.contratEnteteVentes.setCrtCivilContact("SERVICE/SITE:");
               } else {
                  this.contratEnteteVentes.setCrtIdContact(0L);
                  this.contratEnteteVentes.setCrtNomContact("");
                  this.contratEnteteVentes.setCrtCivilContact("");
               }
            } else {
               this.contratEnteteVentes.setCrtIdContact(0L);
               this.contratEnteteVentes.setCrtNomContact("");
               this.contratEnteteVentes.setCrtCivilContact("");
            }

            this.contratEnteteVentes.setCrtTiersRegroupe(this.tiers.getTiesigle());
         }

         this.contratEnteteVentes.setCrtIdResponsable(0L);
         this.contratEnteteVentes.setCrtNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var16 = this.usersDao.selectUserD(this.var_nom_responsable, var2);
         if (var16 != null) {
            this.contratEnteteVentes.setCrtIdResponsable(var16.getUsrid());
            this.contratEnteteVentes.setCrtNomResponsable(var16.getUsrPatronyme());
         }

         this.contratEnteteVentes.setCrtIdCommercial(0L);
         this.contratEnteteVentes.setCrtNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var5 = this.usersDao.selectUserD(this.var_nom_commercial, var2);
            if (var5 != null) {
               this.contratEnteteVentes.setCrtIdCommercial(var5.getUsrid());
               this.contratEnteteVentes.setCrtNomCommercial(var5.getUsrPatronyme());
            }
         }

         this.contratEnteteVentes.setCrtIdEquipe(0L);
         this.contratEnteteVentes.setCrtNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.contratEnteteVentes.getCrtIdResponsable(), var2);
            if (this.equipes != null) {
               this.contratEnteteVentes.setCrtIdEquipe(this.equipes.getEquId());
               this.contratEnteteVentes.setCrtNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var17;
         if (this.var_timbre != 0) {
            var17 = this.var_date.getYear() + 1900;
            double var6 = this.utilNombre.calculTimbre(this.structureLog, this.contratEnteteVentes.getCrtTotTtc() + this.contratEnteteVentes.getCrtTotTc(), var17, this.contratEnteteVentes.getCrtDevise(), this.contratEnteteVentes.getCrtDate());
            this.val_timbre = this.utilNombre.myRoundDevise(var6, this.contratEnteteVentes.getCrtDevise());
            if (this.val_timbre != 0.0D) {
               String var8 = this.utilNombre.beginSimple(this.val_timbre, this.contratEnteteVentes.getCrtDevise());
               this.contratEnteteVentes.setCrtFormule2(this.utilNombre.texteTimbre(this.structureLog, var8, var17, this.contratEnteteVentes.getCrtDevise(), this.contratEnteteVentes.getCrtDate()));
            }
         }

         if (this.contratEnteteVentes.getCrtId() == 0L) {
            this.contratEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.contratEnteteVentes.setCrtDateCreat(new Date());
            this.contratEnteteVentes.setCrtIdCreateur(this.usersLog.getUsrid());
            this.contratEnteteVentes.setCrtNomCreateur(this.usersLog.getUsrPatronyme());
            if (this.contratEnteteVentes.getCrtSerie() != null && !this.contratEnteteVentes.getCrtSerie().equalsIgnoreCase("X") && !this.contratEnteteVentes.getCrtSerie().isEmpty()) {
               this.contratEnteteVentes.setCrtNum(this.calculChrono.numCompose(this.contratEnteteVentes.getCrtDate(), this.nature, this.contratEnteteVentes.getCrtSerie(), var2));
               boolean var20 = false;

               label415:
               while(true) {
                  while(true) {
                     if (var20) {
                        break label415;
                     }

                     new ContratEnteteVentes();
                     ContratEnteteVentes var21 = this.contratEnteteVentesDao.pourParapheur(this.contratEnteteVentes.getCrtNum(), var2);
                     if (var21 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.contratEnteteVentes.setCrtNum(this.calculChrono.numCompose(this.contratEnteteVentes.getCrtDate(), this.nature, this.contratEnteteVentes.getCrtSerie(), var2));
                        var20 = false;
                     } else {
                        var20 = true;
                     }
                  }
               }
            } else {
               long var18 = this.contratEnteteVentesDao.selectLastNum(var2);
               this.contratEnteteVentes.setCrtNum("" + var18);
            }

            this.contratEnteteVentes.setCrtEtat(0);
            this.contratEnteteVentes.setCrtEtatVal(0);
            this.contratEnteteVentes.setCrtDateValide((Date)null);
            if (this.var_sansstock) {
               this.contratEnteteVentes.setCrtStock(1);
            } else {
               this.contratEnteteVentes.setCrtStock(0);
            }

            this.contratEnteteVentes = this.contratEnteteVentesDao.insert(this.contratEnteteVentes, var2);
            this.showModalPanelValidationDocument = false;
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.contratEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            if (this.contratEnteteVentes.getCrtEtat() == 6) {
               if (this.contratEnteteVentes.getCrtEtatVal() == 1) {
                  this.contratEnteteVentes.setCrtEtat(0);
               } else {
                  this.contratEnteteVentes.setCrtEtat(0);
               }
            }

            this.contratEnteteVentes.setCrtDateModif(new Date());
            this.contratEnteteVentes.setCrtIdModif(this.usersLog.getUsrid());
            this.contratEnteteVentes.setCrtNomModif(this.usersLog.getUsrPatronyme());
            this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var2);
            var17 = 0;

            while(true) {
               if (var17 >= this.lesLignesList.size()) {
                  this.var_action = 0;
                  this.var_memo_action = this.var_action;
                  this.visibleOnglet = false;
                  this.showModalPanelValidationDocument = false;
                  break;
               }

               this.contratLigneVentes = (ContratLigneVentes)this.lesLignesList.get(var17);
               this.contratLigneVentes.setCrtligOrdre(var17);
               this.contratLigneVentes.setContratEnteteVentes(this.contratEnteteVentes);
               if (this.typeVente == 810) {
                  if (this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.contratLigneVentes.getCrtligCode(), var2);
                     if (this.produits != null) {
                        this.contratLigneVentes.setCrtligFamille(this.produits.getProVteCode());
                        this.contratLigneVentes.setCrtligStock(this.produits.getProStock());
                        this.contratLigneVentes.setCrtligLong(this.produits.getProLongueur());
                        this.contratLigneVentes.setCrtligLarg(this.produits.getProLargeur());
                        this.contratLigneVentes.setCrtligHaut(this.produits.getProEpaisseur());
                        this.contratLigneVentes.setCrtligDiam(this.produits.getProDiamExt());
                        this.contratLigneVentes.setCrtligPoidsBrut(this.produits.getProPoidsBrut());
                        this.contratLigneVentes.setCrtligPoidsNet(this.produits.getProPoidsNet());
                        this.contratLigneVentes.setCrtligVolume(this.produits.getProVolume());
                        this.contratLigneVentes.setCrtligNb(this.produits.getProNbUnite());
                        this.contratLigneVentes.setCrtligReference((String)null);
                        this.contratLigneVentes.setCrtligModeGroupe(this.produits.getProMode());
                     } else {
                        this.contratLigneVentes.setCrtligFamille((String)null);
                     }
                  } else {
                     this.contratLigneVentes.setCrtligFamille((String)null);
                  }

                  if (this.contratEnteteVentes.getCrtExoTva() == 0 && this.contratLigneVentes.getCrtligTaxe() != null && !this.contratLigneVentes.getCrtligTaxe().isEmpty()) {
                     new TaxesVentes();
                     TaxesVentes var19 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.contratLigneVentes.getCrtligTaxe(), var2);
                     if (var19 != null) {
                        this.contratLigneVentes.setCrtligTaxe(var19.getTaxvteCode());
                        this.contratLigneVentes.setCrtligTauxTaxe(var19.getTaxvteTaux());
                     } else {
                        this.contratLigneVentes.setCrtligTaxe("");
                        this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                     }
                  } else {
                     this.contratLigneVentes.setCrtligTaxe("");
                     this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                  }
               }

               if (this.contratLigneVentes.getCrtligId() == 0L) {
                  this.contratLigneVentes = this.contratLigneVentesDao.insertLigne(this.contratLigneVentes, var2);
               } else {
                  this.contratLigneVentes = this.contratLigneVentesDao.modifLigne(this.contratLigneVentes, var2);
               }

               ++var17;
            }
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.contratEnteteVentes.getCrtId(), this.contratEnteteVentes.getCrtNum(), this.contratEnteteVentes.getCrtNomTiers(), this.contratEnteteVentes.getCrtDate(), this.contratEnteteVentes.getCrtDevise(), this.contratEnteteVentes.getCrtTotTtc() + this.contratEnteteVentes.getCrtTotTc(), this.contratEnteteVentes.getCrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var2), this.contratEnteteVentes.getVar_format_devise(), 0, var2);
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var14) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.contratEnteteVentes.setCrtSite(this.usersLog.getUsrSite());
      this.contratEnteteVentes.setCrtDepartement(this.usersLog.getUsrDepartement());
      this.contratEnteteVentes.setCrtService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.contratEnteteVentes.setCrtIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.contratEnteteVentes.getCrtNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.contratEnteteVentes.setCrtTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.contratEnteteVentes.setCrtRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.contratEnteteVentes.setCrtSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.contratEnteteVentes.setCrtPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.contratEnteteVentes.setCrtTiersRegroupe(this.tiers.getTiesigle());
            this.contratEnteteVentes.setCrtRegion(this.tiers.getTieregion());
            this.contratEnteteVentes.setCrtSecteur(this.tiers.getTiesecteur());
            this.contratEnteteVentes.setCrtPdv(this.tiers.getTiepdv());
         }
      } else {
         this.contratEnteteVentes.setCrtTiersRegroupe(this.tiers.getTiesigle());
         this.contratEnteteVentes.setCrtRegion(this.tiers.getTieregion());
         this.contratEnteteVentes.setCrtSecteur(this.tiers.getTiesecteur());
         this.contratEnteteVentes.setCrtPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.contratEnteteVentes.setCrtActivite("");
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

               this.contratEnteteVentes.setCrtActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new ContratLigneVentes();
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

                  ContratLigneVentes var13 = (ContratLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getCrtligCode() != null && !var13.getCrtligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getCrtligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getCrtligPt());
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
                              var7.setPrix(var13.getCrtligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getCrtligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.contratEnteteVentes.setCrtActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.contratEnteteVentes.setCrtAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.contratEnteteVentes.getCrtAnal4() != null && this.contratEnteteVentes.getCrtAnal4().length() <= 2) {
         this.contratEnteteVentes.setCrtAnal4("");
      }

      if (!this.var_anal_parc) {
         this.contratEnteteVentes.setCrtAnal2("");
      } else if (this.contratEnteteVentes.getCrtAnal2() != null && this.contratEnteteVentes.getCrtAnal2().length() <= 2) {
         this.contratEnteteVentes.setCrtAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.contratEnteteVentes.setCrtEtatVal(1);
         this.contratEnteteVentes.setCrtEtat(0);
         this.contratEnteteVentes.setCrtDateValide((Date)null);
         return true;
      } else {
         this.contratEnteteVentes.setCrtEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.contratEnteteVentes.setCrtEtat(1);
               this.contratEnteteVentes.setCrtDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.contratEnteteVentes.setCrtEtat(0);
               this.contratEnteteVentes.setCrtDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void facturationAutomatique() throws ParseException {
      this.chargerPeriodes();
      this.chargerModeleFactures();
      this.showModalPanelAuto = true;
   }

   public void fermerFacturation() {
      this.showModalPanelAuto = false;
   }

   public void validerFacturation() throws HibernateException, NamingException, ParseException {
      if (this.periode != null && !this.periode.isEmpty()) {
         new ArrayList();
         Date var2 = null;
         Date var3 = null;
         String var4 = "";
         List var1 = this.contratEnteteVentesDao.rechercheContratActif((Session)null);
         if (var1.size() != 0) {
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
            Transaction var6 = null;

            try {
               var6 = var5.beginTransaction();

               for(int var7 = 0; var7 < var1.size(); ++var7) {
                  this.contratEnteteVentes = (ContratEnteteVentes)var1.get(var7);
                  if (this.contratEnteteVentes != null) {
                     Date var8 = this.contratEnteteVentes.getCrtDateDebut();
                     Date var9 = this.contratEnteteVentes.getCrtDateFin();
                     if (this.inpDu.compareTo(var8) >= 0 && (var9 == null || var9 != null && this.inpAu.compareTo(var9) <= 0)) {
                        if (this.contratEnteteVentes.getCrtJour() == 0) {
                           this.contratEnteteVentes.setCrtJour(1);
                        }

                        long var10 = 0L;
                        long var12 = 0L;
                        boolean var14 = false;
                        if (this.contratEnteteVentes.getCrtPeriodicite() != 0 && this.contratEnteteVentes.getCrtPeriodicite() != 1) {
                           int var15;
                           String var16;
                           if (this.contratEnteteVentes.getCrtPeriodicite() == 2) {
                              var15 = this.inpDu.getMonth() + 1;
                              var16 = "";
                              if (var15 <= 9) {
                                 var16 = "0" + var15;
                              } else {
                                 var16 = "" + var15;
                              }

                              var2 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var16 + "-" + "01");
                              var3 = this.utilDate.dateDernierJourMois(var2);
                              var4 = "Facturation du mois " + var16 + "/" + (this.inpDu.getYear() + 1900);
                              var14 = true;
                           } else {
                              int var17;
                              int var19;
                              String var20;
                              byte var28;
                              int var29;
                              if (this.contratEnteteVentes.getCrtPeriodicite() == 3) {
                                 var15 = this.inpDu.getMonth() + 1;
                                 var29 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1;
                                 var17 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1 + 3;
                                 int var18 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1 + 6;
                                 var19 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1 + 9;
                                 if (var15 == 1 && var29 == 1) {
                                    var28 = 1;
                                 } else if (var15 == 4 && var17 == 4) {
                                    var28 = 4;
                                 } else if (var15 == 7 && var18 == 7) {
                                    var28 = 7;
                                 } else if (var15 == 10 && var19 == 10) {
                                    var28 = 10;
                                 } else {
                                    var28 = 0;
                                 }

                                 if (var28 != 0) {
                                    var20 = "";
                                    if (var28 <= 9) {
                                       var20 = "0" + var28;
                                    } else {
                                       var20 = "" + var28;
                                    }

                                    var2 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var20 + "-" + "01");
                                    int var21 = this.inpDu.getMonth() + 1;
                                    if (var21 >= 1 && var21 <= 3) {
                                       var21 = 3;
                                    } else if (var21 >= 4 && var21 <= 6) {
                                       var21 = 6;
                                    } else if (var21 >= 7 && var21 <= 9) {
                                       var21 = 9;
                                    } else if (var21 >= 10 && var21 <= 12) {
                                       var21 = 12;
                                    }

                                    String var22 = "";
                                    if (var21 <= 9) {
                                       var22 = "0" + var21;
                                    } else {
                                       var22 = "" + var21;
                                    }

                                    var3 = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(this.inpAu.getYear() + 1900 + "-" + var22 + "-" + "01"));
                                    if (var28 == this.inpDu.getMonth() + 1) {
                                       if (this.inpDu.getMonth() + 1 >= 1 && this.inpDu.getMonth() + 1 <= 3) {
                                          var4 = "Facture du 1er trimestre " + (this.inpDu.getYear() + 1900);
                                       } else if (this.inpDu.getMonth() + 1 >= 4 && this.inpDu.getMonth() + 1 <= 6) {
                                          var4 = "Facture du 2eme trimestre " + (this.inpDu.getYear() + 1900);
                                       } else if (this.inpDu.getMonth() + 1 >= 7 && this.inpDu.getMonth() + 1 <= 9) {
                                          var4 = "Facture du 3eme trimestre " + (this.inpDu.getYear() + 1900);
                                       } else if (this.inpDu.getMonth() + 1 >= 10 && this.inpDu.getMonth() + 1 <= 12) {
                                          var4 = "Facture du 4eme trimestre " + (this.inpDu.getYear() + 1900);
                                       }

                                       var14 = true;
                                    }
                                 }
                              } else if (this.contratEnteteVentes.getCrtPeriodicite() == 4) {
                                 var15 = this.inpDu.getMonth() + 1;
                                 var29 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1;
                                 var17 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1 + 6;
                                 if (var15 == 1 && var29 == 1) {
                                    var28 = 1;
                                 } else if (var15 == 7 && var17 == 7) {
                                    var28 = 7;
                                 } else {
                                    var28 = 0;
                                 }

                                 if (var28 != 0) {
                                    String var30 = "";
                                    if (var28 <= 9) {
                                       var30 = "0" + var28;
                                    } else {
                                       var30 = "" + var28;
                                    }

                                    var2 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var30 + "-" + "01");
                                    var19 = this.contratEnteteVentes.getCrtDateDebut().getMonth() + 1;
                                    if (var19 >= 1 && var19 <= 6) {
                                       var19 = 6;
                                    } else if (var19 >= 7 && var19 <= 12) {
                                       var19 = 12;
                                    }

                                    var20 = "";
                                    if (var19 <= 9) {
                                       var20 = "0" + var19;
                                    } else {
                                       var20 = "" + var19;
                                    }

                                    var3 = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(this.inpAu.getYear() + 1900 + "-" + var20 + "-" + "01"));
                                    if (var28 == this.inpDu.getMonth() + 1) {
                                       if (this.inpDu.getMonth() + 1 >= 1 && this.inpDu.getMonth() + 1 <= 6) {
                                          var4 = "Facture du 1er semestre " + (this.inpDu.getYear() + 1900);
                                       } else if (this.inpDu.getMonth() + 1 >= 7 && this.inpDu.getMonth() + 1 <= 12) {
                                          var4 = "Facture du 2eme semestre " + (this.inpDu.getYear() + 1900);
                                       }

                                       var14 = true;
                                    }
                                 }
                              } else if (this.contratEnteteVentes.getCrtPeriodicite() == 5) {
                                 var28 = 1;
                                 var16 = "0" + var28;
                                 var2 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var16 + "-" + "01");
                                 var3 = this.utilDate.dateDernierJourAnnee(var2);
                                 if (var28 == this.inpDu.getMonth() + 1) {
                                    var4 = "Facturation de l'année " + (this.inpDu.getYear() + 1900);
                                    var14 = true;
                                 }
                              }
                           }
                        }

                        if (var14 && var2.compareTo(this.contratEnteteVentes.getCrtDateDebut()) >= 0 && (this.contratEnteteVentes.getCrtDateFin() == null || this.contratEnteteVentes.getCrtDateFin() != null && var3.compareTo(this.contratEnteteVentes.getCrtDateFin()) <= 0)) {
                           this.validerFacturationSuite(0, var10, var12, var2, var3, var4, (Date)null, (Date)null, (String)null, var5);
                        }
                     }
                  }
               }

               var6.commit();
            } catch (HibernateException var26) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var26;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showModalPanelAuto = false;
   }

   public void validerFacturationSuite(int var1, long var2, long var4, Date var6, Date var7, String var8, Date var9, Date var10, String var11, Session var12) throws HibernateException, NamingException, ParseException {
      if (this.contratEnteteVentes.getCrtDateDebut() != null && this.contratEnteteVentes.getCrtDateFin() != null) {
         var9 = this.utilDate.datePremierJourMois(this.contratEnteteVentes.getCrtDateDebut());
         var10 = this.utilDate.dateDernierJourMois(this.contratEnteteVentes.getCrtDateFin());
      } else if (this.contratEnteteVentes.getCrtDateDebut() != null) {
         var9 = this.utilDate.datePremierJourMois(this.inpAu);
         var10 = this.utilDate.dateDernierJourMois(this.inpDu);
      } else {
         var9 = this.utilDate.datePremierJourMois(this.inpAu);
         var10 = this.utilDate.dateDernierJourMois(this.inpDu);
      }

      if (var11 != null && !var11.isEmpty()) {
      }

      float var13 = 1.0F;
      var2 = (long)((var7.getYear() + 1900 - (var6.getYear() + 1900)) * 12 + (var7.getMonth() + 1 + 1 - (var6.getMonth() + 1)) * 30 + 1);
      var4 = var2;
      if (this.contratEnteteVentes.getCrtDateFin() != null) {
         if (var9.before(this.contratEnteteVentes.getCrtDateDebut())) {
            if (var9.getDate() != 1) {
               var4 = var2 - (long)(var6.getDate() - 1);
            }

            if (this.contratEnteteVentes.getCrtDateFin().compareTo(var7) != 0) {
               var4 -= (long)(30 - this.contratEnteteVentes.getCrtDateFin().getDate());
            }
         } else {
            if (var9.getDate() != 1) {
               var4 = var2 - (long)(var6.getDate() - 1);
            }

            if (this.contratEnteteVentes.getCrtDateFin().compareTo(var7) != 0) {
               var4 -= (long)(30 - this.contratEnteteVentes.getCrtDateFin().getDate());
            }
         }
      } else if (var9.before(this.contratEnteteVentes.getCrtDateDebut())) {
         if (this.contratEnteteVentes.getCrtDateDebut().getDate() != 1) {
            var4 = var2 - (long)(this.contratEnteteVentes.getCrtDateDebut().getDate() - 1);
         }

         if (var10.compareTo(var7) != 0) {
            var4 -= (long)(30 - var7.getDate());
         }
      } else {
         if (var6.getDate() != 1) {
            var4 = var2 - (long)(var6.getDate() - 1);
         }

         if (var10.compareTo(var7) != 0) {
            var4 -= (long)(30 - var7.getDate());
         }
      }

      var13 = (float)var4 / (float)var2;
      boolean var14 = false;
      String var15 = "";
      String var16 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
      String var17 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:23:59";
      int var20;
      if (var1 == 0) {
         this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheurAutomatique(this.contratEnteteVentes.getTiers().getTieid(), this.contratEnteteVentes.getCrtNum(), var16, var17, var12);
         if (this.factureEnteteVentes != null) {
            if (this.factureEnteteVentes.getFacEtat() == 0) {
               var15 = this.factureEnteteVentes.getFacNum();
               new ArrayList();
               List var18 = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var12);
               if (var18.size() != 0) {
                  new FactureLigneVentes();

                  for(var20 = 0; var20 < var18.size(); ++var20) {
                     FactureLigneVentes var19 = (FactureLigneVentes)var18.get(var20);
                     this.factureLigneVentesDao.deleteAllLigne(this.factureEnteteVentes, var12);
                  }
               }

               this.factureEnteteVentesDao.delete(this.factureEnteteVentes, var12);
               var14 = true;
            } else {
               var14 = false;
            }
         } else {
            var14 = true;
         }
      } else {
         var15 = this.factureEnteteVentes.getFacNum();
         var14 = true;
      }

      if (var14) {
         if (var1 == 0) {
            this.factureEnteteVentes = new FactureEnteteVentes();
         }

         String var37 = "";
         if (var15 != null && !var15.isEmpty()) {
            var37 = var15;
         } else {
            var37 = this.calculChrono.numCompose(var9, 25, this.contratEnteteVentes.getCrtSerie(), var12);
         }

         this.factureEnteteVentes = new FactureEnteteVentes();
         this.factureEnteteVentes.setExerciceventes(this.exercicesVentes);
         this.factureEnteteVentes.setTiers(this.contratEnteteVentes.getTiers());
         this.factureEnteteVentes.setUsers(this.usersLog);
         this.factureEnteteVentes.setFacActivite(this.contratEnteteVentes.getCrtActivite());
         this.factureEnteteVentes.setFacAnal2(this.contratEnteteVentes.getCrtAnal2());
         this.factureEnteteVentes.setFacAnal4(this.contratEnteteVentes.getCrtAnal4());
         this.factureEnteteVentes.setFacAnnexe1((String)null);
         this.factureEnteteVentes.setFacAnnexe2((String)null);
         this.factureEnteteVentes.setFacArrondiReg(this.contratEnteteVentes.getCrtArrondiReg());
         this.factureEnteteVentes.setFacBanque(this.contratEnteteVentes.getCrtBanque());
         this.factureEnteteVentes.setFacBudget(this.contratEnteteVentes.getCrtBudget());
         this.factureEnteteVentes.setFacCat(this.contratEnteteVentes.getCrtCat());
         this.factureEnteteVentes.setFacCivilContact(this.contratEnteteVentes.getCrtCivilContact());
         this.factureEnteteVentes.setFacCivilTiers(this.contratEnteteVentes.getCrtCivilTiers());
         this.factureEnteteVentes.setFacTiersRegroupe(this.contratEnteteVentes.getCrtTiersRegroupe());
         this.factureEnteteVentes.setFacConditionReg(this.contratEnteteVentes.getCrtConditionReg());
         this.factureEnteteVentes.setFacContrat(this.contratEnteteVentes.getCrtNum());
         if (this.contratEnteteVentes.getCrtJour() != 0) {
            this.factureEnteteVentes.setFacDate(this.utilDate.dateEcheanceArrondi(this.inpDu, this.contratEnteteVentes.getCrtJour()));
         } else {
            this.factureEnteteVentes.setFacDate(this.inpDu);
         }

         this.factureEnteteVentes.setFacDateAnnule((Date)null);
         this.factureEnteteVentes.setFacDateCreat(new Date());
         this.factureEnteteVentes.setFacDateEcheReg((Date)null);
         this.factureEnteteVentes.setFacDateImp((Date)null);
         this.factureEnteteVentes.setFacDateLastReg((Date)null);
         this.factureEnteteVentes.setFacDateLivraison((Date)null);
         this.factureEnteteVentes.setFacDateModif((Date)null);
         this.factureEnteteVentes.setFacDateRelance((Date)null);
         this.factureEnteteVentes.setFacDateTransfert((Date)null);
         boolean var38 = false;
         int var39;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var39 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var39 = 0;
         }

         boolean var40 = false;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var20 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var20 = 0;
         }

         this.factureEnteteVentes.setFacDateRelance(this.utilDate.datedevaleurTheo(this.inpDu, var39));
         this.factureEnteteVentes.setFacDateValidite(this.utilDate.datedevaleurTheo(this.inpDu, var20));
         this.factureEnteteVentes.setFacDateValide((Date)null);
         this.factureEnteteVentes.setFacDateVisa((Date)null);
         this.factureEnteteVentes.setFacDepartement(this.contratEnteteVentes.getCrtDepartement());
         this.factureEnteteVentes.setFacDevise(this.contratEnteteVentes.getCrtDevise());
         this.factureEnteteVentes.setFacDiversAdresse((String)null);
         this.factureEnteteVentes.setFacEcheanceReliquat((Date)null);
         this.factureEnteteVentes.setFacEtat(0);
         this.factureEnteteVentes.setFacEtatVal(0);
         this.factureEnteteVentes.setFacExoDouane(this.contratEnteteVentes.getCrtExoDouane());
         this.factureEnteteVentes.setFacExoTva(this.contratEnteteVentes.getCrtExoTva());
         this.factureEnteteVentes.setFacFactorEtat(0);
         this.factureEnteteVentes.setFacFactorId(0L);
         this.factureEnteteVentes.setFacFactorNom((String)null);
         this.factureEnteteVentes.setFacFormule1(this.contratEnteteVentes.getCrtFormule1());
         this.factureEnteteVentes.setFacFormule2(this.contratEnteteVentes.getCrtFormule2());
         this.factureEnteteVentes.setFacGarde((String)null);
         this.factureEnteteVentes.setFacGele(this.contratEnteteVentes.getCrtGele());
         this.factureEnteteVentes.setFacIdCommercial(this.contratEnteteVentes.getCrtIdCommercial());
         this.factureEnteteVentes.setFacIdContact(this.contratEnteteVentes.getCrtIdContact());
         this.factureEnteteVentes.setFacIdCreateur(this.usersLog.getUsrid());
         this.factureEnteteVentes.setFacIdEquipe(this.contratEnteteVentes.getCrtIdEquipe());
         this.factureEnteteVentes.setFacIdModif(0L);
         this.factureEnteteVentes.setFacIdResponsable(this.contratEnteteVentes.getCrtIdResponsable());
         this.factureEnteteVentes.setFacIncoterm((String)null);
         this.factureEnteteVentes.setFacInfo1(this.contratEnteteVentes.getCrtInfo1());
         this.factureEnteteVentes.setFacInfo2(this.contratEnteteVentes.getCrtInfo2());
         this.factureEnteteVentes.setFacInfo3(this.contratEnteteVentes.getCrtInfo3());
         this.factureEnteteVentes.setFacInfo4(this.contratEnteteVentes.getCrtInfo4());
         this.factureEnteteVentes.setFacInfo5(this.contratEnteteVentes.getCrtInfo5());
         this.factureEnteteVentes.setFacInfo6(this.contratEnteteVentes.getCrtInfo6());
         this.factureEnteteVentes.setFacInfo7(this.contratEnteteVentes.getCrtInfo7());
         this.factureEnteteVentes.setFacInfo8(this.contratEnteteVentes.getCrtInfo8());
         this.factureEnteteVentes.setFacInfo9(this.contratEnteteVentes.getCrtInfo9());
         this.factureEnteteVentes.setFacInfo10(this.contratEnteteVentes.getCrtInfo10());
         this.factureEnteteVentes.setFacInfoLivraison((String)null);
         this.factureEnteteVentes.setFacJournalReg(this.contratEnteteVentes.getCrtJournalReg());
         this.factureEnteteVentes.setFacLieuLivraison((String)null);
         this.factureEnteteVentes.setFacModeReg(this.contratEnteteVentes.getCrtModeReg());
         this.factureEnteteVentes.setFacModeleImp(this.modeleFacture);
         this.factureEnteteVentes.setFacMotifAnnule((String)null);
         this.factureEnteteVentes.setFacMotifExo(this.contratEnteteVentes.getCrtMotifExo());
         this.factureEnteteVentes.setFacMotifRejetCredit((String)null);
         this.factureEnteteVentes.setFacNbJourReg(this.contratEnteteVentes.getCrtNbJourReg());
         this.factureEnteteVentes.setFacNomCommercial(this.contratEnteteVentes.getCrtNomCommercial());
         this.factureEnteteVentes.setFacNomContact(this.contratEnteteVentes.getCrtNomContact());
         this.factureEnteteVentes.setFacNomCreateur(this.usersLog.getUsrPatronyme());
         this.factureEnteteVentes.setFacNomEquipe(this.contratEnteteVentes.getCrtNomEquipe());
         this.factureEnteteVentes.setFacNomModif((String)null);
         this.factureEnteteVentes.setFacNomResponsable(this.contratEnteteVentes.getCrtNomResponsable());
         this.factureEnteteVentes.setFacNomTiers(this.contratEnteteVentes.getCrtNomTiers());
         this.factureEnteteVentes.setFacNum(var37);
         this.factureEnteteVentes.setFacNumAvoir((String)null);
         this.factureEnteteVentes.setFacNumBl((String)null);
         this.factureEnteteVentes.setFacNumTrf((String)null);
         this.factureEnteteVentes.setFacNumVisa((String)null);
         this.factureEnteteVentes.setFacObject(var8);
         this.factureEnteteVentes.setFacObservation(this.contratEnteteVentes.getCrtObservation());
         this.factureEnteteVentes.setFacPdv(this.contratEnteteVentes.getCrtPdv());
         this.factureEnteteVentes.setFacRangeVisa(this.contratEnteteVentes.getCrtRangeVisa());
         this.factureEnteteVentes.setFacRegion(this.contratEnteteVentes.getCrtRegion());
         this.factureEnteteVentes.setFacSecteur(this.contratEnteteVentes.getCrtSecteur());
         this.factureEnteteVentes.setFacSerie(this.contratEnteteVentes.getCrtSerie());
         this.factureEnteteVentes.setFacService(this.contratEnteteVentes.getCrtService());
         this.factureEnteteVentes.setFacSite(this.contratEnteteVentes.getCrtService());
         this.factureEnteteVentes.setFacSolde(0);
         this.factureEnteteVentes.setFacSource(this.contratEnteteVentes.getCrtSource());
         this.factureEnteteVentes.setFacStock(this.contratEnteteVentes.getCrtStock());
         this.factureEnteteVentes.setFacTauxTc(this.contratEnteteVentes.getCrtTauxTc());
         this.factureEnteteVentes.setFacTotHt(this.contratEnteteVentes.getCrtTotHt());
         this.factureEnteteVentes.setFacTotRabais(this.contratEnteteVentes.getCrtTotRabais());
         this.factureEnteteVentes.setFacTotReglement(0.0D);
         this.factureEnteteVentes.setFacTotRemise(this.contratEnteteVentes.getCrtTotRemise());
         this.factureEnteteVentes.setFacTotTc((double)this.contratEnteteVentes.getCrtTauxTc());
         this.factureEnteteVentes.setFacTotTimbre(this.contratEnteteVentes.getCrtTotTimbre());
         this.factureEnteteVentes.setFacTotTtc(this.contratEnteteVentes.getCrtTotTtc());
         this.factureEnteteVentes.setFacTotTva(this.contratEnteteVentes.getCrtTotTva());
         this.factureEnteteVentes.setFacTypeReg(this.contratEnteteVentes.getCrtTypeReg());
         this.factureEnteteVentes.setFacTypeTransforme(0);
         this.factureEnteteVentes = this.factureEnteteVentesDao.insert(this.factureEnteteVentes, var12);
         if (this.contratEnteteVentes.getCrtType() == 101) {
            double var21 = 0.0D;
            double var23 = 0.0D;
            double var25 = 0.0D;
            double var27 = 0.0D;
            float var29 = 0.0F;
            String var30 = "";
            if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var31 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var12);
               if (var31 != null) {
                  var29 = var31.getTaxvteTaux();
                  var30 = var31.getTaxvteCode();
               }
            }

            new ArrayList();
            ArrayList var32 = new ArrayList();
            List var43 = this.salariesPointageDao.chargerlesPointages(this.contratEnteteVentes.getCrtNum(), this.inpDu, this.inpAu, var12);
            int var33;
            if (var43.size() != 0) {
               for(var33 = 0; var33 < var43.size(); ++var33) {
                  this.salariesPointage = (SalariesPointage)var43.get(var33);
                  if (var32.size() == 0) {
                     var32.add(this.salariesPointage);
                  } else {
                     boolean var34 = false;
                     float var35 = 0.0F;

                     for(int var36 = 0; var36 < var32.size(); ++var36) {
                        if (this.salariesPointage.getSalpoiTache() != null && !this.salariesPointage.getSalpoiTache().isEmpty() && ((SalariesPointage)var32.get(var36)).getSalpoiTache() != null && ((SalariesPointage)var32.get(var36)).getSalpoiTache().isEmpty() && ((SalariesPointage)var32.get(var36)).getSalpoiTache().equals(this.salariesPointage.getSalpoiTache())) {
                           var35 = ((SalariesPointage)var32.get(var36)).getSalpoiDuree();
                           var34 = true;
                           break;
                        }
                     }

                     if (var34) {
                        this.salariesPointage.setSalpoiDuree(this.salariesPointage.getSalpoiDuree() + var35);
                        var32.add(this.salariesPointage);
                     } else {
                        var32.add(this.salariesPointage);
                     }
                  }
               }
            }

            if (var32.size() != 0) {
               for(var33 = 0; var33 < var32.size(); ++var33) {
                  this.salariesPointage = (SalariesPointage)var32.get(var33);
                  if (this.salariesPointage.getSalpoiTache() != null && !this.salariesPointage.getSalpoiTache().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.salariesPointage.getSalpoiTache(), var12);
                     if (this.produits == null) {
                        this.produits = new Produits();
                     }

                     this.taches = this.tachesDao.rechercheTache(this.salariesPointage.getSalpoiTache(), var12);
                     if (this.taches == null) {
                        this.taches = new Taches();
                        this.salariesTaches = new SalariesTaches();
                     } else {
                        this.salariesTaches = this.salariesTachesDao.selectUsersTaches(this.salariesPointage.getSalpoiTache(), this.salariesPointage.getSalaries(), var12);
                        if (this.salariesTaches == null) {
                           this.salariesTaches = new SalariesTaches();
                        }
                     }
                  } else {
                     this.produits = new Produits();
                     this.taches = new Taches();
                     this.salariesTaches = new SalariesTaches();
                  }

                  FactureLigneVentes var44 = new FactureLigneVentes();
                  var44.setFactureEnteteVentes(this.factureEnteteVentes);
                  var44.setFacligCode(this.salariesPointage.getSalpoiTache());
                  var44.setFacligCommission(0.0D);
                  if (this.optionsVentes.getDescriptifComplementaire().equals("1")) {
                     var44.setFacligComplement(var8);
                  } else {
                     var44.setFacligComplement("");
                  }

                  var44.setFacligCondition("");
                  var44.setFacligDepot("");
                  var44.setFacligDescription("");
                  var44.setFacligDevise(this.structureLog.getStrdevise());
                  var44.setFacligDiam(0.0F);
                  var44.setFacligEchelle(0);
                  var44.setFacligEntStock(0);
                  var44.setFacligFamille(this.produits.getProVteCode());
                  var44.setFacligHaut(0.0F);
                  var44.setFacligIdBcm(0L);
                  var44.setFacligIdBlv(0L);
                  var44.setFacligIdDvs(0L);
                  var44.setFacligLarg(0.0F);
                  var44.setFacligLibelle(this.produits.getProLibClient());
                  var44.setFacligLong(0.0F);
                  var44.setFacligLot("");
                  var44.setFacligNb(0.0F);
                  var44.setFacligNumSerie("");
                  var44.setFacligOrdre(var33);
                  var44.setFacligPoidsBrut(0.0F);
                  var44.setFacligPoidsNet(0.0F);
                  var44.setFacligReference("");
                  var44.setFacligRabais(0.0D);
                  var44.setFacligUnite("");
                  var44.setFacligVolume(0.0F);
                  var44.setFacligQte(this.salariesPointage.getSalpoiDuree());
                  var44.setFacligQteStock(0.0F);
                  var44.setFacligQteUtil(this.salariesPointage.getSalpoiDuree());
                  var44.setFacligStock(0);
                  var44.setFacligTauxRemise(0.0F);
                  if (this.salariesTaches.getSaltacId() != 0L) {
                     var44.setFacligPu((double)this.salariesTaches.getSaltacValPv());
                     var44.setFacligPump((double)this.salariesTaches.getSaltacValPr());
                  } else {
                     var44.setFacligPu((double)this.taches.getTacValPv());
                     var44.setFacligPump((double)this.taches.getTacValPr());
                  }

                  var44.setFacligPuRem(var44.getFacligPu());
                  if (this.contratEnteteVentes.getCrtExoTva() == 1) {
                     var44.setFacligTaxe("");
                     var44.setFacligTauxTaxe(0.0F);
                     var44.setFacligPuTtc(var44.getFacligPu());
                     var44.setFacligPuRemTtc(var44.getFacligPuRem());
                  } else {
                     var44.setFacligTaxe(var30);
                     var44.setFacligTauxTaxe(var29);
                     var44.setFacligPuTtc(var44.getFacligPu() + this.utilNombre.myRoundDevise(var44.getFacligPu() * (double)var29 / 100.0D, this.structureLog.getStrdevise()));
                     var44.setFacligPuRemTtc(var44.getFacligPuRem() + this.utilNombre.myRoundDevise(var44.getFacligPuRem() * (double)var29 / 100.0D, this.structureLog.getStrdevise()));
                  }

                  var44.setFacligPt(var44.getFacligPuRem() * (double)var44.getFacligQte());
                  var44.setFacligTva(this.utilNombre.myRoundDevise(var44.getFacligPt() * (double)var29 / 100.0D, this.structureLog.getStrdevise()));
                  var44.setFacligTtc(var44.getFacligPt() + var44.getFacligTva());
                  var44.setFacligTc(0.0D);
                  var44 = this.factureLigneVentesDao.insertLigne(var44, var12);
                  var21 = var44.getFacligPt();
                  var23 = var44.getFacligTva();
                  var25 += var44.getFacligTtc();
                  var27 += var44.getFacligTc();
               }
            }

            this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(this.factureEnteteVentes.getFacId(), var12);
            if (this.factureEnteteVentes != null) {
               this.factureEnteteVentes.setFacTotHt(var21);
               this.factureEnteteVentes.setFacTotTva(var23);
               this.factureEnteteVentes.setFacTotTtc(var25);
               this.factureEnteteVentes.setFacTotTc(var27);
               this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var12);
            }
         } else {
            new ArrayList();
            List var41 = this.contratLigneVentesDao.chargerLesLignes(this.contratEnteteVentes, var12);
            if (var41.size() != 0) {
               for(int var22 = 0; var22 < var41.size(); ++var22) {
                  this.contratLigneVentes = (ContratLigneVentes)var41.get(var22);
                  FactureLigneVentes var42 = new FactureLigneVentes();
                  var42.setFactureEnteteVentes(this.factureEnteteVentes);
                  var42.setFacligCode(this.contratLigneVentes.getCrtligCode());
                  var42.setFacligCommission(this.contratLigneVentes.getCrtligCommission());
                  if (this.optionsVentes.getDescriptifComplementaire().equals("1")) {
                     var42.setFacligComplement(var8);
                  } else {
                     var42.setFacligComplement(this.contratLigneVentes.getCrtligComplement());
                  }

                  var42.setFacligCondition(this.contratLigneVentes.getCrtligCondition());
                  var42.setFacligDepot(this.contratLigneVentes.getCrtligDepot());
                  var42.setFacligDescription(this.contratLigneVentes.getCrtligDescription());
                  var42.setFacligDevise(this.contratLigneVentes.getCrtligDevise());
                  var42.setFacligDiam(this.contratLigneVentes.getCrtligDiam());
                  var42.setFacligEchelle(this.contratLigneVentes.getCrtligEchelle());
                  var42.setFacligEntStock(this.contratLigneVentes.getCrtligEntStock());
                  var42.setFacligFamille(this.contratLigneVentes.getCrtligFamille());
                  var42.setFacligHaut(this.contratLigneVentes.getCrtligHaut());
                  var42.setFacligIdBcm(0L);
                  var42.setFacligIdBlv(0L);
                  var42.setFacligIdDvs(0L);
                  var42.setFacligLarg(this.contratLigneVentes.getCrtligLarg());
                  var42.setFacligLibelle(this.contratLigneVentes.getCrtligLibelle());
                  var42.setFacligLong(this.contratLigneVentes.getCrtligLong());
                  var42.setFacligLot(this.contratLigneVentes.getCrtligLot());
                  var42.setFacligNb(this.contratLigneVentes.getCrtligNb());
                  var42.setFacligNumSerie(this.contratLigneVentes.getCrtligNumSerie());
                  var42.setFacligOrdre(this.contratLigneVentes.getCrtligOrdre());
                  var42.setFacligPoidsBrut(this.contratLigneVentes.getCrtligPoidsBrut());
                  var42.setFacligPoidsNet(this.contratLigneVentes.getCrtligPoidsNet());
                  var42.setFacligPt(this.contratLigneVentes.getCrtligPt());
                  var42.setFacligPu(this.contratLigneVentes.getCrtligPu());
                  var42.setFacligPuRem(this.contratLigneVentes.getCrtligPuRem());
                  var42.setFacligPuRemTtc(this.contratLigneVentes.getCrtligPuRemTtc());
                  var42.setFacligPuTtc(this.contratLigneVentes.getCrtligPuTtc());
                  var42.setFacligPump(this.contratLigneVentes.getCrtligPump());
                  var42.setFacligQte(this.contratLigneVentes.getCrtligQte());
                  var42.setFacligQteStock(this.contratLigneVentes.getCrtligQteStock());
                  var42.setFacligQteUtil(this.contratLigneVentes.getCrtligQteUtil());
                  var42.setFacligRabais(this.contratLigneVentes.getCrtligRabais());
                  var42.setFacligReference(this.contratLigneVentes.getCrtligReference());
                  var42.setFacligStock(this.contratLigneVentes.getCrtligStock());
                  var42.setFacligTauxRemise(this.contratLigneVentes.getCrtligTauxRemise());
                  var42.setFacligTauxTaxe(this.contratLigneVentes.getCrtligTauxTaxe());
                  var42.setFacligTaxe(this.contratLigneVentes.getCrtligTaxe());
                  var42.setFacligTc(this.contratLigneVentes.getCrtligTc());
                  var42.setFacligTtc(this.contratLigneVentes.getCrtligTtc());
                  var42.setFacligTva(this.contratLigneVentes.getCrtligTva());
                  var42.setFacligUnite(this.contratLigneVentes.getCrtligUnite());
                  var42.setFacligVolume(this.contratLigneVentes.getCrtligVolume());
                  this.factureLigneVentesDao.insertLigne(var42, var12);
               }
            }
         }
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

   public void rechercheTexteModeleContrat() throws HibernateException, NamingException {
      this.contratEnteteVentes.setCrtText("");
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
            this.contratEnteteVentes.setCrtText(var4.getModTexte());
            this.calculeTexte();
         } else {
            this.contratEnteteVentes.setCrtText("Erreur modèle");
         }
      }

   }

   public void calculeTexte() throws HibernateException, NamingException {
      this.calculeZone((Session)null);
      if (this.contratEnteteVentes.getCrtText() != null && !this.contratEnteteVentes.getCrtText().isEmpty()) {
         this.contratEnteteVentes.setCrtText(this.utilTdt.analyseTexteCommercial(this.contratEnteteVentes.getCrtText(), this.usersLog, this.structureLog, this.tiers));
      } else {
         this.afficheTexteContrat = true;
      }

   }

   public void calculeZone(Session var1) throws HibernateException, NamingException {
      if (this.decoupageActivite) {
         String var2 = "";
         boolean var3 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var4 = 0; var4 < this.lesDecoupagesActivites.size(); ++var4) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var4);
               if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                  if (var3) {
                     var2 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     var3 = false;
                  } else {
                     var2 = var2 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                  }
               }
            }
         }

         this.contratEnteteVentes.setCrtActivite(var2);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.contratEnteteVentes.getCrtExoTva() == 0) {
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

      this.contratLigneVentes.setCrtligTaxe(var6);
      this.contratLigneVentes.setCrtligTauxTaxe(var5);
      double var35 = this.contratLigneVentes.getCrtligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.contratEnteteVentes.getCrtDevise());
      }

      var10 = this.contratLigneVentes.getCrtligQte();
      if (this.contratLigneVentes.getCrtligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.contratLigneVentes.setCrtligQteUtil(this.contratLigneVentes.getCrtligQte());
            var10 = this.contratLigneVentes.getCrtligQte() * this.contratLigneVentes.getCrtligLong();
         } else {
            this.contratLigneVentes.setCrtligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.contratLigneVentes.getCrtligCondition(), this.contratLigneVentes.getCrtligQte(), this.contratLigneVentes.getCrtligLong(), this.contratLigneVentes.getCrtligLarg(), this.contratLigneVentes.getCrtligHaut(), this.contratLigneVentes.getCrtligDiam(), this.contratLigneVentes.getCrtligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.contratLigneVentes.setCrtligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.contratLigneVentes.getCrtligCondition() != null && !this.contratLigneVentes.getCrtligCondition().isEmpty() && this.contratLigneVentes.getCrtligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.contratLigneVentes.getCrtligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.contratLigneVentes.getCrtligRabais() * (double)this.contratLigneVentes.getCrtligQte();
      }

      if (this.contratLigneVentes.getCrtligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.contratLigneVentes.getCrtligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      if (this.contratEnteteVentes.getCrtType() == 26) {
         if (this.contratLigneVentes.getCrtligNb() == 0.0F) {
            this.contratLigneVentes.setCrtligNb(1.0F);
         }

         this.totalHt = var17 * (double)this.contratLigneVentes.getCrtligNb();
      } else {
         this.totalHt = var17;
      }

      double var19 = this.totalHt * (double)this.contratLigneVentes.getCrtligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = this.totalHt * (double)(this.contratLigneVentes.getCrtligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = this.totalHt + var21;
      double var25 = 0.0D;
      if (this.contratLigneVentes.getCrtligCondition() != null && !this.contratLigneVentes.getCrtligCondition().isEmpty() && this.contratLigneVentes.getCrtligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(this.totalHt / (double)this.contratLigneVentes.getCrtligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(this.totalHt / (double)this.contratLigneVentes.getCrtligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(this.totalHt / (double)this.contratLigneVentes.getCrtligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(this.totalHt / (double)this.contratLigneVentes.getCrtligQte(), 2);
      }

      this.contratLigneVentes.setCrtligPuRem(var25);
      this.contratLigneVentes.setCrtligPt(this.totalHt);
      this.contratLigneVentes.setCrtligTva(var21);
      this.contratLigneVentes.setCrtligTc(0.0D);
      this.contratLigneVentes.setCrtligTtc(var23);
      double var27 = 0.0D;
      if (this.contratLigneVentes.getCrtligCondition() != null && !this.contratLigneVentes.getCrtligCondition().isEmpty() && this.contratLigneVentes.getCrtligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.contratLigneVentes.getCrtligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.contratLigneVentes.getCrtligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.contratLigneVentes.getCrtligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.contratLigneVentes.getCrtligQte(), 2);
      }

      this.contratLigneVentes.setCrtligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.contratLigneVentes.getCrtligTauxTaxe() / 100.0D;
      this.contratLigneVentes.setCrtligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.contratEnteteVentes.setCrtTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.contratLigneVentes.setCrtligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = this.totalHt * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
               if (this.contratLigneVentes.getCrtligTauxTaxe() != 0.0F) {
                  var31 = this.totalHt * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.contratLigneVentes.getCrtligTauxTaxe() / 100.0D;
                  this.contratLigneVentes.setCrtligTc(var33);
               }
            }
         } else {
            if (this.contratLigneVentes.getCrtligTva() != 0.0D) {
               var31 = this.totalHt * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.contratLigneVentes.setCrtligTc(var33);
         }
      } else {
         this.contratLigneVentes.setCrtligTc(0.0D);
         this.contratEnteteVentes.setCrtTauxTc(0.0F);
      }

      this.contratLigneVentes.setCrtligPt(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligPt(), this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligTva(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligTva(), this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligTtc(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligTtc(), this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligTc(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligTc(), this.contratEnteteVentes.getCrtDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.contratEnteteVentes.getCrtExoTva() == 0) {
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

      this.contratLigneVentes.setCrtligTaxe(var6);
      this.contratLigneVentes.setCrtligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.contratEnteteVentes.getCrtTauxTc() != 0.0F && this.contratLigneVentes.getCrtligTva() != 0.0D) {
         var10 = this.contratLigneVentes.getCrtligTtc();
         var12 = var10 * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.contratLigneVentes.getCrtligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.contratLigneVentes.getCrtligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.contratLigneVentes.setCrtligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.contratLigneVentes.getCrtligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.contratLigneVentes.getCrtligRabais() * (double)this.contratLigneVentes.getCrtligQte();
      }

      double var14 = 0.0D;
      if (this.contratLigneVentes.getCrtligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.contratLigneVentes.getCrtligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.contratLigneVentes.getCrtligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.contratLigneVentes.getCrtligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.contratLigneVentes.getCrtligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.contratLigneVentes.setCrtligQteUtil(this.contratLigneVentes.getCrtligQte());
         } else {
            this.contratLigneVentes.setCrtligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.contratLigneVentes.getCrtligCondition(), this.contratLigneVentes.getCrtligQte(), this.contratLigneVentes.getCrtligLong(), this.contratLigneVentes.getCrtligLarg(), this.contratLigneVentes.getCrtligHaut(), this.contratLigneVentes.getCrtligDiam(), this.contratLigneVentes.getCrtligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.contratLigneVentes.setCrtligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.contratLigneVentes.getCrtligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.contratEnteteVentes.getCrtDevise()));
      double var26 = var20 * (double)this.contratLigneVentes.getCrtligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.contratEnteteVentes.getCrtDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligPuRem(var18);
      this.contratLigneVentes.setCrtligPuRemTtc(var20);
      this.contratLigneVentes.setCrtligPt(var24);
      this.contratLigneVentes.setCrtligTva(var32);
      this.contratLigneVentes.setCrtligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.contratEnteteVentes.setCrtTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.contratLigneVentes.setCrtligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
               if (this.contratLigneVentes.getCrtligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.contratLigneVentes.getCrtligTauxTaxe() / 100.0D;
                  this.contratLigneVentes.setCrtligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.contratEnteteVentes.getCrtTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.contratLigneVentes.setCrtligTc(var36);
         }
      } else {
         this.contratLigneVentes.setCrtligTc(0.0D);
         this.contratEnteteVentes.setCrtTauxTc(0.0F);
      }

      this.contratLigneVentes.setCrtligPt(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligPt(), this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligTva(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligTva(), this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligTtc(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligTtc(), this.contratEnteteVentes.getCrtDevise()));
      this.contratLigneVentes.setCrtligTc(this.utilNombre.myRoundDevise(this.contratLigneVentes.getCrtligTc(), this.contratEnteteVentes.getCrtDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.contratLigneVentes != null && this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.contratLigneVentes.getCrtligTaxe(), this.contratLigneVentes.getCrtligTauxTaxe(), (Session)null);
      this.griserValider = false;
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.contratLigneVentes.getCrtligPuRemTtc() != 0.0D) {
               if (this.contratLigneVentes.getCrtligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.contratLigneVentes.getCrtligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.contratLigneVentes.getCrtligPuRem() != 0.0D) {
            if (this.contratLigneVentes.getCrtligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.contratLigneVentes.getCrtligPu() < this.prixPlancher) {
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
         new ContratLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            ContratLigneVentes var13 = (ContratLigneVentes)this.lesLignesList.get(var14);
            if (var13.getCrtligGroupe() == null || var13.getCrtligGroupe().isEmpty()) {
               var3 += var13.getCrtligPt();
               var5 += var13.getCrtligTva();
               var7 += var13.getCrtligTtc();
               var9 += var13.getCrtligTc();
               if (var13.getCrtligRabais() != 0.0D || var13.getCrtligTauxRemise() != 0.0F) {
                  var11 += var13.getCrtligPu() * (double)var13.getCrtligQte() - var13.getCrtligPt();
               }

               var1 = var1 + var13.getCrtligPt() - var13.getCrtligPump() * (double)var13.getCrtligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.contratEnteteVentes.setCrtTotHt(var3);
      this.contratEnteteVentes.setCrtTotTva(var5);
      this.contratEnteteVentes.setCrtTotTtc(var7);
      this.contratEnteteVentes.setCrtTotRemise(var11);
      this.contratEnteteVentes.setCrtTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.contratLigneVentes = (ContratLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         if (this.contratLigneVentes.getCrtligCode() != null && this.contratLigneVentes.getCrtligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.contratLigneVentes.getCrtligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.contratLigneVentes.setCrtligCode(this.produits.getProCode());
               this.contratLigneVentes.setCrtligFamille(this.produits.getProAchCode());
               this.contratLigneVentes.setCrtligStock(this.produits.getProStock());
               this.contratLigneVentes.setCrtligLong(this.produits.getProLongueur());
               this.contratLigneVentes.setCrtligLarg(this.produits.getProLargeur());
               this.contratLigneVentes.setCrtligHaut(this.produits.getProEpaisseur());
               this.contratLigneVentes.setCrtligDiam(this.produits.getProDiamExt());
               this.contratLigneVentes.setCrtligPoidsBrut(this.produits.getProPoidsBrut());
               this.contratLigneVentes.setCrtligPoidsNet(this.produits.getProPoidsNet());
               this.contratLigneVentes.setCrtligVolume(this.produits.getProVolume());
               if (this.contratEnteteVentes.getCrtType() != 26) {
                  this.contratLigneVentes.setCrtligNb(this.produits.getProNbUnite());
               }

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
               if (this.contratLigneVentes.getCrtligTaxe() != null && !this.contratLigneVentes.getCrtligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.contratLigneVentes.getCrtligTaxe(), this.contratLigneVentes.getCrtligTaxe() + ":" + this.contratLigneVentes.getCrtligTauxTaxe()));
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
         this.contratLigneVentes = (ContratLigneVentes)this.datamodelLigne.getRowData();
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
      this.contratLigneVentes = new ContratLigneVentes();
      this.mesTaxesVentesProduits = new ArrayList();
      this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesProduitsDepotsItems.add(new SelectItem(0, ""));
      this.mesConditionnementsProduits = new ArrayList();
      this.mesConditionnementsProduits.add(new SelectItem(0, ""));
      this.mesUnitesProduits = new ArrayList();
      this.mesUnitesProduits.add(new SelectItem(0, ""));
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
      if (this.contratLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.contratLigneVentes);
            this.lesLignesList.add(this.numLigne, this.contratLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.contratLigneVentes = (ContratLigneVentes)this.lesLignesList.get(var3);
               this.contratLigneVentes.setCrtligOrdre(var3);
               this.contratLigneVentes = this.contratLigneVentesDao.modifLigne(this.contratLigneVentes, var1);
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
      if (this.contratLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.contratLigneVentes);
            this.lesLignesList.add(this.numLigne, this.contratLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.contratLigneVentes = (ContratLigneVentes)this.lesLignesList.get(var3);
               this.contratLigneVentes.setCrtligOrdre(var3);
               this.contratLigneVentes = this.contratLigneVentesDao.modifLigne(this.contratLigneVentes, var1);
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
            if (this.contratLigneVentes.getCrtligId() == ((ContratLigneVentes)this.lesLignesList.get(var2)).getCrtligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty() || this.contratLigneVentes.getCrtligLibelle() != null && !this.contratLigneVentes.getCrtligLibelle().isEmpty() || this.contratLigneVentes.getCrtligComplement() != null && !this.contratLigneVentes.getCrtligComplement().isEmpty()) {
         if (this.contratEnteteVentes.getCrtId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.contratLigneVentes.setCrtligEntStock(this.contratEnteteVentes.getCrtStock());
            if (this.contratLigneVentes.getCrtligQteUtil() == 0.0F) {
               this.contratLigneVentes.setCrtligQteUtil(this.contratLigneVentes.getCrtligQte());
            }

            this.calculPrix(this.contratLigneVentes.getCrtligTaxe(), this.contratLigneVentes.getCrtligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.contratLigneVentes.setCrtligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.contratLigneVentes.setCrtligDepot(var3[0]);
               }
            } else {
               this.contratLigneVentes.setCrtligDepot("");
            }

            if (this.contratLigneVentes.getCrtligCondition() != null && !this.contratLigneVentes.getCrtligCondition().isEmpty() && this.contratLigneVentes.getCrtligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.contratLigneVentes.getCrtligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.contratLigneVentes.setCrtligDescription(var5);
               } else {
                  this.contratLigneVentes.setCrtligDescription("");
               }

               if (this.contratLigneVentes.getCrtligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.contratLigneVentes.setCrtligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.contratLigneVentes.setCrtligDescription("");
            }

            if (this.contratLigneVentes.getCrtligId() == 0L) {
               this.contratLigneVentes.setContratEnteteVentes(this.contratEnteteVentes);
               this.contratLigneVentes.setCrtligDevise(this.contratEnteteVentes.getCrtDevise());
               this.contratLigneVentes.setCrtligEntStock(this.contratEnteteVentes.getCrtStock());
               this.contratLigneVentes = this.contratLigneVentesDao.insertLigne(this.contratLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.contratLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.contratLigneVentes = this.contratLigneVentesDao.modifLigne(this.contratLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new ContratLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  ContratLigneVentes var16 = (ContratLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getCrtligGroupe() != null && !var16.getCrtligGroupe().isEmpty() && var16.getCrtligGroupe().equals(this.memoProduits.getProCode())) {
                     this.contratLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.contratLigneVentes.getCrtligQte();
               new ContratLigneVentes();

               ContratLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (ContratLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getCrtligGroupe() != null && !var19.getCrtligGroupe().isEmpty() && var19.getCrtligGroupe().equals(var18)) {
                     this.contratLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new ContratLigneVentes();
                     var19.setCrtligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setCrtligCondition("");
                     var19.setCrtligComplement("");
                     var19.setCrtligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setCrtligDescription("");
                     var19.setCrtligDevise(this.contratEnteteVentes.getCrtDevise());
                     var19.setCrtligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setCrtligEchelle(0);
                     var19.setCrtligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setCrtligGroupe(var18);
                     var19.setCrtligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setCrtligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setCrtligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setCrtligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setCrtligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setCrtligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setCrtligOrdre(var8);
                     var19.setCrtligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setCrtligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setCrtligPt(0.0D);
                     var19.setCrtligPu(0.0D);
                     var19.setCrtligPuRem(0.0D);
                     var19.setCrtligPuRemTtc(0.0D);
                     var19.setCrtligPuTtc(0.0D);
                     var19.setCrtligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setCrtligQte(var9);
                     var19.setCrtligQteUtil(var19.getCrtligQte());
                     var19.setCrtligRabais(0.0D);
                     var19.setCrtligReference(var18);
                     var19.setCrtligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setCrtligTauxRemise(0.0F);
                     var19.setCrtligTauxTaxe(0.0F);
                     var19.setCrtligTaxe("");
                     var19.setCrtligTc(0.0D);
                     var19.setCrtligTtc(0.0D);
                     var19.setCrtligTva(0.0D);
                     var19.setCrtligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setCrtligVolume(0.0F);
                     var19.setContratEnteteVentes(this.contratEnteteVentes);
                     var19 = this.contratLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var1);
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
      if (this.contratLigneVentes.getCrtligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.contratLigneVentes.getCrtligCode();
            int var4 = this.contratLigneVentes.getCrtligModeGroupe();
            String var5 = this.contratLigneVentes.getCrtligGroupe();
            this.contratLigneVentesDao.deleteOneLigne(this.contratLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new ContratLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  ContratLigneVentes var6 = (ContratLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getCrtligGroupe() != null && !var6.getCrtligGroupe().isEmpty() && var6.getCrtligGroupe().equals(var3)) {
                     this.contratLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " de la Facture N° " + this.contratEnteteVentes.getCrtNum() + " du " + this.contratEnteteVentes.getCrtDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.contratEnteteVentes.getCrtNomTiers(), this.nature);
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
                     this.contratEnteteVentes.setCrtSerie(this.tiers.getTieserie());
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
            this.contratEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.contratEnteteVentes.setCrtCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.contratEnteteVentes.setCrtCivilTiers(this.contratEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.contratEnteteVentes.setCrtNomTiers(this.nomTier);
            this.contratEnteteVentes.setCrtTypeReg(this.tiers.getTietypereg());
            this.contratEnteteVentes.setCrtModeReg(this.tiers.getTiemodereg());
            String var9 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var9 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var9 = this.tiers.getTiemodereg();
            }

            int var10;
            if (!var9.equals("") && !var9.equals("100")) {
               this.contratEnteteVentes.setCrtNbJourReg(this.tiers.getTienbecheance());
               this.contratEnteteVentes.setCrtArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var10 = 0; var10 < this.lesModeReglementClientsListe.size(); ++var10) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var10);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.contratEnteteVentes.setCrtTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.contratEnteteVentes.setCrtModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.contratEnteteVentes.setCrtNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.contratEnteteVentes.setCrtArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.contratEnteteVentes.setCrtJournalReg(this.tiers.getTiejournalreg());
            this.contratEnteteVentes.setCrtCat(this.tiers.getTienomfamille());
            this.contratEnteteVentes.setCrtExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.contratEnteteVentes.setCrtExoDouane(1);
            }

            var10 = this.tiers.getTieexotva();
            if (var10 >= 2) {
               var10 = 0;
            }

            this.contratEnteteVentes.setCrtExoTva(var10);
            if (this.var_tc_calcul) {
               this.contratEnteteVentes.setCrtTauxTc(this.var_tc_taux);
            } else {
               this.contratEnteteVentes.setCrtTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.contratEnteteVentes.setCrtExoTva(1);
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

            if (this.tiers.getTiefacpr() == 0) {
               this.var_pr_pv = false;
            } else {
               this.var_pr_pv = true;
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.contratEnteteVentes.setCrtDevise(this.tiers.getTiedevise());
            } else {
               this.contratEnteteVentes.setCrtDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }

            this.chargerLesUsers(var1);
            this.chargerLesParcs(var1);
            if (this.typeVente == 810) {
               this.lesLignesList.clear();
               LectureModeleFacture var11 = new LectureModeleFacture(this.structureLog.getStrid(), this.tiers.getTieregion());
               var11.recupereModele(this.structureLog.getStrid(), this.tiers.getTieregion());
               new ArrayList();
               List var12 = var11.getLesModeles();
               if (var12.size() != 0) {
                  new ObjetModeleFacture();

                  for(int var8 = 0; var8 < var12.size(); ++var8) {
                     ObjetModeleFacture var13 = (ObjetModeleFacture)var12.get(var8);
                     this.contratLigneVentes = new ContratLigneVentes();
                     this.contratLigneVentes.setCrtligCode(var13.getCode());
                     this.contratLigneVentes.setCrtligLibelle(var13.getLibelle());
                     this.contratLigneVentes.setCrtligTaxe(var13.getTva());
                     this.contratLigneVentes.setCrtligQte(var13.getQte());
                     this.contratLigneVentes.setCrtligPu(var13.getPu());
                     this.lesLignesList.add(this.contratLigneVentes);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
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
      this.contratEnteteVentes.setTiers(this.tiers);
      this.contratEnteteVentes.setCrtNomTiers("");
      this.contratEnteteVentes.setCrtCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      }

      if (this.typeVente == 810) {
         this.lesLignesList.clear();
         this.datamodelLigne.setWrappedData(this.lesLignesList);
      }

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
      if (!this.contratEnteteVentes.getCrtNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.contratEnteteVentes.getCrtCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.contratEnteteVentes.setCrtExoTva(0);
      } else {
         this.contratEnteteVentes.setCrtExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.contratEnteteVentes.setCrtExoDouane(0);
      } else {
         this.contratEnteteVentes.setCrtExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.contratEnteteVentes.setCrtTauxTc(this.var_tc_taux);
      } else {
         this.contratEnteteVentes.setCrtTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.contratLigneVentes = new ContratLigneVentes();
               this.contratLigneVentes = (ContratLigneVentes)this.lesLignesList.get(var3);
               if (this.contratEnteteVentes.getCrtExoTva() == 1) {
                  this.contratLigneVentes.setCrtligTaxe("");
                  this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                  this.contratLigneVentes.setCrtligTva(0.0D);
               } else if (this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.contratLigneVentes.getCrtligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.contratLigneVentes.setCrtligTaxe("");
                        this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.contratLigneVentes.setCrtligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.contratLigneVentes.setCrtligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.contratLigneVentes.getCrtligTaxe(), var1);
                        if (var5 != null) {
                           this.contratLigneVentes.setCrtligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.contratLigneVentes.setCrtligTaxe(this.optionsVentes.getTvaDefaut());
                        this.contratLigneVentes.setCrtligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.contratLigneVentes.setCrtligTaxe("");
                        this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                     }
                  } else {
                     this.contratLigneVentes.setCrtligTaxe("");
                     this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                  }

                  if ((this.contratLigneVentes.getCrtligTaxe() == null || this.contratLigneVentes.getCrtligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.contratLigneVentes.setCrtligTaxe(var5.getTaxvteCode());
                        this.contratLigneVentes.setCrtligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.contratLigneVentes.getCrtligTaxe(), this.contratLigneVentes.getCrtligTauxTaxe(), var1);
               this.contratLigneVentes = this.contratLigneVentesDao.modifLigne(this.contratLigneVentes, var1);
            }
         }

         if (this.contratEnteteVentes.getCrtExoTva() == 0) {
            this.contratEnteteVentes.setCrtMotifExo("");
            this.contratEnteteVentes.setCrtNumVisa("");
            this.contratEnteteVentes.setCrtDateVisa((Date)null);
            this.contratEnteteVentes.setCrtRangeVisa("");
         }

         if (this.contratEnteteVentes.getCrtId() != 0L) {
            this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.contratLigneVentes = new ContratLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.contratLigneVentes = (ContratLigneVentes)this.lesLignesList.get(var3);
               this.contratLigneVentes.setCrtligTauxRemise(this.contratEnteteVentes.getCrtTauxRemise());
               this.calculPrix(this.contratLigneVentes.getCrtligTaxe(), this.contratLigneVentes.getCrtligTauxTaxe(), var1);
               this.contratLigneVentes = this.contratLigneVentesDao.modifLigne(this.contratLigneVentes, var1);
            }
         }

         if (this.contratEnteteVentes.getCrtId() != 0L) {
            this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.contratEnteteVentes.getCrtNomContact(), this.nature);
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
         this.contratEnteteVentes.setCrtNomContact(this.plansAnalytiques.getAnaNomFr());
         this.contratEnteteVentes.setCrtCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.contratEnteteVentes.setCrtAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.contratEnteteVentes.setCrtNomContact("");
      this.contratEnteteVentes.setCrtCivilContact("");
      this.contratEnteteVentes.setCrtAnal4("");
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
      if (this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty() && !this.contratLigneVentes.getCrtligCode().equals("-") && !this.contratLigneVentes.getCrtligCode().equals("=")) {
         if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.contratLigneVentes.getCrtligCode(), this.nature, this.optionsVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.contratLigneVentes.getCrtligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         this.contratLigneVentes.setCrtligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.contratLigneVentes.setCrtligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.contratLigneVentes.setCrtligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.contratLigneVentes.setCrtligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.contratLigneVentes.setCrtligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.contratLigneVentes.setCrtligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.contratLigneVentes.setCrtligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.contratLigneVentes.setCrtligFamille(this.produits.getProVteCode());
         this.contratLigneVentes.setCrtligStock(this.produits.getProStock());
         this.contratLigneVentes.setCrtligLong(this.produits.getProLongueur());
         this.contratLigneVentes.setCrtligLarg(this.produits.getProLargeur());
         this.contratLigneVentes.setCrtligHaut(this.produits.getProEpaisseur());
         this.contratLigneVentes.setCrtligDiam(this.produits.getProDiamExt());
         this.contratLigneVentes.setCrtligPoidsBrut(this.produits.getProPoidsBrut());
         this.contratLigneVentes.setCrtligPoidsNet(this.produits.getProPoidsNet());
         this.contratLigneVentes.setCrtligVolume(this.produits.getProVolume());
         this.contratLigneVentes.setCrtligNb(this.produits.getProNbUnite());
         this.contratLigneVentes.setCrtligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.contratLigneVentes.setCrtligModeGroupe(this.produits.getProMode());
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
                  this.contratLigneVentes.setCrtligTaxe(this.produits.getProVteTva());
                  this.contratLigneVentes.setCrtligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.contratLigneVentes.setCrtligTaxe("");
                  this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.contratLigneVentes.setCrtligTaxe(var8.getFamvteTaxe());
                  this.contratLigneVentes.setCrtligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.contratLigneVentes.setCrtligTaxe("");
               this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.contratEnteteVentes.getCrtExoTva() == 0 && (this.contratLigneVentes.getCrtligTaxe() == null || this.contratLigneVentes.getCrtligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.contratLigneVentes.setCrtligTaxe(var9.getTaxvteCode());
                  this.contratLigneVentes.setCrtligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.contratLigneVentes.setCrtligTaxe("");
            this.contratLigneVentes.setCrtligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.contratLigneVentes.getCrtligTauxTaxe() / 100.0D;
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
               this.contratLigneVentes.setCrtligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.contratLigneVentes.setCrtligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.contratLigneVentes.setCrtligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.contratLigneVentes.setCrtligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.contratLigneVentes.setCrtligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.contratLigneVentes.getCrtligPump() != 0.0D) {
            this.contratLigneVentes.setCrtligPu(this.contratLigneVentes.getCrtligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.contratLigneVentes.getCrtligTaxe(), this.contratLigneVentes.getCrtligTauxTaxe(), var1);
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
      if (this.contratLigneVentes.getCrtligCode() == null || this.contratLigneVentes.getCrtligCode().isEmpty() || this.contratLigneVentes.getCrtligCode().length() < 2) {
         if (this.contratEnteteVentes.getCrtExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.contratLigneVentes.setCrtligTaxe(this.optionsVentes.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.contratLigneVentes.setCrtligCode("");
      this.contratLigneVentes.setCrtligLibelle("");
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
            var2 = this.contratLigneVentes.getCrtligPuTtc();
         } else {
            var2 = this.contratLigneVentes.getCrtligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.contratLigneVentes.setCrtligPuTtc(this.prixUnitaires);
            this.contratLigneVentes.setCrtligPuRemTtc(this.prixUnitaires);
         } else {
            this.contratLigneVentes.setCrtligPu(this.prixUnitaires);
            this.contratLigneVentes.setCrtligPuRem(this.prixUnitaires);
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
                     this.contratLigneVentes.setCrtligTauxRemise(var6.getBarRemise());
                     this.contratLigneVentes.setCrtligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.contratEnteteVentes.getCrtDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.contratLigneVentes.setCrtligPuTtc(this.prixUnitaires);
                        this.contratLigneVentes.setCrtligPuRemTtc(var11);
                     } else {
                        this.contratLigneVentes.setCrtligPu(this.prixUnitaires);
                        this.contratLigneVentes.setCrtligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.contratLigneVentes.setCrtligTauxRemise(var6.getBarRemise());
                     this.contratLigneVentes.setCrtligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.contratLigneVentes.getCrtligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.contratLigneVentes.setCrtligPuTtc(this.prixUnitaires);
                        this.contratLigneVentes.setCrtligPuRemTtc(var11);
                     } else {
                        this.contratLigneVentes.setCrtligPu(this.prixUnitaires);
                        this.contratLigneVentes.setCrtligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.contratLigneVentes.setCrtligTauxRemise(var6.getBarRemise());
                     this.contratLigneVentes.setCrtligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.contratLigneVentes.setCrtligPuTtc(this.prixUnitaires);
                        this.contratLigneVentes.setCrtligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.contratLigneVentes.setCrtligPu(this.prixUnitaires);
                        this.contratLigneVentes.setCrtligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.contratLigneVentes.setCrtligPuTtc(this.prixUnitaires);
                     this.contratLigneVentes.setCrtligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.contratLigneVentes.setCrtligPu(this.prixUnitaires);
                     this.contratLigneVentes.setCrtligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((ContratLigneVentes)this.lesLignesList.get(var9)).getCrtligCode() == null || ((ContratLigneVentes)this.lesLignesList.get(var9)).getCrtligCode().isEmpty() || !((ContratLigneVentes)this.lesLignesList.get(var9)).getCrtligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((ContratLigneVentes)this.lesLignesList.get(var9)).getCrtligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((ContratLigneVentes)this.lesLignesList.get(var8)).getCrtligFamille() != null && !((ContratLigneVentes)this.lesLignesList.get(var8)).getCrtligFamille().isEmpty() && ((ContratLigneVentes)this.lesLignesList.get(var8)).getCrtligFamille().equals(var7)) {
                  var5 += ((ContratLigneVentes)this.lesLignesList.get(var8)).getCrtligPt();
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
         double var2 = this.contratLigneVentes.getCrtligPu();
         double var4 = this.contratLigneVentes.getCrtligPuTtc();
         if (this.contratLigneVentes.getCrtligPu() >= 0.0D && this.contratLigneVentes.getCrtligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.contratEnteteVentes.getCrtCat(), (String)null, var1);
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
                     if (this.contratLigneVentes.getCrtligQte() >= var7.getQteDebut() && this.contratLigneVentes.getCrtligQte() <= var7.getQteFin()) {
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
                        if (this.contratLigneVentes.getCrtligQte() >= var7.getQteDebut() && this.contratLigneVentes.getCrtligQte() <= var7.getQteFin()) {
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
            var2 = Math.abs(this.contratLigneVentes.getCrtligPu());
            var4 = Math.abs(this.contratLigneVentes.getCrtligPuTtc());
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
      this.contratLigneVentes.setCrtligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.contratLigneVentes.getCrtligCondition() != null && !this.contratLigneVentes.getCrtligCondition().isEmpty() && this.contratLigneVentes.getCrtligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.contratLigneVentes.getCrtligEchelle());
            float var5 = 1.0F;
            if (this.contratLigneVentes.getCrtligCondition().contains("/")) {
               String[] var6 = this.contratLigneVentes.getCrtligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.contratLigneVentes.getCrtligCondition() != null && !this.contratLigneVentes.getCrtligCondition().isEmpty() && !this.contratLigneVentes.getCrtligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.contratLigneVentes.getCrtligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.contratLigneVentes.setCrtligPump(var9);
      } else {
         this.contratLigneVentes.setCrtligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.contratLigneVentes.getCrtligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.contratLigneVentes.setCrtligEchelle(this.unite.getUniEchelle());
               } else {
                  this.contratLigneVentes.setCrtligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.contratLigneVentes.setCrtligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.contratLigneVentes.setCrtligEchelle(Integer.parseInt(var2));
         } else {
            this.contratLigneVentes.setCrtligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.contratLigneVentes.getCrtligLong(), this.contratLigneVentes.getCrtligLarg(), this.contratLigneVentes.getCrtligHaut(), this.contratLigneVentes.getCrtligDiam(), this.contratLigneVentes.getCrtligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.contratLigneVentes.getCrtligLong(), this.contratLigneVentes.getCrtligLarg(), this.contratLigneVentes.getCrtligHaut(), this.contratLigneVentes.getCrtligDiam(), this.contratLigneVentes.getCrtligNb(), this.baseLog, var1);
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

   public String conversionContrat() throws HibernateException, NamingException {
      String var1 = null;
      if (this.contratEnteteVentes.getCrtText() != null && !this.contratEnteteVentes.getCrtText().isEmpty()) {
         var1 = this.contratEnteteVentes.getCrtText();
         if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
            String var2 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
            var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var2 + " alt=" + "signature /></p>";
         }
      }

      return var1;
   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.contratEnteteVentes.getCrtFormule1() != null && !this.contratEnteteVentes.getCrtFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.contratEnteteVentes.getCrtFormule1(), (Session)null);
      }

      return var1;
   }

   public String formule2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.contratEnteteVentes.getCrtFormule2() != null && !this.contratEnteteVentes.getCrtFormule2().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.contratEnteteVentes.getCrtFormule2(), (Session)null);
      }

      return var1;
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contratVente" + File.separator;
      return var2;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatContrat.jpg");
            if (var4.exists()) {
               var3 = "formatContrat.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatContrat.jpg");
         if (var4.exists()) {
            var3 = "formatContrat.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.calculeImpressionListe());
      return var1;
   }

   public List calculeImpressionListe() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var2 = false;
         String var3 = "";
         double var4 = 0.0D;
         double var6 = 0.0D;
         this.infoOrigineDoc = "";

         for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
            this.contratLigneVentes = (ContratLigneVentes)this.lesLignesList.get(var8);
            if (this.contratLigneVentes.getCrtligModeGroupe() != 2 || this.contratLigneVentes.getCrtligGroupe() == null || this.contratLigneVentes.getCrtligGroupe().isEmpty()) {
               if (this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty() && this.contratLigneVentes.getCrtligCode().equals("-")) {
                  var2 = true;
                  var3 = this.contratLigneVentes.getCrtligLibelle();
                  if (var3.startsWith("Suivant ") && (this.infoOrigineDoc == null || this.infoOrigineDoc.isEmpty())) {
                     this.infoOrigineDoc = var3;
                  }
               }

               if (var2) {
                  var4 += this.contratLigneVentes.getCrtligPt();
                  var6 = this.contratLigneVentes.getCrtligTtc();
               }

               if (this.contratLigneVentes.getCrtligCode() != null && !this.contratLigneVentes.getCrtligCode().isEmpty() && this.contratLigneVentes.getCrtligCode().equals("=") && var2) {
                  this.contratLigneVentes = new ContratLigneVentes();
                  this.contratLigneVentes.setContratEnteteVentes(this.contratEnteteVentes);
                  this.contratLigneVentes.setCrtligCode("=");
                  this.contratLigneVentes.setCrtligOrdre(var8);
                  this.contratLigneVentes.setCrtligLibelle(var3);
                  this.contratLigneVentes.setCrtligPt(var4);
                  this.contratLigneVentes.setCrtligTtc(var6);
                  var1.add(this.contratLigneVentes);
                  var4 = 0.0D;
                  var6 = 0.0D;
                  var2 = false;
               } else {
                  this.contratLigneVentes.setContratEnteteVentes(this.contratEnteteVentes);
                  this.contratLigneVentes.setCrtligOrdre(var8);
                  var1.add(this.contratLigneVentes);
               }
            }
         }

         if (this.structureLog.getStrid() == 245L) {
            this.contratLigneVentes = new ContratLigneVentes();
            this.contratLigneVentes.setContratEnteteVentes(this.contratEnteteVentes);
            this.contratLigneVentes.setCrtligCode("FORMULE1");
            this.contratLigneVentes.setCrtligOrdre(var1.size() + 2);
            this.contratLigneVentes.setCrtligLibelle(this.formule1());
            this.contratLigneVentes.setCrtligPt(0.0D);
            this.contratLigneVentes.setCrtligTtc(0.0D);
            var1.add(this.contratLigneVentes);
            this.contratLigneVentes = new ContratLigneVentes();
            this.contratLigneVentes.setContratEnteteVentes(this.contratEnteteVentes);
            this.contratLigneVentes.setCrtligCode("FORMULE2");
            this.contratLigneVentes.setCrtligOrdre(var1.size() + 2);
            this.contratLigneVentes.setCrtligLibelle(this.formule2());
            this.contratLigneVentes.setCrtligPt(0.0D);
            this.contratLigneVentes.setCrtligTtc(0.0D);
            var1.add(this.contratLigneVentes);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.contratEnteteVentes.getCrtTotTtc() + this.contratEnteteVentes.getCrtTotTc(), this.contratEnteteVentes.getCrtDevise());
      return var1;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.contratEnteteVentes.getCrtAnal2() != null && !this.contratEnteteVentes.getCrtAnal2().isEmpty()) {
         String var4 = "";
         if (this.contratEnteteVentes.getCrtAnal2().contains(":")) {
            String[] var5 = this.contratEnteteVentes.getCrtAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.contratEnteteVentes.getCrtAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.contratEnteteVentes.getCrtDateImp() != null && this.contratEnteteVentes.getCrtEtat() != 0) {
            var2 = true;
         }

         this.contratEnteteVentes.setCrtDateImp(new Date());
         if (this.contratEnteteVentes.getCrtEtat() == 0 && this.contratEnteteVentes.getCrtEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.contratEnteteVentes.setCrtEtat(1);
         }

         this.contratEnteteVentes.setCrtModeleImp(var1);
         this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var3);
         this.contacts = new Contacts();
         if (this.contratEnteteVentes.getCrtIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.contratEnteteVentes.getCrtIdContact(), var3);
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

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var4);
            var1.setEntete("Impression contrat");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionContrat());
            if (this.contratEnteteVentes.getCrtFormule1() != null && !this.contratEnteteVentes.getCrtFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.contratEnteteVentes.getCrtEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.contratEnteteVentes.getCrtIdResponsable());
            var1.setIdCommercial(this.contratEnteteVentes.getCrtIdCommercial());
            var1.setTiersSelectionne(this.contratEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNature(this.nature);
            var1.setId_doc(this.contratEnteteVentes.getCrtId());
            if (this.contratEnteteVentes.getCrtAnal2() != null && !this.contratEnteteVentes.getCrtAnal2().isEmpty()) {
               String var13 = "";
               if (this.contratEnteteVentes.getCrtAnal2().contains(":")) {
                  String[] var14 = this.contratEnteteVentes.getCrtAnal2().split(":");
                  var13 = var14[0];
               } else {
                  var13 = this.contratEnteteVentes.getCrtAnal2();
               }

               new Parc();
               ParcDao var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var23 = var15.rechercheParc(var13, (Session)null);
               if (var23 != null) {
                  var1.setParc(var23);
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
            JRBeanCollectionDataSource var20 = new JRBeanCollectionDataSource(this.lesEntetesList);
            var1.setjRBeanCollectionDataSource(var20);
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
         var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.contratEnteteVentes.getCrtEtat()));
         var1.setEmetteur("");
         var1.setDestinataire("");
         var1.setDestinataireCC("");
         var1.setDestinataireCCI("");
         var1.setCorpsMail("");
         var1.setId_doc(0L);
         var1.setFormat("PDF");
         if (this.lesEntetesList.size() != 0) {
            ArrayList var21 = new ArrayList();
            new ContratEnteteVentes();
            ContratEnteteVentes var22 = this.contratEnteteVentes;
            Session var24 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");

            for(int var25 = 0; var25 < this.lesEntetesList.size(); ++var25) {
               this.contratEnteteVentes = (ContratEnteteVentes)this.lesEntetesList.get(var25);
               if (this.contratEnteteVentes.getCrtAnal2() != null && !this.contratEnteteVentes.getCrtAnal2().isEmpty()) {
                  String var16 = "";
                  if (this.contratEnteteVentes.getCrtAnal2().contains(":")) {
                     String[] var17 = this.contratEnteteVentes.getCrtAnal2().split(":");
                     var16 = var17[0];
                  } else {
                     var16 = this.contratEnteteVentes.getCrtAnal2();
                  }

                  new Parc();
                  ParcDao var18 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var28 = var18.rechercheParc(var16, var24);
                  if (var28 != null) {
                     var1.setParc((Parc)null);
                     this.contratEnteteVentes.setParcImmatriculation(var28.getPrcImmatriculation());
                  } else {
                     var1.setParc((Parc)null);
                     this.contratEnteteVentes.setParcImmatriculation("");
                  }
               } else {
                  var1.setParc((Parc)null);
                  this.contratEnteteVentes.setParcImmatriculation("");
               }

               boolean var27 = false;
               if (this.contratEnteteVentes.getCrtDateImp() != null && this.contratEnteteVentes.getCrtEtat() != 0) {
                  var27 = true;
               }

               this.chargerDocumentLigne(var24);
               new ArrayList();
               List var29 = this.calculeImpressionListe();
               if (var29.size() != 0) {
                  new ContratLigneVentes();

                  for(int var19 = 0; var19 < var29.size(); ++var19) {
                     ContratLigneVentes var30 = (ContratLigneVentes)var29.get(var19);
                     var30.setContratEnteteVentes(this.contratEnteteVentes);
                     var30.getContratEnteteVentes().setMontantLettre(this.montant_lettre);
                     var30.getContratEnteteVentes().setDupplicata("" + var27);
                     var30.getContratEnteteVentes().setInfoOrigineDoc(this.infoOrigineDoc);
                     var30.getContratEnteteVentes().setParcImmatriculation(this.contratEnteteVentes.getParcImmatriculation());
                     var21.add(var30);
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
            JRBeanCollectionDataSource var26 = new JRBeanCollectionDataSource(var21);
            var1.setjRBeanCollectionDataSource(var26);
            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.contratEnteteVentes = var22;
            this.chargerDocumentLigne((Session)null);
         }
      }

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

   public boolean isContDest() {
      return this.contDest;
   }

   public void setContDest(boolean var1) {
      this.contDest = var1;
   }

   public ContratEnteteVentes getContratEnteteVentes() {
      return this.contratEnteteVentes;
   }

   public void setContratEnteteVentes(ContratEnteteVentes var1) {
      this.contratEnteteVentes = var1;
   }

   public ContratLigneVentes getCrttureLigneVentes() {
      return this.contratLigneVentes;
   }

   public void setCrttureLigneVentes(ContratLigneVentes var1) {
      this.contratLigneVentes = var1;
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

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
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

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public ContratLigneVentes getContratLigneVentes() {
      return this.contratLigneVentes;
   }

   public void setContratLigneVentes(ContratLigneVentes var1) {
      this.contratLigneVentes = var1;
   }

   public boolean isAfficheTexteContrat() {
      return this.afficheTexteContrat;
   }

   public void setAfficheTexteContrat(boolean var1) {
      this.afficheTexteContrat = var1;
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

   public DataModel getDataModelEcheance() {
      return this.dataModelEcheance;
   }

   public void setDataModelEcheance(DataModel var1) {
      this.dataModelEcheance = var1;
   }

   public boolean isShowModalPanelAuto() {
      return this.showModalPanelAuto;
   }

   public void setShowModalPanelAuto(boolean var1) {
      this.showModalPanelAuto = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public List getMesImpressionsFacturesItems() {
      return this.mesImpressionsFacturesItems;
   }

   public void setMesImpressionsFacturesItems(List var1) {
      this.mesImpressionsFacturesItems = var1;
   }

   public String getModeleFacture() {
      return this.modeleFacture;
   }

   public void setModeleFacture(String var1) {
      this.modeleFacture = var1;
   }

   public int getNombreFacture() {
      return this.nombreFacture;
   }

   public void setNombreFacture(int var1) {
      this.nombreFacture = var1;
   }

   public double getTotalHt() {
      return this.totalHt;
   }

   public void setTotalHt(double var1) {
      this.totalHt = var1;
   }

   public double getTotalReglement() {
      return this.totalReglement;
   }

   public void setTotalReglement(double var1) {
      this.totalReglement = var1;
   }

   public double getTotalTtc() {
      return this.totalTtc;
   }

   public void setTotalTtc(double var1) {
      this.totalTtc = var1;
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

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public List getMesNaturesMissions() {
      return this.mesNaturesMissions;
   }

   public void setMesNaturesMissions(List var1) {
      this.mesNaturesMissions = var1;
   }

   public DataModel getDataModelTache() {
      return this.dataModelTache;
   }

   public void setDataModelTache(DataModel var1) {
      this.dataModelTache = var1;
   }
}
