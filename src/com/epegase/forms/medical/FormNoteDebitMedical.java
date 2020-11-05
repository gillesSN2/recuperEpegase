package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
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
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
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
import com.epegase.systeme.xml.OptionMedical;
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

public class FormNoteDebitMedical implements Serializable {
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
   private OptionMedical optionMedical;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
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
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private Contacts contacts;
   private NoteDebitEnteteVentes noteDebitEnteteVentes = new NoteDebitEnteteVentes();
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
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
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private boolean showModalPanelValidationDocument = false;
   private List mesParcsItems = new ArrayList();
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private String numeroPfManuel;
   private boolean showModalPanelAnnuler = false;
   private NoteDebitLigneVentes noteDebitLigneVentes = new NoteDebitLigneVentes();
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
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
   private DocumentTraceVentes documentTraceVentes;
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
   private double plafondEnCours;
   private double soldeEnCours;
   private boolean plafondAutorise;

   public FormNoteDebitMedical() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
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
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
      }

      if (!this.optionMedical.getLib1ENTETE().isEmpty() && !this.optionMedical.getLib2ENTETE().isEmpty() && !this.optionMedical.getLib3ENTETE().isEmpty() && !this.optionMedical.getLib4ENTETE().isEmpty() && !this.optionMedical.getLib5ENTETE().isEmpty() && !this.optionMedical.getLib6ENTETE().isEmpty() && !this.optionMedical.getLib7ENTETE().isEmpty() && !this.optionMedical.getLib8ENTETE().isEmpty() && !this.optionMedical.getLib9ENTETE().isEmpty() && !this.optionMedical.getLib10ENTETE().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionMedical.getNbLigneMax() != null && !this.optionMedical.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionMedical.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = this.optionMedical.getAffichInGlobViewNOTDEB();
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
            if (var1.getCode().equals("21")) {
               this.var_acc_document = true;
            } else if (var1.getCode().equals("22")) {
               this.var_acc_imputation = true;
            } else if (var1.getCode().equals("23")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("24")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("25")) {
               this.var_acc_dre = true;
            } else if (var1.getCode().equals("26")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("27")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("28")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("29")) {
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
            if (var1.getCode().equals("21")) {
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
            if (var1.getCode().equals("22")) {
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
            if (var1.getCode().equals("23")) {
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
            if (var1.getCode().equals("24")) {
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
            if (var1.getCode().equals("25")) {
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
            if (var1.getCode().equals("26")) {
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
            if (var1.getCode().equals("27")) {
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
            if (var1.getCode().equals("28")) {
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
            if (var1.getCode().equals("29")) {
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
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
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
      this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.pourParapheur(var1, (Session)null);
      if (this.noteDebitEnteteVentes != null) {
         this.devisePrint = this.noteDebitEnteteVentes.getNdbDevise();
         this.lesLignesList = this.noteDebitLigneVentesDao.chargerLesLignes(this.noteDebitEnteteVentes, (Session)null);
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
         List var12 = this.noteDebitEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, "", "", this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, this.inpContener, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);

         for(var13 = 0; var13 < var12.size(); ++var13) {
            this.lesEntetesList.add(var12.get(var13));
         }
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new NoteDebitEnteteVentes();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            NoteDebitEnteteVentes var14 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var14.getNdbTotTtc();
            var4 += var14.getNdbTotReglement();
            var6 += var14.getNdbTotHt();
            var8 += var14.getNdbTotTva();
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
            this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.noteDebitEnteteVentes.getNdbNomTiers();
            this.inpIdTiersEnCours = this.noteDebitEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.noteDebitEnteteVentes.getNdbNomContact();
            this.var_date = this.noteDebitEnteteVentes.getNdbDate();
            if (this.noteDebitEnteteVentes.getNdbDate().getHours() <= 9) {
               this.var_heure = "0" + this.noteDebitEnteteVentes.getNdbDate().getHours();
            } else {
               this.var_heure = "" + this.noteDebitEnteteVentes.getNdbDate().getHours();
            }

            if (this.noteDebitEnteteVentes.getNdbDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.noteDebitEnteteVentes.getNdbDate().getMinutes();
            } else {
               this.var_minute = "" + this.noteDebitEnteteVentes.getNdbDate().getMinutes();
            }

            if (this.noteDebitEnteteVentes.getNdbDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.noteDebitEnteteVentes.getNdbDate().getSeconds();
            } else {
               this.var_seconde = "" + this.noteDebitEnteteVentes.getNdbDate().getSeconds();
            }

            this.tiers = this.noteDebitEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
            this.numeroPfManuel = this.noteDebitEnteteVentes.getNdbAnal4();
            this.var_nom_contact = this.noteDebitEnteteVentes.getNdbIdContact();
            this.var_nom_responsable = this.noteDebitEnteteVentes.getNdbIdResponsable();
            this.var_nom_commercial = this.noteDebitEnteteVentes.getNdbIdCommercial();
            this.calculDevise();
            this.chargerDocumentLigne(var6);
            this.calculMessageLitige(var6);
            double var4 = this.chargerBonEncaissement(var6);
            this.chargerDocumentTrace(var6);
            this.chargerLesContactsItem(var6);
            this.chargerUserChrono(var6);
            this.chargerLesUsers(var6);
            this.chargerParapheur(var6);
            this.chargerModeEcheanceAffichage();
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
            if (this.noteDebitEnteteVentes.getNdbTotReglement() != var4) {
               if (this.structureLog.getStrid() != 42L && this.structureLog.getStrid() != 43L && this.structureLog.getStrid() != 44L && this.structureLog.getStrid() != 45L) {
                  this.noteDebitEnteteVentes.setNdbTotReglement(var4);
                  if (var4 >= this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTimbre()) {
                     this.noteDebitEnteteVentes.setNdbSolde(1);
                  } else {
                     this.noteDebitEnteteVentes.setNdbSolde(0);
                  }

                  this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
               } else if (this.noteDebitEnteteVentes.getNdbSolde() == 0) {
                  this.noteDebitEnteteVentes.setNdbTotReglement(var4);
                  this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
               }
            } else {
               if (var4 >= this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTimbre()) {
                  this.noteDebitEnteteVentes.setNdbSolde(1);
               } else {
                  this.noteDebitEnteteVentes.setNdbSolde(0);
               }

               this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
            }

            this.setMontantTtcElmt(this.noteDebitEnteteVentes.getNdbTotTtc());
            this.setMontantReglementElmt(this.noteDebitEnteteVentes.getNdbTotReglement());
            this.setMontantElmTotBonEnc(this.noteDebitEnteteVentes.getNdbTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.noteDebitEnteteVentes.getNdbTotTtc() - this.noteDebitEnteteVentes.getNdbTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.noteDebitEnteteVentes != null) {
         if (this.noteDebitEnteteVentes.getNdbEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.noteDebitEnteteVentes.getNdbDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.noteDebitEnteteVentes.getNdbDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.noteDebitEnteteVentes.getNdbId() > 0L) {
         this.lesLignesList = this.noteDebitLigneVentesDao.chargerLesLignes(this.noteDebitEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var7 = this.reglementsDao.reglementDocument(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
      double var4 = 0.0D;
      if (var7.size() != 0) {
         this.afficheRecu = true;

         for(int var6 = 0; var6 < var7.size(); ++var6) {
            this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + ((Reglements)var7.get(var6)).getRglRecette() + ((Reglements)var7.get(var6)).getRglTimbre();
            var4 = var4 + ((Reglements)var7.get(var6)).getRglRecette() + ((Reglements)var7.get(var6)).getRglTimbre();
         }
      }

      this.datamodelRecu.setWrappedData(var7);
      if (this.var_tot_bon_encaissement < this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc()) {
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.noteDebitEnteteVentes.getNdbId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
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
      if (this.noteDebitEnteteVentes != null && this.noteDebitEnteteVentes.getNdbSerie() != null && !this.noteDebitEnteteVentes.getNdbSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.noteDebitEnteteVentes.getNdbSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.noteDebitEnteteVentes != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.noteDebitEnteteVentes.getNdbId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.noteDebitEnteteVentes.getNdbDateTransfert() != null) {
            this.noteDebitEnteteVentes.setNdbDateTransfert((Date)null);
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
         }
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.documentTraceVentes = null;
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.noteDebitLigneVentes = new NoteDebitLigneVentes();
      this.noteDebitEnteteVentes.setUsers(this.usersLog);
      this.noteDebitEnteteVentes.setNdbIdCreateur(this.usersLog.getUsrid());
      this.noteDebitEnteteVentes.setNdbNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.noteDebitEnteteVentes.setNdbDate(new Date());
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

      boolean var1 = false;
      int var3;
      if (this.optionMedical.getNbrJrRelanceNOTDEB() != null && !this.optionMedical.getNbrJrRelanceNOTDEB().isEmpty()) {
         var3 = Integer.parseInt(this.optionMedical.getNbrJrRelanceNOTDEB());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionMedical.getNbrJrValidNOTDEB() != null && !this.optionMedical.getNbrJrValidNOTDEB().isEmpty()) {
         var4 = Integer.parseInt(this.optionMedical.getNbrJrValidNOTDEB());
      } else {
         var4 = 0;
      }

      this.noteDebitEnteteVentes.setNdbDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.noteDebitEnteteVentes.setNdbDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
      this.noteDebitEnteteVentes.setNdbDateLivraison((Date)null);
      this.noteDebitEnteteVentes.setNdbBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
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
      this.selectDestinataire = true;
      this.var_total_marge = 0.0D;
      this.numLigne = 0;
      this.numeroPfManuel = "";
      this.autorisationDocument();
      this.addLigne();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.noteDebitEnteteVentes != null) {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         if (this.usersLog.getUsrSignatureVentes() != 1 && this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.noteDebitEnteteVentes.getNdbIdResponsable(), this.noteDebitEnteteVentes.getNdbNomResponsable()));
         }

         this.autorisationDocument();
         this.addLigne();
         this.cumulPrix();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.noteDebitEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.noteDebitEnteteVentes.getNdbIdResponsable(), this.noteDebitEnteteVentes.getNdbNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.noteDebitEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.noteDebitEnteteVentes.getNdbEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.noteDebitEnteteVentes.setNdbEtat(1);
               this.noteDebitEnteteVentes.setNdbDateValide(new Date());
               this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle note débit (C.) N° " + this.noteDebitEnteteVentes.getNdbNum() + " du " + this.utilDate.dateToStringSQLLight(this.noteDebitEnteteVentes.getNdbDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument6() == null || this.noteDebitEnteteVentes.getNdbDate().after(this.tiers.getTieDteDocument6())) {
               this.tiers.setTieDteDocument6(this.noteDebitEnteteVentes.getNdbDate());
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
      if (this.noteDebitEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.noteDebitEnteteVentes.getNdbEtat() == 1) {
               this.noteDebitEnteteVentes.setNdbEtat(0);
               this.noteDebitEnteteVentes.setNdbDateValide((Date)null);
               this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
               new ArrayList();
               List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
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
               var10.setEspaction("Dévalidation manuelle note débit (C.) N° " + this.noteDebitEnteteVentes.getNdbNum() + " du " + this.utilDate.dateToStringSQLLight(this.noteDebitEnteteVentes.getNdbDate()));
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
      if (this.noteDebitEnteteVentes != null) {
         this.noteDebitEnteteVentes.setNdbEtat(0);
         this.noteDebitEnteteVentes.setNdbDateAnnule((Date)null);
         this.noteDebitEnteteVentes.setNdbMotifAnnule("");
         this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.noteDebitEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.noteDebitEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            long var3 = this.noteDebitEnteteVentes.getNdbId();
            String var5 = this.noteDebitEnteteVentes.getNdbNum();
            Date var6 = this.noteDebitEnteteVentes.getNdbDate();
            this.noteDebitLigneVentesDao.deleteAllLigne(this.noteDebitEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
            this.noteDebitEnteteVentesDao.delete(this.noteDebitEnteteVentes.getNdbId(), var1);
            this.documentTraceVentes = new DocumentTraceVentes();
            this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(var3, this.nature, var1);
            if (this.documentTraceVentes != null) {
               long var7 = this.documentTraceVentes.getDoctraOrgId();
               int var9 = this.documentTraceVentes.getDoctraOrgType();
               this.documentTraceVentesDao.delete(this.documentTraceVentes, var1);
               boolean var10 = false;
               this.documentTraceVentes = this.documentTraceVentesDao.chercherOrigineTrace(var7, var9, var1);
               byte var18;
               if (this.documentTraceVentes != null) {
                  var18 = 4;
               } else {
                  var18 = 1;
               }

               if (var9 == 21) {
                  new DevisEnteteVentes();
                  DevisEnteteVentesDao var12 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  DevisEnteteVentes var11 = var12.pourParapheur(var7, var1);
                  if (var11 != null) {
                     var11.setDvsEtat(var18);
                     if (var18 == 1) {
                        var11.setDvsDateTransforme((Date)null);
                        var11.setDvsTypeTransforme(0);
                     }

                     var12.modif(var11, var1);
                  }
               }
            }

            Espion var19 = new Espion();
            var19.setUsers(this.usersLog);
            var19.setEsptype(0);
            var19.setEspdtecreat(new Date());
            var19.setEspaction("Suppression Note de débit N° " + var5 + " du " + var6);
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
      if (this.noteDebitEnteteVentes.getNdbId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.noteDebitEnteteVentes.setUsers(this.usersLog);
            this.noteDebitEnteteVentes.setNdbIdCreateur(this.usersLog.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.noteDebitEnteteVentes.setNdbDate(new Date());
            this.noteDebitEnteteVentes.setNdbDateCreat(new Date());
            this.noteDebitEnteteVentes.setNdbDateModif((Date)null);
            this.noteDebitEnteteVentes.setNdbIdModif(0L);
            this.noteDebitEnteteVentes.setNdbNomModif("");
            this.noteDebitEnteteVentes.setNdbNum("");
            this.noteDebitEnteteVentes.setNdbIdResponsable(this.usersLog.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var3 = false;
            int var12;
            if (this.optionMedical.getNbrJrRelanceNOTDEB() != null && !this.optionMedical.getNbrJrRelanceNOTDEB().isEmpty()) {
               var12 = Integer.parseInt(this.optionMedical.getNbrJrRelanceNOTDEB());
            } else {
               var12 = 0;
            }

            boolean var4 = false;
            int var13;
            if (this.optionMedical.getNbrJrValidNOTDEB() != null && !this.optionMedical.getNbrJrValidNOTDEB().isEmpty()) {
               var13 = Integer.parseInt(this.optionMedical.getNbrJrValidNOTDEB());
            } else {
               var13 = 0;
            }

            this.noteDebitEnteteVentes.setNdbDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var12));
            this.noteDebitEnteteVentes.setNdbDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var13));
            this.noteDebitEnteteVentes.setNdbDateLivraison((Date)null);
            if (!this.noteDebitEnteteVentes.getNdbSerie().equalsIgnoreCase("X") && !this.noteDebitEnteteVentes.getNdbSerie().isEmpty()) {
               this.noteDebitEnteteVentes.setNdbNum(this.calculChrono.numCompose(this.noteDebitEnteteVentes.getNdbDate(), this.nature, this.noteDebitEnteteVentes.getNdbSerie(), var1));
            } else {
               long var5 = this.noteDebitEnteteVentesDao.selectLastNum(var1);
               this.noteDebitEnteteVentes.setNdbNum("" + var5);
            }

            this.verifieExistenceHabilitation();
            this.noteDebitEnteteVentes.setNdbDateAnnule((Date)null);
            this.noteDebitEnteteVentes.setNdbMotifAnnule("");
            this.noteDebitEnteteVentes.setNdbDateImp((Date)null);
            this.noteDebitEnteteVentes.setNdbDateTransforme((Date)null);
            this.noteDebitEnteteVentes.setNdbDateTransfert((Date)null);
            this.noteDebitEnteteVentes.setNdbDateLastReg((Date)null);
            this.noteDebitEnteteVentes.setNdbTotReglement(0.0D);
            this.noteDebitEnteteVentes.setNdbSolde(0);
            this.noteDebitEnteteVentes.setNdbEtat(0);
            this.noteDebitEnteteVentes.setNdbContener("");
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.duppliquer(this.noteDebitEnteteVentes, var1);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.noteDebitEnteteVentes.getNdbId(), this.noteDebitEnteteVentes.getNdbNum(), this.noteDebitEnteteVentes.getNdbNomTiers(), this.noteDebitEnteteVentes.getNdbDate(), this.noteDebitEnteteVentes.getNdbDevise(), this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc(), this.noteDebitEnteteVentes.getNdbModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.noteDebitEnteteVentes.getVar_format_devise(), 0, var1);
            }

            if (this.lesLignesList.size() != 0) {
               this.noteDebitLigneVentesDao.duppliquerLigne(this.lesLignesList, this.noteDebitEnteteVentes, var1);
            }

            this.chargeListeDetail(var1);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.noteDebitEnteteVentes.getNdbTypeTransforme() != 0) {
            var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.noteDebitEnteteVentes.getNdbTypeTransforme(), var1);
            if (var3) {
               String var4 = "";
               if (this.noteDebitEnteteVentes.getNdbTypeTransforme() == 22) {
                  var4 = "Bon de commande";
               } else if (this.noteDebitEnteteVentes.getNdbTypeTransforme() == 23) {
                  var4 = "Bon de livraison";
               } else if (this.noteDebitEnteteVentes.getNdbTypeTransforme() == 24) {
                  var4 = "Bon retour";
               } else if (this.noteDebitEnteteVentes.getNdbTypeTransforme() == 25) {
                  var4 = "Facture";
               } else if (this.noteDebitEnteteVentes.getNdbTypeTransforme() == 26) {
                  var4 = "Avoir";
               } else if (this.noteDebitEnteteVentes.getNdbTypeTransforme() == 27) {
                  var4 = "Note de débit";
               }

               this.documentTrfItems.add(new SelectItem(this.noteDebitEnteteVentes.getNdbTypeTransforme(), var4));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 26, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(26, "Avoir"));
            }
         }

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            new NoteDebitEnteteVentes();
            NoteDebitEnteteVentes var5 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var8);
            if (var5.getNdbId() > 0L && var5.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.noteDebitLigneVentesDao.chargerLesLignes(var5, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new NoteDebitLigneVentes();
                     NoteDebitLigneVentes var7 = (NoteDebitLigneVentes)this.lesLignesList.get(var6);
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
      if (this.noteDebitEnteteVentes.getNdbTypeReg() != 0 && this.noteDebitEnteteVentes.getNdbTypeReg() != 3) {
         if (this.noteDebitEnteteVentes.getNdbTypeReg() != 1 && this.noteDebitEnteteVentes.getNdbTypeReg() != 2 && this.noteDebitEnteteVentes.getNdbTypeReg() != 10) {
            if (this.noteDebitEnteteVentes.getNdbTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.noteDebitEnteteVentes.getNdbModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.noteDebitEnteteVentes.getNdbModeReg() != null && !this.noteDebitEnteteVentes.getNdbModeReg().isEmpty() && this.noteDebitEnteteVentes.getNdbModeReg().contains(":")) {
         String[] var2 = this.noteDebitEnteteVentes.getNdbModeReg().split(":");
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

            this.noteDebitEnteteVentes.setNdbTypeReg(Integer.parseInt(var3.getEcheances()));
            this.noteDebitEnteteVentes.setNdbModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.noteDebitEnteteVentes.setNdbNbJourReg(0);
            this.noteDebitEnteteVentes.setNdbArrondiReg(0);
            break;
         }
      }

      if (this.noteDebitEnteteVentes.getNdbTypeReg() != 0 && this.noteDebitEnteteVentes.getNdbTypeReg() != 3) {
         if (this.noteDebitEnteteVentes.getNdbTypeReg() != 1 && this.noteDebitEnteteVentes.getNdbTypeReg() != 2 && this.noteDebitEnteteVentes.getNdbTypeReg() != 10) {
            if (this.noteDebitEnteteVentes.getNdbTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.noteDebitEnteteVentes.setNdbTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.noteDebitEnteteVentes.setNdbModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.noteDebitEnteteVentes.setNdbNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.noteDebitEnteteVentes.setNdbArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.noteDebitEnteteVentes.getNdbModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.noteDebitEnteteVentes.getNdbDate(), this.noteDebitEnteteVentes.getNdbTypeReg(), this.noteDebitEnteteVentes.getNdbNbJourReg(), this.noteDebitEnteteVentes.getNdbArrondiReg());
      this.noteDebitEnteteVentes.setNdbDateEcheReg(var1);
   }

   public void preSave() throws IOException, HibernateException, NamingException, Exception {
      boolean var1 = false;
      if (this.var_nom_responsable != 0L) {
         var1 = true;
      }

      if (var1) {
         if (this.noteDebitEnteteVentes.getNdbId() != 0L) {
            this.showModalPanelValidationDocument = true;
         } else {
            this.save();
         }
      }

   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.noteDebitEnteteVentes.setNdbDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.noteDebitEnteteVentes.getUsers() == null) {
            this.noteDebitEnteteVentes.setUsers(this.usersLog);
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

         this.noteDebitEnteteVentes.setTiers(this.tiers);
         if ((this.noteDebitEnteteVentes.getNdbCat() == null || this.noteDebitEnteteVentes.getNdbCat().isEmpty()) && this.noteDebitEnteteVentes.getTiers().getTienomfamille() != null && !this.noteDebitEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.noteDebitEnteteVentes.setNdbCat(this.noteDebitEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.noteDebitEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.noteDebitEnteteVentes.setNdbCivilTiers("");
         } else {
            this.noteDebitEnteteVentes.setNdbCivilTiers(this.noteDebitEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.noteDebitEnteteVentes.getNdbDiversTiers() == 99) {
               this.noteDebitEnteteVentes.setNdbIdContact(0L);
               this.noteDebitEnteteVentes.setNdbNomContact("");
               this.noteDebitEnteteVentes.setNdbCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.noteDebitEnteteVentes.setNdbIdContact(var3.getConid());
                  this.noteDebitEnteteVentes.setNdbNomContact(var3.getConpatronyme());
                  this.noteDebitEnteteVentes.setNdbCivilContact(var3.getConcivilite());
               } else {
                  this.noteDebitEnteteVentes.setNdbIdContact(0L);
                  this.noteDebitEnteteVentes.setNdbNomContact("");
                  this.noteDebitEnteteVentes.setNdbCivilContact("");
               }
            }

            this.noteDebitEnteteVentes.setNdbTiersRegroupe(this.tiers.getTiesigle());
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.noteDebitEnteteVentes.setNdbIdResponsable(var15.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomResponsable(var15.getUsrPatronyme());
         } else {
            this.noteDebitEnteteVentes.setNdbIdResponsable(0L);
            this.noteDebitEnteteVentes.setNdbNomResponsable("");
         }

         this.noteDebitEnteteVentes.setNdbIdCommercial(0L);
         this.noteDebitEnteteVentes.setNdbNomCommercial("");
         this.noteDebitEnteteVentes.setNdbIdEquipe(0L);
         this.noteDebitEnteteVentes.setNdbNomEquipe("");
         int var4;
         if (this.var_timbre != 0) {
            var4 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc(), var4, this.noteDebitEnteteVentes.getNdbDevise(), this.noteDebitEnteteVentes.getNdbDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.noteDebitEnteteVentes.getNdbDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.noteDebitEnteteVentes.getNdbDevise());
               this.noteDebitEnteteVentes.setNdbFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var4, this.noteDebitEnteteVentes.getNdbDevise(), this.noteDebitEnteteVentes.getNdbDate()));
            }
         }

         if (this.noteDebitEnteteVentes.getNdbId() == 0L) {
            this.noteDebitEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.noteDebitEnteteVentes.setNdbDateCreat(new Date());
            this.noteDebitEnteteVentes.setNdbIdCreateur(this.usersLog.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.noteDebitEnteteVentes.getNdbSerie() != null && !this.noteDebitEnteteVentes.getNdbSerie().equalsIgnoreCase("X") && !this.noteDebitEnteteVentes.getNdbSerie().isEmpty()) {
               this.noteDebitEnteteVentes.setNdbNum(this.calculChrono.numCompose(this.noteDebitEnteteVentes.getNdbDate(), this.nature, this.noteDebitEnteteVentes.getNdbSerie(), var1));
               boolean var17 = false;

               label274:
               while(true) {
                  while(true) {
                     if (var17) {
                        break label274;
                     }

                     new NoteDebitEnteteVentes();
                     NoteDebitEnteteVentes var18 = this.noteDebitEnteteVentesDao.pourParapheurByNum(this.noteDebitEnteteVentes.getNdbNum(), this.noteDebitEnteteVentes.getNdbSerie(), var1);
                     if (var18 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.noteDebitEnteteVentes.setNdbNum(this.calculChrono.numCompose(this.noteDebitEnteteVentes.getNdbDate(), this.nature, this.noteDebitEnteteVentes.getNdbSerie(), var1));
                        var17 = false;
                     } else {
                        var17 = true;
                     }
                  }
               }
            } else {
               long var16 = this.noteDebitEnteteVentesDao.selectLastNum(var1);
               this.noteDebitEnteteVentes.setNdbNum("" + var16);
            }

            this.noteDebitEnteteVentes.setNdbEtat(0);
            this.noteDebitEnteteVentes.setNdbEtatVal(0);
            this.noteDebitEnteteVentes.setNdbDateValide((Date)null);
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.insert(this.noteDebitEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.noteDebitEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.noteDebitEnteteVentes.setNdbDateModif(new Date());
            this.noteDebitEnteteVentes.setNdbIdModif(this.usersLog.getUsrid());
            this.noteDebitEnteteVentes.setNdbNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;

            for(var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
               this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.lesLignesList.get(var4);
               this.noteDebitLigneVentes.setNdbligOrdre(var4);
               this.noteDebitLigneVentes.setNoteDebitEnteteVentes(this.noteDebitEnteteVentes);
               this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var1);
            }
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.noteDebitEnteteVentes.getNdbId(), this.noteDebitEnteteVentes.getNdbNum(), this.noteDebitEnteteVentes.getNdbNomTiers(), this.noteDebitEnteteVentes.getNdbDate(), this.noteDebitEnteteVentes.getNdbDevise(), this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc(), this.noteDebitEnteteVentes.getNdbModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.noteDebitEnteteVentes.getVar_format_devise(), 0, var1);
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
      if (this.noteDebitEnteteVentes != null && this.noteDebitEnteteVentes.getNdbId() != 0L) {
         this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.noteDebitEnteteVentes.setNdbSite(this.usersLog.getUsrSite());
      this.noteDebitEnteteVentes.setNdbDepartement(this.usersLog.getUsrDepartement());
      this.noteDebitEnteteVentes.setNdbService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.noteDebitEnteteVentes.setNdbIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.noteDebitEnteteVentes.getNdbNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.noteDebitEnteteVentes.setNdbTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.noteDebitEnteteVentes.setNdbRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.noteDebitEnteteVentes.setNdbSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.noteDebitEnteteVentes.setNdbPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.noteDebitEnteteVentes.setNdbTiersRegroupe(this.tiers.getTiesigle());
            this.noteDebitEnteteVentes.setNdbRegion(this.tiers.getTieregion());
            this.noteDebitEnteteVentes.setNdbSecteur(this.tiers.getTiesecteur());
            this.noteDebitEnteteVentes.setNdbPdv(this.tiers.getTiepdv());
         }
      } else {
         this.noteDebitEnteteVentes.setNdbTiersRegroupe(this.tiers.getTiesigle());
         this.noteDebitEnteteVentes.setNdbRegion(this.tiers.getTieregion());
         this.noteDebitEnteteVentes.setNdbSecteur(this.tiers.getTiesecteur());
         this.noteDebitEnteteVentes.setNdbPdv(this.tiers.getTiepdv());
      }

   }

   public boolean verifieExistenceHabilitation() {
      if (this.habilitation != null) {
         this.noteDebitEnteteVentes.setNdbEtatVal(1);
         this.noteDebitEnteteVentes.setNdbEtat(0);
         this.noteDebitEnteteVentes.setNdbDateValide((Date)null);
         return true;
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

         return false;
      }
   }

   public void annulerDocument() {
      if (this.noteDebitEnteteVentes != null) {
         this.noteDebitEnteteVentes.setNdbDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.noteDebitEnteteVentes != null) {
         if (this.noteDebitEnteteVentes.getNdbDateAnnule() == null) {
            this.noteDebitEnteteVentes.setNdbDateAnnule(new Date());
         }

         this.noteDebitEnteteVentes.setNdbEtat(3);
         this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation note débit vente N° " + this.noteDebitEnteteVentes.getNdbNum() + " le " + this.noteDebitEnteteVentes.getNdbDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.noteDebitEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.noteDebitEnteteVentes.getNdbExoTva() == 0) {
         TaxesVentes var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
            } else if (this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var3);
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
         } else if (this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var3);
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
      }

      this.noteDebitLigneVentes.setNdbligTaxe(var6);
      this.noteDebitLigneVentes.setNdbligTauxTaxe(var5);
      double var36 = this.noteDebitLigneVentes.getNdbligPu();
      if (this.noteDebitLigneVentes.getNdbligQte() != 0.0F) {
         this.noteDebitLigneVentes.setNdbligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.noteDebitLigneVentes.getNdbligCondition(), this.noteDebitLigneVentes.getNdbligQte(), this.noteDebitLigneVentes.getNdbligLong(), this.noteDebitLigneVentes.getNdbligLarg(), this.noteDebitLigneVentes.getNdbligHaut(), this.noteDebitLigneVentes.getNdbligDiam(), this.noteDebitLigneVentes.getNdbligNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.noteDebitLigneVentes.setNdbligQteUtil(0.0F);
      }

      double var10 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
         var10 = var36 * (double)this.noteDebitLigneVentes.getNdbligQte();
      } else {
         var10 = var36 * (double)this.noteDebitLigneVentes.getNdbligQte();
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
         var12 = var10 - var10 * (double)this.noteDebitLigneVentes.getNdbligTauxRemise() / 100.0D - var14;
      } else {
         var12 = var10 - var14;
      }

      double var16 = this.utilNombre.myRoundFormat(var12, this.var_format_devise);
      double var18 = var16 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var18 *= -1.0D;
      }

      double var20 = this.utilNombre.myRoundFormat(var18, this.var_format_devise);
      double var22 = var16 + var20;
      double var24 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
         var24 = this.utilNombre.myRound(var16 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      } else {
         var24 = this.utilNombre.myRound(var16 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      }

      this.noteDebitLigneVentes.setNdbligPuRem(var24);
      this.noteDebitLigneVentes.setNdbligPt(var16);
      this.noteDebitLigneVentes.setNdbligTva(var20);
      this.noteDebitLigneVentes.setNdbligTc(0.0D);
      this.noteDebitLigneVentes.setNdbligTtc(var22);
      double var26 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
         var26 = this.utilNombre.myRound(var22 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      } else {
         var26 = this.utilNombre.myRound(var22 / (double)this.noteDebitLigneVentes.getNdbligQte(), 2);
      }

      this.noteDebitLigneVentes.setNdbligPuRemTtc(var26);
      double var28 = var36 + var36 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
      this.noteDebitLigneVentes.setNdbligPuTtc(var28);
      if (this.noteDebitEnteteVentes.getNdbTauxTc() != 0.0F) {
         double var30 = 0.0D;
         double var32 = 0.0D;
         float var34 = 0.0F;
         if (this.lesFamilleClientsListe.size() != 0) {
            for(int var35 = 0; var35 < this.lesFamilleClientsListe.size() && !this.noteDebitEnteteVentes.getNdbCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var35)).getLibelle()); ++var35) {
            }
         }

         if (var34 == 1.0F) {
            var30 = var22 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
         } else if (var34 == 2.0F) {
            var30 = var16 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
            if (this.noteDebitLigneVentes.getNdbligTauxTaxe() != 0.0F) {
               var30 += var30 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
            }
         } else if (var34 == 3.0F) {
            var30 = var16 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
         }

         var32 = this.utilNombre.myRoundFormat(var30, this.var_format_devise);
         this.noteDebitLigneVentes.setNdbligTc(var32);
      } else {
         this.noteDebitLigneVentes.setNdbligTc(0.0D);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.noteDebitEnteteVentes.getNdbExoTva() == 0) {
         TaxesVentes var8;
         int var40;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var40 = var8.getTaxvteType();
            } else if (this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxvteTaux();
                  var6 = var9.getTaxvteCode();
                  var40 = var9.getTaxvteType();
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
         } else if (this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var40 = var8.getTaxvteType();
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
      }

      this.noteDebitLigneVentes.setNdbligTaxe(var6);
      this.noteDebitLigneVentes.setNdbligTauxTaxe(var5);
      double var41 = 0.0D;
      double var10;
      double var12;
      if (this.noteDebitEnteteVentes.getNdbTauxTc() != 0.0F) {
         var10 = this.noteDebitLigneVentes.getNdbligPuTtc() * (double)this.noteDebitLigneVentes.getNdbligQte();
         var12 = var10 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
         var41 = this.utilNombre.myRound((var10 - var12) / (double)this.noteDebitLigneVentes.getNdbligQte(), Integer.parseInt(this.optionMedical.getNbDecPu()));
      } else {
         var41 = this.noteDebitLigneVentes.getNdbligPuTtc();
      }

      var10 = var41 / (double)(1.0F + var5 / 100.0F);
      this.noteDebitLigneVentes.setNdbligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionMedical.getNbDecPu())));
      var12 = 0.0D;
      double var14 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.noteDebitLigneVentes.getNdbligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.noteDebitLigneVentes.getNdbligTauxRemise() != 0.0F) {
         var16 = var41 - var41 * (double)this.noteDebitLigneVentes.getNdbligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var41 - var12;
      }

      if (this.noteDebitLigneVentes.getNdbligQte() != 0.0F) {
         this.noteDebitLigneVentes.setNdbligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.noteDebitLigneVentes.getNdbligCondition(), this.noteDebitLigneVentes.getNdbligQte(), this.noteDebitLigneVentes.getNdbligLong(), this.noteDebitLigneVentes.getNdbligLarg(), this.noteDebitLigneVentes.getNdbligHaut(), this.noteDebitLigneVentes.getNdbligDiam(), this.noteDebitLigneVentes.getNdbligNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.noteDebitLigneVentes.setNdbligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionMedical.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionMedical.getNbDecPu()));
      double var22 = var18 * (double)this.noteDebitLigneVentes.getNdbligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.noteDebitEnteteVentes.getNdbDevise()));
      double var26 = var20 * (double)this.noteDebitLigneVentes.getNdbligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.noteDebitEnteteVentes.getNdbDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.noteDebitEnteteVentes.getNdbDevise()));
      this.noteDebitLigneVentes.setNdbligPuRem(var18);
      this.noteDebitLigneVentes.setNdbligPuRemTtc(var20);
      this.noteDebitLigneVentes.setNdbligPt(var24);
      this.noteDebitLigneVentes.setNdbligTva(var32);
      this.noteDebitLigneVentes.setNdbligTtc(var28);
      if (this.noteDebitEnteteVentes.getNdbTauxTc() != 0.0F) {
         double var34 = 0.0D;
         double var36 = 0.0D;
         float var38 = 0.0F;
         if (this.lesFamilleClientsListe.size() != 0) {
            for(int var39 = 0; var39 < this.lesFamilleClientsListe.size() && !this.noteDebitEnteteVentes.getNdbCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var39)).getLibelle()); ++var39) {
            }
         }

         if (var38 == 1.0F) {
            var34 = var28 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
         } else if (var38 == 2.0F) {
            var34 = var24 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
            if (this.noteDebitLigneVentes.getNdbligTauxTaxe() != 0.0F) {
               var34 += var34 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
            }
         } else if (var38 == 3.0F) {
            var34 = var24 * (double)this.noteDebitEnteteVentes.getNdbTauxTc() / 100.0D;
         }

         var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
         this.noteDebitLigneVentes.setNdbligTc(var36);
      } else {
         this.noteDebitLigneVentes.setNdbligTc(0.0D);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.noteDebitLigneVentes != null && this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty()) {
         if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty()) {
            boolean var1 = false;
            if (this.optionMedical.getDecrmtPriVteStock().equals("2") && this.noteDebitLigneVentes.getNdbligPuTtc() == 0.0D) {
               var1 = true;
            } else if (this.optionMedical.getDecrmtPriVteStock().equals("1") && this.noteDebitLigneVentes.getNdbligPu() == 0.0D) {
               var1 = true;
            }

            if (var1) {
               this.prixUnitaireCorrespond((Session)null);
            }
         } else {
            this.prixUnitaireDegressif((Session)null);
         }
      } else {
         this.produits = null;
      }

      this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
            if (this.noteDebitLigneVentes.getNdbligPuRemTtc() != 0.0D) {
               if (this.noteDebitLigneVentes.getNdbligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.noteDebitLigneVentes.getNdbligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.noteDebitLigneVentes.getNdbligPuRem() != 0.0D) {
            if (this.noteDebitLigneVentes.getNdbligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.noteDebitLigneVentes.getNdbligPu() < this.prixPlancher) {
            this.griserValider = true;
            this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

      if (this.plafondEnCours != 0.0D) {
         if (this.soldeEnCours + this.noteDebitLigneVentes.getNdbligTtc() <= this.plafondEnCours) {
            this.plafondAutorise = true;
         } else {
            this.plafondAutorise = false;
            this.formRecherche.setMessageTexte("Vous avez dépassé le plafond. Veuillez réduire les quantités.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      } else {
         this.plafondAutorise = true;
      }

   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
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
         new NoteDebitLigneVentes();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            NoteDebitLigneVentes var13 = (NoteDebitLigneVentes)this.lesLignesList.get(var14);
            if (var13.getNdbligGroupe() == null || var13.getNdbligGroupe().isEmpty()) {
               var3 += var13.getNdbligPt();
               var5 += var13.getNdbligTva();
               var7 += var13.getNdbligTtc();
               var9 += var13.getNdbligTc();
               if (var13.getNdbligRabais() != 0.0D || var13.getNdbligTauxRemise() != 0.0F) {
                  var11 += var13.getNdbligPu() * (double)var13.getNdbligQte() - var13.getNdbligPt();
               }

               var1 = var1 + var13.getNdbligPt() - var13.getNdbligPump() * (double)var13.getNdbligQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.noteDebitEnteteVentes.setNdbTotHt(var3);
      this.noteDebitEnteteVentes.setNdbTotTva(var5);
      this.noteDebitEnteteVentes.setNdbTotTtc(var7);
      this.noteDebitEnteteVentes.setNdbTotRemise(var11);
      this.noteDebitEnteteVentes.setNdbTotTc(var9);
      if (this.plafondEnCours != 0.0D) {
         if (this.soldeEnCours + var7 <= this.plafondEnCours) {
            this.plafondAutorise = true;
         } else {
            this.plafondAutorise = false;
            this.formRecherche.setMessageTexte("Vous avez dépassé le plafond. Veuillez réduire les quantités.....");
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
         this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
         if (this.noteDebitLigneVentes.getNdbligCode() != null && this.noteDebitLigneVentes.getNdbligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.noteDebitLigneVentes.getNdbligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.noteDebitLigneVentes.setNdbligCode(this.produits.getProCode());
               this.noteDebitLigneVentes.setNdbligFamille(this.produits.getProAchCode());
               this.noteDebitLigneVentes.setNdbligStock(this.produits.getProStock());
               this.noteDebitLigneVentes.setNdbligPoidsBrut(this.produits.getProPoidsBrut());
               this.noteDebitLigneVentes.setNdbligPoidsNet(this.produits.getProPoidsNet());
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
               if (this.noteDebitLigneVentes.getNdbligTaxe() != null && !this.noteDebitLigneVentes.getNdbligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTaxe() + ":" + this.noteDebitLigneVentes.getNdbligTauxTaxe()));
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
      this.memoProduits = new Produits();
      this.noteDebitLigneVentes = new NoteDebitLigneVentes();
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

   public void ordonnnerDescendant() {
      if (this.datamodelLigne.isRowAvailable()) {
         this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.datamodelLigne.getRowData();
         if (this.noteDebitLigneVentes != null) {
            this.numLigne = this.clauleNumlLigne() + 1;
            new NoteDebitLigneVentes();
            NoteDebitLigneVentes var1 = this.noteDebitLigneVentes;
            this.lesLignesList.remove(this.noteDebitLigneVentes);
            this.lesLignesList.add(this.numLigne, var1);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }
      }

   }

   public void ordonnnerAscendant() {
      if (this.datamodelLigne.isRowAvailable()) {
         this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.datamodelLigne.getRowData();
         if (this.noteDebitLigneVentes != null) {
            this.numLigne = this.clauleNumlLigne() - 1;
            new NoteDebitLigneVentes();
            NoteDebitLigneVentes var1 = this.noteDebitLigneVentes;
            this.lesLignesList.remove(this.noteDebitLigneVentes);
            this.lesLignesList.add(this.numLigne, var1);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }
      }

   }

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            if (this.noteDebitLigneVentes.getNdbligId() == ((NoteDebitLigneVentes)this.lesLignesList.get(var2)).getNdbligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.noteDebitLigneVentes.getNdbligQte() != 0.0F || this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && (this.noteDebitLigneVentes.getNdbligCode().equals("-") || this.noteDebitLigneVentes.getNdbligCode().equals("+") || this.noteDebitLigneVentes.getNdbligCode().equals("="))) {
         if (this.noteDebitEnteteVentes.getNdbId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.noteDebitLigneVentes.getNdbligQteUtil() == 0.0F) {
               this.noteDebitLigneVentes.setNdbligQteUtil(this.noteDebitLigneVentes.getNdbligQte());
            }

            this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.noteDebitLigneVentes.setNdbligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.noteDebitLigneVentes.setNdbligDepot(var3[0]);
               }
            } else {
               this.noteDebitLigneVentes.setNdbligDepot("");
            }

            if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.noteDebitLigneVentes.getNdbligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.noteDebitLigneVentes.setNdbligDescription(var5);
               } else {
                  this.noteDebitLigneVentes.setNdbligDescription("");
               }

               if (this.noteDebitLigneVentes.getNdbligEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.noteDebitLigneVentes.setNdbligEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.noteDebitLigneVentes.setNdbligDescription("");
            }

            if (this.noteDebitLigneVentes.getNdbligId() == 0L) {
               this.noteDebitLigneVentes.setNoteDebitEnteteVentes(this.noteDebitEnteteVentes);
               this.noteDebitLigneVentes.setNdbligDevise(this.noteDebitEnteteVentes.getNdbDevise());
               this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.insertLigne(this.noteDebitLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.noteDebitLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new NoteDebitLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  NoteDebitLigneVentes var16 = (NoteDebitLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getNdbligGroupe() != null && !var16.getNdbligGroupe().isEmpty() && var16.getNdbligGroupe().equals(this.memoProduits.getProCode())) {
                     this.noteDebitLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.noteDebitLigneVentes.getNdbligQte();
               new NoteDebitLigneVentes();

               NoteDebitLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (NoteDebitLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getNdbligGroupe() != null && !var19.getNdbligGroupe().isEmpty() && var19.getNdbligGroupe().equals(var18)) {
                     this.noteDebitLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new NoteDebitLigneVentes();
                     var19.setNdbligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setNdbligCondition("");
                     var19.setNdbligComplement("");
                     var19.setNdbligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setNdbligDescription("");
                     var19.setNdbligDevise(this.noteDebitEnteteVentes.getNdbDevise());
                     var19.setNdbligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setNdbligEchelle(0);
                     var19.setNdbligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setNdbligGroupe(var18);
                     var19.setNdbligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setNdbligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setNdbligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setNdbligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setNdbligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setNdbligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setNdbligOrdre(var8);
                     var19.setNdbligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setNdbligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setNdbligPt(0.0D);
                     var19.setNdbligPu(0.0D);
                     var19.setNdbligPuRem(0.0D);
                     var19.setNdbligPuRemTtc(0.0D);
                     var19.setNdbligPuTtc(0.0D);
                     var19.setNdbligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setNdbligQte(var9);
                     var19.setNdbligQteUtil(var19.getNdbligQte());
                     var19.setNdbligRabais(0.0D);
                     var19.setNdbligReference(var18);
                     var19.setNdbligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setNdbligTauxRemise(0.0F);
                     var19.setNdbligTauxTaxe(0.0F);
                     var19.setNdbligTaxe("");
                     var19.setNdbligTc(0.0D);
                     var19.setNdbligTtc(0.0D);
                     var19.setNdbligTva(0.0D);
                     var19.setNdbligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setNdbligVolume(0.0F);
                     var19.setNoteDebitEnteteVentes(this.noteDebitEnteteVentes);
                     var19 = this.noteDebitLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
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
      if (this.noteDebitLigneVentes.getNdbligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.noteDebitLigneVentes.getNdbligCode();
            int var4 = this.noteDebitLigneVentes.getNdbligModeGroupe();
            String var5 = this.noteDebitLigneVentes.getNdbligGroupe();
            this.noteDebitLigneVentesDao.deleteOneLigne(this.noteDebitLigneVentes, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new NoteDebitLigneVentes();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  NoteDebitLigneVentes var6 = (NoteDebitLigneVentes)this.lesLignesList.get(var7);
                  if (var6.getNdbligGroupe() != null && !var6.getNdbligGroupe().isEmpty() && var6.getNdbligGroupe().equals(var3)) {
                     this.noteDebitLigneVentesDao.deleteOneLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " de la Note de débit N° " + this.noteDebitEnteteVentes.getNdbNum() + " du " + this.noteDebitEnteteVentes.getNdbDate());
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
      this.tiers = this.formRecherche.rechercheTiers(3, this.noteDebitEnteteVentes.getNdbNomTiers(), this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         boolean var2 = false;
         if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
            if (this.tiers.getTieserie().equals("X")) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.mesSerieUserItem.size(); ++var3) {
                  if (((SelectItem)this.mesSerieUserItem.get(var3)).getValue().toString().equals(this.tiers.getTieserie())) {
                     var2 = true;
                     this.noteDebitEnteteVentes.setNdbSerie(this.tiers.getTieserie());
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
            this.noteDebitEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.noteDebitEnteteVentes.setNdbCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.noteDebitEnteteVentes.setNdbCivilTiers(this.noteDebitEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.noteDebitEnteteVentes.setNdbNomTiers(this.nomTier);
            this.noteDebitEnteteVentes.setNdbTypeReg(this.tiers.getTietypereg());
            this.noteDebitEnteteVentes.setNdbModeReg(this.tiers.getTiemodereg());
            this.calculMessageLitige(var1);
            String var8 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var8 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var8 = this.tiers.getTiemodereg();
            }

            if (!var8.equals("") && !var8.equals("100")) {
               this.noteDebitEnteteVentes.setNdbNbJourReg(this.tiers.getTienbecheance());
               this.noteDebitEnteteVentes.setNdbArrondiReg(this.tiers.getTienbarrondi());
            } else {
               for(int var9 = 0; var9 < this.lesModeReglementClientsListe.size(); ++var9) {
                  new ObjetReglement();
                  ObjetReglement var5 = (ObjetReglement)this.lesModeReglementClientsListe.get(var9);
                  if (var5.getDefaut().equals("true")) {
                     if (var5.getEcheances() == null || var5.getEcheances().isEmpty()) {
                        var5.setEcheances("0");
                     }

                     this.noteDebitEnteteVentes.setNdbTypeReg(Integer.parseInt(var5.getEcheances()));
                     this.noteDebitEnteteVentes.setNdbModeReg(var5.getCategories() + ":" + var5.getLibelles());
                     int var6 = 0;
                     if (var5.getNbjours() != null && !var5.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var5.getNbjours());
                     }

                     this.noteDebitEnteteVentes.setNdbNbJourReg(var6);
                     int var7 = 0;
                     if (var5.getArrondis() != null && !var5.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var5.getArrondis());
                     }

                     this.noteDebitEnteteVentes.setNdbArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.noteDebitEnteteVentes.setNdbJournalReg(this.tiers.getTiejournalreg());
            this.noteDebitEnteteVentes.setNdbCat(this.tiers.getTienomfamille());
            this.noteDebitEnteteVentes.setNdbExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.noteDebitEnteteVentes.setNdbExoDouane(1);
            }

            this.noteDebitEnteteVentes.setNdbExoTva(this.tiers.getTieexotva());
            float var10 = 0.0F;
            this.noteDebitEnteteVentes.setNdbTauxTc(var10);
            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.noteDebitEnteteVentes.setNdbExoTva(1);
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.noteDebitEnteteVentes.setNdbDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.noteDebitEnteteVentes.setNdbDiversTiers(0);
               this.noteDebitEnteteVentes.setNdbDiversNom("");
               this.noteDebitEnteteVentes.setNdbDiversAdresse("");
               this.noteDebitEnteteVentes.setNdbDiversVille("");
               this.noteDebitEnteteVentes.setNdbDiversTel("");
               this.noteDebitEnteteVentes.setNdbDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.noteDebitEnteteVentes.setNdbDevise(this.tiers.getTiedevise());
            } else {
               this.noteDebitEnteteVentes.setNdbDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }

            this.chargerLesUsers(var1);
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
            if (this.optionMedical.getGestionPlafondNdb().equals("1")) {
               this.plafondEnCours = this.tiers.getTieplafond();
               new ArrayList();
               String var5 = " tiers.tieid=" + this.tiers.getTieid() + " and ndb_solde=0  and ndb_id<>" + this.noteDebitEnteteVentes.getNdbId();
               double var6 = 0.0D;
               List var4 = this.noteDebitEnteteVentesDao.rechercheNoteDebitRequete(var5, var1);
               if (var4.size() != 0) {
                  for(int var8 = 0; var8 < var4.size(); ++var8) {
                     var6 += ((NoteDebitEnteteVentes)var4.get(var8)).getNdbTotTtc() - ((NoteDebitEnteteVentes)var4.get(var8)).getNdbTotReglement();
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
      this.noteDebitEnteteVentes.setTiers(this.tiers);
      this.noteDebitEnteteVentes.setNdbNomTiers("");
      this.noteDebitEnteteVentes.setNdbCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
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
      if (!this.noteDebitEnteteVentes.getNdbNomTiers().equals("") && this.tiers.getTieid() != 0L) {
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
      float var3 = 0.0F;
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var4 = 0; var4 < this.lesFamilleClientsListe.size(); ++var4) {
            if (this.noteDebitEnteteVentes.getNdbCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.noteDebitEnteteVentes.setNdbExoTva(0);
      } else {
         this.noteDebitEnteteVentes.setNdbExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.noteDebitEnteteVentes.setNdbExoDouane(0);
      } else {
         this.noteDebitEnteteVentes.setNdbExoDouane(1);
      }

      this.noteDebitEnteteVentes.setNdbTauxTc(var3);
      this.calculeExoneration();
   }

   public void calculeExoneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.noteDebitLigneVentes = new NoteDebitLigneVentes();
               this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.lesLignesList.get(var3);
               if (this.noteDebitEnteteVentes.getNdbExoTva() == 1) {
                  this.noteDebitLigneVentes.setNdbligTaxe("");
                  this.noteDebitLigneVentes.setNdbligTauxTaxe(0.0F);
                  this.noteDebitLigneVentes.setNdbligTva(0.0D);
               } else if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.noteDebitLigneVentes.getNdbligCode(), var1);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.getProVteTva() != null && !var4.getProVteTva().isEmpty()) {
                        this.noteDebitLigneVentes.setNdbligTaxe(var4.getProVteTva());
                     } else {
                        this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var4, var1);
                        if (this.famillesProduitsVentes != null) {
                           this.noteDebitLigneVentes.setNdbligTaxe(this.famillesProduitsVentes.getFamvteTaxe());
                        }
                     }

                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.noteDebitLigneVentes.getNdbligTaxe(), var1);
                     if (var5 != null) {
                        this.noteDebitLigneVentes.setNdbligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.noteDebitLigneVentes.setNdbligTauxTaxe(0.0F);
                     }
                  } else if (this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.noteDebitLigneVentes.setNdbligTaxe(this.optionMedical.getTvaDefaut());
                        this.noteDebitLigneVentes.setNdbligTauxTaxe(var5.getTaxvteTaux());
                     } else {
                        this.noteDebitLigneVentes.setNdbligTaxe("");
                        this.noteDebitLigneVentes.setNdbligTauxTaxe(0.0F);
                     }
                  } else {
                     this.noteDebitLigneVentes.setNdbligTaxe("");
                     this.noteDebitLigneVentes.setNdbligTauxTaxe(0.0F);
                  }

                  if ((this.noteDebitLigneVentes.getNdbligTaxe() == null || this.noteDebitLigneVentes.getNdbligTaxe().isEmpty()) && this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var1);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.noteDebitLigneVentes.setNdbligTaxe(var5.getTaxvteCode());
                        this.noteDebitLigneVentes.setNdbligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var1);
               this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var1);
            }
         }

         if (this.noteDebitEnteteVentes.getNdbExoTva() == 0) {
            this.noteDebitEnteteVentes.setNdbMotifExo("");
            this.noteDebitEnteteVentes.setNdbNumVisa("");
            this.noteDebitEnteteVentes.setNdbDateVisa((Date)null);
            this.noteDebitEnteteVentes.setNdbRangeVisa("");
         }

         if (this.noteDebitEnteteVentes.getNdbId() != 0L) {
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesLignesList.size() != 0) {
            this.noteDebitLigneVentes = new NoteDebitLigneVentes();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.lesLignesList.get(var3);
               this.noteDebitLigneVentes.setNdbligTauxRemise(this.noteDebitEnteteVentes.getNdbTauxRemise());
               this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var1);
               this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var1);
            }
         }

         if (this.noteDebitEnteteVentes.getNdbId() != 0L) {
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
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
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.noteDebitEnteteVentes.getNdbNomContact(), this.nature);
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
         this.noteDebitEnteteVentes.setNdbNomContact(this.plansAnalytiques.getAnaNomFr());
         this.noteDebitEnteteVentes.setNdbCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.noteDebitEnteteVentes.setNdbAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.noteDebitEnteteVentes.setNdbNomContact("");
      this.noteDebitEnteteVentes.setNdbCivilContact("");
      this.noteDebitEnteteVentes.setNdbAnal4("");
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
      if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && !this.noteDebitLigneVentes.getNdbligCode().equals("-") && !this.noteDebitLigneVentes.getNdbligCode().equals("=")) {
         this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.noteDebitLigneVentes.getNdbligCode(), this.nature, this.optionMedical);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
         this.noteDebitLigneVentes.setNdbligCode(this.produits.getProCode());
         this.noteDebitLigneVentes.setNdbligLibelle(this.produits.getProLibClient().toUpperCase());
         this.noteDebitLigneVentes.setNdbligFamille(this.produits.getProVteCode());
         this.noteDebitLigneVentes.setNdbligPoidsBrut(this.produits.getProPoidsBrut());
         this.noteDebitLigneVentes.setNdbligPoidsNet(this.produits.getProPoidsNet());
         this.noteDebitLigneVentes.setNdbligVolume(0.0F);
         this.noteDebitLigneVentes.setNdbligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.noteDebitLigneVentes.setNdbligModeGroupe(this.produits.getProMode());
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
         FamillesProduitsVentes var2 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
         TaxesVentes var3;
         if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
            new TaxesVentes();
            var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
            if (var3 != null) {
               this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var3.getTaxvteTaux()));
               this.noteDebitLigneVentes.setNdbligTaxe(this.produits.getProVteTva());
               this.noteDebitLigneVentes.setNdbligTauxTaxe(var3.getTaxvteTaux());
            } else {
               this.noteDebitLigneVentes.setNdbligTaxe("");
               this.noteDebitLigneVentes.setNdbligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }
         } else if (var2 != null && var2.getFamvteTaxe() != null && !var2.getFamvteTaxe().isEmpty() && !var2.getFamvteTaxe().equals("0")) {
            new TaxesVentes();
            var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var2.getFamvteTaxe(), var1);
            if (var3 != null) {
               this.mesTaxesVentesProduits.add(new SelectItem(var2.getFamvteTaxe(), var2.getFamvteTaxe() + ":" + var3.getTaxvteTaux()));
               this.noteDebitLigneVentes.setNdbligTaxe(var2.getFamvteTaxe());
               this.noteDebitLigneVentes.setNdbligTauxTaxe(var3.getTaxvteTaux());
            }
         } else {
            this.noteDebitLigneVentes.setNdbligTaxe("");
            this.noteDebitLigneVentes.setNdbligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         if (this.noteDebitEnteteVentes.getNdbExoTva() == 0 && (this.noteDebitLigneVentes.getNdbligTaxe() == null || this.noteDebitLigneVentes.getNdbligTaxe().isEmpty()) && this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionMedical.getTvaDefaut(), var1);
            if (var3 != null) {
               this.mesTaxesVentesProduits.add(new SelectItem(var3.getTaxvteCode(), var3.getTaxvteCode() + ":" + var3.getTaxvteTaux()));
               this.noteDebitLigneVentes.setNdbligTaxe(var3.getTaxvteCode());
               this.noteDebitLigneVentes.setNdbligTauxTaxe(var3.getTaxvteTaux());
            }
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var2 != null && var2.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var8 = (100.0F - var2.getFamvteCoefPv()) / 100.0F;
            if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var8;
               double var6 = var4 + var4 * (double)this.noteDebitLigneVentes.getNdbligTauxTaxe() / 100.0D;
               this.prixPlancher = this.utilNombre.myRound(var6, 2);
            } else {
               this.prixPlancher = this.utilNombre.myRound(this.produitsDepot.getProdepPr() / (double)var8, 2);
            }
         } else {
            this.prixPlancher = 0.0D;
         }

         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.noteDebitLigneVentes.setNdbligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.noteDebitLigneVentes.setNdbligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.noteDebitLigneVentes.setNdbligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.noteDebitLigneVentes.setNdbligCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.noteDebitLigneVentes.setNdbligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.noteDebitLigneVentes.getNdbligPump() != 0.0D) {
            this.noteDebitLigneVentes.setNdbligPu(this.noteDebitLigneVentes.getNdbligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var1);
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
      if ((this.noteDebitLigneVentes.getNdbligCode() == null || this.noteDebitLigneVentes.getNdbligCode().isEmpty() || this.noteDebitLigneVentes.getNdbligCode().length() < 2) && this.noteDebitEnteteVentes.getNdbExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
         if (this.mesTaxesVentesProduits.isEmpty()) {
            this.mesTaxesVentesProduits.clear();
            if (this.mesTaxesVentesItems.size() != 0) {
               for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                  this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
               }
            }

            if (this.optionMedical.getTvaDefaut() != null && !this.optionMedical.getTvaDefaut().isEmpty()) {
               this.noteDebitLigneVentes.setNdbligTaxe(this.optionMedical.getTvaDefaut());
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.noteDebitLigneVentes.setNdbligCode("");
      this.noteDebitLigneVentes.setNdbligLibelle("");
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
         new ProduitsTarif();
         ProduitsTarif var2 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.noteDebitEnteteVentes.getNdbCat(), this.noteDebitLigneVentes.getNdbligCondition(), var1);
         if (var2 != null) {
            this.prixUnitaires = var2.getProtarPv();
         } else {
            this.prixUnitaires = 0.0D;
         }

         if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
            this.noteDebitLigneVentes.setNdbligPuTtc(this.prixUnitaires);
         } else {
            this.noteDebitLigneVentes.setNdbligPu(this.prixUnitaires);
         }
      }

   }

   public void prixUnitaireDegressif(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         double var4 = 0.0D;
         if (this.noteDebitLigneVentes.getNdbligPu() > 0.0D && this.noteDebitLigneVentes.getNdbligPuTtc() > 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.noteDebitEnteteVentes.getNdbCat(), (String)null, var1);
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
                     if (this.noteDebitLigneVentes.getNdbligQte() >= var7.getQteDebut() && this.noteDebitLigneVentes.getNdbligQte() <= var7.getQteFin()) {
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
                        if (this.noteDebitLigneVentes.getNdbligQte() >= var7.getQteDebut() && this.noteDebitLigneVentes.getNdbligQte() <= var7.getQteFin()) {
                           var8 = var7.getPrix();
                           break;
                        }
                     }
                  }

                  if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
                     this.noteDebitLigneVentes.setNdbligPuTtc(var8);
                  } else {
                     this.noteDebitLigneVentes.setNdbligPu(var8);
                  }
               } else if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
                  if (var4 != 0.0D) {
                     this.noteDebitLigneVentes.setNdbligPuTtc(var4);
                  } else {
                     this.noteDebitLigneVentes.setNdbligPuTtc(var6.getProtarPv());
                  }
               } else if (var2 != 0.0D) {
                  this.noteDebitLigneVentes.setNdbligPu(var2);
               } else {
                  this.noteDebitLigneVentes.setNdbligPu(var6.getProtarPv());
               }
            } else if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
               this.noteDebitLigneVentes.setNdbligPuTtc(var4);
            } else {
               this.noteDebitLigneVentes.setNdbligPu(var2);
            }
         } else {
            var2 = Math.abs(this.noteDebitLigneVentes.getNdbligPu());
            var4 = Math.abs(this.noteDebitLigneVentes.getNdbligPuTtc());
            if (this.optionMedical.getDecrmtPriVteStock().equals("2")) {
               this.noteDebitLigneVentes.setNdbligPuTtc(var4);
            } else {
               this.noteDebitLigneVentes.setNdbligPu(var2);
            }
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.noteDebitLigneVentes.setNdbligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.noteDebitLigneVentes.getNdbligEchelle());
            float var5 = 1.0F;
            if (this.noteDebitLigneVentes.getNdbligCondition().contains("/")) {
               String[] var6 = this.noteDebitLigneVentes.getNdbligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && !this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.noteDebitLigneVentes.getNdbligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.noteDebitLigneVentes.setNdbligPump(var9);
      } else {
         this.noteDebitLigneVentes.setNdbligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.noteDebitLigneVentes.getNdbligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.noteDebitLigneVentes.setNdbligEchelle(this.unite.getUniEchelle());
               } else {
                  this.noteDebitLigneVentes.setNdbligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.noteDebitLigneVentes.setNdbligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.noteDebitLigneVentes.setNdbligEchelle(Integer.parseInt(var2));
         } else {
            this.noteDebitLigneVentes.setNdbligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var10 = 0; var10 < this.listeProduitDepot.size(); ++var10) {
               ProduitsDepot var11 = (ProduitsDepot)this.listeProduitDepot.get(var10);
               float var12 = 0.0F;
               var12 = var11.getProdepQteStk();
               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.noteDebitLigneVentes.getNdbligLong(), this.noteDebitLigneVentes.getNdbligLarg(), this.noteDebitLigneVentes.getNdbligHaut(), this.noteDebitLigneVentes.getNdbligDiam(), this.noteDebitLigneVentes.getNdbligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.noteDebitLigneVentes.getNdbligLong(), this.noteDebitLigneVentes.getNdbligLarg(), this.noteDebitLigneVentes.getNdbligHaut(), this.noteDebitLigneVentes.getNdbligDiam(), this.noteDebitLigneVentes.getNdbligNb(), this.baseLog, var1);
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
      if (this.montantElmTotBonEnc <= this.noteDebitEnteteVentes.getNdbTotTtc() - this.var_tot_bon_encaissement) {
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

      this.var_date_trf = new Date();
      this.var_serie_trf = this.noteDebitEnteteVentes.getNdbSerie();
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
      this.var_imput_serie = this.noteDebitEnteteVentes.getNdbSerie();
      this.var_imput_cat = this.noteDebitEnteteVentes.getNdbCat();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.noteDebitEnteteVentes.getNdbNum();
            this.noteDebitEnteteVentes.setNdbSerie(this.var_imput_serie);
            this.noteDebitEnteteVentes.setNdbCat(this.var_imput_cat);
            this.noteDebitEnteteVentes.setNdbNum(this.calculChrono.numCompose(this.noteDebitEnteteVentes.getNdbDate(), this.nature, this.noteDebitEnteteVentes.getNdbSerie(), var1));
            this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
            ArrayList var4;
            if (this.noteDebitEnteteVentes.getNdbTotReglement() != 0.0D) {
               new ArrayList();
               ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
               if (var4 != null) {
                  for(int var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     Reglements var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.noteDebitEnteteVentes.getNdbNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
            if (var4 != null) {
               for(int var13 = 0; var13 < var4.size(); ++var13) {
                  new Parapheur();
                  Parapheur var15 = (Parapheur)var4.get(var13);
                  var15.setPhrNum(this.noteDebitEnteteVentes.getNdbNum());
                  this.parapheurDao.modif(var15, var1);
               }
            }

            Espion var14 = new Espion();
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            var14.setEspaction("Imputation Note de débit X N° " + var3 + " en Note de débit " + this.noteDebitEnteteVentes.getNdbSerie() + " N° " + this.noteDebitEnteteVentes.getNdbNum());
            this.espionDao.mAJEspion(var14, var1);
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
            new NoteDebitLigneVentes();
            NoteDebitLigneVentes var3 = (NoteDebitLigneVentes)this.documentDetailTrf.get(var2);
            long var4 = var3.getNdbligId();
            float var6 = var3.getNdbligQte();
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
            var3 = (NoteDebitLigneVentes)this.documentDetailTrf.set(var2, var3);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new NoteDebitLigneVentes();
            NoteDebitLigneVentes var2 = (NoteDebitLigneVentes)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (NoteDebitLigneVentes)this.documentDetailTrf.set(var1, var2);
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
            var3 += ((NoteDebitLigneVentes)this.documentDetailTrf.get(var5)).getNdbligQte();
            var2 += ((NoteDebitLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteDejaTrf();
            var4 += ((NoteDebitLigneVentes)this.documentDetailTrf.get(var5)).getVar_qteReliquat();
         }

         boolean var10 = false;
         int var7;
         if (var3 == var2) {
            new NoteDebitEnteteVentes();

            for(var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
               NoteDebitEnteteVentes var6 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var7);
               if (var6.isVar_select_ligne()) {
                  var6.setNdbEtat(5);
                  this.noteDebitEnteteVentesDao.modif(var6);
               }
            }
         } else {
            var10 = true;
         }

         int var11;
         if (var10 && var4 != 0.0F) {
            boolean var8;
            int var9;
            NoteDebitEnteteVentes var12;
            if (this.var_mode_trf.equals("0")) {
               for(var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
                  new NoteDebitEnteteVentes();
                  var12 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getNdbNum().equalsIgnoreCase(((NoteDebitEnteteVentes)var1.get(var9)).getNdbNum())) {
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
                  new NoteDebitEnteteVentes();
                  var12 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var11);
                  if (var12.isVar_select_ligne()) {
                     var8 = false;

                     for(var9 = 0; var9 < var1.size(); ++var9) {
                        if (var12.getTiers().getTieid() == ((NoteDebitEnteteVentes)var1.get(var9)).getTiers().getTieid()) {
                           if (var12.getNdbSerie().equalsIgnoreCase(((NoteDebitEnteteVentes)var1.get(var9)).getNdbSerie())) {
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
                  this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)var1.get(var11);
                  this.lesLignesList.clear();
                  if (this.var_mode_trf.equals("0")) {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((NoteDebitEnteteVentes)var1.get(var11)).getNdbNum().equalsIgnoreCase(((NoteDebitLigneVentes)this.documentDetailTrf.get(var7)).getNoteDebitEnteteVentes().getNdbNum())) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  } else {
                     for(var7 = 0; var7 < this.documentDetailTrf.size(); ++var7) {
                        if (((NoteDebitEnteteVentes)var1.get(var11)).getTiers().getTieid() == ((NoteDebitLigneVentes)this.documentDetailTrf.get(var7)).getNoteDebitEnteteVentes().getTiers().getTieid()) {
                           this.lesLignesList.add(this.documentDetailTrf.get(var7));
                        }
                     }
                  }

                  if (this.lesLignesList.size() != 0) {
                     this.utilParapheur.supprimerParapheur(this.noteDebitEnteteVentes.getNdbId(), this.nature, (Session)null);
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
               this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)this.lesEntetesList.get(var11);
               if (this.noteDebitEnteteVentes.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.noteDebitEnteteVentes);
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
            var3.setAvrSerie(this.noteDebitEnteteVentes.getNdbSerie());
         }

         var3.setUsers(this.usersLog);
         var3.setAvrIdCreateur(this.usersLog.getUsrid());
         var3.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var3.setAvrDate(this.utilDate.dateToSQLLight(this.noteDebitEnteteVentes.getNdbDate()));
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
         int var34;
         if (this.optionMedical.getNbrJrRelanceAVOIR() != null && !this.optionMedical.getNbrJrRelanceAVOIR().isEmpty()) {
            var34 = Integer.parseInt(this.optionMedical.getNbrJrRelanceAVOIR());
         } else {
            var34 = 0;
         }

         boolean var8 = false;
         int var35;
         if (this.optionMedical.getNbrJrValidAVOIR() != null && !this.optionMedical.getNbrJrValidAVOIR().isEmpty()) {
            var35 = Integer.parseInt(this.optionMedical.getNbrJrValidAVOIR());
         } else {
            var35 = 0;
         }

         var3.setAvrDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var3.setAvrDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var35));
         var3.setAvrService(this.noteDebitEnteteVentes.getNdbService());
         if (!var3.getAvrSerie().equalsIgnoreCase("X") && !var3.getAvrSerie().isEmpty()) {
            var3.setAvrNum(this.calculChrono.numCompose(this.noteDebitEnteteVentes.getNdbDate(), this.var_type_trf, var3.getAvrSerie(), var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setAvrNum("" + var9);
         }

         this.verifieExistenceHabilitationAvoir(var3, var1);
         var3.setAvrSource(this.noteDebitEnteteVentes.getNdbSource());
         var3.setAvrNomResponsable(this.noteDebitEnteteVentes.getNdbNomResponsable());
         var3.setAvrIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
         var3.setAvrNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
         var3.setAvrIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
         var3.setAvrNomEquipe(this.noteDebitEnteteVentes.getNdbNomEquipe());
         var3.setAvrIdEquipe(this.noteDebitEnteteVentes.getNdbIdEquipe());
         var3.setAvrNomTiers(this.noteDebitEnteteVentes.getNdbNomTiers());
         var3.setAvrCivilTiers(this.noteDebitEnteteVentes.getNdbCivilTiers());
         var3.setAvrTiersRegroupe(this.noteDebitEnteteVentes.getNdbTiersRegroupe());
         var3.setAvrIdContact(this.noteDebitEnteteVentes.getNdbIdContact());
         var3.setAvrNomContact(this.noteDebitEnteteVentes.getNdbNomContact());
         var3.setAvrCivilContact(this.noteDebitEnteteVentes.getNdbCivilContact());
         var3.setAvrDiversAdresse(this.noteDebitEnteteVentes.getNdbDiversAdresse());
         var3.setAvrDiversMail(this.noteDebitEnteteVentes.getNdbDiversMail());
         var3.setAvrDiversNom(this.noteDebitEnteteVentes.getNdbDiversNom());
         var3.setAvrDiversTel(this.noteDebitEnteteVentes.getNdbDiversTel());
         var3.setAvrDiversTiers(this.noteDebitEnteteVentes.getNdbDiversTiers());
         var3.setAvrDiversVille(this.noteDebitEnteteVentes.getNdbDiversVille());
         var3.setAvrExoTva(this.noteDebitEnteteVentes.getNdbExoTva());
         var3.setAvrExoDouane(this.noteDebitEnteteVentes.getNdbExoDouane());
         var3.setAvrJournalReg(this.noteDebitEnteteVentes.getNdbJournalReg());
         var3.setAvrCat(this.noteDebitEnteteVentes.getNdbCat());
         var3.setAvrDevise(this.noteDebitEnteteVentes.getNdbDevise());
         var3.setAvrObject(this.noteDebitEnteteVentes.getNdbObject());
         var3.setAvrObservation(this.noteDebitEnteteVentes.getNdbObservation());
         var3.setAvrTauxRemise(this.noteDebitEnteteVentes.getNdbTauxRemise());
         var3.setAvrTotHt(0.0D);
         var3.setAvrTotRemise(0.0D);
         var3.setAvrTotRabais(0.0D);
         var3.setAvrTotTva(0.0D);
         var3.setAvrTotTc(0.0D);
         var3.setAvrTotTtc(0.0D);
         var3.setAvrTotReglement(0.0D);
         var3.setAvrSolde(0);
         var3.setAvrBanque(this.noteDebitEnteteVentes.getNdbBanque());
         var3.setAvrTypeReg(this.noteDebitEnteteVentes.getNdbTypeReg());
         var3.setAvrModeReg(this.noteDebitEnteteVentes.getNdbModeReg());
         var3.setAvrNbJourReg(this.noteDebitEnteteVentes.getNdbNbJourReg());
         var3.setAvrArrondiReg(this.noteDebitEnteteVentes.getNdbArrondiReg());
         var3.setAvrConditionReg(this.noteDebitEnteteVentes.getNdbConditionReg());
         var3.setAvrDateEcheReg(this.noteDebitEnteteVentes.getNdbDateEcheReg());
         var3.setAvrContener(this.noteDebitEnteteVentes.getNdbContener());
         var3.setAvrActivite(this.noteDebitEnteteVentes.getNdbActivite());
         var3.setAvrSite(this.noteDebitEnteteVentes.getNdbSite());
         var3.setAvrDepartement(this.noteDebitEnteteVentes.getNdbDepartement());
         var3.setAvrRegion(this.noteDebitEnteteVentes.getNdbRegion());
         var3.setAvrSecteur(this.noteDebitEnteteVentes.getNdbSecteur());
         var3.setAvrPdv(this.noteDebitEnteteVentes.getNdbPdv());
         var3.setAvrAnal2(this.noteDebitEnteteVentes.getNdbAnal2());
         var3.setAvrAnal4(this.noteDebitEnteteVentes.getNdbAnal4());
         var3.setAvrInfo1(this.noteDebitEnteteVentes.getNdbInfo1());
         var3.setAvrInfo2(this.noteDebitEnteteVentes.getNdbInfo2());
         var3.setAvrInfo3(this.noteDebitEnteteVentes.getNdbInfo3());
         var3.setAvrInfo4(this.noteDebitEnteteVentes.getNdbInfo4());
         var3.setAvrInfo5(this.noteDebitEnteteVentes.getNdbInfo5());
         var3.setAvrInfo6(this.noteDebitEnteteVentes.getNdbInfo6());
         var3.setAvrInfo7(this.noteDebitEnteteVentes.getNdbInfo7());
         var3.setAvrInfo8(this.noteDebitEnteteVentes.getNdbInfo8());
         var3.setAvrInfo9(this.noteDebitEnteteVentes.getNdbInfo9());
         var3.setAvrInfo10(this.noteDebitEnteteVentes.getNdbInfo10());
         var3.setAvrFormule1(this.noteDebitEnteteVentes.getNdbFormule1());
         var3.setAvrFormule2(this.noteDebitEnteteVentes.getNdbFormule2());
         var3.setAvrAnnexe1(this.noteDebitEnteteVentes.getNdbAnnexe1());
         var3.setAvrAnnexe2(this.noteDebitEnteteVentes.getNdbAnnexe2());
         var3.setAvrContrat(this.noteDebitEnteteVentes.getNdbContrat());
         var3.setAvrIncoterm(this.noteDebitEnteteVentes.getNdbIncoterm());
         var3.setAvrLieuLivraison(this.noteDebitEnteteVentes.getNdbLieuLivraison());
         var3.setAvrDateLivraison(this.noteDebitEnteteVentes.getNdbDateLivraison());
         var3.setAvrInfoLivraison(this.noteDebitEnteteVentes.getNdbInfoLivraison());
         var3.setAvrDateImp((Date)null);
         var3.setAvrModeleImp(this.var_modele_trf);
         var3.setAvrGarde(this.noteDebitEnteteVentes.getNdbGarde());
         var3.setAvrGele(0);
         var3.setAvrEtat(0);
         var3.setAvrDateTransforme((Date)null);
         var3.setAvrTypeTransforme(0);
         var3.setAvrDateAnnule((Date)null);
         var3.setAvrMotifAnnule("");
         var3.setAvrFactorNom(this.noteDebitEnteteVentes.getNdbFactorNom());
         var3.setAvrFactorId(this.noteDebitEnteteVentes.getNdbFactorId());
         var3.setAvrFactorEtat(this.noteDebitEnteteVentes.getNdbFactorEtat());
         var3.setExerciceventes(this.exercicesVentes);
         var3.setTiers(this.noteDebitEnteteVentes.getTiers());
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var36 = 0.0F;
         float var10 = 0.0F;
         float var11 = 0.0F;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         double var20 = 0.0D;
         double var22 = 0.0D;
         if (this.lesLignesList.size() != 0) {
            int var24 = 0;

            while(true) {
               if (var24 >= this.lesLignesList.size()) {
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
                  break;
               }

               this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.lesLignesList.get(var24);
               if (this.noteDebitLigneVentes.getNdbligLibelle() != null && !this.noteDebitLigneVentes.getNdbligLibelle().isEmpty() && this.noteDebitLigneVentes.getVar_qteReliquat() != 0.0F) {
                  if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.noteDebitLigneVentes.getNdbligCode(), var1);
                     if (this.produits != null && this.noteDebitLigneVentes.getNdbligDepot() != null && !this.noteDebitLigneVentes.getNdbligDepot().isEmpty()) {
                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.noteDebitLigneVentes.getNdbligCode(), this.noteDebitLigneVentes.getNdbligDepot(), var1);
                     }
                  }

                  float var25 = this.noteDebitLigneVentes.getNdbligQte();
                  float var26 = this.noteDebitLigneVentes.getNdbligQteUtil();
                  AvoirLigneVentes var27 = new AvoirLigneVentes();
                  var36 += ((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getNdbligQte();
                  var10 += ((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_qteDejaTrf();
                  if (((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_qteReliquat() != 0.0F) {
                     var27.setAvrligOrdre(this.noteDebitLigneVentes.getNdbligOrdre());
                     var27.setAvrligCode(this.noteDebitLigneVentes.getNdbligCode());
                     var27.setAvrligGroupe(this.noteDebitLigneVentes.getNdbligGroupe());
                     var27.setAvrligModeGroupe(this.noteDebitLigneVentes.getNdbligModeGroupe());
                     var27.setAvrligDevise(this.noteDebitLigneVentes.getNdbligDevise());
                     var27.setAvrligFamille(this.noteDebitLigneVentes.getNdbligFamille());
                     var27.setAvrligIdNdb(this.noteDebitLigneVentes.getNdbligId());
                     var27.setAvrligLibelle(this.noteDebitLigneVentes.getNdbligLibelle());
                     var27.setAvrligComplement(this.noteDebitLigneVentes.getNdbligComplement());
                     if (((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_depotLigne() != null && !((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_depotLigne().isEmpty() && ((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_depotLigne().contains("=")) {
                        String[] var28 = ((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_depotLigne().split("=");
                        var27.setAvrligDepot(var28[0]);
                     } else {
                        var27.setAvrligDepot("");
                     }

                     var27.setAvrligEchelle(this.noteDebitLigneVentes.getNdbligEchelle());
                     var27.setAvrligUnite(this.noteDebitLigneVentes.getNdbligUnite());
                     var27.setAvrligReference(this.noteDebitLigneVentes.getNdbligReference());
                     var27.setAvrligPump(this.noteDebitLigneVentes.getNdbligPump());
                     var27.setAvrligPu(this.noteDebitLigneVentes.getNdbligPu());
                     var27.setAvrligPuTtc(this.noteDebitLigneVentes.getNdbligPuTtc());
                     var27.setAvrligTauxRemise(this.noteDebitLigneVentes.getNdbligTauxRemise());
                     var27.setAvrligPuRem(this.noteDebitLigneVentes.getNdbligPuRem());
                     var27.setAvrligPuRemTtc(this.noteDebitLigneVentes.getNdbligPuRemTtc());
                     this.noteDebitLigneVentes.setNdbligQte(((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_qteReliquat());
                     this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var1);
                     var27.setAvrligQte(((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_qteReliquat());
                     var27.setAvrligQteStock(0.0F);
                     var27.setAvrligRabais(this.noteDebitLigneVentes.getNdbligRabais());
                     var27.setAvrligTauxTaxe(this.noteDebitLigneVentes.getNdbligTauxTaxe());
                     var27.setAvrligTaxe(this.noteDebitLigneVentes.getNdbligTaxe());
                     var27.setAvrligPt(this.noteDebitLigneVentes.getNdbligPt());
                     var27.setAvrligTva(this.noteDebitLigneVentes.getNdbligTva());
                     var27.setAvrligTtc(this.noteDebitLigneVentes.getNdbligTtc());
                     var27.setAvrligTc(this.noteDebitLigneVentes.getNdbligTc());
                     var27.setAvoirEnteteVentes(var3);
                     var11 += ((NoteDebitLigneVentes)this.lesLignesList.get(var24)).getVar_qteReliquat();
                     var6.add(var27);
                     var12 += var27.getAvrligPt();
                     var14 += (var27.getAvrligPu() - var27.getAvrligPuRem()) * (double)var27.getAvrligQte();
                     var16 += var27.getAvrligRabais();
                     var18 += var27.getAvrligTva();
                     var20 += var27.getAvrligTtc();
                     var22 += var27.getAvrligTc();
                     this.noteDebitLigneVentes.setNdbligQte(var25);
                     this.noteDebitLigneVentes.setNdbligQteUtil(var26);
                  }
               }

               ++var24;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationAvoir(var3, var1), var3.getAvrId(), var3.getAvrNum(), var3.getAvrNomTiers(), var3.getAvrDate(), var3.getAvrDevise(), var3.getAvrTotTtc() + var3.getAvrTotTc(), var3.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 26), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFAVR(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceVentes.setDoctraDateCreat(new Date());
         this.documentTraceVentes.setDoctraUserId(this.usersLog.getUsrid());
         this.documentTraceVentes.setDoctraUserNom(this.usersLog.getUsrNom());
         this.documentTraceVentes.setExerciceventes(this.exercicesVentes);
         this.documentTraceVentes.setDoctraOrgType(this.nature);
         this.documentTraceVentes.setDoctraOrgSerie(this.noteDebitEnteteVentes.getNdbSerie());
         this.documentTraceVentes.setDoctraOrgId(this.noteDebitEnteteVentes.getNdbId());
         this.documentTraceVentes.setDoctraOrgNum(this.noteDebitEnteteVentes.getNdbNum());
         this.documentTraceVentes.setDoctraOrgDate(this.noteDebitEnteteVentes.getNdbDate());
         this.documentTraceVentes.setDoctraDstType(this.var_type_trf);
         this.documentTraceVentes.setDoctraDstSerie(var3.getAvrSerie());
         this.documentTraceVentes.setDoctraDstId(var3.getAvrId());
         this.documentTraceVentes.setDoctraDstNum(var3.getAvrNum());
         this.documentTraceVentes.setDoctraDstDate(var3.getAvrDate());
         this.documentTraceVentesDao.insert(this.documentTraceVentes, var1);
         if (var36 <= var10 + var11 && var36 != 0.0F && var10 + var11 != 0.0F) {
            var3.setAvrEtat(5);
         } else {
            var3.setAvrEtat(4);
         }

         var3.setAvrDateTransforme(new Date());
         var3.setAvrTypeTransforme(this.var_type_trf);
         var4.modif(var3, var1);
         var2.commit();
      } catch (HibernateException var32) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var32;
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
      if (this.noteDebitEnteteVentes != null) {
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
         if (this.var_tot_bon_encaissement > this.noteDebitEnteteVentes.getNdbTotTtc()) {
            this.noteDebitEnteteVentes.setNdbTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.noteDebitEnteteVentes.getNdbTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.noteDebitEnteteVentes.getNdbTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.noteDebitEnteteVentes.getNdbEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.noteDebitEnteteVentes.getNdbTotTtc() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.noteDebitEnteteVentes.setNdbTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.noteDebitEnteteVentes.getNdbTotTtc() - this.var_tot_bon_encaissement;
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.noteDebitEnteteVentes.getNdbSerie())) {
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
      if (this.noteDebitEnteteVentes.getNdbTypeReg() != 4 && this.noteDebitEnteteVentes.getNdbTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (this.var_tot_bon_encaissement <= this.noteDebitEnteteVentes.getNdbTotTtc()) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.noteDebitEnteteVentes.getNdbTypeReg() == 5) {
               this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var14 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var12 = var14.existenceHabilitation(29, var1);
               if (var12 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 79, this.noteDebitEnteteVentes.getNdbSerie(), var1);
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
                  this.bonEncaissementVente.setBonActivite(this.noteDebitEnteteVentes.getNdbActivite());
                  this.bonEncaissementVente.setBonSite(this.noteDebitEnteteVentes.getNdbSite());
                  this.bonEncaissementVente.setBonDepartement(this.noteDebitEnteteVentes.getNdbDepartement());
                  this.bonEncaissementVente.setBonService(this.noteDebitEnteteVentes.getNdbService());
                  this.bonEncaissementVente.setBonRegion(this.noteDebitEnteteVentes.getNdbRegion());
                  this.bonEncaissementVente.setBonSecteur(this.noteDebitEnteteVentes.getNdbSecteur());
                  this.bonEncaissementVente.setBonPdv(this.noteDebitEnteteVentes.getNdbPdv());
                  this.bonEncaissementVente.setBonDateEcheReg(this.noteDebitEnteteVentes.getNdbDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.noteDebitEnteteVentes.getNdbNomTiers());
                  this.bonEncaissementVente.setBonIdTiers(this.noteDebitEnteteVentes.getTiers().getTieid());
                  this.bonEncaissementVente.setBonNomContact(this.noteDebitEnteteVentes.getNdbNomContact());
                  this.bonEncaissementVente.setBonIdContact(this.noteDebitEnteteVentes.getNdbIdContact());
                  this.bonEncaissementVente.setBonTypeTiers(0);
                  this.bonEncaissementVente.setBonLibelle("Règlement Note de débit N° " + this.noteDebitEnteteVentes.getNdbNum());
                  this.bonEncaissementVente.setBonRef(this.noteDebitEnteteVentes.getNdbNum());
                  this.bonEncaissementVente.setBonIdRef(this.noteDebitEnteteVentes.getNdbId());
                  this.bonEncaissementVente.setBonObject(this.noteDebitEnteteVentes.getNdbObject());
                  this.bonEncaissementVente.setBonObservation(this.noteDebitEnteteVentes.getNdbObservation());
                  this.bonEncaissementVente.setBonSerie(this.noteDebitEnteteVentes.getNdbSerie());
                  this.bonEncaissementVente.setBonDevise(this.noteDebitEnteteVentes.getNdbDevise());
                  this.bonEncaissementVente.setBonTotTtc(this.noteDebitEnteteVentes.getNdbTotTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.noteDebitEnteteVentes.getNdbNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(this.noteDebitEnteteVentes.getNdbIdEquipe());
                  this.bonEncaissementVente.setBonNomEquipe(this.noteDebitEnteteVentes.getNdbNomEquipe());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)this.lesEntetesList.get(var11);
            if (this.noteDebitEnteteVentes.isVar_select_ligne()) {
               long var13 = this.noteDebitEnteteVentes.getNdbId();
               this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
               this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.pourParapheur(var13, var1);
               if (this.noteDebitEnteteVentes != null) {
                  this.lesEntetesList.remove(var11);
                  this.noteDebitEnteteVentes.setVar_select_ligne(false);
                  this.lesEntetesList.add(var11, this.noteDebitEnteteVentes);
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
            new NoteDebitEnteteVentes();
            NoteDebitEnteteVentes var11 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getNdbNomTiers())) && var11.getNdbSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getNdbNomTiers();
               var1 += var11.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc();
               var3 += var11.getNdbTotReglement();
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
            this.noteDebitEnteteVentes.setNdbTypeReg(0);
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
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.noteDebitEnteteVentes.getNdbSerie())) {
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
         new NoteDebitEnteteVentes();
         NoteDebitEnteteVentes var6 = (NoteDebitEnteteVentes)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getNdbTotTtc();
            var3 += var6.getNdbTotReglement();
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
      if (this.varTypeReg == 0) {
         var1 = this.var_date.getYear() + 1900;
         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, this.montantElmTotBonEnc, var1, this.structureLog.getStrdevise(), this.var_date);
         this.totalPayerTimbre = this.montantElmTotBonEnc + this.val_timbre;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new NoteDebitEnteteVentes();
               NoteDebitEnteteVentes var7 = (NoteDebitEnteteVentes)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getNdbTotTtc() + var7.getNdbTotTc() - var7.getNdbTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getNdbTotTtc() + var7.getNdbTotTc() - var7.getNdbTotReglement(), var1, this.structureLog.getStrdevise(), var7.getNdbDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getNdbTotTtc() + var7.getNdbTotTc() - var7.getNdbTotReglement(), var1, this.structureLog.getStrdevise(), var7.getNdbDate());
                  var4 = var4 - var7.getNdbTotTtc() + var7.getNdbTotTc() - var7.getNdbTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new NoteDebitEnteteVentes();
            NoteDebitEnteteVentes var8 = (NoteDebitEnteteVentes)this.listFactureSelectionne.get(var1);
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
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.noteDebitEnteteVentes.getNdbSerie();
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

               double var34 = this.montantElmTotBonEnc;
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               new NoteDebitEnteteVentes();

               for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                  NoteDebitEnteteVentes var20 = (NoteDebitEnteteVentes)this.listFactureSelectionne.get(var21);
                  var16 = var20.getVar_fac_timbre();
                  var18 = var20.getMontantReglementManuel();
                  var12 = 0.0D;
                  if (var20.isVar_select_ligne()) {
                     long var22 = var20.getNdbId();
                     var20 = this.noteDebitEnteteVentesDao.pourParapheur(var22, var3);
                     if (var20 != null) {
                        if (this.repartitionManuelle) {
                           if (var18 != 0.0D) {
                              this.generationReglement(var8, var18, var16, var20, var5, var3);
                              var34 -= var18;
                              if (var34 < 0.0D) {
                                 var34 = 0.0D;
                                 break;
                              }
                           }
                        } else {
                           var12 = var20.getNdbTotTtc() + var20.getNdbTotTc() + var16 - var20.getNdbTotReglement();
                           if (var34 <= 0.0D) {
                              break;
                           }

                           if (var12 <= var34) {
                              var14 = var12;
                           } else {
                              var14 = var34;
                           }

                           this.generationReglement(var8, var14, var16, var20, var5, var3);
                           var34 -= var14;
                           if (var34 < 0.0D) {
                              var34 = 0.0D;
                              break;
                           }
                        }
                     }
                  }
               }

               boolean var35 = false;
               if (var34 > 0.0D) {
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
         Session var31 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");

         for(int var32 = 0; var32 < this.lesEntetesList.size(); ++var32) {
            this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)this.lesEntetesList.get(var32);
            if (this.noteDebitEnteteVentes.isVar_select_ligne()) {
               long var33 = this.noteDebitEnteteVentes.getNdbId();
               this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
               this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.pourParapheur(var33, var31);
               if (this.noteDebitEnteteVentes != null) {
                  if (this.noteDebitEnteteVentes.getNdbSolde() == 1 && this.inpEtat == 13) {
                     this.lesEntetesList.remove(var32);
                  } else {
                     this.lesEntetesList.remove(var32);
                     this.noteDebitEnteteVentes.setVar_select_ligne(false);
                     this.lesEntetesList.add(var32, this.noteDebitEnteteVentes);
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
               this.totManuel += ((NoteDebitEnteteVentes)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
            }

            this.ecartManuel = this.montantElmTotBonEnc - this.totManuel;
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

   public void generationReglement(String var1, double var2, double var4, NoteDebitEnteteVentes var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= var6.getNdbTotTtc() + var6.getNdbTotTc() + var4) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite(var6.getNdbActivite());
      this.reglements.setRglBudget(var6.getNdbBudget());
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
      this.reglements.setRglDepartement(var6.getNdbDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getNdbDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getNdbNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getNdbId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle(var6.getNdbObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(27);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      this.reglements.setRglIdContact(var6.getNdbIdContact());
      this.reglements.setRglNomContact(var6.getVar_nomContact());
      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getNdbPdv());
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getNdbDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getNdbRegion());
      this.reglements.setRglSecteur(var6.getNdbSecteur());
      this.reglements.setRglSerie(var6.getNdbSerie());
      this.reglements.setRglService(var6.getNdbService());
      this.reglements.setRglSite(var6.getNdbSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getNdbIdResponsable());
      this.reglements.setRglNomResponsable(var6.getNdbNomResponsable());
      this.reglements.setRglIdCommercial(var6.getNdbIdCommercial());
      this.reglements.setRglNomCommercial(var6.getNdbNomCommercial());
      this.reglements.setRglIdEquipe(var6.getNdbIdEquipe());
      this.reglements.setRglNomEquipe(var6.getNdbNomEquipe());
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
         var6.setNdbTotReglement(var6.getNdbTotReglement() + var2);
         var6.setNdbTotTimbre(var6.getNdbTotTimbre() + var14);
         if (var6.getNdbTotReglement() >= var6.getNdbTotTtc() + var6.getNdbTotTc()) {
            var6.setNdbSolde(1);
         } else {
            var6.setNdbSolde(0);
         }

         var6.setNdbDateLastReg(this.reglements.getRglDateReg());
         this.noteDebitEnteteVentesDao.modif(var6, var8);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.noteDebitEnteteVentes.getNdbId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.noteDebitEnteteVentes.setNdbTotReglement(var4);
            if (this.noteDebitEnteteVentes.getNdbTotReglement() >= this.noteDebitEnteteVentes.getNdbTotTtc()) {
               this.noteDebitEnteteVentes.setNdbSolde(1);
            } else {
               this.noteDebitEnteteVentes.setNdbSolde(0);
            }

            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
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
      if (this.noteDebitEnteteVentes != null) {
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

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 181) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "note_debit" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator;
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
            this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.lesLignesList.get(var10);
            if (this.noteDebitLigneVentes.getNdbligModeGroupe() != 2 || this.noteDebitLigneVentes.getNdbligGroupe() == null || this.noteDebitLigneVentes.getNdbligGroupe().isEmpty()) {
               this.noteDebitLigneVentes.setVar_lib_des_condit("");
               if (this.noteDebitLigneVentes.getNdbligCondition() != null && !this.noteDebitLigneVentes.getNdbligCondition().isEmpty() && this.noteDebitLigneVentes.getNdbligCondition().contains(":")) {
                  String[] var11 = this.noteDebitLigneVentes.getNdbligCondition().split(":");
                  Conditionnement var9 = var8.rechercheConditionnement(var11[0], (Session)null);
                  if (var9 != null) {
                     this.noteDebitLigneVentes.setVar_lib_des_condit(var9.getCdtDescription());
                  }
               }

               if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.noteDebitLigneVentes.getNdbligCode().equals("-")) {
                  var2 = true;
                  var3 = this.noteDebitLigneVentes.getNdbligLibelle();
                  if (var3.startsWith("Suivant ")) {
                     this.infoOrigineDoc = var3;
                  }
               }

               if (var2) {
                  var4 += this.noteDebitLigneVentes.getNdbligPt();
                  var6 = this.noteDebitLigneVentes.getNdbligTtc();
               }

               if (this.noteDebitLigneVentes.getNdbligCode() != null && !this.noteDebitLigneVentes.getNdbligCode().isEmpty() && this.noteDebitLigneVentes.getNdbligCode().equals("=") && var2) {
                  this.noteDebitLigneVentes = new NoteDebitLigneVentes();
                  this.noteDebitLigneVentes.setNoteDebitEnteteVentes(this.noteDebitEnteteVentes);
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
      }

      this.montant_lettre = this.utilNombre.begin(this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc(), this.noteDebitEnteteVentes.getNdbDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var1);
      return var12;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.noteDebitEnteteVentes.getNdbAnal2() != null && !this.noteDebitEnteteVentes.getNdbAnal2().isEmpty()) {
         String var4 = "";
         if (this.noteDebitEnteteVentes.getNdbAnal2().contains(":")) {
            String[] var5 = this.noteDebitEnteteVentes.getNdbAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.noteDebitEnteteVentes.getNdbAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.noteDebitEnteteVentes.getNdbDateImp() != null && this.noteDebitEnteteVentes.getNdbEtat() != 0) {
            var2 = true;
         }

         this.noteDebitEnteteVentes.setNdbDateImp(new Date());
         if (this.noteDebitEnteteVentes.getNdbEtat() == 0 && this.noteDebitEnteteVentes.getNdbEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.noteDebitEnteteVentes.setNdbEtat(1);
            if (this.tiers.getTieDteDocument6() == null || this.noteDebitEnteteVentes.getNdbDate().after(this.tiers.getTieDteDocument6())) {
               this.tiers.setTieDteDocument6(this.noteDebitEnteteVentes.getNdbDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.noteDebitEnteteVentes.setNdbModeleImp(var1);
         this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var3);
         this.contacts = new Contacts();
         if (this.noteDebitEnteteVentes.getNdbIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.noteDebitEnteteVentes.getNdbIdContact(), var3);
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

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression facture externe");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.noteDebitEnteteVentes.getNdbEtat()));
            var1.setDuplicata("" + var11);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionMedical.getNbDecQte());
            var1.setNbDecPu(this.optionMedical.getNbDecPu());
            this.noteDebitEnteteVentes.setNdbDevise(this.devisePrint);
            if (!this.noteDebitEnteteVentes.getNdbDevise().equals("XOF") && !this.noteDebitEnteteVentes.getNdbDevise().equals("XAF")) {
               if (this.noteDebitEnteteVentes.getNdbDevise().equals("EUR")) {
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
               double var12 = this.utilNombre.myRound((this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc()) / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var12, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
            var1.setIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
            var1.setTiersSelectionne(this.noteDebitEnteteVentes.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.noteDebitEnteteVentes.getNdbNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.noteDebitEnteteVentes.getNdbId());
            if (this.noteDebitEnteteVentes.getNdbAnal2() != null && !this.noteDebitEnteteVentes.getNdbAnal2().isEmpty()) {
               String var16 = "";
               if (this.noteDebitEnteteVentes.getNdbAnal2().contains(":")) {
                  String[] var13 = this.noteDebitEnteteVentes.getNdbAnal2().split(":");
                  var16 = var13[0];
               } else {
                  var16 = this.noteDebitEnteteVentes.getNdbAnal2();
               }

               new Parc();
               ParcDao var14 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var17 = var14.rechercheParc(var16, (Session)null);
               if (var17 != null) {
                  var1.setParc(var17);
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
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des factures externes");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "note_debit" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNumDoc((String)null);
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
            this.nbDecGraph = Integer.parseInt(this.optionMedical.getNbDecQte());
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

         new NoteDebitEnteteVentes();
         new NoteDebitLigneVentes();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitLigne");
         String var6 = "";

         NoteDebitEnteteVentes var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getNdbNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getNdbNum() + "'";
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

                  var14 = (NoteDebitEnteteVentes)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getNdbDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getNdbNomResponsable() != null && !var14.getNdbNomResponsable().isEmpty()) {
                        var17 = var14.getNdbNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var14.getNdbNomCommercial() != null && !var14.getNdbNomCommercial().isEmpty()) {
                        var17 = var14.getNdbNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getNdbNomEquipe() != null && !var14.getNdbNomEquipe().isEmpty()) {
                        var17 = var14.getNdbNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getNdbNomTiers() != null && !var14.getNdbNomTiers().isEmpty()) {
                        var17 = var14.getNdbNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var14.getNdbSource() != null && !var14.getNdbSource().isEmpty()) {
                        var17 = var14.getNdbSource();
                     } else {
                        var17 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getNdbAnal4() != null && !var14.getNdbAnal4().isEmpty()) {
                        var17 = var14.getNdbAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var14.getNdbRegion() != null && !var14.getNdbRegion().isEmpty()) {
                        var17 = var14.getNdbRegion();
                     } else {
                        var17 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var14.getNdbSecteur() != null && !var14.getNdbSecteur().isEmpty()) {
                        var17 = var14.getNdbSecteur();
                     } else {
                        var17 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var14.getNdbPdv() != null && !var14.getNdbPdv().isEmpty()) {
                        var17 = var14.getNdbPdv();
                     } else {
                        var17 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var14.getNdbSite() != null && !var14.getNdbSite().isEmpty()) {
                        var17 = var14.getNdbSite();
                     } else {
                        var17 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var14.getNdbDepartement() != null && !var14.getNdbDepartement().isEmpty()) {
                        var17 = var14.getNdbDepartement();
                     } else {
                        var17 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var14.getNdbService() != null && !var14.getNdbService().isEmpty()) {
                        var17 = var14.getNdbService();
                     } else {
                        var17 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var14.getNdbSerie() != null && !var14.getNdbSerie().isEmpty()) {
                        var17 = var14.getNdbSerie();
                     } else {
                        var17 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getNdbTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getNdbDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getNdbDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getNdbDate().getMonth() + 1 >= 1 && var14.getNdbDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getNdbDate().getMonth() + 1 >= 4 && var14.getNdbDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getNdbDate().getMonth() + 1 >= 7 && var14.getNdbDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getNdbDate().getMonth() + 1 >= 10 && var14.getNdbDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getNdbDate().getMonth() + 1 >= 1 && var14.getNdbDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getNdbDate().getMonth() + 1 >= 7 && var14.getNdbDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getNdbDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.noteDebitLigneVentesDao.chargerLesLignesNoteDebits(var6, var5);
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

                  NoteDebitLigneVentes var15 = (NoteDebitLigneVentes)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getNoteDebitEnteteVentes().getNdbDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getNoteDebitEnteteVentes().getNdbNomResponsable() != null && !var15.getNoteDebitEnteteVentes().getNdbNomResponsable().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getNoteDebitEnteteVentes().getNdbNomCommercial() != null && !var15.getNoteDebitEnteteVentes().getNdbNomCommercial().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getNoteDebitEnteteVentes().getNdbNomEquipe() != null && !var15.getNoteDebitEnteteVentes().getNdbNomEquipe().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getNoteDebitEnteteVentes().getNdbNomTiers() != null && !var15.getNoteDebitEnteteVentes().getNdbNomTiers().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getNdbligFamille() != null && !var15.getNdbligFamille().isEmpty()) {
                        var8 = var15.getNdbligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getNdbligLibelle() != null && !var15.getNdbligLibelle().isEmpty()) {
                        var8 = var15.getNdbligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  } else if (this.modeGraph == 7) {
                     if (var15.getNoteDebitEnteteVentes().getNdbSource() != null && !var15.getNoteDebitEnteteVentes().getNdbSource().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbSource();
                     } else {
                        var8 = "Sans Source";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var15.getNoteDebitEnteteVentes().getNdbAnal4() != null && !var15.getNoteDebitEnteteVentes().getNdbAnal4().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbAnal4();
                     } else {
                        var8 = "Sans Affaire";
                     }
                  } else if (this.modeGraph == 9) {
                     if (var15.getNoteDebitEnteteVentes().getNdbRegion() != null && !var15.getNoteDebitEnteteVentes().getNdbRegion().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbRegion();
                     } else {
                        var8 = "Sans Region";
                     }
                  } else if (this.modeGraph == 10) {
                     if (var15.getNoteDebitEnteteVentes().getNdbSecteur() != null && !var15.getNoteDebitEnteteVentes().getNdbSecteur().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbSecteur();
                     } else {
                        var8 = "Sans Secteur";
                     }
                  } else if (this.modeGraph == 11) {
                     if (var15.getNoteDebitEnteteVentes().getNdbPdv() != null && !var15.getNoteDebitEnteteVentes().getNdbPdv().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbPdv();
                     } else {
                        var8 = "Sans Point de vente";
                     }
                  } else if (this.modeGraph == 12) {
                     if (var15.getNoteDebitEnteteVentes().getNdbSite() != null && !var15.getNoteDebitEnteteVentes().getNdbSite().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbSite();
                     } else {
                        var8 = "Sans Site";
                     }
                  } else if (this.modeGraph == 13) {
                     if (var15.getNoteDebitEnteteVentes().getNdbDepartement() != null && !var15.getNoteDebitEnteteVentes().getNdbDepartement().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbDepartement();
                     } else {
                        var8 = "Sans Departement";
                     }
                  } else if (this.modeGraph == 14) {
                     if (var15.getNoteDebitEnteteVentes().getNdbService() != null && !var15.getNoteDebitEnteteVentes().getNdbService().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbService();
                     } else {
                        var8 = "Sans Service";
                     }
                  } else if (this.modeGraph == 15) {
                     if (var15.getNoteDebitEnteteVentes().getNdbSerie() != null && !var15.getNoteDebitEnteteVentes().getNdbSerie().isEmpty()) {
                        var8 = var15.getNoteDebitEnteteVentes().getNdbSerie();
                     } else {
                        var8 = "Sans Serie";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getNdbligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getNdbligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getNoteDebitEnteteVentes().getNdbDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 >= 1 && var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 >= 4 && var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 >= 7 && var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 >= 10 && var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 >= 1 && var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 >= 7 && var15.getNoteDebitEnteteVentes().getNdbDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getNoteDebitEnteteVentes().getNdbDate().getHours();
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
         if (var1 != 21 && var1 != 22 && var1 != 23 && var1 != 24 && var1 != 25 && var1 != 26 && var1 == 27) {
            FormNoteDebitMedical var7 = new FormNoteDebitMedical();
            var7.setBaseLog(this.baseLog);
            var7.setStructureLog(this.structureLog);
            var7.setUsersLog(this.usersLog);
            var7.setutilInitHibernate(this.utilInitHibernate);
            var7.InstancesDaoUtilses();
            var7.rechercheDOCUMENT(var2);
            if (var7.getNoteDebitEnteteVentes() != null) {
               var7.setExercicesVentes(var7.getNoteDebitEnteteVentes().getExerciceventes());
               String var8 = var7.getNoteDebitEnteteVentes().getNdbModeleImp();
               var7.setOptionMedical(this.optionMedical);
               var7.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var7.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
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

   public void recalculTva(NoteDebitEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      if (var1 != null) {
         this.noteDebitEnteteVentes = var1;
         this.lesLignesList = this.noteDebitLigneVentesDao.chargerLesLignes(this.noteDebitEnteteVentes, var2);
         if (this.lesLignesList.size() != 0) {
            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.noteDebitLigneVentes = (NoteDebitLigneVentes)this.lesLignesList.get(var3);
               this.calculPrix(this.noteDebitLigneVentes.getNdbligTaxe(), this.noteDebitLigneVentes.getNdbligTauxTaxe(), var2);
               this.noteDebitLigneVentes = this.noteDebitLigneVentesDao.modifLigne(this.noteDebitLigneVentes, var2);
            }

            this.cumulPrix();
            this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var2);
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

   public NoteDebitEnteteVentes getNoteDebitEnteteVentes() {
      return this.noteDebitEnteteVentes;
   }

   public void setNoteDebitEnteteVentes(NoteDebitEnteteVentes var1) {
      this.noteDebitEnteteVentes = var1;
   }

   public NoteDebitLigneVentes getNoteDebitLigneVentes() {
      return this.noteDebitLigneVentes;
   }

   public void setNoteDebitLigneVentes(NoteDebitLigneVentes var1) {
      this.noteDebitLigneVentes = var1;
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

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public String getInpContener() {
      return this.inpContener;
   }

   public void setInpContener(String var1) {
      this.inpContener = var1;
   }

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
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

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
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

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
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

   public boolean isPlafondAutorise() {
      return this.plafondAutorise;
   }

   public void setPlafondAutorise(boolean var1) {
      this.plafondAutorise = var1;
   }
}
