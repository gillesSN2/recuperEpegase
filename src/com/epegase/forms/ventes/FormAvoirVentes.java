package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
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
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteVentes;
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
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
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
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
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

public class FormAvoirVentes implements Serializable {
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
   private AvoirEnteteVentes avoirEnteteVentes = new AvoirEnteteVentes();
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
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
   private boolean showModalPanelHistoReglement = false;
   private List mesAffairesItems = new ArrayList();
   private String numeroPfManuel;
   private boolean showModalPanelAnnuler = false;
   private AvoirLigneVentes avoirLigneVentes = new AvoirLigneVentes();
   private AvoirLigneVentesDao avoirLigneVentesDao;
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
   private boolean showModalPanelPaye = false;
   private FactureEnteteVentes factureEnteteVentes;
   private transient DataModel dataModelFacture = new ListDataModel();
   private List listFactureVentes = new ArrayList();
   private CommandeEnteteVentes commandeEnteteVentes;
   private List listCommandeVentes = new ArrayList();
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private List listLivraisonVentes = new ArrayList();
   private double totalPayer;
   private double totalEcart;
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
   private String libelleRabRis;
   private boolean ristourne;

   public FormAvoirVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionsVentes.getAffichInGlobViewAVOIR();
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
      this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.avoirEnteteVentes != null) {
         this.devisePrint = this.avoirEnteteVentes.getAvrDevise();
         this.lesLignesList = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, (Session)null);
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
         List var12 = this.avoirEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpNumBCC, this.inpNumAnal, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new AvoirEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               AvoirEnteteVentes var16 = (AvoirEnteteVentes)var12.get(var17);
               if (var16.getAvrActivite() != null && !var16.getAvrActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getAvrActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getAvrActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getAvrActivite().contains(this.var_colonne3)) {
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
         new AvoirEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            AvoirEnteteVentes var18 = (AvoirEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var18.getAvrTotTtc();
            var4 += var18.getAvrTotReglement();
            var6 += var18.getAvrTotHt();
            var8 += var18.getAvrTotTva();
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
            this.avoirEnteteVentes = (AvoirEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.avoirEnteteVentes.getAvrNomTiers();
            this.inpIdTiersEnCours = this.avoirEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.avoirEnteteVentes.getAvrNomContact();
            this.var_date = this.avoirEnteteVentes.getAvrDate();
            if (this.avoirEnteteVentes.getAvrDate().getHours() <= 9) {
               this.var_heure = "0" + this.avoirEnteteVentes.getAvrDate().getHours();
            } else {
               this.var_heure = "" + this.avoirEnteteVentes.getAvrDate().getHours();
            }

            if (this.avoirEnteteVentes.getAvrDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.avoirEnteteVentes.getAvrDate().getMinutes();
            } else {
               this.var_minute = "" + this.avoirEnteteVentes.getAvrDate().getMinutes();
            }

            if (this.avoirEnteteVentes.getAvrDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.avoirEnteteVentes.getAvrDate().getSeconds();
            } else {
               this.var_seconde = "" + this.avoirEnteteVentes.getAvrDate().getSeconds();
            }

            this.tiers = this.avoirEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.avoirEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.numeroPfManuel = this.avoirEnteteVentes.getAvrAnal4();
            this.var_nom_contact = this.avoirEnteteVentes.getAvrIdContact();
            this.var_nom_responsable = this.avoirEnteteVentes.getAvrIdResponsable();
            this.var_nom_commercial = this.avoirEnteteVentes.getAvrIdCommercial();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerDocumentTrace(var4);
            this.chargerBonEncaissement(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerParapheur(var4);
            this.chargerLesUsers(var4);
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

            this.setMontantTtcElmt(this.avoirEnteteVentes.getAvrTotTtc());
            this.setMontantReglementElmt(this.avoirEnteteVentes.getAvrTotReglement());
            this.setMontantSoldeElmt(this.avoirEnteteVentes.getAvrTotTtc() - this.avoirEnteteVentes.getAvrTotReglement());
            this.cumulPrix();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.avoirEnteteVentes.getAvrTotTc() != 0.0D) {
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
      if (this.avoirEnteteVentes != null) {
         if (this.avoirEnteteVentes.getAvrEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.avoirEnteteVentes.getAvrDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.avoirEnteteVentes.getAvrDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.avoirEnteteVentes.getAvrId() > 0L) {
         this.lesLignesList = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.avoirEnteteVentes != null && this.avoirEnteteVentes.getAvrEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.avoirEnteteVentes.getAvrAnal4(), this.avoirEnteteVentes.getAvrAnal4()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = true;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.avoirEnteteVentes.getAvrTotTtc()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.avoirEnteteVentes.getAvrId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
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
      if (this.avoirEnteteVentes != null && this.avoirEnteteVentes.getAvrSerie() != null && !this.avoirEnteteVentes.getAvrSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.avoirEnteteVentes.getAvrSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.avoirEnteteVentes != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.avoirEnteteVentes.getAvrId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.avoirEnteteVentes.getAvrDateTransfert() != null) {
            this.avoirEnteteVentes.setAvrDateTransfert((Date)null);
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes);
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.avoirEnteteVentes.getAvrActivite() != null && !this.avoirEnteteVentes.getAvrActivite().isEmpty() && this.avoirEnteteVentes.getAvrActivite().contains(":")) {
         String[] var1 = null;
         if (!this.avoirEnteteVentes.getAvrActivite().contains("#")) {
            var1 = this.avoirEnteteVentes.getAvrActivite().split(":");
            if (var1.length == 8) {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
               this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
               this.ecrituresAnalytiqueCtrl.setZoneCol1(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
               this.ecrituresAnalytiqueCtrl.setZoneCol2(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
               this.ecrituresAnalytiqueCtrl.setZoneCol3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.avoirEnteteVentes.getAvrActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 8) {
                  this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                  this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
                  this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
                  this.ecrituresAnalytiqueCtrl.setZoneCol1(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
                  this.ecrituresAnalytiqueCtrl.setZoneCol2(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
                  this.ecrituresAnalytiqueCtrl.setZoneCol3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
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
      if (this.ecrituresAnalytiqueCtrl.getZoneCol1() != null && !this.ecrituresAnalytiqueCtrl.getZoneCol1().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneCol1().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneCol1().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytiqueCtrl.getZoneCol2() != null && !this.ecrituresAnalytiqueCtrl.getZoneCol2().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneCol2().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneCol2().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytiqueCtrl.getZoneCol3() != null && !this.ecrituresAnalytiqueCtrl.getZoneCol3().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneCol3().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneCol3().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void calculPourcentage() {
      if (this.ecrituresAnalytiqueCtrl != null && this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise(this.avoirEnteteVentes.getAvrTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.avoirEnteteVentes.getAvrTotHt() - this.totalImputation;
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
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.avoirLigneVentes = new AvoirLigneVentes();
      this.avoirEnteteVentes.setUsers(this.usersLog);
      this.avoirEnteteVentes.setAvrIdCreateur(this.usersLog.getUsrid());
      this.avoirEnteteVentes.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.avoirEnteteVentes.setAvrDate(new Date());
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
      this.avoirEnteteVentes.setAvrDateLivraison((Date)null);
      this.avoirEnteteVentes.setAvrBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.avoirEnteteVentes.setAvrIdCommercial(this.usersLog.getUsrid());
         this.avoirEnteteVentes.setAvrNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.avoirEnteteVentes.setAvrIdResponsable(this.usersLog.getUsrid());
         this.avoirEnteteVentes.setAvrNomResponsable(this.usersLog.getUsrPatronyme());
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
      if (this.optionsVentes.getNbrJrRelanceAVOIR() != null && !this.optionsVentes.getNbrJrRelanceAVOIR().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceAVOIR());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidAVOIR() != null && !this.optionsVentes.getNbrJrValidAVOIR().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidAVOIR());
      } else {
         var4 = 0;
      }

      this.avoirEnteteVentes.setAvrDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.avoirEnteteVentes.setAvrDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.avoirEnteteVentes != null) {
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
            this.mesUsersItem.add(new SelectItem(this.avoirEnteteVentes.getAvrIdResponsable(), this.avoirEnteteVentes.getAvrNomResponsable()));
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
      if (this.avoirEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.avoirEnteteVentes.getAvrIdResponsable(), this.avoirEnteteVentes.getAvrNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.avoirEnteteVentes.getAvrEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.avoirEnteteVentes.setAvrEtat(1);
            this.avoirEnteteVentes.setAvrDateValide(new Date());
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle avoir (C.) N° " + this.avoirEnteteVentes.getAvrNum() + " du " + this.utilDate.dateToStringSQLLight(this.avoirEnteteVentes.getAvrDate()));
            this.espionDao.mAJEspion(var3, var1);
         }

         if (this.tiers.getTieDteDocument7() == null || this.avoirEnteteVentes.getAvrDate().after(this.tiers.getTieDteDocument7())) {
            this.tiers.setTieDteDocument7(this.avoirEnteteVentes.getAvrDate());
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

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.avoirEnteteVentes.getAvrEtat() == 1) {
            this.avoirEnteteVentes.setAvrEtat(0);
            this.avoirEnteteVentes.setAvrDateValide((Date)null);
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle avoir (C.) N° " + this.avoirEnteteVentes.getAvrNum() + " du " + this.utilDate.dateToStringSQLLight(this.avoirEnteteVentes.getAvrDate()));
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

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.avoirEnteteVentes != null) {
         this.avoirEnteteVentes.setAvrEtat(0);
         this.avoirEnteteVentes.setAvrDateAnnule((Date)null);
         this.avoirEnteteVentes.setAvrMotifAnnule("");
         this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.avoirEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         long var3 = this.avoirEnteteVentes.getAvrId();
         String var5 = this.avoirEnteteVentes.getAvrNum();
         Date var6 = this.avoirEnteteVentes.getAvrDate();
         this.avoirLigneVentesDao.deleteAllLigne(this.avoirEnteteVentes, var1);
         this.utilParapheur.supprimerParapheur(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
         this.avoirEnteteVentesDao.delete(this.avoirEnteteVentes.getAvrId(), var1);
         this.documentTraceVentes = new DocumentTraceVentes();
         this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(var3, this.nature, var1);
         if (this.documentTraceVentes != null) {
            long var7 = this.documentTraceVentes.getDoctraOrgId();
            int var9 = this.documentTraceVentes.getDoctraOrgType();
            this.documentTraceVentesDao.delete(this.documentTraceVentes, var1);
            boolean var10 = false;
            this.documentTraceVentes = this.documentTraceVentesDao.chercherOrigineTrace(var7, var9, var1);
            if (this.documentTraceVentes != null) {
               var10 = true;
            } else {
               var10 = true;
            }

            if (var9 == 24) {
               new RetourEnteteVentes();
               RetourEnteteVentesDao var12 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               RetourEnteteVentes var11 = var12.pourParapheur(var7, var1);
               if (var11 != null) {
                  var11.setBrtNumAvoir("");
                  var11.setBrtEtat(1);
                  var12.modif(var11, var1);
               }
            }
         }

         Espion var18 = new Espion();
         var18.setUsers(this.usersLog);
         var18.setEsptype(0);
         var18.setEspdtecreat(new Date());
         var18.setEspaction("Suppression Avoir N° " + var5 + " du " + var6);
         this.espionDao.mAJEspion(var18, var1);
         var2.commit();
      } catch (HibernateException var16) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.avoirEnteteVentes.getAvrId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.avoirEnteteVentes.setUsers(this.usersLog);
            this.avoirEnteteVentes.setAvrIdCreateur(this.usersLog.getUsrid());
            this.avoirEnteteVentes.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.avoirEnteteVentes.setAvrDate(new Date());
            this.avoirEnteteVentes.setAvrDateCreat(new Date());
            this.avoirEnteteVentes.setAvrDateModif((Date)null);
            this.avoirEnteteVentes.setAvrIdModif(0L);
            this.avoirEnteteVentes.setAvrNomModif("");
            this.avoirEnteteVentes.setAvrNum("");
            this.avoirEnteteVentes.setAvrIdResponsable(this.usersLog.getUsrid());
            this.avoirEnteteVentes.setAvrNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            this.avoirEnteteVentes.setAvrDateLivraison((Date)null);
            if (!this.avoirEnteteVentes.getAvrSerie().equalsIgnoreCase("X") && !this.avoirEnteteVentes.getAvrSerie().isEmpty()) {
               this.avoirEnteteVentes.setAvrNum(this.calculChrono.numCompose(this.avoirEnteteVentes.getAvrDate(), this.nature, this.avoirEnteteVentes.getAvrSerie(), var1));
            } else {
               long var3 = this.avoirEnteteVentesDao.selectLastNum(var1);
               this.avoirEnteteVentes.setAvrNum("" + var3);
            }

            this.verifieExistenceHabilitation(var1);
            this.avoirEnteteVentes.setAvrDateAnnule((Date)null);
            this.avoirEnteteVentes.setAvrMotifAnnule("");
            this.avoirEnteteVentes.setAvrDateImp((Date)null);
            this.avoirEnteteVentes.setAvrDateTransforme((Date)null);
            this.avoirEnteteVentes.setAvrDateTransfert((Date)null);
            this.avoirEnteteVentes.setAvrDateLastReg((Date)null);
            this.avoirEnteteVentes.setAvrTotReglement(0.0D);
            this.avoirEnteteVentes.setAvrSolde(0);
            this.avoirEnteteVentes.setAvrEtat(0);
            this.avoirEnteteVentes.setAvrContener("");
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.duppliquer(this.avoirEnteteVentes, var1);
            if (this.lesLignesList.size() != 0) {
               this.avoirLigneVentesDao.duppliquerLigne(this.lesLignesList, this.avoirEnteteVentes, var1);
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
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.avoirEnteteVentes.getAvrId(), this.avoirEnteteVentes.getAvrNum(), this.avoirEnteteVentes.getAvrNomTiers(), this.avoirEnteteVentes.getAvrDate(), this.avoirEnteteVentes.getAvrDevise(), this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc(), this.avoirEnteteVentes.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.avoirEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
      }

   }

   public void razNumreoPortefeuille() {
      this.numeroPfManuel = "";
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
      if (this.avoirEnteteVentes.getAvrTypeReg() != 0 && this.avoirEnteteVentes.getAvrTypeReg() != 3) {
         if (this.avoirEnteteVentes.getAvrTypeReg() != 1 && this.avoirEnteteVentes.getAvrTypeReg() != 2 && this.avoirEnteteVentes.getAvrTypeReg() != 10) {
            if (this.avoirEnteteVentes.getAvrTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.avoirEnteteVentes.getAvrModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.avoirEnteteVentes.getAvrModeReg() != null && !this.avoirEnteteVentes.getAvrModeReg().isEmpty() && this.avoirEnteteVentes.getAvrModeReg().contains(":")) {
         String[] var2 = this.avoirEnteteVentes.getAvrModeReg().split(":");
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

            this.avoirEnteteVentes.setAvrTypeReg(Integer.parseInt(var3.getEcheances()));
            this.avoirEnteteVentes.setAvrModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.avoirEnteteVentes.setAvrNbJourReg(0);
            this.avoirEnteteVentes.setAvrArrondiReg(0);
            break;
         }
      }

      if (this.avoirEnteteVentes.getAvrTypeReg() != 0 && this.avoirEnteteVentes.getAvrTypeReg() != 3) {
         if (this.avoirEnteteVentes.getAvrTypeReg() != 1 && this.avoirEnteteVentes.getAvrTypeReg() != 2 && this.avoirEnteteVentes.getAvrTypeReg() != 10) {
            if (this.avoirEnteteVentes.getAvrTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.avoirEnteteVentes.setAvrTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.avoirEnteteVentes.setAvrModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.avoirEnteteVentes.setAvrNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.avoirEnteteVentes.setAvrArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.avoirEnteteVentes.getAvrModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.avoirEnteteVentes.getAvrDate(), this.avoirEnteteVentes.getAvrTypeReg(), this.avoirEnteteVentes.getAvrNbJourReg(), this.avoirEnteteVentes.getAvrArrondiReg());
      this.avoirEnteteVentes.setAvrDateEcheReg(var1);
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
         if (this.avoirEnteteVentes.getAvrId() != 0L) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.avoirEnteteVentes.setAvrDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.avoirEnteteVentes.getUsers() == null) {
            this.avoirEnteteVentes.setUsers(this.usersLog);
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

         if (!this.contDest) {
            if (this.avoirEnteteVentes.getAvrDiversTiers() == 99) {
               this.avoirEnteteVentes.setAvrIdContact(0L);
               this.avoirEnteteVentes.setAvrNomContact("");
               this.avoirEnteteVentes.setAvrCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.avoirEnteteVentes.setAvrIdContact(var3.getConid());
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.avoirEnteteVentes.setAvrNomContact(var3.getConpatronyme());
                     this.avoirEnteteVentes.setAvrCivilContact(var3.getConcivilite());
                  } else if (var3.getConservice() != null && !var3.getConservice().isEmpty()) {
                     this.avoirEnteteVentes.setAvrNomContact(var3.getConservice());
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
            }

            this.avoirEnteteVentes.setAvrTiersRegroupe(this.tiers.getTiesigle());
         }

         this.avoirEnteteVentes.setAvrIdResponsable(0L);
         this.avoirEnteteVentes.setAvrNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.avoirEnteteVentes.setAvrIdResponsable(var15.getUsrid());
            this.avoirEnteteVentes.setAvrNomResponsable(var15.getUsrPatronyme());
         }

         this.avoirEnteteVentes.setAvrIdCommercial(0L);
         this.avoirEnteteVentes.setAvrNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.avoirEnteteVentes.setAvrIdCommercial(var4.getUsrid());
               this.avoirEnteteVentes.setAvrNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.avoirEnteteVentes.setAvrIdEquipe(0L);
         this.avoirEnteteVentes.setAvrNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.avoirEnteteVentes.getAvrIdResponsable(), var1);
            if (this.equipes != null) {
               this.avoirEnteteVentes.setAvrIdEquipe(this.equipes.getEquId());
               this.avoirEnteteVentes.setAvrNomEquipe(this.equipes.getEquNomFr());
            }
         }

         int var16;
         if (this.var_timbre != 0) {
            var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc(), var16, this.avoirEnteteVentes.getAvrDevise(), this.avoirEnteteVentes.getAvrDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.avoirEnteteVentes.getAvrDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.avoirEnteteVentes.getAvrDevise());
               this.avoirEnteteVentes.setAvrFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.avoirEnteteVentes.getAvrDevise(), this.avoirEnteteVentes.getAvrDate()));
            }
         }

         if (this.accesAffaires) {
         }

         if (this.avoirEnteteVentes.getAvrId() != 0L) {
            if (this.avoirEnteteVentes.getAvrEtat() == 6) {
               if (this.avoirEnteteVentes.getAvrEtatVal() == 1) {
                  this.avoirEnteteVentes.setAvrEtat(0);
               } else {
                  this.avoirEnteteVentes.setAvrEtat(0);
               }
            }

            this.avoirEnteteVentes.setAvrDateModif(new Date());
            this.avoirEnteteVentes.setAvrIdModif(this.usersLog.getUsrid());
            this.avoirEnteteVentes.setAvrNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var16 = 0; var16 < this.lesLignesList.size(); ++var16) {
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var16);
               this.avoirLigneVentes.setAvrligOrdre(var16);
               this.avoirLigneVentes.setAvoirEnteteVentes(this.avoirEnteteVentes);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var1);
            }
         } else {
            this.avoirEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.avoirEnteteVentes.setAvrDateCreat(new Date());
            this.avoirEnteteVentes.setAvrIdCreateur(this.usersLog.getUsrid());
            this.avoirEnteteVentes.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.avoirEnteteVentes.getAvrSerie() != null && !this.avoirEnteteVentes.getAvrSerie().equalsIgnoreCase("X") && !this.avoirEnteteVentes.getAvrSerie().isEmpty()) {
               this.avoirEnteteVentes.setAvrNum(this.calculChrono.numCompose(this.avoirEnteteVentes.getAvrDate(), this.nature, this.avoirEnteteVentes.getAvrSerie(), var1));
               boolean var18 = false;

               label402:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label402;
                     }

                     new AvoirEnteteVentes();
                     AvoirEnteteVentes var19 = this.avoirEnteteVentesDao.pourParapheur(this.avoirEnteteVentes.getAvrNum(), this.avoirEnteteVentes.getAvrSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.avoirEnteteVentes.setAvrNum(this.calculChrono.numCompose(this.avoirEnteteVentes.getAvrDate(), this.nature, this.avoirEnteteVentes.getAvrSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.avoirEnteteVentesDao.selectLastNum(var1);
               this.avoirEnteteVentes.setAvrNum("" + var17);
            }

            this.avoirEnteteVentes.setAvrEtat(0);
            this.avoirEnteteVentes.setAvrEtatVal(0);
            this.avoirEnteteVentes.setAvrDateValide((Date)null);
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.insert(this.avoirEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.avoirEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.avoirEnteteVentes.getAvrId(), this.avoirEnteteVentes.getAvrNum(), this.avoirEnteteVentes.getAvrNomTiers(), this.avoirEnteteVentes.getAvrDate(), this.avoirEnteteVentes.getAvrDevise(), this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc(), this.avoirEnteteVentes.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.avoirEnteteVentes.getVar_format_devise(), 0, var1);
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
      if (this.avoirEnteteVentes != null && this.avoirEnteteVentes.getAvrId() != 0L) {
         this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes);
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.avoirEnteteVentes.setAvrSite(this.usersLog.getUsrSite());
      this.avoirEnteteVentes.setAvrDepartement(this.usersLog.getUsrDepartement());
      this.avoirEnteteVentes.setAvrService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.avoirEnteteVentes.setAvrIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.avoirEnteteVentes.getAvrNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.avoirEnteteVentes.setAvrTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.avoirEnteteVentes.setAvrRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.avoirEnteteVentes.setAvrSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.avoirEnteteVentes.setAvrPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.avoirEnteteVentes.setAvrTiersRegroupe(this.tiers.getTiesigle());
            this.avoirEnteteVentes.setAvrRegion(this.tiers.getTieregion());
            this.avoirEnteteVentes.setAvrSecteur(this.tiers.getTiesecteur());
            this.avoirEnteteVentes.setAvrPdv(this.tiers.getTiepdv());
         }
      } else {
         this.avoirEnteteVentes.setAvrTiersRegroupe(this.tiers.getTiesigle());
         this.avoirEnteteVentes.setAvrRegion(this.tiers.getTieregion());
         this.avoirEnteteVentes.setAvrSecteur(this.tiers.getTiesecteur());
         this.avoirEnteteVentes.setAvrPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.avoirEnteteVentes.setAvrActivite("");
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

               this.avoirEnteteVentes.setAvrActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new AvoirLigneVentes();
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

                  AvoirLigneVentes var13 = (AvoirLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getAvrligCode() != null && !var13.getAvrligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getAvrligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getAvrligPt());
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
                              var7.setPrix(var13.getAvrligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getAvrligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.avoirEnteteVentes.setAvrActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.avoirEnteteVentes.setAvrAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.avoirEnteteVentes.getAvrAnal4() != null && this.avoirEnteteVentes.getAvrAnal4().length() <= 2) {
         this.avoirEnteteVentes.setAvrAnal4("");
      }

      if (!this.var_anal_parc) {
         this.avoirEnteteVentes.setAvrAnal2("");
      } else if (this.avoirEnteteVentes.getAvrAnal2() != null && this.avoirEnteteVentes.getAvrAnal2().length() <= 2) {
         this.avoirEnteteVentes.setAvrAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.avoirEnteteVentes.setAvrEtatVal(1);
         this.avoirEnteteVentes.setAvrEtat(0);
         this.avoirEnteteVentes.setAvrDateValide((Date)null);
         return true;
      } else {
         this.avoirEnteteVentes.setAvrEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.avoirEnteteVentes.setAvrEtat(1);
               this.avoirEnteteVentes.setAvrDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.avoirEnteteVentes.setAvrEtat(0);
               this.avoirEnteteVentes.setAvrDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.avoirEnteteVentes != null) {
         this.avoirEnteteVentes.setAvrDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.avoirEnteteVentes != null) {
         if (this.avoirEnteteVentes.getAvrDateAnnule() == null) {
            this.avoirEnteteVentes.setAvrDateAnnule(new Date());
         }

         this.avoirEnteteVentes.setAvrEtat(3);
         this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation avoir vente N° " + this.avoirEnteteVentes.getAvrNum() + " le " + this.avoirEnteteVentes.getAvrDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.avoirEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.avoirEnteteVentes.getAvrExoTva() == 0) {
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

      this.avoirLigneVentes.setAvrligTaxe(var6);
      this.avoirLigneVentes.setAvrligTauxTaxe(var5);
      double var35 = this.avoirLigneVentes.getAvrligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.avoirEnteteVentes.getAvrDevise());
      }

      var10 = this.avoirLigneVentes.getAvrligQte();
      if (this.avoirLigneVentes.getAvrligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.avoirLigneVentes.setAvrligQteUtil(this.avoirLigneVentes.getAvrligQte());
            var10 = this.avoirLigneVentes.getAvrligQte() * this.avoirLigneVentes.getAvrligLong();
         } else {
            this.avoirLigneVentes.setAvrligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.avoirLigneVentes.getAvrligCondition(), this.avoirLigneVentes.getAvrligQte(), this.avoirLigneVentes.getAvrligLong(), this.avoirLigneVentes.getAvrligLarg(), this.avoirLigneVentes.getAvrligHaut(), this.avoirLigneVentes.getAvrligDiam(), this.avoirLigneVentes.getAvrligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.avoirLigneVentes.setAvrligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && this.avoirLigneVentes.getAvrligCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.avoirLigneVentes.getAvrligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.avoirLigneVentes.getAvrligRabais() * (double)this.avoirLigneVentes.getAvrligQte();
      }

      if (this.avoirLigneVentes.getAvrligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.avoirLigneVentes.getAvrligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.avoirLigneVentes.getAvrligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.avoirLigneVentes.getAvrligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && this.avoirLigneVentes.getAvrligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.avoirLigneVentes.getAvrligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.avoirLigneVentes.getAvrligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.avoirLigneVentes.getAvrligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.avoirLigneVentes.getAvrligQte(), 2);
      }

      this.avoirLigneVentes.setAvrligPuRem(var25);
      this.avoirLigneVentes.setAvrligPt(var17);
      this.avoirLigneVentes.setAvrligTva(var21);
      this.avoirLigneVentes.setAvrligTc(0.0D);
      this.avoirLigneVentes.setAvrligTtc(var23);
      double var27 = 0.0D;
      if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && this.avoirLigneVentes.getAvrligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.avoirLigneVentes.getAvrligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.avoirLigneVentes.getAvrligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.avoirLigneVentes.getAvrligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.avoirLigneVentes.getAvrligQte(), 2);
      }

      this.avoirLigneVentes.setAvrligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.avoirLigneVentes.getAvrligTauxTaxe() / 100.0D;
      this.avoirLigneVentes.setAvrligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.avoirEnteteVentes.setAvrTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.avoirLigneVentes.setAvrligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
               if (this.avoirLigneVentes.getAvrligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.avoirLigneVentes.getAvrligTauxTaxe() / 100.0D;
                  this.avoirLigneVentes.setAvrligTc(var33);
               }
            }
         } else {
            if (this.avoirLigneVentes.getAvrligTva() != 0.0D) {
               var31 = var17 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.avoirLigneVentes.setAvrligTc(var33);
         }
      } else {
         this.avoirLigneVentes.setAvrligTc(0.0D);
         this.avoirEnteteVentes.setAvrTauxTc(0.0F);
      }

      this.avoirLigneVentes.setAvrligPt(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligPt(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTva(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTva(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTtc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTtc(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTc(), this.avoirEnteteVentes.getAvrDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.avoirEnteteVentes.getAvrExoTva() == 0) {
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

      this.avoirLigneVentes.setAvrligTaxe(var6);
      this.avoirLigneVentes.setAvrligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.avoirEnteteVentes.getAvrTauxTc() != 0.0F && this.avoirLigneVentes.getAvrligTva() != 0.0D) {
         var10 = this.avoirLigneVentes.getAvrligTtc();
         var12 = var10 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.avoirLigneVentes.getAvrligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.avoirLigneVentes.getAvrligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.avoirLigneVentes.setAvrligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.avoirLigneVentes.getAvrligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.avoirLigneVentes.getAvrligRabais() * (double)this.avoirLigneVentes.getAvrligQte();
      }

      double var14 = 0.0D;
      if (this.avoirLigneVentes.getAvrligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.avoirLigneVentes.getAvrligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.avoirLigneVentes.getAvrligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.avoirLigneVentes.getAvrligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.avoirLigneVentes.getAvrligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.avoirLigneVentes.setAvrligQteUtil(this.avoirLigneVentes.getAvrligQte());
         } else {
            this.avoirLigneVentes.setAvrligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.avoirLigneVentes.getAvrligCondition(), this.avoirLigneVentes.getAvrligQte(), this.avoirLigneVentes.getAvrligLong(), this.avoirLigneVentes.getAvrligLarg(), this.avoirLigneVentes.getAvrligHaut(), this.avoirLigneVentes.getAvrligDiam(), this.avoirLigneVentes.getAvrligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.avoirLigneVentes.setAvrligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.avoirLigneVentes.getAvrligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.avoirEnteteVentes.getAvrDevise()));
      double var26 = var20 * (double)this.avoirLigneVentes.getAvrligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.avoirEnteteVentes.getAvrDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligPuRem(var18);
      this.avoirLigneVentes.setAvrligPuRemTtc(var20);
      this.avoirLigneVentes.setAvrligPt(var24);
      this.avoirLigneVentes.setAvrligTva(var32);
      this.avoirLigneVentes.setAvrligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.avoirEnteteVentes.setAvrTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.avoirLigneVentes.setAvrligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
               if (this.avoirLigneVentes.getAvrligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.avoirLigneVentes.getAvrligTauxTaxe() / 100.0D;
                  this.avoirLigneVentes.setAvrligTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.avoirEnteteVentes.getAvrTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.avoirLigneVentes.setAvrligTc(var36);
         }
      } else {
         this.avoirLigneVentes.setAvrligTc(0.0D);
         this.avoirEnteteVentes.setAvrTauxTc(0.0F);
      }

      this.avoirLigneVentes.setAvrligPt(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligPt(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTva(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTva(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTtc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTtc(), this.avoirEnteteVentes.getAvrDevise()));
      this.avoirLigneVentes.setAvrligTc(this.utilNombre.myRoundDevise(this.avoirLigneVentes.getAvrligTc(), this.avoirEnteteVentes.getAvrDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.avoirLigneVentes != null && this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.avoirLigneVentes.getAvrligPuRemTtc() != 0.0D) {
               if (this.avoirLigneVentes.getAvrligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.avoirLigneVentes.getAvrligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.avoirLigneVentes.getAvrligPuRem() != 0.0D) {
            if (this.avoirLigneVentes.getAvrligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.avoirLigneVentes.getAvrligPu() < this.prixPlancher) {
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
         new AvoirLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            AvoirLigneVentes var13 = (AvoirLigneVentes)this.lesLignesList.get(var14);
            if (var13.getAvrligGroupe() == null || var13.getAvrligGroupe().isEmpty()) {
               var3 += var13.getAvrligPt();
               var5 += var13.getAvrligTva();
               var7 += var13.getAvrligTtc();
               var9 += var13.getAvrligTc();
               if (var13.getAvrligRabais() != 0.0D || var13.getAvrligTauxRemise() != 0.0F) {
                  var11 += var13.getAvrligPu() * (double)var13.getAvrligQte() - var13.getAvrligPt();
               }

               var1 = var1 + var13.getAvrligPt() - var13.getAvrligPump() * (double)var13.getAvrligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.avoirEnteteVentes.setAvrTotHt(var3);
      this.avoirEnteteVentes.setAvrTotTva(var5);
      this.avoirEnteteVentes.setAvrTotTtc(var7);
      this.avoirEnteteVentes.setAvrTotRemise(var11);
      this.avoirEnteteVentes.setAvrTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.avoirLigneVentes = (AvoirLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         if (this.avoirLigneVentes.getAvrligCode() != null && this.avoirLigneVentes.getAvrligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.avoirLigneVentes.getAvrligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.avoirLigneVentes.setAvrligCode(this.produits.getProCode());
               this.avoirLigneVentes.setAvrligFamille(this.produits.getProAchCode());
               this.avoirLigneVentes.setAvrligStock(this.produits.getProStock());
               this.avoirLigneVentes.setAvrligLong(this.produits.getProLongueur());
               this.avoirLigneVentes.setAvrligLarg(this.produits.getProLargeur());
               this.avoirLigneVentes.setAvrligHaut(this.produits.getProEpaisseur());
               this.avoirLigneVentes.setAvrligDiam(this.produits.getProDiamExt());
               this.avoirLigneVentes.setAvrligPoidsBrut(this.produits.getProPoidsBrut());
               this.avoirLigneVentes.setAvrligPoidsNet(this.produits.getProPoidsNet());
               this.avoirLigneVentes.setAvrligVolume(this.produits.getProVolume());
               this.avoirLigneVentes.setAvrligNb(this.produits.getProNbUnite());
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
               if (this.avoirLigneVentes.getAvrligTaxe() != null && !this.avoirLigneVentes.getAvrligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTaxe() + ":" + this.avoirLigneVentes.getAvrligTauxTaxe()));
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
         this.avoirLigneVentes = (AvoirLigneVentes)this.datamodelLigne.getRowData();
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
      this.avoirLigneVentes = new AvoirLigneVentes();
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
      if (this.avoirLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.avoirLigneVentes);
            this.lesLignesList.add(this.numLigne, this.avoirLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var3);
               this.avoirLigneVentes.setAvrligOrdre(var3);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var1);
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
      if (this.avoirLigneVentes != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.avoirLigneVentes);
            this.lesLignesList.add(this.numLigne, this.avoirLigneVentes);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var3);
               this.avoirLigneVentes.setAvrligOrdre(var3);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var1);
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
            if (this.avoirLigneVentes.getAvrligId() == ((AvoirLigneVentes)this.lesLignesList.get(var2)).getAvrligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() || this.avoirLigneVentes.getAvrligLibelle() != null && !this.avoirLigneVentes.getAvrligLibelle().isEmpty() || this.avoirLigneVentes.getAvrligComplement() != null && !this.avoirLigneVentes.getAvrligComplement().isEmpty()) {
         if (this.avoirEnteteVentes.getAvrId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.avoirLigneVentes.getAvrligQteUtil() == 0.0F) {
               this.avoirLigneVentes.setAvrligQteUtil(this.avoirLigneVentes.getAvrligQte());
            }

            this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.avoirLigneVentes.setAvrligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.avoirLigneVentes.setAvrligDepot(var3[0]);
               }
            } else {
               this.avoirLigneVentes.setAvrligDepot("");
            }

            if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && this.avoirLigneVentes.getAvrligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.avoirLigneVentes.getAvrligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.avoirLigneVentes.setAvrligDescription(var5);
               } else {
                  this.avoirLigneVentes.setAvrligDescription("");
               }

               if (this.avoirLigneVentes.getAvrligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.avoirLigneVentes.setAvrligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.avoirLigneVentes.setAvrligDescription("");
            }

            if (this.avoirLigneVentes.getAvrligId() == 0L) {
               this.avoirLigneVentes.setAvoirEnteteVentes(this.avoirEnteteVentes);
               this.avoirLigneVentes.setAvrligDevise(this.avoirEnteteVentes.getAvrDevise());
               this.avoirLigneVentes = this.avoirLigneVentesDao.insertLigne(this.avoirLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.avoirLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new AvoirLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  AvoirLigneVentes var16 = (AvoirLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getAvrligGroupe() != null && !var16.getAvrligGroupe().isEmpty() && var16.getAvrligGroupe().equals(this.memoProduits.getProCode())) {
                     this.avoirLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.avoirLigneVentes.getAvrligQte();
               new AvoirLigneVentes();

               AvoirLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (AvoirLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getAvrligGroupe() != null && !var19.getAvrligGroupe().isEmpty() && var19.getAvrligGroupe().equals(var18)) {
                     this.avoirLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new AvoirLigneVentes();
                     var19.setAvrligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setAvrligCondition("");
                     var19.setAvrligComplement("");
                     var19.setAvrligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setAvrligDescription("");
                     var19.setAvrligDevise(this.avoirEnteteVentes.getAvrDevise());
                     var19.setAvrligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setAvrligEchelle(0);
                     var19.setAvrligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setAvrligGroupe(var18);
                     var19.setAvrligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setAvrligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setAvrligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setAvrligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setAvrligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setAvrligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setAvrligOrdre(var8);
                     var19.setAvrligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setAvrligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setAvrligPt(0.0D);
                     var19.setAvrligPu(0.0D);
                     var19.setAvrligPuRem(0.0D);
                     var19.setAvrligPuRemTtc(0.0D);
                     var19.setAvrligPuTtc(0.0D);
                     var19.setAvrligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setAvrligQte(var9);
                     var19.setAvrligQteUtil(var19.getAvrligQte());
                     var19.setAvrligRabais(0.0D);
                     var19.setAvrligReference(var18);
                     var19.setAvrligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setAvrligTauxRemise(0.0F);
                     var19.setAvrligTauxTaxe(0.0F);
                     var19.setAvrligTaxe("");
                     var19.setAvrligTc(0.0D);
                     var19.setAvrligTtc(0.0D);
                     var19.setAvrligTva(0.0D);
                     var19.setAvrligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setAvrligVolume(0.0F);
                     var19.setAvoirEnteteVentes(this.avoirEnteteVentes);
                     var19 = this.avoirLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
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
      if (this.avoirLigneVentes.getAvrligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.avoirLigneVentes.getAvrligCode();
            int var4 = this.avoirLigneVentes.getAvrligModeGroupe();
            String var5 = this.avoirLigneVentes.getAvrligGroupe();
            this.avoirLigneVentesDao.deleteOneLigne(this.avoirLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new AvoirLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  AvoirLigneVentes var6 = (AvoirLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getAvrligGroupe() != null && !var6.getAvrligGroupe().isEmpty() && var6.getAvrligGroupe().equals(var3)) {
                     this.avoirLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " de l'Avoir N° " + this.avoirEnteteVentes.getAvrNum() + " du " + this.avoirEnteteVentes.getAvrDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.avoirEnteteVentes.getAvrNomTiers(), this.nature);
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
                     this.avoirEnteteVentes.setAvrSerie(this.tiers.getTieserie());
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
            this.avoirEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.avoirEnteteVentes.setAvrCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.avoirEnteteVentes.setAvrCivilTiers(this.avoirEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.avoirEnteteVentes.setAvrNomTiers(this.nomTier);
            this.avoirEnteteVentes.setAvrTypeReg(this.tiers.getTietypereg());
            this.avoirEnteteVentes.setAvrModeReg(this.tiers.getTiemodereg());
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
               this.avoirEnteteVentes.setAvrNbJourReg(this.tiers.getTienbecheance());
               this.avoirEnteteVentes.setAvrArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.avoirEnteteVentes.setAvrTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.avoirEnteteVentes.setAvrModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.avoirEnteteVentes.setAvrNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.avoirEnteteVentes.setAvrArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.avoirEnteteVentes.setAvrJournalReg(this.tiers.getTiejournalreg());
            this.avoirEnteteVentes.setAvrCat(this.tiers.getTienomfamille());
            this.avoirEnteteVentes.setAvrExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.avoirEnteteVentes.setAvrExoDouane(1);
            }

            var9 = this.tiers.getTieexotva();
            if (var9 >= 2) {
               var9 = 0;
            }

            this.avoirEnteteVentes.setAvrExoTva(var9);
            if (this.var_tc_calcul) {
               this.avoirEnteteVentes.setAvrTauxTc(this.var_tc_taux);
            } else {
               this.avoirEnteteVentes.setAvrTauxTc(0.0F);
            }

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.avoirEnteteVentes.setAvrExoTva(1);
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
      this.avoirEnteteVentes.setTiers(this.tiers);
      this.avoirEnteteVentes.setAvrNomTiers("");
      this.avoirEnteteVentes.setAvrCivilTiers("");
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
      if (!this.avoirEnteteVentes.getAvrNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.avoirEnteteVentes.getAvrCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.avoirEnteteVentes.setAvrExoTva(0);
      } else {
         this.avoirEnteteVentes.setAvrExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.avoirEnteteVentes.setAvrExoDouane(0);
      } else {
         this.avoirEnteteVentes.setAvrExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.avoirEnteteVentes.setAvrTauxTc(this.var_tc_taux);
      } else {
         this.avoirEnteteVentes.setAvrTauxTc(0.0F);
      }

      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneVentes = new AvoirLigneVentes();
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var3);
               if (this.avoirEnteteVentes.getAvrExoTva() == 1) {
                  this.avoirLigneVentes.setAvrligTaxe("");
                  this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
                  this.avoirLigneVentes.setAvrligTva(0.0D);
               } else if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.avoirLigneVentes.getAvrligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
                        this.avoirLigneVentes.setAvrligTaxe("");
                        this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
                     } else {
                        if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                           this.avoirLigneVentes.setAvrligTaxe(var4.getProVteTva());
                        } else {
                           this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                           if (this.famillesProduitsVentes != null) {
                              this.avoirLigneVentes.setAvrligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                           }
                        }

                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.avoirLigneVentes.getAvrligTaxe(), var1);
                        if (var5 != null) {
                           this.avoirLigneVentes.setAvrligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
                        }
                     }
                  } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.avoirLigneVentes.setAvrligTaxe(this.optionsVentes.getTvaDefaut());
                        this.avoirLigneVentes.setAvrligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.avoirLigneVentes.setAvrligTaxe("");
                        this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
                     }
                  } else {
                     this.avoirLigneVentes.setAvrligTaxe("");
                     this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
                  }

                  if ((this.avoirLigneVentes.getAvrligTaxe() == null || this.avoirLigneVentes.getAvrligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.avoirLigneVentes.setAvrligTaxe(var5.getTaxvteCode());
                        this.avoirLigneVentes.setAvrligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var1);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var1);
            }
         }

         if (this.avoirEnteteVentes.getAvrExoTva() == 0) {
            this.avoirEnteteVentes.setAvrMotifExo("");
            this.avoirEnteteVentes.setAvrNumVisa("");
            this.avoirEnteteVentes.setAvrDateVisa((Date)null);
            this.avoirEnteteVentes.setAvrRangeVisa("");
         }

         if (this.avoirEnteteVentes.getAvrId() != 0L) {
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.avoirLigneVentes = new AvoirLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var3);
               this.avoirLigneVentes.setAvrligTauxRemise(this.avoirEnteteVentes.getAvrTauxRemise());
               this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var1);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var1);
            }
         }

         if (this.avoirEnteteVentes.getAvrId() != 0L) {
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.avoirEnteteVentes.getAvrNomContact(), this.nature);
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
         this.avoirEnteteVentes.setAvrNomContact(this.plansAnalytiques.getAnaNomFr());
         this.avoirEnteteVentes.setAvrCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.avoirEnteteVentes.setAvrAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.avoirEnteteVentes.setAvrNomContact("");
      this.avoirEnteteVentes.setAvrCivilContact("");
      this.avoirEnteteVentes.setAvrAnal4("");
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
      if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty() && !this.avoirLigneVentes.getAvrligCode().equals("-") && !this.avoirLigneVentes.getAvrligCode().equals("=")) {
         if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.avoirLigneVentes.getAvrligCode(), this.nature, this.optionsVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.avoirLigneVentes.getAvrligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         this.avoirLigneVentes.setAvrligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.avoirLigneVentes.setAvrligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.avoirLigneVentes.setAvrligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.avoirLigneVentes.setAvrligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.avoirLigneVentes.setAvrligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.avoirLigneVentes.setAvrligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.avoirLigneVentes.setAvrligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.avoirLigneVentes.setAvrligFamille(this.produits.getProVteCode());
         this.avoirLigneVentes.setAvrligStock(this.produits.getProStock());
         this.avoirLigneVentes.setAvrligLong(this.produits.getProLongueur());
         this.avoirLigneVentes.setAvrligLarg(this.produits.getProLargeur());
         this.avoirLigneVentes.setAvrligHaut(this.produits.getProEpaisseur());
         this.avoirLigneVentes.setAvrligDiam(this.produits.getProDiamExt());
         this.avoirLigneVentes.setAvrligPoidsBrut(this.produits.getProPoidsBrut());
         this.avoirLigneVentes.setAvrligPoidsNet(this.produits.getProPoidsNet());
         this.avoirLigneVentes.setAvrligVolume(this.produits.getProVolume());
         this.avoirLigneVentes.setAvrligNb(this.produits.getProNbUnite());
         this.avoirLigneVentes.setAvrligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.avoirLigneVentes.setAvrligModeGroupe(this.produits.getProMode());
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
                  this.avoirLigneVentes.setAvrligTaxe(this.produits.getProVteTva());
                  this.avoirLigneVentes.setAvrligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.avoirLigneVentes.setAvrligTaxe("");
                  this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.avoirLigneVentes.setAvrligTaxe(var8.getFamvteTaxe());
                  this.avoirLigneVentes.setAvrligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.avoirLigneVentes.setAvrligTaxe("");
               this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.avoirEnteteVentes.getAvrExoTva() == 0 && (this.avoirLigneVentes.getAvrligTaxe() == null || this.avoirLigneVentes.getAvrligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.avoirLigneVentes.setAvrligTaxe(var9.getTaxvteCode());
                  this.avoirLigneVentes.setAvrligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.avoirLigneVentes.setAvrligTaxe("");
            this.avoirLigneVentes.setAvrligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.avoirLigneVentes.getAvrligTauxTaxe() / 100.0D;
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
               this.avoirLigneVentes.setAvrligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.avoirLigneVentes.setAvrligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.avoirLigneVentes.setAvrligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.avoirLigneVentes.setAvrligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.avoirLigneVentes.setAvrligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.avoirLigneVentes.getAvrligPump() != 0.0D) {
            this.avoirLigneVentes.setAvrligPu(this.avoirLigneVentes.getAvrligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var1);
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
      if ((this.avoirLigneVentes.getAvrligCode() == null || this.avoirLigneVentes.getAvrligCode().isEmpty() || this.avoirLigneVentes.getAvrligCode().length() < 2) && this.avoirEnteteVentes.getAvrExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0 && this.mesTaxesVentesProduits.isEmpty()) {
         this.mesTaxesVentesProduits.clear();
         if (this.mesTaxesVentesItems.size() != 0) {
            for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
               this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
            }
         }

         if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            this.avoirLigneVentes.setAvrligTaxe(this.optionsVentes.getTvaDefaut());
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.avoirLigneVentes.setAvrligCode("");
      this.avoirLigneVentes.setAvrligLibelle("");
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
            var2 = this.avoirLigneVentes.getAvrligPuTtc();
         } else {
            var2 = this.avoirLigneVentes.getAvrligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.avoirLigneVentes.setAvrligPuTtc(this.prixUnitaires);
            this.avoirLigneVentes.setAvrligPuRemTtc(this.prixUnitaires);
         } else {
            this.avoirLigneVentes.setAvrligPu(this.prixUnitaires);
            this.avoirLigneVentes.setAvrligPuRem(this.prixUnitaires);
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
                     this.avoirLigneVentes.setAvrligTauxRemise(var6.getBarRemise());
                     this.avoirLigneVentes.setAvrligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.avoirEnteteVentes.getAvrDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.avoirLigneVentes.setAvrligPuTtc(this.prixUnitaires);
                        this.avoirLigneVentes.setAvrligPuRemTtc(var11);
                     } else {
                        this.avoirLigneVentes.setAvrligPu(this.prixUnitaires);
                        this.avoirLigneVentes.setAvrligPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.avoirLigneVentes.setAvrligTauxRemise(var6.getBarRemise());
                     this.avoirLigneVentes.setAvrligRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.avoirLigneVentes.getAvrligQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.avoirLigneVentes.setAvrligPuTtc(this.prixUnitaires);
                        this.avoirLigneVentes.setAvrligPuRemTtc(var11);
                     } else {
                        this.avoirLigneVentes.setAvrligPu(this.prixUnitaires);
                        this.avoirLigneVentes.setAvrligPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.avoirLigneVentes.setAvrligTauxRemise(var6.getBarRemise());
                     this.avoirLigneVentes.setAvrligRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.avoirLigneVentes.setAvrligPuTtc(this.prixUnitaires);
                        this.avoirLigneVentes.setAvrligPuRemTtc(this.prixUnitaires);
                     } else {
                        this.avoirLigneVentes.setAvrligPu(this.prixUnitaires);
                        this.avoirLigneVentes.setAvrligPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.avoirLigneVentes.setAvrligPuTtc(this.prixUnitaires);
                     this.avoirLigneVentes.setAvrligPuRemTtc(this.prixUnitaires);
                  } else {
                     this.avoirLigneVentes.setAvrligPu(this.prixUnitaires);
                     this.avoirLigneVentes.setAvrligPuRem(this.prixUnitaires);
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((AvoirLigneVentes)this.lesLignesList.get(var9)).getAvrligCode() == null || ((AvoirLigneVentes)this.lesLignesList.get(var9)).getAvrligCode().isEmpty() || !((AvoirLigneVentes)this.lesLignesList.get(var9)).getAvrligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((AvoirLigneVentes)this.lesLignesList.get(var9)).getAvrligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((AvoirLigneVentes)this.lesLignesList.get(var8)).getAvrligFamille() != null && !((AvoirLigneVentes)this.lesLignesList.get(var8)).getAvrligFamille().isEmpty() && ((AvoirLigneVentes)this.lesLignesList.get(var8)).getAvrligFamille().equals(var7)) {
                  var5 += ((AvoirLigneVentes)this.lesLignesList.get(var8)).getAvrligPt();
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
         double var2 = this.avoirLigneVentes.getAvrligPu();
         double var4 = this.avoirLigneVentes.getAvrligPuTtc();
         if (this.avoirLigneVentes.getAvrligPu() >= 0.0D && this.avoirLigneVentes.getAvrligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.avoirEnteteVentes.getAvrCat(), (String)null, var1);
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
                     if (this.avoirLigneVentes.getAvrligQte() >= var7.getQteDebut() && this.avoirLigneVentes.getAvrligQte() <= var7.getQteFin()) {
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
                        if (this.avoirLigneVentes.getAvrligQte() >= var7.getQteDebut() && this.avoirLigneVentes.getAvrligQte() <= var7.getQteFin()) {
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
            var2 = Math.abs(this.avoirLigneVentes.getAvrligPu());
            var4 = Math.abs(this.avoirLigneVentes.getAvrligPuTtc());
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
      this.avoirLigneVentes.setAvrligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && this.avoirLigneVentes.getAvrligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.avoirLigneVentes.getAvrligEchelle());
            float var5 = 1.0F;
            if (this.avoirLigneVentes.getAvrligCondition().contains("/")) {
               String[] var6 = this.avoirLigneVentes.getAvrligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && !this.avoirLigneVentes.getAvrligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.avoirLigneVentes.getAvrligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.avoirLigneVentes.setAvrligPump(var9);
      } else {
         this.avoirLigneVentes.setAvrligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.avoirLigneVentes.getAvrligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.avoirLigneVentes.setAvrligEchelle(this.unite.getUniEchelle());
               } else {
                  this.avoirLigneVentes.setAvrligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.avoirLigneVentes.setAvrligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.avoirLigneVentes.setAvrligEchelle(Integer.parseInt(var2));
         } else {
            this.avoirLigneVentes.setAvrligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.avoirLigneVentes.getAvrligLong(), this.avoirLigneVentes.getAvrligLarg(), this.avoirLigneVentes.getAvrligHaut(), this.avoirLigneVentes.getAvrligDiam(), this.avoirLigneVentes.getAvrligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.avoirLigneVentes.getAvrligLong(), this.avoirLigneVentes.getAvrligLarg(), this.avoirLigneVentes.getAvrligHaut(), this.avoirLigneVentes.getAvrligDiam(), this.avoirLigneVentes.getAvrligNb(), this.baseLog, var1);
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

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.avoirEnteteVentes.getAvrSerie();
      this.var_imput_cat = this.avoirEnteteVentes.getAvrCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new AvoirEnteteVentes();
         AvoirEnteteVentes var1 = this.avoirEnteteVentesDao.pourParapheur(this.var_imput_num, this.avoirEnteteVentes.getAvrSerie(), (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.avoirEnteteVentes.getAvrNum();
               this.avoirEnteteVentes.setAvrNum(this.var_imput_num);
               this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
               if (this.avoirEnteteVentes.getAvrTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.avoirEnteteVentes.getAvrNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.avoirEnteteVentes.getAvrNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Avoir N° " + var3 + " en Avoir N° " + this.avoirEnteteVentes.getAvrNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.avoirEnteteVentes.getAvrNum();
            this.avoirEnteteVentes.setAvrSerie(this.var_imput_serie);
            this.avoirEnteteVentes.setAvrCat(this.var_imput_cat);
            this.avoirEnteteVentes.setAvrNum(this.calculChrono.numCompose(this.avoirEnteteVentes.getAvrDate(), this.nature, this.avoirEnteteVentes.getAvrSerie(), var1));
            this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
            if (this.avoirEnteteVentes.getAvrTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.avoirEnteteVentes.getAvrNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.avoirEnteteVentes.getAvrId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.avoirEnteteVentes.getAvrNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Avoir X N° " + var3 + " en Avoir " + this.avoirEnteteVentes.getAvrSerie() + " N° " + this.avoirEnteteVentes.getAvrNum());
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

   public void payeDocument() throws NamingException, JDOMException, IOException {
      if (this.avoirEnteteVentes == null) {
         this.selectionLigne();
      }

      this.var_date = this.avoirEnteteVentes.getAvrDate();
      this.listFactureVentes.clear();
      this.listCommandeVentes.clear();
      if (this.optionsVentes.getPaiementAVOIR().equals("1")) {
         CommandeEnteteVentesDao var1 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.listCommandeVentes = var1.rechercheNonSoldeTiers(this.tiers, this.avoirEnteteVentes.getAvrSerie(), (Session)null);
         if (this.listCommandeVentes.size() != 0) {
            this.dataModelFacture.setWrappedData(this.listCommandeVentes);
            this.showModalPanelPaye = true;
         }
      } else if (this.optionsVentes.getPaiementAVOIR().equals("2")) {
         LivraisonEnteteVentesDao var2 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.listLivraisonVentes = var2.rechercheNonSoldeTiers(this.tiers, this.avoirEnteteVentes.getAvrSerie(), (Session)null);
         if (this.listLivraisonVentes.size() != 0) {
            this.dataModelFacture.setWrappedData(this.listLivraisonVentes);
            this.showModalPanelPaye = true;
         }
      } else {
         FactureEnteteVentesDao var3 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.listFactureVentes = var3.rechercheNonSoldeTiers(this.tiers, this.avoirEnteteVentes.getAvrSerie(), (Session)null);
         if (this.listFactureVentes.size() != 0) {
            this.dataModelFacture.setWrappedData(this.listFactureVentes);
            this.showModalPanelPaye = true;
         }
      }

      this.totalPayer = 0.0D;
   }

   public void calculTotalElement() {
      this.totalPayer = 0.0D;
      this.totalEcart = 0.0D;
      int var1;
      if (this.optionsVentes.getPaiementAVOIR().equals("1")) {
         if (this.listCommandeVentes.size() != 0) {
            for(var1 = 0; var1 < this.listCommandeVentes.size(); ++var1) {
               this.commandeEnteteVentes = (CommandeEnteteVentes)this.listCommandeVentes.get(var1);
               if (this.commandeEnteteVentes.isVar_select_ligne()) {
                  this.totalPayer += this.commandeEnteteVentes.getBcmTotTtc();
               }
            }
         }
      } else if (this.listFactureVentes.size() != 0) {
         for(var1 = 0; var1 < this.listFactureVentes.size(); ++var1) {
            this.factureEnteteVentes = (FactureEnteteVentes)this.listFactureVentes.get(var1);
            if (this.factureEnteteVentes.isVar_select_ligne()) {
               this.totalPayer += this.factureEnteteVentes.getFacTotTtc();
            }
         }
      }

      this.totalEcart = this.avoirEnteteVentes.getAvrTotTtc() - this.totalPayer;
   }

   public void selectionFacture() {
      if (this.dataModelFacture.isRowAvailable()) {
         if (this.optionsVentes.getPaiementAVOIR().equals("1")) {
            this.commandeEnteteVentes = (CommandeEnteteVentes)this.dataModelFacture.getRowData();
         } else {
            this.factureEnteteVentes = (FactureEnteteVentes)this.dataModelFacture.getRowData();
         }
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException, ParseException {
      double var1 = this.avoirEnteteVentes.getAvrTotTtc() - this.avoirEnteteVentes.getAvrTotReglement();
      double var3 = 0.0D;
      double var5 = 0.0D;
      String var7 = "";
      if (this.var_date == null) {
         this.var_date = new Date();
      }

      ExercicesCaisse var9;
      ExercicesCaisseDao var10;
      Session var11;
      Transaction var12;
      String var13;
      int var15;
      Reglements var16;
      String var17;
      String var18;
      String var19;
      int var49;
      long var50;
      if (this.optionsVentes.getPaiementAVOIR().equals("1")) {
         if (this.commandeEnteteVentes != null) {
            CommandeEnteteVentesDao var8 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            new ExercicesCaisse();
            var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            var9 = var10.recupererLastExo((Session)null);
            if (var9 != null) {
               var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
               var12 = null;

               try {
                  var12 = var11.beginTransaction();
                  var13 = this.calculChrono.numCompose(this.var_date, 29, this.commandeEnteteVentes.getBcmSerie(), var11);
                  new CommandeEnteteVentes();

                  for(var15 = 0; var15 < this.listCommandeVentes.size(); ++var15) {
                     CommandeEnteteVentes var14 = (CommandeEnteteVentes)this.listCommandeVentes.get(var15);
                     if (var14.isVar_select_ligne()) {
                        var7 = var14.getBcmNum();
                        var16 = new Reglements();
                        var16.setRglActivite(var14.getBcmActivite());
                        var16.setRglBanqueTireur("");
                        var16.setRglBudget(var14.getBcmBudget());
                        var16.setRglBon("");
                        var16.setRglCategorie(20);
                        var16.setRglCodeCaiss("");
                        var16.setRglLibCaiss("");
                        var16.setRglCodeEmetrice("");
                        var16.setRglLibEmetrice("");
                        var16.setRglCodeReceptrice("");
                        var16.setRglLibReceptrice("");
                        var16.setRglDateCreation(new Date());
                        var16.setRglDateImp((Date)null);
                        var16.setRglDateReg(this.var_date);
                        var16.setRglDateTransfert((Date)null);
                        var16.setRglDateValeur((Date)null);
                        var16.setRglDepartement(var14.getBcmDepartement());
                        var16.setRglDepense(0.0D);
                        var16.setRglDevise(var14.getBcmDevise());
                        var16.setRglDossier("");
                        var16.setRglFormatDevise(this.calculformatDevise(var16.getRglDevise()));
                        var16.setRglDocument(var14.getBcmNum());
                        var16.setRglIdCaissier(this.usersLog.getUsrid());
                        var16.setRglIdBon(0L);
                        var16.setRglIdDocument(var14.getBcmId());
                        var16.setRglIdTiers(var14.getTiers().getTieid());
                        var16.setRglDepotTiers(0);
                        var16.setRglLibelle("Compense Avoir N° " + this.avoirEnteteVentes.getAvrNum());
                        var16.setRglLibTypReg("Compense");
                        var16.setRglMode("Compense");
                        var16.setRglModele("");
                        var16.setRglNumChqBdx("");
                        var16.setRglNatureDoc(22);
                        var16.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        var16.setRglNomTiers(var14.getBcmNomTiers());
                        var16.setRglNum(var13);
                        var16.setRglObjet(var14.getBcmObject());
                        var16.setRglParc("");
                        var16.setRglPdv(var14.getBcmPdv());
                        if (var14.getBcmTotTtc() - var14.getBcmTotReglement() <= var1) {
                           var16.setRglRecette(var14.getBcmTotTtc() - var14.getBcmTotReglement());
                           var1 -= var14.getBcmTotTtc() - var14.getBcmTotReglement();
                        } else {
                           var16.setRglRecette(var1);
                           var1 = 0.0D;
                        }

                        var3 = var16.getRglRecette();
                        var16.setRglTimbre(0.0D);
                        var16.setRglRegion(var14.getBcmRegion());
                        var16.setRglSecteur(var14.getBcmSecteur());
                        var16.setRglSerie(var14.getBcmSerie());
                        var16.setRglService(var14.getBcmService());
                        var16.setRglSite(var14.getBcmSite());
                        var16.setRglTrf(1);
                        var16.setRglTypeReg(0);
                        var16.setRglTypeTiers(0);
                        var16.setRglUserCreat(this.usersLog.getUsrid());
                        var16.setRglUserModif(0L);
                        var16.setRglIdResponsable(var14.getBcmIdResponsable());
                        var16.setRglNomResponsable(var14.getBcmNomResponsable());
                        var16.setRglIdCommercial(var14.getBcmIdCommercial());
                        var16.setRglNomCommercial(var14.getBcmNomCommercial());
                        var16.setRglIdEquipe(var14.getBcmIdEquipe());
                        var16.setRglNomEquipe(var14.getBcmNomEquipe());
                        var17 = "";
                        if (var16.getRglDateReg().getMonth() + 1 <= 9) {
                           var17 = "0" + (var16.getRglDateReg().getMonth() + 1);
                        } else {
                           var17 = "" + (var16.getRglDateReg().getMonth() + 1);
                        }

                        var18 = "" + (var16.getRglDateReg().getYear() + 1900);
                        var16.setRglPeriode(var17 + ":" + var18);
                        var16.setRglCle1(var16.getRglCodeCaiss() + ":" + var16.getRglPeriode());
                        var19 = this.utilDate.dateToStringSQLLight(var16.getRglDateReg());
                        var16.setRglCle2(var16.getRglCodeCaiss() + ":" + var19);
                        var16.setExercicesCaisse(var9);
                        this.reglementsDao.insert(var16, var11);
                        var14.setBcmTotReglement(var14.getBcmTotReglement() + var3);
                        if (var14.getBcmTotReglement() >= var14.getBcmTotTtc()) {
                           var14.setBcmSolde(1);
                        } else {
                           var14.setBcmSolde(0);
                        }

                        var14 = var8.modif(var14, var11);
                        var16 = new Reglements();
                        var16.setRglActivite(var14.getBcmActivite());
                        var16.setRglBanqueTireur("");
                        var16.setRglBudget(var14.getBcmBudget());
                        var16.setRglBon("");
                        var16.setRglCategorie(20);
                        var16.setRglCodeCaiss("");
                        var16.setRglLibCaiss("");
                        var16.setRglCodeEmetrice("");
                        var16.setRglLibEmetrice("");
                        var16.setRglCodeReceptrice("");
                        var16.setRglLibReceptrice("");
                        var16.setRglDateCreation(new Date());
                        var16.setRglDateImp((Date)null);
                        var16.setRglDateReg(this.var_date);
                        var16.setRglDateTransfert((Date)null);
                        var16.setRglDateValeur((Date)null);
                        var16.setRglDepartement(this.avoirEnteteVentes.getAvrDepartement());
                        var16.setRglDepense(0.0D);
                        var16.setRglDevise(this.avoirEnteteVentes.getAvrDevise());
                        var16.setRglDossier("");
                        var16.setRglFormatDevise(this.calculformatDevise(var16.getRglDevise()));
                        var16.setRglDocument(this.avoirEnteteVentes.getAvrNum());
                        var16.setRglIdCaissier(this.usersLog.getUsrid());
                        var16.setRglIdBon(0L);
                        var16.setRglIdDocument(this.avoirEnteteVentes.getAvrId());
                        var16.setRglIdTiers(this.avoirEnteteVentes.getTiers().getTieid());
                        var16.setRglDepotTiers(0);
                        var16.setRglLibelle("Compense BC N° " + var14.getBcmNum());
                        var16.setRglLibTypReg("Compense");
                        var16.setRglMode("Compense");
                        var16.setRglModele("");
                        var16.setRglNumChqBdx("");
                        var16.setRglNatureDoc(26);
                        var16.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        var16.setRglNomTiers(this.avoirEnteteVentes.getAvrNomTiers());
                        var16.setRglNum(var13);
                        var16.setRglObjet(this.avoirEnteteVentes.getAvrObject());
                        var16.setRglParc("");
                        var16.setRglPdv(this.avoirEnteteVentes.getAvrPdv());
                        var16.setRglRecette(var3);
                        var5 += var3;
                        var16.setRglTimbre(0.0D);
                        var16.setRglRegion(this.avoirEnteteVentes.getAvrRegion());
                        var16.setRglSecteur(this.avoirEnteteVentes.getAvrSecteur());
                        var16.setRglSerie(this.avoirEnteteVentes.getAvrSerie());
                        var16.setRglService(this.avoirEnteteVentes.getAvrService());
                        var16.setRglSite(this.avoirEnteteVentes.getAvrSite());
                        var16.setRglTrf(1);
                        var16.setRglTypeReg(0);
                        var16.setRglTypeTiers(0);
                        var16.setRglUserCreat(this.usersLog.getUsrid());
                        var16.setRglUserModif(0L);
                        var16.setRglIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
                        var16.setRglNomResponsable(this.avoirEnteteVentes.getAvrNomResponsable());
                        var16.setRglIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
                        var16.setRglNomCommercial(this.avoirEnteteVentes.getAvrNomCommercial());
                        var16.setRglIdEquipe(this.avoirEnteteVentes.getAvrIdEquipe());
                        var16.setRglNomEquipe(this.avoirEnteteVentes.getAvrNomEquipe());
                        var17 = "";
                        if (var16.getRglDateReg().getMonth() + 1 <= 9) {
                           var17 = "0" + (var16.getRglDateReg().getMonth() + 1);
                        } else {
                           var17 = "" + (var16.getRglDateReg().getMonth() + 1);
                        }

                        var18 = "" + (var16.getRglDateReg().getYear() + 1900);
                        var16.setRglPeriode(var17 + ":" + var18);
                        var16.setRglCle1(var16.getRglCodeCaiss() + ":" + var16.getRglPeriode());
                        var19 = this.utilDate.dateToStringSQLLight(var16.getRglDateReg());
                        var16.setRglCle2(var16.getRglCodeCaiss() + ":" + var19);
                        var16.setExercicesCaisse(var9);
                        this.reglementsDao.insert(var16, var11);
                     }

                     if (var1 == 0.0D) {
                        break;
                     }
                  }

                  this.avoirEnteteVentes.setAvrTotReglement(this.avoirEnteteVentes.getAvrTotReglement() + var5);
                  this.avoirEnteteVentes.setAvrNumBC(var7);
                  if (var5 >= this.avoirEnteteVentes.getAvrTotTtc()) {
                     this.avoirEnteteVentes.setAvrSolde(1);
                  } else {
                     this.avoirEnteteVentes.setAvrSolde(0);
                  }

                  this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var11);
                  var12.commit();
               } catch (HibernateException var45) {
                  if (var12 != null) {
                     var12.rollback();
                  }

                  throw var45;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }

            if (this.lesEntetesList.size() != 0) {
               var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");

               for(var49 = 0; var49 < this.lesEntetesList.size(); ++var49) {
                  this.avoirEnteteVentes = (AvoirEnteteVentes)this.lesEntetesList.get(var49);
                  if (this.avoirEnteteVentes.isVar_select_ligne()) {
                     var50 = this.avoirEnteteVentes.getAvrId();
                     this.avoirEnteteVentes = new AvoirEnteteVentes();
                     this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var50, var11);
                     if (this.avoirEnteteVentes != null) {
                        if (this.avoirEnteteVentes.getAvrSolde() == 1 && this.inpEtat == 13) {
                           this.lesEntetesList.remove(var49);
                        } else {
                           this.lesEntetesList.remove(var49);
                           this.avoirEnteteVentes.setVar_select_ligne(false);
                           this.lesEntetesList.add(var49, this.avoirEnteteVentes);
                        }
                     }
                  }
               }

               this.utilInitHibernate.closeSession();
               this.datamodelEntete.setWrappedData(this.lesEntetesList);
            }
         }
      } else if (this.optionsVentes.getPaiementAVOIR().equals("2")) {
         if (this.livraisonEnteteVentes != null) {
            LivraisonEnteteVentesDao var47 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            new ExercicesCaisse();
            var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            var9 = var10.recupererLastExo((Session)null);
            if (var9 != null) {
               var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
               var12 = null;

               try {
                  var12 = var11.beginTransaction();
                  var13 = this.calculChrono.numCompose(this.var_date, 29, this.livraisonEnteteVentes.getBlvSerie(), var11);
                  new LivraisonEnteteVentes();

                  for(var15 = 0; var15 < this.listLivraisonVentes.size(); ++var15) {
                     LivraisonEnteteVentes var51 = (LivraisonEnteteVentes)this.listLivraisonVentes.get(var15);
                     if (var51.isVar_select_ligne()) {
                        var7 = var51.getBlvNum();
                        var16 = new Reglements();
                        var16.setRglActivite(var51.getBlvActivite());
                        var16.setRglBanqueTireur("");
                        var16.setRglBudget(var51.getBlvBudget());
                        var16.setRglBon("");
                        var16.setRglCategorie(20);
                        var16.setRglCodeCaiss("");
                        var16.setRglLibCaiss("");
                        var16.setRglCodeEmetrice("");
                        var16.setRglLibEmetrice("");
                        var16.setRglCodeReceptrice("");
                        var16.setRglLibReceptrice("");
                        var16.setRglDateCreation(new Date());
                        var16.setRglDateImp((Date)null);
                        var16.setRglDateReg(this.var_date);
                        var16.setRglDateTransfert((Date)null);
                        var16.setRglDateValeur((Date)null);
                        var16.setRglDepartement(var51.getBlvDepartement());
                        var16.setRglDepense(0.0D);
                        var16.setRglDevise(var51.getBlvDevise());
                        var16.setRglDossier("");
                        var16.setRglFormatDevise(this.calculformatDevise(var16.getRglDevise()));
                        var16.setRglDocument(var51.getBlvNum());
                        var16.setRglIdCaissier(this.usersLog.getUsrid());
                        var16.setRglIdBon(0L);
                        var16.setRglIdDocument(var51.getBlvId());
                        var16.setRglIdTiers(var51.getTiers().getTieid());
                        var16.setRglDepotTiers(0);
                        var16.setRglLibelle("Compense Avoir N° " + this.avoirEnteteVentes.getAvrNum());
                        var16.setRglLibTypReg("Compense");
                        var16.setRglMode("Compense");
                        var16.setRglModele("");
                        var16.setRglNumChqBdx("");
                        var16.setRglNatureDoc(23);
                        var16.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        var16.setRglNomTiers(var51.getBlvNomTiers());
                        var16.setRglNum(var13);
                        var16.setRglObjet(var51.getBlvObject());
                        var16.setRglParc("");
                        var16.setRglPdv(var51.getBlvPdv());
                        if (var51.getBlvTotTtc() - var51.getBlvTotReglement() <= var1) {
                           var16.setRglRecette(var51.getBlvTotTtc() - var51.getBlvTotReglement());
                           var1 -= var51.getBlvTotTtc() - var51.getBlvTotReglement();
                        } else {
                           var16.setRglRecette(var1);
                           var1 = 0.0D;
                        }

                        var3 = var16.getRglRecette();
                        var16.setRglTimbre(0.0D);
                        var16.setRglRegion(var51.getBlvRegion());
                        var16.setRglSecteur(var51.getBlvSecteur());
                        var16.setRglSerie(var51.getBlvSerie());
                        var16.setRglService(var51.getBlvService());
                        var16.setRglSite(var51.getBlvSite());
                        var16.setRglTrf(1);
                        var16.setRglTypeReg(0);
                        var16.setRglTypeTiers(0);
                        var16.setRglUserCreat(this.usersLog.getUsrid());
                        var16.setRglUserModif(0L);
                        var16.setRglIdResponsable(var51.getBlvIdResponsable());
                        var16.setRglNomResponsable(var51.getBlvNomResponsable());
                        var16.setRglIdCommercial(var51.getBlvIdCommercial());
                        var16.setRglNomCommercial(var51.getBlvNomCommercial());
                        var16.setRglIdEquipe(var51.getBlvIdEquipe());
                        var16.setRglNomEquipe(var51.getBlvNomEquipe());
                        var17 = "";
                        if (var16.getRglDateReg().getMonth() + 1 <= 9) {
                           var17 = "0" + (var16.getRglDateReg().getMonth() + 1);
                        } else {
                           var17 = "" + (var16.getRglDateReg().getMonth() + 1);
                        }

                        var18 = "" + (var16.getRglDateReg().getYear() + 1900);
                        var16.setRglPeriode(var17 + ":" + var18);
                        var16.setRglCle1(var16.getRglCodeCaiss() + ":" + var16.getRglPeriode());
                        var19 = this.utilDate.dateToStringSQLLight(var16.getRglDateReg());
                        var16.setRglCle2(var16.getRglCodeCaiss() + ":" + var19);
                        var16.setExercicesCaisse(var9);
                        this.reglementsDao.insert(var16, var11);
                        var51.setBlvTotReglement(var51.getBlvTotReglement() + var3);
                        if (var51.getBlvTotReglement() >= var51.getBlvTotTtc()) {
                           var51.setBlvSolde(1);
                        } else {
                           var51.setBlvSolde(0);
                        }

                        var51 = var47.modif(var51, var11);
                        var16 = new Reglements();
                        var16.setRglActivite(var51.getBlvActivite());
                        var16.setRglBanqueTireur("");
                        var16.setRglBudget(var51.getBlvBudget());
                        var16.setRglBon("");
                        var16.setRglCategorie(20);
                        var16.setRglCodeCaiss("");
                        var16.setRglLibCaiss("");
                        var16.setRglCodeEmetrice("");
                        var16.setRglLibEmetrice("");
                        var16.setRglCodeReceptrice("");
                        var16.setRglLibReceptrice("");
                        var16.setRglDateCreation(new Date());
                        var16.setRglDateImp((Date)null);
                        var16.setRglDateReg(this.var_date);
                        var16.setRglDateTransfert((Date)null);
                        var16.setRglDateValeur((Date)null);
                        var16.setRglDepartement(this.avoirEnteteVentes.getAvrDepartement());
                        var16.setRglDepense(0.0D);
                        var16.setRglDevise(this.avoirEnteteVentes.getAvrDevise());
                        var16.setRglDossier("");
                        var16.setRglFormatDevise(this.calculformatDevise(var16.getRglDevise()));
                        var16.setRglDocument(this.avoirEnteteVentes.getAvrNum());
                        var16.setRglIdCaissier(this.usersLog.getUsrid());
                        var16.setRglIdBon(0L);
                        var16.setRglIdDocument(this.avoirEnteteVentes.getAvrId());
                        var16.setRglIdTiers(this.avoirEnteteVentes.getTiers().getTieid());
                        var16.setRglDepotTiers(0);
                        var16.setRglLibelle("Compense BL N° " + var51.getBlvNum());
                        var16.setRglLibTypReg("Compense");
                        var16.setRglMode("Compense");
                        var16.setRglModele("");
                        var16.setRglNumChqBdx("");
                        var16.setRglNatureDoc(26);
                        var16.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        var16.setRglNomTiers(this.avoirEnteteVentes.getAvrNomTiers());
                        var16.setRglNum(var13);
                        var16.setRglObjet(this.avoirEnteteVentes.getAvrObject());
                        var16.setRglParc("");
                        var16.setRglPdv(this.avoirEnteteVentes.getAvrPdv());
                        var16.setRglRecette(var3);
                        var5 += var3;
                        var16.setRglTimbre(0.0D);
                        var16.setRglRegion(this.avoirEnteteVentes.getAvrRegion());
                        var16.setRglSecteur(this.avoirEnteteVentes.getAvrSecteur());
                        var16.setRglSerie(this.avoirEnteteVentes.getAvrSerie());
                        var16.setRglService(this.avoirEnteteVentes.getAvrService());
                        var16.setRglSite(this.avoirEnteteVentes.getAvrSite());
                        var16.setRglTrf(1);
                        var16.setRglTypeReg(0);
                        var16.setRglTypeTiers(0);
                        var16.setRglUserCreat(this.usersLog.getUsrid());
                        var16.setRglUserModif(0L);
                        var16.setRglIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
                        var16.setRglNomResponsable(this.avoirEnteteVentes.getAvrNomResponsable());
                        var16.setRglIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
                        var16.setRglNomCommercial(this.avoirEnteteVentes.getAvrNomCommercial());
                        var16.setRglIdEquipe(this.avoirEnteteVentes.getAvrIdEquipe());
                        var16.setRglNomEquipe(this.avoirEnteteVentes.getAvrNomEquipe());
                        var17 = "";
                        if (var16.getRglDateReg().getMonth() + 1 <= 9) {
                           var17 = "0" + (var16.getRglDateReg().getMonth() + 1);
                        } else {
                           var17 = "" + (var16.getRglDateReg().getMonth() + 1);
                        }

                        var18 = "" + (var16.getRglDateReg().getYear() + 1900);
                        var16.setRglPeriode(var17 + ":" + var18);
                        var16.setRglCle1(var16.getRglCodeCaiss() + ":" + var16.getRglPeriode());
                        var19 = this.utilDate.dateToStringSQLLight(var16.getRglDateReg());
                        var16.setRglCle2(var16.getRglCodeCaiss() + ":" + var19);
                        var16.setExercicesCaisse(var9);
                        this.reglementsDao.insert(var16, var11);
                     }

                     if (var1 == 0.0D) {
                        break;
                     }
                  }

                  this.avoirEnteteVentes.setAvrTotReglement(this.avoirEnteteVentes.getAvrTotReglement() + var5);
                  this.avoirEnteteVentes.setAvrNumBL(var7);
                  if (var5 >= this.avoirEnteteVentes.getAvrTotTtc()) {
                     this.avoirEnteteVentes.setAvrSolde(1);
                  } else {
                     this.avoirEnteteVentes.setAvrSolde(0);
                  }

                  this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var11);
                  var12.commit();
               } catch (HibernateException var43) {
                  if (var12 != null) {
                     var12.rollback();
                  }

                  throw var43;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }

            if (this.lesEntetesList.size() != 0) {
               var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");

               for(var49 = 0; var49 < this.lesEntetesList.size(); ++var49) {
                  this.avoirEnteteVentes = (AvoirEnteteVentes)this.lesEntetesList.get(var49);
                  if (this.avoirEnteteVentes.isVar_select_ligne()) {
                     var50 = this.avoirEnteteVentes.getAvrId();
                     this.avoirEnteteVentes = new AvoirEnteteVentes();
                     this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var50, var11);
                     if (this.avoirEnteteVentes != null) {
                        if (this.avoirEnteteVentes.getAvrSolde() == 1 && this.inpEtat == 13) {
                           this.lesEntetesList.remove(var49);
                        } else {
                           this.lesEntetesList.remove(var49);
                           this.avoirEnteteVentes.setVar_select_ligne(false);
                           this.lesEntetesList.add(var49, this.avoirEnteteVentes);
                        }
                     }
                  }
               }

               this.utilInitHibernate.closeSession();
               this.datamodelEntete.setWrappedData(this.lesEntetesList);
            }
         }
      } else if (this.factureEnteteVentes != null) {
         FactureEnteteVentesDao var48 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ExercicesCaisse();
         var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         var9 = var10.recupererLastExo((Session)null);
         if (var9 != null) {
            var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
            var12 = null;

            try {
               var12 = var11.beginTransaction();
               var13 = this.calculChrono.numCompose(this.var_date, 29, this.factureEnteteVentes.getFacSerie(), var11);
               new FactureEnteteVentes();

               for(var15 = 0; var15 < this.listFactureVentes.size(); ++var15) {
                  FactureEnteteVentes var52 = (FactureEnteteVentes)this.listFactureVentes.get(var15);
                  if (var52.isVar_select_ligne()) {
                     var7 = var52.getFacNum();
                     var16 = new Reglements();
                     var16.setRglActivite(var52.getFacActivite());
                     var16.setRglBanqueTireur("");
                     var16.setRglBudget(var52.getFacBudget());
                     var16.setRglBon("");
                     var16.setRglCategorie(20);
                     var16.setRglCodeCaiss("");
                     var16.setRglLibCaiss("");
                     var16.setRglCodeEmetrice("");
                     var16.setRglLibEmetrice("");
                     var16.setRglCodeReceptrice("");
                     var16.setRglLibReceptrice("");
                     var16.setRglDateCreation(new Date());
                     var16.setRglDateImp((Date)null);
                     var16.setRglDateReg(this.var_date);
                     var16.setRglDateTransfert((Date)null);
                     var16.setRglDateValeur((Date)null);
                     var16.setRglDepartement(var52.getFacDepartement());
                     var16.setRglDepense(0.0D);
                     var16.setRglDevise(var52.getFacDevise());
                     var16.setRglDossier("");
                     var16.setRglFormatDevise(this.calculformatDevise(var16.getRglDevise()));
                     var16.setRglDocument(var52.getFacNum());
                     var16.setRglIdCaissier(this.usersLog.getUsrid());
                     var16.setRglIdBon(0L);
                     var16.setRglIdDocument(var52.getFacId());
                     var16.setRglIdTiers(var52.getTiers().getTieid());
                     var16.setRglDepotTiers(0);
                     var16.setRglLibelle("Compense Avoir N° " + this.avoirEnteteVentes.getAvrNum());
                     var16.setRglLibTypReg("Compense");
                     var16.setRglMode("Compense");
                     var16.setRglModele("");
                     var16.setRglNumChqBdx("");
                     var16.setRglNatureDoc(25);
                     var16.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                     var16.setRglNomTiers(var52.getFacNomTiers());
                     var16.setRglNum(var13);
                     var16.setRglObjet(var52.getFacObject());
                     var16.setRglParc("");
                     var16.setRglPdv(var52.getFacPdv());
                     if (var52.getFacTotTtc() - var52.getFacTotReglement() <= var1) {
                        var16.setRglRecette(var52.getFacTotTtc() - var52.getFacTotReglement());
                        var1 -= var52.getFacTotTtc() - var52.getFacTotReglement();
                     } else {
                        var16.setRglRecette(var1);
                        var1 = 0.0D;
                     }

                     var3 = var16.getRglRecette();
                     var16.setRglTimbre(0.0D);
                     var16.setRglRegion(var52.getFacRegion());
                     var16.setRglSecteur(var52.getFacSecteur());
                     var16.setRglSerie(var52.getFacSerie());
                     var16.setRglService(var52.getFacService());
                     var16.setRglSite(var52.getFacSite());
                     var16.setRglTrf(1);
                     var16.setRglTypeReg(0);
                     var16.setRglTypeTiers(0);
                     var16.setRglUserCreat(this.usersLog.getUsrid());
                     var16.setRglUserModif(0L);
                     var16.setRglIdResponsable(var52.getFacIdResponsable());
                     var16.setRglNomResponsable(var52.getFacNomResponsable());
                     var16.setRglIdCommercial(var52.getFacIdCommercial());
                     var16.setRglNomCommercial(var52.getFacNomCommercial());
                     var16.setRglIdEquipe(var52.getFacIdEquipe());
                     var16.setRglNomEquipe(var52.getFacNomEquipe());
                     var17 = "";
                     if (var16.getRglDateReg().getMonth() + 1 <= 9) {
                        var17 = "0" + (var16.getRglDateReg().getMonth() + 1);
                     } else {
                        var17 = "" + (var16.getRglDateReg().getMonth() + 1);
                     }

                     var18 = "" + (var16.getRglDateReg().getYear() + 1900);
                     var16.setRglPeriode(var17 + ":" + var18);
                     var16.setRglCle1(var16.getRglCodeCaiss() + ":" + var16.getRglPeriode());
                     var19 = this.utilDate.dateToStringSQLLight(var16.getRglDateReg());
                     var16.setRglCle2(var16.getRglCodeCaiss() + ":" + var19);
                     var16.setExercicesCaisse(var9);
                     this.reglementsDao.insert(var16, var11);
                     var52.setFacTotReglement(var52.getFacTotReglement() + var3);
                     if (var52.getFacTotReglement() >= var52.getFacTotTtc()) {
                        var52.setFacSolde(1);
                     } else {
                        var52.setFacSolde(0);
                     }

                     var52 = var48.modif(var52, var11);
                     var16 = new Reglements();
                     var16.setRglActivite(var52.getFacActivite());
                     var16.setRglBanqueTireur("");
                     var16.setRglBudget(var52.getFacBudget());
                     var16.setRglBon("");
                     var16.setRglCategorie(20);
                     var16.setRglCodeCaiss("");
                     var16.setRglLibCaiss("");
                     var16.setRglCodeEmetrice("");
                     var16.setRglLibEmetrice("");
                     var16.setRglCodeReceptrice("");
                     var16.setRglLibReceptrice("");
                     var16.setRglDateCreation(new Date());
                     var16.setRglDateImp((Date)null);
                     var16.setRglDateReg(this.var_date);
                     var16.setRglDateTransfert((Date)null);
                     var16.setRglDateValeur((Date)null);
                     var16.setRglDepartement(this.avoirEnteteVentes.getAvrDepartement());
                     var16.setRglDepense(0.0D);
                     var16.setRglDevise(this.avoirEnteteVentes.getAvrDevise());
                     var16.setRglDossier("");
                     var16.setRglFormatDevise(this.calculformatDevise(var16.getRglDevise()));
                     var16.setRglDocument(this.avoirEnteteVentes.getAvrNum());
                     var16.setRglIdCaissier(this.usersLog.getUsrid());
                     var16.setRglIdBon(0L);
                     var16.setRglIdDocument(this.avoirEnteteVentes.getAvrId());
                     var16.setRglIdTiers(this.avoirEnteteVentes.getTiers().getTieid());
                     var16.setRglDepotTiers(0);
                     var16.setRglLibelle("Compense Facture N° " + var52.getFacNum());
                     var16.setRglLibTypReg("Compense");
                     var16.setRglMode("Compense");
                     var16.setRglModele("");
                     var16.setRglNumChqBdx("");
                     var16.setRglNatureDoc(26);
                     var16.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                     var16.setRglNomTiers(this.avoirEnteteVentes.getAvrNomTiers());
                     var16.setRglNum(var13);
                     var16.setRglObjet(this.avoirEnteteVentes.getAvrObject());
                     var16.setRglParc("");
                     var16.setRglPdv(this.avoirEnteteVentes.getAvrPdv());
                     var16.setRglRecette(var3);
                     var5 += var3;
                     var16.setRglTimbre(0.0D);
                     var16.setRglRegion(this.avoirEnteteVentes.getAvrRegion());
                     var16.setRglSecteur(this.avoirEnteteVentes.getAvrSecteur());
                     var16.setRglSerie(this.avoirEnteteVentes.getAvrSerie());
                     var16.setRglService(this.avoirEnteteVentes.getAvrService());
                     var16.setRglSite(this.avoirEnteteVentes.getAvrSite());
                     var16.setRglTrf(1);
                     var16.setRglTypeReg(0);
                     var16.setRglTypeTiers(0);
                     var16.setRglUserCreat(this.usersLog.getUsrid());
                     var16.setRglUserModif(0L);
                     var16.setRglIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
                     var16.setRglNomResponsable(this.avoirEnteteVentes.getAvrNomResponsable());
                     var16.setRglIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
                     var16.setRglNomCommercial(this.avoirEnteteVentes.getAvrNomCommercial());
                     var16.setRglIdEquipe(this.avoirEnteteVentes.getAvrIdEquipe());
                     var16.setRglNomEquipe(this.avoirEnteteVentes.getAvrNomEquipe());
                     var17 = "";
                     if (var16.getRglDateReg().getMonth() + 1 <= 9) {
                        var17 = "0" + (var16.getRglDateReg().getMonth() + 1);
                     } else {
                        var17 = "" + (var16.getRglDateReg().getMonth() + 1);
                     }

                     var18 = "" + (var16.getRglDateReg().getYear() + 1900);
                     var16.setRglPeriode(var17 + ":" + var18);
                     var16.setRglCle1(var16.getRglCodeCaiss() + ":" + var16.getRglPeriode());
                     var19 = this.utilDate.dateToStringSQLLight(var16.getRglDateReg());
                     var16.setRglCle2(var16.getRglCodeCaiss() + ":" + var19);
                     var16.setExercicesCaisse(var9);
                     this.reglementsDao.insert(var16, var11);
                  }

                  if (var1 == 0.0D) {
                     break;
                  }
               }

               this.avoirEnteteVentes.setAvrTotReglement(this.avoirEnteteVentes.getAvrTotReglement() + var5);
               this.avoirEnteteVentes.setAvrNumFacture(var7);
               if (var5 >= this.avoirEnteteVentes.getAvrTotTtc()) {
                  this.avoirEnteteVentes.setAvrSolde(1);
               } else {
                  this.avoirEnteteVentes.setAvrSolde(0);
               }

               this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var11);
               var12.commit();
            } catch (HibernateException var41) {
               if (var12 != null) {
                  var12.rollback();
               }

               throw var41;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         if (this.lesEntetesList.size() != 0) {
            var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");

            for(var49 = 0; var49 < this.lesEntetesList.size(); ++var49) {
               this.avoirEnteteVentes = (AvoirEnteteVentes)this.lesEntetesList.get(var49);
               if (this.avoirEnteteVentes.isVar_select_ligne()) {
                  var50 = this.avoirEnteteVentes.getAvrId();
                  this.avoirEnteteVentes = new AvoirEnteteVentes();
                  this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var50, var11);
                  if (this.avoirEnteteVentes != null) {
                     if (this.avoirEnteteVentes.getAvrSolde() == 1 && this.inpEtat == 13) {
                        this.lesEntetesList.remove(var49);
                     } else {
                        this.lesEntetesList.remove(var49);
                        this.avoirEnteteVentes.setVar_select_ligne(false);
                        this.lesEntetesList.add(var49, this.avoirEnteteVentes);
                     }
                  }
               }
            }

            this.utilInitHibernate.closeSession();
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
         }
      }

      this.var_affiche_dollar = false;
      this.showModalPanelPaye = false;
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

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void histoReglement() {
      if (this.avoirEnteteVentes != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
   }

   public String conversionGarde() throws HibernateException, NamingException {
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

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.avoirEnteteVentes.getAvrFormule1() != null && !this.avoirEnteteVentes.getAvrFormule1().isEmpty()) {
         FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesVentes(this.avoirEnteteVentes.getAvrFormule1(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
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

   public String conversionAnnexe2() throws HibernateException, NamingException {
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

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      this.montant_lettre = this.utilNombre.begin(Math.abs(this.avoirEnteteVentes.getAvrTotTtc()) + Math.abs(this.avoirEnteteVentes.getAvrTotTc()), this.avoirEnteteVentes.getAvrDevise());
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
         ConditionnementDao var8 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Conditionnement();

         for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
            this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var10);
            if (this.avoirLigneVentes.getAvrligModeGroupe() != 2 || this.avoirLigneVentes.getAvrligGroupe() == null || this.avoirLigneVentes.getAvrligGroupe().isEmpty()) {
               this.avoirLigneVentes.setVar_lib_des_condit("");
               if (this.avoirLigneVentes.getAvrligCondition() != null && !this.avoirLigneVentes.getAvrligCondition().isEmpty() && this.avoirLigneVentes.getAvrligCondition().contains(":")) {
                  String[] var11 = this.avoirLigneVentes.getAvrligCondition().split(":");
                  Conditionnement var9 = var8.rechercheConditionnement(var11[0], (Session)null);
                  if (var9 != null) {
                     this.avoirLigneVentes.setVar_lib_des_condit(var9.getCdtDescription());
                  }
               }

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
                  this.avoirLigneVentes.setAvoirEnteteVentes(this.avoirEnteteVentes);
                  this.avoirLigneVentes.setAvrligCode("=");
                  this.avoirLigneVentes.setAvrligOrdre(var10);
                  this.avoirLigneVentes.setAvrligLibelle(var3);
                  this.avoirLigneVentes.setAvrligPt(var4);
                  this.avoirLigneVentes.setAvrligTtc(var6);
                  var1.add(this.avoirLigneVentes);
                  var4 = 0.0D;
                  var6 = 0.0D;
                  var2 = false;
               } else {
                  this.avoirLigneVentes.setAvoirEnteteVentes(this.avoirEnteteVentes);
                  this.avoirLigneVentes.setAvrligOrdre(var10);
                  var1.add(this.avoirLigneVentes);
               }
            }
         }
      }

      return var1;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.avoirEnteteVentes.getAvrAnal2() != null && !this.avoirEnteteVentes.getAvrAnal2().isEmpty()) {
         String var4 = "";
         if (this.avoirEnteteVentes.getAvrAnal2().contains(":")) {
            String[] var5 = this.avoirEnteteVentes.getAvrAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.avoirEnteteVentes.getAvrAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.avoirEnteteVentes.getAvrDateImp() != null && this.avoirEnteteVentes.getAvrEtat() != 0) {
            var2 = true;
         }

         this.avoirEnteteVentes.setAvrDateImp(new Date());
         if (this.avoirEnteteVentes.getAvrEtat() == 0 && this.avoirEnteteVentes.getAvrEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.avoirEnteteVentes.setAvrEtat(1);
            if (this.tiers.getTieDteDocument7() == null || this.avoirEnteteVentes.getAvrDate().after(this.tiers.getTieDteDocument7())) {
               this.tiers.setTieDteDocument7(this.avoirEnteteVentes.getAvrDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.avoirEnteteVentes.setAvrModeleImp(var1);
         this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var3);
         this.contacts = new Contacts();
         if (this.avoirEnteteVentes.getAvrIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.avoirEnteteVentes.getAvrIdContact(), var3);
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
            var1.setEntete("Impression avoir");
            var1.setPageGarde(this.conversionGarde());
            if (this.avoirEnteteVentes.getAvrFormule1() != null && !this.avoirEnteteVentes.getAvrFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.avoirEnteteVentes.getAvrEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.avoirEnteteVentes.setAvrDevise(this.devisePrint);
            if (!this.avoirEnteteVentes.getAvrDevise().equals("XOF") && !this.avoirEnteteVentes.getAvrDevise().equals("XAF")) {
               if (this.avoirEnteteVentes.getAvrDevise().equals("EUR")) {
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
               double var13 = this.utilNombre.myRound((this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var13, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.avoirEnteteVentes.getAvrIdResponsable());
            var1.setIdCommercial(this.avoirEnteteVentes.getAvrIdCommercial());
            var1.setTiersSelectionne(this.avoirEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.avoirEnteteVentes.getAvrNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.avoirEnteteVentes.getAvrId());
            if (this.avoirEnteteVentes.getAvrAnal2() != null && !this.avoirEnteteVentes.getAvrAnal2().isEmpty()) {
               String var22 = "";
               if (this.avoirEnteteVentes.getAvrAnal2().contains(":")) {
                  String[] var14 = this.avoirEnteteVentes.getAvrAnal2().split(":");
                  var22 = var14[0];
               } else {
                  var22 = this.avoirEnteteVentes.getAvrAnal2();
               }

               new Parc();
               ParcDao var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var23 = var15.rechercheParc(var22, (Session)null);
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
            var1.setEntete("Impression de la liste des avoirs");
            var1.setTotauxHt("" + this.totauxHt);
            var1.setTotauxTaxe("" + this.totauxTaxe);
            var1.setTotauxTtc("" + this.totauxTtc);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "avoir" + File.separator);
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
            JRBeanCollectionDataSource var20 = new JRBeanCollectionDataSource(this.lesEntetesList);
            var1.setjRBeanCollectionDataSource(var20);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 2 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression avoir");
         var1.setMontant_lettre("");
         var1.setPageGarde("");
         var1.setAnnexe1("");
         var1.setAnnexe2("");
         var1.setDuplicata("");
         var1.setInfoOrigineDoc("");
         var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), 26));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.avoirEnteteVentes.getAvrEtat()));
         var1.setEmetteur("");
         var1.setDestinataire("");
         var1.setDestinataireCC("");
         var1.setDestinataireCCI("");
         var1.setCorpsMail("");
         var1.setId_doc(0L);
         var1.setFormat("PDF");
         if (this.lesEntetesList.size() != 0) {
            ArrayList var21 = new ArrayList();
            new AvoirEnteteVentes();
            AvoirEnteteVentes var24 = this.avoirEnteteVentes;
            Session var25 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");

            for(int var26 = 0; var26 < this.lesEntetesList.size(); ++var26) {
               this.avoirEnteteVentes = (AvoirEnteteVentes)this.lesEntetesList.get(var26);
               if (this.avoirEnteteVentes.getAvrAnal2() != null && !this.avoirEnteteVentes.getAvrAnal2().isEmpty()) {
                  String var16 = "";
                  if (this.avoirEnteteVentes.getAvrAnal2().contains(":")) {
                     String[] var17 = this.avoirEnteteVentes.getAvrAnal2().split(":");
                     var16 = var17[0];
                  } else {
                     var16 = this.avoirEnteteVentes.getAvrAnal2();
                  }

                  new Parc();
                  ParcDao var18 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var29 = var18.rechercheParc(var16, var25);
                  if (var29 != null) {
                     var1.setParc((Parc)null);
                     this.avoirEnteteVentes.setParcImmatriculation(var29.getPrcImmatriculation());
                  } else {
                     var1.setParc((Parc)null);
                     this.avoirEnteteVentes.setParcImmatriculation("");
                  }
               } else {
                  var1.setParc((Parc)null);
                  this.avoirEnteteVentes.setParcImmatriculation("");
               }

               boolean var28 = false;
               if (this.avoirEnteteVentes.getAvrDateImp() != null && this.avoirEnteteVentes.getAvrEtat() != 0) {
                  var28 = true;
               }

               this.chargerDocumentLigne(var25);
               new ArrayList();
               List var30 = this.calculeImpressionListe();
               if (var30.size() != 0) {
                  new AvoirLigneVentes();

                  for(int var19 = 0; var19 < var30.size(); ++var19) {
                     AvoirLigneVentes var31 = (AvoirLigneVentes)var30.get(var19);
                     var31.setAvoirEnteteVentes(this.avoirEnteteVentes);
                     var31.getAvoirEnteteVentes().setMontantLettre(this.montant_lettre);
                     var31.getAvoirEnteteVentes().setDupplicata("" + var28);
                     var31.getAvoirEnteteVentes().setInfoOrigineDoc(this.infoOrigineDoc);
                     var31.getAvoirEnteteVentes().setParcImmatriculation(this.avoirEnteteVentes.getParcImmatriculation());
                     var21.add(var31);
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
            JRBeanCollectionDataSource var27 = new JRBeanCollectionDataSource(var21);
            var1.setjRBeanCollectionDataSource(var27);
            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.avoirEnteteVentes = var24;
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
            this.uniteGraph = "AVOIRS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "AVOIRS : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "AVOIRS : Quantites";
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

         new AvoirEnteteVentes();
         new AvoirLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirLigne");
         String var6 = "";

         AvoirEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (AvoirEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getAvrNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getAvrNum() + "'";
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

                  var14 = (AvoirEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getAvrDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getAvrNomResponsable() != null && !var14.getAvrNomResponsable().isEmpty()) {
                        var17 = var14.getAvrNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getAvrNomCommercial() != null && !var14.getAvrNomCommercial().isEmpty()) {
                        var17 = var14.getAvrNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getAvrNomEquipe() != null && !var14.getAvrNomEquipe().isEmpty()) {
                        var17 = var14.getAvrNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getAvrNomTiers() != null && !var14.getAvrNomTiers().isEmpty()) {
                        var17 = var14.getAvrNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getAvrSource() != null && !var14.getAvrSource().isEmpty()) {
                        var17 = var14.getAvrSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getAvrAnal4() != null && !var14.getAvrAnal4().isEmpty()) {
                        var17 = var14.getAvrAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getAvrRegion() != null && !var14.getAvrRegion().isEmpty()) {
                        var17 = var14.getAvrRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getAvrSecteur() != null && !var14.getAvrSecteur().isEmpty()) {
                        var17 = var14.getAvrSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getAvrPdv() != null && !var14.getAvrPdv().isEmpty()) {
                        var17 = var14.getAvrPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getAvrSite() != null && !var14.getAvrSite().isEmpty()) {
                        var17 = var14.getAvrSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getAvrDepartement() != null && !var14.getAvrDepartement().isEmpty()) {
                        var17 = var14.getAvrDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getAvrService() != null && !var14.getAvrService().isEmpty()) {
                        var17 = var14.getAvrService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getAvrSerie() != null && !var14.getAvrSerie().isEmpty()) {
                        var17 = var14.getAvrSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getAvrTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getAvrDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getAvrDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getAvrDate().getMonth() + 1 >= 1 && var14.getAvrDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getAvrDate().getMonth() + 1 >= 4 && var14.getAvrDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getAvrDate().getMonth() + 1 >= 7 && var14.getAvrDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getAvrDate().getMonth() + 1 >= 10 && var14.getAvrDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getAvrDate().getMonth() + 1 >= 1 && var14.getAvrDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getAvrDate().getMonth() + 1 >= 7 && var14.getAvrDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getAvrDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.avoirLigneVentesDao.chargerLesLignesAvoirs(var6, var5);
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

                  AvoirLigneVentes var15 = (AvoirLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getAvoirEnteteVentes().getAvrDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getAvoirEnteteVentes().getAvrNomResponsable() != null && !var15.getAvoirEnteteVentes().getAvrNomResponsable().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getAvoirEnteteVentes().getAvrNomCommercial() != null && !var15.getAvoirEnteteVentes().getAvrNomCommercial().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getAvoirEnteteVentes().getAvrNomEquipe() != null && !var15.getAvoirEnteteVentes().getAvrNomEquipe().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getAvoirEnteteVentes().getAvrNomTiers() != null && !var15.getAvoirEnteteVentes().getAvrNomTiers().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getAvrligFamille() != null && !var15.getAvrligFamille().isEmpty()) {
                        var8 = var15.getAvrligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getAvrligLibelle() != null && !var15.getAvrligLibelle().isEmpty()) {
                        var8 = var15.getAvrligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getAvoirEnteteVentes().getAvrSource() != null && !var15.getAvoirEnteteVentes().getAvrSource().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getAvoirEnteteVentes().getAvrAnal4() != null && !var15.getAvoirEnteteVentes().getAvrAnal4().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getAvoirEnteteVentes().getAvrRegion() != null && !var15.getAvoirEnteteVentes().getAvrRegion().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getAvoirEnteteVentes().getAvrSecteur() != null && !var15.getAvoirEnteteVentes().getAvrSecteur().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getAvoirEnteteVentes().getAvrPdv() != null && !var15.getAvoirEnteteVentes().getAvrPdv().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getAvoirEnteteVentes().getAvrSite() != null && !var15.getAvoirEnteteVentes().getAvrSite().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getAvoirEnteteVentes().getAvrDepartement() != null && !var15.getAvoirEnteteVentes().getAvrDepartement().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getAvoirEnteteVentes().getAvrService() != null && !var15.getAvoirEnteteVentes().getAvrService().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getAvoirEnteteVentes().getAvrSerie() != null && !var15.getAvoirEnteteVentes().getAvrSerie().isEmpty()) {
                        var8 = var15.getAvoirEnteteVentes().getAvrSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getAvrligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getAvrligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getAvoirEnteteVentes().getAvrDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 >= 1 && var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 >= 4 && var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 >= 7 && var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 >= 10 && var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 >= 1 && var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 >= 7 && var15.getAvoirEnteteVentes().getAvrDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getAvoirEnteteVentes().getAvrDate().getHours();
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

   public void recalculTva(AvoirEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.avoirEnteteVentes = var1;
         this.tiers = this.avoirEnteteVentes.getTiers();
         if (this.tiers.getTiecss() == 0 && this.structureLog.getStrcodepays().equals("0077")) {
            this.var_tc_calcul = true;
            this.var_tc_taux = 1.0F;
            this.var_tc_type = 7;
         } else {
            this.var_tc_calcul = false;
            this.var_tc_taux = 0.0F;
            this.var_tc_type = 0;
         }

         this.lesLignesList = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.avoirLigneVentes.getAvrligCode(), var2);
               }

               this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var2);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var2);
            }

            this.cumulPrix();
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var2);
         }
      }

   }

   public void recalculCss(AvoirEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.avoirEnteteVentes = var1;
         this.tiers = this.avoirEnteteVentes.getTiers();
         this.lesLignesList = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneVentes = (AvoirLigneVentes)this.lesLignesList.get(var3);
               this.produits = null;
               if (this.avoirLigneVentes.getAvrligCode() != null && !this.avoirLigneVentes.getAvrligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.avoirLigneVentes.getAvrligCode(), var2);
               }

               this.calculPrix(this.avoirLigneVentes.getAvrligTaxe(), this.avoirLigneVentes.getAvrligTauxTaxe(), var2);
               this.avoirLigneVentes = this.avoirLigneVentesDao.modifLigne(this.avoirLigneVentes, var2);
            }

            this.cumulPrix();
            this.avoirEnteteVentes = this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var2);
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

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
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

   public DataModel getDataModelFacture() {
      return this.dataModelFacture;
   }

   public void setDataModelFacture(DataModel var1) {
      this.dataModelFacture = var1;
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

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
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

   public double getTotalPayer() {
      return this.totalPayer;
   }

   public void setTotalPayer(double var1) {
      this.totalPayer = var1;
   }

   public double getTotalEcart() {
      return this.totalEcart;
   }

   public void setTotalEcart(double var1) {
      this.totalEcart = var1;
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
