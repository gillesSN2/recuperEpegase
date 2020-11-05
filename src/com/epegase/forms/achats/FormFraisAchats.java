package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
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

public class FormFraisAchats implements Serializable {
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
   private String nomTier;
   private List lesFamilleFournisseursListe;
   private List lesModeReglementFournisseurListe;
   private String informationsTiers;
   private TiersDao tiersDao;
   private Users responsable;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private List lesUsers = new ArrayList();
   private Contacts contacts;
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private String libelleDossier;
   private String libelleDossierFiche;
   private PlansAnalytiques dossier = new PlansAnalytiques();
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private FraisEnteteAchats fraisEnteteAchats = new FraisEnteteAchats();
   private FraisEnteteAchatsDao fraisEnteteAchatsDao;
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
   private long var_nom_responsable;
   private long var_nom_contact;
   private List mesDocumentsConcernes = new ArrayList();
   private CommandeEnteteAchatsDao commandeEnteteAchatsDao;
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private transient DataModel datamodelFacture = new ListDataModel();
   private Date var_date_trf;
   private transient DataModel datamodelTransfert = new ListDataModel();
   private String var_modele_trf;
   private FraisLigneAchats fraisLigneAchats = new FraisLigneAchats();
   private FraisLigneAchatsDao fraisLigneAchatsDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private ServiceDao serviceDao;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private ProduitsTarifDao produitsTarifdao;
   private TaxesAchatsDao taxesAchatsDao;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private List mesTaxesAchatsItems;
   private List mesTaxesAchatsProduits = new ArrayList();
   private List lisTaxesAchats;
   private boolean verrou_libelle = false;
   private List mesUnitesItems;
   private boolean var_aff_unite = false;
   private int var_code_unite;
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
   private double inpMontant = 0.0D;
   private String inpNumFacture = "";
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
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String var_inpModeleImp;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private List mesBudgetsItems;
   private List mesTypeReglementsCaisse = new ArrayList();
   private List listCaisses;
   private List mesCaissesSeriesItems = new ArrayList();
   private BonDecaissementAchat bonDecaissementAchat;
   private BonDecaissementAchatDao bonDecaissementAchatDao;
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
   private boolean showModalPanelDossier = false;
   private String nouveauDossier;
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

   public FormFraisAchats() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.fraisEnteteAchatsDao = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fraisLigneAchatsDao = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonDecaissementAchatDao = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteAchatsDao = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      this.var_sansstock = true;
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

      this.periode = this.optionAchats.getAffichInGlobViewFRA();
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

      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
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
      this.inpDossier = "";
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void recupererBudgetItem() throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      PlansBudgetairesDao var1 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      String var2 = "" + this.lastExoCompta.getExecpt_id();
      if (this.fraisEnteteAchats.getFsfActivite() != null && !this.fraisEnteteAchats.getFsfActivite().isEmpty() && this.fraisEnteteAchats.getFsfActivite().contains(":")) {
         String[] var3 = this.fraisEnteteAchats.getFsfActivite().split(":");
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

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         this.inpDossier = "";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpResponsable = "";
         this.inpBudget = "100";
         this.inpActivite = "100";
         this.inpDossier = "";
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
         this.lesEntetesList = this.fraisEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.inpNum, this.inpNumFacture, this.inpMontant, this.inpIdTiersEnCours, this.inpFournisseur, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.inpService, this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.inpBudget, this.inpResponsable, this.inpActivite, this.inpDossier, var10, var11);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new FraisEnteteAchats();

         for(int var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            FraisEnteteAchats var12 = (FraisEnteteAchats)this.lesEntetesList.get(var13);
            var2 += var12.getFsfTotTtc();
            var4 += var12.getFsfTotReglement();
            var6 += var12.getFsfTotHt();
            var8 += var12.getFsfTotTva();
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
            this.fraisEnteteAchats = (FraisEnteteAchats)var1.get(0);
            this.inpNomTiersEnCours = this.fraisEnteteAchats.getFsfNomTiers();
            this.inpIdTiersEnCours = this.fraisEnteteAchats.getTiers().getTieid();
            this.var_date = this.fraisEnteteAchats.getFsfDate();
            if (this.fraisEnteteAchats.getFsfDate().getHours() <= 9) {
               this.var_heure = "0" + this.fraisEnteteAchats.getFsfDate().getHours();
            } else {
               this.var_heure = "" + this.fraisEnteteAchats.getFsfDate().getHours();
            }

            if (this.fraisEnteteAchats.getFsfDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.fraisEnteteAchats.getFsfDate().getMinutes();
            } else {
               this.var_minute = "" + this.fraisEnteteAchats.getFsfDate().getMinutes();
            }

            if (this.fraisEnteteAchats.getFsfDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.fraisEnteteAchats.getFsfDate().getSeconds();
            } else {
               this.var_seconde = "" + this.fraisEnteteAchats.getFsfDate().getSeconds();
            }

            this.tiers = this.fraisEnteteAchats.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.fraisEnteteAchats.getFsfIdContact();
            this.var_nom_responsable = this.fraisEnteteAchats.getFsfIdResponsable();
            this.calculDevise();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
            this.chargerDocumentLigne(var6);
            this.chargerDossierAffaire(var6);
            double var4 = this.chargerBonEncaissement(var6);
            this.chargerLesContactsItem(var6);
            this.chargerUserChrono(var6);
            this.chargerLesUsers(var6);
            this.chargerParapheur(var6);
            this.chargerModeEcheanceAffichage();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.chargerDocumentsConcernes(this.fraisEnteteAchats.getFsfAnal4(), var6);
            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.verrouNum = true;
            this.visibiliteBton = true;
            this.utilInitHibernate.closeSession();
            this.fraisEnteteAchats.setFsfTotReglement(var4);
            if (var4 >= this.fraisEnteteAchats.getFsfTotTtc() + this.fraisEnteteAchats.getFsfTotTimbre()) {
               this.fraisEnteteAchats.setFsfSolde(1);
            } else {
               this.fraisEnteteAchats.setFsfSolde(0);
            }

            this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats);
            this.setMontantTtcElmt(this.fraisEnteteAchats.getFsfTotTtc());
            this.setMontantReglementElmt(this.fraisEnteteAchats.getFsfTotReglement());
            this.setMontantElmTotBonEnc(this.fraisEnteteAchats.getFsfTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.fraisEnteteAchats.getFsfTotTtc() - this.fraisEnteteAchats.getFsfTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.fraisEnteteAchats != null) {
         if (this.fraisEnteteAchats.getFsfEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.fraisEnteteAchats.getFsfDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.fraisEnteteAchats.getFsfDevise());
         if (this.fraisEnteteAchats.getFsfCoefDevise() == 0.0F) {
            if (this.fraisEnteteAchats.getFsfDevise().equals(this.structureLog.getStrdevise())) {
               this.fraisEnteteAchats.setFsfCoefDevise(1.0F);
            } else {
               new ObjetDevises();
               LectureDevises var2 = new LectureDevises();
               ObjetDevises var1 = var2.devisesRecherchee(this.fraisEnteteAchats.getFsfDevise(), this.structureLog.getStrdevise());
               float var3 = Float.parseFloat(var1.getTaux1());
               float var4 = Float.parseFloat(var1.getTaux2());
               var1 = var2.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
               float var5 = Float.parseFloat(var1.getTaux1());
               float var6 = Float.parseFloat(var1.getTaux2());
               this.fraisEnteteAchats.setFsfCoefDevise(var3 * var6);
            }
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.fraisEnteteAchats.getFsfId() > 0L) {
         this.lesLignesList = this.fraisLigneAchatsDao.chargerLesLignes(this.fraisEnteteAchats, var1);
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

      if (this.fraisEnteteAchats != null && this.fraisEnteteAchats.getFsfAnal4() != null && !this.fraisEnteteAchats.getFsfAnal4().isEmpty()) {
         this.dossier = this.plansAnalytiquesDao.rechercheAffaire(this.fraisEnteteAchats.getFsfAnal4(), var1);
         if (this.dossier != null && this.dossier.getAnaNature() != null && !this.dossier.getAnaNature().isEmpty()) {
            if (this.dossier.getAnaNature().equals("6")) {
               this.libelleDossierFiche = "N° Dossier";
            } else if (this.dossier.getAnaNature().equals("10")) {
               this.libelleDossierFiche = "N° Affaire";
            }
         }
      }

   }

   public void chargerDocumentFrais(Session var1) throws HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      new DocumentEntete();
      if (this.fraisEnteteAchats.getFsfId() > 0L && this.fraisEnteteAchats.getFsfAnal4() != null && !this.fraisEnteteAchats.getFsfAnal4().isEmpty()) {
         boolean var4 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
            var4 = true;
         }

         new ArrayList();
         List var5 = this.commandeEnteteAchatsDao.rechercheByDossier(this.fraisEnteteAchats.getFsfAnal4(), (Session)null);
         new ArrayList();
         List var6 = this.receptionEnteteAchatsDao.rechercheByDossier(this.fraisEnteteAchats.getFsfAnal4(), (Session)null);
         RetourEnteteAchatsDao var7 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var8 = var7.rechercheByDossier(this.fraisEnteteAchats.getFsfAnal4(), (Session)null);
         NoteDebitEnteteAchatsDao var9 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var10 = var9.rechercheByDossier(this.fraisEnteteAchats.getFsfAnal4(), (Session)null);
         if (var4) {
            this.utilInitHibernate.closeSession();
         }

         DocumentEntete var3;
         int var11;
         if (var5.size() != 0) {
            for(var11 = 0; var11 < var5.size(); ++var11) {
               var3 = new DocumentEntete();
               var3.setDocCat("Commande");
               var3.setDocDate(((CommandeEnteteAchats)var5.get(var11)).getCmdDate());
               var3.setDocNum(((CommandeEnteteAchats)var5.get(var11)).getCmdNum());
               var3.setDocSerie(((CommandeEnteteAchats)var5.get(var11)).getCmdSerie());
               var3.setDocNomTiers(((CommandeEnteteAchats)var5.get(var11)).getCmdNomTiers());
               var3.setDocActivite(((CommandeEnteteAchats)var5.get(var11)).getCmdActivite());
               var3.setDocLibelle(((CommandeEnteteAchats)var5.get(var11)).getCmdObject());
               var3.setDocTotHt(((CommandeEnteteAchats)var5.get(var11)).getCmdTotHt());
               var2.add(var3);
            }
         }

         if (var6.size() != 0) {
            for(var11 = 0; var11 < var6.size(); ++var11) {
               var3 = new DocumentEntete();
               var3.setDocCat("Réception");
               var3.setDocDate(((ReceptionEnteteAchats)var6.get(var11)).getRecDate());
               var3.setDocNum(((ReceptionEnteteAchats)var6.get(var11)).getRecNum());
               var3.setDocSerie(((ReceptionEnteteAchats)var6.get(var11)).getRecSerie());
               var3.setDocNomTiers(((ReceptionEnteteAchats)var6.get(var11)).getRecNomTiers());
               var3.setDocActivite(((ReceptionEnteteAchats)var6.get(var11)).getRecActivite());
               var3.setDocLibelle(((ReceptionEnteteAchats)var6.get(var11)).getRecObject());
               var3.setDocTotHt(((ReceptionEnteteAchats)var6.get(var11)).getRecTotHt());
               var2.add(var3);
            }
         }

         if (var8.size() != 0) {
            for(var11 = 0; var11 < var8.size(); ++var11) {
               var3 = new DocumentEntete();
               var3.setDocCat("Retour");
               var3.setDocDate(((RetourEnteteAchats)var8.get(var11)).getBrfDate());
               var3.setDocNum(((RetourEnteteAchats)var8.get(var11)).getBrfNum());
               var3.setDocSerie(((RetourEnteteAchats)var8.get(var11)).getBrfSerie());
               var3.setDocNomTiers(((RetourEnteteAchats)var8.get(var11)).getBrfNomTiers());
               var3.setDocActivite(((RetourEnteteAchats)var8.get(var11)).getBrfActivite());
               var3.setDocLibelle(((RetourEnteteAchats)var8.get(var11)).getBrfObject());
               var3.setDocTotHt(((RetourEnteteAchats)var8.get(var11)).getBrfTotHt() * -1.0D);
               var2.add(var3);
            }
         }

         if (var10.size() != 0) {
            for(var11 = 0; var11 < var10.size(); ++var11) {
               var3 = new DocumentEntete();
               var3.setDocCat("Note Débit");
               var3.setDocDate(((NoteDebitEnteteAchats)var10.get(var11)).getNdfDate());
               var3.setDocNum(((NoteDebitEnteteAchats)var10.get(var11)).getNdfNum());
               var3.setDocSerie(((NoteDebitEnteteAchats)var10.get(var11)).getNdfSerie());
               var3.setDocNomTiers(((NoteDebitEnteteAchats)var10.get(var11)).getNdfNomTiers());
               var3.setDocActivite(((NoteDebitEnteteAchats)var10.get(var11)).getNdfActivite());
               var3.setDocLibelle(((NoteDebitEnteteAchats)var10.get(var11)).getNdfObject());
               var3.setDocTotHt(((NoteDebitEnteteAchats)var10.get(var11)).getNdfTotHt());
               var2.add(var3);
            }
         }
      }

