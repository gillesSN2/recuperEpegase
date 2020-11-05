package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
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
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DocumentTraceAchatsDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FormulesAchatsDao;
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
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionAchats;
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

public class FormAvoirAchats implements Serializable {
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
   private Tiers tiers;
   private TiersDao tiersDao;
   private String nomTier;
   private List lesFamilleFournisseursListe;
   private List lesModeReglementFournisseurListe;
   private String informationsTiers;
   private transient DataModel datamodelTiersSecondaire;
   private Tiers tiersSecondaire;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private Users responsable;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private List lesUsers = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private Contacts contacts;
   private AvoirEnteteAchats avoirEnteteAchats = new AvoirEnteteAchats();
   private AvoirEnteteAchatsDao avoirEnteteAchatsDao;
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
   private AvoirLigneAchats avoirLigneAchats = new AvoirLigneAchats();
   private AvoirLigneAchatsDao avoirLigneAchatsDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private boolean griserValider = false;
   private int numLigne;
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
   private PlansAnalytiques dossier;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean var_anal_chantier = false;
   private List mesBudgetsItems;
   private BonDecaissementAchat bonDecaissementAchat;
   private BonDecaissementAchatDao bonDecaissementAchatDao;
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
   private boolean showModalPanelAnnuler = false;
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

