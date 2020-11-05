package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CcamMedical;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CimMedical;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationInfirmerie;
import com.epegase.systeme.classe.ConsultationLabo;
import com.epegase.systeme.classe.ConsultationOrdo;
import com.epegase.systeme.classe.ConsultationReglement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.classe.MotifEntreeMedical;
import com.epegase.systeme.classe.NgapMedical;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDci;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsMedicamment;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.ProtocoleMedical;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.SpecialitesMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CcamMedicalDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CimMedicalDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationInfirmerieDao;
import com.epegase.systeme.dao.ConsultationLaboDao;
import com.epegase.systeme.dao.ConsultationOrdoDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.MotifEntreeMedicalDao;
import com.epegase.systeme.dao.NgapMedicalDao;
import com.epegase.systeme.dao.PatientAntDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientProtDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsMedicammentDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ProtocoleMedicalDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SpecialitesMedicalDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureDent;
import com.epegase.systeme.xml.LectureInfirmerieAudiometrie;
import com.epegase.systeme.xml.LectureInfirmerieTuberTest;
import com.epegase.systeme.xml.LectureInfirmerieVaccin;
import com.epegase.systeme.xml.LectureInfirmerieVma;
import com.epegase.systeme.xml.LectureInfirmerieVme;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionMedical;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormConsultationGene implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private FormPatients formPatients;
   private int var_action = 0;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionMedical optionMedical;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoMedical;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_nb_max = 100;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private Date memoDateRdv;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private Patients patients;
   private String nomPatient;
   private List lesTypeReglementsItems;
   private List mesCategoriesItems = new ArrayList();
   private List lesCategoriesList = new ArrayList();
   private List mesComplementaireItems = new ArrayList();
   private List lesComplementairesList = new ArrayList();
   private ConventionMedical conventionMedical = new ConventionMedical();
   private LettreMedical lettreMedical = new LettreMedical();
   private PatientPec patientPec = new PatientPec();
   private PatientPec patientPecComplementaire = new PatientPec();
   private float tauxCasSocial;
   private UserDao usersDao;
   private long var_nom_medecin;
   private List lesMedecins = new ArrayList();
   private List mesMedecinsItem = new ArrayList();
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private int medecinSpecialite;
   private Habilitation habilitation;
   private int var_modestock;
   private boolean verrouRemRab;
   private boolean verrouPrvente;
   private boolean verrouPrventeAssurance;
   private boolean verrouPrventeCnamgs;
   private boolean accesProduits;
   private String verrouDepotUser;
   private boolean visibiliteBton;
   private boolean var_verrou_comm;
   private boolean var_consultation_directe = false;
   private boolean var_affiche_protocole;
   private boolean var_affiche_service;
   private boolean var_affiche_pathologie;
   private boolean var_affiche_prescipteur;
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpFam = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpNomPatient = "";
   private String inpPrenomPatient = "";
   private String inpDossier = "";
   private String inpSociete = "";
   private String inpAssurance = "";
   private String inpComplementaire = "";
   private String inpContrat = "";
   private String inpTel = "";
   private String inpCi = "";
   private String inpMedecin = "";
   private String inpProtocole = "";
   private String inpSite = "";
   private String inpActivite = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private List mesdevisesItems;
   private int formatdevise;
   private String montant_lettre;
   private UtilNombre chiffreEnLettre;
   private ServiceDao serviceDao;
   private List mesBudgetsItems;
   private List mesTaxesMedicalItems;
   private boolean tBudget = false;
   private boolean tActivite = false;
   private boolean tParc = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private boolean showModalPanelImput = false;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private transient DataModel datamodelDocument = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesConsultationEntete = new ArrayList();
   private ConsultationEnteteGene consultationEnteteGene;
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private long nomFamille;
   private long nomComplementaire;
   private double totalPatient;
   private double totalTiers;
   private double regPatient;
   private double regTiers;
   private double soldePatient;
   private double soldeTiers;
   private int var_nb_ligne;
   private int var_num_ligne;
   private boolean visibilitenbrjr;
   private boolean visibiliteterme;
   private boolean visibiliteencaissemt;
   private boolean var_aff_action;
   private List mesProtocoleItems = new ArrayList();
   private List lesMotifEntree;
   private boolean var_acc_descriptif;
   private boolean var_acc_antecedent;
   private boolean var_acc_anamese;
   private boolean var_acc_examClinique;
   private boolean var_acc_acte;
   private boolean var_acc_medicament;
   private boolean var_acc_examComplementaire;
   private boolean var_acc_historique;
   private boolean var_acc_facture;
   private boolean var_acc_reglement;
   private boolean var_acc_etat;
   private boolean var_ajt;
   private boolean var_mod;
   private boolean var_sup;
   private boolean var_imp;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private double var_tot_tiers;
   private double var_solde;
   private double var_tot_reg;
   private Produits produits;
   private boolean valideConsultation;
   private boolean showModalpanelPec = false;
   private double totalDocFacture;
   private double totalDocPatient;
   private double totalDocTiers;
   private double totalDocReglement;
   private boolean showModalPanelAntecedent = false;
   private transient DataModel dataModelAntecedent = new ListDataModel();
   private List lesPatientAntecedent = new ArrayList();
   private boolean afficheButtAntecedent = false;
   private PatientAnt patientAnt;
   private PatientAntDao patientAntDao;
   private int var_actionAntecedent;
   private String var_antecedent;
   private boolean showModalPaneldiagnostic = false;
   private transient DataModel dataModelDiagnostic = new ListDataModel();
   private List lesDiagnostic = new ArrayList();
   private CimMedical cimMedical;
   private String recherche_diag;
   private String recherche_cmd;
   private int diagSelect;
   private String var_lib_poids;
   private CimMedicalDao cimMedicalDao;
   private transient DataModel dataModelActe = new ListDataModel();
   private List lesActe = new ArrayList();
   private ConsultationActes consultationActes;
   private ConsultationActesDao consultationActesDao;
   private boolean griserchamps = false;
   private List mesLettresItems;
   private String var_lettre;
   private float var_pecCnamgs;
   private boolean var_pecAssurance;
   private boolean afficheButtActes;
   private boolean showModalPanelListeActes = false;
   private List lesActesCCAM = new ArrayList();
   private List lesActesNGAP = new ArrayList();
   private NgapMedical ngapMedical;
   private NgapMedicalDao ngapMedicalDao;
   private CcamMedical ccamMedical;
   private CcamMedicalDao ccamMedicalDao;
   private boolean showModalPanelCreationActe = false;
   private String lettreActe;
   private List lesTarifs = new ArrayList();
   private String inpCodeFamille;
   private PatientPecDao patientPecDao;
   private TaxesVentesDao taxesMedicalDao;
   private ProduitsTarifDao produitsTarifDao;
   private ConventionMedicalDao conventionMedicalDao;
   private LettreMedicalDao lettreMedicalDao;
   private int typeActe;
   private boolean afficheActeCCAM = false;
   private boolean afficheActeNGAP = false;
   private boolean afficheActeCP = false;
   private transient DataModel dataModelOrdonnance = new ListDataModel();
   private List lesOrdonnance = new ArrayList();
   private ConsultationOrdo consultationOrdo;
   private ConsultationOrdoDao consultationOrdoDao;
   private boolean var_aff_detail_ordo = false;
   private boolean afficheButtOrdo;
   private ProduitsMedicamment produitsMedicamment;
   private ProduitsMedicammentDao produitsMedicammentDao;
   private List lesMedicamments = new ArrayList();
   private boolean showModalPanelMedicamment = false;
   private ProduitsDci produitsDci = new ProduitsDci();
   private boolean showModalPanelMedicammentDci = false;
   private transient DataModel dataModelPharmacie = new ListDataModel();
   private List lesPharmacie = new ArrayList();
   private PharmacieLigne pharmacieLigne;
   private PharmacieLigneDao pharmacieLigneDao;
   private boolean var_aff_detail_pharmacie = false;
   private boolean afficheButtPharmacie;
   private List mesConditionnementsProduits;
   private List mesConditionnementsItems;
   private List mesProduitsDepotsItems;
   private ProduitsDepot produitsDepot;
   private String var_depotProd;
   private int var_code_unite;
   private int validationLigne;
   private String messageStockNegatif;
   private CalculStock calculStock;
   private ProduitsDepotDao produitsDepotDao;
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private List mesUnitesProduits;
   private Unite unite;
   private UniteDao uniteDao;
   private transient DataModel dataModelLaboratoire = new ListDataModel();
   private List lesLaboratoire = new ArrayList();
   private ConsultationLabo consultationLabo;
   private ConsultationLaboDao consultationLaboDao;
   private boolean var_aff_detail_labo = false;
   private boolean afficheButtLabo;
   private boolean showModalPanelProduits = false;
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduits = new ListDataModel();
   private UIDataTable extDTableProduits = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionProduits = new SimpleSelection();
   private transient DataModel datamodelProduitsCCAM = new ListDataModel();
   private UIDataTable extDTableCCAM = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionCCAM = new SimpleSelection();
   private transient DataModel datamodelProduitsNGAP = new ListDataModel();
   private UIDataTable extDTableNGAP = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionNGAP = new SimpleSelection();
   private Service service;
   private ProduitsVtesDao produitsMedicDao;
   private ProduitsMclesDao produitsMclesDao;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsServices produitsServices;
   private int choixPanenProd;
   private TaxesVentes taxesMedical = new TaxesVentes();
   private ProduitsTarif produitsTarif = new ProduitsTarif();
   private List mesDentsItems = new ArrayList();
   private boolean infirmerie;
   private ConsultationInfirmerie consultationInfirmerie;
   private ConsultationInfirmerieDao consultationInfirmerieDao;
   private MotifEntreeMedical motifEntreeMedical;
   private MotifEntreeMedicalDao motifEntreeMedicalDao;
   private int var_heures;
   private int var_minutes;
   private Date var_date_accident;
   private transient DataModel dataModelElements = new ListDataModel();
   private List lesElements = new ArrayList();
   private boolean var_affiche_at = false;
   private boolean var_affiche_vaccin = false;
   private boolean var_affiche_audio = false;
   private boolean var_affiche_vme = false;
   private boolean var_affiche_vma = false;
   private boolean var_affiche_tubertest = false;
   private boolean var_affiche_maladie = false;
   private boolean var_affiche_certificat = false;
   private ObjetCompte objetCompte;
   private List mesFournisseursItem;
   private long var_nom_fournisseurPha;
   private long var_nom_fournisseurLab;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
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
   private String var_modele_trf;
   private Date var_date_trf = null;
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
   private boolean showModalPanelPrintRecu = false;
   private boolean showModalPanelHistoReglement = false;
   private String numLettreGarantie;
   private double montantElmTotReliquat;
   private boolean var_affiche_lettre = false;
   private List mesLettresGarantiesItems = new ArrayList();
   private double reliquatPatient;
   private boolean showModalPanelAnnuler = false;
   private boolean ajouterSurAvoir = false;
   private UtilDownload utilDownload;
   private String fileName;
   private String urlphotoAgent;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private UploadedFile uploadedPDFFile;
   private String pdfFileName;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private transient DataModel dataModelDocumnts = new ListDataModel();
   private List lesDocuments = new ArrayList();
   private String nomRepertoire;
   private boolean showModalPanelPj = false;
   private boolean showModalPanelAjoutFile = false;
   private String nomDocument;
   private Date dateRefacturation;
   private String numRefacturation;
   private String etatRefacuration;
   private boolean autoriseRefacturation;
   private boolean showModalPanelChangerService = false;
   private String nouveauService;
   private String nouveauMotif;
   private long nouveauMedecin;
   private String ancienMedecin;

   public void instanceDaoUtilises() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      this.consultationOrdoDao = new ConsultationOrdoDao(this.baseLog, this.utilInitHibernate);
      this.consultationLaboDao = new ConsultationLaboDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicammentDao = new ProduitsMedicammentDao(this.baseLog, this.utilInitHibernate);
      this.cimMedicalDao = new CimMedicalDao(this.baseLog, this.utilInitHibernate);
      this.ccamMedicalDao = new CcamMedicalDao(this.baseLog, this.utilInitHibernate);
      this.ngapMedicalDao = new NgapMedicalDao(this.baseLog, this.utilInitHibernate);
      this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      this.taxesMedicalDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.conventionMedicalDao = new ConventionMedicalDao(this.baseLog, this.utilInitHibernate);
      this.lettreMedicalDao = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
   }

   public void configMedical() {
      this.periode = this.getOptionMedical().getAffichInGlobViewCC();
      if (this.structureLog.getStrtypeentreprise() == null || !this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
         this.var_modestock = 0;
      } else {
         this.var_sansstock = false;
         this.var_modestock = 0;
      }

      if (this.optionMedical.getNbLigneMax() != null && !this.optionMedical.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionMedical.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.infirmerie = this.rechercheModule(81500);
      if (this.infirmerie) {
         this.mesConditionnementsProduits = new ArrayList();
         this.mesConditionnementsItems = new ArrayList();
         this.mesProduitsDepotsItems = new ArrayList();
         this.mesUnitesProduits = new ArrayList();
         this.calculStock = new CalculStock();
         this.unite = new Unite();
         this.consultationInfirmerie = new ConsultationInfirmerie();
         this.motifEntreeMedical = new MotifEntreeMedical();
         this.utilDownload = new UtilDownload();
         this.objetCompte = new ObjetCompte();
         this.mesFournisseursItem = new ArrayList();
         this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
         this.consultationInfirmerieDao = new ConsultationInfirmerieDao(this.baseLog, this.utilInitHibernate);
         this.motifEntreeMedicalDao = new MotifEntreeMedicalDao(this.baseLog, this.utilInitHibernate);
      }

      if (this.infirmerie) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "infirmerie" + File.separator;
      } else {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "consultation" + File.separator;
      }

      File var1 = new File(this.nomRepertoire);
      if (!var1.exists()) {
         var1.mkdir();
      }

      if (this.infirmerie) {
         if (this.usersLog.getUsrSite() != null && !this.usersLog.getUsrSite().isEmpty()) {
            this.inpSite = this.usersLog.getUsrSite();
         } else {
            this.inpSite = "";
         }
      }

   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemRab = false;
      } else {
         this.verrouRemRab = true;
      }

      if (this.usersLog.getUsrVerPv() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAffPvMarche() == 0) {
         this.verrouPrventeAssurance = false;
      } else {
         this.verrouPrventeAssurance = true;
      }

      if (this.usersLog.getUsrAffPlancher() == 0) {
         this.verrouPrventeCnamgs = false;
      } else {
         this.verrouPrventeCnamgs = true;
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
      this.var_acc_descriptif = false;
      this.var_acc_antecedent = false;
      this.var_acc_anamese = false;
      this.var_acc_examClinique = false;
      this.var_acc_acte = false;
      this.var_acc_medicament = false;
      this.var_acc_examComplementaire = false;
      this.var_acc_historique = false;
      this.var_acc_facture = false;
      this.var_acc_reglement = false;
      this.var_acc_etat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("21")) {
               this.var_acc_descriptif = true;
            } else if (var1.getCode().equals("22")) {
               this.var_acc_antecedent = true;
            } else if (var1.getCode().equals("23")) {
               this.var_acc_anamese = true;
            } else if (var1.getCode().equals("24")) {
               this.var_acc_examClinique = true;
            } else if (var1.getCode().equals("25")) {
               this.var_acc_acte = true;
            } else if (var1.getCode().equals("26")) {
               this.var_acc_medicament = true;
            } else if (var1.getCode().equals("27")) {
               this.var_acc_examComplementaire = true;
            } else if (var1.getCode().equals("28")) {
               this.var_acc_historique = true;
            } else if (var1.getCode().equals("29")) {
               this.var_acc_facture = true;
            } else if (var1.getCode().equals("30")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("31")) {
               this.var_acc_etat = true;
            }
         }
      }

   }

   public void autorisationDescription() {
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
            }
         }
      }

   }

   public void autorisationAntecedent() {
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
            }
         }
      }

   }

   public void autorisationAnamese() {
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
            }
         }
      }

   }

   public void autorisationExamClinique() {
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
            }
         }
      }

   }

   public void autorisationActes() {
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
            }
         }
      }

      this.ajouterActes();
   }

   public void autorisationMedicament() {
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
            }
         }
      }

      this.ajouterMedicamment();
   }

   public void autorisationExamComplementaire() {
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
            }
         }
      }

      this.ajouterLaboratoire();
   }

   public void autorisationHistorique() {
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
            }
         }
      }

   }

   public void autorisationFacture() {
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
            if (var1.getCode().equals("30")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
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
            if (var1.getCode().equals("31")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void calculMedecinActe() throws HibernateException, NamingException {
      this.calculMedecinActe((Session)null);
   }

   public void calculMedecinActe(Session var1) throws HibernateException, NamingException {
      this.lesMedecins.clear();
      if (this.infirmerie) {
         this.lesMedecins = this.usersDao.chargerLesUsersByServices("", var1);
      } else {
         if (!this.var_affiche_service) {
            this.consultationEnteteGene.setCsgService("");
         }

         this.lesMedecins = this.usersDao.chargerLesUsersByServices(this.consultationEnteteGene.getCsgService(), var1);
      }

      this.mesMedecinsItem.clear();

      for(int var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
         Users var3 = (Users)this.lesMedecins.get(var2);
         if ((var3.getUsrFonction() != null && !var3.getUsrFonction().isEmpty() && var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
            this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
         }
      }

      this.verifValideConsultation(var1);
   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.mesMedecinsItem.clear();
      String var1 = "";
      if (this.nouveauService != null && !this.nouveauService.isEmpty()) {
         var1 = this.nouveauService;
      } else if (this.consultationEnteteGene.getCsgService() != null && !this.consultationEnteteGene.getCsgService().isEmpty()) {
         var1 = this.consultationEnteteGene.getCsgService();
      }

      new ArrayList();
      List var2 = this.usersDao.chargerLesUsersByServices(var1, (Session)null);
      this.mesMedecinsItem.clear();

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         Users var4 = (Users)var2.get(var3);
         if ((var4.getUsrFonction() != null && !var4.getUsrFonction().isEmpty() && var4.getUsrFonction().contains("Professeur") || var4.getUsrFonction().contains("Médecin")) && var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
            this.mesMedecinsItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme() + ":" + var4.getUsrMetier()));
         }
      }

   }

   public void recherchePatients() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formPatients.setSite(this.inpSite);
      this.formPatients.moduleRecherchePatients(this.nature, this.optionMedical);
   }

   public void validerTiers() throws HibernateException, NamingException {
      this.patients = this.formPatients.moduleCalculePatients();
      this.calculePatient();
      if (this.usersLog.getUsrVendeur() == 0) {
         this.var_action = 1;
      } else if (this.usersLog.getUsrVendeur() == 1) {
         this.var_action = 2;
      } else if (this.usersLog.getUsrVendeur() == 2) {
         this.var_action = 3;
      }

      this.nomFamille = 0L;
      this.nomComplementaire = 0L;
      this.var_pecCnamgs = 0.0F;
      this.verifValideConsultation();
   }

   public void annulerTiers() {
      this.patients = null;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void detailPatient() {
      if (this.formPatients != null && this.patients != null) {
         this.formPatients.setNature(this.nature);
         this.formPatients.setPatients(this.patients);
         this.formPatients.setVar_action(3);
         this.var_memo_action = this.var_action;
         this.var_action = 5;
      }

   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void majPatient() throws HibernateException, NamingException {
      if (this.formPatients != null && this.formPatients.moduleMajPatient()) {
         this.var_action = this.var_memo_action;
      }

   }

   public void ajouterPatient() throws HibernateException, NamingException {
      this.formPatients.moduleAjouterPatient();
      this.formPatients.setVar_action(1);
      this.var_action = 5;
   }

   public void modifierPatient() throws HibernateException, NamingException {
      this.patients = this.formPatients.moduleRecuererPatient();
      if (this.patients != null) {
         this.formPatients.setPatients(this.patients);
         this.formPatients.setVar_action(2);
         this.var_action = 5;
      }

   }

   public void consulterPatient() throws HibernateException, NamingException {
      this.patients = this.formPatients.moduleRecuererPatient();
      if (this.patients != null) {
         this.formPatients.setPatients(this.patients);
         this.formPatients.setVar_action(3);
         this.var_action = 5;
      }

   }

   private void calculePatient() throws HibernateException, NamingException {
      this.consultationEnteteGene.setPatients(this.patients);
      this.consultationEnteteGene.setCsgIdPatient(this.patients.getPatId());
      if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
         this.consultationEnteteGene.setCsgNomPatient(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
      } else {
         this.consultationEnteteGene.setCsgNomPatient(this.patients.getPatNom());
      }

      this.consultationEnteteGene.setCsgCivilite(this.patients.getPatCivilite());
      this.consultationEnteteGene.setCsgPecCnamgs(0.0F);
      this.nomFamille = (long)this.patients.getPatNomFamille();
      this.consultationEnteteGene.setCsgFam(this.nomFamille);
      this.nomComplementaire = this.patients.getPatPecComplementaire();
      this.consultationEnteteGene.setCsgComplementaire(this.nomComplementaire);
      if (this.consultationEnteteGene.getCsgCivilite() != null && !this.consultationEnteteGene.getCsgCivilite().isEmpty() && this.consultationEnteteGene.getCsgCivilite().equalsIgnoreCase("Bébé")) {
         this.var_lib_poids = "gr";
      } else {
         this.var_lib_poids = "kg";
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      this.elementPatient(var1);
      this.utilInitHibernate.closeSession();
      this.var_aff_action = false;
   }

   public void elementPatient(Session var1) throws HibernateException, NamingException {
      this.mesProtocoleItems.clear();
      PatientProtDao var2 = new PatientProtDao(this.baseLog, this.utilInitHibernate);
      this.mesProtocoleItems = var2.chargerLesPatientsProtoclesItems(this.patients, var1);
      if (this.mesProtocoleItems.size() != 0) {
         this.var_affiche_protocole = true;
      } else {
         this.var_affiche_protocole = false;
      }

      this.lesPatientAntecedent.clear();
      if (this.usersLog.getUsrVendeur() != 1) {
         this.lesPatientAntecedent = this.patientAntDao.chargerLesPatientsAntecedents(this.patients, var1);
         this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
         this.consultationEnteteGene.setLib_diag1("");
         this.consultationEnteteGene.setLib_diag2("");
         this.consultationEnteteGene.setLib_diag3("");
         this.consultationEnteteGene.setLib_diag4("");
         this.consultationEnteteGene.setLib_diag5("");
         this.consultationEnteteGene.setLib_diag11("");
         this.consultationEnteteGene.setLib_diag12("");
      }

      this.mesCategoriesItems.clear();
      this.mesComplementaireItems.clear();
      this.var_pecAssurance = false;
      new ArrayList();
      List var3 = this.patientPecDao.chargerLesPatientsPec(this.patients, 0, var1);
      int var4;
      if (var3.size() != 0) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            if ((((PatientPec)var3.get(var4)).getPatpecInactif() == 0 || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.consultationEnteteGene.getCsgIdAssurance() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.consultationEnteteGene.getCsgIdSociete() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.consultationEnteteGene.getCsgIdComplementaire()) && ((PatientPec)var3.get(var4)).getPatpecType() != null && !((PatientPec)var3.get(var4)).getPatpecType().isEmpty()) {
               if (!((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Assurance") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("IPM") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Programme Médical") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Mutuelle/Assurance")) {
                  if (!((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Client société") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Ministère") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Hôpital") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Direction") && !((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Mairie")) {
                     if (((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Mutuelle") || ((PatientPec)var3.get(var4)).getPatpecType().equalsIgnoreCase("Complémentaire")) {
                        this.mesComplementaireItems.add(new SelectItem(((PatientPec)var3.get(var4)).getPatpecId(), "Complém.:" + ((PatientPec)var3.get(var4)).getTiers().getTieraisonsocialenom()));
                     }
                  } else {
                     this.mesCategoriesItems.add(new SelectItem(((PatientPec)var3.get(var4)).getPatpecId(), "Société:" + ((PatientPec)var3.get(var4)).getTiers().getTieraisonsocialenom()));
                  }
               } else {
                  this.var_pecAssurance = true;
                  if (((PatientPec)var3.get(var4)).getPatpecIdEmployeur() != 0L) {
                     this.mesCategoriesItems.add(new SelectItem(((PatientPec)var3.get(var4)).getPatpecId(), "Assuré:" + ((PatientPec)var3.get(var4)).getTiers().getTieraisonsocialenom() + "=" + ((PatientPec)var3.get(var4)).getPatpecNomEmployeur()));
                  } else {
                     this.mesCategoriesItems.add(new SelectItem(((PatientPec)var3.get(var4)).getPatpecId(), "Assuré:" + ((PatientPec)var3.get(var4)).getTiers().getTieraisonsocialenom()));
                  }
               }
            }
         }
      }

      this.tauxCasSocial = 0.0F;
      if (this.lesCategoriesList.size() != 0) {
         for(var4 = 0; var4 < this.lesCategoriesList.size(); ++var4) {
            if (this.patients.getPatPourcentCasSocial() != 0.0F) {
               this.tauxCasSocial = this.patients.getPatPourcentCasSocial();
               if (((ObjetCategories)this.lesCategoriesList.get(var4)).getLibelle_FR().equalsIgnoreCase("cas social")) {
                  this.mesCategoriesItems.add(new SelectItem(((ObjetCategories)this.lesCategoriesList.get(var4)).getCode(), ((ObjetCategories)this.lesCategoriesList.get(var4)).getLibelle_FR()));
               }
            } else if (((ObjetCategories)this.lesCategoriesList.get(var4)).getLibelle_FR().equalsIgnoreCase("Non Assuré")) {
               this.mesCategoriesItems.add(new SelectItem(((ObjetCategories)this.lesCategoriesList.get(var4)).getCode(), ((ObjetCategories)this.lesCategoriesList.get(var4)).getLibelle_FR()));
            }
         }
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
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpMedecin = "";
         this.inpProtocole = "";
         this.inpNomPatient = "";
         this.inpPrenomPatient = "";
         this.inpTel = "";
         this.inpCi = "";
         this.inpDossier = "";
         this.inpSociete = "";
         this.inpAssurance = "";
         this.inpComplementaire = "";
         this.inpContrat = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesConsultationEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      this.var_nb_ligne = 0;
      String var14 = "";
      String var15 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var14 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var15 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var14 = null;
         var15 = null;
      }

      Object var16 = new ArrayList();
      if (this.inpEtat != 50) {
         var16 = this.consultationEnteteGeneDao.rechercheConsultation(var1, this.exercicesVentes.getExevteId(), this.inpSite, this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), this.getInpEtat(), this.getInpSerie(), this.getInpFam(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var14, var15);
      }

      int var17;
      if (this.inpEtat == 13) {
         if (((List)var16).size() != 0) {
            for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
               if (((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 1 || ((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 4 || ((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 5 || ((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 6) {
                  this.lesConsultationEntete.add(((List)var16).get(var17));
               }
            }
         }
      } else if (this.inpEtat == 15) {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 6) {
               this.lesConsultationEntete.add(((List)var16).get(var17));
            }
         }
      } else if (this.inpEtat != 17 && this.inpEtat != 18) {
         this.lesConsultationEntete = (List)var16;
      } else {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 5 || ((ConsultationEnteteGene)((List)var16).get(var17)).getCsgEtat() == 6) {
               this.lesConsultationEntete.add(((List)var16).get(var17));
            }
         }
      }

      if (this.lesConsultationEntete.size() > 0) {
         this.datamodelDocument = new ListDataModel();
         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
         new ConsultationEnteteGene();

         for(int var18 = 0; var18 < this.lesConsultationEntete.size(); ++var18) {
            ConsultationEnteteGene var19 = (ConsultationEnteteGene)this.lesConsultationEntete.get(var18);
            var2 += var19.getCsgTotPatient();
            var4 += var19.getCsgTotTaxePatient();
            var6 = var6 + var19.getCsgTotAssurance() + var19.getCsgTotSociete() + var19.getCsgTotComplmentaire();
            var8 = var8 + var19.getCsgTotTaxeAssurance() + var19.getCsgTotTaxeSociete() + var19.getCsgTotTaxeComplementaire();
            var10 += var19.getCsgRegPatient();
            var12 += var19.getCsgRegTiers();
         }

         this.var_nb_ligne = this.lesConsultationEntete.size();
      }

      this.totalPatient = var2 + var4;
      this.totalTiers = var6 + var8;
      this.regPatient = var10;
      this.regTiers = var12;
      this.soldePatient = var2 + var4 - var10;
      this.soldeTiers = var6 + var8 - var12;
      this.visibiliteBton = false;
   }

   public void selectionConsultation() throws HibernateException, NamingException, JDOMException, IOException {
      this.consultationEnteteGene = new ConsultationEnteteGene();
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
            this.consultationEnteteGene = (ConsultationEnteteGene)var1.get(0);
            if (this.consultationEnteteGene.getCsgCivilite() != null && !this.consultationEnteteGene.getCsgCivilite().isEmpty() && this.consultationEnteteGene.getCsgCivilite().equalsIgnoreCase("Bébé")) {
               this.var_lib_poids = "gr";
            } else {
               this.var_lib_poids = "kg";
            }

            this.var_pecCnamgs = this.consultationEnteteGene.getCsgPecCnamgs();
            this.nomFamille = this.consultationEnteteGene.getCsgFam();
            this.nomComplementaire = this.consultationEnteteGene.getCsgComplementaire();
            if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
               this.var_pecAssurance = true;
            } else {
               this.var_pecAssurance = false;
            }

            this.var_nom_medecin = this.consultationEnteteGene.getCsgIdMedecin();
            this.var_date = this.consultationEnteteGene.getCsgDate();
            this.memoDateRdv = this.consultationEnteteGene.getCsgRdv();
            if (this.consultationEnteteGene.getCsgDate().getHours() <= 9) {
               this.var_heure = "0" + this.consultationEnteteGene.getCsgDate().getHours();
            } else {
               this.var_heure = "" + this.consultationEnteteGene.getCsgDate().getHours();
            }

            if (this.consultationEnteteGene.getCsgDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.consultationEnteteGene.getCsgDate().getMinutes();
            } else {
               this.var_minute = "" + this.consultationEnteteGene.getCsgDate().getMinutes();
            }

            if (this.consultationEnteteGene.getCsgDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.consultationEnteteGene.getCsgDate().getSeconds();
            } else {
               this.var_seconde = "" + this.consultationEnteteGene.getCsgDate().getSeconds();
            }

            this.patients = this.consultationEnteteGene.getPatients();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
            this.elementPatient(var6);
            if (this.consultationEnteteGene.getCsgCodeDiag1() != null && !this.consultationEnteteGene.getCsgCodeDiag1().isEmpty()) {
               this.consultationEnteteGene.setLib_diag1(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag1(), var6).getCimLibelleFR());
            }

            if (this.consultationEnteteGene.getCsgCodeDiag2() != null && !this.consultationEnteteGene.getCsgCodeDiag2().isEmpty()) {
               this.consultationEnteteGene.setLib_diag2(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag2(), var6).getCimLibelleFR());
            }

            if (this.consultationEnteteGene.getCsgCodeDiag3() != null && !this.consultationEnteteGene.getCsgCodeDiag3().isEmpty()) {
               this.consultationEnteteGene.setLib_diag3(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag3(), var6).getCimLibelleFR());
            }

            if (this.consultationEnteteGene.getCsgCodeDiag4() != null && !this.consultationEnteteGene.getCsgCodeDiag4().isEmpty()) {
               this.consultationEnteteGene.setLib_diag4(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag4(), var6).getCimLibelleFR());
            }

            if (this.consultationEnteteGene.getCsgCodeDiag5() != null && !this.consultationEnteteGene.getCsgCodeDiag5().isEmpty()) {
               this.consultationEnteteGene.setLib_diag5(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag5(), var6).getCimLibelleFR());
            }

            if (this.consultationEnteteGene.getCsgCodeDiag11() != null && !this.consultationEnteteGene.getCsgCodeDiag11().isEmpty()) {
               this.consultationEnteteGene.setLib_diag11(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag11(), var6).getCimLibelleFR());
            }

            if (this.consultationEnteteGene.getCsgCodeDiag12() != null && !this.consultationEnteteGene.getCsgCodeDiag12().isEmpty()) {
               this.consultationEnteteGene.setLib_diag12(this.cimMedicalDao.selectOneCim(this.consultationEnteteGene.getCsgCodeDiag12(), var6).getCimLibelleFR());
            }

            this.chargerPriseEnCharges(var6);
            this.chargerActes(var6);
            this.chargerOrdonnance(var6);
            this.chargerLaboratoire(var6);
            this.chargerDocumentScan();
            this.var_aff_detail_prod = false;
            this.afficheButtActes = false;
            this.afficheButtAntecedent = false;
            this.afficheButtOrdo = false;
            this.afficheButtLabo = false;
            this.afficheButtPharmacie = false;
            this.var_affiche_at = false;
            this.var_affiche_vaccin = false;
            this.var_affiche_audio = false;
            this.var_affiche_vme = false;
            this.var_affiche_vma = false;
            this.var_affiche_tubertest = false;
            this.var_affiche_certificat = false;
            this.var_nom_fournisseurPha = 0L;
            this.var_nom_fournisseurLab = 0L;
            this.medecinSpecialite = 0;
            double var4 = 0.0D;
            if (this.infirmerie) {
               this.chargerElements(var6);
               if (this.consultationEnteteGene.getCsgNumBc() != null && !this.consultationEnteteGene.getCsgNumBc().isEmpty()) {
                  this.var_nom_fournisseurPha = this.consultationEnteteGene.getCsgIdComplementaire();
                  this.var_nom_fournisseurLab = this.consultationEnteteGene.getCsgIdAssurance();
                  this.chargerFournisseurs(var6);
               }
            } else {
               var4 = this.chargerBonEncaissement(var6);
            }

            this.calculMedecinActe(var6);
            this.chargerUserChrono(var6);
            this.utilInitHibernate.closeSession();
            if (var4 != 0.0D && this.consultationEnteteGene.getCsgRegPatient() != var4) {
               this.consultationEnteteGene.setCsgRegPatient(var4);
               if (var4 >= this.consultationEnteteGene.getCsgTotPatient()) {
                  this.consultationEnteteGene.setCsgSoldePatient(1);
               } else {
                  this.consultationEnteteGene.setCsgSoldePatient(0);
               }

               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene);
            }

            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.consultationEnteteGene != null) {
         if (this.consultationEnteteGene.getCsgEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerPriseEnCharges(Session var1) throws HibernateException, NamingException {
      this.patientPec = null;
      this.patientPecComplementaire = null;
      if (this.consultationEnteteGene.getCsgFam() != 0L) {
         this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 0, var1);
      }

      if (this.consultationEnteteGene.getCsgComplementaire() != 0L) {
         this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgComplementaire(), 0, var1);
      }

   }

   public void chargerActes(Session var1) throws HibernateException, NamingException {
      this.lesActe.clear();
      this.consultationActes = new ConsultationActes();
      this.lesActe = this.consultationActesDao.selectConsActesByConsEnt(this.consultationEnteteGene, var1);
      this.dataModelActe.setWrappedData(this.lesActe);
      this.ajouterSurAvoir = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      if (this.lesActe.size() != 0) {
         for(int var2 = 0; var2 < this.lesActe.size(); ++var2) {
            this.totalDocFacture += ((ConsultationActes)this.lesActe.get(var2)).getCslactTotal() + ((ConsultationActes)this.lesActe.get(var2)).getCslactTaxe();
            this.totalDocPatient += ((ConsultationActes)this.lesActe.get(var2)).getTotlalPatient();
            this.totalDocReglement += ((ConsultationActes)this.lesActe.get(var2)).getCslactRegPatient();
            this.totalDocTiers += ((ConsultationActes)this.lesActe.get(var2)).getTotalTiers();
            if (((ConsultationActes)this.lesActe.get(var2)).getCslactQte() < 0.0F && (((ConsultationActes)this.lesActe.get(var2)).getConsultationEnteteGene().getCsgDateTransfert() == null || ((ConsultationActes)this.lesActe.get(var2)).getConsultationEnteteGene().getCsgEtat() <= 9)) {
               this.ajouterSurAvoir = true;
            }
         }
      }

   }

   public void chargerOrdonnance(Session var1) throws HibernateException, NamingException {
      this.lesOrdonnance.clear();
      this.consultationOrdo = new ConsultationOrdo();
      this.lesOrdonnance = this.consultationOrdoDao.selectConsOrdoByConsEnt(this.consultationEnteteGene, var1);
      this.dataModelOrdonnance.setWrappedData(this.lesOrdonnance);
      this.lesPharmacie.clear();
      this.pharmacieLigne = new PharmacieLigne();
      if (this.infirmerie) {
         this.lesPharmacie = this.pharmacieLigneDao.selectConsActesByConsEnt(this.consultationEnteteGene, var1);
      }

      this.dataModelPharmacie.setWrappedData(this.lesPharmacie);
   }

   public void chargerLaboratoire(Session var1) throws HibernateException, NamingException {
      this.lesLaboratoire.clear();
      this.consultationLabo = new ConsultationLabo();
      this.lesLaboratoire = this.consultationLaboDao.selectConsLaboByConsEnt(this.consultationEnteteGene, var1);
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
   }

   public void chargerElements(Session var1) throws HibernateException, NamingException {
      this.calculeMotifEntree(var1);
      this.consultationInfirmerie = new ConsultationInfirmerie();
      this.consultationInfirmerie = this.consultationInfirmerieDao.selectConsInfirmerieByConsEnt(this.consultationEnteteGene, var1);
      if (this.consultationInfirmerie == null) {
         this.consultationInfirmerie = new ConsultationInfirmerie();
         this.var_date_accident = null;
         this.var_heures = 0;
         this.var_minutes = 0;
         if (this.var_affiche_at) {
            this.consultationInfirmerie.setCslaccType(0);
         } else if (this.var_affiche_vaccin) {
            this.consultationInfirmerie.setCslaccType(1);
         } else if (this.var_affiche_audio) {
            this.consultationInfirmerie.setCslaccType(2);
         } else if (this.var_affiche_vme) {
            this.consultationInfirmerie.setCslaccType(3);
         } else if (this.var_affiche_vma) {
            this.consultationInfirmerie.setCslaccType(4);
         } else if (this.var_affiche_tubertest) {
            this.consultationInfirmerie.setCslaccType(5);
         }
      } else {
         if (this.consultationInfirmerie.getCslaccDateAccident() != null) {
            this.var_date_accident = this.consultationInfirmerie.getCslaccDateAccident();
            this.var_heures = this.consultationInfirmerie.getCslaccDateAccident().getHours();
            this.var_minutes = this.consultationInfirmerie.getCslaccDateAccident().getMinutes();
         }

         if (this.consultationInfirmerie.getCslaccCertificat() != 0) {
            this.var_affiche_certificat = true;
         }

         if (this.consultationInfirmerie.getCslaccType() == 1) {
            this.chargerElement();
         } else if (this.consultationInfirmerie.getCslaccType() == 2) {
            this.chargerElement();
         } else if (this.consultationInfirmerie.getCslaccType() == 3) {
            this.chargerElement();
         } else if (this.consultationInfirmerie.getCslaccType() == 4) {
            this.chargerElement();
         } else if (this.consultationInfirmerie.getCslaccType() == 5) {
            this.chargerElement();
         }
      }

   }

   public void calculeMotifEntree() throws HibernateException, NamingException {
      this.calculeMotifEntree((Session)null);
   }

   public void calculeMotifEntree(Session var1) throws HibernateException, NamingException {
      this.var_affiche_at = false;
      this.var_affiche_vaccin = false;
      this.var_affiche_audio = false;
      this.var_affiche_vme = false;
      this.var_affiche_vma = false;
      this.var_affiche_tubertest = false;
      this.var_affiche_maladie = true;
      this.lesElements.clear();
      if (this.consultationEnteteGene != null && this.consultationEnteteGene.getCsgEntree() != null && !this.consultationEnteteGene.getCsgEntree().isEmpty()) {
         String var2 = "";
         if (this.consultationEnteteGene.getCsgEntree().contains(":")) {
            String[] var3 = this.consultationEnteteGene.getCsgEntree().split(":");
            var2 = var3[0];
         } else {
            var2 = this.consultationEnteteGene.getCsgEntree();
         }

         this.motifEntreeMedical = this.motifEntreeMedicalDao.selectMotifEntreeMedical(this.exercicesVentes.getExevteId(), var2, var1);
         if (this.motifEntreeMedical != null) {
            if (this.motifEntreeMedical.isVar_at()) {
               this.var_affiche_at = true;
               this.var_affiche_maladie = false;
            } else if (this.motifEntreeMedical.isVar_vaccin()) {
               LectureInfirmerieVaccin var4 = new LectureInfirmerieVaccin();
               this.lesElements = var4.getMesElements();
               this.var_affiche_vaccin = true;
               this.var_affiche_maladie = false;
            } else if (this.motifEntreeMedical.isVar_audio()) {
               LectureInfirmerieAudiometrie var5 = new LectureInfirmerieAudiometrie();
               this.lesElements = var5.getMesElements();
               this.var_affiche_audio = true;
               this.var_affiche_maladie = false;
            } else if (this.motifEntreeMedical.isVar_vme()) {
               LectureInfirmerieVme var6 = new LectureInfirmerieVme();
               this.lesElements = var6.getMesElements();
               this.var_affiche_vme = true;
               this.var_affiche_maladie = false;
            } else if (this.motifEntreeMedical.isVar_vma()) {
               LectureInfirmerieVma var7 = new LectureInfirmerieVma();
               this.lesElements = var7.getMesElements();
               this.var_affiche_vma = true;
               this.var_affiche_maladie = false;
            } else if (this.motifEntreeMedical.isVar_tubertest()) {
               LectureInfirmerieTuberTest var8 = new LectureInfirmerieTuberTest();
               this.lesElements = var8.getMesElements();
               this.var_affiche_tubertest = true;
               this.var_affiche_maladie = false;
            }
         }
      }

      this.dataModelElements.setWrappedData(this.lesElements);
   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.consultationEnteteGene.getCsgId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      new ArrayList();
      List var8 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), this.nature, var1);
      double var4 = 0.0D;
      this.afficheRecu = false;
      if (var8.size() != 0) {
         this.afficheRecu = true;
         new Reglements();

         for(int var7 = 0; var7 < var8.size(); ++var7) {
            Reglements var6 = (Reglements)var8.get(var7);
            this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + var6.getRglRecette() - var6.getRglDepense();
            var4 += ((Reglements)var8.get(var7)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var8);
      if (this.var_tot_bon_encaissement < this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient()) {
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

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null && this.consultationEnteteGene.getCsgSerie() != null && !this.consultationEnteteGene.getCsgSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.consultationEnteteGene.getCsgSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerDocumentScan() throws IOException {
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.consultationEnteteGene.getCsgNum().replace("/", "_");
         String[] var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesDocuments.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      Object var1 = new ArrayList();
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (this.consultationEnteteGene.getCsgId() > 0L) {
            FactureLigneMedicalDao var4 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
            var1 = var4.chargerLesLignesFacturesByNature(this.consultationEnteteGene.getCsgId(), "", 71, var2);
            if (((List)var1).size() != 0) {
               if (this.consultationEnteteGene.getCsgEtat() <= 5) {
                  this.consultationEnteteGene.setCsgEtat(6);
                  this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var2);
               }
            } else if (this.consultationEnteteGene.getCsgEtat() >= 6) {
               this.consultationEnteteGene.setCsgEtat(5);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var2);
            }
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

      this.datamodelDocumentTrace.setWrappedData(var1);
   }

   public void calculTotaux() {
      if (this.consultationEnteteGene.getCsgEntree() == null || this.consultationEnteteGene.getCsgEntree().isEmpty() || !this.consultationEnteteGene.getCsgEntree().contains(":") || this.consultationEnteteGene.getCsgEntree().equals("100")) {
         this.consultationEnteteGene.setCsgEntree("");
      }

      if (this.consultationEnteteGene.getCsgPathologie() == null || this.consultationEnteteGene.getCsgPathologie().isEmpty() || !this.consultationEnteteGene.getCsgPathologie().contains(":") || this.consultationEnteteGene.getCsgPathologie().equals("100")) {
         this.consultationEnteteGene.setCsgPathologie("");
      }

      if (this.consultationEnteteGene.getCsgProtocole() == null || this.consultationEnteteGene.getCsgProtocole().isEmpty() || !this.consultationEnteteGene.getCsgProtocole().contains(":") || this.consultationEnteteGene.getCsgProtocole().equals("100")) {
         this.consultationEnteteGene.setCsgProtocole("");
      }

      if ((this.consultationEnteteGene.getCsgService() == null || this.consultationEnteteGene.getCsgService().isEmpty() || !this.consultationEnteteGene.getCsgService().contains(":") || this.consultationEnteteGene.getCsgService().equals("100")) && !this.infirmerie) {
         this.consultationEnteteGene.setCsgService("");
      }

      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = 0.0D;
      double var19 = 0.0D;
      double var21 = 0.0D;
      if (this.lesActe.size() != 0) {
         new ConsultationActes();

         for(int var24 = 0; var24 < this.lesActe.size(); ++var24) {
            ConsultationActes var23 = (ConsultationActes)this.lesActe.get(var24);
            var5 += var23.getCslactPatientHt();
            var7 += var23.getCslactPatientTaxe();
            var9 += var23.getCslactSocieteHt();
            var11 += var23.getCslactSocieteTaxe();
            var13 += var23.getCslactAssuranceHt();
            var15 += var23.getCslactAssuranceTaxe();
            var17 += var23.getCslactComplementaireHt();
            var19 += var23.getCslactComplementaireTaxe();
            var21 += var23.getCslactRabais();
         }

         var1 = var5 + var9 + var13 + var17;
         var3 = var7 + var11 + var15 + var19;
      }

      this.consultationEnteteGene.setCsgTotPatient(var5);
      this.consultationEnteteGene.setCsgTotTaxePatient(var7);
      this.consultationEnteteGene.setCsgTotSociete(var9);
      this.consultationEnteteGene.setCsgTotTaxeSociete(var11);
      this.consultationEnteteGene.setCsgTotAssurance(var13);
      this.consultationEnteteGene.setCsgTotTaxeAssurance(var15);
      this.consultationEnteteGene.setCsgTotComplmentaire(var17);
      this.consultationEnteteGene.setCsgTotTaxeComplementaire(var19);
      this.consultationEnteteGene.setCsgTotGeneral(var1);
      this.consultationEnteteGene.setCsgTotTaxeGeneral(var3);
      this.consultationEnteteGene.setCsgTotRabais(var21);
      this.var_tot_tiers = var9 + var13 + var17;
      this.var_tot_reg = this.consultationEnteteGene.getCsgRegPatient() + this.consultationEnteteGene.getCsgRegTiers();
      this.var_solde = this.consultationEnteteGene.getCsgTotGeneral() - this.var_tot_reg;
      this.totalDocFacture = var1 + var3;
      this.totalDocPatient = var5 + var7;
      this.totalDocReglement = this.var_tot_reg;
      this.totalDocTiers = var9 + var11 + var13 + var15 + var17 + var19;
   }

   public void calculeEtat() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.dateRefacturation = null;
         this.numRefacturation = "";
         this.etatRefacuration = "";
         this.autoriseRefacturation = false;
         new FactureLigneMedical();
         FactureLigneMedicalDao var2 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
         FactureLigneMedical var1 = var2.rechercheFactureByConsultation(this.consultationEnteteGene.getCsgId(), (Session)null);
         if (var1 != null) {
            this.dateRefacturation = var1.getFactureEnteteMedical().getFacDate();
            this.numRefacturation = var1.getFactureEnteteMedical().getFacNum();
            this.etatRefacuration = var1.getFactureEnteteMedical().getLibelleEta();
            if (var1.getFactureEnteteMedical().getFacEtat() == 0) {
               this.autoriseRefacturation = true;
            } else {
               this.autoriseRefacturation = false;
            }
         } else {
            this.autoriseRefacturation = true;
         }
      }

   }

   public void bloqueFacturation() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.consultationEnteteGene.setCsgBloqueRefacturation(true);
         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene);
      }

   }

   public void deBloqueFacturation() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.consultationEnteteGene.setCsgBloqueRefacturation(false);
         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.lesMedecins.clear();
      this.mesMedecinsItem.clear();
      this.lesPatientAntecedent.clear();
      this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
      this.lesActe.clear();
      this.dataModelActe.setWrappedData(this.lesActe);
      this.lesOrdonnance.clear();
      this.dataModelOrdonnance.setWrappedData(this.lesOrdonnance);
      this.lesPharmacie.clear();
      this.dataModelPharmacie.setWrappedData(this.lesPharmacie);
      this.lesLaboratoire.clear();
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.consultationEnteteGene = new ConsultationEnteteGene();
      this.consultationActes = new ConsultationActes();
      this.consultationLabo = new ConsultationLabo();
      this.consultationOrdo = new ConsultationOrdo();
      this.consultationInfirmerie = new ConsultationInfirmerie();
      this.pharmacieLigne = new PharmacieLigne();
      this.memoDateRdv = null;
      this.mesCategoriesItems.clear();
      this.calculMedecinActe();
      this.nomFamille = 0L;
      this.nomComplementaire = 0L;
      this.var_nom_fournisseurPha = 0L;
      this.var_nom_fournisseurLab = 0L;
      this.patientPec = null;
      this.patientPecComplementaire = null;
      this.valideConsultation = false;
      if (this.patients != null && this.var_consultation_directe) {
         this.calculePatient();
         if (this.usersLog.getUsrVendeur() == 0) {
            this.var_action = 1;
         } else if (this.usersLog.getUsrVendeur() == 1) {
            this.var_action = 2;
         } else if (this.usersLog.getUsrVendeur() == 2) {
            this.var_action = 3;
         }

         this.var_aff_detail_tiers = true;
         this.var_pecCnamgs = 0.0F;
      } else {
         this.recherchePatients();
         this.var_action = 4;
         this.var_aff_detail_tiers = false;
         this.var_pecCnamgs = 0.0F;
         this.var_pecAssurance = false;
      }

      if (this.optionMedical.getCnamgs().equals("0")) {
         this.var_pecCnamgs = 0.0F;
      }

      this.nomFamille = 0L;
      if (this.infirmerie) {
         this.consultationEnteteGene.setCsgService(this.inpSite);
      }

      this.consultationEnteteGene.setCsgIdCreateur(this.usersLog.getUsrid());
      this.consultationEnteteGene.setCsgNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.consultationEnteteGene.setCsgIdMedecin(this.usersLog.getUsrid());
      this.consultationEnteteGene.setCsgMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.consultationEnteteGene.setCsgDate(new Date());
      this.consultationEnteteGene.setCsgDateCreat(new Date());
      this.consultationEnteteGene.setCsgDateModif((Date)null);
      this.consultationEnteteGene.setCsgIdModif(0L);
      this.consultationEnteteGene.setCsgNomModif("");
      this.consultationEnteteGene.setCsgNum("");
      this.var_nom_medecin = 0L;
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

      this.chargerModeEcheance();
      this.var_tot_bon_encaissement = 0.0D;
      this.var_aff_action = false;
      this.visibleOnglet = false;
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.afficheButtAntecedent = false;
      this.afficheButtOrdo = false;
      this.afficheButtLabo = false;
      this.afficheButtPharmacie = false;
      this.var_affiche_at = false;
      this.var_affiche_vaccin = false;
      this.var_affiche_audio = false;
      this.var_affiche_vme = false;
      this.var_affiche_vma = false;
      this.var_affiche_tubertest = false;
      this.var_affiche_certificat = false;
      this.showModalpanelPec = false;
      this.ajouterSurAvoir = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      this.var_memo_action = this.var_action;
   }

   public void duppliquerDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (this.consultationEnteteGene != null && this.patients != null) {
         this.var_consultation_directe = true;
         this.lesMedecins.clear();
         this.mesMedecinsItem.clear();
         this.lesPatientAntecedent.clear();
         this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
         this.lesActe.clear();
         this.dataModelActe.setWrappedData(this.lesActe);
         this.lesOrdonnance.clear();
         this.dataModelOrdonnance.setWrappedData(this.lesOrdonnance);
         this.lesPharmacie.clear();
         this.dataModelPharmacie.setWrappedData(this.lesPharmacie);
         this.lesLaboratoire.clear();
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.consultationEnteteGene = new ConsultationEnteteGene();
         this.consultationActes = new ConsultationActes();
         this.consultationLabo = new ConsultationLabo();
         this.consultationOrdo = new ConsultationOrdo();
         this.consultationInfirmerie = new ConsultationInfirmerie();
         this.pharmacieLigne = new PharmacieLigne();
         this.memoDateRdv = null;
         this.mesCategoriesItems.clear();
         this.calculMedecinActe();
         this.nomFamille = 0L;
         this.nomComplementaire = 0L;
         this.var_nom_fournisseurPha = 0L;
         this.var_nom_fournisseurLab = 0L;
         this.patientPec = null;
         this.patientPecComplementaire = null;
         this.valideConsultation = false;
         this.calculePatient();
         if (this.usersLog.getUsrVendeur() == 0) {
            this.var_action = 1;
         } else if (this.usersLog.getUsrVendeur() == 1) {
            this.var_action = 2;
         } else if (this.usersLog.getUsrVendeur() == 2) {
            this.var_action = 3;
         }

         this.var_aff_detail_tiers = true;
         this.var_pecCnamgs = 0.0F;
         this.nomFamille = 0L;
         this.consultationEnteteGene.setCsgIdCreateur(this.usersLog.getUsrid());
         this.consultationEnteteGene.setCsgNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         this.consultationEnteteGene.setCsgIdMedecin(this.usersLog.getUsrid());
         this.consultationEnteteGene.setCsgMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         this.consultationEnteteGene.setCsgDate(new Date());
         this.consultationEnteteGene.setCsgDateCreat(new Date());
         this.consultationEnteteGene.setCsgDateModif((Date)null);
         this.consultationEnteteGene.setCsgIdModif(0L);
         this.consultationEnteteGene.setCsgNomModif("");
         this.consultationEnteteGene.setCsgNum("");
         this.var_nom_medecin = 0L;
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

         this.chargerModeEcheance();
         this.var_tot_bon_encaissement = 0.0D;
         this.var_aff_action = false;
         this.visibleOnglet = false;
         this.var_aff_detail_prod = false;
         this.afficheButtActes = false;
         this.afficheButtAntecedent = false;
         this.afficheButtOrdo = false;
         this.afficheButtLabo = false;
         this.afficheButtPharmacie = false;
         this.var_affiche_at = false;
         this.var_affiche_vaccin = false;
         this.var_affiche_audio = false;
         this.var_affiche_vme = false;
         this.var_affiche_vma = false;
         this.var_affiche_tubertest = false;
         this.var_affiche_certificat = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.consultationEnteteGene != null) {
         this.chargerModeEcheance();
         if (this.usersLog.getUsrVendeur() == 0) {
            this.var_action = 11;
         } else if (this.usersLog.getUsrVendeur() == 1) {
            this.var_action = 12;
         } else if (this.usersLog.getUsrVendeur() == 2) {
            this.var_action = 13;
         }

         this.var_aff_action = false;
         this.var_aff_detail_tiers = true;
         this.visibleOnglet = true;
         this.verifValideConsultation();
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() throws ParseException {
      if (this.consultationEnteteGene != null) {
         this.chargerModeEcheance();
         if (this.usersLog.getUsrVendeur() == 0) {
            this.var_action = 21;
         } else if (this.usersLog.getUsrVendeur() == 1) {
            this.var_action = 22;
         } else if (this.usersLog.getUsrVendeur() == 2) {
            this.var_action = 23;
         }

         this.var_aff_action = true;
         this.var_aff_detail_tiers = true;
         this.visibleOnglet = true;
         this.valideConsultation = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      if (this.consultationEnteteGene.getCsgTypeReg() != 0 && this.consultationEnteteGene.getCsgTypeReg() != 3) {
         if (this.consultationEnteteGene.getCsgTypeReg() != 1 && this.consultationEnteteGene.getCsgTypeReg() != 2) {
            this.visibiliteterme = false;
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
            this.visibiliteencaissemt = false;
         }
      } else {
         this.consultationEnteteGene.setCsgNbJourReg(0);
         this.consultationEnteteGene.setCsgArrondiReg(0);
      }

      if (this.consultationEnteteGene.getCsgTypeReg() == 4) {
         this.visibiliteencaissemt = true;
         this.visibilitenbrjr = true;
      } else {
         this.visibiliteencaissemt = false;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.consultationEnteteGene.getCsgDate(), this.consultationEnteteGene.getCsgTypeReg(), this.consultationEnteteGene.getCsgNbJourReg(), this.consultationEnteteGene.getCsgArrondiReg());
      this.consultationEnteteGene.setCsgDateEcheReg(var1);
   }

   public void selectionPec() throws HibernateException, NamingException {
      this.changerTarif();
   }

   public void supprimerDocument() throws HibernateException, NamingException, IOException, ParseException {
      if (this.consultationEnteteGene != null) {
         String var1 = this.consultationEnteteGene.getCsgNum();
         new ArrayList();
         List var2 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), this.nature, (Session)null);
         if (var2.size() == 0) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
            Transaction var4 = null;

            try {
               var4 = var3.beginTransaction();
               int var5;
               if (this.lesActe.size() != 0) {
                  for(var5 = 0; var5 < this.lesActe.size(); ++var5) {
                     this.consultationActes = (ConsultationActes)this.lesActe.get(var5);
                     this.consultationActesDao.delete(this.consultationActes, var3);
                  }
               }

               if (this.lesOrdonnance.size() != 0) {
                  for(var5 = 0; var5 < this.lesOrdonnance.size(); ++var5) {
                     this.consultationOrdo = (ConsultationOrdo)this.lesOrdonnance.get(var5);
                     this.consultationOrdoDao.delete(this.consultationOrdo, var3);
                  }
               }

               if (this.lesPharmacie.size() != 0) {
                  for(var5 = 0; var5 < this.lesPharmacie.size(); ++var5) {
                     this.pharmacieLigne = (PharmacieLigne)this.lesPharmacie.get(var5);
                     this.pharmacieLigneDao.delete(this.pharmacieLigne, var3);
                  }
               }

               if (this.consultationInfirmerie != null && this.consultationInfirmerie.getCslaccId() != 0L) {
                  this.consultationInfirmerie = this.consultationInfirmerieDao.selectConsInfirmerieByConsEnt(this.consultationEnteteGene, var3);
                  if (this.consultationInfirmerie != null) {
                     this.consultationInfirmerieDao.delete(this.consultationInfirmerie, var3);
                  }
               }

               if (this.lesLaboratoire.size() != 0) {
                  for(var5 = 0; var5 < this.lesLaboratoire.size(); ++var5) {
                     this.consultationLabo = (ConsultationLabo)this.lesLaboratoire.get(var5);
                     this.consultationLaboDao.delete(this.consultationLabo, var3);
                  }
               }

               if (this.lesDocuments.size() != 0 && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
                  for(var5 = 0; var5 < this.lesDocuments.size(); ++var5) {
                     String var6 = ((String)this.lesDocuments.get(var5)).toString();
                     File var7 = new File(this.nomRepertoire + var6);
                     if (var7.exists()) {
                        var7.delete();
                     }
                  }
               }

               new ArrayList();
               List var16 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.consultationEnteteGene.getCsgId(), this.nature, var3);
               if (var16.size() != 0) {
                  for(int var13 = 0; var13 < var16.size(); ++var13) {
                     this.bonEncaissementVente = (BonEncaissementVente)var16.get(var13);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var3);
                  }
               }

               new ConsultationEnteteGene();
               ConsultationEnteteGene var14 = this.consultationEnteteGeneDao.selectById(this.consultationEnteteGene.getCsgId(), var3);
               if (var14 != null) {
                  this.consultationEnteteGeneDao.delete(var14, var3);
               }

               this.lesConsultationEntete.remove(this.consultationEnteteGene);
               Espion var15 = new Espion();
               var15.setUsers(this.usersLog);
               var15.setEsptype(0);
               var15.setEspdtecreat(new Date());
               var15.setEspaction("Suppression consultation N° " + var1);
               this.espionDao.mAJEspion(var15, var3);
               var4.commit();
            } catch (HibernateException var11) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            this.formRecherche.setMessageTexte("Ce document a des réglements. La suppression est impossible...");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void save() throws HibernateException, NamingException, ParseException {
      this.calculTotaux();
      this.verifieExistenceHabilitation((Session)null);
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
      Transaction var3 = null;

      Users var4;
      try {
         var3 = var2.beginTransaction();
         this.consultationEnteteGene.setCsgDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         new Users();
         if (this.var_nom_medecin == 0L && this.mesMedecinsItem.size() == 1) {
            this.var_nom_medecin = Long.parseLong(((SelectItem)this.mesMedecinsItem.get(0)).getValue().toString());
         }

         var4 = this.usersDao.selectUserD(this.var_nom_medecin, var2);
         if (var4 != null) {
            this.consultationEnteteGene.setCsgIdMedecin(var4.getUsrid());
            this.consultationEnteteGene.setCsgMedecin(var4.getUsrPatronyme());
         } else {
            this.consultationEnteteGene.setCsgIdMedecin(0L);
            this.consultationEnteteGene.setCsgMedecin("");
         }

         this.consultationEnteteGene.setCsgAyantDroit(false);
         this.consultationEnteteGene.setCsgNomAssurePrincipal("");
         this.consultationEnteteGene.setCsgPecCnamgs(this.var_pecCnamgs);
         if (this.consultationEnteteGene.getCsgFam() <= 0L && this.nomComplementaire == 0L) {
            this.consultationEnteteGene.setCsgIdAssurance(0L);
            this.consultationEnteteGene.setCsgNomAssurance("");
            this.consultationEnteteGene.setCsgContratAssurance("");
            this.consultationEnteteGene.setCsgIdComplementaire(0L);
            this.consultationEnteteGene.setCsgNomComplemtaire("");
            this.consultationEnteteGene.setCsgIdEmployeur(0L);
            this.consultationEnteteGene.setCsgNomEmployeur("");
            this.consultationEnteteGene.setCsgContratComplementaire("");
            this.consultationEnteteGene.setCsgIdSociete(0L);
            this.consultationEnteteGene.setCsgNomSociete("");
            this.consultationEnteteGene.setCsgMatricule("");
         } else {
            if (this.patientPec == null) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 0, var2);
            }

            if (this.patientPec != null) {
               if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
                  this.consultationEnteteGene.setCsgFam(this.patientPec.getPatpecId());
                  if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                     this.consultationEnteteGene.setCsgIdSociete(this.patientPec.getTiers().getTieid());
                     this.consultationEnteteGene.setCsgNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                     this.consultationEnteteGene.setCsgMatricule(this.patientPec.getPatpecMatricule());
                  } else {
                     this.var_pecAssurance = true;
                     this.consultationEnteteGene.setCsgIdAssurance(this.patientPec.getTiers().getTieid());
                     this.consultationEnteteGene.setCsgNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                     this.consultationEnteteGene.setCsgIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     this.consultationEnteteGene.setCsgNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                     this.consultationEnteteGene.setCsgMatricule(this.patientPec.getPatpecMatricule());
                     this.consultationEnteteGene.setCsgContratAssurance(this.patientPec.getPatpecNumContrat());
                  }

                  if (this.patientPec.getPatpecIdCouvert() != 0L) {
                     this.consultationEnteteGene.setCsgAyantDroit(true);
                     this.consultationEnteteGene.setCsgNomAssurePrincipal(this.patientPec.getPatpecNomCouvert());
                  }
               }
            } else {
               this.consultationEnteteGene.setCsgFam(0L);
            }

            if (this.patientPecComplementaire == null && this.consultationEnteteGene.getCsgIdComplementaire() != 0L) {
               this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgComplementaire(), 0, var2);
            }

            if (this.patientPecComplementaire != null) {
               if (this.patientPecComplementaire.getPatpecType() != null && !this.patientPecComplementaire.getPatpecType().isEmpty() && (this.patientPecComplementaire.getPatpecType().equals("Mutuelle") || this.patientPecComplementaire.getPatpecType().equals("Complémentaire"))) {
                  this.consultationEnteteGene.setCsgComplementaire(this.patientPecComplementaire.getPatpecId());
                  this.consultationEnteteGene.setCsgIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
                  this.consultationEnteteGene.setCsgNomComplemtaire(this.patientPecComplementaire.getTiers().getTieraisonsocialenom());
                  this.consultationEnteteGene.setCsgContratComplementaire(this.patientPecComplementaire.getPatpecNumContrat());
               }
            } else {
               this.consultationEnteteGene.setCsgComplementaire(0L);
            }
         }

         if (this.consultationEnteteGene.getCsgId() == 0L) {
            boolean var5 = true;
            if (var5) {
               if (!this.consultationEnteteGene.getCsgSerie().equalsIgnoreCase("X") && !this.consultationEnteteGene.getCsgSerie().isEmpty()) {
                  this.consultationEnteteGene.setCsgNum(this.calculChrono.numCompose(this.consultationEnteteGene.getCsgDate(), this.nature, this.consultationEnteteGene.getCsgSerie(), var2));
                  boolean var28 = false;

                  label758:
                  while(true) {
                     while(true) {
                        if (var28) {
                           break label758;
                        }

                        new ConsultationEnteteGene();
                        ConsultationEnteteGene var7 = this.consultationEnteteGeneDao.selectByNum(this.consultationEnteteGene.getCsgNum(), this.consultationEnteteGene.getCsgSerie(), var2);
                        if (var7 != null) {
                           long var8 = 100000000L * this.usersLog.getUsrid();

                           for(long var10 = 0L; var10 < var8; ++var10) {
                           }

                           this.consultationEnteteGene.setCsgNum(this.calculChrono.numCompose(this.consultationEnteteGene.getCsgDate(), this.nature, this.consultationEnteteGene.getCsgSerie(), var2));
                           var28 = false;
                        } else {
                           var28 = true;
                        }
                     }
                  }
               } else {
                  long var6 = this.consultationEnteteGeneDao.selectLastNum(var2);
                  this.consultationEnteteGene.setCsgNum("" + var6);
               }

               this.consultationEnteteGene.setExerciceventes(this.exercicesVentes);
               this.consultationEnteteGene.setPatients(this.patients);
               this.consultationEnteteGene.setCsgDateCreat(new Date());
               this.consultationEnteteGene.setCsgIdCreateur(this.usersLog.getUsrid());
               this.consultationEnteteGene.setCsgNomCreateur(this.usersLog.getUsrPatronyme());
               this.consultationEnteteGene.setCsgEtat(0);
               this.consultationEnteteGene.setCsgEtatVal(0);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.insert(this.consultationEnteteGene, var2);
               this.lesConsultationEntete.add(this.consultationEnteteGene);
               this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
               if (this.usersLog.getUsrVendeur() == 0) {
                  this.var_action = 1;
               } else if (this.usersLog.getUsrVendeur() == 1) {
                  this.var_action = 2;
               } else if (this.usersLog.getUsrVendeur() == 2) {
                  this.var_action = 3;
               }

               this.var_memo_action = this.var_action;
               this.simpleSelectionEntete.clear();
               this.extDTable = new HtmlExtendedDataTable();
            }
         } else if (this.lesActe.size() == 0) {
            this.formRecherche.setMessageTexte("Vous n'avez pas spécifié de produits. Veuillez cliquez sur l'onglet Actes et saisir au moins un acte.");
            this.formRecherche.setShowModalPanelMessage(true);
         } else {
            this.consultationEnteteGene.setCsgDateModif(new Date());
            this.consultationEnteteGene.setCsgIdModif(this.usersLog.getUsrid());
            this.consultationEnteteGene.setCsgNomModif(this.usersLog.getUsrPatronyme());
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var2);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var24) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         var4 = null;

         try {
            Transaction var26 = var2.beginTransaction();
            new ArrayList();
            new Rdv();
            RdvDao var29 = new RdvDao(this.baseLog, this.utilInitHibernate);
            String var31 = "";
            var31 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()) + "'";
            List var27 = var29.rechercheRdvRequete(var31, var2);
            Rdv var30;
            if (var27.size() != 0) {
               var30 = (Rdv)var27.get(0);
               var30.setRdvEtat(1);
               var30.setRdvDteExec(new Date());
               var30.setRdvCr("Effectué");
               var29.modif(var30, var2);
            }

            String var9;
            if (this.consultationEnteteGene.getCsgRdv() != null) {
               if (this.memoDateRdv != null) {
                  var31 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.memoDateRdv) + "'";
               } else {
                  var31 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgRdv()) + "'";
               }

               var27 = var29.rechercheRdvRequete(var31, var2);
               if (var27.size() != 0) {
                  if (this.memoDateRdv != null && !this.memoDateRdv.equals(this.consultationEnteteGene.getCsgRdv())) {
                     var30 = (Rdv)var27.get(0);
                     var30.setRdvDteDe(this.consultationEnteteGene.getCsgRdv());
                     var29.modif(var30, var2);
                  }
               } else {
                  var30 = new Rdv();
                  var30.setRdvCollaborateur((String)null);
                  var30.setRdvDateCreation(new Date());
                  var30.setRdvDescript((String)null);
                  var30.setRdvDteDe(this.consultationEnteteGene.getCsgRdv());
                  var30.setRdvEtat(0);
                  var30.setRdvHrDe("00");
                  var30.setRdvHrFi("00");
                  var30.setRdvLieu((String)null);
                  var30.setRdvMailContact((String)null);
                  var30.setRdvMnDe("00");
                  var30.setRdvMnFi("00");
                  var30.setRdvMode("Non renseigné");
                  var30.setRdvNature(1);
                  var9 = "";
                  if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                     var9 = this.patients.getPatNom() + " " + this.patients.getPatPrenom();
                  } else {
                     var9 = this.patients.getPatNom();
                  }

                  var30.setRdvNomPat(var9);
                  var30.setRdvNomUsers(this.usersLog.getUsrPatronyme());
                  var30.setRdvPatIdDe(this.patients.getPatId());
                  var30.setRdvService(this.usersLog.getUsrService());
                  var30.setRdvSujet("RDV suite CS");
                  var30.setRdvTache((String)null);
                  var30.setUsers(this.usersLog);
                  var29.insert(var30, var2);
               }

               this.memoDateRdv = this.consultationEnteteGene.getCsgRdv();
            }

            if (this.infirmerie && this.consultationInfirmerie != null && this.consultationInfirmerie.getCslaccDateRdv() != null) {
               if (this.memoDateRdv != null) {
                  var31 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.memoDateRdv) + "'";
               } else {
                  var31 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.consultationInfirmerie.getCslaccDateRdv()) + "'";
               }

               var27 = var29.rechercheRdvRequete(var31, var2);
               if (var27.size() != 0) {
                  if (this.memoDateRdv != null && !this.memoDateRdv.equals(this.consultationInfirmerie.getCslaccDateRdv())) {
                     var30 = (Rdv)var27.get(0);
                     var30.setRdvDteDe(this.consultationInfirmerie.getCslaccDateRdv());
                     var29.modif(var30, var2);
                  }
               } else {
                  var30 = new Rdv();
                  var30.setRdvCollaborateur((String)null);
                  var30.setRdvDateCreation(new Date());
                  var30.setRdvDescript((String)null);
                  var30.setRdvDteDe(this.consultationInfirmerie.getCslaccDateRdv());
                  var30.setRdvEtat(0);
                  var30.setRdvHrDe("00");
                  var30.setRdvHrFi("00");
                  var30.setRdvLieu((String)null);
                  var30.setRdvMailContact((String)null);
                  var30.setRdvMnDe("00");
                  var30.setRdvMnFi("00");
                  var30.setRdvMode("Non renseigné");
                  var30.setRdvNature(1);
                  var9 = "";
                  if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                     var9 = this.patients.getPatNom() + " " + this.patients.getPatPrenom();
                  } else {
                     var9 = this.patients.getPatNom();
                  }

                  var30.setRdvNomPat(var9);
                  var30.setRdvNomUsers(this.usersLog.getUsrPatronyme());
                  var30.setRdvPatIdDe(this.patients.getPatId());
                  var30.setRdvService(this.usersLog.getUsrService());
                  if (this.consultationInfirmerie.getCslaccType() == 1) {
                     var30.setRdvSujet("RDV Vaccin");
                  } else if (this.consultationInfirmerie.getCslaccType() == 2) {
                     var30.setRdvSujet("RDV Audiométrie");
                  }

                  var30.setRdvTache((String)null);
                  var30.setUsers(this.usersLog);
                  var29.insert(var30, var2);
               }

               this.memoDateRdv = this.consultationInfirmerie.getCslaccDateRdv();
            }

            var26.commit();
         } catch (HibernateException var22) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var22;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.usersChrono.getUsrchrValidation() == 4 && this.consultationEnteteGene.getCsgEtat() == 1 && this.consultationEnteteGene.getCsgTotPatient() != 0.0D) {
            if (this.usersLog.getUsrFactureCaisse() == 1 && this.var_tot_bon_encaissement == 0.0D) {
               this.payeDocumentBonEncaissement();
            } else if (this.usersLog.getUsrFactureCaisse() == 2 && this.consultationEnteteGene.getCsgRegPatient() != this.consultationEnteteGene.getCsgTotPatient()) {
               this.payeXDocumentRecu();
            } else if (this.usersLog.getUsrFactureCaisse() == 3) {
            }
         }
      }

      this.var_consultation_directe = false;
      this.visibleOnglet = true;
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.consultationEnteteGene.setCsgEtatVal(1);
         this.consultationEnteteGene.setCsgEtat(0);
         return true;
      } else {
         this.consultationEnteteGene.setCsgEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.consultationEnteteGene.setCsgEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2) {
               if (this.usersChrono.getUsrchrValidation() == 3) {
                  this.consultationEnteteGene.setCsgEtat(0);
               } else if (this.usersChrono.getUsrchrValidation() == 4) {
                  this.consultationEnteteGene.setCsgEtat(1);
               }
            }
         }

         return false;
      }
   }

   public void annuleSaisie() throws HibernateException, NamingException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      if (this.lesActe.size() == 0 && this.consultationEnteteGene.getCsgId() != 0L) {
         this.consultationEnteteGene.setCsgDateAnnule(new Date());
         this.consultationEnteteGene.setCsgEtat(3);
         this.consultationEnteteGene.setCsgMotifAnnule("ANNULATION SAISIE SUR AJOUT");
         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene);
         this.lesConsultationEntete.remove(this.consultationEnteteGene);
         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
      }

   }

   public void verifValideConsultation() throws HibernateException, NamingException {
      this.verifValideConsultation((Session)null);
   }

   public void verifValideConsultation(Session var1) throws HibernateException, NamingException {
      this.valideConsultation = false;
      this.medecinSpecialite = 0;
      if (this.consultationEnteteGene.getCsgIdPatient() != 0L) {
         if (this.optionMedical.getServiceCG().equals("0")) {
            if (this.consultationEnteteGene.getCsgService() != null && !this.consultationEnteteGene.getCsgService().isEmpty()) {
               if (this.optionMedical.getMedecinCG().equals("0")) {
                  if (this.var_nom_medecin != 0L) {
                     this.valideConsultation = true;
                  }
               } else {
                  this.valideConsultation = true;
               }
            }
         } else if (this.optionMedical.getMedecinCG().equals("0")) {
            if (this.var_nom_medecin != 0L) {
               this.valideConsultation = true;
            }
         } else {
            this.valideConsultation = true;
         }

         if (this.var_nom_medecin != 0L) {
            new Users();
            Users var2 = this.usersDao.selectUserD(this.var_nom_medecin, var1);
            if (var2 != null && var2.getUsrFonction() != null && !var2.getUsrFonction().isEmpty() && var2.getUsrFonction().equals("Dentiste")) {
               this.medecinSpecialite = 1;
            }
         }

         if (this.infirmerie && this.valideConsultation && (this.consultationEnteteGene.getCsgService() == null || this.consultationEnteteGene.getCsgService().isEmpty())) {
            this.valideConsultation = false;
         }
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.consultationEnteteGene.getCsgEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.consultationEnteteGene.setCsgEtat(1);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            if (this.infirmerie && this.lesPharmacie.size() != 0) {
               for(int var3 = 0; var3 < this.lesPharmacie.size(); ++var3) {
                  this.pharmacieLigne = (PharmacieLigne)this.lesPharmacie.get(var3);
                  if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty()) {
                     this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligProduit(), var1);
                     if (this.produits != null) {
                        this.calculStock.majPharmacie(this.pharmacieLigne, this.produits, 0.0F, 0, this.baseLog, var1);
                     }
                  }
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Validation manuelle consultation (M.) N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
            this.espionDao.mAJEspion(var9, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.consultationEnteteGene.getCsgEtat() == 1 && this.usersChrono.getUsrchrDeValidation() == 1) {
            this.consultationEnteteGene.setCsgEtat(0);
            this.consultationEnteteGene.setCsgDateImp((Date)null);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            new ArrayList();
            List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.consultationEnteteGene.getCsgId(), this.nature, var1);
            int var4;
            if (var3.size() != 0) {
               for(var4 = 0; var4 < var3.size(); ++var4) {
                  this.bonEncaissementVente = (BonEncaissementVente)var3.get(var4);
                  this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
               }
            }

            this.var_tot_bon_encaissement = 0.0D;
            if (this.infirmerie && this.lesPharmacie.size() != 0) {
               for(var4 = 0; var4 < this.lesPharmacie.size(); ++var4) {
                  this.pharmacieLigne = (PharmacieLigne)this.lesPharmacie.get(var4);
                  if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty()) {
                     this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligProduit(), var1);
                     if (this.produits != null) {
                        this.calculStock.majPharmacie(this.pharmacieLigne, this.produits, 0.0F, 1, this.baseLog, var1);
                     }
                  }
               }
            }

            Espion var10 = new Espion();
            var10.setUsers(this.usersLog);
            var10.setEsptype(0);
            var10.setEspdtecreat(new Date());
            var10.setEspaction("Dévalidation manuelle consultation (M.) N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
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

   public void annulerDocument() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.consultationEnteteGene.setCsgDateAnnule(new Date());
         this.mesCaissesSeriesItems.clear();
         if (this.listCaisses.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.listCaisses.size()) {
                  if (this.mesCaissesSeriesItems.size() != 0) {
                     this.var_inputCaisse = ((SelectItem)this.mesCaissesSeriesItems.get(0)).getValue().toString();
                  } else {
                     this.var_inputCaisse = "";
                  }
                  break;
               }

               if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.consultationEnteteGene.getCsgSerie())) {
                  String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
                  this.mesCaissesSeriesItems.add(new SelectItem(var2));
               }

               ++var1;
            }
         }

         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.consultationEnteteGene.getCsgDateAnnule() == null) {
               this.consultationEnteteGene.setCsgDateAnnule(new Date());
            }

            this.consultationEnteteGene.setCsgEtat(3);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), this.nature, var1);
            if (var3.size() != 0) {
               double var4 = 0.0D;

               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  this.reglements = (Reglements)var3.get(var6);
                  var4 = var4 + this.reglements.getRglRecette() - this.reglements.getRglDepense();
               }

               if (var4 != 0.0D) {
                  boolean var12 = false;
                  if (this.usersChrono.getUsrchrValidation() == 4) {
                     if (this.usersLog.getUsrFactureCaisse() == 1) {
                        var12 = this.majBonencaissementAnnulation(var4, this.consultationEnteteGene.getCsgDateAnnule(), var1);
                     } else if (this.usersLog.getUsrFactureCaisse() == 2) {
                        var12 = this.majReglementAnnulation(var4, this.consultationEnteteGene.getCsgDateAnnule(), var1);
                     } else if (this.usersLog.getUsrFactureCaisse() == 3) {
                        var12 = this.majBonencaissementAnnulation(var4, this.consultationEnteteGene.getCsgDateAnnule(), var1);
                     }
                  }

                  if (var12) {
                     this.lesConsultationEntete.remove(this.consultationEnteteGene);
                     this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
                  } else {
                     this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.consultationEnteteGene.getCsgId(), var1);
                     if (this.consultationEnteteGene != null) {
                        this.consultationEnteteGene.setCsgDateAnnule((Date)null);
                        this.consultationEnteteGene.setCsgEtat(1);
                        this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
                     }
                  }
               }
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
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public boolean majBonencaissementAnnulation(double var1, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if ((this.var_inputCaisse == null || this.var_inputCaisse.isEmpty()) && this.listCaisses.size() != 0) {
         for(int var6 = 0; var6 < this.listCaisses.size(); ++var6) {
            if (((UsersChrono)this.listCaisses.get(var6)).getUsrchrModeCaisse() <= 1) {
               this.var_inputCaisse = ((UsersChrono)this.listCaisses.get(var6)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var6)).getUsrchrLib();
               break;
            }
         }
      }

      String var8 = this.calculChrono.numCompose(new Date(), 79, this.consultationEnteteGene.getCsgSerie(), var4);
      if (var8 != null && !var8.isEmpty()) {
         this.bonEncaissementVente = new BonEncaissementVente();
         if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
            String[] var7 = this.var_inputCaisse.split(":");
            this.bonEncaissementVente.setBonCodeCaisse(var7[0]);
            this.bonEncaissementVente.setBonLibCaisse(var7[1]);
         } else {
            this.bonEncaissementVente.setBonCodeCaisse((String)null);
            this.bonEncaissementVente.setBonLibCaisse((String)null);
         }

         this.bonEncaissementVente.setBonTypeReg(0);
         this.bonEncaissementVente.setBonCodeBanq((String)null);
         this.bonEncaissementVente.setBonLibBanq((String)null);
         this.bonEncaissementVente.setBonBanqueTireur("");
         this.bonEncaissementVente.setBonNumChqBdx("");
         this.bonEncaissementVente.setBonDateCreat(new Date());
         this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
         this.bonEncaissementVente.setBonActivite(this.consultationEnteteGene.getCsgActivite());
         this.bonEncaissementVente.setBonSite("");
         this.bonEncaissementVente.setBonDepartement("");
         this.bonEncaissementVente.setBonService(this.consultationEnteteGene.getCsgService());
         this.bonEncaissementVente.setBonRegion("");
         this.bonEncaissementVente.setBonSecteur("");
         this.bonEncaissementVente.setBonPdv("");
         this.bonEncaissementVente.setBonDateEcheReg((Date)null);
         this.bonEncaissementVente.setBonEtat(0);
         this.bonEncaissementVente.setBonNatRef(this.nature);
         this.bonEncaissementVente.setBonNomTiers(this.consultationEnteteGene.getCsgNomPatient());
         this.bonEncaissementVente.setBonIdTiers(this.consultationEnteteGene.getPatients().getPatId());
         this.bonEncaissementVente.setBonNomContact("");
         this.bonEncaissementVente.setBonIdContact(0L);
         this.bonEncaissementVente.setBonTypeTiers(4);
         this.bonEncaissementVente.setBonLibelle("Annulation Règlement Consultation N° " + this.consultationEnteteGene.getCsgNum());
         this.bonEncaissementVente.setBonRef(this.consultationEnteteGene.getCsgNum());
         this.bonEncaissementVente.setBonIdRef(this.consultationEnteteGene.getCsgId());
         this.bonEncaissementVente.setBonObject(this.consultationEnteteGene.getCsgMotifAnnule());
         this.bonEncaissementVente.setBonObservation(this.consultationEnteteGene.getCsgMedecin());
         this.bonEncaissementVente.setBonSerie(this.consultationEnteteGene.getCsgSerie());
         this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
         this.bonEncaissementVente.setBonTotTtc(this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient());
         this.bonEncaissementVente.setBonAPayer(var1 * -1.0D);
         this.bonEncaissementVente.setBonActif(0);
         this.bonEncaissementVente.setBonNum(var8);
         this.bonEncaissementVente.setBonDate(var3);
         this.bonEncaissementVente.setBonIdResponsable(0L);
         this.bonEncaissementVente.setBonNomResponsable("");
         this.bonEncaissementVente.setBonIdCommercial(0L);
         this.bonEncaissementVente.setBonNomCommercial("");
         this.bonEncaissementVente.setBonIdEquipe(0L);
         this.bonEncaissementVente.setBonNomEquipe("");
         this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
         this.bonEncaissementVente.setBonClient("");
         this.bonEncaissementVente.setBonFacture("");
         this.bonEncaissementVente.setBonMontant("");
         this.bonEncaissementVente.setBonLettreGarantie("");
         this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var4);
         Espion var9 = new Espion();
         var9.setUsers(this.usersLog);
         var9.setEsptype(0);
         var9.setEspdtecreat(new Date());
         var9.setEspaction("Annulation consultation N° " + this.consultationEnteteGene.getCsgNum() + " pour " + this.consultationEnteteGene.getCsgMotifAnnule());
         this.espionDao.mAJEspion(var9, var4);
         var5 = true;
      } else {
         this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
         this.formRecherche.setShowModalPanelMessage(true);
         var5 = false;
      }

      return var5;
   }

   public boolean majReglementAnnulation(double var1, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (this.var_inputCaisse == null || this.var_inputCaisse.isEmpty()) {
         new ArrayList();
         List var6 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), 71, var4);
         if (var6.size() != 0) {
            this.var_inputCaisse = ((Reglements)var6.get(0)).getRglCodeCaiss() + ":" + ((Reglements)var6.get(0)).getRglLibCaiss();
         } else if (this.listCaisses.size() != 0) {
            for(int var7 = 0; var7 < this.listCaisses.size(); ++var7) {
               if (((UsersChrono)this.listCaisses.get(var7)).getUsrchrModeCaisse() <= 1) {
                  this.var_inputCaisse = ((UsersChrono)this.listCaisses.get(var7)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var7)).getUsrchrLib();
                  break;
               }
            }
         }
      }

      String var13 = this.calculChrono.numComposeCaisse(new Date(), 61, "0", this.consultationEnteteGene.getCsgSerie(), this.var_inputCaisse, var4);
      if (var13 != null && !var13.isEmpty()) {
         this.reglements = new Reglements();
         this.reglements.setRglOperation("03");
         this.reglements.setRglActivite(this.consultationEnteteGene.getCsgActivite());
         this.reglements.setRglBudget("");
         this.reglements.setRglBanqueTireur("");
         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(30);
         if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
            String[] var14 = this.var_inputCaisse.split(":");
            this.reglements.setRglCodeCaiss(var14[0]);
            this.reglements.setRglLibCaiss(var14[1]);
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
         }

         this.reglements.setRglCodeEmetrice((String)null);
         this.reglements.setRglLibEmetrice((String)null);
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDateReg(var3);
         this.reglements.setRglDepartement("");
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglDevise(this.structureLog.getStrdevise());
         this.reglements.setRglDossier("");
         this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
         this.reglements.setRglDocument(this.consultationEnteteGene.getCsgNum());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(this.consultationEnteteGene.getCsgId());
         this.reglements.setRglIdTiers(this.consultationEnteteGene.getPatients().getPatId());
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglLibelle(this.consultationEnteteGene.getCsgEntree());
         this.reglements.setRglMode("0");
         this.reglements.setRglModele("");
         this.reglements.setRglNatureDoc(71);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomTiers(this.consultationEnteteGene.getCsgNomPatient());
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
         this.reglements.setRglNum(var13);
         this.reglements.setRglNumChqBdx("");
         this.reglements.setRglObjet("Annulation Règlement Consultation N° " + this.consultationEnteteGene.getCsgNum());
         this.reglements.setRglParc("");
         this.reglements.setRglPdv("");
         this.reglements.setRglRecette(var1 * -1.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion("");
         this.reglements.setRglSecteur("");
         this.reglements.setRglSerie(this.consultationEnteteGene.getCsgSerie());
         this.reglements.setRglService(this.consultationEnteteGene.getCsgService());
         this.reglements.setRglSite("");
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeTiers(4);
         this.reglements.setRglTypeReg(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         this.reglements.setRglIdResponsable(0L);
         this.reglements.setRglNomResponsable("");
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

         String var8 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var15 + ":" + var8);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var9 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var9);
         new ExercicesCaisse();
         ExercicesCaisseDao var11 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         ExercicesCaisse var10 = var11.recupererLastExo(var4);
         this.reglements.setExercicesCaisse(var10);
         this.reglements = this.reglementsDao.insert(this.reglements, var4);
         Espion var12 = new Espion();
         var12.setUsers(this.usersLog);
         var12.setEsptype(0);
         var12.setEspdtecreat(new Date());
         var12.setEspaction("Annulation consultation N° " + this.consultationEnteteGene.getCsgNum() + " pour " + this.consultationEnteteGene.getCsgMotifAnnule());
         this.espionDao.mAJEspion(var12, var4);
         var5 = true;
      } else {
         this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
         this.formRecherche.setShowModalPanelMessage(true);
         var5 = false;
      }

      return var5;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.consultationEnteteGene.setCsgEtat(0);
            this.consultationEnteteGene.setCsgDateAnnule((Date)null);
            this.consultationEnteteGene.setCsgMotifAnnule("");
            this.consultationEnteteGene.setCsgRegPatient(this.consultationEnteteGene.getCsgTotPatient());
            this.consultationEnteteGene.setCsgRegTiers(this.consultationEnteteGene.getTotalTiers());
            this.consultationEnteteGene.setCsgSoldePatient(1);
            this.consultationEnteteGene.setCsgSoldeTiers(1);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), this.nature, var1);
            if (var3.size() != 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  this.reglements = (Reglements)var3.get(var4);
                  if (this.reglements.getRglRecette() < 0.0D) {
                     this.reglements.setRglDateReg(new Date());
                     String var5 = "";
                     if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                        var5 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                     } else {
                        var5 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                     }

                     String var6 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                     this.reglements.setRglPeriode(var5 + ":" + var6);
                     this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                     String var7 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                     this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var7);
                     this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                     this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var7);
                     this.reglementsDao.avoirReg(this.reglements, var1);
                  }
               }
            }

            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Réactivation consultation N° " + this.consultationEnteteGene.getCsgNum());
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
      }

   }

   public void changerService() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.nouveauService = "";
         this.nouveauMotif = "";
         this.nouveauMedecin = 0L;
         this.ancienMedecin = "";
         if (this.consultationEnteteGene.getCsgIdMedecin() != 0L) {
            new Users();
            Users var1 = this.usersDao.selectLeUserId(this.consultationEnteteGene.getCsgIdMedecin(), (Session)null);
            if (var1 != null) {
               this.ancienMedecin = var1.getUsrPatronyme();
            }
         }

         this.showModalPanelChangerService = true;
      }

   }

   public void annulerChangerService() {
      this.showModalPanelChangerService = false;
   }

   public void validerChangerService() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            boolean var3 = false;
            boolean var4 = false;
            boolean var5 = false;
            String var6 = this.consultationEnteteGene.getCsgService();
            String var7 = this.consultationEnteteGene.getCsgEntree();
            if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.consultationEnteteGene.getCsgService() == null || this.consultationEnteteGene.getCsgService().isEmpty() || !this.nouveauService.equals(this.consultationEnteteGene.getCsgService()))) {
               var3 = true;
            }

            if (this.nouveauMotif != null && !this.nouveauMotif.isEmpty() && (this.consultationEnteteGene.getCsgEntree() == null || this.consultationEnteteGene.getCsgEntree().isEmpty() || !this.nouveauMotif.equals(this.consultationEnteteGene.getCsgEntree()))) {
               var4 = true;
            }

            if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.consultationEnteteGene.getCsgIdMedecin()) {
               var5 = true;
            }

            if (var3 || var4 || var5) {
               if (var3) {
                  this.consultationEnteteGene.setCsgService(this.nouveauService);
               }

               if (var4) {
                  this.consultationEnteteGene.setCsgEntree(this.nouveauMotif);
               }

               if (var5) {
                  this.consultationEnteteGene.setCsgIdMedecin(this.nouveauMedecin);
               }

               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               if (var3) {
                  new ArrayList();
                  List var8 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), this.nature, var1);
                  if (var8.size() != 0) {
                     for(int var9 = 0; var9 < var8.size(); ++var9) {
                        this.reglements = (Reglements)var8.get(var9);
                        this.reglements.setRglService(this.nouveauService);
                        this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                     }
                  }

                  ConsultationReglementDao var20 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
                  new ArrayList();
                  List var10 = var20.selectReglementByEnt(this.consultationEnteteGene, var1);
                  if (var10.size() != 0) {
                     new ConsultationReglement();

                     for(int var12 = 0; var12 < var10.size(); ++var12) {
                        ConsultationReglement var11 = (ConsultationReglement)var10.get(var12);
                        var11.setCsgregService(this.nouveauService);
                        var20.modif(var11, var1);
                     }
                  }

                  Espion var23 = new Espion();
                  var23.setUsers(this.usersLog);
                  var23.setEsptype(0);
                  var23.setEspdtecreat(new Date());
                  var23.setEspaction("Chg service consultation (M.) N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()) + " du service " + var6 + " au service " + this.nouveauService);
                  this.espionDao.mAJEspion(var23, var1);
               }

               if (var4) {
                  Espion var18 = new Espion();
                  var18.setUsers(this.usersLog);
                  var18.setEsptype(0);
                  var18.setEspdtecreat(new Date());
                  var18.setEspaction("Chg motif consultation (M.) N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()) + " du motif " + var7 + " au motif " + this.nouveauMotif);
                  this.espionDao.mAJEspion(var18, var1);
               }

               if (var5) {
                  String var19 = "";
                  new Users();
                  Users var21 = this.usersDao.selectLeUserId(this.nouveauMedecin, var1);
                  if (var21 != null) {
                     var19 = var21.getUsrPatronyme();
                  }

                  Espion var22 = new Espion();
                  var22.setUsers(this.usersLog);
                  var22.setEsptype(0);
                  var22.setEspdtecreat(new Date());
                  var22.setEspaction("Chg médecin consultation (M.) N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()) + " du médecin " + this.ancienMedecin + " au médecin " + var19);
                  this.espionDao.mAJEspion(var22, var1);
               }
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

      this.showModalPanelChangerService = false;
   }

   public void ajouterAntecedent() throws IOException {
      this.patientAnt = new PatientAnt();
      this.var_antecedent = "";
      this.var_actionAntecedent = 1;
      this.patientAnt.setPatantDate(this.consultationEnteteGene.getCsgDate());
      this.patientAnt.setPatantMedecin(this.consultationEnteteGene.getCsgMedecin());
      this.showModalPanelAntecedent = true;
   }

   public void modifierAntecedent() {
      if (this.patientAnt.getPatantCode() != null && !this.patientAnt.getPatantCode().isEmpty()) {
         this.var_antecedent = this.patientAnt.getPatantCode() + ":" + this.patientAnt.getPatantFamille();
      } else {
         this.var_antecedent = "";
      }

      this.var_actionAntecedent = 2;
      this.showModalPanelAntecedent = true;
   }

   public void consulterAntecedent() {
      if (this.patientAnt.getPatantCode() != null && !this.patientAnt.getPatantCode().isEmpty()) {
         this.var_antecedent = this.patientAnt.getPatantCode() + ":" + this.patientAnt.getPatantFamille();
      } else {
         this.var_antecedent = "";
      }

      this.var_actionAntecedent = 3;
      this.showModalPanelAntecedent = true;
   }

   public void supprimerAntecedent() throws HibernateException, NamingException {
      this.patientAntDao.delete(this.patientAnt);
      this.elementPatient((Session)null);
      this.afficheButtAntecedent = false;
   }

   public void selectionAntecedent() {
      this.patientAnt = new PatientAnt();
      if (this.dataModelAntecedent.isRowAvailable()) {
         this.patientAnt = (PatientAnt)this.dataModelAntecedent.getRowData();
         this.afficheButtAntecedent = true;
      }

   }

   public void saveAntecedent() throws HibernateException, NamingException {
      if (this.var_antecedent != null && this.var_antecedent.contains(":")) {
         String[] var1 = this.var_antecedent.split(":");
         this.patientAnt.setPatantCode(var1[0]);
         this.patientAnt.setPatantFamille(var1[1]);
         if (this.patientAnt.getPatantId() == 0L) {
            this.patientAnt.setPatient(this.patients);
            this.patientAnt.setPatantNumConsultGene(this.consultationEnteteGene.getCsgNum());
            this.patientAnt = this.patientAntDao.insert(this.patientAnt);
            this.lesPatientAntecedent.add(this.patientAnt);
            this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
         } else {
            this.patientAnt = this.patientAntDao.modif(this.patientAnt);
         }
      }

      this.afficheButtAntecedent = false;
      this.showModalPanelAntecedent = false;
   }

   public void fermerAntecedent() {
      this.afficheButtAntecedent = false;
      this.showModalPanelAntecedent = false;
   }

   public void rechercheDiagnostic1() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag1() != null && !this.consultationEnteteGene.getCsgCodeDiag1().isEmpty()) {
         this.diagSelect = 1;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.cimMedical = new CimMedical();
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag1(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag1("");
      }

   }

   public void rechercheDiagnostic2() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag2() != null && !this.consultationEnteteGene.getCsgCodeDiag2().isEmpty()) {
         this.diagSelect = 2;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag2(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag2("");
      }

   }

   public void rechercheDiagnostic3() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag3() != null && !this.consultationEnteteGene.getCsgCodeDiag3().isEmpty()) {
         this.diagSelect = 3;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag3(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag3("");
      }

   }

   public void rechercheDiagnostic4() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag4() != null && !this.consultationEnteteGene.getCsgCodeDiag4().isEmpty()) {
         this.diagSelect = 4;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag4(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag4("");
      }

   }

   public void rechercheDiagnostic5() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag5() != null && !this.consultationEnteteGene.getCsgCodeDiag5().isEmpty()) {
         this.diagSelect = 5;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag5(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag5("");
      }

   }

   public void rechercheDiagnostic11() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag11() != null && !this.consultationEnteteGene.getCsgCodeDiag11().isEmpty()) {
         this.diagSelect = 11;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag11(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag11("");
      }

   }

   public void rechercheDiagnostic12() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgCodeDiag12() != null && !this.consultationEnteteGene.getCsgCodeDiag12().isEmpty()) {
         this.diagSelect = 12;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.consultationEnteteGene.getCsgCodeDiag12(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.consultationEnteteGene.setLib_diag12("");
      }

   }

   public void rechercheSuite() throws HibernateException, NamingException {
      if (this.recherche_cmd != null && !this.recherche_cmd.isEmpty() || this.recherche_diag != null && !this.recherche_diag.isEmpty()) {
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalSuite(this.recherche_cmd, this.recherche_diag, (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      }

   }

   public void selectionDiagnostic() {
      if (this.dataModelDiagnostic.isRowAvailable()) {
         this.cimMedical = (CimMedical)this.dataModelDiagnostic.getRowData();
      }

   }

   public void calculeDiagnostic() throws JDOMException, IOException {
      if (this.cimMedical != null) {
         if (this.diagSelect == 1) {
            this.consultationEnteteGene.setCsgCodeDiag1(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag1(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 2) {
            this.consultationEnteteGene.setCsgCodeDiag2(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag2(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 3) {
            this.consultationEnteteGene.setCsgCodeDiag3(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag3(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 4) {
            this.consultationEnteteGene.setCsgCodeDiag4(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag4(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 5) {
            this.consultationEnteteGene.setCsgCodeDiag5(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag5(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 11) {
            this.consultationEnteteGene.setCsgCodeDiag11(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag11(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 12) {
            this.consultationEnteteGene.setCsgCodeDiag12(this.cimMedical.getCimCode());
            this.consultationEnteteGene.setLib_diag12(this.cimMedical.getCimLibelleFR());
         }
      } else {
         this.annuleDiagostic();
      }

      this.showModalPaneldiagnostic = false;
   }

   public void annuleDiagostic() {
      if (this.diagSelect == 1) {
         this.consultationEnteteGene.setCsgCodeDiag1("");
         this.consultationEnteteGene.setLib_diag1("");
      } else if (this.diagSelect == 2) {
         this.consultationEnteteGene.setCsgCodeDiag2("");
         this.consultationEnteteGene.setLib_diag2("");
      } else if (this.diagSelect == 3) {
         this.consultationEnteteGene.setCsgCodeDiag3("");
         this.consultationEnteteGene.setLib_diag3("");
      } else if (this.diagSelect == 4) {
         this.consultationEnteteGene.setCsgCodeDiag4("");
         this.consultationEnteteGene.setLib_diag4("");
      } else if (this.diagSelect == 5) {
         this.consultationEnteteGene.setCsgCodeDiag5("");
         this.consultationEnteteGene.setLib_diag5("");
      } else if (this.diagSelect == 11) {
         this.consultationEnteteGene.setCsgCodeDiag11("");
         this.consultationEnteteGene.setLib_diag11("");
      } else if (this.diagSelect == 12) {
         this.consultationEnteteGene.setCsgCodeDiag12("");
         this.consultationEnteteGene.setLib_diag12("");
      }

      this.showModalPaneldiagnostic = false;
   }

   public void majRaccourciPersonnel() throws HibernateException, NamingException {
      if (this.cimMedical != null) {
         this.cimMedical = this.cimMedicalDao.modif(this.cimMedical);
      }

   }

   public void calculIcm() {
      if (this.consultationEnteteGene.getCsgPoids() != 0.0F && this.consultationEnteteGene.getCsgTaille() != 0.0F) {
         float var1 = this.consultationEnteteGene.getCsgPoids() / (this.consultationEnteteGene.getCsgTaille() * this.consultationEnteteGene.getCsgTaille()) * 10000.0F;
         this.consultationEnteteGene.setCsgImc(var1);
      }

   }

   public void ajouterActes() {
      this.ccamMedical = new CcamMedical();
      this.ngapMedical = new NgapMedical();
      this.produits = new Produits();
      this.consultationActes = new ConsultationActes();
      this.var_lettre = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.ajouterSurAvoir = false;
      if (this.lesActe.size() != 0) {
         for(int var1 = 0; var1 < this.lesActe.size(); ++var1) {
            if (((ConsultationActes)this.lesActe.get(var1)).getCslactTotal() < 0.0D) {
               this.ajouterSurAvoir = true;
               break;
            }
         }
      }

   }

   public void rechercheActes() throws HibernateException, NamingException {
      this.extDTableProduits = new HtmlExtendedDataTable();
      if (this.simpleSelectionProduits == null) {
         this.simpleSelectionProduits = new SimpleSelection();
      }

      this.simpleSelectionProduits.clear();
      this.choixPanenProd = 1;
      if (this.consultationActes.getCslactProduit() != null && !this.consultationActes.getCslactProduit().isEmpty()) {
         this.lesActesCCAM.clear();
         this.lesActesNGAP.clear();
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         if (this.optionMedical.getActePerso().equals("true")) {
            this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.consultationActes.getCslactProduit(), "1104", var1);
         }

         if (this.optionMedical.getActeCcam().equals("true")) {
            this.lesActesCCAM = this.ccamMedicalDao.selectallCcamMedicalActe(this.consultationActes.getCslactProduit(), var1);
         }

         if (this.optionMedical.getActeNgap().equals("true")) {
            this.lesActesNGAP = this.ngapMedicalDao.selectallNgapMedicalDetail(this.consultationActes.getCslactProduit(), var1);
         }

         if (this.lesActesCCAM.size() == 1 && this.lesActesNGAP.size() == 0 && this.lesProduits.size() == 0) {
            this.ccamMedical = (CcamMedical)this.lesActesCCAM.get(0);
            this.produits = new Produits();
            this.acteCCAM();
            this.valideActes(var1);
         } else if (this.lesActesCCAM.size() == 0 && this.lesActesNGAP.size() == 1 && this.lesProduits.size() == 0) {
            this.ngapMedical = (NgapMedical)this.lesActesNGAP.get(0);
            this.produits = new Produits();
            this.acteNGAP();
            this.valideActes(var1);
         } else if (this.lesActesCCAM.size() == 0 && this.lesActesNGAP.size() == 0 && this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.ccamMedical = new CcamMedical();
            this.actePerso();
            this.valideActes(var1);
         } else if (this.lesActesCCAM.size() <= 1 && this.lesActesNGAP.size() <= 1 && this.lesProduits.size() <= 1) {
            this.annuleActes();
         } else {
            this.ccamMedical = new CcamMedical();
            this.ngapMedical = new NgapMedical();
            this.produits = new Produits();
            this.typeActe = 9;
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.datamodelProduitsCCAM.setWrappedData(this.lesActesCCAM);
            this.datamodelProduitsNGAP.setWrappedData(this.lesActesNGAP);
            if (this.lesProduits.size() != 0) {
               this.afficheActeCP = true;
            } else {
               this.afficheActeCP = false;
            }

            if (this.lesActesCCAM.size() != 0) {
               this.afficheActeCCAM = true;
            } else {
               this.afficheActeCCAM = false;
            }

            if (this.lesActesNGAP.size() != 0) {
               this.afficheActeNGAP = true;
            } else {
               this.afficheActeNGAP = false;
            }

            this.showModalPanelListeActes = true;
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionActesCCAM() throws HibernateException, NamingException {
      if (this.extDTableCCAM != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionCCAM.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableCCAM.setRowKey(var3);
            if (this.extDTableCCAM.isRowAvailable()) {
               var1.add(this.extDTableCCAM.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.ccamMedical = (CcamMedical)var1.get(0);
            this.acteCCAM();
            this.var_lettre = "";
            this.ngapMedical = null;
            this.produits = null;
         }
      }

   }

   public void selectionActesNGAP() throws HibernateException, NamingException {
      if (this.extDTableNGAP != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionNGAP.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableNGAP.setRowKey(var3);
            if (this.extDTableNGAP.isRowAvailable()) {
               var1.add(this.extDTableNGAP.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.ngapMedical = (NgapMedical)var1.get(0);
            this.acteNGAP();
            this.var_lettre = "";
            this.ccamMedical = null;
            this.produits = null;
         }
      }

   }

   public void selectionActesCP() throws HibernateException, NamingException {
      if (this.extDTableProduits != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionProduits.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableProduits.setRowKey(var3);
            if (this.extDTableProduits.isRowAvailable()) {
               var1.add(this.extDTableProduits.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.produits = (Produits)var1.get(0);
            this.actePerso();
            this.var_lettre = "";
            this.ccamMedical = null;
            this.ngapMedical = null;
         }
      }

   }

   public void acteCCAM() {
      this.typeActe = 0;
      this.mesDentsItems.clear();
   }

   public void acteNGAP() {
      this.typeActe = 2;
      this.mesDentsItems.clear();
   }

   public void actePerso() {
      this.typeActe = 1;
      this.mesDentsItems.clear();
      if (!this.optionMedical.getDent().equals("0") && this.produits.getProMode() == 1) {
         int var1 = (int)this.patients.getAge();
         byte var2 = 0;
         float var3 = 12.0F;
         if (Float.parseFloat(this.optionMedical.getAnneeFinEnfant()) != 0.0F) {
            var3 = Float.parseFloat(this.optionMedical.getAnneeFinEnfant());
         }

         if ((float)var1 <= var3) {
            var2 = 1;
         }

         LectureDent var4 = new LectureDent(Integer.parseInt(this.optionMedical.getDent()), var2);
         this.mesDentsItems = var4.getMesElementsItems();
      }

   }

   public void valideActes() throws HibernateException, NamingException {
      this.valideActes((Session)null);
   }

   public void valideActes(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         boolean var2;
         ObjetCategories var3;
         int var4;
         if (this.typeActe == 0 && this.ccamMedical != null) {
            this.lesTarifs.clear();
            var2 = false;
            if (var1 == null) {
               var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
               var2 = true;
            }

            this.produits = this.produitsMedicDao.chargeProduit(this.ccamMedical.getCcamDetCode(), var1);
            if (this.produits == null) {
               if (var2) {
                  this.utilInitHibernate.closeSession();
               }

               this.produits = new Produits();
               this.produits.setProCode(this.ccamMedical.getCcamDetCode());
               if (this.ccamMedical.getCcamDetLibFr() != null && !this.ccamMedical.getCcamDetLibFr().isEmpty()) {
                  this.produits.setProLibClient(this.ccamMedical.getCcamDetLibFr().substring(0, this.ccamMedical.getCcamDetLibFr().length()).toUpperCase());
               }

               this.produits.setProVteCode((String)null);
               this.produits.setProVteNat((String)null);
               this.produits.setProVteTva((String)null);
               this.produits.setProLettre((String)null);
               new ObjetCategories();

               for(var4 = 0; var4 < this.lesCategoriesList.size(); ++var4) {
                  var3 = (ObjetCategories)this.lesCategoriesList.get(var4);
                  this.produitsTarif = new ProduitsTarif();
                  this.produitsTarif.setProtarClient(var3.getLibelle_FR());
                  this.produitsTarif.setProtarLettre("");
                  this.produitsTarif.setProtarOrdre(Integer.parseInt(var3.getCode()));
                  this.produitsTarif.setProtarCoef(var3.getCoef());
                  this.lesTarifs.add(this.produitsTarif);
               }

               this.lettreActe = null;
               this.showModalPanelCreationActe = true;
            } else {
               this.consultationActes.setCslactProduit(this.produits.getProCode());
               this.validesActesSuite(var1);
               if (var2) {
                  this.utilInitHibernate.closeSession();
               }
            }
         } else if (this.typeActe == 1 && this.produits != null) {
            this.consultationActes.setCslactProduit(this.produits.getProCode());
            this.validesActesSuite((Session)null);
         } else if (this.typeActe == 2 && this.ngapMedical != null) {
            this.lesTarifs.clear();
            var2 = false;
            if (var1 == null) {
               var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
               var2 = true;
            }

            this.produits = this.produitsMedicDao.chargeProduit(this.ccamMedical.getCcamDetCode(), var1);
            if (this.produits == null) {
               if (var2) {
                  this.utilInitHibernate.closeSession();
               }

               this.produits = new Produits();
               this.produits.setProCode(this.ngapMedical.getNgaDetCode());
               if (this.ngapMedical.getNgaDetLibelleFr() != null && !this.ngapMedical.getNgaDetLibelleFr().isEmpty()) {
                  this.produits.setProLibClient(this.ngapMedical.getNgaDetLibelleFr().substring(0, this.ngapMedical.getNgaDetLibelleFr().length()).toUpperCase());
               }

               this.produits.setProVteCode((String)null);
               this.produits.setProVteNat((String)null);
               this.produits.setProVteTva((String)null);
               this.produits.setProLettre((String)null);
               new ObjetCategories();

               for(var4 = 0; var4 < this.lesCategoriesList.size(); ++var4) {
                  var3 = (ObjetCategories)this.lesCategoriesList.get(var4);
                  this.produitsTarif = new ProduitsTarif();
                  this.produitsTarif.setProtarClient(var3.getLibelle_FR());
                  this.produitsTarif.setProtarLettre("");
                  this.produitsTarif.setProtarOrdre(Integer.parseInt(var3.getCode()));
                  this.produitsTarif.setProtarCoef(var3.getCoef());
                  this.lesTarifs.add(this.produitsTarif);
               }

               this.lettreActe = null;
               this.showModalPanelCreationActe = true;
            } else {
               this.consultationActes.setCslactProduit(this.produits.getProCode());
               this.validesActesSuite(var1);
               if (var2) {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

   }

   public void validesActesSuite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         var2 = true;
      }

      boolean var3 = true;
      if (this.optionMedical.getNbrJrGraceCG() != null && !this.optionMedical.getNbrJrGraceCG().isEmpty() && !this.optionMedical.getNbrJrGraceCG().equals("0") && this.produits != null && this.produits.getProGrace() == 1) {
         new ConsultationActes();
         ConsultationActes var4 = this.consultationActesDao.selectByGrace(this.consultationEnteteGene.getPatients().getPatId(), this.consultationEnteteGene.getCsgIdMedecin(), this.produits.getProCode(), Integer.parseInt(this.optionMedical.getNbrJrGraceCG()), var1);
         if (var4 != null) {
            this.formRecherche.setMessageTexte("Ce patient a déjà eu le même acte avec le même médecin le " + this.utilDate.dateToStringFrLg(var4.getConsultationEnteteGene().getCsgDate()) + "!");
            this.formRecherche.setShowModalPanelMessage(true);
            var3 = false;
         }
      }

      if (var3) {
         this.calculPrix(var1);
      } else {
         this.ajouterActes();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      this.var_aff_detail_prod = true;
      this.showModalPanelListeActes = false;
   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix((Session)null);
   }

   public void calculPrix(Session var1) throws HibernateException, NamingException {
      float var2 = 1.0F;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = this.consultationActes.getCslactPu();
      double var11 = this.consultationActes.getCslactPuCnamgs();
      double var13 = this.consultationActes.getCslactPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.consultationActes.getCslactProduit(), var1);
      if (this.produits != null) {
         this.consultationActes.setCslactProduit(this.produits.getProCode());
         this.consultationActes.setCslactLibelle(this.produits.getProLibClient());
         this.consultationActes.setCslactLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.consultationActes.setCslactLettre(this.produits.getProLettre());
         } else {
            this.consultationActes.setCslactLettre("");
            this.consultationActes.setCslactNb(0.0F);
            this.consultationActes.setCslactNbCnamgs(0.0F);
         }

         if (this.consultationActes.getCslactQte() == 0.0F) {
            this.consultationActes.setCslactQte(1.0F);
         }

         this.consultationActes.setCslactCodeTva(this.produits.getProVteTva());
         this.consultationActes.setCslactTauxTva(0.0F);
         if (this.consultationActes.getCslactCodeTva() != null && !this.consultationActes.getCslactCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.consultationActes.getCslactCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.consultationActes.setCslactTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.consultationEnteteGene.getLibelleFamille();
         int var17;
         if (var16.startsWith("Assuré") && this.optionMedical.getTarifSociete().equals("1")) {
            var16 = "Non Assuré";
         } else if (var16.startsWith("Assuré") && this.optionMedical.getTarifSociete().equals("2")) {
            var16 = "Assuré";

            for(var17 = 0; var17 < this.mesCategoriesItems.size(); ++var17) {
               if (Long.parseLong(((SelectItem)this.mesCategoriesItems.get(var17)).getValue().toString()) == this.nomFamille) {
                  if (((SelectItem)this.mesCategoriesItems.get(var17)).getLabel().toString().startsWith("Société")) {
                     var16 = "Société";
                  } else {
                     var16 = "Assuré";
                  }
                  break;
               }
            }
         } else if (var16.equals("Cas Social")) {
            var16 = "Non Assuré";
         } else if (var16.startsWith("Non Assuré") && this.var_pecCnamgs != 0.0F) {
            var16 = "CNAMGS";
         } else {
            var16 = "Non Assuré";
         }

         this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, var16, var1);
         if (this.produitsTarif != null) {
            var2 = this.produitsTarif.getProtarCoef();
            var3 = this.produitsTarif.getProtarPv();
            var5 = this.produitsTarif.getProtarPvCnamgs();
            this.consultationActes.setCslactNb(this.produitsTarif.getProtarNb());
            this.consultationActes.setCslactNbCnamgs(this.produitsTarif.getProtarNbCnamgs());
            this.consultationActes.setCslactValeur(this.produitsTarif.getProtarValeur());
            this.consultationActes.setCslactValeurCnamgs(this.produitsTarif.getProtarValeurCnamgs());
            if (var2 == 0.0F) {
               var2 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var17 = 0; var17 < this.lesCategoriesList.size(); ++var17) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.consultationEnteteGene.getLibelleFamille())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.consultationActes.setCslactCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.consultationActes.setCslactPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.consultationActes.setCslactPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.consultationActes.setCslactPuAssurance(var7);
            if (var7 == 0.0D) {
               boolean var21 = false;

               for(int var18 = 0; var18 < this.lesMotifEntree.size(); ++var18) {
                  if (this.consultationEnteteGene.getCsgEntree() != null && !this.consultationEnteteGene.getCsgEntree().isEmpty()) {
                     String var19 = "";
                     if (this.consultationEnteteGene.getCsgEntree().contains(":")) {
                        String[] var20 = this.consultationEnteteGene.getCsgEntree().split(":");
                        var19 = var20[0];
                     } else {
                        var19 = this.consultationEnteteGene.getCsgEntree();
                     }

                     if (var19.equals(((MotifEntreeMedical)this.lesMotifEntree.get(var18)).getMteCode()) && ((MotifEntreeMedical)this.lesMotifEntree.get(var18)).getMteConv() == 1 && var16.equals("Société")) {
                        var21 = true;
                        break;
                     }

                     if (var19.equals(((MotifEntreeMedical)this.lesMotifEntree.get(var18)).getMteCode()) && ((MotifEntreeMedical)this.lesMotifEntree.get(var18)).getMteConvAss() == 1 && var16.equals("Assuré")) {
                        var21 = true;
                        break;
                     }
                  }
               }

               if (this.consultationEnteteGene.getCsgFam() >= 1L && var21) {
                  this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 0, var1);
                  if (this.patientPec != null) {
                     this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.consultationActes.getCslactProduit(), var1);
                     if (this.conventionMedical != null) {
                        if (var16.equals("Société")) {
                           this.consultationActes.setCslactPu(this.conventionMedical.getCvnValeur());
                           this.consultationActes.setCslactPuAssurance(0.0D);
                        } else if (var16.equals("Assuré")) {
                           this.consultationActes.setCslactPuAssurance(this.conventionMedical.getCvnValeur());
                           if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                              this.consultationActes.setCslactPu(this.conventionMedical.getCvnValeurOrigine());
                           }
                        }
                     }
                  }
               } else if (this.consultationEnteteGene.getCsgFam() >= 1L && !var21) {
                  this.consultationActes.setCslactPuAssurance(var7);
                  this.consultationActes.setCslactPu(var3);
               }
            }
         } else {
            this.consultationActes.setCslactLettre("");
            this.consultationActes.setCslactNb(0.0F);
            this.consultationActes.setCslactNbCnamgs(0.0F);
            this.consultationActes.setCslactCoef(0.0F);
            this.consultationActes.setCslactValeur(0.0D);
            this.consultationActes.setCslactValeurCnamgs(0.0D);
            this.consultationActes.setCslactPu(var9);
            this.consultationActes.setCslactPuCnamgs(var11);
            this.consultationActes.setCslactPuAssurance(var13);
            if (this.consultationActes.getCslactQte() == 0.0F) {
               this.consultationActes.setCslactQte(1.0F);
            }
         }
      } else {
         this.consultationActes.setCslactLettre("");
         this.consultationActes.setCslactNb(0.0F);
         this.consultationActes.setCslactNbCnamgs(0.0F);
         this.consultationActes.setCslactCoef(0.0F);
         this.consultationActes.setCslactValeur(0.0D);
         this.consultationActes.setCslactValeurCnamgs(0.0D);
         this.consultationActes.setCslactPu(var9);
         this.consultationActes.setCslactPuCnamgs(var11);
         this.consultationActes.setCslactPuAssurance(var13);
         if (this.consultationActes.getCslactQte() == 0.0F) {
            this.consultationActes.setCslactQte(1.0F);
         }
      }

      if (this.var_pecCnamgs != 0.0F) {
         if (this.nomComplementaire != 0L) {
            this.avecCnamgsPriveComplementaire(var1);
         } else {
            this.avecCnamgsPrive(var1);
         }
      } else if (this.consultationEnteteGene.getCsgFam() != 0L && this.consultationEnteteGene.getCsgFam() != -1L) {
         this.sansCnamgsAssure(var1);
      } else {
         this.sansCnamgsPrive(var1);
      }

      if (var15) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void sansCnamgsAssure(Session var1) throws HibernateException, NamingException {
      double var2;
      if (this.consultationActes.getCslactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu() - var2);
         this.consultationActes.setCslactRabais(0.0D);
      } else {
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu());
      }

      this.consultationActes.setCslactTotal(this.consultationActes.getCslactPuRem() * (double)this.consultationActes.getCslactQte());
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var2 = this.consultationActes.getCslactTotal() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.consultationActes.setCslactTaxe(0.0D);
      }

      this.consultationActes.setCslactNbCnamgs(0.0F);
      this.consultationActes.setCslactValeurCnamgs(0.0D);
      this.consultationActes.setCslactPuCnamgs(0.0D);
      this.consultationActes.setCslactSocieteHt(0.0D);
      this.consultationActes.setCslactSocieteTaxe(0.0D);
      this.consultationActes.setCslactAssuranceHt(0.0D);
      this.consultationActes.setCslactAssuranceTaxe(0.0D);
      this.consultationActes.setCslactComplementaireHt(0.0D);
      this.consultationActes.setCslactComplementaireTaxe(0.0D);
      this.consultationActes.setCslactPatientHt(0.0D);
      this.consultationActes.setCslactPatientTaxe(0.0D);
      this.consultationEnteteGene.setCsgIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.consultationEnteteGene.getCsgIdSociete() != 0L && this.consultationEnteteGene.getCsgFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.consultationActes.getCslactTotal() * (double)this.patientPec.getPatpecSoins() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.consultationActes.setCslactSocieteHt(var2);
            } else {
               this.consultationActes.setCslactSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.consultationActes.getCslactTauxTva() != 0.0F) {
               var9 = this.consultationActes.getCslactSocieteHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
               this.consultationActes.setCslactSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.consultationEnteteGene.getCsgIdAssurance() != 0L && this.consultationEnteteGene.getCsgFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.consultationEnteteGene.setCsgIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.consultationActes.getCslactPuAssurance() == 0.0D) {
               this.consultationActes.setCslactPuAssurance(this.consultationActes.getCslactPu());
            }

            var4 = this.consultationActes.getCslactPuAssurance() * (double)this.consultationActes.getCslactQte() * (double)this.patientPec.getPatpecSoins() / 100.0D;
            if (this.consultationActes.getCslactRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.consultationActes.setCslactAssuranceHt(var4);
            } else {
               this.consultationActes.setCslactAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.consultationActes.getCslactTauxTva() != 0.0F) {
               var9 = this.consultationActes.getCslactAssuranceHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
               this.consultationActes.setCslactAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.consultationEnteteGene.getCsgIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactQte() * (double)this.patientPecComplementaire.getPatpecSoins() / 100.0D;
            if (this.consultationActes.getCslactRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.consultationActes.setCslactComplementaireHt(var6);
            } else {
               this.consultationActes.setCslactComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.consultationActes.getCslactTauxTva() != 0.0F) {
               var9 = this.consultationActes.getCslactComplementaireHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
               this.consultationActes.setCslactComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.consultationActes.getCslactRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
            this.consultationActes.setCslactPuRem((this.consultationActes.getCslactPu() - var11) * (double)var8);
         } else {
            this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu() * (double)var8);
         }

         this.consultationActes.setCslactTotal(this.consultationActes.getCslactPuRem() * (double)this.consultationActes.getCslactQte());
         if (this.consultationActes.getCslactTauxTva() != 0.0F) {
            var11 = this.consultationActes.getCslactTotal() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
            this.consultationActes.setCslactTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.consultationActes.setCslactTaxe(0.0D);
         }
      } else {
         var9 = this.consultationActes.getCslactTotal() - (var2 + var4 + var6);
         this.consultationActes.setCslactTotal(this.consultationActes.getCslactSocieteHt() + this.consultationActes.getCslactAssuranceHt() + this.consultationActes.getCslactComplementaireHt() + var9);
      }

      var11 = this.consultationActes.getCslactTotal() - (this.consultationActes.getCslactSocieteHt() + this.consultationActes.getCslactAssuranceHt() + this.consultationActes.getCslactComplementaireHt());
      if (this.consultationActes.getCslactRabais() != 0.0D) {
         this.consultationActes.setCslactPatientHt(var11 - this.consultationActes.getCslactRabais());
         this.consultationActes.setCslactRemise(0.0F);
         if (this.consultationActes.getCslactPatientHt() < 0.0D) {
            this.consultationActes.setCslactPatientHt(var11);
            this.consultationActes.setCslactRabais(0.0D);
         }
      } else {
         this.consultationActes.setCslactPatientHt(var11);
      }

      double var13;
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var13 = this.consultationActes.getCslactPatientHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.consultationActes.getCslactRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
            this.consultationActes.setCslactPuRem((this.consultationActes.getCslactPu() - var13) * (double)var8);
         } else {
            this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu() * (double)var8);
         }

         this.consultationActes.setCslactTotal(this.consultationActes.getCslactPuRem() * (double)this.consultationActes.getCslactQte());
         var13 = this.consultationActes.getCslactAssuranceHt() + this.consultationActes.getCslactComplementaireHt() + this.consultationActes.getCslactSocieteHt() + this.consultationActes.getCslactPatientHt();
         double var15 = this.consultationActes.getCslactTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 != 0.0D) {
               this.consultationActes.setCslactAssuranceHt(this.consultationActes.getCslactAssuranceHt() + var15);
            } else if (var2 != 0.0D) {
               this.consultationActes.setCslactSocieteHt(this.consultationActes.getCslactSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.consultationActes.setCslactComplementaireHt(this.consultationActes.getCslactComplementaireHt() + var15);
            }
         }
      }

   }

   public void sansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.consultationActes.setCslactRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.consultationActes.getCslactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu() - var2);
         this.consultationActes.setCslactRabais(0.0D);
      } else {
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu());
      }

      this.consultationActes.setCslactTotal(this.consultationActes.getCslactPuRem() * (double)this.consultationActes.getCslactQte());
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var2 = this.consultationActes.getCslactTotal() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.consultationActes.setCslactTaxe(0.0D);
      }

      this.consultationActes.setCslactNbCnamgs(0.0F);
      this.consultationActes.setCslactValeurCnamgs(0.0D);
      this.consultationActes.setCslactPuCnamgs(0.0D);
      this.consultationActes.setCslactPuAssurance(0.0D);
      this.consultationActes.setCslactSocieteHt(0.0D);
      this.consultationActes.setCslactSocieteTaxe(0.0D);
      this.consultationActes.setCslactAssuranceHt(0.0D);
      this.consultationActes.setCslactAssuranceTaxe(0.0D);
      this.consultationActes.setCslactComplementaireHt(0.0D);
      this.consultationActes.setCslactComplementaireTaxe(0.0D);
      this.consultationActes.setCslactPatientHt(0.0D);
      this.consultationActes.setCslactPatientTaxe(0.0D);
      this.consultationEnteteGene.setCsgIdEmployeur(0L);
      var2 = this.consultationActes.getCslactTotal();
      if (this.consultationActes.getCslactRabais() != 0.0D) {
         this.consultationActes.setCslactPatientHt(var2 - this.consultationActes.getCslactRabais());
         this.consultationActes.setCslactRemise(0.0F);
         if (this.consultationActes.getCslactPatientHt() < 0.0D) {
            this.consultationActes.setCslactPatientHt(var2);
            this.consultationActes.setCslactRabais(0.0D);
         }
      } else {
         this.consultationActes.setCslactPatientHt(var2);
      }

      if (this.consultationActes.getCslactTaxe() != 0.0D) {
         double var4 = this.consultationActes.getCslactPatientHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.consultationActes.setCslactPatientTaxe(0.0D);
      }

   }

   public void avecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.consultationActes.getCslactPuCnamgs() > this.consultationActes.getCslactPu()) {
         this.consultationActes.setCslactPu(this.consultationActes.getCslactPuCnamgs());
      }

      double var2;
      double var4;
      if (this.consultationActes.getCslactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPuCnamgs() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.consultationActes.setCslactPuCnamgs(this.consultationActes.getCslactPuCnamgs() - var4);
         this.consultationActes.setCslactRabais(0.0D);
      } else {
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu());
      }

      this.consultationActes.setCslactTotal(this.consultationActes.getCslactPuRem() * (double)this.consultationActes.getCslactQte());
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var2 = this.consultationActes.getCslactTotal() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.consultationActes.setCslactTaxe(0.0D);
      }

      this.consultationActes.setCslactPuAssurance(0.0D);
      this.consultationActes.setCslactSocieteHt(0.0D);
      this.consultationActes.setCslactSocieteTaxe(0.0D);
      this.consultationActes.setCslactAssuranceHt(0.0D);
      this.consultationActes.setCslactAssuranceTaxe(0.0D);
      this.consultationActes.setCslactComplementaireHt(0.0D);
      this.consultationActes.setCslactComplementaireTaxe(0.0D);
      this.consultationActes.setCslactPatientHt(0.0D);
      this.consultationActes.setCslactPatientTaxe(0.0D);
      this.consultationEnteteGene.setCsgIdEmployeur(0L);
      this.consultationActes.setCslactAssuranceHt(this.consultationActes.getCslactPuCnamgs() * (double)this.consultationActes.getCslactQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var2 = this.consultationActes.getCslactAssuranceHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.consultationActes.getCslactTotal() - this.consultationActes.getCslactAssuranceHt();
      if (this.consultationActes.getCslactRabais() != 0.0D) {
         this.consultationActes.setCslactPatientHt(var2 - this.consultationActes.getCslactRabais());
         this.consultationActes.setCslactRemise(0.0F);
         if (this.consultationActes.getCslactPatientHt() < 0.0D) {
            this.consultationActes.setCslactPatientHt(var2);
            this.consultationActes.setCslactRabais(0.0D);
         }
      } else {
         this.consultationActes.setCslactPatientHt(var2);
      }

      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var4 = this.consultationActes.getCslactPatientHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void avecCnamgsPriveComplementaire(Session var1) throws HibernateException, NamingException {
      if (this.consultationActes.getCslactPuCnamgs() > this.consultationActes.getCslactPu()) {
         this.consultationActes.setCslactPu(this.consultationActes.getCslactPuCnamgs());
      }

      double var2;
      double var4;
      if (this.consultationActes.getCslactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPu() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.consultationActes.getCslactPuCnamgs() * (double)this.consultationActes.getCslactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.consultationActes.setCslactPuCnamgs(this.consultationActes.getCslactPuCnamgs() - var4);
         this.consultationActes.setCslactRabais(0.0D);
      } else {
         this.consultationActes.setCslactPuRem(this.consultationActes.getCslactPu());
      }

      this.consultationActes.setCslactTotal(this.consultationActes.getCslactPuRem() * (double)this.consultationActes.getCslactQte());
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var2 = this.consultationActes.getCslactTotal() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.consultationActes.setCslactTaxe(0.0D);
      }

      this.consultationActes.setCslactPuAssurance(0.0D);
      this.consultationActes.setCslactSocieteHt(0.0D);
      this.consultationActes.setCslactSocieteTaxe(0.0D);
      this.consultationActes.setCslactAssuranceHt(0.0D);
      this.consultationActes.setCslactAssuranceTaxe(0.0D);
      this.consultationActes.setCslactComplementaireHt(0.0D);
      this.consultationActes.setCslactComplementaireTaxe(0.0D);
      this.consultationActes.setCslactPatientHt(0.0D);
      this.consultationActes.setCslactPatientTaxe(0.0D);
      this.consultationEnteteGene.setCsgIdEmployeur(0L);
      var2 = 0.0D;
      this.consultationActes.setCslactAssuranceHt(this.consultationActes.getCslactPuCnamgs() * (double)this.consultationActes.getCslactQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         var4 = this.consultationActes.getCslactAssuranceHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactAssuranceTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

      this.consultationEnteteGene.setCsgComplementaire(this.nomComplementaire);
      if (this.consultationEnteteGene.getCsgComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            this.consultationEnteteGene.setCsgIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
            var2 = this.consultationActes.getCslactTotal() - this.consultationActes.getCslactAssuranceHt();
            this.consultationActes.setCslactComplementaireHt(var2);
            if (this.consultationActes.getCslactTauxTva() != 0.0F) {
               var4 = this.consultationActes.getCslactComplementaireHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
               this.consultationActes.setCslactComplementaireTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
            }
         }
      }

      var4 = this.consultationActes.getCslactTotal() - this.consultationActes.getCslactAssuranceHt() - this.consultationActes.getCslactComplementaireHt();
      if (this.consultationActes.getCslactRabais() != 0.0D) {
         this.consultationActes.setCslactPatientHt(var4 - this.consultationActes.getCslactRabais());
         this.consultationActes.setCslactRemise(0.0F);
         if (this.consultationActes.getCslactPatientHt() < 0.0D) {
            this.consultationActes.setCslactPatientHt(var4);
            this.consultationActes.setCslactRabais(0.0D);
         }
      } else {
         this.consultationActes.setCslactPatientHt(var4);
      }

      if (this.consultationActes.getCslactTauxTva() != 0.0F) {
         double var6 = this.consultationActes.getCslactPatientHt() * (double)this.consultationActes.getCslactTauxTva() / 100.0D;
         this.consultationActes.setCslactPatientTaxe(this.utilNombre.myRoundDevise(var6, this.structureLog.getStrdevise()));
      }

   }

   public void selectionActeListe() throws HibernateException, NamingException {
      this.var_aff_detail_prod = false;
      this.var_lettre = "";
      if (this.dataModelActe.isRowAvailable()) {
         this.consultationActes = (ConsultationActes)this.dataModelActe.getRowData();
         if (this.consultationActes.getCslactLettre() != null && !this.consultationActes.getCslactLettre().isEmpty()) {
            this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.consultationActes.getCslactLettre(), (Session)null);
            if (this.lettreMedical != null) {
               this.var_lettre = this.consultationActes.getCslactLettre() + ":" + this.lettreMedical.getLetLibelleFr();
            }
         }

         if (!this.optionMedical.getDent().equals("0") && this.consultationActes.getCslactDent() != null && !this.consultationActes.getCslactDent().isEmpty()) {
            int var1 = (int)this.patients.getAge();
            byte var2 = 0;
            float var3 = 12.0F;
            if (Float.parseFloat(this.optionMedical.getAnneeFinEnfant()) != 0.0F) {
               var3 = Float.parseFloat(this.optionMedical.getAnneeFinEnfant());
            }

            if ((float)var1 <= var3) {
               var2 = 1;
            }

            LectureDent var4 = new LectureDent(Integer.parseInt(this.optionMedical.getDent()), var2);
            this.mesDentsItems = var4.getMesElementsItems();
            this.produits = new Produits();
            this.produits.setProMode(1);
         }

         this.var_aff_detail_prod = true;
         this.afficheButtActes = true;
         this.ajouterSurAvoir = false;
      }

   }

   public void annuleActes() {
      this.ccamMedical = new CcamMedical();
      this.ngapMedical = new NgapMedical();
      this.produits = new Produits();
      this.consultationActes = new ConsultationActes();
      this.var_lettre = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.showModalPanelListeActes = false;
   }

   public void supprimerActe() throws HibernateException, NamingException {
      if (this.consultationActes != null) {
         this.consultationActesDao.delete(this.consultationActes);
         this.lesActe.remove(this.consultationActes);
         this.dataModelActe.setWrappedData(this.lesActe);
         this.calculTotaux();
         this.consultationEnteteGeneDao.modif(this.consultationEnteteGene);
         this.ajouterActes();
         this.var_aff_detail_prod = false;
         this.afficheButtActes = false;
      }

   }

   public void calculeFamille() throws HibernateException, NamingException {
      if (this.inpCodeFamille != null && !this.inpCodeFamille.isEmpty() && this.inpCodeFamille.contains(":")) {
         String[] var1 = this.inpCodeFamille.split(":");
         new FamillesProduitsVentes();
         FamillesProduitsVentesDao var3 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         FamillesProduitsVentes var2 = var3.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), var1[0], (Session)null);
         if (var2 != null) {
            this.produits.setProVteCode(var2.getFamvteCode());
            this.produits.setProVteLib(var2.getFamvteLibelleFr());
            this.produits.setProVteNat(var2.getFamvteNature());
            this.produits.setProVteTva(var2.getFamvteTaxe());
         } else {
            this.produits.setProVteCode((String)null);
            this.produits.setProVteLib("");
            this.produits.setProVteNat("");
            this.produits.setProVteTva("");
         }
      } else {
         this.produits.setProVteCode((String)null);
         this.produits.setProVteLib("");
         this.produits.setProVteNat("");
         this.produits.setProVteTva("");
      }

   }

   public void calculeTarif() throws HibernateException, NamingException {
      double var1 = 0.0D;
      if (this.lettreActe != null && !this.lettreActe.isEmpty() && this.lettreActe.contains(":")) {
         String[] var3 = this.lettreActe.split(":");
         this.produits.setProLettre(var3[0]);
         this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.produits.getProLettre(), (Session)null);
         if (this.lettreMedical != null) {
            var1 = this.lettreMedical.getLetValeur();
         }

         for(int var4 = 0; var4 < this.lesTarifs.size(); ++var4) {
            this.produitsTarif = (ProduitsTarif)this.lesTarifs.get(var4);
            this.produitsTarif.setProtarLettre(this.produits.getProLettre());
            this.produitsTarif.setProtarValeur(var1);
            this.produitsTarif.setProtarNb(this.produits.getProNbUnite());
            double var5 = var1 * (double)this.produitsTarif.getProtarNb() * (double)this.produitsTarif.getProtarCoef();
            this.produitsTarif.setProtarPv(var5);
         }
      } else {
         this.lettreActe = null;
      }

   }

   public void validesProduit() throws HibernateException, NamingException {
      this.showModalPanelCreationActe = false;
      this.calculeTarif();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.produits = this.produitsMedicDao.insert(this.produits, var1);
         var1.flush();
         if (this.lesTarifs.size() != 0) {
            for(int var3 = 0; var3 < this.lesTarifs.size(); ++var3) {
               this.produitsTarif = (ProduitsTarif)this.lesTarifs.get(var3);
               this.produitsTarif.setProduits(this.produits);
               if (this.produitsTarif.getProtarOrdre() == 0) {
                  this.produitsTarif.setProtarOrdre(var3 + 1);
               }

               this.produitsTarifDao.insert(this.produitsTarif, var1);
            }
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

      this.consultationActes.setCslactProduit(this.produits.getProCode());
      this.validesActesSuite((Session)null);
   }

   public void fermerValidesProduit() {
      this.showModalPanelCreationActe = false;
   }

   public void saveActe() throws HibernateException, NamingException {
      if (this.consultationActes.getCslactQte() != 0.0F && this.consultationActes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.tarifPatient(var1);
            this.calculPrix(var1);
            if (this.consultationActes.getCslactId() == 0L) {
               this.consultationActes.setConsultationEnteteGene(this.consultationEnteteGene);
               this.consultationActes = this.consultationActesDao.insert(this.consultationActes, var1);
               this.lesActe.add(this.consultationActes);
               this.dataModelActe.setWrappedData(this.lesActe);
            } else {
               this.consultationActes = this.consultationActesDao.modif(this.consultationActes, var1);
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

      this.ajouterActes();
      this.calculTotaux();
   }

   public void changerTarif() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.tarifPatient(var1);
         if (this.consultationEnteteGene.getCsgId() != 0L) {
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            if (this.lesActe.size() != 0) {
               for(int var3 = 0; var3 < this.lesActe.size(); ++var3) {
                  this.consultationActes = (ConsultationActes)this.lesActe.get(var3);
                  this.calculPrix(var1);
                  this.consultationActes = this.consultationActesDao.modif(this.consultationActes, var1);
               }
            }
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

      this.calculTotaux();
      this.ajouterActes();
   }

   public void tarifPatient(Session var1) throws HibernateException, NamingException {
      this.var_pecAssurance = false;
      this.consultationEnteteGene.setCsgFam(this.nomFamille);
      this.consultationEnteteGene.setCsgComplementaire(this.nomComplementaire);
      if (this.nomFamille >= 1L) {
         this.var_pecCnamgs = 0.0F;
         this.consultationEnteteGene.setCsgIdSociete(0L);
         this.consultationEnteteGene.setCsgIdAssurance(0L);
         this.consultationEnteteGene.setCsgIdComplementaire(0L);
         this.consultationEnteteGene.setCsgNomSociete("");
         this.consultationEnteteGene.setCsgNomAssurance("");
         this.consultationEnteteGene.setCsgNomComplemtaire("");
         this.consultationEnteteGene.setCsgIdEmployeur(0L);
         this.consultationEnteteGene.setCsgMatricule("");
         this.consultationEnteteGene.setCsgContratAssurance("");
         this.consultationEnteteGene.setCsgContratComplementaire("");
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 0, var1);
         }

         if (this.patientPec != null) {
            if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
               if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("Mutuelle/Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                  this.consultationEnteteGene.setCsgIdSociete(this.patientPec.getTiers().getTieid());
                  this.consultationEnteteGene.setCsgNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.consultationEnteteGene.setCsgMatricule(this.patientPec.getPatpecMatricule());
               } else {
                  this.var_pecAssurance = true;
                  this.consultationEnteteGene.setCsgIdAssurance(this.patientPec.getTiers().getTieid());
                  this.consultationEnteteGene.setCsgNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.consultationEnteteGene.setCsgIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                  this.consultationEnteteGene.setCsgContratAssurance(this.patientPec.getPatpecNumContrat());
               }
            }
         } else {
            this.consultationEnteteGene.setCsgFam(0L);
         }

         if (this.nomComplementaire >= 1L) {
            if (this.patientPecComplementaire == null) {
               this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.nomComplementaire, 0, var1);
            }

            if (this.patientPecComplementaire != null) {
               if (this.patientPecComplementaire.getPatpecType() != null && !this.patientPecComplementaire.getPatpecType().isEmpty() && (this.patientPecComplementaire.getPatpecType().equals("Mutuelle") || this.patientPecComplementaire.getPatpecType().equals("Complémentaire"))) {
                  this.consultationEnteteGene.setCsgIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
                  this.consultationEnteteGene.setCsgNomComplemtaire(this.patientPecComplementaire.getTiers().getTieraisonsocialenom());
                  this.consultationEnteteGene.setCsgContratComplementaire(this.patientPecComplementaire.getPatpecNumContrat());
               }
            } else {
               this.consultationEnteteGene.setCsgComplementaire(0L);
            }
         }
      } else if (this.nomFamille == -1L) {
         this.consultationEnteteGene.setCsgComplementaire(0L);
         this.consultationEnteteGene.setCsgIdSociete(0L);
         this.consultationEnteteGene.setCsgIdAssurance(0L);
         this.consultationEnteteGene.setCsgIdComplementaire(0L);
         this.consultationEnteteGene.setCsgNomSociete("");
         this.consultationEnteteGene.setCsgNomAssurance("");
         this.consultationEnteteGene.setCsgNomComplemtaire("");
         this.consultationEnteteGene.setCsgIdEmployeur(0L);
         this.consultationEnteteGene.setCsgMatricule("");
         this.consultationEnteteGene.setCsgContratAssurance("");
         this.consultationEnteteGene.setCsgContratComplementaire("");
      }

   }

   public void avoirLigne() throws HibernateException, NamingException {
      if (this.consultationActes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            ConsultationActes var3 = new ConsultationActes();
            var3.setConsultationEnteteGene(this.consultationEnteteGene);
            var3.setCslactAssuranceHt(this.consultationActes.getCslactAssuranceHt() * -1.0D);
            var3.setCslactAssuranceTaxe(this.consultationActes.getCslactAssuranceTaxe() * -1.0D);
            var3.setCslactCodeTva(this.consultationActes.getCslactCodeTva());
            var3.setCslactCoef(this.consultationActes.getCslactCoef());
            var3.setCslactComplementaireHt(this.consultationActes.getCslactComplementaireHt() * -1.0D);
            var3.setCslactComplementaireTaxe(this.consultationActes.getCslactComplementaireTaxe() * -1.0D);
            var3.setCslactLettre(this.consultationActes.getCslactLettre());
            var3.setCslactLibelle(this.consultationActes.getCslactLibelle());
            var3.setCslactNb(this.consultationActes.getCslactNb());
            var3.setCslactNbCnamgs(this.consultationActes.getCslactNbCnamgs());
            var3.setCslactPatientHt(this.consultationActes.getCslactPatientHt() * -1.0D);
            var3.setCslactPatientTaxe(this.consultationActes.getCslactPatientTaxe() * -1.0D);
            var3.setCslactProduit(this.consultationActes.getCslactProduit());
            var3.setCslactPu(this.consultationActes.getCslactPu());
            var3.setCslactPuAssurance(this.consultationActes.getCslactPuAssurance());
            var3.setCslactPuCnamgs(this.consultationActes.getCslactPuCnamgs());
            var3.setCslactPuRem(this.consultationActes.getCslactPuRem());
            var3.setCslactQte(this.consultationActes.getCslactQte() * -1.0F);
            var3.setCslactRegPatient(0.0D);
            var3.setCslactRegTiers(0.0D);
            var3.setCslactRemise(this.consultationActes.getCslactRemise());
            var3.setCslactSocieteHt(this.consultationActes.getCslactSocieteHt() * -1.0D);
            var3.setCslactSocieteTaxe(this.consultationActes.getCslactSocieteTaxe() * -1.0D);
            var3.setCslactTauxTva(this.consultationActes.getCslactTauxTva());
            var3.setCslactTaxe(this.consultationActes.getCslactTaxe() * -1.0D);
            var3.setCslactTotal(this.consultationActes.getCslactTotal() * -1.0D);
            var3.setCslactValeur(this.consultationActes.getCslactValeur());
            var3.setCslactValeurCnamgs(this.consultationActes.getCslactValeurCnamgs());
            this.consultationActes = new ConsultationActes();
            this.consultationActes = var3;
            this.consultationActes = this.consultationActesDao.insert(this.consultationActes, var1);
            this.lesActe.add(this.consultationActes);
            this.dataModelActe.setWrappedData(this.lesActe);
            this.calculTotaux();
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            double var4 = this.consultationActes.getCslactPatientHt() + this.consultationActes.getCslactPatientTaxe();
            if (var4 != 0.0D) {
               boolean var6 = false;
               if (this.usersChrono.getUsrchrValidation() == 4) {
                  if (this.usersLog.getUsrFactureCaisse() == 1) {
                     var6 = this.majBonencaissementAnnulation(Math.abs(var4), this.consultationEnteteGene.getCsgDate(), var1);
                  } else if (this.usersLog.getUsrFactureCaisse() == 2) {
                     var6 = this.majReglementAnnulation(Math.abs(var4), this.consultationEnteteGene.getCsgDate(), var1);
                  } else if (this.usersLog.getUsrFactureCaisse() == 3) {
                     var6 = this.majBonencaissementAnnulation(Math.abs(var4), this.consultationEnteteGene.getCsgDate(), var1);
                  }
               }

               if (!var6) {
                  this.consultationActesDao.delete(this.consultationActes, var1);
                  this.lesActe.remove(this.consultationActes);
                  this.dataModelActe.setWrappedData(this.lesActe);
                  this.calculTotaux();
                  this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.consultationEnteteGene.getCsgId(), var1);
                  if (this.consultationEnteteGene != null) {
                     this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
                  }
               }
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

         this.ajouterActes();
         this.ajouterSurAvoir = true;
      }

   }

   public void consulterTarif() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.tarifPatient((Session)null);
         if (this.consultationEnteteGene.getCsgIdSociete() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.consultationEnteteGene.getCsgIdSociete(), (Session)null);
            if (this.patientPec != null) {
               this.showModalpanelPec = true;
            }
         } else if (this.consultationEnteteGene.getCsgIdAssurance() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.consultationEnteteGene.getCsgIdAssurance(), (Session)null);
            if (this.patientPec != null) {
               if (this.consultationEnteteGene.getCsgIdComplementaire() != 0L) {
                  this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.patients, this.consultationEnteteGene.getCsgIdComplementaire(), (Session)null);
               }

               this.showModalpanelPec = true;
            }
         }
      }

   }

   public void fermerConsulterTarif() {
      this.showModalpanelPec = false;
   }

   public void ajouterMedicamment() {
      this.produitsMedicamment = new ProduitsMedicamment();
      this.consultationOrdo = new ConsultationOrdo();
      this.var_aff_detail_ordo = false;
      this.afficheButtOrdo = false;
   }

   public void selectionMedicammentListe() {
      this.var_aff_detail_ordo = false;
      if (this.dataModelOrdonnance.isRowAvailable()) {
         this.consultationOrdo = (ConsultationOrdo)this.dataModelOrdonnance.getRowData();
         this.var_aff_detail_ordo = true;
         this.afficheButtOrdo = true;
      }

   }

   public void supprimerMedicamment() throws HibernateException, NamingException {
      if (this.consultationOrdo != null) {
         this.consultationOrdoDao.delete(this.consultationOrdo);
         this.lesOrdonnance.remove(this.consultationOrdo);
         this.dataModelOrdonnance.setWrappedData(this.lesOrdonnance);
         this.var_aff_detail_ordo = false;
         this.afficheButtOrdo = false;
      }

   }

   public void detailDci() throws HibernateException, NamingException {
      Session var1;
      if (this.consultationOrdo.getCslordDci() != null && !this.consultationOrdo.getCslordDci().isEmpty()) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         this.produitsDci = this.produitsMedicammentDao.rechercheDci(this.consultationOrdo.getCslordDci(), var1);
         this.produitsMedicamment = this.produitsMedicammentDao.rechercheSpecialite(this.consultationOrdo.getCslordLibelle(), var1);
         this.showModalPanelMedicammentDci = true;
         this.utilInitHibernate.closeSession();
      } else if (this.produitsMedicamment != null && this.produitsMedicamment.getPromdcCodeDci() != null && !this.produitsMedicamment.getPromdcCodeDci().isEmpty()) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         this.produitsDci = this.produitsMedicammentDao.rechercheDci(this.produitsMedicamment.getPromdcCodeDci(), var1);
         this.produitsMedicamment = this.produitsMedicammentDao.rechercheSpecialite(this.produitsMedicamment.getPromdcSpecialite(), var1);
         this.showModalPanelMedicammentDci = true;
         this.utilInitHibernate.closeSession();
      } else {
         this.showModalPanelMedicammentDci = false;
      }

   }

   public void fermerDci() {
      this.showModalPanelMedicammentDci = false;
   }

   public void saveOrdonnance() throws HibernateException, NamingException {
      if (this.consultationOrdo != null) {
         if (this.consultationOrdo.getCslordId() == 0L) {
            this.consultationOrdo.setConsultationEnteteGene(this.consultationEnteteGene);
            this.consultationOrdo = this.consultationOrdoDao.insert(this.consultationOrdo);
            this.lesOrdonnance.add(this.consultationOrdo);
            this.dataModelOrdonnance.setWrappedData(this.lesOrdonnance);
         } else {
            this.consultationOrdo = this.consultationOrdoDao.modif(this.consultationOrdo);
         }

         this.ajouterMedicamment();
      }

   }

   public void rechercheMedicamment() throws HibernateException, NamingException {
      this.choixPanenProd = 2;
      if (this.consultationOrdo.getCslordProduit() != null && !this.consultationOrdo.getCslordProduit().isEmpty()) {
         this.lesMedicamments.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         this.lesMedicamments = this.produitsMedicammentDao.rechercheMedicamments(this.consultationOrdo.getCslordProduit(), var1);
         this.utilInitHibernate.closeSession();
         if (this.lesMedicamments.size() == 1) {
            this.produitsMedicamment = (ProduitsMedicamment)this.lesMedicamments.get(0);
            this.validerMedicamment();
         } else if (this.lesMedicamments.size() > 1) {
            this.produitsMedicamment = new ProduitsMedicamment();
            this.showModalPanelMedicamment = true;
            this.datamodelProduits.setWrappedData(this.lesMedicamments);
         } else {
            this.annulerMedicamment();
         }
      }

   }

   public void selectionMedicamment() {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produitsMedicamment = (ProduitsMedicamment)this.datamodelProduits.getRowData();
      }

   }

   public void annulerMedicamment() {
      this.produitsMedicamment = new ProduitsMedicamment();
      this.consultationOrdo = new ConsultationOrdo();
      this.var_aff_detail_ordo = false;
      this.afficheButtOrdo = false;
      this.showModalPanelMedicamment = false;
   }

   public void validerMedicamment() throws HibernateException, NamingException {
      if (this.produitsMedicamment != null) {
         this.consultationOrdo.setCslordProduit(this.produitsMedicamment.getPromdcCodeCis());
         this.consultationOrdo.setCslordLibelle(this.produitsMedicamment.getPromdcSpecialite());
         this.consultationOrdo.setCslordDci(this.produitsMedicamment.getPromdcCodeDci());
         this.consultationOrdo.setCslordForme(this.produitsMedicamment.getPromdcForme());
         this.produitsDci = this.produitsMedicammentDao.rechercheDci(this.produitsMedicamment.getPromdcCodeDci(), (Session)null);
         if (this.produitsDci != null) {
            this.consultationOrdo.setCslordPoso(this.produitsDci.getProdciPosologie());
         } else {
            this.consultationOrdo.setCslordPoso("");
         }

         this.var_aff_detail_ordo = true;
      }

      this.showModalPanelMedicamment = false;
   }

   public void calculeProtocoleOrdonnance() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null && this.consultationEnteteGene.getCsgProtocole() != null && !this.consultationEnteteGene.getCsgProtocole().isEmpty() && this.consultationEnteteGene.getCsgProtocole().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProtocoleMedical");
         String[] var2 = this.consultationEnteteGene.getCsgProtocole().split(":");
         this.produitsMedicamment = new ProduitsMedicamment();
         this.produitsMedicammentDao = new ProduitsMedicammentDao(this.baseLog, this.utilInitHibernate);
         new ProtocoleMedical();
         ProtocoleMedicalDao var4 = new ProtocoleMedicalDao(this.baseLog, this.utilInitHibernate);
         ProtocoleMedical var3 = var4.chargeProtocole(var2[0], var1);
         if (var3 != null && var3.getPrtOrdonance() != null && !var3.getPrtOrdonance().isEmpty() && var3.getPrtOrdonance().contains(":")) {
            new ObjetTarif();
            ObjetTarif var5;
            String[] var6;
            if (!var3.getPrtOrdonance().contains("#")) {
               var6 = var3.getPrtOrdonance().split(":");
               var5 = new ObjetTarif();
               var5.setCodeProduit(var6[0]);
               var5.setNomProduit(var6[1]);
               var5.setIdProduit(Long.parseLong(var6[2]));
               var5.setQteProduit(Float.parseFloat(var6[3]));
               this.ajouterLigneProocole(var5, this.produitsMedicamment, this.produitsMedicammentDao, var1);
            } else {
               var6 = var3.getPrtOrdonance().split("#");
               int var7 = var6.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  String[] var9 = var6[var8].split(":");
                  var5 = new ObjetTarif();
                  var5.setCodeProduit(var9[0]);
                  var5.setNomProduit(var9[1]);
                  var5.setIdProduit(Long.parseLong(var9[2]));
                  var5.setQteProduit(Float.parseFloat(var9[3]));
                  this.ajouterLigneProocole(var5, this.produitsMedicamment, this.produitsMedicammentDao, var1);
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void ajouterLigneProocole(ObjetTarif var1, ProduitsMedicamment var2, ProduitsMedicammentDao var3, Session var4) throws HibernateException, NamingException {
      if (var1.getIdProduit() != 0L) {
         var2 = var3.rechercheById(var1.getIdProduit(), var4);
         if (var2 != null) {
            this.consultationOrdo = new ConsultationOrdo();
            this.consultationOrdo.setCslordProduit(var2.getPromdcCodeCis());
            this.consultationOrdo.setCslordLibelle(var2.getPromdcSpecialite());
            this.consultationOrdo.setCslordDci(var2.getPromdcCodeDci());
            this.consultationOrdo.setCslordForme(var2.getPromdcForme());
            this.produitsDci = var3.rechercheDci(var2.getPromdcCodeDci(), var4);
            if (this.produitsDci != null) {
               this.consultationOrdo.setCslordPoso(this.produitsDci.getProdciPosologie());
            } else {
               this.consultationOrdo.setCslordPoso("");
            }

            this.lesOrdonnance.add(this.consultationOrdo);
         }
      }

   }

   public void ajouterPharmacie() {
      this.produits = new Produits();
      this.pharmacieLigne = new PharmacieLigne();
      this.var_aff_detail_pharmacie = false;
      this.afficheButtPharmacie = false;
      this.griserchamps = false;
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsItems.clear();
   }

   public void supprimerPharmacie() throws HibernateException, NamingException {
      if (this.pharmacieLigne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.pharmacieLigne.getPhaligProduit();
            this.pharmacieLigneDao.delete(this.pharmacieLigne, var1);
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit " + var3 + " de la consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.consultationEnteteGene.getCsgDate());
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

         this.lesPharmacie.remove(this.pharmacieLigne);
         this.dataModelPharmacie.setWrappedData(this.lesPharmacie);
         this.ajouterPharmacie();
      }

   }

   public void selectionPharmacieListe() throws HibernateException, NamingException {
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsItems.clear();
      this.produits = null;
      this.afficheButtPharmacie = false;
      this.var_aff_detail_pharmacie = false;
      if (this.dataModelPharmacie.isRowAvailable()) {
         this.pharmacieLigne = (PharmacieLigne)this.dataModelPharmacie.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         if (this.pharmacieLigne.getPhaligProduit() != null && this.pharmacieLigne.getPhaligProduit().length() >= 2) {
            this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligProduit(), var1);
            if (this.produits != null) {
               this.pharmacieLigne.setPhaligProduit(this.produits.getProCode());
               this.pharmacieLigne.setPhaligFamille(this.produits.getProAchCode());
               this.pharmacieLigne.setPhaligStock(this.produits.getProStock());
               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
               this.mefConditionnementDepot(var1);
               this.selectionDepot(var1);
               if (this.mesProduitsDepotsItems.size() != 0) {
                  for(int var2 = 0; var2 < this.mesProduitsDepotsItems.size(); ++var2) {
                     if (((SelectItem)this.mesProduitsDepotsItems.get(var2)).getLabel().toString().startsWith(this.pharmacieLigne.getPhaligDepot())) {
                        this.var_depotProd = ((SelectItem)this.mesProduitsDepotsItems.get(var2)).getLabel().toString();
                        break;
                     }
                  }
               }

               this.mesUnitesProduits = this.chargerUniteProduit(var1);
            }
         } else {
            this.produits = null;
            this.var_aff_detail_prod = false;
            this.griserchamps = false;
            this.pharmacieLigne.setPhaligUnite("");
            this.pharmacieLigne.setPhaligCondition("");
            this.pharmacieLigne.setPhaligEchelle(0);
         }

         this.utilInitHibernate.closeSession();
         this.afficheButtPharmacie = true;
         this.var_aff_detail_pharmacie = true;
      } else {
         this.var_aff_detail_prod = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
      }

   }

   public void savePharmacie() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
            String[] var3;
            if (this.var_depotProd.contains(":")) {
               var3 = this.var_depotProd.split(":");
               this.pharmacieLigne.setPhaligDepot(var3[0]);
            } else {
               var3 = this.var_depotProd.split("=");
               this.pharmacieLigne.setPhaligDepot(var3[0]);
            }
         } else {
            this.pharmacieLigne.setPhaligDepot("");
         }

         if (this.pharmacieLigne.getPhaligCondition() != null && !this.pharmacieLigne.getPhaligCondition().isEmpty() && this.pharmacieLigne.getPhaligCondition().contains(":")) {
            ConditionnementDao var11 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            String[] var4 = this.pharmacieLigne.getPhaligCondition().split(":");
            String var5 = var11.rechercheConditionnement(var4[0], var1).getCdtDescription();
            if (var5 != null && !var5.isEmpty()) {
               this.pharmacieLigne.setPhaligDescription(var5);
            } else {
               this.pharmacieLigne.setPhaligDescription("");
            }

            if (this.pharmacieLigne.getPhaligEchelle() == 0) {
               this.unite = new Unite();
               this.unite = this.uniteDao.selectUnite(var4[0], var1);
               if (this.unite != null) {
                  this.pharmacieLigne.setPhaligEchelle(this.unite.getUniEchelle());
               }
            }
         } else {
            this.pharmacieLigne.setPhaligDescription("");
         }

         if (this.pharmacieLigne.getPhaligQte() != 0.0F) {
            this.pharmacieLigne.setPhaligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.pharmacieLigne.getPhaligCondition(), this.pharmacieLigne.getPhaligQte(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, this.utilInitHibernate, var1));
         } else {
            this.pharmacieLigne.setPhaligQteUtil(0.0F);
         }

         if (this.pharmacieLigne.getPhaligQteUtil() == 0.0F) {
            this.pharmacieLigne.setPhaligQteUtil(this.pharmacieLigne.getPhaligQte());
         }

         if (this.pharmacieLigne != null) {
            if (this.pharmacieLigne.getPhaligId() == 0L) {
               this.pharmacieLigne.setConsultationEnteteGene(this.consultationEnteteGene);
               this.pharmacieLigne.setPharmacieEntete((PharmacieEntete)null);
               this.pharmacieLigne = this.pharmacieLigneDao.insert(this.pharmacieLigne, var1);
               this.lesPharmacie.add(this.pharmacieLigne);
               this.dataModelPharmacie.setWrappedData(this.lesPharmacie);
            } else {
               this.pharmacieLigne = this.pharmacieLigneDao.modif(this.pharmacieLigne, var1);
            }

            this.ajouterPharmacie();
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

   public void recherchePharmacie() throws HibernateException, NamingException {
      this.choixPanenProd = 4;
      if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.pharmacieLigne.getPhaligProduit(), "1105", var1);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.validerPharmacie(var1);
         } else if (this.lesProduits.size() > 1) {
            this.produits = new Produits();
            this.showModalPanelProduits = true;
            this.datamodelProduits.setWrappedData(this.lesProduits);
         } else {
            this.annulerPharmacie();
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionPharmacie() {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduits.getRowData();
      }

   }

   public void annulerPharmacie() {
      this.produits = new Produits();
      this.pharmacieLigne = new PharmacieLigne();
      this.var_aff_detail_pharmacie = false;
      this.afficheButtPharmacie = false;
      this.showModalPanelProduits = false;
   }

   public void validerPharmacie() throws HibernateException, NamingException {
      this.validerPharmacie((Session)null);
   }

   public void validerPharmacie(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         this.pharmacieLigne.setPhaligProduit(this.produits.getProCode());
         this.pharmacieLigne.setPhaligLibelle(this.produits.getProLibClient());
         this.pharmacieLigne.setPhaligFamille(this.produits.getProVteCode());
         this.pharmacieLigne.setPhaligStock(this.produits.getProStock());
         this.var_aff_detail_pharmacie = true;
         this.mesProduitsDepotsItems.clear();
         this.mesConditionnementsProduits.clear();
         this.mesConditionnementsItems.clear();
         this.pharmacieLigne.setPhaligUnite("");
         this.pharmacieLigne.setPhaligCondition("");
         this.pharmacieLigne.setPhaligEchelle(0);
         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         if (this.mesConditionnementsProduits.size() != 0) {
            this.pharmacieLigne.setPhaligCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.mefConditionnementDepot(var1);
      }

      this.showModalPanelProduits = false;
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      new ArrayList();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var3 = this.pharmacieLigne.getPhaligCondition();
         if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
            if (var3.contains("/")) {
               String[] var4 = var3.split("/");
               String var5 = var4[1];
               String[] var6 = var5.split(":");
               this.unite = this.uniteDao.selectUnite(var6[1], var1);
               if (this.unite != null) {
                  this.pharmacieLigne.setPhaligEchelle(this.unite.getUniEchelle());
               } else {
                  this.pharmacieLigne.setPhaligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.pharmacieLigne.setPhaligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var3 != null && !var3.isEmpty() && !var3.contains(":")) {
            this.pharmacieLigne.setPhaligEchelle(Integer.parseInt(var3));
         } else {
            this.pharmacieLigne.setPhaligEchelle(0);
         }

         List var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, 73, var1);
         if (var2.size() != 0) {
            for(int var11 = 0; var11 < var2.size(); ++var11) {
               ProduitsDepot var12 = (ProduitsDepot)var2.get(var11);
               float var13 = var12.getProdepQteStk();
               String var7 = "";
               int var8;
               if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
                  var13 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var3, var13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, var1);
                  var8 = (int)var13;
                  var7 = "" + var8;
               } else if (var3 != null && !var3.isEmpty() && !var3.contains(":")) {
                  var13 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var3, var13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, var1);
                  var8 = (int)var13;
                  var7 = "" + var8;
               } else {
                  var7 = "" + var13;
               }

               if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
                  if (!this.verrouDepotUser.contains(",")) {
                     if (var12.getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                        if (var12.getProdepCasier() != null && !var12.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var12.getDepot().getDpoCode() + ":" + var12.getProdepCasier() + "=" + var7));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var12.getDepot().getDpoCode() + "=" + var7));
                        }
                     }
                  } else {
                     String[] var14 = this.verrouDepotUser.split(",");
                     int var9 = var14.length;

                     for(int var10 = 0; var10 < var9; ++var10) {
                        if (var12.getDepot().getDpoCode().equals(var14[var10])) {
                           if (var12.getProdepCasier() != null && !var12.getProdepCasier().isEmpty()) {
                              this.mesProduitsDepotsItems.add(new SelectItem(var12.getDepot().getDpoCode() + ":" + var12.getProdepCasier() + "=" + var7));
                              break;
                           }

                           this.mesProduitsDepotsItems.add(new SelectItem(var12.getDepot().getDpoCode() + "=" + var7));
                           break;
                        }
                     }
                  }
               } else if (var12.getProdepCasier() != null && !var12.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var12.getDepot().getDpoCode() + ":" + var12.getProdepCasier() + "=" + var7));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var12.getDepot().getDpoCode() + "=" + var7));
               }
            }
         }
      }

   }

   public List chargerConditionnementProduit(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.produits.setProCondition1("UNITE:1.0:unite/1.0:unite");
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementStock(this.mesConditionnementsItems, this.produits, (ProduitsDepot)null, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
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

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.pharmacieLigne.setPhaligUnite(this.produitsDepot.getProdepUnite());
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
               if (this.structureLog.getStrstockNegatif() == 2) {
                  if (this.produitsDepot.getProdepQteStk() < this.pharmacieLigne.getPhaligQte() && this.pharmacieLigne.getPhaligQte() != 0.0F) {
                     this.validationLigne = 2;
                     this.messageStockNegatif = "Quantité demandée : " + this.pharmacieLigne.getPhaligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                  } else {
                     this.validationLigne = 0;
                  }
               } else if (this.structureLog.getStrstockNegatif() == 1) {
                  if (this.produitsDepot.getProdepQteStk() < this.pharmacieLigne.getPhaligQte() && this.pharmacieLigne.getPhaligQte() != 0.0F) {
                     this.validationLigne = 1;
                     this.messageStockNegatif = "Quantité demandée : " + this.pharmacieLigne.getPhaligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
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
         if (this.pharmacieLigne.getPhaligCondition() != null && !this.pharmacieLigne.getPhaligCondition().isEmpty() && this.pharmacieLigne.getPhaligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.pharmacieLigne.getPhaligEchelle());
            float var5 = 1.0F;
            if (this.pharmacieLigne.getPhaligCondition().contains("/")) {
               String[] var6 = this.pharmacieLigne.getPhaligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.pharmacieLigne.getPhaligCondition() != null && !this.pharmacieLigne.getPhaligCondition().isEmpty() && !this.pharmacieLigne.getPhaligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.pharmacieLigne.getPhaligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.pharmacieLigne.setPhaligPump(var9);
      } else {
         this.pharmacieLigne.setPhaligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
      this.mefConditionnementDepot(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void ajouterLaboratoire() {
      this.produits = new Produits();
      this.consultationLabo = new ConsultationLabo();
      this.var_aff_detail_labo = false;
      this.afficheButtLabo = false;
   }

   public void selectionLaboratoireListe() {
      this.var_aff_detail_ordo = false;
      if (this.dataModelLaboratoire.isRowAvailable()) {
         this.consultationLabo = (ConsultationLabo)this.dataModelLaboratoire.getRowData();
         this.var_aff_detail_labo = true;
         this.afficheButtLabo = true;
      }

   }

   public void supprimerLaboratoire() throws HibernateException, NamingException {
      if (this.consultationLabo != null) {
         this.consultationLaboDao.delete(this.consultationLabo);
         this.chargerLaboratoire((Session)null);
         this.var_aff_detail_labo = false;
         this.afficheButtLabo = false;
      }

   }

   public void detailLaboratoire() {
   }

   public void saveLaboratoire() throws HibernateException, NamingException {
      if (this.consultationLabo != null) {
         if (this.consultationLabo.getCsllabId() == 0L) {
            this.consultationLabo.setConsultationEnteteGene(this.consultationEnteteGene);
            this.consultationLabo = this.consultationLaboDao.insert(this.consultationLabo);
            this.lesLaboratoire.add(this.consultationLabo);
            this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         } else {
            this.consultationLabo = this.consultationLaboDao.modif(this.consultationLabo);
         }

         this.ajouterLaboratoire();
      }

   }

   public void rechercheLaboratoire() throws HibernateException, NamingException {
      this.choixPanenProd = 3;
      if (this.consultationLabo.getCsllabProduit() != null && !this.consultationLabo.getCsllabProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.consultationLabo.getCsllabProduit(), "1106", var1);
         this.utilInitHibernate.closeSession();
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.validerLaboratoire();
         } else if (this.lesProduits.size() > 1) {
            this.produits = new Produits();
            this.showModalPanelProduits = true;
            this.datamodelProduits.setWrappedData(this.lesProduits);
         } else {
            this.annulerLaboratoire();
         }
      }

   }

   public void selectionLaboratoire() throws HibernateException, NamingException {
      if (this.datamodelProduits.isRowAvailable()) {
         this.var_lettre = "";
         this.produits = (Produits)this.datamodelProduits.getRowData();
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.produits.getProLettre(), (Session)null);
            if (this.lettreMedical != null) {
               this.var_lettre = this.produits.getProLettre() + ":" + this.lettreMedical.getLetLibelleFr();
            }
         }
      }

   }

   public void annulerLaboratoire() {
      this.produits = new Produits();
      this.consultationLabo = new ConsultationLabo();
      this.var_aff_detail_labo = false;
      this.afficheButtLabo = false;
      this.showModalPanelProduits = false;
   }

   public void validerLaboratoire() {
      this.consultationLabo.setCsllabProduit(this.produits.getProCode());
      this.consultationLabo.setCsllabLibelle(this.produits.getProLibClient());
      this.var_aff_detail_labo = true;
      this.showModalPanelProduits = false;
   }

   public void selectionElementListe() {
      if (this.dataModelElements.isRowAvailable()) {
         this.objetCompte = (ObjetCompte)this.dataModelElements.getRowData();
      }

   }

   public void chargerElement() {
      if (this.lesElements.size() != 0) {
         for(int var1 = 0; var1 < this.lesElements.size(); ++var1) {
            this.objetCompte = (ObjetCompte)this.lesElements.get(var1);
            if (var1 == 0) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV1Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV1Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot1());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte1());
            } else if (var1 == 1) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV2Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV2Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot2());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte2());
            } else if (var1 == 2) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV3Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV3Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot3());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte3());
            } else if (var1 == 3) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV4Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV4Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot4());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte4());
            } else if (var1 == 4) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV5Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV5Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot5());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte5());
            } else if (var1 == 5) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV6Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV6Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot6());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte6());
            } else if (var1 == 6) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV7Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV7Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot7());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte7());
            } else if (var1 == 7) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV8Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV8Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot8());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte8());
            } else if (var1 == 8) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV9Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV9Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot9());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte9());
            } else if (var1 == 9) {
               this.objetCompte.setDemande(this.consultationInfirmerie.isCslaccV10Dem());
               this.objetCompte.setEffectue(this.consultationInfirmerie.isCslaccV10Rea());
               this.objetCompte.setLot(this.consultationInfirmerie.getCslaccLot10());
               this.objetCompte.setDatePeremption(this.consultationInfirmerie.getCslaccLotDte10());
            }
         }
      }

   }

   public void chargerFournisseurs(Session var1) throws HibernateException, NamingException {
      this.mesFournisseursItem.clear();
      new ArrayList();
      TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesTiers("0", var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.mesFournisseursItem.add(new SelectItem(((Tiers)var2.get(var4)).getTieid(), ((Tiers)var2.get(var4)).getTieraisonsocialenom()));
         }
      }

   }

   public void miseajourElement() {
      for(int var1 = 0; var1 < this.lesElements.size(); ++var1) {
         this.objetCompte = (ObjetCompte)this.lesElements.get(var1);
         if (var1 == 0) {
            this.consultationInfirmerie.setCslaccV1Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV1Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot1(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte1(this.objetCompte.getDatePeremption());
         } else if (var1 == 1) {
            this.consultationInfirmerie.setCslaccV2Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV2Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot2(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte2(this.objetCompte.getDatePeremption());
         } else if (var1 == 2) {
            this.consultationInfirmerie.setCslaccV3Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV3Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot3(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte3(this.objetCompte.getDatePeremption());
         } else if (var1 == 3) {
            this.consultationInfirmerie.setCslaccV4Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV4Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot4(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte4(this.objetCompte.getDatePeremption());
         } else if (var1 == 4) {
            this.consultationInfirmerie.setCslaccV5Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV5Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot5(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte5(this.objetCompte.getDatePeremption());
         } else if (var1 == 5) {
            this.consultationInfirmerie.setCslaccV6Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV6Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot6(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte6(this.objetCompte.getDatePeremption());
         } else if (var1 == 6) {
            this.consultationInfirmerie.setCslaccV7Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV7Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot7(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte7(this.objetCompte.getDatePeremption());
         } else if (var1 == 7) {
            this.consultationInfirmerie.setCslaccV8Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV8Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot8(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte8(this.objetCompte.getDatePeremption());
         } else if (var1 == 8) {
            this.consultationInfirmerie.setCslaccV9Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV9Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot9(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte9(this.objetCompte.getDatePeremption());
         } else if (var1 == 9) {
            this.consultationInfirmerie.setCslaccV10Dem(this.objetCompte.isDemande());
            this.consultationInfirmerie.setCslaccV10Rea(this.objetCompte.isEffectue());
            this.consultationInfirmerie.setCslaccLot10(this.objetCompte.getLot());
            this.consultationInfirmerie.setCslaccLotDte10(this.objetCompte.getDatePeremption());
         }
      }

   }

   public void calculerBC() throws HibernateException, NamingException {
      String var1 = this.calculChrono.numCompose(this.var_date, 22, this.consultationEnteteGene.getCsgSerie(), (Session)null);
      if (var1 == null || var1.isEmpty()) {
         var1 = "" + this.var_date.getTime();
      }

      this.consultationEnteteGene.setCsgNumBc(var1);
      this.chargerFournisseurs((Session)null);
   }

   public void effacerBC() {
      this.consultationEnteteGene.setCsgNumBc((String)null);
   }

   public int calculNbRepos() {
      int var1 = 0;
      if (this.consultationInfirmerie.getCslaccDateDu() != null && this.consultationInfirmerie.getCslaccDateAu() != null) {
         var1 = (int)((this.consultationInfirmerie.getCslaccDateAu().getTime() - this.consultationInfirmerie.getCslaccDateDu().getTime()) / 86400000L + 1L);
         this.consultationInfirmerie.setCslaccNbJourRepos(var1);
      } else {
         this.consultationInfirmerie.setCslaccNbJourRepos(0);
      }

      return var1;
   }

   public void saveInfirmerie() throws HibernateException, NamingException, ParseException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
      Transaction var3 = null;

      Users var4;
      try {
         var3 = var2.beginTransaction();
         this.consultationEnteteGene.setCsgDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         new Users();
         if (this.var_nom_medecin == 0L && this.mesMedecinsItem.size() == 1) {
            this.var_nom_medecin = Long.parseLong(((SelectItem)this.mesMedecinsItem.get(0)).getValue().toString());
         }

         var4 = this.usersDao.selectUserD(this.var_nom_medecin, var2);
         if (var4 != null) {
            this.consultationEnteteGene.setCsgIdMedecin(var4.getUsrid());
            this.consultationEnteteGene.setCsgMedecin(var4.getUsrPatronyme());
         } else {
            this.consultationEnteteGene.setCsgIdMedecin(0L);
            this.consultationEnteteGene.setCsgMedecin("");
         }

         int var5;
         long var6;
         if (this.var_nom_fournisseurPha != 0L) {
            for(var5 = 0; var5 < this.mesFournisseursItem.size(); ++var5) {
               var6 = Long.parseLong(((SelectItem)this.mesFournisseursItem.get(var5)).getValue().toString());
               if (var6 == this.var_nom_fournisseurPha) {
                  this.consultationEnteteGene.setCsgIdComplementaire(this.var_nom_fournisseurPha);
                  this.consultationEnteteGene.setCsgNomComplemtaire(((SelectItem)this.mesFournisseursItem.get(var5)).getLabel().toString());
               }
            }
         } else {
            this.consultationEnteteGene.setCsgIdComplementaire(0L);
            this.consultationEnteteGene.setCsgNomComplemtaire("");
         }

         if (this.var_nom_fournisseurLab != 0L) {
            for(var5 = 0; var5 < this.mesFournisseursItem.size(); ++var5) {
               var6 = Long.parseLong(((SelectItem)this.mesFournisseursItem.get(var5)).getValue().toString());
               if (var6 == this.var_nom_fournisseurLab) {
                  this.consultationEnteteGene.setCsgIdAssurance(this.var_nom_fournisseurLab);
                  this.consultationEnteteGene.setCsgNomAssurance(((SelectItem)this.mesFournisseursItem.get(var5)).getLabel().toString());
               }
            }
         } else {
            this.consultationEnteteGene.setCsgIdAssurance(0L);
            this.consultationEnteteGene.setCsgNomAssurance("");
         }

         if (this.consultationEnteteGene.getCsgId() != 0L) {
            this.consultationEnteteGene.setCsgDateModif(new Date());
            this.consultationEnteteGene.setCsgIdModif(this.usersLog.getUsrid());
            this.consultationEnteteGene.setCsgNomModif(this.usersLog.getUsrPatronyme());
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var2);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
         } else {
            if (!this.consultationEnteteGene.getCsgSerie().equalsIgnoreCase("X") && !this.consultationEnteteGene.getCsgSerie().isEmpty()) {
               this.consultationEnteteGene.setCsgNum(this.calculChrono.numCompose(this.consultationEnteteGene.getCsgDate(), this.nature, this.consultationEnteteGene.getCsgSerie(), var2));
               boolean var27 = false;

               label844:
               while(true) {
                  while(true) {
                     if (var27) {
                        break label844;
                     }

                     new ConsultationEnteteGene();
                     ConsultationEnteteGene var28 = this.consultationEnteteGeneDao.selectByNum(this.consultationEnteteGene.getCsgNum(), this.consultationEnteteGene.getCsgSerie(), var2);
                     if (var28 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.consultationEnteteGene.setCsgNum(this.calculChrono.numCompose(this.consultationEnteteGene.getCsgDate(), this.nature, this.consultationEnteteGene.getCsgSerie(), var2));
                        var27 = false;
                     } else {
                        var27 = true;
                     }
                  }
               }
            } else {
               long var26 = this.consultationEnteteGeneDao.selectLastNum(var2);
               this.consultationEnteteGene.setCsgNum("" + var26);
            }

            this.consultationEnteteGene.setExerciceventes(this.exercicesVentes);
            this.consultationEnteteGene.setPatients(this.patients);
            this.consultationEnteteGene.setCsgDateCreat(new Date());
            this.consultationEnteteGene.setCsgIdCreateur(this.usersLog.getUsrid());
            this.consultationEnteteGene.setCsgNomCreateur(this.usersLog.getUsrPatronyme());
            this.consultationEnteteGene.setCsgEtat(0);
            this.consultationEnteteGene.setCsgEtatVal(0);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.insert(this.consultationEnteteGene, var2);
            this.lesConsultationEntete.add(this.consultationEnteteGene);
            this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.var_affiche_at && this.var_date_accident != null) {
            String var31 = "";
            if (this.var_heures <= 9) {
               var31 = "0" + this.var_heures;
            } else {
               var31 = "" + this.var_heures;
            }

            String var29 = "";
            if (this.var_heures <= 9) {
               var29 = "0" + this.var_minutes;
            } else {
               var29 = "" + this.var_minutes;
            }

            this.consultationInfirmerie.setCslaccType(0);
            this.consultationInfirmerie.setCslaccDateAccident(this.utilDate.dateToSQL(this.var_date_accident, var31, var29, "00"));
         } else if (this.var_affiche_vaccin) {
            this.consultationInfirmerie.setCslaccType(1);
            this.consultationInfirmerie.setCslaccDateAccident((Date)null);
            if (this.lesElements.size() != 0) {
               this.miseajourElement();
            }
         } else if (this.var_affiche_audio) {
            this.consultationInfirmerie.setCslaccType(2);
            this.consultationInfirmerie.setCslaccDateAccident((Date)null);
            if (this.lesElements.size() != 0) {
               this.miseajourElement();
            }
         } else if (this.var_affiche_vme) {
            this.consultationInfirmerie.setCslaccType(3);
            this.consultationInfirmerie.setCslaccDateAccident((Date)null);
            if (this.lesElements.size() != 0) {
               this.miseajourElement();
            }
         } else if (this.var_affiche_vma) {
            this.consultationInfirmerie.setCslaccType(4);
            this.consultationInfirmerie.setCslaccDateAccident((Date)null);
            if (this.lesElements.size() != 0) {
               this.miseajourElement();
            }
         } else if (this.var_affiche_tubertest) {
            this.consultationInfirmerie.setCslaccType(5);
            this.consultationInfirmerie.setCslaccDateAccident((Date)null);
            if (this.lesElements.size() != 0) {
               this.miseajourElement();
            }
         }

         if (this.consultationInfirmerie.getCslaccCertificat() != 0) {
            this.var_affiche_certificat = true;
         } else {
            this.consultationInfirmerie.setCslaccDateDu((Date)null);
            this.consultationInfirmerie.setCslaccDateAu((Date)null);
            this.consultationInfirmerie.setCslaccNbJourRepos(0);
            this.consultationInfirmerie.setCslaccMotifRepos("");
         }

         if (this.var_affiche_at && this.var_date_accident != null || this.var_affiche_vaccin || this.var_affiche_audio || this.var_affiche_vme || this.var_affiche_vma || this.var_affiche_tubertest || this.var_affiche_certificat) {
            if (this.consultationInfirmerie.getCslaccDateDocument() == null) {
               this.consultationInfirmerie.setCslaccDateDocument(this.consultationEnteteGene.getCsgDate());
            }

            if (this.consultationInfirmerie.getCslaccSignataire() == null || this.consultationInfirmerie.getCslaccSignataire().isEmpty()) {
               this.consultationInfirmerie.setCslaccSignataire(this.consultationEnteteGene.getCsgMedecin());
            }

            this.consultationInfirmerie.setCslaccNbJourRepos(this.calculNbRepos());
            if (this.consultationInfirmerie.getCslaccId() == 0L) {
               this.consultationInfirmerie.setConsultationEnteteGene(this.consultationEnteteGene);
               this.consultationInfirmerie = this.consultationInfirmerieDao.insert(this.consultationInfirmerie, var2);
            } else {
               this.consultationInfirmerie = this.consultationInfirmerieDao.modif(this.consultationInfirmerie, var2);
            }
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var23) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         var4 = null;

         try {
            Transaction var25 = var2.beginTransaction();
            new ArrayList();
            new Rdv();
            RdvDao var30 = new RdvDao(this.baseLog, this.utilInitHibernate);
            String var8 = "";
            var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()) + "'";
            List var33 = var30.rechercheRdvRequete(var8, var2);
            Rdv var32;
            if (var33.size() != 0) {
               var32 = (Rdv)var33.get(0);
               var32.setRdvEtat(1);
               var32.setRdvDteExec(new Date());
               var32.setRdvCr("Effectué");
               var30.modif(var32, var2);
            }

            String var34;
            if (this.consultationEnteteGene.getCsgRdv() != null) {
               if (this.memoDateRdv != null) {
                  var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.memoDateRdv) + "'";
               } else {
                  var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgRdv()) + "'";
               }

               var33 = var30.rechercheRdvRequete(var8, var2);
               if (var33.size() != 0) {
                  if (this.memoDateRdv != null && !this.memoDateRdv.equals(this.consultationEnteteGene.getCsgRdv())) {
                     var32 = (Rdv)var33.get(0);
                     var32.setRdvDteDe(this.consultationEnteteGene.getCsgRdv());
                     var30.modif(var32, var2);
                  }
               } else {
                  var32 = new Rdv();
                  var32.setRdvCollaborateur((String)null);
                  var32.setRdvDateCreation(new Date());
                  var32.setRdvDescript((String)null);
                  var32.setRdvDteDe(this.consultationEnteteGene.getCsgRdv());
                  var32.setRdvEtat(0);
                  var32.setRdvHrDe("00");
                  var32.setRdvHrFi("00");
                  var32.setRdvLieu((String)null);
                  var32.setRdvMailContact((String)null);
                  var32.setRdvMnDe("00");
                  var32.setRdvMnFi("00");
                  var32.setRdvMode("Non renseigné");
                  var32.setRdvNature(1);
                  var34 = "";
                  if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                     var34 = this.patients.getPatNom() + " " + this.patients.getPatPrenom();
                  } else {
                     var34 = this.patients.getPatNom();
                  }

                  var32.setRdvNomPat(var34);
                  var32.setRdvNomUsers(this.usersLog.getUsrPatronyme());
                  var32.setRdvPatIdDe(this.patients.getPatId());
                  var32.setRdvService(this.usersLog.getUsrService());
                  var32.setRdvSujet("RDV suite CS");
                  var32.setRdvTache((String)null);
                  var32.setUsers(this.usersLog);
                  var30.insert(var32, var2);
               }

               this.memoDateRdv = this.consultationEnteteGene.getCsgRdv();
            }

            if (this.infirmerie && this.consultationInfirmerie != null && this.consultationInfirmerie.getCslaccDateRdv() != null) {
               if (this.memoDateRdv != null) {
                  var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.memoDateRdv) + "'";
               } else {
                  var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.consultationInfirmerie.getCslaccDateRdv()) + "'";
               }

               var33 = var30.rechercheRdvRequete(var8, var2);
               if (var33.size() != 0) {
                  if (this.memoDateRdv != null && !this.memoDateRdv.equals(this.consultationInfirmerie.getCslaccDateRdv())) {
                     var32 = (Rdv)var33.get(0);
                     var32.setRdvDteDe(this.consultationInfirmerie.getCslaccDateRdv());
                     var30.modif(var32, var2);
                  }
               } else {
                  var32 = new Rdv();
                  var32.setRdvCollaborateur((String)null);
                  var32.setRdvDateCreation(new Date());
                  var32.setRdvDescript((String)null);
                  var32.setRdvDteDe(this.consultationInfirmerie.getCslaccDateRdv());
                  var32.setRdvEtat(0);
                  var32.setRdvHrDe("00");
                  var32.setRdvHrFi("00");
                  var32.setRdvLieu((String)null);
                  var32.setRdvMailContact((String)null);
                  var32.setRdvMnDe("00");
                  var32.setRdvMnFi("00");
                  var32.setRdvMode("Non renseigné");
                  var32.setRdvNature(1);
                  var34 = "";
                  if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                     var34 = this.patients.getPatNom() + " " + this.patients.getPatPrenom();
                  } else {
                     var34 = this.patients.getPatNom();
                  }

                  var32.setRdvNomPat(var34);
                  var32.setRdvNomUsers(this.usersLog.getUsrPatronyme());
                  var32.setRdvPatIdDe(this.patients.getPatId());
                  var32.setRdvService(this.usersLog.getUsrService());
                  if (this.consultationInfirmerie.getCslaccType() == 1) {
                     var32.setRdvSujet("RDV Vaccin");
                  } else if (this.consultationInfirmerie.getCslaccType() == 2) {
                     var32.setRdvSujet("RDV Audiométrie");
                  }

                  var32.setRdvTache((String)null);
                  var32.setUsers(this.usersLog);
                  var30.insert(var32, var2);
               }

               this.memoDateRdv = this.consultationInfirmerie.getCslaccDateRdv();
            }

            var25.commit();
         } catch (HibernateException var21) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.visibleOnglet = true;
   }

   public void ajouterDocumentScan() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomDocument = "";
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocumentScan() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocumentScan() {
      if (this.consultationEnteteGene != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoire + this.consultationEnteteGene.getCsgNum());
         if (var1.exists()) {
            var1.delete();
         }

         FacesContext var2 = FacesContext.getCurrentInstance();

         try {
            if (this.utilDownload == null) {
               this.utilDownload = new UtilDownload();
            }

            String var3 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var4 = var3.substring(var3.indexOf(".") + 1);
            if (this.nomDocument != null && !this.nomDocument.isEmpty()) {
               var3 = this.consultationEnteteGene.getCsgNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.consultationEnteteGene.getCsgNum().replace("/", "_") + "." + var4;
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoire), var3);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var3;
            this.lesDocuments.add(this.pdfFileName);
            this.dataModelDocumnts.setWrappedData(this.lesDocuments);
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutFile = false;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         } else if (var3.equals(" ")) {
            var2 = var2 + "_";
         }
      }

      return var2;
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

   public void lectureDoc() throws MalformedURLException, IOException {
      if (this.dataModelDocumnts.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumnts.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScan(var2);
            }
         }
      }

   }

   public void consulterDocumentScan(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuDocumentScan() {
      this.showModalPanelPj = false;
   }

   public void supprimerDocumentScan() {
      if (this.nomDocument != null && !this.nomDocument.isEmpty() && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         String var1 = this.nomRepertoire + this.nomDocument;
         File var2 = new File(var1);
         var2.delete();
         this.lesDocuments.remove(this.nomDocument);
         this.dataModelDocumnts.setWrappedData(this.lesDocuments);
         this.showModalPanelPj = false;
      }

   }

   public void selectionTracabilite() {
      if (this.datamodelDocumentTrace.isRowAvailable()) {
      }

   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
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
         this.var_affiche_lettre = false;
         this.var_date_trf = new Date();
         this.calculeCaisseDisponibleBencaissement();
         if (this.var_tot_bon_encaissement > this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient()) {
            this.consultationEnteteGene.setCsgTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.var_tot_bon_encaissement;
            this.montantElmTotBonEnc = this.var_netAPayer;
            this.verifBonEncaissement();
         } else {
            if (this.consultationEnteteGene.getCsgTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.consultationEnteteGene.getCsgEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.var_tot_bon_encaissement;
               this.montantElmTotBonEnc = this.var_netAPayer;
               this.var_affiche_valide = true;
            } else {
               this.consultationEnteteGene.setCsgTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.var_tot_bon_encaissement;
               this.montantElmTotBonEnc = this.var_netAPayer;
               this.verifBonEncaissement();
            }

            this.var_affichMontant = true;
         }

         if (this.mesCaissesSeriesItems.size() != 0) {
            this.var_inputCaisse = ((SelectItem)this.mesCaissesSeriesItems.get(0)).getValue().toString();
            this.choixCaisseXReglementBencaissement();
         }

         this.showModalPanelPaye = true;
      }

   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void calculeCaisseDisponibleBencaissement() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.consultationEnteteGene.getCsgSerie())) {
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

      if (this.varTypeReg != 0 && this.varTypeReg != 11) {
         if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
            if (this.varTypeReg == 12) {
               this.numLettreGarantie = "";
               this.mesLettresGarantiesItems.clear();
               PatientLettreGarantieDao var4 = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               List var2 = var4.chargerLesLettresByPatients(this.patients, 1, 0, (Session)null);
               if (var2.size() != 0) {
                  for(int var3 = 0; var3 < var2.size(); ++var3) {
                     this.mesLettresGarantiesItems.add(new SelectItem(((PatientLettreGarantie)var2.get(var3)).getPatlgaNum()));
                  }
               }

               this.var_affiche_lettre = true;
               this.var_affiche_banque = false;
            } else {
               this.var_affiche_banque = false;
               this.var_affiche_lettre = false;
            }
         } else {
            this.var_affiche_banque = true;
            this.var_affiche_lettre = false;
         }
      } else {
         this.var_affiche_lettre = false;
         this.var_affiche_banque = false;
      }

      this.verifValide();
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
      if (this.consultationEnteteGene.getCsgTypeReg() != 4 && this.consultationEnteteGene.getCsgTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.consultationEnteteGene.getCsgTypeReg() == 4) {
               if (this.consultationEnteteGene.getCsgNumPieceTiers() == null || this.consultationEnteteGene.getCsgNumPieceTiers().isEmpty()) {
                  this.consultationEnteteGene.setCsgNumPieceTiers("Non renseignée");
               }

               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            }

            String var3 = this.calculChrono.numCompose(new Date(), 79, this.consultationEnteteGene.getCsgSerie(), var1);
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

               this.bonEncaissementVente.setBonCodeBanq((String)null);
               this.bonEncaissementVente.setBonLibBanq((String)null);
               if ((this.varTypeReg == 1 || this.varTypeReg == 2 || this.varTypeReg == 3 || this.varTypeReg == 4 || this.varTypeReg == 6 || this.varTypeReg == 7 || this.varTypeReg == 13 || this.varTypeReg == 14) && this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
                  var4 = this.var_banque_destination.split(":");
                  this.bonEncaissementVente.setBonCodeBanq(var4[0]);
                  this.bonEncaissementVente.setBonLibBanq(var4[1]);
               }

               this.bonEncaissementVente.setBonBanqueTireur(this.var_banque_tireur);
               this.bonEncaissementVente.setBonNumChqBdx(this.var_num_cheque);
               this.bonEncaissementVente.setBonDateCreat(new Date());
               this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
               this.bonEncaissementVente.setBonActivite(this.consultationEnteteGene.getCsgActivite());
               this.bonEncaissementVente.setBonSite("");
               this.bonEncaissementVente.setBonDepartement("");
               this.bonEncaissementVente.setBonService(this.consultationEnteteGene.getCsgService());
               this.bonEncaissementVente.setBonRegion("");
               this.bonEncaissementVente.setBonSecteur("");
               this.bonEncaissementVente.setBonPdv("");
               this.bonEncaissementVente.setBonDateEcheReg(this.consultationEnteteGene.getCsgDateEcheReg());
               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               this.bonEncaissementVente.setBonNomTiers(this.consultationEnteteGene.getCsgNomPatient());
               this.bonEncaissementVente.setBonIdTiers(this.consultationEnteteGene.getPatients().getPatId());
               this.bonEncaissementVente.setBonNomContact("");
               this.bonEncaissementVente.setBonIdContact(0L);
               this.bonEncaissementVente.setBonTypeTiers(4);
               this.bonEncaissementVente.setBonLibelle("Règlement Consultation N° " + this.consultationEnteteGene.getCsgNum());
               this.bonEncaissementVente.setBonRef(this.consultationEnteteGene.getCsgNum());
               this.bonEncaissementVente.setBonIdRef(this.consultationEnteteGene.getCsgId());
               this.bonEncaissementVente.setBonObject(this.consultationEnteteGene.getCsgEntree());
               this.bonEncaissementVente.setBonObservation(this.consultationEnteteGene.getCsgMedecin());
               this.bonEncaissementVente.setBonSerie(this.consultationEnteteGene.getCsgSerie());
               this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
               this.bonEncaissementVente.setBonTotTtc(this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient());
               this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc + this.reliquatPatient);
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var3);
               this.bonEncaissementVente.setBonDate(this.var_date_trf);
               this.bonEncaissementVente.setBonIdResponsable(0L);
               this.bonEncaissementVente.setBonNomResponsable("");
               this.bonEncaissementVente.setBonIdCommercial(0L);
               this.bonEncaissementVente.setBonNomCommercial("");
               this.bonEncaissementVente.setBonIdEquipe(0L);
               this.bonEncaissementVente.setBonNomEquipe("");
               this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
               this.bonEncaissementVente.setBonClient("");
               this.bonEncaissementVente.setBonFacture("");
               this.bonEncaissementVente.setBonMontant("");
               this.bonEncaissementVente.setBonLettreGarantie(this.numLettreGarantie);
               this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
               if (this.reliquatPatient != 0.0D) {
                  this.varTypeReg = 0;
                  this.bonEncaissementVente = new BonEncaissementVente();
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     var4 = this.var_inputCaisse.split(":");
                     this.bonEncaissementVente.setBonCodeCaisse(var4[0]);
                     this.bonEncaissementVente.setBonLibCaisse(var4[1]);
                     this.bonEncaissementVente.setBonTypeReg(0);
                  } else {
                     this.bonEncaissementVente.setBonCodeCaisse((String)null);
                     this.bonEncaissementVente.setBonLibCaisse((String)null);
                     this.bonEncaissementVente.setBonTypeReg(0);
                  }

                  this.bonEncaissementVente.setBonCodeBanq((String)null);
                  this.bonEncaissementVente.setBonLibBanq((String)null);
                  this.bonEncaissementVente.setBonBanqueTireur("");
                  this.bonEncaissementVente.setBonNumChqBdx("");
                  this.bonEncaissementVente.setBonDateCreat(new Date());
                  this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                  this.bonEncaissementVente.setBonActivite(this.consultationEnteteGene.getCsgActivite());
                  this.bonEncaissementVente.setBonSite("");
                  this.bonEncaissementVente.setBonDepartement("");
                  this.bonEncaissementVente.setBonService(this.consultationEnteteGene.getCsgService());
                  this.bonEncaissementVente.setBonRegion("");
                  this.bonEncaissementVente.setBonSecteur("");
                  this.bonEncaissementVente.setBonPdv("");
                  this.bonEncaissementVente.setBonDateEcheReg(this.consultationEnteteGene.getCsgDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.consultationEnteteGene.getCsgNomPatient());
                  this.bonEncaissementVente.setBonIdTiers(this.consultationEnteteGene.getPatients().getPatId());
                  this.bonEncaissementVente.setBonNomContact("");
                  this.bonEncaissementVente.setBonIdContact(0L);
                  this.bonEncaissementVente.setBonTypeTiers(4);
                  this.bonEncaissementVente.setBonLibelle("Règlement Consultation N° " + this.consultationEnteteGene.getCsgNum());
                  this.bonEncaissementVente.setBonRef(this.consultationEnteteGene.getCsgNum());
                  this.bonEncaissementVente.setBonIdRef(this.consultationEnteteGene.getCsgId());
                  this.bonEncaissementVente.setBonObject(this.consultationEnteteGene.getCsgEntree());
                  this.bonEncaissementVente.setBonObservation(this.consultationEnteteGene.getCsgMedecin());
                  this.bonEncaissementVente.setBonSerie(this.consultationEnteteGene.getCsgSerie());
                  this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                  this.bonEncaissementVente.setBonTotTtc(this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient());
                  this.bonEncaissementVente.setBonAPayer(this.reliquatPatient * -1.0D);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonIdResponsable(0L);
                  this.bonEncaissementVente.setBonNomResponsable("");
                  this.bonEncaissementVente.setBonIdCommercial(0L);
                  this.bonEncaissementVente.setBonNomCommercial("");
                  this.bonEncaissementVente.setBonIdEquipe(0L);
                  this.bonEncaissementVente.setBonNomEquipe("");
                  this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
                  this.bonEncaissementVente.setBonClient("");
                  this.bonEncaissementVente.setBonFacture("");
                  this.bonEncaissementVente.setBonMontant("");
                  this.bonEncaissementVente.setBonLettreGarantie("");
                  this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
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

      if (this.consultationEnteteGene != null) {
         this.lesConsultationEntete.remove(this.consultationEnteteGene);
         this.consultationEnteteGene.setVar_select_ligne(false);
         this.lesConsultationEntete.add(this.consultationEnteteGene);
      }

      this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
      this.showModalPanelPaye = false;
      this.visibiliteBton = false;
   }

   public void payeXDocumentRecu() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
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
         this.var_affiche_lettre = false;
         this.val_timbre = 0.0D;
         this.totalPayerTimbre = 0.0D;
         this.var_date_trf = new Date();
         this.calculeCaisseDisponibleBrecu();
         this.reglements = new Reglements();
         this.var_date_trf = new Date();
         this.var_netAPayer = this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.consultationEnteteGene.getCsgRegPatient();
         this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
         this.varTypeReg = 0;
         this.choixTypeReglement();
         this.choixCaisseXReglement();
         this.consultationEnteteGene.setCsgTypeReg(0);
         this.chargerModReg();
         this.verifValide();
         this.showModalPanelReglement = true;
      }

   }

   public void calculeCaisseDisponibleBrecu() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.consultationEnteteGene.getCsgSerie())) {
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

   public void verifValide() throws HibernateException, NamingException {
      this.reliquatPatient = 0.0D;
      if (this.montantElmTotBonEnc <= this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.var_tot_bon_encaissement) {
         if (this.varTypeReg != 0 && this.varTypeReg != 11) {
            if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
               if (this.varTypeReg == 12) {
                  if (this.numLettreGarantie != null && !this.numLettreGarantie.isEmpty()) {
                     double var1 = 0.0D;
                     PatientLettreGarantieDao var3 = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
                     new PatientLettreGarantie();
                     PatientLettreGarantie var4 = var3.trouverLettreGarantie(this.numLettreGarantie, 0, (Session)null);
                     if (var4 != null) {
                        new ArrayList();
                        List var5 = this.reglementsDao.chargeRecuByLettreGarantie(this.numLettreGarantie, (Session)null);
                        if (var5.size() != 0) {
                           for(int var6 = 0; var6 < var5.size(); ++var6) {
                              var1 += ((Reglements)var5.get(var6)).getRglRecette();
                           }
                        }

                        if (this.consultationEnteteGene.getCsgTotPatient() > var4.getPatlgaMontant() - var1) {
                           this.reliquatPatient = var4.getPatlgaMontant() - var1 - this.consultationEnteteGene.getCsgTotPatient();
                        }
                     }

                     this.var_affiche_valide = true;
                  } else {
                     this.var_affiche_valide = false;
                  }
               }
            } else {
               this.var_affiche_valide = true;
            }
         } else {
            this.var_affiche_valide = true;
         }
      } else {
         this.var_affiche_valide = false;
      }

      this.calculValeurTimbre();
   }

   public void choixTypeReglement() throws HibernateException, NamingException {
      if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
         String[] var1 = this.var_type_reg.split(":");
         this.varTypeReg = Integer.parseInt(var1[0]);
      } else {
         this.varTypeReg = 0;
      }

      if (this.varTypeReg != 0 && this.varTypeReg != 11) {
         if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
            if (this.varTypeReg == 12) {
               this.mesLettresGarantiesItems.clear();
               PatientLettreGarantieDao var4 = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               List var2 = var4.chargerLesLettresByPatients(this.patients, 1, 0, (Session)null);
               if (var2.size() != 0) {
                  for(int var3 = 0; var3 < var2.size(); ++var3) {
                     this.mesLettresGarantiesItems.add(new SelectItem(((PatientLettreGarantie)var2.get(var3)).getPatlgaNum()));
                  }
               }

               this.var_affiche_lettre = true;
               this.var_affiche_banque = false;
            } else {
               this.var_affiche_banque = false;
               this.var_affiche_lettre = false;
            }
         } else {
            this.var_affiche_banque = true;
            this.var_affiche_lettre = false;
            if (this.varTypeReg == 1) {
            }
         }
      } else {
         this.var_affiche_lettre = false;
         this.var_affiche_banque = false;
      }

      this.calculeNomRep();
      this.verifValide();
   }

   public void calculValeurTimbre() {
      this.var_netAPayer = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      if (this.varTypeReg == 0) {
         int var1 = this.var_date.getYear() + 1900;
         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, this.montantElmTotBonEnc, var1, this.structureLog.getStrdevise(), this.var_date);
         this.totalPayerTimbre = this.montantElmTotBonEnc + this.val_timbre;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.montantElmTotBonEnc != 0.0D && var4 < this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.consultationEnteteGene.getCsgRegPatient()) {
            this.utilNombre.calculTimbre(this.structureLog, this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.consultationEnteteGene.getCsgRegPatient(), var1, this.structureLog.getStrdevise(), this.consultationEnteteGene.getCsgDate());
         } else {
            this.utilNombre.calculTimbre(this.structureLog, this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.consultationEnteteGene.getCsgRegPatient(), var1, this.structureLog.getStrdevise(), this.consultationEnteteGene.getCsgDate());
            var4 = var4 - this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() - this.consultationEnteteGene.getCsgRegPatient();
         }

         this.var_netAPayer += this.consultationEnteteGene.getVar_reliquat();
      } else if (this.varTypeReg != 0) {
         this.var_netAPayer += this.consultationEnteteGene.getVar_reliquat();
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
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementMedical");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.consultationEnteteGene.getCsgSerie();
               String var8 = "";
               String var9 = "" + this.varTypeReg;
               if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("1")) {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var9, var7, var3);
               } else if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("2")) {
                  String var10 = "";
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     String[] var11 = this.var_inputCaisse.split(":");
                     var10 = var11[0];
                  }

                  if (var10 != null && !var10.isEmpty()) {
                     var8 = this.calculChrono.numComposeCaisse(this.var_date_trf, 61, "", var7, var10, var3);
                  } else {
                     var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
                  }
               } else {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               }

               double var26 = this.montantElmTotBonEnc;
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               var16 = 0.0D;
               var12 = 0.0D;
               var12 = this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() + var16 - this.consultationEnteteGene.getCsgRegPatient();
               if (var26 > 0.0D) {
                  if (var12 <= var26) {
                     var14 = var12;
                  } else {
                     var14 = var26;
                  }

                  this.generationReglement(var8, var14, var16, var5, var3);
               } else {
                  var14 = var26;
                  this.generationReglement(var8, var26, var16, var5, var3);
               }

               var26 -= var14;
               if (var26 < 0.0D) {
                  var26 = 0.0D;
               }

               if (var26 > 0.0D) {
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
                  this.reglements.setRglRecette(var26);
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
               }

               var4.commit();
            }
         } catch (HibernateException var21) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.lesConsultationEntete.size() != 0) {
         int var23 = this.datamodelDocument.getRowIndex() + 1;
         Session var24 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         long var25 = this.consultationEnteteGene.getCsgId();
         this.consultationEnteteGene = new ConsultationEnteteGene();
         this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(var25, var24);
         if (this.consultationEnteteGene != null) {
            this.lesConsultationEntete.remove(var23);
            this.lesConsultationEntete.add(this.consultationEnteteGene);
         }

         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
         this.chargerBonEncaissement(var24);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelReglement = false;
   }

   public void generationReglement(String var1, double var2, double var4, ExercicesCaisse var6, Session var7) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient() + var4) {
         if (var2 < 0.0D) {
            this.reglements.setRglOperation("03");
         } else {
            this.reglements.setRglOperation("01");
         }
      } else if (var2 < 0.0D) {
         this.reglements.setRglOperation("03");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite(this.consultationEnteteGene.getCsgActivite());
      this.reglements.setRglBudget("");
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(30);
      String[] var8;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         var8 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var8[0]);
         this.reglements.setRglLibCaiss(var8[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

      this.reglements.setRglCodeEmetrice((String)null);
      this.reglements.setRglLibEmetrice((String)null);
      if ((this.varTypeReg == 1 || this.varTypeReg == 2 || this.varTypeReg == 3 || this.varTypeReg == 4 || this.varTypeReg == 6 || this.varTypeReg == 7 || this.varTypeReg == 13 || this.varTypeReg == 14) && this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
         var8 = this.var_banque_destination.split(":");
         this.reglements.setRglCodeEmetrice(var8[0]);
         this.reglements.setRglLibEmetrice(var8[1]);
      }

      this.reglements.setRglCodeReceptrice((String)null);
      this.reglements.setRglLibReceptrice((String)null);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDateReg(this.var_date_trf);
      this.reglements.setRglDepartement("");
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(this.structureLog.getStrdevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(this.consultationEnteteGene.getCsgNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(this.consultationEnteteGene.getCsgId());
      this.reglements.setRglIdTiers(this.consultationEnteteGene.getPatients().getPatId());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(this.consultationEnteteGene.getCsgEntree());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(71);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(this.consultationEnteteGene.getCsgNomPatient());
      this.reglements.setRglIdContact(0L);
      this.reglements.setRglNomContact("");
      this.reglements.setRglNum(var1);
      this.reglements.setRglNomEquipe("");
      if (this.varTypeReg == 12) {
         this.reglements.setRglNumChqBdx(this.numLettreGarantie);
      } else if (this.varTypeReg != 98 && this.varTypeReg != 99) {
         this.reglements.setRglNumChqBdx(this.var_num_cheque);
      } else {
         this.reglements.setRglNomEquipe(this.var_type_reg);
         this.reglements.setRglTrf(1);
      }

      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv("");
      this.reglements.setRglRecette(var2);
      double var20 = 0.0D;
      if (var4 != 0.0D) {
         int var10 = this.consultationEnteteGene.getCsgDate().getYear() + 1900;
         var20 = this.utilNombre.calculTimbre(this.structureLog, var2, var10, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var20);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(this.consultationEnteteGene.getCsgSerie());
      this.reglements.setRglService(this.consultationEnteteGene.getCsgService());
      this.reglements.setRglSite("");
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(4);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(0L);
      this.reglements.setRglNomResponsable("");
      this.reglements.setRglIdCommercial(0L);
      this.reglements.setRglNomCommercial("");
      this.reglements.setRglIdEquipe(0L);
      String var21 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var21 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var21 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var11 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var21 + ":" + var11);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var12 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var12);
      this.reglements.setExercicesCaisse(var6);
      this.reglements = this.reglementsDao.insert(this.reglements, var7);
      this.memoReglements = this.reglements;
      if (this.consultationEnteteGene != null) {
         this.consultationEnteteGene.setCsgRegPatient(this.consultationEnteteGene.getCsgRegPatient() + var2);
         if (this.consultationEnteteGene.getCsgRegPatient() >= this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient()) {
            this.consultationEnteteGene.setCsgSoldePatient(1);
         } else {
            this.consultationEnteteGene.setCsgSoldePatient(0);
         }

         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var7);
         ArrayList var13 = new ArrayList();
         if (this.lesActe.size() != 0) {
            new ConsultationActes();
            double var15 = this.reglements.getRglRecette();
            double var17 = 0.0D;

            for(int var19 = 0; var19 < this.lesActe.size(); ++var19) {
               ConsultationActes var14 = (ConsultationActes)this.lesActe.get(var19);
               if (var14.getCslactPatientHt() + var14.getCslactPatientTaxe() - var14.getCslactRegPatient() != 0.0D) {
                  if (var14.getCslactPatientHt() + var14.getCslactPatientTaxe() <= var15) {
                     var14.setCslactRegPatient(var14.getCslactPatientHt() + var14.getCslactPatientTaxe());
                     var17 = var14.getCslactRegPatient();
                  } else {
                     var14.setCslactRegPatient(var15);
                     var17 = var15;
                  }

                  var15 -= var14.getCslactRegPatient();
                  if (var15 < 0.0D) {
                     var15 = 0.0D;
                  }

                  var14 = this.consultationActesDao.modif(var14, var7);
                  var14.setNouveauPaiement(var17);
                  var13.add(var14);
               }
            }
         }

         if (var13.size() != 0) {
            ConsultationReglementDao var22 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
            new ConsultationReglement();
            new ConsultationActes();

            for(int var24 = 0; var24 < var13.size(); ++var24) {
               ConsultationActes var16 = (ConsultationActes)var13.get(var24);
               ConsultationReglement var23 = new ConsultationReglement();
               if (this.reglements.getRglCodeCaiss() != null && !this.reglements.getRglCodeCaiss().isEmpty()) {
                  var23.setCsgregCaisse(this.reglements.getRglCodeCaiss());
               } else {
                  var23.setCsgregCaisse("");
               }

               var23.setCsgregEtat(1);
               var23.setCsgregDate(this.reglements.getRglDateReg());
               var23.setCsgregNumRecu(this.reglements.getRglNum());
               var23.setCsgregIdRecu(this.reglements.getRglId());
               var23.setConsultationEnteteGene(this.consultationEnteteGene);
               var23.setCsgregIdBonEncaissement(0L);
               var23.setCsgregLibelle(var16.getCslactLibelle());
               var23.setCsgregPatient(var16.getNouveauPaiement());
               var23.setCsgregProduit(var16.getCslactProduit());
               var23.setCsgregService(var16.getConsultationEnteteGene().getCsgService());
               var23.setCsgregNumPieceTiers(var16.getConsultationEnteteGene().getCsgNumPieceTiers());
               var22.insert(var23, var7);
            }
         }
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.consultationEnteteGene.setCsgRegPatient(var4);
            if (this.consultationEnteteGene.getCsgRegPatient() >= this.consultationEnteteGene.getCsgTotTaxePatient() + this.consultationEnteteGene.getCsgTotPatient()) {
               this.consultationEnteteGene.setCsgSoldePatient(1);
            } else {
               this.consultationEnteteGene.setCsgSoldePatient(0);
            }

            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
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
      if (this.consultationEnteteGene != null) {
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
            var2.setContact((Contacts)null);
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

            if (this.patients.getPatIdUserPaiement() != 0L) {
               new Users();
               Users var2 = this.usersDao.selectUserD(this.patients.getPatIdUserPaiement(), (Session)null);
               if (var2 != null) {
                  this.mesTypeReglementsCaisse.add(new SelectItem("99:" + var2.getUsrid() + ":" + var2.getUsrPatronyme()));
               }
            } else if (this.patients.getPatSalariePaiement() != null && !this.patients.getPatSalariePaiement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("98:" + this.patients.getPatSalariePaiement()));
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

   public String conversionGarde() throws HibernateException, NamingException {
      Object var1 = null;
      return (String)var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      Object var1 = null;
      return (String)var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      Object var1 = null;
      return (String)var1;
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "consultationGene" + File.separator;
      return var2;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatConsultationGenerale.jpg");
            if (var4.exists()) {
               var3 = "formatConsultationGenerale.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatConsultationGenerale.jpg");
         if (var4.exists()) {
            var3 = "formatConsultationGenerale.jpg";
         }
      }

      return var3;
   }

   public String calculeImageInfirmerieFond(String var1, String var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4 = new File(this.calculeCheminSousRapport(var1) + var2);
      if (var4.exists()) {
         var3 = var2;
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.consultationEnteteGene != null) {
         int var2;
         if (this.lesActe.size() != 0) {
            for(var2 = 0; var2 < this.lesActe.size(); ++var2) {
               this.consultationActes = (ConsultationActes)this.lesActe.get(var2);
               this.consultationActes.setTypeLigne(0);
               this.consultationActes.setConsultationEnteteGene(this.consultationEnteteGene);
               var1.add(this.consultationActes);
            }
         }

         if (this.lesOrdonnance.size() != 0) {
            for(var2 = 0; var2 < this.lesOrdonnance.size(); ++var2) {
               this.consultationOrdo = (ConsultationOrdo)this.lesOrdonnance.get(var2);
               this.consultationActes = new ConsultationActes();
               this.consultationActes.setTypeLigne(1);
               this.consultationActes.setConsultationEnteteGene(this.consultationEnteteGene);
               this.consultationActes.setCslordDci(this.consultationOrdo.getCslordDci());
               this.consultationActes.setCslordForme(this.consultationOrdo.getCslordForme());
               this.consultationActes.setCslordLibelle(this.consultationOrdo.getCslordLibelle());
               this.consultationActes.setCslordObs(this.consultationOrdo.getCslordObs());
               this.consultationActes.setCslordPoso(this.consultationOrdo.getCslordPoso());
               this.consultationActes.setCslordProduit(this.consultationOrdo.getCslordProduit());
               this.consultationActes.setCslordQte(this.consultationOrdo.getCslordQte());
               this.consultationActes.setCslordUnite(this.consultationOrdo.getCslordUnite());
               var1.add(this.consultationActes);
            }
         }

         if (this.lesLaboratoire.size() != 0) {
            for(var2 = 0; var2 < this.lesLaboratoire.size(); ++var2) {
               this.consultationLabo = (ConsultationLabo)this.lesLaboratoire.get(var2);
               this.consultationActes = new ConsultationActes();
               this.consultationActes.setConsultationEnteteGene(this.consultationEnteteGene);
               this.consultationActes.setTypeLigne(2);
               this.consultationActes.setCslactLibelle(this.consultationLabo.getCsllabLibelle());
               this.consultationActes.setCslactProduit(this.consultationLabo.getCsllabObs());
               var1.add(this.consultationActes);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.consultationEnteteGene.getTotalPatient(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionRemboursementCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      double var2 = 0.0D;
      if (this.lesActe.size() != 0) {
         for(int var4 = 0; var4 < this.lesActe.size(); ++var4) {
            this.consultationActes = (ConsultationActes)this.lesActe.get(var4);
            this.consultationActes.setConsultationEnteteGene(this.consultationEnteteGene);
            if (this.consultationActes.getCslactQte() < 0.0F) {
               var2 += this.consultationActes.getCslactPatientHt() + this.consultationActes.getCslactPatientTaxe();
               var1.add(this.consultationActes);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var1);
      return var5;
   }

   public JRBeanCollectionDataSource calculeImpressionConsultationCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.consultationEnteteGene != null) {
         String var2;
         int var3;
         if (this.lesActe.size() == 0) {
            this.consultationEnteteGene.setNomActe("");
         } else {
            var2 = "";
            var3 = 0;

            while(true) {
               if (var3 >= this.lesActe.size()) {
                  this.consultationEnteteGene.setNomActe(var2);
                  break;
               }

               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + ", " + ((ConsultationActes)this.lesActe.get(var3)).getCslactLibelle();
               } else {
                  var2 = ((ConsultationActes)this.lesActe.get(var3)).getCslactLibelle();
               }

               ++var3;
            }
         }

         if (this.lesOrdonnance.size() != 0) {
            this.consultationEnteteGene.setPrescriptOrdo(true);
         } else {
            this.consultationEnteteGene.setPrescriptOrdo(false);
         }

         if (this.lesPharmacie.size() == 0) {
            this.consultationEnteteGene.setSortieMed(false);
            this.consultationEnteteGene.setNomMed("");
         } else {
            this.consultationEnteteGene.setSortieMed(true);
            var2 = "";
            var3 = 0;

            while(true) {
               if (var3 >= this.lesPharmacie.size()) {
                  this.consultationEnteteGene.setNomMed(var2);
                  break;
               }

               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + ", " + ((PharmacieLigne)this.lesPharmacie.get(var3)).getPhaligQte() + " - " + ((PharmacieLigne)this.lesPharmacie.get(var3)).getPhaligLibelle();
               } else {
                  var2 = ((PharmacieLigne)this.lesPharmacie.get(var3)).getPhaligQte() + " - " + ((PharmacieLigne)this.lesPharmacie.get(var3)).getPhaligLibelle();
               }

               ++var3;
            }
         }

         if (this.lesLaboratoire.size() == 0) {
            this.consultationEnteteGene.setPrescripLabo(false);
            this.consultationEnteteGene.setTypeExamen("");
         } else {
            this.consultationEnteteGene.setPrescripLabo(true);
            var2 = "";
            var3 = 0;

            while(true) {
               if (var3 >= this.lesLaboratoire.size()) {
                  this.consultationEnteteGene.setTypeExamen(var2);
                  break;
               }

               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + ", " + ((ConsultationLabo)this.lesLaboratoire.get(var3)).getCsllabLibelle();
               } else {
                  var2 = ((ConsultationLabo)this.lesLaboratoire.get(var3)).getCsllabLibelle();
               }

               ++var3;
            }
         }

         if (this.consultationInfirmerie != null) {
            this.consultationEnteteGene.setNbJourArretTravail(this.consultationInfirmerie.getCslaccNbJourRepos());
            this.consultationEnteteGene.setDu(this.consultationInfirmerie.getCslaccDateDu());
            this.consultationEnteteGene.setAu(this.consultationInfirmerie.getCslaccDateAu());
         } else {
            this.consultationEnteteGene.setNbJourArretTravail(0);
            this.consultationEnteteGene.setDu((Date)null);
            this.consultationEnteteGene.setAu((Date)null);
         }

         var1.add(this.consultationEnteteGene);
      }

      this.montant_lettre = this.utilNombre.begin(this.consultationEnteteGene.getTotalPatient(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(var1);
      return var4;
   }

   public JRBeanCollectionDataSource calculeImpressionInfirmerieCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.consultationEnteteGene != null && this.consultationInfirmerie != null) {
         this.consultationInfirmerie.setPatSecu(this.patients.getPatSecu());
         this.consultationInfirmerie.setPatNom(this.patients.getPatronyme());
         this.consultationInfirmerie.setPatAdresse(this.patients.getPatAdresse());
         this.consultationInfirmerie.setPatTel1(this.patients.getPatCel1());
         this.consultationInfirmerie.setPatTel2(this.patients.getPatCel2());
         this.consultationInfirmerie.setPatMail(this.patients.getPatMail1());
         this.consultationInfirmerie.setPatSexe(this.patients.getPatSexe());
         this.consultationInfirmerie.setPatNationnalite(this.patients.getPatPaysNaissance());
         this.consultationInfirmerie.setPatDateEmbauche(this.patients.getPatDateEmbauche());
         this.consultationInfirmerie.setPatProfession(this.patients.getPatProfession());
         this.consultationInfirmerie.setPatPoste(this.patients.getPatProfObs());
         this.consultationInfirmerie.setPatAnciennete(0);
         this.consultationInfirmerie.setPatConjoint("");
         this.consultationInfirmerie.setPatConjointTel1("");
         this.consultationInfirmerie.setPatConjointTel2("");
         this.consultationInfirmerie.setPatNature(this.patients.getPatPorte());
         this.consultationInfirmerie.setPatCivilite(this.patients.getPatCivilite());
         this.consultationInfirmerie.setPatMatricule(this.patients.getPatDossier());
         this.consultationInfirmerie.setPatDateNaissance(this.patients.getPatDateNaissance());
         this.consultationInfirmerie.setPatLieuNaissance(this.patients.getPatLieuNaissance());
         this.consultationInfirmerie.setPatService(this.patients.getPatZone());
         this.consultationInfirmerie.setPatMedecin(this.consultationEnteteGene.getCsgMedecin());
         var1.add(this.consultationInfirmerie);
      }

      this.montant_lettre = "";
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public String calculeService(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         new SpecialitesMedical();
         SpecialitesMedicalDao var4 = new SpecialitesMedicalDao(this.baseLog, this.utilInitHibernate);
         String var5 = "";
         if (var1.contains(":")) {
            String[] var6 = var1.split(":");
            var5 = var6[0];
         } else {
            var5 = var1;
         }

         SpecialitesMedical var3 = var4.getSpecialitesMedicalCode(var5, (Session)null);
         if (var3 != null) {
            var2 = var3.getSpemedNom();
            if (var3.getSpemedAdresse() != null && !var3.getSpemedAdresse().isEmpty()) {
               var2 = var2 + "\n" + var3.getSpemedAdresse();
            }

            if (var3.getSpemedBP() != null && !var3.getSpemedBP().isEmpty()) {
               var2 = var2 + "\n" + var3.getSpemedBP() + this.structureLog.getStrville();
            }

            if (var3.getSpemedTel1() != null && !var3.getSpemedTel1().isEmpty()) {
               var2 = var2 + "\n" + "Tél.: " + var3.getSpemedTel1();
            }

            if (var3.getSpemedFax() != null && !var3.getSpemedFax().isEmpty()) {
               var2 = var2 + " Fax.: " + var3.getSpemedFax();
            }

            if (var3.getSpemedNomResponsable() != null && !var3.getSpemedNomResponsable().isEmpty()) {
               var2 = var2 + "\n" + var3.getSpemedNomResponsable();
            }
         }
      }

      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.consultationEnteteGene.getCsgDateImp() != null && this.consultationEnteteGene.getCsgEtat() != 0) {
            var2 = true;
         }

         this.consultationEnteteGene.setCsgDateImp(new Date());
         if (this.consultationEnteteGene.getCsgEtat() == 0 && this.consultationEnteteGene.getCsgEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.consultationEnteteGene.setCsgEtat(1);
         }

         this.consultationEnteteGene.setCsgModeleImp(var1);
         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var3);
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
            if (var3.equalsIgnoreCase("Declaration_AT_CNSS")) {
               var1.setjRBeanCollectionDataSource(this.calculeImpressionInfirmerieCommun());
               var1.setService(this.usersLog.getUsrSite());
               var1.setImageFondPage(this.calculeImageInfirmerieFond("structure" + this.structureLog.getStrid(), "declarationCnss.png"));
            } else if (var3.equalsIgnoreCase("Declaration_AT_TEMPORAIRE")) {
               var1.setjRBeanCollectionDataSource(this.calculeImpressionInfirmerieCommun());
               var1.setImageFondPage("");
               var1.setService(this.usersLog.getUsrSite());
            } else if (var3.equalsIgnoreCase("Certificat")) {
               var1.setjRBeanCollectionDataSource(this.calculeImpressionInfirmerieCommun());
               var1.setImageFondPage("");
               var1.setService(this.usersLog.getUsrSite());
            } else if (var3.equalsIgnoreCase("Bon_Commande")) {
               var1.setImageFondPage("");
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
               var1.setService(this.usersLog.getUsrSite());
            } else if (var3.equalsIgnoreCase("Recapitulatif_consultation")) {
               var1.setImageFondPage("");
               var1.setjRBeanCollectionDataSource(this.calculeImpressionConsultationCommun());
               var1.setService(this.consultationEnteteGene.getCsgService());
            } else {
               if (var3.startsWith("Remboursement")) {
                  var1.setjRBeanCollectionDataSource(this.calculeImpressionRemboursementCommun());
               } else {
                  var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
               }

               var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.consultationEnteteGene.getCsgEtat()));
               var1.setService(this.consultationEnteteGene.getCsgService());
            }

            var1.setRapport(var3);
            var1.setEntete("Impression consultation générale");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.consultationEnteteGene.getCsgIdMedecin());
            var1.setIdCommercial(this.consultationEnteteGene.getCsgIdCreateur());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.consultationEnteteGene.getCsgNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.consultationEnteteGene.getCsgId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des consultations générales");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "consultationGene" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         if (this.inpEtat == 0) {
            var1.setFiltre("Documents En cours");
         } else if (this.inpEtat == 1) {
            var1.setFiltre("Documents Validés");
         } else if (this.inpEtat == 2) {
            var1.setFiltre("Documents Gélés");
         } else if (this.inpEtat == 3) {
            var1.setFiltre("Documents Annulés");
         } else if (this.inpEtat == 4) {
            var1.setFiltre("???");
         } else if (this.inpEtat == 5) {
            var1.setFiltre("Documents Controlés");
         } else if (this.inpEtat == 6) {
            var1.setFiltre("Documents Refacturés");
         } else if (this.inpEtat == 13) {
            var1.setFiltre("Documents Non Payés Patient");
         } else if (this.inpEtat == 14) {
            var1.setFiltre("Documents Payés Patient");
         } else if (this.inpEtat == 15) {
            var1.setFiltre("Documents Non Payés tiers");
         } else if (this.inpEtat == 16) {
            var1.setFiltre("Documents Payés Tiers");
         } else if (this.inpEtat == 17) {
            var1.setFiltre("Documents Non Transférés en compta");
         } else if (this.inpEtat == 18) {
            var1.setFiltre("Documents TRansférés en commpta");
         }

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
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesConsultationEntete);
         var1.setjRBeanCollectionDataSource(var12);
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
      if (this.lesConsultationEntete.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "CONSULTATIONS GENERALES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "CONSULTATIONS GENERALES  : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         }

         this.titreGraph = "Analyse des consultations : ";
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
            this.sousTitreGraph = this.sousTitreGraph + " - Par médecins (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par prescripteurs (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par patients (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par assurances (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par complèmentaires (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par sociétés (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par motifs entrée (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 8) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par protocoles (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 9) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par pathologies (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 10) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par services (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 20) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par actes (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 21) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par pharmacie (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 22) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par ordonance (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 23) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par laboratoire (" + this.uniteGraph + ")";
         }

         new ConsultationEnteteGene();
         new ConsultationActes();
         String var5 = "";
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");

         ConsultationEnteteGene var14;
         for(int var7 = 0; var7 < this.lesConsultationEntete.size(); ++var7) {
            var14 = (ConsultationEnteteGene)this.lesConsultationEntete.get(var7);
            if (var5.isEmpty()) {
               var5 = "'" + var14.getCsgNum() + "'";
            } else {
               var5 = var5 + ",'" + var14.getCsgNum() + "'";
            }
         }

         long var9;
         int var11;
         int var13;
         boolean var17;
         List var22;
         String var23;
         if (this.modeGraph == 20) {
            new ArrayList();
            var22 = this.consultationActesDao.chargerLesLignesActes(var5, var6);
            if (var22.size() != 0) {
               var23 = "";
               var9 = 0L;
               var17 = false;
               new ConsultationActes();
               var13 = 0;

               while(true) {
                  if (var13 >= var22.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  ConsultationActes var21 = (ConsultationActes)var22.get(var13);
                  var23 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (var21.getCslactLibelle() == null || var21.getCslactLibelle().isEmpty()) {
                     var21.setCslactLibelle("ERREUR LIBELLE");
                  }

                  var23 = var21.getCslactLibelle();
                  if (this.valQteGraph == 0) {
                     var9 = (long)var21.getCslactTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var21.getCslactQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var11 = var21.getConsultationEnteteGene().getCsgDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var11 = var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 3) {
                        var11 = 1;
                     } else if (var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 4 && var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                        var11 = 2;
                     } else if (var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 9) {
                        var11 = 3;
                     } else if (var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 10 && var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                        var11 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                        var11 = 1;
                     } else if (var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var21.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                        var11 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var11 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var11 = var21.getConsultationEnteteGene().getCsgDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var23, var11, var9);
                  ++var13;
               }
            }
         } else if (this.modeGraph == 21) {
            new ArrayList();
            var22 = this.pharmacieLigneDao.chargerLesLignesProduits(var5, var6);
            if (var22.size() != 0) {
               var23 = "";
               var9 = 0L;
               var17 = false;
               new PharmacieLigne();
               var13 = 0;

               while(true) {
                  if (var13 >= var22.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  PharmacieLigne var20 = (PharmacieLigne)var22.get(var13);
                  var23 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (var20.getPhaligLibelle() != null && !var20.getPhaligLibelle().isEmpty()) {
                     var23 = var20.getPhaligLibelle();
                     if (this.valQteGraph == 0) {
                        var9 = (long)var20.getPhaligTotal();
                     } else {
                        var9 = (long)this.utilNombre.myRound(var20.getPhaligQte(), 1);
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var20.getConsultationEnteteGene().getCsgDate().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 4 && var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 10 && var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var20.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var20.getConsultationEnteteGene().getCsgDate().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var23, var11, var9);
                  }

                  ++var13;
               }
            }
         } else if (this.modeGraph == 22) {
            new ArrayList();
            var22 = this.consultationOrdoDao.chargerLesLignesProduits(var5, var6);
            if (var22.size() != 0) {
               var23 = "";
               var9 = 0L;
               var17 = false;
               new ConsultationOrdo();
               var13 = 0;

               while(true) {
                  if (var13 >= var22.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  ConsultationOrdo var19 = (ConsultationOrdo)var22.get(var13);
                  var23 = "";
                  var9 = 0L;
                  var11 = 0;
                  var23 = var19.getCslordLibelle();
                  if (var19.getCslordLibelle() != null && !var19.getCslordLibelle().isEmpty()) {
                     if (this.valQteGraph == 0) {
                        var9 = 0L;
                     } else {
                        var9 = (long)this.utilNombre.myRound((float)var19.getCslordQte(), 1);
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var19.getConsultationEnteteGene().getCsgDate().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 4 && var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 10 && var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var19.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var19.getConsultationEnteteGene().getCsgDate().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var23, var11, var9);
                  }

                  ++var13;
               }
            }
         } else if (this.modeGraph == 23) {
            new ArrayList();
            var22 = this.consultationLaboDao.chargerLesLignesProduits(var5, var6);
            if (var22.size() != 0) {
               var23 = "";
               var9 = 0L;
               var17 = false;
               new ConsultationLabo();
               var13 = 0;

               while(true) {
                  if (var13 >= var22.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  ConsultationLabo var18 = (ConsultationLabo)var22.get(var13);
                  var23 = "";
                  var9 = 0L;
                  var11 = 0;
                  var23 = var18.getCsllabLibelle();
                  if (var18.getCsllabLibelle() != null && !var18.getCsllabLibelle().isEmpty()) {
                     if (this.valQteGraph == 0) {
                        var9 = 0L;
                     } else {
                        var9 = 1L;
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var18.getConsultationEnteteGene().getCsgDate().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 4 && var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 10 && var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 1 && var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 >= 7 && var18.getConsultationEnteteGene().getCsgDate().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var18.getConsultationEnteteGene().getCsgDate().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var23, var11, var9);
                  }

                  ++var13;
               }
            }
         } else if (this.lesConsultationEntete.size() != 0) {
            String var15 = "";
            long var8 = 0L;
            boolean var10 = false;
            var11 = 0;

            while(true) {
               if (var11 >= this.lesConsultationEntete.size()) {
                  var1 = this.calculePourcentage((List)var1);
                  break;
               }

               var14 = (ConsultationEnteteGene)this.lesConsultationEntete.get(var11);
               var15 = "";
               var8 = 0L;
               int var16 = 0;
               if (this.modeGraph == 0) {
                  int var12 = var14.getCsgDate().getYear() + 1900;
                  var15 = "" + var12;
                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 1) {
                  if (var14.getCsgMedecin() != null && !var14.getCsgMedecin().isEmpty()) {
                     var15 = var14.getCsgMedecin();
                  } else {
                     var15 = "Sans médecin";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 2) {
                  if (var14.getCsgPrescripteur() != null && !var14.getCsgPrescripteur().isEmpty()) {
                     var15 = var14.getCsgPrescripteur();
                  } else {
                     var15 = "Sans prescripteur";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 3) {
                  if (var14.getCsgNomPatient() != null && !var14.getCsgNomPatient().isEmpty()) {
                     var15 = var14.getCsgNomPatient();
                  } else {
                     var15 = "Sans patient";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotPatient();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 4) {
                  if (var14.getCsgNomAssurance() != null && !var14.getCsgNomAssurance().isEmpty()) {
                     var15 = var14.getCsgNomAssurance();
                  } else {
                     var15 = "Sans assurance";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotAssurance();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 5) {
                  if (var14.getCsgNomComplemtaire() != null && !var14.getCsgNomComplemtaire().isEmpty()) {
                     var15 = var14.getCsgNomComplemtaire();
                  } else {
                     var15 = "Sans complémentaire";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotComplmentaire();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 6) {
                  if (var14.getCsgNomSociete() != null && !var14.getCsgNomSociete().isEmpty()) {
                     var15 = var14.getCsgNomSociete();
                  } else {
                     var15 = "Sans société";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotSociete();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 7) {
                  if (var14.getCsgEntree() != null && !var14.getCsgEntree().isEmpty()) {
                     var15 = var14.getCsgEntree();
                  } else {
                     var15 = "Sans motif entrée";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 8) {
                  if (var14.getCsgProtocole() != null && !var14.getCsgProtocole().isEmpty()) {
                     var15 = var14.getCsgProtocole();
                  } else {
                     var15 = "Sans protocole";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 9) {
                  if (var14.getCsgPathologie() != null && !var14.getCsgPathologie().isEmpty()) {
                     var15 = var14.getCsgPathologie();
                  } else {
                     var15 = "Sans protocole";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               } else if (this.modeGraph == 10) {
                  if (var14.getCsgService() != null && !var14.getCsgService().isEmpty()) {
                     var15 = var14.getCsgService();
                  } else {
                     var15 = "Sans service";
                  }

                  if (this.valQteGraph == 0) {
                     var8 = (long)var14.getCsgTotGeneral();
                  } else {
                     var8 = 1L;
                  }
               }

               if (this.timeDecoupage == 0) {
                  var16 = var14.getCsgDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var16 = var14.getCsgDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var14.getCsgDate().getMonth() + 1 >= 1 && var14.getCsgDate().getMonth() + 1 <= 3) {
                     var16 = 1;
                  } else if (var14.getCsgDate().getMonth() + 1 >= 4 && var14.getCsgDate().getMonth() + 1 <= 6) {
                     var16 = 2;
                  } else if (var14.getCsgDate().getMonth() + 1 >= 7 && var14.getCsgDate().getMonth() + 1 <= 9) {
                     var16 = 3;
                  } else if (var14.getCsgDate().getMonth() + 1 >= 10 && var14.getCsgDate().getMonth() + 1 <= 12) {
                     var16 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var14.getCsgDate().getMonth() + 1 >= 1 && var14.getCsgDate().getMonth() + 1 <= 6) {
                     var16 = 1;
                  } else if (var14.getCsgDate().getMonth() + 1 >= 7 && var14.getCsgDate().getMonth() + 1 <= 12) {
                     var16 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var16 = 1;
               } else if (this.timeDecoupage == 5) {
                  var16 = var14.getCsgDate().getHours();
               }

               var1 = this.calculeListe((List)var1, var15, var16, var8);
               ++var11;
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
            var3 += (float)(var2.getV01() + var2.getV02() + var2.getV03() + var2.getV04() + var2.getV05() + var2.getV06() + var2.getV07() + var2.getV08() + var2.getV09() + var2.getV10() + var2.getV11() + var2.getV12() + var2.getV13() + var2.getV14() + var2.getV15() + var2.getV16() + var2.getV17() + var2.getV18() + var2.getV19() + var2.getV20() + var2.getV21() + var2.getV22() + var2.getV23() + var2.getV24() + var2.getV25() + var2.getV26() + var2.getV27() + var2.getV28() + var2.getV29() + var2.getV30() + var2.getV31());
         }
      }

      if (var1.size() != 0) {
         float var7 = 0.0F;
         float var5 = 0.0F;

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            var2 = (ObjetGraph)var1.get(var6);
            var5 = (float)(var2.getV01() + var2.getV02() + var2.getV03() + var2.getV04() + var2.getV05() + var2.getV06() + var2.getV07() + var2.getV08() + var2.getV09() + var2.getV10() + var2.getV11() + var2.getV12() + var2.getV13() + var2.getV14() + var2.getV15() + var2.getV16() + var2.getV17() + var2.getV18() + var2.getV19() + var2.getV20() + var2.getV21() + var2.getV22() + var2.getV23() + var2.getV24() + var2.getV25() + var2.getV26() + var2.getV27() + var2.getV28() + var2.getV29() + var2.getV30() + var2.getV31());
            var7 = var5 / var3 * 100.0F;
            var2.setVpourcent(var7);
         }
      }

      return var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean istActivite() {
      return this.tActivite;
   }

   public void settActivite(boolean var1) {
      this.tActivite = var1;
   }

   public boolean istBudget() {
      return this.tBudget;
   }

   public void settBudget(boolean var1) {
      this.tBudget = var1;
   }

   public boolean istParc() {
      return this.tParc;
   }

   public void settParc(boolean var1) {
      this.tParc = var1;
   }

   public int getVar_modestock() {
      return this.var_modestock;
   }

   public void setVar_modestock(int var1) {
      this.var_modestock = var1;
   }

   public boolean isVar_sansstock() {
      return this.var_sansstock;
   }

   public void setVar_sansstock(boolean var1) {
      this.var_sansstock = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isAccesProduits() {
      return this.accesProduits;
   }

   public void setAccesProduits(boolean var1) {
      this.accesProduits = var1;
   }

   public boolean isVerrouPrventeAssurance() {
      return this.verrouPrventeAssurance;
   }

   public void setVerrouPrventeAssurance(boolean var1) {
      this.verrouPrventeAssurance = var1;
   }

   public UtilNombre getChiffreEnLettre() {
      return this.chiffreEnLettre;
   }

   public void setChiffreEnLettre(UtilNombre var1) {
      this.chiffreEnLettre = var1;
   }

   public int getFormatdevise() {
      return this.formatdevise;
   }

   public void setFormatdevise(int var1) {
      this.formatdevise = var1;
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

   public String getInpMedecin() {
      return this.inpMedecin;
   }

   public void setInpMedecin(String var1) {
      this.inpMedecin = var1;
   }

   public String getInpAssurance() {
      return this.inpAssurance;
   }

   public void setInpAssurance(String var1) {
      this.inpAssurance = var1;
   }

   public String getInpCi() {
      return this.inpCi;
   }

   public void setInpCi(String var1) {
      this.inpCi = var1;
   }

   public String getInpComplementaire() {
      return this.inpComplementaire;
   }

   public void setInpComplementaire(String var1) {
      this.inpComplementaire = var1;
   }

   public String getInpContrat() {
      return this.inpContrat;
   }

   public void setInpContrat(String var1) {
      this.inpContrat = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
   }

   public String getInpNomPatient() {
      return this.inpNomPatient;
   }

   public void setInpNomPatient(String var1) {
      this.inpNomPatient = var1;
   }

   public String getInpPrenomPatient() {
      return this.inpPrenomPatient;
   }

   public void setInpPrenomPatient(String var1) {
      this.inpPrenomPatient = var1;
   }

   public String getInpSociete() {
      return this.inpSociete;
   }

   public void setInpSociete(String var1) {
      this.inpSociete = var1;
   }

   public String getInpTel() {
      return this.inpTel;
   }

   public void setInpTel(String var1) {
      this.inpTel = var1;
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

   public List getMesdevisesItems() {
      return this.mesdevisesItems;
   }

   public void setMesdevisesItems(List var1) {
      this.mesdevisesItems = var1;
   }

   public String getMontant_lettre() {
      return this.montant_lettre;
   }

   public void setMontant_lettre(String var1) {
      this.montant_lettre = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
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

   public boolean isVerrouPrvente() {
      return this.verrouPrvente;
   }

   public void setVerrouPrvente(boolean var1) {
      this.verrouPrvente = var1;
   }

   public boolean isVerrouRemRab() {
      return this.verrouRemRab;
   }

   public void setVerrouRemRab(boolean var1) {
      this.verrouRemRab = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public List getLesTypeReglementsItems() {
      return this.lesTypeReglementsItems;
   }

   public void setLesTypeReglementsItems(List var1) {
      this.lesTypeReglementsItems = var1;
   }

   public String getNomPatient() {
      return this.nomPatient;
   }

   public void setNomPatient(String var1) {
      this.nomPatient = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesTaxesMedicalItems() {
      return this.mesTaxesMedicalItems;
   }

   public void setMesTaxesMedicalItems(List var1) {
      this.mesTaxesMedicalItems = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public double getRegPatient() {
      return this.regPatient;
   }

   public void setRegPatient(double var1) {
      this.regPatient = var1;
   }

   public double getRegTiers() {
      return this.regTiers;
   }

   public void setRegTiers(double var1) {
      this.regTiers = var1;
   }

   public double getSoldePatient() {
      return this.soldePatient;
   }

   public void setSoldePatient(double var1) {
      this.soldePatient = var1;
   }

   public double getSoldeTiers() {
      return this.soldeTiers;
   }

   public void setSoldeTiers(double var1) {
      this.soldeTiers = var1;
   }

   public double getTotalPatient() {
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getTotalTiers() {
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }

   public String getVar_imput_cat() {
      return this.var_imput_cat;
   }

   public void setVar_imput_cat(String var1) {
      this.var_imput_cat = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }

   public String getInpFam() {
      return this.inpFam;
   }

   public void setInpFam(String var1) {
      this.inpFam = var1;
   }

   public String getInpProtocole() {
      return this.inpProtocole;
   }

   public void setInpProtocole(String var1) {
      this.inpProtocole = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getVar_num_ligne() {
      return this.var_num_ligne;
   }

   public void setVar_num_ligne(int var1) {
      this.var_num_ligne = var1;
   }

   public boolean isVisibiliteencaissemt() {
      return this.visibiliteencaissemt;
   }

   public void setVisibiliteencaissemt(boolean var1) {
      this.visibiliteencaissemt = var1;
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

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public List getMesProtocoleItems() {
      return this.mesProtocoleItems;
   }

   public void setMesProtocoleItems(List var1) {
      this.mesProtocoleItems = var1;
   }

   public boolean isVar_acc_acte() {
      return this.var_acc_acte;
   }

   public void setVar_acc_acte(boolean var1) {
      this.var_acc_acte = var1;
   }

   public boolean isVar_acc_anamese() {
      return this.var_acc_anamese;
   }

   public void setVar_acc_anamese(boolean var1) {
      this.var_acc_anamese = var1;
   }

   public boolean isVar_acc_antecedent() {
      return this.var_acc_antecedent;
   }

   public void setVar_acc_antecedent(boolean var1) {
      this.var_acc_antecedent = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_examClinique() {
      return this.var_acc_examClinique;
   }

   public void setVar_acc_examClinique(boolean var1) {
      this.var_acc_examClinique = var1;
   }

   public boolean isVar_acc_examComplementaire() {
      return this.var_acc_examComplementaire;
   }

   public void setVar_acc_examComplementaire(boolean var1) {
      this.var_acc_examComplementaire = var1;
   }

   public boolean isVar_acc_facture() {
      return this.var_acc_facture;
   }

   public void setVar_acc_facture(boolean var1) {
      this.var_acc_facture = var1;
   }

   public boolean isVar_acc_historique() {
      return this.var_acc_historique;
   }

   public void setVar_acc_historique(boolean var1) {
      this.var_acc_historique = var1;
   }

   public boolean isVar_acc_medicament() {
      return this.var_acc_medicament;
   }

   public void setVar_acc_medicament(boolean var1) {
      this.var_acc_medicament = var1;
   }

   public boolean isVar_acc_reglement() {
      return this.var_acc_reglement;
   }

   public void setVar_acc_reglement(boolean var1) {
      this.var_acc_reglement = var1;
   }

   public DataModel getDataModelAntecedent() {
      return this.dataModelAntecedent;
   }

   public void setDataModelAntecedent(DataModel var1) {
      this.dataModelAntecedent = var1;
   }

   public PatientAnt getPatientAnt() {
      return this.patientAnt;
   }

   public void setPatientAnt(PatientAnt var1) {
      this.patientAnt = var1;
   }

   public boolean isAfficheButtAntecedent() {
      return this.afficheButtAntecedent;
   }

   public void setAfficheButtAntecedent(boolean var1) {
      this.afficheButtAntecedent = var1;
   }

   public CalculChrono getCalculChrono() {
      return this.calculChrono;
   }

   public void setCalculChrono(CalculChrono var1) {
      this.calculChrono = var1;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
   }

   public int getVar_actionAntecedent() {
      return this.var_actionAntecedent;
   }

   public void setVar_actionAntecedent(int var1) {
      this.var_actionAntecedent = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public String getVar_antecedent() {
      return this.var_antecedent;
   }

   public void setVar_antecedent(String var1) {
      this.var_antecedent = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public DataModel getDataModelDiagnostic() {
      return this.dataModelDiagnostic;
   }

   public void setDataModelDiagnostic(DataModel var1) {
      this.dataModelDiagnostic = var1;
   }

   public boolean isShowModalPaneldiagnostic() {
      return this.showModalPaneldiagnostic;
   }

   public void setShowModalPaneldiagnostic(boolean var1) {
      this.showModalPaneldiagnostic = var1;
   }

   public String getRecherche_diag() {
      return this.recherche_diag;
   }

   public void setRecherche_diag(String var1) {
      this.recherche_diag = var1;
   }

   public String getRecherche_cmd() {
      return this.recherche_cmd;
   }

   public void setRecherche_cmd(String var1) {
      this.recherche_cmd = var1;
   }

   public DataModel getDataModelActe() {
      return this.dataModelActe;
   }

   public void setDataModelActe(DataModel var1) {
      this.dataModelActe = var1;
   }

   public CimMedical getCimMedical() {
      return this.cimMedical;
   }

   public void setCimMedical(CimMedical var1) {
      this.cimMedical = var1;
   }

   public ConsultationActes getConsultationActes() {
      return this.consultationActes;
   }

   public void setConsultationActes(ConsultationActes var1) {
      this.consultationActes = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public List getMesLettresItems() {
      return this.mesLettresItems;
   }

   public void setMesLettresItems(List var1) {
      this.mesLettresItems = var1;
   }

   public DataModel getDatamodelProduits() {
      return this.datamodelProduits;
   }

   public void setDatamodelProduits(DataModel var1) {
      this.datamodelProduits = var1;
   }

   public Service getService() {
      return this.service;
   }

   public void setService(Service var1) {
      this.service = var1;
   }

   public boolean isShowModalPanelProduits() {
      return this.showModalPanelProduits;
   }

   public void setShowModalPanelProduits(boolean var1) {
      this.showModalPanelProduits = var1;
   }

   public int getDiagSelect() {
      return this.diagSelect;
   }

   public void setDiagSelect(int var1) {
      this.diagSelect = var1;
   }

   public String getVar_lib_poids() {
      return this.var_lib_poids;
   }

   public void setVar_lib_poids(String var1) {
      this.var_lib_poids = var1;
   }

   public List getLesCategoriesList() {
      return this.lesCategoriesList;
   }

   public void setLesCategoriesList(List var1) {
      this.lesCategoriesList = var1;
   }

   public String getVar_lettre() {
      return this.var_lettre;
   }

   public void setVar_lettre(String var1) {
      this.var_lettre = var1;
   }

   public boolean isAfficheButtActes() {
      return this.afficheButtActes;
   }

   public void setAfficheButtActes(boolean var1) {
      this.afficheButtActes = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public double getVar_tot_reg() {
      return this.var_tot_reg;
   }

   public void setVar_tot_reg(double var1) {
      this.var_tot_reg = var1;
   }

   public double getVar_tot_tiers() {
      return this.var_tot_tiers;
   }

   public void setVar_tot_tiers(double var1) {
      this.var_tot_tiers = var1;
   }

   public boolean isAfficheButtOrdo() {
      return this.afficheButtOrdo;
   }

   public void setAfficheButtOrdo(boolean var1) {
      this.afficheButtOrdo = var1;
   }

   public DataModel getDataModelOrdonnance() {
      return this.dataModelOrdonnance;
   }

   public void setDataModelOrdonnance(DataModel var1) {
      this.dataModelOrdonnance = var1;
   }

   public boolean isVar_aff_detail_ordo() {
      return this.var_aff_detail_ordo;
   }

   public void setVar_aff_detail_ordo(boolean var1) {
      this.var_aff_detail_ordo = var1;
   }

   public ConsultationOrdo getConsultationOrdo() {
      return this.consultationOrdo;
   }

   public void setConsultationOrdo(ConsultationOrdo var1) {
      this.consultationOrdo = var1;
   }

   public int getChoixPanenProd() {
      return this.choixPanenProd;
   }

   public void setChoixPanenProd(int var1) {
      this.choixPanenProd = var1;
   }

   public boolean isAfficheButtLabo() {
      return this.afficheButtLabo;
   }

   public void setAfficheButtLabo(boolean var1) {
      this.afficheButtLabo = var1;
   }

   public ConsultationLabo getConsultationLabo() {
      return this.consultationLabo;
   }

   public void setConsultationLabo(ConsultationLabo var1) {
      this.consultationLabo = var1;
   }

   public DataModel getDataModelLaboratoire() {
      return this.dataModelLaboratoire;
   }

   public void setDataModelLaboratoire(DataModel var1) {
      this.dataModelLaboratoire = var1;
   }

   public boolean isVar_aff_detail_labo() {
      return this.var_aff_detail_labo;
   }

   public void setVar_aff_detail_labo(boolean var1) {
      this.var_aff_detail_labo = var1;
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

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public ExercicesVentes getLastExoMedical() {
      return this.lastExoMedical;
   }

   public void setLastExoMedical(ExercicesVentes var1) {
      this.lastExoMedical = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isShowModalPanelAntecedent() {
      return this.showModalPanelAntecedent;
   }

   public void setShowModalPanelAntecedent(boolean var1) {
      this.showModalPanelAntecedent = var1;
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

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
   }

   public long getVar_nom_medecin() {
      return this.var_nom_medecin;
   }

   public void setVar_nom_medecin(long var1) {
      this.var_nom_medecin = var1;
   }

   public ProduitsMedicamment getProduitsMedicamment() {
      return this.produitsMedicamment;
   }

   public void setProduitsMedicamment(ProduitsMedicamment var1) {
      this.produitsMedicamment = var1;
   }

   public boolean isShowModalPanelMedicamment() {
      return this.showModalPanelMedicamment;
   }

   public void setShowModalPanelMedicamment(boolean var1) {
      this.showModalPanelMedicamment = var1;
   }

   public boolean isShowModalPanelMedicammentDci() {
      return this.showModalPanelMedicammentDci;
   }

   public void setShowModalPanelMedicammentDci(boolean var1) {
      this.showModalPanelMedicammentDci = var1;
   }

   public ProduitsDci getProduitsDci() {
      return this.produitsDci;
   }

   public void setProduitsDci(ProduitsDci var1) {
      this.produitsDci = var1;
   }

   public boolean isShowModalPanelListeActes() {
      return this.showModalPanelListeActes;
   }

   public void setShowModalPanelListeActes(boolean var1) {
      this.showModalPanelListeActes = var1;
   }

   public CcamMedical getCcamMedical() {
      return this.ccamMedical;
   }

   public void setCcamMedical(CcamMedical var1) {
      this.ccamMedical = var1;
   }

   public boolean isShowModalPanelCreationActe() {
      return this.showModalPanelCreationActe;
   }

   public void setShowModalPanelCreationActe(boolean var1) {
      this.showModalPanelCreationActe = var1;
   }

   public String getLettreActe() {
      return this.lettreActe;
   }

   public void setLettreActe(String var1) {
      this.lettreActe = var1;
   }

   public List getLesTarifs() {
      return this.lesTarifs;
   }

   public void setLesTarifs(List var1) {
      this.lesTarifs = var1;
   }

   public String getInpCodeFamille() {
      return this.inpCodeFamille;
   }

   public void setInpCodeFamille(String var1) {
      this.inpCodeFamille = var1;
   }

   public DataModel getDatamodelProduitsCCAM() {
      return this.datamodelProduitsCCAM;
   }

   public void setDatamodelProduitsCCAM(DataModel var1) {
      this.datamodelProduitsCCAM = var1;
   }

   public boolean isAfficheActeCCAM() {
      return this.afficheActeCCAM;
   }

   public void setAfficheActeCCAM(boolean var1) {
      this.afficheActeCCAM = var1;
   }

   public boolean isAfficheActeCP() {
      return this.afficheActeCP;
   }

   public void setAfficheActeCP(boolean var1) {
      this.afficheActeCP = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
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

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
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

   public DataModel getDatamodelRecu() {
      return this.datamodelRecu;
   }

   public void setDatamodelRecu(DataModel var1) {
      this.datamodelRecu = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public List getMesMedecinsItem() {
      return this.mesMedecinsItem;
   }

   public void setMesMedecinsItem(List var1) {
      this.mesMedecinsItem = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isVar_consultation_directe() {
      return this.var_consultation_directe;
   }

   public void setVar_consultation_directe(boolean var1) {
      this.var_consultation_directe = var1;
   }

   public float getVar_pecCnamgs() {
      return this.var_pecCnamgs;
   }

   public void setVar_pecCnamgs(float var1) {
      this.var_pecCnamgs = var1;
   }

   public boolean isVar_pecAssurance() {
      return this.var_pecAssurance;
   }

   public void setVar_pecAssurance(boolean var1) {
      this.var_pecAssurance = var1;
   }

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
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

   public long getNomFamille() {
      return this.nomFamille;
   }

   public void setNomFamille(long var1) {
      this.nomFamille = var1;
   }

   public boolean isAfficheActeNGAP() {
      return this.afficheActeNGAP;
   }

   public void setAfficheActeNGAP(boolean var1) {
      this.afficheActeNGAP = var1;
   }

   public DataModel getDatamodelProduitsNGAP() {
      return this.datamodelProduitsNGAP;
   }

   public void setDatamodelProduitsNGAP(DataModel var1) {
      this.datamodelProduitsNGAP = var1;
   }

   public NgapMedical getNgapMedical() {
      return this.ngapMedical;
   }

   public void setNgapMedical(NgapMedical var1) {
      this.ngapMedical = var1;
   }

   public List getMesComplementaireItems() {
      return this.mesComplementaireItems;
   }

   public void setMesComplementaireItems(List var1) {
      this.mesComplementaireItems = var1;
   }

   public long getNomComplementaire() {
      return this.nomComplementaire;
   }

   public void setNomComplementaire(long var1) {
      this.nomComplementaire = var1;
   }

   public double getMontantElmTotReliquat() {
      return this.montantElmTotReliquat;
   }

   public void setMontantElmTotReliquat(double var1) {
      this.montantElmTotReliquat = var1;
   }

   public String getNumLettreGarantie() {
      return this.numLettreGarantie;
   }

   public void setNumLettreGarantie(String var1) {
      this.numLettreGarantie = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public boolean isAfficheButtPharmacie() {
      return this.afficheButtPharmacie;
   }

   public void setAfficheButtPharmacie(boolean var1) {
      this.afficheButtPharmacie = var1;
   }

   public DataModel getDataModelPharmacie() {
      return this.dataModelPharmacie;
   }

   public void setDataModelPharmacie(DataModel var1) {
      this.dataModelPharmacie = var1;
   }

   public PharmacieLigne getPharmacieLigne() {
      return this.pharmacieLigne;
   }

   public void setPharmacieLigne(PharmacieLigne var1) {
      this.pharmacieLigne = var1;
   }

   public boolean isVar_aff_detail_pharmacie() {
      return this.var_aff_detail_pharmacie;
   }

   public void setVar_aff_detail_pharmacie(boolean var1) {
      this.var_aff_detail_pharmacie = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public String getVar_depotProd() {
      return this.var_depotProd;
   }

   public void setVar_depotProd(String var1) {
      this.var_depotProd = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public boolean isVar_affiche_at() {
      return this.var_affiche_at;
   }

   public void setVar_affiche_at(boolean var1) {
      this.var_affiche_at = var1;
   }

   public int getVar_heures() {
      return this.var_heures;
   }

   public void setVar_heures(int var1) {
      this.var_heures = var1;
   }

   public int getVar_minutes() {
      return this.var_minutes;
   }

   public void setVar_minutes(int var1) {
      this.var_minutes = var1;
   }

   public Date getVar_date_accident() {
      return this.var_date_accident;
   }

   public void setVar_date_accident(Date var1) {
      this.var_date_accident = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public boolean isVar_affiche_protocole() {
      return this.var_affiche_protocole;
   }

   public void setVar_affiche_protocole(boolean var1) {
      this.var_affiche_protocole = var1;
   }

   public boolean isVar_affiche_pathologie() {
      return this.var_affiche_pathologie;
   }

   public void setVar_affiche_pathologie(boolean var1) {
      this.var_affiche_pathologie = var1;
   }

   public boolean isVar_affiche_prescipteur() {
      return this.var_affiche_prescipteur;
   }

   public void setVar_affiche_prescipteur(boolean var1) {
      this.var_affiche_prescipteur = var1;
   }

   public boolean isVar_affiche_service() {
      return this.var_affiche_service;
   }

   public void setVar_affiche_service(boolean var1) {
      this.var_affiche_service = var1;
   }

   public DataModel getDataModelElements() {
      return this.dataModelElements;
   }

   public void setDataModelElements(DataModel var1) {
      this.dataModelElements = var1;
   }

   public boolean isVar_affiche_audio() {
      return this.var_affiche_audio;
   }

   public void setVar_affiche_audio(boolean var1) {
      this.var_affiche_audio = var1;
   }

   public boolean isVar_affiche_vaccin() {
      return this.var_affiche_vaccin;
   }

   public void setVar_affiche_vaccin(boolean var1) {
      this.var_affiche_vaccin = var1;
   }

   public boolean isVar_affiche_maladie() {
      return this.var_affiche_maladie;
   }

   public void setVar_affiche_maladie(boolean var1) {
      this.var_affiche_maladie = var1;
   }

   public boolean isVar_affiche_tubertest() {
      return this.var_affiche_tubertest;
   }

   public void setVar_affiche_tubertest(boolean var1) {
      this.var_affiche_tubertest = var1;
   }

   public boolean isVar_affiche_vma() {
      return this.var_affiche_vma;
   }

   public void setVar_affiche_vma(boolean var1) {
      this.var_affiche_vma = var1;
   }

   public boolean isVar_affiche_vme() {
      return this.var_affiche_vme;
   }

   public void setVar_affiche_vme(boolean var1) {
      this.var_affiche_vme = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public ConsultationInfirmerie getConsultationInfirmerie() {
      return this.consultationInfirmerie;
   }

   public void setConsultationInfirmerie(ConsultationInfirmerie var1) {
      this.consultationInfirmerie = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
   }

   public boolean isValideConsultation() {
      return this.valideConsultation;
   }

   public void setValideConsultation(boolean var1) {
      this.valideConsultation = var1;
   }

   public FormPatients getFormPatients() {
      return this.formPatients;
   }

   public void setFormPatients(FormPatients var1) {
      this.formPatients = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getUrlphotoAgent() {
      return this.urlphotoAgent;
   }

   public void setUrlphotoAgent(String var1) {
      this.urlphotoAgent = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public List getMesFournisseursItem() {
      return this.mesFournisseursItem;
   }

   public void setMesFournisseursItem(List var1) {
      this.mesFournisseursItem = var1;
   }

   public long getVar_nom_fournisseurLab() {
      return this.var_nom_fournisseurLab;
   }

   public void setVar_nom_fournisseurLab(long var1) {
      this.var_nom_fournisseurLab = var1;
   }

   public long getVar_nom_fournisseurPha() {
      return this.var_nom_fournisseurPha;
   }

   public void setVar_nom_fournisseurPha(long var1) {
      this.var_nom_fournisseurPha = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
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

   public boolean isVar_affiche_certificat() {
      return this.var_affiche_certificat;
   }

   public void setVar_affiche_certificat(boolean var1) {
      this.var_affiche_certificat = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public double getVar_tot_bon_encaissement() {
      return this.var_tot_bon_encaissement;
   }

   public void setVar_tot_bon_encaissement(double var1) {
      this.var_tot_bon_encaissement = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public boolean isVar_affiche_lettre() {
      return this.var_affiche_lettre;
   }

   public void setVar_affiche_lettre(boolean var1) {
      this.var_affiche_lettre = var1;
   }

   public List getMesLettresGarantiesItems() {
      return this.mesLettresGarantiesItems;
   }

   public void setMesLettresGarantiesItems(List var1) {
      this.mesLettresGarantiesItems = var1;
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

   public UIDataTable getExtDTableCCAM() {
      return this.extDTableCCAM;
   }

   public void setExtDTableCCAM(UIDataTable var1) {
      this.extDTableCCAM = var1;
   }

   public UIDataTable getExtDTableNGAP() {
      return this.extDTableNGAP;
   }

   public void setExtDTableNGAP(UIDataTable var1) {
      this.extDTableNGAP = var1;
   }

   public UIDataTable getExtDTableProduits() {
      return this.extDTableProduits;
   }

   public void setExtDTableProduits(UIDataTable var1) {
      this.extDTableProduits = var1;
   }

   public SimpleSelection getSimpleSelectionCCAM() {
      return this.simpleSelectionCCAM;
   }

   public void setSimpleSelectionCCAM(SimpleSelection var1) {
      this.simpleSelectionCCAM = var1;
   }

   public SimpleSelection getSimpleSelectionNGAP() {
      return this.simpleSelectionNGAP;
   }

   public void setSimpleSelectionNGAP(SimpleSelection var1) {
      this.simpleSelectionNGAP = var1;
   }

   public SimpleSelection getSimpleSelectionProduits() {
      return this.simpleSelectionProduits;
   }

   public void setSimpleSelectionProduits(SimpleSelection var1) {
      this.simpleSelectionProduits = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public PatientPec getPatientPec() {
      return this.patientPec;
   }

   public void setPatientPec(PatientPec var1) {
      this.patientPec = var1;
   }

   public boolean isShowModalpanelPec() {
      return this.showModalpanelPec;
   }

   public void setShowModalpanelPec(boolean var1) {
      this.showModalpanelPec = var1;
   }

   public boolean isAutoriseRefacturation() {
      return this.autoriseRefacturation;
   }

   public void setAutoriseRefacturation(boolean var1) {
      this.autoriseRefacturation = var1;
   }

   public Date getDateRefacturation() {
      return this.dateRefacturation;
   }

   public void setDateRefacturation(Date var1) {
      this.dateRefacturation = var1;
   }

   public String getEtatRefacuration() {
      return this.etatRefacuration;
   }

   public void setEtatRefacuration(String var1) {
      this.etatRefacuration = var1;
   }

   public String getNumRefacturation() {
      return this.numRefacturation;
   }

   public void setNumRefacturation(String var1) {
      this.numRefacturation = var1;
   }

   public boolean isShowModalPanelChangerService() {
      return this.showModalPanelChangerService;
   }

   public void setShowModalPanelChangerService(boolean var1) {
      this.showModalPanelChangerService = var1;
   }

   public String getNouveauService() {
      return this.nouveauService;
   }

   public void setNouveauService(String var1) {
      this.nouveauService = var1;
   }

   public String getInpSite() {
      return this.inpSite;
   }

   public void setInpSite(String var1) {
      this.inpSite = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public boolean isAjouterSurAvoir() {
      return this.ajouterSurAvoir;
   }

   public void setAjouterSurAvoir(boolean var1) {
      this.ajouterSurAvoir = var1;
   }

   public long getNouveauMedecin() {
      return this.nouveauMedecin;
   }

   public void setNouveauMedecin(long var1) {
      this.nouveauMedecin = var1;
   }

   public String getNouveauMotif() {
      return this.nouveauMotif;
   }

   public void setNouveauMotif(String var1) {
      this.nouveauMotif = var1;
   }

   public String getAncienMedecin() {
      return this.ancienMedecin;
   }

   public void setAncienMedecin(String var1) {
      this.ancienMedecin = var1;
   }

   public boolean isVerrouPrventeCnamgs() {
      return this.verrouPrventeCnamgs;
   }

   public void setVerrouPrventeCnamgs(boolean var1) {
      this.verrouPrventeCnamgs = var1;
   }

   public double getTotalDocFacture() {
      return this.totalDocFacture;
   }

   public void setTotalDocFacture(double var1) {
      this.totalDocFacture = var1;
   }

   public double getTotalDocPatient() {
      return this.totalDocPatient;
   }

   public void setTotalDocPatient(double var1) {
      this.totalDocPatient = var1;
   }

   public double getTotalDocReglement() {
      return this.totalDocReglement;
   }

   public void setTotalDocReglement(double var1) {
      this.totalDocReglement = var1;
   }

   public double getTotalDocTiers() {
      return this.totalDocTiers;
   }

   public void setTotalDocTiers(double var1) {
      this.totalDocTiers = var1;
   }

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public double getReliquatPatient() {
      return this.reliquatPatient;
   }

   public void setReliquatPatient(double var1) {
      this.reliquatPatient = var1;
   }

   public List getLesMotifEntree() {
      return this.lesMotifEntree;
   }

   public void setLesMotifEntree(List var1) {
      this.lesMotifEntree = var1;
   }

   public List getMesDentsItems() {
      return this.mesDentsItems;
   }

   public void setMesDentsItems(List var1) {
      this.mesDentsItems = var1;
   }

   public int getMedecinSpecialite() {
      return this.medecinSpecialite;
   }

   public void setMedecinSpecialite(int var1) {
      this.medecinSpecialite = var1;
   }
}