      this.datamodelFacture.setWrappedData(var2);
   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonDecaissementAchatDao.rechercheBeByDoc(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.var_tot_bon_encaissement += ((BonDecaissementAchat)var2.get(var3)).getBonAPayer();
         }
      }

      double var7 = 0.0D;
      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = true;

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var6)).getRglDepense();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.fraisEnteteAchats.getFsfTotTtc() + this.fraisEnteteAchats.getFsfTotTc()) {
         if (this.usersLog.getUsrFactureDeCaisse() == 1) {
            this.var_affiche_be = true;
            this.var_affiche_dollar = false;
         } else if (this.usersLog.getUsrFactureDeCaisse() == 2) {
            this.var_affiche_be = false;
            this.var_affiche_dollar = true;
         } else if (this.usersLog.getUsrFactureDeCaisse() == 3) {
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

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null && this.fraisEnteteAchats.getFsfSerie() != null && !this.fraisEnteteAchats.getFsfSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.fraisEnteteAchats.getFsfSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerDocumentsConcernes(String var1, Session var2) throws HibernateException, NamingException {
      this.mesDocumentsConcernes.clear();
      new ArrayList();
      List var3 = this.commandeEnteteAchatsDao.rechercheByDossier(var1, var2);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            new CommandeEnteteAchats();
            CommandeEnteteAchats var5 = (CommandeEnteteAchats)var3.get(var4);
            this.mesDocumentsConcernes.add(new SelectItem("CMD:" + var5.getCmdNum()));
         }
      }

      new ArrayList();
      List var7 = this.receptionEnteteAchatsDao.rechercheByDossier(var1, var2);
      if (var7.size() != 0) {
         for(int var8 = 0; var8 < var7.size(); ++var8) {
            new ReceptionEnteteAchats();
            ReceptionEnteteAchats var6 = (ReceptionEnteteAchats)var7.get(var8);
            this.mesDocumentsConcernes.add(new SelectItem("REC:" + var6.getRecNum()));
         }
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.fraisEnteteAchats.getFsfId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.fraisEnteteAchats.getFsfActivite() != null && !this.fraisEnteteAchats.getFsfActivite().isEmpty() && this.fraisEnteteAchats.getFsfActivite().contains(":")) {
         String[] var1 = null;
         if (!this.fraisEnteteAchats.getFsfActivite().contains("#")) {
            var1 = this.fraisEnteteAchats.getFsfActivite().split(":");
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
            String[] var2 = this.fraisEnteteAchats.getFsfActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.fraisEnteteAchats.getFsfTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.fraisEnteteAchats.getFsfTotHt() - this.totalImputation;
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
      this.fraisEnteteAchats = new FraisEnteteAchats();
      this.fraisLigneAchats = new FraisLigneAchats();
      this.fraisEnteteAchats.setUsers(this.usersLog);
      this.fraisEnteteAchats.setFsfIdCreateur(this.usersLog.getUsrid());
      this.fraisEnteteAchats.setFsfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.fraisEnteteAchats.setFsfIdResponsable(this.usersLog.getUsrid());
      this.fraisEnteteAchats.setFsfNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.fraisEnteteAchats.setFsfDate(new Date());
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
      this.mesDocumentsConcernes.clear();
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

      this.autorisationDocument();
      this.chargerLesFrais();
      this.addLigne();
   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionAchats.getNbrJrRelanceFRA() != null && !this.optionAchats.getNbrJrRelanceFRA().isEmpty()) {
         var3 = Integer.parseInt(this.optionAchats.getNbrJrRelanceFRA());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionAchats.getNbrJrValidFRA() != null && !this.optionAchats.getNbrJrValidFRA().isEmpty()) {
         var4 = Integer.parseInt(this.optionAchats.getNbrJrValidFRA());
      } else {
         var4 = 0;
      }

      this.fraisEnteteAchats.setFsfDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.fraisEnteteAchats.setFsfDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
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
            this.mesUsersItem.add(new SelectItem(this.fraisEnteteAchats.getFsfIdResponsable(), this.fraisEnteteAchats.getFsfNomResponsable()));
         }

         this.autorisationDocument();
         this.chargerLesFrais();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.fraisEnteteAchats != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.fraisEnteteAchats.getFsfIdResponsable(), this.fraisEnteteAchats.getFsfNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fraisEnteteAchats.getFsfEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.fraisEnteteAchats.setFsfEtat(1);
               this.fraisEnteteAchats.setFsfDateValide(new Date());
               if (this.fraisEnteteAchats.getFsfAnal4() != null && !this.fraisEnteteAchats.getFsfAnal4().isEmpty()) {
                  new ValorisationEnteteAchats();
                  ValorisationEnteteAchatsDao var4 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  ValorisationEnteteAchats var3 = var4.rechercheByDossier(this.fraisEnteteAchats.getFsfAnal4(), var1);
                  if (var3 != null) {
                     this.fraisEnteteAchats.setFsfValo(var3.getValNum());
                  }
               }

               this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Validation manuelle frais (F.) N° " + this.fraisEnteteAchats.getFsfNum() + " du " + this.utilDate.dateToStringSQLLight(this.fraisEnteteAchats.getFsfDate()));
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
      if (this.fraisEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fraisEnteteAchats.getFsfEtat() == 1) {
               this.fraisEnteteAchats.setFsfEtat(0);
               this.fraisEnteteAchats.setFsfDateValide((Date)null);
               this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
               new ArrayList();
               List var3 = this.bonDecaissementAchatDao.rechercheBeByDoc(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
               if (var3.size() != 0) {
                  for(int var4 = 0; var4 < var3.size(); ++var4) {
                     this.bonDecaissementAchat = (BonDecaissementAchat)var3.get(var4);
                     this.bonDecaissementAchatDao.delete(this.bonDecaissementAchat, var1);
                  }
               }

               this.var_tot_bon_encaissement = 0.0D;
               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Dévalidation manuelle frais (F.) N° " + this.fraisEnteteAchats.getFsfNum() + " du " + this.utilDate.dateToStringSQLLight(this.fraisEnteteAchats.getFsfDate()));
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
      if (this.fraisEnteteAchats != null) {
         this.fraisEnteteAchats.setFsfEtat(0);
         this.fraisEnteteAchats.setFsfDateAnnule((Date)null);
         this.fraisEnteteAchats.setFsfMotifAnnule("");
         this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fraisEnteteAchats.getFsfNum();
            Date var4 = this.fraisEnteteAchats.getFsfDate();
            this.lesEntetesList.remove(this.fraisEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.fraisLigneAchatsDao.deleteAllLigne(this.fraisEnteteAchats, var1);
            this.utilParapheur.supprimerParapheur(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
            this.fraisEnteteAchatsDao.delete(this.fraisEnteteAchats.getFsfId(), var1);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression frais achat N° " + var3 + " du " + var4);
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

   public void chargerModeEcheanceAffichage() {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      if (this.fraisEnteteAchats.getFsfTypeReg() != 0 && this.fraisEnteteAchats.getFsfTypeReg() != 3) {
         if (this.fraisEnteteAchats.getFsfTypeReg() != 1 && this.fraisEnteteAchats.getFsfTypeReg() != 2 && this.fraisEnteteAchats.getFsfTypeReg() != 10) {
            if (this.fraisEnteteAchats.getFsfTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.fraisEnteteAchats.getFsfModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.fraisEnteteAchats.getFsfModeReg() != null && !this.fraisEnteteAchats.getFsfModeReg().isEmpty() && this.fraisEnteteAchats.getFsfModeReg().contains(":")) {
         String[] var2 = this.fraisEnteteAchats.getFsfModeReg().split(":");
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

            this.fraisEnteteAchats.setFsfTypeReg(Integer.parseInt(var3.getEcheances()));
            this.fraisEnteteAchats.setFsfModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.fraisEnteteAchats.setFsfNbJourReg(0);
            this.fraisEnteteAchats.setFsfArrondiReg(0);
            break;
         }
      }

      if (this.fraisEnteteAchats.getFsfTypeReg() != 0 && this.fraisEnteteAchats.getFsfTypeReg() != 3) {
         if (this.fraisEnteteAchats.getFsfTypeReg() != 1 && this.fraisEnteteAchats.getFsfTypeReg() != 2 && this.fraisEnteteAchats.getFsfTypeReg() != 10) {
            if (this.fraisEnteteAchats.getFsfTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementFournisseurListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.fraisEnteteAchats.setFsfTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.fraisEnteteAchats.setFsfModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.fraisEnteteAchats.setFsfNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.fraisEnteteAchats.setFsfArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.fraisEnteteAchats.getFsfModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.fraisEnteteAchats.getFsfDate(), this.fraisEnteteAchats.getFsfTypeReg(), this.fraisEnteteAchats.getFsfNbJourReg(), this.fraisEnteteAchats.getFsfArrondiReg());
      this.fraisEnteteAchats.setFsfDateEcheReg(var1);
   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.fraisEnteteAchats.setFsfDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.fraisEnteteAchats.getUsers() == null) {
            this.fraisEnteteAchats.setUsers(this.usersLog);
         }

         this.fraisEnteteAchats.setTiers(this.tiers);
         if ((this.fraisEnteteAchats.getFsfCat() == null || this.fraisEnteteAchats.getFsfCat().isEmpty()) && this.fraisEnteteAchats.getTiers().getTienomfamille() != null && !this.fraisEnteteAchats.getTiers().getTienomfamille().isEmpty()) {
            this.fraisEnteteAchats.setFsfCat(this.fraisEnteteAchats.getTiers().getTienomfamille());
         }

         if (!this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.fraisEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.fraisEnteteAchats.setFsfCivilTiers("");
         } else {
            this.fraisEnteteAchats.setFsfCivilTiers(this.fraisEnteteAchats.getTiers().getTiecivilite());
         }

         if (this.fraisEnteteAchats.getFsfDiversTiers() == 99) {
            this.fraisEnteteAchats.setFsfIdContact(0L);
            this.fraisEnteteAchats.setFsfNomContact("");
            this.fraisEnteteAchats.setFsfCivilContact("");
         } else {
            new Contacts();
            Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
            if (var3 != null) {
               this.fraisEnteteAchats.setFsfIdContact(var3.getConid());
               this.fraisEnteteAchats.setFsfNomContact(var3.getConpatronyme());
               this.fraisEnteteAchats.setFsfCivilContact(var3.getConcivilite());
            } else {
               this.fraisEnteteAchats.setFsfIdContact(0L);
               this.fraisEnteteAchats.setFsfNomContact("");
               this.fraisEnteteAchats.setFsfCivilContact("");
            }
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var17 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var17 != null) {
            this.fraisEnteteAchats.setFsfIdResponsable(var17.getUsrid());
            this.fraisEnteteAchats.setFsfNomResponsable(var17.getUsrPatronyme());
         } else {
            this.fraisEnteteAchats.setFsfIdResponsable(0L);
            this.fraisEnteteAchats.setFsfNomResponsable("");
         }

         double var4 = 0.0D;
         if (this.lesLignesList.size() != 0) {
            for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
               if (((FraisLigneAchats)this.lesLignesList.get(var6)).getFsfligMode() == 4) {
                  var4 += ((FraisLigneAchats)this.lesLignesList.get(var6)).getFsfligTtc();
               }
            }
         }

         this.fraisEnteteAchats.setFsfTotTvaDouane(var4);
         if (this.fraisEnteteAchats.getFsfId() != 0L) {
            if (this.fraisEnteteAchats.getFsfEtat() == 6) {
               if (this.fraisEnteteAchats.getFsfEtatVal() == 1) {
                  this.fraisEnteteAchats.setFsfEtat(0);
               } else {
                  this.fraisEnteteAchats.setFsfEtat(0);
               }
            }

            this.fraisEnteteAchats.setFsfDateModif(new Date());
            this.fraisEnteteAchats.setFsfIdModif(this.usersLog.getUsrid());
            this.fraisEnteteAchats.setFsfNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.fraisEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.fraisEnteteAchats.setFsfDateCreat(new Date());
            this.fraisEnteteAchats.setFsfIdCreateur(this.usersLog.getUsrid());
            this.fraisEnteteAchats.setFsfNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.fraisEnteteAchats.getFsfSerie() != null && !this.fraisEnteteAchats.getFsfSerie().equalsIgnoreCase("X") && !this.fraisEnteteAchats.getFsfSerie().isEmpty()) {
               this.fraisEnteteAchats.setFsfNum(this.calculChrono.numCompose(this.fraisEnteteAchats.getFsfDate(), this.nature, this.fraisEnteteAchats.getFsfSerie(), var1));
               boolean var19 = false;

               label276:
               while(true) {
                  while(true) {
                     if (var19) {
                        break label276;
                     }

                     new FraisEnteteAchats();
                     FraisEnteteAchats var7 = this.fraisEnteteAchatsDao.pourParapheur(this.fraisEnteteAchats.getFsfNum(), this.fraisEnteteAchats.getFsfSerie(), var1);
                     if (var7 != null) {
                        long var8 = 100000000L * this.usersLog.getUsrid();

                        for(long var10 = 0L; var10 < var8; ++var10) {
                        }

                        this.fraisEnteteAchats.setFsfNum(this.calculChrono.numCompose(this.fraisEnteteAchats.getFsfDate(), this.nature, this.fraisEnteteAchats.getFsfSerie(), var1));
                        var19 = false;
                     } else {
                        var19 = true;
                     }
                  }
               }
            } else {
               long var18 = this.fraisEnteteAchatsDao.selectLastNum(var1);
               this.fraisEnteteAchats.setFsfNum("" + var18);
            }

            this.fraisEnteteAchats.setFsfEtat(0);
            this.fraisEnteteAchats.setFsfEtatVal(0);
            this.fraisEnteteAchats.setFsfDateValide((Date)null);
            this.fraisEnteteAchats = this.fraisEnteteAchatsDao.insert(this.fraisEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.fraisEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.fraisEnteteAchats.getFsfId(), this.fraisEnteteAchats.getFsfNum(), this.fraisEnteteAchats.getFsfNomTiers(), this.fraisEnteteAchats.getFsfDate(), this.fraisEnteteAchats.getFsfDevise(), this.fraisEnteteAchats.getFsfTotTtc() + this.fraisEnteteAchats.getFsfTotTc(), this.fraisEnteteAchats.getFsfModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
         }

         var2.commit();
      } catch (HibernateException var15) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majAnalytique() throws HibernateException, NamingException {
      this.fraisEnteteAchats.setFsfSite(this.usersLog.getUsrSite());
      this.fraisEnteteAchats.setFsfDepartement(this.usersLog.getUsrDepartement());
      this.fraisEnteteAchats.setFsfService(this.usersLog.getUsrService());
      this.fraisEnteteAchats.setFsfRegion(this.tiers.getTieregion());
      this.fraisEnteteAchats.setFsfSecteur(this.tiers.getTiesecteur());
      this.fraisEnteteAchats.setFsfPdv(this.tiers.getTiepdv());
      if (!this.var_anal_activite) {
         this.fraisEnteteAchats.setFsfActivite("");
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

            this.fraisEnteteAchats.setFsfActivite(var1);
         }
      } else {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         String var14 = "";
         boolean var15 = true;
         new FraisLigneAchats();
         new Produits();
         if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
            ArrayList var6 = new ArrayList();
            ObjetTarif var7 = new ObjetTarif();
            int var8 = 0;

            label105:
            while(true) {
               if (var8 >= this.lesLignesList.size()) {
                  var8 = 0;

                  while(true) {
                     if (var8 >= var6.size()) {
                        break label105;
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

               FraisLigneAchats var4 = (FraisLigneAchats)this.lesLignesList.get(var8);
               if (var4.getFsfligCode() != null && !var4.getFsfligCode().isEmpty()) {
                  Produits var5 = this.produitsDao.chargeProduit(var4.getFsfligCode(), var13);
                  if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                     if (var6.size() == 0) {
                        var7 = new ObjetTarif();
                        var7.setNomLibelle(var5.getProActivite());
                        var7.setPrix(var4.getFsfligPt());
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
                           var7.setPrix(var4.getFsfligPt());
                           var6.add(var7);
                        } else if (var9 && var7 != null) {
                           var7.setPrix(var10 + var4.getFsfligPt());
                           var6.remove(var7);
                           var6.add(var7);
                        }
                     }
                  }
               }

               ++var8;
            }
         }

         this.fraisEnteteAchats.setFsfActivite(var14);
         this.utilInitHibernate.closeSession();
      }

      if (this.fraisEnteteAchats.getFsfAnal4() != null && this.fraisEnteteAchats.getFsfAnal4().length() <= 2) {
         this.fraisEnteteAchats.setFsfAnal4("");
      }

      if (!this.var_anal_parc) {
         this.fraisEnteteAchats.setFsfAnal2("");
      } else if (this.fraisEnteteAchats.getFsfAnal2() != null && this.fraisEnteteAchats.getFsfAnal2().length() <= 2) {
         this.fraisEnteteAchats.setFsfAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.fraisEnteteAchats.setFsfEtatVal(1);
         this.fraisEnteteAchats.setFsfEtat(0);
         this.fraisEnteteAchats.setFsfDateValide((Date)null);
         return true;
      } else {
         this.fraisEnteteAchats.setFsfEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.fraisEnteteAchats.setFsfEtat(1);
               this.fraisEnteteAchats.setFsfDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.fraisEnteteAchats.setFsfEtat(0);
               this.fraisEnteteAchats.setFsfDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.fraisEnteteAchats != null) {
         this.fraisEnteteAchats.setFsfDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
         if (this.fraisEnteteAchats.getFsfDateAnnule() == null) {
            this.fraisEnteteAchats.setFsfDateAnnule(new Date());
         }

         this.fraisEnteteAchats.setFsfEtat(3);
         this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation frais achat N° " + this.fraisEnteteAchats.getFsfNum() + " le " + this.fraisEnteteAchats.getFsfDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.fraisEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void chargerLesFrais() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionAchats.getChargerFRA().equals("1")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         new ArrayList();
         List var2 = this.produitsDao.chargerLesProduitsByNature("0112", var1);
         if (var2 != null && var2.size() != 0) {
            int var3 = 0;

            while(true) {
               if (var3 >= var2.size()) {
                  this.datamodelLigne.setWrappedData(this.lesLignesList);
                  break;
               }

               this.produits = (Produits)var2.get(var3);
               if (this.produits.getProInactif() == 0) {
                  boolean var4 = false;
                  if (this.lesLignesList.size() != 0) {
                     new FraisLigneAchats();

                     for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                        FraisLigneAchats var5 = (FraisLigneAchats)this.lesLignesList.get(var6);
                        if (var5.getFsfligCode() != null && !var5.getFsfligCode().isEmpty() && var5.getFsfligCode().equals(this.produits.getProCode())) {
                           var4 = true;
                           break;
                        }
                     }
                  }

                  if (!var4) {
                     this.fraisLigneAchats = new FraisLigneAchats();
                     this.calculeProduits(var1);
                     this.lesLignesList.add(this.fraisLigneAchats);
                  }
               }

               ++var3;
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void calculDisponibilite() throws HibernateException, NamingException {
      this.fraisEnteteAchats.setFsfBudgetDispo(0.0D);
      this.fraisEnteteAchats.setFsfBudgetDispoMois(0.0D);
      this.fraisEnteteAchats.setFsfBudgetTreso(0.0D);
      this.fraisEnteteAchats.setFsfBudgetTresoMois(0.0D);
      if (this.fraisEnteteAchats.getFsfBudget() != null && this.fraisEnteteAchats.getFsfBudget().contains(":")) {
         String var1 = "" + this.lastExoCompta.getExecpt_id();
         String[] var2 = this.fraisEnteteAchats.getFsfBudget().split(":");
         String var3 = null;
         if (this.fraisEnteteAchats.getFsfActivite() != null && !this.fraisEnteteAchats.getFsfActivite().isEmpty()) {
            String[] var4 = this.fraisEnteteAchats.getFsfActivite().split(":");
            var3 = var4[0];
         }

         int var27 = this.fraisEnteteAchats.getFsfDate().getMonth() + 1;
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
         List var24 = var23.selectLesDisponibilites(this.lastExoCompta.getExecpt_id(), this.fraisEnteteAchats.getFsfDate(), (Session)null);
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

         this.fraisEnteteAchats.setFsfBudgetDispo(var5 - var28);
         this.fraisEnteteAchats.setFsfBudgetDispoMois(var7 - var13);
         this.fraisEnteteAchats.setFsfBudgetTreso(var15 - var19);
         this.fraisEnteteAchats.setFsfBudgetTresoMois(var17 - var21);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.fraisEnteteAchats.getFsfExoTva() == 0 || this.fraisEnteteAchats.getFsfExoTva() == 2 || this.fraisEnteteAchats.getFsfExoTva() == 3) {
         if (var1 != null && !var1.isEmpty()) {
            new TaxesAchats();
            TaxesAchats var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxachTaux();
               var6 = var8.getTaxachCode();
               var7 = var8.getTaxachType();
            }
         } else {
            var5 = var2;
            var6 = var1;
            var7 = 0;
         }
      }

      if (this.produits != null && this.produits.isProExoTva() || this.tiers != null && this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
         var5 = 0.0F;
         var6 = "";
         var7 = 0;
      }

      this.fraisLigneAchats.setFsfligTaxe(var6);
      this.fraisLigneAchats.setFsfligTauxTaxe(var5);
      double var28 = this.fraisLigneAchats.getFsfligPu();
      double var10 = 0.0D;
      var10 = var28 * (double)this.fraisLigneAchats.getFsfligQte();
      double var12 = 0.0D;
      double var14 = 0.0D;
      if (this.optionAchats.getDecrmtRabais().equals("1")) {
         var14 = this.fraisLigneAchats.getFsfligRabais();
      } else if (this.optionAchats.getDecrmtRabais().equals("2")) {
         var14 = this.fraisLigneAchats.getFsfligRabais() * (double)this.fraisLigneAchats.getFsfligQte();
      }

      if (this.fraisLigneAchats.getFsfligTauxRemise() != 0.0F) {
         var12 = var10 - var10 * (double)this.fraisLigneAchats.getFsfligTauxRemise() / 100.0D - var14;
      } else {
         var12 = var10 - var14;
      }

      double var16 = this.utilNombre.myRoundFormat(var12, this.var_format_devise);
      double var18 = var16 * (double)this.fraisLigneAchats.getFsfligTauxTaxe() / 100.0D;
      if (var7 == 2 || var7 == 3) {
         var18 = var16 * (double)(this.fraisLigneAchats.getFsfligTauxTaxe() / 100.0F);
         var18 *= -1.0D;
      }

      double var20 = this.utilNombre.myRoundFormat(var18, this.var_format_devise);
      double var22 = var16 + var20;
      double var24 = 0.0D;
      var24 = this.utilNombre.myRound(var16 / (double)this.fraisLigneAchats.getFsfligQte(), 2);
      this.fraisLigneAchats.setFsfligPuRem(var24);
      this.fraisLigneAchats.setFsfligPt(var16);
      this.fraisLigneAchats.setFsfligTva(var20);
      this.fraisLigneAchats.setFsfligTc(0.0D);
      this.fraisLigneAchats.setFsfligTtc(var22);
      this.calculDevise();
      double var26 = this.utilNombre.myRoundDevise(this.fraisLigneAchats.getFsfligPt() * (double)this.fraisEnteteAchats.getFsfCoefDevise(), this.structureLog.getStrdevise());
      this.fraisLigneAchats.setFsfligPtLocal(var26);
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix(this.fraisLigneAchats.getFsfligTaxe(), this.fraisLigneAchats.getFsfligTauxTaxe(), (Session)null);
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
      double var11 = 0.0D;
      new FraisLigneAchats();

      for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
         FraisLigneAchats var13 = (FraisLigneAchats)this.lesLignesList.get(var14);
         if (var13.getFsfligMode() == 4) {
            var5 += var13.getFsfligTtc();
            var3 = var3 + var13.getFsfligTva() + var13.getFsfligTtc();
            var7 += var13.getFsfligTtc();
            var9 += var13.getFsfligTc();
         } else {
            var1 += var13.getFsfligPt();
            var7 += var13.getFsfligTtc();
            var9 += var13.getFsfligTc();
            var3 += var13.getFsfligTva();
         }

         if (var13.getFsfligRabais() != 0.0D || var13.getFsfligTauxRemise() != 0.0F) {
            var11 += var13.getFsfligPu() * (double)var13.getFsfligQte() - var13.getFsfligPt();
         }
      }

      this.fraisEnteteAchats.setFsfTotHt(var1);
      this.fraisEnteteAchats.setFsfTotTtc(var7);
      this.fraisEnteteAchats.setFsfTotTc(var9);
      this.fraisEnteteAchats.setFsfTotTva(var3);
      this.fraisEnteteAchats.setFsfTotTvaDouane(var5);
      this.fraisEnteteAchats.setFsfTotRemise(var11);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesAchatsProduits.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.fraisLigneAchats = (FraisLigneAchats)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         if (this.fraisLigneAchats.getFsfligCode() != null && this.fraisLigneAchats.getFsfligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.fraisLigneAchats.getFsfligCode(), var1);
            if (this.produits != null) {
               this.fraisLigneAchats.setFsfligCode(this.produits.getProCode());
               this.fraisLigneAchats.setFsfligFamille(this.produits.getProAchCode());
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
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
      }

   }

   public void addLigne() {
      this.produits = new Produits();
      this.fraisLigneAchats = new FraisLigneAchats();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_code_unite = 0;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.fraisLigneAchats.getFsfligCode() != null && !this.fraisLigneAchats.getFsfligCode().isEmpty()) {
         if (this.fraisEnteteAchats.getFsfId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.fraisLigneAchats.setFsfligQte(1.0F);
            if (this.fraisLigneAchats.getFsfligTaxe() != null && !this.fraisLigneAchats.getFsfligTaxe().equals("0") && !this.fraisLigneAchats.getFsfligTaxe().isEmpty()) {
               if (this.fraisLigneAchats.getFsfligTauxTaxe() == 0.0F) {
                  this.fraisLigneAchats.setFsfligTauxTaxe(this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.fraisLigneAchats.getFsfligTaxe(), var1).getTaxachTaux());
               }
            } else {
               this.fraisLigneAchats.setFsfligTaxe("0");
               this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
            }

            this.calculPrix(this.fraisLigneAchats.getFsfligTaxe(), this.fraisLigneAchats.getFsfligTauxTaxe(), var1);
            if (this.fraisLigneAchats.getFsfligId() == 0L) {
               this.fraisLigneAchats.setFraisEnteteAchats(this.fraisEnteteAchats);
               this.fraisLigneAchats.setFsfligDevise(this.fraisEnteteAchats.getFsfDevise());
               this.fraisLigneAchats = this.fraisLigneAchatsDao.insertLigne(this.fraisLigneAchats, var1);
               if (this.optionAchats.getChargerFRA().equals("1")) {
                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               } else {
                  this.lesLignesList.add(this.fraisLigneAchats);
                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               }
            } else {
               this.fraisLigneAchats = this.fraisLigneAchatsDao.modifLigne(this.fraisLigneAchats, var1);
            }

            if (this.produits != null && this.produits.getProId() != 0L && this.tiers != null) {
               new ProduitsFournisseur();
               ProduitsFournisseurDao var4 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
               ProduitsFournisseur var3 = var4.selectProdFourByprodFic(this.produits, this.tiers, var1);
               if (var3 == null) {
                  var3 = new ProduitsFournisseur();
               }

               var3.setProfouDevise(this.fraisEnteteAchats.getFsfDevise());
               var3.setProfouFormat(this.fraisEnteteAchats.getVar_format_devise());
               if (var3.getProfouLib() == null || var3.getProfouLib().isEmpty()) {
                  var3.setProfouLib(this.fraisLigneAchats.getFsfligLibelle());
               }

               var3.setProfouDate(this.fraisEnteteAchats.getFsfDate());
               var3.setProfouPa(this.fraisLigneAchats.getFsfligPu());
               if (this.structureLog.getStrdevise().equalsIgnoreCase(this.fraisEnteteAchats.getFsfDevise())) {
                  var3.setProfouCoefLocal(1.0F);
                  var3.setProfouPaLocal(var3.getProfouPa());
               } else {
                  var3.setProfouCoefLocal(this.utilNombre.deviseTaux2(this.structureLog.getStrdevise(), var3.getProfouDate()));
                  var3.setProfouPaLocal(this.utilNombre.myRoundDevise(var3.getProfouPa() * (double)var3.getProfouCoefLocal(), this.structureLog.getStrdevise()));
               }

               var3.setProfouCoefEuro(this.utilNombre.deviseTaux1(var3.getProfouDevise(), var3.getProfouDate()));
               var3.setProfouPaEuro(this.utilNombre.myRoundFormat(var3.getProfouPa() * (double)var3.getProfouCoefEuro(), 1));
               if (var3.getProfouId() == 0L) {
                  var3.setProduits(this.produits);
                  var3.setTiers(this.tiers);
                  var4.insert(var3, var1);
               } else {
                  var4.modif(var3, var1);
               }
            }

            this.cumulPrix();
            this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
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

      this.addLigne();
   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.fraisLigneAchats.getFsfligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fraisLigneAchats.getFsfligCode();
            this.fraisLigneAchatsDao.deleteOneLigne(this.fraisLigneAchats, var1);
            new ArrayList();
            List var4 = (List)this.datamodelLigne.getWrappedData();
            var4.remove(this.fraisLigneAchats);
            this.datamodelLigne.setWrappedData(var4);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression ligne produit " + var3 + " de la frais achat N° " + this.fraisEnteteAchats.getFsfNum() + " du " + this.fraisEnteteAchats.getFsfDate());
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
      }

   }

   public void calculPuLocal() throws HibernateException, NamingException {
      if (this.lesLignesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.fraisLigneAchats = (FraisLigneAchats)this.lesLignesList.get(var3);
               if (this.fraisEnteteAchats.getFsfCoefDevise() == 0.0F) {
                  this.fraisEnteteAchats.setFsfCoefDevise(1.0F);
               }

               double var4 = this.fraisLigneAchats.getFsfligPt() * (double)this.fraisEnteteAchats.getFsfCoefDevise();
               this.fraisLigneAchats.setFsfligPtLocal(var4);
               this.fraisLigneAchats = this.fraisLigneAchatsDao.modifLigne(this.fraisLigneAchats, var1);
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

   }

   public void rechercheDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      String var1 = "" + (this.var_date.getYear() + 1900);
      this.dossier = new PlansAnalytiques();
      if (this.optionAchats.getAxeDossier().equals("2")) {
         this.dossier = this.formRecherche.rechercheAffaire(this.fraisEnteteAchats.getFsfAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.fraisEnteteAchats.getFsfSerie(), this.fraisEnteteAchats.getFsfDevise());
      } else {
         this.dossier = this.formRecherche.rechercheDossier(this.fraisEnteteAchats.getFsfAnal4(), var1, this.nature, this.var_date, this.exercicesAchats, this.fraisEnteteAchats.getFsfSerie(), this.fraisEnteteAchats.getFsfDevise());
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

   public void calculeDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
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
               this.fraisEnteteAchats.setFsfAnal4(this.dossier.getAnaTypeDossier() + this.dossier.getAnaCode());
            } else {
               this.fraisEnteteAchats.setFsfAnal4(this.dossier.getAnaCode());
            }
         } else {
            this.libelleDossierFiche = "N° Dossier";
            this.fraisEnteteAchats.setFsfAnal4(this.dossier.getAnaCode());
         }

         if (this.dossier.getAnaCode() != null && !this.dossier.getAnaCode().isEmpty()) {
            this.chargerDocumentsConcernes(this.dossier.getAnaCode(), (Session)null);
         }
      } else {
         this.fraisEnteteAchats.setFsfAnal4("");
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleDossier() {
      this.fraisEnteteAchats.setFsfAnal4("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.fraisEnteteAchats.getFsfNomTiers(), this.nature);
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
         this.fraisEnteteAchats.setTiers(this.tiers);
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.fraisEnteteAchats.setFsfCivilTiers("");
            this.var_typeTiers = true;
         } else {
            this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.fraisEnteteAchats.setFsfCivilTiers(this.fraisEnteteAchats.getTiers().getTiecivilite());
            this.var_typeTiers = false;
         }

         this.fraisEnteteAchats.setFsfNomTiers(this.nomTier);
         this.fraisEnteteAchats.setFsfTypeReg(this.tiers.getTietypereg());
         this.fraisEnteteAchats.setFsfModeReg(this.tiers.getTiemodereg());
         this.calculMessageLitige();
         String var2 = "";
         if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
            String[] var3 = this.tiers.getTiemodereg().split(":");
            var2 = var3[0];
         } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
            var2 = this.tiers.getTiemodereg();
         }

         if (!var2.equals("") && !var2.equals("100")) {
            this.fraisEnteteAchats.setFsfNbJourReg(this.tiers.getTienbecheance());
            this.fraisEnteteAchats.setFsfArrondiReg(this.tiers.getTienbarrondi());
         } else {
            for(int var7 = 0; var7 < this.lesModeReglementFournisseurListe.size(); ++var7) {
               new ObjetReglement();
               ObjetReglement var4 = (ObjetReglement)this.lesModeReglementFournisseurListe.get(var7);
               if (var4.getDefaut().equals("true")) {
                  if (var4.getEcheances() == null || var4.getEcheances().isEmpty()) {
                     var4.setEcheances("0");
                  }

                  this.fraisEnteteAchats.setFsfTypeReg(Integer.parseInt(var4.getEcheances()));
                  this.fraisEnteteAchats.setFsfModeReg(var4.getCategories() + ":" + var4.getLibelles());
                  int var5 = 0;
                  if (var4.getNbjours() != null && !var4.getNbjours().isEmpty()) {
                     var5 = Integer.parseInt(var4.getNbjours());
                  }

                  this.fraisEnteteAchats.setFsfNbJourReg(var5);
                  int var6 = 0;
                  if (var4.getArrondis() != null && !var4.getArrondis().isEmpty()) {
                     var6 = Integer.parseInt(var4.getArrondis());
                  }

                  this.fraisEnteteAchats.setFsfArrondiReg(var6);
                  break;
               }
            }
         }

         this.chargerModeEcheanceAffichage();
         this.fraisEnteteAchats.setFsfJournalReg(this.tiers.getTiejournalreg());
         if (this.tiers.getTienomfamille() != null && !this.tiers.getTienomfamille().isEmpty()) {
            this.fraisEnteteAchats.setFsfCat(this.tiers.getTienomfamille());
            this.fraisEnteteAchats.setFsfExoDouane(this.tiers.getTieexodouane());
            this.fraisEnteteAchats.setFsfExoTva(this.tiers.getTieexotva());
         }

         if (this.tiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
            this.fraisEnteteAchats.setFsfDiversTiers(99);
         } else {
            this.fraisEnteteAchats.setFsfDiversTiers(0);
            this.fraisEnteteAchats.setFsfDiversNom("");
            this.fraisEnteteAchats.setFsfDiversAdresse("");
            this.fraisEnteteAchats.setFsfDiversVille("");
            this.fraisEnteteAchats.setFsfDiversTel("");
            this.fraisEnteteAchats.setFsfDiversMail("");
         }

         if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
            this.fraisEnteteAchats.setFsfDevise(this.tiers.getTiedevise());
         } else {
            this.fraisEnteteAchats.setFsfDevise(this.structureLog.getStrdevise());
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
      this.fraisEnteteAchats.setTiers(this.tiers);
      this.fraisEnteteAchats.setFsfNomTiers("");
      this.fraisEnteteAchats.setFsfCivilTiers("");
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
      if (!this.fraisEnteteAchats.getFsfNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_aff_detail_tiers = true;
         this.CalculDateEcheance();
         if (this.optionAchats.getAxeDossier().equals("2")) {
            this.var_valide_doc = true;
         } else if (this.fraisEnteteAchats.getFsfAnal4() != null && !this.fraisEnteteAchats.getFsfAnal4().isEmpty()) {
            if (this.fraisEnteteAchats.getFsfNumDoc() != null && !this.fraisEnteteAchats.getFsfNumDoc().isEmpty()) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else {
            this.var_valide_doc = false;
         }
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
            if (this.fraisEnteteAchats.getFsfCat() != null && !this.fraisEnteteAchats.getFsfCat().isEmpty() && this.fraisEnteteAchats.getFsfCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && !var1.equalsIgnoreCase("1")) {
         if (var1.equalsIgnoreCase("2")) {
            if (this.tiers != null && this.tiers.getTiecodepays() != null && !this.tiers.getTiecodepays().equals(this.structureLog.getStrcodepays())) {
               this.fraisEnteteAchats.setFsfExoTva(3);
            } else {
               this.fraisEnteteAchats.setFsfExoTva(2);
            }
         } else {
            this.fraisEnteteAchats.setFsfExoTva(0);
         }
      } else {
         this.fraisEnteteAchats.setFsfExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && !var2.equalsIgnoreCase("1")) {
         this.fraisEnteteAchats.setFsfExoDouane(0);
      } else {
         this.fraisEnteteAchats.setFsfExoDouane(1);
      }

      if (this.lesLignesList.size() != 0) {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         Transaction var4 = null;

         try {
            var4 = var13.beginTransaction();

            for(int var5 = 0; var5 < this.lesLignesList.size(); ++var5) {
               this.fraisLigneAchats = new FraisLigneAchats();
               this.fraisLigneAchats = (FraisLigneAchats)this.lesLignesList.get(var5);
               if (this.fraisEnteteAchats.getFsfExoTva() == 1) {
                  this.fraisLigneAchats.setFsfligTaxe("");
                  this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
                  this.fraisLigneAchats.setFsfligTva(0.0D);
               } else if (this.fraisLigneAchats.getFsfligCode() != null && !this.fraisLigneAchats.getFsfligCode().isEmpty()) {
                  new Produits();
                  Produits var6 = this.produitsDao.chargeProduit(this.fraisLigneAchats.getFsfligCode(), var13);
                  if (var6 == null) {
                     this.fraisLigneAchats.setFsfligTaxe("");
                     this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
                  } else if (!var6.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
                     if (var6.getProVteTva() != null && !var6.getProVteTva().isEmpty()) {
                        this.fraisLigneAchats.setFsfligTaxe(var6.getProVteTva());
                     } else {
                        this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var6, var13);
                        if (this.famillesProduitsAchats != null) {
                           this.fraisLigneAchats.setFsfligTaxe(this.famillesProduitsAchats.getFamachTaxe());
                        }
                     }

                     new TaxesAchats();
                     TaxesAchats var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.fraisLigneAchats.getFsfligTaxe(), var13);
                     if (var7 != null) {
                        this.fraisLigneAchats.setFsfligTauxTaxe(var7.getTaxachTaux());
                     } else {
                        this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
                     }
                  } else {
                     this.fraisLigneAchats.setFsfligTaxe("");
                     this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
                  }
               }

               this.calculPrix(this.fraisLigneAchats.getFsfligTaxe(), this.fraisLigneAchats.getFsfligTauxTaxe(), var13);
               this.fraisLigneAchats = this.fraisLigneAchatsDao.modifLigne(this.fraisLigneAchats, var13);
            }

            if (this.fraisEnteteAchats.getFsfId() != 0L) {
               this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var13);
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
      this.produits = this.formRecherche.rechercheProduitFraisAchat(this.fraisLigneAchats.getFsfligCode(), this.nature);
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
      this.calculeProduits((Session)null);
   }

   public void calculeProduits(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
            var2 = true;
         }

         this.fraisLigneAchats.setFsfligCode(this.produits.getProCode());
         this.fraisLigneAchats.setFsfligLibelle(this.produits.getProLibClient());
         this.fraisLigneAchats.setFsfligFamille(this.produits.getProAchCode());
         this.fraisLigneAchats.setFsfligMode(this.produits.getProMode());
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
            float var6 = 0.0F;
            new TaxesAchats();
            TaxesAchats var7 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.produits.getProAchTva(), var1);
            if (var7 != null) {
               var6 = var7.getTaxachTaux();
            }

            this.fraisLigneAchats.setFsfligTaxe(this.produits.getProAchTva());
            this.fraisLigneAchats.setFsfligTauxTaxe(var6);
         } else {
            new FamillesProduitsAchats();
            FamillesProduitsAchats var3 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.lastExoAchats.getExeachId(), this.produits, var1);
            if (var3 != null && var3.getFamachTaxe() != null && !var3.getFamachTaxe().isEmpty() && !var3.getFamachTaxe().equals("0")) {
               float var4 = 0.0F;
               new TaxesAchats();
               TaxesAchats var5 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), var3.getFamachTaxe(), var1);
               if (var5 != null) {
                  var4 = var5.getTaxachTaux();
               }

               this.fraisLigneAchats.setFsfligTaxe(var3.getFamachTaxe());
               this.fraisLigneAchats.setFsfligTauxTaxe(var4);
            } else {
               this.fraisLigneAchats.setFsfligTaxe("");
               this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
            }
         }

         if (this.produits.isProExoTva() || this.tiers != null && this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            this.fraisLigneAchats.setFsfligTaxe("");
            this.fraisLigneAchats.setFsfligTauxTaxe(0.0F);
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.fraisLigneAchats.getFsfligTaxe(), this.fraisLigneAchats.getFsfligTauxTaxe(), var1);
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
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
      if (this.fraisEnteteAchats.getFsfExoTva() == 0) {
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
            this.fraisLigneAchats.setFsfligTaxe(this.optionAchats.getTvaDefaut());
         }
      } else if ((this.fraisEnteteAchats.getFsfExoTva() == 2 || this.fraisEnteteAchats.getFsfExoTva() == 3) && this.mesTaxesAchatsItems.size() != 0) {
         for(var1 = 0; var1 < this.mesTaxesAchatsItems.size(); ++var1) {
            var2 = false;

            for(var3 = 0; var3 < this.lisTaxesAchats.size(); ++var3) {
               if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachCode().equals(((SelectItem)this.mesTaxesAchatsItems.get(var1)).getValue().toString())) {
                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 2 && this.fraisEnteteAchats.getFsfExoTva() == 2) {
                     var2 = true;
                     break;
                  }

                  if (((TaxesAchats)this.lisTaxesAchats.get(var3)).getTaxachType() == 3 && this.fraisEnteteAchats.getFsfExoTva() == 3) {
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
      if (this.fraisLigneAchats.getFsfligCode() == null || this.fraisLigneAchats.getFsfligCode().isEmpty() || this.fraisLigneAchats.getFsfligCode().length() < 2) {
         if (this.fraisEnteteAchats.getFsfExoTva() == 0) {
            this.selectionListeTva();
         } else {
            this.mesTaxesAchatsProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.fraisLigneAchats.setFsfligCode("");
      this.fraisLigneAchats.setFsfligLibelle("");
      this.mesTaxesAchatsProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null && this.tiers != null) {
         new ProduitsFournisseur();
         ProduitsFournisseurDao var3 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
         ProduitsFournisseur var2 = var3.selectProdFourByprodFic(this.produits, this.tiers, var1);
         if (var2 != null) {
            this.fraisLigneAchats.setFsfligPu(var2.getProfouPa());
         }
      }

   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.fraisEnteteAchats.getFsfTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.fraisEnteteAchats.getFsfSerie();
      this.var_imput_cat = this.fraisEnteteAchats.getFsfCat();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new FraisEnteteAchats();
         FraisEnteteAchats var1 = this.fraisEnteteAchatsDao.pourParapheur(this.var_imput_num, this.fraisEnteteAchats.getFsfSerie(), (Session)null);
         if (var1 != null) {
            this.var_imput_num = "";
         }
      }

   }

   public void miseajourImput() throws IOException, JDOMException, NamingException, HibernateException, ParseException {
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.fraisEnteteAchats.getFsfNum();
               this.fraisEnteteAchats.setFsfNum(this.var_imput_num);
               this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
               if (this.fraisEnteteAchats.getFsfTotReglement() != 0.0D) {
                  new ArrayList();
                  var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  var4 = (ArrayList)var5.reglementDocument(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
                  if (var4 != null) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        new Reglements();
                        var7 = (Reglements)var4.get(var6);
                        var7.setRglDocument(this.fraisEnteteAchats.getFsfNum());
                        var5.modifierReg(var7, var1);
                     }
                  }
               }

               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
               if (var4 != null) {
                  for(var22 = 0; var22 < var4.size(); ++var22) {
                     new Parapheur();
                     var24 = (Parapheur)var4.get(var22);
                     var24.setPhrNum(this.fraisEnteteAchats.getFsfNum());
                     this.parapheurDao.modif(var24, var1);
                  }
               }

               var23 = new Espion();
               var23.setUsers(this.usersLog);
               var23.setEsptype(0);
               var23.setEspdtecreat(new Date());
               var23.setEspaction("Imputation Frais achat N° " + var3 + " en Frais achat N° " + this.fraisEnteteAchats.getFsfNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.fraisEnteteAchats.getFsfNum();
            this.fraisEnteteAchats.setFsfSerie(this.var_imput_serie);
            this.fraisEnteteAchats.setFsfCat(this.var_imput_cat);
            this.fraisEnteteAchats.setFsfNum(this.calculChrono.numCompose(this.fraisEnteteAchats.getFsfDate(), this.nature, this.fraisEnteteAchats.getFsfSerie(), var1));
            this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
            if (this.fraisEnteteAchats.getFsfTotReglement() != 0.0D) {
               new ArrayList();
               var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.fraisEnteteAchats.getFsfNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
            if (var4 != null) {
               for(var22 = 0; var22 < var4.size(); ++var22) {
                  new Parapheur();
                  var24 = (Parapheur)var4.get(var22);
                  var24.setPhrNum(this.fraisEnteteAchats.getFsfNum());
                  this.parapheurDao.modif(var24, var1);
               }
            }

            var23 = new Espion();
            var23.setUsers(this.usersLog);
            var23.setEsptype(0);
            var23.setEspdtecreat(new Date());
            var23.setEspaction("Imputation Frais achat X N° " + var3 + " en Frais achat " + this.fraisEnteteAchats.getFsfSerie() + " N° " + this.fraisEnteteAchats.getFsfNum());
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

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
         this.caissesCommerciales = new CaissesCommerciales();
         if (this.caissesCommercialesDao == null) {
            this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         }

         this.bonDecaissementAchat = new BonDecaissementAchat();
         this.bonDecaissementAchat.setBonCodeCaisse((String)null);
         this.bonDecaissementAchat.setBonLibCaisse((String)null);
         this.bonDecaissementAchat.setBonDate(new Date());
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
         if (this.var_tot_bon_encaissement > this.fraisEnteteAchats.getFsfTotTtc()) {
            this.fraisEnteteAchats.setFsfTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.fraisEnteteAchats.getFsfTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.fraisEnteteAchats.getFsfTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.fraisEnteteAchats.getFsfEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.fraisEnteteAchats.getFsfTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.fraisEnteteAchats.setFsfTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.fraisEnteteAchats.getFsfTotTtc() - this.var_tot_bon_encaissement;
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 1) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.fraisEnteteAchats.getFsfSerie())) {
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

   }

   public void selectionBanqueDestinationBencaissement() throws HibernateException, NamingException {
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonDecaissementAchat.setBonCodeCaisse(var1[0]);
         this.bonDecaissementAchat.setBonLibCaisse(var1[1]);
      } else {
         this.bonDecaissementAchat.setBonCodeCaisse((String)null);
         this.bonDecaissementAchat.setBonLibCaisse((String)null);
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void chargerModReg() {
      if (this.fraisEnteteAchats.getFsfTypeReg() != 4 && this.fraisEnteteAchats.getFsfTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (this.var_tot_bon_encaissement <= this.fraisEnteteAchats.getFsfTotTtc()) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fraisEnteteAchats.getFsfTypeReg() == 5) {
               this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(this.nature, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 19, this.fraisEnteteAchats.getFsfSerie(), var1);
               if (var3 != null && !var3.isEmpty()) {
                  this.bonDecaissementAchat = new BonDecaissementAchat();
                  String[] var4;
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     var4 = this.var_inputCaisse.split(":");
                     this.bonDecaissementAchat.setBonCodeCaisse(var4[0]);
                     this.bonDecaissementAchat.setBonLibCaisse(var4[1]);
                     if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
                        String[] var5 = this.var_type_reg.split(":");
                        this.bonDecaissementAchat.setBonTypeReg(Integer.parseInt(var5[0]));
                     } else {
                        this.bonDecaissementAchat.setBonTypeReg(0);
                     }
                  } else {
                     this.bonDecaissementAchat.setBonCodeCaisse((String)null);
                     this.bonDecaissementAchat.setBonLibCaisse((String)null);
                     this.bonDecaissementAchat.setBonTypeReg(0);
                  }

                  if (this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
                     var4 = this.var_banque_destination.split(":");
                     this.bonDecaissementAchat.setBonCodeBanq(var4[0]);
                     this.bonDecaissementAchat.setBonLibBanq(var4[1]);
                  } else {
                     this.bonDecaissementAchat.setBonCodeBanq((String)null);
                     this.bonDecaissementAchat.setBonLibBanq((String)null);
                  }

                  this.bonDecaissementAchat.setBonBanqueTireur(this.var_banque_tireur);
                  this.bonDecaissementAchat.setBonNumChqBdx(this.var_num_cheque);
                  this.bonDecaissementAchat.setBonDateCreat(new Date());
                  this.bonDecaissementAchat.setBonUserCreat(this.usersLog.getUsrid());
                  this.bonDecaissementAchat.setBonActivite(this.fraisEnteteAchats.getFsfActivite());
                  this.bonDecaissementAchat.setBonSite(this.fraisEnteteAchats.getFsfSite());
                  this.bonDecaissementAchat.setBonDepartement(this.fraisEnteteAchats.getFsfDepartement());
                  this.bonDecaissementAchat.setBonService(this.fraisEnteteAchats.getFsfService());
                  this.bonDecaissementAchat.setBonRegion(this.fraisEnteteAchats.getFsfRegion());
                  this.bonDecaissementAchat.setBonSecteur(this.fraisEnteteAchats.getFsfSecteur());
                  this.bonDecaissementAchat.setBonPdv(this.fraisEnteteAchats.getFsfPdv());
                  this.bonDecaissementAchat.setBonDateEcheReg(this.fraisEnteteAchats.getFsfDateEcheReg());
                  this.bonDecaissementAchat.setBonEtat(0);
                  this.bonDecaissementAchat.setBonNatRef(this.nature);
                  this.bonDecaissementAchat.setBonNomTiers(this.fraisEnteteAchats.getFsfNomTiers());
                  this.bonDecaissementAchat.setBonIdTiers(this.fraisEnteteAchats.getTiers().getTieid());
                  this.bonDecaissementAchat.setBonNomContact(this.fraisEnteteAchats.getFsfNomContact());
                  this.bonDecaissementAchat.setBonIdContact(this.fraisEnteteAchats.getFsfIdContact());
                  this.bonDecaissementAchat.setBonTypeTiers(1);
                  this.bonDecaissementAchat.setBonLibelle("Règlement Facture frais N° " + this.fraisEnteteAchats.getFsfNum());
                  this.bonDecaissementAchat.setBonRef(this.fraisEnteteAchats.getFsfNum());
                  this.bonDecaissementAchat.setBonIdRef(this.fraisEnteteAchats.getFsfId());
                  this.bonDecaissementAchat.setBonObject(this.fraisEnteteAchats.getFsfObject());
                  this.bonDecaissementAchat.setBonObservation(this.fraisEnteteAchats.getFsfObservation());
                  this.bonDecaissementAchat.setBonSerie(this.fraisEnteteAchats.getFsfSerie());
                  this.bonDecaissementAchat.setBonDevise(this.fraisEnteteAchats.getFsfDevise());
                  this.bonDecaissementAchat.setBonTotTtc(this.fraisEnteteAchats.getFsfTotTtc());
                  this.bonDecaissementAchat.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonDecaissementAchat.setBonActif(0);
                  this.bonDecaissementAchat.setBonNum(var3);
                  this.bonDecaissementAchat.setBonDate(this.var_date_trf);
                  this.bonDecaissementAchat.setBonIdResponsable(this.fraisEnteteAchats.getFsfIdResponsable());
                  this.bonDecaissementAchat.setBonNomResponsable(this.fraisEnteteAchats.getFsfNomResponsable());
                  this.bonDecaissementAchat.setBonGrp(this.usersLog.getUsrCollaboration());
                  this.bonDecaissementAchatDao.insert(this.bonDecaissementAchat, var1);
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.fraisEnteteAchats = (FraisEnteteAchats)this.lesEntetesList.get(var11);
            if (this.fraisEnteteAchats.isVar_select_ligne()) {
               long var13 = this.fraisEnteteAchats.getFsfId();
               this.fraisEnteteAchats = new FraisEnteteAchats();
               this.fraisEnteteAchats = this.fraisEnteteAchatsDao.pourParapheur(var13, var1);
               if (this.fraisEnteteAchats != null) {
                  this.lesEntetesList.remove(var11);
                  this.fraisEnteteAchats.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.fraisEnteteAchats);
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
            new FraisEnteteAchats();
            FraisEnteteAchats var11 = (FraisEnteteAchats)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getFsfNomTiers())) && var11.getFsfSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getFsfNomTiers();
               var1 += var11.getFsfTotTtc() + this.fraisEnteteAchats.getFsfTotTc();
               var3 += var11.getFsfTotReglement();
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
            this.fraisEnteteAchats.setFsfTypeReg(0);
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 1) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.fraisEnteteAchats.getFsfSerie())) {
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
         new FraisEnteteAchats();
         FraisEnteteAchats var6 = (FraisEnteteAchats)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getFsfTotTtc();
            var3 += var6.getFsfTotReglement();
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

      this.calculeNomRep();
      this.calculValeurTimbre();
   }

   public void calculValeurTimbre() {
      this.var_netAPayer = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      int var1;
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, this.montantElmTotBonEnc, var1, this.structureLog.getStrdevise(), this.var_date);
         this.totalPayerTimbre = this.montantElmTotBonEnc + this.val_timbre;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new FraisEnteteAchats();
               FraisEnteteAchats var7 = (FraisEnteteAchats)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getFsfTotTtc() + var7.getFsfTotTc() - var7.getFsfTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFsfTotTtc() + var7.getFsfTotTc() - var7.getFsfTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFsfDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFsfTotTtc() + var7.getFsfTotTc() - var7.getFsfTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFsfDate());
                  var4 = var4 - var7.getFsfTotTtc() + var7.getFsfTotTc() - var7.getFsfTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FraisEnteteAchats();
            FraisEnteteAchats var8 = (FraisEnteteAchats)this.listFactureSelectionne.get(var1);
            var8.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var8.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
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
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "bonDecaissementAchat");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.fraisEnteteAchats.getFsfSerie();
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

               double var32 = this.montantElmTotBonEnc;
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               new FraisEnteteAchats();

               for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                  FraisEnteteAchats var20 = (FraisEnteteAchats)this.listFactureSelectionne.get(var21);
                  var16 = var20.getVar_fac_timbre();
                  var18 = var20.getMontantReglementManuel();
                  var12 = 0.0D;
                  if (var20.isVar_select_ligne()) {
                     long var22 = var20.getFsfId();
                     var20 = this.fraisEnteteAchatsDao.pourParapheur(var22, var3);
                     if (var20 != null) {
                        if (this.repartitionManuelle) {
                           if (var18 != 0.0D) {
                              this.generationReglement(var8, var18, var16, var20, var5, var3);
                              var32 -= var18;
                              if (var32 < 0.0D) {
                                 var32 = 0.0D;
                                 break;
                              }
                           }
                        } else {
                           var12 = var20.getFsfTotTtc() + var20.getFsfTotTc() + var16 - var20.getFsfTotReglement();
                           if (var32 <= 0.0D) {
                              break;
                           }

                           if (var12 <= var32) {
                              var14 = var12;
                           } else {
                              var14 = var32;
                           }

                           this.generationReglement(var8, var14, var16, var20, var5, var3);
                           var32 -= var14;
                           if (var32 < 0.0D) {
                              var32 = 0.0D;
                              break;
                           }
                        }
                     }
                  }
               }

               if (var32 > 0.0D) {
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
                  this.reglements.setRglDepense(var32);
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
                  this.tiers = new Tiers();
                  this.tiers = this.tiersDao.selectTierD(this.memoReglements.getRglIdTiers(), var3);
                  if (this.tiers != null) {
                     double var33 = this.tiers.getTiedepotavance() + var32;
                     this.tiers.setTiedepotavance(var33);
                     this.tiersDao.modif(this.tiers, var3);
                  }
               }

               var4.commit();
            }
         } catch (HibernateException var27) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var27;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.lesEntetesList.size() != 0) {
         Session var29 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");

         for(int var30 = 0; var30 < this.lesEntetesList.size(); ++var30) {
            this.fraisEnteteAchats = (FraisEnteteAchats)this.lesEntetesList.get(var30);
            if (this.fraisEnteteAchats.isVar_select_ligne()) {
               long var31 = this.fraisEnteteAchats.getFsfId();
               this.fraisEnteteAchats = new FraisEnteteAchats();
               this.fraisEnteteAchats = this.fraisEnteteAchatsDao.pourParapheur(var31, var29);
               if (this.fraisEnteteAchats != null) {
                  if (this.fraisEnteteAchats.getFsfSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var30);
                  } else {
                     this.lesEntetesList.remove(var30);
                     this.fraisEnteteAchats.setVar_select_ligne(false);
                     this.lesEntetesList.add(var30, this.fraisEnteteAchats);
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
               this.totManuel += ((FraisEnteteAchats)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
            }

            this.ecartManuel = this.montantElmTotBonEnc - this.totManuel;
            if (this.ecartManuel >= 0.0D) {
               this.var_affiche_valide = true;
            } else {
               this.var_affiche_valide = false;
            }
         }
      }

   }

   public void generationReglement(String var1, double var2, double var4, FraisEnteteAchats var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= var6.getFsfTotTtc() + var6.getFsfTotTc() + var4) {
         this.reglements.setRglOperation("21");
      } else {
         this.reglements.setRglOperation("22");
      }

      this.reglements.setRglActivite(var6.getFsfActivite());
      this.reglements.setRglBudget(var6.getFsfBudget());
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(10);
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
      this.reglements.setRglDepartement(var6.getFsfDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getFsfDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getFsfNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getFsfId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(var6.getFsfObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(18);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      this.reglements.setRglIdContact(var6.getFsfIdContact());
      this.reglements.setRglNomContact(var6.getVar_nomContact());
      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getFsfPdv());
      this.reglements.setRglDepense(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getFsfDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getFsfRegion());
      this.reglements.setRglSecteur(var6.getFsfSecteur());
      this.reglements.setRglSerie(var6.getFsfSerie());
      this.reglements.setRglService(var6.getFsfService());
      this.reglements.setRglSite(var6.getFsfSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getFsfIdResponsable());
      this.reglements.setRglNomResponsable(var6.getFsfNomResponsable());
      this.reglements.setRglIdCommercial(0L);
      this.reglements.setRglNomCommercial("");
      this.reglements.setRglIdEquipe(0L);
      this.reglements.setRglNomEquipe("");
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
         var6.setFsfTotReglement(var6.getFsfTotReglement() + var2);
         var6.setFsfTotTimbre(var6.getFsfTotTimbre() + var14);
         if (var6.getFsfTotReglement() >= var6.getFsfTotTtc() + var6.getFsfTotTc()) {
            var6.setFsfSolde(1);
         } else {
            var6.setFsfSolde(0);
         }

         var6.setFsfDateLastReg(this.reglements.getRglDateReg());
         this.fraisEnteteAchatsDao.modif(var6, var8);
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

   public void supprimerReglement() throws HibernateException, NamingException {
      if (this.datamodelRecu.isRowAvailable()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.fraisEnteteAchats.getFsfId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglDepense();
               }
            }

            this.fraisEnteteAchats.setFsfTotReglement(var4);
            if (this.fraisEnteteAchats.getFsfTotReglement() >= this.fraisEnteteAchats.getFsfTotTtc()) {
               this.fraisEnteteAchats.setFsfSolde(1);
            } else {
               this.fraisEnteteAchats.setFsfSolde(0);
            }

            this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
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
      if (this.fraisEnteteAchats != null) {
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
                  var6 = "" + this.utilNombre.beginText(((Reglements)var7.get(var8)).getRglDepense() + ((Reglements)var7.get(var8)).getRglTimbre(), this.structureLog.getStrformatdevise());
               } else {
                  var5 = var5 + "\n" + ((Reglements)var7.get(var8)).getRglDocument();
                  var6 = var6 + "\n" + this.utilNombre.beginText(((Reglements)var7.get(var8)).getRglDepense() + ((Reglements)var7.get(var8)).getRglTimbre(), this.structureLog.getStrformatdevise());
               }

               var3 = var3 + ((Reglements)var7.get(var8)).getRglDepense() + ((Reglements)var7.get(var8)).getRglTimbre();
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
      if (this.varTypeReg != 0 && this.varTypeReg != 11) {
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

   public void changeDossier() {
      if (this.fraisEnteteAchats != null) {
         this.nouveauDossier = "";
         this.showModalPanelDossier = true;
      }

   }

   public void fermeDossier() {
      this.showModalPanelDossier = false;
   }

   public void miseajourDossier() throws HibernateException, NamingException {
      if (this.nouveauDossier != null && !this.nouveauDossier.isEmpty()) {
         this.fraisEnteteAchats.setFsfAnal4(this.nouveauDossier);
         this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats);
         new PlansAnalytiques();
         PlansAnalytiques var1 = this.plansAnalytiquesDao.rechercheAnal("6", this.nouveauDossier, (Session)null);
         if (var1 != null) {
            String var2 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.fraisEnteteAchats.getFsfId();
            new ArrayList();
            new ArrayList();
            new Ecritures();
            EcrituresAnalytique var6 = new EcrituresAnalytique();
            EcrituresDao var7 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
            EcrituresAnalytiquesDao var8 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            List var3 = var7.ChargerLesEcrituresRecherche(var2, (Session)null);
            if (var3.size() != 0) {
               Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               Transaction var10 = null;

               try {
                  var10 = var9.beginTransaction();

                  for(int var11 = 0; var11 < var3.size(); ++var11) {
                     Ecritures var5 = (Ecritures)var3.get(var11);
                     if (var5 != null) {
                        List var4 = var8.chargerLesEcrituresAnalytiques(var5, var9);
                        if (var4.size() != 0) {
                           var6.setEcranaAnal4(var1.getAnaCode());
                           var6.setEcranaAnal4Lib(var1.getAnaNomFr());
                           var8.modifEcritureAnalytiques(var9, var6);
                        }
                     }
                  }

                  var10.commit();
               } catch (HibernateException var15) {
                  if (var10 != null) {
                     var10.rollback();
                  }

                  throw var15;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.fraisEnteteAchats.getFsfAnnexe1() != null && !this.fraisEnteteAchats.getFsfAnnexe1().isEmpty() && this.fraisEnteteAchats.getFsfAnnexe1().contains(":")) {
         String[] var2 = this.fraisEnteteAchats.getFsfAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.fraisEnteteAchats.getUsers(), this.structureLog, this.fraisEnteteAchats.getTiers());
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
      if (this.fraisEnteteAchats.getFsfAnnexe2() != null && !this.fraisEnteteAchats.getFsfAnnexe2().isEmpty() && this.fraisEnteteAchats.getFsfAnnexe2().contains(":")) {
         String[] var2 = this.fraisEnteteAchats.getFsfAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.fraisEnteteAchats.getUsers(), this.structureLog, this.fraisEnteteAchats.getTiers());
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

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      return var2;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatFrais.jpg");
            if (var4.exists()) {
               var3 = "formatFrais.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatFrais.jpg");
         if (var4.exists()) {
            var3 = "formatFrais.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            var1.add(this.lesLignesList.get(var2));
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.fraisEnteteAchats.getFsfTotTtc() + this.fraisEnteteAchats.getFsfTotTc(), this.fraisEnteteAchats.getFsfDevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.fraisEnteteAchats.getFsfAnal2() != null && !this.fraisEnteteAchats.getFsfAnal2().isEmpty()) {
         String var4 = "";
         if (this.fraisEnteteAchats.getFsfAnal2().contains(":")) {
            String[] var5 = this.fraisEnteteAchats.getFsfAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.fraisEnteteAchats.getFsfAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.fraisEnteteAchats.getFsfDateImp() != null) {
            var2 = true;
         }

         this.fraisEnteteAchats.setFsfDateImp(new Date());
         if (this.fraisEnteteAchats.getFsfEtat() == 0 && this.fraisEnteteAchats.getFsfEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.fraisEnteteAchats.setFsfEtat(1);
            if (this.fraisEnteteAchats.getFsfAnal4() != null && !this.fraisEnteteAchats.getFsfAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var6 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var5 = var6.rechercheByDossier(this.fraisEnteteAchats.getFsfAnal4(), var3);
               if (var5 != null) {
                  this.fraisEnteteAchats.setFsfValo(var5.getValNum());
                  this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var3);
               }
            }
         }

         this.fraisEnteteAchats.setFsfModeleImp(var1);
         this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var3);
         var4.commit();
      } catch (HibernateException var10) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression frais");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.fraisEnteteAchats.getFsfEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.fraisEnteteAchats.getFsfIdResponsable());
            var1.setTiersSelectionne(this.fraisEnteteAchats.getTiers());
            var1.setNumDoc(this.fraisEnteteAchats.getFsfNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.fraisEnteteAchats.getFsfId());
            if (this.fraisEnteteAchats.getFsfAnal2() != null && !this.fraisEnteteAchats.getFsfAnal2().isEmpty()) {
               String var12 = "";
               if (this.fraisEnteteAchats.getFsfAnal2().contains(":")) {
                  String[] var13 = this.fraisEnteteAchats.getFsfAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.fraisEnteteAchats.getFsfAnal2();
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
         var1.setEntete("Impression de la liste des frais");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "frais" + File.separator);
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
            this.uniteGraph = "FACTURES FRAIS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "FACTURES FRAIS : Quantites";
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

         new FraisEnteteAchats();
         new FraisLigneAchats();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisLigne");
         String var6 = "";

         FraisEnteteAchats var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (FraisEnteteAchats)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getFsfNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getFsfNum() + "'";
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

                  var14 = (FraisEnteteAchats)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getFsfDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getFsfNomResponsable() != null && !var14.getFsfNomResponsable().isEmpty()) {
                        var17 = var14.getFsfNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getFsfNomTiers() != null && !var14.getFsfNomTiers().isEmpty()) {
                        var17 = var14.getFsfNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  }

                  var20 = (long)var14.getFsfTotHt();
                  if (this.timeDecoupage == 0) {
                     var18 = var14.getFsfDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getFsfDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getFsfDate().getMonth() + 1 >= 1 && var14.getFsfDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getFsfDate().getMonth() + 1 >= 4 && var14.getFsfDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getFsfDate().getMonth() + 1 >= 7 && var14.getFsfDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getFsfDate().getMonth() + 1 >= 10 && var14.getFsfDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getFsfDate().getMonth() + 1 >= 1 && var14.getFsfDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getFsfDate().getMonth() + 1 >= 7 && var14.getFsfDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getFsfDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.fraisLigneAchatsDao.chargerLesLignesFrais(var6, var5);
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

                  FraisLigneAchats var15 = (FraisLigneAchats)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getFraisEnteteAchats().getFsfDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getFraisEnteteAchats().getFsfNomResponsable() != null && !var15.getFraisEnteteAchats().getFsfNomResponsable().isEmpty()) {
                        var8 = var15.getFraisEnteteAchats().getFsfNomResponsable();
                     } else {
                        var8 = "Sans responsable";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getFraisEnteteAchats().getFsfNomTiers() != null && !var15.getFraisEnteteAchats().getFsfNomTiers().isEmpty()) {
                        var8 = var15.getFraisEnteteAchats().getFsfNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getFsfligFamille() != null && !var15.getFsfligFamille().isEmpty()) {
                        var8 = var15.getFsfligFamille();
                     } else {
                        var8 = "Sans Famille produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getFsfligLibelle() != null && !var15.getFsfligLibelle().isEmpty()) {
                        var8 = var15.getFsfligLibelle();
                     } else {
                        var8 = "Sans Libelle produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getFsfligPt();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getFsfligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getFraisEnteteAchats().getFsfDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 >= 1 && var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 >= 4 && var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 >= 7 && var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 >= 10 && var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 >= 1 && var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 >= 7 && var15.getFraisEnteteAchats().getFsfDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getFraisEnteteAchats().getFsfDate().getHours();
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

   public FraisEnteteAchats getFraisEnteteAchats() {
      return this.fraisEnteteAchats;
   }

   public void setFraisEnteteAchats(FraisEnteteAchats var1) {
      this.fraisEnteteAchats = var1;
   }

   public FraisLigneAchats getFraisLigneAchats() {
      return this.fraisLigneAchats;
   }

   public void setFraisLigneAchats(FraisLigneAchats var1) {
      this.fraisLigneAchats = var1;
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

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public List getMesTaxesAchatsItems() {
      return this.mesTaxesAchatsItems;
   }

   public void setMesTaxesAchatsItems(List var1) {
      this.mesTaxesAchatsItems = var1;
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

   public DataModel getDatamodelFacture() {
      return this.datamodelFacture;
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

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
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

   public List getMesDocumentsConcernes() {
      return this.mesDocumentsConcernes;
   }

   public void setMesDocumentsConcernes(List var1) {
      this.mesDocumentsConcernes = var1;
   }

   public boolean isShowModalPanelDossier() {
      return this.showModalPanelDossier;
   }

   public void setShowModalPanelDossier(boolean var1) {
      this.showModalPanelDossier = var1;
   }

   public String getNouveauDossier() {
      return this.nouveauDossier;
   }

   public void setNouveauDossier(String var1) {
      this.nouveauDossier = var1;
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

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
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

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
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

   public double getInpMontant() {
      return this.inpMontant;
   }

   public void setInpMontant(double var1) {
      this.inpMontant = var1;
   }

   public String getInpNumFacture() {
      return this.inpNumFacture;
   }

   public void setInpNumFacture(String var1) {
      this.inpNumFacture = var1;
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

   public List getLisTaxesAchats() {
      return this.lisTaxesAchats;
   }

   public void setLisTaxesAchats(List var1) {
      this.lisTaxesAchats = var1;
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