   public FormAvoirAchats() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteAchatsDao = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneAchatsDao = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionAchats.getAffichInGlobViewAVOIR();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
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
      if (this.avoirEnteteAchats.getAvfActivite() != null && !this.avoirEnteteAchats.getAvfActivite().isEmpty() && this.avoirEnteteAchats.getAvfActivite().contains(":")) {
         String[] var3 = this.avoirEnteteAchats.getAvfActivite().split(":");
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
      this.avoirEnteteAchats = this.avoirEnteteAchatsDao.pourParapheur(var1, (Session)null);
      if (this.avoirEnteteAchats != null) {
         this.lesLignesList = this.avoirLigneAchatsDao.chargerLesLignes(this.avoirEnteteAchats, (Session)null);
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
         this.inpResponsable = "";
         this.inpBudget = "100";
         this.inpActivite = "100";
         this.inpDossier = "";
         this.inpAnal = "";
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
         this.lesEntetesList = this.avoirEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.getInpNum(), this.getInpFournisseur(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.getInpBudget(), this.getInpResponsable(), this.getInpActivite(), this.inpDossier, this.inpAnal, var10, var11);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new AvoirEnteteAchats();

         for(int var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            AvoirEnteteAchats var12 = (AvoirEnteteAchats)this.lesEntetesList.get(var13);
            var2 += var12.getAvfTotTtc();
            var4 += var12.getAvfTotReglement();
            var6 += var12.getAvfTotHt();
            var8 += var12.getAvfTotTva();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.totauxHt = var2;
      this.totauxHt = var6;
      this.totauxTaxe = var8;
      this.montantTtc = var2;
      this.numLigne = 0;
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
            this.avoirEnteteAchats = (AvoirEnteteAchats)var1.get(0);
            this.inpNomTiersEnCours = this.avoirEnteteAchats.getAvfNomTiers();
            this.inpIdTiersEnCours = this.avoirEnteteAchats.getTiers().getTieid();
            this.var_date = this.avoirEnteteAchats.getAvfDate();
            if (this.avoirEnteteAchats.getAvfDate().getHours() <= 9) {
               this.var_heure = "0" + this.avoirEnteteAchats.getAvfDate().getHours();
            } else {
               this.var_heure = "" + this.avoirEnteteAchats.getAvfDate().getHours();
            }

            if (this.avoirEnteteAchats.getAvfDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.avoirEnteteAchats.getAvfDate().getMinutes();
            } else {
               this.var_minute = "" + this.avoirEnteteAchats.getAvfDate().getMinutes();
            }

            if (this.avoirEnteteAchats.getAvfDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.avoirEnteteAchats.getAvfDate().getSeconds();
            } else {
               this.var_seconde = "" + this.avoirEnteteAchats.getAvfDate().getSeconds();
            }

            this.tiers = this.avoirEnteteAchats.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.avoirEnteteAchats.getAvfIdContact();
            this.var_nom_responsable = this.avoirEnteteAchats.getAvfIdResponsable();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerDossierAffaire(var4);
            this.chargerBonEncaissement(var4);
            this.chargerDocumentTrace(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
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

            this.utilInitHibernate.closeSession();
            this.setMontantTtcElmt(this.avoirEnteteAchats.getAvfTotTtc());
            this.setMontantReglementElmt(this.avoirEnteteAchats.getAvfTotReglement());
            this.setMontantElmTotBonEnc(this.avoirEnteteAchats.getAvfTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.avoirEnteteAchats.getAvfTotTtc() - this.avoirEnteteAchats.getAvfTotReglement());
            this.cumulPrix();
            this.verrouNum = true;
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.avoirEnteteAchats != null) {
         if (this.avoirEnteteAchats.getAvfEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.avoirEnteteAchats.getAvfDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.avoirEnteteAchats.getAvfDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.avoirEnteteAchats.getAvfId() > 0L) {
         this.lesLignesList = this.avoirLigneAchatsDao.chargerLesLignes(this.avoirEnteteAchats, var1);
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

      if (this.avoirEnteteAchats != null && this.avoirEnteteAchats.getAvfAnal4() != null && !this.avoirEnteteAchats.getAvfAnal4().isEmpty()) {
         this.dossier = this.plansAnalytiquesDao.rechercheAffaire(this.avoirEnteteAchats.getAvfAnal4(), var1);
         if (this.dossier != null && this.dossier.getAnaNature() != null && !this.dossier.getAnaNature().isEmpty()) {
            if (this.dossier.getAnaNature().equals("6")) {
               this.libelleDossierFiche = "N° Dossier";
            } else if (this.dossier.getAnaNature().equals("10")) {
               this.libelleDossierFiche = "N° Affaire";
            }
         }
      }

   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonDecaissementAchatDao.rechercheBeByDoc(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonDecaissementAchat)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonDecaissementAchat)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = true;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.avoirEnteteAchats.getAvfTotTtc()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.avoirEnteteAchats.getAvfId() > 0L) {
         var2 = this.documentTraceAchatsDao.chargerLesDocumentsTrace(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
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
      if (this.avoirEnteteAchats != null && this.avoirEnteteAchats.getAvfSerie() != null && !this.avoirEnteteAchats.getAvfSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.avoirEnteteAchats.getAvfSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.avoirEnteteAchats != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.avoirEnteteAchats.getAvfId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.avoirEnteteAchats.getAvfActivite() != null && !this.avoirEnteteAchats.getAvfActivite().isEmpty() && this.avoirEnteteAchats.getAvfActivite().contains(":")) {
         String[] var1 = null;
         if (!this.avoirEnteteAchats.getAvfActivite().contains("#")) {
            var1 = this.avoirEnteteAchats.getAvfActivite().split(":");
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
            String[] var2 = this.avoirEnteteAchats.getAvfActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.avoirEnteteAchats.getAvfTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.avoirEnteteAchats.getAvfTotHt() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException {
      this.avoirEnteteAchats = new AvoirEnteteAchats();
      this.avoirLigneAchats = new AvoirLigneAchats();
      this.avoirEnteteAchats.setUsers(this.usersLog);
      this.avoirEnteteAchats.setAvfIdCreateur(this.usersLog.getUsrid());
      this.avoirEnteteAchats.setAvfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.avoirEnteteAchats.setAvfIdResponsable(this.usersLog.getUsrid());
      this.avoirEnteteAchats.setAvfNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.avoirEnteteAchats.setAvfDate(new Date());
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

      this.numLigne = 0;
      this.autorisationDocument();
      this.addLigne();
   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionAchats.getNbrJrRelanceAVOIR() != null && !this.optionAchats.getNbrJrRelanceAVOIR().isEmpty()) {
         var3 = Integer.parseInt(this.optionAchats.getNbrJrRelanceAVOIR());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionAchats.getNbrJrValidAVOIR() != null && !this.optionAchats.getNbrJrValidAVOIR().isEmpty()) {
         var4 = Integer.parseInt(this.optionAchats.getNbrJrValidAVOIR());
      } else {
         var4 = 0;
      }

      this.avoirEnteteAchats.setAvfDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.avoirEnteteAchats.setAvfDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.avoirEnteteAchats != null) {
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
            this.mesUsersItem.add(new SelectItem(this.avoirEnteteAchats.getAvfIdResponsable(), this.avoirEnteteAchats.getAvfNomResponsable()));
         }

         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.avoirEnteteAchats != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.avoirEnteteAchats.getAvfIdResponsable(), this.avoirEnteteAchats.getAvfNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.avoirEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.avoirEnteteAchats.getAvfEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.avoirEnteteAchats.setAvfEtat(1);
               this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle avoir (F.) N° " + this.avoirEnteteAchats.getAvfNum() + " du " + this.utilDate.dateToStringSQLLight(this.avoirEnteteAchats.getAvfDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument7() == null || this.avoirEnteteAchats.getAvfDate().after(this.tiers.getTieDteDocument7())) {
               this.tiers.setTieDteDocument7(this.avoirEnteteAchats.getAvfDate());
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
      if (this.avoirEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.avoirEnteteAchats.getAvfEtat() == 1) {
               this.avoirEnteteAchats.setAvfEtat(0);
               this.avoirEnteteAchats.setAvfDateImp((Date)null);
               this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle avoir (F.) N° " + this.avoirEnteteAchats.getAvfNum() + " du " + this.utilDate.dateToStringSQLLight(this.avoirEnteteAchats.getAvfDate()));
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
      if (this.avoirEnteteAchats != null) {
         this.avoirEnteteAchats.setAvfEtat(0);
         this.avoirEnteteAchats.setAvfDateAnnule((Date)null);
         this.avoirEnteteAchats.setAvfMotifAnnule("");
         this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.avoirEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.avoirEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.avoirEnteteAchats.getAvfId();
            String var5 = this.avoirEnteteAchats.getAvfNum();
            Date var6 = this.avoirEnteteAchats.getAvfDate();
            this.avoirLigneAchatsDao.deleteAllLigne(this.avoirEnteteAchats, var1);
            this.utilParapheur.supprimerParapheur(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
            this.avoirEnteteAchatsDao.delete(this.avoirEnteteAchats.getAvfId(), var1);
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

               if (var9 == 15) {
                  new FactureEnteteAchats();
                  FactureEnteteAchatsDao var12 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  FactureEnteteAchats var11 = var12.pourParapheur(var7, var1);
                  if (var11 != null) {
                     var11.setFcfEtat(var18);
                     if (var18 == 1) {
                        var11.setFcfDateTransforme((Date)null);
                        var11.setFcfTypeTransforme(0);
                     }

                     var12.modif(var11, var1);
                  }
               }
            }

            Espion var19 = new Espion();
            var19.setUsers(this.usersLog);
            var19.setEsptype(0);
            var19.setEspdtecreat(new Date());
            var19.setEspaction("Suppression avoir achat N° " + var5 + " du " + var6);
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
      if (this.avoirEnteteAchats.getAvfTypeReg() != 0 && this.avoirEnteteAchats.getAvfTypeReg() != 3) {
         if (this.avoirEnteteAchats.getAvfTypeReg() != 1 && this.avoirEnteteAchats.getAvfTypeReg() != 2 && this.avoirEnteteAchats.getAvfTypeReg() != 10) {
            if (this.avoirEnteteAchats.getAvfTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.avoirEnteteAchats.getAvfModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.avoirEnteteAchats.getAvfModeReg() != null && !this.avoirEnteteAchats.getAvfModeReg().isEmpty() && this.avoirEnteteAchats.getAvfModeReg().contains(":")) {
         String[] var2 = this.avoirEnteteAchats.getAvfModeReg().split(":");
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

            this.avoirEnteteAchats.setAvfTypeReg(Integer.parseInt(var3.getEcheances()));
            this.avoirEnteteAchats.setAvfModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.avoirEnteteAchats.setAvfNbJourReg(0);
            this.avoirEnteteAchats.setAvfArrondiReg(0);
            break;
         }
      }

      if (this.avoirEnteteAchats.getAvfTypeReg() != 0 && this.avoirEnteteAchats.getAvfTypeReg() != 3) {
         if (this.avoirEnteteAchats.getAvfTypeReg() != 1 && this.avoirEnteteAchats.getAvfTypeReg() != 2 && this.avoirEnteteAchats.getAvfTypeReg() != 10) {
            if (this.avoirEnteteAchats.getAvfTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementFournisseurListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.avoirEnteteAchats.setAvfTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.avoirEnteteAchats.setAvfModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.avoirEnteteAchats.setAvfNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.avoirEnteteAchats.setAvfArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.avoirEnteteAchats.getAvfModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.avoirEnteteAchats.getAvfDate(), this.avoirEnteteAchats.getAvfTypeReg(), this.avoirEnteteAchats.getAvfNbJourReg(), this.avoirEnteteAchats.getAvfArrondiReg());
      this.avoirEnteteAchats.setAvfDateEcheReg(var1);
   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.avoirEnteteAchats.setAvfDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.avoirEnteteAchats.getUsers() == null) {
            this.avoirEnteteAchats.setUsers(this.usersLog);
         }

         this.avoirEnteteAchats.setTiers(this.tiers);
         if ((this.avoirEnteteAchats.getAvfCat() == null || this.avoirEnteteAchats.getAvfCat().isEmpty()) && this.avoirEnteteAchats.getTiers().getTienomfamille() != null && !this.avoirEnteteAchats.getTiers().getTienomfamille().isEmpty()) {
            this.avoirEnteteAchats.setAvfCat(this.avoirEnteteAchats.getTiers().getTienomfamille());
         }

         if (!this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.avoirEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.avoirEnteteAchats.setAvfCivilTiers("");
         } else {
            this.avoirEnteteAchats.setAvfCivilTiers(this.avoirEnteteAchats.getTiers().getTiecivilite());
         }

         if (this.avoirEnteteAchats.getAvfDiversTiers() == 99) {
            this.avoirEnteteAchats.setAvfIdContact(0L);
            this.avoirEnteteAchats.setAvfNomContact("");
            this.avoirEnteteAchats.setAvfCivilContact("");
         } else {
            new Contacts();
            Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
            if (var3 != null) {
               this.avoirEnteteAchats.setAvfIdContact(var3.getConid());
               this.avoirEnteteAchats.setAvfNomContact(var3.getConpatronyme());
               this.avoirEnteteAchats.setAvfCivilContact(var3.getConcivilite());
            } else {
               this.avoirEnteteAchats.setAvfIdContact(0L);
               this.avoirEnteteAchats.setAvfNomContact("");
               this.avoirEnteteAchats.setAvfCivilContact("");
            }
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.avoirEnteteAchats.setAvfIdResponsable(var15.getUsrid());
            this.avoirEnteteAchats.setAvfNomResponsable(var15.getUsrPatronyme());
         } else {
            this.avoirEnteteAchats.setAvfIdResponsable(0L);
            this.avoirEnteteAchats.setAvfNomResponsable("");
         }

         if (this.avoirEnteteAchats.getAvfId() != 0L) {
            if (this.avoirEnteteAchats.getAvfEtat() == 6) {
               if (this.avoirEnteteAchats.getAvfEtatVal() == 1) {
                  this.avoirEnteteAchats.setAvfEtat(0);
               } else {
                  this.avoirEnteteAchats.setAvfEtat(0);
               }
            }

            this.avoirEnteteAchats.setAvfDateModif(new Date());
            this.avoirEnteteAchats.setAvfIdModif(this.usersLog.getUsrid());
            this.avoirEnteteAchats.setAvfNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.avoirEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.avoirEnteteAchats.setAvfDateCreat(new Date());
            this.avoirEnteteAchats.setAvfIdCreateur(this.usersLog.getUsrid());
            this.avoirEnteteAchats.setAvfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.avoirEnteteAchats.getAvfSerie() != null && !this.avoirEnteteAchats.getAvfSerie().equalsIgnoreCase("X") && !this.avoirEnteteAchats.getAvfSerie().isEmpty()) {
               this.avoirEnteteAchats.setAvfNum(this.calculChrono.numCompose(this.avoirEnteteAchats.getAvfDate(), this.nature, this.avoirEnteteAchats.getAvfSerie(), var1));
               boolean var16 = false;

               label245:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label245;
                     }

                     new AvoirEnteteAchats();
                     AvoirEnteteAchats var5 = this.avoirEnteteAchatsDao.pourParapheur(this.avoirEnteteAchats.getAvfNum(), this.avoirEnteteAchats.getAvfSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.avoirEnteteAchats.setAvfNum(this.calculChrono.numCompose(this.avoirEnteteAchats.getAvfDate(), this.nature, this.avoirEnteteAchats.getAvfSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var4 = this.avoirEnteteAchatsDao.selectLastNum(var1);
               this.avoirEnteteAchats.setAvfNum("" + var4);
            }

            this.avoirEnteteAchats.setAvfEtat(0);
            this.avoirEnteteAchats.setAvfEtatVal(0);
            this.avoirEnteteAchats.setAvfDateValide((Date)null);
            this.avoirEnteteAchats = this.avoirEnteteAchatsDao.insert(this.avoirEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.avoirEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.avoirEnteteAchats.getAvfId(), this.avoirEnteteAchats.getAvfNum(), this.avoirEnteteAchats.getAvfNomTiers(), this.avoirEnteteAchats.getAvfDate(), this.avoirEnteteAchats.getAvfDevise(), this.avoirEnteteAchats.getAvfTotTtc() + this.avoirEnteteAchats.getAvfTotTc(), this.avoirEnteteAchats.getAvfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var1), this.calculeParc(var1), this.avoirEnteteAchats.getVar_format_devise(), 0, var1);
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
      this.avoirEnteteAchats.setAvfSite(this.usersLog.getUsrSite());
      this.avoirEnteteAchats.setAvfDepartement(this.usersLog.getUsrDepartement());
      this.avoirEnteteAchats.setAvfService(this.usersLog.getUsrService());
      this.avoirEnteteAchats.setAvfRegion("");
      this.avoirEnteteAchats.setAvfSecteur("");
      this.avoirEnteteAchats.setAvfPdv("");
      if (!this.var_anal_activite) {
         this.avoirEnteteAchats.setAvfActivite("");
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

            this.avoirEnteteAchats.setAvfActivite(var1);
         }
      } else {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
         String var14 = "";
         boolean var15 = true;
         new AvoirLigneAchats();
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

               AvoirLigneAchats var4 = (AvoirLigneAchats)this.lesLignesList.get(var8);
               if (var4.getAvfligCode() != null && !var4.getAvfligCode().isEmpty()) {
                  Produits var5 = this.produitsDao.chargeProduit(var4.getAvfligCode(), var13);
                  if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                     if (var6.size() == 0) {
                        var7 = new ObjetTarif();
                        var7.setNomLibelle(var5.getProActivite());
                        var7.setPrix(var4.getAvfligPt());
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
                           var7.setPrix(var4.getAvfligPt());
                           var6.add(var7);
                        } else if (var9 && var7 != null) {
                           var7.setPrix(var10 + var4.getAvfligPt());
                           var6.remove(var7);
                           var6.add(var7);
                        }
                     }
                  }
               }

               ++var8;
            }
         }

         this.avoirEnteteAchats.setAvfActivite(var14);
         this.utilInitHibernate.closeSession();
      }

      if (this.avoirEnteteAchats.getAvfAnal4() != null && !this.avoirEnteteAchats.getAvfAnal4().isEmpty()) {
         this.avoirEnteteAchats.setAvfAnal4(this.avoirEnteteAchats.getAvfAnal4().toUpperCase());
      }

      if (!this.var_anal_parc) {
         this.avoirEnteteAchats.setAvfAnal2("");
      } else if (this.avoirEnteteAchats.getAvfAnal2() != null && this.avoirEnteteAchats.getAvfAnal2().length() <= 2) {
         this.avoirEnteteAchats.setAvfAnal2("");
      }

      if (this.avoirEnteteAchats.getAvfAnal1() != null && this.avoirEnteteAchats.getAvfAnal1().length() <= 2) {
         this.avoirEnteteAchats.setAvfAnal1("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.avoirEnteteAchats.setAvfEtatVal(1);
         this.avoirEnteteAchats.setAvfEtat(0);
         this.avoirEnteteAchats.setAvfDateValide((Date)null);
         return true;
      } else {
         this.avoirEnteteAchats.setAvfEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.avoirEnteteAchats.setAvfEtat(1);
               this.avoirEnteteAchats.setAvfDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.avoirEnteteAchats.setAvfEtat(0);
               this.avoirEnteteAchats.setAvfDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.avoirEnteteAchats != null) {
         this.avoirEnteteAchats.setAvfDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.avoirEnteteAchats != null) {
         if (this.avoirEnteteAchats.getAvfDateAnnule() == null) {
            this.avoirEnteteAchats.setAvfDateAnnule(new Date());
         }

         this.avoirEnteteAchats.setAvfEtat(3);
         this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation avoir achat N° " + this.avoirEnteteAchats.getAvfNum() + " le " + this.avoirEnteteAchats.getAvfDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.avoirEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculDisponibilite() throws HibernateException, NamingException {
      this.avoirEnteteAchats.setAvfBudgetDispo(0.0D);
      this.avoirEnteteAchats.setAvfBudgetDispoMois(0.0D);
      this.avoirEnteteAchats.setAvfBudgetTreso(0.0D);
      this.avoirEnteteAchats.setAvfBudgetTresoMois(0.0D);
      if (this.avoirEnteteAchats.getAvfBudget() != null && this.avoirEnteteAchats.getAvfBudget().contains(":")) {
         String var1 = "" + this.lastExoCompta.getExecpt_id();
         String[] var2 = this.avoirEnteteAchats.getAvfBudget().split(":");
         String var3 = null;
         if (this.avoirEnteteAchats.getAvfActivite() != null && !this.avoirEnteteAchats.getAvfActivite().isEmpty()) {
            String[] var4 = this.avoirEnteteAchats.getAvfActivite().split(":");
            var3 = var4[0];
         }

         int var27 = this.avoirEnteteAchats.getAvfDate().getMonth() + 1;
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
         List var24 = var23.selectLesDisponibilites(this.lastExoCompta.getExecpt_id(), this.avoirEnteteAchats.getAvfDate(), (Session)null);
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

         this.avoirEnteteAchats.setAvfBudgetDispo(var5 - var28);
         this.avoirEnteteAchats.setAvfBudgetDispoMois(var7 - var13);
         this.avoirEnteteAchats.setAvfBudgetTreso(var15 - var19);
         this.avoirEnteteAchats.setAvfBudgetTresoMois(var17 - var21);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.avoirEnteteAchats.getAvfExoTva() == 0 || this.avoirEnteteAchats.getAvfExoTva() == 2 || this.avoirEnteteAchats.getAvfExoTva() == 3) {
         TaxesAchats var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesAchats();
            var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxachTaux();
               var6 = var8.getTaxachCode();
               var7 = var8.getTaxachType();
            } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
               new TaxesAchats();
               TaxesAchats var9 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxachTaux();
                  var6 = var9.getTaxachCode();
                  var7 = var9.getTaxachType();
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
         } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
            new TaxesAchats();
            var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxachTaux();
               var6 = var8.getTaxachCode();
               var7 = var8.getTaxachType();
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

      this.avoirLigneAchats.setAvfligTaxe(var6);
      this.avoirLigneAchats.setAvfligTauxTaxe(var5);
      double var26 = this.avoirLigneAchats.getAvfligPu();
      if (this.avoirLigneAchats.getAvfligQte() != 0.0F) {
         this.avoirLigneAchats.setAvfligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.avoirLigneAchats.getAvfligCondition(), this.avoirLigneAchats.getAvfligQte(), this.avoirLigneAchats.getAvfligLong(), this.avoirLigneAchats.getAvfligLarg(), this.avoirLigneAchats.getAvfligHaut(), this.avoirLigneAchats.getAvfligDiam(), this.avoirLigneAchats.getAvfligNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.avoirLigneAchats.setAvfligQteUtil(0.0F);
      }

      double var10 = 0.0D;
      if (this.avoirLigneAchats.getAvfligCondition() != null && !this.avoirLigneAchats.getAvfligCondition().isEmpty() && this.avoirLigneAchats.getAvfligCondition().contains(":")) {
         var10 = var26 * (double)this.avoirLigneAchats.getAvfligQte();
      } else {
         var10 = var26 * (double)this.avoirLigneAchats.getAvfligQte();
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      if (this.optionAchats.getDecrmtRabais().equals("1")) {
         var14 = this.avoirLigneAchats.getAvfligRabais();
      } else if (this.optionAchats.getDecrmtRabais().equals("2")) {
         var14 = this.avoirLigneAchats.getAvfligRabais() * (double)this.avoirLigneAchats.getAvfligQte();
      }

      if (this.avoirLigneAchats.getAvfligTauxRemise() != 0.0F) {
         var12 = var10 - var10 * (double)this.avoirLigneAchats.getAvfligTauxRemise() / 100.0D - var14;
      } else {
         var12 = var10 - var14;
      }

      double var16 = this.utilNombre.myRoundFormat(var12, this.var_format_devise);
      double var18 = var16 * (double)this.avoirLigneAchats.getAvfligTauxTaxe() / 100.0D;
      if (var7 == 2 || var7 == 3) {
         var18 = var16 * (double)(this.avoirLigneAchats.getAvfligTauxTaxe() / 100.0F);
         var18 *= -1.0D;
      }

      double var20 = this.utilNombre.myRoundFormat(var18, this.var_format_devise);
      double var22 = var16 + var20;
      double var24 = 0.0D;
      if (this.avoirLigneAchats.getAvfligCondition() != null && !this.avoirLigneAchats.getAvfligCondition().isEmpty() && this.avoirLigneAchats.getAvfligCondition().contains(":")) {
         var24 = this.utilNombre.myRound(var16 / (double)this.avoirLigneAchats.getAvfligQteUtil(), 2);
      } else {
         var24 = this.utilNombre.myRound(var16 / (double)this.avoirLigneAchats.getAvfligQteUtil(), 2);
      }

      this.avoirLigneAchats.setAvfligPuRem(var24);
      this.avoirLigneAchats.setAvfligPt(var16);
      this.avoirLigneAchats.setAvfligTva(var20);
      this.avoirLigneAchats.setAvfligTc(0.0D);
      this.avoirLigneAchats.setAvfligTtc(var22);
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.avoirLigneAchats.getAvfligCondition() != null && !this.avoirLigneAchats.getAvfligCondition().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      }

      this.calculPrix(this.avoirLigneAchats.getAvfligTaxe(), this.avoirLigneAchats.getAvfligTauxTaxe(), (Session)null);
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
      new AvoirLigneAchats();

      for(int var12 = 0; var12 < this.lesLignesList.size(); ++var12) {
         AvoirLigneAchats var11 = (AvoirLigneAchats)this.lesLignesList.get(var12);
         var1 += var11.getAvfligPt();
         var5 += var11.getAvfligTtc();
         var7 += var11.getAvfligTc();
         var3 += var11.getAvfligTva();
         if (var11.getAvfligRabais() != 0.0D || var11.getAvfligTauxRemise() != 0.0F) {
            var9 += var11.getAvfligPu() * (double)var11.getAvfligQte() - var11.getAvfligPt();
         }
      }

      this.avoirEnteteAchats.setAvfTotHt(var1);
      this.avoirEnteteAchats.setAvfTotTtc(var5);
      this.avoirEnteteAchats.setAvfTotTc(var7);
      this.avoirEnteteAchats.setAvfTotTva(var3);
      this.avoirEnteteAchats.setAvfTotRemise(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesAchatsProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.avoirLigneAchats = (AvoirLigneAchats)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
         if (this.avoirLigneAchats.getAvfligCode() != null && this.avoirLigneAchats.getAvfligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.avoirLigneAchats.getAvfligCode(), var1);
            if (this.produits != null) {
               this.avoirLigneAchats.setAvfligCode(this.produits.getProCode());
               this.avoirLigneAchats.setAvfligFamille(this.produits.getProAchCode());
               this.avoirLigneAchats.setAvfligLong(this.produits.getProLongueur());
               this.avoirLigneAchats.setAvfligLarg(this.produits.getProLargeur());
               this.avoirLigneAchats.setAvfligHaut(this.produits.getProEpaisseur());
               this.avoirLigneAchats.setAvfligDiam(this.produits.getProDiamExt());
               this.avoirLigneAchats.setAvfligPoidsBrut(this.produits.getProPoidsBrut());
               this.avoirLigneAchats.setAvfligPoidsNet(this.produits.getProPoidsNet());
               this.avoirLigneAchats.setAvfligVolume(this.produits.getProVolume());
               this.avoirLigneAchats.setAvfligNb(this.produits.getProNbUnite());
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

   public void selectionLigneDetailLight() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.avoirLigneAchats = (AvoirLigneAchats)this.datamodelLigne.getRowData();
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
      this.avoirLigneAchats = new AvoirLigneAchats();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.avoirLigneAchats != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.avoirLigneAchats);
            this.lesLignesList.add(this.numLigne, this.avoirLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneAchats = (AvoirLigneAchats)this.lesLignesList.get(var3);
               this.avoirLigneAchats.setAvfligOrdre(var3);
               this.avoirLigneAchats = this.avoirLigneAchatsDao.modifLigne(this.avoirLigneAchats, var1);
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
      if (this.avoirLigneAchats != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.avoirLigneAchats);
            this.lesLignesList.add(this.numLigne, this.avoirLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.avoirLigneAchats = (AvoirLigneAchats)this.lesLignesList.get(var3);
               this.avoirLigneAchats.setAvfligOrdre(var3);
               this.avoirLigneAchats = this.avoirLigneAchatsDao.modifLigne(this.avoirLigneAchats, var1);
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
            if (this.avoirLigneAchats.getAvfligId() == ((AvoirLigneAchats)this.lesLignesList.get(var2)).getAvfligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.avoirEnteteAchats.getAvfId() == 0L) {
         this.save();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.avoirLigneAchats.getAvfligQteUtil() == 0.0F) {
            this.avoirLigneAchats.setAvfligQteUtil(this.avoirLigneAchats.getAvfligQte());
         }

         this.calculPrix(this.avoirLigneAchats.getAvfligTaxe(), this.avoirLigneAchats.getAvfligTauxTaxe(), var1);
         if (this.avoirLigneAchats.getAvfligCondition() != null && !this.avoirLigneAchats.getAvfligCondition().isEmpty() && this.avoirLigneAchats.getAvfligCondition().contains(":")) {
            ConditionnementDao var3 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            String[] var4 = this.avoirLigneAchats.getAvfligCondition().split(":");
            String var5 = var3.rechercheConditionnement(var4[0], var1).getCdtDescription();
            if (var5 != null && !var5.isEmpty()) {
               this.avoirLigneAchats.setAvfligDescription(var5);
            } else {
               this.avoirLigneAchats.setAvfligDescription("");
            }
         } else {
            this.avoirLigneAchats.setAvfligDescription("");
         }

         if (this.avoirLigneAchats.getAvfligId() == 0L) {
            this.avoirLigneAchats.setAvoirEnteteAchats(this.avoirEnteteAchats);
            this.avoirLigneAchats.setAvfligDevise(this.avoirEnteteAchats.getAvfDevise());
            this.avoirLigneAchats = this.avoirLigneAchatsDao.insertLigne(this.avoirLigneAchats, var1);
            if (this.numLigne == 0) {
               if (this.lesLignesList.size() != 0) {
                  this.numLigne = this.lesLignesList.size();
               } else {
                  this.numLigne = 0;
               }
            }

            this.lesLignesList.add(this.avoirLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
            this.numLigne = this.clauleNumlLigne() + 1;
         } else {
            this.avoirLigneAchats = this.avoirLigneAchatsDao.modifLigne(this.avoirLigneAchats, var1);
         }

         if (this.produits != null && this.produits.getProId() != 0L && this.tiers != null) {
            this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
            if (this.produitsFournisseur == null) {
               this.produitsFournisseur = new ProduitsFournisseur();
            }

            this.produitsFournisseur.setProfouDevise(this.avoirEnteteAchats.getAvfDevise());
            this.produitsFournisseur.setProfouFormat(this.avoirEnteteAchats.getVar_format_devise());
            if ((this.produitsFournisseur.getProfouLib() == null || this.produitsFournisseur.getProfouLib().isEmpty()) && this.avoirLigneAchats.getAvfligLibelleFournisseur() != null && !this.avoirLigneAchats.getAvfligLibelleFournisseur().isEmpty()) {
               this.produitsFournisseur.setProfouLib(this.avoirLigneAchats.getAvfligLibelleFournisseur());
            }

            if ((this.produitsFournisseur.getProfouRef() == null || this.produitsFournisseur.getProfouRef().isEmpty()) && this.avoirLigneAchats.getAvfligReference() != null && !this.avoirLigneAchats.getAvfligReference().isEmpty()) {
               this.produitsFournisseur.setProfouRef(this.avoirLigneAchats.getAvfligReference());
            }

            this.produitsFournisseur.setProfouDate(this.avoirEnteteAchats.getAvfDate());
            this.produitsFournisseur.setProfouPa(this.avoirLigneAchats.getAvfligPu());
            if (this.structureLog.getStrdevise().equalsIgnoreCase(this.avoirEnteteAchats.getAvfDevise())) {
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
         this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
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
      if (this.avoirLigneAchats.getAvfligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.avoirLigneAchats.getAvfligCode();
            this.avoirLigneAchatsDao.deleteOneLigne(this.avoirLigneAchats, var1);
            new ArrayList();
            List var4 = (List)this.datamodelLigne.getWrappedData();
            var4.remove(this.avoirLigneAchats);
            this.datamodelLigne.setWrappedData(var4);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression ligne produit " + var3 + " de l'avoir achat N° " + this.avoirEnteteAchats.getAvfNum() + " du " + this.avoirEnteteAchats.getAvfDate());
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

         if (this.lesLignesList.size() != 0) {
            this.numLigne = this.lesLignesList.size();
         } else {
            this.numLigne = 0;
         }
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.avoirEnteteAchats.getAvfNomTiers(), this.nature);
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
         this.avoirEnteteAchats.setTiers(this.tiers);
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.avoirEnteteAchats.setAvfCivilTiers("");
            this.var_typeTiers = true;
         } else {
            this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.avoirEnteteAchats.setAvfCivilTiers(this.avoirEnteteAchats.getTiers().getTiecivilite());
            this.var_typeTiers = false;
         }

         this.avoirEnteteAchats.setAvfNomTiers(this.nomTier);
         this.avoirEnteteAchats.setAvfTypeReg(this.tiers.getTietypereg());
         this.avoirEnteteAchats.setAvfModeReg(this.tiers.getTiemodereg());
         this.calculMessageLitige();
         String var2 = "";
         if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
            String[] var3 = this.tiers.getTiemodereg().split(":");
            var2 = var3[0];
         } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
            var2 = this.tiers.getTiemodereg();
         }

         if (!var2.equals("") && !var2.equals("100")) {
            this.avoirEnteteAchats.setAvfNbJourReg(this.tiers.getTienbecheance());
            this.avoirEnteteAchats.setAvfArrondiReg(this.tiers.getTienbarrondi());
         } else {
            for(int var7 = 0; var7 < this.lesModeReglementFournisseurListe.size(); ++var7) {
               new ObjetReglement();
               ObjetReglement var4 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var7);
               if (var4.getDefaut().equals("true")) {
                  if (var4.getEcheances() == null || var4.getEcheances().isEmpty()) {
                     var4.setEcheances("0");
                  }

                  this.avoirEnteteAchats.setAvfTypeReg(Integer.parseInt(var4.getEcheances()));
                  this.avoirEnteteAchats.setAvfModeReg(var4.getCategories() + ":" + var4.getLibelles());
                  int var5 = 0;
                  if (var4.getNbjours() != null && !var4.getNbjours().isEmpty()) {
                     var5 = Integer.parseInt(var4.getNbjours());
                  }

                  this.avoirEnteteAchats.setAvfNbJourReg(var5);
                  int var6 = 0;
                  if (var4.getArrondis() != null && !var4.getArrondis().isEmpty()) {
                     var6 = Integer.parseInt(var4.getArrondis());
                  }

                  this.avoirEnteteAchats.setAvfArrondiReg(var6);
                  break;
               }
            }
         }

         this.chargerModeEcheanceAffichage();
         this.avoirEnteteAchats.setAvfJournalReg(this.tiers.getTiejournalreg());
         if (this.tiers.getTienomfamille() != null && !this.tiers.getTienomfamille().isEmpty()) {
            this.avoirEnteteAchats.setAvfCat(this.tiers.getTienomfamille());
            this.avoirEnteteAchats.setAvfExoDouane(this.tiers.getTieexodouane());
            this.avoirEnteteAchats.setAvfExoTva(this.tiers.getTieexotva());
         } else if (this.tiers.getTiecodepays().equalsIgnoreCase(this.structureLog.getStrcodepays())) {
            this.avoirEnteteAchats.setAvfCat("Local");
         } else {
            this.avoirEnteteAchats.setAvfCat("Import");
         }

         if (this.tiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
            this.avoirEnteteAchats.setAvfDiversTiers(99);
         } else {
            this.avoirEnteteAchats.setAvfDiversTiers(0);
            this.avoirEnteteAchats.setAvfDiversNom("");
            this.avoirEnteteAchats.setAvfDiversAdresse("");
            this.avoirEnteteAchats.setAvfDiversVille("");
            this.avoirEnteteAchats.setAvfDiversTel("");
            this.avoirEnteteAchats.setAvfDiversMail("");
         }

         if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
            this.avoirEnteteAchats.setAvfDevise(this.tiers.getTiedevise());
         } else {
            this.avoirEnteteAchats.setAvfDevise(this.structureLog.getStrdevise());
         }

         this.mesContactItem.clear();
         this.chargerLesContactsItem(var1);
         this.chargerLesUsers(var1);
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
      this.avoirEnteteAchats.setTiers(this.tiers);
      this.avoirEnteteAchats.setAvfNomTiers("");
      this.avoirEnteteAchats.setAvfCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.lesUsers.clear();
      this.mesUsersItem.clear();
      this.mesUsersItem.add(new SelectItem(0, ""));
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (!this.avoirEnteteAchats.getAvfNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
            if (this.avoirEnteteAchats.getAvfCat() != null && !this.avoirEnteteAchats.getAvfCat().isEmpty() && this.avoirEnteteAchats.getAvfCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && !var1.equalsIgnoreCase("1")) {
         if (var1.equalsIgnoreCase("2")) {
            if (this.tiers != null && this.tiers.getTiecodepays() != null && !this.tiers.getTiecodepays().equals(this.structureLog.getStrcodepays())) {
               this.avoirEnteteAchats.setAvfExoTva(3);
            } else {
               this.avoirEnteteAchats.setAvfExoTva(2);
            }
         } else {
            this.avoirEnteteAchats.setAvfExoTva(0);
         }
      } else {
         this.avoirEnteteAchats.setAvfExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && !var2.equalsIgnoreCase("1")) {
         this.avoirEnteteAchats.setAvfExoDouane(0);
      } else {
         this.avoirEnteteAchats.setAvfExoDouane(1);
      }

      if (this.lesLignesList.size() != 0) {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var4 = null;

         try {
            var4 = var13.beginTransaction();

            for(int var5 = 0; var5 < this.lesLignesList.size(); ++var5) {
               this.avoirLigneAchats = new AvoirLigneAchats();
               this.avoirLigneAchats = (AvoirLigneAchats)this.lesLignesList.get(var5);
               if (this.avoirEnteteAchats.getAvfExoTva() == 1) {
                  this.avoirLigneAchats.setAvfligTaxe("");
                  this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
                  this.avoirLigneAchats.setAvfligTva(0.0D);
               } else if (this.avoirLigneAchats.getAvfligCode() != null && !this.avoirLigneAchats.getAvfligCode().isEmpty()) {
                  new Produits();
                  Produits var6 = this.produitsDao.chargeProduit(this.avoirLigneAchats.getAvfligCode(), var13);
                  TaxesAchats var7;
                  if (var6 == null) {
                     if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
                        new TaxesAchats();
                        var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var13);
                        if (var7 != null) {
                           this.avoirLigneAchats.setAvfligTaxe(this.optionAchats.getTvaDefaut());
                           this.avoirLigneAchats.setAvfligTauxTaxe(var7.getTaxachTaux());
                        } else {
                           this.avoirLigneAchats.setAvfligTaxe("");
                           this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
                        }
                     } else {
                        this.avoirLigneAchats.setAvfligTaxe("");
                        this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
                     }
                  } else if (!var6.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
                     if (var6.getProVteTva() != null && !var6.getProVteTva().isEmpty()) {
                        this.avoirLigneAchats.setAvfligTaxe(var6.getProVteTva());
                     } else {
                        this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var6, var13);
                        if (this.famillesProduitsAchats != null) {
                           this.avoirLigneAchats.setAvfligTaxe(this.famillesProduitsAchats.getFamachTaxe());
                        }
                     }

                     new TaxesAchats();
                     var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.avoirLigneAchats.getAvfligTaxe(), var13);
                     if (var7 != null) {
                        this.avoirLigneAchats.setAvfligTauxTaxe(var7.getTaxachTaux());
                     } else {
                        this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
                     }
                  } else {
                     this.avoirLigneAchats.setAvfligTaxe("");
                     this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
                  }
               }

               this.calculPrix(this.avoirLigneAchats.getAvfligTaxe(), this.avoirLigneAchats.getAvfligTauxTaxe(), var13);
               this.avoirLigneAchats = this.avoirLigneAchatsDao.modifLigne(this.avoirLigneAchats, var13);
            }

            if (this.avoirEnteteAchats.getAvfId() != 0L) {
               this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var13);
               var4.commit();
            }
         } catch (HibernateException var11) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentLigne((Session)null);
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
      this.produits = this.formRecherche.rechercheProduitAchat(this.avoirLigneAchats.getAvfligCode(), this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
         this.avoirLigneAchats.setAvfligCode(this.produits.getProCode());
         if (this.optionAchats.getModLibelleProd().equals("1")) {
            this.avoirLigneAchats.setAvfligLibelle(this.produits.getProLibTech());
         } else {
            this.avoirLigneAchats.setAvfligLibelle(this.produits.getProLibClient());
         }

         this.avoirLigneAchats.setAvfligFamille(this.produits.getProAchCode());
         this.avoirLigneAchats.setAvfligLong(this.produits.getProLongueur());
         this.avoirLigneAchats.setAvfligLarg(this.produits.getProLargeur());
         this.avoirLigneAchats.setAvfligHaut(this.produits.getProEpaisseur());
         this.avoirLigneAchats.setAvfligDiam(this.produits.getProDiamExt());
         this.avoirLigneAchats.setAvfligPoidsBrut(this.produits.getProPoidsBrut());
         this.avoirLigneAchats.setAvfligPoidsNet(this.produits.getProPoidsNet());
         this.avoirLigneAchats.setAvfligVolume(this.produits.getProVolume());
         this.avoirLigneAchats.setAvfligNb(this.produits.getProNbUnite());
         this.avoirLigneAchats.setAvfligReference((String)null);
         this.avoirLigneAchats.setAvfligLibelleFournisseur((String)null);
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

            this.avoirLigneAchats.setAvfligTaxe(this.produits.getProAchTva());
            this.avoirLigneAchats.setAvfligTauxTaxe(var5);
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

               this.avoirLigneAchats.setAvfligTaxe(var2.getFamachTaxe());
               this.avoirLigneAchats.setAvfligTauxTaxe(var3);
            } else {
               this.avoirLigneAchats.setAvfligTaxe("");
               this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
            }
         }

         if (this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            this.avoirLigneAchats.setAvfligTaxe("");
            this.avoirLigneAchats.setAvfligTauxTaxe(0.0F);
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.avoirLigneAchats.setAvfligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.avoirLigneAchats.setAvfligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.avoirLigneAchats.setAvfligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.avoirLigneAchats.setAvfligCondition("");
         this.prixUnitaireCorrespond(var1);
         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.avoirLigneAchats.getAvfligTaxe(), this.avoirLigneAchats.getAvfligTauxTaxe(), var1);
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
      if (this.avoirEnteteAchats.getAvfExoTva() == 0) {
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
            this.avoirLigneAchats.setAvfligTaxe(this.optionAchats.getTvaDefaut());
         }
      } else if ((this.avoirEnteteAchats.getAvfExoTva() == 2 || this.avoirEnteteAchats.getAvfExoTva() == 3) && this.mesTaxesAchatsItems.size() != 0) {
         for(var1 = 0; var1 < this.mesTaxesAchatsItems.size(); ++var1) {
            var2 = false;

            for(var3 = 0; var3 < this.lisTaxesAchats.size(); ++var3) {
               if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachCode().equals(((SelectItem)this.mesTaxesAchatsItems.get(var1)).getValue().toString())) {
                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 2 && this.avoirEnteteAchats.getAvfExoTva() == 2) {
                     var2 = true;
                     break;
                  }

                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 3 && this.avoirEnteteAchats.getAvfExoTva() == 3) {
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
      if (this.avoirLigneAchats.getAvfligCode() == null || this.avoirLigneAchats.getAvfligCode().isEmpty() || this.avoirLigneAchats.getAvfligCode().length() < 2) {
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
      this.avoirLigneAchats.setAvfligCode("");
      this.avoirLigneAchats.setAvfligLibelle("");
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
            this.avoirLigneAchats.setAvfligPu(this.produitsFournisseur.getProfouPa());
            this.avoirLigneAchats.setAvfligReference(this.produitsFournisseur.getProfouRef());
            this.avoirLigneAchats.setAvfligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.avoirLigneAchats.setAvfligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.avoirLigneAchats.getAvfligCondition() != null && !this.avoirLigneAchats.getAvfligCondition().isEmpty() && this.avoirLigneAchats.getAvfligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.avoirLigneAchats.getAvfligEchelle());
            float var5 = 1.0F;
            if (this.avoirLigneAchats.getAvfligCondition().contains("/")) {
               String[] var6 = this.avoirLigneAchats.getAvfligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.avoirLigneAchats.getAvfligCondition() != null && !this.avoirLigneAchats.getAvfligCondition().isEmpty() && !this.avoirLigneAchats.getAvfligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.avoirLigneAchats.getAvfligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.avoirLigneAchats.setAvfligPump(var9);
      } else {
         this.avoirLigneAchats.setAvfligPump(0.0D);
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
         String var2 = this.avoirLigneAchats.getAvfligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.avoirLigneAchats.setAvfligEchelle(this.unite.getUniEchelle());
               } else {
                  this.avoirLigneAchats.setAvfligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.avoirLigneAchats.setAvfligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.avoirLigneAchats.setAvfligEchelle(Integer.parseInt(var2));
         } else {
            this.avoirLigneAchats.setAvfligEchelle(0);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.avoirLigneAchats.getAvfligLong(), this.avoirLigneAchats.getAvfligLarg(), this.avoirLigneAchats.getAvfligHaut(), this.avoirLigneAchats.getAvfligDiam(), this.avoirLigneAchats.getAvfligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.avoirLigneAchats.getAvfligLong(), this.avoirLigneAchats.getAvfligLarg(), this.avoirLigneAchats.getAvfligHaut(), this.avoirLigneAchats.getAvfligDiam(), this.avoirLigneAchats.getAvfligNb(), this.baseLog, var1);
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

   public void rechercheDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      String var1 = "" + (this.var_date.getYear() + 1900);
      if (this.optionAchats.getAxeDossier().equals("2")) {
         this.dossier = this.formRecherche.rechercheAffaire(this.avoirEnteteAchats.getAvfAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.avoirEnteteAchats.getAvfSerie(), this.avoirEnteteAchats.getAvfDevise());
      } else {
         this.dossier = this.formRecherche.rechercheDossier(this.avoirEnteteAchats.getAvfAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.avoirEnteteAchats.getAvfSerie(), this.avoirEnteteAchats.getAvfDevise());
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

   public void recuperationDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.dossier = this.formRecherche.calculeDossier();
      this.calculeDossier();
   }

   public void calculeDossier() throws JDOMException, IOException, ParseException {
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
               this.avoirEnteteAchats.setAvfAnal4(this.dossier.getAnaTypeDossier() + this.dossier.getAnaCode());
            } else {
               this.avoirEnteteAchats.setAvfAnal4(this.dossier.getAnaCode());
            }
         } else {
            this.libelleDossierFiche = "N° Dossier";
            this.avoirEnteteAchats.setAvfAnal4(this.dossier.getAnaCode());
         }

         this.avoirEnteteAchats.setAvfObject(this.dossier.getAnaNomFr());
      } else {
         this.avoirEnteteAchats.setAvfAnal4("");
         this.avoirEnteteAchats.setAvfDevise(this.tiers.getTiedevise());
         this.avoirEnteteAchats.setAvfObject("");
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleDossier() {
      this.avoirEnteteAchats.setAvfAnal4("");
      this.avoirEnteteAchats.setAvfDevise(this.tiers.getTiedevise());
      this.avoirEnteteAchats.setAvfObject("");
      this.var_action = this.var_memo_action;
   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.avoirEnteteAchats.getAvfTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.avoirEnteteAchats.getAvfSerie();
      this.var_imput_cat = this.avoirEnteteAchats.getAvfCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new AvoirEnteteAchats();
         AvoirEnteteAchats var1 = this.avoirEnteteAchatsDao.pourParapheur(this.var_imput_num, this.avoirEnteteAchats.getAvfSerie(), (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.avoirEnteteAchats.getAvfNum();
               this.avoirEnteteAchats.setAvfNum(this.var_imput_num);
               this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
               if (var4 != null) {
                  for(var5 = 0; var5 < var4.size(); ++var5) {
                     new Parapheur();
                     var6 = (Parapheur)var4.get(var5);
                     var6.setPhrNum(this.avoirEnteteAchats.getAvfNum());
                     this.parapheurDao.modif(var6, var1);
                  }
               }

               var21 = new Espion();
               var21.setUsers(this.usersLog);
               var21.setEsptype(0);
               var21.setEspdtecreat(new Date());
               var21.setEspaction("Imputation Avoir achat N° " + var3 + " en Avoir achat N° " + this.avoirEnteteAchats.getAvfNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.avoirEnteteAchats.getAvfNum();
            this.avoirEnteteAchats.setAvfSerie(this.var_imput_serie);
            this.avoirEnteteAchats.setAvfCat(this.var_imput_cat);
            this.avoirEnteteAchats.setAvfNum(this.calculChrono.numCompose(this.avoirEnteteAchats.getAvfDate(), this.nature, this.avoirEnteteAchats.getAvfSerie(), var1));
            this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
            if (this.avoirEnteteAchats.getAvfTotReglement() != 0.0D) {
               new ArrayList();
               ReglementsDao var22 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var22.reglementDocument(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
               if (var4 != null) {
                  for(int var23 = 0; var23 < var4.size(); ++var23) {
                     new Reglements();
                     Reglements var7 = (Reglements)var4.get(var23);
                     var7.setRglDocument(this.avoirEnteteAchats.getAvfNum());
                     var22.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.avoirEnteteAchats.getAvfId(), this.nature, var1);
            if (var4 != null) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  new Parapheur();
                  var6 = (Parapheur)var4.get(var5);
                  var6.setPhrNum(this.avoirEnteteAchats.getAvfNum());
                  this.parapheurDao.modif(var6, var1);
               }
            }

            var21 = new Espion();
            var21.setUsers(this.usersLog);
            var21.setEsptype(0);
            var21.setEspdtecreat(new Date());
            var21.setEspaction("Imputation Avoir achat X N° " + var3 + " en Avoir achat " + this.avoirEnteteAchats.getAvfSerie() + " N° " + this.avoirEnteteAchats.getAvfNum());
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

   public void payeDocument() {
      this.bonDecaissementAchat = new BonDecaissementAchat();
      this.bonDecaissementAchat.setBonCodeCaisse("");
      this.bonDecaissementAchat.setBonLibCaisse("");
      this.bonDecaissementAchat.setBonDate(new Date());
      if (this.var_tot_bon_encaissement > this.avoirEnteteAchats.getAvfTotTtc()) {
         this.avoirEnteteAchats.setAvfModeReg("4");
         this.var_verouxModReg = true;
         this.var_affichMontant = false;
      } else {
         this.avoirEnteteAchats.setAvfModeReg("0");
         this.var_verouxModReg = false;
         this.var_affichMontant = true;
      }

      this.var_netAPayer = this.avoirEnteteAchats.getAvfTotTtc() - this.var_tot_bon_encaissement;
      this.verifBonEncaissement();
      this.setShowModalPanelPaye(true);
   }

   public void annulePaye() {
      this.setShowModalPanelPaye(false);
   }

   public void chargerModReg() {
      if (this.avoirEnteteAchats.getAvfModeReg().equalsIgnoreCase("4")) {
         this.var_affichMontant = false;
      } else {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.avoirEnteteAchats.getAvfTotTtc()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.calculChrono.numCompose(new Date(), 19, this.avoirEnteteAchats.getAvfSerie(), var1);
            this.bonDecaissementAchat = new BonDecaissementAchat();
            this.bonDecaissementAchat.setBonDateCreat(new Date());
            if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
               String[] var4 = this.var_inputCaisse.split(":");
               this.bonDecaissementAchat.setBonCodeCaisse(var4[0]);
               this.bonDecaissementAchat.setBonLibCaisse(var4[1]);
            } else {
               this.bonDecaissementAchat.setBonCodeCaisse("");
               this.bonDecaissementAchat.setBonLibCaisse("");
            }

            this.bonDecaissementAchat.setBonUserCreat(this.usersLog.getUsrid());
            this.bonDecaissementAchat.setBonActivite(this.avoirEnteteAchats.getAvfActivite());
            this.bonDecaissementAchat.setBonSite(this.avoirEnteteAchats.getAvfSite());
            this.bonDecaissementAchat.setBonDepartement(this.avoirEnteteAchats.getAvfDepartement());
            this.bonDecaissementAchat.setBonService(this.avoirEnteteAchats.getAvfService());
            this.bonDecaissementAchat.setBonRegion(this.avoirEnteteAchats.getAvfRegion());
            this.bonDecaissementAchat.setBonSecteur(this.avoirEnteteAchats.getAvfSecteur());
            this.bonDecaissementAchat.setBonPdv(this.avoirEnteteAchats.getAvfPdv());
            this.bonDecaissementAchat.setBonDateEcheReg(this.avoirEnteteAchats.getAvfDateEcheReg());
            this.bonDecaissementAchat.setBonEtat(0);
            this.bonDecaissementAchat.setBonNatRef(this.nature);
            this.bonDecaissementAchat.setBonNomResponsable(this.usersLog.getUsrPrenom() + " " + this.usersLog.getUsrNom());
            this.bonDecaissementAchat.setBonNomTiers(this.avoirEnteteAchats.getAvfNomTiers());
            this.bonDecaissementAchat.setBonIdTiers(this.avoirEnteteAchats.getTiers().getTieid());
            this.bonDecaissementAchat.setBonTypeTiers(1);
            this.bonDecaissementAchat.setBonLibelle("Règlement Avoir achat N° " + this.avoirEnteteAchats.getAvfNum());
            this.bonDecaissementAchat.setBonRef(this.avoirEnteteAchats.getAvfNum());
            this.bonDecaissementAchat.setBonIdRef(this.avoirEnteteAchats.getAvfId());
            this.bonDecaissementAchat.setBonObject(this.avoirEnteteAchats.getAvfObject());
            this.bonDecaissementAchat.setBonObservation(this.avoirEnteteAchats.getAvfObservation());
            this.bonDecaissementAchat.setBonSerie(this.avoirEnteteAchats.getAvfSerie());
            this.bonDecaissementAchat.setBonDevise(this.avoirEnteteAchats.getAvfDevise());
            this.bonDecaissementAchat.setBonTotTtc(this.avoirEnteteAchats.getAvfTotTtc());
            this.bonDecaissementAchat.setBonAPayer(this.montantElmTotBonEnc);
            this.bonDecaissementAchat.setBonTypeReg(this.avoirEnteteAchats.getAvfTypeReg());
            this.bonDecaissementAchat.setBonActif(0);
            this.bonDecaissementAchat.setBonNum(var3);
            this.bonDecaissementAchat.setBonDate(new Date());
            this.bonDecaissementAchat.setBonModeleImp(this.var_inpModeleImp);
            this.bonDecaissementAchatDao.insert(this.bonDecaissementAchat, var1);
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
         this.bonDecaissementAchat.setBonCodeCaisse("");
         this.bonDecaissementAchat.setBonLibCaisse("");
      } else {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonDecaissementAchat.setBonCodeCaisse(var1[0]);
         this.bonDecaissementAchat.setBonLibCaisse(var1[1]);
      }

   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.avoirEnteteAchats.getAvfFormule1() != null && !this.avoirEnteteAchats.getAvfFormule1().isEmpty()) {
         FormulesAchatsDao var2 = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesAchats(this.avoirEnteteAchats.getAvfFormule1(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.avoirEnteteAchats.getAvfAnnexe1() != null && !this.avoirEnteteAchats.getAvfAnnexe1().isEmpty() && this.avoirEnteteAchats.getAvfAnnexe1().contains(":")) {
         String[] var2 = this.avoirEnteteAchats.getAvfAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.avoirEnteteAchats.getUsers(), this.structureLog, this.avoirEnteteAchats.getTiers());
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
      if (this.avoirEnteteAchats.getAvfAnnexe2() != null && !this.avoirEnteteAchats.getAvfAnnexe2().isEmpty() && this.avoirEnteteAchats.getAvfAnnexe2().contains(":")) {
         String[] var2 = this.avoirEnteteAchats.getAvfAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.avoirEnteteAchats.getUsers(), this.structureLog, this.avoirEnteteAchats.getTiers());
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

   public JRBeanCollectionDataSource calculeImpressionCommun(Session var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
            Transaction var3 = null;

            try {
               var3 = var1.beginTransaction();

               for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
                  this.avoirLigneAchats = (AvoirLigneAchats)this.lesLignesList.get(var4);
                  if (this.avoirLigneAchats.getAvfligCode() != null && !this.avoirLigneAchats.getAvfligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.avoirLigneAchats.getAvfligCode(), var1);
                     if (this.produits != null) {
                        this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                        if (this.produitsFournisseur != null) {
                           this.avoirLigneAchats.setAvfligReference(this.produitsFournisseur.getProfouRef());
                           this.avoirLigneAchats.setAvfligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
                           this.avoirLigneAchats = this.avoirLigneAchatsDao.modifLigne(this.avoirLigneAchats, var1);
                        }
                     }
                  }

                  var2.add(this.avoirLigneAchats);
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
               this.avoirLigneAchats = (AvoirLigneAchats)this.lesLignesList.get(var10);
               if (this.avoirLigneAchats.getAvfligCode() != null && !this.avoirLigneAchats.getAvfligCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.avoirLigneAchats.getAvfligCode(), var1);
                  if (this.produits != null) {
                     this.produitsFournisseur = this.produitsFournisseurDao.selectProdFourByprodFic(this.produits, this.tiers, var1);
                     if (this.produitsFournisseur != null) {
                        this.avoirLigneAchats.setAvfligReference(this.produitsFournisseur.getProfouRef());
                        this.avoirLigneAchats.setAvfligLibelleFournisseur(this.produitsFournisseur.getProfouLib());
                        this.avoirLigneAchats = this.avoirLigneAchatsDao.modifLigne(this.avoirLigneAchats, var1);
                     }
                  }
               }

               var2.add(this.avoirLigneAchats);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(Math.abs(this.avoirEnteteAchats.getAvfTotTtc()) + Math.abs(this.avoirEnteteAchats.getAvfTotTc()), this.avoirEnteteAchats.getAvfDevise());
      JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(var2);
      return var11;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.avoirEnteteAchats.getAvfAnal2() != null && !this.avoirEnteteAchats.getAvfAnal2().isEmpty()) {
         String var4 = "";
         if (this.avoirEnteteAchats.getAvfAnal2().contains(":")) {
            String[] var5 = this.avoirEnteteAchats.getAvfAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.avoirEnteteAchats.getAvfAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.avoirEnteteAchats.getAvfDateImp() != null) {
            var2 = true;
         }

         this.avoirEnteteAchats.setAvfDateImp(new Date());
         if (this.avoirEnteteAchats.getAvfEtat() == 0 && this.avoirEnteteAchats.getAvfEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.avoirEnteteAchats.setAvfEtat(1);
            if (this.tiers.getTieDteDocument7() == null || this.avoirEnteteAchats.getAvfDate().after(this.tiers.getTieDteDocument7())) {
               this.tiers.setTieDteDocument7(this.avoirEnteteAchats.getAvfDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.avoirEnteteAchats.setAvfModeleImp(var1);
         this.avoirEnteteAchats = this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var3);
         this.contacts = new Contacts();
         if (this.avoirEnteteAchats.getAvfIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.avoirEnteteAchats.getAvfIdContact(), var3);
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
            var1.setEntete("Impression avoir");
            var1.setMontant_lettre(this.montant_lettre);
            if (this.avoirEnteteAchats.getAvfFormule1() != null && !this.avoirEnteteAchats.getAvfFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog, this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.avoirEnteteAchats.getAvfEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.avoirEnteteAchats.getAvfIdResponsable());
            var1.setTiersSelectionne(this.avoirEnteteAchats.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.avoirEnteteAchats.getAvfNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.avoirEnteteAchats.getAvfId());
            if (this.avoirEnteteAchats.getAvfAnal2() != null && !this.avoirEnteteAchats.getAvfAnal2().isEmpty()) {
               String var12 = "";
               if (this.avoirEnteteAchats.getAvfAnal2().contains(":")) {
                  String[] var13 = this.avoirEnteteAchats.getAvfAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.avoirEnteteAchats.getAvfAnal2();
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
         var1.setEntete("Impression de la liste des avoirs");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "avoir" + File.separator);
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
            this.uniteGraph = "AVOIRS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "AVOIRS : Quantites";
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
         }

         new AvoirEnteteAchats();
         AvoirLigneAchats var15 = new AvoirLigneAchats();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirLigne");
         String var6 = "";

         AvoirEnteteAchats var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (AvoirEnteteAchats)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getAvfNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getAvfNum() + "'";
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

                  var14 = (AvoirEnteteAchats)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getAvfDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getAvfNomResponsable() != null && !var14.getAvfNomResponsable().isEmpty()) {
                        var17 = var14.getAvfNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getAvfNomTiers() != null && !var14.getAvfNomTiers().isEmpty()) {
                        var17 = var14.getAvfNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  }

                  if (var15.getAvfligDevise().equals(this.structureLog.getStrdevise())) {
                     var20 = (long)var14.getAvfTotHt();
                  } else {
                     float var21 = this.utilNombre.deviseTaux1(var15.getAvoirEnteteAchats().getAvfDevise(), var15.getAvoirEnteteAchats().getAvfDate());
                     var20 = (long)(var14.getAvfTotHt() * (double)var21);
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getAvfDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getAvfDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getAvfDate().getMonth() + 1 >= 1 && var14.getAvfDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getAvfDate().getMonth() + 1 >= 4 && var14.getAvfDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getAvfDate().getMonth() + 1 >= 7 && var14.getAvfDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getAvfDate().getMonth() + 1 >= 10 && var14.getAvfDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getAvfDate().getMonth() + 1 >= 1 && var14.getAvfDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getAvfDate().getMonth() + 1 >= 7 && var14.getAvfDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getAvfDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.avoirLigneAchatsDao.chargerLesLignesAvoirs(var6, var5);
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

                  var15 = (AvoirLigneAchats)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getAvoirEnteteAchats().getAvfDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getAvoirEnteteAchats().getAvfNomResponsable() != null && !var15.getAvoirEnteteAchats().getAvfNomResponsable().isEmpty()) {
                        var8 = var15.getAvoirEnteteAchats().getAvfNomResponsable();
                     } else {
                        var8 = "Sans responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getAvoirEnteteAchats().getAvfNomTiers() != null && !var15.getAvoirEnteteAchats().getAvfNomTiers().isEmpty()) {
                        var8 = var15.getAvoirEnteteAchats().getAvfNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getAvfligFamille() != null && !var15.getAvfligFamille().isEmpty()) {
                        var8 = var15.getAvfligFamille();
                     } else {
                        var8 = "Sans Famille produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getAvfligLibelle() != null && !var15.getAvfligLibelle().isEmpty()) {
                        var8 = var15.getAvfligLibelle();
                     } else {
                        var8 = "Sans Libelle produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     if (var15.getAvfligDevise().equals(this.structureLog.getStrdevise())) {
                        var9 = (long)var15.getAvfligPt();
                     } else {
                        float var22 = this.utilNombre.deviseTaux1(var15.getAvoirEnteteAchats().getAvfDevise(), var15.getAvoirEnteteAchats().getAvfDate());
                        var9 = (long)(var15.getAvfligPt() * (double)var22);
                     }
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getAvfligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getAvoirEnteteAchats().getAvfDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 >= 1 && var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 >= 4 && var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 >= 7 && var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 >= 10 && var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 >= 1 && var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 >= 7 && var15.getAvoirEnteteAchats().getAvfDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getAvoirEnteteAchats().getAvfDate().getHours();
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

   public AvoirEnteteAchats getAvoirEnteteAchats() {
      return this.avoirEnteteAchats;
   }

   public void setAvoirEnteteAchats(AvoirEnteteAchats var1) {
      this.avoirEnteteAchats = var1;
   }

   public AvoirLigneAchats getAvoirLigneAchats() {
      return this.avoirLigneAchats;
   }

   public void setAvoirLigneAchats(AvoirLigneAchats var1) {
      this.avoirLigneAchats = var1;
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

   public List getLisTaxesAchats() {
      return this.lisTaxesAchats;
   }

   public void setLisTaxesAchats(List var1) {
      this.lisTaxesAchats = var1;
   }

   public boolean isGriserValider() {
      return this.griserValider;
   }

   public void setGriserValider(boolean var1) {
      this.griserValider = var1;
   }

   public int getNumLigne() {
      return this.numLigne;
   }

   public void setNumLigne(int var1) {
      this.numLigne = var1;
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
